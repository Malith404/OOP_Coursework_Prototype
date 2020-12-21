import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class Main extends Application {

    Stage window;
    TableView<FootballClubs> tableView;
    private List<FootballClubs> list=new ArrayList<>();

    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane layout = new GridPane();

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(layout);
        scrollPane.setPrefSize(95500, 85500);
        scrollPane.setStyle("-fx-background-color: #0000A0;");
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);

        layout.setHgap(20);
        layout.setVgap(20);

        window = primaryStage;
        window.setTitle("FOOTBALL PREMIER LEAGUE");


        Button sortNoOfWins=new Button("SORT NUMBER OF WINS IN DESCENDING ORDER");
        layout.getChildren().add(sortNoOfWins);
        GridPane.setConstraints(sortNoOfWins,0,4);
        sortNoOfWins.setMinSize(100, 50);


        Button sortGoalsScored=new Button("SORT GOALS SCORED IN DESCENDING ORDER");
        layout.getChildren().add(sortGoalsScored);
        GridPane.setConstraints(sortGoalsScored,0,6);
        sortGoalsScored.setMinSize(100, 50);

        Button closeGUI=new Button("Exit");
        layout.getChildren().add(closeGUI);
        GridPane.setConstraints(closeGUI,0,8);
        closeGUI.setMinSize(100, 50);

        closeGUI.setOnAction(event -> {
            window.close();
        });

        //Club name column
        TableColumn<FootballClubs, String> clubColumn = new TableColumn<>("Club name");
        clubColumn.setMinWidth(200);
        clubColumn.setCellValueFactory(new PropertyValueFactory<>("clubName"));

        //country column
        TableColumn<FootballClubs, String> countryColumn = new TableColumn<>("Country");
        countryColumn.setMinWidth(200);
        countryColumn.setCellValueFactory(new PropertyValueFactory<>("country"));

        //location column
        TableColumn<FootballClubs, String> locationColumn = new TableColumn<>("Location");
        locationColumn.setMinWidth(200);
        locationColumn.setCellValueFactory(new PropertyValueFactory<>("city"));

        //noOfMatchesPlayed column
        TableColumn<FootballClubs, Integer> noOfMatchesColumn = new TableColumn<>("NoOfMatchesPlayed");
        noOfMatchesColumn.setMinWidth(160);
        noOfMatchesColumn.setCellValueFactory(new PropertyValueFactory<>("noOfMatchesPlayed"));

        //matchesWon column
        TableColumn<FootballClubs, Integer> wonColumn = new TableColumn<>("Won");
        wonColumn.setMinWidth(100);
        wonColumn.setCellValueFactory(new PropertyValueFactory<>("matchesWon"));


        //matchesLost column
        TableColumn<FootballClubs, Integer> matchesLostColumn = new TableColumn<>("Lost");
        matchesLostColumn.setMinWidth(100);
        matchesLostColumn.setCellValueFactory(new PropertyValueFactory<>("matchesLost"));

        //matchesDrawn column
        TableColumn<FootballClubs, Integer> matchesDrawnColumn = new TableColumn<>("Drawn");
        matchesDrawnColumn.setMinWidth(100);
        matchesDrawnColumn.setCellValueFactory(new PropertyValueFactory<>("matchesDrawn"));

        //goalsScored column
        TableColumn<FootballClubs, Integer> goalsScoredColumn = new TableColumn<>("GoalsScored");
        goalsScoredColumn.setMinWidth(100);
        goalsScoredColumn.setCellValueFactory(new PropertyValueFactory<>("goalsScored"));

        //goalsReceived column
        TableColumn<FootballClubs, Integer> goalsReceivedColumn = new TableColumn<>("GoalsReceived");
        goalsReceivedColumn.setMinWidth(100);
        goalsReceivedColumn.setCellValueFactory(new PropertyValueFactory<>("goalsReceived"));

        //pointsScored column
        TableColumn<FootballClubs, Integer> pointsScoredColumn = new TableColumn<>("pointsScored");
        pointsScoredColumn.setMinWidth(110);
        pointsScoredColumn.setCellValueFactory(new PropertyValueFactory<>("pointsScored"));

        tableView = new TableView<>();
        tableView.setItems(getFootballClubs());
        tableView.getColumns().addAll(clubColumn, countryColumn, locationColumn,
                noOfMatchesColumn, wonColumn, matchesLostColumn,
                matchesDrawnColumn, goalsScoredColumn, goalsReceivedColumn, pointsScoredColumn);


        layout.getChildren().add(tableView);
        /*GridPane.setConstraints(tableView, 0, 0);*/
        tableView.setMinWidth(1500);

        Scene scene = new Scene(scrollPane, 3000, 600);
        window.setScene(scene);
        window.show();
    }



    public ObservableList<FootballClubs> getFootballClubs() {
        Collections.sort(list,Collections.reverseOrder());

        ObservableList<FootballClubs> footballClubs = FXCollections.observableArrayList();
        list.add(new FootballClubs("Manchester united", "England", "London", 4, 2,
                1, 1, 5, 2, 3));
        list.add(new FootballClubs("Brighton & Hove Albion", "SriLanka", "Colombo", 6, 2,
                1, 3, 12, 9, 13));

        for (FootballClubs footballClubs1:list){
            footballClubs.add(footballClubs1);
        }
        return footballClubs;
    }

}
