package ru.sidorova.humantesting.domain;

import javax.persistence.*;
@Entity
public class UserAnswer {
    @Id
    private long id;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="user_id")
    private User master;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="question_id")
    private Answer question;
    private String text;
}
