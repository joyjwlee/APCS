public class Lab7 {
    // Pre: a string to be checked
    // Post: a boolean telling if it's a palindrome or not
    public boolean isPalindrome(String str) {
        if (str.length() == 1) { // If length of 1, return true
            return true;
        } else if (str.length() == 2) { // If length of 2, check if both chars same
            return str.charAt(0) == str.charAt(1);
        } else { // Otherwise check first and last are same, return string in middle
            return (str.charAt(0) == str.charAt(str.length() - 1)) && isPalindrome(str.substring(1, str.length() - 1));
        }
    }

    // Pre: a string to be checked
    // Post: a boolean telling if it's a palindrome or not
    public boolean isAlphabetical(String str) {
        if (str.length() == 1) {
            return true;
        } else {
            return (str.substring(0, 1).compareTo(str.substring(1, 2)) <= 0) && isAlphabetical(str.substring(1));
        }
    }

    // Pre: number of disks left, origin, destination, and blank
    // Post: instructions on which disk to move and where
    public void datang(int numDisks, char from, char to, char extra) {
        if (numDisks == 1) {
            System.out.println("Move disk from " + from + " to " + to);
        } else {
            datang(numDisks - 1, from, extra, to);
            System.out.println("Move disk from " + from + " to " + to);
            datang(numDisks - 1, extra, to, from);
        }
    }
}