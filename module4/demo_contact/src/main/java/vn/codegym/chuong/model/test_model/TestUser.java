package vn.codegym.chuong.model.test_model;

import javax.persistence.*;
import java.util.List;

@Entity
public class TestUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String userName;

    @OneToMany(mappedBy = "testUser", cascade = CascadeType.ALL)
    private List<Question> questionList;
    public TestUser() {
    }

    public TestUser(String userName) {
        this.userName = userName;
    }


    public List<Question> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<Question> questionList) {
        this.questionList = questionList;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
