package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.*;
import java.util.*;

//PremierLeagueManager class which is going to implement the classes which are in the interface LeagueManager
public class PremierLeagueManager implements LeagueManager, Serializable {
    public static final int maxNoClubs = 20;//variable showing maximum number of clubs that can play in the premier league
    private int freeSpacesForClubs = 20;//variable showing the free spaces available ing the list of football clubs.
    private List<FootballClub> list_of_footballClubs = new ArrayList<>();//arraylist which contain all the objects in sports club including football clubs
    private List<MatchSimulation> playedMatchesSimulation = new ArrayList<>();//arraylist which contain all the objects in match simulation class

    //Method that is used to create a new football club and add to the premier league manager
    @Override
    public void addToPremierLeague(FootballClub footballClub) {

        for (FootballClub footballClubNew : list_of_footballClubs) {//looping inside the list of football clubs
            if ((footballClub.getClubName().equals(footballClubNew.getClubName()))) {//if the user enters an already entered club, printing an error
                System.out.println("ERROR ! This Football club is already registered");
                System.out.println("\n");
                return;//printing the error message and return to the main menu
            }
        }

        //finding that the university entered by the user is already registered
        if (footballClub instanceof UniversityFootballClub) {
            for (FootballClub footballClubNew : list_of_footballClubs) {
                if (footballClubNew instanceof UniversityFootballClub) {
                    if ((((UniversityFootballClub) footballClubNew).getUniversityName()).equals((((UniversityFootballClub) footballClub).getUniversityName()))) {
                        System.out.println("ERROR ! This UNIVERSITY IS ALREADY REGISTERED");
                        System.out.println("\n");
                        return;
                    }
                }
            }
        }


        //finding that the school entered by the user is already registered
        if (footballClub instanceof SchoolFootballClub) {
            for (FootballClub footballClubNew : list_of_footballClubs) {
                if (footballClubNew instanceof SchoolFootballClub) {
                    if ((((SchoolFootballClub) footballClubNew).getSchoolName()).equals((((SchoolFootballClub) footballClub).getSchoolName()))) {
                        System.out.println("ERROR ! This SCHOOL IS ALREADY REGISTERED");
                        System.out.println("\n");
                        return;
                    }
                }
            }
        }

        if (freeSpacesForClubs == 0) {
            System.out.println("ERROR ! The Football club is Full");//if the spaces in the football club drops to zero printing an error message
        } else {
            list_of_footballClubs.add(footballClub);//if there are no error adding football clubs to the arraylist
            freeSpacesForClubs -= footballClub instanceof UniversityFootballClub ? 1 : 1;//if the football club is a university football club reducing the space by one and else also one
            System.out.println("YOU HAVE SUCCESSFULLY ADDED A FOOTBALL CLUB...CHEERS !");
            //printing the number of free slots remaining
            System.out.println(freeSpacesForClubs > 0 ? ("Free Slots Remaining to add football clubs: " + freeSpacesForClubs) : "No More Spaces available to add a football club");
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
    public void deleteExistingClub(String clubName) {
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
    public void displayStatisticSelectedClub(String clubNameDisplay) {

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
    public void displayPremierLeagueTable() {
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
                System.out.printf("| %-22s | %-15s | %-15s | %-17s | %-15s | %-15s | %-15s | %-15s | %-15s |%-15s | %-14s |", footballClub.getClubName(), footballClub.getCountry(),
                        footballClub.getLocation(), footballClub.getNoOfMatchesPlayed(), footballClub.getMatchesWon(), footballClub.getMatchesLost(),
                        footballClub.getMatchesDrawn(), footballClub.getGoalsScored(), footballClub.getGoalsReceived(), (footballClub.getGoalsScored() - footballClub.getGoalsReceived()), footballClub.getPointsScored(), "|\n");
                System.out.println("\n");
                System.out.println("------------------------------------------------------------------------------------------------" +
                        "---------------------------------------------------------------------------------------------------------------");
                System.out.println("\n");
            }
        } else if (choice == 2) {//if the user wants to filter the matches played by a specific date
            boolean dateFoundBoolean = false;//boolean vale to find the date of the match played

            System.out.println("Please Enter the Day of the match played: ");//taking the day of the match played
            int day = user_input.nextInt();

            System.out.println("Please Enter the Month of the match played: ");//taking the month of the match played
            int month = user_input.nextInt();

            System.out.println("Please Enter the Year of the match played : 2020");//taking the year of the match played
//            int year = user_input.nextInt();
            int year = 2020;
            System.out.println("\n");

            for (MatchSimulation matchSimulation : playedMatchesSimulation) {//looping inside the match simulation class from the arraylist
                //if the day,month and year is in the arraylist printing the statistics of the matches played
                if ((matchSimulation.getDateOfMatchPlayed().getDay() == day) && (matchSimulation.getDateOfMatchPlayed().getMonth() == month)
                        && (matchSimulation.getDateOfMatchPlayed().getYear() == year)) {
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
                    dateFoundBoolean = true;//making the boolean value to true as the date is correct
                }

            }
            if (dateFoundBoolean == false) {//if the date is not found printing and error message
                System.out.println("ERROR ! Invalid Date or You have entered a wrong date...");
                System.out.println("\n");
            }
        } else {
            //if the user inputs anything else 1 and 2 options printing an error message
            System.out.println("ERROR ! Wrong Input...Try Again...");
            System.out.println("\n");
        }

    }

    //Method that is used to add a played match with its score and its date
    @Override
    public void addPlayedMatch(String homeTeamPlaying, String opponentTeamPlaying, DateMatchesPlayed dateMatchesPlayed,
                               int goalsScoredHomeTeam, int goalsScoredOpponentTeam) {

        //check that home team and the opponent team is equal
        if (homeTeamPlaying.equals(opponentTeamPlaying)) {
            System.out.println("ERROR ! Home Team and Opponent Team cannot be the same");
            System.out.println("\n");
        }

        boolean homeClubFound = false;//to find the home club entered by the user
        boolean opponentClubFound = false;//to find the opponent club entered by the user

        boolean isClubUniversity = false;//to find the club entered by the user belongs to which division

        FootballClub homeClub = null;//taking a variable to set the relevant attributes related to that particular football club(home club)


        for (FootballClub footballClub : list_of_footballClubs) {
            if (footballClub.getClubName().equals(homeTeamPlaying)) {//if the home club entered by the user is in the football club arraylist
                if (footballClub instanceof UniversityFootballClub) {//and of the home club os a university football club
                    isClubUniversity = true;//making the boolean value to true as the home club is a university football club.

                }

                //else if the football club entered by the user is a school football club
                homeClub = footballClub;//take the specific club name entered by the user and the relevant features of that club name into the home club variable

                homeClubFound = true;//as the home club is found making the boolean value to true

            }
        }
        FootballClub opponentClub = null;//taking a variable to set the relevant attributes related to that particular football club(opponent club)

        for (FootballClub footballClub : list_of_footballClubs) {
            if ((footballClub.getClubName().equals(opponentTeamPlaying))) {//if the opponent club entered by the user is in the list of football clubs
                if (isClubUniversity == true) {//making the boolean value to true as it a university football club
                    if (footballClub instanceof UniversityFootballClub) {

                        isClubUniversity = true;
                    }
                }

                opponentClub = footballClub;
                opponentClubFound = true;
            }

        }


        if (homeClubFound == false) {//if the home club entered by the user is not found printing an error message
            System.out.println("ERROR ! This Home Team is not registered...Please register it first !!!");
            System.out.println("\n");

        }
        if (opponentClubFound == false) {//if the opponent club entered by the user is not found printing an error message
            System.out.println("ERROR ! This Opponent Team is not registered on selected divisions...Please register it first !!!");
            System.out.println("\n");

        }
        if (homeClubFound == true && opponentClubFound == true) {//if the home club and the opponent club entered by the user, both are found adding the elements to the arraylist and setting it to the match simulation class
            MatchSimulation matchSimulation = new MatchSimulation(homeTeamPlaying, opponentTeamPlaying, dateMatchesPlayed, goalsScoredHomeTeam, goalsScoredOpponentTeam);
            playedMatchesSimulation.add(matchSimulation);
            System.out.println(playedMatchesSimulation);


            //printing an error message because one club can play maximum of 38 matches only for the season.
            if (homeClub.getNoOfMatchesPlayed() == 38) {
                System.out.println("ERROR ! MAXIMUM AMOUNT OF MATCHES PLAYED BY A single CLUB SHOULD NOT EXCEED 38 [Home club has exceeded the maximum amount]");
                System.out.println("\n");
            }
            if (opponentClub.getNoOfMatchesPlayed() == 38) {
                System.out.println("ERROR ! MAXIMUM AMOUNT OF MATCHES PLAYED BY A single CLUB SHOULD NOT EXCEED 38 [Opponent club has exceeded the maximum amount]");
                System.out.println("\n");
            }


            homeClub.setNoOfMatchesPlayed(homeClub.getNoOfMatchesPlayed() + 1);//increase the number of matches played by one
            homeClub.setGoalsScored(homeClub.getGoalsScored() + goalsScoredHomeTeam);//updating the goals scored the home team
            homeClub.setGoalsReceived(homeClub.getGoalsReceived() + goalsScoredOpponentTeam);//updating the goals received by the home team

            opponentClub.setNoOfMatchesPlayed(opponentClub.getNoOfMatchesPlayed() + 1);//increase the number of matches played by one
            opponentClub.setGoalsScored(opponentClub.getGoalsScored() + goalsScoredOpponentTeam);//updating the goals scored the opponent team
            opponentClub.setGoalsReceived(opponentClub.getGoalsReceived() + goalsScoredHomeTeam);//updating the goals received by the opponent team


            if (goalsScoredHomeTeam > goalsScoredOpponentTeam) {//if the goals scored by home team is greater than the goals scored by the opponent team
                homeClub.setPointsScored(homeClub.getPointsScored() + 3);//increasing the points of the home team by 3
                homeClub.setMatchesWon(homeClub.getMatchesWon() + 1);//increasing the number of matches won by the home team by one
                opponentClub.setMatchesLost(opponentClub.getMatchesLost() + 1);//increasing the number of matches lost by the opponent team by one
                System.out.println("HOME CLUB HAS WON THE MATCH...");
                System.out.println("\n");

            }
            if (goalsScoredHomeTeam < goalsScoredOpponentTeam) {//if the goals scored by opponent team is greater than the goals scored by the home team
                opponentClub.setPointsScored(opponentClub.getPointsScored() + 3);//increasing the points of the opponent team by 3
                opponentClub.setMatchesWon(opponentClub.getMatchesWon() + 1);//increasing the number of matches won by the opponent team by one
                homeClub.setMatchesLost(homeClub.getMatchesLost() + 1);//increasing the number of matches lost by the home team by one
                System.out.println("OPPONENT CLUB HAS WON THE MATCH...");
                System.out.println("\n");

            }
            if (goalsScoredHomeTeam == goalsScoredOpponentTeam) {//if the goals scored by the home team and the opponent team is equal
                homeClub.setPointsScored(homeClub.getPointsScored() + 1);//increasing the number of points scored by the home club by one
                opponentClub.setPointsScored(opponentClub.getPointsScored() + 1);//increasing the number og points scored by the opponent club by one
                homeClub.setMatchesDrawn(homeClub.getMatchesDrawn() + 1);//increasing the number of matches drawn by the home club by one
                opponentClub.setMatchesDrawn(opponentClub.getMatchesDrawn() + 1);//increasing the number of matches drawn by the opponent club by one
                System.out.println("MATCH HAS BEEN DRAWN...");
                System.out.println("\n");
            }
        }
    }


    //Method that is used to save the the information entered by the user into a text file
    @Override
    public void saveInAFile() {

        try {
            //creating text file of football clubs
            FileOutputStream fileOutputStreamPremierLeague1 = new FileOutputStream("footballClubPremierLeague.txt");
            ObjectOutputStream objectOutputStreamPremierLeague1 = new ObjectOutputStream(fileOutputStreamPremierLeague1);

            //creating text file of matches played
            FileOutputStream fileOutputStreamPremierLeague2 = new FileOutputStream("matchSimulation.txt");
            ObjectOutputStream objectOutputStreamPremierLeague2 = new ObjectOutputStream(fileOutputStreamPremierLeague2);

            //writing objects into the text file which are in the football clubs
            for (FootballClub footballClub : list_of_footballClubs) {
                objectOutputStreamPremierLeague1.writeObject(footballClub);
            }
            //flush the object output stream
            objectOutputStreamPremierLeague1.flush();
            //close the fileoutputstream and objectoutputstream
            fileOutputStreamPremierLeague1.close();
            objectOutputStreamPremierLeague1.close();

            //writing objects into the text file which the matches are played
            for (MatchSimulation matchSimulation : playedMatchesSimulation) {
                objectOutputStreamPremierLeague2.writeObject(matchSimulation);
            }
            //flush the object output stream
            objectOutputStreamPremierLeague2.flush();
            //close the fileoutputstream and objectoutputstream
            fileOutputStreamPremierLeague2.close();
            objectOutputStreamPremierLeague2.close();

            System.out.println("DATA SAVED SUCCESSFULLY...");
            System.out.println("\n");
            //show any errors there are errors
        } catch (Exception exception) {
            System.out.println("ERROR in Saving !");
            System.out.println("\n");
        }
    }


    @Override
    public void loadFromFile() throws IOException {

        try {
            //Creating a stream to read the objects in the text file
            FileInputStream fileInputStream1 = new FileInputStream("footballClubPremierLeague.txt");
            ObjectInputStream objectInputStream1 = new ObjectInputStream(fileInputStream1);

            while (true) {
                FootballClub footballClub = (FootballClub) objectInputStream1.readObject();

                list_of_footballClubs.add(footballClub);
                freeSpacesForClubs -= footballClub instanceof UniversityFootballClub ? 1 : 1;//if the football club is a university football club reducing the space by one and else also one

            }


        } catch (ClassNotFoundException classNotFoundException) {//exception for class not found
            System.out.println("ERROR ! Class not found Exception has occurred");
            System.out.println("\n");
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("ERROR ! File not found Exception has occurred");
            System.out.println("\n");
        } catch (EOFException eofException) {//exception for end of file
            System.out.println("==============================");
            System.out.println("FILE HAS BEEN READ COMPLETELY");
            System.out.println("==============================");
            System.out.println("\n");
        }
        if (list_of_footballClubs.size() > 1) {
            System.out.println("DATA LOADED SUCCESSFULLY OF FOOTBALL CLUBS");
            System.out.println("\n");
        }
        new FileOutputStream("footballClubPremierLeague.txt").close();//flushing the text file after reading

        try {
            //Creating a stream to read the objects in the text file
            FileInputStream fileInputStream2 = new FileInputStream("matchSimulation.txt");
            ObjectInputStream objectInputStream2 = new ObjectInputStream(fileInputStream2);

            while (true) {
                MatchSimulation matchSimulation = (MatchSimulation) objectInputStream2.readObject();

                playedMatchesSimulation.add(matchSimulation);
            }

        } catch (ClassNotFoundException classNotFoundException) {//exception for class not found
            System.out.println("ERROR ! Class not found Exception has occurred");
            System.out.println("\n");
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("ERROR ! File not found Exception has occurred");
            System.out.println("\n");
        } catch (EOFException eofException) {//exception for end of file
            System.out.println("==============================");
            System.out.println("FILE HAS BEEN READ COMPLETELY");
            System.out.println("==============================");
            System.out.println("\n");
        }
        if (playedMatchesSimulation.size() > 1) {
            System.out.println("DATA LOADED SUCCESSFULLY OF MATCHES PLAYED");
            System.out.println("\n");
        }
        new FileOutputStream("matchSimulation.txt").close();//flushing the text file after reading
    }

//
//    @Override
//    public void displayPremierLeagueTableGUI() {
//
//        //table creation
//        TableView<FootballClub> tableFootballClubsPremierLeague = new TableView<>();
//
//        //stage to the table
//        Stage window = new Stage();
//
//        //pane layout for the table
//        Pane layout = new Pane();
//
//        //scrollpane to adjust the size of the winodw
//        ScrollPane scrollPane = new ScrollPane();
//        scrollPane.setContent(layout);
//        scrollPane.setPrefSize(70000, 85500);
//        scrollPane.setStyle("-fx-background-color: #0000A0;");
//        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
//        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
//
//
//        //title of the window
//        window.setTitle("FOOTBALL PREMIER LEAGUE");
//
//        BackgroundFill background_fill = new BackgroundFill(Color.LIGHTSKYBLUE, CornerRadii.EMPTY, Insets.EMPTY);
//        Background background = new Background(background_fill);
//        // set background
//        layout.setBackground(background);
//
//        //heading of the layout
//        Label heading = new Label("PREMIER LEAGUE MANAGER");
//        heading.setLayoutX(520);
//        heading.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
//        layout.getChildren().add(heading);
//
//        //take the take day to search
//        TextField day = new TextField();
//        day.setLayoutX(990);
//        day.setLayoutY(20);
//        day.setMaxSize(70, 45);
//        day.setPromptText("DAY");
//        layout.getChildren().add(day);
//
//        //take the month to search
//        TextField month = new TextField();
//        month.setLayoutX(1090);
//        month.setLayoutY(20);
//        month.setMaxSize(70, 45);
//        month.setPromptText("MONTH");
//        layout.getChildren().add(month);
//
//        //take the year to search
//        TextField year = new TextField();
//        year.setLayoutX(1190);
//        year.setLayoutY(20);
//        year.setMaxSize(70, 45);
//        year.setPromptText("YEAR");
//        layout.getChildren().add(year);
//
//        //search button to do the search function
//        Button search = new Button("Search");
//        search.setLayoutX(1290);
//        search.setLayoutY(20);
//        search.setMinSize(60, 30);
//        layout.getChildren().add(search);
//
//        //search action after clicking the button
//        search.setOnAction(event -> {
//
//            boolean dateFoundBoolean = false;//boolean value to find the date
//
//            //stage which appears after clicking the search button
//            Stage filterStage = new Stage();
//            filterStage.setTitle("Filter Table by the Date");//title of the stage
//
//
//            Pane dateFilter = new Pane();//pane layout of the search function
//
//            BackgroundFill background_fill_filterStage = new BackgroundFill(Color.MEDIUMTURQUOISE, CornerRadii.EMPTY, Insets.EMPTY);
//            Background background_matchSimulation = new Background(background_fill_filterStage);
//            // set background
//            dateFilter.setBackground(background_matchSimulation);
//
//            //break line by line when displaying the details of the clubs playd on a particular date
//            int yAxisHomeClub = 80;
//            int yAxisOpponentClub = 80;
//            int yAxisGoalsScoredHomeClub = 80;
//            int yAxisGoalsScoredOpponentClub = 80;
//
//
//            for (MatchSimulation matchSimulation : playedMatchesSimulation) {//looping inside the match simulation class from the arraylist
//                //if the day,month and year is in the arraylist printing the statistics of the matches played
//                if ((matchSimulation.getDateOfMatchPlayed().getDay() == Integer.parseInt(day.getText())) && (matchSimulation.getDateOfMatchPlayed().getMonth() == Integer.parseInt(month.getText()))
//                        && (matchSimulation.getDateOfMatchPlayed().getYear() == Integer.parseInt(year.getText()))) {
//                    dateFoundBoolean = true;//boolean value to true when the date os found
//
//                    //creating the labels to display the relavent data
//                    Label headingFilter = new Label("FILTER BY DATE");
//                    headingFilter.setTextFill(Color.web("#00008B"));
//                    headingFilter.setLayoutX(350);
//                    headingFilter.setLayoutY(10);
//                    headingFilter.setFont(Font.font("Helvetica", FontWeight.BOLD, FontPosture.ITALIC, 17));
//                    dateFilter.getChildren().add(headingFilter);
//
//                    Label homeClub = new Label("Home Club");
//                    homeClub.setLayoutX(10);
//                    homeClub.setLayoutY(50);
//                    homeClub.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
//                    dateFilter.getChildren().add(homeClub);
//
//                    Label opponentClub = new Label("Opponent Club");
//                    opponentClub.setLayoutX(170);
//                    opponentClub.setLayoutY(50);
//                    opponentClub.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
//                    dateFilter.getChildren().add(opponentClub);
//
//                    Label goalsScoredHomeClub = new Label("Goals Scored Home CLub");
//                    goalsScoredHomeClub.setLayoutX(370);
//                    goalsScoredHomeClub.setLayoutY(50);
//                    goalsScoredHomeClub.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
//                    dateFilter.getChildren().add(goalsScoredHomeClub);
//
//                    Label goalsScoredOpponentClub = new Label("Goals Scored opponent CLub");
//                    goalsScoredOpponentClub.setLayoutX(580);
//                    goalsScoredOpponentClub.setLayoutY(50);
//                    goalsScoredOpponentClub.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
//                    dateFilter.getChildren().add(goalsScoredOpponentClub);
//
//                    Label homeClubName = new Label(matchSimulation.getHomeTeam());
//                    homeClubName.setLayoutX(10);
//                    homeClubName.setLayoutY(yAxisHomeClub);
//                    yAxisHomeClub += 30;
//                    homeClubName.setFont(Font.font("Verdana", 12));
//                    dateFilter.getChildren().add(homeClubName);
//
//                    Label opponentClubName = new Label(matchSimulation.getOpponentTeam());
//                    opponentClubName.setLayoutX(170);
//                    opponentClubName.setLayoutY(yAxisOpponentClub);
//                    yAxisOpponentClub += 30;
//                    opponentClubName.setFont(Font.font("Verdana", 12));
//                    dateFilter.getChildren().add(opponentClubName);
//
//                    Label goalsScoredHomeClubValue = new Label(matchSimulation.getGoalsScoredHomeTeam() + "");
//                    goalsScoredHomeClubValue.setLayoutX(370);
//                    goalsScoredHomeClubValue.setLayoutY(yAxisGoalsScoredHomeClub);
//                    yAxisGoalsScoredHomeClub += 30;
//                    goalsScoredHomeClubValue.setFont(Font.font("Verdana", 12));
//                    dateFilter.getChildren().add(goalsScoredHomeClubValue);
//
//                    Label goalsScoredOpponentClubValue = new Label(matchSimulation.getGoalsScoredOpponentTeam() + "");
//                    goalsScoredOpponentClubValue.setLayoutX(580);
//                    goalsScoredOpponentClubValue.setLayoutY(yAxisGoalsScoredOpponentClub);
//                    yAxisGoalsScoredOpponentClub += 30;
//                    goalsScoredOpponentClubValue.setFont(Font.font("Verdana", 12));
//                    dateFilter.getChildren().add(goalsScoredOpponentClubValue);
//
//                }
//            }
//            if (dateFoundBoolean == true) {
//                //show the window and setting the relevant width and height
//                Scene dateFilterScene = new Scene(dateFilter, 800, 500);
//                filterStage.setScene(dateFilterScene);
//                filterStage.showAndWait();
//            }
//
//            //if the date os not found showing an a;ert box that the date is not found
//            if (dateFoundBoolean == false) {
//                Alert alertSuccessfullyUpdated = new Alert(Alert.AlertType.INFORMATION);
//                alertSuccessfullyUpdated.setContentText("SORRY ! NO MATCH HAS BEEN PLAYED ON THAT DATE, OR YOU HAVE ENTERED A WRONG DATE");
//                alertSuccessfullyUpdated.showAndWait();
//            }
//
//        });
//
//        //creating the columns for the table adjusting a default size for the columns, and also making relevant columns unsortable
//        //Club name column
//        TableColumn<FootballClub, String> clubColumn = new TableColumn<>("Club name");
//        clubColumn.setMinWidth(200);
//        clubColumn.setCellValueFactory(new PropertyValueFactory<>("clubName"));
//        clubColumn.setSortable(false);
//
//        //country column
//        TableColumn<FootballClub, String> countryColumn = new TableColumn<>("Country");
//        countryColumn.setMinWidth(150);
//        countryColumn.setCellValueFactory(new PropertyValueFactory<>("country"));
//        countryColumn.setSortable(false);
//
//        //location column
//        TableColumn<FootballClub, String> locationColumn = new TableColumn<>("Location");
//        locationColumn.setMinWidth(150);
//        locationColumn.setCellValueFactory(new PropertyValueFactory<>("location"));
//        locationColumn.setSortable(false);
//
//        //noOfMatchesPlayed column
//        TableColumn<FootballClub, Integer> noOfMatchesColumn = new TableColumn<>("No Of Matches Played");
//        noOfMatchesColumn.setMinWidth(150);
//        noOfMatchesColumn.setCellValueFactory(new PropertyValueFactory<>("noOfMatchesPlayed"));
//        noOfMatchesColumn.setSortable(false);
//
//        //matchesWon column
//        TableColumn<FootballClub, Integer> wonColumn = new TableColumn<>("Matches Won");
//        wonColumn.setMinWidth(120);
//        wonColumn.setCellValueFactory(new PropertyValueFactory<>("matchesWon"));
//
//        //matchesLost column
//        TableColumn<FootballClub, Integer> matchesLostColumn = new TableColumn<>("Matches Lost");
//        matchesLostColumn.setMinWidth(120);
//        matchesLostColumn.setCellValueFactory(new PropertyValueFactory<>("matchesLost"));
//        matchesLostColumn.setSortable(false);
//
//        //matchesDrawn column
//        TableColumn<FootballClub, Integer> matchesDrawnColumn = new TableColumn<>("Matches Drawn");
//        matchesDrawnColumn.setMinWidth(120);
//        matchesDrawnColumn.setCellValueFactory(new PropertyValueFactory<>("matchesDrawn"));
//        matchesDrawnColumn.setSortable(false);
//
//        //goalsScored column
//        TableColumn<FootballClub, Integer> goalsScoredColumn = new TableColumn<>("Goals Scored");
//        goalsScoredColumn.setMinWidth(120);
//        goalsScoredColumn.setCellValueFactory(new PropertyValueFactory<>("goalsScored"));
//
//        //goalsReceived column
//        TableColumn<FootballClub, Integer> goalsReceivedColumn = new TableColumn<>("Goals Received");
//        goalsReceivedColumn.setMinWidth(120);
//        goalsReceivedColumn.setCellValueFactory(new PropertyValueFactory<>("goalsReceived"));
//        goalsReceivedColumn.setSortable(false);
//
//        //pointsScored column
//        TableColumn<FootballClub, Integer> pointsScoredColumn = new TableColumn<>("Points Scored");
//        pointsScoredColumn.setMinWidth(110);
//        pointsScoredColumn.setCellValueFactory(new PropertyValueFactory<>("pointsScored"));
//
//        tableFootballClubsPremierLeague.setLayoutY(50);
//        tableFootballClubsPremierLeague.setItems(getFootballClubs());
//        tableFootballClubsPremierLeague.getColumns().addAll(clubColumn, countryColumn, locationColumn,
//                noOfMatchesColumn, wonColumn, matchesLostColumn,
//                matchesDrawnColumn, goalsScoredColumn, goalsReceivedColumn, pointsScoredColumn);
//
//
//        //button to sort the points in descending order
//        Button sortPoints = new Button("SORT POINTS IN DESCENDING ORDER");
//        sortPoints.setLayoutX(20);
//        sortPoints.setLayoutY(550);
//        sortPoints.setMinSize(100, 50);
//        layout.getChildren().add(sortPoints);
//
//
//        //if the sorting points button is pressed sort the points in descending order
//        sortPoints.setOnAction(event -> {
//            tableFootballClubsPremierLeague.getSortOrder().clear();//clearing the sorted table first to sort the points scored
//            tableFootballClubsPremierLeague.getSortOrder().add(pointsScoredColumn);
//            pointsScoredColumn.setSortType(TableColumn.SortType.DESCENDING);
//            tableFootballClubsPremierLeague.sort();
//        });
//
//        //button to sort the number of wins in descending order
//        Button sortNoOfWins = new Button("SORT NUMBER OF WINS IN DESCENDING ORDER");
//        //setting the position the button
//        sortNoOfWins.setLayoutX(280);
//        sortNoOfWins.setLayoutY(550);
//        sortNoOfWins.setMinSize(100, 50);
//        layout.getChildren().add(sortNoOfWins);
//
//
//        //function which sort the number of wins in descending order
//        sortNoOfWins.setOnAction(event -> {
//            tableFootballClubsPremierLeague.getSortOrder().clear();//clearing the sorted table first to sort the number of wins in descending order
//            tableFootballClubsPremierLeague.getSortOrder().add(wonColumn);
//            wonColumn.setSortType(TableColumn.SortType.DESCENDING);
//            tableFootballClubsPremierLeague.sort();
//        });
//
//        //button to sort the goals scored in descending order
//        Button sortGoalsScored = new Button("SORT GOALS SCORED IN DESCENDING ORDER");
//        //position of the button
//        sortGoalsScored.setLayoutX(600);
//        sortGoalsScored.setLayoutY(550);
//        sortGoalsScored.setMinSize(100, 50);
//        layout.getChildren().add(sortGoalsScored);
//
//        //function which sort the goals scored in descending order
//        sortGoalsScored.setOnAction(event -> {
//            tableFootballClubsPremierLeague.getSortOrder().clear();//clear the sorted table first to perform the sorting function
//            tableFootballClubsPremierLeague.getSortOrder().add(goalsScoredColumn);
//            goalsScoredColumn.setSortType(TableColumn.SortType.DESCENDING);
//            tableFootballClubsPremierLeague.sort();
//        });
//
//        //button to play a random match
//        Button randomMatch = new Button("Random Match");
//        //position of the button in the window
//        randomMatch.setLayoutX(900);
//        randomMatch.setLayoutY(550);
//        randomMatch.setMinSize(100, 50);
//        layout.getChildren().add(randomMatch);
//
//        //disable the random match button when the football club list size is equal to one
//        if (list_of_footballClubs.size() == 1) {
//            randomMatch.setDisable(true);
//        }
//
//
//        //disable the button if the played matches list is less than one
//        if (playedMatchesSimulation.size() < 1) {
//            randomMatch.setDisable(true);
//        }
//
//        //button action to play a random match
//        randomMatch.setOnAction(event -> {
//            //table creation
//            TableView<FootballClub> tableRandomMatch = new TableView<>();
//
//            //random home team and opponent team
//            Random randomHomeTeam = new Random();
//            Random randomOpponentTeam = new Random();
//
//            //random date for random match
//            Random date = new Random();
//
//            //stage for the random match
//            Stage randomMatchInfo = new Stage();
//            randomMatchInfo.setTitle("MATCH SIMULATION");//title of the stage
//
//            Pane matchInfoPane = new Pane();//pane layout for the random matches
//
//            BackgroundFill background_fill_matchSimulation = new BackgroundFill(Color.CADETBLUE, CornerRadii.EMPTY, Insets.EMPTY);
//            Background background_matchSimulation = new Background(background_fill_matchSimulation);
//            // set background
//            matchInfoPane.setBackground(background_matchSimulation);
//
//            //random goals score by the home team
//            int goalsScoredHomeTeam = randomHomeTeam.nextInt(11);
//            //random goals scored by the opponent team
//            int goalsScoredOpponentTeam = randomOpponentTeam.nextInt(11);
//
//            //generate random dates
//            int dayRandom = date.nextInt(31) + 1;
//            int monthRandom = date.nextInt(12) + 1;
//            int yearRandom = 2020;
//
//            //set the random dates for the date constructor
//            DateMatchesPlayed dateMatchesPlayed = new DateMatchesPlayed(dayRandom, monthRandom, yearRandom);
//
//            clubSameLoop:
//            while (true) {
//
//                //generate random home team name
//                int randomGenerateHomeTeam = randomHomeTeam.nextInt(list_of_footballClubs.size());
//                FootballClub randomElementHomeTeam = list_of_footballClubs.get(randomGenerateHomeTeam);
//
//                //generate random opponent team name
//                int randomGenerateOpponentTeam = randomOpponentTeam.nextInt(list_of_footballClubs.size());
//                FootballClub randomElementOpponentTeam = list_of_footballClubs.get(randomGenerateOpponentTeam);
//
//                //random home team should be equal to the home team in the football club list
//                if (!(randomElementHomeTeam.getClubName().equals(randomElementOpponentTeam.getClubName()))) {
//                    //check whether the random home team and opponent team is university sports club
//                    if ((randomElementHomeTeam instanceof UniversityFootballClub && randomElementOpponentTeam instanceof UniversityFootballClub) ||
//                            //check whether the random home team and opponent team is school sports club
//                            randomElementHomeTeam instanceof SchoolFootballClub && randomElementOpponentTeam instanceof SchoolFootballClub) {
//
//                        Label headingRandomMatch = new Label("RANDOM PLAYED MATCH");
//                        headingRandomMatch.setTextFill(Color.web("#00008B"));
//                        headingRandomMatch.setLayoutX(270);
//                        headingRandomMatch.setLayoutY(10);
//                        headingRandomMatch.setFont(Font.font("Helvetica", FontWeight.BOLD, FontPosture.ITALIC, 17));
//                        matchInfoPane.getChildren().add(headingRandomMatch);
//
//                        //displaying the random home team and random opponent team, random goals scored by the home team, random goals scored by the opponent team
//                        Label homeTeam = new Label("* HOME TEAM \t\t\t\t\t\t\t: " + randomElementHomeTeam.getClubName());
//                        homeTeam.setLayoutX(10);
//                        homeTeam.setLayoutY(50);
//                        homeTeam.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
//                        matchInfoPane.getChildren().add(homeTeam);
//
//                        Label opponentTeam = new Label("* OPPONENT TEAM \t\t\t\t\t: " + randomElementOpponentTeam.getClubName());
//                        opponentTeam.setLayoutX(10);
//                        opponentTeam.setLayoutY(100);
//                        opponentTeam.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
//                        matchInfoPane.getChildren().add(opponentTeam);
//
//                        Label dateMatchPlayed = new Label("* Date of Match Played \t\t\t\t\t: " + dateMatchesPlayed);
//                        dateMatchPlayed.setLayoutX(10);
//                        dateMatchPlayed.setLayoutY(150);
//                        dateMatchPlayed.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
//                        matchInfoPane.getChildren().add(dateMatchPlayed);
//
//                        Label goalsScoredHomeTeamLabel = new Label("* " + "Goals Scored by the home team \t\t: " + goalsScoredHomeTeam);
//                        goalsScoredHomeTeamLabel.setLayoutX(10);
//                        goalsScoredHomeTeamLabel.setLayoutY(200);
//                        goalsScoredHomeTeamLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
//                        matchInfoPane.getChildren().add(goalsScoredHomeTeamLabel);
//
//                        Label goalsScoredOpponentTeamLabel = new Label("* " + "Goals Scored by the opponent team \t\t: " + goalsScoredOpponentTeam);
//                        goalsScoredOpponentTeamLabel.setLayoutX(10);
//                        goalsScoredOpponentTeamLabel.setLayoutY(250);
//                        goalsScoredOpponentTeamLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
//                        matchInfoPane.getChildren().add(goalsScoredOpponentTeamLabel);
//
//                        Label goalReceivedHomeTeamLabel = new Label("* " + "Goals Received by the home team \t\t: " + goalsScoredOpponentTeam);
//                        goalReceivedHomeTeamLabel.setLayoutX(10);
//                        goalReceivedHomeTeamLabel.setLayoutY(300);
//                        goalReceivedHomeTeamLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
//                        matchInfoPane.getChildren().add(goalReceivedHomeTeamLabel);
//
//                        Label goalReceivedOpponentTeamLabel = new Label("* " + "Goals Received by the opponent team \t: " + goalsScoredHomeTeam);
//                        goalReceivedOpponentTeamLabel.setLayoutX(10);
//                        goalReceivedOpponentTeamLabel.setLayoutY(350);
//                        goalReceivedOpponentTeamLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
//                        matchInfoPane.getChildren().add(goalReceivedOpponentTeamLabel);
//
//                        Label teamsPlayed = new Label("# " + randomElementHomeTeam.getClubName() + " is played with ------> " + randomElementOpponentTeam.getClubName());
//                        teamsPlayed.setLayoutX(10);
//                        teamsPlayed.setLayoutY(450);
//                        teamsPlayed.setFont(Font.font("Verdana", FontWeight.BOLD, 14));
//                        matchInfoPane.getChildren().add(teamsPlayed);
//
//                        //set the values to the match simulation constructor
//                        MatchSimulation matchSimulation = new MatchSimulation(randomElementHomeTeam.getClubName(), randomElementOpponentTeam.getClubName(), dateMatchesPlayed, goalsScoredHomeTeam, goalsScoredOpponentTeam);
//                        playedMatchesSimulation.add(matchSimulation);
//                        //System.out.println(playedMatchesSimulation);
//
//                        boolean homeClubFound = false;//to find the home club entered by the user
//                        boolean opponentClubFound = false;//to find the opponent club entered by the user
//
//                        boolean isClubUniversity = false;//to find the club entered by the user belongs to which division
//
//                        FootballClub homeClub = null;//taking a variable to set the relevant attributes related to that particular football club(home club)
//
//
//                        for (FootballClub footballClub : list_of_footballClubs) {
//                            if (footballClub.getClubName().equals(randomElementHomeTeam.getClubName())) {//if the home club entered by the user is in the football club arraylist
//                                if (footballClub instanceof UniversityFootballClub) {//and of the home club os a university football club
//                                    isClubUniversity = true;//making the boolean value to true as the home club is a university football club.
//
//                                }
//
//                                //else if the football club entered by the user is a school football club
//                                homeClub = footballClub;//take the specific club name entered by the user and the relevant features of that club name into the home club variable
//
//                                homeClubFound = true;//as the home club is found making the boolean value to true
//
//                            }
//                        }
//                        FootballClub opponentClub = null;//taking a variable to set the relevant attributes related to that particular football club(opponent club)
//
//                        for (FootballClub footballClub : list_of_footballClubs) {
//                            if ((footballClub.getClubName().equals(randomElementOpponentTeam.getClubName()))) {//if the opponent club entered by the user is in the list of football clubs
//                                if (isClubUniversity == true) {//making the boolean value to true as it a university football club
//                                    if (footballClub instanceof UniversityFootballClub) {
//                                        isClubUniversity = true;
//                                    }
//                                }
//
//                                opponentClub = footballClub;
//                                opponentClubFound = true;
//                            }
//
//                        }
//
//                        if (homeClubFound == true && opponentClubFound == true) {//if the home club and the opponent club entered by the user, both are found adding the elements to the arraylist and setting it to the match simulation class
//
//                            homeClub.setNoOfMatchesPlayed(homeClub.getNoOfMatchesPlayed() + 1);//increase the number of matches played by one
//                            homeClub.setGoalsScored(homeClub.getGoalsScored() + goalsScoredHomeTeam);//updating the goals scored the home team
//                            homeClub.setGoalsReceived(homeClub.getGoalsReceived() + goalsScoredOpponentTeam);//updating the goals received by the home team
//
//                            opponentClub.setNoOfMatchesPlayed(opponentClub.getNoOfMatchesPlayed() + 1);//increase the number of matches played by one
//                            opponentClub.setGoalsScored(opponentClub.getGoalsScored() + goalsScoredOpponentTeam);//updating the goals scored the opponent team
//                            opponentClub.setGoalsReceived(opponentClub.getGoalsReceived() + goalsScoredHomeTeam);//updating the goals received by the opponent team
//
//
//                            if (goalsScoredHomeTeam > goalsScoredOpponentTeam) {//if the goals scored by home team is greater than the goals scored by the opponent team
//                                homeClub.setPointsScored(homeClub.getPointsScored() + 3);//increasing the points of the home team by 3
//                                homeClub.setMatchesWon(homeClub.getMatchesWon() + 1);//increasing the number of matches won by the home team by one
//                                opponentClub.setMatchesLost(opponentClub.getMatchesLost() + 1);//increasing the number of matches lost by the opponent team by one
//
//                                Label wonTeam = new Label("***** " + "HOME TEAM WON THE MATCH " + " *****");
//                                wonTeam.setLayoutX(60);
//                                wonTeam.setLayoutY(500);
//                                wonTeam.setFont(Font.font("Verdana", FontWeight.BOLD, 14));
//                                matchInfoPane.getChildren().add(wonTeam);
//                            }
//                            if (goalsScoredHomeTeam < goalsScoredOpponentTeam) {//if the goals scored by opponent team is greater than the goals scored by the home team
//                                opponentClub.setPointsScored(opponentClub.getPointsScored() + 3);//increasing the points of the opponent team by 3
//                                opponentClub.setMatchesWon(opponentClub.getMatchesWon() + 1);//increasing the number of matches won by the opponent team by one
//                                homeClub.setMatchesLost(homeClub.getMatchesLost() + 1);//increasing the number of matches lost by the home team by one
//
//                                Label wonTeam = new Label("***** " + "Opponent TEAM WON THE MATCH " + " *****");
//                                wonTeam.setLayoutX(60);
//                                wonTeam.setLayoutY(500);
//                                wonTeam.setFont(Font.font("Verdana", FontWeight.BOLD, 14));
//                                matchInfoPane.getChildren().add(wonTeam);
//                            }
//                            if (goalsScoredHomeTeam == goalsScoredOpponentTeam) {//if the goals scored by the home team and the opponent team is equal
//                                homeClub.setPointsScored(homeClub.getPointsScored() + 1);//increasing the number of points scored by the home club by one
//                                opponentClub.setPointsScored(opponentClub.getPointsScored() + 1);//increasing the number og points scored by the opponent club by one
//                                homeClub.setMatchesDrawn(homeClub.getMatchesDrawn() + 1);//increasing the number of matches drawn by the home club by one
//                                opponentClub.setMatchesDrawn(opponentClub.getMatchesDrawn() + 1);//increasing the number of matches drawn by the opponent club by one
//
//                                Label wonTeam = new Label("***** " + "MATCH TIED " + " *****");
//                                wonTeam.setLayoutX(60);
//                                wonTeam.setLayoutY(500);
//                                wonTeam.setFont(Font.font("Verdana", FontWeight.BOLD, 14));
//                                matchInfoPane.getChildren().add(wonTeam);
//                            }
//                        }
//
//                        //button to exit from gui which displays the random matches
//                        Button closeGUI = new Button("Exit");
//                        closeGUI.setLayoutX(600);
//                        closeGUI.setLayoutY(600);
//                        closeGUI.setMinSize(100, 40);
//                        matchInfoPane.getChildren().add(closeGUI);
//
//                        //close the gui which displays the random matches
//                        closeGUI.setOnAction(event1 -> {
//                            //refresh the table after adding the random match details
//                            tableFootballClubsPremierLeague.refresh();
//                            //alert box to show that the details has been added to the table of the random match
//                            Alert alertSuccessfullyUpdated = new Alert(Alert.AlertType.INFORMATION);
//                            alertSuccessfullyUpdated.setContentText("SUCCESSFULLY UPDATED THE TABLE...");
//                            alertSuccessfullyUpdated.showAndWait();
//                            randomMatchInfo.close();
//
//                        });
//
//                        //size of the window which displays the random matches
//                        Scene matchInfoScene = new Scene(matchInfoPane, 800, 650);
//                        randomMatchInfo.setScene(matchInfoScene);
//                        randomMatchInfo.showAndWait();
//                        break clubSameLoop;
//                    } else {
//                        //continue the loop until the home team and the opponent team is not equal
//                        continue clubSameLoop;
//                    }
//                } else {
//                    //continue the loop until the home team and the opponent team is in the same division to play the match
//                    continue clubSameLoop;
//                }
//
//            }
//
//        });
//
//
//        //exit the main window
//        Button closeGUI = new Button("Exit");
//        closeGUI.setLayoutX(1230);
//        closeGUI.setLayoutY(650);
//        closeGUI.setMinSize(100, 50);
//        layout.getChildren().add(closeGUI);
//
//        //close the gui window the exit button is pressed
//        closeGUI.setOnAction(event ->
//        {
//            window.close();
//        });
//
//        //sort the table by date in ascending order
//        Button sortDateAscending = new Button("SORT TABLE BY DATE IN ASCENDING ORDER");
//        //position of the button
//        sortDateAscending.setLayoutX(1050);
//        sortDateAscending.setLayoutY(550);
//        sortDateAscending.setMinSize(100, 50);
//        layout.getChildren().add(sortDateAscending);
//
//        //disable the button if the football club list size is equal to one
//        if (list_of_footballClubs.size() == 1) {
//            sortDateAscending.setDisable(true);
//        }
//
//        //disable the button if the match simulation list size is equal to one
//        if (playedMatchesSimulation.size() < 1) {
//            sortDateAscending.setDisable(true);
//        }
//
//        //action to sort the date in ascending order
//        sortDateAscending.setOnAction(event -> {
//            //sort the matches played
//            Collections.sort(playedMatchesSimulation);
//
//            //stage to display the dates sorted in ascending order
//            Stage sortDateStage = new Stage();
//            //title of the window which sort the date in ascending order
//            sortDateStage.setTitle("Sort Date in Ascending Order");
//
//            //pane layout to display the date sorted in ascending order
//            Pane sortDateInAscendingOrderPane = new Pane();
//
//
//            BackgroundFill background_fill_sortDate = new BackgroundFill(Color.LIGHTSTEELBLUE, CornerRadii.EMPTY, Insets.EMPTY);
//            Background background_SortDateAscendingOrder = new Background(background_fill_sortDate);
//            // set background
//            sortDateInAscendingOrderPane.setBackground(background_SortDateAscendingOrder);
//
//            //break the labels line by line
//            int yAxisHomeTeam = 110;
//            int yAxisVs = 110;
//            int yAxisOpponentTeam = 110;
//            int yAxisArrow = 110;
//            int yAxisDateMatchPlayed = 110;
//
//            for (MatchSimulation matchSimulation : playedMatchesSimulation) {
//
//                Label headingSortDateAscending = new Label("SORT DATE IN ASCENDING ORDER");
//                headingSortDateAscending.setTextFill(Color.web("#00008B"));
//                headingSortDateAscending.setLayoutX(250);
//                headingSortDateAscending.setLayoutY(10);
//                headingSortDateAscending.setFont(Font.font("Helvetica", FontWeight.BOLD, FontPosture.ITALIC, 15));
//                sortDateInAscendingOrderPane.getChildren().add(headingSortDateAscending);
//
//                Label homeTeamPlayed = new Label("Home Team Played");
//                homeTeamPlayed.setLayoutX(20);
//                homeTeamPlayed.setLayoutY(70);
//                homeTeamPlayed.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
//                sortDateInAscendingOrderPane.getChildren().add(homeTeamPlayed);
//
//                Label opponentTeamPlayed = new Label("Opponent Team Played");
//                opponentTeamPlayed.setLayoutX(270);
//                opponentTeamPlayed.setLayoutY(70);
//                opponentTeamPlayed.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
//                sortDateInAscendingOrderPane.getChildren().add(opponentTeamPlayed);
//
//                Label dateMatchPlayedHeading = new Label("Date Of Match Played");
//                dateMatchPlayedHeading.setLayoutX(580);
//                dateMatchPlayedHeading.setLayoutY(70);
//                dateMatchPlayedHeading.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
//                sortDateInAscendingOrderPane.getChildren().add(dateMatchPlayedHeading);
//
//                //display the details of the matches which are sorted in ascending order by date
//                Label homeTeam = new Label("* " + matchSimulation.getHomeTeam());
//                homeTeam.setLayoutX(40);
//                homeTeam.setLayoutY(yAxisHomeTeam);
//                yAxisHomeTeam += 50;
//                homeTeam.setFont(Font.font("Verdana", 12));
//                sortDateInAscendingOrderPane.getChildren().add(homeTeam);
//
//                Label vs = new Label("VS");
//                vs.setLayoutX(205);
//                vs.setLayoutY(yAxisVs);
//                yAxisVs += 50;
//                vs.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
//                sortDateInAscendingOrderPane.getChildren().add(vs);
//
//                Label opponentTeam = new Label("* " + matchSimulation.getOpponentTeam());
//                opponentTeam.setLayoutX(270);
//                opponentTeam.setLayoutY(yAxisOpponentTeam);
//                yAxisOpponentTeam += 50;
//                opponentTeam.setFont(Font.font("Verdana", 12));
//                sortDateInAscendingOrderPane.getChildren().add(opponentTeam);
//
//                Label arrow = new Label("------------>");
//                arrow.setLayoutX(470);
//                arrow.setLayoutY(yAxisArrow);
//                yAxisArrow += 50;
//                arrow.setFont(Font.font("Verdana", 12));
//                sortDateInAscendingOrderPane.getChildren().add(arrow);
//
//                Label dateMatchPlayed = new Label(matchSimulation.getDateOfMatchPlayed() + "");
//                dateMatchPlayed.setLayoutX(580);
//                dateMatchPlayed.setLayoutY(yAxisDateMatchPlayed);
//                yAxisDateMatchPlayed += 50;
//                arrow.setFont(Font.font("Verdana", 12));
//                sortDateInAscendingOrderPane.getChildren().add(dateMatchPlayed);
//            }
//            //size of the window
//            Scene dateSortScene = new Scene(sortDateInAscendingOrderPane, 800, 600);
//            sortDateStage.setScene(dateSortScene);
//            sortDateStage.showAndWait();
//
//        });
//
//
//        //position of the table
//        tableFootballClubsPremierLeague.setLayoutX(5);
//        tableFootballClubsPremierLeague.setLayoutY(100);
//        //add elements the table to the layout
//        layout.getChildren().add(tableFootballClubsPremierLeague);
//
//        //show the main stage and adjust the size of the window
//        Scene scene = new Scene(scrollPane, 1400, 650);
//        window.setScene(scene);
//        window.showAndWait();
//    }
//
//    //add the football club list to the observable arraylist
//    public ObservableList<FootballClub> getFootballClubs() {
//        //sort the arraylist by points in descending order
//        Collections.sort(list_of_footballClubs, Collections.reverseOrder());//sort the arraylist of football clubs in descending order
//
//        ObservableList<FootballClub> footballClubs = FXCollections.observableArrayList();
//        //add the elements of the football clu  to the observable arraylist
//        for (FootballClub footballClub : list_of_footballClubs) {
//            footballClubs.add(footballClub);
//        }
//        //return the observable arraylist
//        return footballClubs;
//    }


}
