package ServletRegisterLogin.ServletRegisterLogin;

import java.io.Serializable;

public class User implements Serializable,Comparable<User> {
	private String firstName;
	private String email;
	private String password;

	public User(String email, String password) {
		super();
		this.firstName=null;
		this.email = email;
		this.password = password;
	}
	
	public User(String firstName, String email, String password) {
		super();
		this.firstName = firstName;
		this.email = email;
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
		if (this.compareTo(other)==0)
			return true;
		else
			return false;
	}

	@Override
	public int compareTo(User o) {
		return this.email.compareTo(o.getEmail());
	}

}
