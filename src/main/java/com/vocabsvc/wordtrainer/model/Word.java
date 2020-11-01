package com.vocabsvc.wordtrainer.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.ArrayList;

@Setter
@Getter
@Entity
@Table
public class Word {
    @Id
    @Column
    private String name;

    @Column
    private String meaning;

    @Column
    private ArrayList<Word> synonyms;

    @Column
    private ArrayList<Word> antonyms;

    @Column
    private ArrayList<String> examples;
}
