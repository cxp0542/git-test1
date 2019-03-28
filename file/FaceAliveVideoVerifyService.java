package com.jzl.cloud_common_service.api.face;

import com.jzl.cloud_common_service.manager.face.FaceAliveVideoVerifyManager;
import com.jzl.cloud_common_service.vo.face.requestvo.FaceAliveVideoVo;
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
 * Created by xiao on 2018-08-29.
 */
//活体检测（通过语音验证码和视频验证）
@Component
public class FaceAliveVideoVerifyService extends ServiceHandler
{
    @Autowired
    FaceAliveVideoVerifyManager faceAliveVideoVerifyManager;

    @ParamField(name = "face_alive_video", checkType = CheckType.NOT_NULL_AND_BLANK, message = "活体检测视频数据不能为空！")
    private ThreadLocal<FaceAliveVideoVo> faceAliveVideoVo = new ThreadLocal<>();

    @Override
    public String supportServiceName()
    {
        return "face" + "." + "video";
    }

    @Override
    public Response handle(Request request)
    {
        return new ResponseBody()
                .setStatus(ResponseStatus.STATUS_SUCCESS)
                .putData("instance", faceAliveVideoVerifyManager.getVideoDetect(faceAliveVideoVo.get()))
                .bulid();
    }
}
