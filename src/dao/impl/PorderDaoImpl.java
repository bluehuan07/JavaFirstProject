package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.DbConnection;
import dao.PorderDao;
import model.People;
import model.Porder;

public class PorderDaoImpl implements PorderDao {
	public static void main(String[] args) {
//		new PorderDaoImpl().addPorder(new Porder("a", 100, 50, 25));

//		List<Porder> l = new PorderDaoImpl().selectAll();
//		for (Porder p : l) {
//			System.out.println(p.getId() + "\t" + p.getName() + "\t" + p.getA());
//		}

		Porder p = new PorderDaoImpl().selectById(1);
		System.out.println(p.getId() + "\t" + p.getName() + "\t" + p.getA());

//		Member m=new MemberDaoImpl().queryMemberByUsername("ccc");
//		m.setName("teacher");
//		m.setPassword("000000");
//		m.setAddress("高雄");
//		m.setPhone("777777");	
//		new MemberDaoImpl().updateMember(m);

//		new MemberDaoImpl().deleteMember(5);

//		System.out.println(new MemberDaoImpl().queryMember("ppp", "222"));
//		System.out.println(new MemberDaoImpl().queryMemberByUsername("ccc"));

	}

	@Override
	public void addPorder(Porder p) {
		Connection conn = DbConnection.getDb();
		String SQL = "INSERT INTO porder(name,a,b,c) VALUES(?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1, p.getName());
			ps.setInt(2, p.getA());
			ps.setInt(3, p.getB());
			ps.setInt(4, p.getC());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public List<Porder> selectAll() {
		Connection conn = DbConnection.getDb();
		String SQL = "SELECT * FROM porder";
		List<Porder> l = new ArrayList<Porder>();
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Porder p = new Porder();
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setA(rs.getInt("a"));
				p.setB(rs.getInt("b"));
				p.setC(rs.getInt("c"));
				l.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}

	@Override
	public Porder selectById(int id) {
		Connection conn = DbConnection.getDb();
		String SQL = "SELECT * FROM porder WHERE id=?";
		Porder p = null;
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				p = new Porder();
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setA(rs.getInt("A"));
				p.setB(rs.getInt("B"));
				p.setC(rs.getInt("C"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return p;
	}

}
