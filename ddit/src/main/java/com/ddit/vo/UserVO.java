package com.ddit.vo;

import io.swagger.annotations.ApiParam;
import lombok.Data;

@Data
public class UserVO {

    @ApiParam(value = "email", required = true)
    private String userEmail;

    @ApiParam(value = "password", required = true)
    private String userPw;

    @ApiParam(value = "name", required = false)
    private String userName;
}
