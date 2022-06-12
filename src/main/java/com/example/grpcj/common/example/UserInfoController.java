package com.example.grpcj.common.example;

import com.example.grpcj.common.gen.School;
import com.example.grpcj.common.gen.UserInfo;
import com.example.grpcj.kafka.KafkaProducer;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class UserInfoController {
    @Resource
    private KafkaProducer producer;

    @RequestMapping(value = "/addUserInfo", method = RequestMethod.GET)
    public String addUserInfo(@RequestParam(value = "id") int id,
                             @RequestParam(value = "name") String name){

        UserInfo userInfo = UserInfo.newBuilder()
                .setId(id)
                .setName(name)
                .setAge(111)
                .setSchool(School.newBuilder()
                        .setAddress("上海")
                        .setSchoolName("华东师范大学")
                        .build())
                .build();
        boolean b = producer.produce(userInfo);
        if (b){
            return "OK";
        }
        return "Fail";
    }
}
