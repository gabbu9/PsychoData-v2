import java.awt.event.*;
import java.awt.Image;
import java.awt.Graphics2D;
import java.util.*;
public class Player{
    private static int randX = 0, randY = 0;   
    private static int maxSize;
    private Position pos = new Position();
    private Position startPos = new Position();
    private boolean[][] visited;
    public Player(){
        while(true){
            randX = (int)(Math.random()*SingletonMap.getInstance().getSize());
            randY = (int)(Math.random()*SingletonMap.getInstance().getSize());
            if(SingletonMap.getInstance().getTileType(randY,randX)=='g')break;
        }
        System.out.println("Start Position: ("+randX+","+randY+")");
        pos.setX(randX);
        pos.setY(randY);
        startPos.setX(randX);
        startPos.setY(randY);
        this.maxSize = SingletonMap.getInstance().getSize();
        visited = new boolean[SingletonMap.getInstance().getSize()][SingletonMap.getInstance().getSize()];
        visited[pos.getX()][pos.getY()] = true;
    }

    public boolean move(char direction){ //updating player position
        if(direction == 'U'){
            if(setPosition(pos.getY()-1)){
                pos.setY(pos.getY()-1);
            }else{
                return false;
            }
        }else if(direction == 'D'){
            if(setPosition(pos.getY()+1)){
                pos.setY(pos.getY()+1);
            }else{
                return false;
            }
        }else if(direction == 'R'){
            if(setPosition(pos.getX()+1)){
                pos.setX(pos.getX()+1);
            }else{
                return false;
            }
        }else if(direction == 'L'){
            if(setPosition(pos.getX()-1)){
                pos.setX(pos.getX()-1);
            }else{
                return false;
            }
        }else{
            System.out.println("Invalid direction");
            return false;
        }
        visited[pos.getX()][pos.getY()] = true;
        System.out.println("Moved to: ("+pos.getX()+","+pos.getY()+")");
        return true;
    }

    public boolean setPosition(int x){
        if(x < 0 || x > maxSize-1){
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
    
    public void returnToStart(){
        pos.setY(startPos.getY());
        pos.setX(startPos.getX());
    }
}
