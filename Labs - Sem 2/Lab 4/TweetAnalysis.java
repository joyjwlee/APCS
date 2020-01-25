import java.util.*;
import java.io.*;

public class TweetAnalysis {
    Scanner input = new Scanner(System.in);
    static List<String> dictionaryWords = new ArrayList<String>();

    public void go () {
        initList();
        SOP("Enter string to find: ");
        String word = input.next();
        SOP("Index is: ");
        SOP(binarySearch(word));
        printTweets();
    }

    //Shorthand for System.out.print(ln) :)
    static void SOP (Object line) {
        System.out.println(line);
    }

    static void sop (Object line) {
        System.out.print(line);
    }

    //Accesses dictionary text file and puts all words into an arraylist
    public static void initList () {
        try {
            Scanner input = new Scanner( new File( "dictionary.txt" ) );
            while (input.hasNext()) {
                dictionaryWords.add( input.nextLine() );
            }
        } catch ( FileNotFoundException ex) {}
    }

    //Two-pointer, iterative binary search
    //Pre: Gets a sting
    //Post: index of word if it exists, otherwise returns -1
    public static int binarySearch (String s) {
        int lft = 0, rgt = dictionaryWords.size()-1, mid;
        while (lft <= rgt) {
            mid = lft + (rgt - lft) / 2; //The famous incident where Java re-wrote their built-in binary search due to overflow
            //Link to the post where I read about it last year!!
            //https://thebittheories.com/the-curious-case-of-binary-search-the-famous-bug-that-remained-undetected-for-20-years-973e89fc212

            //Return index if we found the word
            if ( dictionaryWords.get(mid).equals(s) ) return mid;
            //Update pointers accordingly otherwise
            if ( dictionaryWords.get(mid).compareTo(s) < 0 ) lft = mid + 1;
            else rgt = mid - 1; 
        }
        //Return -1 if it doesn't exist
        return -1;
    }

    public void processLine (String str) {
        int ind;
        //Iterate through the line
        for (int i = 0; i < str.length(); i++) {
            //If at a character, extract the word
            if ( (65 <= str.charAt(i) && str.charAt(i) <= 90) || (97 <= str.charAt(i) && str.charAt(i) <= 122) ){
                ind = i;
                while (ind < str.length() && ((65 <= str.charAt(ind) && str.charAt(ind) <= 90) || (97 <= str.charAt(ind) && str.charAt(ind) <= 122)) ) {
                    ind++;
                }
                str.substring(i, ind);
                i = ind - 1;
            }
            //Otherwise, get to the next word
            else {
                ind = i;
                while (ind < str.length() && !((65 <= str.charAt(ind) && str.charAt(ind) <= 90) || (97 <= str.charAt(ind) && str.charAt(ind) <= 122)) ) {
                    ind++;
                }
                i = ind - 1;
            }
        }
    }

    //Accesses Json file and outputs only the tweets to the text file
    public static void printTweets () {
        String everything = "";
        try {
            Scanner input = new Scanner( new File( "TweetJson.txt" ) ); //"TweetJsonSmall.txt"
            while (input.hasNext()) {
                everything = input.nextLine();
            }
        } catch ( FileNotFoundException ex) {}

        //Use formatting from Json file to isolate tweet
        // Opening: {"text":"
        String opening = "{\"text\":\"";
        int openingLen = opening.length();
        // Closing: "}
        String closing = "\"}";
        int closingLen = closing.length();
        
        //Use indexOf to extract tweets
        int start = everything.indexOf(opening);
        int end = everything.indexOf(closing);
        int x = 1;
        while ( start != -1 ) {
            start = everything.indexOf(opening);
            everything = everything.substring(start + openingLen);
            end = everything.indexOf(closing);
            SOP ( x + " " + everything.substring(0,end) );
            x++;
        }
    }
}