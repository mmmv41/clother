package com.min.clother.user.query.mapper;

import com.min.clother.user.query.dto.UserDTO;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    List<UserDTO> getUsers(@Param("keyword") String keyword);

    UserDTO getUser(@Param("userId") int userId);
}
