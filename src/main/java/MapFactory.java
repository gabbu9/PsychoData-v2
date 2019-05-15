import java.util.*;
public class MapFactory{
    public Map getMap(String type, int sH, int players){
        if(type.equalsIgnoreCase("RECTANGLE")){
            return new Rectangular_Map(sH,players);
        }else{
            return null;
        }
    }
}