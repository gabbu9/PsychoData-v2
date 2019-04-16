import java.awt.event.*;
import java.awt.Image;
import java.awt.Graphics2D;
import java.util.*;
public class Player{
    private static int randX = 0, randY = 0;   
    private static int maxSize;
    private Position pos = new Position();
    private boolean[][] visited;
    public Player(MyMap currMap){
        do{
            randX = (int)(Math.random()*currMap.getSize());
            randY = (int)(Math.random()*currMap.getSize());
        }while(currMap.getTileType(randX,randY)!='g');
        System.out.println("Start Position: ("+randX+","+randY+")");
        pos.setX(randX);
        pos.setY(randY);
        this.maxSize = currMap.getSize();
        visited = new boolean[currMap.getSize()][currMap.getSize()];
        visited[pos.getX()][pos.getY()] = true;
    }//not sure if you can generate multiple players

    public void move(char direction){ //updating player position
        if(direction == 'U'){
            if(setPosition(pos.getY()-1)){
                pos.setY(pos.getY()-1);
            }
        }else if(direction == 'D'){
            if(setPosition(pos.getY()+1)){
                pos.setY(pos.getY()+1);
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
        visited[pos.getX()][pos.getY()] = true;
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
    
    public boolean getVisited(int i,int j){
        return visited[i][j];
    }
}
