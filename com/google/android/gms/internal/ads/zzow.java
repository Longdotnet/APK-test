package com.google.android.gms.internal.ads;

import android.util.Base64;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;

/* JADX INFO: loaded from: classes.dex */
public final class zzow implements zzpf {
    public static final zzfwh zza = new zzfwh() { // from class: com.google.android.gms.internal.ads.zzou
        @Override // com.google.android.gms.internal.ads.zzfwh
        public final Object zza() {
            return zzow.zzn();
        }
    };
    private static final Random zzb = new Random();
    private final zzbk zzc;
    private final zzbj zzd;
    private final HashMap zze;
    private zzpe zzf;
    private zzbl zzg;
    private String zzh;
    private long zzi;

    public zzow() {
        throw null;
    }

    public final long zzl() {
        zzov zzovVar = (zzov) this.zze.get(this.zzh);
        return (zzovVar == null || zzovVar.zzd == -1) ? this.zzi + 1 : zzovVar.zzd;
    }

    private final zzov zzm(int i, zzvh zzvhVar) {
        HashMap map = this.zze;
        long j = Long.MAX_VALUE;
        zzov zzovVar = null;
        for (zzov zzovVar2 : map.values()) {
            zzovVar2.zzg(i, zzvhVar);
            if (zzovVar2.zzj(i, zzvhVar)) {
                long j2 = zzovVar2.zzd;
                if (j2 == -1 || j2 < j) {
                    zzovVar = zzovVar2;
                    j = j2;
                } else if (j2 == j) {
                    String str = zzex.zza;
                    if (zzovVar.zze != null && zzovVar2.zze != null) {
                        zzovVar = zzovVar2;
                    }
                }
            }
        }
        if (zzovVar != null) {
            return zzovVar;
        }
        String strZzn = zzn();
        zzov zzovVar3 = new zzov(this, strZzn, i, zzvhVar);
        map.put(strZzn, zzovVar3);
        return zzovVar3;
    }

    public static String zzn() {
        byte[] bArr = new byte[12];
        zzb.nextBytes(bArr);
        return Base64.encodeToString(bArr, 10);
    }

    private final void zzo(zzov zzovVar) {
        if (zzovVar.zzd != -1) {
            this.zzi = zzovVar.zzd;
        }
        this.zzh = null;
    }

