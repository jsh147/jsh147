package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.SolDTO;

public class SolDAO {
	public Connection conn;
	public PreparedStatement ps;
	public ResultSet rs;
	
	public SolDAO() {
		conn = DBConnection.getConnection();
	}

	public boolean checkid(String solid) {
		try {
			String sql = "select * from captain where solid = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, solid);
			
			rs = ps.executeQuery();
			
			return !rs.next();
		} catch (SQLException e) {
		}
		return false;
	}

	public boolean join(SolDTO newSol) {
		try {
			String sql = "insert into captain (solid,solpw,solclass,solposition,solname,solbirth,gunnum,basenum) values(?,?,?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, newSol.solid);
			ps.setString(2, newSol.solpw);
			ps.setString(3, newSol.solclass);
			ps.setString(4, newSol.solposition);
			ps.setString(5, newSol.solname);
			ps.setString(6, newSol.solbirth);
			ps.setInt(7, newSol.gunnum);
			ps.setInt(8, newSol.basenum);
			
			return ps.executeUpdate() == 1;
			
		} catch (SQLException e) {
		}
		
		return false;
	}

	public boolean login(String solid, String solpw) {
		try {
			String sql = "select * from captain where solid = ? and solpw = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, solid);
			ps.setString(2, solpw);
		
			rs = ps.executeQuery();
		
			if(rs.next()) {
				SolDTO loginSol = new SolDTO();
				loginSol.solid = rs.getString("solid");
				loginSol.solpw = rs.getString("solpw");
				loginSol.solclass = rs.getString("solclass");
				loginSol.solposition = rs.getString("solposition");
				loginSol.solname = rs.getString("solname");
				loginSol.solbirth = rs.getString("solbirth");
				loginSol.state = rs.getString("state");
				loginSol.gunnum = rs.getInt("gunnum");
				loginSol.basenum = rs.getInt("basenum");
			
				Session.setData("loginSol", loginSol);
				
				return true;
			}
		} catch (SQLException e) {
			System.out.println("sql오류");
		}
		System.out.println("오류발생");
		return false;
	}

	public ArrayList<SolDTO> getList() {
		String solid = ((SolDTO)Session.getData("loginSol")).solid;
		ArrayList<SolDTO> result = new ArrayList<SolDTO>();
		String sql = "select * from captain where solid = ?";

		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, solid);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				SolDTO s = new SolDTO();
				s.solid = rs.getString("solid");
				s.solpw = rs.getString("solpw" );
				s.solclass = rs.getString("solclass" );
				s.solposition = rs.getString("solposition" );
				s.solname = rs.getString("solname" );
				s.solbirth = rs.getString("solbirth" );
				s.state = rs.getString("state" );
				s.gunnum = rs.getInt("gunnum" );
				s.basenum = rs.getInt("basenum" );
			
				result.add(s);
			}
		} catch (SQLException e) {
		}
		
		return result;
	}
	public boolean leaveId(String solid) {
		try {
			String sql = "delete from captain where solid = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, solid);
			if(ps.executeUpdate() == 1) {
				Session.setData("loginSol", null);
				return true;
			}
		} catch (SQLException e) {
		}
		
		return false;
	}
	public boolean modifySol(String solid, int choice, String newData) {
		//choice : 1 - 암호 / 2 - 계급 / 3 - 직책 / 4 - 소속/
		String[] cols = {"","solpw","solclass","solposition","basenum"};
		String sql = "update captain set " + cols[choice] + " = ? where solid = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, newData);
			ps.setString(2, solid);
			
			if(ps.executeUpdate() == 1) {
				sql = "select * from captain where solid = ?";
				ps = conn.prepareStatement(sql);
				ps.setString(1, solid);
				
				rs = ps.executeQuery();
				if(rs.next()) {
					SolDTO loginSol = new SolDTO();
					loginSol.solid = rs.getString("solid");
					loginSol.solpw = rs.getString("solpw");
					loginSol.solclass= rs.getString("solclass");
					loginSol.solname = rs.getString("solname");
					loginSol.solbirth = rs.getString("solbirth");
					loginSol.solposition = rs.getString("solposition");
					loginSol.state = rs.getString("state");
					loginSol.gunnum = rs.getInt("gunnum");
					loginSol.basenum = rs.getInt("basenum");
					loginSol.regdate = rs.getString("regdate");
					Session.setData("loginSol", loginSol);
				}
				return true;
			}
		} catch (SQLException e) {
		}
		return false;
	}
	
	
}
