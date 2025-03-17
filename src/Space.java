import java.awt.*;

public class Space {
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_RESET = "\u001B[0m";

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
        entered = true;
    }

    public void trigger(){
        symbol = ANSI_RED+symbol+ANSI_RESET;
    }

    public void untrigger(){
        symbol = ANSI_WHITE+symbol+ANSI_RESET;
    }


}
