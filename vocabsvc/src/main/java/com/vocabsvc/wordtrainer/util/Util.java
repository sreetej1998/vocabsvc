package com.vocabsvc.wordtrainer.util;

import com.vocabsvc.wordtrainer.model.Word;

public class Util {
  public static void copyWord(Word original, Word incoming) {
    incoming.setId(original.getId());
    if (incoming.getAntonyms() == null) {
      incoming.setAntonyms(original.getAntonyms());
    }
    if (incoming.getSynonyms() == null) {
      incoming.setSynonyms(original.getSynonyms());
    }
    if (incoming.getMeaning() == null) {
      incoming.setMeaning(original.getMeaning());
    }
    if (incoming.getExamples() == null) {
      incoming.setExamples(original.getExamples());
    }
  }
}
