/**
* @author Gokhan ERSOY
*/

//Special Characters: é " ! ' £ ^ # $ % ½ & ? | ` ±

package igem_applet;

import java.io.BufferedWriter;
import java.io.FileWriter;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;

import javax.swing.JLabel;
import javax.swing.JOptionPane;




import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class PathwayFinder {
    private static String USAGE = "java PathwayFinder [Interactions File] [Input Part] [Output Part]";
    private static boolean DEBUG = false;
    private static String outFileName = "pathway.txt"; //TODO bunu local yapabilirsin
    private static String interactionsFileName = "interactions.txt"; //TODO bunu local yapabilirsin
    private static boolean firstCall = true; //used for file operations

    public PathwayFinder() {
    }
    
    public Hashtable getNetwork(String[] interactions) {
        Hashtable network = new Hashtable();

        for (int i = 0; i < interactions.length; i++) {
            //System.out.println(interactions[i]);

            String[] edgeInfo = interactions[i].split("\t"); //TODO dosya formatina guvenilerek yapildi
            String part1 = edgeInfo[0].trim();
            String partType1 = edgeInfo[1].trim();
            String part2 = edgeInfo[2].trim();
            String partType2 = edgeInfo[3].trim();

            String interactionType = "" + partType2.substring(0, 1).toUpperCase();
            if (!network.containsKey(part1)) { //eger bu part daha onceden eklenmemisse...
                Part partInfo = new Part();
                partInfo.partID = part1;
                partInfo.partType = partType1.substring(0, 1).toUpperCase();
                Hashtable nextParts = new Hashtable();
                nextParts.put(part2, interactionType);
                partInfo.nextParts = nextParts;
                if(interactionType.equals("O")){
                    partInfo.output = part2;
                }else if(interactionType.equals("T")){
                    partInfo.terminator = part2;
                }
                network.put(part1, partInfo);
            } else {
                Part partInfo = (Part)network.get(part1); //partin bilgilerini cek
                if (!partInfo.nextParts.containsKey(part2)) { //bu parttan gidilebilecek partlara bak. elimizdeki nextpart daha once eklenmediyse...
                    partInfo.nextParts.put(part2, interactionType);
                    if(interactionType.equals("O")){
                        partInfo.output = part2;
                    }else if(interactionType.equals("T")){
                        partInfo.terminator = part2;
                    }
                }
                network.put(part1, partInfo);
            }
        }

        return network;
    }
    
    public Hashtable getNetwork2(String[] interactions) {
        Hashtable network = new Hashtable();

        for (int i = 0; i < interactions.length; i++) {
            //System.out.println(interactions[i]);

            String[] edgeInfo = interactions[i].split("\t"); //TODO dosya formatina guvenilerek yapildi
            String part1 = Utils.recoverSpelling(edgeInfo[0].trim().toUpperCase());
            String partType1 = Utils.recoverSpelling(edgeInfo[1].trim().toUpperCase());
            String part2 = Utils.recoverSpelling(edgeInfo[2].trim().toUpperCase());
            String partType2 = Utils.recoverSpelling(edgeInfo[3].trim().toUpperCase());
            
            String interactionType = "" + partType2.substring(0,1);
            String promoterType = "-";//TODO Default olarak bu iþaret kullanýldý ama deðiþtirilecek.
            if(edgeInfo.length == 5){
                promoterType = Utils.recoverSpelling(edgeInfo[4].trim().toUpperCase());
                promoterType = promoterType.substring(0,1);
            }
            
            if (!network.containsKey(part1)) { //eger bu part daha onceden eklenmemisse...
                Part partInfo = new Part();
                partInfo.partID = part1;
                /*if(partType1.equals("RBS+GENE")){
                    partInfo.partType = "RG";
                }else{*/
                    partInfo.partType = partType1.substring(0,1);
                //}
                
                //partInfo.promoterType = promoterType.substring(0,1);//TODO BU VE BUNUNLA ÝLGÝLÝ SATIRLAR SÝLÝNECEK
                //partInfo.promoterType = "A";//TODO BU VE BUNUNLA ÝLGÝLÝ SATIRLAR SÝLÝNECEK
                
                Hashtable nextParts = new Hashtable();
                if(!promoterType.equals("I")){//Inhibitor deðilse nextPart'lara ekle TODO doðruluðu kontrol edilecek
                    Part nextPartInfo = new Part(part2, interactionType, promoterType, "", "", null);
                    nextParts.put(part2, nextPartInfo);
                }
                partInfo.nextParts = nextParts;
                
                if(interactionType.equals("O")){
                    partInfo.output = part2;
                }else if(interactionType.equals("T")){
                    partInfo.terminator = part2;
                }
                network.put(part1, partInfo);
            } else {
                Part partInfo = (Part) network.get(part1); //partin bilgilerini cek
                if (!partInfo.nextParts.containsKey(part2)) { //bu parttan gidilebilecek partlara bak. elimizdeki nextpart daha once eklenmediyse...
                    if(!promoterType.equals("I")){//Inhibitor deðilse nextPart'lara ekle TODO doðruluðu kontrol edilecek
                        Part nextPartInfo = new Part(part2, interactionType, promoterType, "", "", null);
                        partInfo.nextParts.put(part2, nextPartInfo);
                    }
                    
                    if(interactionType.equals("O")){
                        partInfo.output = part2;
                    }else if(interactionType.equals("T")){
                        partInfo.terminator = part2;
                    }
                }
                network.put(part1, partInfo);
            }
        }

        return network;
    }
	
	public Hashtable getNetwork3() {
        Hashtable network = new Hashtable();
		System.out.println("EHU EHU");
		try {
			Connection con = IIConnection.getIIConnection();
            Statement stmt = con.createStatement();
			ResultSet set = stmt.executeQuery("SELECT * FROM interactions_wide");
			while(set.next()){
				String part1 = Utils.recoverSpelling(set.getString("part1").toUpperCase());
				String partType1 = Utils.recoverSpelling(set.getString("type1").toUpperCase());
				String part2 = Utils.recoverSpelling(set.getString("part2").toUpperCase());
				String partType2 = Utils.recoverSpelling(set.getString("type2").toUpperCase());
				String promoterType = Utils.recoverSpelling(set.getString("promoter_type").toUpperCase());
				promoterType = promoterType.substring(0,1);
				
				String interactionType = "" + partType2.substring(0,1);
				
				if (!network.containsKey(part1)) { //eger bu part daha onceden eklenmemisse...
					Part partInfo = new Part();
					partInfo.partID = part1;
					/*if(partType1.equals("RBS+GENE")){
						partInfo.partType = "RG";
					}else{*/
						partInfo.partType = partType1.substring(0,1);
					//}
					
					//partInfo.promoterType = promoterType.substring(0,1);//TODO BU VE BUNUNLA ÝLGÝLÝ SATIRLAR SÝLÝNECEK
					//partInfo.promoterType = "A";//TODO BU VE BUNUNLA ÝLGÝLÝ SATIRLAR SÝLÝNECEK
					
					Hashtable nextParts = new Hashtable();
					if(!promoterType.equals("I")){//Inhibitor deðilse nextPart'lara ekle TODO doðruluðu kontrol edilecek
						Part nextPartInfo = new Part(part2, interactionType, promoterType, "", "", null);
						nextParts.put(part2, nextPartInfo);
					}
					partInfo.nextParts = nextParts;
					
					if(interactionType.equals("O")){
						partInfo.output = part2;
					}else if(interactionType.equals("T")){
						partInfo.terminator = part2;
					}
					network.put(part1, partInfo);
				} else {
					Part partInfo = (Part) network.get(part1); //partin bilgilerini cek
					if (!partInfo.nextParts.containsKey(part2)) { //bu parttan gidilebilecek partlara bak. elimizdeki nextpart daha once eklenmediyse...
						if(!promoterType.equals("I")){//Inhibitor deðilse nextPart'lara ekle TODO doðruluðu kontrol edilecek
							Part nextPartInfo = new Part(part2, interactionType, promoterType, "", "", null);
							partInfo.nextParts.put(part2, nextPartInfo);
						}
						
						if(interactionType.equals("O")){
							partInfo.output = part2;
						}else if(interactionType.equals("T")){
							partInfo.terminator = part2;
						}
					}
					network.put(part1, partInfo);
				}
			}
			con.close();
		}catch( Exception e ) {
			e.printStackTrace();
		}

        return network;
    }

    public ArrayList<ArrayList<Part>> findAllPathways(Hashtable network, String inputPart, String outputPart, Integer deviceCount) {
        ArrayList<ArrayList<Part>> pathways = null;
        
		System.out.println(inputPart +"\t>\t"+ outputPart);
		
        if (network.containsKey(inputPart)) { //TODO bunun gercekten input olup olmadigi kontrol edilebilir.
            firstCall = true;
            pathways = getPaths(network, inputPart, outputPart, deviceCount);
        }else{
            //TODO
            JLabel optionLabel = new JLabel("<HTML><FONT COLOR = RED><B>"+inputPart+"</B></FONT><FONT COLOR = Blue> was not found in plates. </FONT></HTML>");
            JOptionPane.showMessageDialog(null, optionLabel);
            pathways = null;//isi garantiye almak icin
        }
        
        return pathways;
    }

     /**
      * PROBLEM1 (RESOLVED):
      * Network'te Gene'in hem output'undan hem terminator'ýndan bir sonraki node'a geçiþ olmayacak.
      * sadece output'tan geçiþ olacak. yani
      * T:istenen output
      * Y:terminator ise
      *
      * ekrana
      * ADHNT yerine ADHNY yazdýracan.
      * ADHNTGKT yerine ADHNYGKY yazdýracan.
      *
      * bunu en son T'leri Y ile replace ederek yapabilirsin. BINGO!
      * 
      * TODO
      * PROBLEM2:
      * Kerem'in belirttiði durum:
      * Loop oluþmasý durumunda, benim algoritma loop noktasýndan geri geri giderek en son fork (dallanma) noktasýna kadar path'i temizliyor.
      * Ancak þunu yapmasý lazým. Eðer loop noktasýndan sonra baþka path üzerinden gidecekse, yani loop noktasýnýn 1'den fazla çocuðu varsa, onlardan devam etmeli.
      * */
    private ArrayList<ArrayList<Part>> getPaths(Hashtable network, String input, String output, Integer deviceCount) {
        ArrayList<ArrayList<Part>> pathList = new ArrayList<ArrayList<Part>>();
        ArrayList<Part> path = new ArrayList<Part>();
        Part outputPart = new Part(output, "O", "", "", "", null);
        
        ArrayList<String> stack = new ArrayList<String>();
        ArrayList<Integer> childCountStack = new ArrayList<Integer>();
        
        stack.add(input);//PUSH
        
        while (stack.size() > 0) {
            String parent = stack.remove(stack.size() - 1); //POP
            
            boolean isPartInNetwork = network.containsKey(parent);//this variable is defined to speed up program running.
            Part part = null;
            if (isPartInNetwork) {
                part = (Part) network.get(parent);
                //part.nextParts = null; //TODO luzumu halinde acilacak. sebebi asagida yaziyor.
                                        //nextParts degiskeni þimdilik silinmedi. 
                                       //eger ilerde kullanilmazsa Part class'i gibi ayri bi class tanimlanip kullanilmasi iyi olur. 
                                       //Bu class'in içinde nextParts degiskeni olmayacak. 
                                       //Ya da burda path'e eklenmeden once nextParts degeri null'a esitlenir. bu daha iyi bence.
            }else{
                part = new Part(parent, "", "", "", "", null);//bunun cocuklari olmadigi icin zaten asagida path'ten cikarilacak. bu yüzden tipini yazmaya gerek yok.
            }
            
            
            /*if(part.partType.equals("X") || 
               part.partType.equals("Y") || 
               part.partType.equals("Z") || 
               part.partType.equals("W") || 
               part.partType.equals("Q")){
                System.out.println(part.partType + "\t" + part.partID);
            }*/
            
            
            if(getIndex(parent, path) < 0){//aynisindan daha once eklemediysek. bu, LOOP'u engellemek icin yapýlan bir kontroldür.
                if (parent.equals(output)) {
                    //TODO BURAYA DIKKAT
                    //TODO burda once genin terminator'i ekleniyor.??????
                    Part gene = path.get(path.size()-1);
                    Part terminator = new Part("", "T", "", "", "", null);
                    if(gene.terminator.equals("")){
                        System.out.println("[1] TERMINATOR'SIZ GEN: " + gene.partID);//TODO Silinecek
                        terminator.partID = "UNDEFINED_TERMINATOR";
                    }else{
                        terminator.partID = gene.terminator;
                    }
                    
                    path.add(terminator);//TODO þu an eklenen Part bir output olduðu için bir öncesi mutlaka Gen'dir mantýðýyla yapýldý.
                                         //Ancak, RBS+Gene ve Promoter+RBS+Gene de olabilir. bunlar icin ozel sart koyulacak.
                    path.add(outputPart);//TODO bu doðru bir uygulama gibi görünüyor. ama daha sonra kontrol edilmesinde fayda var.
                    
                    /* TODO Burdaki islemler program gelistiricisi icin
					
					String parts = "";
                    String partTypes = "";
                    for (int k = 0; k < path.size(); k++)  {
                        parts += path.get(k).partID + ">";
                        partTypes += path.get(k).partType + ">";
                    }
                    System.out.println(parts);
                    writeFile(parts, 1);
                    writeFile(partTypes, 1);*/
                    
                    ArrayList<Part> path1 = new ArrayList<Part>();
                    for (int ik = 0; ik < path.size(); ik++){//The reason is Java and C# uses reference based assignments so they just pass reference, for solving this problem, a copy of the object is taken and then it is destroyed. 
                        path1.add(path.get(ik));
                    }
                    
                    if(checkDeviceCount(path1, deviceCount)){//TODO þimdilik böyle yapýldý. ancak programý hýzlandýrmak için path oluþtururken kontrol edilebilir. 
                        pathList.add(path1);
                    }
                    
                    //path1 = new ArrayList<Part>();
                }else{
                    /*if(!part.partID.equals("$")){//TODO constitutive'ler için yapilan bi deneme
                        path.add(part);
                    }*/
                    path.add(part);
                }
                
                if (isPartInNetwork) {//if node has children, then add those children to stack.
                    boolean isPathOK = false;
                    /*if(part.promoterType.equals("I")){
                        isPathOK = false;
                    }else{*/
                        String partType = part.partType;
                        if(partType.equals("P")){
                            //BIR ONCEKI PART'IN TIPI T ISE 2 ONCESININ OUTPUT'UNU KONTROL ET.
                            //EGER BU OUTPUT BU PROMOTER'A INPUT OLARAK GIRIYORSA PATH DOGRUDUR.
                            //GIRMIYORSA BASKA YOLDAN DEVAM EDECEK.lastNode
                            
                            Part lastNode = path.get(path.size()-2);//BIR ONCESI
                            if(lastNode.partType.equals("T")){//partType Promoter ise lastNode'un partType'i ya T ya da I olmalidir, diye düþünüyorum, ben, yaaanii.
                                lastNode = path.get(path.size()-3);//MUST BE IN G,Y,Z,Q
                                
                                Part outputNode = (Part) network.get(lastNode.output);
                                if(outputNode != null){
                                    Enumeration iterator = outputNode.nextParts.keys();
                                    while (iterator.hasMoreElements() && !isPathOK) {
                                        String child = (String)iterator.nextElement();
                                        if(child.equals(parent)){
                                            isPathOK = true;
                                        }
                                    }
                                }else{
                                    isPathOK = false;
                                }
                            }else{
                                /**IMPORTANT SECTION**/
                                isPathOK = true;
                                //if(lastNode.partType.equals("I") && !lastNode.partID.equals(input)){//BÝR ÖNCEKÝ PART'IN TERMINATOR'INI BU PARTIN YERÝNE EKLE.
                                if(lastNode.partType.equals("I")){//path size'ýn 2'den büyük olmasý demek, lastNode'un ilk node olmamasý demek.
                                    if(path.size() > 2){
                                        lastNode = path.get(path.size()-3);//MUST BE IN G,Y,Z,Q,W
                                        /*if(lastNode.partType.equals("G") 
                                           || lastNode.partType.equals("Y") 
                                           || lastNode.partType.equals("Z") 
                                           || lastNode.partType.equals("Q")){*/
                                            Part terminator = new Part("", "T", "", "", "", null);
                                            if(lastNode.terminator.equals("")){
                                                System.out.println("[2] TERMINATOR'SIZ GEN: " + lastNode.partID);//TODO Silinecek
                                                terminator.partID = "UNDEFINED_TERMINATOR";
                                            }else{
                                                terminator.partID = lastNode.terminator;
                                            }
                                            
                                            path.add(path.size()-2, terminator);//ARAYA TERMINATOR SOKUYORUZ
                                            path.remove(path.size()-2);//TERMINATOR'DAN BÝR SONRA GELEN INPUT TIPINDEKI NODE'U SÝLÝYORUZ.
                                        /*}else{
                                            //TODO 
                                        }*/
                                    }
                                }else{
                                    //TODO buraya bi þey yazmaya gerek yok bence.
                                }
                                /**-----------------**/
                            }
                        }/*else if(partType.equals("G")){
                            Part outputNode = (Part) network.get(part.output);
                            if(outputNode != null){
                                isPathOK = true;
                            }else{
                                isPathOK = false;
                            }
                        }*/else{
                            isPathOK = true;
                        }
                    //}
                    
                    if(isPathOK){
                        Hashtable nextParts = part.nextParts;
                        Integer childCount = part.nextParts.size();
                        childCountStack.add(childCount);

                        Enumeration iterator = nextParts.keys();
                        while (iterator.hasMoreElements()) {
                            String child = (String)iterator.nextElement();
                            stack.add(child); //PUSH
                        }
                    }else{
                        path.remove(path.size()-1);
                        path = cropPath(path, childCountStack);//DOGRU. BI DAHA BI DAHA KONTROL ETME.
                    }
                } else {//node doesn't have any children (leaf node)
                    //son ekledigimizi cikariyoruz.
                    Part lastNode = path.remove(path.size()-1);//REMOVE LAST NODE
                    //if(lastNode.partType.equals("O")){//TODO BURAYA DÝKKAT: ASLINDA BU ÝÞLEM SADECE SON OUTPUT ÝÇÝN GEÇERLÝ. DIGERLERINDE SORUN OLABÝLÝR. ÇÜNKÜ DÝÐERLERÝNDEN ÖNCE TERMÝNATOR EKLEMÝYORUZ.
                    if(lastNode.partID.equals(output)){
                        path.remove(path.size()-1);//REMOVE LAST NODE AGAIN, BECAUSE OF TERMINATOR
                    }
                    path = cropPath(path, childCountStack);//DOGRU. BI DAHA BI DAHA KONTROL ETME.
                }
            } else {//AYNISI VAR
                //System.out.println("AYNISI VAR: " + parent);
                path = cropPath(path, childCountStack);//DOGRU. BI DAHA BI DAHA KONTROL ETME.
            }
        }
        
        System.out.println("BITTI");
        
        return pathList;
    }
     
	private boolean checkDeviceCount(ArrayList<Part> path, Integer deviceCount) {
        if(deviceCount < 1){
            return true;
        }
        
        int size = path.size();
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (path.get(i).partType.equals("T")) {
                count++;
            }

            if (count > deviceCount) {
                return false;
            }
        }

        return true;
    }
    
    private int getIndex(String part, ArrayList<Part> path){
        int index = -1;
        int size = path.size();
        boolean found = false;
        for (int i = 0; i < size && !found; i++)  {
            if(path.get(i).partID.equals(part)){
                index = i;
                found = true;
            }
        }
        
        return index;
    }
    
    /**
     * childcount'u 0'a inenleri path'ten çýkarma islemi
     * */
    private ArrayList<Part> cropPath(ArrayList<Part> path, ArrayList<Integer> childCountStack) {
        ArrayList<Part> croppedPath = path;

        int removalCount = 0; //leaf node'u path'e zaten eklememis oldugumuz icin 0'dan baslatiyoruz.

        boolean bitti = false;
        while (!bitti) {
            if (childCountStack.size() > 0) {
                Integer childCount = childCountStack.remove(childCountStack.size() - 1); //POP
                if (childCount > 1) {
                    childCount--;
                    childCountStack.add(childCount); //1 azaltilmis olan cocuk sayisini yigita tekrar ekle
                    bitti = true;
                } else { //if there exists no child left
                    removalCount++; //remove the node from path
                }
            } else { //bu kosulun saglanmasi demek tum node'larin taranmis olmasi demek oluyor bi anlamda
                bitti = true;
            }
        }

        for (int i = 0; i < removalCount; i++) {
            croppedPath.remove(croppedPath.size()-1);//REMOVE LAST NODE
        }
        
        return croppedPath;
    }
    
    private void writeFile(String str, int fileNo) {
        try {
            FileWriter fstream;
            FileWriter fstream2;
            if (firstCall) {
                fstream = new FileWriter(outFileName); //open mode
                fstream2 = new FileWriter(interactionsFileName); //open mode
                firstCall = false;
            } else {
                fstream = new FileWriter(outFileName, true); //append mode
                fstream2 = 
                        new FileWriter(interactionsFileName, true); //append mode
            }
            BufferedWriter out;
            if (fileNo == 1) {
                out = new BufferedWriter(fstream);
            } else {
                out = new BufferedWriter(fstream2);
            }

            out.write(str + "\n");
            out.close();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
