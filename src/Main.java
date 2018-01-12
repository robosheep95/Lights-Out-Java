
/*
 * Taylor Scafe
 * 3/1/2016
 * A main class that interfaces for LightsOutJava.java
 * Last Updated 3/27/2016
 */
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Main {
	public static int xsize;
	public static int ysize;
	public static boolean notDone = true;

	public static void main(String[] args) {
		do {
			setXandY();
			if (!notDone) {
				JOptionPane.showMessageDialog(null, "Thanks for Playing!");
				notDone = false;
			} else if (xsize == 0 || ysize == 0) {
				JOptionPane.showMessageDialog(null, "Number of rows or columns cannot be 0");
				setXandY();
			} else {
				LightsOutJava game = new LightsOutJava(xsize, ysize);
				game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				while (!game.gameDone) {
				}
				if (JOptionPane.showConfirmDialog(null, "You Won!\nPlay Again?", "Lights Out",
						JOptionPane.YES_NO_OPTION) != 0) {
					JOptionPane.showMessageDialog(null, "Thanks for Playing!");
					notDone = false;
				}
				game.dispose();
			}
		} while (notDone);

	}

	public static void setXandY() {// Creates dialog boxes to ask for row and column dimensions
		String xInput = null;
		String yInput = null;
		try {
			xInput = JOptionPane.showInputDialog("Enter the number of rows you want");
			xsize = Integer.parseInt(xInput);
			yInput = JOptionPane.showInputDialog("Enter the number of columns you want");
			ysize = Integer.parseInt(yInput);
		} catch (NumberFormatException e) {
			if (xInput == null || yInput == null) {
				notDone = false;
			} else {
				JOptionPane.showMessageDialog(null, "Please only use integers");
				setXandY();
			}
		}
	}
}
