<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="tag.jsp" %>
<c:set var="title" scope="request" value="Home"/>
<jsp:include flush="true" page="base.jsp"/>

<div class="container">
    <h1>La central-ish</h1>

    <h2><a class="link-if" href="${UrlRoute.URL_LISTING_FORM}">Publier une annonce</a></h2>

    <h2 class="my-5">Les derniers listings</h2>
    <div class="row">
        <c:forEach items="${listings}" var="listing">
            <a class="col-4 mt-2 link-if main-listing-card" href="${UrlRoute.URL_LISTING}/${listing.slug}">
                <div class="listing-card">
                    <div class="listing-card-img">
                        <img alt="${listing.title}" src="${listing.image}">
                    </div>
                    <div class="d-flex justify-content-between">
                        <p>${listing.model.name} ${listing.model.brand.name}</p>
                        <p>${listing.price/100}€</p>
                    </div>
                </div>
            </a>
        </c:forEach>
    </div>
</div>

<%@ include file="footer.jsp" %>
