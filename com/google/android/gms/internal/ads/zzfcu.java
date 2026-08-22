package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.formats.AdManagerAdViewOptions;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;
import com.google.android.gms.ads.internal.gMU.QTaELkFI;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes2.dex */
public final class zzfcu {
    private com.google.android.gms.ads.internal.client.zzm zza;
    private com.google.android.gms.ads.internal.client.zzr zzb;
    private String zzc;
    private com.google.android.gms.ads.internal.client.zzgc zzd;
    private boolean zze;
    private ArrayList zzf;
    private ArrayList zzg;
    private zzbge zzh;
    private com.google.android.gms.ads.internal.client.zzx zzi;
    private AdManagerAdViewOptions zzj;
    private PublisherAdViewOptions zzk;
    private com.google.android.gms.ads.internal.client.zzco zzl;
    private zzbmp zzn;
    private zzeky zzr;
    private Bundle zzt;
    private com.google.android.gms.ads.internal.client.zzcs zzv;
    private int zzm = 1;
    private final zzfch zzo = new zzfch();
    private boolean zzp = false;
    private boolean zzq = false;
    private boolean zzs = false;
    private final AtomicLong zzu = new AtomicLong();

    public final zzfcu zzA(boolean z) {
        this.zzs = true;
        return this;
    }

    public final zzfcu zzB(Bundle bundle) {
        this.zzt = bundle;
        return this;
    }

    public final zzfcu zzC(boolean z) {
        this.zze = z;
        return this;
    }

    public final zzfcu zzD(int i) {
        this.zzm = i;
        return this;
    }

    public final zzfcu zzE(zzbge zzbgeVar) {
        this.zzh = zzbgeVar;
        return this;
    }

    public final zzfcu zzF(ArrayList arrayList) {
        this.zzf = arrayList;
        return this;
    }

    public final zzfcu zzG(ArrayList arrayList) {
        this.zzg = arrayList;
        return this;
    }

    public final zzfcu zzH(long j) {
        this.zzu.set(j);
        return this;
    }

    public final zzfcu zzI(PublisherAdViewOptions publisherAdViewOptions) {
        this.zzk = publisherAdViewOptions;
        if (publisherAdViewOptions != null) {
            this.zze = publisherAdViewOptions.zza;
            this.zzl = publisherAdViewOptions.zzb;
        }
        return this;
    }

    public final zzfcu zzJ(com.google.android.gms.ads.internal.client.zzm zzmVar) {
        this.zza = zzmVar;
        return this;
    }

    public final zzfcu zzK(com.google.android.gms.ads.internal.client.zzgc zzgcVar) {
        this.zzd = zzgcVar;
        return this;
    }

    public final String zzN() {
        return this.zzc;
    }

    public final boolean zzV() {
        return this.zzp;
    }

    public final boolean zzW() {
        return this.zzq;
    }

    public final zzfcu zzY(com.google.android.gms.ads.internal.client.zzcs zzcsVar) {
        this.zzv = zzcsVar;
        return this;
    }

    public final long zzb() {
        return this.zzu.get();
    }

    public final com.google.android.gms.ads.internal.client.zzm zzg() {
        return this.zza;
    }

    public final com.google.android.gms.ads.internal.client.zzr zzi() {
        return this.zzb;
    }

    public final zzfch zzq() {
        return this.zzo;
    }

    public final zzfcu zzr(zzfcw zzfcwVar) {
        this.zzo.zza(zzfcwVar.zzo.zza);
        this.zza = zzfcwVar.zzd;
        this.zzb = zzfcwVar.zze;
        this.zzv = zzfcwVar.zzu;
        this.zzc = zzfcwVar.zzf;
        this.zzd = zzfcwVar.zza;
        this.zzf = zzfcwVar.zzg;
        this.zzg = zzfcwVar.zzh;
        this.zzh = zzfcwVar.zzi;
        this.zzi = zzfcwVar.zzj;
        zzs(zzfcwVar.zzl);
        zzI(zzfcwVar.zzm);
        this.zzp = zzfcwVar.zzp;
        this.zzq = zzfcwVar.zzq;
        this.zzr = zzfcwVar.zzc;
        this.zzs = zzfcwVar.zzr;
        this.zzt = zzfcwVar.zzs;
        this.zzu.set(zzfcwVar.zzt.get());
        return this;
    }

    public final zzfcu zzs(AdManagerAdViewOptions adManagerAdViewOptions) {
        this.zzj = adManagerAdViewOptions;
        if (adManagerAdViewOptions != null) {
            this.zze = adManagerAdViewOptions.zza;
        }
        return this;
    }

    public final zzfcu zzt(com.google.android.gms.ads.internal.client.zzr zzrVar) {
        this.zzb = zzrVar;
        return this;
    }

    public final zzfcu zzu(String str) {
        this.zzc = str;
        return this;
    }

    public final zzfcu zzv(com.google.android.gms.ads.internal.client.zzx zzxVar) {
        this.zzi = zzxVar;
        return this;
    }

    public final zzfcu zzw(zzeky zzekyVar) {
        this.zzr = zzekyVar;
        return this;
    }

    public final zzfcu zzx(zzbmp zzbmpVar) {
        this.zzn = zzbmpVar;
        this.zzd = new com.google.android.gms.ads.internal.client.zzgc(false, true, false);
        return this;
    }

    public final zzfcu zzy(boolean z) {
        this.zzp = z;
        return this;
    }

    public final zzfcu zzz(boolean z) {
        this.zzq = z;
        return this;
    }

    public final zzfcw zzL() {
        com.google.android.gms.common.internal.zzah.checkNotNull(this.zzc, "ad unit must not be null");
        com.google.android.gms.common.internal.zzah.checkNotNull(this.zzb, QTaELkFI.jAJglq);
        com.google.android.gms.common.internal.zzah.checkNotNull(this.zza, "ad request must not be null");
        return new zzfcw(this, null);
    }
}
