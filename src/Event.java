import java.util.Scanner;

public class Event extends Space{
    private Player player;
    private Scanner scan;
    private boolean autograph;
    public Event(String s, Player p){
        super(s);
        player = p;
        scan = new Scanner(System.in);
        autograph = false;
    }

    @Override
    public void enterMessage() {
        int num = (int)(Math.random()*5)+1;
        String input = "";
        if (num==1){
            System.out.println("Hey, "+player.getName());
            System.out.println("Did you know that you can't hum if you hold your nose?");
            System.out.println("You should try it sometime!");
        } else if (num==2){
            System.out.println("Hello, "+player.getName());
            System.out.println("Which drink would you like?");
            System.out.println("A) Water");
            System.out.println("B) Mystery Drink");
            System.out.println("C) Orange Juice");
            System.out.println("D) No thanks");
            input = scan.nextLine();
            while (!input.equalsIgnoreCase("a")&&!input.equalsIgnoreCase("b")&&!input.equalsIgnoreCase("c")&&!input.equalsIgnoreCase("d")){
                System.out.println("You can't have that, "+player.getName()+"! You've gotta pick something else.");
            }
            if (input.equalsIgnoreCase("a")){
                System.out.println("You drank the water. It's very refreshing.");
                player.heal(10);
            } else if (input.equalsIgnoreCase("b")){
                System.out.print("You drank the mystery drink. ");
                num = (int)(Math.random()*2)+1;
                if (num==1) {
                    System.out.println("It tastes really good!");
                } else {
                    System.out.println("Turns out it was poisoned and you took some damage");
                    player.damage(10);
                }
            } else if (input.equalsIgnoreCase("c")){
                System.out.println("You drank the orange juice");
                System.out.println("Unfortunately, you're deathly allergic to oranges, so you died");
                player.damage(player.getHealth());
            } else {
                System.out.println("That's probably for the best");
            }
        } else if (num==3){
            System.out.println("Sometimes I wonder if I should've made this game with a GUI");
        } else if (num==4){
            System.out.println(player.getName()+", did you know that you have an orange allergy?");
            System.out.println("A) I do?");
            input = scan.nextLine();
            System.out.println("Yeah! You're deathly allergic. I wouldn't suggest having anything orange-related");
            System.out.println("A) okay...");
            input = scan.nextLine();
            //I think I'm too obsessed with In Stars and Time
        } else {
            if (player.getName().equalsIgnoreCase("lebron james")&&!autograph){
                System.out.println("Hey, you're LeBron James, right?");
                System.out.println("Can I get your autograph?");
                System.out.println("A) Sure!");
                input = scan.nextLine();
                System.out.println("Thank you! I shall treasure this forever!!! :D");
                autograph = true;
            } else {
                System.out.println(player.getName()+", would you like a cookie?");
                System.out.println("A) Sure?");
                System.out.println("B) No thanks");
                input = scan.nextLine();
                if (input.equalsIgnoreCase("a")){
                    System.out.println("You ate the cookie. It tastes nice");;
                } else {
                    System.out.println("Fine. More for me then");
                }
            }
        }
    }

    @Override
    public void trigger(){
        setSymbol(ANSI_PURPLE + getSymbol() + ANSI_RESET);
    }


}
