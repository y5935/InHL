package com.manage.student.service.impl;

import com.manage.student.mapper.CommonMapper;
import com.manage.student.model.CommonBody;
import com.manage.student.model.FeiHuoLiang;
import com.manage.student.model.ShenGao;
import com.manage.student.model.TiZhong;
import com.manage.student.model.XiongWei;
import com.manage.student.service.CommonService;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

@Service("commonService")
public class CommonServiceImpl implements CommonService {

    @Autowired
    private CommonMapper commonMapper;
    @Override
    public void insertUserInfo(String username, String password, String realname, String profession, String classAndGrade, String sex) {
        commonMapper.insertUserInfo(username,password,realname,profession,classAndGrade,sex);
    }
    @Override
    public void updateUserInfo(String username, String password, String realname, String profession, String classAndGrade, String sex) {
        commonMapper.updateUserInfo(username,password,realname,profession,classAndGrade,sex);
    }

    @Override
    public void deleteUserInfo(String username) {
        commonMapper.deleteUserInfo(username);
    }

    @Override
    public CommonBody getUserInfo(String username, String password) {
        return commonMapper.getUserInfo(username, password);
    }

    @Override
    public List<CommonBody> userInfoList(String username, String profession, String classAndGrade,int currentPage,int itemsPerPage){
        int totalItems = commonMapper.userInfoCount(username,profession,classAndGrade);
        if (totalItems == 0){
            return new ArrayList<>();
        }
        return commonMapper.userInfoList(username,profession,classAndGrade, currentPage, itemsPerPage, totalItems);
    }

    @Override
    public List<CommonBody> tijianInfoList( CommonBody commonBody){
        int totalItems = commonMapper.tijianInfoCount(commonBody);
        if (totalItems == 0){
            return new ArrayList<>();
        }
        commonBody.setTotalItems(totalItems);
        return commonMapper.tijianInfoList(commonBody);
    }

    @Override
    public void updateTijianInfo( CommonBody commonBody){
        commonMapper.updateTijianInfo(commonBody);
    }

    @Override
    public void deleteTijianInfo(String username) {
        commonMapper.deleteTijianInfo(username);
    }

    @Override
    public byte[] exportUserInfoList(String username, String profession, String classAndGrade) throws Exception {
        XSSFWorkbook wb = new XSSFWorkbook();
        XSSFSheet sheet = wb.createSheet("用户信息列表");
        XSSFRow row = sheet.createRow( 0);
        row.createCell( 0).setCellValue("用户名");
        row.createCell( 1).setCellValue("所属系");
        row.createCell(2).setCellValue("所属班");
        row.createCell( 3).setCellValue("真实名");
        row.createCell( 4).setCellValue("性别");
        List<CommonBody> userList = commonMapper.exportUserInfoList(username, profession, classAndGrade);
        int rownum = 1;
        for (CommonBody c : userList){
            row = sheet.createRow( rownum++);
            row.createCell(0).setCellValue(c.getUsername());
            row.createCell(1).setCellValue(c.getProfession());
            row.createCell(2).setCellValue(c.getClassAndGrade());
            row.createCell(3).setCellValue(c.getRealname());
            if ("male".equals(c.getSex())){
                row.createCell(4).setCellValue("男");
            } else {
                row.createCell(4).setCellValue("女");
            }
        }
        ByteArrayOutputStream output = null;
        try
        {
            output = new ByteArrayOutputStream();
            wb.write(output);
        } catch (Exception e){
            throw new RuntimeException("导出用户信息出错！");
        } finally {
            IOUtils.closeQuietly(output);
        }
        return output.toByteArray();
    }

    @Override
    public byte[] exportTijianInfoList(CommonBody commonBody) throws Exception {
        XSSFWorkbook wb = new XSSFWorkbook();
        XSSFSheet sheet = wb.createSheet("用户体检信息列表");
        XSSFRow row = sheet.createRow( 0);
        row.createCell( 0).setCellValue("用户名");
        row.createCell( 1).setCellValue("所属系");
        row.createCell( 2).setCellValue("所属班");
        row.createCell( 3).setCellValue("真实名");
        row.createCell( 4).setCellValue("性别");
        row.createCell( 5).setCellValue("身高（单位CM）");
        row.createCell( 6).setCellValue("体重（单位KG）");
        row.createCell( 7).setCellValue("肺活量（单位CC）");
        row.createCell( 8).setCellValue("胸围（单位CM）");
        row.createCell( 9).setCellValue("左眼视力");
        row.createCell( 10).setCellValue("右眼视力");
        row.createCell( 11).setCellValue("备注（病情）");

        // 第五步，写入实体数据
        List<CommonBody> userList = commonMapper.exportTijianInfoList(commonBody);
        int rownum = 1;
        for (CommonBody c : userList){
            row = sheet.createRow( rownum++);
            row.createCell(0).setCellValue(c.getUsername());
            row.createCell(1).setCellValue(c.getProfession());
            row.createCell(2).setCellValue(c.getClassAndGrade());
            row.createCell(3).setCellValue(c.getRealname());
            if ("male".equals(c.getSex())){
                row.createCell(4).setCellValue("男");
            } else {
                row.createCell(4).setCellValue("女");
            }
            row.createCell(5).setCellValue(c.getHeight());
            row.createCell(6).setCellValue(c.getWeight());
            row.createCell(7).setCellValue(c.getVitalCapacity());
            row.createCell(8).setCellValue(c.getChestCircumference());
            row.createCell(9).setCellValue(c.getLeftEye());
            row.createCell(10).setCellValue(c.getRigthEye());
            row.createCell(11).setCellValue(c.getRemark());
        }
        // 第六步，将文件存到指定位置
        ByteArrayOutputStream output = null;
        try
        {
            output = new ByteArrayOutputStream();
            wb.write(output);
        } catch (Exception e){
            throw new RuntimeException("导出用户体检信息出错！");
        } finally {
            IOUtils.closeQuietly(output);
        }
        return output.toByteArray();
    }

    @Override
    public CommonBody getTongJiInfo(CommonBody commonBody) {
        CommonBody cb = new CommonBody();
        ShenGao sg = commonMapper.getShenGaoInfo(commonBody.getProfession(),commonBody.getClassAndGrade());
        if (null == sg) {
        	sg = new ShenGao();
        }
        cb.setShenGao(sg);
        TiZhong tz = commonMapper.getTiZhongInfo(commonBody.getProfession(),commonBody.getClassAndGrade());
        if (null == tz) {
        	tz = new TiZhong();
        }
        cb.setTiZhong(tz);
        XiongWei xw = commonMapper.getXiongWeiInfo(commonBody.getProfession(),commonBody.getClassAndGrade());
        if (null == xw) {
        	xw = new XiongWei();
        }
        cb.setXiongWei(xw);
        FeiHuoLiang fhl = commonMapper.getFeiHuoLiangInfo(commonBody.getProfession(),commonBody.getClassAndGrade());
        if (null == fhl) {
        	fhl = new FeiHuoLiang();
        }
        cb.setFeiHuoLiang(fhl);
        return cb;
    }

    @Override
    public int checkUsername(String username) {
        return commonMapper.checkUsername(username);
    }

    @Override
    public int checkTiJianInfo(String username) {
        return commonMapper.checkTiJianInfo(username);
    }
}
