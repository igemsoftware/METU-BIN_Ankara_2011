/**
* @author Gokhan ERSOY
*/
package igem_applet;

import java.applet.Applet;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.Hashtable;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import y.base.Node;

import y.view.Arrow;
import y.view.EdgeRealizer;
import y.view.EditMode;
import y.view.Graph2D;
import y.view.Graph2DView;
import y.view.NodeRealizer;
import y.view.ShapeNodeRealizer;


public class M4BApplet extends Applet implements ActionListener{
    private static int FILE_READ_ERROR = -2;
    private String file = "C:\\GOKHAN\\MSc2011\\iGEM\\algo_files\\input_files\\io5.txt"; //TODO bunu kullaniciya sectirmenin alemi yok.
                                                                                                //zaten bu daha sonra veritabanindan cekecek partlari.
    private Hashtable network;
    // Variables declaration
    private JLabel lblInput;
    private JLabel lblOutput;
    private JLabel lblDeviceCount;
    private JTextField txtInput;
    private JTextField txtOutput;
    private JTextField txtDeviceCount;
    private JButton btnFind;
    private JTextArea txtareaPathways;
    private JList listPathways;
    Graph2DView view;
    JScrollPane scPnlGraph;
    JPanel pnlGraph;
    
    //private JPanel contentPane;
    private Font defaultFont = new Font("Serif", Font.BOLD, 12);
    // End of variables declaration
    
    public M4BApplet() {
        super();
        create();
        this.setVisible(true);
    }
    
