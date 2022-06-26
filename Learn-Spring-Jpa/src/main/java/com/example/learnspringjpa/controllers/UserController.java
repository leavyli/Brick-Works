package com.example.learnspringjpa.controllers;

import com.example.learnspringjpa.entities.User;
import com.example.learnspringjpa.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * Author saino
 * LastModify 6:27
 */
@RestController
@RequestMapping(path = "/api/v1")
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * 保存用户
     *
     * @param user 用户
     * @return 保存后的用户
     */
    @PostMapping(path = "user", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public User addNewUser(@RequestBody User user) {
        return userRepository.save(user);
    }


    /**
     * 根据分页信息查找用户
     *
     * @param request 分页信息
     * @return 用户列表
     */
    @GetMapping(path = "users")
    public Page<User> getAllUsers(Pageable request) {
        return userRepository.findAll(request);
    }

    @GetMapping(path = "page")
    public Page<User> getAllUsersByPage() {
        return userRepository.findAll(PageRequest.of(0, 20, Sort.by(new Sort.Order(Sort.Direction.ASC, "name"))));
    }

    @GetMapping(path = "/sort")
    public Iterable<User> getAllUsersBySort() {
        return userRepository.findAll(Sort.by(new Sort.Order(Sort.Direction.ASC, "name")));
    }
}
