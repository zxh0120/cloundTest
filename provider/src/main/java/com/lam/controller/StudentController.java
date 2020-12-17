package com.lam.controller;

import com.entity.CommonResult;
import com.entity.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class StudentController {

    @GetMapping(value = "/qurery/{name}")
    public String qurery(@PathVariable("name") String name) {
        log.info("provider ---getPost-------------");
        return name + "hello";

    }

    /**
     * 对象来接收参数
     *  https://www.hangge.com/blog/cache/detail_2485.html
     * @param student
     * @return
     */
    @PostMapping(value = "/qureryPost")
    public CommonResult<Student> qureryPost(Student student) {
        log.info("provider ---queryPost-------------");
        CommonResult commonResult = new CommonResult();
        commonResult.setCode(200);
        commonResult.setMessage("ok --- put");
        commonResult.setData(new Student("zxh", 15));
        return commonResult;
    }

    //接收 form-data 格式的 POST 数据： https://www.hangge.com/blog/cache/detail_2485.html
    @PostMapping(value = "/postParam")
    public CommonResult<Student> hello(@RequestParam(name = "name", defaultValue = "xxx") String name,
                                       @RequestParam(name = "age", required = false) Integer age) {
        CommonResult commonResult = new CommonResult();
        commonResult.setCode(200);
        commonResult.setMessage("ok --- postParam");
        commonResult.setData(new Student(name, age));
        return commonResult;
    }
    /*
     *json 作为参数传递，我们可以使用 @requestbody 接收参数，将数据直接转换成对象
     */
    @PutMapping(value = "/queryPut")
    public CommonResult<Student> queryPut( @RequestBody Student student) {
        CommonResult commonResult = new CommonResult();
        commonResult.setCode(200);
        commonResult.setMessage("ok put---");
        commonResult.setData(new Student(student.getName(), student.getAge()));
        return commonResult;

    }
    /*
    *https://blog.csdn.net/qq_35075909/article/details/94005211
    *GET方法怎么传递多个参数
    */
    @DeleteMapping(value = "deleteQurey/{id}/{pkId}")
    public CommonResult<Student> deleteQurey(@PathVariable("id") Integer id, @PathVariable("pkId") Integer pkId) {
        CommonResult commonResult = new CommonResult();
        commonResult.setCode(200);
        commonResult.setMessage("ok ---delete");
        commonResult.setData(new Student("ok --- delete ", id));
        return commonResult;

    }
}
