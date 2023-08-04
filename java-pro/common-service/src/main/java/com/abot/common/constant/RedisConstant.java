package com.abot.common.constant;

/**
 * @author kamu
 * @date 2020-12-17 14:33
 */
public class RedisConstant {

    //缓存所有通过认证备案启用的医生的某些信息，供专题医生活动使用
    public static final String REDIS_DOCTOR_ALL = "cache_doctor_all";

    //缓存某一个专题的已经添加了的医生，hash结构，_后面是合作的专题活动的id
    public static final String REDIS_DOCTOR_ADDED = "cache_doctor_add_";

    //腾讯云cos 医生头像路径拼接
    public static final String QCLOUD_COS_URL = "https://xxm-cos-test-1251808769.cos.ap-guangzhou.myqcloud.com/";

    //app入口登录redis相关
    public static final String APP_LOGIN_TOKEN = "app:login:token:";

    // 患者app登录token
    public static final String APP_LOGIN_PATIENT_APP_TOKEN = "app:login:patient_app:token:";
    // 小程序登录token
    public static final String APP_LOGIN_MINI_PROGRAM_TOKEN = "app:login:mini_program:token:";

    //180天过期
    public static final Long APP_TOKEN_EXPIRED = 15552000L;

    //新命名规则：数据库名 + [表名:主键名:主键值]

    //大前缀   数据库名称(去掉medical_)
    private static final String REDIS_PRE_SYSTEM = "system:";

    //redis key :   hash存储通俗疾病数据
    public static final String COMMON_SICKNESS_ALL = RedisConstant.REDIS_PRE_SYSTEM + "common_sickness:all";

    //redis key :  存储疾病详情
    public static final String COMMON_SICKNESS_ID = RedisConstant.REDIS_PRE_SYSTEM + "common_sickness:id:";

    //新旧系统兼容，判断医生是否迁移，前端可能会传医生id或者不传医生id
    //redis key :  医生是否已经迁移前缀。      key dr:move:3366  value  1已经迁移， 0 没有迁移。
    public static final String REDIS_DOCTOR_MOVE = "dr:move:";

    //redis key :  没传医生id，缓存患者公众号openid      key openid:move:openid  value  1已经迁移， 0 没有迁移。
    public static final String REDIS_OPENID_MOVE = "openid:move:";

    //redis key ：定时任务中订单流水
    public static final String REDIS_SCHEDULE_PAYMENT = "schedule:payment:";

    //redis key ：定时任务中处方流水
    public static final String REDIS_SCHEDULE_PRESCRIPTION = "schedule:prescription:";

    //redis key ：定时任务中商品流水
    public static final String REDIS_SCHEDULE_PRODUCT = "schedule:product:";

    //redis key ：定时任务中问诊单
    public static final String REDIS_SCHEDULE_ENQUIRY = "schedule:enquiry:";

    //redis key ：定时任务中推送超时消息
    public static final String REDIS_SCHEDULE_WX_TEMPLATE_PUSH = "schedule:wx_push:";

    //redis key ：定时任务中通俗疾病库
    public static final String REDIS_COMMON_SICKNESS = "schedule:common_sickness:";

    //redis key ：定时任务中统计通俗疾病使用次数
    public static final String REDIS_COMMON_SICKNESS_CNT = "schedule:common_sickness_cnt:";

    //redis key : 申请提现加锁保证幂等key前缀,前缀会追加一个userid,value为uuid
    public static final String REDIS_APPLY_WITHDRAW = "app:apply.withdraw:userid:string:";

    //redis key : 支付回调计算积分加锁,保证幂等,追加一个业务单号,string为类型
    public static final String REDIS_CALLBACK_ADD_CREDIT = "app:callback_add_credit:string:";

    //redis key : 默认失效时间
    public static final long DEFAULT_EXPIRE_TIME = 3L;

    //redis key ：  存储人脸核身-获取Access Token
    public static final String FACE_AUTH_ACCESS_TOKEN = "face_auth:access_token:";

    //redis key ：  存储人脸核身-获取 SIGN ticket
    public static final String FACE_AUTH_SIGN_TICKET = "face_auth:sign_ticket:";

