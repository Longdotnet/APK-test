package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public final class zzema implements zzeuc {
    private final zzgdy zza;
    private final Context zzb;
    private final zzfcw zzc;
    private final View zzd;

    public zzema(zzgdy zzgdyVar, Context context, zzfcw zzfcwVar, ViewGroup viewGroup) {
        this.zza = zzgdyVar;
        this.zzb = context;
        this.zzc = zzfcwVar;
        this.zzd = viewGroup;
    }

    public static /* synthetic */ zzemb zzc(zzema zzemaVar) {
        ArrayList arrayList = new ArrayList();
        View view = zzemaVar.zzd;
        while (view != null) {
            Object parent = view.getParent();
            if (parent == null) {
                break;
            }
            int iIndexOfChild = parent instanceof ViewGroup ? ((ViewGroup) parent).indexOfChild(view) : -1;
            Bundle bundle = new Bundle();
            bundle.putString("type", parent.getClass().getName());
            bundle.putInt("index_of_child", iIndexOfChild);
            arrayList.add(bundle);
            if (!(parent instanceof View)) {
                break;
            }
            view = (View) parent;
        }
        return new zzemb(zzemaVar.zzb, zzemaVar.zzc.zze, arrayList);
    }

    @Override // com.google.android.gms.internal.ads.zzeuc
    public final int zza() {
        return 3;
    }

    @Override // com.google.android.gms.internal.ads.zzeuc
    public final ListenableFuture zzb() {
        zzbde.zza(this.zzb);
        return this.zza.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzelz
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return zzema.zzc(this.zza);
            }
        });
    }
}
