package com.spring.mpvue.springbootmpvue.sqlserver.po;

import java.util.Date;

public class HouseAndRealestate {
    private Integer id;          //主键
    private Date gjsd;           //案例的时间
    private String build;        //案例楼盘（）
    private String rsDz;         //案例地址
    private Double rsDj;         //案例价格
    private String cx;           //案例朝向
    private String rsMj;         //案例面积
    private String zx;           //案例装修程度
    private String zcs;          //案例总层数
    private String pgc;          //案例所在层数
    private String pm;
    private String wq;          //案例外墙装饰
    private String jg;          //案例结构
    private String yt;
    private String completedDate;   //案例建筑年份
    private String rsType;          //案例建筑类型
    private String area;            //案例区域

    public HouseAndRealestate() {
    }

    public HouseAndRealestate(Integer id, Date gjsd, String build, String rsDz, Double rsDj, String cx, String rsMj, String zx, String zcs, String pgc, String pm, String wq, String jg, String yt, String completedDate, String rsType,String area) {
        this.id = id;
        this.gjsd = gjsd;
        this.build = build;
        this.rsDz = rsDz;
        this.rsDj = rsDj;
        this.cx = cx;
        this.rsMj = rsMj;
        this.zx = zx;
        this.zcs = zcs;
        this.pgc = pgc;
        this.pm = pm;
        this.wq = wq;
        this.jg = jg;
        this.yt = yt;
        this.completedDate = completedDate;
        this.rsType = rsType;
        this.area = area;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getGjsd() {
        return gjsd;
    }

    public void setGjsd(Date gjsd) {
        this.gjsd = gjsd;
    }

    public String getBuild() {
        return build;
    }

    public void setBuild(String build) {
        this.build = build;
    }

    public String getRsDz() {
        return rsDz;
    }

    public void setRsDz(String rsDz) {
        this.rsDz = rsDz;
    }

    public Double getRsDj() {
        return rsDj;
    }

    public void setRsDj(Double rsDj) {
        this.rsDj = rsDj;
    }

    public String getCx() {
        return cx;
    }

    public void setCx(String cx) {
        this.cx = cx;
    }

    public String getRsMj() {
        return rsMj;
    }

    public void setRsMj(String rsMj) {
        this.rsMj = rsMj;
    }

    public String getZx() {
        return zx;
    }

    public void setZx(String zx) {
        this.zx = zx;
    }

    public String getZcs() {
        return zcs;
    }

    public void setZcs(String zcs) {
        this.zcs = zcs;
    }

    public String getPgc() {
        return pgc;
    }

    public void setPgc(String pgc) {
        this.pgc = pgc;
    }

    public String getPm() {
        return pm;
    }

    public void setPm(String pm) {
        this.pm = pm;
    }

    public String getWq() {
        return wq;
    }

    public void setWq(String wq) {
        this.wq = wq;
    }

    public String getJg() {
        return jg;
    }

    public void setJg(String jg) {
        this.jg = jg;
    }

    public String getYt() {
        return yt;
    }

    public void setYt(String yt) {
        this.yt = yt;
    }

    public String getCompletedDate() {
        return completedDate;
    }

    public void setCompletedDate(String completedDate) {
        this.completedDate = completedDate;
    }

    public String getRsType() {
        return rsType;
    }

    public void setRsType(String rsType) {
        this.rsType = rsType;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}
