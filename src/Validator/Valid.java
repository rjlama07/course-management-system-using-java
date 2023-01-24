package Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Valid {
	public boolean checkEmail(String email)
    {
        String regex="^(.+)@(\\S+)$";
        Pattern pattern=Pattern.compile(regex);
        Matcher matcher=pattern.matcher(email);
        return matcher.matches();
    }
    public boolean checkPassword(String p){
        String regex= "^(?=.*[0-9])"
                + "(?=.*[a-z])(?=.*[A-Z])"
                + "(?=.*[@#$%^&+=])"
                + "(?=\\S+$).{8,20}$";
        Pattern pattern=Pattern.compile(regex);
        Matcher matcher=pattern.matcher(p);
        return matcher.matches();
    }

}