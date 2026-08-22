package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import okio.AsyncTimeout;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class zzdkw implements zzdjb, zzdax {
    private final zzbqf zza;
    private final zzcwq zzb;
    private final zzcym zzc;
    private final zzcvw zzd;
    private final zzdeb zze;
    private final Context zzf;
    private final zzfca zzg;
    private final VersionInfoParcel zzh;
    private final zzfcw zzi;
    private boolean zzj = false;
    private boolean zzk = false;
    private boolean zzl = true;
    private final zzbqb zzm;
    private final zzbqc zzn;

    public zzdkw(zzbqb zzbqbVar, zzbqc zzbqcVar, zzbqf zzbqfVar, zzcwq zzcwqVar, zzcym zzcymVar, zzcvw zzcvwVar, zzdeb zzdebVar, Context context, zzfca zzfcaVar, VersionInfoParcel versionInfoParcel, zzfcw zzfcwVar) {
        this.zzm = zzbqbVar;
        this.zzn = zzbqcVar;
        this.zza = zzbqfVar;
        this.zzb = zzcwqVar;
        this.zzc = zzcymVar;
        this.zzd = zzcvwVar;
        this.zze = zzdebVar;
        this.zzf = context;
        this.zzg = zzfcaVar;
        this.zzh = versionInfoParcel;
        this.zzi = zzfcwVar;
    }

    private final void zzc(View view) {
        try {
            zzbqf zzbqfVar = this.zza;
            if (zzbqfVar != null && !zzbqfVar.zzA()) {
                zzbqfVar.zzw(new ObjectWrapper(view));
                this.zzd.onAdClicked();
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzli)).booleanValue()) {
                    this.zze.zzdf();
                    return;
                }
                return;
            }
            zzbqb zzbqbVar = this.zzm;
            if (zzbqbVar != null && !zzbqbVar.zzx()) {
                zzbqbVar.zzs(new ObjectWrapper(view));
                this.zzd.onAdClicked();
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzli)).booleanValue()) {
                    this.zze.zzdf();
                    return;
                }
                return;
            }
            zzbqc zzbqcVar = this.zzn;
            if (zzbqcVar == null || zzbqcVar.zzv()) {
                return;
            }
            zzbqcVar.zzq(new ObjectWrapper(view));
            this.zzd.onAdClicked();
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzli)).booleanValue()) {
                this.zze.zzdf();
            }
        } catch (RemoteException e) {
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzk("Failed to call handleClick", e);
        }
    }

    private static final HashMap zzd(Map map) {
        HashMap map2 = new HashMap();
        if (map != null) {
            synchronized (map) {
                try {
                    for (Map.Entry entry : map.entrySet()) {
                        View view = (View) ((WeakReference) entry.getValue()).get();
                        if (view != null) {
                            map2.put((String) entry.getKey(), view);
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return map2;
    }

    @Override // com.google.android.gms.internal.ads.zzdjb
    public final void zzA(zzbig zzbigVar) {
    }

    /* JADX WARN: Code duplicated, block: B:52:0x00d1 A[Catch: RemoteException -> 0x002c, JSONException -> 0x0048, TRY_LEAVE, TryCatch #0 {RemoteException -> 0x002c, blocks: (B:2:0x0000, B:4:0x001c, B:8:0x0026, B:13:0x0032, B:15:0x0039, B:16:0x0048, B:18:0x004e, B:20:0x005a, B:23:0x0066, B:26:0x006d, B:28:0x0083, B:30:0x008b, B:45:0x00aa, B:35:0x0095, B:39:0x009e, B:48:0x00b1, B:49:0x00b5, B:50:0x00cb, B:52:0x00d1, B:56:0x00e3, B:58:0x00f1, B:60:0x00ff, B:62:0x0103, B:64:0x0114, B:66:0x0118), top: B:73:0x0000 }] */
    /* JADX WARN: Code duplicated, block: B:85:0x0063 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:88:0x0048 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:91:0x00cb A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.ads.zzdjb
    public final void zzB(View view, Map map, Map map2, View.OnTouchListener onTouchListener, View.OnClickListener onClickListener) {
        Object obj;
        ClassLoader classLoader;
        Iterator it;
        IObjectWrapper iObjectWrapperZzn;
        try {
            ObjectWrapper objectWrapper = new ObjectWrapper(view);
            JSONObject jSONObject = this.zzg.zzaj;
            boolean z = true;
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzbJ)).booleanValue() && jSONObject.length() != 0) {
                Map map3 = map == null ? new HashMap() : map;
                Map map4 = map2 == null ? new HashMap() : map2;
                HashMap map5 = new HashMap();
                map5.putAll(map3);
                map5.putAll(map4);
                Iterator itKeys = jSONObject.keys();
                loop0: while (itKeys.hasNext()) {
                    String str = (String) itKeys.next();
                    JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(str);
                    if (jSONArrayOptJSONArray != null) {
                        WeakReference weakReference = (WeakReference) map5.get(str);
                        if (weakReference != null && (obj = weakReference.get()) != null) {
                            Class<?> cls = obj.getClass();
                            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzbK)).booleanValue() && str.equals("3010")) {
                                zzbqf zzbqfVar = this.zza;
                                Object objUnwrap = null;
                                if (zzbqfVar != null) {
                                    try {
                                        iObjectWrapperZzn = zzbqfVar.zzn();
                                    } catch (RemoteException | IllegalArgumentException unused) {
                                    }
                                } else {
                                    zzbqb zzbqbVar = this.zzm;
                                    if (zzbqbVar != null) {
                                        iObjectWrapperZzn = zzbqbVar.zzk();
                                    } else {
                                        zzbqc zzbqcVar = this.zzn;
                                        iObjectWrapperZzn = zzbqcVar != null ? zzbqcVar.zzj() : null;
                                    }
                                }
                                if (iObjectWrapperZzn != null) {
                                    objUnwrap = ObjectWrapper.unwrap(iObjectWrapperZzn);
                                }
                                if (objUnwrap != null) {
                                    cls = objUnwrap.getClass();
                                    ArrayList arrayList = new ArrayList();
                                    AsyncTimeout.Companion.zzc(jSONArrayOptJSONArray, arrayList);
                                    com.google.android.gms.ads.internal.util.zzs zzsVar = com.google.android.gms.ads.internal.zzv.zza.zzd;
                                    classLoader = this.zzf.getClassLoader();
                                    it = arrayList.iterator();
                                    while (true) {
                                        if (it.hasNext()) {
                                            if (Class.forName((String) it.next(), false, classLoader).isAssignableFrom(cls)) {
                                            }
                                        }
                                    }
                                }
                            } else {
                                try {
                                    ArrayList arrayList2 = new ArrayList();
                                    AsyncTimeout.Companion.zzc(jSONArrayOptJSONArray, arrayList2);
                                    com.google.android.gms.ads.internal.util.zzs zzsVar2 = com.google.android.gms.ads.internal.zzv.zza.zzd;
                                    classLoader = this.zzf.getClassLoader();
                                    it = arrayList2.iterator();
                                    while (true) {
                                        if (it.hasNext()) {
                                            if (Class.forName((String) it.next(), false, classLoader).isAssignableFrom(cls)) {
                                            }
                                        }
                                    }
                                } catch (JSONException unused2) {
                                    continue;
                                }
                            }
                        }
                        z = false;
                        break;
                    }
                }
            }
            this.zzl = z;
            HashMap mapZzd = zzd(map);
            HashMap mapZzd2 = zzd(map2);
            zzbqf zzbqfVar2 = this.zza;
            if (zzbqfVar2 != null) {
                zzbqfVar2.zzy(objectWrapper, new ObjectWrapper(mapZzd), new ObjectWrapper(mapZzd2));
                return;
            }
            zzbqb zzbqbVar2 = this.zzm;
            if (zzbqbVar2 != null) {
                zzbqbVar2.zzv(objectWrapper, new ObjectWrapper(mapZzd), new ObjectWrapper(mapZzd2));
                zzbqbVar2.zzu(objectWrapper);
                return;
            }
            zzbqc zzbqcVar2 = this.zzn;
            if (zzbqcVar2 != null) {
                zzbqcVar2.zzt(objectWrapper, new ObjectWrapper(mapZzd), new ObjectWrapper(mapZzd2));
                zzbqcVar2.zzs(objectWrapper);
            }
        } catch (RemoteException e) {
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzk("Failed to call trackView", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdjb
    public final void zzC(View view, Map map) {
        try {
            ObjectWrapper objectWrapper = new ObjectWrapper(view);
            zzbqf zzbqfVar = this.zza;
            if (zzbqfVar != null) {
                zzbqfVar.zzz(objectWrapper);
                return;
            }
            zzbqb zzbqbVar = this.zzm;
            if (zzbqbVar != null) {
                zzbqbVar.zzw(objectWrapper);
                return;
            }
            zzbqc zzbqcVar = this.zzn;
            if (zzbqcVar != null) {
                zzbqcVar.zzu(objectWrapper);
            }
        } catch (RemoteException e) {
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzk("Failed to call untrackView", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdjb
    public final boolean zzD() {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzdjb
    public final boolean zzE() {
        return this.zzg.zzL;
    }

    @Override // com.google.android.gms.internal.ads.zzdjb
    public final boolean zzF(Bundle bundle) {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzdjb
    public final int zza() {
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzdax
    public final void zzdp() {
    }

    @Override // com.google.android.gms.internal.ads.zzdax
    public final void zzdq() {
        try {
            zzbqf zzbqfVar = this.zza;
            if (zzbqfVar == null || !zzbqfVar.zzB()) {
                return;
            }
            zzfca zzfcaVar = this.zzg;
            if (zzfcaVar.zze != 4 && !zzfcaVar.zzaC) {
                return;
            }
            zzbqfVar.zzx();
            this.zzb.zza();
        } catch (RemoteException e) {
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzk("Failed to report impression from an adapter", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdjb
    public final JSONObject zzf(View view, Map map, Map map2, ImageView.ScaleType scaleType) {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzdjb
    public final JSONObject zzg(View view, Map map, Map map2, ImageView.ScaleType scaleType) {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzdjb
    public final void zzi() {
        int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
        com.google.android.gms.ads.internal.util.client.zzo.zzj("Mute This Ad is not supported for 3rd party ads");
    }

    @Override // com.google.android.gms.internal.ads.zzdjb
    public final void zzj() {
    }

    @Override // com.google.android.gms.internal.ads.zzdjb
    public final void zzk() {
    }

    @Override // com.google.android.gms.internal.ads.zzdjb
    public final void zzl(com.google.android.gms.ads.internal.client.zzdj zzdjVar) {
        int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
        com.google.android.gms.ads.internal.util.client.zzo.zzj("Mute This Ad is not supported for 3rd party ads");
    }

    @Override // com.google.android.gms.internal.ads.zzdjb
    public final void zzm(View view, View view2, Map map, Map map2, boolean z, ImageView.ScaleType scaleType) {
        if (this.zzk && this.zzg.zzL) {
            return;
        }
        zzc(view);
    }

    @Override // com.google.android.gms.internal.ads.zzdjb
    public final void zzn(String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzdjb
    public final void zzo(Bundle bundle) {
    }

    @Override // com.google.android.gms.internal.ads.zzdjb
    public final void zzq(View view, View view2, Map map, Map map2, boolean z, ImageView.ScaleType scaleType, int i) {
        if (!this.zzk) {
            int i2 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("Custom click reporting for 3p ads failed. enableCustomClickGesture is not set.");
        } else if (this.zzg.zzL) {
            zzc(view2);
        } else {
            int i3 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("Custom click reporting for 3p ads failed. Ad unit id not in allow list.");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdjb
    public final void zzr(View view, Map map, Map map2, ImageView.ScaleType scaleType) {
    }

    @Override // com.google.android.gms.internal.ads.zzdjb
    public final void zzs() {
    }

    @Override // com.google.android.gms.internal.ads.zzdjb
    public final void zzt(View view, Map map, Map map2, ImageView.ScaleType scaleType) {
        try {
            if (!this.zzj) {
                this.zzj = com.google.android.gms.ads.internal.zzv.zza.zzp.zzn(this.zzf, this.zzh.afmaVersion, this.zzg.zzC.toString(), this.zzi.zzf);
            }
            if (this.zzl) {
                zzbqf zzbqfVar = this.zza;
                if (zzbqfVar == null) {
                    zzbqb zzbqbVar = this.zzm;
                    if (zzbqbVar != null && !zzbqbVar.zzy()) {
                        zzbqbVar.zzt();
                        this.zzb.zza();
                        return;
                    }
                    zzbqc zzbqcVar = this.zzn;
                    if (zzbqcVar == null || zzbqcVar.zzw()) {
                        return;
                    }
                    zzbqcVar.zzr();
                    this.zzb.zza();
                    return;
                }
                zzfca zzfcaVar = this.zzg;
                if (zzfcaVar.zzaC) {
                    if (zzbqfVar.zzB()) {
                        return;
                    }
                    zzbqfVar.zzx();
                    this.zzb.zza();
                    return;
                }
                if (zzbqfVar.zzB() && zzfcaVar.zze == 4) {
                    this.zzc.zza();
                } else {
                    zzbqfVar.zzx();
                    this.zzb.zza();
                }
            }
        } catch (RemoteException e) {
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzk("Failed to call recordImpression", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdjb
    public final void zzu() {
    }

    @Override // com.google.android.gms.internal.ads.zzdjb
    public final void zzv(View view, MotionEvent motionEvent, View view2) {
    }

    @Override // com.google.android.gms.internal.ads.zzdjb
    public final void zzw(Bundle bundle) {
    }

    @Override // com.google.android.gms.internal.ads.zzdjb
    public final void zzx(View view) {
    }

    @Override // com.google.android.gms.internal.ads.zzdjb
    public final void zzy() {
        this.zzk = true;
    }

    @Override // com.google.android.gms.internal.ads.zzdjb
    public final void zzz(com.google.android.gms.ads.internal.client.zzdf zzdfVar) {
        int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
        com.google.android.gms.ads.internal.util.client.zzo.zzj("Mute This Ad is not supported for 3rd party ads");
    }
}
