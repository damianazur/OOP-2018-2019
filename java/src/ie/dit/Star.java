package ie.dit;

import processing.data.TableRow;

public class Star
{
    private int hab;
    private String displayName;
    private float distance;
    private float xG, yG, zG;
    private float absMag;

    public Star(TableRow row)
    {
        this.hab = row.getInt("Hab?");
        this.displayName = row.getString("Display Name");
        this.distance = row.getFloat("Distance");
        this.xG = row.getFloat("Xg");
        this.yG = row.getFloat("Yg");
        this.zG = row.getFloat("Zg");
        this.absMag = row.getFloat("AbsMag");
    }

    /**
     * @return the hab
     */
    public int getHab() {
        return hab;
    }

    /**
     * @param hab the hab to set
     */
    public void setHab(int hab) {
        this.hab = hab;
    }

    /**
     * @return the displayName
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     * @param displayName the displayName to set
     */
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    /**
     * @return the distance
     */
    public float getDistance() {
        return distance;
    }

    /**
     * @param distance the distance to set
     */
    public void setDistance(float distance) {
        this.distance = distance;
    }

    /**
     * @return the xG
     */
    public float getxG() {
        return xG;
    }

    /**
     * @param xG the xG to set
     */
    public void setxG(float xG) {
        this.xG = xG;
    }

    /**
     * @return the yG
     */
    public float getyG() {
        return yG;
    }

    /**
     * @param yG the yG to set
     */
    public void setyG(float yG) {
        this.yG = yG;
    }

    /**
     * @return the zG
     */
    public float getzG() {
        return zG;
    }

    /**
     * @param zG the zG to set
     */
    public void setzG(float zG) {
        this.zG = zG;
    }

    /**
     * @return the absMag
     */
    public float getAbsMag() {
        return absMag;
    }

    /**
     * @param absMag the absMag to set
     */
    public void setAbsMag(float absMag) {
        this.absMag = absMag;
    }

    public String toString() {
        return displayName + "\t" + hab + "\t" + xG + "\t" + yG + "\t" + zG + "\t" + absMag;
    }
}