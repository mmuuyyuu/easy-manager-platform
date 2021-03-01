package com.easy.config.param;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

/**
 * @Packge com.easy.config.param
 * @Autor linNaibin
 * @Description
 * @Version 1.0
 * @Date 2021/1/13 16:18
 */
@Configuration
@ConfigurationProperties(prefix = "thread-pool")
public class ConfigParameterServer {

    private Map<String, Object> configMap;

    public ConfigParameterServer() {
    }


    public Object get(String key) {
        return this.configMap.get(key);
    }

    public int getAsInt(String key) {
        Object r = this.get(key);
        if (r == null) {
            return 0;
        }
        return Integer.parseInt(String.valueOf(r));
    }

    public long getAsLong(String key) {
        Object r = this.get(key);
        if (r == null) {
            return 0l;
        }
        return Long.valueOf(String.valueOf(r));
     }

    public String getAsString(String key) {
        return String.valueOf(this.get(key));
    }

    public Map<String, Object> getConfigMap() {
        return configMap;
    }

    public void setConfigMap(Map<String, Object> configMap) {
        this.configMap = configMap;
    }
}

