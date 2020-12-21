import java.io.IOException;

//Interface class with methods that have empty bodies
public interface LeagueManager {
    //methods that should be implemented in PremierLeagueManager class
    void addToPremierLeague(FootballClub footballClub);
    void deleteExistingClub(String clubName);
    void displayStatisticSelectedClub(String clubNameDisplay);
    void displayPremierLeagueTable();
    void addPlayedMatch(String homeTeamPlaying, String opponentTeamPlaying, DateMatchesPlayed dateMatchPlaying, int goalsScoredHomeTeam, int goalsScoredOpponentTeam);
    void saveInAFile() ;
    void loadFromFile() throws IOException;
    void displayPremierLeagueTableGUI();
}
