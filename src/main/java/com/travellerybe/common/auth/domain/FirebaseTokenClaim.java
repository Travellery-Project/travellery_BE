package com.travellerybe.common.auth.domain;

import com.google.firebase.auth.FirebaseToken;

public record FirebaseTokenClaim(
        String email,
        String picture,
        String name
) {
    public static FirebaseTokenClaim fromFirebaseToken(FirebaseToken firebaseToken) {
        return new FirebaseTokenClaim(
                firebaseToken.getEmail(),
                firebaseToken.getPicture(),
                firebaseToken.getName()
        );
    }
}
