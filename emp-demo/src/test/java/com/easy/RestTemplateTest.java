package com.easy;

import com.mysql.cj.protocol.x.Notice;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.io.InputStream;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @Packge com.easy
 * @Autor linNaibin
 * @Description
 * @Version 1.0
 * @Date 2021/2/4 12:59
 */

// @RunWith(SpringRunner.class)
// @SpringBootTest(classes = AdminApplication.class)
public class RestTemplateTest {
    /**
     * 不带参的get请求
     */
    @Test
    public void restTemplateGetTest() throws IOException {

        String x = "116.331479";
        String y = "39.898057";
        String z = "0";
        String tk = "a92e641c3af7b0925c36209424482979";
        String url = "http://t0.tianditu.gov.cn/img_w/wmts?SERVICE=WMTS&REQUEST=GetTile&VERSION=1.0.0&LAYER=img&STYLE=default&TILEMATRIXSET=w&FORMAT=tiles&TILEMATRIX=" + z + "&TILEROW=" + x + "&TILECOL=" + y + "&tk=" + tk;
        RestTemplate restTemplate = new RestTemplate();
        InputStream notice = restTemplate.getForObject(url, InputStream.class);
        System.out.println(notice.available());


    }
}
