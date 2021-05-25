package windowsView;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import control.CLogin;
import valueObject.OLogin;
import valueObject.OMember;

public class VLoginPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	private OMember user;

	private CLogin cLogin;

	private JTextField idText;
	private JTextField passwordText;
	
	private final String ID_VALID_MSG = "아이디에는 숫자만 입력할 수 있습니다";
	private final String ID_BLANK_MSG = "아이디를 입력하세요";
	private final String PSWD_BLANK_MSG = "비밀번호를 입력하세요"; 
	
	public VLoginPanel() {
		
		this.setLayout(new GridBagLayout());
		this.setMaximumSize(new Dimension(400, 300));
		
		JLabel loginLabel = new JLabel("아이디(학번)");
		this.add(loginLabel, this.getGbc(0, 0));
		
		JLabel passwordLabel = new JLabel("비밀번호");
		this.add(passwordLabel, this.getGbc(0, 1));
		
		this.idText = new JTextField(20);
		this.add(this.idText, this.getGbc(1, 0, 4, 1));
		
		this.passwordText = new JPasswordField(20);
		this.add(this.passwordText, this.getGbc(1, 1, 4, 1));
		
		
		JButton loginButton = new JButton("로그인");
		this.add(loginButton, this.getGbc(0, 3, 5, 1));
		
		JButton registrationButton = new JButton("회원가입");
		this.add(registrationButton, this.getGbc(0, 4, 5, 1));
		
		JLabel validText = new JLabel();
		validText.setForeground(Color.red);
		GridBagConstraints idValidTextGbc = this.getGbc(0, 2, 5, 1);
		idValidTextGbc.insets = new Insets(0, 10, 0, 10);
		this.add(validText, idValidTextGbc);
		
		KeyAdapter keyAdapter = new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				String id = idText.getText();
				try {
					Integer.parseInt(id);
					validText.setText("");
				}catch(NumberFormatException ex) {
					validText.setText(ID_VALID_MSG);
				}
			}
			
		};
		this.idText.addKeyListener(keyAdapter);
		this.passwordText.addKeyListener(keyAdapter);
		
		this.cLogin = new CLogin();
		
		
		loginButton.addActionListener((e) -> {
			String id = this.idText.getText();
			String password = this.passwordText.getText();
			if(id.equals("")) {
				this.idText.requestFocus();
				this.idText.selectAll();
				validText.setText(this.ID_BLANK_MSG);
				return;
			}
			if(password.equals("")) {
				this.passwordText.requestFocus();
				this.passwordText.selectAll();
				validText.setText(this.PSWD_BLANK_MSG);
				return;
			}
			OLogin oLogin = new OLogin(id, password);
			OMember oMember = cLogin.validate(oLogin);
			System.out.println(oMember);
			
			if(oMember == null) {
				JOptionPane.showMessageDialog(null, "로그인 실패!");
				this.idText.requestFocus();
			}else {
				this.user = oMember;
				this.setVisible(false);
			}
		});
		
		this.setVisible(true);
		
	}
	
	private GridBagConstraints getGbc(int x, int y) {
		GridBagConstraints gbc = new GridBagConstraints();

		gbc.gridx = x;
		gbc.gridy = y;
		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.weightx = 1;
		gbc.weighty = 1;
		return gbc;
	}
	
	private GridBagConstraints getGbc(int x, int y, int width, int height) {
		GridBagConstraints gbc = this.getGbc(x, y);
		gbc.gridwidth = width;
		gbc.gridheight = height;
		gbc.fill = GridBagConstraints.BOTH;
		return gbc;
	}
	
	public OMember getUser() {
		return this.user;
	}

}
