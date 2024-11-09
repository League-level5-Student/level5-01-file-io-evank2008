package _06_Pixel_Art_Save_State._02_Pixel_Art;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JPanel;

public class GridPanel extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	private int windowWidth;
	private int windowHeight;
	private int pixelWidth;
	private int pixelHeight;
	private int rows;
	private int cols;
	public Pixel[][]grid;
	Random ran = new Random();
	//1. Create a 2D array of pixels. Do not initialize it yet.
	
	private Color color;
	
	
	public GridPanel(int w, int h, int r, int c) {
		
		this.windowWidth = w;
		this.windowHeight = h;
		this.rows = r;
		this.cols = c;
		
		this.pixelWidth = windowWidth / cols;
		this.pixelHeight = windowHeight / rows;
		
		
		color = Color.BLACK;
		
		setPreferredSize(new Dimension(windowWidth, windowHeight));
		//2. Initialize the pixel array using the rows and cols variables.
		grid=new Pixel[r][c];
		
		//3. Iterate through the array and initialize each element to a new pixel.
		for(int x=0;x<grid.length;x++) {
			for(int y=0;y<grid[x].length;y++) {
				grid[x][y]=new Pixel(x*pixelWidth,y*pixelHeight);
			}
		}
		
	}
	
	public void setColor(Color c) {
		color = c;
	}
	
	public void clickPixel(int mouseX, int mouseY) {
		//5. Use the mouseX and mouseY variables to change the color
		//   of the pixel that was clicked. *HINT* Use the pixel's dimensions.
		//grid[mouseX][mouseY].color=color;
		grid[mouseX/pixelWidth][mouseY/pixelHeight].color=color;
		System.out.println("MouseX: "+mouseX);
		System.out.println("MouseY: "+mouseY);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		//4. Iterate through the array.
		//   For every pixel in the list, fill in a rectangle using the pixel's color.
		//   Then, use drawRect to add a grid pattern to your display.
		for(Pixel[] e:grid) {
			for(Pixel p:e) {
				g.setColor(p.color);
				g.fillRect(p.x, p.y, pixelWidth, pixelHeight);
				//g.drawRect(p.x, p.y, pixelWidth, pixelHeight);
			}
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		
	}
}
