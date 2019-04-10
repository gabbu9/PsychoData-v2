import java.util.*;
public class Game{
    static Scanner in = new Scanner(System.in);
    int turns;
    static Player players[];
    Map map;
    public static void main(String args[]){
        int playerCount = in.nextInt();
        do{
            if(setNumPlayers(playerCount)){
                players = new Player[playerCount];
            }
            else{
                System.out.println("Player Count needs to be between 2 and 8");
                playerCount = in.nextInt();
            }
        }while(!setNumPlayers(playerCount));
    }
    public void startGame(){
    }
    public static boolean setNumPlayers(int n){
        if(n>=2 && n<=8){
            return true;
        }
        else{
            return false;
        }
    }
    public void generateHTMLFiles(){
    }
}