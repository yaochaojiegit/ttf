moment.locale("zh-cn");

	$(function(){
		$("#menu .easyui-tree").tree({
			onClick:function(node){
				console.log(node);
				$("#tt").tabs("close",1);//
				$("#tt").tabs("add",{
					title:node.text,
					index:1,//在第几个索引打开  从零开始
					closable:true,//是否可以关闭
					href:node.attributes.href
				});
			}
		});
		
	});
	function addTab(text, href){
		$('#tt').tabs('close',1);
		$('#tt').tabs('add',{
			title: text,
			index: 1,
			closable:true,
			href: href
		});
	}