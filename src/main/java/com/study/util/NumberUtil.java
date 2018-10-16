package com.study.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * Created by gf on 2018/10/16.
 */
public class NumberUtil {
    /**
     * 1 为了防止浮点数以科学计数法显示出来，通过NumberFormat转化成普通计数法，这里指定最多精确到小数点后4位
     * 
     * @param value
     *            浮点型数据
     * @param length
     *            精确到小数点后的位数
     */
    public static String convertDoubleToString(double value, int length) {
        DecimalFormat df = (DecimalFormat) NumberFormat.getInstance();// 返回当前默认语言环境的通用数值格式。
        df.setMinimumFractionDigits(length); // 返回数的小数部分所允许的最小位数。
        df.setMaximumFractionDigits(length); // 返回数的小数部分所允许的最大位数。
        return df.format(value);
    }

    /**
     * 3 将字符串转化成double类型
     * 
     * @param value
     *            字符串
     */
    public static double convertStringToDouble(String value) {
        if (value.equals("")) {
            value = "0.0";
        }
        value = replaceString(value, ",", "");// 将value中的","替换成""
        return Double.valueOf(value);
    }

    /**
     * 2 将指定的字符串替换成新的字符串:将str中出现的字符串oldStr替换为newStr
     * 
     * @param str
     * @param oldStr
     *            子字符串
     * @param newStr
     *            新子字符串
     * @return
     */
    private static String replaceString(String str, String oldStr, String newStr) {
        int pos = 0;
        if (str == null) {
            return null;
        }
        String tmp = str;
        String resultStr = "";
        // 字符串.indexOf(子字符串)：返回指定子字符串在此字符串中第一次出现处的索引。
        // 将str中出现的oldStr替换为newStr
        while ((pos = tmp.indexOf(oldStr)) >= 0) {
            resultStr = resultStr + tmp.substring(0, pos) + newStr;
            tmp = tmp.substring(pos + oldStr.length(), tmp.length());
        }
        if (tmp.equals("")) {
            return resultStr;
        }
        return resultStr + tmp;
    }

    /**
     * 4 判断字符串是否为零
     * 
     * @param strNum
     * @return
     */
    public static boolean equalZero(String strNum) {
        boolean ref = false;
        ref = Double.parseDouble(strNum) == 0;
        return ref;
    }

    /**
     * 5 将一个字符串转化成一个固定长度的字符串，位数不够在前面补0
     * 
     * @param str
     * @param length
     *            指定字符串固定的长度
     * @return
     */
    public static String fillStr(String str, int length) {
        int len = str.length();
        int replaceLen = length - len;
        String newStr = str;
        if (len < length) {
            for (int i = 0; i < replaceLen; i++) {
                newStr = "0".concat(newStr);// 将指定字符串newStr连接到此字符串"0"的结尾。
            }
            return newStr;
        } else {
            return str;
        }
    }

    /**
     * 6 将前面用0补齐的字符串转化成正常的字符串
     * @param value
     * @return
     */
    public static String convertStringToIntString(String value) {
        return String.valueOf(Integer.valueOf(value));// Integer.valueOf(value)将前面带0的数值字符串转换成不带0的数值字符串
    }

    /**
     * 7 以传入参数numinitial的形式格式化一个字符串，按照0.0000格式传递
     * 
     * @param str
     * @param numinitial
     * @return
     */
    public static String formatStr(String str, String numinitial) {
        str = isValide(str) ? str : "0"; // 判断字符串是否有效
        int scale = (numinitial.length() - 2 > 0 ? numinitial.length() - 2 : 0);
        BigDecimal bd = new BigDecimal(str);
        String result = bd.setScale(scale, BigDecimal.ROUND_HALF_DOWN)
                .toString();
        return result;
    }

    /**
     * 判断字符串是否有效
     * 
     * @param str
     * @return
     */
    public static boolean isValide(String str) {
        if (str.equals("")) {
            return false;
        }
        return true;
    }

    /**
     * 8 清除掉数值中小数部分多余的0 2.3300---->2.33
     * @param num
     * @return
     */
    public static String cleanZero(String num) {
        if (num.indexOf("0") > 0) { // 该数是一个小数
            byte[] c = num.getBytes();// l将字符串转化成字符数组
            int i = c.length - 1;


            for (; ((char) c[i]) == '0'; i--)
                ;
            if (c[i] == '.') {
                return new String(c, 0, i);
            } else {
                return new String(c, 0, i + 1);
            }
        } else {
            return num;
        }


    }

    public static void main(String[] args) {
        // 1
        System.out.println(convertDoubleToString(99.99, 9));
        // 2
        System.out.println(replaceString("ren,peng,liang", ",", ";"));
        // 3
        System.out.println(convertStringToDouble("20.,66"));
        // 4
        System.out.println(equalZero("0"));
        // 5
        System.out.println(fillStr("5555", 8));
        // 6
        System.out.println(convertStringToIntString("00005555"));
        // 7
        /*
        * 如果格式为：0.00000；如果小数点后的位数超过5位，从第六位开始进行四舍五入 66.666664---->66.66666
        * 66.666665----->66.66667
        */
        System.out.println(formatStr("66.666664", "0.00000"));
        // 8
        System.out.println(cleanZero("22.3300"));
    }
}
