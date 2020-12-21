public class UniversityFootballClub {

    //attributes that a university football club should contain
    private String universityName;
    private int noOfPlayers;//number of players in the university football club

      //constructor for university football club
     public UniversityFootballClub(String universityName, int noOfPlayers) {
        this.universityName = universityName;
        this.noOfPlayers = noOfPlayers;
     }

    //getter method to get and display the university name
     public String getUniversityName() {
          return universityName;
    }

     //setter method to set the number of players which is entered by the user
    public void setUniversityName(String universityName) {
       this.universityName = universityName;
    }

    //getter method to get and display the number of players
    public int getNoOfPlayers() {
      return noOfPlayers;
     }

     //setter method to set the number of players which is entered by the user
    public void setNoOfPlayers(int noOfPlayers) {
        this.noOfPlayers = noOfPlayers;
    }

 }
