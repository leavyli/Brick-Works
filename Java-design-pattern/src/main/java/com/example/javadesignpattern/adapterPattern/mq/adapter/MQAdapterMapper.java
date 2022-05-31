package com.example.javadesignpattern.adapterPattern.mq.adapter;

import com.example.javadesignpattern.adapterPattern.mq.CreateAccount;
import com.example.javadesignpattern.adapterPattern.mq.RebateInfo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MQAdapterMapper {
    MQAdapterMapper INSTANCE = Mappers.getMapper(MQAdapterMapper.class);
    @Mapping(source = "number", target = "userId")
    @Mapping(source = "number", target = "bizId")
    @Mapping(source = "accountDate", target = "bizTime")
    RebateInfo toRebeteInfo(CreateAccount createAccount);
}
