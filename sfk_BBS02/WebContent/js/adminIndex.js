/**
 * adminIndex.jsp页面
 */
$.ajaxSetup(
{
    dataType : 'json',
    contentType : 'application/json;charset=utf-8'
});

$(function(){
    //alert(123);
    $("#newFatherModule").validate({
        submitHandler:function(){
            alert("恭喜你验证成功"+$("#moduleName").val());
            return true;
        },
        invalidHandler:function(event,validator){
            //alert('对不起，您有'+validator.numberOfInvalids()+'个验证项没有通过');
        },
        rules:{
            moduleName:
                {
                    required:true,
                    maxlength:50
                },
                sort:
                {
                    required:true,
                    max:10000,
                    min:0
                }
            },
            errorPlacement:function(error, element){
                //alert(1111);
                error.appendTo(element.parent());
            },
            messages:{
                moduleName:
                {
                    required:"父版块名称必须填写",
                    maxlength:"父版块名称必须在50个字符以内"
                },
                sort:
                {
                    required:"排名是必填的",
                    max:"排名值必须在0-10000以内",
                    min:"排名值必须在0-10000以内"
                }
            },
            highlight:function(element,errorClass,validClass)
            {
                $(element).css("border-clor","red");
                $(element).parent().find("."+errorClass).removeClass("ok");
            },
            success:function(label,element){
                label.addClass("ok");
                $(element).css("border-clor","#ccc");
                
                /*success:function(label,element){
                    label.addClass("ok");
                    $(element).css("border-color",'#ccc');*/
                    //这个在再次验证时不会自动去掉，需要手动去掉
                }
    });
   
    
    
    //验证子版块提交的的表单
    $("#newSonModule").validate({
        submitHandler:function(){
            alert("恭喜你验证成功");
            return true;
        },
        invalidHandler:function(event,validator){
            //alert('对不起，您有'+validator.numberOfInvalids()+'个验证项没有通过');
        },
        rules:{
            moduleName:
                {
                    required:true,
                    maxlength:50
                },
                memberId:
                {
                    //这个必须填，且是数字，因为这个Spring表单对象要求的，因为项目中没有自定转换器和格式化器
                    required:true,
                    max:10000,
                    min:0
                },
                sort:
                {
                    required:true,
                    max:10000,
                    min:0
                }
            },
            errorPlacement:function(error, element){
                //alert(1111);
                error.appendTo(element.parent());
            },
            messages:{
                moduleName:
                {
                    required:"子版块名称必须填写",
                    maxlength:"子版块名称必须在50个字符以内"
                },
                memberId:
                {
                    required:"会员Id是必填的",
                    max:"会员Id值必须在0-10000以内",
                    min:"会员Id值必须在0-10000以内"
                },
                sort:
                {
                    required:"排名是必填的",
                    max:"排名值必须在0-10000以内",
                    min:"排名值必须在0-10000以内"
                }
            },
            highlight:function(element,errorClass,validClass)
            {
                $(element).css("border-clor","red");
                $(element).parent().find("."+errorClass).removeClass("ok");
            },
            success:function(label,element){
                label.addClass("ok");
                $(element).css("border-clor","#ccc");
                
                }
    });
});

/**
 * 删除一个父板块 采用和cnblogs后台的删除一样的操作方法
 * 
 * @param moduleId
 *            父板块Id
 * @param title
 *            父板块名称
 */
function DeleteFatherModule(moduleId, title)
{
    // alert(moduleId + "" + title);
    if (!confirm("确认删除＂" + title + "＂吗?"))
    {
        return false;
    }
    // fatherModule_
    $("#fatherModule_" + moduleId).html(
            "<td colspan='3'><span style='color:red'>删除操作中...</span></td>");

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
                        $("#fatherModule_" + moduleId)
                                .html(
                                        "<td colspan='3'><span style='color:red'>删除成功!</span></td>");
                    }
                    else
                    {
                        $("#fatherModule_" + moduleId)
                                .html(
                                        "<td colspan='3'><span style='color:red'>删除失败!</span></td>");
                    }
                },
                error : function()
                {
                    $("#fatherModule_" + moduleId)
                            .html(
                                    "<td colspan='3'><span style='color:red'>Error!</span></td>");
                }
            });
}

