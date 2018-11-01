<!-- 此标签解决乱码问题 -->
<%@page pageEncoding="UTF-8"%>
<!-- jquery -->
<script src="${pageContext.request.contextPath}/js/plug/jquery.min.js"></script>
<!-- bootstrap -->
<script src="${pageContext.request.contextPath}/js/plug/bootstrap.min.js"></script>
<!-- tree插件 -->
<script src="${pageContext.request.contextPath}/js/plug/bootstrap-treeview.js" ></script>
<!-- 消息框插件 -->
<script src="${pageContext.request.contextPath}/js/plug/toastr.min.js" ></script>
<!-- 富文本编辑器 -->
<script src="${pageContext.request.contextPath}/js/plug/wangEditor.min.js"></script>
<!-- 图样报表插件 -->
<script src="${pageContext.request.contextPath}/js/plug/Chart.js"></script>
<!-- 模态框 对话框插件 -->
<script src="${pageContext.request.contextPath}/js/plug/bootstrap-dialog.min.js" ></script>
<!-- 图片上传插件 -->
<script src="${pageContext.request.contextPath}/js/plug/fileinput.min.js" ></script>
<!-- 图片上传插件 中文 -->
<script src="${pageContext.request.contextPath}/js/plug/fileinput_zh.js" ></script>
<!-- 表格的插件 -->
<script src="${pageContext.request.contextPath}/js/plug/bootstrap-table.min.js" ></script>
<script src="${pageContext.request.contextPath}/js/plug/bootstrap-table-zh-CN.min.js" ></script>
<!-- 表单验证插件 -->
<script src="${pageContext.request.contextPath}/js/plug/bootstrapValidator.min.js" ></script>
<script src="${pageContext.request.contextPath}/js/plug/bootstrapValidator_zh_CN.js" ></script>
<!-- 头js -->
<script src="${pageContext.request.contextPath}/js/common/common_header.js" ></script>
<script type="text/javascript">
	/* 一下为全局变量 */
	//富文本编辑器
	var E = window.wangEditor;
	var editor = new E('#editor');
	//消息件的配置
    toastr.options = {
        closeButton: false,  
        debug: false,  
        progressBar: true,  
        positionClass: "toast-top-center",  
        onclick: null,  
        showDuration: "300",  
        hideDuration: "1000",  
        timeOut: "1000",  
        extendedTimeOut: "1000",  
        showEasing: "swing",  
        hideEasing: "linear",  
        showMethod: "fadeIn",  
        hideMethod: "fadeOut"  
   };
</script>