/**
 * adminIndex.jsp页面
 */
$.ajaxSetup(
{
    dataType : 'json',
    contentType : 'application/json;charset=utf-8'
});

/**
 * 删除一个父板块
 * 采用和cnblogs后台的删除一样的操作方法
 * @param moduleId
 *            父板块Id
 * @param title
 *            父板块名称
 */
function DeleteFatherModule(moduleId, title)
{
    //alert(moduleId + "" + title);
    if (!confirm("确认删除＂" + title + "＂吗?"))
    {
        return false;
    }
    //fatherModule_
    $("#fatherModule_"+moduleId).html("<td colspan='3'><span style='color:red'>删除操作中...</span></td>");
    $.ajax(
    {
        type : 'DELETE',
        dataType : 'json',
        contentType : 'application/json;charset=utf-8',
        url : "/sfk_BBS02/rest/fatherModule/" + moduleId,
        // data:{_method:'delete'},
        success : function(data)
        {
            // data in (true,false)
            if (data)
            {
                $("#fatherModule_"+moduleId).html("<td colspan='3'><span style='color:red'>删除成功!</span></td>");
            }
            else
            {
                $("#fatherModule_"+moduleId).html("<td colspan='3'><span style='color:red'>删除失败!</span></td>");
            }
        },
        error : function()
        {
            $("#fatherModule_"+moduleId).html("<td colspan='3'><span style='color:red'>Error!</span></td>");
        }
    });

    /**
     * 
     * 
     * url: '/post/delete', type: 'post', data: '{"postId":' + entryId + '}',
     * contentType: 'application/json', dataType: 'json', success: function
     * (data) { if (data.isSuccess) { $("#entry_" + entryId).html("
     * <td colspan='7'><span style='color:red'>删除成功！</span></td>
     * "); } else { $("#entry_" + entryId).html("
     * <td colspan='7'><span style='color:red'>删除失败！" + data.msg + "</span></td>
     * "); } }, error: function (xhr) { $("#entry_" + entryId).html("
     * <td colspan='7'><span style='color:red'>" + xhr.responseText + "</span></td>
     * "); }
     */

}