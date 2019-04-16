import java.util.*;
import java.io.*;
public class Game{
    static Scanner in = new Scanner(System.in);
    int turns;
    static Player players[];
    static MyMap map;
    public static void main(String args[]){
        System.out.println("Enter Player Count");
        int playerCount = in.nextInt();
        do{
            if(!setNumPlayers(playerCount)){
                System.out.println("Player Count needs to be between 2 and 8\n\nEnter Player Count");
                playerCount = in.nextInt();
            }
        }while(!setNumPlayers(playerCount));
        players = new Player[playerCount];
        map = new MyMap(playerCount);
        generateHTMLFiles();
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

    public static void generateHTMLFiles(){
        File f = new File("htmlFile.html");
        StringBuilder table = new StringBuilder();
        String ROW_START = "<tr>";
        String ROW_END = "</tr>";
        String COLUMN_START = "<td>";
        String COLUMN_END = "</td>";

        for(int i = 0; i < MyMap.getSize(); i++){
            StringBuilder sb = new StringBuilder();

            sb.append(ROW_START);
            for(int j = 0; j < MyMap.getSize(); j++){
                sb.append(COLUMN_START);
                sb.append(MyMap.getTileType(i,j));
                sb.append(COLUMN_END);

            }
            sb.append(ROW_END);
            table.append(sb.toString());
        }
        String toWrite = "<html><table border=\"1\">"+table.toString()+"</table></html>";
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
