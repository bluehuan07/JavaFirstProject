package dao;

import java.util.List;

import model.Porder;

public interface PorderDao {

	// create
	void addPorder(Porder p);

	// read
	List<Porder> selectAll();

	Porder selectById(int id);

	// update

	// delete
}