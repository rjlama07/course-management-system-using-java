package Exceptions;

public class InvalidEmail extends RuntimeException{
    private static final long serialVersionUID = 1L;

	public InvalidEmail(String errorMessage) {  
        super(errorMessage);  
        }  
}
