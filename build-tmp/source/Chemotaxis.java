import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Chemotaxis extends PApplet {

 Bacteria[] suzy; 
 public void setup()   
 {     
 	size(300,300);//initialize bacteria variables here
 	fill(0);
 	rect(0,0,300,300);
 	int count = 50;
 	suzy= new Bacteria[count];  

 	for (int i=0; i<count; i++){
 		suzy[i]= new Bacteria(150,150);
 	} 
 }   
 
 public void draw() {
 	for (int x=0; x < 50; x++){
 		suzy[x].show();
 		suzy[x].walk(); 
 	}

 	 noStroke();
 	fill(0,10);
 	rect(0, 0, 300, 300);
  
 } 

 public void mousePressed() {

 } 
 
 class Bacteria    
 {     
 	int myX, myY, myColor, direction, move; //variables 
 	Bacteria(int x, int y) {
 		myX= x;
 		direction=3;
 		myY= y;
 		myColor= color((int)(Math.random()*255), (int)(Math.random()*255), (int)(Math.random()*255));
 		move = 0; //0= no bias; 1= right, 2 = left, 3= up, 4=down
 	}

 	public void show() {
 		
 		noStroke();
 		fill(myColor, 25);
 		ellipse(myX,myY,10,10);
 	} 

 	public void walk() {
 		myY+=(int)(Math.random()*7)-direction;
 		myX+=(int)(Math.random()*7)-direction;
 		if (myY>0 && myY<300) {
 			direction= 3;
 		} else if (myY > 300) {
 			direction= 5;
 		} else if (myY < 0) {
 			direction= 1;
 		}

 		if (myX>0 && myX<300) {
 			direction= 3;
 		} else if (myX > 300) {
 			direction= 5;
 		} else if (myX < 0) {
 			direction  = 1;
 		}
 	} 
 	 
 }    
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Chemotaxis" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
