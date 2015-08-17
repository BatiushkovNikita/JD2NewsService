<%@ page isErrorPage="true" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>500</title>
    <%@ include file="include.jsp"%>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <div class="error-template">
                <h1>
                    Oops!</h1>

                <h2>
                    500 Not yet implemented...</h2>

                <div class="error-details">
                    Sorry... It's not you. It's us.
                </div>
                <div class="error-actions">
                    <a href="Controller?command=news_feed" class="btn btn-primary btn-lg"><span
                            class="glyphicon glyphicon-home"></span>
                        Back to news</a>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
