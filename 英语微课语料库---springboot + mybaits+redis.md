# 英语微课语料库---springboot + mybaits+redis

#### 1.关于整合mybatis后端分页使用第三方pagehelper插件

1. ##### 引入pageHelper依赖

```java
<dependency>
      <groupId>com.github.pagehelper</groupId>
      <artifactId>pagehelper</artifactId>
      <version>4.1.4</version>
    </dependency>
```

2. ##### 编写分页配置bean

```java
package cn.lll.emcc.utils;

/**
 * 分页bean
 */

import java.util.List;

public class PageBean<T> {
    // 当前页
    private Integer currentPage = 1;
    // 每页显示的总条数
    private Integer pageSize = 10;
    // 总条数
    private Integer totalNum;
    // 是否有下一页
    private Integer isMore;
    // 总页数
    private Integer totalPage;
    // 开始索引
    private Integer startIndex;
    // 分页结果
    private List<T> items;

    public PageBean() {
        super();
    }

    public PageBean(Integer currentPage, Integer pageSize, Integer totalNum) {
        super();
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.totalNum = totalNum;
        this.totalPage = (this.totalNum+this.pageSize-1)/this.pageSize;
        this.startIndex = (this.currentPage-1)*this.pageSize;
        this.isMore = this.currentPage >= this.totalPage?0:1;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Integer totalNum) {
        this.totalNum = totalNum;
    }

    public Integer getIsMore() {
        return isMore;
    }

    public void setIsMore(Integer isMore) {
        this.isMore = isMore;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(Integer startIndex) {
        this.startIndex = startIndex;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }
}

```

3. ##### 在启动类中将bean注入

```java
@Bean
	public PageHelper pageHelper(){
		PageHelper pageHelper = new PageHelper();
		Properties properties = new Properties();
		properties.setProperty("offsetAsPageNum","true");
		properties.setProperty("rowBoundsWithCount","true");
		properties.setProperty("reasonable","true");
		properties.setProperty("dialect","mysql");    //配置mysql数据库的方言
		pageHelper.setProperties(properties);
		return pageHelper;
	}
```

4. ##### 在service接口中声明

```java
/**
	 * 分页查询
	 */
	List<Dataset> findItemByPage(int currentPage, int pageSize);
```

5. ##### 实现接口

```java
@Override
	public List<Dataset> findItemByPage(int currentPage, int pageSize) {
		//设置分页信息，分别是当前页数和每页显示的总记录数【记住：必须在mapper接口中的方法执行之前设置该分页信息】
		PageHelper.startPage(currentPage, pageSize);
		List<Dataset> allItems = datasetMapper.getAllData();        //全部商品
		int countNums = 800;
		PageBean<Dataset> pageData = new PageBean<>(currentPage, pageSize, countNums);
		pageData.setItems(allItems);
		return pageData.getItems();
	}
```

6. ##### 最后写出控制类

```java
@GetMapping("/pageData")
	@ResponseBody
	public List<Dataset> pageData(@RequestParam("c") int currentPage,@RequestParam("p") int pageSize){
		return datasetService.findItemByPage(currentPage,pageSize);
	}

```

#### 2.关于写入数据库（mysql）乱码的问题

##### 方法1：在配置文件中添加

```jaVA
url=jdbc:mysql:///emcc1?useUnicode=true&amp;characterEncoding=utf-8
```

##### 方法2：如果问题没有解决查看数据库现在的编码，进入数据库dos命令登录后输入

```sql
一、查看MySQL数据库服务器和数据库MySQL字符集。

 　　show variables like "%char%"


二、查看MySQL数据表（table）的MySQL字符集。

　　show table status from sqlstudy_db like "%countries%"

 

三、查看MySQL数据列（column）的MySQL字符集。

　　show full columns from countries
```

查看相应的字符编码格式是否统一，如果不统一可以在配置文件my.ini中修改默认编码

在此电脑中输入%ProgramData%就可以显示所有的隐藏配置文件

后修改my.ini中的配置

```c
[mysql]

# default-character-set=
default-character-set=utf8

[mysqld]

# character-set-server=
character-set-server=utf8
```



然后重启服务，可以通过管理员权限的DOS

```DOS
net stop mysql


net start mysql
```

#### 3.thymeleaf中的th:if使用方法

```html
gt：great than（大于）>
ge：great equal（大于等于）>=
eq：equal（等于）==
lt：less than（小于）<
le：less equal（小于等于）<=
ne：not equal（不等于）!=
```

#### 4.sql中过滤空格

```sql
UPDATE `dataset` SET `subEndTime`=REPLACE(`subEndTime`,' ','');
#过滤 dataset 表中的 subEndTime字段
```

