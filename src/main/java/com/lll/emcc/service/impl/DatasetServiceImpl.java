package com.lll.emcc.service.impl;

import com.github.pagehelper.PageHelper;
import com.lll.emcc.entity.Dataset;
import com.lll.emcc.mapper.DatasetMapper;
import com.lll.emcc.service.DatasetService;
import com.lll.emcc.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional(readOnly = false)
public class DatasetServiceImpl implements DatasetService {
    @Autowired
    private DatasetMapper datasetMapper;
    @Override
    //@Cacheable(value ="DatasetCache",key = "'dataset.getAllData'")
    public List<Dataset> getAllDataset() {
        return datasetMapper.getAllData();
    }




    //@Cacheable(value ="DatasetCache",key = "'dataset.getAllData'")
    @Override
    public Map<String, Object> findAllByPage(int currentPage, int pageSize) {
        Map<String,Object> map = new HashMap<>();
        PageHelper.startPage(currentPage,pageSize);
        List<Dataset> allData = datasetMapper.getAllData();
        PageBean<Dataset> pageData = new PageBean<Dataset>(currentPage,pageSize);
        pageData.setItems(allData);
        map.put("allData",pageData.getItems());
        return map;
    }

    @Override
    public List<Dataset> getDataBySearch(String keywords) {
        return datasetMapper.getDataBySearch(keywords);
    }

    @Override
    public Map<String, Object> findAllByPageSearch(int currentPage, int pageSize,String keywords) {
        Map<String,Object> map = new HashMap<>();
        PageHelper.startPage(currentPage,pageSize);
        List<Dataset> allData = datasetMapper.getDataBySearch(keywords);
        PageBean<Dataset> pageData = new PageBean<Dataset>(currentPage,pageSize);
        pageData.setItems(allData);
        map.put("allData",pageData.getItems());
        return map;
    }
}
