package com.easy;

import com.easy.service.EasyService;
import com.easy.utils.SpringContextUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Packge com.easy.gis
 * @Autor linNaibin
 * @Description
 * @Version 1.0
 * @Date 2021/2/3 14:10
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AdminApplication.class)
public class EasyTest {

    @Test
    public void cashFlowDataAdapter() {

        EasyService dataAdapter = SpringContextUtil.getBean(EasyService.class);
        dataAdapter.free();

    }

}
