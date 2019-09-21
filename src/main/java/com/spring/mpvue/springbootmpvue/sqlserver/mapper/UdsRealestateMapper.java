package com.spring.mpvue.springbootmpvue.sqlserver.mapper;

import com.spring.mpvue.springbootmpvue.sqlserver.po.UdsRealestate;
import com.spring.mpvue.springbootmpvue.sqlserver.po.UdsRealestateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UdsRealestateMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table UDS_REALESTATE
     *
     * @mbggenerated Mon Sep 10 21:28:50 CST 2018
     */
    int countByExample(UdsRealestateExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table UDS_REALESTATE
     *
     * @mbggenerated Mon Sep 10 21:28:50 CST 2018
     */
    int deleteByExample(UdsRealestateExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table UDS_REALESTATE
     *
     * @mbggenerated Mon Sep 10 21:28:50 CST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table UDS_REALESTATE
     *
     * @mbggenerated Mon Sep 10 21:28:50 CST 2018
     */
    int insert(UdsRealestate record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table UDS_REALESTATE
     *
     * @mbggenerated Mon Sep 10 21:28:50 CST 2018
     */
    int insertSelective(UdsRealestate record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table UDS_REALESTATE
     *
     * @mbggenerated Mon Sep 10 21:28:50 CST 2018
     */
    List<UdsRealestate> selectByExample(UdsRealestateExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table UDS_REALESTATE
     *
     * @mbggenerated Mon Sep 10 21:28:50 CST 2018
     */
    UdsRealestate selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table UDS_REALESTATE
     *
     * @mbggenerated Mon Sep 10 21:28:50 CST 2018
     */
    int updateByExampleSelective(@Param("record") UdsRealestate record, @Param("example") UdsRealestateExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table UDS_REALESTATE
     *
     * @mbggenerated Mon Sep 10 21:28:50 CST 2018
     */
    int updateByExample(@Param("record") UdsRealestate record, @Param("example") UdsRealestateExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table UDS_REALESTATE
     *
     * @mbggenerated Mon Sep 10 21:28:50 CST 2018
     */
    int updateByPrimaryKeySelective(UdsRealestate record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table UDS_REALESTATE
     *
     * @mbggenerated Mon Sep 10 21:28:50 CST 2018
     */
    int updateByPrimaryKey(UdsRealestate record);
}