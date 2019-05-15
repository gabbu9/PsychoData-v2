import org.junit.*;
/**
 * The test class PositionTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class SquareTest
{
    private Square_Map m;
    public SquareTest(){}
    
    @Before
    public void setUp(){
        m = new Square_Map(1,7);
    }
    
    @Test
    public void testGenerate(){
        Assert.assertNotNull(m.generate());
    }
    
    @Test
    public void testTileType(){
        Assert.assertNotNull(m.getTileType(4,4));
    }
    
    @Test
    public void testSize(){
        Assert.assertNotNull(m.getSize());
    }
    
    @Test
    public void testNegTileType(){
        Assert.assertEquals('n',m.getTileType(-4,-7));
    }
}
