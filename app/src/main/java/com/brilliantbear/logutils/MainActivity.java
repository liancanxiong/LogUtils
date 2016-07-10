package com.brilliantbear.logutils;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.brilliantbear.logutils.utils.LogUtils;

public class MainActivity extends AppCompatActivity {

    private static final String json = "{\"name\":\"JSON中国\",\"url\":\"http://www.json.org.cn\",\"page\":88,\"isNonProfit\":true,\"address\":{\"street\":\"浙大路38号.\",\"city\":\"浙江杭州\",\"country\":\"中国\"},\"links\":[{\"name\":\"Google\",\"url\":\"http://www.google.com\"},{\"name\":\"Baidu\",\"url\":\"http://www.baidu.com\"},{\"name\":\"SoSo\",\"url\":\"http://www.SoSo.com\"}]}";
    private static final String jsonArr = "[{\"name\":\"Google\",\"url\":\"http://www.google.com\"},{\"name\":\"Baidu\",\"url\":\"http://www.baidu.com\"},{\"name\":\"SoSo\",\"url\":\"http://www.SoSo.com\"}]";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LogUtils.init(LogUtils.LEVEL_ALL, "Log");

        LogUtils.V("test");
        LogUtils.D("test");
        LogUtils.I("test");
        LogUtils.W("test");
        LogUtils.E("test");

        LogUtils.V("log", "test");
        LogUtils.D("log", "test");
        LogUtils.I("log", "test");
        LogUtils.W("log", "test");
        LogUtils.E("log", "test");

        LogUtils.json(LogUtils.LEVEL_DEBUG, "log", json);
        LogUtils.json(LogUtils.LEVEL_DEBUG, "log", jsonArr);
    }


}