    private void create() {
        lblInput = new JLabel();
        lblOutput = new JLabel();
        lblDeviceCount = new JLabel();
        txtInput = new JTextField();
        txtOutput = new JTextField();
        txtDeviceCount = new JTextField();
        btnFind = new JButton();
        txtareaPathways = new JTextArea();
        listPathways = new JList();
        /*JPanel abc = new JPanel();
        abc.setBackground(new Color(255, 0, 0));
        JLabel tttt = new JLabel();
        tttt.setHorizontalAlignment(SwingConstants.RIGHT);
        tttt.setForeground(new Color(0, 0, 255));
        tttt.setText("Input:");
        addComponent(abc, tttt,9000, 9000, 100, 50);*/
        
        pnlGraph = new JPanel();
        //pnlGraph.setBackground(new Color(255, 0, 0));
        scPnlGraph = new JScrollPane(pnlGraph);
        
        //contentPane = (JPanel)this.getContentPane();

        //
        // lblInput
        //
        lblInput.setHorizontalAlignment(SwingConstants.RIGHT);
        lblInput.setForeground(new Color(0, 0, 255));
        lblInput.setText("Input:");
        //
        // lblOutput
        //
        lblOutput.setHorizontalAlignment(SwingConstants.RIGHT);
        lblOutput.setForeground(new Color(0, 0, 255));
        lblOutput.setText("Output:");
        //
        // lblDeviceCount
        //
        lblDeviceCount.setHorizontalAlignment(SwingConstants.RIGHT);
        lblDeviceCount.setForeground(new Color(0, 0, 255));
        lblDeviceCount.setText("# of Devices:");
        //
        // txtInput
        //
        txtInput.setForeground(new Color(0, 0, 255));
        txtInput.setSelectedTextColor(new Color(0, 0, 255));
        txtInput.setToolTipText("Enter Input");
        /*txtInput.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        txtInput_actionPerformed(e);
                    }
                });*/
        //
        // txtOutput
        //
        txtOutput.setForeground(new Color(0, 0, 255));
        txtOutput.setToolTipText("Enter Output");
        /*txtOutput.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        txtOutput_actionPerformed(e);
                    }
                });*/

        //
        // txtDeviceCount
        //
        txtDeviceCount.setForeground(new Color(0, 0, 255));
        txtDeviceCount.setToolTipText("Enter # of Devices");
        /*txtDeviceCount.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        txtDeviceCount_actionPerformed(e);
                    }
                });*/

        //
        // btnFind
        //
        btnFind.setBackground(new Color(204, 204, 204));
        btnFind.setForeground(new Color(0, 0, 255));
        btnFind.setText("Find Pathways!");
        /*btnFind.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        btnFind_actionPerformed(e);
                    }

                });*/
		btnFind.addActionListener(this);
        btnFind.setActionCommand("btnFind_actionPerformed");


        //
        //output partition
        //
        //ScrollPane scPathways = new ScrollPane(ScrollPane.SCROLLBARS_AS_NEEDED);
        txtareaPathways.setEditable(false);
        txtareaPathways.setText("\n");
        txtareaPathways.setForeground(new Color(0, 0, 255));
        txtareaPathways.setToolTipText("All possible pathways from selected input to selected output.");
        txtareaPathways.setSelectedTextColor(new Color(0, 255, 255));
        txtareaPathways.setFont(defaultFont);
        JScrollPane scTxtareaPathways = new JScrollPane(txtareaPathways);
        //scTxtareaPathways.add(txtareaPathways);
        //scTxtareaPathways.setSize(txtareaPathways.getWidth(), 60);
        
        //
        //list
        //
        //listPathways.setForeground(new Color(0, 0, 255));
        listPathways.setToolTipText("All possible pathways from selected input to selected output.");
        listPathways.setFont(defaultFont);
        listPathways.setSelectionBackground(new Color(147,226,75));
        listPathways.setSelectionForeground(new Color(0,0,0));
        //listPathways.addSelectionInterval(1,1);
        listPathways.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listPathways.addListSelectionListener(new ListSelectionListener(){
                public void valueChanged(ListSelectionEvent e) {
                    listPathways_actionPerformed(e);
                }
            }
        );
		
        JScrollPane scListPathways = new JScrollPane(listPathways);
        
        //
        // contentPane
        //
        //contentPane.setLayout(null);
        this.setLayout(null);
        //contentPane.setBorder(BorderFactory.createEtchedBorder());
        //contentPane.setBackground(new Color(204, 204, 204));
        this.setBackground(new Color(204, 204, 204));
        addComponent(this, lblInput, 5, 10, 66, 18);
        addComponent(this, lblOutput, 5, 47, 66, 18);
        addComponent(this, lblDeviceCount, 5, 84, 66, 18);
        addComponent(this, txtInput, 75, 10, 140, 22);
        addComponent(this, txtOutput, 75, 45, 140, 22);
        addComponent(this, txtDeviceCount, 75, 80, 140, 22);
        addComponent(this, btnFind, 72, 110, 120, 28);
        //addComponent(this, scTxtareaPathways, 50, 150, 400, 400);//TODO buna gerek kalmadï¿½. daha sonra bunu ve baï¿½lantï¿½larï¿½nï¿½ silersin.
        
		//addComponent(this, scPnlGraph, 230, 10, 550, 330);
        
		addComponent(this, scListPathways, 10, 350, 770, 210);
        
		//contentPane.setSize(100,100);
        //
        // login
        //
        //this.setTitle("M4BApplet: MINING FOR BIOBRICKS");
        this.setLocation(new Point(250, 100));
        this.setSize(new Dimension(800, 600));
        //this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //this.setResizable(false);
    }

    /** Add Component Without a Layout Manager (Absolute Positioning) */
    private void addComponent(Container container, Component c, int x, int y, int width, int height) {
        System.out.println("Component will be added");
		
		Component existingComp = findComponentAt(x, y);
		if(existingComp != null){
			System.out.println("Component found");
			container.remove(existingComp);
			System.out.println("Component removed");
		}else{
			System.out.println("Component NOT found");
		}
		
		c.setBounds(x, y, width, height);
        container.add(c);
        System.out.println("Component added");
    }


    private void txtInput_actionPerformed(ActionEvent e) {


    }

    private void txtOutput_actionPerformed(ActionEvent e) {

    }

