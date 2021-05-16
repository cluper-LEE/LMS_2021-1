package valueObject;

public class OLogin {
	protected String id;
	protected String pswd;

	public OLogin() {

	}

	public OLogin(String id, String pswd) {
		this.id = id;
		this.pswd = pswd;
	}

	public String getId() {
		return id;
	}
	public String getPswd() {

		return pswd;
	}

}
