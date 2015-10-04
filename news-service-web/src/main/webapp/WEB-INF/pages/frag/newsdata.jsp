<div class="container">
    <div class="form-group">
        <form:label path="topic">
            <spring:message code="frag.newsdata.topic"/>
        </form:label>
        <span class="text-danger"><form:errors path="topic"/></span>
        <form:input  path="topic" cssClass="form-control" />
    </div>
    <div class="form-group">
        <form:label  path="newsText">
            <spring:message code="frag.newsdata.newsText"/>
        </form:label>
        <span class="text-danger"><form:errors path="newsText"/></span>
        <form:textarea path="newsText" cssClass="form-control" rows="5" />
    </div>
</div>
