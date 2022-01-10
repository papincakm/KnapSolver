package com.company.knap;

import com.company.data.KnapInstanceInterface;
import com.company.data.KnapSolution;

public abstract class KnapSolver<T extends KnapInstanceInterface> {
    public static String[] algorithms = { "Constructive", "Decision", "Dynamic", "FPTAS", "Greedy", "GreedyRedux" };
    protected final T instance;

    //TODO: mby send knapInstance to solve so object doesn't have to be instantiated every time and make this static
    public KnapSolver(T knapInstance) {
        this.instance = knapInstance;
    }

    public abstract KnapSolution solve();
}
