package com.ziya.bank.utils;

import android.graphics.Color;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @version V1.0
 * @Author Oliver.Lau
 */
public class StringUtil {

    public static boolean isEmpty(String str) {
        if (str == null || str.trim().equals("") || "null".equals(str)) {
            return true;
        }
        return false;
    }

    public static String addBlackSpace(String str, int count) {
        StringBuffer sb = new StringBuffer();
        if (!StringUtil.isEmpty(str)) {
            for (int x = 0; x < str.length(); x++) {
                if (x % count == 0 && x != 0 && x != str.length()) {
                    if (!str.substring(x, x + 1).equals(" ")) {
                        sb.append(" " + str.substring(x, x + 1));
                    } else {
                        sb.append(str.substring(x, x + 1));
                    }
                } else {
                    sb.append(str.substring(x, x + 1));
                }
            }
            return sb.toString();
        }
        return null;
    }

    /**
     * 去除字符串中的空格
     */
    public static String removeBlackSpace(String str) {
        if (StringUtil.isEmpty(str))
            return null;
        StringBuffer sBuffer = new StringBuffer();
        for (int x = 0; x < str.length(); x++) {
            if (!str.substring(x, x + 1).equals(" "))
                sBuffer.append(str.substring(x, x + 1));
        }
        return sBuffer.toString();
    }

    /**
     * 验证是否是邮箱格式
     */
    public static boolean isEmailValid(String email) {
        boolean isValid = false;
        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        CharSequence inputStr = email;
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputStr);
        if (matcher.matches()) {
            isValid = true;
        }
        return isValid;
    }

    /**
     * 判断字符串同时包含数字和字母
     */
    public static boolean hasDigitAndLetter(String text) {
        boolean isDigit = false;
        boolean isLetter = false;
        for (int i = 0; i < text.length(); i++) {
            if (Character.isDigit(text.charAt(i))) {
                isDigit = true;
                continue;
            }
            if (Character.isLetter(text.charAt(i))) {
                isLetter = true;
                continue;
            }
            return false;

        }
        if (isDigit && isLetter) {
            return true;
        } else
            return false;
    }

    /**
     * 设置TextVew某一部分字体特殊颜色显示同时可点击
     *
     * @param tv              指定的TextView
     * @param text            TextView显示内容
     * @param start           特殊颜色部分字体开始位置
     * @param end             特殊颜色字体结束位置
     * @param color           特殊颜色字体显示颜色
     * @param onClickListener 特殊颜色字体点击监听
     */
    public static void setTextClickAndColor(TextView tv, String text, int start, int end, final int color, final View.OnClickListener onClickListener) {
        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                avoidHintColor(widget);
                onClickListener.onClick(widget);
            }

            @Override
            public void updateDrawState(TextPaint ds) {
                super.updateDrawState(ds);
                ds.setColor(color);
                ds.setUnderlineText(false);
                ds.clearShadowLayer();
            }
        };
        SpannableString spannableString = new SpannableString(text);
        spannableString.setSpan(clickableSpan, start, end, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        tv.setText(spannableString);
        tv.setMovementMethod(LinkMovementMethod.getInstance());
    }

    /**
     * 高亮区域的背景色
     *
     * @param view
     */
    private static void avoidHintColor(View view) {
        if (view instanceof TextView)
            ((TextView) view).setHighlightColor(Color.TRANSPARENT);
    }

    /**
     * 首字母转小写
     */
    public static String toLowerCaseFirstOne(String s) {
        if (Character.isLowerCase(s.charAt(0)))
            return s;
        else
            return (new StringBuilder()).append(Character.toLowerCase(s.charAt(0))).append(s.substring(1)).toString();
    }

    /**
     * 将键值对形式的字符串保存到Map中
     *
     * @param content 键值对字符串
     * @return Map
     */
    public static Map<String, String> string2Map(String content) {
        Map<String, String> map = new HashMap<>();
        if (isEmpty(content))
            return map;
        String[] forms = content.split("&");
        int length = forms.length;
        for (int size = 0; size < length; size++) {
            String[] value = forms[size].split("=");
            map.put(value[0], value[1]);
        }
        return map;
    }

    public static Map<String, String> json2Map(String json) {
        Map<String, String> map = new HashMap<>();
        if (isEmpty(json))
            return map;
        try {
            JSONObject object = new JSONObject(json);
            for (Iterator<String> keys = object.keys(); keys.hasNext(); ) {
                String key = keys.next();
                map.put(key, object.optString(key));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return map;
    }
}
