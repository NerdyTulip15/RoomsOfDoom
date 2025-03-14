public class Exit extends Space{
    private int[] location;
    public Exit(String s, int col){
        super(s);
        location = new int[]{0,col};
        this.reveal();
    }
}
