package com.manage.student.mapper;

import com.manage.student.model.*;
import org.apache.ibatis.annotations.*;

import java.util.List;
/*
 * 当使用基于注解的映射器接口时，不需要再xml配置文件中配置。
 * Mapper接口方法上使用@select、@insert、@delete
 * @author Lens
 *
 */
public interface CommonMapper {
	
    @Insert("insert into user(username,password,realname,profession,classAndGrade,sex,level)" +
            " values(#{username},#{password},#{realname},#{profession},#{classAndGrade},#{sex},2)")
    void insertUserInfo(@Param("username") String username, @Param("password") String password, @Param("realname") String realname,
                        @Param("profession") String profession, @Param("classAndGrade") String classAndGrade, @Param("sex") String sex);

    @Insert("insert into user(username,password,realname,profession,classAndGrade,sex,level)" +
            " values(#{username},#{password},#{realname},#{profession},#{classAndGrade},#{sex},2) " +
            " on duplicate key update password=#{password}, realname=#{realname}, profession=#{profession}," +
            " classAndGrade=#{classAndGrade}, sex=#{sex}")
    void updateUserInfo(@Param("username") String username, @Param("password") String password, @Param("realname") String realname,
                        @Param("profession") String profession, @Param("classAndGrade") String classAndGrade, @Param("sex") String sex);
   
    @Delete("delete from user where username=#{username}")
    void deleteUserInfo(@Param("username") String username);
    
    @Select("select * from user where username=#{username} and password=#{password}")
    CommonBody getUserInfo(@Param("username") String username, @Param("password") String password);

    @Select("<script>" +
            " select #{totalItems} as 'totalItems',u.* from user u where 1=1 " +
            " <if test=\"username!=null and username!=''\">and u.username like concat('%',#{username},'%')</if> " +
            " <if test=\"profession!=null and profession!=''\">and u.profession = #{profession}</if> " +
            " <if test=\"classAndGrade!=null and classAndGrade!=''\">and u.classAndGrade = #{classAndGrade}</if> " +
            " limit ${(currentPage - 1) * itemsPerPage},#{itemsPerPage}" +
            " </script> " )
    List<CommonBody> userInfoList(@Param("username") String username, @Param("profession") String profession,
                                  @Param("classAndGrade") String classAndGrade,@Param("currentPage") int currentPage,
                                  @Param("itemsPerPage") int itemsPerPage,@Param("totalItems") int totalItems);
    
    @Select("<script>" +
            " select count(1) from user where 1=1 " +
            " <if test=\"username!=null and username!=''\">and username like concat('%',#{username},'%')</if> " +
            " <if test=\"profession!=null and profession!=''\">and profession = #{profession}</if> " +
            " <if test=\"classAndGrade!=null and classAndGrade!=''\">and classAndGrade = #{classAndGrade}</if> " +
            " </script> " )
    int userInfoCount(@Param("username") String username, @Param("profession") String profession,
                                  @Param("classAndGrade") String classAndGrade);
    @Select("<script>" +
            " select #{commonBody.totalItems} as 'totalItems',u.*,t.* from user u, tijian t where u.username=t.username " +
            " <if test=\"commonBody.username!=null and commonBody.username!=''\">and u.username like concat('%',#{commonBody.username},'%')</if> " +
            " <if test=\"commonBody.profession!=null and commonBody.profession!=''\">and u.profession = #{commonBody.profession}</if> " +
            " <if test=\"commonBody.classAndGrade!=null and commonBody.classAndGrade!=''\">and u.classAndGrade = #{commonBody.classAndGrade}</if> " +
            " <if test=\"commonBody.remark!=null and commonBody.remark!=''\">and t.remark like concat('%',#{commonBody.remark},'%')</if> " +
            " limit ${(commonBody.currentPage - 1) * commonBody.itemsPerPage},#{commonBody.itemsPerPage}" +
            " </script> " )
    List<CommonBody> tijianInfoList(@Param("commonBody") CommonBody commonBody);

