package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.DbConnection;
import dao.PeopleDao;
import model.People;

public class PeopleDaoImpl implements PeopleDao {

	public static void main(String[] args) {
//		new PeopleDaoImpl().addPeople("abc", "ppp","josh","tai","tai","1212","4444");
//		new PeopleDaoImpl().addPeople(new People("zxc", "ccc","kobe","chi","tai","1021","4444"));
//
//		List<People> l=new PeopleDaoImpl().queryAllList();
//		for (People p : l) {
//			System.out.println(p.getIdpeople() + "\t" + p.getName() + "\t" + p.getUsername());
//		}
//		System.out.print(new PeopleDaoImpl().queryAllString());
//
//		People p=new PeopleDaoImpl().queryPeopleById(1);
//		p.setPassword("001");
//		p.setName("danny");
//		p.setAddress1("kao");
//		p.setTel("8888");	
//		new PeopleDaoImpl().updatePeopleById(p);
//		p=new PeopleDaoImpl().queryPeopleByUsername("zxc");
//		p.setPassword("kkk");
//		p.setName("jame");
//		p.setAddress1("tai");
//		p.setTel("9999");	
//		new PeopleDaoImpl().updatePeopleByUsername(p);
//		System.out.print(new PeopleDaoImpl().queryAllString());

//		System.out.println(new PeopleDaoImpl().queryPeople("abc", "001").getName());
	}

