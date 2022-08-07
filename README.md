# Mybatis
mybatis练习
注意事项：
  1. mybatis核心配置文件的标签是有顺序的
  2. mappers配置引入映射配置文件
  3. mapper映射文件和mapper接口文件包名一致
  4. mapper映射文件名和mapper接口名一致
  5. mapper映射文件中的sql的id与mapper接口中方法名一致
  6. #{}和${}的区别，#{}在jdbc底层使用的是preparedStatment做了预编译处理（会给传入的数据加上单引号），会解决sql注入问题。${}在jdbc底层使用的是statement完成字符串拼接，会出现sq注入问题。
  7. 特殊sql语句：
     - 模糊查询中的三种方式：
      ```
      <!--使用#{}进行模糊查询会出现报错，错误为无法找到占位符，因为在单引号中将？不视作占位符-->
        <!--select * from t_user where name like '%#{name}%'-->
        
        <!--select * from t_user where name like '%${name}%'-->
        <!--使用concat函数进行字符串拼，从而实现模糊查询，解决了sql注入问题-->
        <!--select * from t_user where name like concat('%',#{name},'%');-->
        <!---->
        select * from t_user where name like "%"#{name}"%"
      ```
     - 批量删除 IN
     ```
     delete from t_user where id in (${ids})  //不能使用#{ids}，在sql语句规范中，in('')会报错
     ```
     - 动态设置表名
     ```
     select * from ${tabName}   //也不能使用#{}来进行表名的填充
     ```
     
  8. 添加功能自动获取主键
  ```
  <insert id="insertGenKey" useGeneratedKeys="true" keyProperty="id">
        insert into t_user values(null,'张三','123456','北京','12233445566')
    </insert>
  ```
