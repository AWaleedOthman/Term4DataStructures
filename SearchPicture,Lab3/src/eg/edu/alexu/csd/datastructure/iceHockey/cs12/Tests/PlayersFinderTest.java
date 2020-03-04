package eg.edu.alexu.csd.datastructure.iceHockey.cs12.Tests;

import eg.edu.alexu.csd.datastructure.iceHockey.cs12.Classes.PlayersFinder;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class PlayersFinderTest {

    @org.junit.jupiter.api.Test
    void findPlayers() {
        PlayersFinder pf = new PlayersFinder();
        String[] test = {
                "11111",
                "1AAA1",
                "1A1A1",
                "1AAA1",
                "11111"
        };
        Point[] points = pf.findPlayers(test, 1, 3);
        pf.sort(points);
        for (Point point : points) {
            System.out.println(point.x + " " + point.y);
        }
    }
}
