package com.example.grpcj.common.example;

import com.example.grpcj.common.gen.School;
import com.example.grpcj.common.gen.UserInfo;
import com.example.grpcj.kafka.producer.AddUserInfoProducer;
import com.example.grpcj.kafka.producer.DeleteUserInfoProducer;
import com.example.grpcj.kafka.producer.GetUserInfoProducer;
import com.example.grpcj.kafka.producer.UpdateUserInfoProducer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class UserInfoController {
    @Resource
    private AddUserInfoProducer addUserInfoProducer;
    @Resource
    private DeleteUserInfoProducer deleteUserInfoProducer;
    @Resource
    private UpdateUserInfoProducer updateUserInfoProducer;
    @Resource
    private GetUserInfoProducer getUserInfoProducer;

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
        boolean b = addUserInfoProducer.produce(userInfo);
        if (b){
            return "OK";
        }
        return "Fail";
    }

    @RequestMapping(value = "/deleteUserInfo", method = RequestMethod.GET)
    public String deleteUserInfo(@RequestParam(value = "id") int id,
                              @RequestParam(value = "name") String name){

        UserInfo userInfo = UserInfo.newBuilder()
                .setId(id)
                .setName(name)
                .build();
        boolean b = deleteUserInfoProducer.produce(userInfo);
        if (b){
            return "OK";
        }
        return "Fail";
    }

    @RequestMapping(value = "/updateUserInfo", method = RequestMethod.GET)
    public String updateUserInfo(@RequestParam(value = "id") int id,
                              @RequestParam(value = "name") String name){

        UserInfo userInfo = UserInfo.newBuilder()
                .setId(id)
                .setName(name)
                .setAge(12111)
                .setSchool(School.newBuilder()
                        .setAddress("上海11")
                        .setSchoolName("华东师范大学111")
                        .build())
                .build();
        boolean b = updateUserInfoProducer.produce(userInfo);
        if (b){
            return "OK";
        }
        return "Fail";
    }

    @RequestMapping(value = "/getUserInfo", method = RequestMethod.GET)
    public String getUserInfo(@RequestParam(value = "id") int id,
                              @RequestParam(value = "name") String name){

        UserInfo userInfo = UserInfo.newBuilder()
                .setId(id)
                .setName(name)
                .build();
        boolean b = getUserInfoProducer.produce(userInfo);
        if (b){
            return "OK";
        }
        return "Fail";
    }
}
