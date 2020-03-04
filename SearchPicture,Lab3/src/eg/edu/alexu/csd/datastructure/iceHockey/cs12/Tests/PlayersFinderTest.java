package eg.edu.alexu.csd.datastructure.iceHockey.cs12.Tests;

import eg.edu.alexu.csd.datastructure.iceHockey.cs12.Classes.PlayersFinder;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

class PlayersFinderTest {

    @org.junit.jupiter.api.Test
    void findPlayers() throws IOException {

        PlayersFinder pf = new PlayersFinder();
        int team, threshold, n;
        int x,y;

        Scanner sc = new Scanner(new File(System.getProperty("user.dir") +
                "\\src\\eg\\edu\\alexu\\csd\\datastructure\\iceHockey\\cs12\\Tests\\tests.txt"));
        while (sc.hasNext()) {
            n = sc.nextInt();
            team = sc.nextInt();
            threshold = sc.nextInt();
            sc.nextLine();
            String[] test = new String[n];
            for (int i = 0; i < n; i++) {
               test[i] = sc.nextLine();
            }

            ArrayList<Point> alExpected = new ArrayList<>();
            String temp = sc.nextLine();
            Pattern pattern = Pattern.compile("[0-9]+");
            Matcher matcher = pattern.matcher(temp);
            while (matcher.find()) {
                x = Integer.parseInt(temp.substring(matcher.start(), matcher.end()));
                matcher.find();
                y = Integer.parseInt(temp.substring(matcher.start(), matcher.end()));
                alExpected.add(new Point(x,y));
            }
            //to Point[]
            Point[] expected = new Point[alExpected.size()];
            for (int i = 0; i < expected.length; i++) {
                expected[i] = alExpected.get(i);
            }

            Point[] points = pf.findPlayers(test, team, threshold);
            pf.sort(points);

            for (int i = 0; i < points.length; i++) {
                assertEquals(expected[i].x, points[i].x);
                assertEquals(expected[i].y, points[i].y);
            }
        }
    }
}
