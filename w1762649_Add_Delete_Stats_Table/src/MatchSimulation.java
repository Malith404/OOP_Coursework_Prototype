public class MatchSimulation {
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

    public String getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public String getOpponentTeam() {
        return opponentTeam;
    }

    public void setOpponentTeam(String opponentTeam) {
        this.opponentTeam = opponentTeam;
    }

    public Date getDateOfMatchPlaying() {
        return dateOfMatchPlaying;
    }

    public void setDateOfMatchPlaying(Date dateOfMatchPlaying) {
        this.dateOfMatchPlaying = dateOfMatchPlaying;
    }

    public int getGoalsScoredHomeTeam() {
        return goalsScoredHomeTeam;
    }

    public void setGoalsScoredHomeTeam(int goalsScoredHomeTeam) {
        this.goalsScoredHomeTeam = goalsScoredHomeTeam;
    }

    public int getGoalsScoredOpponentTeam() {
        return goalsScoredOpponentTeam;
    }

    public void setGoalsScoredOpponentTeam(int goalsScoredOpponentTeam) {
        this.goalsScoredOpponentTeam = goalsScoredOpponentTeam;
    }


    @Override
    public String toString() {
        return "MatchSimulation{" +"homeTeam=" + this.homeTeam +", opponentTeam=" + this.opponentTeam  +
                ", dateOfMatchPlaying=" + this.dateOfMatchPlaying +", goalsScoredHomeTeam=" + this.goalsScoredHomeTeam +
                ", goalsScoredOpponentTeam=" + this.goalsScoredOpponentTeam +'}';
    }
}
