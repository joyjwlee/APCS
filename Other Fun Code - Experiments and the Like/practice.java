// May 5
public int findLowestScore() {
    int lowest = players[0].getScore();
    for (int i = 0; i < players.length; i++) {
        if (players[i].getScore() < lowest) {
            lowest = players[i].getScore();
        }
    }
    return lowest;
}

public void playRound() {
    // update score
    allPlay();

    // if tied
    return;
        if (allTied()) {
    }

    // remove those with lowest
    int lowest = findLowestScore();
    for (int i = 0; i < players.length; i++) {
        if (players[i].getScore() == lowest) {
            players[i] = null;
        }
    }

    // fill in null
    for (int i = 0; i < players.length; i++) {
        if (players[i] == null) {
            if (waiting.size() > 0) {
                players[i] = waiting.remove(0);
            }
        }
    }

    // "compress" to the left
    int idx = 0;
    for (int i = 0; i < players.length; i++) {
        if (players[i] == null) {
            idx = i;
            while (idx < players.length && players[idx] == null) {
                idx++;
            }
            players[i] = players[idx];
            players[idx] = null;
        }
        i = idx;
    }
}

public String playGame() {
    while (players[1] != null) {
        playRound();
    }
    return players[0].getName();
}
// enhancement: arraylist for players, not array

/*************************************************************************************/

// May 8
private void cleanData() {
    for (int i = 0; i < pings.size(); i++) {
        if (pings.get(i).atHome() || pings.get(i).getDuration() < limit) {
            pings.remove(i);
            i--;
        }
    }
}

public boolean unsafeHour(int hour, int min, int threshold) {
    cleanData();
    int num = 0;
    int seconds = 0;
    for (int i = 0; i < pings.size(); i++) {
        if (pings.get(i).getHour() == hour) {
            seconds += pings.get(i).getDuration();
            num++;
        }
    }
    if (num > min || seconds > threshold * num) {
        return true;
    }
    return false;
}

public int nonCompliantUsers() {
    int ans = 0;
    for (int i = 0; i < users.length; i++) {
        int hours = 0;
        for (int j = 0; j < 24; j++) {
            if (users[i].unsafeHour(j, allowed, avergeLimit)) {
                hours++;
            }
        }
        if (hours > 3) {
            ans++;
        }
    }
    return ans;
}

//Goes through each user and identifies if they are egregious or not
//Returns an arraylist of strings that has names of the egregious users
public ArrayList<String> egregiousUsers() {
    /*
        Modifications:
        - None in ping
        - DailyUserData, public string for name and getName() method; also modify constructor
        - Analyzer, have a public arraylist of string and a method that updates list of egregious users  
    */
}

//May 12 practice FRQ

public int countOnlyBlueCards() {
    int ans = 0;
    for (int i = 0; i < deck.size(); i++) {
        if (deck.get(i).getColor().equals(BLUE)) {
            ans++;
        }
    }
    return ans;
}

public ArrayList<Card> updateDeck(ArrayList<Card> pack) {
    ArrayList<Card> unused = new ArrayList<Card>();
    while(pack.size() > 0) {
        Card curr = pack.remove(0);
        boolean duplicate = false;
        boolean added = false;
        
        //see if duplicate or not
        for (int i = 0; i < deck.size(); i++) {
            if (deck.get(i).getName().equals(curr.getName())) {
                duplicate = true;
                unused.add(curr);
            }
        }

        //add if not duplicate
        if (!duplicate) {
            for (int i = 0; i < deck.size(); i++) {
                if (curr.getName().compareTo(deck.get(i).getName()) < 0) {
                    deck.add(i, curr);
                    added = true;
                    break;
                }
            }
        }

        if (!duplicate && !added) {
            deck.add(curr);
        }
    }
    return unused;
}

//method header:
public int playerWithMostOfOneColor(PlayerDeck[] players) {
    //code
    /*
        Modifications:
        - array of final strings in PlayerDeck to have all colors
        - for loop that runs through each color for each player
        - rename countOnlyBlue and pass parameter as a color; change method so that it compares to the passed color 
    */
}