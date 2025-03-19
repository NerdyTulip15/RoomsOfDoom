public class Damage extends Space{
    private int damageGiven;

    public Damage(String s, int d){
        super(s);
        damageGiven = d;
    }

    public int getDamageGiven() {
        return damageGiven;
    }

    @Override
    public void enterMessage() {
        System.out.println("You walked into a dangerous room and took some damage");
    }
}
