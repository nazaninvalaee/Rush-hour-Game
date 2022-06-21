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
    private Car crashedCar;

    public Board(int rows, int cols, int numCars) {
        this.searchCount = 0;
        this.rows = rows;
        this.cols = cols;
        this.numCars = numCars;
        cars = new ArrayList<>();
    }

    public Board(int cols, int rows, ArrayList<Car> newCars) {
        this.cols = cols;
        this.rows = rows;
        this.cars = newCars;
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

    public Car getCrashedCar() {
        return crashedCar;
    }

    public Car getRedCar() {
        return this.cars.get(0);
    }

    public void setRedCar(Car redCar) {
        this.redCar = redCar;
    }

    public boolean canMoveDown(Car car) {
        if(car.getX() + car.getSize() < getRows()
                && !crashCars(car.getX() + car.getSize(), car.getY()))
            return true;
        return false;
    }

    public boolean canMoveUp(Car car) {
        if(car.getX() > 0 && !crashCars(car.getX()-1, car.getY()))
            return true;
        return false;
    }

    public boolean canMoveRight(Car car) {
        if(car.getY() + car.getSize() < getCols()
                && !crashCars(car.getX(), car.getY() + car.getSize()))
            return true;
        return false;
    }

    public boolean canMoveLeft(Car car) {
        if(car.getY() > 0 && !crashCars(car.getX(), car.getY() -1))
            return true;
        return false;
    }

    public boolean crashCars(int x, int y) {
        for(Car car : cars){
            if(car.isHorizontal()){
                if(x == car.getX() && y >= car.getY() && y < car.getY() + car.getSize()){
                    crashedCar = car;
                    return true;
                }
            }
            else if(car.isVertical()){
                if(y == car.getY() && x >= car.getX() && x < car.getX() + car.getSize()){
                    crashedCar = car;
                    return true;
                }
            }
        }
        return false;
    }

}
