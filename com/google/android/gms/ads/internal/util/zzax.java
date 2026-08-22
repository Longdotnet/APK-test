package com.google.android.gms.ads.internal.util;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import androidx.core.text.jp.CyjpdoedCdLTIO;
import com.yoyogames.runner.RunnerJNILib;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class zzax implements Runnable {
    public final /* synthetic */ Context zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ boolean zzc;
    public final /* synthetic */ boolean zzd;

    public zzax(zzay zzayVar, Context context, String str, boolean z, boolean z2) {
        this.zza = context;
        this.zzb = str;
        this.zzc = z;
        this.zzd = z2;
        Objects.requireNonNull(zzayVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzs zzsVar = com.google.android.gms.ads.internal.zzv.zza.zzd;
        Context context = this.zza;
        AlertDialog.Builder builderZzL = zzs.zzL(context);
        builderZzL.setMessage(this.zzb);
        if (this.zzc) {
            builderZzL.setTitle("Error");
        } else {
            builderZzL.setTitle("Info");
        }
        boolean z = this.zzd;
        String str = CyjpdoedCdLTIO.kAAqoNtk;
        if (z) {
            builderZzL.setNeutralButton(str, (DialogInterface.OnClickListener) null);
        } else {
            builderZzL.setPositiveButton("Learn More", new RunnerJNILib.AnonymousClass2.DialogInterfaceOnClickListenerC00072(this, context));
            builderZzL.setNegativeButton(str, (DialogInterface.OnClickListener) null);
        }
        builderZzL.create().show();
    }
}
