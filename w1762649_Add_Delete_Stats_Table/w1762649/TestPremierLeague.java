import java.util.Scanner;

public class TestPremierLeague {

    public static void main(String[] args) {
        LeagueManager premierLeagueManager = new PremierLeagueManager();

        Scanner User_Input = new Scanner(System.in);

        //TEST SCHOOL FOOTBALL CLUB
        SchoolFootballClub schoolFootballClub1 = new SchoolFootballClub("Vidura College", 13, "Chelsea", "SriLanka", "Colombo", 5, 2, 2, 1, 12, 8, 22);
        SchoolFootballClub schoolFootballClub2 = new SchoolFootballClub("Gateway", 15, "clubGateWay", "SriLanka", "Colombo", 7, 4, 1, 2, 16, 9, 42);


        //TEST UNIVERSITY FOOTBALL CLUB
        UniversityFootballClub universityFootballClub = new UniversityFootballClub("IIT", 14, "Manchester United", "SriLanka", "Colombo", 8, 3, 2, 3, 17, 4, 34);

        //ADD NEW CLUBS TO THE UNIVERSITY FOOTBALL CLUB
         FootballClub footballClubUniversity = new UniversityFootballClub("IIT", 16, "Leeds United", "Sri Lanka", "Wellwatte", 18, 10, 6, 2, 19, 7, 23);

        // ADD NEW CLUBS TO THE SCHOOL FOOTBALL CLUB
         FootballClub footballClubSchool = new UniversityFootballClub("Vidura College", 19, "Arsenal", "Sri Lanka", "Thalawathugoda", 12, 7, 2, 3, 16, 5, 36);

        //TEST DATE CLASS
        Date date = new Date(7, 2, 2020);//date constructor


        //PRINT THE RELEVANT OBJECTS TO TEST
        System.out.println(date);
        System.out.println("\n");

        System.out.println(schoolFootballClub1);
        System.out.println(schoolFootballClub2);
         System.out.println("\n");

         System.out.println(universityFootballClub);
        System.out.println("\n");

        System.out.println(footballClubUniversity);
        System.out.println(footballClubSchool);
         System.out.println("\n");

        /*
----------------------------------------------------------------------------------------------------------------
*/
        //ADD CLUB

        premierLeagueManager.AddToPremierLeague(schoolFootballClub1);
        premierLeagueManager.AddToPremierLeague(schoolFootballClub2);
        premierLeagueManager.AddToPremierLeague(universityFootballClub);

        //DISPLAY STATISTICS OF A SELECTED CLUB

        premierLeagueManager.DisplayStatisticSelectedClub("clubGateWay");

        //DISPLAY PREMIER LEAGUE TABLE

        System.out.println("DISPLAY TABLE...\n");
        premierLeagueManager.DisplayPremierLeagueTable();

        //DELETE EXISTING CLUB
        premierLeagueManager.DeleteExistingClub("Chelsea");

        //DISPLAY TABLE AFTER DELETING
        System.out.println("DISPLAY TABLE AFTER DELETING...\n");
      premierLeagueManager.DisplayPremierLeagueTable();

/*
----------------------------------------------------------------------------------------------------------------
*/
    }
}



