package com.waveghost.uwhub.infrastructure.abstarct_service.CRUD;

public interface ICreate<RQ,RS> {
    public RS create(RQ request);
}
