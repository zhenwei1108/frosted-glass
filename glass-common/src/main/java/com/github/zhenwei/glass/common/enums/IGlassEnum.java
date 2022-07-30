package com.github.zhenwei.glass.common.enums;

/**
 * @description: IGlassEnum
 *  异常枚举
 * @author: zhangzhenwei
 * @since: 1.0
 * @date: 2022/7/30  23:29
 */
public interface IGlassEnum {

    String SUCCESS_MSG = "success";

    int SUCCESS_CODE = 200;

    String SYSTEM_ERR_MSG = "system error";

    int SYSTEM_ERR_CODE = 999999;




    /**
     * @param []
     * @return java.lang.String
     * @author zhangzhenwei
     * @description 获取异常信息
     * @date 2022/7/30  23:28
     * @since: 1.0
     */
    String getErrMessage();

    /**
     * @param []
     * @return int
     * @author zhangzhenwei
     * @description 获取错误码
     * @date 2022/7/30  23:29
     * @since: 1.0
     */
    int getErrCode();

}
