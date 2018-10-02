package lessons.lesson21;

public class Demo {

    {
        //some logic;
    }

    public static void main(String[] args) throws Exception{
        Company company = new Company(100, "Nokia");
        //call method by class;
        Company.setLicence("TTT111");

        System.out.println(company.getLicence());

        Company company1 = new Company(9, "Test");

        System.out.println(company1.getLicence());

        //call method by object;
        company.setLicence("G111222");

        System.out.println(company.getLicence());
        System.out.println(company1.getLicence());

        //Company.validate();

        int min = ArrayUtils.minElement(new int[]{1, 10, 40});

    }
}
