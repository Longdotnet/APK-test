package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.ApkChecksum;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager$OnChecksumsReadyListener;
import android.os.Build;
import androidx.core.view.ContentInfoCompat$$ExternalSyntheticApiModelOutline0;
import java.io.ByteArrayInputStream;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public final class zzaxl extends zzayk {
    private static final zzayl zzh = new zzayl();
    private final zzasp zzi;
    private final Context zzj;
    private final zzaup zzk;

    public zzaxl(zzawx zzawxVar, String str, String str2, zzast zzastVar, int i, int i2, Context context, zzasg zzasgVar, zzasp zzaspVar, zzaup zzaupVar) {
        super(zzawxVar, "5l2BxulTXy+0Wovy9T0xreNvMgccuxz9Mfzqj2nIzDWreku9cf/hyHYbFP2gke7n", "rfz55QLsxMWzB2XqDjYWCElC2tXCWyMh5Hq3cP2KfWk=", zzastVar, i, 27);
        this.zzj = context;
        this.zzi = zzaspVar;
        this.zzk = zzaupVar;
    }

    private final zzaum zzc() {
        String str;
        zzbcv zzbcvVar = zzbde.zzcW;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
        int iIntValue = ((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue() ? ((Integer) zzbdVar.zzd.zzb(zzbde.zzdb)).intValue() : this.zzi.zza();
        zzaum zzaumVar = new zzaum((String) this.zze.invoke(null, this.zzj, Boolean.FALSE, ""));
        zzaup zzaupVar = this.zzk;
        if (zzaupVar == null || zzaupVar.zza() == null) {
            str = "E";
        } else {
            try {
                str = (String) zzaupVar.zza().get(iIntValue, TimeUnit.MILLISECONDS);
            } catch (InterruptedException | ExecutionException | TimeoutException unused) {
                str = "E";
            }
        }
        zzaumVar.zza = str;
        return zzaumVar;
    }

    private final String zzd() {
        try {
            zzawx zzawxVar = this.zza;
            if (zzawxVar.zzk() != null) {
                zzawxVar.zzk().get();
            }
            zzatq zzatqVarZzc = zzawxVar.zzc();
            if (zzatqVarZzc == null || !zzatqVarZzc.zzaf()) {
                return null;
            }
            return zzatqVarZzc.zzg();
        } catch (InterruptedException | ExecutionException unused) {
            return null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzayk
    public final void zza() {
        int i;
        zzaum zzaumVarZzc;
        zzaum zzaumVar;
        zzayl zzaylVar = zzh;
        Context context = this.zzj;
        AtomicReference atomicReferenceZza = zzaylVar.zza(context.getPackageName());
        synchronized (atomicReferenceZza) {
            try {
                zzaum zzaumVar2 = (zzaum) atomicReferenceZza.get();
                if (zzaumVar2 == null || zzaxa.zzd(zzaumVar2.zza) || zzaumVar2.zza.equals("E") || zzaumVar2.zza.equals("0000000000000000000000000000000000000000000000000000000000000000")) {
                    if (zzaxa.zzd(null)) {
                        zzaxa.zzd(null);
                        i = 3;
                    } else {
                        i = 5;
                    }
                    if (this.zzk != null) {
                        zzaumVarZzc = zzc();
                    } else {
                        Boolean boolValueOf = Boolean.valueOf(i == 3 && !this.zzi.zzd());
                        zzbcv zzbcvVar = zzbde.zzcK;
                        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
                        Boolean bool = (Boolean) zzbdVar.zzd.zzb(zzbcvVar);
                        String strZzb = ((Boolean) zzbdVar.zzd.zzb(zzbde.zzcJ)).booleanValue() ? zzb() : null;
                        if (bool.booleanValue() && this.zza.zzo() && zzaxa.zzd(strZzb)) {
                            strZzb = zzd();
                        }
                        zzaum zzaumVar3 = new zzaum((String) this.zze.invoke(null, context, boolValueOf, strZzb));
                        if (zzaxa.zzd(zzaumVar3.zza) || zzaumVar3.zza.equals("E")) {
                            int i2 = i - 1;
                            if (i2 == 3) {
                                String strZzd = zzd();
                                if (!zzaxa.zzd(strZzd)) {
                                    zzaumVar3.zza = strZzd;
                                }
                            } else if (i2 == 4) {
                                throw null;
                            }
                        }
                        zzaumVarZzc = zzaumVar3;
                    }
                    atomicReferenceZza.set(zzaumVarZzc);
                }
                zzaumVar = (zzaum) atomicReferenceZza.get();
            } catch (Throwable th) {
                throw th;
            }
        }
        zzast zzastVar = this.zzd;
        synchronized (zzastVar) {
            if (zzaumVar != null) {
                try {
                    zzastVar.zzv(zzaumVar.zza);
                    zzastVar.zzV(zzaumVar.zzb);
                    zzastVar.zzX(zzaumVar.zzc);
                    zzastVar.zzi(zzaumVar.zzd);
                    zzastVar.zzu(zzaumVar.zze);
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    /* JADX WARN: Type inference failed for: r5v3, types: [com.google.android.gms.internal.ads.zzaym] */
    public final String zzb() {
        try {
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            zzbcv zzbcvVar = zzbde.zzcL;
            com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
            byte[] bArrZzf = zzaxa.zzf((String) zzbdVar.zzd.zzb(zzbcvVar));
            ArrayList arrayList = new ArrayList();
            arrayList.add(certificateFactory.generateCertificate(new ByteArrayInputStream(bArrZzf)));
            if (!Build.TYPE.equals("user")) {
                arrayList.add(certificateFactory.generateCertificate(new ByteArrayInputStream(zzaxa.zzf((String) zzbdVar.zzd.zzb(zzbde.zzcM)))));
            }
            Context context = this.zzj;
            String packageName = context.getPackageName();
            this.zza.zzj();
            if (Build.VERSION.SDK_INT <= 30 && !Build.VERSION.CODENAME.equals("S")) {
                return null;
            }
            final zzgeh zzgehVarZze = zzgeh.zze();
            context.getPackageManager().requestChecksums(packageName, false, 8, arrayList, new PackageManager$OnChecksumsReadyListener() { // from class: com.google.android.gms.internal.ads.zzaym
                public final void onChecksumsReady(List list) {
                    zzgeh zzgehVar = zzgehVarZze;
                    if (list == null) {
                        zzgehVar.zzc(null);
                        return;
                    }
                    try {
                        int size = list.size();
                        for (int i = 0; i < size; i++) {
                            ApkChecksum apkChecksumM = ContentInfoCompat$$ExternalSyntheticApiModelOutline0.m(list.get(i));
                            if (apkChecksumM.getType() == 8) {
                                zzgehVar.zzc(zzaxa.zzb(apkChecksumM.getValue()));
                                return;
                            }
                        }
                        zzgehVar.zzc(null);
                    } catch (Throwable unused) {
                        zzgehVar.zzc(null);
                    }
                }
            });
            return (String) zzgehVarZze.get();
        } catch (PackageManager.NameNotFoundException | InterruptedException | NoClassDefFoundError | CertificateEncodingException | CertificateException | ExecutionException unused) {
            return null;
        }
    }
}
