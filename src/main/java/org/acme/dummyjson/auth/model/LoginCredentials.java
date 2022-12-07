package org.acme.dummyjson.auth.model;

public record LoginCredentials(
        String username,
        String password
) {
}
