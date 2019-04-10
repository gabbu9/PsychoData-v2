import java.util.Arrays;
class Map{
    private char[][] Map;
    private int size;
    public Map(int players){
        System.out.print('\u000C');
        if(players>=2&&players<=4){
            size = (int)(Math.random()*45)+5;
        }else if(players>=5&&players<=8){
            size = (int)(Math.random()*42)+8;
        }
        if(setMapSize(size,size)){
            generate();
            System.out.println("Generated Map with size: "+size+" x "+size);
            for(int i = 0;i<size;i++){
                for (int j = 0; j<size; j++){
                    System.out.print(getTileType(i,j)+" ");
                }
                System.out.print("\n");
            }
        }
    }
    public boolean setMapSize(int x, int y){
        if(x<=50&&y<=50&&x>=5&&y>=5){
            Map = new char[x][y];
            for(int i = 0;i<size;i++){
                for (int j = 0; j<size; j++){
                    Map[i][j] = 'g';
                }
            }
            return true;
        }else return false;
    }
    public void generate(){
        for(int i = 0; i<(int)size*1.5; i++){
            Map[(int)(Math.random()*size)][(int)(Math.random()*size)]='w';
        }
        Map[(int)(Math.random()*size)][(int)(Math.random()*size)]='y';
    }
    public char getTileType(int x, int y){
        return Map[x][y];
    }
}