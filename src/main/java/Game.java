import java.util.*;
import java.io.*;
public class Game{
    static Scanner in = new Scanner(System.in);
    //private int turns;
    static Player players[];
    private boolean alive[];
    static MyMap map;
    private int playerCount;
    private Vector<Position> visited = new Vector<Position>();
    
    public Game(){
        System.out.print('\u000C');
        System.out.print("Enter Player Count: ");
        playerCount = in.nextInt();
        do{
            if(!setNumPlayers(playerCount)){
                System.out.println("Player Count needs to be between 2 and 8\n\nEnter Player Count");
                playerCount = in.nextInt();
            }
        }while(!setNumPlayers(playerCount));
        players = new Player[playerCount];
        alive = new boolean[playerCount];
        map = new MyMap(playerCount);
        for(int i = 0; i < playerCount; i++){
            System.out.print("Player "+(i+1)+" ");
            players[i] = new Player(map);
            alive[i] = true;
        }
        generateMainHTMLFile();
        generatePlayerHTMLFiles();
        startGame();
    }

    public void startGame(){
        for(int i = -1;i<playerCount;){
            i++;
            if(alive[i]==true){
                System.out.println("Currently at: ("+players[i].getX()+","+players[i].getY()+")");
                System.out.print("Enter move for player "+(i+1)+": ");
                players[i].move(in.next().charAt(0));
                if(map.getTileType(players[i].getX(),players[i].getY())=='w')alive[i]=false;
                if(map.getTileType(players[i].getX(),players[i].getY())=='y')break;
            }
            if(i==playerCount-1){
                i=-1;
            }
            generatePlayerHTMLFiles();
        }
    }

    public boolean setNumPlayers(int n){
        if(n>=2 && n<=8){
            return true;
        }else{
            return false;
        }
    }

    public void generatePlayerHTMLFiles(){
        int player = 0;
        boolean coloured = false;
        do{
            File f = new File("map_player_"+(player+1)+".html");
            visited = new Vector<Position>(players[player].getVisited());
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
                    coloured = false;
                    for(Position pos : visited){
                        if(i == pos.getY() && j == pos.getX()){
                            sb.append(" class=\"tg-d52n\"");
                            coloured = true;
                        }
                    }
                    if(i == players[player].getY() && j == players[player].getX()){
                        sb.append("><img src=\"https://cdn2.iconfinder.com/data/icons/people-80/96/Picture1-64.png\"");
                    }else if(!coloured) sb.append(" class=\"tg-c6of\"");
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
            System.out.println("Wrote to file: map_player_"+(player+1)+".html");
            player++;
        }while(player < players.length);
    }
    
    public void generateMainHTMLFile(){
        File f = new File("mapFile.html");
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
        System.out.println("Wrote to file: mapFile.html");
    }
}