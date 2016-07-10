# LogUtils
一个简单的Log日志库

* 可以显示类名，函数名，行号，点击可以直接跳转到源文件
* 可以根据等级过滤日志
* 可以格式化输出Json

## 如何使用
### 初始化
    LogUtils.init(LogUtils.LEVEL_ALL, "Log");

### 输出
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