    //redis key ：  存医生是否完成所有认证
    public static final String FACE_AUTH_FINISH = "face_auth:finish";

    //redis key : 存诊所预览信息
    public static final String CLINIC_PREVIEW = "app:clinic_preview:";

    //redis key ：患者未支付超时自动取消
    public static final String REDIS_SCHEDULE_ENQUIRY_PATIENT_NOT_PAY = "schedule:enquiry:patient:not_pay";

    //redis key ：医生超时未接诊自动取消
    public static final String REDIS_SCHEDULE_ENQUIRY_DOCTOR_NOT_ADMISSION = "schedule:enquiry:doctor:not_admission";

    //redis key ：聊天会话更新
    public static final String REDIS_APP_UPDATE_MESSAGE_CONVERSATION = "app:update:message:conversation:";

    //微信accessToken
    public static final String ACCESS_TOKEN = "access_token:";

    //微信小程序accessToken
    public static final String ACCESS_TOKEN_APPLET = "access_token:applet";

    //redis key ：定时任务医生超时未接诊  催医生接诊
    public static final String DOCTOR_ACCEPT_INQUIRY_TIMEOUT = "schedule:doctor:accept:";

    // redis key: 定时任务 定时催接诊
    public static final String DOCTOR_ENQUIRY_TIMING = "schedule:doctor:Enquiry:timing";

    //redis key ：定时任务医生超时未接诊
    public static final String CREATE_WORK_ORDER = "schedule:create:work:order:";

    //redis key ：患者超时未支付问诊费用
    public static final String PATIENT_PAY_FEE = "schedule:patient:pay:";

    //redis key ：定时任务中问诊单
    public static final String PATIENT_BUY_MEDICINET = "schedule:patient:buy:";

    // 需求变更，限制该患者2分钟最多 1 条提醒
    public static final String MINI_APP_PATIENT_LIMIT_REMIND = "schedule:patient:sub_news:";

    // 最近一次医生发推送给患者新消息时间
    public static final String MINI_APP_PATIENT_LAST_PUSH_TIME = "schedule:patient:sub_news_last_push_time:";

    //redis key ：推送小程序订阅消息超时消息定时任务
    public static final String REDIS_SCHEDULE_MINI_APP_PATIENT_UNREAD = "schedule:mini_app:unread";

    //redis key ：老系统聊天记录
    public static final String BAYMAX_MESSAGE = "schedule:baymax:message:";

    //redis key ：医生名片图片
    public static final String DOCTOR_BUSSINESS_CARD = "doctor:bussiness_card:";

    //redis key ：短信验证码
    public static final String APP_SMS_CODE = "app:sms_code:";

    // sms 日限制 登录位置区分
    public static final String APP_SMS_CODE_LIMIT_DAY_REPRESENT = RedisConstant.APP_SMS_CODE + "limit:day:represent:";
    public static final String APP_SMS_CODE_LIMIT_DAY_APP = RedisConstant.APP_SMS_CODE + "limit:day:app:";

    // sms 小时限制 登录位置区分
    public static final String APP_SMS_CODE_LIMIT_HOUR_REPRESENT = RedisConstant.APP_SMS_CODE + "limit:hour:represent:";
    public static final String APP_SMS_CODE_LIMIT_HOUR_APP = RedisConstant.APP_SMS_CODE + "limit:hour:app:";

    //redis key ：隐私电话
    public static final String APP_PRIVACY_CALL = "app:privacy_call:";

    //redis key ：隐私电话接口标识检验
    public static final String APP_PRIVACY_CALL_CHECK = "app:privacy_call_check:";

    //redis key ：推送患者未读 公众号模板消息  该类短信的频率限制：最多15分钟一条。
    public static final String SCHEDULE_OFFICIAL_ACCOUNT_PATIENT_UNREAD = "schedule:official_account:patient_unread:";

    //redis key ：医生会话初始化
    public static final String DOCTOR_INITIALIZE_CONVERSATION = "doctor:initialize_conversation:";

    //redis key ：医生会话初始化
    public static final String DOCTOR_INITIALIZE_CONVERSATION_OPTIMISTIC_LOCK = "doctor:initialize_conversation:optimisticLock";

