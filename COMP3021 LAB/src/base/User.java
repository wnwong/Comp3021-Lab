package base;

public class User implements Comparable<User> {
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
	public int compareTo(User u) {
		if(userId > u.userId)
			return 1;
		else if (userId < u.userId)
			return -1;
		else
		return 0;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((userEmail == null) ? 0 : userEmail.hashCode());
		result = prime * result + userId;
		result = prime * result
				+ ((userName == null) ? 0 : userName.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (userEmail == null) {
			if (other.userEmail != null)
				return false;
		} else if (!userEmail.equals(other.userEmail))
			return false;
		if (userId != other.userId)
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
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
