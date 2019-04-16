import java.util.*;
import java.io.*;
public class Game{
    static Scanner in = new Scanner(System.in);
    int turns;
    static Player players[];
    Map map;

    public Game(){
        System.out.print("Enter number of players: ");
        int playerCount = in.nextInt();
        do{
            if(setNumPlayers(playerCount)){
                players = new Player[playerCount];
            }
            else{
                System.out.println("Player Count needs to be between 2 and 8");
                System.out.print("Enter number of players: ");
                playerCount = in.nextInt();
            }
        }while(!setNumPlayers(playerCount));
        generateHTMLFiles();
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
        File f = new File("htmlFile.html");
        String toWrite = "<html><table border=\"1\"><tr><th>1H</th><th>2H</th><th>3H</th></tr><tr>"+
                         "<td>1</td><td>2</td><td>3</td></tr><tr><td>4</td><td>5</td><td>6</td></tr><tr>"+
                         "<td>9</td><td>8</td><td>7</td></tr></table></html>";
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter(f));
            bw.write(toWrite);
            bw.close();
        }catch(IOException io){
            io.printStackTrace();
        }
        System.out.println("Wrote to file");
    }
}
