package part1;

public class User {
	String userName;
	String email;
	private String password;
	User(String userName,String email,String password){
		this.userName = userName;
		this.email = email;
		this.password = password;
	}
	
	public String getPassword() {
		return password;
	}
	
}
