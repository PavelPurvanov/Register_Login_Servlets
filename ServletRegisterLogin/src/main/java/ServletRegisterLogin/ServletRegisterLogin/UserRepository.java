package ServletRegisterLogin.ServletRegisterLogin;

import java.util.Set;
import java.util.TreeSet;

import ServletRegisterLogin.ServletRegisterLogin.User;

public class UserRepository {
	
	private static Set<User> UsersSet = new TreeSet<>();

	public UserRepository() {
	}

	public static void addUser(User user) {
		UsersSet.add(user);
	}

	public static User getUser(User user) {
		for (User repoUser : UsersSet) {
			if (repoUser.getEmail().equals(user.getEmail()) 
					&& repoUser.getPassword().equals(user.getPassword()))
				return repoUser;
		}
		return null;
	}

	public static boolean contains(User user) {
		for (User repoUser : UsersSet) {
			if (repoUser.equals(user))
				return true;
		}
		return false;
	}
}
