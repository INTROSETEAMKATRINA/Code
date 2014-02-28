public class InvalidDateException extends Exception {
    public InvalidDateException(String column, String row) {
        super("Invalid Date on column " + column + ", row " + row);
    }   
    
    public InvalidDateException() {
        super("Invalid Date");        
    }
    
}
