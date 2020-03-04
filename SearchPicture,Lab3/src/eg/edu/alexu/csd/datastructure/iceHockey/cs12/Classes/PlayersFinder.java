package eg.edu.alexu.csd.datastructure.iceHockey.cs12.Classes;

import eg.edu.alexu.csd.datastructure.iceHockey.cs12.Interfaces.IPlayersFinder;

import java.awt.*;
import java.util.ArrayList;

public class PlayersFinder implements IPlayersFinder {

    @Override
    public Point[] findPlayers(String[] photo, int team, int threshold) {
        char cteam = (char)(team + '0');
        ArrayList<Point> alPoint = new ArrayList<Point>();
        for (int y = 0; y < photo.length; y++) {
            for (int x = 0; x < photo[0].length(); x++) {
                if (photo[y].charAt(x) == cteam) {
                    n = 0;
                    xmin = xmax = x;
                    ymin = ymax = y;
                    find(photo, cteam, y, x, y, From.L);
                    if (n*4 >= threshold) {
                        alPoint.add(new Point(xmin + xmax +1,ymin + ymax +1));
                    }
                }
            }
        }
        Point[] myPoints = new Point[alPoint.size()];
        for (int i = 0; i < myPoints.length; i++) {
            myPoints[i] = alPoint.get(i);
        }
        return myPoints;
    }

    private enum From { U, R, D, L }
    private int xmin, xmax, ymin, ymax, n;

    public void find(String[] photo, char team, int firstY, int x, int y, From f) {
    /*
    TODO:
        handle string and array of strings index out of range problem
     */
        n++;
        if (x < xmin) xmin = x;
        if (x > xmax) xmax = x;
        if (y < ymin) ymin = y;
        if (y > ymax) ymax = y;

        switch (f) {
            case L:
                if (firstY != y) {   //not first row in object
                    //search up
                    if (photo[y-1].charAt(x) == team) find(photo, team, firstY, x, y - 1, From.D);
                }
                //search right
                if (photo[y].charAt(x+1) == team) find(photo, team, firstY, x + 1, y, From.L);
                //search down
                if (photo[y+1].charAt(x) == team) find(photo, team, firstY, x, y + 1, From.U);
                break;
            case U:
                //search left
                if (photo[y].charAt(x-1) == team) find(photo, team, firstY, x - 1, y, From.R);
                //search right
                if (photo[y].charAt(x+1) == team) find(photo, team, firstY, x + 1, y, From.L);
                //search down
                if (photo[y+1].charAt(x) == team) find(photo, team, firstY, x, y + 1, From.U);
                break;
            case R:
                if (firstY != y) {   //not first row in object
                    //search up
                    if (photo[y-1].charAt(x) == team) find(photo, team, firstY, x, y - 1, From.D);
                }
                //search left
                if (photo[y].charAt(x-1) == team) find(photo, team, firstY, x - 1, y, From.R);
                //search down
                if (photo[y+1].charAt(x) == team) find(photo, team, firstY, x, y + 1, From.U);
                break;
            case D:
                if (firstY != y) {   //not first row in object
                    //search up
                    if (photo[y-1].charAt(x) == team) find(photo, team, firstY, x, y - 1, From.D);
                }
                //search left
                if (photo[y].charAt(x-1) == team) find(photo, team, firstY, x - 1, y, From.R);
                //search right
                if (photo[y].charAt(x+1) == team) find(photo, team, firstY, x + 1, y, From.L);
                break;
        }

    }

}
