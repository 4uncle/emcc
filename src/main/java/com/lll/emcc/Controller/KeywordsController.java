package com.lll.emcc.Controller;

import com.lll.emcc.entity.Keyset;
import com.lll.emcc.service.KeySetService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class KeywordsController {
    @Autowired
    private KeySetService keySetService;
    @GetMapping("/getAllKeyset")
    @ResponseBody
    public List<Keyset> getAllKeyset(){
        return keySetService.getAllKeyset();
    }

    /**
     *
     * @param currentPage 当前页
     * @param flag 1代表下一页 2代表上一页
     * @param model
     * @return
     */
    @GetMapping("/getAllKeysetByPage")
    public String getAllKeysetByPage(
            @RequestParam(value = "page",defaultValue = "1") int currentPage,
            @RequestParam(value = "flag",defaultValue = "3") int flag,
            Model model){
        if(flag==1){
            currentPage+=1;
        }else if(flag==2){
            currentPage-=1;
        }
        Map<String, Object> keyMap = keySetService.findAllByPage(currentPage, 10);
        keyMap.put("req","/getAllKeysetByPage");
        keyMap.put("currentPage",currentPage);
        keyMap.put("about","单词检索");
        model.addAttribute("dataMap",keyMap);
        return "key_list";
    }

    /**
     *
     * @param word 单词
     * @param model
     * @return
     */
    @GetMapping("/searchWord")
    public String searchWord(@RequestParam(value = "word") String word, Model model){
        List<Keyset> wordList = keySetService.getWord(word);
        model.addAttribute("wordList",wordList);
        return "word";
    }
}
