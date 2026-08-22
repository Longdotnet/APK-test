package com.google.android.gms.internal.p002firebaseauthapi;

import android.app.Activity;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzah;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.auth.internal.zzao;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
abstract class zzyb implements zzyd {
    private boolean zza;
    protected final int zzb;
    protected FirebaseApp zzd;
    protected FirebaseUser zze;
    protected Object zzf;
    protected zzao zzg;
    protected Executor zzi;
    protected zzzy zzj;
    protected zzzr zzk;
    protected zzzd zzl;
    protected zzaaj zzm;
    protected String zzn;
    protected String zzo;
    protected AuthCredential zzp;
    protected String zzq;
    protected String zzr;
    protected zztm zzs;
    Object zzt;
    Status zzu;
    protected zzya zzv;
    final zzxy zzc = new zzxy(this);
    protected final List zzh = new ArrayList();

    public zzyb(int i) {
        this.zzb = i;
    }

    public static /* bridge */ /* synthetic */ void zzj(zzyb zzybVar) {
        zzybVar.zzb();
        zzah.checkState(zzybVar.zza, "no success or failure set on method implementation");
    }

    public static /* bridge */ /* synthetic */ void zzk(zzyb zzybVar, Status status) {
        zzao zzaoVar = zzybVar.zzg;
        if (zzaoVar != null) {
            zzaoVar.zzb(status);
        }
    }

    public abstract void zzb();

    public final zzyb zzd(Object obj) {
        zzah.checkNotNull(obj, "external callback cannot be null");
        this.zzf = obj;
        return this;
    }

    public final zzyb zze(zzao zzaoVar) {
        zzah.checkNotNull(zzaoVar, "external failure callback cannot be null");
        this.zzg = zzaoVar;
        return this;
    }

    public final zzyb zzf(FirebaseApp firebaseApp) {
        zzah.checkNotNull(firebaseApp, "firebaseApp cannot be null");
        this.zzd = firebaseApp;
        return this;
    }

    public final zzyb zzg(FirebaseUser firebaseUser) {
        zzah.checkNotNull(firebaseUser, "firebaseUser cannot be null");
        this.zze = firebaseUser;
        return this;
    }

    public final zzyb zzh(PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, Activity activity, Executor executor, String str) {
        PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacksZza = zzyp.zza(str, onVerificationStateChangedCallbacks, this);
        synchronized (this.zzh) {
            List list = this.zzh;
            zzah.checkNotNull(onVerificationStateChangedCallbacksZza);
            list.add(onVerificationStateChangedCallbacksZza);
        }
        if (activity != null) {
            zzxs.zza(activity, this.zzh);
        }
        zzah.checkNotNull(executor);
        this.zzi = executor;
        return this;
    }

    public final void zzl(Status status) {
        this.zza = true;
        this.zzu = status;
        this.zzv.zza(null, status);
    }

    public final void zzm(Object obj) {
        this.zza = true;
        this.zzt = obj;
        this.zzv.zza(obj, null);
    }
}
