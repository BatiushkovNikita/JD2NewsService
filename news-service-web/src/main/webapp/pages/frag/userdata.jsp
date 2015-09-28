<div class="form-group">
    <form:label class="control-label col-sm-2" path="email">
        <spring:message code="frag.userdata.email"/></form:label>
    <div class="controls">
        <form:errors path="email" cssClass="label label-important" />
        <div class="col-sm-10">
            <form:input placeholder="dklskdlskdls" type="email" cssClass="form-control" id="email" path="email"/>
        </div>
    </div>
</div>

<div class="form-group">
    <form:label class="control-label col-sm-2" path="password">
        <fmt:message key="frag.userdata.password"/></form:label>
    <div class="col-sm-10">
        <form:input type="password" cssClass="form-control" id="firstName" path="password"/>
    </div>
</div>

<div class="form-group">
    <form:label class="control-label col-sm-2" path="firstName">
        <fmt:message key="frag.userdata.first.name"/></form:label>
    <div class="col-sm-10">
        <form:input type="text" cssClass="form-control" id="firstName" path="firstName"/>
    </div>
</div>

<div class="form-group">
    <form:label class="control-label col-sm-2" path="lastName">
        <fmt:message key="frag.userdata.last.name"/></form:label>
    <div class="col-sm-10">
        <form:input type="text" cssClass="form-control" id="firstName" path="lastName"/>
    </div>
</div>

<div class="form-group">
    <form:label class="control-label col-sm-2" path="cellPhone">
        <fmt:message key="frag.userdata.cellphone"/></form:label>
    <div class="col-sm-10">
        <form:input type="tel" cssClass="form-control" id="firstName" path="cellPhone"/>
    </div>
</div>