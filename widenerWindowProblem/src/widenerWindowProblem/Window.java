package dSchwartzWidenerProblemsFoReal;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

public class Window extends JFrame {

	private static JTextField tf1, tf2, tf3, tf4, tf5;
	private static JLabel lb1, lb2, lb3, lb4, lb5;
	private JButton btn1, btn2, btn3;
	
	
	public Window() {
		
		super("Widener Probs Fo'Real 'Tis Time");
		setLayout(new GridLayout(3, 5));

		tf1 = new JTextField(10);
		tf2 = new JTextField(10);
		tf3 = new JTextField(10);
		tf4 = new JTextField(10);
		tf5 = new JTextField(10);
		
		lb1 = new JLabel();
		lb2 = new JLabel();
		lb3 = new JLabel();
		lb4 = new JLabel();
		lb5 = new JLabel();
		
		btn1 = new JButton("Submit");
		btn2 = new JButton("Reset");
		btn3 = new JButton("Random");
		
		
		actionListener listener = new actionListener();
		btn1.addActionListener(listener);
		btn2.addActionListener(listener);
		btn3.addActionListener(listener);
		btn1.setActionCommand("submit");
		btn2.setActionCommand("clearAll");
		btn3.setActionCommand("randomizer");
		
		add(tf1);
		add(tf2);
		add(tf3);
		add(tf4);
		add(tf5);
		add(lb1);
		add(lb2);
		add(lb3);
		add(lb4);
		add(lb5);
		add(btn1);
		add(btn2);
		add(btn3);
	}
	
