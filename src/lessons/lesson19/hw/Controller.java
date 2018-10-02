package lessons.lesson19.hw;

public class Controller {

    public File put(Storage storage, File file) throws Exception{
        if(file != null) {

            validateFile(storage, file);
            insertFile(storage.getFiles(), file);

            return file;
        }
        return null;
    }

    public void delete(Storage storage, File file) throws Exception {
        if (storage.getFiles() != null && file != null) {

            if(getFile(storage, file.getId()) == null){
                throw new Exception("File " + file.getId() + " not found in storage " + storage.getId());
            }

            for (int i = 0; i < storage.getFiles().length; i++){
                if(storage.getFiles()[i] != null && storage.getFiles()[i].equals(file)){
                    storage.getFiles()[i] = null;
                    return;
                }
            }
        }
    }

    public void transferAll(Storage storageFrom, Storage storageTo)throws Exception{
        //if (storageFrom.getFiles() != null && storageTo.getFiles() != null){

            validateTranferFiles(storageFrom, storageTo);

            for (File f : storageFrom.getFiles()){
                transferFile(storageFrom,storageTo, f.getId());
            }
        //}
    }

    public void transferFile(Storage storageFrom, Storage storageTo, long id) throws Exception{
        if (storageFrom.getFiles() != null && storageTo.getFiles() != null) {

            File file = getFile(storageFrom, id);
            if(file != null) {

                validateFile(storageTo, file);

                //insert
                insertFile(storageTo.getFiles(), file);
                //remove
                delete(storageFrom, file);

                return;
            }
            throw new Exception("File " + id + " not found in storage " + storageFrom.getId());
        }
    }

    /**
     * additional methods
    */

    private void validateFile(Storage storage, File file) throws Exception{
        if(storage == null || file == null || storage.getFiles() == null || storage.getFormatSuported() == null) {
            throw new NullPointerException("can't make validation.Null pointer Exception");
        }
        //check accepted or not a file format in storage
        checkFormat(storage, file);

        //check file if it exist
        checkFileInStorage(storage, file.getId());

        //check free space in the storage
        checkFreeSpace(storage, file);

        //check free place in storage
        countFreePlaceInStorage(storage);

    }

    private void checkFormat (Storage storage, File file) throws Exception{
        String [] formats = storage.getFormatSuported();
        if(formats.length > 0) {
            for (String format : formats) {
                if(format.equals(file.getFormat())){
                    return;
                }
            }
        }
        throw new Exception("Format for file " + file.getId() + " is not supported in storage " + storage.getId());
    }

    private void checkFileInStorage(Storage storage, long id) throws Exception{
        if(getFile(storage, id) != null){
            throw new Exception("File " + id + " already exist in a storage " + storage.getId());
        }
    }

    //return null of file not found
    private File getFile (Storage storage, long id){
        if(storage.getFiles() != null && storage.getFiles().length>0) {
            for (File file : storage.getFiles()) {
                if (file != null && file.getId() == id) {
                    return file;
                }
            }
        }
        return null;
    }

    private void checkFreeSpace(Storage storageTo, File file) throws Exception{
        if (storageTo.getFiles() == null || getFreeSpace(storageTo) <= file.getSize()) {
            throw new Exception("There is not enough free space in storage " + storageTo.getId());
        }
    }

    //check free space in storage....space in mb for example
    private long getFreeSpace (Storage storage){
        long filesSize = 0;
            for (File f : storage.getFiles()) {
                if(f != null) {
                    filesSize += f.getSize();
                }
            }
        return storage.getStorageSize() - filesSize;
    }

    //check null positions in array
    private int countFreePlaceInStorage(Storage storage)throws Exception{
        int freePlaces = 0;
        for (File f : storage.getFiles()){
            if (f == null){
                freePlaces++;
            }
        }
        if(freePlaces == 0) {
            throw new Exception("There is not a free place in storage " + storage.getId());
        }
        return freePlaces;
    }

    private void validateTranferFiles(Storage storageFrom, Storage storageTo) throws Exception {
        //check if enough space for files from storageFrom in storageTo
        if(getFreeSpace(storageTo) < (storageFrom.getStorageSize() - getFreeSpace(storageFrom))){
            throw new Exception("There isn't enough free space for files from storage " + storageFrom.getId() + " in storage " + storageTo.getId());
        }
        for (File f : storageFrom.getFiles()){
            if(f != null){
                //check accepted or not a file format in storage
                checkFormat(storageTo, f);
                //check file if it exist
                checkFileInStorage(storageTo, f.getId());
                //check free places in storage
                compareFreePlaces(storageFrom, storageTo);
            }
        }
    }

    private void insertFile(File[] files, File file){
        if (files != null) {
            for (int i = 0; i < files.length; i++) {
                if (files[i] == null) {
                    files[i] = file;
                    break;
                }
            }
        }
    }

    private void compareFreePlaces(Storage storageFrom, Storage storageTo) throws Exception{
        if(countFreePlaceInStorage(storageTo) < countFiles(storageFrom)){
            throw new Exception("There are not enough place for transfer files from storage: " + storageFrom.getId() + " to storage: " + storageTo.getId());
        }
    }

    private int countFiles(Storage storage){
        int filesAmount = 0;
        for(File f : storage.getFiles()){
            if (f != null){
                filesAmount++;
            }
        }
        return filesAmount;
    }
}