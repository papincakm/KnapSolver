package com.company.knap;

import com.company.data.KnapInstance;
import com.company.data.KnapSolution;

public class SolverFactory {
    enum Algorithm { Constructive, Decision };

    KnapSolver create(Algorithm algorithm, KnapInstance knapInstance) {
        switch(algorithm) {
            case Constructive:
                return new ConstructProblemSolver(knapInstance);
            default:
                return null;
        }
    }
}
