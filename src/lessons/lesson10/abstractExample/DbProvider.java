package lessons.lesson10.abstractExample;

public abstract class DbProvider {

    private String dbHost;

    /**
    public DbProvider(String dbHost) {
        this.dbHost = dbHost;
    }
    */

    abstract void connectToDb();

    abstract void diconnectFromDb();

    void printDbHost(){
        System.out.println("DB host is " + dbHost);
    }
}
