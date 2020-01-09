public class FauxkuMaker {
    private Word[] words;

    //Init and fills array with >= 30 elements
    public FauxkuMaker() {
        words = new Word[30];
        words[0] = new Word ("Diamond", 3);
        words[1] = new Word ("Platinum", 3);
        words[2] = new Word ("Gold", 1);
        words[3] = new Word ("Silver", 2);
        words[4] = new Word ("Bronze", 1);
        words[5] = new Word ("Computer", 3);
        words[6] = new Word ("Coding", 2);
        words[7] = new Word ("Music", 2);
        words[8] = new Word ("Paper", 2);
        words[9] = new Word ("Pool", 1);
        words[10] = new Word ("Tennis", 2);
        words[11] = new Word ("Concert", 2);
        words[12] = new Word ("Flight", 1);
        words[13] = new Word ("Trip", 1);
        words[14] = new Word ("Airport", 2);
        words[15] = new Word ("Plane", 1);
        words[16] = new Word ("Pizza", 2);
        words[17] = new Word ("Hard boiled eggs", 3);
        words[18] = new Word ("Vacation", 3);
        words[19] = new Word ("Mountain", 2);
        words[20] = new Word ("Lake", 1);
        words[21] = new Word ("Golf", 1);
        words[22] = new Word ("Phone", 1);
        words[23] = new Word ("Mathematics", 4);
        words[24] = new Word ("School", 1);
        words[25] = new Word ("Success", 2);
        words[26] = new Word ("Windows", 2);
        words[27] = new Word ("Apple", 2);
        words[28] = new Word ("Tower", 2);
        words[29] = new Word ("Waterfall", 3);
    }

    //construct and return a haiku using random words from your words array
    //A faux-ku is a three-line poem in which the first line has 5 syllables, the second line has
    // 7 syllables, and the third line has 5 syllables.
    //Reminder: You can use the escape sequence "\n" to move to the next line
    //Note: An actual haiku has additional requirements that we are not incorporating;
    // we are only using the haiku structure.
    public String makeFauxku() {
        String faux = "";
        //Line 1
        faux += makeLine(5);
        //Line 2
        faux += makeLine(7);
        //Line 3
        faux += makeLine(5);
        return faux;
    }
    
    String makeLine (int syllables) {
        String line = "";
        int index, num = 0;
        while (num < syllables) {
            index = rand();
            if ( num + words[index].getSyllables() <= syllables ) {
                num += words[index].getSyllables();
                line += words[index].getWord();
                line += " ";
            }
        }
        line += "\n";
        return line;
    }
    
    int rand () {
        return (int)(Math.random()*30);
    }
}