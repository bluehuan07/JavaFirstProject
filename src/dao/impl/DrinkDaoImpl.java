package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.DbConnection;
import dao.DrinkDao;
import model.Drink;

public class DrinkDaoImpl implements DrinkDao {

	@Override
	public void addDrink(String name, int peach, int melon, int brown) {
		Connection conn = DbConnection.getDb();
		String SQL = "INSERT INTO drink(name,peach,melon,brown) VALUES(?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1, name);
			ps.setInt(2, peach);
			ps.setInt(3, melon);
			ps.setInt(4, brown);
			ps.executeUpdate();
			System.out.println("addDrink Success");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("addDrink Error");
			e.printStackTrace();
		}

	}

	@Override
	public void addDrink(String username, String name, int peach, int melon, int brown) {
		Connection conn = DbConnection.getDb();
		String SQL = "INSERT INTO drink(username,name,peach,melon,brown) VALUES(?,?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1, username);
			ps.setString(2, name);
			ps.setInt(3, peach);
			ps.setInt(4, melon);
			ps.setInt(5, brown);
			ps.executeUpdate();
			System.out.println("addDrink Success");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("addDrink Error");
			e.printStackTrace();
		}

	}

	@Override
	public void addDrink(Drink d) {
		Connection conn = DbConnection.getDb();
		String SQL = "INSERT INTO drink(username,name,peach,melon,brown) VALUES(?,?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1, d.getUsername());
			ps.setString(2, d.getName());
			ps.setInt(3, d.getPeach());
			ps.setInt(4, d.getMelon());
			ps.setInt(5, d.getBrown());
			ps.executeUpdate();
			System.out.println("addDrink Success");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("addDrink Error");
			e.printStackTrace();
		}

	}

	@Override
	public List<Drink> queryAllList() {
		Connection conn = DbConnection.getDb();
		String SQL = "SELECT * FROM drink";
		List<Drink> l = new ArrayList<Drink>();
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Drink d = new Drink();
				d.setUsername(rs.getString("username"));
				d.setName(rs.getString("name"));
				d.setPeach(rs.getInt("peach"));
				d.setMelon(rs.getInt("melon"));
				d.setBrown(rs.getInt("brown"));
				l.add(d);
			}
			System.out.println("queryAllList Success");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("queryAllList Error");
			e.printStackTrace();
		}
		return l;
	}

	@Override
	public String queryAllString() {
		Connection conn = DbConnection.getDb();
		String SQL = "SELECT * FROM drink";
		String show = "";
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ResultSet rs = ps.executeQuery();
			show = "帳號\t名字\t密桃奶茶\t冷露歐雷\t黑糖鮮奶\n";
			while (rs.next()) {
				show = show + rs.getString("username") + "\t";
				show = show + rs.getString("name") + "\t";
				show = show + rs.getInt("peach") + "\t";
				show = show + rs.getInt("melon") + "\t";
				show = show + rs.getInt("brown") + "\n";
			}
			System.out.println("queryAllList Success");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("queryAllList Error");
			e.printStackTrace();
		}
		return show;
	}

	@Override
	public String queryHistoryByUsername(String username) {
		Connection conn = DbConnection.getDb();
		String SQL = "SELECT * FROM blueblue.drink where username = ?;";
		String show = "";

		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			show = " 次數\t名字\t密桃奶茶\t冷露歐雷\t黑糖鮮奶\n";
			int tmp = 1;
			while (rs.next()) {
				show = show + " " + tmp + "\t";
				show = show + " " + rs.getString("name") + "\t";
				show = show + " " + rs.getInt("peach") + "\t";
				show = show + " " + rs.getInt("melon") + "\t";
				show = show + " " + rs.getInt("brown") + "\n";
				tmp = tmp + 1;
			}
			System.out.println("queryHistoryByUsername Success");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("queryHistoryByUsername Error");
			e.printStackTrace();
		}

		return show;
	}

}
