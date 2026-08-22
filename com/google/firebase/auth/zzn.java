package com.google.firebase.auth;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.p002firebaseauthapi.zzzy;
import com.google.firebase.auth.internal.zzbk;

/* JADX INFO: loaded from: classes.dex */
public final class zzn implements zzbk {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ FirebaseAuth zza;

    public /* synthetic */ zzn(FirebaseAuth firebaseAuth, int i) {
        this.$r8$classId = i;
        this.zza = firebaseAuth;
    }

    @Override // com.google.firebase.auth.internal.zzg
    public final void zza(zzzy zzzyVar, FirebaseUser firebaseUser) {
        switch (this.$r8$classId) {
            case 0:
                FirebaseAuth.zzH(this.zza, firebaseUser, zzzyVar, true, true);
                break;
            default:
                com.google.android.gms.common.internal.zzah.checkNotNull(zzzyVar);
                com.google.android.gms.common.internal.zzah.checkNotNull(firebaseUser);
                firebaseUser.zzh(zzzyVar);
                FirebaseAuth.zzH(this.zza, firebaseUser, zzzyVar, true, true);
                break;
        }
    }

    @Override // com.google.firebase.auth.internal.zzao
    public final void zzb(Status status) {
        switch (this.$r8$classId) {
            case 0:
                int statusCode = status.getStatusCode();
                if (statusCode == 17011 || statusCode == 17021 || statusCode == 17005) {
                    this.zza.signOut();
                }
                break;
            default:
                if (status.getStatusCode() == 17011 || status.getStatusCode() == 17021 || status.getStatusCode() == 17005 || status.getStatusCode() == 17091) {
                    this.zza.signOut();
                }
                break;
        }
    }
}
