package com.xdemo.auth.Definition.Pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class NumChangeChineseDTO {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "需要转换的数字", required = true)
    private Integer num;

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getNum() {
        return num;
    }
}
