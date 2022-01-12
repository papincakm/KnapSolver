package com.company.knap;

import com.company.data.KnapInstance;
import com.company.data.KnapSolution;

public abstract class KnapSolver {
    protected final KnapInstance instance;

    //TODO: mby send knapInstance to solve so object doesn't have to be instantiated every time and make this static
    public KnapSolver(KnapInstance knapInstance) {
        this.instance = knapInstance;
    }

    public abstract KnapSolution solve();
}
