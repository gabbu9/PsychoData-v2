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
        String COLUMN_START = "<td";
        String COLUMN_END = "></td>";
        for(int i = 0; i < MyMap.getSize(); i++){
            StringBuilder sb = new StringBuilder();
            sb.append(ROW_START);
            for(int j = 0; j < MyMap.getSize(); j++){
                sb.append(COLUMN_START);
                if(MyMap.getTileType(i,j)=='w')sb.append(" class=\"tg-2n01\"");
                else if(MyMap.getTileType(i,j)=='g')sb.append(" class=\"tg-d52n\"");
                else if(MyMap.getTileType(i,j)=='y')sb.append(" class=\"tg-kusv\"");
                sb.append(MyMap.getTileType(i,j));
                sb.append(COLUMN_END);
            }
            sb.append(ROW_END);
            table.append(sb.toString());
        }
        String style = "<style type=\"text/css\">.tg  {border-collapse:collapse;border-spacing:0;}.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:black;}.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:black;}.tg .tg-kusv{background-color:#fffe65;border-color:inherit;text-align:left;vertical-align:top}.tg .tg-2n01{background-color:#3531ff;border-color:inherit;text-align:left;vertical-align:top}.tg .tg-d52n{background-color:#32cb00;border-color:inherit;text-align:left;vertical-align:top}.tg .tg-0pky{border-color:inherit;text-align:left;vertical-align:top}</style>";
        String toWrite = style+"<table class=\"tg\">"+table.toString()+"</table>";
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