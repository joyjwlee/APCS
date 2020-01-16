import java.util.*;
import java.io.*;

public class GreekToMe {
    String all = ""; //Entire text
    int sum = 0; //Total number of words in text
    String longest = ""; //Longest word in text
    int[] arr = new int[50]; //Index is length, value is number of words of that length
    String[] names = new String[50]; //Array of Greek names
    int nameInd = 0; //Pointer for names array index    
    
    //Pre: nothing
    //Post:main method for program
    public void go() {
        try {
            //Read text file, combine entire thing into one large string
            Scanner input = new Scanner( new File( "Phaedo.txt" ) );
            while (input.hasNext() ) {
                String line = input.nextLine();
                all += line;
                all += " ";
                //Add number of words in the line to global sum
                sum += numWords(line);
            }            
            //Print out everything
            System.out.println( "==> Total number of words in the text is " + sum + " words.");
            System.out.println( "==> The longest word is \"" + longest + "\", and its length is " + longest.length() + " characters" );
            System.out.println( "==>  Length: \t Number of Words:" );
            for (int i = 0; i <= longest.length(); i++) {
                if (arr[i] != 0) {
                    System.out.println( "       " + i + "\t\t" + arr[i]);
                }
            }
            System.out.println( "==> List of all Greek Names:" );
            for (int i = 0; i < nameInd; i++) {
                System.out.println( "     - " + names[i]);
            }
        } catch ( FileNotFoundException ex) {}
    }
    
    //Pre: gets a string (line)
    //Post: returns number of words in the string while doing other operations as well
    public int numWords (String str) {
        int ans = 0, ind;
        //Iterate through the line
        for (int i = 0; i < str.length(); i++) {
            //If at a character, extract the word
            if ((65 <= str.charAt(i) && str.charAt(i) <= 90) || (97 <= str.charAt(i) && str.charAt(i) <= 122) ){
                ans++;
                ind = i;
                while (ind < str.length() && ((65 <= str.charAt(ind) && str.charAt(ind) <= 90) || (97 <= str.charAt(ind) && str.charAt(ind) <= 122)) ) {
                    ind++;
                }
                //While I get the number of words, I also pass each word
                updateLongest( str.substring(i, ind) );
                //Update array of longest word
                updateArray( str.substring(i, ind) );
                //Update array of Greek names
                updateNames( str.substring(i, ind) );
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
        return ans;
    }
    
    //Pre: gets a string
    //Post: updates longest string
    public void updateLongest (String str) {
        if (str.length() >= longest.length()) longest = str;
    }
    
    //Pre: gets a string
    //Post: update word length array
    public void updateArray (String str) {
        arr[str.length()]++;
    }
    
    //Pre: gets a string
    //Post: update name array if it is a Greek name
    public void updateNames( String str ) {
        boolean startCap = true, alreadyExist = false, goodEnding = false;
        
        //Check if first letter is capital
        if ( !(65 <= str.charAt(0) && str.charAt(0) <= 90) ) {
            startCap = false;
        }
        
        //Check if name has already been added to the array
        for (int i = 0; i <= nameInd; i++) {
            if ( str.equals(names[i]) ) {
                alreadyExist = true;
                break;
            }
        }
        
        int len = str.length();
        if (len >= 4) {
            //Check -"ates"
            if ( str.substring(len-4).equals("ates") ) goodEnding = true;
            //Check -"us"
            else if ( str.substring(len-2).equals("us") ) goodEnding = true;
            //Check -"to"
            else if ( str.substring(len-2).equals("to") ) goodEnding = true;
        }
        
        //If name fits all criteria, add to array
        if (startCap && !alreadyExist && goodEnding) {
            names[nameInd] = str;
            nameInd++;
        }
    }
}