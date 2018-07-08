package com.example.activiti.service.impl;


import com.example.activiti.authorizationleader.LeaderAttributeFinderModule;
import com.example.activiti.authorizationleader.LeaderResourceFinder;
import com.example.activiti.service.PDPService;
import org.wso2.balana.Balana;
import org.wso2.balana.PDP;
import org.wso2.balana.PDPConfig;
import org.wso2.balana.ctx.ResponseCtx;
import org.wso2.balana.ctx.xacml3.RequestCtx;
import org.wso2.balana.finder.AttributeFinder;
import org.wso2.balana.finder.AttributeFinderModule;
import org.wso2.balana.finder.ResourceFinder;
import org.wso2.balana.finder.ResourceFinderModule;
import org.wso2.balana.finder.impl.FileBasedPolicyFinderModule;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author: zhouheng
 * @Created: with IntelliJ IDEA.
 * @Description:
 * @Date: 2018-06-13
 * @Time: 16:37
 */
public class PDPServiceImpl implements PDPService {

    private static Balana balana;

    private static String  policyLocation;

    public static String getPolicyLocation() {
        return policyLocation;
    }

    public static void setPolicyLocation(String policyLocation) {
        PDPServiceImpl.policyLocation = policyLocation;
    }

    /**
     * 根据传入的请求来进行评估
     *
     * @param requestCtx
     * @return
     */
    public ResponseCtx evaluate(RequestCtx requestCtx, String policyLocation) {
        setPolicyLocation(policyLocation);

        initBalana();
        PDP pdp = getPDPNewInstance();

        Set<String> permitResources = new HashSet<String>();
        Set<String> denyResources = new HashSet<String>();

        ResponseCtx responseCtx = pdp.evaluate(requestCtx);
      /*  AbstractResult result = responseCtx.getResults().iterator().next();

        String strResult = "";
        switch (result.getDecision()) {
            case 0:
                strResult = "permit";
                break;
            case 1:
                strResult = "deny";
                break;
            case 2:
                strResult = "Indeterminate";
                break;
            case 3:
                strResult = "NotApplicable";
                break;

            default:
                strResult = "deny";
        }
*/
        //获取所有的结果

        return responseCtx;
}


    private static void initBalana() {

        try {
//            String policyLocation = (new File(".")).getCanonicalPath() + File.separator + "resources";
//            System.out.println((new File(".")).getCanonicalPath());

//            policyLocation = "E:\\maven\\workspace\\java2\\activitirest\\src\\main\\resources\\balana\\";

            System.setProperty(FileBasedPolicyFinderModule.POLICY_DIR_PROPERTY, getPolicyLocation());
        } catch (Exception e) {
            System.err.println("Can not locate policy repository");
        }
        // create default instance of Balana
        balana = Balana.getInstance();
    }

    /**
     * Returns a new PDP instance with new XACML policies
     *
     * @return a  PDP instance
     */
    private static PDP getPDPNewInstance() {

        PDPConfig pdpConfig = balana.getPdpConfig();

        // registering new attribute finder. so default PDPConfig is needed to change
        AttributeFinder attributeFinder = pdpConfig.getAttributeFinder();
        List<AttributeFinderModule> finderModules = attributeFinder.getModules();
        finderModules.add(new LeaderAttributeFinderModule());
//        finderModules.add(new SampleAttributeFinderModule());
        attributeFinder.setModules(finderModules);

        // registering new resource finder. so default PDPConfig is needed to change
        ResourceFinder resourceFinder = pdpConfig.getResourceFinder();
        List<ResourceFinderModule> resourceModules = resourceFinder.getModules();
        resourceModules.add(new LeaderResourceFinder());
//        resourceModules.add(new HierarchicalResourceFinder());
        resourceFinder.setModules(resourceModules);


        return new PDP(new PDPConfig(attributeFinder, pdpConfig.getPolicyFinder(), resourceFinder, true));
    }

}
