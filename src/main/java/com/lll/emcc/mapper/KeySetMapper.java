package com.lll.emcc.mapper;

import com.lll.emcc.entity.Keyset;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface KeySetMapper {
    //获取所有数据
    @Select("SELECT * FROM keyset")
    public List<Keyset> getAllKeySet();
    //查询单词
    @Select("SELECT * FROM keyset WHERE engKey=#{0}OR chaKey LIKE CONCAT('%',#{0},'%')")
    public List<Keyset> getWord(String word);
}
