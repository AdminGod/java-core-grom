package lessons.lesson19.hw;

public class Storage {
    private long id;
    private File[] files;
    private String [] formatSuported;
    private String storageCountry;
    private long storageSize;

    /**Constructor**/
    public Storage(long id, File[] files, String[] formatSuported, String storageCountry, long storageSize) {
        this.id = id;
        this.files = files;
        this.formatSuported = formatSuported;
        this.storageCountry = storageCountry;
        this.storageSize = storageSize;
    }

    /**Getters and Setters**/
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public File[] getFiles() {
        return files;
    }

    public void setFiles(File[] files) {
        this.files = files;
    }

    public String[] getFormatSuported() {
        return formatSuported;
    }

    public void setFormatSuported(String[] formatSuported) {
        this.formatSuported = formatSuported;
    }

    public String getStorageCountry() {
        return storageCountry;
    }

    public void setStorageCountry(String storageCountry) {
        this.storageCountry = storageCountry;
    }

    public long getStorageSize() {
        return storageSize;
    }

    public void setStorageSize(long storageSize) {
        this.storageSize = storageSize;
    }
}
