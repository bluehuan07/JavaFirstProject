package dao;

import java.util.List;

import model.People;

/* 管理會員資料庫-->CRUD--->method名-->SQL */
public interface PeopleDao {
	/* create */
	void addPeople(String username, String password,String name, String address1, String address2,String birthday,String tel);

	void addPeople(People p);

	/* read */
	List<People> queryAllList();// 全部

	String queryAllString();

	People queryPeopleById(int idpeople);

	People queryPeopleByUsername(String username);

	People queryPeople(String username, String password); // 查詢登入是否正確

	/* update */
	void updatePeopleById(People p);

	void updatePeopleByUsername(People p);

	/* delete */
	void deletePeopleById(int id);

	void deletePeopleByUsernam(String username);
}
