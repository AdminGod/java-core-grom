package lessons.lesson10.abstractExample;

public class MySQLProvider extends DbProvider{

    @Override
    void connectToDb(){
        //some logic for MySQL
    }

    @Override
    void diconnectFromDb() {

    }
}
