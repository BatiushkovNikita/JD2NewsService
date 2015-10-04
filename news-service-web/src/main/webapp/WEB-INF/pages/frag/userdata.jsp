<div class="form-group">
    <form:label class="control-label col-sm-2" path="email">
        <spring:message code="frag.userdata.email"/></form:label>
    <div class="col-sm-10">
        <span class="text-danger"><form:errors path="email"/></span>
        <spring:message code="frag.userdata.email.placeholder" var="placeholder"/>
        <form:input placeholder="${placeholder}" type="email" cssClass="form-control" id="email" path="email"/>
    </div>
</div>

<div class="form-group">
    <form:label class="control-label col-sm-2" path="password">
        <spring:message code="frag.userdata.password"/></form:label>
    <div class="col-sm-10">
        <span class="text-danger"><form:errors path="password"/></span>
        <spring:message code="frag.userdata.password.placeholder" var="placeholder"/>
        <form:input placeholder="${placeholder}" type="password" cssClass="form-control" id="password" path="password"/>
    </div>
</div>

<div class="form-group">
    <form:label class="control-label col-sm-2" path="firstName">
        <spring:message code="frag.userdata.firstName"/></form:label>
    <div class="col-sm-10">
        <span class="text-danger"><form:errors path="firstName"/></span>
        <spring:message code="frag.userdata.firstName.placeholder" var="placeholder"/>
        <form:input placeholder="${placeholder}" type="text" cssClass="form-control" id="firstName" path="firstName"/>
    </div>
</div>

<div class="form-group">
    <form:label class="control-label col-sm-2" path="lastName">
        <spring:message code="frag.userdata.lastName"/></form:label>
    <div class="col-sm-10">
        <span class="text-danger"><form:errors path="lastName"/></span>
        <spring:message code="frag.userdata.lastName.placeholder" var="placeholder"/>
        <form:input placeholder="${placeholder}" type="text" cssClass="form-control" id="lastName" path="lastName"/>
    </div>
</div>

<div class="form-group">
    <form:label class="control-label col-sm-2" path="cellPhone">
        <spring:message code="frag.userdata.cellPhone"/></form:label>
    <div class="col-sm-10">
        <span class="text-danger"><form:errors path="cellPhone"/></span>
        <spring:message code="frag.userdata.cellPhone.placeholder" var="placeholder"/>
        <form:input placeholder="${placeholder}" type="text" cssClass="form-control" id="cellPhone" path="cellPhone"/>
    </div>
</div>