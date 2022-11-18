package com.ddit.sample.vo;

import java.util.Date;

import io.swagger.annotations.ApiParam;
import lombok.Data;

@Data // lombok이 자동으로 getter, setter를 내부적으로 생성해준다.
public class SampleVO {

    @ApiParam(value = "boardId", required = true) // swagger를 위한 설정
    private String boardId;

    @ApiParam(value = "userId", required = true)
    private Long userId;

    @ApiParam(value = "boardId", required = true)
    private String boardTitle;

    @ApiParam(value = "boardContents", required = true)
    private String boardContents;

    @ApiParam(value = "boardViews", required = true)
    private Long boardViews;

    @ApiParam(value = "createAt", required = true)
    private Date createAt;

    @ApiParam(value = "updateAt", required = true)
    private Date updateAt;
    
}
