public class Date {

     //attributes that should contain in a Date class
    private int day;
    private int month;
    private int year;

    //constructor for Date Class
    public Date(int day, int month, int year) {
         this.day = day;
        this.month = month;
        this.year = year;
    }

      //getter method to get and display the day of match playing
    public int getDay() {
         return day;
     }

    //setter method to set the day of match playing
    public void setDay(int day) {
       this.day = day;
     }

     //getter method to get and display the month of match playing
    public int getMonth() {
      return month;
    }

    //setter method to set the month of match playing
    public void setMonth(int month) {
         this.month = month;
      }

     //getter method to get and display the year of match playing
    public int getYear() {
         return year;
    }

    //setter method to set the year of match playing
    public void setYear(int year) {
        this.year = year;
    }

}