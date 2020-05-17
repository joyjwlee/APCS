// 030Z2759
// J. L.

// Part A
public static double checkGuesses(String phrase, int num) {
    int correct = 0;
    for (int i = 0; i < num; i++) {
        // if in the phrase, correct++
        if (phrase.indexOf(getGuess()) != -1) {
            correct++;
        }
    }
    // return double
    return (double) correct / num;
}

// Part B

/*
Modifications:
    - remove "int num" from the checkGuesses method's parameter
    - instead, create a new instance variable that is a public integer variable for num
    - in the constructor, create a new Random object and initialize num (since it's already been initialized)

    - import the random library (java.util.Random)
    - initalize num using the Random object and setting nextInt's parameter as 100
    - since this (pseudo-randomly) generates values from 0~99, increase num by 1 to get 1~100

    - if we are not using Random objects, we can also use Math.random()
    - again, in the constructor, initialize num like the following:
    - num = (int) (Math.random() * 100) + 1;
    - Math.random() generates random double values in the range [0.0, 1.0)
    - So, we mutiply by 100 to get [0.0, 100.0) and add 1 to get [1.0, 101.0)
    - casting to integer would basically give us the range [1.0, 100], just as we desired
*/