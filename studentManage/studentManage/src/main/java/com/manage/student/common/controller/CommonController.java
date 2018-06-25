package com.manage.student.common.controller;

import com.manage.student.common.exception.ControllerException;
import com.manage.student.common.response.Response;
import com.manage.student.model.CommonBody;
import com.manage.student.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CommonController extends BaseController{

    @Autowired
    private CommonService commonService;
    @GetMapping(value = "/")
    public String init(){
        return "index";
    }
    @PostMapping(value = "/login")
    @ResponseBody
    public CommonBody login(@RequestBody CommonBody commonBody) throws ControllerException{
        CommonBody b = commonService.getUserInfo(commonBody.getUsername(),commonBody.getPassword());
        if (null == b){
            throw new ControllerException(Response.Status.ERR_CHECK,"用户名或者密码不正确！");
        }
        setFromSession("userInfo",b);
        return b;
    }

    @GetMapping(value = "/registInit")
    public String registInit(){
        return "regist";
    }

    @PostMapping(value = "/registUser")
    @ResponseBody
    public void registUser(@RequestBody CommonBody commonBody){
        commonService.insertUserInfo(commonBody.getUsername(),commonBody.getPassword(),commonBody.getRealname(),commonBody.getProfession(),
                commonBody.getClassAndGrade(),commonBody.getSex());
    }

    @PostMapping(value = "/updateUserInfo")
    @ResponseBody
    public void updateUserInfo(@RequestBody CommonBody commonBody){
        commonService.updateUserInfo(commonBody.getUsername(),commonBody.getPassword(),commonBody.getRealname(),commonBody.getProfession(),
                commonBody.getClassAndGrade(),commonBody.getSex());
    }

    @PostMapping(value = "/deleteUserInfo")
    @ResponseBody
    public void deleteUserInfo(@RequestBody CommonBody commonBody){
        commonService.deleteUserInfo(commonBody.getUsername());
    }

    @PostMapping(value = "/userInfoList")
    @ResponseBody
    public List<CommonBody> userInfoList(@RequestBody CommonBody commonBody){
        return commonService.userInfoList(commonBody.getUsername(),commonBody.getProfession(),commonBody.getClassAndGrade(),
                commonBody.getCurrentPage(),commonBody.getItemsPerPage());
    }

    @PostMapping(value = "/tijianInfoList")
    @ResponseBody
    public List<CommonBody> tijianInfoList(@RequestBody CommonBody commonBody){
        return commonService.tijianInfoList(commonBody);
    }

    @PostMapping(value = "/updateTijianInfo")
    @ResponseBody
    public void updateTijianInfo(@RequestBody CommonBody commonBody){
        commonService.updateTijianInfo(commonBody);
    }

    @PostMapping(value = "/deleteTijianInfo")
    @ResponseBody
    public void deleteTijianInfo(@RequestBody CommonBody commonBody){
        commonService.deleteTijianInfo(commonBody.getUsername());
    }

    @PostMapping(value = "/getTongJiInfo")
    @ResponseBody
    public CommonBody getTongJiInfo(@RequestBody CommonBody commonBody){
        return commonService.getTongJiInfo(commonBody);
    }

    @PostMapping(value = "/checkUsername")
    @ResponseBody
    public int checkUsername(@RequestBody CommonBody commonBody){
        return commonService.checkUsername(commonBody.getUsername());
    }
    @PostMapping(value = "/checkTiJianInfo")
    @ResponseBody
    public int checkTiJianInfo(@RequestBody CommonBody commonBody){
        return commonService.checkTiJianInfo(commonBody.getUsername());
    }
}
