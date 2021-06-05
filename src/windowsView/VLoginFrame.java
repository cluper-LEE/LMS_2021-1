package windowsView;

import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import constants.Config.FVForm;
import constants.Config.FVLogin;
import control.CLogin;
import global.Global;
import valueObject.OLogin;
import valueObject.OMember;

public class VLoginFrame extends JFrame {
	private static final long serialVersionUID = 1L;

	private CLogin cLogin;

	private VFormPanel topPanel;

	private JTextField idText;
	private JTextField passwordText;
	private JLabel validText;

	public VLoginFrame(ActionListener actionListener) {
		this.cLogin = new CLogin();

		this.setTitle(FVLogin.frameName);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// �ֻ��� �г�
		topPanel = new VFormPanel();
		this.setContentPane(topPanel);

		validText = topPanel.getValidText();

		// �Է� �г� ���� ä���
		JLabel idLabel = new JLabel(FVLogin.idLabelText);
		this.idText = new JTextField(FVForm.textFieldLength);
		topPanel.addInputRow(idLabel, idText);

		JLabel passwordLabel = new JLabel(FVLogin.passwordLabelText);
		this.passwordText = new JPasswordField(FVForm.textFieldLength);
		topPanel.addInputRow(passwordLabel, passwordText);

		// ��ư �г� ���� ä���
		JButton loginButton = new JButton(FVLogin.loginButtonText);
		loginButton.addActionListener(actionListener);
		this.getRootPane().setDefaultButton(loginButton); // ���͸� ������ �� ��ư�� ��������.
		topPanel.addButton(loginButton);

		JButton registrationButton = new JButton(FVLogin.registrationButtonText);
		registrationButton.addActionListener(actionListener);
		topPanel.addButton(registrationButton);

		// ���̵� �Է½� ���� Ȯ��, �޽��� ǥ��
		KeyAdapter keyAdapter = new KeyAdapter() {
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

		};
		this.idText.addKeyListener(keyAdapter);

		this.pack();
		this.setVisible(true);
	}

	public OMember validLogin() {
		if (Global.validBlank(idText) && Global.validBlank(passwordText)) {

			String id = this.idText.getText();
			String password = this.passwordText.getText();

			OLogin oLogin = new OLogin(id, password);
			OMember oMember = cLogin.validate(oLogin);
			System.out.println(oMember);

			if (oMember == null) {
				JOptionPane.showMessageDialog(null, FVLogin.loginFailMSG);
				this.idText.requestFocus();
			} else {
				return oMember;
			}

		}
		return null;
	}
}
