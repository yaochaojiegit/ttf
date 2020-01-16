

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
               var star="";
                var st="<i class=\"layui-icon\" style=\"font-size: 30px; color: #FCE808;\">&#xe658;</i> ";
                img="#star"+i;
                for (var h=0;h<data[i].star;h++){
                    star+=st;
                }
                $(img).html(star);
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
            var check = '<a onclick=\'loginOut()\' onmouseenter =\'moleave()\' onmouseleave=\'blurLogin()\'><span id=\'lg\' style=\'color:#44c28d;font-size: 20px\'>'+'欢迎,'+result.username+'</span></a><br/>';
            if (result.role==1){
                check+="<i class=\"layui-icon\">&#xe735;</i><span>钻石会员</span> ";
            }else {
                check+="<i class=\"layui-icon\">&#xe613;</i><span>大众会员</span> ";
            }
            $("#user").html(check);
        }
    });
}

//退出登录
function loginOut() {
    layer.confirm('确定退出当前账号？', {
        btn: ['确定','取消'] //按钮
    }, function(){
        var uri="/loginOut";
        console.log(1);
        $.post(uri,function (result) {
            if (result.code==1){
                layer.msg("退出成功",{icon:1});
                location.href="UserLogin.html";
            } else {
                layer.msg("退出失败,请重新尝试",{icon:5});
            }
        });

    });
}

