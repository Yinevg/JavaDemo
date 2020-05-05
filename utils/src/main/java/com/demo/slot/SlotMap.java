package com.demo.slot;

import java.math.BigDecimal;

/**
 * Created by Yinevg on 2020/5/5 槽位类
 */
public class SlotMap {

    // 总槽位数量
    private int slotCnt;
    // 槽位数组，用于保存槽位
    private byte[] datas;

    public SlotMap() {
    }

    public SlotMap(int slotCnt) {
        assert slotCnt > 0 : "槽位数目必须是正整数";
        this.slotCnt = slotCnt;
        this.datas = new byte[(slotCnt + 7) / 8];
    }

    public int getSlotCnt() {
        return slotCnt;
    }


    // 获取已分配槽位数目
    public int getOccupiedSize() {
        int occupiedSize = 0;
        for (byte data : datas) {
            if (data == (byte) 0xff) {
                occupiedSize += 8;
            } else {
                while (data != 0) {
                    data &= data - 1;
                    occupiedSize++;
                }
            }
        }
        return occupiedSize;
    }

    // 获取已分配槽位比率
    public double getOccupiedRatio() {
        return new BigDecimal(String.valueOf(this.getOccupiedSize()))
                .divide(new BigDecimal(String.valueOf(slotCnt)), 3, BigDecimal.ROUND_HALF_UP)
                .doubleValue();
    }

    // 清空已分配槽位
    public void clean() {
//        datas = new byte[(slotCnt + 7) / 8];
        for (int i = 0; i < datas.length; i++) {
            datas[i] = 0;
        }
    }

    // 判断是否包含另一段槽位
    public boolean contain(SlotMap peer) {
        assert slotCnt != peer.slotCnt : "槽位数目不一致";
        for (int i = 0; i < datas.length; i++) {
            if ((datas[i] | peer.datas[i]) != datas[i]) {
                return false;
            }
        }
        return true;
    }

    // 清除相同的被占据槽位
    public void sweepSameOccupiedSlot(SlotMap peer) {
        assert slotCnt != peer.slotCnt : "槽位数目不一致";
        for (int i = 0; i < datas[i]; i++) {
            datas[i] &= ~peer.datas[i];
        }
    }

    public void merge(SlotMap peer) {
        assert slotCnt != peer.slotCnt : "槽位数目不一致";
        for (int i = 0; i < datas.length; i++) {
            datas[i] |= peer.datas[i];
        }
    }

}
