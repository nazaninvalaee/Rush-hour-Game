package com.company;

public class Heuristic {

    public int getValue(State state) {
        Car redCar = state.puzzle.getRedCar();
        int gridSize = state.puzzle.getRows();
        int numberOfMovements = 0;
        for (int i = redCar.getY() + 2; i < gridSize; i++) {
            int x = redCar.getX();
            int y = i;
            if(state.puzzle.crashCars(x, y)){
                Car car = state.puzzle.getCrashedCar();
                if(!state.puzzle.canMoveDown(car) && !state.puzzle.canMoveUp(car))
                    numberOfMovements += 2;
                else
                    numberOfMovements ++;
            }
        }
        return numberOfMovements;
    }

}