    private void txtDeviceCount_actionPerformed(ActionEvent e) {

    }

    private void btnFind_actionPerformed() {//(ActionEvent e)
        System.out.println("\nbtnFind_actionPerformed(ActionEvent e) called.");
        String input = new String(txtInput.getText());
        String output = new String(txtOutput.getText());
        System.out.println("input: "+input);
        System.out.println("output: "+output);
				
        Integer deviceCount = 1;
        if(Utils.isInteger(txtDeviceCount.getText())){
            deviceCount = new Integer(txtDeviceCount.getText());
            if(deviceCount < 1){
                deviceCount = 1;
            }
        }
        
        if (input.equals("")){//TODO constitutive'ler için geçici olarak yapýlmýþ bir çözüm.
            input = "$";
        }

        if (input.equals("") || output.equals("")) // If output and input is empty > Do this >>>
        {
            btnFind.setEnabled(false);
            JLabel errorFields = new JLabel("<HTML><FONT COLOR = Blue>You must enter an input and output to get results.</FONT></HTML>");
            JOptionPane.showMessageDialog(null, errorFields);
            txtInput.setText("");
            txtOutput.setText("");
            btnFind.setEnabled(true);
            this.setVisible(true);
        } else {
            JLabel optionLabel = new JLabel();
            
            if (input.equals("$")){//TODO constitutive'ler için geçici olarak yapýlmýþ bir çözüm.
                optionLabel = 
                    new JLabel("<HTML><FONT COLOR = Blue>Pathway finding will start <BR>with</FONT><FONT COLOR = RED> <B>Constitutive Promoters</B></FONT> <FONT COLOR = Blue>as input <BR>and</FONT><FONT COLOR = RED> <B>" + 
                               output + "</B></FONT> <FONT COLOR = Blue>as output.<BR>Do you confirm?</FONT></HTML>");
            }else{
                optionLabel = 
                    new JLabel("<HTML><FONT COLOR = Blue>Pathway finding will start <BR>with</FONT><FONT COLOR = RED> <B>" + 
                               input + 
                               "</B></FONT> <FONT COLOR = Blue>as input <BR>and</FONT><FONT COLOR = RED> <B>" + 
                               output + 
                               "</B></FONT> <FONT COLOR = Blue>as output.<BR>Do you confirm?</FONT></HTML>");
            }
            
            int confirm = JOptionPane.showConfirmDialog(null, optionLabel);
            switch (confirm) { // Switch > Case
            case JOptionPane.YES_OPTION: // Attempt to Login user
                btnFind.setEnabled(false); // Set button enable to false to prevent 2 login attempts
                
                listPathways.setListData(new Object[1]);//empty list

                PathwayFinder pathwayFinder = new PathwayFinder();
                //String[] interactions = readFile(file);
                ////network = pathwayFinder.getNetwork(interactions);
                //network = pathwayFinder.getNetwork2(interactions);
				network = pathwayFinder.getNetwork3();
                //ArrayList<ArrayList<Part>> pathways = pathwayFinder.findAllPathways(network, input, output);
                //ArrayList<ArrayList<Part>> pathways = pathwayFinder.findAllPathways(network, input.toUpperCase(getLocale()), output.toUpperCase(getLocale()));
                ArrayList<ArrayList<Part>> pathways = pathwayFinder.findAllPathways(network,Utils.recoverSpelling(input.toUpperCase()), Utils.recoverSpelling(output.toUpperCase()), deviceCount);
                if(pathways != null){
                    if(pathways.size() == 0){
                        optionLabel = new JLabel("<HTML><FONT COLOR = RED><B>NO DEVICE!</B></FONT></HTML>");
                        JOptionPane.showMessageDialog(null, optionLabel);
                    }else{
                        optionLabel = new JLabel("<HTML><FONT COLOR = RED><B>"+pathways.size()+"</B></FONT><FONT COLOR = BLUE> device(s) found!</FONT></HTML>");
                        JOptionPane.showMessageDialog(null, optionLabel);
                        String[] pathList = getPathList(pathways);
                        listPathways.setListData(pathList);
                    }
                }else{
                    //TODO
                }
                
                btnFind.setEnabled(true);
                break;
            case JOptionPane.NO_OPTION: // No Case.(Go back. Set text to 0)
                btnFind.setEnabled(false);
                txtInput.setText("");
                txtOutput.setText("");
                btnFind.setEnabled(true);
                break;
            case JOptionPane.CANCEL_OPTION: // Cancel Case.(Go back. Set text to 0)
                btnFind.setEnabled(false);
                txtInput.setText("");
                txtOutput.setText("");
                btnFind.setEnabled(true);
                break;
            } // End Switch > Case
        }
    }
	
