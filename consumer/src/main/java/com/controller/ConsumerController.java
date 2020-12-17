package com.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.entity.CommonResult;
import com.entity.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
class ConsumerController {
    @Resource
    private RestTemplate restTemplate;

    String url = "http://localhost:8080";

    @GetMapping(value = "/test/query/{name}")
    public String qurey(@PathVariable("name") String name) {
        log.info("----------qurey----------");
        return restTemplate.getForObject(url + "/qurery/" + name, String.class);
    }

    @GetMapping(value = "/test/queryPost")
    public CommonResult<Student> queryPost(Student student) {
        student.setName("consumer");
        student.setAge(26);
        return restTemplate.postForObject(url + "/qureryPost", student, CommonResult.class);
    }

    /**
     * RestTemplate post方式提交表单数据
     * https://www.cnblogs.com/zhengqun/p/7508865.html
     */
    @PostMapping(value = "/test/queryPostParam")
    public CommonResult<Student> queryPostParam
    (@RequestParam(name = "name", defaultValue = "xxx") String name,
     @RequestParam(name = "age", required = false) Integer age) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, Object> map = new LinkedMultiValueMap<String, Object>();
        map.add("name", name);
        map.add("age", age);

        HttpEntity<MultiValueMap<String, Object>> request = new HttpEntity<MultiValueMap<String, Object>>(map, headers);
        return restTemplate.postForObject(url + "/postParam", request, CommonResult.class);
    }

    /**
     * DELETE、PUT 没有返回值
     * 用 exchage
     * https://www.cnblogs.com/wwct/p/12333497.html
     * 备用
     * https://blog.csdn.net/uotail/article/details/86255120
     *
     * @param student
     * @return
     */
    @PutMapping(value = "/test/queryPut")
    public CommonResult<Student> queryPut(@RequestBody Student student) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        // String json = "{\"name\": \"zxh1111\",\"age\": 123}";
        JSONObject jsonObject = (JSONObject) JSONObject.toJSON(student);
        HttpEntity<String> entity = new HttpEntity<>(jsonObject.toString(), headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url + "/queryPut", HttpMethod.PUT, entity, String.class);
        String result = responseEntity.getBody();
        System.out.println(result);
        JSONObject resultJson = JSONObject.parseObject(result);
        CommonResult commonResult = JSON.toJavaObject(resultJson, CommonResult.class);
        return commonResult;
    }

    /**
     * url传递多个参数
     * https://blog.csdn.net/qq_35075909/article/details/94005211
     * <p>
     * RestTemplate的PUT请求和DELETE请求
     * https://blog.csdn.net/chengqiuming/article/details/81137871
     * <p>
     * <p>
     * RestTemplate的exchange()方法,解决put和delete请求拿不到返回值的问题
     * https://www.cnblogs.com/wwct/p/12333497.html
     *
     * @param id
     * @param pkId
     * @return
     */
    @DeleteMapping(value = "/test/deleteQury/id/{id}/pkId/{pkId}")
    public CommonResult<Student> deleteQury(@PathVariable("id") Integer id,
                                            @PathVariable("pkId") Integer pkId) {
        System.out.println("---deleteQury--------ok");

        //不需要返回值
        //restTemplate.delete(url + "/deleteQurey/{id}/{pkId}", id, pkId);

        Map<String, Object> map = new HashMap<>();
        map.put("id", 1);
        map.put("pkId", 222);
        ResponseEntity<String> resp = restTemplate.exchange(url + "/deleteQurey/{id}/{pkId}",
                HttpMethod.DELETE, null, String.class, map);
        System.out.println(resp.getBody());
        JSONObject resultJson = JSONObject.parseObject(resp.getBody());
        CommonResult commonResult = JSON.toJavaObject(resultJson, CommonResult.class);
        return commonResult;
    }


}
