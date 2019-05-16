import org.junit.*;
/**
 * The test class PositionTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class FactoryTest
{
    private MapFactory fac;
    public FactoryTest(){}
    
    @Before
    public void setUp(){
        fac = new MapFactory();
    }
    
    @Test
    public void testGetMapExist(){
        Assert.assertNotNull(fac.getMap("Square",1,5));
    }
    
    @Test
    public void testNonExistantMap(){
        Assert.assertNull(fac.getMap("@#",1,5));
    }
}
