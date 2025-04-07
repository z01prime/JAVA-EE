package service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import entity.Empl;

public interface EmplService {
	List<Empl> selectAll();
	void delete(int id);
	void insert(Empl e);
	void update(Empl em);
	Empl selectById(int id);
	//模糊查询
		List<Empl> selectMohu(@Param("name")String name,@Param("ageBegin")String ageBegin,@Param("ageEnd")String ageEnd,@Param("dept")String dept);
	//批量删除优化
		void deleteMany(@Param("ids")List<Integer> ids);
}
