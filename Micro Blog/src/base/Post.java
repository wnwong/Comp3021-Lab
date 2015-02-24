package base;

import java.util.Date;

public class Post {

	private Date date;
	private String content;
	/**
	 * Constructor
	 * @param date
	 * @param content
	 */
	public Post(Date date, String content){
		this.date = date;
		this.content = content;
	}
	/**
	 * 
	 * @return the content of the blog
	 */
	public String getContent(){
		
		return content;
	}
	/**
	 * 
	 * @return the date of the post
	 */
	public Date getDate(){
		
		return date;
	}
	/**
	 * 
	 * @param content
	 */
	public void setContent(String content){
		this.content = content;
	}
	@Override
	/**
	 * Output this object in string format
	 * @return String
	 * 
	 */
	public String toString(){

		return date + "\n" + content;
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
			// Transfer object o to POST
			Post post = (Post) o;
			if(date != post.date || !content.equals(this.content))
			ans = false;
		}
		return ans;
	}
	/**
	 * 
	 */
	public int hashCode(){
		int hashCode = 0;
		hashCode = 
		date.hashCode() + content.hashCode();
		
		return hashCode;
	}
	/**
	 * check whether this post contains some keyword
	 * @param keyword
	 * @return
	 */
	public boolean contains(String keyword){
		if(content.contains(keyword))
			return true;
		else 
			return false;
	}
}
