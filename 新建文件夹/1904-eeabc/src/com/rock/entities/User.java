package com.rock.entities;

public class User {

    String userid;
    String password;
    String sex;
    public User(){

    }
    public User(String userid, String password,  String mail,String sex, String hobby, String degree, String question, String answer) {
        this.userid = userid;
        this.password = password;
        this.sex = sex;
        this.mail = mail;
        this.hobby = hobby;
        this.degree = degree;
        this.question = question;
        this.answer = answer;
    }

    String mail;
    String hobby;
    String degree;
    String question;
    String answer;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "User{" +
                "userid='" + userid + '\'' +
                ", password='" + password + '\'' +
                ", sex='" + sex + '\'' +
                ", mail='" + mail + '\'' +
                ", hobby='" + hobby + '\'' +
                ", degree='" + degree + '\'' +
                ", question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }
}
