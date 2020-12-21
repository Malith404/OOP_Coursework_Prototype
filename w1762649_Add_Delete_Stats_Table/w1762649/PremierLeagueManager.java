import java.io.*;
import java.util.*;
//PremierLeagueManager class which is going to implement the classes which are in the interface LeagueManager
public class PremierLeagueManager implements LeagueManager {
    public static final int maxNoClubs = 20;//variable showing maximum number of clubs that can play in the premier league
    private int freeSpacesForClubs = 20;//variable showing the free spaces available ing the list of football clubs.
     private List<FootballClub> list_of_footballClubs = new ArrayList<>();//arraylist which contain all the objects in sports club including football clubs
    private List<MatchSimulation> playedMatchesSimulation = new ArrayList<>();//arraylist which contain all the objects in match simulation class

    //Method that is used to create a new football club and add to the premier league manager
    @Override
    public void AddToPremierLeague(FootballClub footballClub) {

        for (FootballClub footballClubNew : list_of_footballClubs) {//looping inside the list of football clubs
            if ((footballClub.getClubName().equals(footballClubNew.getClubName()))) {//if the user enters an already entered club, printing an error
                System.out.println("ERROR ! This Football club is already registered");
                System.out.println("\n");
                return;//printing the error message and return to the main menu
            }
        }
        if (freeSpacesForClubs == 0) {
            System.out.println("ERROR ! The Football club is Full");//if the spaces in the football club drops to zero printing an error message
        } else {
            list_of_footballClubs.add(footballClub);//if there are no error adding football clubs to the arraylist
            freeSpacesForClubs -= footballClub instanceof UniversityFootballClub ? 1 : 1;//if the football club is a university football club reducing the space by one              and else also one
            System.out.println("YOU HAVE SUCCESSFULLY ADDED A FOOTBALL CLUB...CHEERS !");
            //printing the number of free slots remaining
              System.out.println(freeSpacesForClubs > 0 ? ("Free Slots Remaining to add football clubs: " + freeSpacesForClubs) : "No More Spaces available to add a                  football club");
            System.out.println(list_of_footballClubs);
        }
        System.out.println("\n");

        if (freeSpacesForClubs >= maxNoClubs) {//if the free slots became greater than or equal to the maximum number of clubs printing an error message
            System.out.println("ERROR ! No spaces available to add any football club");
            System.out.println("\n");
          }

    }

    //Method that is used to delete an existing football club from premier league
      @Override
    public void DeleteExistingClub(String clubName) {
         if (list_of_footballClubs.isEmpty()) {//printing an error message if the football club list is empty..so can't perform delete operation
            System.out.println("No Football clubs in the list,yet!");
        } else {
            boolean foundClub = false;//boolean value to find the club name
               for (FootballClub footballClub : list_of_footballClubs) {
                if (footballClub.getClubName().equals(clubName)) {//if the club name is inside the arraylist
                    foundClub = true;//making the boolean value to true
                    list_of_footballClubs.remove(footballClub);//removing the relevant club from the list of football clubs
                    System.out.println("SAD NEWS !!!");
                    System.out.printf("A %s has Left the Football Club List.%n", footballClub instanceof UniversityFootballClub ? "University Football Club" : "School Football Club");
                    freeSpacesForClubs += footballClub instanceof UniversityFootballClub ? 1 : 1;//updating the free slots in the list of football clubs
                    System.out.println("\n");
                     System.out.printf("Free Slots Remaining: %d%n", freeSpacesForClubs); //printing the remaining spaces
                    System.out.println("\n");
                    break;
                }
            }

            if (foundClub == false) {//if the club is not found printing an error message
                System.out.println("Invalid Club Name! Please Check & Try Again!");
                System.out.println("\n");
            }
          }
    }

     //Method that is used to display the statistics for a selected club
    @Override
      public void DisplayStatisticSelectedClub(String clubNameDisplay) {

        if (list_of_footballClubs.isEmpty()) {//printing an error message if the football club is empty
            System.out.println("No Football clubs in the list,yet!");
            System.out.println("\n");
        } else {
            boolean foundClub = false;//boolean value to find the club name

            for (FootballClub footballClub : list_of_footballClubs) {
                if (footballClub.getClubName().equals(clubNameDisplay)) {//if the club is in the list of football clubs
                    foundClub = true;//making the boolean value tto true
                    System.out.println("******************************** STATISTICS ********************************");
                    System.out.println("\n");
                    if (footballClub instanceof UniversityFootballClub) {//if the football club is a university football club printing the name of the university
                        System.out.println("* Name of the University [U23 Division] \t: " + ((UniversityFootballClub) footballClub).getUniversityName());
                    } else {
                        //if the football club is a school football club printing the name of the school
                        System.out.println("* Name of the School [U18 Division]\t: " + ((SchoolFootballClub) footballClub).getSchoolName());
                    }
                    System.out.println("* Name of the Club \t\t\t: " + footballClub.getClubName());//displaying the name of the club
                    System.out.println("* Country of the Club \t\t\t: " + footballClub.getCountry());//displaying the country of the club
                    System.out.println("* Location of the Club \t\t\t: " + footballClub.getLocation());//displaying the city of the club
                    System.out.println("* Number Of Matches Played \t\t: " + footballClub.getNoOfMatchesPlayed());//displaying the number of matches played by the club
                    System.out.println("* Number of Matches Won \t\t: " + footballClub.getMatchesWon());//displaying the number of matches won by the club
                    System.out.println("* Number of Matches Lost \t\t: " + footballClub.getMatchesLost());//displaying the number of matches lost by the club
                     System.out.println("* Number of Matches Drawn \t\t: " + footballClub.getMatchesDrawn());//displaying the number of matches drawn by the club
                    System.out.println("* Goals Scored \t\t\t\t: " + footballClub.getGoalsScored());//displaying the number of goals scored by the club
                    System.out.println("* Goals Received \t\t\t: " + footballClub.getGoalsReceived());//displaying the number of goals received by the club
                     System.out.println("* Points Scored \t\t\t: " + footballClub.getPointsScored());//displaying the points scored by the club
                    System.out.println("\n");
                    System.out.println("******************************************************************************");
                    System.out.println("\n");
                    break;
                }
            }
            if (foundClub == false) {//if the football club is not found printing an error message
                System.out.println("Invalid Club Name! Please Check & Try Again!");
                System.out.println("\n");
            }
        }
    }


