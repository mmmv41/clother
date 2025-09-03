package com.min.clother.user.query.service;

import com.min.clother.user.query.dto.UserDTO;
import java.util.List;

public interface UserQueryService {

    List<UserDTO> getUsers(String keyword);

    UserDTO getUser(int userId);
}
