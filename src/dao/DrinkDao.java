package dao;

import java.util.List;

import model.Drink;

public interface DrinkDao {

	/* create */
	void addDrink(String name, int peach, int melon, int brown);

	void addDrink(String username, String name, int peach, int melon, int brown);

	void addDrink(Drink d);

	/* read */
	List<Drink> queryAllList();// 全部

	String queryAllString();

	/* update */

	/* delete */

}
