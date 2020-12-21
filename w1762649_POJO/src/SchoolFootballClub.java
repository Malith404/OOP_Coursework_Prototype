public class SchoolFootballClub {

    //attributes that a school football club should contain
    private String schoolName;
    private int noOfPlayers;//number of players in the school football club

    //constructor for school football club
    public SchoolFootballClub(String schoolName, int noOfPlayers) {
        this.schoolName = schoolName;
        this.noOfPlayers = noOfPlayers;
    }

    //getter method to get and display the school name
    public String getSchoolName() {
        return schoolName;
    }

    //setter method to set the school name entered by the user
    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    //getter method to get and display the number of player
    public int getNoOfPlayers() {
        return noOfPlayers;
    }

    //setter method to set the number of players entered by the user
    public void setNoOfPlayers(int noOfPlayers) {
        this.noOfPlayers = noOfPlayers;
    }

}
