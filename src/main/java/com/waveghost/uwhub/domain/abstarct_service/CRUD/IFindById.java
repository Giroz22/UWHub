package com.waveghost.uwhub.domain.abstarct_service.CRUD;

public interface IFindById<RS,ID> {
    public RS findById(ID id);
}
