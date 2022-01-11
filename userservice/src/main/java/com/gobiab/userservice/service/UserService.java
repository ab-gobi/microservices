package com.gobiab.userservice.service;

import com.gobiab.userservice.VO.ResponseVO;
import com.gobiab.userservice.entity.Department;
import com.gobiab.userservice.entity.User;
import com.gobiab.userservice.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public User saveUser(User user) {
        log.info("UserService:saveUser");
        return userRepository.save(user);
    }

    public ResponseVO getUserById(Long id) {
        log.info("UserService:getUserById");
        ResponseVO responseVO = new ResponseVO();
        User user = userRepository.findByUserId(id);
        Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/" + user.getDepartmentId(),Department.class);
        responseVO.setUser(user);
        responseVO.setDepartment(department);
        return responseVO;
    }
}
