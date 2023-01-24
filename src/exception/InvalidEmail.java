package exception;

public class InvalidEmail extends RuntimeException{
    public InvalidEmail(String errorMessage) {  
        super(errorMessage);  
        }  
}
