package com.my.common.constant;

public interface CommonConstant {

    String SUCCESS_0 = "0";

    String FALSE_1 = "1";

    String INTERNAL_SERVER_ERROR_500 = "500";

    String OK_200 = "200";

    String ERROR = "-1";

    //默认最小分页size
    Integer MIN_PAGE_SIZE = 10;

    //默认最小分页
    Integer MIN_PAGE_NUM = 1;

    Integer ZERO = 0;

    //图标
    String ICON = "icon";

    String APP = "app";

    String MANUAL = "manual";

    String CONFIGURATION = "configuration";

    //业务状态码
    String HTTP_NOT_SINGIN = "300001";
    String BCID = "99";

    //省市物管平台数据上报数据的实际上传数据量
    public static final String SECONDARYPLATFORMPUSHDATANUM = "30";

    /**
     * 消息类型
     *
     * @author ck
     */
    public static interface MESSAGE_TYPE {
        /**
         * 省平台向总部推送设备基础信息类消息
         */
        public static final String DEVICEINFO = "deviceInfo";

        /**
         * 省公司扩展物联模型消息
         */
        public static final String EXTENDMODEL = "extendModel";

        /**
         * 省公司自定义物联模型消息
         */
        public static final String MODELPROVINCE = "modelProvince";

        /**
         * 省公司设备运行状态消息
         */
        public static final String MONITORDEVICERUN = "deviceRunStatistics";

        /**
         * 省公司边缘代理app消息
         */
        public static final String MONITORDEVICEAPP = "deviceAppStatistics";


        /**
         * 总部物联模型类消息
         */
        public static final String UNITEMODEL = "uniteModel";

        /**
         * 省平台向总部推送物联模型结果类消息
         */
        public static final String UNITEMODELACK = "uniteModelAck";

        /**
         * 新增的消息类型：
         * 省平台向总部推送的边缘代理设备类消息
         */
        public static final String EDGE = "edge";

        /**
         * 总部边缘应用基本信息消息
         */
        public static final String UNITEAPP = "uniteApp";

        /**
         * 省平台向总部推送应用基本信息入库结果消息
         */
        public static final String UNITEAPPACK = "uniteAppAck";

        /**
         * 省平台向总部推送设备接入统计类消息
         */
        public static final String DEVICEACCESSSTATISTICS = "deviceAccessStatistics";

        /**
         * 省平台向总部推送厂商设备统计类消息
         */
        public static final String MANUFACTURERDEVICESTATISTICS = "manufacturerDeviceStatistics";

        /**
         * 省平台向总部推送平台服务能力统计消息
         */
        public static final String PLATFORMSERVICESTATISTICS = "platformServiceStatistics";

        /**
         * 省平台向总部推送支撑业务系统信息消息
         */
        public static final String SUPPORTEDBUSINESSSTATISTICS = "supportedBusinessStatistics";

        /**
         * 省平台向总部推送物联模型统计类消息
         */
        public static final String MODELSTATISTICS = "modelStatistics";

        /**
         * 省平台向总部推送边缘应用统计类消息
         */
        public static final String APPSTATISTICS = "appStatistics";

    }

    /**
     * 各个指标id
     */
    public static interface KPI_ID {
        /**
         * 省市物管平台数据上报数据的上报延迟次数
         */
        public static final String SECONDARYPLATFORMPUSHDELAYNUM = "secondaryPlatformPushDelayNum";

        /**
         * 省市物管平台数据上报数据的上报次数
         */
        public static final String SECONDARYPLATFORMPUSHNUM = "secondaryPlatformPushNum";

        /**
         * 省市物管平台数据上报数的请求上传数据量
         */
        public static final String SECONDARYPLATFORMPUSHDATAREGULARNUM = "secondaryPlatformPushDataRegularNum";

    }

    /**
     * 各个指标id
     */
    public static interface KPI_NAME {
        /**
         * 省市物管平台数据上报数据的上报延迟次数
         */
        public static final String SECONDARYPLATFORMPUSHDELAYNUM = "省市物管平台数据上报数据的上报延迟次数";

        /**
         * 省市物管平台数据上报数据的上报次数
         */
        public static final String SECONDARYPLATFORMPUSHNUM = "省市物管平台数据上报数据的上报次数";

        /**
         * 省市物管平台数据上报数的请求上传数据量
         */
        public static final String SECONDARYPLATFORMPUSHDATAREGULARNUM = "省市物管平台数据上报数的请求上传数据量";

    }

    //是否物理删除
    String DELETED_FLAG_Y = "Y";
    String DELETED_FLAG_N = "N";
    //定义日志表(1，新增，2，修改，3，删除)
    Integer OPERATION_1 = 1;
    Integer OPERATION_2 = 2;
    Integer OPERATION_3 = 3;
    Integer OPERATION_0 = 0;


    //首页,单位
    String HEADCOENTSCONFIGDW = "test1,test2";

    //首页,总部
    String HEADCOENTSCONFIGZB = "fun_home_device_access,fun_home_object_association,fun_home_todo_list,fun_home_appinstall,fun_home_apprank,fun_home_terminal_statistic";

    //非总部用户首页默认权限
    String HEADUSERPOWER = "1,71,72,75,79,80";

    //非总部用户能勾选的菜单id
    String HEADUSERPOWERTRUE = "72,75,79,80,6,11,12,14,45,46,47,48";

}
