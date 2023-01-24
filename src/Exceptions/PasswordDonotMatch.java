package Exceptions;

public class PasswordDonotMatch extends RuntimeException{
    private static final long serialVersionUID = 1L;

	public PasswordDonotMatch(String errorMessage) {  
        super(errorMessage);  
        }  
}
