package com.waveghost.uwhub.infrastructure.abstarct_service.CRUD;

import java.util.List;

public interface IFindAll<RS> {
    public List<RS> findAll();
}
