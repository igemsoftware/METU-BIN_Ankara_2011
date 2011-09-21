package igem_applet;

import java.sql.Connection;

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
	
	public static void bubbleSort1(double[] scores, String[] paths) {
        int n = scores.length;
        for (int pass = 1; pass < n; pass++) {  // count how many times
            // This next loop becomes shorter and shorter
            for (int i = 0; i < n-pass; i++) {
                if (scores[i] < scores[i+1]) {
                    // exchange elements
                    double temp = scores[i];  
                    scores[i] = scores[i+1];  
                    scores[i+1] = temp;
                    
                    String tempPath = paths[i];  
                    paths[i] = paths[i+1];  
                    paths[i+1] = tempPath;
                }
            }
        }
    }
    
    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }
}
