package com.example.xxl_job;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import com.xxl.job.core.log.XxlJobLogger;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@JobHandler(value = "demoHandler")
@Component
@Slf4j
@RequiredArgsConstructor
public class DemoHandler extends IJobHandler {
    private final DemoJobService demoJobService;

    @Override
    public ReturnT<String> execute(String s1) throws Exception {
        XxlJobLogger.log("xxl-job测试任务开始执行。【args: {}】", s1);
        try {
            demoJobService.demoTest(s1);
            XxlJobLogger.log("xxl-job测试任务执行结束。");
            return SUCCESS;
        } catch (Exception e) {
            XxlJobLogger.log("xxl-job测试任务执行出错!", e);
            return FAIL;
        }
    }
}
