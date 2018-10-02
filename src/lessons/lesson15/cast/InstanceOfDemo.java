package lessons.lesson15.cast;

public class InstanceOfDemo {
    public static void main(String[] args) {
        Provider provider = new Provider();
        FoodProvider foodProvider = new FoodProvider();
        InternetProvider internetProvider  = new InternetProvider();

        System.out.println(provider instanceof Provider);
        System.out.println(provider instanceof InternetProvider);
        System.out.println(provider instanceof FoodProvider);
        System.out.println(internetProvider instanceof Provider);

        if(test() instanceof InternetProvider){
            //some logic
        }else if(test() instanceof FoodProvider){
            //some logic
        }
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
