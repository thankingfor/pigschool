$(function () {
	
})

/**
 * 上一页
 * @returns
 */
function turnToUp(page){
	if(page >1){
		turnTo(page - 1);
	}else{
		turnTo(1);
	}
}

/**
 * 下一页
 * @returns
 */
function turnToDown(page,totalPage){
	if(page < totalPage){
		turnTo(page + 1);
	}else{
		turnTo(totalPage);
	}
}
/**
 * 跳转某一页数
 * @param page
 * @returns
 */
function turnTo(page) {
	var rows = 8;
	window.location.href = "content?page="+page+"&rows="+rows;
}

/**
 * 置顶
 * @returns
 */
function upTop() {
	$.ajax({
        type:"post",
        dataType:"json",
        url:"/manager/content/upTop",
        async:false,//异步  true 同步
        data:{text:text},
        success:function(result){  
        	window.location.href = "content";
        },error:function(){
        	alert("置顶失败");
        	window.location.href = "content";
        }
    })
}
/**
 * 取消置顶
 * @returns
 */
function outTop(id) {
	$.ajax({
        type:"post",
        dataType:"json",
        url:"/manager/content/outTop",
        async:false,//异步  true 同步
        data:{id:id},
        success:function(result){  
        	window.location.href = "content";
        },error:function(){
        	alert("置顶失败");
        	window.location.href = "content";
        }
    })
}