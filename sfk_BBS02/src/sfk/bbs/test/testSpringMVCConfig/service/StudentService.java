package sfk.bbs.test.testSpringMVCConfig.service;

import java.util.List;

import sfk.bbs.test.testSpringMVCConfig.domain.StudentOfTestSpringMVC;

public interface StudentService
{
    public List<StudentOfTestSpringMVC> findAllStudent();
}
