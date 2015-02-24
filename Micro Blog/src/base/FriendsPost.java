package base;
import java.util.Date;

public class FriendsPost extends Post{
	private User friend;
	
	public FriendsPost(Date date, String content, User user){
		super(date, content);
		friend = user;
	}
	@Override
	/**
	 * Output this object in string format
	 * @return String
	 * 
	 */
	public String toString(){

		return friend.toString() + "\n" + super.getDate() + "\n" + super.getContent();
	}

}
