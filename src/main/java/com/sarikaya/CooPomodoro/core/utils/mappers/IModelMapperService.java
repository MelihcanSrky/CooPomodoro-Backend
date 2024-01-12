package com.sarikaya.CooPomodoro.core.utils.mappers;

import org.modelmapper.ModelMapper;

public interface IModelMapperService {
    ModelMapper forResponse();
    ModelMapper forRequest();
}
