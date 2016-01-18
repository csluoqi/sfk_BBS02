package sfk.bbs.test.testSpringMVCConfig.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import sfk.bbs.test.testSpringMVCConfig.dao.service.StudentDaoService;
import sfk.bbs.test.testSpringMVCConfig.dao.serviceImpl.BaseDaoImpl;
import sfk.bbs.test.testSpringMVCConfig.domain.StudentOfTestSpringMVC;

@Repository
public class StudentDao implements StudentDaoService
{
    public static Logger log = Logger.getLogger(StudentDao.class);
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public List<StudentOfTestSpringMVC> findAll()
    {
        final String sql = "select * from tb_StudentOfTestSpringMVC;";
        final List<StudentOfTestSpringMVC> studentList = new ArrayList<StudentOfTestSpringMVC>(1);
        jdbcTemplate.query(sql, new RowCallbackHandler()
        {
            @Override
            public void processRow(ResultSet rs) throws SQLException
            {
                StudentOfTestSpringMVC stu = new StudentOfTestSpringMVC();
                stu.setName(rs.getString("name"));
                studentList.add(stu);
            }
        });
        System.out.println("studentList"+ studentList);
        return studentList;
    }

    @Override
    public StudentOfTestSpringMVC getById(Long id)
    {
        // TODO Auto-generated method stub
        return null;
    }

    
}
