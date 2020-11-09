package com.vocabsvc.wordtrainer.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table
public class Word {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column private String name;

  @Column private String meaning;

  @Column private ArrayList<Word> synonyms;

  @Column private ArrayList<Word> antonyms;

  @Column private ArrayList<String> examples;

  @ManyToMany(mappedBy = "words")
  List<User> userList;
}
