package com.example.myapplication.Classes;

public class TimeTableData {
    String Year, Branch, Section, Date, Day, Time, SubjectName, TeacherName;

    public TimeTableData(String year, String branch, String section, String day, String time, String subjectName, String teacherName) {
        Year = year;
        Branch = branch;
        Section = section;
        Day = day;
        Time = time;
        SubjectName = subjectName;
        TeacherName = teacherName;
    }

    public String getYear() {
        return Year;
    }

    public void setYear(String year) {
        Year = year;
    }

    public String getBranch() {
        return Branch;
    }

    public void setBranch(String branch) {
        Branch = branch;
    }

    public String getSection() {
        return Section;
    }

    public void setSection(String section) {
        Section = section;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getDay() {
        return Day;
    }

    public void setDay(String day) {
        Day = day;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public String getSubjectName() {
        return SubjectName;
    }

    public void setSubjectName(String subjectName) {
        SubjectName = subjectName;
    }

    public String getTeacherName() {
        return TeacherName;
    }

    public void setTeacherName(String teacherName) {
        TeacherName = teacherName;
    }
}
