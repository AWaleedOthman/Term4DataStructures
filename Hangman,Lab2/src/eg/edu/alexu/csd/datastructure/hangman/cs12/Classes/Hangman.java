package eg.edu.alexu.csd.datastructure.hangman.cs12.Classes;

import eg.edu.alexu.csd.datastructure.hangman.cs12.Interfaces.IHangman;

import java.io.*;
import java.util.Scanner;

public class Hangman implements IHangman {

    String[] dictionary;
    int maxWrongGuesses, failedAttempts = 0;
    private String randomSecretWord;
    String word;

    public String[] readDictionary(File dictionary) {

        int i = 0;
        String thisLine;
        /* counting words in .txt file to make array
         */
        try {
            FileReader fr = new FileReader(dictionary);
            BufferedReader br = new BufferedReader(fr);
            while (br.readLine() != null) {
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
                words[i] = thisLine;
                i++;
            }
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
        c = Character.toLowerCase(c);
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
            return null;
        } else {
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

    public int getMaxWrongGuesses() {
        return maxWrongGuesses;
    }

    public String[] getDictionary() {
        return dictionary;
    }

    public char getInput() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter your guess: ");
        String temp = sc.nextLine();
        while (temp.length() != 1) {
            System.out.println("Invalid");
            System.out.print("Please enter your guess: ");
            temp = sc.nextLine();
        }
        return temp.charAt(0);
    }

}
