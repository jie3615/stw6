package com.ajie.stw6.pojo;

import lombok.Builder;
import lombok.Data;

/**
 * @author wyj
 * @since 2022/1/17
 */
@Builder
@Data
public class User {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
