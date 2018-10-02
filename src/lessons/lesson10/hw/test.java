package lessons.lesson10.hw;

public class test {
    public static void main(String[] args) {
        String s1 = "-12";
        //Sys.out.println(new Integer("ss")+ 5);
        //Sys.out.println(Integer.parseInt("hh") + 2);
        int a = 5;
        if(true && false){
            a=10;
        }
        System.out.println(a + ">>>>>>>>>>>>>");

        String [] arr = {"5", "ksdjb", "aslkdf;", "-100", "212", "sdg", "102"};
        int [] numbers_temp= new int[arr.length];
        int counter = 0;
        for (int i = 0; i < arr.length; i++){
            try{
                numbers_temp[counter] = new Integer(arr[i]);
                counter++;
            }catch (NumberFormatException ex) {
                //some logic
            }
        }
        int []numbers = new int[counter];
        System.arraycopy(numbers_temp, 0, numbers, 0, counter);
        for (int i : numbers){
            System.out.println(i);
        }
     }
}
