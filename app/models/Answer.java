package models;

import javax.persistence.*;

@Entity
@Table(name = "answers")
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    public String answer;

    public boolean isCorrectAnswer;

}
