package winasia.eventbus.objectmessage;

/**
 * Created by WinAsia on 2017/3/29.
 */
public class MessageEntity {
    private String name;
    private String pwd;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "\n*****/////******  \nname: " + getName() + "  \npwd: " + getPwd() + "  \n*****/////******\n";
    }
}
