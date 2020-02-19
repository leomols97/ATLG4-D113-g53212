package esi.atl.msg;

import java.io.Serializable;

public class Message
        implements Serializable {

    private final Type type;
    private final String txt;

    public Message(Type type, String txt) {
        this.type = type;
        this.txt = txt;
    }

    public Type getType() {
        return type;
    }

    public String getTxt() {
        return txt;
    }

}
