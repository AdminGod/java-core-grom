package lessons.lesson9.utils;

public class Checker {
    /**
     public - is showing everywhere;
     protected - is showing inside of one package and in the classes heirs (наследники);
     "default" - is showing inside of one package (not writing);
     private - is showing only inside of a class;
    */
    private int companyNamesValidatedCount = 0;

    public boolean checkCompanyName(String companyName) {
        if(companyNamesValidatedCount >10){
            return false;
        }
        companyNamesValidatedCount++;
        return companyName != "Google" && companyName != "Amazon";
    }
}
