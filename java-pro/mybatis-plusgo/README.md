## 实现批量更新
实现批量更新：  
1、循环调用mp的mapper.insert  
2、调用mp的service.saveOrUpdateBatch  
3、自己实现，如同下面写的两个方式  

### mybatis注解实现批量更新
方式一
```java
@Update("<script>" +
            "update user" +
            "<set>" +
            "<trim prefix='username=case' suffix='end,'>" +
            "    <foreach collection='users' item='user'>" +
            "        <if test='user.username!=null'>" +
            "            when id=#{user.id} then #{user.username}" +
            "        </if>" +
            "    </foreach>" +
            "</trim>" +
            "<trim prefix='password=case' suffix='end,'>" +
            "    <foreach collection='users' item='user'>" +
            "        <if test='user.password!=null'>" +
            "            when id=#{user.id} then #{user.password}" +
            "        </if>" +
            "    </foreach>" +
            "</trim>" +
            "<trim prefix='remark=case' suffix='end,'>" +
            "    <foreach collection='users' item='user'>" +
            "        <if test='user.remark!=null'>" +
            "            when id=#{user.id} then #{user.remark}" +
            "        </if>" +
            "    </foreach>" +
            "</trim>" +
            "</set>" +
            "<where>" +
            "    <foreach collection='users' item='user'  separator='or'>" +
            "        id = #{user.id}" +
            "    </foreach>" +
            "</where>" +
            "</script>")
```
将其转化成sql语句如下：
```mysql
update user set 
    username =
CASE 
	WHEN id = 1 THEN
		'aa1'
	WHEN id = 2 THEN
		'bb2'
end,
	password =
CASE 
	WHEN id = 1 THEN
		'111'
	WHEN id = 2 THEN
		'222'
end,
    remark =
CASE
    WHEN id = 1 THEN
        '111'
    WHEN id = 2 THEN
        '222'
end
where id = 1 or id = 2;
```

方式二
```java
@Update("<script>"+
        "<foreach collection='users' item='item'  separator=';'>"+
        "update `user`"+
        "<set>"+
        "<if test='item.username!=null'>`username`=#{item.username},</if>"+
        "<if test='item.password!=null'>`password`=#{item.password},</if>"+
        "<if test='item.remark!=null'>`remark`=#{item.remark},</if>"+
        "</set>"+
        "where `id` = #{item.id} "+
        "</foreach>"+
        "</script>")
```
将其转化成sql语句如下：
```mysql
update user set username=xxx, password=xxx where id=xxx;
update user set username=xxx, password=xxx where id=xxx;
...
...
```
