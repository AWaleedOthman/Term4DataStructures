package eg.edu.alexu.csd.datastructure.hangman.cs12.Tests;

import eg.edu.alexu.csd.datastructure.hangman.cs12.Classes.Hangman;

import java.io.File;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class HangmanTest {


    @org.junit.jupiter.api.Test
    void test() {
        Hangman hm = new Hangman();
        File file = new File("D:\\Uni\\Term4\\Data Structures\\Labs\\Term4DataStructures\\Hangman,Lab2\\src" +
                "\\eg\\edu\\alexu\\csd\\datastructure\\hangman\\cs12\\words.txt");
        String[] words = hm.readDictionary(file);

        hm.setDictionary(words);
        assertEquals(61336, hm.getDictionary().length);

        String randomSecretWord = hm.selectRandomSecretWord();
        System.out.println("random secret word is: " + randomSecretWord);

        try {
            System.out.println("HERE");
            hm.guess(hm.getInput())  ;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
