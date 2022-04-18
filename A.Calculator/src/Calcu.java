import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.*;
import java.io.*;


public class Calcu extends JFrame implements ActionListener
{

	CalcuRW bato = new CalcuRW();
	
	public boolean bool = false;
	
	//<--- Main Calculator Buttons
	public  JButton bcancel;
	public  JButton bnegpos;
	public  JButton bdel;
	public  JButton bdivide;
	public  JButton bmultiply;
	public  JButton bsubtract;
	public  JButton badd;
	public  JButton bequal;
	public  JButton b9;
	public  JButton b8;
	public  JButton b7;
	public  JButton b6;
	public  JButton b5;
	public  JButton b4;
	public  JButton b3;
	public  JButton b2;
	public  JButton b1;
	public  JButton b0;
	public  JButton bdot;
	
	//<--- Visible and Invisible visual aid computation of entered number
	public  JTextField t4inv;
	public  JTextField t3inv;
	public  JTextField t2inv;
	public  JTextField t1;
	public  JTextField t;
	
	//<--- Button that show History Panel
	public  JButton slider;
	
	//<--- History Panel buttons and TextField
	public  JTextField hempty;
	public  JTextField hprob;
	public  JTextField hans;
	public  JTextField h1prob;
	public  JTextField h1ans;
	public  JTextField h2prob;
	public  JTextField h2ans;
	public  JTextField h3prob;
	public  JTextField h3ans;
	public JTextField bt202p;
	public  JButton fileclear;
	public  JButton fileopen;
	public JLabel panelHistory;
	public JTextField historyText;
	public JTextField historyUnderline;
	public JTextField fileisopened;
	
	//<--- not used / for experiment
	public String grabprob;
	public String grabans;
	public  JLabel ladd;
	public  JLabel lsub;
	public  JLabel lmulti;
	public  JLabel ldiv;
	public JTextArea reader;
	public String s0, s1, s2;
	public int answerfordel;
	public int formathighnum;
	public int formathighnum1;
	public int delTimes=0;
	
	//<-- Shows computed Answer/the one that holds the computed number
	public double answer;
	public String answer2;
	
	//<--- For the flow of continues computation
	public int operatorLapag=0,decimal=0,z=0;
	
	public int var = 0;
	public int var1 = 1;
	
	//<--- Switch Loop char comparison/Detects a selected operator
	public char operator;
	
	//<--- The one that reads specific line of a document
	public int enter=0;
	public int enter1=1;
	
	public int enter2=2;
	public int enter3=3;
	
	public int enter4=4;
	public int enter5=5;

	public int enter6=6;
	public int enter7=7;
	
	//<--- Holds the data of entered number
	public String setprob;
	public String setans;
	
	//<--- Holds the data of specified line of a document
	public String line;
	public String line1;
	
	public String line2;
	public String line3;
	
	public String line4;
	public String line5;
	
	public String line6;
	public String line7;
	
	//<--- Flow for the data of document that shows in history panel
	public int beqenter=0;
	
	//<--- Tells whether a History Panel is opened or closed.
	public int slide=0;
	
	//<--- Flow for the calculator
	public int formateq=0;
	
	//<--- Change the format of the answer.
	DecimalFormat format = new DecimalFormat("###,###,###.#####");
	
	
	//<--- JDK1.8.0_181 siya pinaandar at no error / later version pwede
	
	public Calcu() throws IOException
	
	
	
