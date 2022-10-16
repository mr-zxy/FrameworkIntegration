package com.framework.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("商品实体类")
public class User {
    @ApiModelProperty("商品ID")
    private Integer id;
    private String name;
    private String pwd;
}
