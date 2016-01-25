package sfk.bbs.test.springjsbctempletTest;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import sfk.bbs.common.springUtil.SpringHelper;
import sfk.bbs.test.testSpringMVCConfig.domain.StudentOfTestSpringMVC;
/**
 * 又有一种世上无难事的感觉
 * 1.添加jar包
 * 2.配置xml文件
 * 3.代码
 * @author rocky
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TempletTest
{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Test
    public void select1() throws SQLException
    {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/sfkbbs?useUnicode=true&characterEncoding=utf-8");
        dataSource.setUsername("root");
        dataSource.setPassword("2011211961");
        Connection conn = dataSource.getConnection();
        PreparedStatement pstm = conn.prepareStatement("select * from tb_StudentOfTestSpringMVC");
        ResultSet rs = pstm.executeQuery();
        while(rs.next())
        {
            System.out.println(rs.getInt("id")+"==="+rs.getString("name"));
        }
        rs.close();
        pstm.close();
        conn.close();
    }
    
    
    @Test
    public void select2()
    {
        //JdbcTemplate jdbcTemplate = (JdbcTemplate)SpringHelper.getSpringHelper().getBean("jdbcTemplate");
        jdbcTemplate.query("select * from tb_StudentOfTestSpringMVC", new RowCallbackHandler()
        {
            @Override
            public void processRow(ResultSet rs) throws SQLException
            {
                System.out.println(rs.getInt("id")+"==="+rs.getString("name"));
            }
        });
    }
    
    @Test
    public void insert1()//经常使用
    {
        //id | name | gender | age  
        final String sql = "insert into tb_StudentOfTestSpringMVC(name,gender,age)values(?,?,?) ";
        int affectRow = jdbcTemplate.update(sql,"Spring","M",30);
        System.out.println(affectRow);
    }
    
    @Test
    public void insert2()//经常使用
    {
        final String sql = "insert into tb_StudentOfTestSpringMVC(name,gender,age)values(?,?,?) ";
        Object[] params = {"Spring","M",30};
        int affectRow = jdbcTemplate.update(sql, params, new int[]{Types.VARCHAR,Types.VARCHAR,Types.INTEGER});
        System.out.println(affectRow);
    }
    
    /**
     * 返回主键,常用
     */
    @Test
    public void insert3()
    {
        final String sql = "insert into tb_StudentOfTestSpringMVC(name,gender,age)values(?,?,?) ";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator()
        {
            
            @Override
            public PreparedStatement createPreparedStatement(Connection con)
                    throws SQLException
            {
                PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, "lilei");
                ps.setString(2, "male");
                ps.setInt(3, 25);
                return ps;
            }
        }, keyHolder);
        System.out.println("primary key : " + keyHolder.getKey().intValue());
    }
    
    @Test
    public void update1()//经常使用
    {
        final String sql = "update tb_StudentOfTestSpringMVC set name = ?,gender = ?,age = ? where id = ? ;";
        int affectRow = jdbcTemplate.update(sql,"Spring","M",8,8);
        System.out.println(affectRow);
    }
    
    @Test
    public void delete1()
    {
        final String sql = "delete from tb_StudentOfTestSpringMVC where id = ?";
        jdbcTemplate.update(sql,8);
    }
    
    /**
     * 经常使用,推荐
     */
    @Test
    public void handle14()
    {
        final String sql = "select * from tb_StudentOfTestSpringMVC where id=?";
        final List<StudentOfTestSpringMVC> studentList = new ArrayList<StudentOfTestSpringMVC>(1);
        jdbcTemplate.query(sql, new Object[]{9}, new RowCallbackHandler()
        {
            
            @Override
            public void processRow(ResultSet rs) throws SQLException
            {
                StudentOfTestSpringMVC student = new StudentOfTestSpringMVC();
                student.setId(rs.getLong("id"));
                student.setName(rs.getString("name"));
                student.setGender(rs.getString("gender"));
                student.setAge(rs.getInt("age"));
                
                studentList.add(student);
                
            }
        });
        
        for(StudentOfTestSpringMVC stu : studentList)
        {
            System.out.println("stu" + stu);
        }
    }
    /**
     * 经常使用,推荐
     */
    @Test
    public void handle18()
    {
        final String sql = "select * from tb_StudentOfTestSpringMVC where id=?";
        final List<StudentOfTestSpringMVC> studentList = new ArrayList<StudentOfTestSpringMVC>(1);
        
        jdbcTemplate.query(sql, new RowCallbackHandler()
        {
            
            @Override
            public void processRow(ResultSet rs) throws SQLException
            {
                StudentOfTestSpringMVC student = new StudentOfTestSpringMVC();
                student.setId(rs.getLong("id"));
                student.setName(rs.getString("name"));
                student.setGender(rs.getString("gender"));
                student.setAge(rs.getInt("age"));
                System.out.println("sutdent : "+student);
            }
        }, 8);
                
    }
    /**
     * 经常用,推荐
     */
    @Test
    public void handle19()
    {
        final String sql = "select * from tb_StudentOfTestSpringMVC where id > ?";
        final List<StudentOfTestSpringMVC> studentList = new ArrayList<StudentOfTestSpringMVC>(1);
        jdbcTemplate.query(sql, new Object[]{0},new RowCallbackHandler()
        {
            
            @Override
            public void processRow(ResultSet rs) throws SQLException
            {
                StudentOfTestSpringMVC stu = new StudentOfTestSpringMVC();
                stu.setName(rs.getString("name"));
                studentList.add(stu);
                
            }
        });
        for(StudentOfTestSpringMVC s : studentList)
        {
            System.out.println(s);
        }
    }
    
    @Test
    public void handle20()
    {
        final String sql = "select * from tb_StudentOfTestSpringMVC where id > ?";
        final List<StudentOfTestSpringMVC> studentList = new ArrayList<StudentOfTestSpringMVC>(1);
        jdbcTemplate.query(sql, new RowCallbackHandler(){

            @Override
            public void processRow(ResultSet rs) throws SQLException
            {
                StudentOfTestSpringMVC stu = new StudentOfTestSpringMVC();
                stu.setName(rs.getString("name"));
                studentList.add(stu);
                
            }}, 1);
        for(StudentOfTestSpringMVC s : studentList)
        {
            System.out.println(s);
        }
    }
    
    /**
     * RowMapper--100万集合中,--在发送
     */
    public void handle22()
    {
        
    }
}



































































