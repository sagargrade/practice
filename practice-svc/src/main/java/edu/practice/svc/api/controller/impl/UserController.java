package edu.practice.svc.api.controller.impl;

import edu.practice.svc.api.controller.UserApiDefinition;
import edu.practice.svc.bo.UserBO;
import edu.practice.svc.config.security.SecurityScope;
import edu.practice.svc.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@AllArgsConstructor
@RequestMapping(AbstractController.ROOT_CONTEXT_PATH + UserController.BASE_PATH)
public class UserController extends AbstractController implements UserApiDefinition {

    public static final String BASE_PATH = "/users";
    private final UserService userService;

    @Override
    @GetMapping
    @PreAuthorize(SecurityScope.PRE_AUTHORIZE_CAN_CONSULT)
    public CompletableFuture<UserBO[]> getUsers() {
        return userService.getUsers();
    }
}