//支付
function pay() {
    var uri='/order/pay';
    $.post(uri,{},function (result) {
        if (result==1){
            layer.alert('支付成功', {icon: 1});
            $('#cart .cart-item').remove();
            $('#cart .empty').fadeIn(500);
            $('#checkout').fadeOut(500);
        } else {
           layer.alert('支付失败', {icon: 5});
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
function geRenOn() {
    $("#grid").empty();
    $("#demo6").remove();
    var uri="/userCheck";
    $.post(uri,{},function (result) {
        if (result == null||result=="") {
            layer.alert("登录超时,请重新登录",function () {
                location.href="UserLogin.html";
            });
        }else {
            var role="";
            if (result.role==1){
                role="钻石会员";
            } else {
                role="大众会员";
            }
            var person="<button class=\"layui-btn layui-btn-normal\">我的个人信息</button>";
            person+="<form class=\"layui-form\" action=\"\">\n" +
                "  <div class=\"layui-form-item\" >\n" +
                "    <label class=\"layui-form-label\" style=\"background-color: #f2f2f2\">用户ID</label>\n" +
                "    <div class=\"layui-input-inline\">\n" +
                "      <input type=\"text\" name=\"id\" readonly lay-verify=\"required\" placeholder=\"用户ID\" autocomplete=\"off\" class=\"layui-input\" value="+result.id+">\n" +
                "    </div>\n" +
                "  </div>\n" +
                "  <div class=\"layui-form-item\" >\n" +
                "    <label class=\"layui-form-label\" style=\"background-color: #eeeeee\">用户名称</label>\n" +
                "    <div class=\"layui-input-inline\">\n" +
                "      <input type=\"text\" name=\"username\" readonly lay-verify=\"required\" placeholder=\"用户名称\" autocomplete=\"off\" class=\"layui-input\" value="+result.username+">\n" +
                "    </div>\n" +
                "  </div>\n" +
                "  <div class=\"layui-form-item\" >\n" +
                "    <label class=\"layui-form-label\" style=\"background-color: #e2e2e2\">用户邮箱</label>\n" +
                "    <div class=\"layui-input-inline\">\n" +
                "      <input type=\"text\" name=\"email\" readonly lay-verify=\"required\" placeholder=\"用户邮箱\" autocomplete=\"off\" class=\"layui-input\" value="+result.email+">\n" +
                "    </div>\n" +
                "  </div>\n" +
                "  <div class=\"layui-form-item\" >\n" +
                "    <label class=\"layui-form-label\" style=\"background-color: #dddddd\">用户性别</label>\n" +
                "    <div class=\"layui-input-inline\">\n" +
                "      <input type=\"text\" name=\"gender\" readonly lay-verify=\"required\" placeholder=\"用户性别\" autocomplete=\"off\" class=\"layui-input\" value="+result.gender+">\n" +
                "    </div>\n" +
                "  </div>\n" +
                "  <div class=\"layui-form-item\" >\n" +
                "    <label class=\"layui-form-label\" style=\"background-color: #d2d2d2\">用户等级</label>\n" +
                "    <div class=\"layui-input-inline\">\n" +
                "      <input type=\"text\" name=\"role\" readonly lay-verify=\"required\" placeholder=\"用户等级\" autocomplete=\"off\" class=\"layui-input\" value="+role+">\n" +
                "    </div>\n" +
                "  </div>\n" +
                "  </div>\n" +
                "  <div class=\"layui-form-item\" >\n" +
                "    <label class=\"layui-form-label\" style=\"background-color: #d2d2d2\">账户余额(元)</label>\n" +
                "    <div class=\"layui-input-inline\">\n" +
                "      <input type=\"text\" name=\"balance\" readonly lay-verify=\"required\" placeholder=\"账户余额\" autocomplete=\"off\" class=\"layui-input\" value="+result.balance+">\n" +
                "    </div>\n" +
                "  </div>\n" +
                "</form>";
        }
        $("#grid").append(person);
    });


}
function geRenLeft() {

}

function orderList() {
    $("#grid").empty();
    $("#demo6").remove();
    var uri="/order/getUserOrderList";
    
    $.post(uri,{},function (result) {
        layer.load();
        var data=result.rows;

        var or="";
        or+="<button class=\"layui-btn layui-btn-warm\">消费记录<span class=\"layui-badge layui-bg-gray\">"+data.length+"</span></button>";
         or+="<ul class=\"layui-timeline\">";
        $.each(data,function (index,item) {
            var money=item.money;
            or+="<li class=\"layui-timeline-item\">\n" +
                "    <i class=\"layui-icon layui-timeline-axis\">&#xe63f;</i>\n" +
                "    <div class=\"layui-timeline-content layui-text\">\n" +
                "      <h3 class=\"layui-timeline-title\">"+item.date+"</h3>\n" +
                "      <p><em>订单编号:</em>&nbsp;&nbsp;"+item.id+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<em>订单金额: </em>"+money+"元&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<button class=\"layui-btn layui-btn-sm layui-btn-radius layui-btn-primary\" onclick=\"checkDetail("+item.id+")\">查看订单详情</button></p>\n" +
                "      <div id=\"detail"+item.id+"\">\n" +
                "      </div>\n" +
                "    </div>\n" +
                "  </li>"
        });
        or+="</ul>";
        $("#grid").append(or);
        layer.closeAll();
    });

}
var  clickNum=0;
function checkDetail(check) {
    var de = "#detail" + check;
    if (clickNum == 1) {
        $(de).empty();
        clickNum = 0;
    } else {
        clickNum = 1;
        
    var uri = "/orderDetail/getOrderDetailByID";
    $.post(uri, {orderId: check}, function (result) {
        var data = result.rows;

        if (data == null && data.length == 0) {
            $(de).html("订单查询失败");
        } else {

            var id = data[0].oid;
            var time = (data[0].time).substring(0, data[0].time.length - 2);
            var moneyAll = 0;
            var status = "";
            var da = "";
            $.each(data, function (index, item) {
                da += "<tr>\n" +
                    "                <td>" + item.gName + "</td>\n" +
                    "                <td>" + item.num + "</td>\n" +
                    "                <td>" + item.money + "元</td>\n" +
                    "            </tr>";
                moneyAll += item.money;
            });
            if (data[0].status == 0) {
                status = "等待中";
            }
            else {
                status = "已处理";
            }
            var detail = "<div><span>订单编号:" + id + "</span><br>\n" +
                "   <span>订单时间:" + time + "</span>\n" +
                "   </div>\n" +
                "    <hr style=\"height:1px;border:none;border-top:1px solid #555555;\" />\n" +
                "    <div>\n" +
                "        <table style=\"border: #52d689;width: 300px\" >\n" +
                "            <tr>\n" +
                "                <td>商品名称</td>\n" +
                "                <td>商品数量</td>\n" +
                "                <td>商品金额</td>\n" +
                "            </tr>\n" + da +
                "        </table>\n" +
                "    </div>\n" +
                "    <hr style=\"height:1px;border:none;border-top:1px solid #555555;\" />\n" +
                "    <div>\n" +
                "        <span>总金额:" + moneyAll + "元</span><br>\n" +
                "        <span>付款状态:" + status + "</span>\n" +
                "    </div>";
            $(de).append(detail);
        }
    });
}
}
function qr() {
    layer.open({
        type: 1,
        title:false,
        skin: 'layui-layer-demo', //样式类名
        closeBtn: 0, //不显示关闭按钮
        area: ['204px', '225px'],
        anim: 2,
        shadeClose: true, //开启遮罩关闭
        content: '<div style="text-align: center"> <p style="color: red">扫描下方二维码,更多惊喜在等你</p><div id="qrcode" style="margin: auto"></div></div>'
    });
createQrCode();
}
//创建二维码
function createQrCode() {
    var result=location.href;
    var qrcode = new QRCode('qrcode', {
        text: 'your qrcode',
        width: 200,
        height: 200,
        colorDark : '#000000',
        colorLight : '#ffffff',
        correctLevel : QRCode.CorrectLevel.H
    });
    // 使用 API
    qrcode.clear();
    qrcode.makeCode(result);
}