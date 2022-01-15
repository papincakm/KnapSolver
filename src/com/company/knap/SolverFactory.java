package com.company.knap;

import com.company.data.DecKnapInstance;
import com.company.data.Job;
import com.company.data.KnapInstance;

public class SolverFactory {
    public static KnapSolver create(Job.Algorithm algorithm) {
        switch(algorithm) {
            case Constructive:
                return new ConstructRecSolver();
            case Decision:
                return new DecisionRecSolver();
            case Dynamic:
                return new DynamicSolver();
            case Greedy:
                return new GreedySolver();
            case GreedyRedux:
                return new GreedyReduxSolver();
            default:
                return null;
        }
    }
}