    @Select("<script>" +
            " select count(1) from user u, tijian t where u.username=t.username " +
            " <if test=\"commonBody.username!=null and commonBody.username!=''\">and u.username like concat('%',#{commonBody.username},'%')</if> " +
            " <if test=\"commonBody.profession!=null and commonBody.profession!=''\">and u.profession = #{commonBody.profession}</if> " +
            " <if test=\"commonBody.classAndGrade!=null and commonBody.classAndGrade!=''\">and u.classAndGrade = #{commonBody.classAndGrade}</if> " +
            " <if test=\"commonBody.remark!=null and commonBody.remark!=''\">and t.remark like concat('%',#{commonBody.remark},'%')</if> " +
            " </script> " )
    int tijianInfoCount(@Param("commonBody") CommonBody commonBody);

    @Insert("insert into tijian(username,height,weight,vitalCapacity,chestCircumference,leftEye,rigthEye,remark) " +
            " values(#{commonBody.username},#{commonBody.height},#{commonBody.weight},#{commonBody.vitalCapacity}," +
            " #{commonBody.chestCircumference},#{commonBody.leftEye},#{commonBody.rigthEye},#{commonBody.remark}) " +
            " on duplicate key update height=#{commonBody.height},weight=#{commonBody.weight},vitalCapacity=#{commonBody.vitalCapacity}," +
            " chestCircumference=#{commonBody.chestCircumference},leftEye=#{commonBody.leftEye},rigthEye=#{commonBody.rigthEye},remark=#{commonBody.remark}")
    void updateTijianInfo(@Param("commonBody") CommonBody commonBody);

    @Delete("delete from tijian where username=#{username}")
    void deleteTijianInfo(@Param("username") String username);

    @Select("<script>" +
            " select u.* from user u where 1=1 " +
            " <if test=\"username!=null and username!=''\">and u.username like concat('%',#{username},'%')</if> " +
            " <if test=\"profession!=null and profession!=''\">and u.profession = #{profession}</if> " +
            " <if test=\"classAndGrade!=null and classAndGrade!=''\">and u.classAndGrade = #{classAndGrade}</if> " +
            " </script> " )
    List<CommonBody> exportUserInfoList(@Param("username") String username, @Param("profession") String profession,
                                  @Param("classAndGrade") String classAndGrade);

    @Select("<script>" +
            " select u.*,t.* from user u, tijian t where u.username=t.username " +
            " <if test=\"commonBody.username!=null and commonBody.username!=''\">and u.username like concat('%',#{commonBody.username},'%')</if> " +
            " <if test=\"commonBody.profession!=null and commonBody.profession!=''\">and u.profession = #{commonBody.profession}</if> " +
            " <if test=\"commonBody.classAndGrade!=null and commonBody.classAndGrade!=''\">and u.classAndGrade = #{commonBody.classAndGrade}</if> " +
            " <if test=\"commonBody.remark!=null and commonBody.remark!=''\">and t.remark like concat('%',#{commonBody.remark},'%')</if> " +
            " </script> " )
    List<CommonBody> exportTijianInfoList(@Param("commonBody") CommonBody commonBody);

    @Select("<script>" +
            " select count(1),sum((select count(1) from tijian t where u.username=t.username <![CDATA[ and t.height < 150 ]]>)) as 'a'," +
            " sum((select count(1) from tijian t where u.username=t.username <![CDATA[ and t.height >= 150 and t.height < 160 ]]>)) as 'b'," +
            " sum((select count(1) from tijian t where u.username=t.username <![CDATA[ and t.height >= 160 and t.height < 170 ]]>)) as 'c'," +
            " sum((select count(1) from tijian t where u.username=t.username <![CDATA[ and t.height >= 170 and t.height < 180 ]]>)) as 'd'," +
            " sum((select count(1) from tijian t where u.username=t.username <![CDATA[ and t.height >= 180 ]]>)) as 'e' from user u where 1=1" +
            " <if test=\"profession!=null and profession!=''\">and u.profession = #{profession}</if> " +
            " <if test=\"classAndGrade!=null and classAndGrade!=''\">and u.classAndGrade = #{classAndGrade}</if> " +
            " </script> " )
    ShenGao getShenGaoInfo(@Param("profession") String profession, @Param("classAndGrade") String classAndGrade);

