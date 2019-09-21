package com.spring.mpvue.springbootmpvue.controller;

import com.spring.mpvue.springbootmpvue.mybatis.mapper.RecordMapper;
import com.spring.mpvue.springbootmpvue.mybatis.mapper.ReferencecaseMapper;
import com.spring.mpvue.springbootmpvue.mybatis.mapper.UserMapper;
import com.spring.mpvue.springbootmpvue.mybatis.po.*;
import com.spring.mpvue.springbootmpvue.sqlserver.App;
import com.spring.mpvue.springbootmpvue.sqlserver.mapper.HouseAndRealestateMapper;
import com.spring.mpvue.springbootmpvue.sqlserver.mapper.UdsHourseMapper;
import com.spring.mpvue.springbootmpvue.sqlserver.po.HouseAndRealestate;
import com.spring.mpvue.springbootmpvue.sqlserver.po.UdsHourse;
import com.spring.mpvue.springbootmpvue.util.DateUtil;
import com.spring.mpvue.springbootmpvue.util.FormatAddressUtil;
import com.spring.mpvue.springbootmpvue.util.ParamConfig;
import com.spring.mpvue.springbootmpvue.util.SwitchNumber;
import io.swagger.annotations.*;
import io.swagger.models.auth.In;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
@RequestMapping("/evaluate")
@Api(value = "SqlServerController", tags = {"房地产自动估价接口"})
public class SqlServerController {
    private static Logger log = LoggerFactory.getLogger(SqlServerController.class);
    private SqlSession session;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ReferencecaseMapper referencecaseMapper;

    @Autowired
    private RecordMapper recordMapper;

