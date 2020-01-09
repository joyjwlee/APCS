// Lee 10/16/19

import java.util.*;
public class Lab13_Fraction{
    private int numerator, denominator;

    //Constructors
    Lab13_Fraction(){
        numerator = 0;
        denominator = 1;
    }

    Lab13_Fraction(int a, int b){
        numerator = a;
        denominator = b;
    }

    //Set Numerator, Denominator, or Fraction
    public void setNumerator(int a){
        numerator = a;
    }

    public void setDenominator(int b){
        denominator = b;
    }

    public void setFraction(int a, int b){
        numerator = a;
        denominator = b;
    }

    //Get Numerator and Denominator
    public int getNum(){
        return numerator;
    }

    public int getDenom(){
        return denominator;
    }

    //To String
    public String toString(){
        return numerator + " / " + denominator;
    }

    //Reduce Method
    public Lab13_Fraction reduce(){
        Lab13_Fraction reduced = new Lab13_Fraction();
        int GCF = 0;
        int numeratorAbs = Math.abs(numerator);
        int denominatorAbs = Math.abs(denominator);
        if (numeratorAbs != denominatorAbs) GCF = findGCF(numeratorAbs, denominatorAbs);
        else GCF = numeratorAbs;
        //Now divide each by GCF
        reduced.numerator = numerator / GCF;
        reduced.denominator = denominator / GCF;
        return reduced;
    }

    //Find GCF - Euclid's Algorithm
    public int findGCF(int w, int z){ 
        if (w == 0) return z;
        return findGCF(z % w, w);
    }

    //The four basic operations
    //Pre: b is valid Fraction object
    //Post: returns a new Fraction representing the product of this and b
    public Lab13_Fraction multiply(Lab13_Fraction b){
        if ((denominator == 0) || (b.denominator == 0)) throw new IllegalArgumentException("Denominator cannot be zero!"); //If denominator is zero, let user know
        Lab13_Fraction product = new Lab13_Fraction();
        product.numerator = numerator * b.numerator;
        product.denominator = denominator * b.denominator;
        product = product.reduce();
        return product;
    }

    //Pre: b is valid Fraction object
    //Post: returns a new Fraction representing the quotient of this and b
    public Lab13_Fraction divide(Lab13_Fraction b){
        if ((denominator == 0) || (b.denominator == 0)) throw new IllegalArgumentException("Denominator cannot be zero!");
        Lab13_Fraction quotient = new Lab13_Fraction();
        quotient.numerator = numerator * b.denominator;
        quotient.denominator = denominator * b.numerator;
        quotient = quotient.reduce();
        return quotient;
    }

    //Pre: b is valid Fraction object
    //Post: returns a new Fraction representing the sum of this and b
    public Lab13_Fraction add(Lab13_Fraction b){
        if ((denominator == 0) || (b.denominator == 0)) throw new IllegalArgumentException("Denominator cannot be zero!");
        Lab13_Fraction sum = new Lab13_Fraction();
        sum.numerator = numerator * b.denominator + denominator * b.numerator;
        sum.denominator = denominator * b.denominator;
        sum = sum.reduce();
        return sum;
    }

    //Pre: b is valid Fraction object
    //Post: returns a new Fraction representing the difference of this and b
    public Lab13_Fraction subtract(Lab13_Fraction b){
        if ((denominator == 0) || (b.denominator == 0)) throw new IllegalArgumentException("Denominator cannot be zero!");
        Lab13_Fraction difference = new Lab13_Fraction();
        difference.numerator = numerator * b.denominator - denominator * b.numerator;
        difference.denominator = denominator * b.denominator;
        difference = difference.reduce();
        return difference;
    }

    //Make reciprocal
    public void makeReciprocal(){
        int temp = numerator;
        numerator = denominator;
        denominator = temp;
    }

    //Raise Fraction to a Power
    public void power(int exponent){
        int counter = exponent;
        int numeratorExp = 1;
        int denominatorExp = 1;
        while(counter > 0){
            numeratorExp *= numerator;
            denominatorExp *= denominator;
            counter--;
        }
        numerator = numeratorExp;
        denominator = denominatorExp;
    }

    //Generate a random fraction
    public static Lab13_Fraction createRandomFraction(){
        Lab13_Fraction random = new Lab13_Fraction();
        int randomNum = (int)(Math.random()*21 - 10);
        int randomDen = (int)(Math.random()*100)+1;
        random.setNumerator(randomNum);
        random.setDenominator(randomDen);
        random = random.reduce();
        return random;
    }
}