package com.example.activiti.service.impl;


import com.example.activiti.service.PEPService;
import org.wso2.balana.attr.AttributeValue;
import org.wso2.balana.attr.StringAttribute;
import org.wso2.balana.ctx.Attribute;
import org.wso2.balana.ctx.xacml3.RequestCtx;
import org.wso2.balana.xacml3.Attributes;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author: zhouheng
 * @Created: with IntelliJ IDEA.
 * @Description:
 * @Date: 2018-06-13
 * @Time: 16:06
 */
public class PEPServiceImpl implements PEPService {
    /**
     * 构建subject的请求属性
     *
     * @param subjectAttributeValue 属性的值
     * @return
     */
    private Attributes createSubjectAttribute(String subjectAttributeValue) throws URISyntaxException {
        HashSet attributes = new HashSet();

        // setup the id and value for the requesting subject
        URI subjectId = new URI("urn:oasis:names:tc:xacml:1.0:subject:subject-id");
        StringAttribute stringAttribValue = new StringAttribute(subjectAttributeValue);

        List<AttributeValue> attributeValues = new ArrayList<AttributeValue>();
        attributeValues.add(stringAttribValue);
        Attribute attribute = new Attribute(subjectId, new URI("http://www.w3.org/2001/XMLSchema#string"), null, null, attributeValues, false, 3);


        attributes.add(attribute);
//        attributes.add(new Attribute(subjectId, null, null, stringAttribValue, 1));


        Attributes attributesResult = new Attributes(new URI("urn:oasis:names:tc:xacml:1.0:subject-category:access-subject"), attributes);
        return attributesResult;
    }

    /**
     * 创建资源的属性
     *
     * @param resourceAttributeValue
     * @return
     */
    private Attributes createResourceAttribute(String resourceAttributeValue) throws URISyntaxException {
        HashSet resource = new HashSet();

        // the resource being requested
//        AnyURIAttribute value =
//                new AnyURIAttribute(new URI(resourceAttributeValue));
        StringAttribute stringAttribValue = new StringAttribute(resourceAttributeValue);

        List<AttributeValue> attributeValues = new ArrayList<AttributeValue>();
        attributeValues.add(stringAttribValue);
        Attribute attribute = new Attribute(new URI("urn:oasis:names:tc:xacml:1.0:resource:resource-id"), new URI("http://www.w3.org/2001/XMLSchema#string"), null, null, attributeValues, true, 3);

//        Attribute attributeScope = new Attribute(new URI("urn:oasis:names:tc:xacml:2.0:resource:scope"), null, null, null, new StringAttribute("Descendants"), false, 3);


        List<AttributeValue> attributeValuesScope = new ArrayList<AttributeValue>();
        attributeValuesScope.add(new StringAttribute("Descendants"));
//        Attribute attributeScope = new Attribute(new URI("urn:oasis:names:tc:xacml:1.0:resource:resource-id"), null, null, null, attributeValuesScope, false, 3);
        Attribute attributeScope = new Attribute(new URI("urn:oasis:names:tc:xacml:2.0:resource:scope"), new URI("http://www.w3.org/2001/XMLSchema#string"), null, null, attributeValuesScope, false, 3);

        // create the resource using a standard, required identifier for
        // the resource being requested

        resource.add(attributeScope);
        resource.add(attribute);
       /*
       这里是原来的老代码
       resource.add(
                new Attribute(
                        new URI("urn:oasis:names:tc:xacml:1.0:resource:resource-id"),
                        null,
                        null,
                        value, 1));
        resource.add(new Attribute(new URI("urn:oasis:names:tc:xacml:2.0:resource:scope"), null, null, new StringAttribute("Descendants"), 1));
*/
/*        "<Attribute AttributeId=\"urn:oasis:names:tc:xacml:2.0:resource:scope\" IncludeInResult=\"false\">\n" +
                "<AttributeValue DataType=\"http://www.w3.org/2001/XMLSchema#string\">" + type + "</AttributeValue>\n" +
                "</Attribute>\n" +*/
        Attributes attributes = new Attributes(new URI("urn:oasis:names:tc:xacml:3.0:attribute-category:resource"), resource);
        return attributes;
    }

    /**
     * 创建action的属性
     *
     * @param actionAttributeValue
     * @return
     */
    private Attributes createActionAttribute(String actionAttributeValue) throws URISyntaxException {
        HashSet action = new HashSet();

        // this is a standard URI that can optionally be used to specify
        // the action being requested
        URI actionId = new URI("urn:oasis:names:tc:xacml:1.0:action:action-id");


        List<AttributeValue> attributeValues = new ArrayList<AttributeValue>();
        attributeValues.add(new StringAttribute(actionAttributeValue));
        Attribute attribute = new Attribute(actionId, new URI("http://www.w3.org/2001/XMLSchema#string"), null, null, attributeValues, false, 3);

        action.add(attribute);

        // create the action
//        action.add(
//                new Attribute(actionId, null, null, new StringAttribute(actionAttributeValue), 1));

        Attributes attributes = new Attributes(new URI("urn:oasis:names:tc:xacml:3.0:attribute-category:action"), action);
        return attributes;
    }

    /**
     * @param subjectAttributeValue
     * @param resourceAttributeValue
     * @param actionAttributeValue
     * @return
     * @throws URISyntaxException
     */
    public RequestCtx createRequestCtx(String subjectAttributeValue, String resourceAttributeValue, String actionAttributeValue) throws URISyntaxException {

        Attributes subjectAttribute = createSubjectAttribute(subjectAttributeValue);
        Attributes resourceAttribute = createResourceAttribute(resourceAttributeValue);
        Attributes actionAttribute = createActionAttribute(actionAttributeValue);

        Set set = new HashSet();
        set.add(subjectAttribute);
        set.add(resourceAttribute);
        set.add(actionAttribute);
        RequestCtx request =
                new RequestCtx(
                        set, null);

        request.encode(System.out);
        return request;
    }
}
