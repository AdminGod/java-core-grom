package lessons.lesson17.hw4;

public class Solution {
    public static void main(String[] args) {
        String s1 = "https://google.com";
        String s2 = "http://google.com";
        String s3 = "h3ttp://google.com";
        String s4 = "h3ttp://goo-gle.com";
        String s5 = "h3ttp://goo-gle.coo";
        String s6 = null;
        String s7 = "";

        //System.out.println(Character.isLetter('#'));
        System.out.println(validate(s1));
        System.out.println(validate(s2));
        System.out.println(validate(s3));
        System.out.println(validate(s4));
        System.out.println(validate(s5));
        System.out.println(validate(s6));
        System.out.println(validate(s7));

    }

    public static boolean validate(String adress){
        if (adress != null && getProtocol(adress)!= null && checkAdressName(adress) &&  checkDomainZone(adress)){
            return true;
        }
        return false;
    }

    private static String getProtocol(String adress){
        String protocol_1 = "http://";
        String protocol_2 = "https://";

        if(adress.startsWith(protocol_1)) {
            return protocol_1;
        }else if(adress.startsWith(protocol_2)) {
            return protocol_2;
        }
        return null;
    }

    private static boolean checkDomainZone(String adress){
        String zone1 = ".org";
        String zone2 = ".com";
        String zone3 = ".net";
        String domainZone = adress.substring(adress.length()-4, adress.length());
        if(domainZone.endsWith(zone1) || domainZone.endsWith(zone2) || domainZone.endsWith(zone3)){
            return true;
        }
        return false;
    }

    private static boolean checkAdressName(String adress){
        String protocole = getProtocol(adress);
        if(protocole != null && checkDomainZone(adress)) {
            adress = adress.replace(protocole, "");
            if(adress.startsWith("www.")) {
                adress = adress.replace("www.", "");
            }
            //String domainZone = adress.substring(adress.length()-4, adress.length());
            //adress = adress.replace(domainZone, "");
            adress = adress.substring(0, adress.length()-4);

            return checkWord(adress);
        }
        return false;
    }

    private static boolean checkWord(String word){
        if (word != null && word.length() > 0) {
            char[] symbols = word.toLowerCase().toCharArray();
            for (char c : symbols) {
                if (!Character.isLetterOrDigit(c)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
