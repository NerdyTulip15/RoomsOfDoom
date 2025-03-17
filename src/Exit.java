public class Exit extends Space{
    public Exit(String s, int col){
        super(s);
        this.reveal();
    }

    @Override
    public boolean isEntered() {
        return false;
    }
}
