package com.zero;

import com.zero.util.DocumentUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.File;

/**
 * @author yezhaoxing
 * @date 2017/11/10
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class DocumentTest {

    @Test
    public void testUpload() {
        File file = new File("E:\\《亿级流量电商详情页系统实战（第二版）：缓存架构+高可用服务架构+微服务架构》.doc");
        String title = "亿级流量电商详情页系统实战";
        DocumentUtil.createDocument(file, title, "doc", null, null, null);
    }

    @Test
    public void testQuery() {
        DocumentUtil.getDocument("doc-hk9je0dax4pvf6n");
    }
}
