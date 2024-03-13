package com.example.ebookapp;

public class SubjectModel {
    private String subjectName;
    private int imageResource;

    public SubjectModel(String subjectName) {
        this.subjectName = subjectName;
    }

    public SubjectModel(String subjectName, int imageResource) {
        this.subjectName = subjectName;
        this.imageResource = imageResource;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }
}
