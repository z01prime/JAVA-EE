package dao;

import entity.UserProfile;
import org.apache.ibatis.annotations.Param;

public interface UserProfileDao {

    // 根据员工ID查询个人简介
    UserProfile selectById(int id);

    // 更新员工的个人简介
    void updateProfile(@Param("id") int id, @Param("profile") String profile);

    // 如果您想要添加插入操作，假设数据库中某个员工没有简介记录，可以使用此方法
    void insertProfile(UserProfile userProfile);
}