    //Method that is used to display the premier league table in descending order of their points or goal difference
    @Override
    public void DisplayPremierLeagueTable() {
        Scanner user_input = new Scanner(System.in);

        System.out.println("1 => Display Premier League Table");
        System.out.println("2 => Filter Matches played to a particular date");
        System.out.println("\n");
        System.out.println("Select [1 or 2] from above to proceed... : ");
        int choice = user_input.nextInt();
        System.out.println("\n");

        if (choice == 1) {//if the user wants to show the premier league table
            Collections.sort(list_of_footballClubs, Collections.reverseOrder());//sort the arraylist of football clubs in descending order

            System.out.println("------------------------------------------------------------------------------------------------" +
                    "---------------------------------------------------------------------------------------------------------------");
            //headings of the table
            System.out.printf("| %-22s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %-14s |", "ClubName", "Country", "Location",
                    "NoOfMatchesPlayed", "MatchesWon", "MatchesLost", "MatchesDrawn", "GoalsScored", "GoalsReceived", "GoalsDifference", "PointsScored");
            System.out.println("\n");
            System.out.println("------------------------------------------------------------------------------------------------" +
                    "---------------------------------------------------------------------------------------------------------------");

            System.out.println("\n");

            for (FootballClub footballClub : list_of_footballClubs) {
                //values that are coming in the table
                System.out.printf("| %-22s | %-15s | %-15s | %-17s | %-15s | %-15s | %-15s | %-15s | %-15s |%-15s | %-14s |", footballClub.getClubName(),                   footballClub.getCountry(),
                        footballClub.getLocation(), footballClub.getNoOfMatchesPlayed(), footballClub.getMatchesWon(), footballClub.getMatchesLost(),
                        footballClub.getMatchesDrawn(), footballClub.getGoalsScored(), footballClub.getGoalsReceived(), (footballClub.getGoalsScored() -                             footballClub.getGoalsReceived()), footballClub.getPointsScored(), "|\n");
                System.out.println("\n");
                System.out.println("------------------------------------------------------------------------------------------------" +
                        "---------------------------------------------------------------------------------------------------------------");
                System.out.println("\n");
            }
        } else if (choice == 2) {//if the user wants to filter the matches played by a specific date
            boolean dateFound = false;//boolean vale to find the date of the match played

            System.out.println("Please Enter the Day of the match played: ");//taking the day of the match played
            int day = user_input.nextInt();

            System.out.println("Please Enter the Month of the match played: ");//taking the month of the match played
            int month = user_input.nextInt();

            System.out.println("Please Enter the Year of the match played: ");//taking the year of the match played
            int year = user_input.nextInt();
            System.out.println("\n");

            for (MatchSimulation matchSimulation : playedMatchesSimulation) {//looping inside the match simulation class from the arraylist
                //if the day,month and year is in the arraylist printing the statistics of the matches played
                if ((matchSimulation.dateOfMatchPlaying.getDay() == day) && (matchSimulation.dateOfMatchPlaying.getMonth() == month)
                        && (matchSimulation.dateOfMatchPlaying.getYear() == year)) {
                    System.out.println("-----------------------------------------------------------------------------------------------------");

                    System.out.printf("| %-22s | %-22s | %-15s | %-25s |", "HomeClubName", "OpponentClubName", "HomeClubGoalsScored", "OpponentClubGoalsScored");
                    System.out.println("\n");
                    System.out.println("-----------------------------------------------------------------------------------------------------");
                     System.out.println("\n");

                    //displaying the values of the table which is sorted to a specific date
                    System.out.printf("| %-22s | %-22s | %-19s | %-25s | ", matchSimulation.getHomeTeam(),
                            matchSimulation.getOpponentTeam(), matchSimulation.getGoalsScoredHomeTeam(), matchSimulation.getGoalsScoredOpponentTeam(), "|\n");
                    System.out.println("\n");
                    System.out.println("-----------------------------------------------------------------------------------------------------");
                    System.out.println("\n");
                    dateFound = true;//making the boolean value to true as the date is correct
                }

            }
            if (dateFound == false) {//if the date is not found printing and error message
                System.out.println("ERROR ! Invalid Date or You have entered a wrong date...");
                System.out.println("\n");
            }
        } else {
            //if the user inputs anything else 1 and 2 options printing an error message
              System.out.println("ERROR ! Wrong Input...Try Again...");
            System.out.println("\n");
        }

    }

}