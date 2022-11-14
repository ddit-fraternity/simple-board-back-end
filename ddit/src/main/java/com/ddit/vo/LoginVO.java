package com.ddit.vo;

import io.swagger.annotations.ApiParam;
import lombok.Data;

@Data
public class LoginVO {
	
    @ApiParam(value = "authJwt", required = false)
    private String authJwt;
    
    @ApiParam(value = "refreshJwt", required = false)
    private String refreshJwt;
}
