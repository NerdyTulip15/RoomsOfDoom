public class Space {
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_PURPLE = "\033[0;35m";

    private final String DEFAULT_SYMBOL;
    private String symbol;
    private boolean entered;

    public Space(String s){
        DEFAULT_SYMBOL = s;
        symbol = "-";
        entered = false;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public boolean isEntered() {
        return entered;
    }

    public void reveal(){
        symbol = DEFAULT_SYMBOL;
    }

    public void enter(){
        reveal();
        entered = true;
    }

    public void trigger(){
        symbol = ANSI_GREEN + symbol + ANSI_RESET;
    }

    public void enterMessage(){
        System.out.println("You walked into a room. It's just a room. Nothing special here.");
    }

}
