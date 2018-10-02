package lessons.lesson17;

public class Solution {
    public static void main(String[] args) {
        String s1 = "https://google.com";
        String s2 = "http://google.com";
        String s3 = "h3ttps://google.com";
        String s4 = "https://goo-gle.com";
        String s5 = "https://google.coo";
        String s6 = "";
        String s7 = null;
        String s8 = "https://www.google.com";
        String s9 = "https://ww.google.com";
        String s10 = " https://www.google.com";

        System.out.println(validate(s1));
        System.out.println(validate(s2));
        System.out.println(validate(s3));
        System.out.println(validate(s4));
        System.out.println(validate(s5));
        System.out.println(validate(s6));
        System.out.println(validate(s7));
        System.out.println(validate(s8));
        System.out.println(validate(s9));
        System.out.println(validate(s10));
    }

    public static boolean validate(String adress){
        if(adress != null && getProtocol(adress) != null && checkAdressName(adress) && checkDomainZone(adress)){
            return true;
        }
        return false;
    }

    private static String getProtocol(String adress){
        String protocol1 = "http://";
        String protocol2 = "https://";

        if(adress.startsWith(protocol1)){
            return protocol1;
        }
        if(adress.startsWith(protocol2)){
            return protocol2;
        }
        return null;
    }

    private static boolean checkDomainZone(String adress){
        String zone1 = ".org";
        String zone2 = ".com";
        String zone3 = ".net";

        String domainZone = adress.substring(adress.length()-4, adress.length());

        if(domainZone.equals(zone1) || domainZone.equals(zone2) || domainZone.equals(zone3)){
            return true;
        }
        return false;
    }

    private static boolean checkAdressName(String adress){
        String protiocole = getProtocol(adress);
        if(protiocole != null){
            adress = adress.replace(protiocole, "");
            if(adress.startsWith("www.")){
                adress = adress.replace("www.", "");
            }
            adress = adress.substring(0, adress.length()-4);

            return checkWord(adress);
        }
        return false;
    }

    private static boolean checkWord(String word){
        if(word != null && word.length() > 0){
            char[] symbols = word.toLowerCase().toCharArray();
            for(char c : symbols){
                if(!Character.isLetterOrDigit(c)){
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
