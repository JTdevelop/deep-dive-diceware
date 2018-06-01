package edu.cnm.deepdive.diceware;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Generator {

  private String[] words;
  private Random rng;

  public Generator(String[] words, Random rng) {
    Set<String> pool = new HashSet<>();
    for (String word : words) {
      word = word.toLowerCase();
      if (!pool.contains(word)) {
        pool.add(word);
      }
    }
    this.words = pool.toArray(new String[pool.size()]);
    this.rng = rng;
  }

  public String next() {
    return words[rng.nextInt(words.length)];
  }

  public String[] next(int numWords, boolean duplicatesAllowed) {
    List<String> selection = new LinkedList<>();
  while (selection.size() <numWords) {
    String pick = next();
    if (duplicatesAllowed || !selection.contains(pick)) {
      selection.add(pick);
    }
  }
    return selection.toArray(new String[selection.size()]);
  }

  public String[] next(int numWords) {
    return next(numWords, true);
  }
}