	private void listPathways_actionPerformed(ListSelectionEvent e){
        if (e.getValueIsAdjusting()) {//eï¿½er liste ï¿½zerinde geziniyorsa ve henï¿½z seï¿½im yapmadï¿½ysa. bu sayede iki kez seï¿½ilme engellenmiï¿½ oluyor. NE Gï¿½ZEL NE Gï¿½ZEL.
            return;
        }
		
		System.out.println("ROW CHANGED!!!!");
		
        String pathway = (String) listPathways.getSelectedValue();
        //JPanel pnlGraph = drawGraph(pathway);
        
        
        //drawGraph(pathway);
        
        if(pathway != null){
            GraphConstructor gc = new GraphConstructor();
            gc.drawGraph(pathway, network);
            //scPnlGraph = new JScrollPane(gc);
			addComponent(this, gc, 230, 10, 550, 330);
        }
        
        //scPnlGraph.add(pnlGraph);
        
        //addContentTo(scPnlGraph.getRootPane(), pnlGraph);
        //scPnlGraph.getRootPane().setContentPane(pnlGraph);
        
        //scPnlGraph = new JScrollPane(pnlGraph);
        //this.getContentPane().add(scPnlGraph, BorderLayout.CENTER);
        
        //System.out.println(pathway);
    }
    
    private String[] getPathList(ArrayList<ArrayList<Part>> pathways){
        int size = pathways.size();
        String[] pathList = new String[size];
        
        for (int i = 0; i < size; i++)  {
            ArrayList<Part> path = pathways.get(i);
            int pathLength = path.size();
            String strPath = "";
            for (int j = 0; j < pathLength; j++)  {
                strPath += path.get(j).partID + ">";
            }
            pathList[i] = strPath;
        }
        
        return pathList;
    }
    
    private String[] readFile(String file) {
        int rowCount = getRowCount(file);

        String[] interactions = new String[rowCount];

        try {
            FileInputStream fstream = 
                new FileInputStream(file); //LOCALPATH + file
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            int i = 0;
            while ((strLine = br.readLine()) != null) {
                strLine = 
                        strLine.trim(); //Creates a new String by trimming any leading or trailing whitespace from the current String.
                //System.out.println(strLine);
                int lineWidth = strLine.length();
                if (lineWidth > 0) { //TODO >1 de olabilir.
                    interactions[i] = strLine;
                    i++;
                }
            }
            in.close();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            System.exit(FILE_READ_ERROR);
        }

        return interactions;
    }
    
    private int getRowCount(String file) {
        int rowCount = 0;
        try {
            FileInputStream fstream = 
                new FileInputStream(file); //LOCALPATH + file
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            while ((strLine = br.readLine()) != null) {
                strLine = 
                        strLine.trim(); //Creates a new String by trimming any leading or trailing whitespace from the current String.
                int lineWidth = strLine.length();
                if (lineWidth > 0) { //TODO >1 de olabilir.
                    rowCount++;
                }
            }
            in.close();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            System.exit(FILE_READ_ERROR);
        }

        return rowCount;
    }
    
    
    
