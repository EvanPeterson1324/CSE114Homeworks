
package CSE114_Homework7;

/**
 * @author Evan Peterson
 * SBU ID: 108509452
 * CSE 114
 * Homework #7
 */
class HexFormatException extends Exception{
    private String hexFormat;
    
    public HexFormatException(String hexFormat){
        super("Invalid Hex Format: " + hexFormat);
        this.hexFormat = hexFormat;
    }
    
    public String getHexFormat(){
        return this.hexFormat;
    }
}
