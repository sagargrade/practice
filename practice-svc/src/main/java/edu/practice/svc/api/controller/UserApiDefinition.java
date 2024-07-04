package edu.practice.svc.api.controller;

import edu.practice.svc.bo.UserBO;

import java.util.concurrent.CompletableFuture;

public interface UserApiDefinition {

    CompletableFuture<UserBO[]> getUsers();
}
