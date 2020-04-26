package com.demo.multi;

import java.util.Map;

/**
 * Created by Yinevg on 2020/4/26 配置信息
 */
public class MultiConfiguration<T> {

    // 数据源配置
    private Map<String, T> dataSourceMap;

    public T getDataSource(String key) {
        return dataSourceMap.getOrDefault(key, null);
    }

    public Map<String, T> getDataSourceMap() {
        return dataSourceMap;
    }

    public void setDataSourceMap(Map<String, T> dataSourceMap) {
        this.dataSourceMap = dataSourceMap;
    }
}
