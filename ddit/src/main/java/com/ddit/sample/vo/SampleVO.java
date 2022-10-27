package com.ddit.sample.vo;

import io.swagger.annotations.ApiParam;
import lombok.Data;

@Data // lombok이 자동으로 getter, setter를 내부적으로 생성해준다.
public class SampleVO {

    @ApiParam(value = "email", required = true) // swagger를 위한 설정
    private String userEmail;

    @ApiParam(value = "password", required = true)
    private String userPw;

    @ApiParam(value = "name", required = false)
    private String userName;

}
