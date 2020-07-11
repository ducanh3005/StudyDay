package com.darly.api.base;

/**
 * author:zhangyuhui
 * date:2020-07-0616:24
 * description: 基础服务，初始化入口。
 */
public class ServiceStartEntry {

    private ServiceStartEntry() {
    }

    /**
     * 进行服务启动前置条件设置。
     *
     * @return 成功/失败
     */
    public static BaseServiceModel initService() {
        BaseServiceModel model = new BaseServiceModel();
        model.setCode(ApiCons.SUCCESS);
        model.setData(true);
        //初始化接口对象集合。
        MethodName.setMethodsMap();
        //初始化，将内置好主题存入到数据库中。当已经存在，不进行存储。
        return model;
    }
}
