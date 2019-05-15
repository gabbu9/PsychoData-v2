import java.util.*;
public class MapFactory{
    public Map getMap(String type, int sH, int players){
        if(type.equalsIgnoreCase("Square")){
            return new Square_Map(sH,players);
        }else{
            return null;
        }
    }
}