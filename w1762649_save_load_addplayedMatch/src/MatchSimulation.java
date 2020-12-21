import java.io.Serializable;

public class MatchSimulation implements Serializable {
    private String homeTeam;
    private String opponentTeam;
    private DateMatchesPlaying dateMatchesPlayingOfMatchPlaying;
     private int goalsScoredHomeTeam;
    private int goalsScoredOpponentTeam;


    public MatchSimulation(String homeTeam, String opponentTeam, DateMatchesPlaying dateMatchesPlayingOfMatchPlaying, int goalsScoredHomeTeam, int goalsScoredOpponentTeam) {
        this.homeTeam = homeTeam;
        this.opponentTeam = opponentTeam;
         this.dateMatchesPlayingOfMatchPlaying = dateMatchesPlayingOfMatchPlaying;
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

     public DateMatchesPlaying getDateOfMatchPlaying() {
        return dateMatchesPlayingOfMatchPlaying;
    }

    public void setDateOfMatchPlaying(DateMatchesPlaying dateMatchesPlayingOfMatchPlaying) {
        this.dateMatchesPlayingOfMatchPlaying = dateMatchesPlayingOfMatchPlaying;
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
                ", dateOfMatchPlaying=" + this.dateMatchesPlayingOfMatchPlaying +", goalsScoredHomeTeam=" + this.goalsScoredHomeTeam +
                  ", goalsScoredOpponentTeam=" + this.goalsScoredOpponentTeam +'}';
    }
   }
