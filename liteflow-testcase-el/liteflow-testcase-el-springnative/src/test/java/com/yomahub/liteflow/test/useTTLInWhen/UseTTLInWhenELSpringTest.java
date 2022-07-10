package com.yomahub.liteflow.test.useTTLInWhen;

import com.yomahub.liteflow.core.FlowExecutor;
import com.yomahub.liteflow.flow.LiteflowResponse;
import com.yomahub.liteflow.slot.DefaultContext;
import com.yomahub.liteflow.test.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * 在when异步节点的情况下去拿ThreadLocal里的测试场景
 * @author Bryan.Zhang
 * @since 2.6.3
 */
@RunWith(SpringRunner.class)
@ContextConfiguration("classpath:/useTTLInWhen/application.xml")
public class UseTTLInWhenELSpringTest extends BaseTest {

    @Resource
    private FlowExecutor flowExecutor;

    @Test
    public void testUseTTLInWhen() throws Exception{
        LiteflowResponse response = flowExecutor.execute2Resp("chain1", "arg");
        DefaultContext context = response.getFirstContextBean();
        Assert.assertEquals("hello,b", context.getData("b"));
        Assert.assertEquals("hello,c", context.getData("c"));
        Assert.assertEquals("hello,d", context.getData("d"));
        Assert.assertEquals("hello,e", context.getData("e"));
        Assert.assertEquals("hello,f", context.getData("f"));
    }
}
