public class Damage extends Space{
    private int damageGiven;

    public Damage(String s, int d){
        super(s);
        damageGiven = d;
    }

    public int getDamageGiven() {
        return damageGiven;
    }
}
