package com.google.android.gms.internal.p002firebaseauthapi;

import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes.dex */
public final class zzxl {
    private static final String zza = "com.google.android.gms.internal.firebase-auth-api.zzxl";

    private zzxl() {
    }

    public static Object zza(String str, Type type) throws zzvg {
        if (type == String.class) {
            try {
                zzzb zzzbVar = new zzzb();
                zzzbVar.zzb(str);
                if (zzzbVar.zzd()) {
                    return zzzbVar.zzc();
                }
                throw new zzvg("No error message: " + str);
            } catch (Exception e) {
                throw new zzvg("Json conversion failed! ".concat(String.valueOf(e.getMessage())), e);
            }
        }
        if (type == Void.class) {
            return null;
        }
        try {
            zzxn zzxnVar = (zzxn) ((Class) type).getConstructor(null).newInstance(null);
            try {
                zzxnVar.zza(str);
                return zzxnVar;
            } catch (Exception e2) {
                throw new zzvg("Json conversion failed! ".concat(String.valueOf(e2.getMessage())), e2);
            }
        } catch (Exception e3) {
            throw new zzvg("Instantiation of JsonResponse failed! ".concat(type.toString()), e3);
        }
    }
}
