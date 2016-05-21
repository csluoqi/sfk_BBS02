package sfk.bbs.test.testSpringMVCConfig.domain;

import java.util.Date;

public class StudentOfTestSpringMVC
{
    private Long id;
    private String name;
    private String gender;
    // 测试 整型 (在验证表单对象的合法性时)
    private Integer stuNumber;
    // 测试 时间类型 (在验证表单对象的合法性时)
    private Date birthday;

    public Integer getStuNumber()
    {
        return stuNumber;
    }

    public void setStuNumber(Integer stuNumber)
    {
        this.stuNumber = stuNumber;
    }

    public Date getBirthday()
    {
        return birthday;
    }

    public void setBirthday(Date birthday)
    {
        this.birthday = birthday;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getGender()
    {
        return gender;
    }

    public void setGender(String gender)
    {
        this.gender = gender;
    }

    @Override
    public String toString()
    {
        return "StudentOfTestSpringMVC [id=" + id + ", name=" + name
                + ", gender=" + gender + ", stuNumber=" + stuNumber
                + ", birthday=" + birthday + "]";
    }
    
    
}
