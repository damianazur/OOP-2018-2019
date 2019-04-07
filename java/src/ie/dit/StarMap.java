/*
    Damian Wojtowicz 
    C17413722
    07/04/2018
    DT228/2 OOP Lab Test Preperations
*/

package ie.dit;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class StarMap extends PApplet {
    private ArrayList<Star> stars = new ArrayList<Star>(); 
    private int border = 50;
    private int screenDim = 600;
    private int selected1 = -1;
    private int selected2 = -1;

    public void settings() {
        size(screenDim, screenDim);
    }

    public void setup() {
        loadData();
        //printStars();
    }

    public void loadData() {
        // every row in this table is star
        Table table = loadTable("HabHYG15ly.csv", "header");

        for (int i = 0; i < table.getRowCount(); i++) {
            // creates a new star 
            Star s = new Star(table.getRow(i));

            // adds the star to the end of the stars array list
            stars.add(s);
        }
    }

    public void printStars() {
        int i = 1;
        for (Star s : stars) {
            System.out.println(i + ": " + s.toString());
            i++;
        }
    }

    public void mouseClicked() {
        // check if a star has been clicked
        int i = 0;
        for (Star s : stars) {
            // get the x and y co-ords of the star on the screen itself
            float x = map(s.getxG(), -5, 5, border, screenDim - border);
            float y = map(s.getyG(), -5, 5, border, screenDim - border);

            // check if the distance between the mouse and star center is less or equal 
            // to that of the stars radius
            if (dist(mouseX, mouseY, x, y) <= s.getAbsMag() / 2) {
                // if the first star is not selected then select it
                if (selected1 == -1) {
                    selected1 = i;
                // if the second star is not selected then select it
                } else if (selected2 == -1) {
                    selected2 = i;
                // if both are selected then select the new star and 
                // deselect the second one
                } else if (selected1 != -1 && selected2 != -1) {
                    selected1 = i;
                    selected2 = -1;
                }
                //System.out.println(s.getDisplayName());
            }
            i++;
        }
    }

    public void drawGrid() {
        // purple line color
        stroke(150, 0, 150);
        // purple text color
        fill(150, 0, 150);
        textAlign(CENTER, CENTER);
        // grid
        for (int i = -5; i < 6; i++) {
            float var = map(i, -5, 5, border, screenDim - border);

            // vertical lines
            line(var, border, var, screenDim - border);
            text(i, var, border/2);

            // horizontal lines
            line(border, var, screenDim - border, var);
            text(i, border/2, var);
        }
    }

    public void drawStars() {
        // stars
        for (Star s : stars) {
            float x = map(s.getxG(), -5, 5, border, screenDim - border);
            float y = map(s.getyG(), -5, 5, border, screenDim - border);
            float diameter = s.getAbsMag();
            String sName = s.getDisplayName();

            // star circle
            stroke(255, 0, 0);
            noFill();
            ellipse(x, y, diameter, diameter);

            // star cross
            stroke(250, 250, 0);
            line(x - 5, y, x + 5, y);
            line(x, y - 5, x, y + 5);

            // star name
            textAlign(LEFT, CENTER);
            fill(255, 255, 255);
            textSize(10);
            text(sName, x + 10, y);
        }
    }

    public void draw() {
        // refresh background
        background(0);
        
        drawGrid();
        drawStars();

        // if the one star is selected but the other is not
        // draw line from the star to the mouse
        if (selected1 != -1 && selected2 == -1) {
            Star s1 = stars.get(selected1);
            float x1 = map(s1.getxG(), -5, 5, border, screenDim - border);
            float y1 = map(s1.getyG(), -5, 5, border, screenDim - border);

            stroke(255, 255, 0);
            line(x1, y1, mouseX, mouseY);
        // if both stars are selected then draw line between two
        } else if (selected1 != -1 && selected2 != -1) {
            Star s1 = stars.get(selected1);
            float x1 = map(s1.getxG(), -5, 5, border, screenDim - border);
            float y1 = map(s1.getyG(), -5, 5, border, screenDim - border);

            Star s2 = stars.get(selected2);
            float x2 = map(s2.getxG(), -5, 5, border, screenDim - border);
            float y2 = map(s2.getyG(), -5, 5, border, screenDim - border);

            stroke(255, 255, 0);
            line(x1, y1, x2, y2);

            // distance in a 3 dimentional space
            float dist = dist(s1.getxG(), s1.getyG(), s1.getzG(), s2.getxG(), s2.getyG(), s2.getzG());
            text("Distance from " + s1.getDisplayName() + " to " + s2.getDisplayName() + " is " + dist + " parsecs", border,
                    height - 25);
        }
    }
    
}