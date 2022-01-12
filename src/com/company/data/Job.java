package com.company.data;

import java.util.EnumSet;

public record Job(String instanceFilePath, String resultFilePath, Algorithm algorithm) {
    public enum Algorithm { Constructive, Decision, Dynamic, FPTAS, Greedy, GreedyRedux };
}
