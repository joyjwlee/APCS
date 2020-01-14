import java.util.*;

public class StringDriver {
    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        String input;
        
        System.out.println("\n===============================");
        System.out.println("Enter a string to be reversed.");
        input = in.nextLine();
        System.out.println("The reversed string is " + StringUtil.reverse(input));

        System.out.println("\n===============================");
        System.out.println("Enter a string to be cleaned.");
        input = in.nextLine();
        System.out.println("The cleaned string is " + StringUtil.clean(input));

        System.out.println("\n===============================");
        System.out.println("Enter a string to be checked for palindrominess.");
        input = in.nextLine();
        if (StringUtil.isPalindrome(input))
            System.out.println(input + " is a palindrome");
        else    
            System.out.println(input + " is not a palindrome");

        System.out.println("\n===============================");
        System.out.println("Enter a string to find a vowel in.");
        input = in.nextLine();
        System.out.println("The first vowel is at position " + StringUtil.findFirstVowel(input));

        System.out.println("\n===============================");
        System.out.println("Enter a word to piggify");
        input = in.nextLine();
        System.out.println("The piggified string is " + StringUtil.piggify(input));

        System.out.println("\n===============================");
        System.out.println("Enter a sentence to piggify");
        input = in.nextLine();
        System.out.println("The piggified sentence is " + StringUtil.splitSentence(input));
    }
}