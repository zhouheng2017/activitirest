package com.example.activiti.chapter6.util;

import org.activiti.engine.ProcessEngineConfiguration;

/**
 * @author zhouheng
 */
public class InitEngineeDatabase {

    public static void main(String[] args) {
        ProcessEngineConfiguration.createProcessEngineConfigurationFromResourceDefault().buildProcessEngine();
    }

}
