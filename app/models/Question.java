package models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "questions")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    public String question;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
    public Set<Answer> answers = new HashSet<>();

    public void addAnswer(Answer answer) {
        this.answers.add(answer);
    }

    public Question (){

    }
}