    //redis key ：医生推荐诊断
    public static final String DOCTOR_RECOMMEND_DIAGNOSIS = "doctor:recommend_diagnosis:";

    //医生历史用药
    public static final String DOCTOR_HISTORY_MEDICAL = "doctor:history_medical:";

    // redis key ：上次诊疗记录结束时间  app:treatment_last_endtime:55784389_445495
    public static final String DOCTOR_PATIENT_TREATMENT_LAST_ENDTIME = "app:treatment:last_endtime:";

    //redis key ：最近一次添加的线下病例的创建时间app:treatment:offline_case_time:  +patientId
    public static final String PATIENT_LAST_OFFLINE_CASE_TIME = "app:treatment:offline_case_time:";

    // redis key ：医生点击查看诊疗记录时间  app:treatment:doctorId_patientId
    // 需求变更，医生端 - 快捷入口 患者资料（诊疗记录、随访记录），不管医生点诊疗记录列表还是随访记录列表，new标识就会消失。
    public static final String DOCTOR_PATIENT_TREATMENT_READ_TIME = "app:treatment:read_time:";

    // 限制护士发该患者每分钟最多 2 条提醒  -> 需求变更，两分钟最多一条
    public static final String NURSE_PATIENT_SEND_LIMIT = "schedule:nurse_patient_send_limit:";

    // redis key ：定时增量同步es中的商品数据
    public static final String INCREMENTAL_SYNC_ES_PRODUCT_DATA = "schedule:incremental_syncEs_product:";

    // redis key ：定时增量同步es中的商品数据
    public static final String INCREMENTAL_SYNC_ES_CLINIC_PRICE = "schedule:incremental_syncEs_clinic_price:";

    // redis key ：检查每一个处方单的患者的  医生和该患者的最新聊天时间  的时间是否在诊疗周期，在的话，修改状态
    // 疗程计算周期内，医生主动发消息，判为已处理的【已完成】
    // 疗程计算周期内，患者主动发消息，从待复诊列表中移除
    public static final String REDIS_SCHEDULE_TREATMENT_REMIND_CHAT = "schedule:treatment_remind_chat";

    // redis key ：预接诊医生接诊提醒 + inquiryNo
    public static final String PRE_DIAGNOSE_DOCTOR_RECEVICE_REMIND = "app:pre_diagnose:recevice_remind:";

    // 帮助患者填写病历工单
    public static final String FILL_OUT_MEDICAL_RECORD = "schedule:fill_out_medical_record";

    //订单发货参数防重缓存
    public static final String ORDER_DELIVERY_DATA_CACHE = "order:order_delivery_data_cache_v3:";
    public static final long ORDER_DELIVERY_DATA_CACHE_SECOND = 3600 * 24 * 7;

    // redis key ：患者切换至新系统，旧系统积分自动转换抵用金 + userId , value 值目前没有业务意义，为unionId
    public static final String PATIENT_ODC_EXCHANGE_POINT = "app:patient_odc_exchange_point:";

    // redis key : KA医生迁移部分商品限购活动
    public static final String APP_KA_DOCTOR_PRODUCT_LIMIT = "app:ka_doctor_product_limit:";

    //redis key ：公众号消息 医生卡片消息跳转路径url，这个url是临时的30天有效期，微信限制的 app:doctor:card_tmp_url:doctorId  value是小程序的那个临时url
    public static final String APP_DOCTOR_CARD_TMP_URL = "app:doctor:card_tmp_url:";

    // redis key : 群发调用IM接口的频率
    public static final String REDIS_SCHEDULE_BULK_FREQUENCY = "schedule:im:bulk_frequency";
    // redis key : 患教调用IM接口的频率
    public static final String REDIS_PATIENT_EDU_FREQUENCY = "schedule:im:patient_edu_frequency";
    // redis key : 助理消息推送调用IM接口的频率
    public static final String REDIS_SCHEDULE_NURSE_BULK_FREQUENCY = "schedule:im:nurse_bulk_frequency";

