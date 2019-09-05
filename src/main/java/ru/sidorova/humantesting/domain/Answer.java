package ru.sidorova.humantesting.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table
@ToString(of= {"questionParent","text"})
@EqualsAndHashCode(of ={"idAnswer"})
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idAnswer;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name="question_id")
    private Question questionParent;
    private String text;
    @JsonIgnore
    public Question getQuestionParent() {
        return questionParent;
    }

    public void setQuestionParent(Question questionParent) {
        this.questionParent = questionParent;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public long getIdAnswer() {
        return idAnswer;
    }

    public void setIdAnswer(long idAnswer) {
        this.idAnswer = idAnswer;
    }
}
