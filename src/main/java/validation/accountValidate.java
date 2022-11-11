package validation;

public class accountValidate {
	public String validUser(String user) {
		if(user==null) {
			return ("Invalid input");
		}
		else
			return user;
	}
	public boolean validPassword(String password){
	    return password != null &&
	    
	    password.matches("(?=.*[a-zA-Z])(?=.*[\\\\d~!@#$%^&*()_+{}\\\\[\\\\]?<>|]).{8,50}");
	}

}
