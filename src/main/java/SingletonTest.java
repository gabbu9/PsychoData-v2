import org.junit.*;
/**
 * The test class PositionTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class SingletonTest
{
    private SingletonMap sMap;
    public SingletonTest(){}
    
    @Before
    public void setUp(){
        sMap.init(1,4);
    }
    
    @Test
    public void testGetInstance(){
        Assert.assertNotNull(sMap.getInstance());
    }
    
    @Test
    public void testSingGetSize(){
        Assert.assertNotNull(sMap.getInstance().getSize());
    }
    
    @Test
    public void testTileType(){
        Assert.assertNotNull(sMap.getInstance().getTileType(2,2));
    }
    
    @Test
    public void testNegTileType(){
        Assert.assertEquals('n',sMap.getInstance().getTileType(-2,2));
    }
}
