package lessons.lesson30.task2;

import java.util.ArrayList;

public class ProjectDAO {
    ArrayList<Project> projects = new ArrayList<>();

    public ProjectDAO() {
    }

    public Project add (Project project){
        projects.add(project);
        return project;
    }

    public void remove(Project project){
        projects.remove(project);
    }

    public ArrayList<Project> getAll (){
        return projects;
    }

    public ArrayList<Project> projectsByEmployee(Employee employee){
        return employee.getProjects();
    }

    public ArrayList<Project> projectsByCustomer(Customer customer){
        ArrayList<Project> result = new ArrayList<>();
        for (Project project : projects){
            if(project != null && project.getCustomer().equals(customer)){
                result.add(project);
            }
        }
        return result;
    }
}