    public static final String REDIS_SCHEDULE_NURSE_BULK = "schedule:im:nurse_bulk";

    // 患者处方药复诊提醒 定时任务每天中午12点发给患者模板消息
    public static final String REDIS_SCHEDULE_PATIENT_PRESCRIPTION_REMIND = "schedule:patient:prescription_remind";

    // 优惠券到期提前一天通知 定时任务每天中午12点发给患者模板消息
    public static final String REDIS_SCHEDULE_COUPON_EXPIRATION_REMIND = "schedule:patient:coupon_expiration_remind";

    // 新患者抵用金
    public static final String REDIS_APP_NEW_PATIENT_CREDIT = "app:new_patient:credit";

    // 工单处理除了专属助理的助理队列
    public static final String WORK_ORDER_NURSER_CURSOR = "user:work_order_nurse_cursor";

    // 会话处理除了专属助理的助理队列
    public static final String SESSION_NURSER_CURSOR = "user:session_nurse_cursor";

    // C2C聊天消息发送后回调保存至mongo
    public static final String C2C_CALLBACK_SAVE_MESSAGE = "app:c2c_callback_save_message";

    // C2C聊天消息发送后回调保存至mongo
    public static final String GROUP_CALLBACK_SAVE_MESSAGE = "app:group_callback_save_message";

    // 定时任务：随访报表疗程结束时间处理
    public static final String REDIS_SCHEDULE_USER_FOLLOW_REPORT = "schedule:user:follow_report";

    //redis key ：这个url是临时的30天有效期，微信限制的 老系统现在要通过这个跳转到新系统的小程序 key + path + query
    public static final String APP_MINIAPP_URL_LINK = "app:miniapp:url_link:";

    // redis key : 同步医生表积分信息标识
    public static final String APP_DOCTOR_POINTS_SYNC_TAG = "app:doctor_points_sync_tag:";

    // redis key : 医生积分
    public static final String APP_DOCTOR_POINTS = "app:doctor_points:";

    // redis key : 订单积分计算幂等
    public static final String CALCULATE_ORDER_POINTS = "schedule:calculate_order_points";

    // redis key : 图文问诊积分计算幂等
    public static final String CALCULATE_GRAPHIC_POINTS = "schedule:calculate_graphic_points";

    // redis key ：小程序自主购药
    public static final String MINIAPP_SELF_BUY_MEDICAL = "miniapp:self_buy_medical:";

    // redis key : 订单积分计算幂等
    public static final String ORDER_SIGNED_THAW_POINTS = "schedule:order_signed_thaw_points";

    // 定时任务：富友 退款结果 定时任务查询
    public static final String REDIS_SCHEDULE_REFUND_RESULT_SEARCH = "schedule:pay:fuiou_refund_result_search";

    // 患者打开小程序，前端立即调接口传code和doctorId进来，后端code换成小程序openId redis k=openId v=doctorId
    public static final String APP_BIND_DOCTOR_TO_REDIS = "app:bind_doctor_to_redis:";

    // redis aop 接口幂等 key prefix
    public static final String REDIS_AOP_API_IDEMPOTENT_PREFIX = "redis:api_idempotent:";

    //redis key : send_coupon_amount：couponId:doctorId   医生已发送优惠券数量
    public static final String SEND_COUPON_AMOUNT = "send_coupon_amount:";

    /**
     * schedule:user:device_info 刷新用户设备信息
     */
    public static final String REDIS_SCHEDULE_USER_DEVICE_INFO = "schedule:user:device_info";

    // 用户登录设备信息记录 aop:device:userId
    public static final String AOP_DEVICE = "aop:device_info:";

    // 记录当天的登录的用户id   aop:deivice_set:2022-10-20
    public static final String AOP_DEVICE_SET = "aop:device_set:";

    //redis key ：患者扫老系统二维码， key 患者unionId  value 医生新系统id, 患者扫多个老医生二维码则，覆盖即可
    public static final String APP_SCAN_OLD_DOCTOR = "app:scan_old_doctor:";

    //redis key ：代表端登录失败次数， key userName  value 失败次数
    public static final String REPRE_LOGIN_FAIL_TIME = "repre:login:fail_time:";

