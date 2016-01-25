package sfk.bbs.common.constance;

/**
 * 1.这个类里存储的是requestMapping中对对应的value
 * 2.命名规则是,全部大写,单词之间用下划线链接
 * 3.注意,这里的ActionURL没有.do
 * @author rocky
 */
public final class ActionURL
{
    /**测试Spring框架-- 显示学生的请求链接**/
    public final static String STUDENT_LIST = "/studentList";
    /**进入后台管理页面的链接***/
    public final static String ADMIN_INDEX = "/adminIndex"; 
    
    /**进入添加父板块页面的链接**/
    public final static String NEW_FATHER_MODULE = "/newFatherModule";
    /****saveFatherModule**/
    public final static String SAVE_FATHER_MODULE = "/saveFatherModule";
}
