package CSE114_Homework7;


/**
 * @author Evan Peterson
 * SBU ID: 108509452
 * CSE 114
 * Homework #7
 */
public class HexBinDec {
    
    public static void main(String[] args){
        
        // Hex Format Exception
        try {
            System.out.println(hex2Dec("ff"));
            System.out.println(hex2Dec("rr"));
        } catch (HexFormatException ex) {
            System.out.println(ex.getHexFormat() + " is not a valid Hex Format.");
        } 
        
        System.out.println();
        
        // Binary Format Exception
        try {
            System.out.println(bin2Dec("1101"));
            System.out.println(bin2Dec("zasdsdd11..."));
        } catch (BinaryFormatException ex){
            System.out.println(ex.getBinString() + " is not a valid Binary Format");
        }
        System.out.println();    
    }
    
    public static int hex2Dec(String hexString) throws HexFormatException{
        String hexString2 = hexString.toLowerCase();
        int decimalSum = 0;
        int counter = 0;
        String validChars = "0123456789abcdef";
        for(char ch : hexString2.toCharArray()){
            int i = validChars.indexOf(ch);
            if(i == -1){
                throw new HexFormatException(hexString);
            }
            decimalSum = (int) (decimalSum + (Math.pow(16, counter)) * i);
            counter--;
        }
        return decimalSum;
    }
    
    public static int bin2Dec(String binString) throws BinaryFormatException {
        try{
            return Integer.parseInt(binString, 2);
        } catch(NumberFormatException ex){
            throw new BinaryFormatException(binString);
        }
    }
}
