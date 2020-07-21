package session08_clean_code.homeworks;

public class TennisGame {
    public static String getResult(String player1Name, String player2Name, int player1Score, int player2Score) {
        String message = "";
        int tempScore = 0;
        final boolean equalEachOther = player1Score == player2Score;
        final boolean scoreOverFour = player1Score >= 4 || player2Score >= 4;
        if (equalEachOther) {
            message = getEqualInfo(player1Score);
        }
        else {

            if (scoreOverFour) {
                message = getScoreOverFourInfo(player1Score, player2Score);
            } else {
                message = getScoreInfo(player1Score, player2Score, message);
            }
        }
        return message;
    }

    private static String getScoreOverFourInfo(int player1Score, int player2Score) {
        String message;
        int minusResult = player1Score-player2Score;
        final boolean ADVANTAGE_PLAYER1 = minusResult == 1;
        final boolean ADVANTAGE_PLAYER2 = minusResult == -1;
        if (ADVANTAGE_PLAYER1) message ="Advantage player1";
        else {
            if (ADVANTAGE_PLAYER2) message ="Advantage player2";
            else if (minusResult >= 2) message = "Win for player1";
            else message ="Win for player2";
        }
        return message;
    }

    private static String getEqualInfo(int player1Score) {
        String message;
        switch (player1Score) {
            case 0:
                message = "Love-All";
                break;
            case 1:
                message = "Fifteen-All";
                break;
            case 2:
                message = "Thirty-All";
                break;
            case 3:
                message = "Forty-All";
                break;

            default:
                message = "Deuce";
                break;
        }
        return message;
    }

    private static String getScoreInfo(int player1Score, int player2Score, String message) {
        int tempScore;
        for (int i = 1; i < 3; i++) {
            if (i == 1) tempScore = player1Score;
            else { message += "-"; tempScore = player2Score;}
            switch (tempScore) {
                case 0:
                    message += "Love";
                    break;
                case 1:
                    message += "Fifteen";
                    break;
                case 2:
                    message += "Thirty";
                    break;
                case 3:
                    message += "Forty";
                    break;
            }
        }
        return message;
    }
}
