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
        <div class="col-md-2">
            <div class="list-group">
                <a href="user_list" class="list-group-item active">用户管理</a>
                <a href="user_search" class="list-group-item">用户搜索</a>
                <a href="" role="button"  class="list-group-item" data-toggle="modal" data-target="#myModal">添加用户</a>
            </div>
        </div>
        <div class="col-md-10">
            <div class="page-header">
                <h1>用户管理</h1>
            </div>
            <ul class="nav nav-tabs">
                <li class="active">
                    <a href="user_list">用户列表</a>
                </li>
                <li>
                    <a href="user_search">用户搜索</a>
                </li>
                <li>
                    <a href="" role="button" data-toggle="modal" data-target="#myModal">添加用户</a>
                </li>
            </ul>
            <table class="table">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>用户名</th>
                        <th>邮箱</th>
                        <th>操作</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <th scope="row">1</th>
                        <td>张三</td>
                        <td>123456789@maiziedu.com</td>
                        <td>
                            <div role="presentation" class="dropdown">
                                <button class="btn btn-default dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
                                    操作<span class="caret"></span>
                                </button>
                                <ul class="dropdown-menu">
                                   <li><a href="#">编辑</a></li>
                                   <li><a href="#">删除</a></li>
                                   <li><a href="#">锁定</a></li>
                                   <li><a href="#">修改密码</a></li>
                                </ul>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <th scope="row">2</th>
                        <td>李四</td>
                        <td>121265489@maiziedu.com</td>
                        <td>
                            <div role="presentation" class="dropdown">
                                <button class="btn btn-default dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
                                    操作<span class="caret"></span>
                                </button>
                                <ul class="dropdown-menu">
                                    <li><a href="#">编辑</a></li>
                                    <li><a href="#">删除</a></li>
                                    <li><a href="#">锁定</a></li>
                                    <li><a href="#">修改密码</a></li>
                                </ul>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <th scope="row">2</th>
                        <td>李四</td>
                        <td>121265489@maiziedu.com</td>
                        <td>
                            <div role="presentation" class="dropdown">
                                <button class="btn btn-default dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
                                    操作<span class="caret"></span>
                                </button>
                                <ul class="dropdown-menu">
                                    <li><a href="#">编辑</a></li>
                                    <li><a href="#">删除</a></li>
                                    <li><a href="#">锁定</a></li>
                                    <li><a href="#">修改密码</a></li>
                                </ul>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <th scope="row">2</th>
                        <td>李四</td>
                        <td>121265489@maiziedu.com</td>
                        <td>
                            <div role="presentation" class="dropdown">
                                <button class="btn btn-default dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
                                    操作<span class="caret"></span>
                                </button>
                                <ul class="dropdown-menu">
                                    <li><a href="#">编辑</a></li>
                                    <li><a href="#">删除</a></li>
                                    <li><a href="#">锁定</a></li>
                                    <li><a href="#">修改密码</a></li>
                                </ul>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <th scope="row">2</th>
                        <td>李四</td>
                        <td>121265489@maiziedu.com</td>
                        <td>
                            <div role="presentation" class="dropdown">
                                <button class="btn btn-default dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
                                    操作<span class="caret"></span>
                                </button>
                                <ul class="dropdown-menu">
                                    <li><a href="#">编辑</a></li>
                                    <li><a href="#">删除</a></li>
                                    <li><a href="#">锁定</a></li>
                                    <li><a href="#">修改密码</a></li>
                                </ul>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <th scope="row">2</th>
                        <td>李四</td>
                        <td>121265489@maiziedu.com</td>
                        <td>
                            <div role="presentation" class="dropdown">
                                <button class="btn btn-default dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
                                    操作<span class="caret"></span>
                                </button>
                                <ul class="dropdown-menu">
                                    <li><a href="#">编辑</a></li>
                                    <li><a href="#">删除</a></li>
                                    <li><a href="#">锁定</a></li>
                                    <li><a href="#">修改密码</a></li>
                                </ul>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <th scope="row">2</th>
                        <td>李四</td>
                        <td>121265489@maiziedu.com</td>
                        <td>
                            <div role="presentation" class="dropdown">
                                <button class="btn btn-default dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
                                    操作<span class="caret"></span>
                                </button>
                                <ul class="dropdown-menu">
                                    <li><a href="#">编辑</a></li>
                                    <li><a href="#">删除</a></li>
                                    <li><a href="#">锁定</a></li>
                                    <li><a href="#">修改密码</a></li>
                                </ul>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <th scope="row">2</th>
                        <td>李四</td>
                        <td>121265489@maiziedu.com</td>
                        <td>
                            <div role="presentation" class="dropdown">
                                <button class="btn btn-default dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
                                    操作<span class="caret"></span>
                                </button>
                                <ul class="dropdown-menu">
                                    <li><a href="#">编辑</a></li>
                                    <li><a href="#">删除</a></li>
                                    <li><a href="#">锁定</a></li>
                                    <li><a href="#">修改密码</a></li>
                                </ul>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <th scope="row">2</th>
                        <td>李四</td>
                        <td>121265489@maiziedu.com</td>
                        <td>
                            <div role="presentation" class="dropdown">
                                <button class="btn btn-default dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
                                    操作<span class="caret"></span>
                                </button>
                                <ul class="dropdown-menu">
                                    <li><a href="#">编辑</a></li>
                                    <li><a href="#">删除</a></li>
                                    <li><a href="#">锁定</a></li>
                                    <li><a href="#">修改密码</a></li>
                                </ul>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <th scope="row">2</th>
                        <td>李四</td>
                        <td>121265489@maiziedu.com</td>
                        <td>
                            <div role="presentation" class="dropdown">
                                <button class="btn btn-default dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
                                    操作<span class="caret"></span>
                                </button>
                                <ul class="dropdown-menu">
                                    <li><a href="#">编辑</a></li>
                                    <li><a href="#">删除</a></li>
                                    <li><a href="#">锁定</a></li>
                                    <li><a href="#">修改密码</a></li>
                                </ul>
                            </div>
                        </td>
                    </tr>
                </tbody>
            </table>
            <nav class="pull-right">
                <ul class="pagination">
                    <li class="disabled"><a href="#" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>
                    <li class="active"><a href="#">1</a></li>
                    <li><a href="#">2 </a></li>
                    <li><a href="#">3 </a></li>
                    <li><a href="#">4 </a></li>
                    <li><a href="#">5 </a></li>
                    <li><a href="#">6 </a></li>
                    <li><a href="#"><span aria-hidden="true">&raquo;</span></a></li>
                </ul>
            </nav>
        </div>
    </div>
</div>

<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">添加用户</h4>
            </div>
            <div class="modal-body">
                <form action="#">
                    <div class="form-group">
                        <label for="addname">用户名</label>
                        <input type="text" id="addname" class="form-control" placeholder="用户名">
                    </div>
                    <div class="form-group">
                        <label for="addpassword">用户密码</label>
                        <input type="text" id="addpassword" class="form-control" placeholder="请输入用户密码">
                    </div>
                    <div class="form-group">
                        <label for="addpassword1">确认用户密码</label>
                        <input type="text" id="addpassword1" class="form-control" placeholder="请确认输入用户密码">
                    </div>
                    <div class="form-group">
                        <label for="addemail">请输入用户邮箱</label>
                        <input type="email" id="addemail" class="form-control" placeholder="请输入用户邮箱">
                    </div>
                    <div class="form-group">
                        <label for="addyonghuzu">所属用户组</label>
                        <select id="addyonghuzu" class="form-control">
                            <option>限制会员</option>
                            <option>新手上路</option>
                            <option>组册会员</option>
                            <option>中级会员</option>
                            <option>高级会员</option>
                        </select>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary">提交</button>
            </div>
        </div>
    </div>
</div>

<%@ include file="../common/common_footer.jsp"%>
</body>
</html>