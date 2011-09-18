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
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
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
import y.view.Graph2DSelectionListener;
import y.view.Graph2DSelectionEvent;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.imageio.ImageIO;
import java.io.File;
import java.awt.image.BufferedImage;
import java.io.IOException;

import java.awt.Image;
import java.awt.Graphics;

public class M4BApplet extends Applet implements ActionListener{
    private static int FILE_READ_ERROR = -2;
    private String file = "C:\\GOKHAN\\MSc2011\\iGEM\\algo_files\\input_files\\io5.txt"; //TODO bunu kullaniciya sectirmenin alemi yok.
                                                                                                //zaten bu daha sonra veritabanindan cekecek partlari.
    private Hashtable network;
	PathwayFinder pathwayFinder;
    // Variables declaration
    private JLabel lblInput;
    private JTextField txtInput;
	private JComboBox cmbInput;
    private JLabel lblOutput;
	private JTextField txtOutput;
	private JComboBox cmbOutput;
    private JLabel lblDeviceCount;
	private JTextField txtDeviceCount;
    private JButton btnFind;
    private JTextArea txtareaPathways;
    private JList listPathways;
	private JTextArea txtareaPartInfo;
	private JTextPane txtpanePartInfo;
	
	private JTextField txtFeedBack;
	private JButton btnFeedBack;
	
    Graph2DView view;
    JScrollPane scPnlGraph;
    JPanel pnlGraph;
	JScrollPane scTxtareaPartInfo;
    
	private Connection con = IIConnection.getIIConnection();
	
    //private JPanel contentPane;
    private Font defaultFont = new Font("Serif", Font.BOLD, 12);
    // End of variables declaration
    
    public M4BApplet() {
        super();
        create();
		this.setBackground(new Color(255, 128, 0));
		//this.setBackground(new Color(137, 156, 245));
		//this.setBackground(new Color(128, 255, 0));
        this.setVisible(true);
    }
    
