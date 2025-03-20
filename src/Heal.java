public class Heal extends Space{
    private int healAmount;

    public Heal(String s, int h){
        super(s);
        healAmount = h;
    }

    public int getHealAmount() {
        return healAmount;
    }

    @Override
    public void enterMessage() {
        System.out.println("You walked into the room. It magically heals your wounds (don't ask)");
    }

    @Override
    public void trigger() {
        setSymbol(ANSI_BLUE + getSymbol() + ANSI_RESET);
    }
}
