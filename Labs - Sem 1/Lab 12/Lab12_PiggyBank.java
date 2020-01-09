//Lee
//Lab 12 - Piggy Bank
//To practice and get an introduction to OOP 
//Extensions: TBD

import java.util.*;
public class Lab12_PiggyBank {
    private int pennies, nickels, dimes, quarters;
    
    //Empty piggybank
    Lab12_PiggyBank(){
        pennies = 0;
        nickels = 0;
        dimes = 0;
        quarters = 0;
    }
    
    //Piggybank with money
    Lab12_PiggyBank(int p, int n, int d, int q){
        pennies = p;
        nickels = n;
        dimes = d;
        quarters = q;
    }
    
    //Add coins or an entire pile
    public void addPennies(int addP){
        pennies += addP;
    }
    public void addNickels(int addN){
        nickels += addN;
    }
    public void addDimes(int addD){
        dimes += addD;
    }
    public void addQuarters(int addQ){
        quarters += addQ;
    }
    public void addPile(int addP, int addN, int addD, int addQ){
        pennies += addP;
        nickels += addN;
        dimes += addD;
        quarters += addQ;
    }
    
    //Getters for net worth and for each type of coin
    public int getValue(){
        return pennies + nickels*5 + dimes*10 + quarters*25;
    }
    public int getPennies(){
        return pennies;
    }
    public int getNickels(){
        return nickels;
    }
    public int getDimes(){
        return dimes;
    }
    public int getQuarters(){
        return quarters;
    }
    
    //Method to spend money
    public void spend(double dollars){
        int cents = (int)(dollars*100);
        while(cents >= 25 && quarters > 0){
            cents -= 25;
            quarters--;
        }
        while(cents >= 10 && dimes > 0){
            cents -= 10;
            dimes--;
        }
        while(cents >= 5 && nickels > 0){
            cents -= 5;
            nickels--;
        }
        while(cents >= 1 && pennies > 0){
            cents--;
            pennies--;
        }
        /*
         * To minimize change, first find out net worth
         * Then take the difference between net worth and cost
         * Starting with quarters, try to fill up the difference as much as possible
         * Then the remaining difference is the smallest change
         * This minimizes the change in cents but not the number of coins
         */
    }
}