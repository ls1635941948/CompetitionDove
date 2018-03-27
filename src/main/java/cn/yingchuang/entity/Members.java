package cn.yingchuang.entity;

/**
 * Created by Administrator on 2018/3/18.
 */
public class Members {
    private int id;
    private String userName;
    private String password;
    private String nickName;
    private Information information;
    private String memberCode;

    public Members() {
    }

    public Members(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }



    public Members(int id, String userName, String password, String nickName, Information information, String memberCode) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.nickName = nickName;
        this.information = information;
        this.memberCode = memberCode;
    }



    @Override
    public String toString() {
        return "Members{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", nickName='" + nickName + '\'' +
                ", information=" + information +
                ", memberCode='" + memberCode + '\'' +
                '}';
    }

    public String getMemberCode() {
        return memberCode;
    }

    public void setMemberCode(String memberCode) {
        this.memberCode = memberCode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Information getInformation() {
        return information;
    }

    public void setInformation(Information information) {
        this.information = information;
    }


}
