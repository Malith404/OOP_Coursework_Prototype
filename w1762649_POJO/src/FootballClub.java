public class FootballClub {

    //attributes that should contain in a football club
    private int goalsScored;
    private int goalsReceived;
    private int pointsScored;

    //constructor for football club
    public FootballClub(int goalsScored, int goalsReceived, int pointsScored) {
        this.goalsScored = goalsScored;
        this.goalsReceived = goalsReceived;
        this.pointsScored = pointsScored;
    }

    //getter for get and display the goals scored by a football club
    public int getGoalsScored() {
        return goalsScored;
    }

    //setter method to set the goals scored by a football club entered by the user
    public void setGoalsScored(int goalsScored) {
        this.goalsScored = goalsScored;
    }

    //getter for get and display the goals received for a football club
    public int getGoalsReceived() {
        return goalsReceived;
    }

    //setter method to set the goals revived for a football club entered by the user
    public void setGoalsReceived(int goalsReceived) {
        this.goalsReceived = goalsReceived;
    }

    //getter for get and display the points scored by a football club
    public int getPointsScored() {
        return pointsScored;
    }

    //setter method to set the points scored by a football club entered by the user
    public void setPointsScored(int pointsScored) {
        this.pointsScored = pointsScored;
    }


}