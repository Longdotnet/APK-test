package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.IBinder;
import android.os.SystemClock;
import android.text.TextUtils;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class zzfhl implements zzfhj {
    private final Context zza;
    private final int zzp;
    private long zzb = 0;
    private long zzc = -1;
    private boolean zzd = false;
    private int zzq = 2;
    private int zzr = 2;
    private int zze = 0;
    private String zzf = "";
    private String zzg = "";
    private String zzh = "";
    private String zzi = "";
    private zzfhz zzj = zzfhz.SCAR_REQUEST_TYPE_UNSPECIFIED;
    private String zzk = "";
    private String zzl = "";
    private String zzm = "";
    private boolean zzn = false;
    private boolean zzo = false;

    public zzfhl(Context context, int i) {
        this.zza = context;
        this.zzp = i;
    }

    public final synchronized zzfhl zzA() {
        com.google.android.gms.ads.internal.zzv.zza.zzl.getClass();
        this.zzc = SystemClock.elapsedRealtime();
        return this;
    }

    public final synchronized zzfhl zzK(int i) {
        this.zzq = i;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfhj
    public final /* bridge */ /* synthetic */ zzfhj zza(com.google.android.gms.ads.internal.client.zze zzeVar) {
        zzr(zzeVar);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfhj
    public final /* bridge */ /* synthetic */ zzfhj zzb(zzfcm zzfcmVar) {
        zzs(zzfcmVar);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfhj
    public final /* bridge */ /* synthetic */ zzfhj zzc(String str) {
        zzt(str);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfhj
    public final /* bridge */ /* synthetic */ zzfhj zzd(String str) {
        zzu(str);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfhj
    public final /* bridge */ /* synthetic */ zzfhj zze(String str) {
        zzv(str);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfhj
    public final /* bridge */ /* synthetic */ zzfhj zzf(zzfhz zzfhzVar) {
        zzw(zzfhzVar);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfhj
    public final /* bridge */ /* synthetic */ zzfhj zzg(boolean z) {
        zzx(z);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfhj
    public final /* bridge */ /* synthetic */ zzfhj zzh(Throwable th) {
        zzy(th);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfhj
    public final /* bridge */ /* synthetic */ zzfhj zzi() {
        zzz();
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfhj
    public final /* bridge */ /* synthetic */ zzfhj zzj() {
        zzA();
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfhj
    public final synchronized boolean zzk() {
        return this.zzo;
    }

    @Override // com.google.android.gms.internal.ads.zzfhj
    public final boolean zzl() {
        return !TextUtils.isEmpty(this.zzh);
    }

    @Override // com.google.android.gms.internal.ads.zzfhj
    public final synchronized zzfhn zzm() {
        try {
            if (this.zzn) {
                return null;
            }
            this.zzn = true;
            if (!this.zzo) {
                zzz();
            }
            if (this.zzc < 0) {
                zzA();
            }
            return new zzfhn(this, null);
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfhj
    public final /* bridge */ /* synthetic */ zzfhj zzn(int i) {
        zzK(i);
        return this;
    }

    public final synchronized zzfhl zzr(com.google.android.gms.ads.internal.client.zze zzeVar) {
        try {
            IBinder iBinder = zzeVar.zze;
            if (iBinder != null) {
                zzcvr zzcvrVar = (zzcvr) iBinder;
                String strZzl = zzcvrVar.zzl();
                if (!TextUtils.isEmpty(strZzl)) {
                    this.zzf = strZzl;
                }
                String strZzi = zzcvrVar.zzi();
                if (!TextUtils.isEmpty(strZzi)) {
                    this.zzg = strZzi;
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return this;
    }

    public final synchronized zzfhl zzs(zzfcm zzfcmVar) {
        try {
            String str = zzfcmVar.zzb.zzb;
            if (!TextUtils.isEmpty(str)) {
                this.zzf = str;
            }
            Iterator it = zzfcmVar.zza.iterator();
            while (it.hasNext()) {
                String str2 = ((zzfca) it.next()).zzab;
                if (!TextUtils.isEmpty(str2)) {
                    this.zzg = str2;
                    break;
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return this;
    }

    public final synchronized zzfhl zzt(String str) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzjj)).booleanValue()) {
            this.zzm = str;
        }
        return this;
    }

    public final synchronized zzfhl zzu(String str) {
        this.zzh = str;
        return this;
    }

    public final synchronized zzfhl zzv(String str) {
        this.zzi = str;
        return this;
    }

    public final synchronized zzfhl zzw(zzfhz zzfhzVar) {
        this.zzj = zzfhzVar;
        return this;
    }

    public final synchronized zzfhl zzx(boolean z) {
        this.zzd = z;
        return this;
    }

    public final synchronized zzfhl zzy(Throwable th) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzjj)).booleanValue()) {
            this.zzl = zzbun.zzf(th);
            this.zzk = (String) zzfwe.zzb(zzfva.zzc('\n')).zzd(zzbun.zze(th)).iterator().next();
        }
        return this;
    }

    public final synchronized zzfhl zzz() {
        Configuration configuration;
        com.google.android.gms.ads.internal.zzv zzvVar = com.google.android.gms.ads.internal.zzv.zza;
        com.google.android.gms.ads.internal.util.zzt zztVar = zzvVar.zzg;
        Context context = this.zza;
        this.zze = zztVar.zzm(context);
        Resources resources = context.getResources();
        int i = 2;
        if (resources != null && (configuration = resources.getConfiguration()) != null) {
            i = configuration.orientation == 2 ? 4 : 3;
        }
        this.zzr = i;
        zzvVar.zzl.getClass();
        this.zzb = SystemClock.elapsedRealtime();
        this.zzo = true;
        return this;
    }
}
