import org.junit.*;
/**
 * The test class PositionTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class PositionTest
{
    private Position pos;
    public PositionTest(){}
    
    @Before
    public void setUp(){
        pos = new Position();
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown(){
        
    }
    
    
    @Test
    public void testSetGetX(){
        pos.setX(5);
        Assert.assertEquals(5,pos.getX());
    }
    
    @Test
    public void testSetGetY(){
        pos.setY(5);
        Assert.assertEquals(5,pos.getY());
    }
    
    @Test
    public void testSetGetNegX(){
        pos.setX(-5);
        Assert.assertEquals(-5,pos.getX());
    }
    
    @Test
    public void testSetGetNegY(){
        pos.setY(-5);
        Assert.assertEquals(-5,pos.getY());
    }
}