    /**
     * 估价接口(第三方数据库sqlserver2008)
     */
    @ResponseBody
    @RequestMapping("/autoEvaluate")
    @ApiOperation(value = "自动估价接口", httpMethod = "POST", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "房价查询"),
            @ApiResponse(code = 500, message = "500(系统错误)", response = String.class)
    })
    public Object autoEvaluate(
            @ApiParam(value = "房价查询参数", required = true)
            @RequestBody final UdsHourse udsHourse
    ) {
        session = App.getSqlSession();
        UdsHourseMapper udsHourseMapper = session.getMapper(UdsHourseMapper.class);
        List<UdsHourse> udsHourseList = udsHourseMapper.selectByExample(null);
        App.closeSession(session);
        return udsHourseList;
    }

    /**
     * 向表中插入数据
     */
    @ResponseBody
    @RequestMapping("/insert")
    @ApiOperation(value = "插入房子数据", httpMethod = "POST", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "插入房子信息"),
            @ApiResponse(code = 500, message = "500(系统错误)", response = String.class)
    })
    public Object insert(
            @ApiParam(value = "房子插入参数", required = true)
            @RequestBody final UdsHourse udsHourse
    ) {
        session = App.getSqlSession();
        UdsHourseMapper udsHourseMapper = session.getMapper(UdsHourseMapper.class);
        int result = udsHourseMapper.insertSelective(udsHourse);
        session.commit();
        App.closeSession(session);
        return result;
    }

    /**
     * 联表查询house和realestate根据的地址楼盘
     *
     * @return
     */
    @RequestMapping("/getHouseByAddress")
    @ResponseBody
    @ApiOperation(value = "根据地址连表查询房子信息", httpMethod = "POST", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "根据地址连表查询房子信息"),
            @ApiResponse(code = 500, message = "500(系统错误)", response = String.class)
    })
    public Map<String, Object> selectHouseAndRealestateByaddress(
            @ApiParam(value = "表单值", required = true)
            @RequestBody final Record record
    ) {
        Map<String, Object> result = new HashMap<String, Object>();
        session = App.getSqlSession();
        HouseAndRealestateMapper houseAndRealestateMapper = session.getMapper(HouseAndRealestateMapper.class);
        List<HouseAndRealestate> houseAndRealestateListOld = houseAndRealestateMapper.selectHouseRealestateByAddress(record.getDetailAddress());
        //楼层系数
        String recorddLc = "";
        String recordZcs = "";
        if (StringUtils.isNotBlank(record.getFloor())) {
            String targetLc = record.getFloor().split("/")[0];
            String targetZcs = record.getFloor().split("/")[1];
            recorddLc = targetLc.substring(0, targetLc.length() - 1);
            recordZcs = targetZcs.substring(0, targetZcs.length() - 1);
        }
        System.out.println("用户输入的楼层：" + recorddLc + "," + recordZcs);
        int recordZcsInt = Integer.parseInt(recordZcs);

       /* *//*获取用户输入的地址区域*//*
        String distinct = FormatAddressUtil.formatAddress(record.getDetailAddress());*/
        String distinct = record.getBack3();
        System.out.println("区域："+distinct);
        List<HouseAndRealestate> houseAndRealestateList = new ArrayList<>();
        for (int i = 0; i < houseAndRealestateListOld.size(); i++) {
            /*1.过滤掉 非住宅，商铺，办公楼 的案例不参与计算
             * 2.如果用户输入的总层数在1到4，则为小高层（别墅或者自建的低层住宅）则选1-4的案例参与计算，
             *   如果用户输入的总层数在5到8，则为高层（步梯），则选5-8的案例参与计算，
             *   如果用户输入的总层数在9层以上，则为超高层（电梯），则选9层以上的参与计算。
             * 3.只取出和用户输入的地址同一个区域的案例进行计算。
             * 4.过滤掉一年之外的案例
             * */
            //选出同区域的案例parseString2Date("2017-12-21")
          /*  System.out.println("案例时间原始："+DateUtil.format(houseAndRealestateListOld.get(i).getGjsd()));
            System.out.println("案例时间加一年："+DateUtil.addYearData(houseAndRealestateListOld.get(i).getGjsd()));
            System.out.println("当前日期是否在内："+DateUtil.belongCalendar(new Date(),houseAndRealestateListOld.get(i).getGjsd(),DateUtil.parseString2Date(DateUtil.addYearData(houseAndRealestateListOld.get(i).getGjsd()))));*/
           /* if(true){*/
            if (distinct.indexOf(houseAndRealestateListOld.get(i).getArea()) > -1 && StringUtils.isNotBlank(houseAndRealestateListOld.get(i).getArea())) {
                //过滤掉 非住宅，商铺，办公楼,商业，商住，住宅非住宅，车位 的案例不参与计算
               /* if (!(houseAndRealestateListOld.get(i).getRsType().indexOf("非住宅") > -1 || houseAndRealestateListOld.get(i).getRsType().indexOf("商铺") > -1 || houseAndRealestateListOld.get(i).getRsType().indexOf("办公楼") > -1 || houseAndRealestateListOld.get(i).getRsType().indexOf("商业") > -1 || houseAndRealestateListOld.get(i).getRsType().indexOf("住宅非住宅") > -1 || houseAndRealestateListOld.get(i).getRsType().indexOf("商住") > -1 || houseAndRealestateListOld.get(i).getRsType().indexOf("车位") > -1 || houseAndRealestateListOld.get(i).getRsType().indexOf("工业") > -1 || houseAndRealestateListOld.get(i).getRsType().indexOf("办公") > -1  || houseAndRealestateListOld.get(i).getRsType().indexOf("厂房") > -1 || houseAndRealestateListOld.get(i).getRsType().indexOf("仓库") > -1 || houseAndRealestateListOld.get(i).getRsType().indexOf("宿舍") > -1)) {*/
                 if(houseAndRealestateListOld.get(i).getRsType().indexOf("住宅") > -1 && !(houseAndRealestateListOld.get(i).getRsType().indexOf("非住宅") > -1)){
                     //过滤掉非一年之内的案例
                     if(DateUtil.belongCalendar(new Date(),houseAndRealestateListOld.get(i).getGjsd(),DateUtil.parseString2Date(DateUtil.addYearData(houseAndRealestateListOld.get(i).getGjsd())))) {
                         int zcs = 0;
                         try {
                             zcs = Integer.parseInt(houseAndRealestateListOld.get(i).getZcs());
                         } catch (Exception e) {
                             e.printStackTrace();
                         }
                         if (recordZcsInt >= 1 && recordZcsInt <= 4) {
                             //小高层(别墅或者自建的低层住宅）
                             if (zcs >= 1 && zcs <= 4) {
                                 houseAndRealestateList.add(houseAndRealestateListOld.get(i));
                             }
                         } else if (recordZcsInt >= 5 && recordZcsInt <= 8) {
                             //高层（步梯）
                             if (zcs >= 5 && zcs <= 8) {
                                 houseAndRealestateList.add(houseAndRealestateListOld.get(i));
                             }
                         } else if (recordZcsInt >= 9) {
                             //超高层（电梯）
                             if (zcs >= 9) {
                                 houseAndRealestateList.add(houseAndRealestateListOld.get(i));
                             }
                         }
                     }
                }
            }
        }

        log.info("查询结果：" + houseAndRealestateList);
        if (houseAndRealestateList.size() > 0 && houseAndRealestateList.size() <= 3) {

        } else if (houseAndRealestateList.size() > 3) {
            houseAndRealestateList = houseAndRealestateList.subList(0, 3);

        } else {
            result.put("status", -1);
            result.put("msg", "如果无法查找结果，请确认楼盘名称或地址是否正确，若确认后仍无法查找结果，请将地址精确至楼幢或街道号");
            result.put("data", "0   ");
            return result;
        }
        double evaluate = 0;
        StringBuffer builder_year = new StringBuffer();
        for (int i = 0; i < houseAndRealestateList.size(); i++) {
               /* 方法2：通过楼盘名搜索案例，按照估价时点倒序，取前面的三个案例,每个案例的价格*楼层系数*朝向系数*面积系数*装修程度系数=自动估价的值，三个结果平均=自动估价的值
                如果没有三个案例也可以计算，但至少需要一个案例*/
            HouseAndRealestate tempHouseEvaluate = houseAndRealestateList.get(i);
            //建筑年代
            if(StringUtils.isNotBlank(tempHouseEvaluate.getCompletedDate())){
                builder_year.append(tempHouseEvaluate.getCompletedDate().substring(0,4)+",");
            }
            //案例价格
            double price = 0;
            System.out.println("价格：" + tempHouseEvaluate.getRsDj());
            if (tempHouseEvaluate.getRsDj() != null && tempHouseEvaluate.getRsDj().toString() != "") {
                price = tempHouseEvaluate.getRsDj();
            }

            //朝向系数
            Double cxParam = ParamConfig.getOrientationParam(tempHouseEvaluate.getCx(), record.getOrientation());
            //面积系数
            Double areaParam = ParamConfig.getAreaParam(tempHouseEvaluate.getRsMj(), record.getArea());
            //所在楼层系数
            Double floorParam = ParamConfig.getFloorParam(tempHouseEvaluate.getPgc(),tempHouseEvaluate.getZcs(),recorddLc,recordZcs);

            System.out.println("评估打印的值：" + price + "," + "," + cxParam + "," + areaParam + ","+floorParam);
            evaluate += price * cxParam * areaParam * floorParam;
        }
        //装修程度系数
        Double decorationParam = ParamConfig.getDecorationDegreeParam(record.getDegreeDecoration());
        System.out.println("装修程度参数"+decorationParam);
        //户型系数
        System.out.println("户型：" + record.getHouseType().split("室")[0]);
        int houseCount = Integer.parseInt(record.getHouseType().split("室")[0]);
        String houseType = "";
        //hx1,hx2,hx3,hx4,hx5
        if(houseCount == 1){
            houseType = "hx1";
        }else if(houseCount == 2){
            houseType = "hx2";
        }else if(houseCount == 3){
            houseType = "hx3";
        }else if(houseCount == 4){
            houseType = "hx4";
        }else if(houseCount > 5){
            houseType = "hx5";
        }
        Double pmParam = ParamConfig.getPMParm(houseType);

        System.out.println("户型参数："+pmParam);

        double avgEvalute = (evaluate / houseAndRealestateList.size()) * decorationParam * pmParam;

        //建筑年代
        System.out.println("建筑年代："+Arrays.asList(builder_year.toString().split(",")));
        //判断众数
        String[] array_build_year = builder_year.toString().split(",");
        List<Integer> build_year_list = new ArrayList<Integer>();
        for(int j = 0;j<array_build_year.length;j++){
            int parseIntBuild = 0;
            try{
                parseIntBuild = Integer.parseInt(array_build_year[j]);
            }catch (Exception e){
                e.printStackTrace();
            }
            if(parseIntBuild != 0) {
                build_year_list.add(parseIntBuild);
            }
        }
        Integer[] listArray = new Integer[build_year_list.size()];//当泛型为Integer时，需要
        listArray =  (Integer[])build_year_list.toArray(listArray);
        int zhongshu = SwitchNumber.majorityElement(listArray);
        if(zhongshu != 0){
            builder_year = new StringBuffer(zhongshu+",");
        }else {
            if(build_year_list.size() > 0){
                StringBuffer listStringBuffer = new StringBuffer();
                for(int i = 0;i< build_year_list.size();i++){
                    listStringBuffer.append(build_year_list.get(i)+",");
                }
                builder_year = listStringBuffer;
            }
        }
        System.out.println("建筑年代："+builder_year);
        record.setBuildYear(builder_year.toString().split(",")[0]);

        //向record表中插入数据


        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andOpenIdEqualTo(record.getOpenId());
        //用户是否被禁用
        criteria.andDelFlagEqualTo("N");
        List<User> userList = userMapper.selectByExample(userExample);
        if (userList.size() > 0) {
            //插入用户姓名
            record.setBack1(userList.get(0).getUserName());
            //查询结果
            record.setQueryResult(Math.round(avgEvalute) + "");
            //想back5中存总价格
            String totalResult = Math.round((Float.parseFloat(record.getArea()) * Float.parseFloat(record.getQueryResult())) / 10000) + "";
            record.setBack5(totalResult);
            //建筑年代（查询的案例中的众数或者用户输入的年代）
            int i = recordMapper.insertSelective(record);
            log.info("我的id:" + record.getId());
            if (i > 0) {
                //每查询一次更改用户可查询次数
                UserExample userExample1 = new UserExample();
                UserExample.Criteria criteria1 = userExample1.createCriteria();
                if (StringUtils.isNotBlank(record.getOpenId())) {
                    criteria1.andOpenIdEqualTo(record.getOpenId());
                }
                List<User> userList1 = userMapper.selectByExample(userExample1);
                User saveUser = new User();
                if (userList1 != null && userList1.size() > 0) {
                    //如果在查询时间段内，则不修改查询次数，否则修改
                    if ("N".equals(userList1.get(0).getBack4())) {
                        saveUser.setEnableCount(userList1.get(0).getEnableCount() - 1);
                        userMapper.updateByExampleSelective(saveUser, userExample1);
                    }
                }
                //向参考案例表中插入数据

                for (int j = 0; j < houseAndRealestateList.size(); j++) {
                    Referencecase referencecase = new Referencecase();
                    if (houseAndRealestateList.get(j).getGjsd() != null) {
                        referencecase.setGjsd(houseAndRealestateList.get(j).getGjsd());
                    }
                    if (houseAndRealestateList.get(j).getRsDj() != null) {
                        referencecase.setRsDz(houseAndRealestateList.get(j).getRsDj().toString());
                    }
                    if (StringUtils.isNotBlank(houseAndRealestateList.get(j).getRsDz())) {
                        referencecase.setBuild(houseAndRealestateList.get(j).getRsDz());
                    }
                    if (StringUtils.isNotBlank(houseAndRealestateList.get(j).getPgc()) && StringUtils.isNotBlank(houseAndRealestateList.get(j).getZcs())) {
                        referencecase.setLc(houseAndRealestateList.get(j).getPgc() + "层/" + houseAndRealestateList.get(j).getZcs() + "层");
                    }
                    if (StringUtils.isNotBlank(houseAndRealestateList.get(j).getPm())) {
                        referencecase.setPm(houseAndRealestateList.get(j).getPm());
                    }
                    if (StringUtils.isNotBlank(houseAndRealestateList.get(j).getCx())) {
                        referencecase.setCx(houseAndRealestateList.get(j).getCx());
                    }
                    if (StringUtils.isNotBlank(houseAndRealestateList.get(j).getRsMj())) {
                        referencecase.setRjMj(houseAndRealestateList.get(j).getRsMj());
                    }
                    if (StringUtils.isNotBlank(houseAndRealestateList.get(j).getZx())) {
                        referencecase.setZx(houseAndRealestateList.get(j).getZx());
                    }
                    if (StringUtils.isNotBlank(houseAndRealestateList.get(j).getWq())) {
                        referencecase.setWq(houseAndRealestateList.get(j).getWq());
                    }
                    if (StringUtils.isNotBlank(houseAndRealestateList.get(j).getCompletedDate())) {
                        referencecase.setCompletedate(houseAndRealestateList.get(j).getCompletedDate());
                    }
                    if (StringUtils.isNotBlank(houseAndRealestateList.get(j).getYt())) {
                        referencecase.setYt(houseAndRealestateList.get(j).getYt());
                    }
                    referencecase.setRecordId(record.getId());
                    referencecaseMapper.insertSelective(referencecase);
                }

                result.put("status", 0);
                result.put("msg", "success");
                result.put("data", avgEvalute);
                result.put("recordId", record.getId());
                result.put("builder_year",builder_year);
            } else {
                result.put("status", -2);
                result.put("msg", "查询失败");
                result.put("data", "");
                return result;
            }
        } else {
            result.put("status", -3);
            result.put("msg", "用户被禁用");
            result.put("data", "");
            return result;
        }
        return result;
    }
}
