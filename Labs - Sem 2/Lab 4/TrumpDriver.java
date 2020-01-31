public class TrumpDriver {
    //Pre: compile button pressed and method is selected to run
    //Post: outputs the entire assignment by accessing the go() method in the Analyzer class
    public static void main (String[] args) {
        TrumpAnalyzer trump = new TrumpAnalyzer();
        trump.go();
        try {
            Thread.sleep(3000);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        System.out.print('\u000C');
        System.out.println("===== Trump's Tweets Analysis =====");
        TweetAnalysis analyze = new TweetAnalysis();
        analyze.go();
    }
}