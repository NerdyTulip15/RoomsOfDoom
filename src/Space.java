public class Space {
    private String defaultSymbol;
    private String symbol;
    private boolean entered;

    public Space(String s){
        defaultSymbol = s;
        symbol = "-";
        entered = false;
    }

    public String getSymbol() {
        return symbol;
    }

    public boolean isEntered() {
        return entered;
    }

    public void reveal(){
        symbol = defaultSymbol;
    }


}
