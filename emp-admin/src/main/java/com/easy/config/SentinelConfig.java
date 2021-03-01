package com.easy.config;

import com.alibaba.csp.sentinel.annotation.aspectj.SentinelResourceAspect;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRule;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRuleManager;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * @Packge com.easy.config
 * @Autor linNaibin
 * @Description Sentinel 规则
 * @Version 1.0
 * @Date 2021/3/1 16:23
 */
@Configuration
public class SentinelConfig {

    public static final String COMMON_RESOURCE = "EASY_RESOURCE";

    @Bean
    public SentinelResourceAspect sentinelResourceAspect() {
        return new SentinelResourceAspect();
    }


    // 配置限流规则
    @PostConstruct
    private void initFlowRules() throws Exception {
        FlowRule rule1 = new FlowRule();
        rule1.setResource(COMMON_RESOURCE);
        rule1.setGrade(RuleConstant.FLOW_GRADE_QPS);
        rule1.setCount(1);   // 每秒调用最大次数为 1 次

        List<FlowRule> rules = new ArrayList<>();
        rules.add(rule1);

        // 将控制规则载入到 Sentinel
        FlowRuleManager.loadRules(rules);
    }

    // 配置降级、熔断规则
    @PostConstruct
    private void initDegradeRule() throws Exception {
        DegradeRule degradeRule = new DegradeRule();
        degradeRule.setResource(COMMON_RESOURCE);
        // 异常次数超过5的时候, 进行熔断
        degradeRule.setCount(2);
        //  degradeRule.setCount(1);   // 每秒调用最大次数为 1 次
        degradeRule.setGrade(RuleConstant.DEGRADE_GRADE_EXCEPTION_COUNT);
        degradeRule.setTimeWindow(50); // 设置降级的时间，以s为单位

        List<DegradeRule> rules = new ArrayList<>();
        rules.add(degradeRule);

        // 将规则载入到 Sentinel
        DegradeRuleManager.loadRules(rules);
    }
}
