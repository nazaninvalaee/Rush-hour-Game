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
        HashMap<State, State> predecessor = new HashMap<>();
        HashMap<String, Boolean> visited = new HashMap<>();

        State src = new State(board);
        State goal = null;

        src.setCost(0);
        priorityQueue.add(src);
        visited.put(src.toString(), true);

        while(!priorityQueue.isEmpty()){
            State s = priorityQueue.poll();

            if(s.isGoal()){
                goal = s;
                break;
            }

            for(State v : s.getNeighbors()){
                int cost = s.cost + 1 + heuristic.getValue(v);

                if(!contains(visited, v)){
                    v.setCost(cost);
                    priorityQueue.add(v);
                    predecessor.put(v, s);
                    visited.put(v.toString(), true);
                }
            }
        }

        return getPath(predecessor, goal);
    }

    private boolean contains(HashMap<String, Boolean> visited, State v) {
        return visited.containsKey(v.toString());
    }

    private void print(LinkedList<State> path) {
        System.out.println("Number of optimal movements = " + (path.size()-1) + "\n");
    }

    private LinkedList<State> getPath(HashMap<State, State> pred, State goal) {
        LinkedList<State> path =  new LinkedList<>();
        State s = goal;

        path.addFirst(s.clone());

        while(pred.get(s) != null){
            State parent = pred.get(s);
            path.addFirst(parent.clone());
            s = parent;
        }

        return path;
    }


}





