<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../tag.jsp" %>
<c:set var="title" scope="request" value="New Listing"/>
<jsp:include flush="true" page="../base.jsp"/>

<div class="container">

    <h1>Publier une annonce</h1>
    <f:form modelAttribute="listing" method="post" action="${action}" cssClass="p-5">
        <div class="mb-3 row">
            <f:label path="title" class="col-sm-2 col-form-label">Title</f:label>
            <div class="col-sm-10">
                <f:input type="text" cssClass="form-control" path="title"/>
                <f:errors path="title" cssClass="invalid-feedback"/>
            </div>
        </div>

        <div class="mb-3 row">
            <span class="col-sm-2 col-form-label">Modèle : </span>
            <div class="col-sm-10">
                <f:select path="modelId"
                          items="${models}"
                          cssClass="form-select"
                          itemLabel="name"
                          itemValue="id"
                >
                </f:select>
            </div>
        </div>

        <div class="mb-3 row">
            <f:label path="mileage" class="col-sm-2 col-form-label">Kilométrage:</f:label>
            <div class="col-sm-10">
                <f:input type="text" cssClass="form-control" path="mileage"/>
                <f:errors path="mileage" cssClass="invalid-feedback"/>
            </div>
        </div>

        <div class="mb-3 row">
            <f:label path="producedYear" class="col-sm-2 col-form-label">Année de fabrication:</f:label>
            <div class="col-sm-10">
                <f:input type="text" cssClass="form-control" path="producedYear"/>
                <f:errors path="producedYear" cssClass="invalid-feedback"/>
            </div>
        </div>

        <div class="mb-3 row">
            <f:label path="price" class="col-sm-2 col-form-label">Prix:</f:label>
            <div class="col-sm-10">
                <f:input type="text" cssClass="form-control" path="price"/>
                <f:errors path="price" cssClass="invalid-feedback"/>
            </div>
        </div>

        <div class="mb-3 row">
            <f:label path="description" class="col-sm-2 col-form-label">Description:</f:label>
            <div class="col-sm-10">
                <f:textarea type="text" cssClass="form-control" path="description"/>
                <f:errors path="description" cssClass="invalid-feedback"/>
            </div>
        </div>

        <f:input type="number" path="userId" hidden="hidden"/>

        <f:button class="btn btn-secondary" type="reset">Reset</f:button>
        <f:button class="btn btn-primary">Submit</f:button>
    </f:form>
</div>

<%@ include file="../footer.jsp" %>
