/**
 * Created by wangfei on 2015/5/22.
 */
$(function(){
    var properties = new Properties(1, "");
    /* 初始化查询 */
    cpsChannel.list(properties);

    /* 搜索 */
    $("#searchBtn").bind({
        click : function(){
            if($.trim($("#keyword").val()) == ""){
                common.showTips("请输入搜索内容");
                return false;
            }
            properties.currentPage = 1;
            properties.keyword = $("#keyword").val();
            cpsChannel.list(properties);
        }
    });

    /* 更新按钮 */
    $("#update_button").bind({
        click : function(){
            if(!validation.vaild($("#channelForm"))){
                return false;
            }
            cpsChannel.update(properties);
        }
    });

    /* 取消按钮 */
    $("#cancel_button").bind({
        click : function(){
            $("#channelForm")[0].reset();
            showContent();
        }
    });

    /* 删除按钮 */
    $("#delete_button").bind({
        click : function(){
            common.showPublicTips("删除后不可撤销，确认删除？");
        }
    });

    /* 删除确认 */
    var reConfirm = window.parent.$("#theme_popover_publicConfirm");
    reConfirm.find(".confirm").unbind("click").bind({
        click : function(){
            cpsChannel.delete($("#id").val(), properties);
        }
    });
    reConfirm.find(".cancel").unbind("click").bind({
        click : function(){
            common.hideMask();
        }
    });

});

function showContent(){
    $("#top_div").show();
    $("#count_div").show();
    $("#show_div").show();
    $("#edit_div").hide();
}

function showEdit(){
    $("#top_div").hide();
    $("#count_div").hide();
    $("#show_div").hide();
    $("#edit_div").show();
}
