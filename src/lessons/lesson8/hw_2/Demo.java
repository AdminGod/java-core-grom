package lessons.lesson8.hw_2;

public class Demo {
    public static void main(String[] args) {
        Student s1 = createHighestParent();
        SpecialStudent s2 = createLowestChild();
    }

    static Student createHighestParent() {

        Course[] cources = new Course[5];

        return new Student("Ivan", "Boyan", 25, cources);
    }

    static SpecialStudent createLowestChild() {
        Course[] cources = new Course[5];

        return new SpecialStudent("Ivan", "Boyan", 25, cources, 32165, "email");
    }
}