	private class actionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand() == "submit") {
					checkProbs();
				}
			if (e.getActionCommand() == "clearAll") {
				clearIt();
			}
			if (e.getActionCommand() == "randomizer") {
				randomIt();
			}
			
		}
			
	}
	
	public static void clearIt() {
		tf1.setText("");
		tf2.setText("");
		tf3.setText("");
		tf4.setText("");
		tf5.setText("");
		lb1.setText("");
		lb2.setText("");
		lb3.setText("");
		lb4.setText("");
		lb5.setText("");
	}
	
	public static void error() {
//		if (tf1.getText().length() != 4 || )
	}
	
	public static void randomIt() {
		clearIt();
		Random rand = new Random();
		tf1.setText(Integer.toString(rand.nextInt(10000)));
		tf2.setText(rand.nextInt(100) + "");
		tf3.setText((rand.nextInt(2) + 1) + " " + String.format("%04d", rand.nextInt(10000)));
		int temp = rand.nextInt(11) + 2;
		if (temp % 2 == 0) temp++;
		for (int i = 0; i <= temp; i++) {
			tf4.setText(tf4.getText() + " " + (Integer.toString(rand.nextInt(9)) + 1));
		}
		tf4.setText(tf4.getText().substring(1) + " " + Integer.toString(-1*(rand.nextInt(9) + 1)));
		tf5.setText(Integer.toString(rand.nextInt(100)) + " " + Integer.toString(rand.nextInt(100)) + " " + Integer.toString(rand.nextInt(100)) + " " + Integer.toString(rand.nextInt(100)) + " " + Integer.toString(rand.nextInt(100)) + " " + Integer.toString(rand.nextInt(100)) + " " + Integer.toString(rand.nextInt(100)) + " " + Integer.toString(rand.nextInt(100)) + " " + Integer.toString(rand.nextInt(100)) + " " + Integer.toString(rand.nextInt(100)) + " " + Integer.toString(rand.nextInt(100)) + " " + Integer.toString(rand.nextInt(100)));
//		checkProbs();
	}
	
	public static void checkProbs() {
		if (tf1.getText().length() < 1) { 
			lb1.setText("No Input");
		} else {
			p1(Integer.parseInt(tf1.getText()));
		}
		if (tf2.getText().length() < 1) { 
			lb2.setText("No Input"); 
		} else {
			p2(Integer.parseInt(tf2.getText()));
		}
		if (tf3.getText().length() < 1) { 
			lb3.setText("No Input"); 
		} else {
			p3(tf3.getText());
		}
		if (tf4.getText().length() < 1) {  
			lb4.setText("No Input");
		} else {
			p4(tf4.getText());		
		}
		if (tf5.getText().length() < 1) { 
			lb5.setText("No Input"); 
		} else {
			p5(tf5.getText());		
		}
		


	}
	
	public static void p1(int year) {
		if (year < 1582) lb1.setText("Not a Leap Year");
		if ((year & 3) == 0 && ((year % 25) != 0 || (year & 15) == 0)) lb1.setText("Leap Year"); else lb1.setText("Not a Leap Year");
	}
	
	public static void p2(int num) {
		String res = "";
		for (int i = 1; i <= num; i++) {
		int c = 0;	
			for (int j = 1; j < i; j++) {
				if (i % j == 0) c += j;
			}
			if (c == i) res += c + ", ";
		}
		lb2.setText(res.substring(0, res.length() - 2));
	}
	public static void p3(String line) {
// help        System.out.println("Please enter the text below as the 1 or 2 than a space and then the 4 digits: ");
        String[] words = line.split(" ");
        if (words[0].equals("1")) lb3.setText((((Integer.parseInt(words[1].substring(2, 3))) + 7) % 10) + "" + (((Integer.parseInt(words[1].substring(3, 4))) + 7) % 10) + "" + (((Integer.parseInt(words[1].substring(0, 1))) + 7) % 10)     + "" + (((Integer.parseInt(words[1].substring(1, 2))) + 7) % 10));
        if (words[0].equals("2")) lb3.setText(Math.abs(((Integer.parseInt(words[1].substring(1, 2))) - 7) % 10) + "" + Math.abs(((Integer.parseInt(words[1].substring(3, 4))) - 7) % 10) + "" + Math.abs(((Integer.parseInt(words[1].substring(0, 1))) - 7) % 10) + "" + Math.abs(((Integer.parseInt(words[1].substring(2, 3))) - 7) % 10));
 }
	
	
	
	
	
	public static int simp(int num, int den) {
        if(den == 0) return num; else return simp(den, num % den);
    }
   
    public static void p4(String line) {
// help        System.out.println("Please enter the text below in one line: ");
        String[] words = line.split(" ");
        int n = 0, d = 1;
        
        for (int i = 0; i < words.length - 2; i += 2) {
     	   d*=Integer.parseInt(words[i+1]);
        }
        
        for (int j = 0; j < words.length - 2; j += 2) {
     	   n+=((Integer.parseInt(words[j]) * (d / Integer.parseInt(words[j+1]))));
        }
        

		int simplDiv = simp(n, d);

        d = d / simplDiv;
        n = n / simplDiv;
        
        String str = (n/d) + " " + (n - ((n/d) * d)) + "/" + d;
        if (str.contains(" 0/")) str = str.substring(0, str.indexOf(" 0/"));
        lb4.setText(str);
    }
    
    public static void p5(String line) {
        Random rand = new Random();
        String res = "";
//        JOptionPane.showMessageDialog(null, "yo");
            System.out.println("Please enter the text below in one line: ");
            List<String> myList = new ArrayList<String>(Arrays.asList(line.split(" ")));

            // Step 1
            res+="Step 1: Input Scores: " + myList.toString().substring(1, myList.toString().length() - 1).replaceAll("," , "") + "\n";

            // Step 2
            myList.remove(rand.nextInt(myList.size()-1));
            myList.remove(rand.nextInt(myList.size()-1));
            res+="Step 2: Nine random selected scores: " + myList.toString().substring(1, myList.toString().length() - 1).replaceAll("," , "") + "\n";
            
            // Step 3
            String min = myList.get(0);
            String max = myList.get(0);
	        for(int i = 0; i < myList.size(); i++) {
	           String num = myList.get(i);
	           if(Integer.parseInt(num) < Integer.parseInt(min)) min = num;
	           if(Integer.parseInt(num) > Integer.parseInt(max)) max = num;
	        }    
	        myList.remove(myList.indexOf(min));
	        myList.remove(myList.indexOf(max));
	        res+="Step 3: The remaining seven scores: " + myList.toString().substring(1, myList.toString().length() - 1).replaceAll("," , "") + "\n";
	         
	        // Step 4
	        double sum = 0;
	        for(int i = 0; i < myList.size(); i++) sum += Integer.parseInt(myList.get(i));
	        res+="Step 4: The final score is: " + (sum / 7);
	        JOptionPane.showMessageDialog(null, res);
	    }
		
}
