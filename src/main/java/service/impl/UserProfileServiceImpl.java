package service.impl;

import org.apache.ibatis.session.SqlSession;
import dao.UserProfileDao;
import entity.UserProfile;
import service.UserProfileService;
import util.MybatisUtil;

public class UserProfileServiceImpl implements UserProfileService {

    @Override
    public UserProfile getProfileById(int id) {
        SqlSession session = null;
        UserProfile profile = null;
        try {
            session = MybatisUtil.getSqlSession();
            UserProfileDao dao = session.getMapper(UserProfileDao.class);
            profile = dao.selectById(id);
            session.commit();
        } catch (Exception e) {
            try {
                session.rollback();
            } catch (Exception e1) {
                throw new RuntimeException(e1);
            }
            throw new RuntimeException(e);
        } finally {
            MybatisUtil.closeSqlSession(session);
        }
        return profile;
    }

    @Override
    public void updateProfile(int id, String profile) {
        SqlSession session = null;
        try {
            session = MybatisUtil.getSqlSession();
            UserProfileDao dao = session.getMapper(UserProfileDao.class);
//            System.out.println("Updating profile for id=" + id + " with profile=" + profile);
            // 判断是否存在该 ID 的个人简介
            UserProfile existingProfile = dao.selectById(id);

            if (existingProfile != null) {
                // 如果存在，进行更新
                dao.updateProfile(id, profile);  // 更新个人简介
            } else {
                // 如果不存在，插入新记录
                UserProfile newProfile = new UserProfile();
                newProfile.setId(id);
                newProfile.setProfile(profile);
                dao.insertProfile(newProfile);  // 插入个人简介
            }

            session.commit();
        } catch (Exception e) {
            try {
                session.rollback();
            } catch (Exception e1) {
                throw new RuntimeException(e1);
            }
            throw new RuntimeException(e);
        } finally {
            MybatisUtil.closeSqlSession(session);
        }
    }

    @Override
    public void insertProfile(UserProfile userProfile) {
        SqlSession session = null;
        try {
            session = MybatisUtil.getSqlSession();
            UserProfileDao dao = session.getMapper(UserProfileDao.class);
            dao.insertProfile(userProfile);  // 插入个人简介
            session.commit();
        } catch (Exception e) {
            try {
                session.rollback();
            } catch (Exception e1) {
                throw new RuntimeException(e1);
            }
            throw new RuntimeException(e);
        } finally {
            MybatisUtil.closeSqlSession(session);
        }
    }
}
