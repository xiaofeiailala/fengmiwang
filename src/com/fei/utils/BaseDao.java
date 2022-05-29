package com.fei.utils;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BaseDao {

    public int update(Connection conn,String sql,Object...arr) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            int count = ps.getParameterMetaData().getParameterCount();
            if (arr != null && arr.length == count){
                for (int i = 0; i < count; i++) {
                    ps.setObject(i+1,arr[i]);
                }
            }
            int i = ps.executeUpdate();
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCDruidUtils.close(ps);
        }
        return 0;
    }

    public <T> List<T> select(Connection conn, Class<T> clzss, String sql, Object...arr){
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            int count = ps.getParameterMetaData().getParameterCount();
            if (arr != null && count == arr.length){
                for (int i = 0; i < count; i++) {
                    ps.setObject(i+1,arr[i]);
                }
            }
            rs = ps.executeQuery();
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();
            List<T> list = new ArrayList<>();
            while (rs.next()){
                T t = clzss.newInstance();
                for (int i = 0; i < columnCount; i++) {
                    String name = metaData.getColumnLabel(i + 1);
                    Object value = rs.getObject(name);
                    //通过反射赋值
                    Field field = clzss.getDeclaredField(name);
                    field.setAccessible(true);
                    field.set(t,value);
                    //BeanUtils.setProperty(t,name,value);
                }
                list.add(t);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCDruidUtils.close(ps,rs);
        }
        return null;
    }

    public <E> E selectCount(Connection connection,String sql,Object...arr){
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement(sql);
            for (int i = 0; i < arr.length; i++) {
                ps.setObject(i+1,arr[i]);
            }
            rs = ps.executeQuery();
            Object object = null;
            if (rs.next()){
                object = rs.getObject(1);
            }
            return (E)object;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCDruidUtils.close(ps,rs);
        }
        return null;
    }
}
