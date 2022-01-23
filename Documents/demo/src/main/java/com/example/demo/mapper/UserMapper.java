package com.example.demo.mapper;

import com.example.demo.dto.UserRes;
import com.example.demo.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import static org.mapstruct.NullValueCheckStrategy.ALWAYS;
import static org.mapstruct.ReportingPolicy.IGNORE;

@Mapper(unmappedTargetPolicy = IGNORE, nullValueCheckStrategy = ALWAYS)
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserRes toUserRes (User user);
}
