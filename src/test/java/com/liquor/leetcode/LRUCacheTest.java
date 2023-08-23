package com.liquor.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LRUCacheTest {

    @Test
    void testLRUCache() {
        var lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        var res1 = lRUCache.get(1);    // 返回 1
        Assertions.assertEquals(res1, 1);
        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        var res_1 = lRUCache.get(2);    // 返回 -1 (未找到)
        Assertions.assertEquals(res_1, -1);
        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        var res_1_1 = lRUCache.get(1);    // 返回 -1 (未找到)
        Assertions.assertEquals(res_1_1, -1);
        var res3 = lRUCache.get(3);    // 返回 3
        Assertions.assertEquals(res3, 3);
        var res4 = lRUCache.get(4);    // 返回 4
        Assertions.assertEquals(res4, 4);
    }

}