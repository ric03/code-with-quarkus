package org.acme.dummyjson.products;

import io.smallrye.mutiny.Uni;
import org.acme.dummyjson.products.model.ProductList;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/products")
@RegisterRestClient(configKey = "dummy-json-api")
public interface ProductService {

    @GET
    Uni<ProductList> getProductList();
}
