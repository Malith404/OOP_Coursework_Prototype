import java.util.Scanner;
import java.io.Serializable;


public class DateMatchesPlayed implements Serializable {
    private int day;
    private int month;
    private int year;

    private static Scanner dateValidation = new Scanner(System.in);
    public DateMatchesPlayed(int day, int month, int year) {

        try{
            if(day>0 && day<=31){
                this.day = day;
            }else{
                System.out.print("Please Enter valid date which played the match: ");
                setDay(dateValidation.nextInt());
            }
        }catch (Exception e){
            System.out.print("Please enter valid Date of the match played: ");
            setDay(dateValidation.nextInt());
        }

        try{
            if(month>0 &&month<=12){
                this.month = month;
            }else{
                System.out.print("Please Enter valid month which played the match: ");
                setMonth(dateValidation.nextInt());
            }
        }catch (Exception e){
            System.out.print("Please enter valid Month of the match played:");
            setMonth(dateValidation.nextInt());
        }


        try{
            if(year==2020){
                this.year = year;
            }else{
                System.out.print("Please Enter valid year which played the match: ");
                setYear(dateValidation.nextInt());
            }
        }catch (Exception e){
            System.out.print("Please enter Year of the match played :");
            setYear(dateValidation.nextInt());
        }
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day=day;
        /*try{
            if(day>0 && day<=31){
                this.day = day;
            }else{
                System.out.print("Please Enter valid date which played the match: ");
                setDay(scan.nextInt());
                System.out.println("\n");
            }
        }catch (Exception e){
            System.out.print("Please enter valid date which played the match: ");
            setDay(scan.nextInt());
            System.out.println("\n");
        }*/
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month=month;
        /*try{
            if(month>0 &&month<=12){
                this.month = month;
            }else{
                System.out.print("Please Enter valid month which played the match:  ");
                setMonth(scan.nextInt());
                System.out.println("\n");

            }
        }catch (Exception e){
            System.out.print("Please enter valid month which played the match: ");
            setMonth(scan.nextInt());
            System.out.println("\n");

        }*/
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year=year;
        /*try{
            if(year==2020){
                this.year = year;
            }else{
                System.out.print("Please Enter valid year which played the match: ");
                setYear(scan.nextInt());
                System.out.println("\n");

            }
        }catch (Exception e){
            System.out.print("Please enter valid year which played the match: ");
            setYear(scan.nextInt());
            System.out.println("\n");

        }*/
    }

    @Override
    public String toString() {
        return "Date{" +"day=" + this.day +", month=" + this.month +", year=" + this.year +'}';
    }
}