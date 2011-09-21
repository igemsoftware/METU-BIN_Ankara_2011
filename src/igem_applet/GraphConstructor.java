package igem_applet;

import java.awt.BorderLayout;
import java.awt.Color;

import java.util.Hashtable;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRootPane;

import y.base.Node;

import y.layout.BufferedLayouter;
import y.layout.orthogonal.CompactOrthogonalLayouter;

import y.view.Arrow;
import y.view.EdgeRealizer;
import y.view.EditMode;
import y.view.Graph2D;
import y.view.Graph2DView;
import y.view.ImageNodeRealizer;
import y.view.NodeLabel;
import y.view.NodeRealizer;
import y.view.ShapeNodeRealizer;


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

        add(view);

        configureDefaultRealizers();

        Graph2D graph = view.getGraph2D();
        new BufferedLayouter(new CompactOrthogonalLayouter()).doLayout(graph);
        graph.updateViews();
    }

    public Graph2D getGraphObject() {
        return view.getGraph2D();
    }

    public Graph2DView getGraphViewObject() {
        return view;
    }

    protected void configureDefaultRealizers() {
        Graph2D graph = view.getGraph2D();

        EdgeRealizer er = 
            graph.getDefaultEdgeRealizer(); //change the looks of the default edge
        er.setArrow(Arrow.STANDARD); //a standard (target) arrow

        ShapeNodeRealizer snr = 
            new ShapeNodeRealizer(ShapeNodeRealizer.ROUND_RECT); //change the looks (and type) of the default node
        snr.setSize(80, 30);
        //snr.setFillColor(DemoDefaults.DEFAULT_NODE_COLOR);

        //use it as default node realizer
        graph.setDefaultNodeRealizer(snr);
    }

    public void drawGraph(String pathway, Hashtable network) {
        if (pathway != 
            null) { //TODO bu bir yamadýr. yeni sorgu yaptýðýmýzda listedeki satýrý seçili sanýyor.
            String[] parts = pathway.split(">");
            createNodes(parts, network);
            createEdges();
            //start();
        }
    }

    private void createNodes(String[] parts, Hashtable network) {
        Graph2D graph = view.getGraph2D();
        String partID = "";
        char partType;

        double posX = 5.0;
        double posY = 100.0;
        for (int i = 0; i < parts.length; i++) {
            if(i == 0){
                partType = 'S';//Score
                partID = parts[i];
            }else{
                if (network.containsKey(parts[i])) {
                    Part part = (Part)network.get(parts[i]);
                    
                    partID = part.partID;
                    partType = part.partType.toCharArray()[0]; //char'a dönüþmesi gerekiyordu, böyle yaptýk
                } else {
                    //TODO buraya bi þeyler yazman lazým. OUTPUT'lar için özel bi þeyler.
                    partID = parts[i];
                    if (i == 
                        parts.length - 1) { //sonuncunun output oldugu garanti oldugu icin boyle yapildi
                        partType = 'O'; //TODO bunda daha doðru bi karakter seçilebilir
                    } else if (partID.equals("ANY TERMINATOR")) {
                        partType = 'T';
                    } else {
                        partType = ' '; //TODO bunda daha doðru bi karakter seçilebilir     
                    }
                }
            }
            
            Color nodeColor = getNodeColor(partType);
            ShapeNodeRealizer nodeShape = getNodeShape(partType);
            //graph.setDefaultNodeRealizer(nodeShape);

            ImageNodeRealizer nodeImage = getImageNodeRealizer(partType);
            graph.setDefaultNodeRealizer(nodeImage);

            //posX = posX + 110;
            posX = posX + 120;

            if (partType == 'I') {
                posY = 70; //posY - 30;
            } else if (partType == 'O') {
                posY = 130; //posY + 30;
            } else if (partType == 'S') {
                posX -= 105;
                posY = 20; //posY + 30;
            } else {
                posY = 100.0;
            }

            Node stateNode = graph.createNode();
            NodeRealizer nr = graph.getRealizer(stateNode);
            nr.setLocation(posX, posY);
            nr.setLabelText(partID);
            //nr.setFillColor2(nodeColor);
        }


    }

    private ImageNodeRealizer getImageNodeRealizer(char partType) {
        String imagePath = "resource/questionmark32x32.png"; //DEFAULT IMAGE
        switch (partType) {
        case 'S':
            imagePath = "resource/newicons/star32x32.png";
            break;
        case 'I':
            imagePath = "resource/newicons/input.png";
            break;
        case 'P':
            imagePath = "resource/newicons/promoter.png";
            break;
        case 'R':
            imagePath = "resource/newicons/rbs.png";
            break;
        case 'G':
            imagePath = "resource/newicons/gene.png";
            break;
        case 'T':
            imagePath = "resource/newicons/terminator.png";
            break;
        case 'O':
            imagePath = "resource/newicons/output.png";
            break;
        case 'X':
            imagePath = "resource/newicons/X.png";
            break;
        case 'Y':
            imagePath = "resource/newicons/Y.png";
            break;
        case 'Z':
            imagePath = "resource/newicons/Z.png";
            break;
        case 'W':
            imagePath = "resource/newicons/W.png";
            break;
        case 'Q':
            imagePath = "resource/newicons/Q.png";
            break;
        case 'U':
            imagePath = "resource/newicons/U.png";
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

    private Color getNodeColor(char partType) {
        Color nodeColor = new Color(100, 100, 100); //DEFAULT COLOR
        switch (partType) {
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

    private ShapeNodeRealizer getNodeShape(char partType) {
        ShapeNodeRealizer snr = 
            new ShapeNodeRealizer(ShapeNodeRealizer.ROUND_RECT); //DEFAULT SHAPE

        switch (partType) {
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
        snr.setSize(50, 50);

        return snr;
    }

    private void createEdges() {
        Graph2D graph = view.getGraph2D();

        Node[] allNodes = graph.getNodeArray();
        for (int j = 1; j < allNodes.length - 1; j++) {//int j = 0
            graph.createEdge(allNodes[j], allNodes[j + 1]);
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
