package com.example.spring_java_camping.core.results;

public class ErrorDataResult<T> extends DataResult<T> {
    public ErrorDataResult(T data, String message) {
        super(data,false,message);
    }
    public ErrorDataResult(T data) {
        super(data,false);
    }
    public ErrorDataResult() {
        super(null,false);
    }

}
