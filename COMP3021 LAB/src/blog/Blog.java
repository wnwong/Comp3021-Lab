package blog;

import java.util.ArrayList;

import base.*;

public class Blog {

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
			System.out.print("Post["+ (i+1) +"]");
			System.out.println(allPosts.get(i));
		}
	}
	/**
	 * delete a post from the blog
	 * @param index
	 */
	public void delete(int index){
		if(index > allPosts.size()){
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
	
	
}
