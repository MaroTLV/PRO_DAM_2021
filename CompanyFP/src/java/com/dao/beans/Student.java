package com.dao.beans;

public class Student {

private int studentId;
private String name;
private String clase;
private String matricula;

public int getStudentId() {
	return studentId;
}

public String getName() {
	return name;
}

public String getClase() {
	return clase;
}

public String getMatricula() {
	return matricula;
}

public void setStudentId(int studentId) {
	this.studentId = studentId;
}

public void setName(String name) {
	this.name = name;
}

public void setClase(String clase) {
	this.clase = clase;
}

public void setMatricula(String matricula) {
	this.matricula = matricula;
}
}