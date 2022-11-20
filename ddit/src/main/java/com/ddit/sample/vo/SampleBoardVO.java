package com.ddit.sample.vo;

import com.ddit.entity.SampleBoard;

import io.swagger.annotations.ApiParam;
import lombok.Data;

@Data // lombok이 자동으로 getter, setter를 내부적으로 생성해준다.
public class SampleBoardVO {

    @ApiParam(value = "sbId", required = true) // swagger를 위한 설정
    private Long sbId;

    @ApiParam(value = "sbTitle", required = true)
    private String sbTitle;

    @ApiParam(value = "sbContents", required = true)
    private String sbContents;

    @ApiParam(value = "sbViews", required = true)
    private Long sbViews;

    @ApiParam(value = "creatAt", required = true)
    private String createAt;

    @ApiParam(value = "updateAt", required = true)
    private String updateAt;
    
    public SampleBoardVO(SampleBoard sampleBoard){
        this.sbId = sampleBoard.getSbId();
        this.sbTitle = sampleBoard.getSbTitle();
        this.sbContents = sampleBoard.getSbContents();
        this.sbViews = sampleBoard.getSbViews();
        this.createAt = sampleBoard.getCreateAt();
        this.updateAt = sampleBoard.getUpdateAt();
    }

}
