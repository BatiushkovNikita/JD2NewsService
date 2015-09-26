<%@ page isErrorPage="true" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>404</title>
    <%@ include file="../pages/include.jsp"%>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <div class="error-template">
                <h1>
                    Oops!</h1>

                <h2>
                    404 Not Found</h2>

                <div class="error-details">
                    Sorry, an error has occured, Requested page not found!
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
