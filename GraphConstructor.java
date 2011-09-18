package igem_applet;

import java.awt.BorderLayout;
import java.awt.Color;

import java.util.Hashtable;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRootPane;

import y.base.Node;

import y.view.Arrow;
import y.view.EdgeRealizer;
import y.view.EditMode;
import y.view.Graph2D;
import y.view.Graph2DView;
import y.view.NodeRealizer;
import y.view.ShapeNodeRealizer;
import y.view.ImageNodeRealizer;
import y.view.NodeLabel;

import y.view.Graph2DSelectionListener;
import y.view.Graph2DSelectionEvent;

public class GraphConstructor extends JPanel {
    Graph2DView view;
    
    public GraphConstructor() {
        setLayout(new BorderLayout());
        view = new Graph2DView();
        EditMode mode = new EditMode();
        mode.allowEdgeCreation(false);
        mode.allowNodeCreation(false);
        mode.allowBendCreation(false);
        view.addViewMode(mode);
		
		/*Graph2DViewActions actions = new Graph2DViewActions(view);  
		// Create the maps to hold the actions.   
		ActionMap aMap = actions.createActionMap();  
		InputMap iMap = actions.createDefaultInputMap(aMap);  */
		
		
        add(view);
        
        configureDefaultRealizers();
    }
	
	public Graph2D getGraphObject(){
		return view.getGraph2D();
	}
	
	public Graph2DView getGraphViewObject(){
		return view;
	}
    
    protected void configureDefaultRealizers() {
        Graph2D graph = view.getGraph2D();
		
        EdgeRealizer er = graph.getDefaultEdgeRealizer();//change the looks of the default edge
        //er.setArrow(Arrow.STANDARD);//a standard (target) arrow
        
        ShapeNodeRealizer snr = new ShapeNodeRealizer(ShapeNodeRealizer.ROUND_RECT);//change the looks (and type) of the default node
        snr.setSize(80, 30);
        //snr.setFillColor(DemoDefaults.DEFAULT_NODE_COLOR);

        //use it as default node realizer
        graph.setDefaultNodeRealizer(snr);
    }
    
    public void drawGraph(String pathway, Hashtable network){
        if(pathway != null){//TODO bu bir yamad�r. yeni sorgu yapt���m�zda listedeki sat�r� se�ili san�yor.
            String[] parts = pathway.split(">");
            createNodes(parts, network);
            createEdges();
            //start();
        }
    }
    
    private void createNodes(String[] parts, Hashtable network){
        Graph2D graph = view.getGraph2D();
        String partID = "";
        char partType;
        
        double posX = 5.0;
        double posY = 100.0;
        for (int i = 0; i < parts.length; i++)  {
            if(network.containsKey(parts[i])){
                Part part = (Part) network.get(parts[i]);
                
                partID = part.partID;
                partType = part.partType.toCharArray()[0];//char'a d�n��mesi gerekiyordu, b�yle yapt�k
            }else{
                //TODO buraya bi �eyler yazman laz�m. OUTPUT'lar i�in �zel bi �eyler.
                partID = parts[i];
                partType = ' ';//TODO bunda daha do�ru bi karakter se�ilebilir
            }
            
            Color nodeColor = getNodeColor(partType);
            
            ShapeNodeRealizer nodeShape = getNodeShape(partType);
			ImageNodeRealizer nodeImage = getImageNodeRealizer(partType);
            //graph.setDefaultNodeRealizer(nodeShape);
			graph.setDefaultNodeRealizer(nodeImage);
            
            //posX = posX + 110;
			posX = posX + 60;
            
            Node stateNode = graph.createNode();
            NodeRealizer nr = graph.getRealizer(stateNode);
            nr.setLocation(posX, posY);
            nr.setLabelText(partID);
            //nr.setFillColor2(nodeColor);
        }
        
        
    }
	
