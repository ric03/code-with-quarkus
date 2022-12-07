package org.acme.dummyjson.products;

import io.smallrye.mutiny.Uni;
import org.acme.dummyjson.products.model.ProductList;
import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/auth/products")
@RegisterProvider(TokenProvider.class)
@RegisterRestClient(configKey = "dummy-json-api")
public interface ProtectedProductService {

    @GET
//    @Authenticated
    @Produces("application/json")
    Uni<ProductList> getProductList(@HeaderParam("Authorization") String token);

    @GET
//    @Authenticated
    @Produces("application/json")
    Uni<ProductList> getProductList();
}
