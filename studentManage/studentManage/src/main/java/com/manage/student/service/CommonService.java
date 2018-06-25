package com.manage.student.service;

import com.manage.student.model.CommonBody;

import java.util.List;

public interface CommonService {

    void insertUserInfo(String username, String password, String realname, String profession,
                        String classAndGrade, String sex);
    void updateUserInfo(String username, String password, String realname, String profession,
                        String classAndGrade, String sex);
    void deleteUserInfo(String username);
    CommonBody getUserInfo(String username, String password);
    List<CommonBody> userInfoList(String username, String profession, String classAndGrade,int currentPage,int itemsPerPage);
    List<CommonBody> tijianInfoList( CommonBody commonBody);
    void updateTijianInfo( CommonBody commonBody);
    void deleteTijianInfo(String username);
    byte[] exportUserInfoList(String username, String profession, String classAndGrade) throws Exception;
    byte[] exportTijianInfoList(CommonBody commonBody) throws Exception;
    CommonBody getTongJiInfo( CommonBody commonBody);
    int checkUsername(String username);
    int checkTiJianInfo(String username);
}
