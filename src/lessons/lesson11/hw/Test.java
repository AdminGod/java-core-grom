package lessons.lesson11.hw;

public class Test {
    public static void main(String[] args) {
        int [] ar1 = {1, 2, 3, 4, 5};
        int [] ar2 = {3, 7, 1, 8, 10};

        int [] uniqueTemp = new int[ar1.length + ar2.length];

        int counterNotNull = 0;

        for(int i = 0; i < ar1.length; i++){
            if(ar1[i] != 0){
                uniqueTemp[counterNotNull] = ar1[i];
                counterNotNull++;
            }
        }

        for (int i = 0; i < ar2.length; i++){
            int item = ar2[i];
            boolean found = false;
            for(int j = 0; j < uniqueTemp.length; j++){
                if(item == uniqueTemp[j]){
                    found = true;
                    break;
                }
            }
            if(!found){
                uniqueTemp[counterNotNull] = item;
                counterNotNull++;
            }
        }
        int[] uniqueInt = new int[counterNotNull];
        System.arraycopy(uniqueTemp, 0, uniqueInt, 0, counterNotNull);
        String s1 = "";

        //Room r1 = new Room(1, 250, 4,  "hotel", "city");
        //Room r2 = new Room(2, 250, 4,  "hotel", "city");
        /***
        Sys.out.println(r1.toString());
        Sys.out.println(r2.toString());
        Sys.out.println(r1.toString() == r2.toString());
        Sys.out.println(r1.toString().equals(r2.toString()));
        Sys.out.println(r1.equals(r2));
        */
    }
}
