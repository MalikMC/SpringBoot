package com.machun.springbootmybatisxml.entity;

import java.io.Serializable;
import java.util.List;

/**
 * @Description:
 * @Author: machun
 * @CreateDate: 2020/3/29 12:33
 * @UpdateDate: 2020/3/29 12:33
 * @menu
 */
public class Page<E> implements Serializable {
    /**
     * 当前页数
     */
    private int currentPage = 0;

    /**
     * 总页数
     */
    private long totalPage;


    /**
     * 总记录数
     */
    private long totalNumber;
    /**
     *   数据集
     */
    private List<E> list;

    public Page(int currentPage, long totalPage, long totalNumber, List<E> list) {
        this.currentPage = currentPage;
        this.totalPage = totalPage;
        this.totalNumber = totalNumber;
        this.list = list;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public long getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(long totalPage) {
        this.totalPage = totalPage;
    }

    public long getTotalNumber() {
        return totalNumber;
    }

    public void setTotalNumber(long totalNumber) {
        this.totalNumber = totalNumber;
    }

    public List<E> getList() {
        return list;
    }

    public void setList(List<E> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "Page{" +
                "currentPage=" + currentPage +
                ", totalPage=" + totalPage +
                ", totalNumber=" + totalNumber +
                ", list=" + list +
                '}';
    }
}