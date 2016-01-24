package sfk.bbs.common.constance;

/**
 * 1.用来存储页面的"路径",
 * 2.目前的想法是
 * 路径的第一部分是pages文件夹下一层文件夹,第二部分是这个文件夹下面的页面,且不带.jsp后缀
 * 3.这个类中明明规则是,全部大写,单词之间用下划线连接
 * @author rocky
 */
public final class PagePath
{   
    /**测试Spring框--显示学生列表的页面***/
    public final static String STUDENT_LIST = "testPage/studentList";
    /***bbs后台显示页面**/
    public final static String ADMIN_INDEX = "admin/adminIndex"; 
}
