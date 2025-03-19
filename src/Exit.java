public class Exit extends Space{
    public Exit(String s, int col){
        super(s);
        this.reveal();
    }

    @Override
    public void enterMessage() {
        System.out.println("You exited the building! Finally!!!");
    }
}
