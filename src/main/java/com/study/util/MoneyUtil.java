package com.study.util;

import java.text.DecimalFormat;

/**
 * Created by gf on 2018/10/16.
 */
public class MoneyUtil {
    /**
     * 1 将数字金额转化成汉语字符串 注意：使用该方法只能精确到分:555555.55
     * 
     * @param money
     *            12----->壹拾贰
     * @return String
     */
    public static String convertMoneyToChinese(String money) {
        if (money == null || money.equals("")) {
            return "您转化的金额是空对象";// 空对象返回空字符串
        }
        /**
         * 
         * 判断正负数的标志 flag=false:负数 flag=true:正数
         */
        boolean flag = true;
        if (money.substring(0, 1).equals("-")) {
            money = money.substring(1, money.length());
            flag = false;
        }
        String b = "壹贰叁肆伍陆柒捌玖拾";
        String moneySum = money;
        if (moneySum.substring(moneySum.indexOf("."), moneySum.length())
                .length() < 3) {
            moneySum = moneySum + "0";
        }
        // 将钱数补齐为15位
        while (moneySum.length() < 16) {
            moneySum = " " + moneySum;
        }
        // 将超出15位的钱数截取为15位
        if (moneySum.length() > 16) {
            moneySum = moneySum.substring(moneySum.length() - 16, moneySum
                    .length());
        }
        // 获取钱各位的数值
        String x1 = moneySum.substring(0, 1);
        String x2 = moneySum.substring(1, 2);
        String x3 = moneySum.substring(2, 3);
        String x4 = moneySum.substring(3, 4);
        String x5 = moneySum.substring(4, 5);
        String x6 = moneySum.substring(5, 6);
        String x7 = moneySum.substring(6, 7);
        String x8 = moneySum.substring(7, 8);
        String x9 = moneySum.substring(8, 9);
        String x10 = moneySum.substring(9, 10);
        String x11 = moneySum.substring(10, 11);
        String x12 = moneySum.substring(11, 12);
        String x13 = moneySum.substring(12, 13);
        // 注意把"."区分出来
        String x14 = moneySum.substring(14, 15);
        String x15 = moneySum.substring(15, 16);
        int temp = 0;
        String chinese = "";
        if (!x1.equals(" ")) {
            temp = Integer.parseInt(x1);
            chinese = chinese + b.substring(temp - 1, temp) + "万";
        }
        if (!x2.equals(" ")) {
            temp = Integer.parseInt(x2);
            if (x2.equals("0") && !x3.equals("0")) {
                chinese = chinese + "零";
            }
            if (!x2.equals("0")) {
                chinese = chinese + b.substring(temp - 1, temp) + "仟";
            }
        }
        if (!x3.equals(" ")) {
            temp = Integer.parseInt(x3);
            if (x3.equals("0") && !x4.equals("0")) {
                chinese = chinese + "零";
            }
            if (!x3.equals("0")) {
                chinese = chinese + b.substring(temp - 1, temp) + "佰";
            }
        }
        if (!x4.equals(" ")) {
            temp = Integer.parseInt(x4);
            if (x4.equals("0") && !x5.equals("0")) {
                chinese = chinese + "零";
            }
            if (!x4.equals("0")) {
                chinese = chinese + b.substring(temp - 1, temp) + "拾";
            }
        }
        if (!x5.equals(" ")) {
            temp = Integer.parseInt(x5);
            if (x5.equals("0")) {
                chinese = chinese + "亿";
            }
            if (!x5.equals("0")) {
                chinese = chinese + b.substring(temp - 1, temp) + "亿";
            }
        }
        if (!x6.equals(" ")) {
            temp = Integer.parseInt(x6);
            if (x6.equals("0") && !x7.equals("0")) {
                chinese = chinese + "零";
            }
            if (!x6.equals("0")) {
                chinese = chinese + b.substring(temp - 1, temp) + "仟";
            }
        }
        if (!x7.equals(" ")) {
            temp = Integer.parseInt(x7);
            if (x7.equals("0") && !x8.equals("0")) {
                chinese = chinese + "零";
            }
            if (!x7.equals("0")) {
                chinese = chinese + b.substring(temp - 1, temp) + "佰";
            }
        }
        if (!x8.equals(" ")) {
            temp = Integer.parseInt(x8);
            if (x8.equals("0") && !x9.equals("0")) {
                chinese = chinese + "零";
            }
            if (!x8.equals("0")) {
                chinese = chinese + b.substring(temp - 1, temp) + "拾";
            }
        }
        if (!x9.equals(" ")) {
            temp = Integer.parseInt(x9);
            if (x8.equals("0") && x10.equals("0") && x7.equals("0")
                    && x6.equals("0")) {


            } else if (x9.equals("0")) {
                chinese = chinese + "万";
            } else {
                chinese = chinese + b.substring(temp - 1, temp) + "万";
            }
        }
        if (!x10.equals(" ")) {
            temp = Integer.parseInt(x10);
            if (x10.equals("0") && !x11.equals("0")) {
                chinese = chinese + "零";
            }
            if (!x10.equals("0")) {
                chinese = chinese + b.substring(temp - 1, temp) + "仟";
            }
        }
        if (!x11.equals(" ")) {
            temp = Integer.parseInt(x11);
            if (x11.equals("0") && !x12.equals("0")) {
                chinese = chinese + "零";
            }
            if (!x11.equals("0")) {
                chinese = chinese + b.substring(temp - 1, temp) + "佰";
            }
        }
        if (!x12.equals(" ")) {
            temp = Integer.parseInt(x12);
            if (x12.equals("0") && !x13.equals("0")) {
                chinese = chinese + "零";
            }
            if (!x12.equals("0")) {
                chinese = chinese + b.substring(temp - 1, temp) + "拾";
            }
        }
        if (!x13.equals(" ")) {
            temp = Integer.parseInt(x13);
            if (x13.equals("0") && x14.equals("0") && x12.equals(" ")
                    && x15.equals("0")) {
                chinese = "零元";
            } else if (x13.equals("0")
                    && (!x14.equals("0") || !x15.equals("0"))) {


            } else if (x13.equals("0")) {
                chinese = chinese + "元";
            } else {
                chinese = chinese + b.substring(temp - 1, temp) + "元";
            }
        }
        if (!x14.equals(" ")) {
            temp = Integer.parseInt(x14);
            if (x13.equals("0") && x14.equals("0") && !x15.equals("0")) {
                chinese = chinese + "零";
            } else if (!x14.equals("0")) {
                chinese = chinese + b.substring(temp - 1, temp) + "角";
            }
        }
        if (!x15.equals(" ")) {
            temp = Integer.parseInt(x15);
            if (x15.equals("0")) {
                chinese = chinese + "整";
            } else {
                chinese = chinese + b.substring(temp - 1, temp) + "分";
            }
        }
        if (!flag) {
            chinese = "负" + chinese;
        }
        return chinese;
    }


    /**
     * 2 将","隔开的字符串形式的钱转化成浮点类型的数值的钱
     * 
     * @param moneyStr
     *            以","隔开的字符串形式的钱
     * @return
     */
    public static float changeFloat(String moneyStr) {
        float floatMoney = 0;
        if (null == moneyStr || " ".equals(moneyStr)) { // 如果为空相当于没有钱
            return floatMoney;
        }
        String[] moneyStrArray = moneyStr.split(",");
        String strMoney = "";
        for (int i = 0; i < moneyStrArray.length; i++) {
            strMoney += moneyStrArray[i];
        }
        floatMoney = Float.parseFloat(strMoney);
        return floatMoney;
    }


    /**
     * 将浮点型数据整数部分转化成字符串：把小数四舍五入掉
     * @param money
     * @return
     */
    public static String formatIntegerToString(String money) {
        money = NumberUtil.isValide(money) ? money : "0";
        DecimalFormat f = new DecimalFormat("###,###");
        return f.format(Double.parseDouble(money));
    }


    public static void main(String[] args) {
        // 1
        System.out.println(convertMoneyToChinese("12.1"));
        // 2
        System.out.println(changeFloat("11,12.1"));
        //3
        System.out.println(formatIntegerToString("20.55"));

    }
}
