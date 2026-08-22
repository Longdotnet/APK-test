package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.browser.customtabs.CustomTabsCallback;
import androidx.core.internal.view.Oteb.nYVxXTZQ;
import com.google.android.gms.games.provider.NtJ.wsbWxekY;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;
import okhttp3.MediaType;

/* JADX INFO: loaded from: classes2.dex */
public final class zzdrn implements zzdax, com.google.android.gms.ads.internal.client.zza, zzcws, zzcwc, zzcyo {
    private final Context zzc;
    private final zzfdo zzd;
    private final zzdsj zze;
    private final zzfcn zzf;
    private final zzfca zzg;
    private final zzeca zzh;
    private final String zzi;
    private Boolean zzk;
    private long zzj = -1;
    final AtomicBoolean zza = new AtomicBoolean(false);
    final AtomicBoolean zzb = new AtomicBoolean(false);
    private final boolean zzl = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzgZ)).booleanValue();

    public zzdrn(Context context, zzfdo zzfdoVar, zzdsj zzdsjVar, zzfcn zzfcnVar, zzfca zzfcaVar, zzeca zzecaVar, String str) {
        this.zzc = context;
        this.zzd = zzfdoVar;
        this.zze = zzdsjVar;
        this.zzf = zzfcnVar;
        this.zzg = zzfcaVar;
        this.zzh = zzecaVar;
        this.zzi = str;
    }

    private final zzdsi zzf(String str) {
        zzfcn zzfcnVar = this.zzf;
        zzfcm zzfcmVar = zzfcnVar.zzb;
        zzdsi zzdsiVarZza = this.zze.zza();
        zzdsiVarZza.zzd(zzfcmVar.zzb);
        zzfca zzfcaVar = this.zzg;
        zzdsiVarZza.zzc(zzfcaVar);
        zzdsiVarZza.zzb("action", str);
        zzdsiVarZza.zzb(FirebaseAnalytics.Param.AD_FORMAT, this.zzi.toUpperCase(Locale.ROOT));
        List list = zzfcaVar.zzt;
        if (!list.isEmpty()) {
            zzdsiVarZza.zzb("ancn", (String) list.get(0));
        }
        if (zzfcaVar.zzb()) {
            Context context = this.zzc;
            com.google.android.gms.ads.internal.zzv zzvVar = com.google.android.gms.ads.internal.zzv.zza;
            zzdsiVarZza.zzb("device_connectivity", true != zzvVar.zzi.zzA(context) ? "offline" : CustomTabsCallback.ONLINE_EXTRAS_KEY);
            zzvVar.zzl.getClass();
            zzdsiVarZza.zzb("event_timestamp", String.valueOf(System.currentTimeMillis()));
            zzdsiVarZza.zzb("offline_ad", "1");
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzhg)).booleanValue()) {
            boolean z = MediaType.Companion.zzg(zzfcnVar.zza.zza) != 1;
            zzdsiVarZza.zzb("scar", String.valueOf(z));
            if (z) {
                com.google.android.gms.ads.internal.client.zzm zzmVar = zzfcnVar.zza.zza.zzd;
                zzdsiVarZza.zzb("ragent", zzmVar.zzp);
                zzdsiVarZza.zzb("rtype", MediaType.Companion.zzb(MediaType.Companion.zzc(zzmVar)));
            }
        }
        return zzdsiVarZza;
    }

    private final void zzg(zzdsi zzdsiVar) {
        if (!this.zzg.zzb()) {
            zzdsiVar.zzj();
            return;
        }
        String strZze = zzdsiVar.zze();
        com.google.android.gms.ads.internal.zzv.zza.zzl.getClass();
        this.zzh.zzd(new zzecc(System.currentTimeMillis(), this.zzf.zzb.zzb.zzb, strZze, 2));
    }

    private final boolean zzh() {
        int i = this.zzg.zzb;
        return i == 2 || i == 5 || i == 6 || i == 7;
    }

    private final boolean zzi() {
        String strZzq;
        if (this.zzk == null) {
            synchronized (this) {
                if (this.zzk == null) {
                    String str = (String) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzbF);
                    com.google.android.gms.ads.internal.util.zzs zzsVar = com.google.android.gms.ads.internal.zzv.zza.zzd;
                    try {
                        strZzq = com.google.android.gms.ads.internal.util.zzs.zzq(this.zzc);
                    } catch (RemoteException unused) {
                        strZzq = null;
                    }
                    boolean zMatches = false;
                    if (str != null && strZzq != null) {
                        try {
                            zMatches = Pattern.matches(str, strZzq);
                        } catch (RuntimeException e) {
                            com.google.android.gms.ads.internal.zzv.zza.zzi.zzw(e, "CsiActionsListener.isPatternMatched");
                        }
                    }
                    this.zzk = Boolean.valueOf(zMatches);
                }
            }
        }
        return this.zzk.booleanValue();
    }

    @Override // com.google.android.gms.ads.internal.client.zza
    public final void onAdClicked() {
        if (this.zzg.zzb()) {
            zzg(zzf("click"));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcwc
    public final void zzc(com.google.android.gms.ads.internal.client.zze zzeVar) {
        com.google.android.gms.ads.internal.client.zze zzeVar2;
        if (this.zzl) {
            zzdsi zzdsiVarZzf = zzf("ifts");
            zzdsiVarZzf.zzb("reason", "adapter");
            int i = zzeVar.zza;
            if (zzeVar.zzc.equals("com.google.android.gms.ads") && (zzeVar2 = zzeVar.zzd) != null && !zzeVar2.zzc.equals("com.google.android.gms.ads")) {
                zzeVar = zzeVar.zzd;
                i = zzeVar.zza;
            }
            String str = zzeVar.zzb;
            if (i >= 0) {
                zzdsiVarZzf.zzb("arec", String.valueOf(i));
            }
            String strZza = this.zzd.zza(str);
            if (strZza != null) {
                zzdsiVarZzf.zzb("areec", strZza);
            }
            zzdsiVarZzf.zzj();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcwc
    public final void zzd() {
        if (this.zzl) {
            zzdsi zzdsiVarZzf = zzf("ifts");
            zzdsiVarZzf.zzb("reason", "blocked");
            zzdsiVarZzf.zzj();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdax
    public final void zzdp() {
        if (zzi()) {
            zzf("adapter_shown").zzj();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcwc
    public final void zze(zzdgm zzdgmVar) {
        if (this.zzl) {
            zzdsi zzdsiVarZzf = zzf("ifts");
            zzdsiVarZzf.zzb("reason", "exception");
            if (!TextUtils.isEmpty(zzdgmVar.getMessage())) {
                zzdsiVarZzf.zzb("msg", zzdgmVar.getMessage());
            }
            zzdsiVarZzf.zzj();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcws
    public final void zzt() {
        if (zzi() || this.zzg.zzb()) {
            zzdsi zzdsiVarZzf = zzf("impression");
            zzdsiVarZzf.zzb("imp_type", String.valueOf(this.zzg.zze));
            if (this.zzj > 0) {
                com.google.android.gms.ads.internal.zzv.zza.zzl.getClass();
                zzdsiVarZzf.zzb("p_imp_l", String.valueOf(System.currentTimeMillis() - this.zzj));
            }
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zznL)).booleanValue() && zzh()) {
                com.google.android.gms.ads.internal.util.zzs zzsVar = com.google.android.gms.ads.internal.zzv.zza.zzd;
                zzdsiVarZzf.zzb("foreground", true != com.google.android.gms.ads.internal.util.zzs.zzH(this.zzc) ? "1" : "0");
                zzdsiVarZzf.zzb("fg_show", true == this.zza.get() ? "1" : "0");
            }
            zzg(zzdsiVarZzf);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcyo
    public final void zzv() {
        if (zzi()) {
            this.zzb.set(true);
            com.google.android.gms.ads.internal.zzv.zza.zzl.getClass();
            this.zzj = System.currentTimeMillis();
            zzdsi zzdsiVarZzf = zzf("presentation");
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zznL)).booleanValue() && zzh()) {
                AtomicBoolean atomicBoolean = this.zza;
                atomicBoolean.set(!com.google.android.gms.ads.internal.util.zzs.zzH(this.zzc));
                zzdsiVarZzf.zzb("foreground", true != atomicBoolean.get() ? "0" : "1");
            }
            zzdsiVarZzf.zzj();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdax
    public final void zzdq() {
        String str;
        if (!zzi()) {
            return;
        }
        zzdsi zzdsiVarZzf = zzf(wsbWxekY.hphMJq);
        zzdsiVarZzf.zzb("imp_type", String.valueOf(this.zzg.zze));
        boolean z = this.zzb.get();
        String str2 = nYVxXTZQ.kqYifxdaR;
        if (z) {
            zzdsiVarZzf.zzb("po", "1");
            com.google.android.gms.ads.internal.zzv.zza.zzl.getClass();
            zzdsiVarZzf.zzb("pil", String.valueOf(System.currentTimeMillis() - this.zzj));
        } else {
            zzdsiVarZzf.zzb("po", str2);
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zznL)).booleanValue() && zzh()) {
            com.google.android.gms.ads.internal.util.zzs zzsVar = com.google.android.gms.ads.internal.zzv.zza.zzd;
            if (true != com.google.android.gms.ads.internal.util.zzs.zzH(this.zzc)) {
                str = "1";
            } else {
                str = str2;
            }
            zzdsiVarZzf.zzb("foreground", str);
            if (true == this.zza.get()) {
                str2 = "1";
            }
            zzdsiVarZzf.zzb("fg_show", str2);
        }
        zzdsiVarZzf.zzj();
    }
}
