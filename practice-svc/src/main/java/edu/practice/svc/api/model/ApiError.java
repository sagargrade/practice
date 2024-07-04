package edu.practice.svc.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatusCode;

@AllArgsConstructor
@Data
public class ApiError {

    public HttpStatusCode httpStatus;
    public String errorMessage;
}
