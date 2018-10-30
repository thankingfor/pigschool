<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1 , user-scalable=no">
<title>bootstrap项目实战</title>
<%@ include file="../common/common_css.jsp"%>
<%@ include file="../common/common_js.jsp"%>
</head>
<body>
<!-- 导航栏 -->
<%@ include file="../common/common_header.jsp"%>

<div class="container">
    <div class="row">
        <div class="col-md-12">
            <div class="page-header">
                <h1>TAG标签管理</h1>
            </div>
            <div class="col-md-12 pad0">
                <form>
                    <div class="col-md-10">
                        <input class="form-control" placeholder="请输入要添加的标签">
                    </div>
                    <div class="col-md-2">
                        <button type="submit" class="btn btn-default">添加</button>
                    </div>
                </form>
            </div>
            <div class="col-md-12 taglist">
                <div class="alert alert-info alert-dismissible pull-left" role="alert">
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <strong>bootstrap</strong>
                </div>
                <div class="alert alert-info alert-dismissible  pull-left" role="alert">
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <strong>麦子学院</strong>
                </div>
                <div class="alert alert-info alert-dismissible  pull-left" role="alert">
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <strong>前端课程</strong>
                </div>
            </div>
        </div>
    </div>
</div>

<%@ include file="../common/common_footer.jsp"%>
</body>
</html>