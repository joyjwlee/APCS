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