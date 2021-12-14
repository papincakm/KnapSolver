package com.company.knap;

import java.util.List;

public abstract class KnapSolver<S, T> {
    protected final S instance;

    public KnapSolver(S knapInstance) {
        this.instance = knapInstance;
    }

    public abstract T solve();
}
