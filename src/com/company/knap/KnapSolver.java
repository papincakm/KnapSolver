package com.company.knap;

import com.company.data.KnapInstanceInterface;
import com.company.data.KnapSolution;

public abstract class KnapSolver<T extends KnapInstanceInterface> {
    protected final T instance;

    public KnapSolver(T knapInstance) {
        this.instance = knapInstance;
    }

    public abstract KnapSolution solve();
}
