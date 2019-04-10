import java.awt.event.*;
import java.awt.Image;
import java.awt.Graphics2D;

public class Player{
    private int x,y;
    private int dx = 0,dy = 0;//velocities   
    private int width1,length1; //frame dimensions
    
    public Player(int x, int y, int width, int length){ //setting coordinates for player, x & y need to be randomly generated values for player coordinates, width & height is the size of the arena of which values depend on user input
        this.x = x;
        this.y = y;
        this.width1 = width;
        this.length1 = length;
    }//not sure if you can generate multiple players
    
    public void update(){ //updating player position
        this.x += dx;
        this.y += dy;
        
        if (x < 1) {//ensuring no collision on x-axis
            x = 1;
        }
        
        if (x > width1){
            x = width1;
        }
        
        if (y < 1) {//ensuring no collision on y-axis
            y = 1;
        }
        
        if (y > length1){
            y = length1;
        }
    }
    
    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }
    
    public void setX(int x){
        this.x = x;
    }
    
    public void setY(int y){
        this.y = y;
    }
    
    /*public void draw(Graphics2D g2d){
        g2d.drawImage(getPlayerImg(),x,y,null);
    }
    
    public Image getPlayerImg() {
        ImageIcon ic = new ImageIcon();//upload player image here
        return ic.getImage();
    }*/
    
    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_U){ //UP
            dy = -1;   
        } else if (key == KeyEvent.VK_D) { //DOWN
            dy = 1; 
        } else if (key == KeyEvent.VK_L) { //LEFT
            dx = -1; 
        } else if (key == KeyEvent.VK_R) { //RIGHT 
            dx = 1; 
        }
    }

    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_U){ 
            dy = 0;   
        } else if (key == KeyEvent.VK_D) { 
            dy = 0;    
        } else if (key == KeyEvent.VK_L) { 
            dx = 0; 
        } else if (key == KeyEvent.VK_R) { 
            dx = 0;  
        }
    }
}
