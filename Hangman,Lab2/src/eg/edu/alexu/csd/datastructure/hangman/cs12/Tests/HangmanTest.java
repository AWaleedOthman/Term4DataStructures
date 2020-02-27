package eg.edu.alexu.csd.datastructure.hangman.cs12.Tests;

import eg.edu.alexu.csd.datastructure.hangman.cs12.Classes.Hangman;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class HangmanTest {


    @org.junit.jupiter.api.Test
    void test() {
        /*
        array for simulated user input
         */
        char[] carray = new char[26];
        for (int i = 0; i < 26; i++) {
            carray[i] = (char)('a' + i);
        }
        Hangman hm = new Hangman();
        File file = new File("D:\\Uni\\Term4\\Data Structures\\Labs\\Term4DataStructures\\Hangman,Lab2\\src" +
                "\\eg\\edu\\alexu\\csd\\datastructure\\hangman\\cs12\\words.txt");
        try {
            String[] words = hm.readDictionary(file);
            hm.setDictionary(words);
            assertArrayEquals(words, hm.getDictionary());
        } catch (Exception e) {
            System.out.println("No valid Words in file!");
            System.exit(0);
        }

        String randomSecretWord = hm.selectRandomSecretWord();
        System.out.println("random secret word is: " + randomSecretWord);

        try {
            int i = 0;
            char c = carray[i];
            hm.setMaxWrongGuesses(5);
            assertEquals(5, hm.getMaxWrongGuesses());
            String temp;
            System.out.println(hm.getWord());
            do {
                System.out.println("Test char is: " + c);
                if ((temp = hm.guess(c)) != null) {
                    System.out.println(temp + "          " + hm.getFailedAttempts());
                }else {
                    System.out.println(hm.getWord());
                }
                i++;
                c = carray[i];
            } while (temp != null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
