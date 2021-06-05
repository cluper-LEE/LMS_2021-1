package windowsView;

import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import constants.Config.FVForm;
import constants.Config.FVLogin;
import constants.Config.FVRegistration;
import control.CRegistration;
import global.Global;
import valueObject.OMember;

public class VRegistrationFrame extends JFrame {
	private static final long serialVersionUID = 1L;

	private CRegistration cRegistration;

	private VFormPanel topPanel;

	private JTextField nameText;
	private JTextField idText;
	private JTextField addressText;
	private JTextField departmentText;
	private JTextField passwordText;
	private JTextField checkText;
	private JLabel validText;

	public VRegistrationFrame(ActionListener actionListener) {
		this.cRegistration = new CRegistration();

		this.setTitle(FVRegistration.frameName);
		this.setResizable(false);

		// 최상위 패널
		topPanel = new VFormPanel();
		this.setContentPane(topPanel);

		validText = topPanel.getValidText();

		// 입력 패널 내용 채우기
		int length = FVForm.textFieldLength;
		JLabel nameLabel = new JLabel(FVRegistration.nameLabelText);
		nameText = new JTextField(length);
		topPanel.addInputRow(nameLabel, nameText);

		JLabel idLabel = new JLabel(FVRegistration.idLabelText);
		idText = new JTextField(length);
		topPanel.addInputRow(idLabel, idText);

		JLabel addressLabel = new JLabel(FVRegistration.addressLabelText);
		addressText = new JTextField(length);
		topPanel.addInputRow(addressLabel, addressText);
		
		JLabel departmentLabel = new JLabel(FVRegistration.departmentLabelText);
		departmentText = new JTextField(length);
		topPanel.addInputRow(departmentLabel, departmentText);

		JLabel passwordLabel = new JLabel(FVRegistration.passwordLabelText);
		passwordText = new JTextField(length);
		topPanel.addInputRow(passwordLabel, passwordText);

		JLabel checkLabel = new JLabel(FVRegistration.checkLabelText);
		checkText = new JTextField(length);
		topPanel.addInputRow(checkLabel, checkText);

		// 버튼 패널 내용 채우기
		JButton registrationButton = new JButton(FVRegistration.registrationButtonText);
		registrationButton.addActionListener(actionListener);
		this.getRootPane().setDefaultButton(registrationButton); // 엔터를 누르면 이 버튼이 눌리도록.
		topPanel.addButton(registrationButton);

		KeyAdapter validMatch = new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String pswd1 = passwordText.getText();
				String pswd2 = checkText.getText();
				if (pswd1.equals(pswd2)) {
					validText.setText(" ");
				} else {
					validText.setText(FVRegistration.notMatchMSG);
				}
			}

		};
		passwordText.addKeyListener(validMatch);
		checkText.addKeyListener(validMatch);

		idText.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				String id = idText.getText();
				try {
					Integer.parseInt(id);
					validText.setText(" ");
				} catch (NumberFormatException ex) {
					validText.setText(FVLogin.idValidMSG);
				}
			}
		});
		
		this.pack();
		this.setVisible(true);

	}

	public boolean register() {
		if( Global.validBlank(nameText) &&
			Global.validBlank(idText) &&
			Global.validBlank(addressText) &&
			Global.validBlank(departmentText)&&
			Global.validBlank(passwordText) &&
			Global.validBlank(checkText) &&
			Global.validPasswordMatch(passwordText, checkText)) {
		 	
			String id = idText.getText();
			String name = nameText.getText();
			String address = addressText.getText();
			String department = departmentText.getText();
			String password = passwordText.getText();
			
			
			OMember oMember = new OMember(id, name, address, department, password);
			// 데이터 입력 받아 oMember에 저장
			// oMember를 컨트롤러에 전달.
			if(this.cRegistration.saveMember(oMember)) {
				return true;
			} else {
				JOptionPane.showMessageDialog(null, FVRegistration.alreadyExits);
			}
		}
		return false;
	}
}
