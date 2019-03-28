package com.jzl.cloud_common_service.api.face;
import com.jzl.cloud_common_service.manager.face.FaceAliveVideoVerifyManager;
import com.jzl.cloud_common_service.manager.face.FaceAliveVoiceCodeManager;
import com.jzl.cloud_framework.componet.body.Request;
import com.jzl.cloud_framework.componet.body.Response;
import com.jzl.cloud_framework.componet.body.ResponseBody;
import com.jzl.cloud_framework.componet.body.status.base.ResponseStatus;
import com.jzl.cloud_framework.componet.handler.ServiceHandler;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 * Created by xiao on 2018-08-30.
 */
@Component
public class FaceAliveVoiceCodeService extends ServiceHandler
{
    @Autowired
    FaceAliveVoiceCodeManager faceAliveVoiceCodeManager;

    @Override
    public String supportServiceName()
    {
        return "face" + "." + "voice";
    }

    @Override
    public Response handle(Request request)
    {
        return new ResponseBody()
                .setStatus(ResponseStatus.STATUS_SUCCESS)
                .putData("instance", faceAliveVoiceCodeManager.getVoiceCode())
                .bulid();
    }


}
