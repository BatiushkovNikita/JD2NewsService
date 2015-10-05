<div class="container">

    <div class="form-group">
        <form:label path="topic">
            <spring:message code="frag.newsdata.topic"/>
        </form:label>
        <span class="text-danger"><form:errors path="topic"/></span>
        <spring:message code="frag.newsdata.topic.placeholder" var="placeholder"/>
        <form:input placeholder="${placeholder}" path="topic" cssClass="form-control"/>
    </div>

    <div class="form-group">
        <form:label path="newsText">
            <spring:message code="frag.newsdata.newsText"/>
        </form:label>
        <span class="text-danger"><form:errors path="newsText"/></span>
        <spring:message code="frag.newsdata.newsText.placeholder" var="placeholder"/>
        <form:textarea placeholder="${placeholder}" path="newsText" cssClass="form-control" rows="5"/>
    </div>

    <div>
        <c:forEach items="${tags}" var="t">
            <div class="checkbox">
                <label><input type="checkbox" value="">${t.tagName}</label>
            </div>
        </c:forEach>
    </div>

</div>
