// 030Z2759
// J. L.

// Part A
public void addNewSitters(String[] names) {
    // loop through each name
    for (int i = 0; i < names.length; i++) {
        // boolean to keep track if already exist or not
        boolean exists = false;

        // loop through sitterList
        for (Babysitter curr : sitterList) {
            // if names are same
            if (curr.getName().equals(names[i])) {
                // set true
                exists = true;
            }
        }

        // if not exist yet, create new and add
        if (!exists) {
            sitterList.add(new Babysitter(names[i], 0));
        }
    }
}

// Part B
public ArrayList<Babysitter> affordableSitters(double budget, int numChildren, int hours) {
    ArrayList<Babysitter> affordable = new ArrayList<Babysitter>();

    // go through each one, add if possible
    for (Babysitter curr : sitterList) {
        // figure out rate
        int rate = 2 + curr.getYears();
        if (rate > 6) {
            rate = 6;
        }

        // find cost
        int cost = rate * numChildren * hours;

        // cast to double and compare
        if (budget > (double)cost) {
            affordable.add(curr);
        }
    }

    return affordable;
}

// Part C

/*
Method header: public ArrayList<Babysitter> getHighDemandSitters(int popularity)
Modifications:
    - we would want to modify the Babysitter class to have another instance variable that keeps track of demand
    - the instance variable's scope is public, and data type integer (unless other variable types are preferred)
    - the Babysitter constructor needs an additional parameter, as well as another method to return the demand variable
    - each time this Babysitter is used/chosen, then this demand variable is incremented by +1
    - we also need another method that increments the demand variable

    - in getHighDemandSitters, if the Babysitter's demand value is higher than the popularity (in the parameter), add it to the arraylist of babysitters that this method will return
    - this way, the parameter sets the baseline for what "popular" means for a babysitter

    - unless Babysitters are chosen a different way, these are all of the changes that we need to make
*/