package com.google.firebase.auth.internal;

import com.google.firebase.auth.FirebaseAuthSettings;

/* JADX INFO: loaded from: classes2.dex */
public final class zzw extends FirebaseAuthSettings {
    public String zza;
    public String zzb;
    public boolean zzc = false;
    public boolean zzd = false;

    @Override // com.google.firebase.auth.FirebaseAuthSettings
    public final void forceRecaptchaFlowForTesting(boolean z) {
        this.zzd = z;
    }

    @Override // com.google.firebase.auth.FirebaseAuthSettings
    public final void setAppVerificationDisabledForTesting(boolean z) {
        this.zzc = z;
    }

    @Override // com.google.firebase.auth.FirebaseAuthSettings
    public final void setAutoRetrievedSmsCodeForPhoneNumber(String str, String str2) {
        this.zza = str;
        this.zzb = str2;
    }

    public final String zza() {
        return this.zza;
    }

    public final String zzb() {
        return this.zzb;
    }

    public final boolean zzc() {
        return this.zzd;
    }

    public final boolean zzd() {
        return (this.zza == null || this.zzb == null) ? false : true;
    }

    public final boolean zze() {
        return this.zzc;
    }
}
