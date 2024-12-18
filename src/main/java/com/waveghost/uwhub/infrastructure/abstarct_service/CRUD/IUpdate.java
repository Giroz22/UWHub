package com.waveghost.uwhub.infrastructure.abstarct_service.CRUD;

public interface IUpdate<RQ,RS,ID> {
    public RS update(RQ requets, ID id);
}
