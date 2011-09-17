package igem_applet;

public class Utils {
    public Utils() {
    }
    
    public static String recoverSpelling(String word){
        String recovered = word;
        
        recovered = recovered.replaceAll("Ý","I");
        
        return recovered;
    }
    
    public static boolean isNumeric(String str){
        boolean isNumeric = true;
        //char[]
        
        
        return isNumeric;
    }
    
    public static boolean isInteger(String str){
        boolean ret = false;
        
        try{
          Integer.parseInt(str);  
          ret = true;  
        }  
        catch(Exception e){  
          ret = false;  
        }
        
        return ret;
    } 
}
