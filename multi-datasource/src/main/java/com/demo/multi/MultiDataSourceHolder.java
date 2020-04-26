package com.demo.multi;

/**
 * Created by Yinevg on 2020/4/26 数据源holder，保存当前线程要使用的数据源
 */
public class MultiDataSourceHolder {

    private static final ThreadLocal<String> DATA_SOURCE_HOLDER = new ThreadLocal<>();

    public static void set(String dataSource) {
        DATA_SOURCE_HOLDER.set(dataSource);
    }

    public static String get() {
        return DATA_SOURCE_HOLDER.get();
    }

    public static void clear() {
        DATA_SOURCE_HOLDER.remove();
    }
}
