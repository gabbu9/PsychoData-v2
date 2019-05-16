import org.junit.*;
public class GameTest{
    private Game game;
    @Before
    public void setup(){
        int test = 1;
        game = new Game(test);
    }
    @After
    public void teardown(){
        game = null;
    }
    @Test
    public void testSetNumPlayers_LessThanTwo(){
        Assert.assertEquals(false, game.setNumPlayers(1));
    }
    @Test
    public void testSetNumPlayers_GreaterThanEight(){
        Assert.assertEquals(false, game.setNumPlayers(9));
    }
    @Test
    public void testSetPosition_BetweenTwoAndEight(){
        Assert.assertEquals(true, game.setNumPlayers(5));
    }
}