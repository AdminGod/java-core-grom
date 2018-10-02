package lessons.lesson19.hw;

import java.util.Objects;

public class File {
    private long id;
    private String name;
    private String format;
    private long size;

    /**Constructor**/
    public File(long id, String name, String format, long size) throws Exception{
        this.id = id;
        //check name length
        validate(name);
        this.name = name;
        this.format = format;
        this.size = size;
    }

    /**Getters and Setters**/
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        File file = (File) o;
        return id == file.id &&
                Objects.equals(name, file.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name);
    }

    private void validate (String name) throws Exception{
        if(name == null || name.isEmpty() ||  name.length() > 10){
            throw new Exception("Wrong file name length. The length of file");
        }
    }
}
