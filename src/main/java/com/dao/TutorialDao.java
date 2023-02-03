package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.Tutorial;

public class TutorialDao {

	private static Connection conn;
	public TutorialDao(Connection conn) {
		super();
		this.conn=conn;
	}
	public boolean addTutorial(Tutorial tutorial) {
		boolean f=false;
		try {
			
			String sql="insert into tutorial_db.tbl_tip(title,description,exampleHtmlEscape) values(?,?,?)";
			   PreparedStatement ps = conn.prepareStatement(sql);
			   ps.setString(1,tutorial.getTitle());
			   ps.setString(2,tutorial.getDecription());
			   ps.setString(3,tutorial.getExample());
			   int i=ps.executeUpdate();
			   if(i==1) {
				   f=true;
			   }			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	public List<Tutorial>getAllTutorial(){
		List<Tutorial> list=new ArrayList<Tutorial>();
		Tutorial t=null;
      try {
	  String sql="SELECT * FROM tutorial_db.tbl_tip";
	  PreparedStatement ps = conn.prepareStatement(sql);
	  ResultSet rs=ps.executeQuery();
	  while(rs.next()) {
		  t=new Tutorial();
		  t.setId(rs.getInt(1));
		  t.setTitle(rs.getString(2));
		  t.setDecription(rs.getString(3));
		  t.setExample(rs.getString(4));
		  list.add(t);
	  }
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	public Tutorial getTuturialById(int id) {
		Tutorial t=null;
		 try {
			  String sql="SELECT * FROM tutorial_db.tbl_tip where tip_id=?";
			  PreparedStatement ps = conn.prepareStatement(sql);
			  ps.setInt(1, id);
			  ResultSet rs=ps.executeQuery();
			  while(rs.next()) {
				  t=new Tutorial();
				  t.setId(rs.getInt(1));
				  t.setTitle(rs.getString(2));
				  t.setDecription(rs.getString(3));
				  t.setExample(rs.getString(4));
			  }
				System.out.println(t.getDecription());


				}catch(Exception e) {
					e.printStackTrace();
				}
		return t;		
	}
	public boolean UpdateTutorial(Tutorial tutorial) {
		boolean f=false;
		try {
			
			String sql="update tutorial_db.tbl_tip set title=?,description=?,exampleHtmlEscape=? where tip_id=?";
			   PreparedStatement ps = conn.prepareStatement(sql);
			   ps.setString(1,tutorial.getTitle());
			   ps.setString(2,tutorial.getDecription());
			   ps.setString(3,tutorial.getExample());
			   ps.setInt(4,tutorial.getId());

			   int i=ps.executeUpdate();
			   if(i==1) {
				   f=true;
			   }			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	public boolean deleteTutorial(int id) {
		boolean f=false;
		try {
			
			String sql="delete from tutorial_db.tbl_tip where tip_id=?";
			   PreparedStatement ps = conn.prepareStatement(sql);
			   ps.setInt(1,id);

			   int i=ps.executeUpdate();
			   if(i==1) {
				   f=true;
			   }			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return f;
	}
}
