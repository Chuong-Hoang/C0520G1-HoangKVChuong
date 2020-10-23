package vn.codegym.chuong.model.test_model;

import javax.persistence.*;
import java.util.List;

@Entity
public class QuestionType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questionTypeId;
    private String questionTypeName;

    @OneToMany(mappedBy = "questionType", cascade = CascadeType.ALL)
    private List<Question> questionList;

    public QuestionType() {
    }

    public QuestionType(String questionTypeName) {
        this.questionTypeName = questionTypeName;
    }


    public Long getQuestionTypeId() {
        return questionTypeId;
    }

    public void setQuestionTypeId(Long questionTypeId) {
        this.questionTypeId = questionTypeId;
    }

    public String getQuestionTypeName() {
        return questionTypeName;
    }

    public void setQuestionTypeName(String questionTypeName) {
        this.questionTypeName = questionTypeName;
    }

    public List<Question> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<Question> questionList) {
        this.questionList = questionList;
    }
}
