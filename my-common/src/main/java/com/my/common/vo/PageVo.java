package com.my.common.vo;

import java.io.Serializable;
import java.util.List;

/**
 * @author: 周立雄
 * @version: v1.0
 * @description: 简化版的分页对象，PageHelper的分页对象太完善太复杂了
 * @date: 2020/8/2
 */
public class PageVo<T> implements Serializable {
    private static final long serialVersionUID = -3256519103131877313L;

    /**
     * 当前页码
     */
    private int pageNum;
    /**
     * 页面记录条数
     */
    private int pageSize;
    /**
     * 总记录数
     */
    private long total;
    /**
     * 查询到的数据
     */
    private List<T> list;

    public PageVo() {
        this.pageNum = 1;
        this.pageSize = 10;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}