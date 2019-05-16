import org.junit.*;
public class PlayerTest{
    private Player player;
    @Before
    public void setup(){
        SingletonMap.init(0,5);
        player = new Player();
    }
    @After
    public void teardown(){
        player = null;
    }
    @Test
    public void testMove_MoveUp(){
        player.move('D');
        Assert.assertEquals(true, player.move('U'));
    }
    @Test
    public void testMove_MoveDown(){
        player.move('U');
        Assert.assertEquals(true, player.move('D'));
    }
    @Test
    public void testMove_MoveLeft(){
        player.move('R');
        Assert.assertEquals(true, player.move('L'));
    }
    @Test
    public void testMove_MoveRight(){
        player.move('L');
        Assert.assertEquals(true, player.move('R'));
    }
    @Test
    public void testMove_MoveInvalid(){
        Assert.assertEquals(false, player.move('P'));
    }
    @Test
    public void testSetPosition_GreaterThanMapSize(){
        Assert.assertEquals(false, player.setPosition(SingletonMap.getInstance().getSize()));
    }
    @Test
    public void testSetPosition_LessThanZero(){
        Assert.assertEquals(false, player.setPosition(-1));
    }
    @Test
    public void testSetPosition_BetweenZeroAndMapSize(){
        Assert.assertEquals(true, player.setPosition(SingletonMap.getInstance().getSize()-2));
    }
    @Test
    public void testGetX_SameAsSetX(){
        player.setX(2);
        Assert.assertEquals(2, player.getX());
    }
    @Test
    public void testGetY_SameAsSetY(){
        player.setY(7);
        Assert.assertEquals(7, player.getY());
    }
    @Test
    public void testGetVisited_EitherTrueOrFalse(){
        Assert.assertNotNull(player.getVisited(1,2));
    }
}