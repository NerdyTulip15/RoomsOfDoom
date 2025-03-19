public class Space {
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";

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

    public void enter(){
        reveal();
        entered = true;
    }

    public void trigger(boolean t){
        if (!t) {
            symbol = ANSI_RED + symbol + ANSI_RESET;
        } else {
            symbol = ANSI_GREEN + symbol + ANSI_RESET;
        }
    }

    public void untrigger(){
        symbol = ANSI_BLUE+symbol+ANSI_RESET;
    }

    public void enterMessage(){
        System.out.println("You walked into a room. It's just a room. Nothing special here.");
    }

}
