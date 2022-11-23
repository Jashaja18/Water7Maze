package Model;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Entities {

    private int[] myCoords = new int[4];
    private BufferedImage mySprite;
    private int myX;
    private int myY;
    private final int myWidth;
    private final int myHeight;
    private int myRoomX;
    private int myRoomY;


    public Entities(int theX1, int theY1, int theX2, int theY2){

        myCoords[0] = theX1;
        myCoords[1] = theY1;
        myCoords[2] = theX2;
        myCoords[3] = theY2;
        myWidth = myCoords[2] - myCoords[0];
        myHeight = myCoords[3] - myCoords[1];
        myX = (myCoords[0] + myCoords[2]) / 2 ;
        myY = (myCoords[1] + myCoords[3]) / 2 ;
    }

    public void setSprite(BufferedImage theSprite){
        mySprite = theSprite;
    }

    public void draw(Graphics2D g){
        g.drawImage(mySprite , myX, myY, myWidth, myHeight, null);
    }

    public void changeCoords(int theX, int theY){
        myCoords[0] = theX - (myWidth / 2);
        myCoords[1] = theY - (myHeight / 2);
        myCoords[2] = theX + (myWidth / 2);
        myCoords[3] = theY + (myHeight / 2);
        myX = (myCoords[0] + myCoords[2]) / 2 ;
        myY = (myCoords[1] + myCoords[3]) / 2 ;
    }

    public int[] getCoords(){
        return myCoords;
    }

    public void setRoomLocation(int theRoomX, int theRoomY){
        myRoomX = theRoomX;
        myRoomY = theRoomY;
    }

    public int getRoomX(){
        return myRoomX;
    }
    public int getRoomY(){
        return myRoomY;
    }





}