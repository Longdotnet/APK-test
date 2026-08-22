package com.google.firebase.auth.internal;

import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.MultiFactor;
import com.google.firebase.auth.MultiFactorAssertion;
import com.google.firebase.auth.MultiFactorInfo;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class zzac extends MultiFactor {
    public final zzx zza;

    public zzac(zzx zzxVar) {
        com.google.android.gms.common.internal.zzah.checkNotNull(zzxVar);
        this.zza = zzxVar;
    }

    @Override // com.google.firebase.auth.MultiFactor
    public final Task enroll(MultiFactorAssertion multiFactorAssertion, String str) {
        com.google.android.gms.common.internal.zzah.checkNotNull(multiFactorAssertion);
        zzx zzxVar = this.zza;
        return FirebaseAuth.getInstance(zzxVar.zza()).zzb(zzxVar, multiFactorAssertion, str);
    }

    @Override // com.google.firebase.auth.MultiFactor
    public final List<MultiFactorInfo> getEnrolledFactors() {
        return this.zza.zzn();
    }

    @Override // com.google.firebase.auth.MultiFactor
    public final Task getSession() {
        Task idToken = this.zza.getIdToken(false);
        com.google.firebase.auth.zzr zzrVar = new com.google.firebase.auth.zzr(6);
        com.google.android.gms.tasks.zzw zzwVar = (com.google.android.gms.tasks.zzw) idToken;
        zzwVar.getClass();
        return zzwVar.continueWithTask(TaskExecutors.MAIN_THREAD, zzrVar);
    }

    @Override // com.google.firebase.auth.MultiFactor
    public final Task unenroll(MultiFactorInfo multiFactorInfo) {
        com.google.android.gms.common.internal.zzah.checkNotNull(multiFactorInfo);
        String uid = multiFactorInfo.getUid();
        com.google.android.gms.common.internal.zzah.checkNotEmpty(uid);
        zzx zzxVar = this.zza;
        return FirebaseAuth.getInstance(zzxVar.zza()).zzl(zzxVar, uid);
    }

    @Override // com.google.firebase.auth.MultiFactor
    public final Task unenroll(String str) {
        com.google.android.gms.common.internal.zzah.checkNotEmpty(str);
        zzx zzxVar = this.zza;
        return FirebaseAuth.getInstance(zzxVar.zza()).zzl(zzxVar, str);
    }
}
