import java.util.Scanner;

public class Event extends Space{
    private Player player;
    private Scanner scan;
    private boolean autograph;
    private boolean allergyInfo;
    public Event(String s, Player p){
        super(s);
        player = p;
        scan = new Scanner(System.in);
        autograph = false;
        allergyInfo = false;
    }

    @Override
    public void enterMessage() {
        int num = (int)(Math.random()*7)+1;
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
                System.out.println("You drink the water. It's very refreshing.");
                player.heal(10);
            } else if (input.equalsIgnoreCase("b")){
                System.out.print("You drink the mystery drink. ");
                num = (int)(Math.random()*2)+1;
                if (num==1) {
                    System.out.println("It tastes really good!");
                } else {
                    System.out.println("Turns out it was poisoned and you took some damage");
                    player.damage(10);
                }
            } else if (input.equalsIgnoreCase("c")){
                System.out.println("You drink the orange juice");
                System.out.println("Unfortunately, you're deathly allergic to oranges, so you die");
                player.damage(player.getHealth());
            } else {
                System.out.println("That's probably for the best");
            }
        } else if (num==3){
            System.out.println("Sometimes I wonder if I should've made this game with a GUI");
        } else if (num==4){
            if (!allergyInfo) {
                System.out.println(player.getName() + ", did you know that you have an orange allergy?");
                System.out.println("A) I do?");
                input = scan.nextLine();
                System.out.println("Yeah! You're deathly allergic. I wouldn't suggest having anything orange-related");
                System.out.println("A) okay...");
                input = scan.nextLine();
                allergyInfo = true;
                //I think I'm too obsessed with In Stars and Time
            } else {
                System.out.println("Hello, "+player.getName()+"!");
                System.out.println("Welcome to my lemonade stand!");
                System.out.println("What would you like?");
                System.out.println("A) Lemonade");
                System.out.println("B) Grapes");
                System.out.println("C) Nothing");
                input = scan.nextLine();
                while (!input.equalsIgnoreCase("a")&&!input.equalsIgnoreCase("b")&&!input.equalsIgnoreCase("c")){
                    System.out.println("You can't have that, "+player.getName()+"! You've gotta pick something else.");
                }
                if (input.equalsIgnoreCase("a")){
                    System.out.println("You drink the lemonade");
                    System.out.println("It's refreshing! But not refreshing enough to heal you.");
                } else if (input.equalsIgnoreCase("b")){
                    System.out.println("...");
                    System.out.println("bro");
                    player.damage(5);
                } else {
                    System.out.println("Fine. More for me then.");
                }
            }
        } else if (num==5){
            if (player.getName().equalsIgnoreCase("lebron james")&&!autograph){
                System.out.println("Hey, you're LeBron James, right?");
                System.out.println("Can I get your autograph?");
                System.out.println("A) Sure!");
                input = scan.nextLine();
                System.out.println("Thank you! I shall treasure this forever!!! :D");
                autograph = true;
                player.heal(5);
                //I'm not actually a LeBron James fan I just put this in for fun
            } else {
                System.out.println(player.getName()+", would you like a cookie?");
                System.out.println("A) Sure?");
                System.out.println("B) No thanks");
                input = scan.nextLine();
                if (input.equalsIgnoreCase("a")){
                    System.out.println("You eat the cookie. It tastes nice");;
                } else {
                    System.out.println("Fine. More for me then");
                }
            }
        } else {
            System.out.println(player.getName()+", I'm starting to think that this game could use a few more challenges");
            System.out.println("A) Are you sure? Aren't all the dangerous rooms enough?");
            input = scan.nextLine();
            System.out.println("No. You players can still get out easily");
            System.out.println("You know what would make this game more challenging?");
            System.out.println("A RIDDLE!!!!!");
            System.out.println("A) Is that really necessary?");
            input = scan.nextLine();
            System.out.println("Yes, "+player.getName()+". Yes it is.");
            num = (int)(Math.random()*5)+1;
            System.out.println("I've got a good one, too!");
            String answer = "";
            if (num==1){
                answer = "echo";
                System.out.println("I speak without a mouth and hear without ears");
                System.out.println("I have no body, but I come alive with wind");
                System.out.println("What am I?");
                System.out.println("(ENTER ONE WORD ANSWER BELOW)");
                input = scan.nextLine();

            } else if (num==2){
                answer = "map";
                System.out.println("I have cities, but no houses");
                System.out.println("I have mountains, but no trees");
                System.out.println("I have water, but no fish");
                System.out.println("What am I?");
                System.out.println("(ENTER ONE WORD ANSWER BELOW)");
            } else if (num==3){
                answer = "egg";
                System.out.println("What has to be broken before you can use it?");
                System.out.println("(ENTER ONE WORD ANSWER BELOW)");
                input = scan.nextLine();
            } else if (num==4){
                answer = "darkness";
                System.out.println("The more of this there is, the less you see");
                System.out.println("What am I?");
                System.out.println("(ENTER ONE WORD ANSWER BELOW)");
                input = scan.nextLine();
            } else {
                answer = "david";
                System.out.println("David's parents have 3 sons: Snap, Crackle, and-");
                System.out.println("What's the name of the third son?");
                System.out.println("(ENTER ONE WORD ANSWER BELOW)");
                input = scan.nextLine();
            }

            if (input.equalsIgnoreCase(answer)){
                System.out.println("Wow, "+player.getName()+", you got it right! You smart cookie.");
                System.out.println("Would be a shame if you'd gotten that wrong");
                System.out.println("You may continue!");
            } else {
                System.out.println("YOU GOT IT WRONG!!! YOU TAKE 50 DAMAGE!!!");
                player.damage(50);
                System.out.println("Wasn't that so challenging?");
                System.out.println("A) WHY WOULD YOU DO THAT?!");
                input = scan.nextLine();
                System.out.println("I told you! I wanted this game to be more challenging.");
                System.out.println("Toodles!");
            }
        }
    }

    @Override
    public void trigger(){
        setSymbol(ANSI_PURPLE + getSymbol() + ANSI_RESET);
    }


}
