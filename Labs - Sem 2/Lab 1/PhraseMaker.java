public class PhraseMaker {
    private String[] nouns;
    private String[] verbs;
    private String[] preps;

    void initNouns () {
        nouns[0] = "Andy";
        nouns[1] = "Bob";
        nouns[2] = "Cyrus";
        nouns[3] = "David";
        nouns[4] = "Evan";
        nouns[5] = "Fred";
        nouns[6] = "Gary";
        nouns[7] = "Hillary";
        nouns[8] = "Igor";
        nouns[9] = "Jake";
    }
    
    void initVerbs () {
        verbs[0] = "ran";
        verbs[1] = "walked";
        verbs[2] = "studied";
        verbs[3] = "slept";
        verbs[4] = "typed";
        verbs[5] = "swam";
        verbs[6] = "talked";
        verbs[7] = "sat";
        verbs[8] = "saw";
        verbs[9] = "breathed";
    }
    
    void initPreps () {
        preps[0] = "inside the school";
        preps[1] = "under the bridge";
        preps[2] = "by the beach";
        preps[3] = "in California";
        preps[4] = "on the bike";
        preps[5] = "in the restaurant";
        preps[6] = "on the roof";
        preps[7] = "by the White House";
        preps[8] = "in the car";
        preps[9] = "next to the park";
    }
    
    //initialize and fill arrays with at least 10 of each
    public PhraseMaker () {
        nouns = new String[10];
        verbs = new String[10];
        preps = new String[10];
        initNouns();
        initVerbs();
        initPreps();
    }

    //Constructs and returns a String consisting of a random elements from the arrays
    public String makePhrase() {
        int a = (int)(Math.random()*10);
        int b = (int)(Math.random()*10);
        int c = (int)(Math.random()*10);
        return nouns[a] + " " + verbs[b] + " " + preps[c];
    }
}