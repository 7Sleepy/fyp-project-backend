package com.fyp.response;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class ApiResponse<T> {

    private T data;
    private String message;
    private String status;

    public ApiResponse() {
    }

    public ApiResponse(T data, String message, String status) {
        this.data = data;
        this.message = message;
        this.status = status;
    }

    public Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("data", this.data);
        map.put("message", this.message);
        map.put("status", this.status);
        return map;
    }
}
