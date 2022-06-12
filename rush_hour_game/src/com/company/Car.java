package com.company;

public class Car {
    private int x;
    private int y;
    private String orient;
    private int size;
    /**
 *
 * @param orient   the orientations of each car
 * @param size     the sizes of each car
 * @param x        the x-coordinates of each car
 * @param y        the y-coordinates of each car
 */
    Car(int x, int y, String orient, int size){
        this.x = x;
        this.y = y;
        this.orient = orient;
        this.size = size;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getOrient() {
        return orient;
    }

    public int getSize() {
        return size;
    }
}
