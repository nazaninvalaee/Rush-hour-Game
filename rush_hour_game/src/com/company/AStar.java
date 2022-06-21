package com.company;

import java.util.*;

public class AStar {

    public PriorityQueue<State> priorityQueue;
    public Scanner in = new Scanner(System.in);

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

    private void print(LinkedList<State> path, int parkingIndex) {
        System.out.println(String.format("Test#%d: %s", (parkingIndex + 1), (path.size() - 1)));
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

    public void solveProblem() {
        priorityQueue = new PriorityQueue<State>(10, new Comparator<State>() {

            @Override
            public int compare(State o1, State o2) {
                return o1.cost - o2.cost;
            }

        });

        ArrayList<Board> boards = Main.boards;

        for (int i = 0; i < boards.size(); i++) {
            Heuristic heuristic = new Heuristic();
            LinkedList<State> path1 = aStarSearch(boards.get(i), heuristic);
            print(path1, i);

            in.close();
        }
    }
}





