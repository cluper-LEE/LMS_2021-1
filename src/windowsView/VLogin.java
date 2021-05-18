package windowsView;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import control.CLogin;
import valueObject.OLogin;
import valueObject.OMember;

public class VLogin extends JFrame{
	
	private CLogin cLogin;

	private JTextField idText;
	private JTextField passwordText;
	
	private final int CONTENT_SIZE = 7;
	private final String ID_VALID_MSG = "아이디에는 숫자만 입력할 수 있습니다";
	
	public VLogin() {
		this.setTitle("login");
		this.setSize(400,300);
		this.setResizable(false);
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		panel.setMaximumSize(new Dimension(400, 300));
		this.setContentPane(panel);
		
		GridBagConstraints[] gbc = new GridBagConstraints[CONTENT_SIZE];
		for(int i = 0; i < this.CONTENT_SIZE; i++) {
			gbc[i] = new GridBagConstraints();
			gbc[i].insets = new Insets(10, 10, 10, 10);
			gbc[i].weightx = 1;
			gbc[i].weighty = 1;
		}
		
		
		JLabel loginLabel = new JLabel("아이디(학번)");
		gbc[0].gridx = 0;
		gbc[0].gridy = 0;
		panel.add(loginLabel, gbc[0]);
		
		JLabel passwordLabel = new JLabel("비밀번호");
		gbc[1].gridx = 0;
		gbc[1].gridy = 1;
		panel.add(passwordLabel, gbc[1]);
		
		this.idText = new JTextField(20);
		gbc[2].gridx = 1;
		gbc[2].gridy = 0;
		gbc[2].gridwidth = 4;
		gbc[2].fill = GridBagConstraints.BOTH;
		panel.add(this.idText, gbc[2]);
		
		this.passwordText = new JPasswordField(20);
		gbc[3].gridx = 1;
		gbc[3].gridy = 1;
		gbc[3].gridwidth = 4;
		gbc[3].fill = GridBagConstraints.BOTH;
		panel.add(this.passwordText, gbc[3]);
		
		
		JButton loginButton = new JButton("로그인");
		gbc[4].gridx = 0;
		gbc[4].gridy = 3;
		gbc[4].gridwidth = 5;
		gbc[4].fill = GridBagConstraints.BOTH;
		panel.add(loginButton, gbc[4]);
		
		JButton registrationButton = new JButton("회원가입");
		gbc[5].gridx = 0;
		gbc[5].gridy = 4;
		gbc[5].gridwidth = 5;
		gbc[5].fill = GridBagConstraints.BOTH;
		panel.add(registrationButton, gbc[5]);
		
		JLabel idValidText = new JLabel();
		idValidText.setForeground(Color.red);
		gbc[6].gridx = 0;
		gbc[6].gridy = 2;
		gbc[6].gridwidth = 5;
		gbc[6].fill = GridBagConstraints.BOTH;
		panel.add(idValidText, gbc[6]);
		
		
		// 텍스트 필드에 포커스 리스너 추가
		FocusListener textFocusListener = new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				String id = idText.getText();
				try {
					Integer.parseInt(id);
					idValidText.setText("");
				}catch(NumberFormatException ex) {
					System.out.println("숫자가 아님");
					idValidText.setText(ID_VALID_MSG);
				}
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				JTextField target = (JTextField) e.getComponent();
				target.selectAll();
			}
		};
		
		this.idText.addFocusListener(textFocusListener);
		this.passwordText.addFocusListener(textFocusListener);
		
		this.cLogin = new CLogin();
		loginButton.addActionListener((e) -> {
			String id = this.idText.getText();
			String password = this.passwordText.getText();
			OLogin oLogin = new OLogin(id, password);
			OMember oMember = cLogin.validate(oLogin);
			System.out.println(oMember);
			
			if(oMember == null) {
				JOptionPane.showMessageDialog(null, "로그인 실패!");
				this.idText.requestFocus();
			}else {
				new VLogin();
				this.dispose();
				System.out.println("종료?");
			}
		});
		
		this.setVisible(true);
		
	}

}
