package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.Tutorial;
import com.entity.User;

public class UserDao {

	private static Connection conn;

	public UserDao(Connection conn) {
		super();
		this.conn=conn
				;
	}
	public boolean addUser(User user) {
		boolean f=false;
		try {
			
			String sql="insert into tutorial_db.user(UserName,Password) values(?,?)";
			   PreparedStatement ps = conn.prepareStatement(sql);
			   ps.setString(1,user.getUserName());
			   ps.setString(2,user.getPassword());
			 
			   int i=ps.executeUpdate();
			   if(i==1) {
				   f=true;
			   }			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	public List<User>getAllUser(){
		List<User> list=new ArrayList<User>();
		User t=null;
      try {
	  String sql="SELECT * FROM tutorial_db.user";
	  PreparedStatement ps = conn.prepareStatement(sql);
	  ResultSet rs=ps.executeQuery();
	  while(rs.next()) {
		  t=new User();
		  t.setId(rs.getInt(1));
		  t.setUserName(rs.getString(2));
		  t.setPassword(rs.getString(3));
		  list.add(t);
	  }
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	public User getUserById(int id) {
		User t=null;
		 try {
			  String sql="SELECT * FROM tutorial_db.user where Id=?";
			  PreparedStatement ps = conn.prepareStatement(sql);
			  ps.setInt(1, id);
			  ResultSet rs=ps.executeQuery();
			  while(rs.next()) {
				  t=new User();
				  t.setId(rs.getInt(1));
				  t.setUserName(rs.getString(2));
				  t.setPassword(rs.getString(3));
			  }

				}catch(Exception e) {
					e.printStackTrace();
				}
		return t;		
	}
	public boolean UpdateUser(User user) {
		boolean f=false;
		try {
			
			String sql="update tutorial_db.user set UserName=?,Password=? where Id=?";
			   PreparedStatement ps = conn.prepareStatement(sql);
			   ps.setString(1,user.getUserName());
			   ps.setString(2,user.getPassword());			  
			   ps.setInt(3,user.getId());

			   int i=ps.executeUpdate();
			   if(i==1) {
				   f=true;
			   }			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	public boolean deleteUser(int id) {
		boolean f=false;
		try {
			
			String sql="delete from tutorial_db.User where Id=?";
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
