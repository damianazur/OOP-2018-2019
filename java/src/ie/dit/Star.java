package ie.dit;

import processing.core.PVector;
import processing.data.TableRow;

public class Star {
    private int hab;
    private String displayName;

    private float distance; 

    private PVector coords;
    private float absMag;

    public Star(TableRow row) {
        hab = row.getInt("Hab?");
        displayName = row.getString("Display Name");
        distance = row.getFloat("Distance");
        coords = new PVector(row.getFloat("Xg"), row.getFloat("Yg"), row.getFloat("Zg"));
        absMag = row.getFloat("AbsMag");
    }

    public int getHab() {
        return hab;
    }
    public void setHab(int hab) {
        this.hab = hab;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
    public String getDisplayName() {
        return displayName;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }
    public float getDistance() {
        return distance;
    }

    public void setCoords(float xG, float yG, float zG) {
        coords = new PVector(xG, yG, zG);
    }
    public PVector getCoords() {
        return coords;
    }

    public void setAbsMag(float absMag) {
        this.absMag = absMag;
    }
    public float getAbsMag() {
        return absMag;
    }

    public String toString() {
        return displayName + "\t" + coords + "\t" + distance;
    }

}
