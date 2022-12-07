package org.acme.dummyjson.auth.model;

public record LoginResult(
        Integer id,
        String username,
        String email,
        String firstName,
        String lastName,
        Gender gender,
        String image,
        String token
) {
}
