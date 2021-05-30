package windowsView;

import java.awt.event.ActionListener;

import constants.Config.FVLogin;
import constants.Config.FVRegistration;
import valueObject.OMember;

public class VMain {

	private VLoginFrame vLoginFrame;
	private VMainFrame vMainFrame;
	private VRegistrationFrame vRegistrationFrame;
	private ActionListener loginFormListener;
	private ActionListener registrationFormListener;

	public VMain() {

	}
	
	public void run() {
		// �α��� ������ �α��� â dispose, ���� â on. �Ǵ� ������ �α��� â�� �α��� ��ư ������ ��.
		// �α��� â������ �̺�Ʈ�� ���� â�� ������ ����. �θ� �ܿ��� �̺�Ʈ�� ����.
		this.loginFormListener = (e) -> {
			String buttonText = e.getActionCommand();
			if (buttonText.equals(FVLogin.loginButtonText)) {
				this.login();
			} else if (buttonText.equals(FVLogin.registrationButtonText)) {
				this.openRegistrationFrame();
			}
		};

		this.registrationFormListener = (e) -> {
			String buttonText = e.getActionCommand();
			if (buttonText.equals(FVRegistration.registrationButtonText)) {
				register();
			}
		};

		// �켱 �α��� ȭ���� ���δ�.
		this.vLoginFrame = new VLoginFrame(loginFormListener);
	}

	private void closeRegistrationFrame() {
		if (vRegistrationFrame != null) {
			vRegistrationFrame.dispose();
		}
	}

	private void openRegistrationFrame() {
		closeRegistrationFrame();
		this.vRegistrationFrame = new VRegistrationFrame(registrationFormListener);
	}

	private void register() {
		if (this.vRegistrationFrame.register()) {
			this.vRegistrationFrame.dispose();
		}
	}

	private void login() {
		OMember oMember = this.vLoginFrame.validLogin();
		if (oMember != null) {
			this.vLoginFrame.dispose();
			this.vMainFrame = new VMainFrame(oMember);
			this.vMainFrame.setVisible(true);

			closeRegistrationFrame();
		}
	}

	public static void main(String[] args) {
		VMain main = new VMain();
		main.run();

	}

}
