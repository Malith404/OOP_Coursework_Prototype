//class to represent the simulation process of the premier league
public class MatchSimulation{
    //set of attributes to set the simulation process
    String homeTeam;
    String opponentTeam;
    Date dateOfMatchPlaying;
    int goalsScoredHomeTeam;
    int goalsScoredOpponentTeam;


    public MatchSimulation(String homeTeam, String opponentTeam, Date dateOfMatchPlaying,
                           int goalsScoredHomeTeam, int goalsScoredOpponentTeam) {
        this.homeTeam = homeTeam;
        this.opponentTeam = opponentTeam;
        this.dateOfMatchPlaying = dateOfMatchPlaying;
        this.goalsScoredHomeTeam = goalsScoredHomeTeam;
        this.goalsScoredOpponentTeam = goalsScoredOpponentTeam;
    }

    //getter to get and display the home team playing in the premier league
    public String getHomeTeam() {
        return homeTeam;
    }

    //setter to set the home team playing in the premier league entered by the user
    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    //getter to get and display the opponent team playing in the premier league
    public String getOpponentTeam() {
        return opponentTeam;
    }

    //setter to set the opponent team playing in the premier league entered by the user
    public void setOpponentTeam(String opponentTeam) {
        this.opponentTeam = opponentTeam;
    }

    //getter to get and display the date of the match played
    public Date getDateOfMatchPlaying() {
        return dateOfMatchPlaying;
    }

    //setter to set the date of match played entered by the user
    public void setDateOfMatchPlaying(Date dateOfMatchPlaying) {
        this.dateOfMatchPlaying = dateOfMatchPlaying;
    }

    //getter to get and display the goals scored by the home team
    public int getGoalsScoredHomeTeam() {
        return goalsScoredHomeTeam;
    }

    //setter to set the goals scored by the home team
    public void setGoalsScoredHomeTeam(int goalsScoredHomeTeam) {
        this.goalsScoredHomeTeam = goalsScoredHomeTeam;
    }

    //getter to get and display the goals scored by the opponent team
    public int getGoalsScoredOpponentTeam() {
        return goalsScoredOpponentTeam;
    }

    //setter to set the goals scored by the opponent team
    public void setGoalsScoredOpponentTeam(int goalsScoredOpponentTeam) {
        this.goalsScoredOpponentTeam = goalsScoredOpponentTeam;
    }

}
