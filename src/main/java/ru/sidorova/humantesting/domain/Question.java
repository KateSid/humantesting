package ru.sidorova.humantesting.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table
@ToString(of= {"questionnaireParent","text","type"})
@EqualsAndHashCode(of ={"idQuestion"})
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idQuestion;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="questionnaire_id")
    private Questionnaire questionnaireParent;
    private String text;

    @ElementCollection(targetClass = Role.class, fetch=FetchType.EAGER)
    @CollectionTable(name="question_role",joinColumns = @JoinColumn(name="question_id"))
    @Enumerated(EnumType.STRING)
    private Set<TypeOfQuestion> type;

    @OneToMany(mappedBy = "questionParent", fetch = FetchType.EAGER,cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Answer> answerList;
    @JsonIgnore
    public List<Answer> getAnswerList() {
        return answerList;
    }

    public void setAnswerList(List<Answer> answerList) {
        this.answerList = answerList;
    }

    public long getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(long idQuestion) {
        this.idQuestion = idQuestion;
    }

    public Questionnaire getQuestionnaireParent() {
        return questionnaireParent;
    }

    public void setQuestionnaireParent(Questionnaire questionnaireParent) {
        this.questionnaireParent = questionnaireParent;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Set<TypeOfQuestion> getType() {
        return type;
    }

    public void setType(Set<TypeOfQuestion> type) {
        this.type = type;
    }
}
