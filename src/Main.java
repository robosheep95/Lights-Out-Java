/*
 * Taylor Scafe
 * 3/1/2016
 * A main class that interfaces for LightsOutJava.java
 */
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Main {
	public static int xsize;
	public static int ysize;
	public static boolean notDone = true;
	
	public static void main(String[] args){
		do{
			setXandY();
			LightsOutJava game = new LightsOutJava(xsize,ysize);
			game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			while(!game.gameDone){
			}
			if(JOptionPane.showConfirmDialog(null, "You Won!\nPlay Again?", "Lights Out",  JOptionPane.YES_NO_OPTION)!=0){
				notDone = false;
			}
			game.dispose();
		}while(notDone);
		
	}
	public static void setXandY(){//Creates dialog boxes to ask for row and column dimensions
	try{
		xsize = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of rows you want"));
		ysize = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of columns you want"));
		}
	catch(NumberFormatException e){
		JOptionPane.showMessageDialog(null, "Please only use integers");
		setXandY();
	}
		
	}
}
