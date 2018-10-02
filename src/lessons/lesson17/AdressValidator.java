package lessons.lesson17;

public class AdressValidator {
    public static void main(String[] args) {
        String s = "https://google.com";
        System.out.println(Character.isLetter('#'));
        System.out.println(validate(s));

    }

    public static boolean validate(String adress){
        if (adress == null){
            return false;
        }
        if(getProtocol(adress).length() > 0 && checkDomainZone(adress) && checkAdressName(adress)){
           return true;
        }
        return false;
    }

    private static String getProtocol(String adress){
        String protocol_1 = "http://";
        String protocol_2 = "https://";
        if(adress.indexOf(protocol_1) == 0) {
            return protocol_1;
        }else if(adress.indexOf(protocol_2) == 0) {
            return protocol_2;
        }
        return "";
    }

    private static boolean checkDomainZone(String adress){
        String zone_1 = ".org";
        String zone_2 = ".com";
        String zone_3 = ".net";
        String domainZone = adress.substring(adress.length()-4, adress.length());
        if(domainZone.equals(zone_1) || domainZone.equals(zone_2) || domainZone.equals(zone_3)){
            return true;
        }
        return false;
    }

    private static boolean checkAdressName(String adress){
        String protocole = getProtocol(adress);
        if(protocole.length() > 0 && checkDomainZone(adress)) {
            adress = adress.replace(protocole, "");
            if(adress.indexOf("www.") == 0) {
                adress = adress.replace("www.", "");
            }
            String domainZone = adress.substring(adress.length()-4, adress.length());
            adress = adress.replace(domainZone, "");

            return checkWord(adress);
        }
        return false;
    }

    private static boolean checkWord(String name){
        char[] symbols = name.toLowerCase().toCharArray();
        String regEx = "abcdefghijklmnopqrstuvwxyz";
        for(char c : symbols){
            if(Character.isLetter(c)){
                return false;
            }
        }
        return true;
    }
}
