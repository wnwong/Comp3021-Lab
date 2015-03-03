package test;

import java.io.*;
import java.util.Date;
import base.*;
import blog.*;

public class TestBlog {

	public String getInput(){
		String line = "";
		System.out.print("Enter the prompt:");
		try{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			line = br.readLine();
		}
		catch(IOException e){
			e.printStackTrace();
		}
		return line;
	}
	public static void main(String[] args) {
		TestBlog testBlog = new TestBlog();
		Date date = new Date();
		User user = new User(1, "COMP3021", "COMP3012@cse.ust.hk");
		Blog myblog = new Blog(user);
		String prompt = null;
		
		while(!(prompt = testBlog.getInput()).equals("exit")){
			//String prompt has already stores the input, now deal with it
			if (prompt.startsWith("list")){
				myblog.list();
			}
			else if (prompt.startsWith("post")){
				String cont[] = prompt.split(" ");
				String content = "";
				for(int i = 1; i < cont.length; i++){
					 content = content.concat(cont[i]);
					 content = content.concat(" ");
				}
				Post post = new Post(date, content);
				myblog.post(post);
			}
			else if (prompt.startsWith("delete")){
				String ind[] = prompt.split(" ");
				int index = Integer.parseInt(ind[1]);
				myblog.delete(index);
			}
		}
		

	}

}
