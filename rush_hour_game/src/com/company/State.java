package com.company;

import java.util.ArrayList;

public class State {

    public Board puzzle;
    int cost;

    public State(Board puzzle) {
        super();
        this.puzzle = puzzle;
        this.cost = 10000000;
    }

    public ArrayList<State> getNeighbors(){
        ArrayList<State> neighbors = new ArrayList<>();
        ArrayList<Car> cars = this.puzzle.cars;

        for (int i = 0; i < cars.size(); i++) {
            Car car = cars.get(i);

            if(car.isVertical()){
                ArrayList<Car> newcars = cloneCars(cars);
                Car newcar = newcars.get(i);

                while(puzzle.canMoveDown(newcar)){
                    newcar.moveDown();
                    neighbors.add(new State(new Board(this.puzzle.getCols(), this.puzzle.getRows(),
                            newcars.size())));
                    newcars = cloneCars(newcars);
                    newcar = newcars.get(i);
                }
                newcars = cloneCars(cars);
                newcar = newcars.get(i);

                while(puzzle.canMoveUp(newcar)){
                    newcar.moveUp();
                    neighbors.add(new State(new Board(this.puzzle.getCols(), this.puzzle.getRows(),
                            newcars.size())));
                    newcars = cloneCars(newcars);
                    newcar = newcars.get(i);
                }
            }
            else if(car.isHorizontal()){
                ArrayList<Car> newcars = cloneCars(cars);
                Car newcar = newcars.get(i);

                while(puzzle.canMoveRight(newcar)){
                    newcar.moveRight();
                    neighbors.add(new State(new Board(this.puzzle.getCols(), this.puzzle.getRows(),
                            newcars.size())));
                    newcars = cloneCars(newcars);
                    newcar = newcars.get(i);
                }
                newcars = cloneCars(cars);
                newcar = newcars.get(i);

                while(puzzle.canMoveLeft(newcar)){
                    newcar.moveLeft();
                    neighbors.add(new State(new Board(this.puzzle.getCols(), this.puzzle.getRows(),
                            newcars.size())));
                    newcars = cloneCars(newcars);
                    newcar = newcars.get(i);
                }
            }
        }

        return neighbors;
    }

    private ArrayList<Car> cloneCars(ArrayList<Car> cars) {
        ArrayList<Car> newcars = new ArrayList<>();
        for(Car car : cars){
            newcars.add(car.clone());
        }
        return newcars;
    }


    public boolean isGoal(){
        return puzzle.getRedCar().y == puzzle.getRows() - 2;
    }

    public Board getPuzzle() {
        return puzzle;
    }

    public void setPuzzle(Board puzzle) {
        this.puzzle = puzzle;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public State clone(){
        return new State(this.puzzle);
    }

}
