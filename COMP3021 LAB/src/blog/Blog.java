package blog;

import java.io.*;
import java.util.ArrayList;

import base.*;

import java.util.Calendar;

public class Blog implements Serializable{

	private User user;
	private ArrayList<Post> allPosts;
	/**
	 * Constructor
	 * @param user
	 */
	public Blog(User user){
		this.user = user;
		this.allPosts = new ArrayList<Post>();
	}
	/**
	 * 
	 * @return
	 */
	public User getUser() {
		return user;
	}
	/**
	 * 
	 * @param user
	 */
	public void setUser(User user) {
		this.user = user;
	}
	/**
	 * create a new post in your blog
	 * @param p
	 */
	public void post(Post p){
		//add Post p to your blog
		allPosts.add(p);
		//print a message if succeed
		System.out.println("A new Post:");
		System.out.println(p);
	}
	/**
	 * list all posts in the blog
	 * 
	 */
	public void list(){
		System.out.println("Current posts:");
		for(int i =0; i<allPosts.size();i++){
			System.out.print("Post["+ (i+1) +"]:");
			System.out.println(allPosts.get(i));
		}
	}
	/**
	 * delete a post from the blog
	 * @param index
	 */
	public void delete(int index){
		if(index > allPosts.size() || index <= 0){
			System.out.println("Illegal deletion");
		}
		else
			allPosts.remove(index-1);
	}
	@Override
	/**
	 * 
	 * @return
	 */
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((allPosts == null) ? 0 : allPosts.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}
	@Override
	/**
	 * 
	 */
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Blog other = (Blog) obj;
		if (allPosts == null) {
			if (other.allPosts != null)
				return false;
		} else if (!allPosts.equals(other.allPosts))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}
	@Override
	/**
	 * Output this object in string format
	 * @return String
	 */
	public String toString() {
		return "Blog [user=" + user + ", allPosts=" + allPosts + "]";
	}
	/**
	 * Search posts created in month and mentioned someone
	 * 
	 * @param month
	 * @param someone
	 */
	public void search(int month, String someone){
		Calendar cal = Calendar.getInstance();
		// search from all posts
		for (Post p: allPosts){
			// get the current post's month ( note that Calendar.Month starts 
			// with 0, not 1)
			cal.setTime(p.getDate());
			int postMonth = cal.get((Calendar.MONTH));
			if((postMonth+1 == month) && p.contains(someone))
				System.out.println(p);
		}
	}
	
	public void setPosts(ArrayList<Post> allPosts){
		for(int i=0;i<allPosts.size();i++)
			this.allPosts.add(allPosts.get(i));
	}
	/**
	 * 
	 * @param filepath
	 */
	public void save(String filepath){
		try{
			FileOutputStream fs = new FileOutputStream(filepath);
			ObjectOutputStream os = new ObjectOutputStream(fs);
			os.writeObject(this);
			os.close();
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		
	}
	
	public void load(String filepath){
		try{
			FileInputStream fs = new FileInputStream(filepath);
			ObjectInputStream is = new ObjectInputStream(fs);
			Blog one = (Blog) is.readObject();
			this.user=one.user;
			for(int i=0; i<one.allPosts.size();i++)
			{this.allPosts.add(one.allPosts.get(i));}
			is.close();
		}
		catch(FileNotFoundException e){
			System.out.println("Wait! There is something wrong. I cannot find the file..");
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
}
