package sfk.bbs.admin.entity;

/**
 * 父板块实体类
 * 
 * @author rocky
 *
 */
public class FatherModule
{
    private long id;
    private String moduleName;
    private int sort;

    public FatherModule()
    {
        super();
    }

    public FatherModule(Long id, String moduleName, int sort)
    {
        super();
        this.id = id;
        this.moduleName = moduleName;
        this.sort = sort;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public String getModuleName()
    {
        return moduleName;
    }

    public void setModuleName(String moduelName)
    {
        this.moduleName = moduelName;
    }

    public int getSort()
    {
        return sort;
    }

    public void setSort(int sort)
    {
        this.sort = sort;
    }

    @Override
    public String toString()
    {
        return "FatherModule [id=" + id + ", moduelName=" + moduleName
                + ", sort=" + sort + "]";
    }
}
