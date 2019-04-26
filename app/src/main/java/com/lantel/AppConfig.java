package com.lantel;

/**
 * Created by 冯支.
 * function:
 * Date: 2019/4/26
 * Time: 15:50
 */
public class AppConfig {
    /*************************************************** 模块：splash ***************************************************/
    //资源模式
    public static final String RES_MODE = "RES_MODE";

    //获取资源模式，0:本地资源
    public static final int MODE_LOACL = 0;

    //本地资源 int数组
    public static final String LOACL_RES_LIST = "LOACL_RES_LIST";

    //获取资源模式，1:网络资源
    public static final int MODE_NET = 1;

    //网络资源 string集合
    public static final String NET_RES_LIST = "NET_RES_LIST";

   /*************************************************** 模块：我的 ***************************************************/
    /**
     * 布局viewType标志，TYPE_HEAD头布局，TYPE_ITEM选项布局
     */
    public static final int TYPE_HEAD = 0x10;  //头布局
    public static final int TYPE_ITEM = 0x11;  //中间布局
    public static final int TYPE_AD = 0x12;  //结尾布局

    /**
     * 跳转ACTION标志
     */
    public static final int ACTION_FILE = 0; //我的文件
    public static final int ACTION_CHANNEL = 1; //我的渠道
    public static final int ACTION_OUTPUT = 2; //我的产出
    public static final int ACTION_ROLE_PERMISSION = 3; //角色权限
    public static final int ACTION_FEEDBACK = 4; //意见反馈


    /*************************************************** 模块：主页 ***************************************************/
    /**
     * 跳转ACTION标志
     */
    public static final int ACTION_MARKET_LIST = 5; //市场名单
    public static final int ACTION_REGISTRATION_FEE = 6; //客户跟单
    public static final int ACTION_CURRICULUM = 7; //报名缴费
    public static final int ACTION_CURRICULM = 8; //课表
    public static final int ACTION_ATTENCE = 9; //考勤
    public static final int ACTION_PREPARE_LESSON = 10; //备课
    public static final int ACTION_CLASS_REVIEW = 11; //课评
    public static final int ACTION_HOMEWORK = 12; //作业
    public static final int ACTION_WORK = 13; //作品
    public static final int ACTION_REPORT_FORMS = 14; //报表
    public static final int ACTION_DEAL_WITH = 15; //待办
    public static final int ACTION_SETTING = 16; //设置



    public static final int REQUEST_CODE_SCAN = 100;
}
