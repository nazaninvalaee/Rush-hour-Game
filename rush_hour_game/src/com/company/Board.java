package com.company;

import java.util.ArrayList;

public class Board {

    private int searchCount;
    private int rows; //V
    private int cols; //M
    private int numCars; //N
    private int xExit;
    private int yExit;
    private Car redCar;
    private ArrayList<Car> cars;

    public Board(int rows, int cols, int numCars) {
        this.searchCount = 0;
        this.rows = rows;
        this.cols = cols;
        this.numCars = numCars;
        cars = new ArrayList<>();
    }

    public void setxExit(int xExit) {
        this.xExit = xExit;
    }

    public void setyExit(int yExit) {
        this.yExit = yExit;
    }

    public int getxExit() {
        return xExit;
    }

    public int getyExit() {
        return yExit;
    }

    public void setCars(ArrayList<Car> cars) {
        this.cars = cars;
    }

    public ArrayList<Car> getCars() {
        return cars;
    }

    public int getNumCars() {
        return numCars;
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public int getSearchCount() {
        return searchCount;
    }

    public Car getRedCar() {
        return redCar;
    }

    public void setRedCar(Car redCar) {
        this.redCar = cars.get(0);
    }
}
