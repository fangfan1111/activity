package com.huazx.processDefinition;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.repository.Deployment;
import org.junit.Test;

public class ProcessDefinitionTest {

    ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

    /**
     * 部署流程定义
     */
    @Test
    public void deploymentProcessDefinition() {

        Deployment deployment = processEngine.getRepositoryService()//与流程定义和部署对象相关的service
                .createDeployment()//创建一个部署对象
                .name("helloWorld入门儿程序")//添加部署名称
                .addClasspathResource("diagram/helloWorld.bpmn")//从classpath的资源中加载，一次只能加载一个文件
                .addClasspathResource("diagram/helloWorld.png")//从classpath的资源中加载，一次只能加载一个文件
                .deploy();//完成部署
        System.out.println("############################################");
        System.out.println("部署id：" + deployment.getId() + "\n部署name：" + deployment.getName());//id=1,name=helloWorld入门儿程序
        System.out.println("############################################");
    }

}
