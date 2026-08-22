package com.google.android.gms.ads.internal.util;

import android.os.HandlerThread;
import android.os.Looper;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.google.android.gms.common.internal.zzah;
import com.google.android.gms.internal.ads.zzcfg;
import com.google.android.gms.internal.ads.zzfrw;
import com.google.android.gms.signin.internal.FVfQ.GsPcpBmONXh;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbt {
    public Object zza;
    public Object zzb;
    public int zzc;
    public final Object zzd;

    public zzbt() {
        this.zza = null;
        this.zzb = null;
        this.zzc = 0;
        this.zzd = new Object();
    }

    public zzbt(zzcfg zzcfgVar) throws com.google.android.gms.ads.internal.overlay.zzg {
        this.zza = zzcfgVar.getLayoutParams();
        ViewParent parent = zzcfgVar.getParent();
        this.zzd = zzcfgVar.zzE();
        if (!(parent instanceof ViewGroup)) {
            throw new com.google.android.gms.ads.internal.overlay.zzg("Could not get the parent of the WebView for an overlay.");
        }
        ViewGroup viewGroup = (ViewGroup) parent;
        this.zzb = viewGroup;
        this.zzc = viewGroup.indexOfChild(zzcfgVar.zzF());
        viewGroup.removeView(zzcfgVar.zzF());
        zzcfgVar.zzaq(true);
    }

    public Looper zzb() {
        Looper looper;
        Object obj = this.zzd;
        synchronized (obj) {
            try {
                if (this.zzc != 0) {
                    zzah.checkNotNull((HandlerThread) this.zza, "Invalid state: handlerThread should already been initialized.");
                } else if (((HandlerThread) this.zza) == null) {
                    zze.zza("Starting the looper thread.");
                    HandlerThread handlerThread = new HandlerThread("LooperProvider");
                    this.zza = handlerThread;
                    handlerThread.start();
                    this.zzb = new zzfrw(((HandlerThread) this.zza).getLooper());
                    zze.zza("Looper thread started.");
                } else {
                    zze.zza(GsPcpBmONXh.ssrewyIDDw);
                    obj.notifyAll();
                }
                this.zzc++;
                looper = ((HandlerThread) this.zza).getLooper();
            } catch (Throwable th) {
                throw th;
            }
        }
        return looper;
    }
}
