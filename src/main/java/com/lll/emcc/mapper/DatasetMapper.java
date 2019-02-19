package com.lll.emcc.mapper;

import com.lll.emcc.entity.Dataset;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface DatasetMapper {
    //检索所有数据
    @Select("SELECT * FROM dataset WHERE videoType='演讲'")
   public List<Dataset>  getAllData();
    //检索首条
    @Select("SELECT  id FROM dataset ORDER BY id ASC LIMIT 1")
    public int getFirstData();
    //检索末条
    @Select("SELECT  id FROM dataset ORDER BY id DESC LIMIT 1")
    public int getFinalData();
    //搜索框
    @Select("SELECT * FROM dataset WHERE chineseSubtitle LIKE CONCAT('%',#{0},'%')  OR englishSubtitle LIKE CONCAT('%',#{0},'%') ")
    public List<Dataset> getDataBySearch(String keywords);
}
