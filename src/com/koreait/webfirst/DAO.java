package com.koreait.webfirst;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DAO { 
	public static int updHobby(HobbyEntity param) {
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = "UPDATE t_hobby"
				+ " SET nm = ? "
				+ " WHERE i_hobby = ? ";
				
		try {
			con = DbUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, param.getNm());
			ps.setInt(2, param.getI_hobby());
			System.out.println(ps);
			return ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtils.close(con, ps);
		}
		return 0;

	}
	
	public static int delHobby(HobbyEntity param) { // param 외부
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = "DELETE FROM t_hobby WHERE i_hobby = ?"; // 물음표가 있었다면 무조건 값을 채워줘야함
				
		try {
			con = DbUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, param.getI_hobby());
			System.out.println(ps);
			return ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtils.close(con, ps);
		}
		return 0;
		
	}
	
	public static int insHobby(HobbyEntity param) {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "INSERT INTO t_hobby"
				+ " (i_hobby, nm)"
				+ " SELECT IFNULL(MAX(i_hobby), 0) + 1, ? FROM t_hobby ";
				
		try {
			con = DbUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, param.getNm());
			System.out.println(ps);
			return ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtils.close(con, ps);
		}
		
		return 0;
		
	}
	
	public static HobbyEntity selHobby(HobbyEntity param){ // 특정한 것만 가지고 오기 위해 파라미터를 씀
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT nm FROM t_hobby WHERE i_hobby = ? "; 
		// where절에 pk가 들어가면 1)0줄 > 값이 없는 거 (pk아닌 값) 아니면 2)1줄 > 값이 있는 거 (pk값) >> 무조건 0줄 아니면 1줄이 나옴
		
		try {
			con = DbUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, param.getI_hobby());
			rs = ps.executeQuery();
			
			if(rs.next()) { // 최초 : 첫줄 가리킴 , 레코드가 있으면 true 없으면 false 또 호출됐다 ? 그럼 다음 레코드를 가리킴 레코드 수 만큼 실행시키기 위함
				HobbyEntity vo = new HobbyEntity();
				String nm = rs.getNString("nm");
				vo.setNm(nm);
				return vo;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtils.close(con, ps, rs);
		}
		return null;
		
	}
	
	public static List<HobbyEntity> selHobbyList() { // 특정한 것만 가지고 오는게 아니라 전체 다 들고 올거라서 파라미터가 필요없음
		List<HobbyEntity> list = new ArrayList();
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "SELECT i_hobby, nm FROM t_hobby";
		
		try {
			con = DbUtils.getCon();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) { 
					int i_hobby = rs.getInt("i_hobby");
					String nm = rs.getNString("nm");
					
					HobbyEntity vo = new HobbyEntity();
					vo.setI_hobby(i_hobby);
					vo.setNm(nm);
					list.add(vo);
			}
		} catch (Exception e) {
				e.printStackTrace();
		} finally {
			DbUtils.close(con, ps, rs);
		} 
		return list;
		
	}
	
	
}
