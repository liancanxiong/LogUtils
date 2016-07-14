# LogUtils
一个简单的Log日志库

* 可以显示类名，函数名，行号，点击可以直接跳转到源文件
* 可以根据等级过滤日志
* 可以格式化输出Json

## v1.1 更新
* 支持数组，List，Set，Map数据结构的输出

## 如何使用
直接复制LogUtils.java文件到项目下即可

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

     mArrys = new String[]{"arr1", "arr2", "arr3"};
     LogUtils.D(mArrys);

     mList = new ArrayList<>();
     mList.add("list1");
     mList.add("list2");
     mList.add("list3");
     LogUtils.D(mList);

     mMap = new HashMap<>();
     mMap.put("key1", "map1");
     mMap.put("key2", "map2");
     mMap.put("key3", "map3");
     LogUtils.D(mMap);

     mSet = new TreeSet<>();
     mSet.add("set1");
     mSet.add("set2");
     mSet.add("set3");
     LogUtils.D(mSet);