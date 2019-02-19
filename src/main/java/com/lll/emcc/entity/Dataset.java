package com.lll.emcc.entity;

import java.io.Serializable;

public class Dataset implements Serializable {
    private Long id;
    private String videoPath;
    private String videoName;
    private String subStartTime;
    private String subEndTime;
    private String englishSubtitle;
    private String chineseSubtitle;
    private String videoType;
    private String emotion;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVideoPath() {
        return videoPath;
    }

    public void setVideoPath(String videoPath) {
        this.videoPath = videoPath;
    }

    public String getVideoName() {
        return videoName;
    }

    public void setVideoName(String videoName) {
        this.videoName = videoName;
    }

    public String getSubStartTime() {
        return subStartTime;
    }

    public void setSubStartTime(String subStartTime) {
        this.subStartTime = subStartTime;
    }

    public String getSubEndTime() {
        return subEndTime;
    }

    public void setSubEndTime(String subEndTime) {
        this.subEndTime = subEndTime;
    }

    public String getEnglishSubtitle() {
        return englishSubtitle;
    }

    public void setEnglishSubtitle(String englishSubtitle) {
        this.englishSubtitle = englishSubtitle;
    }

    public String getChineseSubtitle() {
        return chineseSubtitle;
    }

    public void setChineseSubtitle(String chineseSubtitle) {
        this.chineseSubtitle = chineseSubtitle;
    }

    public String getVideoType() {
        return videoType;
    }

    public void setVideoType(String videoType) {
        this.videoType = videoType;
    }

    public String getEmotion() {
        return emotion;
    }

    public void setEmotion(String emotion) {
        this.emotion = emotion;
    }
}
