package lessons.lesson15.cast;

public class Demo {

    public static void main(String[] args) {
        InternetProvider provider = (InternetProvider) test();
        FoodProvider foodProvider = (FoodProvider) test();//Exception java.lang.ClassCastException

        System.out.println(provider);
    }

    private static Provider test(){
        //some logic
        return new InternetProvider();
    }

    private static Provider testFood(){
        //some logic
        return new InternetProvider();
    }
}
