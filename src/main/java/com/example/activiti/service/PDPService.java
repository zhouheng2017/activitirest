package com.example.activiti.service;

import org.wso2.balana.ctx.ResponseCtx;
import org.wso2.balana.ctx.xacml3.RequestCtx;

/**
 * @Author: zhouheng
 * @Created: with IntelliJ IDEA.
 * @Description:
 * @Date: 2018-06-13
 * @Time: 16:35
 */
public interface PDPService {

    /**
     * 根据传入的请求来进行评估
     * @param requestCtx
     * @return
     */
    ResponseCtx evaluate(RequestCtx requestCtx, String policyLocation);
}
