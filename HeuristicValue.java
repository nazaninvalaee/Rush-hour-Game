import com.company.Car;
import com.company.Heuristic;
import com.company.State;

public class Heuristic1 extends Heuristic {

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