    @Select("<script>" +
            " select count(1),sum((select count(1) from tijian t where u.username=t.username <![CDATA[ and t.weight < 90 ]]>)) as 'a'," +
            " sum((select count(1) from tijian t where u.username=t.username <![CDATA[ and t.weight >= 90 and t.weight < 120 ]]>)) as 'b'," +
            " sum((select count(1) from tijian t where u.username=t.username <![CDATA[ and t.weight >= 120 and t.weight < 150 ]]>)) as 'c'," +
            " sum((select count(1) from tijian t where u.username=t.username <![CDATA[ and t.weight >= 150 and t.weight < 180 ]]>)) as 'd'," +
            " sum((select count(1) from tijian t where u.username=t.username <![CDATA[ and t.weight >= 180 ]]>)) as 'e' from user u where 1=1" +
            " <if test=\"profession!=null and profession!=''\">and u.profession = #{profession}</if> " +
            " <if test=\"classAndGrade!=null and classAndGrade!=''\">and u.classAndGrade = #{classAndGrade}</if> " +
            " </script> " )
    TiZhong getTiZhongInfo(@Param("profession") String profession, @Param("classAndGrade") String classAndGrade);

    @Select("<script>" +
            " select count(1),sum((select count(1) from tijian t where u.username=t.username <![CDATA[ and t.chestCircumference < 70 ]]>)) as 'a'," +
            " sum((select count(1) from tijian t where u.username=t.username <![CDATA[ and t.chestCircumference >= 70 and t.chestCircumference < 90 ]]>)) as 'b'," +
            " sum((select count(1) from tijian t where u.username=t.username <![CDATA[ and t.chestCircumference >= 90 and t.chestCircumference < 110 ]]>)) as 'c'," +
            " sum((select count(1) from tijian t where u.username=t.username <![CDATA[ and t.chestCircumference >= 110 and t.chestCircumference < 130 ]]>)) as 'd'," +
            " sum((select count(1) from tijian t where u.username=t.username <![CDATA[ and t.chestCircumference >= 130 ]]>)) as 'e' from user u where 1=1" +
            " <if test=\"profession!=null and profession!=''\">and u.profession = #{profession}</if> " +
            " <if test=\"classAndGrade!=null and classAndGrade!=''\">and u.classAndGrade = #{classAndGrade}</if> " +
            " </script> " )
    XiongWei getXiongWeiInfo(@Param("profession") String profession, @Param("classAndGrade") String classAndGrade);

    @Select("<script>" +
            " select count(1),sum((select count(1) from tijian t where u.username=t.username <![CDATA[ and t.vitalCapacity < 2500 ]]>)) as 'a'," +
            " sum((select count(1) from tijian t where u.username=t.username <![CDATA[ and t.vitalCapacity >= 2500 and t.vitalCapacity < 3000 ]]>)) as 'b'," +
            " sum((select count(1) from tijian t where u.username=t.username <![CDATA[ and t.vitalCapacity >= 3000 and t.vitalCapacity < 3500 ]]>)) as 'c'," +
            " sum((select count(1) from tijian t where u.username=t.username <![CDATA[ and t.vitalCapacity >= 3500 and t.vitalCapacity < 4000 ]]>)) as 'd'," +
            " sum((select count(1) from tijian t where u.username=t.username <![CDATA[ and t.vitalCapacity >= 4000 ]]>)) as 'e' from user u where 1=1" +
            " <if test=\"profession!=null and profession!=''\">and u.profession = #{profession}</if> " +
            " <if test=\"classAndGrade!=null and classAndGrade!=''\">and u.classAndGrade = #{classAndGrade}</if> " +
            " </script> " )
    FeiHuoLiang getFeiHuoLiangInfo(@Param("profession") String profession, @Param("classAndGrade") String classAndGrade);

    @Select("select count(1) from user where username=#{username}")
    int checkUsername(@Param("username") String username);

    @Select("select count(1) from tijian where username=#{username}")
    int checkTiJianInfo(@Param("username") String username);
/*    
    
    <select id="checkTiJianInfo">
    	select count(1) from tijian where username=#{username}
    </select>*/
}
