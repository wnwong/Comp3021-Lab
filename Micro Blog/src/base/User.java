package base;

public class User {
	private int userId;
	private String userName;
	private String userEmail;
	/**
	 * Constructor
	 * @param userId
	 * @param userName
	 * @param userEmail
	 */
	public User(int userId, String userName, String userEmail){
		this.userId = userId;
		this.userName = userName;
		this.userEmail = userEmail;
	}
	/**
	 * 
	 * @return the user name
	 */
	public String getName(){
		return userName;
	}
	/**
	 * 
	 * @param name
	 */
	public void setName(String name){
		userName = name;
	}
	/**
	 * Output this object in string format
	 * @return String
	 * 
	 */
	public String toString(){
		return "User [userId=" + userId + ", userName=" + userName + ", userEmail=" + userEmail + "]";
	}
	@Override
	/**
	 * Check whether this object equals object o
	 * @param object o
	 * @return Boolean
	 * 
	 */
	public boolean equals(Object o){
		boolean ans = true;
		
		if (o == null){
			ans = false;
		}
		// Compare the class of object o
		if(getClass() != o.getClass()){
			ans = false;
		}
		else{
			// Transfer object o to USER
			User user = (User) o;
			if(userId != user.userId || !userName.equals(user.userName) || userEmail.equals(user.userEmail))
			ans = false;
		}
		return ans;
	}
	
	public int hashCode(){
		int hashCode = 0;
		hashCode = 
		userEmail.hashCode() + userName.hashCode() + userId;
		
		return hashCode;
	}
	/**
	 * check whether this post contains some keyword
	 * @param keyword
	 * @return
	 */
	public boolean contains(String keyword){
		if(userName.contains(keyword))
			return true;
		else 
			return false;
	}
}
