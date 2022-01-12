package com.company.knap;

import com.company.data.DecKnapInstance;
import com.company.data.Job;
import com.company.data.KnapInstance;

public class SolverFactory {
    public static KnapSolver create(Job.Algorithm algorithm, KnapInstance knapInstance) {
        switch(algorithm) {
            case Constructive:
                return new ConstructProblemSolver(knapInstance);
            case Decision:
                return new DecisionProblemSolver((DecKnapInstance) knapInstance);
            case Dynamic:
                return new DynamicSolver(knapInstance);
            case Greedy:
                return new GreedySolver(knapInstance);
            case GreedyRedux:
                return new GreedyReduxSolver(knapInstance);
            default:
                return null;
        }
    }
}
