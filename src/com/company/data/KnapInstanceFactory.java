package com.company.data;

public class KnapInstanceFactory {
    public static KnapInstance create(Job.Algorithm algorithm) {
        switch(algorithm) {
            case Decision:
                return new DecKnapInstance();
            default:
                return new KnapInstance();
        }
    }
}
