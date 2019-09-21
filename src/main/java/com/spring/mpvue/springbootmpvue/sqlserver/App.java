package com.spring.mpvue.springbootmpvue.sqlserver;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class App {

   /* public static void main(String[] args) {
	SqlSession session = getSqlSession();
	User u = (User) session.selectOne("selelctUser", 1);
	System.out.println(u);
	closeSession(session);
    }*/

    /*
     * 获取数据库访问链接
     */
    public static SqlSession getSqlSession() {
	String CONFIG_PATH = "TestConfig.xml";
        SqlSession session = null;
        try {
            InputStream stream = App.class.getResourceAsStream(CONFIG_PATH);
            //可以根据配置的相应环境读取相应的数据库环境
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(stream);
            session = factory.openSession();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return session;
    }

    /*
     * 关闭数据库访问链接
     */
    public static void closeSession(SqlSession session) {
        session.close();
    }
    
}
