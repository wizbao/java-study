package com.abot.easyexcelgo;

import com.abot.easyexcelgo.POJO.PO.User;
import com.abot.easyexcelgo.listener.UserDataListener;
import com.abot.easyexcelgo.mapper.UserMapper;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.util.ListUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Slf4j
class EasyExcelgoApplicationTests {

    @Autowired
    private UserMapper userMapper;

    private List<User> data() {
        List<User> list = ListUtils.newArrayList();
        for (int i = 0; i < 10; i++) {
            User data = new User();
            data.setUsername("jay" + i);
            data.setPassword("jay" + i);
            list.add(data);
        }
        return list;
    }

    /**
     * 最简单的写
     * <p>
     * 1. 创建excel对应的实体对象 参照{@link User}
     * <p>
     * 2. 直接写即可
     */
    @Test
    public void simpleWrite() {
        // 注意 simpleWrite在数据量不大的情况下可以使用（5000以内，具体也要看实际情况），数据量大参照 重复多次写入

        // 写法1 JDK8+
        // since: 3.0.0-beta1
        String fileName = "C:\\Users\\韦小宝\\Desktop\\" + "simpleWrite" + System.currentTimeMillis() + ".xlsx";
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        // 如果这里想使用03 则 传入excelType参数即可
        // 分页查询数据
        EasyExcel.write(fileName, User.class)
                .sheet("模板")
                .doWrite(this::data);

//        // 写法2
//        fileName = TestFileUtil.getPath() + "simpleWrite" + System.currentTimeMillis() + ".xlsx";
//        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
//        // 如果这里想使用03 则 传入excelType参数即可
//        EasyExcel.write(fileName, User.class).sheet("模板").doWrite(data());
//
//        // 写法3
//        fileName = TestFileUtil.getPath() + "simpleWrite" + System.currentTimeMillis() + ".xlsx";
//        // 这里 需要指定写用哪个class去写
//        try (ExcelWriter excelWriter = EasyExcel.write(fileName, User.class).build()) {
//            WriteSheet writeSheet = EasyExcel.writerSheet("模板").build();
//            excelWriter.write(data(), writeSheet);
//        }
    }

    /**
     * 最简单的读
     * <p>
     * 1. 创建excel对应的实体对象 参照{@link User}
     * <p>
     * 2. 由于默认一行行的读取excel，所以需要创建excel一行一行的回调监听器，参照{@link com.abot.easyexcelgo.listener.UserDataListener}
     * <p>
     * 3. 直接读即可
     */
    @Test
    public void simpleRead() {
        // 写法1：JDK8+ ,不用额外写一个UserListener
        // since: 3.0.0-beta1
//        String fileName = "C:\\Users\\韦小宝\\Desktop\\" + "simpleWrite" + "1689502417501" + ".xlsx";
        // 这里默认每次会读取100条数据 然后返回过来 直接调用使用数据就行
        // 具体需要返回多少行可以在`PageReadListener`的构造函数设置
//        EasyExcel.read(fileName, User.class, new PageReadListener<User>(dataList -> {
//            for (User demoData : dataList) {
//                log.info("读取到一条数据{}", JSON.toJSONString(demoData));
//            }
//        })).sheet().doRead();

        // 写法2：
        // 匿名内部类 不用额外写一个UserListener
//        fileName = TestFileUtil.getPath() + "demo" + File.separator + "demo.xlsx";
//        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
//        EasyExcel.read(fileName, User.class, new ReadListener<User>() {
//            /**
//             * 单次缓存的数据量
//             */
//            public static final int BATCH_COUNT = 100;
//            /**
//             *临时存储
//             */
//            private List<User> cachedDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);
//
//            @Override
//            public void invoke(User data, AnalysisContext context) {
//                cachedDataList.add(data);
//                if (cachedDataList.size() >= BATCH_COUNT) {
//                    saveData();
//                    // 存储完成清理 list
//                    cachedDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);
//                }
//            }
//
//            @Override
//            public void doAfterAllAnalysed(AnalysisContext context) {
//                saveData();
//            }
//
//            /**
//             * 加上存储数据库
//             */
//            private void saveData() {
//                log.info("{}条数据，开始存储数据库！", cachedDataList.size());
//                log.info("存储数据库成功！");
//            }
//        }).sheet().doRead();

        // 有个很重要的点 UserDataListener 不能被spring管理，要每次读取excel都要new,然后里面用到spring可以构造方法传进去
        // 写法3：
        String fileName = "C:\\Users\\韦小宝\\Desktop\\" + "simpleWrite" + "1689505690958" + ".xlsx";
        // 这里 需要指定读用哪个class去读，然后读取第一个sheet 文件流会自动关闭
        EasyExcel.read(fileName, User.class, new UserDataListener(userMapper)).sheet().doRead();

//        // 写法4
//        fileName = TestFileUtil.getPath() + "demo" + File.separator + "demo.xlsx";
//        // 一个文件一个reader
//        try (ExcelReader excelReader = EasyExcel.read(fileName, User.class, new UserDataListener()).build()) {
//            // 构建一个sheet 这里可以指定名字或者no
//            ReadSheet readSheet = EasyExcel.readSheet(0).build();
//            // 读取一个sheet
//            excelReader.read(readSheet);
//        }
    }

    @Test
    void contextLoads() {
        List<User> users = new ArrayList<>();
        User u1 = new User();
        u1.setUsername("aaa");
        u1.setPassword("aaa");
        User u2 = new User();
        u2.setUsername("bbb");
        u2.setPassword("bbb");
        u2.setRemark("我是bbb");
        users.add(u1);
        users.add(u2);
        try{
            boolean b = userMapper.batchInsert(users);
            if (b){
                System.out.println("success");
            }else {
                System.out.println("fail");
            }
        }catch (Exception e){

        }
    }


}
