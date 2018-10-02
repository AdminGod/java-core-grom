package lessons.lesson21;

public class Company {
    private int numberOfEmployees;
    private String name;

    private static String licence;

    private static int maxNumberOfEmployees;

    static {
        System.out.println("Code block is called");
        init();
    }

    public static void validate() throws Exception {
        if(!licence.equals("TTT111")){
            throw new Exception("wrong licence " + licence);
        }
    }

    private static void init(){
        maxNumberOfEmployees = 100;
    }

    public Company(int numberOfEmployees, String name) throws Exception {
        if(numberOfEmployees > numberOfEmployees){
            throw new Exception("Company can have max " + maxNumberOfEmployees + " employees");
        }
        this.numberOfEmployees = numberOfEmployees;
        this.name = name;
    }

    public int getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public String getName() {
        return name;
    }

    public String getLicence() {
        return licence;
    }

    public static void setLicence(String licence) {
        Company.licence = licence;
    }
}
