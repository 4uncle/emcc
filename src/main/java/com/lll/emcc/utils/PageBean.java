package com.lll.emcc.utils;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.List;

public class PageBean<T> {
    //当前页
    private Integer currentPage=1;
    //每页显示数量
    private Integer pageSize=10;
    //总数
    private Integer totalNum;
    //是否有下一页
    private Integer isMore;
    //总页数
    private Integer totalPage;
    //开始索引
    private Integer startIndex;
    //分页结果
    private List<T> items;
    public PageBean(int currentPage, int pageSize){

    }
    public PageBean(int currentPage, int pageSize, int countNums,int totalNum){
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.totalNum = totalNum;
    }
    @Override
    public String toString() {
        return "PageBean{" +
                "currentPage=" + currentPage +
                ", pageSize=" + pageSize +
                ", totalNum=" + totalNum +
                ", isMore=" + isMore +
                ", totalPage=" + totalPage +
                ", startIndex=" + startIndex +
                ", items=" + items +
                '}';
    }

    public PageBean(Integer currentPage, Integer pageSize, Integer totalNum, Integer isMore, Integer totalPage, Integer startIndex, List<T> items) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.totalNum = totalNum;
        this.isMore = isMore;
        this.totalPage = totalPage;
        this.startIndex = startIndex;
        this.items = items;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Integer totalNum) {
        this.totalNum = totalNum;
    }

    public Integer getIsMore() {
        return isMore;
    }

    public void setIsMore(Integer isMore) {
        this.isMore = isMore;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(Integer startIndex) {
        this.startIndex = startIndex;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }
}
