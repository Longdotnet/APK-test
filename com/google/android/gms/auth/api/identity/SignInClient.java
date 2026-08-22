package com.google.android.gms.auth.api.identity;

import android.content.Intent;
import com.google.android.gms.common.api.HasApiKey;
import com.google.android.gms.tasks.Task;

/* JADX INFO: loaded from: classes.dex */
public interface SignInClient extends HasApiKey {
    Task beginSignIn(BeginSignInRequest beginSignInRequest);

    SignInCredential getSignInCredentialFromIntent(Intent intent);
}
