package com.lll.emcc.service.impl;

import com.github.pagehelper.PageHelper;
import com.lll.emcc.entity.Keyset;
import com.lll.emcc.mapper.KeySetMapper;
import com.lll.emcc.service.KeySetService;
import com.lll.emcc.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional(readOnly = false)
public class KeySetServiceImpl implements KeySetService {
    @Autowired
    private KeySetMapper keySetMapper;
    @Override
    public List<Keyset> getAllKeyset() {
        return keySetMapper.getAllKeySet();
    }

    @Override
    public Map<String, Object> findAllByPage(int currentPage, int pageSize) {
        Map<String,Object> keyMap = new HashMap<>();
        PageHelper.startPage(currentPage,pageSize);
        List<Keyset> keyData = keySetMapper.getAllKeySet();
        PageBean<Keyset> pageData = new PageBean<Keyset>(currentPage,pageSize);
        pageData.setItems(keyData);
        keyMap.put("keyData",pageData.getItems());
        return keyMap;
    }

    @Override
    public List<Keyset> getWord(String word) {
        return keySetMapper.getWord(word);
    }
}
