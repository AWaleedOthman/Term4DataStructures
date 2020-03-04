package eg.edu.alexu.csd.datastructure.iceHockey.cs12.Classes;

import eg.edu.alexu.csd.datastructure.iceHockey.cs12.Interfaces.IPlayersFinder;

import java.awt.*;
import java.util.ArrayList;

public class PlayersFinder implements IPlayersFinder {

    private enum From {U, R, D, L}

    private int xmin, xmax, ymin, ymax, n;

    @Override
    public Point[] findPlayers(String[] photo, int team, int threshold) {
        char cteam = (char) (team + '0');
        ArrayList<Point> alPoint = new ArrayList<>();
        for (int y = 0; y < photo.length; y++) {
            for (int x = 0; x < photo[0].length(); x++) {
                if (photo[y].charAt(x) == cteam) {
                    n = 0;
                    xmin = xmax = x;
                    ymin = ymax = y;
                    find(photo, cteam, x, y, From.L);
                    if (n * 4 >= threshold) {
                        alPoint.add(new Point(xmin + xmax + 1, ymin + ymax + 1));
                    }
                }
            }
        }
        Point[] myPoints = new Point[alPoint.size()];
        for (int i = 0; i < myPoints.length; i++) {
            myPoints[i] = alPoint.get(i);
        }
        /*
          the next part returns every element in the photo
          that was changed from @param team to 't'
         */
        for (int y = 0; y < photo.length; y++) {
            for (int x = 0; x < photo[0].length(); x++) {
                if (photo[y].charAt(x) == 't') {
                    char[] temp;
                    temp = photo[y].toCharArray();
                    temp[x] = cteam;
                    photo[y] = String.copyValueOf(temp);
                }
            }
        }
        return myPoints;
    }

    public void sort(Point[] points) {
        //bubble sort to sort x
        boolean sorted;
        Point temp;
        int length = points.length;
        for (int i = 0; i < length - 1; i++) {
            sorted = true;
            for (int j = 0; j < length - i - 1; j++) {
                if (points[j].x > points[j + 1].x) {
                    temp = points[j];
                    points[j] = points[j + 1];
                    points[j + 1] = temp;
                    sorted = false;
                }
            }

            if (sorted)
                break;
        }

        //bubble sort to sort y
        for (int i = 0; i < length - 1; i++) {
            sorted = true;
            for (int j = 0; j < length - i - 1; j++) {
                if (points[j].x == points[j + 1].x && points[j].y > points[j + 1].y) {
                    temp = points[j];
                    points[j] = points[j + 1];
                    points[j + 1] = temp;
                    sorted = false;
                }
            }

            if (sorted)
                break;
        }
    }

    private void find(String[] photo, char team, int x, int y, From f) {
        //replace char with 't' so as not to call the function again redundantly and to prevent possible infinte loop
        char[] temp;
        temp = photo[y].toCharArray();
        temp[x] = 't';
        photo[y] = String.copyValueOf(temp);
        //to solve index out of array/String range
        boolean maxUp = (y == 0), maxDown = (y == photo.length - 1),
                maxRight = (x == photo[0].length() - 1), maxLeft = (x == 0);
        n++;
        if (x < xmin) xmin = x;
        if (x > xmax) xmax = x;
        if (y < ymin) ymin = y;
        if (y > ymax) ymax = y;

        switch (f) {
            case L:
                //search up
                if (!maxUp && photo[y - 1].charAt(x) == team) find(photo, team, x, y - 1, From.D);
                //search right
                if (!maxRight && photo[y].charAt(x + 1) == team) find(photo, team, x + 1, y, From.L);
                //search down
                if (!maxDown && photo[y + 1].charAt(x) == team) find(photo, team, x, y + 1, From.U);
                break;
            case U:
                //search left
                if (!maxLeft && photo[y].charAt(x - 1) == team) find(photo, team, x - 1, y, From.R);
                //search right
                if (!maxRight && photo[y].charAt(x + 1) == team) find(photo, team, x + 1, y, From.L);
                //search down
                if (!maxDown && photo[y + 1].charAt(x) == team) find(photo, team, x, y + 1, From.U);
                break;
            case R:
                //search up
                if (!maxUp && photo[y - 1].charAt(x) == team) find(photo, team, x, y - 1, From.D);
                //search left
                if (!maxLeft && photo[y].charAt(x - 1) == team) find(photo, team, x - 1, y, From.R);
                //search down
                if (!maxDown && photo[y + 1].charAt(x) == team) find(photo, team, x, y + 1, From.U);
                break;
            case D:
                //search up
                if (!maxUp && photo[y - 1].charAt(x) == team) find(photo, team, x, y - 1, From.D);
                //search left
                if (!maxLeft && photo[y].charAt(x - 1) == team) find(photo, team, x - 1, y, From.R);
                //search right
                if (!maxRight && photo[y].charAt(x + 1) == team) find(photo, team, x + 1, y, From.L);
                break;
        }

    }

}
