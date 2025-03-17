public class Player {
    private String name;
    private int health;
    private final int MAX_HP;
    private int[] location;

    public Player(String n, int h){
        name = n;
        health = h;
        MAX_HP = h;
        location = new int[]{8, 4};
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void damage(int d){
        health-=d;
    }

    public void heal(int h){
        health+=h;
        if (health>MAX_HP){
            health = MAX_HP;
        }
    }

    public int[] getLocation() {
        return location;
    }

    public void changeLocation(int r, int c){
        location[0]+=r;
        location[1]+=c;
    }

    public boolean isAlive(){
        if (health<=0){
            return false;
        }
        return true;
    }
}
