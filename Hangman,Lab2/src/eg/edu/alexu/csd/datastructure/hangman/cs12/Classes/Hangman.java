package eg.edu.alexu.csd.datastructure.hangman.cs12.Classes;

import eg.edu.alexu.csd.datastructure.hangman.cs12.Interfaces.IHangman;

import java.io.*;

public class Hangman implements IHangman {

    String[] dictionary;
    boolean[] chosen = new boolean[26];
    int maxWrongGuesses, failedAttempts = 0;
    private String randomSecretWord;
    String word;

    private boolean checkValid(String s) {
        for (char c : s.toCharArray()) {
            if (!(Character.isLetter(c))) {
                return false;
            }
        }
        return true;
    }

    public String[] readDictionary(File dictionary) {

        int i = 0;
        String thisLine;
        /* counting words in .txt file to make array
         */
        try {
            FileReader fr = new FileReader(dictionary);
            BufferedReader br = new BufferedReader(fr);
            while ((thisLine = br.readLine()) != null) {
                if(checkValid(thisLine))
                    i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String[] words = new String[i];
        i = 0;
        try {
            FileReader fr = new FileReader(dictionary);
            BufferedReader br = new BufferedReader(fr);
            while ((thisLine = br.readLine()) != null) {
                if(checkValid(thisLine)) {
                    words[i] = thisLine;
                    i++;
                }
            }
            br.close();
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return words;
    }

    @Override
    public void setDictionary(String[] words) {
        dictionary = words;
    }

    @Override
    public String selectRandomSecretWord() {
        int randomNum = (int) ((Math.random()) * (dictionary.length - 1));
        randomSecretWord = dictionary[randomNum];
        word = randomSecretWord;
        word = word.replaceAll(".", "-");
        return randomSecretWord;
    }

    @Override
    public String guess(Character c) throws Exception {
        /*
        already handled buggy words in readDictionary() but it is required to write the next line so...
         */
        if(!checkValid(randomSecretWord)) throw new Exception();
        if (!Character.isLetter(c)) {
            System.out.println("Invalid");
            return word;
        }
        c = Character.toLowerCase(c);
        int index = c - 'a';
        if (chosen[index]) {
            System.out.println("Already chosen!");
            return word;
        } else {
            chosen[index] = true;
        }
        char[] temp;
        boolean failed = true;
        for (int i = 0; i < randomSecretWord.length(); i++) {
            if (c == randomSecretWord.charAt(i)) {
                temp = word.toCharArray();
                temp[i] = c;
                word = String.copyValueOf(temp);
                failed = false;
            }
        }
        if (failed && c != null) {
            failedAttempts++;
        }
        if (failedAttempts == maxWrongGuesses) {
            System.out.println("You Lost!");
            return null;
        } else if (word.compareToIgnoreCase(randomSecretWord)==0){
            System.out.println("You Won!");
            return null;
        }else {
            return word;
        }
    }

    @Override
    public void setMaxWrongGuesses(Integer max) {
        if (max == null) {
            maxWrongGuesses = 1;
        }else {
            maxWrongGuesses = max;
        }
    }

    public String[] getDictionary() {
        return dictionary;
    }

    public String getFailedAttempts() {
        return failedAttempts + " of " + maxWrongGuesses + " failed attempts.";
    }

}
