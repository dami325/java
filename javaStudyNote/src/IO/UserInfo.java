package IO;

import java.io.Serializable;

public class UserInfo implements Serializable {
    String name;
    String passwd;
    int age;

    public UserInfo(){
        this("Unknown", "1111", 0);
    }

    public UserInfo(String name, String passwd, int age) {
        this.name = name;
        this.passwd = passwd;
        this.age = age;
    }

    public String toString() {
        return "(" + name + "," + passwd + "," + age + ")";
    }
}
