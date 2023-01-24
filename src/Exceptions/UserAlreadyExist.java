package Exceptions;


public class UserAlreadyExist extends RuntimeException{
    private static final long serialVersionUID = 1L;

	public UserAlreadyExist(String errorMessage) {  
        super(errorMessage);  
        }  
}