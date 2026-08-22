package com.google.android.gms.internal.ads;

import android.os.AsyncTask;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzfnu extends AsyncTask {
    private zzfnv zza;
    protected final zzfnm zzd;

    public zzfnu(zzfnm zzfnmVar) {
        this.zzd = zzfnmVar;
    }

    @Override // android.os.AsyncTask
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(String str) {
        zzfnv zzfnvVar = this.zza;
        if (zzfnvVar != null) {
            zzfnvVar.zza(this);
        }
    }

    public final void zzb(zzfnv zzfnvVar) {
        this.zza = zzfnvVar;
    }
}
