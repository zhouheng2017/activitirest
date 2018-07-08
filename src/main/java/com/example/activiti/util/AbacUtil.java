package com.example.activiti.util;

import com.example.activiti.service.PDPService;
import com.example.activiti.service.PEPService;
import com.example.activiti.service.impl.PDPServiceImpl;
import com.example.activiti.service.impl.PEPServiceImpl;
import org.wso2.balana.ctx.AbstractResult;
import org.wso2.balana.ctx.Attribute;
import org.wso2.balana.ctx.ResponseCtx;
import org.wso2.balana.ctx.xacml3.RequestCtx;
import org.wso2.balana.ctx.xacml3.Result;
import org.wso2.balana.xacml3.Attributes;

import java.net.URISyntaxException;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author: zhouheng
 * @Created: with IntelliJ IDEA.
 * @Description:
 * @Date: 2018-06-25
 * @Time: 11:17
 */
public class AbacUtil {

    private PEPService pepService = new PEPServiceImpl();


    private PDPService pdpService = new PDPServiceImpl();

    public static final String[] DECISIONS = { "Permit", "Deny", "Indeterminate", "NotApplicable"};


    public void setPdpService(PDPService pdpService) {
        this.pdpService = pdpService;
    }

    public Set<String> evaluate(String subjectAttributeValue, String policyLocation, String actionValue) {
        RequestCtx requestCtx = null;
        System.out.println(pepService);
        try {
            requestCtx = pepService.createRequestCtx(subjectAttributeValue, "how2java", actionValue);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

//        System.out.println(requestCtx);


        //获取评估的结果值
        ResponseCtx responseCtx = pdpService.evaluate(requestCtx, policyLocation);

        Set<String> permitResources = new HashSet<String>();
        Set<String> denyResources = new HashSet<String>();


        String decision = "";
        Set<AbstractResult> results  = responseCtx.getResults();
        for(AbstractResult result : results) {
            Set<Attributes> attributesSet = ((Result) result).getAttributes();
            for (Attributes attributes : attributesSet) {
                for (Attribute attribute : attributes.getAttributes()) {
                    if (AbstractResult.DECISION_PERMIT == result.getDecision()) {
                        decision = DECISIONS[result.getDecision()];
                        permitResources.add(attribute.getValue().encode());
                    } else {
                        denyResources.add(attribute.getValue().encode());
                    }
                }
            }


        }
        System.out.println(permitResources);

        return permitResources;
    }
}
