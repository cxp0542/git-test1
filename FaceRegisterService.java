package com.jzl.cloud_common_service.api.face;

import com.jzl.cloud_common_service.manager.face.FaceRegisterManager;
import com.jzl.cloud_common_service.vo.face.requestvo.FaceRegisterVo;
import com.jzl.cloud_framework.componet.annotation.CheckType;
import com.jzl.cloud_framework.componet.annotation.ParamField;
import com.jzl.cloud_framework.componet.body.Request;
import com.jzl.cloud_framework.componet.body.Response;
import com.jzl.cloud_framework.componet.body.ResponseBody;
import com.jzl.cloud_framework.componet.body.status.base.ResponseStatus;
import com.jzl.cloud_framework.componet.handler.ServiceHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by xiao on 2018-08-22.
 */
@Component
public class FaceRegisterService extends ServiceHandler
{
    @Autowired
    FaceRegisterManager faceRegisterManager;

    @ParamField(name = "face_register_info", checkType = CheckType.NOT_NULL_AND_BLANK, message = "用户人脸注册数据不能为空！")
    private ThreadLocal<FaceRegisterVo> faceRegisterVo = new ThreadLocal<>();

    @Override
    public String supportServiceName()
    {
        return "face" + "." + "register";
    }

    @Override
    public Response handle(Request request) throws Exception
    {
        return new ResponseBody()
                .setStatus(ResponseStatus.STATUS_SUCCESS)
                .putData("instance", faceRegisterManager.faceRegister(faceRegisterVo.get().getFace(),
                        faceRegisterVo.get().getGroupId(),
                        faceRegisterVo.get().getUserId()))
                .bulid();
    }

}
