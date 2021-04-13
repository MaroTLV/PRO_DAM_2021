package com.app.companyfp_app.retrofit;

import com.google.gson.annotations.SerializedName;

/**
 * Created by SERGIO on 03/04/2021.
 */

public class User {
    @SerializedName("studentId")
    private String studentId;
    @SerializedName("name")
    private String name;
    @SerializedName("department")
    private String department;
    @SerializedName("emailId")
    private String emailId;

    public User(String studentId, String name, String department, String emailId) {
        this.studentId = studentId;
        this.name = name;
        this.department = department;
        this.emailId = emailId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
}
