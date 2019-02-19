package com.lll.emcc.Controller;

import com.lll.emcc.entity.Dataset;
import com.lll.emcc.service.DatasetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class DatasetController {
    @Autowired
    private DatasetService datasetService;

    //展示所有的data以json
    @GetMapping("/pageData")
    @ResponseBody
   public Map<String,Object> pageData(@RequestParam("c") int currentPage){
        Map<String,Object> dataMap = datasetService.findAllByPage(currentPage,10);
        return dataMap;
    }

    @GetMapping("/getAll")
    public String getAll(Model model){
        List<Dataset> allDataset = datasetService.getAllDataset();
        model.addAttribute("allDataset",allDataset);
        return "datalist";
    }

    /**
     *
     * @param currentPage 当前页数
     * @param flag 上一页 or 下一页
     * @param model 参数传递
     * @return
     */

    @GetMapping("/getTalk")
    public String getTalk(@RequestParam(value = "page",defaultValue = "1") int currentPage,
                          @RequestParam(value = "flag",defaultValue = "3") int flag,
                          @RequestParam(value = "keywords",defaultValue = "演讲") String keywords,
                          Model model){
        if(flag==1){
            currentPage+=1;
        }else if(flag==2){
            currentPage-=1;
        }
        Map<String,Object> dataMap = datasetService.findAllByPage(currentPage,10);
        dataMap.put("currentPage",currentPage);
        dataMap.put("about","演讲类");
        dataMap.put("req","/getTalk");
        dataMap.put("keywords",keywords);
        model.addAttribute("dataMap",dataMap);
        return "datalist";
    }

    /**
     * 搜索框字幕检索
     * @return
     * @param keywords 搜索框中的参数
     * @param currentPage 当前页数
     * @param flag 上一页 or 下一页
     * @param model 参数传递
     *
     */
    @GetMapping("/search")
    public String search(@RequestParam(value = "page",defaultValue = "1") int currentPage,
                          @RequestParam(value = "flag",defaultValue = "3") int flag,
                          Model model,
                         @RequestParam(value = "keywords") String keywords
                         ){
        if(flag==1){
            currentPage+=1;
        }else if(flag==2){
            currentPage-=1;
        }
        Map<String,Object> dataMap = datasetService.findAllByPageSearch(currentPage,10,keywords);
        dataMap.put("currentPage",currentPage);
        dataMap.put("about","关键词检索");
        dataMap.put("req","/search");
        dataMap.put("keywords",keywords);
        model.addAttribute("dataMap",dataMap);
        return "datalist";
    }


}
