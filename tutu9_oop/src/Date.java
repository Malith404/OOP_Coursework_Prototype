import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Date{
    private int  day;
    private int month;
    private int year;

    public Date(int day, int month,int year){
        this.day=day;
        this.month=month;
        this.year=year;

    }

    public int getDay(){
        return this.day;
    }


    public int getYear(){
        return this.year;
    }

    public void setDay(int day){
        this.day=day;
    }

    public void setMonth(int month){
        this.month=month;
    }

    public void setYear(int year){
        this.year=year;
    }


    public int getMonth(){
        return month;
    }

    public String getDate()
    {
        return String.format("%02d/%02d/%04d",this.day,this.month,this.year);
    }

    @Before
    public void setUp() {
    }
    @After
    public void tearDown() {
    }

    @Test
    public void testAddDays() {
        Date d = new Date(12, 2, 2019);
        d.addDays(4);
        assertEquals(2019, d.getYear()); // expected
        assertEquals(2, d.getMonth()); // value should
        assertEquals(16, d.getDay()); // be at LEFT
    }

    private void assertEquals(int i, int day) {
    }

    public void addDays(int days){

    }

    public String toString(){
        return "[Date, " + this.getDay() + "month"+ this.getMonth() + " year" +this.getYear()+"]";
    }


}
