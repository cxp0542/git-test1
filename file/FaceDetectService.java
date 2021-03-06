﻿package com.jzl.cloud_common_service.api.face;

import com.jzl.cloud_common_service.manager.face.FaceDetectManager;
import com.jzl.cloud_common_service.vo.face.requestvo.FaceDetectVo;
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
 * Created by xiao on 2018-08-21.
 */
@ComponentName()
    
            return new ResponseBody()
                    .setStatus(ResponseStatus.STATUS_SUCCESS)
                    .putData("instance", faceDetectManager.faceAliveDetect(faceDetectVo.get().getFaces()))
                    .bulid();
    }
}
