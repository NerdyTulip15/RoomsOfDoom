import java.util.Scanner;
public class RoomsOfDoom {

    private Player player;
    private Space[][] grid;
    private Scanner scan;

    public RoomsOfDoom(){
        grid = new Space[9][9];
        scan = new Scanner(System.in);
    }

    public void start(){
        System.out.println("Enter your name: ");
        String name = scan.nextLine();
        if (name.equalsIgnoreCase("lebron james")) {
            player = new Player(name, 200);
        } else{
            player = new Player(name, 100);
        }
        setGrid();
        play();

    }

    private void play() {
        boolean exited = false;
        printGrid();
        int[] playerLocation = player.getLocation();
        Space previousSpace = null;
        while (player.isAlive()&&!exited) {
            grid[playerLocation[0]][playerLocation[1]].trigger(true);
            if (previousSpace!=null){
                previousSpace.untrigger();
            }
            System.out.println("Health: "+player.getHealth());
            System.out.println("Use WASD to move");
            String input = scan.nextLine().toLowerCase();
            while (!input.equalsIgnoreCase("w")&&!input.equalsIgnoreCase("a")&&!input.equalsIgnoreCase("s")&&!input.equalsIgnoreCase("d")){
                System.out.println("Invalid input. Try again");
                input = scan.nextLine().toLowerCase();
            }
            playerLocation = player.getLocation();
            boolean validPlace = false;
            if (input.equals("w")&&playerLocation[0]!=0&&!grid[playerLocation[0]-1][playerLocation[1]].isEntered()){
                player.changeLocation(-1,0);
                validPlace = true;
            } else if (input.equals("s")&&playerLocation[0]!=8&&!grid[playerLocation[0]+1][playerLocation[1]].isEntered()){
                player.changeLocation(1,0);
                validPlace = true;
            } else if (input.equals("a")&&playerLocation[1]!=0&&!grid[playerLocation[0]][playerLocation[1]-1].isEntered()){
                player.changeLocation(0,-1);
                validPlace = true;
            } else if (input.equals("d")&&playerLocation[1]!=8&&!grid[playerLocation[0]][playerLocation[1]+1].isEntered()){
                player.changeLocation(0,1);
                validPlace = true;
            } else {
                System.out.println("You've already entered this room. There's no going back");
            }

            if (validPlace){
                Space space = grid[playerLocation[0]][playerLocation[1]];
                space.reveal();
                space.trigger(false);
                printGrid();
                switch (space) {
                    case Damage damage -> {
                        System.out.println("You walked into a dangerous room and took some damage");
                        player.damage(damage.getDamageGiven());
                    }
                    case Heal heal -> {
                        System.out.println("You walked into a safe room and tended to some of your wounds");
                        player.heal(heal.getHealAmount());
                    }
                    case Exit exit -> {
                        exited = true;
                        System.out.println("You found the exit and left the building");
                    }
                    default -> System.out.println("You walked into a room. It's just a room. Nothing special here.");
                }
                previousSpace = space;

            }

        }

        if (!player.isAlive()){
            System.out.println("GAME OVER");
            System.out.println("You died");
        } else {
            System.out.println("YOU WON");
        }
    }

    private void setGrid(){
        for (int i=0;i<grid.length;i++){
            for (int j=0;j<grid[0].length;j++){
                int num = (int)(Math.random()*10)+1;
                if (num==1||num==2||num==4||num==5){
                    int damage = (int)(Math.random()*16)+5;
                    grid[i][j] = new Damage("!",damage);
                } else if (num==3){
                    int heal = (int)(Math.random()*6)+6;
                    grid[i][j] = new Heal("+",heal);
                } else {
                    grid[i][j] = new Space("_");
                }
            }
        }

        int row = (int)(Math.random()*7)+1;
        int col = (int)(Math.random()*9);
        grid[row][col] = new InstaKill("X");

        grid[8][4] = new Space("S");
        grid[8][4].reveal();
        col = (int)(Math.random()*9);
        grid[0][col] = new Exit("E",col);
    }

    private void printGrid(){
        for (Space[] row : grid){
            for (Space space:row){
                System.out.print("["+space.getSymbol()+"]");
            }
            System.out.println();
        }
    }


}
