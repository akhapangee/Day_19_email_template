/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.akhilesh.core.template;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Akhilesh
 */
public class JdbcTemplate<T> {

    public List<T> query(String sql,RowMapper<T> mapper) throws ClassNotFoundException, SQLException {
        List<T> rows = new ArrayList<>();
        
        Class.forName("com.mysql.jdbc.cj.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/db", "root", "");
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        
        while(rs.next()){
            rows.add(mapper.mapRow(rs));
        }
        conn.close();
        return  rows;
    }
}
