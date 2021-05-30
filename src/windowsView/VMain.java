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
		// 로그인 성공시 로그인 창 dispose, 메인 창 on. 판단 시점은 로그인 창의 로그인 버튼 눌렸을 때.
		// 로그인 창에서의 이벤트로 메인 창의 동작을 결정. 부모 단에서 이벤트를 결정.
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

		// 우선 로그인 화면을 보인다.
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
