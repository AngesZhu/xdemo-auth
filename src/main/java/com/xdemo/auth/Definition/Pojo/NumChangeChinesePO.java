package com.xdemo.auth.Definition.Pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class NumChangeChinesePO {

    @ApiModelProperty("汉字")
    private String chinese;

    @ApiModelProperty("请求结果")
    private Number code;

    @ApiModelProperty("描述")
    private String description;

    public String getChinese() {
        return chinese;
    }

    public Number getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public void setChinese(String chinese) {
        this.chinese = chinese;
    }

    public void setCode(Number code) {
        this.code = code;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
