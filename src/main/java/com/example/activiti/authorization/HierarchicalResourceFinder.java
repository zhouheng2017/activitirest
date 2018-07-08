/*
*  Copyright (c) WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
*
*  WSO2 Inc. licenses this file to you under the Apache License,
*  Version 2.0 (the "License"); you may not use this file except
*  in compliance with the License.
*  You may obtain a copy of the License at
*
*    http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing,
* software distributed under the License is distributed on an
* "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
* KIND, either express or implied.  See the License for the
* specific language governing permissions and limitations
* under the License.
*/

package com.example.activiti.authorization;

import org.wso2.balana.Balana;
import org.wso2.balana.attr.AttributeValue;
import org.wso2.balana.ctx.EvaluationCtx;
import org.wso2.balana.finder.ResourceFinderModule;
import org.wso2.balana.finder.ResourceFinderResult;

import java.net.URI;
import java.util.HashSet;
import java.util.Set;

/**
 * Sample resource finder for finding hierarchical resources under the root node
 */
public class HierarchicalResourceFinder extends ResourceFinderModule {

    private final static String DATA_TYPE = "http://www.w3.org/2001/XMLSchema#string" ;

    @Override
    public boolean isChildSupported() {
        return true;
    }

    @Override
    public boolean isDescendantSupported() {
        return true;
    }

    @Override
    public ResourceFinderResult findChildResources(AttributeValue parentResourceId, EvaluationCtx context) {

        ResourceFinderResult result = new ResourceFinderResult();

        if(!DATA_TYPE.equals(parentResourceId.getType().toString())){
            return result;
        }

        if("how2java".equals(parentResourceId.encode())){
            Set<AttributeValue> set = new HashSet<AttributeValue>();
            try{
                set.add(Balana.getInstance().getAttributeFactory().createValue(new URI(DATA_TYPE), "user"));
                set.add(Balana.getInstance().getAttributeFactory().createValue(new URI(DATA_TYPE), "user_role"));
                set.add(Balana.getInstance().getAttributeFactory().createValue(new URI(DATA_TYPE), "role"));
            } catch (Exception e) {
                // just ignore
            }
            result = new ResourceFinderResult(set);
        }

        return result;
    }


    @Override
    public ResourceFinderResult findDescendantResources(AttributeValue parentResourceId, EvaluationCtx context) {

        ResourceFinderResult result = new ResourceFinderResult();

        if(!DATA_TYPE.equals(parentResourceId.getType().toString())){
            return result;
        }

        if("how2java".equals(parentResourceId.encode())){
            Set<AttributeValue> set = new HashSet<AttributeValue>();
            try{
/*                set.add(Balana.getInstance().getAttributeFactory().createValue(new URI(DATA_TYPE), "user"));
                set.add(Balana.getInstance().getAttributeFactory().createValue(new URI(DATA_TYPE), "role"));
                set.add(Balana.getInstance().getAttributeFactory().createValue(new URI(DATA_TYPE), "user_role"));*/
/*                set.add(Balana.getInstance().getAttributeFactory().createValue(new URI(DATA_TYPE), "role:role_name:manager"));
                set.add(Balana.getInstance().getAttributeFactory().createValue(new URI(DATA_TYPE), "user_role:role_id:4"));
                set.add(Balana.getInstance().getAttributeFactory().createValue(new URI(DATA_TYPE), "user_role:role_id:2"));
                set.add(Balana.getInstance().getAttributeFactory().createValue(new URI(DATA_TYPE), "user_role:role_id:1"));
                set.add(Balana.getInstance().getAttributeFactory().createValue(new URI(DATA_TYPE), "user_role:role_id:3"));
                set.add(Balana.getInstance().getAttributeFactory().createValue(new URI(DATA_TYPE), "user_role:role_id:7"));
                set.add(Balana.getInstance().getAttributeFactory().createValue(new URI(DATA_TYPE), "role:role_id:11"));*/



                set.add(Balana.getInstance().getAttributeFactory().createValue(new URI(DATA_TYPE), "organizationRichfit"));
                set.add(Balana.getInstance().getAttributeFactory().createValue(new URI(DATA_TYPE), "organizationChangqing"));

            } catch (Exception e) {
                // just ignore
            }
            result = new ResourceFinderResult(set);
        }
        return result;
    }
}
