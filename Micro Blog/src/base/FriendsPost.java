package base;
import java.util.Date;

public class FriendsPost extends Post{
	public User friend;
	
	public FriendsPost(Date date, String content, User user){
		super(date, content);
		this.friend = user;
	}

}
