package com.company.data;

public abstract class DataFileWrapper<T> {
    public abstract T read(String line);
}
