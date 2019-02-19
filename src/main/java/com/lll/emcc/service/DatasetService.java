package com.lll.emcc.service;

import com.lll.emcc.entity.Dataset;
import com.lll.emcc.utils.PageBean;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Map;

public interface DatasetService {
    //获取所有的字幕数据
     List<Dataset> getAllDataset();
    //演讲类后台分页
    Map<String,Object> findAllByPage(int currentPage, int pageSize);
    //搜索框检索
    List<Dataset> getDataBySearch(String keywords);
    //关键字后台分页
    Map<String,Object> findAllByPageSearch(int currentPage, int pageSize,String keywords);
}
