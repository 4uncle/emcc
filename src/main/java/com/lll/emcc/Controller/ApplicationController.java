package com.lll.emcc.Controller;

import com.lll.emcc.utils.TimeCutUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
public class ApplicationController {
    @RequestMapping("/types")
    public String type(Model model){
        model.addAttribute("about","分类语料检索");
        return "data_type";
    }

    @RequestMapping("/videoPlay.do")
    public String videoPlay(@RequestParam(value="startTime",required = true,defaultValue="0") String startTime,
                            @RequestParam(value="endTime",required=true,defaultValue="0") String endTime,
                            @RequestParam(value="videoName",required=true) String videoName,Model model) {
//        String subStartTime = TimeCutUtil.timeCutStart(startTime);
   //     String subEndTime = TimeCutUtil.timeCutEnd(endTime);
        String chineseSub = videoName+"chs.vtt";
        String englishSub = videoName+"eng.vtt";
        videoName = videoName+"mp4";
        Map<String,Object> timeMap = new HashMap<String,Object>();
      //  timeMap.put("startTime",subStartTime );
       // timeMap.put("endTime", subEndTime);
        timeMap.put("videoName", videoName);
        timeMap.put("chineseSub", chineseSub);
        timeMap.put("englishSub", englishSub);
        model.addAttribute("timeMap", timeMap);
        return "video_play";
    }

    @RequestMapping("/videoPlay")
    public String videoPlay(@RequestParam(value = "videoName") String videoName,
                            @RequestParam(value="startTime",required = true,defaultValue="0") String startTime,
                            @RequestParam(value="endTime",required=true,defaultValue="0") String endTime,
                            Map map,
                            Model model){
        //字幕
        String chineseSub = videoName+".chs.vtt";
        String englishSub = videoName+".eng.vtt";
        //视频名
        videoName = videoName+".mp4";
        //开始时间
        startTime = "10";
        //结束时间
        endTime = "20";
        map.put("about","视频播放");
        map.put("startTime",startTime);
        map.put("endTime",endTime);
        map.put("videoName",videoName);
        map.put("chineseSub",chineseSub);
        map.put("englishSub",englishSub);
        model.addAttribute("map",map);
        return "video_play";
    }

}
