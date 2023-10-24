package org.example.tennis;

public class TennisGame3 implements TennisGame {
    
    private int player2Score;
    private int player1Score;
    private String player1Name;
    private String player2Name;
    private final String[] pointsToScore = new String[]{"Love", "Fifteen", "Thirty", "Forty"};

    public TennisGame3(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore() {
        String score;
        if (player1Score < 4 && player2Score < 4 && combinedPlayerScoreNotSix()) {
            score = pointsToScore[player1Score];
            return (player1Score == player2Score) ? score + "-All" : score + "-" + pointsToScore[player2Score];
        } else {
            if (player1Score == player2Score)
                return "Deuce";
            score = getLeaderName();
            return (Math.abs(player1Score - player2Score) == 1) ? "Advantage " + score : "Win for " + score;
        }
    }

    private String getLeaderName() {
        return player1Score > player2Score ? player1Name : player2Name;
    }

    private boolean combinedPlayerScoreNotSix() {
        return !(player1Score + player2Score == 6);
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(player1Name))
            this.player1Score += 1;
        else
            this.player2Score += 1;
        
    }

}
