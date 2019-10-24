package com.learn.heap;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Yinevg on 2019/10/24
 * -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 */
public class HeapOOM {
    static class OOMObject {
    }

    public static void main(String[] args) {
        List<OOMObject> list = new LinkedList<OOMObject>();
        while (true) {
            list.add(new OOMObject());
        }
    }
}
