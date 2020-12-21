//Interface class with methods that have empty bodies
public interface LeagueManager {
    //methods that should be implemented in PremierLeagueManager class
    void AddToPremierLeague(FootballClub footballClub);
    void DeleteExistingClub(String clubName);
    void DisplayStatisticSelectedClub(String clubNameDisplay);
    void DisplayPremierLeagueTable();

}