	private ImageNodeRealizer getImageNodeRealizer(char partType){
		String imagePath = "resource/questionmark32x32.png";//DEFAULT IMAGE
        switch(partType){
            case 'I':
                imagePath = "resource/metu-bin_icon.PNG";
                break;
            case 'P':
                imagePath = "resource/promoter.png";
                break;
            case 'R':
                imagePath = "resource/rbs.png";
                break;
            case 'G':
                imagePath = "resource/gene.png";
                break;
            case 'T':
                imagePath = "resource/terminator.png";
                break;
            case 'O':
                imagePath = "resource/metu-bin_icon.PNG";
                break;
			case 'X':
				imagePath = "resource/Letter-C.jpg";
				break;
			case 'Y':
				imagePath = "resource/Letter-C.jpg";
				break;
			case 'Z':
				imagePath = "resource/Letter-C.jpg";
				break;
			case 'W':
				imagePath = "resource/Letter-C.jpg";
				break;
			case 'Q':
				imagePath = "resource/Letter-C.jpg";
				break;
			case 'U':
				imagePath = "resource/Letter-C.jpg";
				break;
        }
	
	
		//register an image with ImageNodeRealizer.
		//must be a path name relative to your java CLASSPATH.
		ImageNodeRealizer inr = new ImageNodeRealizer();
		//set the image
		inr.setImageURL(getClass().getResource(imagePath));
		//set node size equals to half of original image size
		inr.setToImageSize();
		//inr.setSize(inr.getWidth()/2, inr.getHeight()/2);
		inr.setSize(inr.getWidth(), inr.getHeight());
		
		//inr.setLocation(60, 200);
		//set a label text
		//inr.setLabelText("yFiles");

		//set the label model to be 8-pos (eight available positions around node)
		inr.getLabel().setModel(NodeLabel.EIGHT_POS);

		//set the label position (S == South of Node)
		inr.getLabel().setPosition(NodeLabel.S);
		
		return inr;
	}
    
    private Color getNodeColor(char partType){
        Color nodeColor = new Color(100, 100, 100);//DEFAULT COLOR
        switch(partType){
            case 'I':
                nodeColor = new Color(0, 255, 0);
                break;
            case 'P':
                nodeColor = new Color(255, 255, 0);
                break;
            case 'R':
                nodeColor = new Color(0, 255, 255);
                break;
            case 'G':
                nodeColor = new Color(0, 0, 255);
                break;
            case 'T':
                nodeColor = new Color(255, 0, 0);
                break;
            case 'O':
                nodeColor = new Color(0, 255, 0);
                break;
        }
        
        return nodeColor;
    }
    
    private ShapeNodeRealizer getNodeShape(char partType){
        ShapeNodeRealizer snr = new ShapeNodeRealizer(ShapeNodeRealizer.ROUND_RECT);//DEFAULT SHAPE
        
        switch(partType){
            case 'P':
                snr = new ShapeNodeRealizer(ShapeNodeRealizer.RECT);
                break;
            case 'R':
                snr = new ShapeNodeRealizer(ShapeNodeRealizer.ELLIPSE);
                break;
            case 'G':
                snr = new ShapeNodeRealizer(ShapeNodeRealizer.DIAMOND);
                break;
            case 'T':
                snr = new ShapeNodeRealizer(ShapeNodeRealizer.HEXAGON);
                break;
        }
        
        //snr.setSize(37, 37);
        snr.setSize(50,50);
        
        return snr;
    }
    
    private void createEdges(){
        Graph2D graph = view.getGraph2D();
        
        Node[] allNodes = graph.getNodeArray();
        for (int j = 0 ; j < allNodes.length-1; j++)  {
            graph.createEdge(allNodes[j], allNodes[j+1]);
        }
    }
    
    private void start() {
        JFrame frame = new JFrame(getClass().getName());
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        addContentTo(frame.getRootPane());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
    private final void addContentTo(final JRootPane rootPane) {
        rootPane.setContentPane(this);
    }
}
