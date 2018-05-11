package com.zjgt.service;

import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

import javax.jws.WebService;

/**
 * @Author: zhouheng
 * @Created: with IntelliJ IDEA.
 * @Description: 发布webService需要编写Service类
 * @Date: 2018-05-09
 * @Time: 17:02
 */
@WebService
public class PersonService extends ServerResource {
    /**
     * @get 来标识正式一个HTTP的GET方法
     * @return
     */
    @Get
    public Person getPerson() {

        Person p = new Person();
        p.setName("crayyit");
        p.setAge(30);
        return p;
    }


}







