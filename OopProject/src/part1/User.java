package part1;

public class User {
	private String userName;
	private String noMatrics;
	private String password;
	
	User(String userName,String noMatrics,String password){
		this.userName = userName;
		this.noMatrics = noMatrics;
		this.password = password;
	}
	
	public void setName(String userName){
		this.userName = userName;
	} 
	
	public void setNoMatrics(String noMatrics){
		this.noMatrics = noMatrics;
	}
	
	public void setPassword(String password){
		this.password = password;
	}
	
	public String getName() {
		return userName;
	}
	
	public String getNoMatrics() {
		return noMatrics;
	}
	
	public String getPassword() {
		return password;
	}
	
}