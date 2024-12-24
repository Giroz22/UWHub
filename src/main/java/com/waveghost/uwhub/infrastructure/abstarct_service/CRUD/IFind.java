package com.waveghost.uwhub.infrastructure.abstarct_service.CRUD;

public interface IFind<T,ID> {
    public T find(ID id);
}
