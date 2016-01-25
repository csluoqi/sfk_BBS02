package sfk.bbs.admin.entity;

/**
 * 父板块实体类
 * 
 * @author rocky
 *
 */
public class FatherModule
{
    private Long id;
    private String moduelName;
    private int sort;

    public FatherModule()
    {
        super();
    }

    public FatherModule(Long id, String moduelName, int sort)
    {
        super();
        this.id = id;
        this.moduelName = moduelName;
        this.sort = sort;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getModuelName()
    {
        return moduelName;
    }

    public void setModuelName(String moduelName)
    {
        this.moduelName = moduelName;
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
        return "FatherModule [id=" + id + ", moduelName=" + moduelName
                + ", sort=" + sort + "]";
    }

}
