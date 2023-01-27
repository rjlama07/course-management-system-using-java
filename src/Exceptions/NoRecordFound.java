package Exceptions;

public class NoRecordFound extends RuntimeException{
    private static final long serialVersionUID = 1L;

	public NoRecordFound(String errorMessage) {  
        super(errorMessage);  
        }  
}
