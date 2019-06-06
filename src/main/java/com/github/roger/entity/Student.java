package com.github.roger.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
//标注在javaBean类上
@ApiModel(value = "学生实体")
public class Student {

    //用于标注在javaBean的属性或方法上
    @ApiModelProperty(name = "学生ID", dataType = "String", notes = "学生ID")
    private Long id;
    @ApiModelProperty(name = "学生姓名", dataType = "String", notes = "学生姓名")
    private String name;

}
