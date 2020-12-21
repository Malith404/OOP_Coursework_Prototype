public class exception_handling {
    public static void main(String[] args) {
        try{
            int myArray[]=new int[5];
            System.out.println(myArray[5]);

        }catch(ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException){
            System.out.println("The element "+arrayIndexOutOfBoundsException.getMessage()+" does not exist !");
        }
    }
}
