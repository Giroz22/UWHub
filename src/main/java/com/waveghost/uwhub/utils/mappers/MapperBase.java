package com.waveghost.uwhub.utils.mappers;

import java.util.List;


public interface MapperBase<T,RQ,RS> {
    public RS entityToResponse(T entity);
    public List<RS> entityToResponse(List<T> entity);
    public T requestToEntity(RQ request);
}
