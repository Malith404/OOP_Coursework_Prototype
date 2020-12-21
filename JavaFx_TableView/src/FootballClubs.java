public class FootballClubs implements Comparable<FootballClubs>{
    private String clubName;
    private String country;
    private String city;
    private int noOfMatchesPlayed;
    private int matchesWon;
    private int matchesLost;
    private int matchesDrawn;
    private int goalsScored;
    private int goalsReceived;
    private int pointsScored;

    public FootballClubs(String clubName, String country, String city, int noOfMatchesPlayed,
                         int matchesWon, int matchesLost, int matchesDrawn, int goalsScored, int goalsReceived,
                         int pointsScored) {
        this.clubName = clubName;
        this.country = country;
        this.city = city;
        this.noOfMatchesPlayed = noOfMatchesPlayed;
        this.matchesWon = matchesWon;
        this.matchesLost = matchesLost;
        this.matchesDrawn = matchesDrawn;
        this.goalsScored = goalsScored;
        this.goalsReceived = goalsReceived;
        this.pointsScored = pointsScored;
    }

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getNoOfMatchesPlayed() {
        return noOfMatchesPlayed;
    }

    public void setNoOfMatchesPlayed(int noOfMatchesPlayed) {
        this.noOfMatchesPlayed = noOfMatchesPlayed;
    }

    public static int getMatchesWon() {
        return matchesWon;
    }

    public void setMatchesWon(int matchesWon) {
        this.matchesWon = matchesWon;
    }

    public int getMatchesLost() {
        return matchesLost;
    }

    public void setMatchesLost(int matchesLost) {
        this.matchesLost = matchesLost;
    }

    public int getMatchesDrawn() {
        return matchesDrawn;
    }

    public void setMatchesDrawn(int matchesDrawn) {
        this.matchesDrawn = matchesDrawn;
    }

    public int getGoalsScored() {
        return goalsScored;
    }

    public void setGoalsScored(int goalsScored) {
        this.goalsScored = goalsScored;
    }

    public int getGoalsReceived() {
        return goalsReceived;
    }

    public void setGoalsReceived(int goalsReceived) {
        this.goalsReceived = goalsReceived;
    }

    public int getPointsScored() {
        return pointsScored;
    }

    public void setPointsScored(int pointsScored) {
        this.pointsScored = pointsScored;
    }

    @Override
    public int compareTo(FootballClubs o) {
        return this.pointsScored-o.getPointsScored();
    }

}
