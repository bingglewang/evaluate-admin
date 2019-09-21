package com.spring.mpvue.springbootmpvue.mybatis.mapper;

import com.spring.mpvue.springbootmpvue.mybatis.po.Referencecase;
import com.spring.mpvue.springbootmpvue.mybatis.po.ReferencecaseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ReferencecaseMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table referencecase
     *
     * @mbggenerated Mon Mar 11 20:57:07 CST 2019
     */
    int countByExample(ReferencecaseExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table referencecase
     *
     * @mbggenerated Mon Mar 11 20:57:07 CST 2019
     */
    int deleteByExample(ReferencecaseExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table referencecase
     *
     * @mbggenerated Mon Mar 11 20:57:07 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table referencecase
     *
     * @mbggenerated Mon Mar 11 20:57:07 CST 2019
     */
    int insert(Referencecase record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table referencecase
     *
     * @mbggenerated Mon Mar 11 20:57:07 CST 2019
     */
    int insertSelective(Referencecase record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table referencecase
     *
     * @mbggenerated Mon Mar 11 20:57:07 CST 2019
     */
    List<Referencecase> selectByExample(ReferencecaseExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table referencecase
     *
     * @mbggenerated Mon Mar 11 20:57:07 CST 2019
     */
    Referencecase selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table referencecase
     *
     * @mbggenerated Mon Mar 11 20:57:07 CST 2019
     */
    int updateByExampleSelective(@Param("record") Referencecase record, @Param("example") ReferencecaseExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table referencecase
     *
     * @mbggenerated Mon Mar 11 20:57:07 CST 2019
     */
    int updateByExample(@Param("record") Referencecase record, @Param("example") ReferencecaseExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table referencecase
     *
     * @mbggenerated Mon Mar 11 20:57:07 CST 2019
     */
    int updateByPrimaryKeySelective(Referencecase record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table referencecase
     *
     * @mbggenerated Mon Mar 11 20:57:07 CST 2019
     */
    int updateByPrimaryKey(Referencecase record);
}