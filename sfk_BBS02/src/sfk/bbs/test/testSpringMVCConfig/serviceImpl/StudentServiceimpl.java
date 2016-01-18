package sfk.bbs.test.testSpringMVCConfig.serviceImpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sfk.bbs.test.testSpringMVCConfig.dao.StudentDao;
import sfk.bbs.test.testSpringMVCConfig.domain.StudentOfTestSpringMVC;
import sfk.bbs.test.testSpringMVCConfig.service.StudentService;

@Service
public class StudentServiceimpl implements StudentService
{
    private Logger log = Logger.getLogger(StudentServiceimpl.class);

    @Autowired
    private StudentDao studentDao;
    
    @Override
    public List<StudentOfTestSpringMVC> findAllStudent()
    {
        // TODO Auto-generated method stub
        return studentDao.findAll();
    }
    
}
