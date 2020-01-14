public class StringUtil {
    //Pre: gets original string
    //Post: returns string in reverse
    static String reverse (String str) {
        String rev = "";
        for (int i = str.length() - 1; i >= 0; i--)
            rev += str.charAt(i);
        return rev;
    }
    
    //Pre: gets original string
    //Post: returns a "cleaned" string
    static String clean (String str) {
        String cleaned = "";
        for (int i = 0; i < str.length(); i++) {
            //If lowercase, add to string
            if (97 <= (int)str.charAt(i) && (int)str.charAt(i) <= 122) cleaned += str.charAt(i);
            //If uppercase, add lowercase to string
            else if (65 <= (int)str.charAt(i) && (int)str.charAt(i) <= 90) cleaned += (char)(str.charAt(i)+32);
        }
        return cleaned;
    }

    //Pre: gets original string
    //Post: returns if string is a palindrome or not
    public static boolean isPalindrome (String str) {
        str = clean( str );
        return str.equals( reverse(str) );
    }

    //Pre: gets original string
    //Post: returns index of the first vowel
    public static int findFirstVowel (String str) {
        char[] vowels = {'a','e','i','o','u','A','E','I','O','U'};
        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j < vowels.length; j++) {
                if (str.charAt(i) == vowels[j]) {
                    return i;
                }
            }
        }
        return -1;
    }

    //Pre: gets original string (word)
    //Post: returns the string (word) in pig latin
    public static String piggify (String str) {
        //If first letter is not capital
        if (97 <= str.charAt(0) && str.charAt(0) <= 122) {
            if ( findFirstVowel(str) == -1 ) return str + "ay"; 
            if ( findFirstVowel(str) == 0 ) return str + "yay";
            return str.substring( findFirstVowel(str) ) + str.substring( 0, findFirstVowel(str) ) + "ay";
        }
        else {
            String ans = clean(str);
            ans = piggify(ans);
            return (char)(ans.charAt(0)-32) + ans.substring(1);
        }
    }

    //Pre: gets original string (sentence)
    //Post: returns the string (sentence) in pig latin
    //*THIS IS FIRST DRAFT, NOT USED IN DRIVER*
    public static String piggifySentence (String str) {
        String pigSent = "";
        int lft = 0, rgt = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' '){
                rgt = i;
                pigSent += piggify( str.substring( lft,rgt) );
                pigSent += " ";
                lft = rgt+1;
            }
            else if (i == str.length() - 1) {
                rgt = str.length();
                pigSent += piggify( str.substring( lft,rgt) );
                pigSent += " ";
            }
        }
        return pigSent;
    }
    
    //Pre: gets original string (sentence)
    //Post: returns the string (sentence) in pig latin
    //*THIS IS FINAL DRAFT, USED IN DRIVER AND TAKES CARE OF PUNCUTATION AND CAPITALIZATION*
    public static String splitSentence (String str) {
        String ans = "", word = "", between = "";
        int ind;
        for (int i = 0; i < str.length(); i++) {
            if ((65 <= str.charAt(i) && str.charAt(i) <= 90) || (97 <= str.charAt(i) && str.charAt(i) <= 122) ){
                ind = i;
                word = "";
                while (ind < str.length() && ((65 <= str.charAt(ind) && str.charAt(ind) <= 90) || (97 <= str.charAt(ind) && str.charAt(ind) <= 122)) ) {
                    word += str.charAt(ind);
                    ind++;
                }
                i = ind - 1;
                ans += piggify(word);
            }
            else {
                between = "";
                ind = i;
                word = "";
                while (ind < str.length() && !((65 <= str.charAt(ind) && str.charAt(ind) <= 90) || (97 <= str.charAt(ind) && str.charAt(ind) <= 122)) ) {
                    between += str.charAt(ind);
                    ind++;
                }
                i = ind - 1;
                ans += between;
            }
        }
        return ans;
    }
}