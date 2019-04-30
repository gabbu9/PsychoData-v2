import java.util.*;
import java.io.*;
public class Game{
    static Scanner in = new Scanner(System.in);
    //private int turns;
    static Player players[];
    static MyMap map;
    private int playerCount;
    private int mapType;
    private boolean treasure = false;
    
    public Game(){
        System.out.print('\u000C');
        String input;
        do{
            try{
               System.out.print("Choose Between:\n1: Safe Map\n2: Hazardous Map\n");
               input = in.next();
               mapType = Integer.parseInt(input);
            }catch (NumberFormatException e) {
                System.out.println("Map type needs to be between 1 and 2\n\nChoose Between:\n1: Safe Map\n2: Hazardous Map\n");
                input = in.next(); // this consumes the invalid token
            }
        }while(mapType != 1 && mapType != 2);
        System.out.print("Enter Player Count: ");
        try{
           input = in.next();
           playerCount = Integer.parseInt(input);
        }catch (NumberFormatException e) {
            System.out.println("Player Count needs to be between 2 and 8\n\nEnter Player Count");
            input = in.next(); // this consumes the invalid token
        }
        
        do{
            if(!setNumPlayers(playerCount)){
                System.out.println("Player Count needs to be between 2 and 8\n\nEnter Player Count");
                try{
                    input = in.next();
                    playerCount = Integer.parseInt(input);
                }catch (NumberFormatException e) {
                    System.out.println("Player Count needs to be between 2 and 8\n\nEnter Player Count");
                    input = in.next(); // this consumes the invalid token
                }
            }
        }while(!setNumPlayers(playerCount));
        players = new Player[playerCount];
        map = new MyMap(playerCount, mapType);
        for(int i = 0; i < playerCount; i++){
            System.out.print("Player "+(i+1)+" ");
            players[i] = new Player(map);
        }
        generateMainHTMLFile();
        generatePlayerHTMLFiles();
        startGame();
    }

    public void startGame(){
        int player = 0;
        do{
            System.out.println("Currently at: ("+players[player].getX()+","+players[player].getY()+")");
            System.out.print("Enter move for player "+(player+1)+": ");
            //players[player].move(in.next().charAt(0));
            if(players[player].move(in.next().charAt(0)) == false){
                do{
                    System.out.println("Moving out of Map\nPick another Move");
                    System.out.print("Enter move for player "+(player+1)+": ");
                    players[player].move(in.next().charAt(0));
                }while(players[player].move(in.next().charAt(0)) == false);
            }
            //if(map.getTileType(players[player].getX(),players[player].getY())=='w')alive[player]=false;
            //if(map.getTileType(players[player].getX(),players[player].getY())=='y')break;
            if(player == players.length-1)
                player = -1;
/*            if(player==playerCount-1){
                player=-1;
            }*/
            generatePlayerHTMLFiles();
            if(treasure == true){
                return;
            }
            player++;
        }while(player < players.length);
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
            StringBuilder table = new StringBuilder();
            String ROW_START = "<tr>";
            String ROW_END = "</tr>";
            String COLUMN_START = "<td";
            String COLUMN_END = "></td>";
            for(int i = 0; i < map.getSize(); i++){
                StringBuilder sb = new StringBuilder();
                sb.append(ROW_START);
                for(int j = 0; j < map.getSize(); j++){
                    sb.append(COLUMN_START);
                    coloured = false;
                    
                    //if(i == players[player].getY() && j == players[player].getX()){
                    if(players[player].getVisited(j,i)){
                        if(map.getTileType(i,j)=='w'){
                            sb.append(" class=\"tg-2n01\"");
                            players[player].returnToStart();
                            System.out.println("Player "+(player+1)+" died");
                        }
                        else if(map.getTileType(i,j)=='g')sb.append(" class=\"tg-d52n\"");
                        else if(map.getTileType(i,j)=='y'){
                            sb.append(" class=\"tg-kusv\"");
                            System.out.println("Player "+(player+1)+" found the treasure\nPlayer "+(player+1)+" Wins\nGame Over");
                            treasure = true;
                            return;
                        }
                        coloured = true;
                    }
                    //}
                    if(i == players[player].getY() && j == players[player].getX()){
                        sb.append("><img src=\"https://cdn2.iconfinder.com/data/icons/people-80/96/Picture1-16.png\"");
                    }else if(!coloured) sb.append(" class=\"tg-c6of\"");
                    sb.append(map.getTileType(i,j));
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
        for(int i = 0; i < map.getSize(); i++){
            StringBuilder sb = new StringBuilder();
            sb.append(ROW_START);
            for(int j = 0; j < map.getSize(); j++){
                sb.append(COLUMN_START);
                if(map.getTileType(i,j)=='w')sb.append(" class=\"tg-2n01\"");
                else if(map.getTileType(i,j)=='g')sb.append(" class=\"tg-d52n\"");
                else if(map.getTileType(i,j)=='y')sb.append(" class=\"tg-kusv\"");
                sb.append(map.getTileType(i,j));
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