    private void drawGraph(String pathway){
        //JPanel pnlGraph = new JPanel();
        pnlGraph.setLayout(new BorderLayout());
        
        view = new Graph2DView();
        view.addViewMode(getDefaultEditMode());
        
        configureDefaultRealizers();
        
        createNodes();
        createEdges();
        
        //pnlGraph.add(view);
        pnlGraph.add(view,BorderLayout.CENTER);
        //pnlGraph.getLayout().addLayoutComponent("Graph",view);
        
        //return pnlGraph;
    }
    
    private EditMode getDefaultEditMode(){
        EditMode mode = new EditMode();
        
        mode.allowEdgeCreation(false);
        mode.allowNodeCreation(false);
        mode.allowBendCreation(false);
        
        return mode;
    }
    
    protected void configureDefaultRealizers() {
        Graph2D graph = view.getGraph2D();

        //change the looks of the default edge
        EdgeRealizer er = graph.getDefaultEdgeRealizer();
        //a standard (target) arrow
        er.setArrow(Arrow.STANDARD);

        //change the looks (and type) of the default node
        ShapeNodeRealizer snr = new ShapeNodeRealizer(ShapeNodeRealizer.ROUND_RECT);
        snr.setSize(80, 30);
        //snr.setFillColor(DemoDefaults.DEFAULT_NODE_COLOR);

        //use it as default node realizer
        graph.setDefaultNodeRealizer(snr);
    }
    
    private void createNodes(){
        Graph2D graph = view.getGraph2D();
        
        Node stateNode = graph.createNode();
        NodeRealizer nr = graph.getRealizer(stateNode);
        //nr.setLocation(100 + i * 100, 200);
        nr.setLocation(50, 50);
        nr.setLabelText("1");
        nr.setFillColor2(new Color(100,100,100));
        
        stateNode = graph.createNode();
        nr = graph.getRealizer(stateNode);
        //nr.setLocation(100 + i * 100, 200);
        nr.setLocation(100, 100);
        nr.setLabelText("2");
        nr.setFillColor2(new Color(200,200,200));
    }
    
    private void createEdges(){
        Graph2D graph = view.getGraph2D();
        graph.createEdge(graph.getNodeArray()[0],graph.getNodeArray()[1]);
    }
    
    private ShapeNodeRealizer getNodeShape(char state){//TODO bunun iï¿½i dï¿½zenlenecek. part tipine gï¿½re yapacan
        ShapeNodeRealizer snr = new ShapeNodeRealizer(ShapeNodeRealizer.ROUND_RECT);//DEFAULT SHAPE
        
        if(state == 'M'){
            snr = new ShapeNodeRealizer(ShapeNodeRealizer.RECT);
        }else if(state == 'D'){
            snr = new ShapeNodeRealizer(ShapeNodeRealizer.ELLIPSE);
        }else if(state == 'I'){
            snr = new ShapeNodeRealizer(ShapeNodeRealizer.DIAMOND);
        }
        snr.setSize(37, 37);
        
        return snr;
    }
    
    private final void addContentTo(final JRootPane rootPane, Container container) {
        rootPane.setContentPane(container);
    }
    
    
    
    private void printList(ArrayList<String> pathways){
        txtareaPathways.setText("");//ekranï¿½ temizle
        int size = pathways.size();
        for (int i = 0; i < size; i++)  {
            printLine(pathways.get(i));
        }
    }
    
    private void printLine(String line){
        txtareaPathways.append(line+"\n");
    }

    /*public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        JDialog.setDefaultLookAndFeelDecorated(true);
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception ex) {
            System.out.println("Failed loading L&F: ");
            System.out.println(ex);
        }
        new M4BApplet();
    }*/
    
    public void init(){
        new M4BApplet();
    }

    public void actionPerformed(ActionEvent e) {
        System.out.println("ALÖÖÖÖ");
        //System.out.println(e.getActionCommand());
        if (e.getActionCommand().equals("btnFind_actionPerformed")) {			
            btnFind_actionPerformed();
        }
    }
}
