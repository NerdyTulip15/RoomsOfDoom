import java.util.Scanner;

public class RoomsOfDoom {
    private Player player;
    private Space[][] grid;
    private Scanner scan;
    private boolean testMode;

    public RoomsOfDoom(){
        grid = new Space[9][9];
        scan = new Scanner(System.in);
        testMode = false;
    }

    public void start(){
        System.out.println("Enter your name: ");
        String name = scan.nextLine();
        if (name.equalsIgnoreCase("lebron james")) {
            player = new Player(name, 200);
        } else if (name.equalsIgnoreCase("gametest")){
            testMode = true;
            player = new Player(name,100);
        } else{
            player = new Player(name, 100);
        }
        setGrid();
        play();

    }

    private void play() {
        printGrid();
    }

    private void setGrid(){
        for (int i=0;i<grid.length;i++){
            for (int j=0;j<grid[0].length;j++){
                int num = (int)(Math.random()*6)+1;
                if (num==1||num==2){
                    int damage = (int)(Math.random()*16)+5;
                    grid[i][j] = new Damage("!",damage);
                } else if (num==3){
                    int heal = (int)(Math.random()*6)+6;
                    grid[i][j] = new Heal("+",heal);
                } else {
                    grid[i][j] = new Space("_");
                }
                if (testMode){
                    grid[i][j].reveal();
                }
            }
        }

        int row = (int)(Math.random()*7)+1;
        int col = (int)(Math.random()*9);
        grid[row][col] = new InstaKill("X");
        if (testMode){
            grid[row][col].reveal();
        }

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