    /**
     * app端 新患者列表 医生新绑定患者30天内 是否有未读信息
     */
    public static final String DOCTOR_BINDING_NEW_PATIENT_UNREAD = "doctor:binding_new_patient_unread:";

    /**
     * schedule 会话分配-补偿
     */
    public static final String REDIS_SCHEDULE_ASSIGN_CONVERSATION_TASK = "schedule:assign_conversation_task";

    /**
     * 步长跳转商品下单信息url
     */
    public static final String EXTENSION_JUMP_PRODUCT_URL = "xtension:product:jump_url:";

    /**
     * redis 医保局的 sign_no
     */
    public static final String REDIS_INSURANCE_SIGN_NO = "insurance:sign_no:";

    /**
     * 代表推广临时二维码represent:extension_qr_code:id:sku_code
     */
    public static final String REPRESENT_EXTENSION_QR_CODE = "represent:extension_qr_code:";

    /**
     * redis 抗原限购
     * key app:limit:product:spec_code:patientId
     */
    public static final String REDIS_LIMIT_PRODUCT = "app:limit:product:";

    // 患者扫码打开小程序，前端立即调接口传code和doctorId进来，后端code换成小程序openId, 判断是扫错码的患者  redis k=openId:doctorId
    public static final String APP_BIND_DOCTOR_TO_REDIS_ERROR_PATIENT = "app:bind_doctor_to_redis:error_patient:";

    /**
     * APP版本号信息
     */
    public static final String APP_VERSION_INFOS = "app:version:infos";
    /**
     * 批量导入发送优惠券
     * coupon:batch_import
     */
    public static final String REDIS_BATCH_IMPORT_SEND_COUPON = "coupon:batch_import:";

    /**
     * 创建批量类型的优惠券
     * coupon:batch_import
     */
    public static final String REDIS_CREATE_BATCH_TYPE_COUPON = "coupon:create_batch_type_coupon:";

    /**
     * 批量更新医生业务代表
     */
    public static final String IMPORT_UPDATE_DOCTOR_BUSINESS = "batch_import:update:doctor_business:";

    /**
     * 批量更新医生上级代表
     */
    public static final String IMPORT_UPDATE_DOCTOR_SUPERIOR = "batch_import:update:doctor_business:";

    /**
     * 批量调整医生积分
     */
    public static final String IMPORT_ADJUST_DOCTOR_CREDIT = "batch_import:update:adjust_credit:";


    /**
     * schedule 每天5点定时更新医保药品最小单位的统筹最高限价情况
     */
    public static final String REDIS_SCHEDULE_PRODUCT_UPDATE_LIMIT_PRICE = "schedule:product:update_limit_price";

    /**
     * 批量导入更新分组价格
     */
    public static final String IMPORT_UPDATE_PRODUCT_PRICE_GROUP = "batch_import:update:price_group:";

    /**
     * 限购商品数据 医生端推荐商品数据 患者端置顶商品数据
     */
    public static final String REDIS_PRODUCT_ACTIVITY_DATA = "app:product:activity:data";

    /**
     * 限购商品数据 医生端推荐商品数据 患者端置顶商品数据
     */
    public static final String REDIS_MARKET_SEARCH_RECOM_DATA = "market:search_recom:data";

    /**
     * 物流费用模型
     */
    public static final String SYSTEM_LOGISTICS_FEE_MODEL = "system:logistics:fee_model";
    /**
     * 自动回复语  app:auto_reply:sceneType
     */
    public static final String REDIS_AUTO_REPLY = "app:auto_reply:";

    /**
     * product 运营商品加载到redis 锁
     */
    public static final String REDIS_PRODUCT_ACTIVITY_TO_REDIS = "lock:product_activity";

    /**
     * 医生推广商品的二维码 doctor_extension:product:rqCode:doctorId:skucode
     */
    public static final String REDIS_DOCTOR_EXTENSION_PRODUCT_QRCODE = "doctor_extension:product:rqCode:";

    /**
     * 代表的js-sdk的ticket
     */
    public static final String REDIS_WX_JSSDK_TICKET_REPRESENT = "wx:jsdk_ticket:repr";

