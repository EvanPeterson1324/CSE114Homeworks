
package CSE114_Homework7;

/**
 * @author Evan Peterson
 * SBU ID: 108509452
 * CSE 114
 * Homework #7
 */
class BinaryFormatException extends Exception{
    private String binFormat;
    
    public BinaryFormatException(String binFormat){
        super(binFormat);
        this.binFormat = binFormat;
    }
    
    public String getBinString(){
        return this.binFormat;
    }
}
