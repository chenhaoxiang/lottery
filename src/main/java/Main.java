/*
* chenhx
* Copyright (C) 2013-2022 All Rights Reserved.
*/

/**
 * @className Main.java
 * @date 2022-10-25 19:31
 * @version 0.0.1
 * @author chenhx
 * @description 用于验证种子的开奖号码准确性
 */
public class Main{
    /**
     * 以2022年10月14日举例
     * 汇率网站：https://www.chinamoney.com.cn/chinese/homefxrrm/
     * 取美元兑人民币汇率
     2022年10月14日10点美元兑人民币的汇率：7.1679
     2022年10月14日14点美元兑人民币的汇率：7.1697
     2022年10月14日16点美元兑人民币的汇率：7.1815
     2022年10月14日18点美元兑人民币的汇率：7.2004
     * @param args
     */
    public static void main(String[] args) {
        //最大开奖码为665，由于我们是从0开始计数，则为：665+1，一共666个参与抽奖点号码；开3个红包
        int n = 665 +1;
        //种子数；为汇率小数点后四位点拼接
        String seeds = "1679169718152004";
        //要开的中奖号码数量
        int size = 3;
        int winning_t = Math.abs(SHA256Utils.sha256Hex(seeds).hashCode() % n);
        System.out.println("winning_1："+winning_t);
        for (int i = 1; i < size; i++) {
            winning_t = Math.abs(SHA256Utils.sha256Hex(String.valueOf(winning_t)).hashCode() % n);
            System.out.println("winning_"+(i+1)+"："+winning_t);
        }
    }
}
