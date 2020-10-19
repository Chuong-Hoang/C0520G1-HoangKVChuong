package vn.codegym.chuong.model.student_model;

import javax.persistence.*;
import java.util.List;
@Entity
public class Hobby {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hobbyId;
    private String hobbyName;

    @OneToMany(mappedBy = "hobby", cascade = CascadeType.ALL)
    private List<Student> studentList;

    public Hobby() {
    }

    public Hobby(String hobbyName) {
        this.hobbyName = hobbyName;
    }

    public Hobby(String hobbyName, List<Student> studentList) {
        this.hobbyName = hobbyName;
        this.studentList = studentList;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public Long getHobbyId() {
        return hobbyId;
    }

    public void setHobbyId(Long hobbyId) {
        this.hobbyId = hobbyId;
    }

    public String getHobbyName() {
        return hobbyName;
    }

    public void setHobbyName(String hobbyName) {
        this.hobbyName = hobbyName;
    }
}
