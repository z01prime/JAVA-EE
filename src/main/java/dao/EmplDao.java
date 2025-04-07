package dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import entity.Empl;

public interface EmplDao {
	List<Empl> selectAll();
	void delete(int id);
	void insert(Empl e);
	void update(Empl em);
	Empl selectById(int id);
	//ģ����ѯ
	List<Empl> selectMohu(@Param("name")String name,@Param("ageBegin")String ageBegin,@Param("ageEnd")String ageEnd,@Param("dept")String dept);
	//����ɾ��
	void deleteMany(@Param("ids")List<Integer> ids);
}