    private final void zzp(zzmp zzmpVar) {
        if (zzmpVar.zzb.zzo()) {
            String str = this.zzh;
            if (str != null) {
                zzov zzovVar = (zzov) this.zze.get(str);
                zzovVar.getClass();
                zzo(zzovVar);
                return;
            }
            return;
        }
        zzov zzovVar2 = (zzov) this.zze.get(this.zzh);
        int i = zzmpVar.zzc;
        zzvh zzvhVar = zzmpVar.zzd;
        zzov zzovVarZzm = zzm(i, zzvhVar);
        this.zzh = zzovVarZzm.zzb;
        zzi(zzmpVar);
        if (zzvhVar == null || !zzvhVar.zzb()) {
            return;
        }
        if (zzovVar2 != null) {
            if (zzovVar2.zzd == zzvhVar.zzd && zzovVar2.zze != null && zzovVar2.zze.zzb == zzvhVar.zzb && zzovVar2.zze.zzc == zzvhVar.zzc) {
                return;
            }
        }
        String unused = zzm(i, new zzvh(zzvhVar.zza, zzvhVar.zzd)).zzb;
        String unused2 = zzovVarZzm.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzpf
    public final synchronized String zze() {
        return this.zzh;
    }

    @Override // com.google.android.gms.internal.ads.zzpf
    public final synchronized String zzf(zzbl zzblVar, zzvh zzvhVar) {
        return zzm(zzblVar.zzn(zzvhVar.zza, this.zzd).zzc, zzvhVar).zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzpf
    public final synchronized void zzg(zzmp zzmpVar) {
        zzpe zzpeVar;
        try {
            String str = this.zzh;
            if (str != null) {
                zzov zzovVar = (zzov) this.zze.get(str);
                if (zzovVar == null) {
                    throw null;
                }
                zzo(zzovVar);
            }
            Iterator it = this.zze.values().iterator();
            while (it.hasNext()) {
                zzov zzovVar2 = (zzov) it.next();
                it.remove();
                if (zzovVar2.zzf && (zzpeVar = this.zzf) != null) {
                    zzpeVar.zzv(zzmpVar, zzovVar2.zzb, false);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzpf
    public final void zzh(zzpe zzpeVar) {
        this.zzf = zzpeVar;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x003f A[Catch: all -> 0x003c, TryCatch #0 {all -> 0x003c, blocks: (B:3:0x0001, B:5:0x0005, B:8:0x000f, B:10:0x0013, B:12:0x001d, B:14:0x0029, B:16:0x0033, B:21:0x003f, B:23:0x0049, B:26:0x0052, B:28:0x0058, B:30:0x006d, B:31:0x0089, B:33:0x008f, B:34:0x0095, B:36:0x00a1, B:38:0x00a7, B:44:0x00b8), top: B:47:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:23:0x0049 A[Catch: all -> 0x003c, TryCatch #0 {all -> 0x003c, blocks: (B:3:0x0001, B:5:0x0005, B:8:0x000f, B:10:0x0013, B:12:0x001d, B:14:0x0029, B:16:0x0033, B:21:0x003f, B:23:0x0049, B:26:0x0052, B:28:0x0058, B:30:0x006d, B:31:0x0089, B:33:0x008f, B:34:0x0095, B:36:0x00a1, B:38:0x00a7, B:44:0x00b8), top: B:47:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:30:0x006d A[Catch: all -> 0x003c, TryCatch #0 {all -> 0x003c, blocks: (B:3:0x0001, B:5:0x0005, B:8:0x000f, B:10:0x0013, B:12:0x001d, B:14:0x0029, B:16:0x0033, B:21:0x003f, B:23:0x0049, B:26:0x0052, B:28:0x0058, B:30:0x006d, B:31:0x0089, B:33:0x008f, B:34:0x0095, B:36:0x00a1, B:38:0x00a7, B:44:0x00b8), top: B:47:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:33:0x008f A[Catch: all -> 0x003c, TryCatch #0 {all -> 0x003c, blocks: (B:3:0x0001, B:5:0x0005, B:8:0x000f, B:10:0x0013, B:12:0x001d, B:14:0x0029, B:16:0x0033, B:21:0x003f, B:23:0x0049, B:26:0x0052, B:28:0x0058, B:30:0x006d, B:31:0x0089, B:33:0x008f, B:34:0x0095, B:36:0x00a1, B:38:0x00a7, B:44:0x00b8), top: B:47:0x0001 }] */
    @Override // com.google.android.gms.internal.ads.zzpf
    public final synchronized void zzi(zzmp zzmpVar) {
        int i;
        zzov zzovVarZzm;
        Object obj;
        int i2;
        zzov zzovVarZzm2;
        zzov zzovVar;
        try {
            if (this.zzf == null) {
                throw null;
            }
            zzbl zzblVar = zzmpVar.zzb;
            if (!zzblVar.zzo()) {
                zzvh zzvhVar = zzmpVar.zzd;
                if (zzvhVar == null) {
                    i = zzmpVar.zzc;
                    zzovVarZzm = zzm(i, zzvhVar);
                    if (this.zzh == null) {
                        this.zzh = zzovVarZzm.zzb;
                    }
                    if (zzvhVar != null) {
                        obj = zzvhVar.zza;
                        long j = zzvhVar.zzd;
                        i2 = zzvhVar.zzb;
                        zzovVarZzm2 = zzm(i, new zzvh(obj, j, i2));
                        if (!zzovVarZzm2.zzf) {
                            zzovVarZzm2.zzf = true;
                            zzbj zzbjVar = this.zzd;
                            zzblVar.zzn(obj, zzbjVar);
                            zzbjVar.zzg(i2);
                            Math.max(0L, zzex.zzv(0L) + zzex.zzv(0L));
                            String unused = zzovVarZzm2.zzb;
                        }
                    }
                    if (!zzovVarZzm.zzf) {
                        zzovVarZzm.zzf = true;
                        String unused2 = zzovVarZzm.zzb;
                    }
                    if (zzovVarZzm.zzb.equals(this.zzh)) {
                        zzovVarZzm.zzg = true;
                        this.zzf.zzu(zzmpVar, zzovVarZzm.zzb);
                    }
                } else if (zzvhVar.zzd >= zzl() && ((zzovVar = (zzov) this.zze.get(this.zzh)) == null || zzovVar.zzd != -1 || zzovVar.zzc == zzmpVar.zzc)) {
                    i = zzmpVar.zzc;
                    zzovVarZzm = zzm(i, zzvhVar);
                    if (this.zzh == null) {
                        this.zzh = zzovVarZzm.zzb;
                    }
                    if (zzvhVar != null && zzvhVar.zzb()) {
                        obj = zzvhVar.zza;
                        long j2 = zzvhVar.zzd;
                        i2 = zzvhVar.zzb;
                        zzovVarZzm2 = zzm(i, new zzvh(obj, j2, i2));
                        if (!zzovVarZzm2.zzf) {
                            zzovVarZzm2.zzf = true;
                            zzbj zzbjVar2 = this.zzd;
                            zzblVar.zzn(obj, zzbjVar2);
                            zzbjVar2.zzg(i2);
                            Math.max(0L, zzex.zzv(0L) + zzex.zzv(0L));
                            String unused3 = zzovVarZzm2.zzb;
                        }
                    }
                    if (!zzovVarZzm.zzf) {
                        zzovVarZzm.zzf = true;
                        String unused4 = zzovVarZzm.zzb;
                    }
                    if (zzovVarZzm.zzb.equals(this.zzh) && !zzovVarZzm.zzg) {
                        zzovVarZzm.zzg = true;
                        this.zzf.zzu(zzmpVar, zzovVarZzm.zzb);
                    }
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzpf
    public final synchronized void zzj(zzmp zzmpVar, int i) {
        try {
            if (this.zzf == null) {
                throw null;
            }
            Iterator it = this.zze.values().iterator();
            while (it.hasNext()) {
                zzov zzovVar = (zzov) it.next();
                if (zzovVar.zzk(zzmpVar)) {
                    it.remove();
                    if (zzovVar.zzf) {
                        boolean zEquals = zzovVar.zzb.equals(this.zzh);
                        boolean z = false;
                        if (i == 0 && zEquals && zzovVar.zzg) {
                            z = true;
                        }
                        if (zEquals) {
                            zzo(zzovVar);
                        }
                        this.zzf.zzv(zzmpVar, zzovVar.zzb, z);
                    }
                }
            }
            zzp(zzmpVar);
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzpf
    public final synchronized void zzk(zzmp zzmpVar) {
        try {
            if (this.zzf == null) {
                throw null;
            }
            zzbl zzblVar = this.zzg;
            this.zzg = zzmpVar.zzb;
            Iterator it = this.zze.values().iterator();
            while (it.hasNext()) {
                zzov zzovVar = (zzov) it.next();
                if (!zzovVar.zzl(zzblVar, this.zzg) || zzovVar.zzk(zzmpVar)) {
                    it.remove();
                    if (zzovVar.zzf) {
                        if (zzovVar.zzb.equals(this.zzh)) {
                            zzo(zzovVar);
                        }
                        this.zzf.zzv(zzmpVar, zzovVar.zzb, false);
                    }
                }
            }
            zzp(zzmpVar);
        } catch (Throwable th) {
            throw th;
        }
    }

    public zzow(zzfwh zzfwhVar) {
        this.zzc = new zzbk();
        this.zzd = new zzbj();
        this.zze = new HashMap();
        this.zzg = zzbl.zza;
        this.zzi = -1L;
    }
}
