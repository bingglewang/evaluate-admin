package com.spring.mpvue.springbootmpvue.sqlserver.mapper;

import com.spring.mpvue.springbootmpvue.sqlserver.po.HouseAndRealestate;

import java.util.List;

public interface HouseAndRealestateMapper {
    /**
     * 根据楼盘查询案例，house和realestate一对一联表查询
     */
     List<HouseAndRealestate> selectHouseRealestateByAddress(String address);
}
