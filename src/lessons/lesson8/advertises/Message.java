package lessons.lesson8.advertises;

import java.util.Date;

public class Message extends BaseEntity {


    User userFrom;
    User userTo;
    String msg;
    Date dateSent;
    Date dateRead;

    public Message(long id, User userFrom, User userTo, String msg) {
        super(id);
        this.userFrom = userFrom;
        this.userTo = userTo;
        this.msg = msg;
        this.dateSent = new Date();
    }

    void setDateRead() {
        dateRead = new Date();
    }

    boolean isRead() {
        return dateRead == null;
    }
}
