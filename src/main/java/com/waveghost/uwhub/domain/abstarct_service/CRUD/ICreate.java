package com.waveghost.uwhub.domain.abstarct_service.CRUD;

public interface ICreate<RQ,RS> {
    public RS create(RQ request);
}
