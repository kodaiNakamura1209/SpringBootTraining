package com.example.demo.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.DemoEntity;
import com.example.demo.dataSource.DbAccessDataSource;

@Repository
public class DemoRepository {
	
	@Autowired
	DbAccessDataSource dataSource;
	
    // dto dao　を作ってみる
    public DemoEntity selectUserInfo(DemoEntity entity){
    	
    	try
    	{
    		// DBコネクションを取得
    		Connection conn = DriverManager.getConnection(dataSource.getUrl(), dataSource.getUsername(), dataSource.getPassword());
    		
    		// SQLの生成
    		StringBuffer sql = new StringBuffer("SELECT \"USER_ID\", \"USER_PASSWORD\", \"USER_NAME\" FROM public.\"USER_INFO\" WHERE \"USER_ID\" = '");
    		sql.append(entity.getUserId());
    		sql.append("' AND \"USER_PASSWORD\" = '");
    		sql.append(entity.getUserPassword());
    		sql.append("';");
    		PreparedStatement pStmt = conn.prepareStatement(sql.toString());
    		
    		// 検索結果の取得
    		ResultSet rs = pStmt.executeQuery();
    		rs.next();

    		// Entityに取得結果を格納
    		DemoEntity resultEntity = new DemoEntity(rs.getString("USER_ID"), rs.getString("USER_PASSWORD"), rs.getString("USER_NAME"));
    		
    		System.out.println("USER_ID=" + resultEntity.getUserId());
    		System.out.println("USER_PASSWORD=" + resultEntity.getUserPassword());
    		System.out.println("USER_NAME=" + resultEntity.getUserName());
    		
    		return resultEntity;
    	}
    	catch (SQLException sqlex)
    	{
    		System.out.println(sqlex);
    		return new DemoEntity("", "", "");
    	}
    }
}
