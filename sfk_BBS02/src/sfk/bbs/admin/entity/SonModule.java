package sfk.bbs.admin.entity;

public class SonModule
{
    private Long id;
    private FatherModule fatherModule;
    private String moduleName;
    private String info;
    private Long memberId;
    private long sort;

    public SonModule()
    {
        super();
    }

    public FatherModule getFatherModule()
    {
        return fatherModule;
    }

    public void setFatherModule(FatherModule fatherModule)
    {
        this.fatherModule = fatherModule;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getModuleName()
    {
        return moduleName;
    }

    public void setModuleName(String moduleName)
    {
        this.moduleName = moduleName;
    }

    public String getInfo()
    {
        return info;
    }

    public void setInfo(String info)
    {
        this.info = info;
    }

    public Long getMemberId()
    {
        return memberId;
    }

    public void setMemberId(Long memberId)
    {
        this.memberId = memberId;
    }

    public long getSort()
    {
        return sort;
    }

    public void setSort(long sort)
    {
        this.sort = sort;
    }

}
