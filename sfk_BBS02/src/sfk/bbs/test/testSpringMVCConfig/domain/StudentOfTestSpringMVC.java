package sfk.bbs.test.testSpringMVCConfig.domain;

public class StudentOfTestSpringMVC
{
    private Long id;
    private String name;
    private String gender;
    private Integer age;
    
    
    
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
    public Integer getAge()
    {
        return age;
    }
    public void setAge(Integer age)
    {
        this.age = age;
    }
    @Override
    public String toString()
    {
        return "StudentOfTestSpringMVC [id=" + id + ", name=" + name
                + ", gender=" + gender + ", age=" + age + "]";
    }
}
