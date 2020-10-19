package vn.codegym.chuong.model.student_model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Division {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long divisionId;
    private String divisionName;

    @OneToMany(mappedBy = "division", cascade = CascadeType.ALL)
    private List<Student> studentList;

    public Division() {
    }

    public Division(String divisionName) {
        this.divisionName = divisionName;
    }

    public Division(String divisionName, List<Student> studentList) {
        this.divisionName = divisionName;
        this.studentList = studentList;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public Long getDivisionId() {
        return divisionId;
    }

    public void setDivisionId(Long divisionId) {
        this.divisionId = divisionId;
    }

    public String getDivisionName() {
        return divisionName;
    }

    public void setDivisionName(String divisionName) {
        this.divisionName = divisionName;
    }
}
