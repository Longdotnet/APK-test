package com.google.android.gms.auth.api;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.zzah;
import com.google.android.gms.internal.p000authapi.zbl;
import com.google.firebase.auth.zzz;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public abstract class Auth {
    public static final Api CREDENTIALS_API;
    public static final Api GOOGLE_SIGN_IN_API;
    public static final Api.ClientKey zba;

    public final class AuthCredentialsOptions implements Api.ApiOptions.Optional {
        public static final AuthCredentialsOptions zba;
        public final boolean zbc;
        public final String zbd;

        static {
            zzz zzzVar = new zzz();
            zzzVar.zza = Boolean.FALSE;
            zba = new AuthCredentialsOptions(zzzVar);
        }

        public AuthCredentialsOptions(zzz zzzVar) {
            this.zbc = ((Boolean) zzzVar.zza).booleanValue();
            this.zbd = (String) zzzVar.zzb;
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof AuthCredentialsOptions)) {
                return false;
            }
            AuthCredentialsOptions authCredentialsOptions = (AuthCredentialsOptions) obj;
            authCredentialsOptions.getClass();
            return zzah.equal(null, null) && this.zbc == authCredentialsOptions.zbc && zzah.equal(this.zbd, authCredentialsOptions.zbd);
        }

        public final int hashCode() {
            return Arrays.hashCode(new Object[]{null, Boolean.valueOf(this.zbc), this.zbd});
        }
    }

    static {
        Api.ClientKey clientKey = new Api.ClientKey();
        zba = clientKey;
        Api.ClientKey clientKey2 = new Api.ClientKey();
        zba zbaVar = new zba();
        zbb zbbVar = new zbb();
        Api api = AuthProxy.API;
        CREDENTIALS_API = new Api("Auth.CREDENTIALS_API", zbaVar, clientKey);
        GOOGLE_SIGN_IN_API = new Api("Auth.GOOGLE_SIGN_IN_API", zbbVar, clientKey2);
        new zbl();
    }
}
