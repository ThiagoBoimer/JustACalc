package JustACalc;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class Interface extends JFrame {
	
	// screen will display what the user types //
	// mathScreen will be used to calculate    //
	public static JTextArea screen;
	public static JTextArea mathScreen;

	public Interface() {
		
		// Frame  config //
		// try... catch avoids problems with the Icon (shortly) //
        try {
        	new JFrame();
    		setTitle("Just a Calc");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setIconImage(ImageIO.read(Interface.class.getResourceAsStream("/CalcIcon.png")));
			setLayout(new BorderLayout());
	        setPreferredSize(new Dimension(300, 350));
	        pack();
	        setLocationRelativeTo(null);
		} catch (IOException e) {
			e.printStackTrace();
		}
        
        // Buttons panel //
        JPanel pane = new JPanel(new BorderLayout(10, 10));
        pane.setBorder(new EmptyBorder(10, 10, 10, 10));
        pane.setBackground(Color.BLACK);
        pane.add(bttPanel(), BorderLayout.CENTER);
        
        // Screens config //
        screen = new JTextArea(4, 2);
        screen.setBackground(Color.WHITE);
        screen.setForeground(Color.BLACK);
        screen.setEditable(false);
		screen.setFont(new Font("Arial", Font.BOLD, 16));
        mathScreen = new JTextArea(4, 2);
        mathScreen.setBackground(Color.WHITE);
        mathScreen.setForeground(Color.BLACK);
        mathScreen.setEditable(false);
        mathScreen.setVisible(false);
        pane.add(screen, BorderLayout.NORTH);
        pane.add(mathScreen, BorderLayout.SOUTH);
       
        // Setting up the frame //
        setContentPane(pane);
        setVisible(true);
	}
	
	// Buttons panel method //
	public static JPanel bttPanel() {
		JPanel bttPane = new JPanel();
        bttPane.setLayout(new GridLayout(4, 4, 10, 10));
        bttPane.setBackground(Color.BLACK);
        bttPane.add(Logic.btt7);
        bttPane.add(Logic.btt8);
        bttPane.add(Logic.btt9);
        bttPane.add(Logic.bttPlus);
        bttPane.add(Logic.btt6);
        bttPane.add(Logic.btt5);
        bttPane.add(Logic.btt4);
        bttPane.add(Logic.bttDiff);
        bttPane.add(Logic.btt3);
        bttPane.add(Logic.btt2);
        bttPane.add(Logic.btt1);
        bttPane.add(Logic.bttProd);
        bttPane.add(Logic.bttEq);
        bttPane.add(Logic.btt0);
        bttPane.add(Logic.bttC);
        bttPane.add(Logic.bttQuo);
		return bttPane;	
	}
	
	// Buttons method //
	public static JButton Button(String NumSym) {
		JButton btt = new JButton(NumSym);
		btt.setBackground(Color.BLACK);
		btt.setForeground(Color.WHITE);
		btt.setFont(new Font("Arial", Font.BOLD, 16));
		return btt;
	}
}


