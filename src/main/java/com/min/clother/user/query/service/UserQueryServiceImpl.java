package com.min.clother.user.query.service;

import com.min.clother.user.query.dto.UserDTO;
import com.min.clother.user.query.mapper.UserMapper;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserQueryServiceImpl implements UserQueryService {
    private UserMapper userMapper;

    @Autowired
    public UserQueryServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    // 회원 조회 ( 닉네임 )
    @Override
    public List<UserDTO> getUsers(String keyword) {
        return userMapper.getUsers(keyword);
    }

    // 회원 조회 ( UserId )
    @Override
    public UserDTO getUser(int userId) {
        return userMapper.getUser(userId);
    }
}
