public interface Map{
    public String type = "";
    public char[][] generate();
    public char getTileType(int x, int y);
    public int getSize();
}