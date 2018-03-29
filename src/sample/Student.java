package sample;

import javafx.collections.ObservableList;

public class Student {
    private String fullName;
    private String groupNum;
    private ObservableList<sample.Exam> examList;

    Student(String fullname, String groupNum, ObservableList<Exam> examList){
        this.fullName = fullname;
        this.examList = examList;
        this.groupNum = groupNum;
    }

    public String getFullName() {
        return fullName;
    }

    public String getGroupNum() {
        return groupNum;
    }

    public ObservableList<Exam> getExamList() {
        return examList;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setGroupNum(String groupNum) {
        this.groupNum = groupNum;
    }

    public void setExamList(ObservableList<Exam> examList) {
        this.examList.addAll(examList);
    }
}
