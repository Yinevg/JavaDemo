package com.demo.multi;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Yinevg on 2020/4/26
 */
public class MultiDataSource extends AbstractRoutingDataSource {

    public MultiDataSource() {
    }

    public <T> MultiDataSource(MultiConfiguration<T> multiConfiguration) {
        // 默认数据源，targetDataSources中找不到时使用该数据源
        this.setDefaultTargetDataSource(multiConfiguration.getDataSource(MultiConstant.DEFAULT_DATA_SOURCE));
        // 配置多数据源
        Map<Object, Object> dataSourceMap = new HashMap<>(multiConfiguration.getDataSourceMap().size() - 1);
        multiConfiguration.getDataSourceMap().forEach((dataSourceKey, dataSource) -> {
            if (MultiConstant.DEFAULT_DATA_SOURCE.equals(dataSourceKey)) {
                return;
            }
            dataSourceMap.put(dataSourceKey, dataSource);
        });
        this.setTargetDataSources(dataSourceMap);
    }

    @Override
    protected Object determineCurrentLookupKey() {
        return null;
    }
}
