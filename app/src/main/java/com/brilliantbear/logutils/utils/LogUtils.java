package com.brilliantbear.logutils.utils;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;

/**
 * Created by Bear on 2016-7-10.
 */
public class LogUtils {

    private static final String SUFFIX_JAVA = ".java";

    public static final int LEVEL_ALL = 0x00;
    public static final int LEVEL_VERBOSE = 0x01;
    public static final int LEVEL_DEBUG = 0x02;
    public static final int LEVEL_INFO = 0x03;
    public static final int LEVEL_WARM = 0x04;
    public static final int LEVEL_ERROR = 0x05;
    public static final int LEVEL_NONE = 0x06;

    private static final String DEFAULT_TAG = "LogUtils";
    private static int mLevel = LEVEL_NONE;

    private static String mTag;

    public static void init(int level) {
        init(level, DEFAULT_TAG);
    }

    public static void init(int level, String tag) {
        mLevel = level;
        mTag = tag;
    }


    public static void V(Object msg) {
        printText(LEVEL_VERBOSE, null, msg);
    }

    public static void V(String tag, Object msg) {
        printText(LEVEL_VERBOSE, tag, msg);
    }

    public static void D(Object msg) {
        printText(LEVEL_DEBUG, null, msg);
    }

    public static void D(String tag, Object msg) {
        printText(LEVEL_DEBUG, tag, msg);
    }

    public static void I(Object msg) {
        printText(LEVEL_INFO, null, msg);
    }

    public static void I(String tag, Object msg) {
        printText(LEVEL_INFO, tag, msg);
    }

    public static void W(Object msg) {
        printText(LEVEL_WARM, null, msg);
    }

    public static void W(String tag, Object msg) {
        printText(LEVEL_WARM, tag, msg);
    }

    public static void E(Object msg) {
        printText(LEVEL_ERROR, null, msg);
    }

    public static void E(String tag, Object msg) {
        printText(LEVEL_ERROR, tag, msg);
    }

    public static void json(String msg) {
        printJson(LEVEL_DEBUG, null, msg);
    }

    public static void json(String tag, String msg) {
        printJson(LEVEL_DEBUG, tag, msg);
    }

    public static void json(int level, String tag, String msg) {
        printJson(level, tag, msg);
    }

    private static String getHeadInfo() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();

//        for (int i = 0; i < stackTrace.length; i++) {
//            Log.d("log", i + " : " + stackTrace[i].getClassName() + "   " + stackTrace[i].getMethodName());
//        }

        int i = 5;
        StackTraceElement element = stackTrace[i];
        String className = element.getClassName();
        if (className.contains(".")) {
            String[] names = className.split("\\.");
            className = names[names.length - 1] + SUFFIX_JAVA;
        }

        if (className.contains("$")) {
            className = className.split("\\$")[0] + SUFFIX_JAVA;
        }

        String methodName = element.getMethodName();
        int lineNumber = element.getLineNumber();

        return "[(" + className + ":" + lineNumber + ")#" + methodName + "]";
    }

    private static void printText(int level, String tag, Object msg) {
        if (level < mLevel)
            return;

        String headInfo = getHeadInfo();

        String message;
        if(msg.getClass().isArray()){
            message = Arrays.deepToString((Object[])msg);
        }else{
            message = msg.toString();
        }

        println(level, tag, headInfo + " " + message);
    }

    private static void println(int level, String tag, String msg) {
        String t;
        if (null == tag) {
            t = mTag;
        } else {
            t = tag;
        }

        switch (level) {
            case LEVEL_VERBOSE:
                Log.v(t, msg);
                break;
            case LEVEL_DEBUG:
                Log.d(t, msg);
                break;
            case LEVEL_INFO:
                Log.i(t, msg);
                break;
            case LEVEL_WARM:
                Log.w(t, msg);
                break;
            case LEVEL_ERROR:
                Log.e(t, msg);
                break;
        }
    }


    private static final int INDENT_SPACES = 4;
    private static final String LINE_SEPARATOR = System.getProperty("line.separator");

    public static void printJson(int level, String tag, String msg) {
        if (level < mLevel)
            return;

        String json;
        try {
            if (msg.startsWith("{")) {
                JSONObject jo = new JSONObject(msg);
                json = jo.toString(INDENT_SPACES);
            } else if (msg.startsWith("[")) {
                JSONArray js = new JSONArray(msg);
                json = js.toString(INDENT_SPACES);
            } else {
                json = msg;
            }
        } catch (JSONException e) {
            e.printStackTrace();
            json = msg;
        }

        String headInfo = getHeadInfo();
        json = headInfo + LINE_SEPARATOR + json;
        String[] lines = json.split(LINE_SEPARATOR);
        for (String line : lines) {
            println(level, tag, line);
        }
    }
}
