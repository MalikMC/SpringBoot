package com.machun.springbootmybatisxml.entity;

/**
 * @Description:
 * @Author: machun
 * @CreateDate: 2020/3/29 11:54
 * @UpdateDate: 2020/3/29 11:54
 * @menu
 */
public class PageParam {

    //起始行
    private int beginLine;
    private Integer pageSize = 3;
    // 当前页
    private Integer currentPage=0;

    public void setBeginLine(int beginLine) {
        this.beginLine = beginLine;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

     /**
      * @description: 计算起始行
      * @author: machun
      * @updateUser: machun
      * @param
      * @return
      * @createDate: 2020/3/29 11:57
      * @updateDate: 2020/3/29 11:57
      * @version: V1.0
      * @status: undone
     */

    public int getBeginLine() {
        return pageSize*currentPage;
    }
}
