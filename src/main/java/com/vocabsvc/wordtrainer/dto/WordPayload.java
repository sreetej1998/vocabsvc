package com.vocabsvc.wordtrainer.dto;

import com.vocabsvc.wordtrainer.model.Word;
import java.util.ArrayList;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class WordPayload {
  private long id;

  @NotNull(message = "Name cannot be null")
  private String name;

  @NotNull(message = "meaning cannot be null")
  private String meaning;

  private ArrayList<Word> synonyms;

  private ArrayList<Word> antonyms;

  private ArrayList<String> examples;
}
