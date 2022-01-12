package com.example.sbjpa.test;

import com.example.sbjpa.model.RoleType;
import com.example.sbjpa.model.User;
import com.example.sbjpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DummyController {

    @Autowired // 애플리케이션이 실행되어 메모리에 올라갈 때,
    private UserRepository userRepository;

    @PostMapping("/dummy/join")
    public String join(User user) {

        user.setRole(RoleType.USER);

        userRepository.save(user);

        return user.toString();
    }

    @GetMapping("/dummy/user")
    public List<User> pageList(@PageableDefault(size = 2, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<User> pagingUser = userRepository.findAll(pageable);

        List<User> users = pagingUser.getContent();

        return users;
    }

}
