package exception;

public class UserAlreadyExist extends RuntimeException{
    public UserAlreadyExist(String errorMessage) {  
        super(errorMessage);  
        }  
}
