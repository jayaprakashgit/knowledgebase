package com.interlan.test.java7;

import java.util.Random;

public final class JavaMonopoly {
	
    public int[] board;
    public long[] rolls;
    public int funds = 0;
    public long loops = 0;
    
    public JavaMonopoly(String[] args) {
        board = new int[40];
        rolls = new long[20];
        int num = Integer.parseInt("12");
        board = game(num, board);
        printBoard();
    }
 

    public int[] game(int count, int[] board) {
                int spot = 0;
                funds = 1500;
                Die die1 = new Die();
                Die die2 = new Die();
        for(int x = 0; x < count; x++) {
            int roll = (die1.getValue() + die2.getValue());
            spot = spot + roll;
            if(spot >= 40) {
                spot = spot - 40;
                                funds += 200;
                loops++;
            }
            board[spot]++;
            if(spot == 30) {
                funds -= 50;
            }
            else if(spot == 7 || spot == 22 || spot == 36) {
                funds -= 0;
            }
            else if(spot == 2 || spot == 17 || spot == 33) {
                funds -= 0;
            }
        }
        return(board);
    }
    public void printBoard() {
        System.out.println("GO collect $200              = "+board[0]);
        System.out.println("Mediterreanian Ave [purple]  = "+board[1]);
        System.out.println("Community Chest              = "+board[2]);
        System.out.println("Baltic Ave         [purple]  = "+board[3]);
        System.out.println("INCOME TAX                   = "+board[4]);
        System.out.println("Reading Railroad    < RR >   = "+board[5]);
        System.out.println("Oriental Ave       [cyan]    = "+board[6]);
        System.out.println("Chance                       = "+board[7]);
        System.out.println("Vermont Ave        [cyan]    = "+board[8]);
        System.out.println("Connecticut Ave    [cyan]    = "+board[9]);
        System.out.println("Jail                         = "+board[10]);
        System.out.println("St. Charles Place  [magenta] = "+board[11]);
        System.out.println("Electic Company    (Utility) = "+board[12]);
        System.out.println("States Ave         [magenta] = "+board[13]);
        System.out.println("Virginia Ave       [magenta] = "+board[14]);
        System.out.println("Pennsylvania RR     < RR >   = "+board[15]);
        System.out.println("St James Place     [orange]  = "+board[16]);
        System.out.println("Community Chest              = "+board[17]);
        System.out.println("Tennessee Ave      [orange]  = "+board[18]);
        System.out.println("New York Ave       [orange]  = "+board[19]);
        System.out.println("Free Parking                 = "+board[20]);
        System.out.println("Kentucky Ave       [red]     = "+board[21]);
        System.out.println("Chance                       = "+board[22]);
        System.out.println("Indiana Ave        [red]     = "+board[23]);
        System.out.println("Illinois Ave       [red]     = "+board[24]);
        System.out.println("B&O Railroad        < RR >   = "+board[25]);
        System.out.println("Atlantic Ave       [yellow]  = "+board[26]);
        System.out.println("Ventnor Ave        [yellow]  = "+board[27]);
        System.out.println("Water Works        (Utility) = "+board[28]);
        System.out.println("Marvin Gardens     [yellow]  = "+board[29]);
        System.out.println("GO TO JAIL                   = "+board[30]);
        System.out.println("Pacific Ave        [green]   = "+board[31]);
        System.out.println("North Carolina Ave [green]   = "+board[32]);
        System.out.println("Community Chest              = "+board[33]);
        System.out.println("Pennsylvania Ave   [green]   = "+board[34]);
        System.out.println("Short Line RR       < RR >   = "+board[35]);
        System.out.println("Chance                       = "+board[36]);
        System.out.println("Park Place         [blue]    = "+board[37]);
        System.out.println("LUXURY TAX                   = "+board[38]);
        System.out.println("Boardwalk          [blue]    = "+board[39]);
        System.out.println("\nProperties:");
        System.out.println("purple  = "+(board[1]+board[3]));
        System.out.println("cyan    = "+(board[6]+board[8]+board[9]));
        System.out.println("magenta = "+(board[11]+board[13]+board[14]));
        System.out.println("orange  = "+(board[16]+board[18]+board[19]));
        System.out.println("red     = "+(board[21]+board[23]+board[24]));
        System.out.println("yellow  = "+(board[26]+board[27]+board[29]));
        System.out.println("green   = "+(board[31]+board[32]+board[34]));
        System.out.println("blue    = "+(board[37]+board[39]));
        System.out.println("RR      = "+(board[5]+board[15]+board[25]+board[35]));
        System.out.println("Utility = "+(board[12]+board[28]));
        System.out.println("chance  = "+(board[7]+board[22]+board[36]));
        System.out.println("chest   = "+(board[2]+board[17]+board[33]));
        System.out.println("Ooops  = "+(board[4]+board[30]+board[38]));
        System.out.println("\nThe board was traversed a total of "+loops+" times");
        System.out.print("\nRolls: ");
        for(int x = 1; x <= 13; x++) {
            System.out.print("(" + x + ") = " + rolls[x] + " ");
        }
                System.out.println("\n\n");
        }
        /**
         * This is where we will instantiate the Die objects
         * @param args the command line arguments
        */
    public static void main(String[] args) {
            JavaMonopoly game = new JavaMonopoly(args);
            // Instantiate away!
            Die die1 = new Die();
            Die die2 = new Die();
            //Die die3 = new Die();
            // Die1, 2, 3 are reference variables!
            System.out.println("Die 1's value is " + die1.getValue());
            System.out.println("Die 2's value is " + die2.getValue());
            //System.out.println("Die 3's value is "+ die3.getValue());
            System.out.println("your Total is: " + (die1.getValue() + die2.getValue()));
        }
}

/**
*
* The Die Class should have a integer (int) called value that will contain the die's value.
* In addition, two constants, HIGHEST_DIE_VALUE (= 6) and LOWEST_DIE_VALUE (=1) should be declared.
* When the default constructor is called, the roll method will be called. In the roll method, a
*random number between 1 and 6  will be generated and stored in an instance variable called value.
* 
* @author JP
* 
*/
class Die {
    public static final int Highest_Die_Value = 6;
    public static final int Lowest_Die_Value = 1;    
    private int value;
    /**
     * Default constructor
     */
    public Die(){
        roll();
    }
    /**
     * Overloaded constructor
     */
    public Die ( int value){
        this.value = value;
    }
    /**
     * This will assign a random value to this die object
     */
    public void roll(){
        Random rand = new Random(); // create a new Random Object
        this.value = rand.nextInt(Highest_Die_Value) + Lowest_Die_Value;
    }
    /**
     * Getter for the Die Object's value
     * @return the value of this Die
     */
    public int getValue(){
        return this.value;
    }
}
