package ru.hehmdalolkek.blog.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.hehmdalolkek.blog.model.Role;
import ru.hehmdalolkek.blog.service.UserService;
import ru.hehmdalolkek.blog.web.dto.UserDto;

import java.util.Set;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @ModelAttribute(value = "user")
    public UserDto getUserDto() {
        return new UserDto();
    }

    @GetMapping("/registration")
    public String initRegistration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute UserDto userDto) {
        userDto.setRoles(Set.of(Role.AUTHOR));
        this.userService.createUser(userDto);
        return "redirect:/login?registration";
    }

}
