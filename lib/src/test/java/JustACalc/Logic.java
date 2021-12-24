package JustACalc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class Logic extends Interface {
	
	// Buttons creation, static so I can access it on Interface class //
	public static JButton btt1 = Button("1");
	public static JButton btt2 = Button("2");
	public static JButton btt3 = Button("3");
	public static JButton btt4 = Button("4");
	public static JButton btt5 = Button("5");
	public static JButton btt6 = Button("6");
	public static JButton btt7 = Button("7");
	public static JButton btt8 = Button("8");
	public static JButton btt9 = Button("9");
	public static JButton btt0 = Button("0");
	public static JButton bttPlus = Button("+");
	public static JButton bttDiff = Button("-");
	public static JButton bttProd = Button("*");
	public static JButton bttQuo  = Button("/");
	public static JButton bttEq   = Button("=");
	public static JButton bttC    = Button("C");
	
	// Creating the ArrayList //
    public ArrayList<String> expression = new ArrayList<>();
	
    // Constructor //
	public Logic() {
		
		// Number buttons action //
		btt1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
                screen.setText(screen.getText() + btt1.getText());
                mathScreen.setText(mathScreen.getText() + btt1.getText());
			}
		});
		btt2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				screen.setText(screen.getText() + btt2.getText());
                mathScreen.setText(mathScreen.getText() + btt2.getText());
			}
		});
		btt3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				screen.setText(screen.getText() + btt3.getText());
                mathScreen.setText(mathScreen.getText() + btt3.getText());
			}
		});
		btt4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				screen.setText(screen.getText() + btt4.getText());
                mathScreen.setText(mathScreen.getText() + btt4.getText());
			}
		});
		btt5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				screen.setText(screen.getText() + btt5.getText());
                mathScreen.setText(mathScreen.getText() + btt5.getText());
			}
		});
		btt6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				screen.setText(screen.getText() + btt6.getText());
                mathScreen.setText(mathScreen.getText() + btt6.getText());
			}
		});
		btt7.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				screen.setText(screen.getText() + btt7.getText());
                mathScreen.setText(mathScreen.getText() + btt7.getText());
			}
		});
		btt8.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				screen.setText(screen.getText() + btt8.getText());
                mathScreen.setText(mathScreen.getText() + btt8.getText());
			}
		});
		btt9.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				screen.setText(screen.getText() + btt9.getText());
                mathScreen.setText(mathScreen.getText() + btt9.getText());
			}
		});
		btt0.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				screen.setText(screen.getText() + btt0.getText());
                mathScreen.setText(mathScreen.getText() + btt0.getText());
			}
		});
		
		// Operator buttons action //
		bttPlus.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				screen.setText(screen.getText() + bttPlus.getText());
				expression.add(mathScreen.getText());
				expression.add("+");
				mathScreen.setText("");
			}
		});
		bttDiff.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				screen.setText(screen.getText() + bttDiff.getText());
				expression.add(mathScreen.getText());
				expression.add("-");
				mathScreen.setText("");
			}
		});
		bttProd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				screen.setText(screen.getText() + bttProd.getText());
				expression.add(mathScreen.getText());
				expression.add("*");
				mathScreen.setText("");
			}
		});
		bttQuo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				screen.setText(screen.getText() + bttQuo.getText());
				expression.add(mathScreen.getText());
				expression.add("/");
				mathScreen.setText("");
			}
		});
		bttC.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				expression.clear();
                mathScreen.setText("");
                screen.setText("");				
			}
		});
		
		// Where the magic happens //
		bttEq.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Adds the last number pressed to the list 
				expression.add(mathScreen.getText());
				
			    // With this I can keep track of the priorital operators //
				//ArrayList<Integer> P = new ArrayList<>();
			    //ArrayList<Integer> Q = new ArrayList<>();
			    //for (int k = 0; k <= Numbers.size() - 1; k++) {
				//	if (Numbers.get(k).equals("*")) {
				//		P.add(k);
				//	}
				//}
			    //for (int k = 0; k <= Numbers.size() - 1; k++) {
				//	if (Numbers.get(k).equals("/")) {
				//		Q.add(k);
				//	}
				//}
				
			    // Calculating first the priorital operators //
				// try... catch solves conflicts like: number/zero //
				try {
					for (int i = expression.size() - 1; i >= 0 ; i--) {
				    	if (expression.lastIndexOf("/") > expression.lastIndexOf("*")) {
					    	expression.set(expression.lastIndexOf("/") + 1, String.valueOf(Double.parseDouble(expression.get(expression.lastIndexOf("/") - 1)) / Double.parseDouble(expression.get(expression.lastIndexOf("/") + 1))));
					    	expression.remove(expression.lastIndexOf("/") - 1);
					    	expression.remove(expression.lastIndexOf("/"));
				    	} 
				    	if (expression.lastIndexOf("*") > expression.lastIndexOf("/")) {
					    	expression.set(expression.lastIndexOf("*") + 1, String.valueOf(Double.parseDouble(expression.get(expression.lastIndexOf("*") - 1)) * Double.parseDouble(expression.get(expression.lastIndexOf("*") + 1))));
					    	expression.remove(expression.lastIndexOf("*") - 1);
					    	expression.remove(expression.lastIndexOf("*"));
				    	} 
				    }
				    
				    // Calculating the remaining operators //
				    for (int i = expression.size() - 1; i >= 0 ; i--) {
				    	if (expression.get(i).equals("+")) {
				    		expression.set(expression.lastIndexOf("+") + 1, String.valueOf(Double.parseDouble(expression.get(expression.lastIndexOf("+") - 1)) + Double.parseDouble(expression.get(expression.lastIndexOf("+") + 1))));
					    	expression.remove(expression.lastIndexOf("+") - 1);
					    	expression.remove(expression.lastIndexOf("+"));
				    	} else if (expression.get(i).equals("-")){
				    		expression.set(expression.lastIndexOf("-") + 1, String.valueOf(Double.parseDouble(expression.get(expression.lastIndexOf("-") - 1)) - Double.parseDouble(expression.get(expression.lastIndexOf("-") + 1))));
					    	expression.remove(expression.lastIndexOf("-") - 1);
					    	expression.remove(expression.lastIndexOf("-"));
				    	}
				    }
				    
				    // Showing the result on the screen //
					screen.setText(screen.getText() + " " + bttEq.getText() + "\n" + expression.get(0));
					
					// If you want to keep track of stuff //
					System.out.println(expression);
					//System.out.println(P);
					//System.out.println(Q);
				} catch (Exception e2) {
					screen.setText("Hmm, there's something wrong");
				}
			}
		});
	}
}
