// test from MY pc

package wizzball;

import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;
import processing.core.PShape;
import wizzball.Spot;

public class Wizzball extends PApplet  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	PFont f;
	String typing = "";
	String player =  "";
	boolean firstStep = false;
	boolean enterTheGame = false;
	int count = 0;
	PShape square = null;
	int x = 50;
	int rad = 60;        // Width of the shape
	float xpos, ypos;    // Starting position of shape    
	float xspeed = (float) 5;  // Speed of the shape
	float yspeed = (float) 5;  // Speed of the shape
	Spot sp1 = null;
	boolean isBounceUp = false;
	boolean isBounceDown = false;
	PImage img;
	PImage floor;

	public void setup() {
		img = loadImage("space_background.jpg");
		floor = loadImage("MoonFloor.jpg");
		size(500, 500,P3D);
		f = createFont("Arial",16,true);
		square = createShape(RECT, 0, 10, width*10, 2);
		square.setFill(color(0, 0, 255));
		ellipseMode(RADIUS);
		xpos = width/2;
		ypos = height/2;
		
	}

	public void draw() {
		  img.resize(width, height);
		  floor.resize(width, (int) (height*0.2));
		  background(0);
		  textFont(f,16);
		  fill(200 );
		  stroke(153);
		  //changed by Miguel
		  text(" Hello, welcome to Wizzball game.\n Please, enter your name and press ENTER...\n" ,50 ,50 );
		  text( typing, 50, 100 );
		  if ( firstStep )
		  {
				clear();
			    text("Hello " + player + " , you will enter the game.\n You can move the character using arrows keys.\n When the ball bounces up,\n you can decelerate it using up arrow \n When the ball is coming down,\n you can accelerate it using down arrow.\n Press RETURN to continue...",50 ,50 );
		  }
		  if ( enterTheGame )  
		  {
			  clear();
			  background(img); 
			  sp1 = new Spot( this, xpos, ypos, 5 );
			  sp1.display();
			  xpos = (float) (xpos + xspeed * 0.2) ;
			  ypos = (float) (ypos + yspeed * 0.5 );
			  image(floor, 0, (float) (height*0.8));
		
			  if (ypos > height*0.8  ) {
				  // If the object reaches either edge, multiply speed by -1 to turn it around.
				  yspeed = yspeed * -1;
				  isBounceUp = true;
				  isBounceDown = false;
			  }
			  else if ( ypos < 0 )
			  {
				  yspeed = yspeed * -1;
				  isBounceDown = true;
				  isBounceUp = false;
			  }
			  if ( xpos > width || xpos < 0)
			  {
				  xspeed *= -1;
				  text("bravo" + player ,20 ,20);
			  }        
		 }
	}
	
	public void keyPressed() {
		
		  if ( key == '\n' && count == 0 ){
			  
			  count += 1;
			  player = typing;
			  typing = "";
			  firstStep = true;
		  }
		  else
		  {
			  typing = typing + key; 
		  }
		  
		  if ( key == TAB  ){
			  
			    enterTheGame = true;
			    count += 1;
		  }
		  if ( keyCode == UP ) {
			  if ( isBounceUp )
			  {
				  
				  yspeed = (float) ( yspeed  + 3 );
			  }
		  } 
		  if ( keyCode == DOWN  )
		  {
			  if ( isBounceDown )
			  {
				  yspeed = (float) ( yspeed + 3 );
			  }
		  }
		}
}