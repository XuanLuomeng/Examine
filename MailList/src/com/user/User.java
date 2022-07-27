package com.user;

public class User {
    private String name;
    private String number;
    private String group;
    private String mail;
    /*
    * 设置信息
    * */
    public User(String name, String number, String mail, String group) {
        this.name = name;
        this.number = number;
        this.mail = mail;
        this.group = group;
    }
    /*
    * 获取姓名
    * */
    public String getName() {
        return name;
    }
    /*
    * 获取电话号码
    * */
    public String getNumber(){
        return number;
    }
    /*
    * 获取邮箱
    * */
    public String getMail(){
        return mail;
    }
    /*
    * 获取组名
    * */
    public String getGroup(){
        return group;
    }
    /*
    * 设置组名
    * */
    public void setGroup(String group){
        this.group = group;
    }
}
