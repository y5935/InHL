package com.manage.student.controller;

import com.manage.student.common.controller.BaseController;
import com.manage.student.common.exception.ControllerException;
import com.manage.student.common.response.Response;
import com.manage.student.model.CommonBody;
import com.manage.student.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
/*
 * 控制器主要负责从视图读取请求数据，控制用户信息导出、体检信息导出结果返回到service层，然后把模型处理的结果返回给视图
 */
@Controller
public class ExportController extends BaseController {

    @Autowired
    private CommonService commonService;

    @PostMapping(value = "/exportUserInfoList")
    @ResponseBody
    public byte[] exportUserInfoList(@RequestBody CommonBody commonBody){
        try {
            return commonService.exportUserInfoList(commonBody.getUsername(),commonBody.getProfession(),commonBody.getClassAndGrade());
        } catch (Exception e) {
            throw new ControllerException(Response.Status.ERR_UNKNOWN, e.getMessage());
        }
    }
    
    @PostMapping(value = "/exportTijianInfoList")
    @ResponseBody
    public byte[] exportTijianInfoList(@RequestBody CommonBody commonBody){
        try {
            return commonService.exportTijianInfoList(commonBody);
        } catch (Exception e) {
            throw new ControllerException(Response.Status.ERR_UNKNOWN, e.getMessage());
        }
    }
}
