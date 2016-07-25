package sfk.bbs.common.constance;

/**
 * 1.用来存储页面的"路径",
 * 2.目前的想法是
 * 路径的第一部分是pages文件夹下一层文件夹,第二部分是这个文件夹下面的页面,且不带.jsp后缀
 * 3.这个类中明明规则是,全部大写,单词之间用下划线连接
 * @author rocky
 */
public interface PagePath
{   
    /**测试Spring框--显示学生列表的页面***/
    public final static String STUDENT_LIST = "testPage/studentList";
    /**输入学生页面的页面**/
    public final static String INPUT_STUDENT = "testPage/inputStudent";
    
    /***bbs后台显示页面**/
    public final static String ADMIN_INDEX = "admin/adminIndex";
    /**新增父版块**/
    public final static String NEW_FATHER_MODULE = "admin/newFatherModule";
    /**修改父版块页面updateFatherModule**/
    public final static String UPDATE_FATHER_MODULE = "admin/updateFatherModule";
    
    /**新增子版块newSonModule**/
    public final static String NEW_SON_MODULE = "admin/newSonModule";
    /**子版块列表页面sonModuleList**/
    public final static String SON_MODULE_LIST = "admin/sonModuleList";
}
