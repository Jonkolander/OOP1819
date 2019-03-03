package Assignment06;

import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author Dennis den Hollander (s4776658)
 * @author Tom Kamp (s4760921)
 */
public class Solver {
    PriorityQueue<Configuration> toExamine;
    Set<Configuration> visitedStates;
    
    public Solver(Configuration g) {
        this.visitedStates = new HashSet();
        this.toExamine = new PriorityQueue();
        this.toExamine.add(g);
    }

    public String solve() {
        while (!toExamine.isEmpty()) {
            Configuration next = toExamine.remove();
            visitedStates.add(next);
            if (next.isSolution()) {
                projectPath(next);
                return "Success!";
            } else {
                for (Configuration succ : next.successors()) {
                    if (!visitedStates.contains(succ)) {
                        toExamine.add(succ);
                    }
                }
            }
        }
        return "Failure!";
    }
    
    public void projectPath (Configuration next) {
        int steps = next.pathFromRoot().size() - 1;
        System.out.println("Solved in " + steps + " steps using Best-First Search!\n");
        List<Configuration> finalList = next.pathFromRoot();
        for (int i = 1; i < finalList.size(); i++) 
            System.out.println(finalList.get(i) + "\n");
    }
}

