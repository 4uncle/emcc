package com.lll.emcc.service;

import com.lll.emcc.entity.Keyset;

import java.util.List;
import java.util.Map;

public interface KeySetService {
    //获取所有关键字数据
    List<Keyset> getAllKeyset();
    //分页检索
    Map<String,Object> findAllByPage(int currentPage, int pageSize);
    //查询单词
    List<Keyset> getWord(String word);
}
