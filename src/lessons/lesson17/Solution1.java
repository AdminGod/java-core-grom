package lessons.lesson17;

public class Solution1 {
    public static void main(String[] args) {
        String s1 = "https://google.com";
        String s2 = "http://google.com";
        String s3 = "h3ttps://google.com";
        String s4 = "https://goo-gle.com";
        String s5 = "https://google.coo";
        String s6 = "";
        //String s7 = null;
        String s8 = "https://www.google.com";
        String s9 = "https://ww.google.com";
        String s10 = " https://www.google.com";
        String s11 = "https://www.com";

        System.out.println(validate(s1));
        System.out.println(validate(s2));
        System.out.println(validate(s3));
        System.out.println(validate(s4));
        System.out.println(validate(s5));
        System.out.println(validate(s6));
        //Sys.out.println(validate(s7));
        System.out.println(validate(s8));
        System.out.println(validate(s9));
        System.out.println(validate(s10));
        System.out.println(validate(s11));
    }
    public static boolean validate(String adress){
        if(!adress.startsWith("http://") && !adress.startsWith("https://")){
            return false;
        }
        if(!adress.endsWith(".net") && !adress.endsWith(".com") && adress.endsWith(".org")){
            return false;
        }
        adress = adress.replace("www.", "");
        adress = isValid(adress, new String[] {"https://", "http://"});
        adress = isValid(adress, new String[] {".org", ".com", ".net"});

        return adress != null && checkLetterOrNumber(adress);
    }

    private static String isValid (String adress, String[] parts){

        for(String part : parts){
            if(adress.contains(part)){
                return adress.replace(part, "");
            }
        }
        return null;
    }

    private static  boolean checkLetterOrNumber (String name){
        char [] chars = name.toCharArray();

        for(char c : chars){
            if (!Character.isLetterOrDigit(c)){
                return false;
            }
        }
        return true;
    }
}