    /**
     * 自动返送优惠券
     * coupon:autp_send:doctorId+patientId
     */
    public static final String REDIS_COUPON_AUTO_SEND = "coupon:auto_send:";

    /**
     * 创建自动发放类型优惠券
     * coupon:create_auto_send_type:doctorId:ValidDay
     */
    public static final String REDIS_CREATE_AUTO_SEND_TYPE_COUPON = "coupon:create_auto_send_type:";

    /**
     * 处理患者问诊优惠券弹窗信息缓存到redis
     * coupon:patient_pop_up_coupon:patientId
     */
    public static final String REDIS_CREATE_PATIENT_POP_UP_COUPON = "coupon:patient_pop_up_coupon:";

    // 流失患者优惠券 定时任务每天10.30 发给患者优惠券和 模板消息
    public static final String REDIS_SCHEDULE_LOSS_PATIENT_COUPON_MSG = "schedule:patient:loss_patient_coupon_msg";

    // 患者App登录的unionId和头像等数据  :unionId
    public static final String REDIS_APP_PATIENT_APP_LOGIN = "app:patient_app_login:";

    /**
     * 售后订单 扣除相应积分
     */
    public static final String REDIS_AS_ORDER_DEDUCTION_SCORE = "as_order:deduction_score:";

    /**
     * 检查订单是否完结并解冻积分
     */
    public static final String REDIS_CHECK_ORDER_AND_THAW_DOCTOR_POINTS = "order:check_thaw_points:";

    /**
     * 患者小程序弹窗善美思
     * app:mini_app:pop_up:patientid:doctorId
     */
    public static final String REDIS_APP_MINI_APP_POP_UP_SHANGMEISI = "app:mini_app:pop_up:";

    /**
     * 患者积分保存加锁
     * patient_score:save:patientId
     */
    public static final String REDIS_PATIENT_SCORE_SAVE = "patient_score:save:";

    /**
     * 任务记录保存加锁
     * patient_score:save:patientId
     */
    public static final String REDIS_TASK_RECORD_SAVE = "task_record:save:";

    /**
     * 过期清除患者积分
     * patient_score:expired_purge:patientId
     */
    public static final String REDIS_PATIENT_SCORE_EXPIRED_PURGE = "patient_score:expired_purge:";

    /**
     * 首次赠送患者积分判断
     * patient_score:first_give
     */
    public static final String REDIS_PATIENT_SCORE_FIRST_GIVE = "patient_score:first_give";

    /**
     * 微信医保支付授权
     */
    public static final String REDIS_APP_INSU_PAY_AUTH_NO = "app:insu_payauthno:";


    /**
     * 医生上线时，给患者发送消息
     * app:dr_on_line_send_patient_msg:inquiryNo
     */
    public static final String REDIS_APP_DR_ON_LINE_SEND_PATIENT_MSG = "app:dr_on_line_send_patient_msg:";

    /**
     * 保存个性价格
     */
    public static final String IMPORT_SAVE_PERSONAL_PRICE = "batch_import:save:save_personal_price:";

    /**
     * 保存患者app安装参数和安装来源信息
     * patient_app:install_info
     */
    public static final String PATIENT_APP_INSTALL_INFO = "patient_app:install_info:";


    /**
     * 唯一id生成key
     */
    public static final String UNIQUE_ID_GENERATE = "unique.id.generate:";

    /**
     * lua脚本
     */
    public static final String ID_GENERATE_LUA_SCRIPT =
            "local current_time = redis.call(\"time\")" +
            "local key = KEYS[1] .. current_time[1]\n" +
            "local limit = tonumber(ARGV[1])\n" +
            "local expire_time = tonumber(ARGV[2])\n" +
            "local cnt = redis.call(\"INCR\", key)\n" +
            "if cnt == 1 then\n" +
                "redis.call(\"PEXPIRE\", key, expire_time)\n" +
            "end\n" +
            "if cnt > limit then\n" +
                "return nil\n" +
            "end\n" +
            "return current_time[1] .. \",\" .. current_time[2] .. \",\" .. cnt\n";
}
