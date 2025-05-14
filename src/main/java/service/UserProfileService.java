package service;

import entity.UserProfile;

public interface UserProfileService {

    // 获取员工的个人简介
    UserProfile getProfileById(int id);

    // 更新员工的个人简介
    void updateProfile(int id, String profile);

    // 插入员工的个人简介（如果没有的话）
    void insertProfile(UserProfile userProfile);
}
