<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../tag.jsp" %>
<c:set var="title" scope="request" value="Show Listing"/>
<jsp:include flush="true" page="../base.jsp"/>

<div class="container">
    <div class="row">
        <img class="col-4 p-3 image-fluid" alt="${listing.title}" src="${listing.image}">
        <div class="col-8">
            <h1>${listing.title}</h1>
            <h3 class="mt-4">Modèle: ${listing.model.name}(${listing.model.brand.name})</h3>
            <h3 class="mt-4">Prix: ${listing.price/100}&euro;</h3>
            <h3 class="mt-4">Vendu par: ${listing.user.email}</h3>
        </div>

    </div>
    <div class = "row">
        <ul> <h3>Informations supplémentaires :</h3>
            <li>Année de fabrication: ${listing.producedYear}</li>
            <li>Kilométrage: ${listing.mileage}km</li>
        </ul>
    </div>
    <div class = "row">
        <h3>Description :</h3>
        <p>${listing.description}</p>
    </div>
</div>

<%@ include file="../footer.jsp" %>
