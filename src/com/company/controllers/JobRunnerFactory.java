package com.company.controllers;

import com.company.data.Job;

abstract public class JobRunnerFactory {
    public static JobRunner create(Job.Algorithm algorithm) {
        if (algorithm == Job.Algorithm.Decision)
            return new DecisionJobRunner();
        return new ConstructJobRunner();
    }
}
