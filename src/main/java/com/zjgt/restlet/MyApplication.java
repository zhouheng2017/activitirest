package com.zjgt.restlet;

import com.zjgt.service.PersonService;
import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.routing.Router;

/**
 * @Author: zhouheng
 * @Created: with IntelliJ IDEA.
 * @Description:
 * @Date: 2018-05-09
 * @Time: 17:11
 */
public class MyApplication extends Application {

    /**
     * 经过以下两个步骤，简单的rest风格的WebService就发布了
     * @return
     */
    @Override
    public Restlet createInboundRoot() {
        //创建Router， Rounter是Restlet的子类
        Router router = new Router(getContext());
        //绑定rui与资源类
        router.attach("/person", PersonService.class);

        return router;
    }
}
