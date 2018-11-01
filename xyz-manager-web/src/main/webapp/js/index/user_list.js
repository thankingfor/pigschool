$(function () {
	
})

function searchUser(){
	alert("还未实现");
}

/**
 * 向他吐口水
 * @param id
 * @returns
 */
function truckHim(id){
	alert("还未实现");
}

/**
 * 查看用户详情
 * @returns
 */
function showDetail(id){
	alert("还未实现");
}

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
	window.location.href = "user_list?page="+page+"&rows="+rows;
}