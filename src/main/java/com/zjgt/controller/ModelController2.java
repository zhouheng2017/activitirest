package com.zjgt.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: zhouheng
 * @Created: with IntelliJ IDEA.
 * @Description:
 * @Date: 2018-05-04
 * @Time: 14:56
 */
@Controller
@RequestMapping("model2")
public class ModelController2 {

    @Resource
    private RepositoryService repositoryService;

    @RequestMapping("create2")
    public void create(HttpServletRequest request, HttpServletResponse response) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            ObjectNode editorNode = objectMapper.createObjectNode();
            editorNode.put("id", "abcabc");
            editorNode.put("resourceId", "abcabca");
            ObjectNode stencilSetNode = objectMapper.createObjectNode();
            stencilSetNode.put("namespace", "http://b3mn.org/stencilset/bpmn2.0#");
            editorNode.set("stencilset", stencilSetNode);

            ObjectNode modelObjectNode = objectMapper.createObjectNode();
            modelObjectNode.put("name", "LLLLLLL");
            modelObjectNode.put("revision", 1);
            modelObjectNode.put("description", "没有描述");

            Model modelData = repositoryService.newModel();
            modelData.setCategory(null);
            modelData.setDeploymentId(null);
            modelData.setKey(null);
            modelData.setMetaInfo(modelObjectNode.toString());
            modelData.setName("流程名称");
            modelData.setTenantId("");
            modelData.setVersion(1);

            //保存模型
            repositoryService.saveModel(modelData);
            repositoryService.addModelEditorSource(modelData.getId(), editorNode.toString().getBytes("utf-8"));
            response.sendRedirect(request.getContextPath() + "/modeler.html?modelId=" + modelData.getId());
        } catch (Exception e) {
            System.out.println("创建模型失败：");
        }
    }

}

