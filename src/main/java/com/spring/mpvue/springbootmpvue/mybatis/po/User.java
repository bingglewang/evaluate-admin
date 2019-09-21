package com.spring.mpvue.springbootmpvue.mybatis.po;

import java.util.Date;

public class User {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.ID
     *
     * @mbggenerated Mon Mar 11 20:57:07 CST 2019
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.open_id
     *
     * @mbggenerated Mon Mar 11 20:57:07 CST 2019
     */
    private String openId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.nick_name
     *
     * @mbggenerated Mon Mar 11 20:57:07 CST 2019
     */
    private String nickName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.user_image
     *
     * @mbggenerated Mon Mar 11 20:57:07 CST 2019
     */
    private String userImage;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.phone_number
     *
     * @mbggenerated Mon Mar 11 20:57:07 CST 2019
     */
    private String phoneNumber;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.sex
     *
     * @mbggenerated Mon Mar 11 20:57:07 CST 2019
     */
    private Integer sex;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.user_name
     *
     * @mbggenerated Mon Mar 11 20:57:07 CST 2019
     */
    private String userName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.user_mail
     *
     * @mbggenerated Mon Mar 11 20:57:07 CST 2019
     */
    private String userMail;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.enable_count
     *
     * @mbggenerated Mon Mar 11 20:57:07 CST 2019
     */
    private Integer enableCount;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.start_enable_time
     *
     * @mbggenerated Mon Mar 11 20:57:07 CST 2019
     */
    private Date startEnableTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.end_enable_time
     *
     * @mbggenerated Mon Mar 11 20:57:07 CST 2019
     */
    private Date endEnableTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.del_flag
     *
     * @mbggenerated Mon Mar 11 20:57:07 CST 2019
     */
    private String delFlag;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.register_date
     *
     * @mbggenerated Mon Mar 11 20:57:07 CST 2019
     */
    private Date registerDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.back1
     *
     * @mbggenerated Mon Mar 11 20:57:07 CST 2019
     */
    private String back1;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.back2
     *
     * @mbggenerated Mon Mar 11 20:57:07 CST 2019
     */
    private String back2;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.back3
     *
     * @mbggenerated Mon Mar 11 20:57:07 CST 2019
     */
    private Date back3;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.back4
     *
     * @mbggenerated Mon Mar 11 20:57:07 CST 2019
     */
    private String back4;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.ID
     *
     * @return the value of user.ID
     *
     * @mbggenerated Mon Mar 11 20:57:07 CST 2019
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.ID
     *
     * @param id the value for user.ID
     *
     * @mbggenerated Mon Mar 11 20:57:07 CST 2019
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.open_id
     *
     * @return the value of user.open_id
     *
     * @mbggenerated Mon Mar 11 20:57:07 CST 2019
     */
    public String getOpenId() {
        return openId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.open_id
     *
     * @param openId the value for user.open_id
     *
     * @mbggenerated Mon Mar 11 20:57:07 CST 2019
     */
    public void setOpenId(String openId) {
        this.openId = openId == null ? null : openId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.nick_name
     *
     * @return the value of user.nick_name
     *
     * @mbggenerated Mon Mar 11 20:57:07 CST 2019
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.nick_name
     *
     * @param nickName the value for user.nick_name
     *
     * @mbggenerated Mon Mar 11 20:57:07 CST 2019
     */
    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.user_image
     *
     * @return the value of user.user_image
     *
     * @mbggenerated Mon Mar 11 20:57:07 CST 2019
     */
    public String getUserImage() {
        return userImage;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.user_image
     *
     * @param userImage the value for user.user_image
     *
     * @mbggenerated Mon Mar 11 20:57:07 CST 2019
     */
    public void setUserImage(String userImage) {
        this.userImage = userImage == null ? null : userImage.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.phone_number
     *
     * @return the value of user.phone_number
     *
     * @mbggenerated Mon Mar 11 20:57:07 CST 2019
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.phone_number
     *
     * @param phoneNumber the value for user.phone_number
     *
     * @mbggenerated Mon Mar 11 20:57:07 CST 2019
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber == null ? null : phoneNumber.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.sex
     *
     * @return the value of user.sex
     *
     * @mbggenerated Mon Mar 11 20:57:07 CST 2019
     */
    public Integer getSex() {
        return sex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.sex
     *
     * @param sex the value for user.sex
     *
     * @mbggenerated Mon Mar 11 20:57:07 CST 2019
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.user_name
     *
     * @return the value of user.user_name
     *
     * @mbggenerated Mon Mar 11 20:57:07 CST 2019
     */
    public String getUserName() {
        return userName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.user_name
     *
     * @param userName the value for user.user_name
     *
     * @mbggenerated Mon Mar 11 20:57:07 CST 2019
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.user_mail
     *
     * @return the value of user.user_mail
     *
     * @mbggenerated Mon Mar 11 20:57:07 CST 2019
     */
    public String getUserMail() {
        return userMail;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.user_mail
     *
     * @param userMail the value for user.user_mail
     *
     * @mbggenerated Mon Mar 11 20:57:07 CST 2019
     */
    public void setUserMail(String userMail) {
        this.userMail = userMail == null ? null : userMail.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.enable_count
     *
     * @return the value of user.enable_count
     *
     * @mbggenerated Mon Mar 11 20:57:07 CST 2019
     */
    public Integer getEnableCount() {
        return enableCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.enable_count
     *
     * @param enableCount the value for user.enable_count
     *
     * @mbggenerated Mon Mar 11 20:57:07 CST 2019
     */
    public void setEnableCount(Integer enableCount) {
        this.enableCount = enableCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.start_enable_time
     *
     * @return the value of user.start_enable_time
     *
     * @mbggenerated Mon Mar 11 20:57:07 CST 2019
     */
    public Date getStartEnableTime() {
        return startEnableTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.start_enable_time
     *
     * @param startEnableTime the value for user.start_enable_time
     *
     * @mbggenerated Mon Mar 11 20:57:07 CST 2019
     */
    public void setStartEnableTime(Date startEnableTime) {
        this.startEnableTime = startEnableTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.end_enable_time
     *
     * @return the value of user.end_enable_time
     *
     * @mbggenerated Mon Mar 11 20:57:07 CST 2019
     */
    public Date getEndEnableTime() {
        return endEnableTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.end_enable_time
     *
     * @param endEnableTime the value for user.end_enable_time
     *
     * @mbggenerated Mon Mar 11 20:57:07 CST 2019
     */
    public void setEndEnableTime(Date endEnableTime) {
        this.endEnableTime = endEnableTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.del_flag
     *
     * @return the value of user.del_flag
     *
     * @mbggenerated Mon Mar 11 20:57:07 CST 2019
     */
    public String getDelFlag() {
        return delFlag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.del_flag
     *
     * @param delFlag the value for user.del_flag
     *
     * @mbggenerated Mon Mar 11 20:57:07 CST 2019
     */
    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.register_date
     *
     * @return the value of user.register_date
     *
     * @mbggenerated Mon Mar 11 20:57:07 CST 2019
     */
    public Date getRegisterDate() {
        return registerDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.register_date
     *
     * @param registerDate the value for user.register_date
     *
     * @mbggenerated Mon Mar 11 20:57:07 CST 2019
     */
    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.back1
     *
     * @return the value of user.back1
     *
     * @mbggenerated Mon Mar 11 20:57:07 CST 2019
     */
    public String getBack1() {
        return back1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.back1
     *
     * @param back1 the value for user.back1
     *
     * @mbggenerated Mon Mar 11 20:57:07 CST 2019
     */
    public void setBack1(String back1) {
        this.back1 = back1 == null ? null : back1.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.back2
     *
     * @return the value of user.back2
     *
     * @mbggenerated Mon Mar 11 20:57:07 CST 2019
     */
    public String getBack2() {
        return back2;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.back2
     *
     * @param back2 the value for user.back2
     *
     * @mbggenerated Mon Mar 11 20:57:07 CST 2019
     */
    public void setBack2(String back2) {
        this.back2 = back2 == null ? null : back2.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.back3
     *
     * @return the value of user.back3
     *
     * @mbggenerated Mon Mar 11 20:57:07 CST 2019
     */
    public Date getBack3() {
        return back3;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.back3
     *
     * @param back3 the value for user.back3
     *
     * @mbggenerated Mon Mar 11 20:57:07 CST 2019
     */
    public void setBack3(Date back3) {
        this.back3 = back3;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.back4
     *
     * @return the value of user.back4
     *
     * @mbggenerated Mon Mar 11 20:57:07 CST 2019
     */
    public String getBack4() {
        return back4;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.back4
     *
     * @param back4 the value for user.back4
     *
     * @mbggenerated Mon Mar 11 20:57:07 CST 2019
     */
    public void setBack4(String back4) {
        this.back4 = back4 == null ? null : back4.trim();
    }
}