	@Override
	public void addPeople(String username, String password, String name, String address1, String address2,
			String birthday, String tel) {
		Connection conn = DbConnection.getDb();
		String SQL = "INSERT INTO people(username,password,name,address1,address2,birthday,tel) VALUES(?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1, username);
			ps.setString(2, password);
			ps.setString(3, name);
			ps.setString(4, address1);
			ps.setString(5, address2);
			ps.setString(6, birthday);
			ps.setString(7, tel);
			ps.executeUpdate();
			System.out.println("addPeople Success");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("addPeople Error");
			e.printStackTrace();
		}

	}

	@Override
	public void addPeople(People p) {
		Connection conn = DbConnection.getDb();
		String SQL = "INSERT INTO people(username,password,name,address1,address2,birthday,tel) VALUES(?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1, p.getUsername());
			ps.setString(2, p.getPassword());
			ps.setString(3, p.getName());
			ps.setString(4, p.getAddress1());
			ps.setString(5, p.getAddress2());
			ps.setString(6, p.getBirthday());
			ps.setString(7, p.getTel());
			ps.executeUpdate();
			System.out.println("addPeople Success");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("addPeople Error");
			e.printStackTrace();
		}

	}

	@Override
	public List<People> queryAllList() {
		Connection conn = DbConnection.getDb();
		String SQL = "SELECT * FROM people";
		List<People> l = new ArrayList<People>();
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				People p = new People();
				p.setIdpeople(rs.getInt("idpeople"));
				p.setUsername(rs.getString("username"));
				p.setPassword(rs.getString("password"));
				p.setName(rs.getString("name"));
				p.setAddress1(rs.getString("address1"));
				p.setAddress2(rs.getString("address2"));
				p.setBirthday(rs.getString("birthday"));
				p.setTel(rs.getString("tel"));
				l.add(p);
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
		String SQL = "SELECT * FROM people";
		String show = "";
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ResultSet rs = ps.executeQuery();
			show = "id\t帳號\t密碼\t名字\t戶籍地址1\t通訊地址2\t生日\t電話\n";
			while (rs.next()) {
				show = show + rs.getInt("idpeople") + "\t";
				show = show + rs.getString("username") + "\t";
				show = show + rs.getString("password") + "\t";
				show = show + rs.getString("name") + "\t";
				show = show + rs.getString("address1") + "\t";
				show = show + rs.getString("address2") + "\t";
				show = show + rs.getString("birthday") + "\t";
				show = show + rs.getString("tel") + "\n";
			}
			System.out.println("queryAllString Success");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("queryAllString Error");
			e.printStackTrace();
		}
		return show;
	}

	@Override
	public People queryPeopleById(int idpeople) {
		Connection conn = DbConnection.getDb();
		String SQL = "SELECT * FROM people WHERE idpeople=?";
		People p = null;
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setInt(1, idpeople);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				p = new People();
				p.setIdpeople(rs.getInt("idpeople"));
				p.setUsername(rs.getString("username"));
				p.setPassword(rs.getString("password"));
				p.setName(rs.getString("name"));
				p.setAddress1(rs.getString("address1"));
				p.setAddress2(rs.getString("address2"));
				p.setBirthday(rs.getString("birthday"));
				p.setTel(rs.getString("tel"));
			}
			System.out.println("queryPeopleById Success");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("queryPeopleById Error");
			e.printStackTrace();
		}

		return p;
	}

	@Override
	public People queryPeopleByUsername(String username) {
		Connection conn = DbConnection.getDb();
		String SQL = "SELECT * FROM people WHERE username=?";
		People p = null;
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				p = new People();
				p.setIdpeople(rs.getInt("idpeople"));
				p.setUsername(rs.getString("username"));
				p.setPassword(rs.getString("password"));
				p.setName(rs.getString("name"));
				p.setAddress1(rs.getString("address1"));
				p.setAddress2(rs.getString("address2"));
				p.setBirthday(rs.getString("birthday"));
				p.setTel(rs.getString("tel"));
			}
			System.out.println("queryPeopleByUsername Success");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("queryPeopleById Error");
			e.printStackTrace();
		}

		return p;
	}

	@Override
	public People queryPeople(String username, String password) {
		Connection conn = DbConnection.getDb();
		String SQL = "SELECT * FROM people WHERE username=? and password=?";
		People p = null;
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				p = new People();
				p.setIdpeople(rs.getInt("idpeople"));
				p.setUsername(rs.getString("username"));
				p.setPassword(rs.getString("password"));
				p.setName(rs.getString("name"));
				p.setAddress1(rs.getString("address1"));
				p.setAddress2(rs.getString("address2"));
				p.setBirthday(rs.getString("birthday"));
				p.setTel(rs.getString("tel"));
			}
			System.out.println("queryPeople Success");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("queryPeople Error");
			e.printStackTrace();
		}

		return p;
	}

	@Override
	public void updatePeopleById(People p) {
		Connection conn = DbConnection.getDb();
		String SQL = "update people set password=?,name=?,address1=?,address2=?,birthday=?,tel=? where idpeople=?";
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1, p.getPassword());
			ps.setString(2, p.getName());
			ps.setString(3, p.getAddress1());
			ps.setString(4, p.getAddress2());
			ps.setString(5, p.getBirthday());
			ps.setString(6, p.getTel());
			ps.setInt(7, p.getIdpeople());		
			ps.executeUpdate();
			System.out.println("updatePeopleById Success");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("updatePeopleById Error");
			e.printStackTrace();
		}

	}

	@Override
	public void updatePeopleByUsername(People p) {
		Connection conn = DbConnection.getDb();
		String SQL = "update people set password=?,name=?,address1=?,address2=?,birthday=?,tel=? where username=?";
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1, p.getPassword());
			ps.setString(2, p.getName());
			ps.setString(3, p.getAddress1());
			ps.setString(4, p.getAddress2());
			ps.setString(5, p.getBirthday());
			ps.setString(6, p.getTel());
			ps.setString(7, p.getUsername());
			ps.executeUpdate();
			System.out.println("updatePeopleByUsername Success");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("updatePeopleByUsername Error");
			e.printStackTrace();
		}

	}

	@Override
	public void deletePeopleById(int idpeople) {
		Connection conn = DbConnection.getDb();
		String SQL = "DELETE FROM people WHERE idpeople=?";

		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setInt(1, idpeople);
			ps.executeUpdate();
			System.out.println("deletePeopleById Success");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("deletePeopleById Error");
			e.printStackTrace();
		}

	}

	@Override
	public void deletePeopleByUsernam(String username) {
		Connection conn = DbConnection.getDb();
		String SQL = "DELETE FROM people WHERE username=?";

		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1, username);
			ps.executeUpdate();
			System.out.println("deletePeopleByUsernam Success");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("deletePeopleByUsernam Error");
			e.printStackTrace();
		}

	}

}