    private void create() {
		pathwayFinder = new PathwayFinder();
		network = pathwayFinder.getNetwork3();
	
	
        lblInput = new JLabel();
        lblOutput = new JLabel();
        lblDeviceCount = new JLabel();
        txtInput = new JTextField();
		
		try{
			Statement stmt = con.createStatement();
			ResultSet set = stmt.executeQuery("SELECT DISTINCT(part1) AS part1 FROM interactions_wide WHERE type1 = 'I' ORDER BY part1");//AND part1 LIKE '%tetr%'
			ArrayList<String> allInputs = new ArrayList<String>();
			allInputs.add("");
			while(set.next()){
				allInputs.add(set.getString("part1"));
			}
			cmbInput = new JComboBox(allInputs.toArray());
		}catch(Exception e){
			e.printStackTrace();
		}
		
        txtOutput = new JTextField();
		
		try{
			Statement stmt = con.createStatement();
			ResultSet set = stmt.executeQuery("SELECT DISTINCT(part2) AS part2 FROM interactions_wide WHERE type2 = 'O' ORDER BY part2");//AND part1 LIKE '%tetr%'
			ArrayList<String> allOutputs = new ArrayList<String>();
			allOutputs.add("");
			while(set.next()){
				allOutputs.add(set.getString("part2"));
			}
			cmbOutput = new JComboBox(allOutputs.toArray());
		}catch(Exception e){
			e.printStackTrace();
		}
		
        txtDeviceCount = new JTextField();
        btnFind = new JButton();
		
		txtFeedBack = new JTextField();
        btnFeedBack = new JButton();
		
        txtareaPathways = new JTextArea();
		txtareaPartInfo = new JTextArea();
		txtpanePartInfo = new JTextPane();
		txtpanePartInfo.setContentType("text/html");
		txtpanePartInfo.setEditable(false);
		
        listPathways = new JList();
        /*JPanel abc = new JPanel();
        abc.setBackground(new Color(255, 0, 0));
        JLabel tttt = new JLabel();
        tttt.setHorizontalAlignment(SwingConstants.RIGHT);
        tttt.setForeground(new Color(0, 0, 255));
        tttt.setText("Input:");
        addComponent(abc, tttt,9000, 9000, 100, 50);*/
        
        pnlGraph = new JPanel();
        pnlGraph.setBackground(Color.white);
        scPnlGraph = new JScrollPane(pnlGraph);
        
        //contentPane = (JPanel)this.getContentPane();

        //
        // lblInput
        //
        lblInput.setHorizontalAlignment(SwingConstants.RIGHT);
        lblInput.setForeground(new Color(255, 255, 0));
        lblInput.setText("Input:");
        //
        // lblOutput
        //
        lblOutput.setHorizontalAlignment(SwingConstants.RIGHT);
        lblOutput.setForeground(new Color(255, 255, 0));
        lblOutput.setText("Output:");
        //
        // lblDeviceCount
        //
        lblDeviceCount.setHorizontalAlignment(SwingConstants.RIGHT);
        lblDeviceCount.setForeground(new Color(255, 255, 0));
        lblDeviceCount.setText("Max # of Devices:");
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
				
				
		cmbInput.setForeground(new Color(0, 0, 255));
        cmbInput.setToolTipText("Select Input");
        cmbInput.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        cmbInput_actionPerformed(e);
                    }
                });
        //
        // txtOutput
        //
        txtOutput.setForeground(new Color(0, 0, 255));
        txtOutput.setToolTipText("Enter an Output");
        /*txtOutput.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        txtOutput_actionPerformed(e);
                    }
                });*/

				
		cmbOutput.setForeground(new Color(0, 0, 255));
        cmbOutput.setToolTipText("Select an Output");
        cmbOutput.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        cmbOutput_actionPerformed(e);
                    }
                });
				
        //
        // txtDeviceCount
        //
        txtDeviceCount.setForeground(new Color(0, 0, 255));
        txtDeviceCount.setToolTipText("Enter maximum number of devices");
        /*txtDeviceCount.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        txtDeviceCount_actionPerformed(e);
                    }
                });*/

        //
        // btnFind
        //
        btnFind.setBackground(new Color(255, 255, 255));
        btnFind.setForeground(new Color(0, 0, 0));
        btnFind.setText("Find Composite Devices!");
        /*btnFind.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        btnFind_actionPerformed(e);
                    }

                });*/
		btnFind.addActionListener(this);
        btnFind.setActionCommand("btnFind_actionPerformed");

		
		

        txtFeedBack.setForeground(new Color(0, 0, 255));
        txtFeedBack.setToolTipText("Submit a feedback");
        /*txtFeedBack.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        txtFeedBack_actionPerformed(e);
                    }
                });*/
		
        btnFeedBack.setBackground(new Color(255, 255, 255));
        btnFeedBack.setForeground(new Color(255, 0, 0));
        btnFeedBack.setText("Send Feedback");
        /*btnFeedBack.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        btnFeedBack_actionPerformed(e);
                    }

                });*/
		btnFeedBack.addActionListener(this);
        btnFeedBack.setActionCommand("btnFeedBack_actionPerformed");

		

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
		
		
        txtareaPartInfo.setEditable(false);
        txtareaPartInfo.setText("\n");
		txtareaPartInfo.setBackground (Color.white);
        //txtareaPartInfo.setForeground(new Color(0, 0, 255));
        txtareaPartInfo.setToolTipText("All information about selected node.");
        txtareaPartInfo.setSelectedTextColor(new Color(0, 255, 255));
        txtareaPartInfo.setFont(defaultFont);
		txtareaPartInfo.setLineWrap(true);
        //scTxtareaPartInfo = new JScrollPane(txtareaPartInfo);
        scTxtareaPartInfo = new JScrollPane(txtpanePartInfo);
		
		//scTxtareaPartInfo.add(txtareaPartInfo);
        //scTxtareaPartInfo.setSize(txtareaPartInfo.getWidth(), 60);
        
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
        addComponent(this, lblInput, 5, 160, 66, 18);
        //addComponent(this, txtInput, 75, 160, 140, 22);
		addComponent(this, cmbInput, 75, 160, 140, 22);
        addComponent(this, lblOutput, 5, 197, 66, 18);
		//addComponent(this, txtOutput, 75, 195, 140, 22);
		addComponent(this, cmbOutput, 75, 195, 140, 22);
        addComponent(this, lblDeviceCount, 35, 234, 100, 18);
		addComponent(this, txtDeviceCount, 145, 230, 70, 22);
        addComponent(this, btnFind, 35, 260, 180, 28);
		placeM4BIcon();
        //addComponent(this, scTxtareaPathways, 50, 150, 400, 400);//TODO buna gerek kalmadi. daha sonra bunu ve baglantilarini silersin.
        addComponent(this, scTxtareaPartInfo, 790, 10, 390, 520);
		//addComponent(this, scPnlGraph, 230, 10, 550, 330);
		//addComponent(this, new JPanel(), 230, 10, 550, 330);
		addComponent(this, pnlGraph, 230, 10, 550, 330);
        
		addComponent(this, scListPathways, 10, 350, 770, 180);
		
		addComponent(this, txtFeedBack, 10, 538, 1050, 28);
		addComponent(this, btnFeedBack, 1070, 538, 110, 28);
        
		//contentPane.setSize(100,100);
        //
        // login
        //
        //this.setTitle("M4BApplet: MINING FOR BIOBRICKS");
        //this.setLocation(new Point(250, 100));
        //this.setSize(new Dimension(1200, 600));
        //this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //this.setResizable(false);
    }

    /** Add Component Without a Layout Manager (Absolute Positioning) */
    private void addComponent(Container container, Component c, int x, int y, int width, int height) {
        System.out.println("Component will be added");
		
		/*Component existingComp = findComponentAt(x, y);
		if(existingComp != null){
			System.out.println("Component found");
			container.remove(existingComp);
			System.out.println("Component removed");
			//container.repaint();
		}else{
			System.out.println("Component NOT found");
		}*/
		
		c.setBounds(x, y, width, height);
        container.add(c);
        System.out.println("Component added");
    }


    private void txtInput_actionPerformed(ActionEvent e) {


    }
	
	private void cmbInput_actionPerformed(ActionEvent e) {
		System.out.println("INPUT SECILDI");
    }
	
	private void cmbOutput_actionPerformed(ActionEvent e) {
		System.out.println("OUTPUT SECILDI");
    }

    private void txtOutput_actionPerformed(ActionEvent e) {

    }

    private void txtDeviceCount_actionPerformed(ActionEvent e) {

    }

    private void btnFind_actionPerformed() {//(ActionEvent e)
        System.out.println("\nbtnFind_actionPerformed(ActionEvent e) called.");
        /*String input = new String(txtInput.getText());
        String output = new String(txtOutput.getText());*/
		String input = (String) cmbInput.getSelectedItem();
        String output = (String) cmbOutput.getSelectedItem();
		
        System.out.println("input: "+input);
        System.out.println("output: "+output);
				
        Integer deviceCount = 0;
        if(Utils.isInteger(txtDeviceCount.getText())){
            deviceCount = new Integer(txtDeviceCount.getText());
            /*if(deviceCount < 1){
                deviceCount = 1;
            }*/
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
                    new JLabel("<HTML><FONT COLOR = Blue>Composite device searching will start <BR>with</FONT><FONT COLOR = RED> <B>Constitutive Promoters</B></FONT> <FONT COLOR = Blue>as input <BR>and</FONT><FONT COLOR = RED> <B>" + 
                               output + "</B></FONT> <FONT COLOR = Blue>as output.<BR>Do you confirm?</FONT></HTML>");
            }else{
                optionLabel = 
                    new JLabel("<HTML><FONT COLOR = Blue>Composite device searching will start <BR>with</FONT><FONT COLOR = RED> <B>" + 
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

                //PathwayFinder pathwayFinder = new PathwayFinder();
                //String[] interactions = readFile(file);
                ////network = pathwayFinder.getNetwork(interactions);
                //network = pathwayFinder.getNetwork2(interactions);
				//network = pathwayFinder.getNetwork3();
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
	
	private void btnFeedBack_actionPerformed() {//(ActionEvent e)
		String feedback = new String(txtFeedBack.getText());
		insertFeedBack(feedback);
		JLabel optionLabel = new JLabel();
		optionLabel = new JLabel("<HTML><FONT COLOR = BLUE><B>THANKS!</B></FONT></HTML>");
        JOptionPane.showMessageDialog(null, optionLabel);
		txtFeedBack.setText("");
	}
	
	private void listPathways_actionPerformed(ListSelectionEvent e){
        if (e.getValueIsAdjusting()) {//eger liste uzerinde geziniyorsa ve henuz secim yapmadiysa. bu sayede iki kez secilme engellenmis oluyor. NE GUZEL NE GUZEL.
            return;
        }
		
		System.out.println("ROW CHANGED!!!!");
		
        String pathway = (String) listPathways.getSelectedValue();
        
        if(pathway != null){
            GraphConstructor gc = new GraphConstructor();

			gc.drawGraph(pathway, network);
			
			
			Graph2D graph = gc.getGraphObject();
			graph.addGraph2DSelectionListener(new Graph2DSelectionListener(){
			  public void onGraph2DSelectionEvent(Graph2DSelectionEvent e) {
				graphSelection_actionPerformed(e);
			  }
			});
			
            //scPnlGraph = new JScrollPane(gc);
			//addComponent(this, gc, 230, 10, 550, 330);
			
			pnlGraph.removeAll();
			Graph2DView view = gc.getGraphViewObject();
			view.setBounds(0, 0, 550, 330);
			pnlGraph.add(view);
			
            validate();
			//gc.repaint();
			//validate();
        }
        
        //scPnlGraph.add(pnlGraph);
        
        //addContentTo(scPnlGraph.getRootPane(), pnlGraph);
        //scPnlGraph.getRootPane().setContentPane(pnlGraph);
        
        //scPnlGraph = new JScrollPane(pnlGraph);
        //this.getContentPane().add(scPnlGraph, BorderLayout.CENTER);
        
        //System.out.println(pathway);
    }
	
	private void graphSelection_actionPerformed(Graph2DSelectionEvent e){
		//printPartInfo("B0015");
		if(e.isNodeSelection()){//
			Graph2D graph = e.getGraph2D();
			/*if(graph.isSelectionSingleton()){
			}*/
			Node selection = (Node) e.getSubject();
			String part_name = graph.getLabelText(selection);
			System.out.println("PART_NAME: "+part_name);
			//M4BApplet.txtareaPartInfo.setText("part_name: "+part_name+"\n");//STATIC YAPMAYA MECBUR KALDIM	
			printPartInfo(part_name);
					
			/*validate();
			txtareaPartInfo.repaint();
			validate();*/
		
		}
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
            FileInputStream fstream = new FileInputStream(file); //LOCALPATH + file
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
	
	private void printPartInfo(String partID){
		//System.out.println(partID);
		String partInfo = getPartInfo(partID);
		System.out.println(partInfo);
		//txtareaPartInfo.setText(partInfo);
		txtpanePartInfo.setText(partInfo);
		
		//txtareaPartInfo.update(txtareaPartInfo.getGraphics());
		/*txtareaPartInfo.invalidate();
		txtareaPartInfo.validate();
		txtareaPartInfo.repaint();*/
	   
		//scTxtareaPartInfo = new JScrollPane(txtareaPartInfo);
        //scTxtareaPartInfo.add(txtareaPartInfo);
	}
	
	private void insertFeedBack(String comments){
		try{
			Statement stmt = con.createStatement();
			stmt.executeUpdate("INSERT INTO feedback (comments, submit_date) values ('"+comments+"', SYSDATE())");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private String getPartInfo(String partID){
		String partInfo = "";
		
		try{
			Statement stmt = con.createStatement();
			ResultSet set = stmt.executeQuery("SELECT * FROM main_part_table WHERE part_short_name = '"+partID+"'");
			while(set.next()){
				//allInputs.add(set.getString("part1"));
				partInfo += "<HTML>";
				partInfo += "<b>part_name: </b>"+set.getString("part_name")+" <BR>";
				partInfo += "<b>part_short_name: </b>"+set.getString("part_short_name")+" <BR>";
				partInfo += "<b>part_nickname: </b>"+set.getString("part_nickname")+"<BR>";
				partInfo += "<b>part_short_desc: </b>"+set.getString("part_short_desc")+" <BR>";
				partInfo += "<b>part_type: </b>"+set.getString("part_type")+" <BR>";
				partInfo += "<b>part_status: </b>"+set.getString("part_status")+" <BR>";
				partInfo += "<b>part_results: </b>"+set.getString("part_results")+"<BR>";
				partInfo += "<b>part_rating: </b>"+set.getString("part_rating")+"<BR>";
				//partInfo += "<b>part_url: </b>"+set.getString("part_url")+"<BR>";
				partInfo += "<b>part_url: </b><a href=\""+set.getString("part_url")+"\">"+set.getString("part_url")+"</a><BR>";
				partInfo += "<b>part_entered: </b>"+set.getString("part_entered")+"<BR>";
				partInfo += "<b>part_author: </b>"+set.getString("part_author")+"<BR>";
				partInfo += "<b>best_quality: </b>"+set.getString("best_quality")+"<BR>";
				partInfo += "<b>seq_data: </b>"+set.getString("seq_data")+"<BR>";
				partInfo += "-----------------------------------------------------<BR>";
				partInfo += "</HTML>";
				
				
				/*txtareaPartInfo.append(set.getString("part_name")+"\n");
				txtareaPartInfo.append(set.getString("part_short_name")+"\n");
				txtareaPartInfo.append(set.getString("part_short_desc")+"\n");
				txtareaPartInfo.append(set.getString("part_type")+"\n");
				txtareaPartInfo.append(set.getString("part_status")+"\n");
				txtareaPartInfo.append(set.getString("part_results")+"\n");
				txtareaPartInfo.append(set.getString("part_rating")+"\n");
				txtareaPartInfo.append(set.getString("best_quality")+"\n");
				txtareaPartInfo.append(set.getString("seq_data")+"\n");
				System.out.println(set.getString("seq_data"));
				txtareaPartInfo.append("-------------------------------------\n");*/
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return partInfo;
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
    
	Image background;//TODO daha sonra
    public void init(){
		//background = getImage(getCodeBase(),"resource/Beautiful-Background.jpg");
        new M4BApplet();
		
    }
	
	/*public void paint(Graphics g)
	  {
		 super.paint(g);
		 g.drawImage(background,0,0,this);
	  } */

    public void actionPerformed(ActionEvent e) {
        System.out.println("ALOOOO");
        //System.out.println(e.getActionCommand());
        if (e.getActionCommand().equals("btnFind_actionPerformed")) {			
            btnFind_actionPerformed();
        }else if (e.getActionCommand().equals("btnFeedBack_actionPerformed")) {			
            btnFeedBack_actionPerformed();
        }
		
    }
	
	private void placeM4BIcon(){
		try{
			//BufferedImage myPicture = ImageIO.read(new File("resource/m4b.png"));
			BufferedImage myPicture = ImageIO.read(getClass().getResource("resource/m4b_small.PNG"));
			//BufferedImage myPicture = ImageIO.read(getClass().getResource("resource/fenerbahce1_small.jpg"));
			JLabel picLabel = new JLabel(new ImageIcon( myPicture ));
			picLabel.setBounds(25, 25, 180, 93);
			//picLabel.setBounds(70, 25, 107, 93);
			this.add(picLabel);
		} catch (IOException ex) {
			// handle exception...
			ex.printStackTrace();
		}

	}
}
