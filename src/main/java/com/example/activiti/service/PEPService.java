package com.example.activiti.service;

import org.wso2.balana.ctx.xacml3.RequestCtx;

import java.net.URISyntaxException;

/**
 * @Author: zhouheng
 * @Created: with IntelliJ IDEA.
 * @Description: 构建请求的service
 * @Date: 2018-06-13
 * @Time: 15:37
 */
public interface PEPService {


    /**
     * 传入属性，获取xacml属性的构建
     * @param subjectAttributeValue
     * @param resourceAttributeValue
     * @param actionAttributeValue
     * @return
     */
    RequestCtx createRequestCtx(String subjectAttributeValue, String resourceAttributeValue, String actionAttributeValue) throws URISyntaxException;



}
