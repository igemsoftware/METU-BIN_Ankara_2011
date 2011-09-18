package igem_applet;

import java.util.Hashtable;

public class Part {
    public String partID = "";
    public String partType = "";
    public String promoterType = "";//bu deðiþken sadece Input tipindeki part'larda dolu olacak.
    /**************************************************************
     * bu 2 deðiþken programa hýz kazandýrmak için tanýmlandý. yoksa ayný bilgiler nextParts'ta yer almaktadýr. 
     * bu bilgiler sadece genlerde dolu olacak.
     * ***********************************************************/
    public String output = "";
    public String terminator = "";
    /********************************************************************************/
        
    public Hashtable nextParts = null;
    
    public Part(){
        
    }
    
    public Part(String partID, String partType, String promoterType, String output, String terminator, Hashtable nextParts){
        this.partID = partID;
        this.partType = partType;
        this.promoterType = promoterType;
        this.output = output;
        this.terminator = terminator;
        this.nextParts = nextParts;
    }
}