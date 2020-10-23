package vn.codegym.chuong.model.test_model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questionId;
    private String title;
    private String content;
    private String postDate;
    private String replier = "N/A";

    private String status = "waiting reply";

    @ManyToOne
    @JoinColumn(name = "questionTypeId")
    private QuestionType questionType;

    @ManyToOne
    @JoinColumn(name = "testUserId")
    private TestUser testUser;

    public Question() {
    }

    public Question(String title,String content, String postDate) {
        this.title = title;
        this.content = content;
        this.postDate = postDate;
    }

    public Question(String title, String content, String postDate, QuestionType questionType) {
        this.title = title;
        this.content = content;
        this.postDate = postDate;
        this.questionType = questionType;
    }

    public Question(String title, String content, String postDate, TestUser testUser, QuestionType questionType) {
        this.title = title;
        this.content = content;
        this.postDate = postDate;
        this.testUser = testUser;
        this.questionType = questionType;
    }
    public Question(String title, String content, String postDate, String replier, TestUser testUser, QuestionType questionType) {
        this.title = title;
        this.content = content;
        this.postDate = postDate;
        this.replier = replier;
        this.testUser = testUser;
        this.questionType = questionType;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPostDate() {
        return postDate;
    }

    public void setPostDate(String postDate) {
        this.postDate = postDate;
    }

    public String getReplier() {
        return replier;
    }

    public void setReplier(String replier) {
        this.replier = replier;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public QuestionType getQuestionType() {
        return questionType;
    }

    public void setQuestionType(QuestionType questionType) {
        this.questionType = questionType;
    }

    public TestUser getTestUser() {
        return testUser;
    }

    public void setTestUser(TestUser testUser) {
        this.testUser = testUser;
    }
}
