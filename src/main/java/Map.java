import java.util.Arrays;
class MyMap{
    private static char[][] MyMap;
    private static int size;
    public MyMap(int players){
        System.out.print('\u000C');
        if(players>=2&&players<=4){
            size = (int)(Math.random()*45)+5;
        }else if(players>=5&&players<=8){
            size = (int)(Math.random()*42)+8;
        }
        if(setMapSize(size,size)){
            generate();
            System.out.println("Generated Map with size: "+size+" x "+size);
        }
    }
    public boolean setMapSize(int x, int y){
        if(x<=50&&y<=50&&x>=5&&y>=5){
            MyMap = new char[x][y];
            for(int i = 0;i<size;i++){
                for (int j = 0; j<size; j++){
                    MyMap[i][j] = 'g';
                }
            }
            return true;
        }else return false;
    }
    public void generate(){
        for(int i = 0; i<(int)size*1.5; i++){
            MyMap[(int)(Math.random()*size)][(int)(Math.random()*size)]='w';
        }
        MyMap[(int)(Math.random()*size)][(int)(Math.random()*size)]='y';
    }
    public static char getTileType(int x, int y){
        return MyMap[x][y];
    }
    public static int getSize(){
        return size;
    }
    public static char[] getMyMap(int i){
        return MyMap[i];
    }
}
