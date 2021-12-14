package com.company.data;

public class InstanceWrapperFactory {
    public DataFileWrapper create(DecKnapInstance decKnapInstance) {
        return new DecKnapInstanceW();
    };
}
