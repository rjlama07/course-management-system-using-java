package exception;

public class PasswordDonotMatch extends RuntimeException{
    public PasswordDonotMatch(String errorMessage) {  
        super(errorMessage);  
        }  
}
