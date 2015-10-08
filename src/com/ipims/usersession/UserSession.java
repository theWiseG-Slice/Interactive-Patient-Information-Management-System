package com.ipims.usersession;
import com.ipims.models.User;

/**
 * Stores the current session of the application
 * @author jithin
 *
 */
public class UserSession {


	private static UserSession instance = null;
	private User loggedInUser;
	
	private UserSession() {
		loggedInUser = null;
	}
	
	
	/**
	 * Get the singleton instance of the Usersession class
	 * @return returns the singleton instance
	 */
	public static UserSession getInstance() {
		if(instance == null) {
			instance = new UserSession();
		}
		return instance;
	}

	/**
	 * Returns the current user logged in 
	 * @return null if user is not logged in.
	 */
	public User getCurrentUser() {
		return loggedInUser;
	}
	
	public void login(String userName, String password) {
		loggedInUser = new User();
		
	}
	
	public void logout() {
		loggedInUser = null;
	}
	
	public void register(User user) {
		loggedInUser = user;
	}
}
