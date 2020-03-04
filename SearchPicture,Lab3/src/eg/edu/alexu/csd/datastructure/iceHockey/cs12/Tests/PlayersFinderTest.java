package eg.edu.alexu.csd.datastructure.iceHockey.cs12.Tests;

import eg.edu.alexu.csd.datastructure.iceHockey.cs12.Classes.PlayersFinder;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class PlayersFinderTest {

    @org.junit.jupiter.api.Test
    void findPlayers() {
        PlayersFinder pf = new PlayersFinder();
        String[] test = {
                "00JUBU00",
                "0U3O4430",
                "O33P44NB",
                "PO3NSDP0",
                "VNDSD330",
                "OINFD00X"
        };
        Point[] points = pf.findPlayers(test, 3, 16);
    }
}
