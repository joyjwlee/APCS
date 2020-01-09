//Lee
//Lab 12 - Piggy Bank
//To practice and get an introduction to OOP 
//Extensions: TBD

public class Lab12_PiggyBankDriver {
    public static void main( String[] args ) {
        System.out.print('\u000C' + "\n"); //The weird space on the first line doesn't seem to go away...
        // creates an empty piggybank for son
        Lab12_PiggyBank son = new Lab12_PiggyBank();
        // creates a piggybank with 7 pennies, 3 nickels, 20 dimes, 14 quarters
        Lab12_PiggyBank daughter = new Lab12_PiggyBank(7, 3, 20, 14);
        son.addPennies(18);
        daughter.addQuarters(4);
        daughter.addPile(3, 2, 1, 0);       //  adds 3 pennies, 2 nickels, 1 dime, 0 quarters
        int sonValue = son.getValue();      // sonValue holds the total number of cents in the piggybank
        int daughterValue = daughter.getValue();
        System.out.println("Son has " + sonValue + " cents and daughter has " + daughterValue + " cents");
        int numQuarters = daughter.getQuarters();
        System.out.println("Daughter has " + numQuarters + " quarters");
        // daughter withdraws $3.87 - leave for last, this is hard
        // precondition of spend is that there is enough $ in the PB
        // postcondition is $ is removed smartly, taking all the quarters it needs, then dimes, etc
        daughter.spend(3.87);                   
        System.out.println("After spending 3.87 daughter now has " + daughter.getValue() + " cents left");
        System.out.println("Daughter has " + daughter.getPennies() + " pennies");
        System.out.println("Daughter has " + daughter.getNickels() + " nickels");
        System.out.println("Daughter has " + daughter.getDimes() + " dimes");
        System.out.println("Daughter has " + daughter.getQuarters() + " quarters");
        son.spend(sonValue / 100.0);
        System.out.println("After emptying his bank, son now has " + son.getValue() + " left");
    }
}