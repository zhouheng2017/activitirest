package com.example.activiti.listener;

import com.example.activiti.util.AbacUtil;
import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;
import org.activiti.engine.identity.User;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Set;

/**
 * @Author: zhouheng
 * @Created: with IntelliJ IDEA.
 * @Description:
 * @Date: 2018-06-22
 * @Time: 14:25
 */

public class TaskListenerImpl implements TaskListener {



//    @Autowired
//    private HttpSession session;

    AbacUtil abacUtil = new AbacUtil();

    @Override
    public void notify(DelegateTask delegateTask) {

        //获取session中的user信息
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        User user = (User) WebUtils.getSessionAttribute(request, "user");

//        delegateTask.addCandidateUser("zhouheng");
        //构建xacml的请求
//        User user = UserUtil.getUserFromSession(session);
//

//        System.out.println(user.getId()+"+++++++++++++++");

//        String policyLocation = "E:\\maven\\workspace\\java2\\activitirest\\src\\main\\resources\\balana";

        String policyLocation = "E:\\maven\\workspace\\java2\\activitirest\\src\\main\\resources\\directory";
        //调用评估的结果获取可以访问的结果值
        Set<String> evaluate = abacUtil.evaluate(user.getId(), policyLocation, "operate");

        for (String s : evaluate) {

            //动态的添加到组中，动态给定
            delegateTask.addCandidateGroup(s);
        }
//        找到对应的组织id

//        通过组织id知道对应的经理
//        并将对应的经理组放到group中

    }
}
