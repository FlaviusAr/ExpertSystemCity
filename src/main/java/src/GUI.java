package src;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.filechooser.FileSystemView;


import java.awt.*;
import java.awt.event.*;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class GUI extends JFrame{
	public JFrame frame = new JFrame();
	public static JLabel questiontext;
	public static final JButton yesButton = new JButton();
	public static final JButton noButton = new JButton();
	
	public GUI() {
		  JPanel question = new JPanel();
		  JPanel answer = new JPanel();
		  
		  question.setPreferredSize(new Dimension(500,50));
		  answer.setPreferredSize(new Dimension(250,50));
		/*  TitledBorder t1 =BorderFactory.createTitledBorder(" question");
		 TitledBorder t2 =BorderFactory.createTitledBorder(" answer");
		  
		 question.setBorder(t1);
		 answer.setBorder(t2);*/
		 
		  question.setLayout(new GridLayout(0, 1));
		  answer.setLayout(new GridLayout(0, 2));
		  
		  
		  questiontext = new JLabel("Do you like "+SistemExpert.rules.get(SistemExpert.i)+"?",SwingConstants.CENTER);
		  //Font f = questiontext.getFont();
		  questiontext.setFont(new Font("Verdana", Font.BOLD, 18));
	     // final JButton noButton = new JButton("No");
	      
		
		  noButton.addActionListener(new ActionListener() {
			  public void actionPerformed(ActionEvent ae) {
			    SistemExpert.buttonAct="no";
			    SistemExpert.conclusion();
			  }
			});
		  noButton.setBackground(new Color(59, 89, 182));
	      noButton.setForeground(Color.WHITE);
	      noButton.setFocusPainted(false);
	      noButton.setText("no");
	      noButton.setFont(new Font("Tahoma", Font.BOLD, 12));
	      
	      
	      //final JButton yesButton = new JButton("Yes");
	      
	      
	    
	      yesButton.addActionListener(new ActionListener(){
	    	  public void actionPerformed(ActionEvent ae) {
	    		  SistemExpert.buttonAct="yes";
	    		  SistemExpert.conclusion();
	    	  }
	    	});
	      yesButton.setBackground(new Color(59, 89, 182));
	      yesButton.setForeground(Color.WHITE);
	      yesButton.setFocusPainted(false);
	      yesButton.setText("yes"); 
	      yesButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		  
		  
		  question.add(questiontext, BorderLayout.CENTER);
		  answer.add(noButton, BorderLayout.EAST);
		  answer.add(yesButton, BorderLayout.WEST);
		  
		  frame.add(question,BorderLayout.NORTH);
		  frame.add(answer,BorderLayout.SOUTH);
		  //frame.setUndecorated(true);
		  
		  /*UIDefaults uiDefaults = UIManager.getDefaults();
		  uiDefaults.put("activeCaption", new javax.swing.plaf.ColorUIResource(Color.gray));
		  uiDefaults.put("activeCaptionText", new javax.swing.plaf.ColorUIResource(Color.white));
		  JFrame.setDefaultLookAndFeelDecorated(true);
		  */
		  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      frame.setTitle("Sistem expert oras");
	      frame.pack();
	  	  frame.setSize(500,200);
	      frame.setVisible(true);

	}
	
	public void setqText(String text) {
		questiontext.setText(text);
	}
	
	public static void stop() {
		if(SistemExpert.concluzie=="I couldn't find a recommendation") {
			questiontext.setText("I couldn't find a recommendation");
		}
		else
		questiontext.setText("The recommended city is: " +SistemExpert.concluzie);
		yesButton.setVisible(false);
		noButton.setVisible(false);
	}
	
	public static void setLabelText() {
		if(SistemExpert.i<SistemExpert.rules.size()) {
		questiontext.setText("Do you like "+SistemExpert.rules.get(SistemExpert.i+1)+"?");
		}
	}
	
	/*public static void main(String[] args) {

        new GUI();

    }*/
	
	
	
}
