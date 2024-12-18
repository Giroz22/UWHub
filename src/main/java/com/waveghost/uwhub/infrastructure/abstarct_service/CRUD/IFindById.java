package com.waveghost.uwhub.infrastructure.abstarct_service.CRUD;

public interface IFindById<RS,ID> {
    public RS findById(ID id);
}
