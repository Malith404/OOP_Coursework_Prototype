public class SportsClub {
    
      //attributes that a common sport club should contain
    private String clubName;
    private String country;//country of the sport club
    private String location;//location/city of the sport club
    private int noOfMatchesPlayed;
    private int matchesWon;
    private int matchesLost;
    private int matchesDrawn;
    private Date matchDate;//date of playing a match

       //constructor for sports club
    public SportsClub(String clubName, String country, String location, int noOfMatchesPlayed,
                           int matchesWon, int matchesLost, int matchesDrawn, Date matchDate) {
        this.clubName = clubName;
        this.country = country;
        this.location = location;
        this.noOfMatchesPlayed = noOfMatchesPlayed;
        this.matchesWon = matchesWon;
        this.matchesLost = matchesLost;
        this.matchesDrawn = matchesDrawn;
         this.matchDate = matchDate;
     }

      //getter method to get and display the name of the club
    public String getClubName() {
          return clubName;
    }

      //setter method to set the name of the club entered by the user
    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    //getter method to get and display the country of the club situated
    public String getCountry() {
       return country;
    }

    //setter method to set the country of the club entered by the user
    public void setCountry(String country) {
       this.country = country;
    }

     //getter method to get and display the location(city) of the club situated
    public String getLocation() {
        return location;
    }

     //setter method to set the country of the location(city) entered by the user
    public void setLocation(String location) {
         this.location = location;
      }

     //getter method to get and displaying the number of matches played
    public int getNoOfMatchesPlayed() {
         return noOfMatchesPlayed;
    }

     //setter method to set the number of matches played
    public void setNoOfMatchesPlayed(int noOfMatchesPlayed) {
       this.noOfMatchesPlayed = noOfMatchesPlayed;
    }

     //getter method to get and display the number of matches won
    public int getMatchesWon() {
        return matchesWon;
   }

    //setter method to set the number of matches won
    public void setMatchesWon(int matchesWon) {
        this.matchesWon = matchesWon;
     }

    //getter method to get and display the number of matches lost
    public int getMatchesLost() {
         return matchesLost;
    }

    //setter method to set the number of matches lost
    public void setMatchesLost(int matchesLost) {
       this.matchesLost = matchesLost;
     }

    //getter method to get and display the number of matches drawn
    public int getMatchesDrawn() {
         return matchesDrawn;
    }

    //setter method to set the number of matches drawn
    public void setMatchesDrawn(int matchesDrawn) {
         this.matchesDrawn = matchesDrawn;
      }

    //getter method to get and display the date of the match played
    public Date getMatchDate() {
       return matchDate;
     }

    //setter method to set the date of the match played
    public void setMatchDate(Date matchDate) {
        this.matchDate = matchDate;
     }

}
