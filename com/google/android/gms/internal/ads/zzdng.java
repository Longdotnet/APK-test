package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.collection.ArrayMap;
import androidx.collection.SimpleArrayMap;
import com.google.android.gms.ads.internal.offline.buffering.Dk.eoBKjVuj;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class zzdng extends zzbhi {
    private final Context zza;
    private final zzdit zzb;
    private zzdjt zzc;
    private zzdio zzd;

    public zzdng(Context context, zzdit zzditVar, zzdjt zzdjtVar, zzdio zzdioVar) {
        this.zza = context;
        this.zzb = zzditVar;
        this.zzc = zzdjtVar;
        this.zzd = zzdioVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbhj
    public final com.google.android.gms.ads.internal.client.zzed zze() {
        return this.zzb.zzj();
    }

    @Override // com.google.android.gms.internal.ads.zzbhj
    public final zzbgm zzf() {
        try {
            return this.zzd.zzc().zza();
        } catch (NullPointerException e) {
            com.google.android.gms.ads.internal.zzv.zza.zzi.zzw(e, "InternalNativeCustomTemplateAdShim.getMediaContent");
            return null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbhj
    public final zzbgp zzg(String str) {
        return (zzbgp) this.zzb.zzh().getOrDefault(str, null);
    }

    @Override // com.google.android.gms.internal.ads.zzbhj
    public final IObjectWrapper zzh() {
        return new ObjectWrapper(this.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbhj
    public final String zzi() {
        return this.zzb.zzA();
    }

    @Override // com.google.android.gms.internal.ads.zzbhj
    public final String zzj(String str) {
        return (String) this.zzb.zzi().getOrDefault(str, null);
    }

    @Override // com.google.android.gms.internal.ads.zzbhj
    public final List zzk() {
        try {
            zzdit zzditVar = this.zzb;
            SimpleArrayMap simpleArrayMapZzh = zzditVar.zzh();
            SimpleArrayMap simpleArrayMapZzi = zzditVar.zzi();
            String[] strArr = new String[simpleArrayMapZzh.mSize + simpleArrayMapZzi.mSize];
            int i = 0;
            for (int i2 = 0; i2 < simpleArrayMapZzh.mSize; i2++) {
                strArr[i] = (String) simpleArrayMapZzh.keyAt(i2);
                i++;
            }
            for (int i3 = 0; i3 < simpleArrayMapZzi.mSize; i3++) {
                strArr[i] = (String) simpleArrayMapZzi.keyAt(i3);
                i++;
            }
            return Arrays.asList(strArr);
        } catch (NullPointerException e) {
            com.google.android.gms.ads.internal.zzv.zza.zzi.zzw(e, "InternalNativeCustomTemplateAdShim.getAvailableAssetNames");
            return new ArrayList();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbhj
    public final void zzl() {
        zzdio zzdioVar = this.zzd;
        if (zzdioVar != null) {
            zzdioVar.zzb();
        }
        this.zzd = null;
        this.zzc = null;
    }

    @Override // com.google.android.gms.internal.ads.zzbhj
    public final void zzm() {
        try {
            String strZzC = this.zzb.zzC();
            if (Objects.equals(strZzC, "Google")) {
                int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                com.google.android.gms.ads.internal.util.client.zzo.zzj("Illegal argument specified for omid partner name.");
            } else if (TextUtils.isEmpty(strZzC)) {
                int i2 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                com.google.android.gms.ads.internal.util.client.zzo.zzj("Not starting OMID session. OM partner name has not been configured.");
            } else {
                zzdio zzdioVar = this.zzd;
                if (zzdioVar != null) {
                    zzdioVar.zzf(strZzC, false);
                }
            }
        } catch (NullPointerException e) {
            com.google.android.gms.ads.internal.zzv.zza.zzi.zzw(e, "InternalNativeCustomTemplateAdShim.initializeDisplayOpenMeasurement");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbhj
    public final void zzn(String str) {
        zzdio zzdioVar = this.zzd;
        if (zzdioVar != null) {
            zzdioVar.zzG(str);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbhj
    public final void zzo() {
        zzdio zzdioVar = this.zzd;
        if (zzdioVar != null) {
            zzdioVar.zzK();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbhj
    public final void zzp(IObjectWrapper iObjectWrapper) {
        zzdio zzdioVar;
        Object objUnwrap = ObjectWrapper.unwrap(iObjectWrapper);
        if (!(objUnwrap instanceof View) || this.zzb.zzu() == null || (zzdioVar = this.zzd) == null) {
            return;
        }
        zzdioVar.zzL((View) objUnwrap);
    }

    @Override // com.google.android.gms.internal.ads.zzbhj
    public final boolean zzq() {
        zzdio zzdioVar = this.zzd;
        if (zzdioVar != null && !zzdioVar.zzY()) {
            return false;
        }
        zzdit zzditVar = this.zzb;
        return zzditVar.zzr() != null && zzditVar.zzs() == null;
    }

    @Override // com.google.android.gms.internal.ads.zzbhj
    public final boolean zzr(IObjectWrapper iObjectWrapper) {
        zzdjt zzdjtVar;
        Object objUnwrap = ObjectWrapper.unwrap(iObjectWrapper);
        if (!(objUnwrap instanceof ViewGroup) || (zzdjtVar = this.zzc) == null || !zzdjtVar.zzf((ViewGroup) objUnwrap)) {
            return false;
        }
        this.zzb.zzq().zzar(new zzdnf(this, "_videoMediaView"));
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzbhj
    public final boolean zzs(IObjectWrapper iObjectWrapper) {
        zzdjt zzdjtVar;
        Object objUnwrap = ObjectWrapper.unwrap(iObjectWrapper);
        if (!(objUnwrap instanceof ViewGroup) || (zzdjtVar = this.zzc) == null || !zzdjtVar.zzg((ViewGroup) objUnwrap)) {
            return false;
        }
        this.zzb.zzs().zzar(new zzdnf(this, "_videoMediaView"));
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzbhj
    public final boolean zzt() {
        zzdit zzditVar = this.zzb;
        zzedh zzedhVarZzu = zzditVar.zzu();
        if (zzedhVarZzu == null) {
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzj(eoBKjVuj.thgkEa);
            return false;
        }
        com.google.android.gms.ads.internal.zzv.zza.zzz.zzk(zzedhVarZzu.zza());
        if (zzditVar.zzr() == null) {
            return true;
        }
        zzditVar.zzr().zzd("onSdkLoaded", new ArrayMap());
        return true;
    }
}
