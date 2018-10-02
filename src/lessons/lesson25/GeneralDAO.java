package lessons.lesson25;

public class GeneralDAO <T> {

    private T[] DB = (T[])new Object[10];

    public T save(T t)throws Exception{
        if(find(t) != null) {
            throw new Exception("can't save an object. object already exist");
        }
        for(int i = 0; i < DB.length; i++){
            if(DB[i] == null){
                DB[i] = t;
                return (T) DB[i];
            }
        }
        throw new Exception("can't save an object. Not enough space");
    }

    public T[] getAll(){

        int amount = 0;
        for(int i = 0; i < DB.length; i++){
            if(DB[i] != null){
                amount++;
            }
        }

        T[] result = (T[])new Object[amount];
        int index = 0;

        for(int i = 0; i < DB.length; i++){
            if(DB[i] != null){
                result[index] = DB[i];
                index++;
            }
        }
        return result;
    }

    private T find (T t){
        for(int i = 0; i < DB.length; i++){
            if(DB[i] != null && (DB[i]).equals(t)){
                return DB[i];
            }
        }
        return null;
    }
}
