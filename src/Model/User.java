package Model;

import java.util.Arrays;
import java.util.List;

public class User {

    private String userName;
    private String password;
    private String email;
    private String status;
    private String rank;
    private String org_name;



    // relevant for debug
    public User(){
        userName= "";
        password ="";
        email="";
        status="";
        rank="";
        org_name="";
    }

    public User( List<String> searchResult)
    {
    userName= searchResult.get(0);
    password = searchResult.get(1);
    email=searchResult.get(2);
    status=searchResult.get(3);
    rank=searchResult.get(4);
    org_name=searchResult.get(5);
    }




    public User(String userName, String password, String email, String status, String rank, String org_name) {
        userName = userName;
        password = password;
        email = email;
        status = status;
        rank = rank;
        org_name = org_name;

    }

    public String getuserName() {
        return userName;
    }

    public void setuserName(String userName) {
        userName = userName;
    }

    public String getpassword() {
        return password;
    }

    public void setpassword(String password) {
        password = password;
    }

    public String getemail() {
        return email;
    }

    public void setemail(String email) {
        email = email;
    }

    public String getstatus() {
        return status;
    }

    public void setstatus(String status) {
        status = status;
    }

    public String getrank() {
        return rank;
    }

    public void setrank(String rank) {
        rank = rank;
    }

    public String getorg_name() {
        return org_name;
    }

    public void setorg_name(String org_name) {
        org_name = org_name;
    }


    public List<String> listOfUserDetails() {
        List <String> list = Arrays.asList(userName,password,email,status,rank,org_name);
        return list;
    }
}