	{
		super("Standard Calculator v1 - Cataniag, K.P.");
		this.getContentPane().setBackground(new java.awt.Color(14, 9, 11));
		
		 bt202p = new JTextField("BT202P™");
		
		 slider = new JButton("||");
		 bcancel = new JButton("C");
		 bnegpos= new JButton("±");
		 bdel= new JButton("Del");
		 bdivide= new JButton("÷");
		 bmultiply= new JButton("X");
		 bsubtract= new JButton("-");
		 badd= new JButton("+");
		 bequal= new JButton("=");
		 b9= new JButton("9");
		 b8= new JButton("8");
		 b7= new JButton("7");
		 b6= new JButton("6");
		 b5= new JButton("5");
		 b4= new JButton("4");
		 b3= new JButton("3");
		 b2= new JButton("2");
		 b1= new JButton("1");
		 b0= new JButton("0");
		 bdot= new JButton(".");
		
		 t= new JTextField();
		 
		 ladd= new JLabel("");
		 lsub= new JLabel("");
		 lmulti= new JLabel("");
		 ldiv= new JLabel("");
		 
		 panelHistory = new JLabel("");
		 historyText= new JTextField("History");
		 historyUnderline= new JTextField("");
		 
		 
		 hempty = new JTextField("There's no history yet");;
		 hprob = new JTextField("");;
		 hans = new JTextField("");;
		 h1prob = new JTextField("");;
		 h1ans = new JTextField("");;
		 h2prob = new JTextField("");;
		 h2ans = new JTextField("");;
		 h3prob = new JTextField("");;
		 h3ans = new JTextField("");;
		 
		 reader = new JTextArea("");
		 
		 fileisopened= new JTextField("");
		 
		 fileclear= new JButton("Clear History");
		 fileopen= new JButton("Open History");
		 
		 t1= new JTextField("");
		 t2inv= new JTextField("");
		 t3inv= new JTextField("");
		 t4inv= new JTextField("");
		 
			
			
		 t.setBounds(10,30,383,60);
		 t.setForeground(Color.WHITE);
		 t.setFont(new Font("arial", Font.BOLD, 60));
		 t.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		 t.setBackground(new java.awt.Color(14, 9, 11));
		 t.setHorizontalAlignment(SwingConstants.RIGHT);
		 t.setEditable(false);
		
		 panelHistory.setBounds(405,0,284,491);
		 panelHistory.setForeground(Color.WHITE);
		 panelHistory.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		 panelHistory.setBackground(new java.awt.Color(27, 27, 28));
		 panelHistory.setOpaque(true);
		
		historyText.setBounds(420,10,70,30);
		historyText.setForeground(Color.WHITE);
		historyText.setFont(new Font("arial", Font.BOLD, 20));
		historyText.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		historyText.setBackground(new java.awt.Color(27, 27, 28));
		historyText.setEditable(false);
		
		historyUnderline.setBounds(420,43,68,3);
		historyUnderline.setForeground(Color.WHITE);
		historyUnderline.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		historyUnderline.setBackground(new java.awt.Color(254, 250, 43));
		historyUnderline.setEditable(false);
		
		reader.setBounds(415,75,260,370);
		reader.setForeground(Color.WHITE);
		reader.setFont(new Font("arial", Font.BOLD, 20));
		reader.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		reader.setBackground(new java.awt.Color(254, 250, 43));
		reader.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		reader.setEditable(false);
		reader.setOpaque(true);
		
		t1.setBounds(10,10,383,20);
		t1.setForeground(Color.GRAY);
		t1.setFont(new Font("arial", Font.PLAIN, 20));
		t1.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		t1.setBackground(new java.awt.Color(14, 9, 11));
		t1.setHorizontalAlignment(SwingConstants.RIGHT);
		t1.setEditable(false);
		
		t2inv.setBounds(20,30,40,20);
		t2inv.setForeground(Color.RED);
		t2inv.setFont(new Font("arial", Font.BOLD, 12));
		t2inv.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		t2inv.setBackground(new java.awt.Color(14, 9, 11));
		t2inv.setHorizontalAlignment(SwingConstants.RIGHT);
		t2inv.setEditable(false);
		
		t3inv.setBounds(0,10,40,20);
		t3inv.setForeground(Color.CYAN);
		t3inv.setFont(new Font("arial", Font.BOLD, 12));
		t3inv.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		t3inv.setBackground(new java.awt.Color(14, 9, 11));
		t3inv.setHorizontalAlignment(SwingConstants.RIGHT);
		t3inv.setEditable(false);
		
		t4inv.setBounds(50,10,40,20);
		t4inv.setForeground(Color.YELLOW);
		t4inv.setFont(new Font("arial", Font.BOLD, 12));
		t4inv.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		t4inv.setBackground(new java.awt.Color(14, 9, 11));
		t4inv.setHorizontalAlignment(SwingConstants.RIGHT);
		t4inv.setEditable(false);
		
		slider.setBounds(394,0,11,520);
		slider.setForeground(Color.WHITE);
		slider.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
		slider.setBackground(new java.awt.Color(14, 9, 11));
		
		bcancel.setBounds(10,100,95,75);
		bcancel.setForeground(Color.BLACK);
		bcancel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
		bcancel.setBackground(new java.awt.Color(111, 111, 110));
		
		bnegpos.setBounds(106,100,95,75);
		bnegpos.setForeground(Color.BLACK);
		bnegpos.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
		bnegpos.setBackground(new java.awt.Color(111, 111, 110));
		
		bdel.setBounds(202,100,95,75);
		bdel.setForeground(Color.BLACK);
		bdel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
		bdel.setBackground(new java.awt.Color(111, 111, 110));
		
		bdivide.setBounds(298,100,95,75);
		bdivide.setForeground(Color.BLACK);
		bdivide.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
		bdivide.setBackground(new java.awt.Color(254, 250, 43));
		
		bmultiply.setBounds(298,176,95,75);
		bmultiply.setForeground(Color.BLACK);
		bmultiply.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
		bmultiply.setBackground(new java.awt.Color(254, 250, 43));
		
		bsubtract.setBounds(298,252,95,75);
		bsubtract.setForeground(Color.BLACK);
		bsubtract.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
		bsubtract.setBackground(new java.awt.Color(254, 250, 43));
		
		badd.setBounds(298,328,95,75);
		badd.setForeground(Color.BLACK);
		badd.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
		badd.setBackground(new java.awt.Color(254, 250, 43));
		
		bequal.setBounds(298,404,95,75);
		bequal.setForeground(Color.BLACK);
		bequal.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
		bequal.setBackground(new java.awt.Color(254, 250, 43));
		
		b9.setBounds(202,176,95,75);
		b9.setForeground(Color.BLACK);
		b9.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
		b9.setBackground(new java.awt.Color(157, 159, 159));
		
		b8.setBounds(106,176,95,75);
		b8.setForeground(Color.BLACK);
		b8.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
		b8.setBackground(new java.awt.Color(157, 159, 159));
		
		b7.setBounds(10,176,95,75);
		b7.setForeground(Color.BLACK);
		b7.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
		b7.setBackground(new java.awt.Color(157, 159, 159));
		
		b6.setBounds(202,252,95,75);
		b6.setForeground(Color.BLACK);
		b6.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
		b6.setBackground(new java.awt.Color(157, 159, 159));
		
		b5.setBounds(106,252,95,75);
		b5.setForeground(Color.BLACK);
		b5.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
		b5.setBackground(new java.awt.Color(157, 159, 159));
		
		b4.setBounds(10,252,95,75);
		b4.setForeground(Color.BLACK);
		b4.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
		b4.setBackground(new java.awt.Color(157, 159, 159));
		
		b3.setBounds(202,328,95,75);
		b3.setForeground(Color.BLACK);
		b3.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
		b3.setBackground(new java.awt.Color(157, 159, 159));
		
		b2.setBounds(106,328,95,75);
		b2.setForeground(Color.BLACK);
		b2.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
		b2.setBackground(new java.awt.Color(157, 159, 159));
		
		b1.setBounds(10,328,95,75);
		b1.setForeground(Color.BLACK);
		b1.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
		b1.setBackground(new java.awt.Color(157, 159, 159));
		
		b0.setBounds(10,404,191,75);
		b0.setForeground(Color.BLACK);
		b0.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
		b0.setBackground(new java.awt.Color(157, 159, 159));
		
		bdot.setBounds(202,404,95,75);
		bdot.setForeground(Color.BLACK);
		bdot.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
		bdot.setBackground(new java.awt.Color(157, 159, 159));
		
		fileclear.setBounds(420,455,85,25);
		fileclear.setForeground(Color.WHITE);
		fileclear.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
		fileclear.setBackground(new java.awt.Color(22, 22, 22));
		
		fileopen.setBounds(510,455,85,25);
		fileopen.setForeground(Color.WHITE);
		fileopen.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
		fileopen.setBackground(new java.awt.Color(22, 22, 22));
		
		fileisopened.setBounds(470,430,175,25);
		fileisopened.setForeground(Color.WHITE);
		fileisopened.setFont(new Font("arial", Font.BOLD, 12));
		fileisopened.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		fileisopened.setBackground(new java.awt.Color(27, 27, 28));
		fileisopened.setEditable(false);
		
		bt202p.setBounds(605,455,175,25);
		bt202p.setForeground(Color.WHITE);
		bt202p.setFont(new Font("arial", Font.BOLD, 12));
		bt202p.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		bt202p.setBackground(new java.awt.Color(27, 27, 28));
		bt202p.setEditable(false);
		
		hempty.setBounds(420,60,155,14);
		hempty.setForeground(Color.WHITE);
		hempty.setFont(new Font("arial", Font.BOLD, 14));
		hempty.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		hempty.setBackground(new java.awt.Color(27, 27, 28));
		hempty.setEditable(false);
		
		hprob.setBounds(415,75,260,15);
		hprob.setForeground(Color.GRAY);
		hprob.setFont(new Font("arial", Font.BOLD, 15));
		hprob.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		hprob.setBackground(new java.awt.Color(27, 27, 28));
		hprob.setHorizontalAlignment(SwingConstants.RIGHT);
		hprob.setEditable(false);
		
		hans.setBounds(415,95,260,60);
		hans.setForeground(Color.WHITE);
		hans.setFont(new Font("arial", Font.BOLD, 52));
		hans.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		hans.setBackground(new java.awt.Color(27, 27, 28));
		hans.setHorizontalAlignment(SwingConstants.RIGHT);
		hans.setEditable(false);
		
		h1prob.setBounds(415,160,260,30);
		h1prob.setForeground(Color.GRAY);
		h1prob.setFont(new Font("arial", Font.BOLD, 15));
		h1prob.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		h1prob.setBackground(new java.awt.Color(27, 27, 28));
		h1prob.setHorizontalAlignment(SwingConstants.RIGHT);
		h1prob.setEditable(false);
		
		h1ans.setBounds(415,185,260,60);
		h1ans.setForeground(Color.WHITE);
		h1ans.setFont(new Font("arial", Font.BOLD, 52));
		h1ans.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		h1ans.setBackground(new java.awt.Color(27, 27, 28));
		h1ans.setHorizontalAlignment(SwingConstants.RIGHT);
		h1ans.setEditable(false);
		
		h2prob.setBounds(415,250,260,30);
		h2prob.setForeground(Color.GRAY);
		h2prob.setFont(new Font("arial", Font.BOLD, 15));
		h2prob.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		h2prob.setBackground(new java.awt.Color(27, 27, 28));
		h2prob.setHorizontalAlignment(SwingConstants.RIGHT);
		h2prob.setEditable(false);
		
		h2ans.setBounds(415,275,260,60);
		h2ans.setForeground(Color.WHITE);
		h2ans.setFont(new Font("arial", Font.BOLD, 52));
		h2ans.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		h2ans.setBackground(new java.awt.Color(27, 27, 28));
		h2ans.setHorizontalAlignment(SwingConstants.RIGHT);
		h2ans.setEditable(false);
		
		h3prob.setBounds(415,340,260,30);
		h3prob.setForeground(Color.GRAY);
		h3prob.setFont(new Font("arial", Font.BOLD, 15));
		h3prob.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		h3prob.setBackground(new java.awt.Color(27, 27, 28));
		h3prob.setHorizontalAlignment(SwingConstants.RIGHT);
		h3prob.setEditable(false);
		
		h3ans.setBounds(415,365,260,60);
		h3ans.setForeground(Color.WHITE);
		h3ans.setFont(new Font("arial", Font.BOLD, 52));
		h3ans.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		h3ans.setBackground(new java.awt.Color(27, 27, 28));
		h3ans.setHorizontalAlignment(SwingConstants.RIGHT);
		h3ans.setEditable(false);
		
		
		JPanel panel = (JPanel) this.getContentPane();
		 panel.setLayout(null);
		
		this.add(slider);
		this.add(bcancel);
		this.add(bnegpos);
		this.add(bdel);
		this.add(bdivide);
		this.add(bmultiply);
		this.add(bsubtract);
		this.add(badd);
		this.add(bequal);
		this.add(b9);
		this.add(b8);
		this.add(b7);
		this.add(b6);
		this.add(b5);
		this.add(b4);
		this.add(b3);
		this.add(b2);
		this.add(b1);
		this.add(b0);
		this.add(bdot);
		this.add(t);
		this.add(fileclear);
		this.add(fileopen);
		panel.add(ladd);
		panel.add(lsub);
		panel.add(lmulti);
		panel.add(ldiv);
		panel.add(t1);
		//panel.add(t2inv);
		//panel.add(t3inv);
		//panel.add(t4inv);
		panel.add(panelHistory);
		panel.add(historyText);
		panel.add(historyUnderline);
		panel.add(hempty);
		panel.add(fileisopened);
		panel.add(bt202p);
		
		panel.add(hprob);
		panel.add(hans);
		panel.add(h1prob);
		panel.add(h1ans);
		panel.add(h2prob);
		panel.add(h2ans);
		panel.add(h3prob);
		panel.add(h3ans);
		
		//panel.add(reader);
		
		bdot.addActionListener(this);
		b0.addActionListener(this);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		b8.addActionListener(this);
		b9.addActionListener(this);
		bequal.addActionListener(this);
		badd.addActionListener(this);
		bsubtract.addActionListener(this);
		bmultiply.addActionListener(this);
		bdivide.addActionListener(this);
		bdel.addActionListener(this);
		bnegpos.addActionListener(this);
		bcancel.addActionListener(this);
		fileclear.addActionListener(this);
		fileopen.addActionListener(this);
		slider.addActionListener(this);
		
		
		
	}
	public static void main(String[]args) throws IOException
	{
		Calcu gui = new Calcu();
		gui.setVisible(true);
		gui.setSize(411,520); //gui.setSize(690,520);
		gui.setResizable(false);
		gui.setLocationRelativeTo(null);
		gui.setDefaultCloseOperation(3);
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		try {
			
			File history = new File("HistoryLog.doc");
			history.createNewFile();
			
			history.delete();
			
			FileWriter historyfw = new FileWriter(history, true);
			
			bool = history.exists();
			
			//Double d = 7.99; // 7
			//int i = d.intValue();
			//System.out.printf("Double : %f, int : %d %n", d, i);
			
	        	 
	         
		
		
		
		String s=e.getActionCommand();
		format.setGroupingSize(3);
		//String operatoradd = ladd.getText();
		//String operatorsub = lsub.getText();
		//String operatormulti = lmulti.getText();
		//String operatordiv = ldiv.getText();
		String hawak = t.getText();
		t.setText(" ");
		String hawak1 = t1.getText();
		String hawak2 = t2inv.getText();
		String hawak3 = t3inv.getText();
		String hawak4 = t4inv.getText();
		String mathadd= "+";
		String mathsub= "-";
		String mathmultifake= "x";
		String mathmulti= "*";
		String mathdivifake= "/";
		String mathdivi= "/";
		
		
		//Boolean loop = true;
		
		
		
		
		if(s.equals("0")) {
			fileisopened.setText("");
			if(z==0) {
				t.setText(hawak+"0");
				operatorLapag=1;
			}
			else {
				t.setText("0");
				z=0;
				operatorLapag=1;
			}
			
		}
		else if(s.equals("1")) {
			fileisopened.setText("");
			if(z==0) {
				t.setText(hawak+"1");
				operatorLapag=1;
			}
			else {
				t.setText("1");
				z=0;
				operatorLapag=1;
			}
		}
		else if(s.equals("2")) {
			fileisopened.setText("");
			if(z==0) {
				t.setText(hawak+"2");
				operatorLapag=1;
			}
			else {
				t.setText("2");
				z=0;
				operatorLapag=1;
			}
		}
		else if(s.equals("3")) {
			fileisopened.setText("");
			if(z==0) {
				t.setText(hawak+"3");
				operatorLapag=1;
			}
			else {
				t.setText("3");
				z=0;
				operatorLapag=1;
			}
		}
		else if(s.equals("4")) {
			fileisopened.setText("");
			if(z==0) {
				t.setText(hawak+"4");
				operatorLapag=1;
			}
			else {
				t.setText("4");
				z=0;
				operatorLapag=1;
			}
		}
		else if(s.equals("5")) {
			fileisopened.setText("");
			if(z==0) {
				t.setText(hawak+"5");
				operatorLapag=1;
			}
			else {
				t.setText("5");
				z=0;
				operatorLapag=1;
			}
		}
		else if(s.equals("6")) {
			fileisopened.setText("");
			if(z==0) {
				t.setText(hawak+"6");
				operatorLapag=1;
			}
			else {
				t.setText("6");
				z=0;
				operatorLapag=1;
			}
		}
		else if(s.equals("7")) {
			fileisopened.setText("");
			if(z==0) {
				t.setText(hawak+"7");
				operatorLapag=1;
			}
			else {
				t.setText("7");
				z=0;
				operatorLapag=1;
			}
		}
		else if(s.equals("8")) {
			fileisopened.setText("");
			if(z==0) {
				t.setText(hawak+"8");
				operatorLapag=1;
			}
			else {
				t.setText("8");
				z=0;
				operatorLapag=1;
			}
		}
		else if(s.equals("9")) {
			fileisopened.setText("");
			if(z==0) {
				t.setText(hawak+"9");
				operatorLapag=1;
			}
			else {
				t.setText("9");
				z=0;
				operatorLapag=1;
			}
		}
		else if(s.equals(".")) {
			fileisopened.setText("");
			t.setText(hawak+".");
			/*if(decimal==0) {
			t.setText(hawak+".");
			decimal=1;
			z=0;
			}
			else {
				t.setText(hawak);
				
			}*/
		}
		else if(s.equals("C")) {
			fileisopened.setText("");
			t.setFont(new Font("arial", Font.BOLD, 60));
			t.setText("");
			t1.setText("");
			t3inv.setText("");
			operatorLapag=0;
			decimal=0;
			formateq=0;
		}
		else if(s.equals("Del")) {
			fileisopened.setText("");
			delTimes=1;
			
			if(hawak.equals("0") || hawak.equals("-0") || hawak.equals(".") || hawak.equals(".0")) {
				t.setText("");
				decimal=1;
			}
			
			else {
				if(formateq==0) {
					
					int delnum=Integer.parseInt(hawak);
					t.setText(Integer.toString(delnum/10));
					decimal=1;
				}
				else if (formateq==1) {
					DecimalFormat format = new DecimalFormat(",###");
					int delnum=Integer.parseInt(hawak4);
					int delnumans = delnum/10;
					int tohawak =delnumans;
					t4inv.setText(Integer.toString(tohawak));
					t.setText(format.format(tohawak));
					decimal=1;
				}
			}
			delTimes=1;
			operatorLapag=0;
		}
		else if(s.equals("±")) {
			fileisopened.setText("");
			if(formateq==0) {
				double change=Double.parseDouble(hawak);
				t.setText(Double.toString(change*-1));	
			}
			else if (formateq==1) {
				DecimalFormat format = new DecimalFormat("###,###,###.###");
				double change=Double.parseDouble(hawak3);
				double changeans =change*-1;
				t3inv.setText(Double.toString(changeans));
				t.setText(format.format(changeans));
			}
		}
		
		
		else if(e.getSource()==badd) {
			fileisopened.setText("");
			if(operatorLapag==1 && formateq==0) {
			t1.setText(hawak+" "+mathadd);//<---hawak1
			t2inv.setText(hawak);//<---hawak2
			ladd.setText(mathadd);
			operator='+';
			t.setText("");
			decimal=0;
			}
			else if(operatorLapag==1 && formateq==1) {
				t1.setText(hawak3+" "+mathadd);//<---hawak1
				t2inv.setText(hawak3);//<---hawak2
				ladd.setText(mathadd);
				operator='+';
				t.setText("");
				decimal=0;
				}
			else {
				t1.setText(hawak4+" "+mathadd);
				t2inv.setText(hawak4);//<---hawak2
				ladd.setText(mathadd);
				operator='+';
				t.setText("");
				decimal=0;
			}
			
		}
		else if(e.getSource()==bsubtract) {
			fileisopened.setText("");
			if(operatorLapag==1 && formateq==0) {
				t1.setText(hawak+" "+mathsub);//<---hawak1
				t2inv.setText(hawak);//<---hawak2
				ladd.setText(mathsub);
				operator='-';
				t.setText("");
				decimal=0;
				}
				else if(operatorLapag==1 && formateq==1) {
					t1.setText(hawak3+" "+mathsub);//<---hawak1
					t2inv.setText(hawak3);//<---hawak2
					ladd.setText(mathsub);
					operator='-';
					t.setText("");
					decimal=0;
					}
			else {
				t1.setText(hawak4+" "+mathsub);
				t2inv.setText(hawak4);//<---hawak2
				ladd.setText(mathsub);
				operator='-';
				t.setText("");
				decimal=0;
			}
			
		}
		else if(e.getSource()==bmultiply) {
			fileisopened.setText("");
			if(operatorLapag==1 && formateq==0) {
				t1.setText(hawak+" "+mathmultifake);//<---hawak1
				t2inv.setText(hawak);//<---hawak2
				ladd.setText(mathmulti);
				operator='*';
				t.setText("");
				decimal=0;
				}
				else if(operatorLapag==1 && formateq==1) {
					t1.setText(hawak3+" "+mathmultifake);//<---hawak1
					t2inv.setText(hawak3);//<---hawak2
					ladd.setText(mathmulti);
					operator='*';
					t.setText("");
					decimal=0;
					}
			else {
				t1.setText(hawak4+" "+mathmultifake);
				t2inv.setText(hawak4);//<---hawak2
				ladd.setText(mathmulti);
				operator='*';
				t.setText("");
				decimal=0;
			}
			
		}
		else if(e.getSource()==bdivide) {
			fileisopened.setText("");
			if(operatorLapag==1 && formateq==0) {
				t1.setText(hawak+" "+mathdivifake);//<---hawak1
				t2inv.setText(hawak);//<---hawak2
				ladd.setText(mathdivi);
				operator='/';
				t.setText("");
				decimal=0;
				}
				else if(operatorLapag==1 && formateq==1) {
					t1.setText(hawak3+" "+mathdivifake);//<---hawak1
					t2inv.setText(hawak3);//<---hawak2
					ladd.setText(mathdivi);
					operator='/';
					t.setText("");
					decimal=0;
					}
			else {
				t1.setText(hawak4+" "+mathdivifake);
				t2inv.setText(hawak4);//<---hawak2
				ladd.setText(mathdivi);
				operator='/';
				t.setText("");
				decimal=0;
			}
		}
		
		
		else if(e.getSource()==bequal) {
			fileisopened.setText("");
			historyText.setText("History");
			historyUnderline.setText("  ");
			
			
			
			if (hawak !=null&&formateq==0){
				formateq=1;
				
				double leftOP=Double.parseDouble(hawak2);
				double rightOP=Double.parseDouble(hawak);
				
				//int leftOP1= Integer.parseInt(hawak2);
				//int rightOP1= Integer.parseInt(hawak);
				
				switch(operator) {
				case '+':
					answer=leftOP+rightOP;
					//answerfordel=leftOP1+rightOP1;
					break;
					case '-':
					answer=leftOP-rightOP;
					//answerfordel=leftOP1-rightOP1;
					break;
					case '/':
						if(rightOP==0) {
							answer2 = "Cannot divide by zero";
							
						}
						else {
							answer=leftOP/rightOP;
							//answerfordel=leftOP1/rightOP1;
							break;
						}
					case '*':
					answer=leftOP*rightOP;
					//answerfordel=leftOP1*rightOP1;
					break;
					}
			}
			else if (hawak !=null&&formateq==1){
				
				
				double leftOP=Double.parseDouble(hawak2);
				double rightOP=Double.parseDouble(hawak);
				
				//int leftOP1=(int)Integer.parseInt(hawak2);
				//int rightOP1=(int)Integer.parseInt(hawak);
				
				switch(operator) {
				case '+':
					answer=leftOP+rightOP;
					//answerfordel= leftOP1+rightOP1;
					break;
					case '-':
					answer=leftOP-rightOP;
					//answerfordel=leftOP1-rightOP1;
					break;
					case '/':
						if(rightOP==0) {
							answer2 = "Cannot divide by zero";
							
						}
						else {
							answer=leftOP/rightOP;
							//answerfordel=leftOP1/rightOP1;
							break;
						}
					case '*':
					answer=leftOP*rightOP;
					//answerfordel=leftOP1*rightOP1;
					break;
					}
			}
			double rightOP=Double.parseDouble(hawak);
			if(rightOP==0 && operator == '/') {
				t1.setText(hawak1+" "+hawak+" "+"=");
				t.setText(answer2);
				t.setFont(new Font("arial", Font.BOLD, 30));
				z=1;
				decimal=0;
				//t3inv.setText("Cannot divide by 11zero");
				//t3inv.setFont(new Font("arial", Font.BOLD, 12));
				setprob = t1.getText();
				setans = t3inv.getText();
				//hempty.setText("");
				//historyfw.write(setprob+"\n"+setans+"\n");
				//historyfw.close();
				
				
				
				
			
			}
			else {
			Double answer1 = answer;
			String answer2 = Double.toString(answer);
			String answer3 = format.format(answer);
			int answer4 = answer1.intValue();
			t4inv.setText(Integer.toString(answer4));
			t3inv.setText(Double.toString(answer));
			//t3inv.setText((format.format(answer1)));
			t1.setText(hawak1+" "+hawak+" "+"=");
			
			
			
			if(answer1>=999999999) {
			DecimalFormat format = new DecimalFormat("#,###.##E0");
			t.setText((format.format(answer1)));
			
			
			setprob = t1.getText();
			setans = t.getText();
			hempty.setText("");
			historyfw.write(setprob+"\n"+setans+"\n");
			historyfw.close();
			
			
			
			
			
			}
			else {
				
				t1.setText(hawak1+" "+hawak+" "+"=");
				t.setText(answer3);
				t.setFont(new Font("arial", Font.BOLD, 60));
				setprob = t1.getText();
				setans = t.getText();
				
				hempty.setText("");
				historyfw.write(setprob+"\n"+setans+"\n");
				historyfw.close();
				
				
				
			}
			
			
			if(beqenter==0) {
				//<---------hprob and hans--------->
				line = Files.readAllLines(Paths.get("HistoryLog.doc")).get(enter);
				hprob.setText(line);
				line1 = Files.readAllLines(Paths.get("HistoryLog.doc")).get(enter1);
				hans.setText(line1);
				
				}
				else if(beqenter==1) {
				//<---------hprob and hans--------->
					enter=enter+2;
					enter1=enter1+2;
				line = Files.readAllLines(Paths.get("HistoryLog.doc")).get(enter);
				hprob.setText(line);
				line1 = Files.readAllLines(Paths.get("HistoryLog.doc")).get(enter1);
				hans.setText(line1);
				
				
				//<---------h1prob and h1ans--------->
					enter2=enter2-2;
					enter3=enter3-2;
				line2 = Files.readAllLines(Paths.get("HistoryLog.doc")).get(enter2);
				h1prob.setText(line2);
				line3 = Files.readAllLines(Paths.get("HistoryLog.doc")).get(enter3);
				h1ans.setText(line3);
				
				}
				else if(beqenter==2) {
					//<---------hprob and hans--------->
						enter=enter+2;
						enter1=enter1+2;
					line = Files.readAllLines(Paths.get("HistoryLog.doc")).get(enter);
					hprob.setText(line);
					line1 = Files.readAllLines(Paths.get("HistoryLog.doc")).get(enter1);
					hans.setText(line1);
					
					
					//<---------h1prob and h1ans--------->
						enter2=enter2+2;
						enter3=enter3+2;
					line2 = Files.readAllLines(Paths.get("HistoryLog.doc")).get(enter2);
					h1prob.setText(line2);
					line3 = Files.readAllLines(Paths.get("HistoryLog.doc")).get(enter3);
					h1ans.setText(line3);
					
					
					//<---------h2prob and h2ans--------->
						enter4=enter4-4;
						enter5=enter5-4;
					line4 = Files.readAllLines(Paths.get("HistoryLog.doc")).get(enter4);
					h2prob.setText(line4);
					line5 = Files.readAllLines(Paths.get("HistoryLog.doc")).get(enter5);
					h2ans.setText(line5);
					
					}
				else if (beqenter==3) {
					//<---------hprob and hans--------->
					enter=enter+2;
					enter1=enter1+2;
				line = Files.readAllLines(Paths.get("HistoryLog.doc")).get(enter);
				hprob.setText(line);
				line1 = Files.readAllLines(Paths.get("HistoryLog.doc")).get(enter1);
				hans.setText(line1);
				
				
				//<---------h1prob and h1ans--------->
					enter2=enter2+2;
					enter3=enter3+2;
				line2 = Files.readAllLines(Paths.get("HistoryLog.doc")).get(enter2);
				h1prob.setText(line2);
				line3 = Files.readAllLines(Paths.get("HistoryLog.doc")).get(enter3);
				h1ans.setText(line3);
				
				
				//<---------h2prob and h2ans--------->
					enter4=enter4+2;
					enter5=enter5+2;
				line4 = Files.readAllLines(Paths.get("HistoryLog.doc")).get(enter4);
				h2prob.setText(line4);
				line5 = Files.readAllLines(Paths.get("HistoryLog.doc")).get(enter5);
				h2ans.setText(line5);
				
				//<---------h3prob and h3ans--------->
				enter6=enter6-6;
				enter7=enter7-6;
				line6 = Files.readAllLines(Paths.get("HistoryLog.doc")).get(enter6);
				h3prob.setText(line6);
				line7 = Files.readAllLines(Paths.get("HistoryLog.doc")).get(enter7);
				h3ans.setText(line7);
				}
				else if (beqenter>=4) {
					//<---------hprob and hans--------->
					enter=enter+2;
					enter1=enter1+2;
				line = Files.readAllLines(Paths.get("HistoryLog.doc")).get(enter);
				hprob.setText(line);
				line1 = Files.readAllLines(Paths.get("HistoryLog.doc")).get(enter1);
				hans.setText(line1);
				
				
				//<---------h1prob and h1ans--------->
					enter2=enter2+2;
					enter3=enter3+2;
				line2 = Files.readAllLines(Paths.get("HistoryLog.doc")).get(enter2);
				h1prob.setText(line2);
				line3 = Files.readAllLines(Paths.get("HistoryLog.doc")).get(enter3);
				h1ans.setText(line3);
				
				
				//<---------h2prob and h2ans--------->
					enter4=enter4+2;
					enter5=enter5+2;
				line4 = Files.readAllLines(Paths.get("HistoryLog.doc")).get(enter4);
				h2prob.setText(line4);
				line5 = Files.readAllLines(Paths.get("HistoryLog.doc")).get(enter5);
				h2ans.setText(line5);
				
				//<---------h3prob and h3ans--------->
				enter6=enter6+2;
				enter7=enter7+2;
				line6 = Files.readAllLines(Paths.get("HistoryLog.doc")).get(enter6);
				h3prob.setText(line6);
				line7 = Files.readAllLines(Paths.get("HistoryLog.doc")).get(enter7);
				h3ans.setText(line7);
				}
				
				
				
				
				beqenter++;
			
			z=1;
			decimal=0;
			operatorLapag=1;
			delTimes=0;
			}
			
	
			
			
		}
		
		if(s.equals("Clear History")) {
			
			historyText.setText("History");
			historyUnderline.setText("  ");
			t.setText(hawak);
			hempty.setText("There's no history yet");
			hprob.setText("");
			hans.setText("");
			h1prob.setText("");
			h1ans.setText("");
			h2prob.setText("");
			h2ans.setText("");
			h3prob.setText("");
			h3ans.setText("");
			bt202p.setText("BT202P™");
			fileisopened.setText("");
			
			//reader.setText("   asdasd  ");
		}
		
		if(s.equals("Open History")) {
			Desktop.getDesktop().open(new java.io.File("HistoryLog.doc"));
			fileisopened.setText("File is opened! Please wait..");
			t.setText(hawak);
			
		}
		
		if(s.equals("||")) {
			
			if(slide==0) {
				setSize(new Dimension(690,520));
				t.setText(hawak);
				slider.setBackground(new java.awt.Color(22, 22, 22));
			slide=1;
			}
			else {
				setSize(new Dimension(411,520));
				t.setText(hawak);
				slider.setBackground(new java.awt.Color(14, 9, 11));
				slide=0;
			}
		}
		

				
		}catch(IOException ab) {
			//JOptionPane.showMessageDialog(null, "error");
		}catch(IndexOutOfBoundsException abc) {
			//JOptionPane.showMessageDialog(null, "error 1");
		}
	}

	

}

