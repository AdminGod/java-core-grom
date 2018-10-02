package lessons.lesson24.exercise;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
        GeneralDAO<Sys> systemDAO = new GeneralDAO<>();

        Sys s1 = new Sys(111, "/C:");

        systemDAO.save(s1);
        System.out.println(Arrays.deepToString(systemDAO.getAll()));

        systemDAO.save(s1);
        System.out.println(Arrays.deepToString(systemDAO.getAll()));

        GeneralDAO<Tool> toolDAO = new GeneralDAO<>();

        Tool tool = new Tool("testName", "some description");

        toolDAO.save(tool);
        System.out.println(Arrays.deepToString(toolDAO.getAll()));

        GeneralDAO<Order> orderDAO = new GeneralDAO<>();


    }
}
