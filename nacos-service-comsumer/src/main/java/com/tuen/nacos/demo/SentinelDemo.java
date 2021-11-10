package com.tuen.nacos.demo;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphO;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import com.google.common.collect.Lists;

import java.util.List;

public class SentinelDemo {

    /**
     * 定义访问资源方式一
     */
    private static void doSomething() {
        try (Entry entry = SphU.entry("doSomething")) { // 定义一个资源来实现流控制的逻辑
            //业务逻辑处理
            System.out.println("Hello world" + System.currentTimeMillis());
        } catch (BlockException e) {
            //处理被流控制的逻辑
            e.printStackTrace();
        }
    }

    /**
     * 定义访问资源方式二
     */
    private static void doSomething2() {
        if (SphO.entry("doSomething2")) {
            try { // 定义一个资源来实现流控制的逻辑
                //业务逻辑处理
                System.out.println("Hello world doSomething2" + System.currentTimeMillis());
            } finally {
                //资源使用之后调用Sph0.exit()释放，否则会导致调用链异常，抛出ErrorEntryFreeException
                SphO.exit();
            }
        } else {
            //资源被限流
            System.out.println("资源被限流");
        }
    }
    /**
     * 定义访问资源方式三
     */
    @SentinelResource(value = "getUserById", blockHandler = "blockHandlerForUser")
    private static void getUserById(String useId) {
        System.out.println("user id: " + useId);
    }


    /**
     * 限流后的处理逻辑
     */
    private static void blockHandlerForUser(String useId, BlockException e){
        System.out.println("block handle" + useId);
        return;
    }


    /**
     * 定义限流规则
     */
    private static void initFlowRules(String resource) {
        List<FlowRule> rules = Lists.newArrayList();
        FlowRule flowRule = new FlowRule();
        flowRule.setResource(resource);
        flowRule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        flowRule.setCount(20);
        rules.add(flowRule);
        FlowRuleManager.loadRules(rules);
    }

    public static void main(String[] args) {
        initFlowRules("getUserById");
        while (true) {
            getUserById("shuliang.duan");
        }
    }
}
