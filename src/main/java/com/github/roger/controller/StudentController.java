package com.github.roger.controller;

import com.github.roger.entity.Student;
import com.github.roger.mock.StudentMockData;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/student")
//标注在类，表示这个是Swagger资源
@Api(value = "学生服务", description = "学生的基本操作")
public class StudentController {

    //标注在方法上，表示以一个http请求
    @ApiOperation(value = "学生列表服务", notes = "查询所有学生的列表信息")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Student> list() {
        return StudentMockData.list();
    }

    @ApiOperation(value = "根据学生ID查询学生信息",notes = "根据url的id来获取学生信息")
    @ApiImplicitParam(name = "id",value = "学生ID",required = true,dataType = "Long",paramType = "path")
    @RequestMapping(value = "/findOneById/{id}",method = RequestMethod.GET)
    public Student findOneById(@PathVariable("id") Long id) {
        List<Student> studentList = StudentMockData.list();
        for(Student stu : studentList){
            if(stu.getId() == id){
                return stu;
            }
        }
        return null;
    }

    @ApiOperation(value = "根据学生姓名查询学生信息",notes = "根据url中的name来获取学生信息")
    @RequestMapping(value = "/findOneByName/{name}",method = RequestMethod.GET)
    public Student findOneByName(@ApiParam(value = "用户名",type = "String") @PathVariable("name") String name){
        List<Student> studentList = StudentMockData.list();
        for(Student stu : studentList){
            if(stu.getName().equals(name)){
                return stu;
            }
        }
        return null;
    }

    @ApiOperation(value = "根据学生ID和学生姓名查询学生信息")
    @ApiImplicitParams({
                @ApiImplicitParam(name = "id",value = "学生ID",required = true,dataType = "Long",paramType = "query"),
                @ApiImplicitParam(name = "name",value = "学生姓名",required = true,dataType = "String",paramType = "query")
            }
    )
    @RequestMapping(value = "/findOneByIdAndName",method = RequestMethod.POST)
    public Student findOneByIdAndName(@RequestParam Long id,@RequestParam String name){
        List<Student> studentList = StudentMockData.list();
        for(Student stu : studentList){
            if(stu.getName().equals(name) && stu.getId() == id){
                return stu;
            }
        }
        return null;
    }

}
