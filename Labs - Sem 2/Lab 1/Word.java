public class Word {
    private String word;
    private int syllables;

    public Word( String w, int s ) {
        word = w;
        syllables = s;
    }

    public String getWord () {
        return word;
    }

    public int getSyllables() {
        return syllables;
    }
}