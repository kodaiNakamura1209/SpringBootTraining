package com.example.demo.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.example.demo.Entity.DemoEntity;

@Repository
public class DemoRepository {
    // dto dao　を作ってみる
    public DemoEntity selectUserInfo(DemoEntity entity){
    	
    	// URLを定義 → propertyファイルに移動
    	String JDBC_URL2="jdbc:h2:mem:testdb";

    	try
    	{
    		// DBコネクションを取得
    		Connection conn = DriverManager.getConnection(JDBC_URL2, "sa", "");
    		
    		// SQLの生成
    		StringBuffer sql = new StringBuffer("SELECT USER_ID, USER_PASSWORD, USER_NAME FROM USER_INFO WHERE USER_ID = '");
    		sql.append(entity.getUserId());
    		sql.append("' AND USER_PASSWORD = '");
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
