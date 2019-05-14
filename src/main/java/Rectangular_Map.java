public class Rectangular_Map implements Map{
    char[][] MyMap;
    public String type = "Rectangular";
    int sH;
    int size;
    public Rectangular_Map(int sH, int players){
        if(players>=2&&players<=4){
            this.size = (int)(Math.random()*45)+5;
        }else if(players>=5&&players<=8){
            this.size = (int)(Math.random()*42)+8;
        }
        this.sH = sH;
        MyMap = new char[size][size];
        for(int i = 0;i<size;i++){
            for (int j = 0; j<size; j++){
                MyMap[i][j] = 'g';
            }
        }
    }
    
    @Override
    public char[][] generate(){
        if(sH == 1){
            double percentage = ((int)(Math.random()*10));
            percentage = percentage / 100;
            for(int i = 0; i<(int)size*size*percentage; i++){
                MyMap[(int)(Math.random()*size)][(int)(Math.random()*size)]='w';
            }
        }else if(sH == 2){
            double percentage = ((int)((Math.random()*10)+25));
            percentage = percentage / 100;
            for(int i = 0; i<(int)size*size*percentage; i++){
                MyMap[(int)(Math.random()*size)][(int)(Math.random()*size)]='w';
            }
        }
        MyMap[(int)(Math.random()*size)][(int)(Math.random()*size)]='y';
        System.out.println("Generated Map with size: "+size+" x "+size);
        return MyMap;
    }
    
    @Override
    public char getTileType(int x, int y){
        return MyMap[y][x];
    }
    
    @Override
    public int getSize(){
        return size;
    }
}
