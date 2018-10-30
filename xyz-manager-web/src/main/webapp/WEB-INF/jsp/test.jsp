<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1 , user-scalable=no">
<title>bootstrap项目实战</title>
<%@ include file="common/common_css.jsp"%>
<%@ include file="common/common_js.jsp"%>
<script type="text/javascript">
</script>
</head>
<body>
<!-- 导航栏 -->
<%@ include file="common/common_header.jsp"%>
<div class="container">
        <div class="row">
        <div class="page-header">
            <h1>Use error message that is returned from remote/callback validator</h1>
        </div>

        <div class="col-lg-8 col-lg-offset-2">
            <form id="defaultForm" method="post" class="form-horizontal" action="target.php">
                <div class="form-group">
                    <label class="col-lg-3 control-label">Username</label>
                    <div class="col-lg-5">
                        <input type="text" class="form-control" name="username" autocomplete="off" />
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-lg-3 control-label">Email address</label>
                    <div class="col-lg-5">
                        <input type="text" class="form-control" name="email" autocomplete="off" />
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-lg-3 control-label">Password</label>
                    <div class="col-lg-5">
                        <input type="password" class="form-control" name="password" />
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-lg-9 col-lg-offset-3">
                        <button type="submit" class="btn btn-primary">Submit</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>

<script type="text/javascript">
/* $(document).ready(function() {
	
}); */
//yanzheng();

$(function () {
	yanzheng();
});
function yanzheng(){
	$('#defaultForm').bootstrapValidator({
        message: 'This value is not valid',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            username: {
                message: 'The username is not valid',
                validators: {
                    notEmpty: {
                        message: 'The username is required and can\'t be empty'
                    },
                    remote: {
                        url: 'remote2.php'
                    },
                    different: {
                        field: 'password',
                        message: 'The username and password can\'t be the same as each other'
                    }
                }
            },
            email: {
                validators: {
                    notEmpty: {
                        message: 'The email address is required and can\'t be empty'
                    },
                    emailAddress: {
                        message: 'The input is not a valid email address'
                    },
                    remote: {
                        url: 'remote2.php'
                    }
                }
            },
            password: {
                validators: {
                    notEmpty: {
                        message: 'The password is required and can\'t be empty'
                    },
                    different: {
                        field: 'username',
                        message: 'The password can\'t be the same as username'
                    },
                    callback: {
                        callback: function(value, validator) {
                            // Check the password strength
                            if (value.length < 6) {
                                return {
                                    valid: false,
                                    message: 'The password must be more than 6 characters'
                                }
                            }

                            if (value === value.toLowerCase()) {
                                return {
                                    valid: false,
                                    message: 'The password must contain at least one upper case character'
                                }
                            }
                            if (value === value.toUpperCase()) {
                                return {
                                    valid: false,
                                    message: 'The password must contain at least one lower case character'
                                }
                            }
                            if (value.search(/[0-9]/) < 0) {
                                return {
                                    valid: false,
                                    message: 'The password must contain at least one digit'
                                }
                            }

                            return true;
                        }
                    }
                }
            }
        }
    });
}
</script>
</form>

<%@ include file="common/common_footer.jsp"%>
</body>
</html>