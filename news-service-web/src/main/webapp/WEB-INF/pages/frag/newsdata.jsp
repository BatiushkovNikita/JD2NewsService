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
        <%--<c:forEach items="${tags}" var="t">
            <div class="checkbox">
                <label><input type="checkbox" value="${t.tagName}">${t.tagName}</label>
            </div>
        </c:forEach>--%>

        <p>Tag mapping</p>
        <%--<c:forEach items="${newsVOParam.tagsVO}" var="tagsVO" varStatus="status">
            <tr>
                <td>
                    <form:input type="text" path="tagsVO[${status.index}].tagName" value="${tagsVO.tagName}" />
                </td>
            </tr>
        </c:forEach>--%>
            <form:checkboxes items="${tagsVOParam}" path="tagsVO" itemLabel="tagName" itemValue="id"/>
    </div>

</div>
