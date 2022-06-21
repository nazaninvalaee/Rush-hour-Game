package com.company;

import java.util.ArrayList;

public class State {

    Board puzzle;
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
                            newcars)));
                    newcars = cloneCars(newcars);
                    newcar = newcars.get(i);
                }
                newcars = cloneCars(cars);
                newcar = newcars.get(i);
                while(puzzle.canMoveUp(newcar)){
                    newcar.moveUp();
                    neighbors.add(new State(new Board(this.puzzle.getCols(), this.puzzle.getRows(),
                            newcars)));
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
                            newcars)));
                    newcars = cloneCars(newcars);
                    newcar = newcars.get(i);
                }
                newcars = cloneCars(cars);
                newcar = newcars.get(i);
                while(puzzle.canMoveLeft(newcar)){
                    newcar.moveLeft();
                    neighbors.add(new State(new Board(this.puzzle.getCols(), this.puzzle.getRows(),
                            newcars)));
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

    public void print(){
        System.out.println(this.toString());
    }

    public String toString(){
        char[][] output = new char[puzzle.getCols()][puzzle.getRows()];
        for (int i = 0; i < output.length; i++) {
            for (int j = 0; j < output.length; j++) {
                output[i][j] = '.';
            }
        }
        for(Car car : puzzle.cars){
            if(car.isHorizontal()){
                if(car.size == 2){
                    if(car.equals(puzzle.getRedCar())){
                        output[car.x][car.y] = '=';
                        output[car.x][car.y+1] = '=';
                    }
                    else{
                        output[car.x][car.y] = '*';
                        output[car.x][car.y+1] = '*';
                    }
                }
                else if(car.size == 3){
                    output[car.x][car.y] = '#';
                    output[car.x][car.y+1] = '#';
                    output[car.x][car.y+2] = '#';
                }
            }
            else if(car.isVertical()){
                if(car.size == 2){
                    output[car.x][car.y] = '+';
                    output[car.x+1][car.y] = '+';
                }
                else if(car.size == 3){
                    output[car.x][car.y] = '@';
                    output[car.x+1][car.y] = '@';
                    output[car.x+2][car.y] = '@';
                }
            }
        }

        String result = "";
        for (int i = 0; i < output.length; i++) {
            result += new String(output[i]) + "\n";
        }

        return result;
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
