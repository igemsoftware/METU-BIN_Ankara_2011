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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.FileWriter;

import java.util.ArrayList;
import java.util.Hashtable;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.DefaultListModel;
import javax.swing.ListModel;

import y.base.Node;

import y.layout.BufferedLayouter;
import y.layout.random.RandomLayouter;
import y.layout.circular.CircularLayouter;
import y.layout.tree.ARTreeLayouter;
import y.layout.tree.BalloonLayouter;
import y.layout.orthogonal.CompactOrthogonalLayouter;
import y.layout.orthogonal.DirectedOrthogonalLayouter;
import y.layout.tree.GenericTreeLayouter;

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
	private static String outFileName = "C:\\CompositeDevices.txt";
    private static boolean firstCall = true;
    private String file = "C:\\GOKHAN\\MSc2011\\iGEM\\algo_files\\input_files\\io5.txt"; //TODO bunu kullaniciya sectirmenin alemi yok.
                                                                                                //zaten bu daha sonra veritabanindan cekecek partlari.
	private PathwayFinder pathwayFinder;
	private Hashtable network;
    // Variables declaration
	private JLabel lblRowCount;
	private JLabel lblLoading;
    private JProgressBar progressBar;
	private JLabel lblInput;
    private JLabel lblOutput;
	private JTextField txtInput;
	private JTextField txtOutput;
	private JComboBox cmbInput;
	private JComboBox cmbOutput;
    private JList listInput;
	private JList listOutput;
	private JLabel lblDeviceCount;
	private JTextField txtInputSearch;
	private JTextField txtDeviceCount;
	private JButton btnFind;
    private JList listPathways;
	private JTextArea txtareaPartInfo;
	private JTextPane txtpanePartInfo;
	
	private JTextField txtFeedBack;
	private JButton btnFeedBack;
	
	private JButton btnPrint;
	
    Graph2DView view;
    JScrollPane scPnlGraph;
    JPanel pnlGraph;
	JScrollPane scTxtareaPartInfo;
    
	private Connection con = IIConnection.getIIConnection();
	private Statement stmt;
	
    //private JPanel contentPane;
    private Font defaultFont = new Font("Serif", Font.BOLD, 12);
    // End of variables declaration
    
    public M4BApplet() {
        super();
		
		try {
            stmt = con.createStatement();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
        }
		
        create();
		this.setBackground(new Color(128, 128, 128));//255, 128, 0
		//this.setBackground(new Color(137, 156, 245));
		//this.setBackground(new Color(128, 255, 0));
        this.setVisible(true);
    }
    
    private void create() {
		pathwayFinder = new PathwayFinder();
		network = pathwayFinder.getNetwork3();
		
		txtInputSearch = new JTextField();
		
		txtDeviceCount = new JTextField();
        btnFind = new JButton();
		btnPrint = new JButton();
		
		lblRowCount = new JLabel();
		lblLoading = new JLabel();
        progressBar = new JProgressBar(JProgressBar.HORIZONTAL, 0, 100);
		progressBar.setVisible(false);
        lblInput = new JLabel();
        lblOutput = new JLabel();
        lblDeviceCount = new JLabel();
        txtInput = new JTextField();
		
		/*ArrayList<String> allInputs = new ArrayList<String>();
		try{
			ResultSet set = stmt.executeQuery("SELECT DISTINCT(part1) AS part1 FROM interactions_wide WHERE type1 = 'I' ORDER BY part1");//AND part1 LIKE '%tetr%'
			
			allInputs.add("");
			while(set.next()){
				allInputs.add(set.getString("part1"));
			}
			cmbInput = new JComboBox(allInputs.toArray());
		}catch(Exception e){
			e.printStackTrace();
		}*/
		cmbInput = new JComboBox();
		cmbOutput = new JComboBox();
		
        txtOutput = new JTextField();
		
		/*ArrayList<String> allOutputs = new ArrayList<String>();
		try{
			ResultSet set = stmt.executeQuery("SELECT DISTINCT(part2) AS part2 FROM interactions_wide WHERE type2 = 'O' ORDER BY part2");//AND part2 LIKE '%tetr%'
			
			allOutputs.add("");
			while(set.next()){
				allOutputs.add(set.getString("part2"));
			}
			cmbOutput = new JComboBox(allOutputs.toArray());
		}catch(Exception e){
			e.printStackTrace();
		}*/
		
		//Object[] inputList = allInputs.toArray();
		Object[] inputList = getInputList("");
		//Object[] outputList = allOutputs.toArray();
		
		txtFeedBack = new JTextField();
        btnFeedBack = new JButton();
		
		txtareaPartInfo = new JTextArea();
		txtpanePartInfo = new JTextPane();
		txtpanePartInfo.setContentType("text/html");
		txtpanePartInfo.setEditable(false);
		
        listPathways = new JList();
		listInput = new JList();
		listOutput = new JList();
		
        /*JPanel abc = new JPanel();
        abc.setBackground(new Color(255, 0, 0));
        JLabel tttt = new JLabel();
        tttt.setHorizontalAlignment(SwingConstants.RIGHT);
        tttt.setForeground(new Color(0, 0, 255));
        tttt.setText("Input:");
        addComponent(abc, tttt,9000, 9000, 100, 50);*/
        
        pnlGraph = new JPanel();
        pnlGraph.setBackground(Color.white);
        //scPnlGraph = new JScrollPane(pnlGraph);
        scPnlGraph = new JScrollPane();
		scPnlGraph.setBackground(Color.white);
		
        
        //contentPane = (JPanel)this.getContentPane();

        lblRowCount.setHorizontalAlignment(SwingConstants.RIGHT);
        lblRowCount.setForeground(new Color(255, 255, 0));
        lblRowCount.setText("");
		
		lblLoading.setHorizontalAlignment(SwingConstants.LEFT);
        lblLoading.setForeground(new Color(255, 255, 0));
        lblLoading.setText("");
		
        lblInput.setHorizontalAlignment(SwingConstants.RIGHT);
        lblInput.setForeground(new Color(255, 255, 0));
        lblInput.setText("Input:");

        lblOutput.setHorizontalAlignment(SwingConstants.RIGHT);
        lblOutput.setForeground(new Color(255, 255, 0));
        lblOutput.setText("Output:");

        lblDeviceCount.setHorizontalAlignment(SwingConstants.RIGHT);
        lblDeviceCount.setForeground(new Color(255, 255, 0));
        lblDeviceCount.setText("Max # of Devices:");

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
			
        txtInputSearch.setForeground(new Color(0, 0, 255));
        txtInputSearch.setSelectedTextColor(new Color(0, 0, 255));
        txtInputSearch.setToolTipText("Enter Input");
        txtInputSearch.addKeyListener(new KeyAdapter() {
                    public void keyReleased(KeyEvent e) {
                        txtInputSearch_actionPerformed();
                    }
					
					public void keyPressed(KeyEvent e) {
						
					}
					
					public void keyTyped(KeyEvent e) {
						
					}
                });
		//txtInputSearch.addKeyListener(this);
			
        //
        // txtDeviceCount
        //
        txtDeviceCount.setForeground(new Color(0, 0, 255));
        txtDeviceCount.setToolTipText("Enter maximum number of devices");
        txtDeviceCount.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				txtDeviceCount_actionPerformed();
			}
			
			public void keyPressed(KeyEvent e) {
				
			}
			
			public void keyTyped(KeyEvent e) {
				
			}
		});
		//txtDeviceCount.addKeyListener(this);

        //
        // btnFind
        //
        btnFind.setBackground(new Color(255, 255, 255));
        btnFind.setForeground(new Color(0, 0, 0));
        btnFind.setText("Find!");
		btnFind.setToolTipText("Find Composite Devices!");
        /*btnFind.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        btnFind_actionPerformed(e);
                    }

                });*/
		btnFind.addActionListener(this);
        btnFind.setActionCommand("btnFind_actionPerformed");

		btnPrint.setBackground(new Color(255, 255, 255));
        btnPrint.setForeground(new Color(0, 0, 0));
        btnPrint.setText("Print All Results");
		btnPrint.setToolTipText("Print all results to text file.");
        /*btnPrint.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        btnPrint_actionPerformed(e);
                    }

                });*/
		btnPrint.addActionListener(this);
        btnPrint.setActionCommand("btnPrint_actionPerformed");
		

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
        listPathways.setToolTipText("All possible composite devices from selected input to selected output.");
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
        
		
		listInput.setToolTipText("All available input parts.");
        listInput.setFont(defaultFont);
        listInput.setSelectionBackground(new Color(147,226,75));
        listInput.setSelectionForeground(new Color(0,0,0));
        //listInput.addSelectionInterval(1,1);
        listInput.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listInput.addListSelectionListener(new ListSelectionListener(){
                public void valueChanged(ListSelectionEvent e) {
                    listInput_actionPerformed(e);
                }
            }
        );
        JScrollPane scListInput = new JScrollPane(listInput);
		listInput.setListData(inputList);
		listInput.setSelectedIndex(0);
		
		listOutput.setToolTipText("All available output parts.");
        listOutput.setFont(defaultFont);
        listOutput.setSelectionBackground(new Color(147,226,75));
        listOutput.setSelectionForeground(new Color(0,0,0));
        //listOutput.addSelectionInterval(1,1);
        listOutput.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listOutput.addListSelectionListener(new ListSelectionListener(){
                public void valueChanged(ListSelectionEvent e) {
                    listOutput_actionPerformed(e);
                }
            }
        );
        JScrollPane scListOutput = new JScrollPane(listOutput);
		//listOutput.setListData(outputList);
		//listOutput.setSelectedIndex(0);
		
        //
        // contentPane
        //
        //contentPane.setLayout(null);
        this.setLayout(null);
        //contentPane.setBorder(BorderFactory.createEtchedBorder());
        //contentPane.setBackground(new Color(204, 204, 204));
        this.setBackground(new Color(204, 204, 204));
		
		
		//placeM4BIcon();
		
        
		/*******addComponent(this, cmbInput, 75, 160, 140, 22);
		addComponent(this, cmbOutput, 75, 195, 140, 22);*/
		
		////addComponent(this, btnFind, 230, 100, 180, 28);//35, 260, 180, 28
		
		
		/*addComponent(this, lblInput, 5, 130, 38, 18);
		addComponent(this, txtInputSearch, 45, 130, 160, 28);
        addComponent(this, lblDeviceCount, 240, 134, 100, 18);
		addComponent(this, txtDeviceCount, 340, 130, 70, 28);//145, 230, 70, 22
        
		addComponent(this, scPnlGraph, 425, 10, 755, 320);//415, 10, 405, 320
		////////addComponent(this, new JPanel(), 230, 10, 550, 330);
		//////addComponent(this, pnlGraph, 415, 10, 405, 320);
        
		addComponent(this, scListInput, 10, 160, 195, 166);//10, 160, 400, 83
		addComponent(this, scListOutput, 215, 160, 195, 166);//10, 246, 400, 84
		addComponent(this, lblRowCount, 620, 330, 200, 28);
		addComponent(this, scListPathways, 10, 350, 810, 180);
		
		addComponent(this, scTxtareaPartInfo, 830, 350, 350, 180);//830, 10, 350, 520
		
		addComponent(this, txtFeedBack, 10, 538, 1030, 28);
		addComponent(this, btnFeedBack, 1050, 538, 130, 28);*/
		
		
		
		
		
		/*addComponent(this, lblInput, 5, 10, 40, 20);//Done
		addComponent(this, txtInputSearch, 10, 35, 175, 25);//Done
		addComponent(this, scListInput, 10, 55, 175, 177);//10, 160, 400, 83//Done
		addComponent(this, lblOutput, 190, 10, 50, 20);
		addComponent(this, scListOutput, 195, 35, 175, 200);//10, 246, 400, 84//Done
        addComponent(this, lblDeviceCount, 10, 245, 100, 25);//Done
		addComponent(this, txtDeviceCount, 120, 245, 50, 25);//145, 230, 70, 22//Done
		//addComponent(this, btnFind, 280, 245, 90, 25);//35, 260, 180, 28//Done
		addComponent(this, scPnlGraph, 380, 10, 590, 310);//415, 10, 405, 320//Done
		addComponent(this, scListPathways, 10, 330, 645, 310);//Done
		addComponent(this, lblRowCount, 10, 645, 200, 25);//kac sonuc var gösteren//Done
		addComponent(this, btnPrint, 515, 650, 150, 25);//35, 260, 180, 28//Done
		addComponent(this, scTxtareaPartInfo, 665, 330, 300, 310);//830, 10, 350, 520//Done*/
		
		
		addComponent(this, btnFind, 195, 245, 175, 25);
        addComponent(this, lblDeviceCount, 10, 245, 100, 25);
		addComponent(this, txtDeviceCount, 120, 245, 50, 25);
		addComponent(this, scPnlGraph, 380, 10, 585, 260);
		addComponent(this, lblInput, 5, 10, 40, 20);
		addComponent(this, txtInputSearch, 10, 35, 175, 25);
		addComponent(this, scListInput, 10, 65, 175, 175);
		addComponent(this, lblOutput, 190, 10, 50, 20);
		addComponent(this, scListOutput, 195, 35, 175, 205);
		addComponent(this, lblRowCount, 5, 605, 200, 20);
		//addComponent(this, lblLoading, 255, 605, 400, 20); //TODO ikisi de iptal
        //addComponent(this, progressBar, 255, 605, 400, 30);
		addComponent(this, scListPathways, 10, 280, 700, 320);
		addComponent(this, btnPrint, 720, 280, 245, 25);
		addComponent(this, scTxtareaPartInfo, 720, 310, 245, 290);//720, 280, 245, 290
		
		
		btnPrint.setEnabled(false);
		
		//txtInputSearch.requestFocus();
		
		
        
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
        //System.out.println("Component will be added");
		
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
        //System.out.println("Component added");
    }


    private void txtInput_actionPerformed(ActionEvent e) {


    }
	
	private void cmbInput_actionPerformed(ActionEvent e) {
		//System.out.println("INPUT SECILDI");
    }
	
	private void cmbOutput_actionPerformed(ActionEvent e) {
		//System.out.println("OUTPUT SECILDI");
    }

    private void txtOutput_actionPerformed(ActionEvent e) {

    }
	
    private void btnPrint_actionPerformed() {
        firstCall = true;
        //outFileName = outFileName.substring(0,outFileName.indexOf(".")) + " - " + getDateTime() + outFileName.substring(outFileName.indexOf("."), outFileName.length());
        outFileName = listInput.getSelectedValue() + "_" + listOutput.getSelectedValue() + "_" + getDateTime() + ".txt";
        
        File selectedFile = new File(outFileName);
        JFileChooser jfc = new JFileChooser();
        jfc.setSelectedFile(selectedFile);
        int kullaniciSecimi = jfc.showSaveDialog(null);//this
        
        if (kullaniciSecimi == JFileChooser.APPROVE_OPTION) {
            selectedFile = jfc.getSelectedFile();
            /*System.out.println(selectedFile);
            System.out.println(selectedFile.getAbsolutePath());*/
            outFileName = selectedFile.getAbsolutePath();
            
            ListModel model = listPathways.getModel();
            for (int i = 0; i < model.getSize(); i++) {
                //System.out.println(model.getElementAt(i));
                writeFile((String)model.getElementAt(i));
            }
            JLabel optionLabel = new JLabel("<HTML><FONT COLOR = BLUE>Results saved as following:</FONT> <BR> <FONT COLOR = RED>" + outFileName + "</FONT></HTML>");
            JOptionPane.showMessageDialog(null, optionLabel);
        }
    }

    private String getDateTime() {
        DateFormat dateFormat = new SimpleDateFormat("yyMMddHHmmss");//yyyy-MM-dd HH-mm-ss
        Date date = new Date();
        return dateFormat.format(date);
    }

    private void btnFind_actionPerformed() {//(ActionEvent e)
        //System.out.println("\nbtnFind_actionPerformed(ActionEvent e) called.");
        
		/*String input = (String) cmbInput.getSelectedItem();
        String output = (String) cmbOutput.getSelectedItem();*/
		String input = (String) listInput.getSelectedValue();
        String output = (String) listOutput.getSelectedValue();
		
        /*System.out.println("input: "+input);
        System.out.println("output: "+output);*/
				
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
            
            /*int confirm = JOptionPane.showConfirmDialog(null, optionLabel);
            switch (confirm) { // Switch > Case
				case JOptionPane.YES_OPTION: // Attempt to Login user*/
					btnFind.setEnabled(false); // Set button enable to false to prevent 2 login attempts
					
					//listPathways.setListData(new Object[1]);//empty list
					listPathways.setModel(new DefaultListModel());
					btnPrint.setEnabled(false);
					
					ArrayList<ArrayList<Part>> pathways = pathwayFinder.findAllPathways(network,Utils.recoverSpelling(input.toUpperCase()), Utils.recoverSpelling(output.toUpperCase()), deviceCount);
					if(pathways != null){
						if(pathways.size() == 0){
							optionLabel = new JLabel("<HTML><FONT COLOR = RED><B>NO DEVICE!</B></FONT></HTML>");
							//JOptionPane.showMessageDialog(null, optionLabel);
							lblRowCount.setText("No device found!");
							scPnlGraph.removeAll();
							validate();
							scPnlGraph.repaint();
							validate();
						}else{
							//optionLabel = new JLabel("<HTML><FONT COLOR = RED><B>"+pathways.size()+"</B></FONT><FONT COLOR = BLUE> device(s) found!</FONT></HTML>");
							lblRowCount.setText(pathways.size()+" composite device(s) found!");
							//JOptionPane.showMessageDialog(null, optionLabel);
							String[] pathList = getPathList(pathways);
							listPathways.setListData(pathList);
							btnPrint.setEnabled(true);
						}
					}else{
						//TODO
					}
					
					btnFind.setEnabled(true);
				/*	break;
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
			} // End Switch > Case*/
        }
    }
	
	private void btnFind_actionPerformed_ESKI() {//(ActionEvent e)
        //System.out.println("\nbtnFind_actionPerformed(ActionEvent e) called.");
        
		/*String input = (String) cmbInput.getSelectedItem();
        String output = (String) cmbOutput.getSelectedItem();*/
		String input = (String) listInput.getSelectedValue();
        String output = (String) listOutput.getSelectedValue();
		
        /*System.out.println("input: "+input);
        System.out.println("output: "+output);*/
				
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
				btnPrint.setEnabled(false);

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
						btnPrint.setEnabled(true);
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
		
		//System.out.println("ROW CHANGED!!!!");
		
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
			
			scPnlGraph.removeAll();
			/*new BufferedLayouter(new CompactOrthogonalLayouter()).doLayout(graph);
			graph.updateViews();*/
			addComponent(scPnlGraph, gc, 0, 0, 585, 260);
			
            validate();
			scPnlGraph.repaint();
			validate();
        }
    }
	
	private void txtInputSearch_actionPerformed(){
		//System.out.println(txtInputSearch.getText());
		String deviceCount = txtDeviceCount.getText();
		String inputText = txtInputSearch.getText();
		Object[] inputList = getInputList(inputText);
		
		
		if(inputList != null){
			listInput.setListData(inputList);
			listInput.setSelectedIndex(0);
		}else{
			/*listInput.setListData(new Object[0]);
			listOutput.setListData(new Object[0]);
			listPathways.setListData(new Object[0]);*/
			listInput.setModel(new DefaultListModel());
			listOutput.setModel(new DefaultListModel());
			listPathways.setModel(new DefaultListModel());
			btnPrint.setEnabled(false);
		}
	}
	
	private void listInput_actionPerformed(ListSelectionEvent e){
		if (e.getValueIsAdjusting()) {//eger liste uzerinde geziniyorsa ve henuz secim yapmadiysa. bu sayede iki kez secilme engellenmis oluyor. NE GUZEL NE GUZEL.
			return;
		}
		
		//System.out.println((String) listInput.getSelectedValue());
		Object[] outputList = getOutputList((String) listInput.getSelectedValue());
		if(outputList != null){
			listOutput.setListData(outputList);
			listOutput.setSelectedIndex(0);
		}else{
			listOutput.setModel(new DefaultListModel());
			listPathways.setModel(new DefaultListModel());
			btnPrint.setEnabled(false);
		}
	}
	
	private void listOutput_actionPerformed(ListSelectionEvent e) {
        if (e.getValueIsAdjusting()) { //eger liste uzerinde geziniyorsa ve henuz secim yapmadiysa. bu sayede iki kez secilme engellenmis oluyor. NE GUZEL NE GUZEL.
            return;
        }

        if (listInput.getSelectedValue() != null && listOutput.getSelectedValue() != null) {
            //TODO bunlar simdilik kapatildi
            /*btnFind_actionPerformed();
            listPathways.setSelectedIndex(0);*/
        } else {
            scPnlGraph.removeAll();
            validate();
            scPnlGraph.repaint();
            validate();
        }

    }

    private void txtDeviceCount_actionPerformed() {
        if (listInput.getSelectedValue() != null && listOutput.getSelectedValue() != null) {
            //TODO bunlar simdilik kapatildi
            /*btnFind_actionPerformed();
            listPathways.setSelectedIndex(0);*/
        } else {
            scPnlGraph.removeAll();
            validate();
            scPnlGraph.repaint();
            validate();
        }
    }
	
	private void graphSelection_actionPerformed(Graph2DSelectionEvent e){
		//printPartInfo("B0015");
		if(e.isNodeSelection()){//
			Graph2D graph = e.getGraph2D();
			/*if(graph.isSelectionSingleton()){
			}*/
			Node selection = (Node) e.getSubject();
			String part_name = graph.getLabelText(selection);
			//System.out.println("PART_NAME: "+part_name);
			//M4BApplet.txtareaPartInfo.setText("part_name: "+part_name+"\n");//STATIC YAPMAYA MECBUR KALDIM	
			printPartInfo(part_name);
					
			/*validate();
			txtareaPartInfo.repaint();
			validate();*/
		
		}
	}
    
    private Object[] getInputList(String pattern){
		/*String query = "SELECT DISTINCT(part1) AS part1 FROM interactions_wide WHERE type1 = 'I'";		
		if(pattern != ""){
			query += " AND part1 LIKE '%"+pattern+"%'";
		}
		query += " ORDER BY part1";*/
		
		String query = "SELECT DISTINCT(input) as input FROM input_output";		
		if(pattern != ""){
			query += " WHERE input LIKE '%"+pattern+"%'";
		}
		query += " ORDER BY input";
		
		//System.out.println(query);
		
		ArrayList<String> allInputs = new ArrayList<String>();
		try{
			ResultSet set = stmt.executeQuery(query);
			
			//allInputs.add("");
			while(set.next()){
				//allInputs.add(set.getString("part1"));
				allInputs.add(set.getString("input"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		Object[] inputList = null;
		if(allInputs.size() > 0){
			inputList = allInputs.toArray();
		}
		
		return inputList;
	}
	
	private Object[] getOutputList(String part_id){
		String query = "SELECT output FROM input_output where input = '"+part_id+"' order by output";
		ArrayList<String> allOutputs = new ArrayList<String>();
		try{
			ResultSet set = stmt.executeQuery(query);
			
			//allOutputs.add("");
			while(set.next()){
				allOutputs.add(set.getString("output"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		Object[] outputList = null;
		if(allOutputs.size() > 0){
			outputList = allOutputs.toArray();
		}
		
		return outputList;
	}
	
	private String[] getPathList(ArrayList<ArrayList<Part>> pathways) {
        progressBar.setVisible(true);
        int size = pathways.size();
        String[] pathList = new String[size];
        double[] pathScores = new double[size];
        double maxScore = 0.0;
        
        String loading = "Loading: ";
        for (int i = 0; i < size; i++) {
            double score = 1;
            ArrayList<Part> path = pathways.get(i);
            int pathLength = path.size();
            String strPath = "";
            for (int j = 0; j < pathLength; j++) {
                strPath += path.get(j).partID + ">";
                if(j < pathLength-1){
                    //score *= getEdgeScore("BBa_"+path.get(j).partID, "BBa_"+path.get(j+1).partID));
                    //score += Math.log(getEdgeScore("BBa_"+path.get(j).partID, "BBa_"+path.get(j+1).partID));
                    score += getEdgeScore("BBa_"+path.get(j).partID, "BBa_"+path.get(j+1).partID);
                }
            }
            
            /*loading += "|";
            lblLoading.setText(loading);
            validate();
            lblLoading.repaint();
            validate();*/
            
            int value = progressBar.getValue() + 7;
            if (value > progressBar.getMaximum()) {
              value = progressBar.getMaximum();
            }
            progressBar.setValue(value);
            validate();
            progressBar.repaint();
            validate();
            
            
            if(i == 0){
                maxScore = score;
            }else if(score > maxScore){
                maxScore = score;
                
            }
            
            /*pathScores[i] = score;
            //pathList[i] = "["+score+"]>"+strPath;
            pathList[i] = strPath;*/
            
            pathScores[i] = Math.exp(score);
            pathList[i] = "["+pathScores[i]+"]>"+strPath;
        }
        
        /*for (int i = 0; i < size; i++) {
            //pathScores[i] = round((pathScores[i] / maxScore * -100 + 10000) / 99, 2);
            //pathScores[i] = Utils.round((pathScores[i] / maxScore), 2);
            pathScores[i] = Math.exp(pathScores[i]);
            pathList[i] = "["+pathScores[i]+"]>"+pathList[i];
        }*/
        
        Utils.bubbleSort1(pathScores, pathList);
        
        //lblLoading.setText("");
        progressBar.setVisible(false);
        
        return pathList;
    }
    

    
    private double getEdgeScore(String part1, String part2){
        double edgeScore = 0.0;
        
        String query = "SELECT score FROM edge_scores where part1 = '"+part1+"' && part2 = '"+part2+"'";
        try {
            ResultSet set = stmt.executeQuery(query);
            
            if(set.next()) {
                edgeScore = set.getDouble("score");
                if(edgeScore <= 0.0){
                    edgeScore = 0.01;
                }
            }else{
                edgeScore = 0.01;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
        }
        
        edgeScore = 1/(1+(Math.exp(-0.1*(edgeScore-100))/Math.pow(1.8,-0.1*(edgeScore-100))));
        
        edgeScore = Math.log(edgeScore);

        return edgeScore;
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
	
	private void printPartInfo(String partID){
		//System.out.println(partID);
		String partInfo = getPartInfo(partID);
		//System.out.println(partInfo);
		//txtareaPartInfo.setText(partInfo);
		txtpanePartInfo.setText(partInfo);
		txtpanePartInfo.setCaretPosition(0);
		
		//txtareaPartInfo.update(txtareaPartInfo.getGraphics());
		/*txtareaPartInfo.invalidate();
		txtareaPartInfo.validate();
		txtareaPartInfo.repaint();*/
	   
		//scTxtareaPartInfo = new JScrollPane(txtareaPartInfo);
        //scTxtareaPartInfo.add(txtareaPartInfo);
	}
	
	private void insertFeedBack(String comments){
		try{
			stmt.executeUpdate("INSERT INTO feedback (comments, submit_date) values ('"+comments+"', SYSDATE())");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private String getPartInfo(String partID){
		String partInfo = "";
		
		try{
			ResultSet set = stmt.executeQuery("SELECT * FROM main_part_table WHERE part_short_name = '"+partID+"'");
			while(set.next()){
				//allInputs.add(set.getString("part1"));
				partInfo += "<HTML>";
				partInfo += "<b>ID: </b>"+set.getString("part_id")+" <BR>";
				partInfo += "<b>Name: </b>"+set.getString("part_name")+" <BR>";
				partInfo += "<b>Short Name: </b>"+set.getString("part_short_name")+" <BR>";
				partInfo += "<b>Nickname: </b>"+set.getString("part_nickname")+"<BR>";
				partInfo += "<b>Short Description: </b>"+set.getString("part_short_desc")+" <BR>";
				partInfo += "<b>Type: </b>"+set.getString("part_type")+" <BR>";
				partInfo += "<b>Status: </b>"+set.getString("part_status")+" <BR>";
				partInfo += "<b>Results: </b>"+set.getString("part_results")+"<BR>";
				partInfo += "<b>Rating: </b>"+set.getString("part_rating")+"<BR>";
				//partInfo += "<b>URL: </b>"+set.getString("part_url")+"<BR>";
				partInfo += "<b>URL: </b><a href=\""+set.getString("part_url")+"\" target=\"_blank\">"+set.getString("part_url")+"</a><BR>";
				partInfo += "<b>Date: </b>"+set.getString("part_entered")+"<BR>";
				partInfo += "<b>Author: </b>"+set.getString("part_author")+"<BR>";
				partInfo += "<b>Quality: </b>"+set.getString("best_quality")+"<BR>";
				partInfo += "<b>Sequence: </b>"+set.getString("seq_data")+"<BR>";
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
	
	Image background;//TODO daha sonra
	/*public void paint(Graphics g)
	{
		super.paint(g);
		g.drawImage(background,0,0,this);
	} */

    public void actionPerformed(ActionEvent e) {
        //System.out.println("ALOOOO");
        //System.out.println(e.getActionCommand());
        if (e.getActionCommand().equals("btnFind_actionPerformed")) {			
            btnFind_actionPerformed();
        }else if (e.getActionCommand().equals("btnFeedBack_actionPerformed")) {			
            btnFeedBack_actionPerformed();
        }else if (e.getActionCommand().equals("btnPrint_actionPerformed")) {			
			btnPrint_actionPerformed();
		}
		
    }
	
	private void placeM4BIcon(){
		try{
			//BufferedImage myPicture = ImageIO.read(new File("resource/m4b.png"));
			BufferedImage myPicture = ImageIO.read(getClass().getResource("resource/m4b_60x31.PNG"));//m4b_small.PNG
			//BufferedImage myPicture = ImageIO.read(getClass().getResource("resource/fenerbahce1_small.jpg"));
			JLabel picLabel = new JLabel(new ImageIcon( myPicture ));
			picLabel.setBounds(10, 10, 60, 31);//10, 10, 60, 40
			//picLabel.setBounds(25, 25, 180, 93);
			
			//picLabel.setBounds(70, 25, 107, 93);
			this.add(picLabel);
		} catch (IOException ex) {
			// handle exception...
			ex.printStackTrace();
		}

	}
	
	private void writeFile(String str) {
        try {
            FileWriter fstream;
            if (firstCall) {
                fstream = new FileWriter(outFileName); //open mode
                firstCall = false;
            } else {
                fstream = new FileWriter(outFileName, true); //append mode
            }
            BufferedWriter out = new BufferedWriter(fstream);
            out.write(str + "\n");
            out.close();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
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
		//background = getImage(getCodeBase(),"resource/Beautiful-Background.jpg");
        new M4BApplet();
		
    }
}
