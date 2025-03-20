public class InstaKill extends Damage{

    public InstaKill(String s, Player p){
        super(s,p.getHealth());
    }

    @Override
    public void enterMessage() {
        int num = (int)(Math.random()*5)+1;
        if (num==1) {
            System.out.println("A rock fell on your head and you died instantly");
        } else if (num==2){
            System.out.println("It turns out the room had lava instead of a floor and you melted to death");
        } else if (num==3){
            System.out.println("You saw an orange in the room and you ate it. You're deathly allergic to oranges, so you died");
        } else if (num==4){
            System.out.println("As soon as you entered the room, several guns shot at you");
        } else {
            System.out.println("You died. That's it.");
        }
    }
}
