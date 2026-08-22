package com.google.android.gms.ads.internal.offline.buffering;

import android.content.Context;
import androidx.appcompat.widget.TooltipPopup;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import com.google.android.gms.ads.internal.client.zzai;
import com.google.android.gms.ads.internal.client.zzbb;
import com.google.android.gms.internal.ads.zzbpm;
import com.google.android.gms.internal.ads.zzbtj;
import com.pairip.VMRunner;

/* JADX INFO: loaded from: classes2.dex */
public class OfflinePingSender extends Worker {
    public final zzbtj zza;

    public OfflinePingSender(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        TooltipPopup tooltipPopup = zzbb.zzb.zzd;
        zzbpm zzbpmVar = new zzbpm();
        tooltipPopup.getClass();
        this.zza = (zzbtj) new zzai(tooltipPopup, context, zzbpmVar).zzd(context, false);
    }

    @Override // androidx.work.Worker
    public final ListenableWorker.Result doWork() {
        return (ListenableWorker.Result) VMRunner.invoke("Aqs2DLGCe5yckhuh", new Object[]{this});
    }
}
