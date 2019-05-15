public class SingletonMap{
    private static Map map1;
    private SingletonMap(){};
    public static Map getInstance(){
        return map1;
    }
    
    public static void init(int sH, int players){
        map1 = new MapFactory().getMap("square",sH, players);
        map1.generate();
    }
}