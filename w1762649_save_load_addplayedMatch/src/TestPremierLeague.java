 import java.io.*;

public class TestPremierLeague {

    public static void main(String[] args) throws IOException {
        LeagueManager premierLeagueManager = new PremierLeagueManager();

        premierLeagueManager.LoadFromFile();//load from the text file to the arraylists

        //TEST SCHOOL FOOTBALL CLUB
        SchoolFootballClub schoolFootballClub1 = new SchoolFootballClub("Vidura College", 13, "clubVidura", "SriLanka", "Colombo", 5, 2, 2, 1, 12, 8, 22);
         SchoolFootballClub schoolFootballClub2 = new SchoolFootballClub("Gateway", 15, "clubGateWay", "SriLanka", "Colombo", 7, 4, 1, 2, 16, 9, 42);

        //ADD NEW CLUBS TO THE FOOTBALL CLUB
        FootballClub footballClub1 = new FootballClub("Chelsea", "SriLanka", "Colombo", 5, 2, 2, 1, 12, 8, 22);
         FootballClub footballClub2 = new FootballClub("Manchester United", "England", "London", 7, 3, 2, 2, 17, 4, 32);

        //TEST UNIVERSITY FOOTBALL CLUB
        UniversityFootballClub universityFootballClub1 = new UniversityFootballClub("IIT", 14, "Manchester United", "England", "London", 8, 3, 2, 3, 17, 4, 34);
        UniversityFootballClub universityFootballClub2 = new UniversityFootballClub("SLIIT", 16, "Chelsea", "SriLanka", "Colombo", 12, 2, 6, 4, 13, 2, 21);

        //ADD NEW CLUBS TO THE UNIVERSITY FOOTBALL CLUB
        FootballClub footballClubUniversity = new UniversityFootballClub("IIT", 16, "Leeds United", "Sri Lanka", "Wellwatte", 18, 10, 6, 2, 19, 7, 23);

        // ADD NEW CLUBS TO THE SCHOOL FOOTBALL CLUB
        FootballClub footballClubSchool = new UniversityFootballClub("Vidura College", 19, "Arsenal", "Sri Lanka", "Thalawathugoda", 12, 7, 2, 3, 16, 5, 36);

         //TEST DATE CLASS
        DateMatchesPlaying dateMatchesPlaying = new DateMatchesPlaying(7, 2, 2020);//date constructor


        //PRINT THE RELEVANT OBJECTS TO TEST
        System.out.println(dateMatchesPlaying);
        System.out.println("\n");

        System.out.println(schoolFootballClub1);
         System.out.println(schoolFootballClub2);
        System.out.println("\n");

        System.out.println(universityFootballClub1);
        System.out.println(universityFootballClub2);
        System.out.println("\n");

        System.out.println(footballClubUniversity);
        System.out.println(footballClubSchool);
        System.out.println("\n");

        /*
----------------------------------------------------------------------------------------------------------------
*/
        //ADD CLUB

        System.out.println("ADD A FOOTBALL CLUB");
        premierLeagueManager.AddToPremierLeague(schoolFootballClub1);
        premierLeagueManager.AddToPremierLeague(schoolFootballClub2);
         premierLeagueManager.AddToPremierLeague(universityFootballClub1);
        premierLeagueManager.AddToPremierLeague(universityFootballClub2);

              /*
----------------------------------------------------------------------------------------------------------------
*/

        //DISPLAY STATISTICS OF A SELECTED CLUB

          premierLeagueManager.DisplayStatisticSelectedClub("clubGateWay");

              /*
----------------------------------------------------------------------------------------------------------------
*/


        //DISPLAY PREMIER LEAGUE TABLE

          System.out.println("DISPLAY TABLE...\n");
        premierLeagueManager.DisplayPremierLeagueTable();

              /*
----------------------------------------------------------------------------------------------------------------
*/

        //ADD A PLAYED MATCH
          System.out.println("ADD A PLAYED MATCH :");
        premierLeagueManager.AddPlayedMatch("clubGateWay","clubVidura",new DateMatchesPlaying(2,4,2020),4,2);
        System.out.println("\n");
        premierLeagueManager.AddPlayedMatch("Chelsea","Manchester United",new DateMatchesPlaying(5,7,2020),2,5);

        /*
----------------------------------------------------------------------------------------------------------------
*/
        //WRITING OBJECTS INTO THE FILE(SAVE)

        premierLeagueManager.SaveInAFile();
              /*

----------------------------------------------------------------------------------------------------------------
*/

        //READING OBJECTS FROM THE FILE

        /*premierLeagueManager.LoadFromFile();*/

      /*
----------------------------------------------------------------------------------------------------------------
*/

        //DELETE EXISTING CLUB
        premierLeagueManager.DeleteExistingClub("Chelsea");


/*
----------------------------------------------------------------------------------------------------------------
*/

        //DISPLAY TABLE AFTER DELETING

         System.out.println("DISPLAY TABLE AFTER DELETING...\n");
        premierLeagueManager.DisplayPremierLeagueTable();

/*
----------------------------------------------------------------------------------------------------------------
*/
    }
}



