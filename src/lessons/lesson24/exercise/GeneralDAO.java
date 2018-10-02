package lessons.lesson24.exercise;

public class GeneralDAO<T> {

    @SuppressWarnings("unchecked")
    private T[] arrays = (T[]) new Object[5];

    public T save (T t){
        int index = 0;
        for(T el : arrays){
            if(el == null){
                arrays[index] = t;
                return arrays[index];
            }
            index++;
        }
        return null;
    }

    public T[] getAll (){
        return arrays;
    }
}
