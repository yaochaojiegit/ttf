

layui.use(['laypage', 'layer'], function() {
    var laypage = layui.laypage
        , layer = layui.layer;
    var count=$("#count").val();
    laypage.render({
        elem: 'demo6'
        , count: count
        ,limit:8
        //, layout: ['prev', 'next']
        , jump: function (obj, first) {
            if (!first) {
                layer.msg('第 ' + obj.curr + ' 页');
                pageNum(obj.curr,8);
            }
        }
    });
});

//左菜单栏获取对应菜品种类的
function chosseType(species3) {
    $("#typeid").val(species3);
    pageNum();
}

//获取菜品
function pageNum(page,rows){
    var uri="AdminListGoodsServlet";
    if (!(page!=null&&rows!=null)){
        page=1;
        rows=8;
    }
    var species3=$("#typeid").val();
    $.post(uri,{page:page,rows:rows,species2:1,species3:species3},function (result) {
        $("#count").val(result.total);
        var  data=result.rows;
        var img="";
        for (var i=0;i<8;i++){
            if (i<data.length) {
                img = "#img" + i;
                $(img).attr("src", data[i].picture);
                img = "#id" + i;
                $(img).html(data[i].id);
                img = "#price" + i;
                $(img).html("$" + data[i].price);
                img = "#good" + i;
                $(img).html(data[i].name);
                img = "#intro" + i;
                $(img).html(data[i].intro);
            }else {
                img = "#img" + i;
                $(img).attr("src", "");
                img = "#price" + i;
                $(img).html("$0");
                img = "#good" + i;
                $(img).html("暂无商品");
                img = "#intro" + i;
                $(img).html("");
            }
        }
    });
}

$(function () {
   pageNum();
   getUser();
});
//获取当前用户
function getUser() {
    var uri="/userCheck";
    $.post(uri,{},function (result) {
        if (result == null||result=="") {
            var check = '<a onclick=\'checkLogin()\' onmouseenter =\'blurLogin()\' onmouseleave=\'moleave()\'><span id=\'lg\' style=\'color:#f56060\'>未登录点击登录</span></a>';
            $("#user").html(check);
        } else {
            var check = '<a  onmouseenter =\'moleave()\' onmouseleave=\'blurLogin()\'><span id=\'lg\' style=\'color:#44c28d\'>'+'欢迎,'+result.username+'</span></a>';
            $("#user").html(check);
        }
    });
}
//支付
function pay() {
    var uri='/order/pay';
    $.post(uri,{},function (result) {
        if (result==1){
            layer.msg('支付成功', {icon: 1});
            $('#cart .cart-item').remove();
            $('#cart .empty').fadeIn(500);
            $('#checkout').fadeOut(500);
        } else {
           layer.msg('支付失败', {icon: 1});
        }
    });
}
//检查登录
function checkLogin() {
    location.href="UserLogin.html";
}


//鼠标悬浮事件
function blurLogin() {
    $('#lg').css('color','#44c28d');
}
//鼠标离开事件
function moleave() {
    $('#lg').css('color','#f56060');
}

