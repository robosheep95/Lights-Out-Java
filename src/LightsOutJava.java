/*
 * Taylor Scafe
 * 3/1/2016
 * The Game of Light's Out
 */
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class LightsOutJava extends JFrame {
	private Container window;
	private JButton[][] buttonList;
	public volatile boolean gameDone = false;
	
	public LightsOutJava(int xsize, int ysize){//Takes in row and column dimentions
		super("Lights Out");
		buttonList = new JButton[xsize][ysize];
		window = getContentPane();
		window.setLayout(new GridLayout(0,ysize));
		for(int i = 0;i < buttonList.length;i++){//Generates tiles and adds listeners to each button.
		for(int j = 0;j < buttonList[i].length;j++){
			buttonList[i][j] = new JButton("");
			buttonList[i][j].setBackground(Color.white);
			buttonList[i][j].addActionListener(new ButtonPress());
			window.add(buttonList[i][j]);
		}
		}
		setSize(ysize*100,xsize*100);//Sets window size based on size of grid
		
		Random ranGen = new Random();//Generates a random boolean to randomize the table but ensure that the puzzle is solvable
		for (JButton[] buttonrow : buttonList){
		for (JButton button : buttonrow){
			boolean temp = ranGen.nextBoolean();
		if (temp){
			button.doClick();
		}
		}
		}
		window.repaint();
		setVisible(true);
	}
	private class ButtonPress implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent ea) {
			boolean done = false;
			int x = 0;
			int y = 0;
			for (int i = 0; i < buttonList.length; i++){
				for (int j = 0; j < buttonList[i].length;j++){
					if (((JButton) ea.getSource()).equals(buttonList[i][j])){
						done = true;
						//System.out.println(i+" | "+j);
						x = i;
						y = j;
						break;
					}
				}
				if (done){
					break;
				}
			}			
			switchColor(buttonList[x][y]);
			if (x>0){//Check if there is a space available to the left of the selected tile
				switchColor(buttonList[x-1][y]);
			}
			if(x<buttonList.length-1){//Check if there is a space available to the right of the selected tile
				switchColor(buttonList[x+1][y]);
			}
			if (y>0){//Check if there is a space available to the top of the selected tile
				switchColor(buttonList[x][y-1]);
			}
			if(y<buttonList[x].length-1){//Check if there is a space available to the bottom of the selected tile
				switchColor(buttonList[x][y+1]);
			}
			if(checkWin()){//Checks for a winner and executes freeze and toggles gameDone variable
				for (JButton[] buttonrow : buttonList){
				for (JButton button : buttonrow){
					button.setBackground(Color.green);
					button.setEnabled(false);
					gameDone = true;
				}
				}
			}
			
			
		}
		private boolean checkWin() {//Checks for all tiles to be black
			// TODO Auto-generated method stub
			for (JButton[] buttonrow : buttonList){
			for (JButton button : buttonrow){
				if (button.getBackground() == Color.white){
					return false;
				}
			}
			}
			return true;
		}
		public void switchColor(JButton button){//Used to switch color from black to white or vice versa.
			if (button.getBackground().equals(Color.black)){
				button.setBackground(Color.white);
			}
			else{
				button.setBackground(Color.black);
			}
		}
	}
}
