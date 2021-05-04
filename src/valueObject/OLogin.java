package valueObject;

public class OLogin {
	private String id;
	private String pswd;

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
