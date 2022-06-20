package com.company;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class AStar {

    public Scanner in;
    public PriorityQueue<State> priorityQueue;

    private LinkedList<State> aStarSearch(Board board, Heuristic heuristic) {

    }

}



public class Heuristic1 extends Heuristic{

    @Override
    public int getValue(State state) {
        Car redCar = state.puzzle.getRedCar();
        int gridSize = state.puzzle.gridSize;
        int numberOfMovements = 0;
        for (int i = redCar.y + 2; i < gridSize; i++) {
            int x = redCar.x;
            int y = i;
            if(state.puzzle.crashCars(x, y)){
                Car car = state.puzzle.crashedCar;
                if(!state.puzzle.canMoveDown(car) && !state.puzzle.canMoveUp(car))
                    numberOfMovements += 2;
                else
                    numberOfMovements ++;
            }
        }
        return numberOfMovements;
    }

}

public class Heuristic2 extends Heuristic{

    @Override
    public int getValue(State state) {
        return 0;
    }

}