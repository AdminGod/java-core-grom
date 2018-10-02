package lessons.lesson15.equals;

import java.util.Objects;

public class File {
    private int size;
    private String path;
    private String extension;

    public File(int size, String path, String extension) {
        this.size = size;
        this.path = path;
        this.extension = extension;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        File file = (File) o;
        return Objects.equals(path, file.path);
    }

    @Override
    public int hashCode() {
        return path.hashCode();
    }

    /*@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        File file = (File) o;
        return size == file.size && (path.equals(file.path)) && extension.equals(file.extension);
    }

    @Override
    public int hashCode() {
        int result  = size;
        result = 31*result + path.hashCode();
        result = 31*result + extension.hashCode();
        return result;
    }*/

}
