package lessons.lesson25;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) throws Exception{
        GeneralDAO generalDAO = new GeneralDAO();

        Order o1 = new Order(1);

        TestClass<String, Order, Long> testClass = new TestClass<>();

        System.out.println(testClass.doSomething1("rrr"));


        int test = 100;
        long var  = 111;
        Long var2 = 222L;
        Long var3 = new Long(111);

        //generalDAO.validate(test);

        GeneralDAO<Order> orderGeneralDAO = new GeneralDAO<>();
        orderGeneralDAO.save(o1);
        //orderGeneralDAO.save(o1); // throws Exception can't save an object
        System.out.println(Arrays.deepToString(orderGeneralDAO.getAll()));

        GeneralDAO<Tool1> tool1GeneralDAO = new GeneralDAO<>();

        tool1GeneralDAO.save(new Tool1());
        System.out.println(Arrays.deepToString(tool1GeneralDAO.getAll()));

        GeneralDAO<Tool2> tool2GeneralDAO = new GeneralDAO<>();

        tool2GeneralDAO.save(new Tool2(12));
        System.out.println(Arrays.deepToString(tool2GeneralDAO.getAll()));
    }
}
