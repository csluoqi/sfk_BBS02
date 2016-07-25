package sfk.bbs.common.constance;

/**
 * 1.这个类里存储的是requestMapping中对对应的value
 * 2.命名规则是,全部大写,单词之间用下划线链接
 * 3.注意,这里的ActionURL没有.do
 * 4.从updateFatherModule开始，跳转到页面的连接都在处理这个连接的后面加Go
 * 5.new开头表示新增，update开头表示更新
 * (其实也可一用Page，但是觉得Go比较简单所以就默认用Go了)结尾
 * @author rocky
 */
public   interface ActionURL
{
    /**测试Spring框架-- 显示学生的请求链接**/
    public final static String STUDENT_LIST = "/studentList";
    /**转发输入学生页面的表单**/
    public final static String INPUT_STUDENT = "/inputStudent";
    /**保存一个输入的学生表单**/
    public final static String SAVE_STUDENT = "/saveStudent";
    /**进入后台管理页面的链接***/
    public final static String ADMIN_INDEX = "/adminIndex"; 
    
    /**进入添加父板块页面的链接**/
    public final static String NEW_FATHER_MODULE = "/newFatherModule";
    /****saveFatherModule**/
    public final static String SAVE_FATHER_MODULE = "/saveFatherModule";
    /**修改父版块***/
    public final static String UPDATE_FATHER_MODULE = "/updateFatherModule";
    /**修改父版块页面***/
    public final static String UPDATE_FATHER_MODULE_GO = "/updateFatherModuleGo";
    /**新增子版块页面**/
    public final static String NEW_SON_MODULE_GO = "/newSonModuleGo";
    /**新增子版块**/
    public final static String NEW_SON_MODULE = "/newSonModule";
    /**子版块列表**/
    public final static String SON_MODULE_LIST  = "/sonModuleList";
}
