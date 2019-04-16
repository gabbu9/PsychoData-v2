import java.awt.event.*;
import java.awt.Image;
import java.awt.Graphics2D;

public class Player{
    private int randX = 0, randY = 0;   
    private int maxSize;
    private Position pos = new Position();
    
    public Player(MyMap currMap){
        do{
            randX = (int)(Math.random()*currMap.getSize());
            randY = (int)(Math.random()*currMap.getSize());
        }while(currMap.getTileType(randX,randY)!='g');
        System.out.println("Start Position: ("+randX+","+randY+")");
        pos.setX(randX);
        pos.setY(randY);
        this.maxSize = currMap.getSize();
    }//not sure if you can generate multiple players
    
    public void move(char direction){ //updating player position
        if(direction == 'U'){
            if(setPosition(pos.getY()+1)){
                pos.setY(pos.getY()+1);
            }
        }else if(direction == 'D'){
            if(setPosition(pos.getY()-1)){
                pos.setY(pos.getY()-1);
            }
        }else if(direction == 'R'){
            if(setPosition(pos.getX()+1)){
                pos.setX(pos.getX()+1);
            }
        }else if(direction == 'L'){
            if(setPosition(pos.getX()-1)){
                pos.setX(pos.getX()-1);
            }
        }else{
            System.out.println("Invalid direction");
            return;
        }
        System.out.println("Moved to: ("+pos.getX()+","+pos.getY()+")");
    }
    
    public boolean setPosition(int x){
        if(x < 0 || x > maxSize){
            return false;
        }else{
            return true;
        }
    }
    
    public int getX(){
        return pos.getX();
    }
    
    public int getY(){
        return pos.getY();
    }
    
    public void setX(int x){
        pos.setX(x);
    }
    
    public void setY(int y){
        pos.setY(y);
    }
    
    /*public void draw(Graphics2D g2d){
        g2d.drawImage(getPlayerImg(),x,y,null);
    }
    
    public Image getPlayerImg() {
        ImageIcon ic = new ImageIcon();//upload player image here
        return ic.getImage();
    }*/
    
    // public void keyPressed(KeyEvent e){
        // int key = e.getKeyCode();
        // if(key == KeyEvent.VK_U){ //UP
            // dy = -1;   
        // } else if (key == KeyEvent.VK_D) { //DOWN
            // dy = 1; 
        // } else if (key == KeyEvent.VK_L) { //LEFT
            // dx = -1; 
        // } else if (key == KeyEvent.VK_R) { //RIGHT 
            // dx = 1; 
        // }
    // }

    // public void keyReleased(KeyEvent e){
        // int key = e.getKeyCode();
        // if(key == KeyEvent.VK_U){ 
            // dy = 0;   
        // } else if (key == KeyEvent.VK_D) { 
            // dy = 0;    
        // } else if (key == KeyEvent.VK_L) { 
            // dx = 0; 
        // } else if (key == KeyEvent.VK_R) { 
            // dx = 0;  
        // }
    // }
}
