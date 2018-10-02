package lessons.lesson19;

public class RuntimeExceptionExample {
    public static void main(String[] args) {
        arifmeticException(2);

        try {
            arifmeticException(0);
        }catch (Exception e){
            System.out.println("Something wrong");
        }

        npe(new Object());
        npe(null);

    }

    private static void arifmeticException(int a){
        System.out.println(10/a);
    }
    private static void npe(Object object) {
        if (object != null) {
            System.out.println(object.hashCode());
        }
    }

}
