package com.yomahub.liteflow.test.subflow.cmp2;

import com.yomahub.liteflow.core.NodeComponent;
import org.springframework.stereotype.Component;

import static com.yomahub.liteflow.test.subflow.ImplicitSubFlowELSpringTest.RUN_TIME_SLOT;


@Component("f")
public class FCmp extends NodeComponent {
    @Override
    public void process() throws Exception {

        RUN_TIME_SLOT.add(this.getSlot().getRequestId());

        System.out.println("Fcomp executed!");
    }
}
