package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.view.Surface;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class zzceo extends zzcbs implements zzhj, zzmr {
    public static final /* synthetic */ int zza = 0;
    private final Context zzb;
    private final zzcdz zzc;
    private final zzyu zzd;
    private final zzcca zze;
    private final WeakReference zzf;
    private final zzwo zzg;
    private zziy zzh;
    private ByteBuffer zzi;
    private boolean zzj;
    private zzcbr zzk;
    private int zzl;
    private int zzm;
    private long zzn;
    private final String zzo;
    private final int zzp;
    private Integer zzr;
    private final ArrayList zzs;
    private volatile zzceb zzt;
    private final Object zzq = new Object();
    private final Set zzu = new HashSet();

    /* JADX WARN: Code duplicated, block: B:22:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:23:0x00e6  */
    public zzceo(Context context, zzcca zzccaVar, zzccb zzccbVar, Integer num) {
        final boolean z;
        final zzgi zzgiVar;
        this.zzb = context;
        this.zze = zzccaVar;
        this.zzr = num;
        this.zzf = new WeakReference(zzccbVar);
        zzcdz zzcdzVar = new zzcdz();
        this.zzc = zzcdzVar;
        zzyu zzyuVar = new zzyu(context);
        this.zzd = zzyuVar;
        if (com.google.android.gms.ads.internal.util.zze.zzc()) {
            com.google.android.gms.ads.internal.util.zze.zza("SimpleExoPlayerAdapter initialize ".concat(toString()));
        }
        zzcbs.zzD().incrementAndGet();
        zzmj zzmjVar = new zzmj(context, new zzcem(this));
        zzmjVar.zzb(zzyuVar);
        zzmjVar.zza(zzcdzVar);
        zzmk zzmkVarZzc = zzmjVar.zzc();
        this.zzh = zzmkVarZzc;
        zzmkVarZzc.zzz(this);
        this.zzl = 0;
        this.zzn = 0L;
        this.zzm = 0;
        this.zzs = new ArrayList();
        this.zzt = null;
        this.zzo = (String) zzfvn.zzd(zzccbVar != null ? zzccbVar.zzr() : null).zzb("");
        this.zzp = zzccbVar != null ? zzccbVar.zzf() : 0;
        final String strZzc = com.google.android.gms.ads.internal.zzv.zza.zzd.zzc(context, zzccbVar.zzm().afmaVersion);
        if (!this.zzj || this.zzi.limit() <= 0) {
            zzbcv zzbcvVar = zzbde.zzck;
            com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
            if (((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue()) {
                if (!((Boolean) zzbdVar.zzd.zzb(zzbde.zzcc)).booleanValue()) {
                    z = zzccaVar.zzi ? false : true;
                }
            } else if (zzccaVar.zzi) {
            }
            final zzgi zzgiVar2 = zzccaVar.zzl ? new zzgi() { // from class: com.google.android.gms.internal.ads.zzcef
                @Override // com.google.android.gms.internal.ads.zzgi
                public final zzgj zza() {
                    return zzceo.zzW(this.zza, strZzc, z);
                }
            } : zzccaVar.zzh > 0 ? new zzgi() { // from class: com.google.android.gms.internal.ads.zzceg
                @Override // com.google.android.gms.internal.ads.zzgi
                public final zzgj zza() {
                    return zzceo.zzX(this.zza, strZzc, z);
                }
            } : new zzgi() { // from class: com.google.android.gms.internal.ads.zzceh
                @Override // com.google.android.gms.internal.ads.zzgi
                public final zzgj zza() {
                    return zzceo.zzY(this.zza, strZzc, z);
                }
            };
            zzgiVar = zzccaVar.zzi ? new zzgi() { // from class: com.google.android.gms.internal.ads.zzcei
                @Override // com.google.android.gms.internal.ads.zzgi
                public final zzgj zza() {
                    return zzceo.zzZ(this.zza, zzgiVar2);
                }
            } : zzgiVar2;
            ByteBuffer byteBuffer = this.zzi;
            if (byteBuffer != null && byteBuffer.limit() > 0) {
                final byte[] bArr = new byte[this.zzi.limit()];
                this.zzi.get(bArr);
                zzgiVar = new zzgi() { // from class: com.google.android.gms.internal.ads.zzcej
                    @Override // com.google.android.gms.internal.ads.zzgi
                    public final zzgj zza() {
                        int i = zzceo.zza;
                        zzgj zzgjVarZza = zzgiVar.zza();
                        byte[] bArr2 = bArr;
                        return new zzcec(new zzge(bArr2), bArr2.length, zzgjVarZza);
                    }
                };
            }
        } else {
            final byte[] bArr2 = new byte[this.zzi.limit()];
            this.zzi.get(bArr2);
            zzgiVar = new zzgi() { // from class: com.google.android.gms.internal.ads.zzced
                @Override // com.google.android.gms.internal.ads.zzgi
                public final zzgj zza() {
                    int i = zzceo.zza;
                    return new zzge(bArr2);
                }
            };
        }
        this.zzg = new zzwo(zzgiVar, new zzwn(((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzn)).booleanValue() ? new zzaea() { // from class: com.google.android.gms.internal.ads.zzcen
            @Override // com.google.android.gms.internal.ads.zzaea
            public final /* synthetic */ zzadv[] zza(Uri uri, Map map) {
                int i = zzceo.zza;
                return new zzadv[]{new zzajj(), new zzahy(), new zzajd(zzakr.zza, 32, null, null, zzfyq.zzn(), null)};
            }
        } : new zzaea() { // from class: com.google.android.gms.internal.ads.zzcee
            @Override // com.google.android.gms.internal.ads.zzaea
            public final /* synthetic */ zzadv[] zza(Uri uri, Map map) {
                int i = zzceo.zza;
                return new zzadv[]{new zzajj(), new zzahy()};
            }
        }));
    }

    public static /* synthetic */ zzgj zzW(zzceo zzceoVar, String str, boolean z) {
        zzceo zzceoVar2 = true != z ? null : zzceoVar;
        zzcca zzccaVar = zzceoVar.zze;
        return new zzcer(str, zzceoVar2, zzccaVar.zzd, zzccaVar.zze, zzccaVar.zzm, zzccaVar.zzn);
    }

    public static /* synthetic */ zzgj zzX(zzceo zzceoVar, String str, boolean z) {
        zzceo zzceoVar2 = true != z ? null : zzceoVar;
        zzcca zzccaVar = zzceoVar.zze;
        zzcdy zzcdyVar = new zzcdy(str, zzceoVar2, zzccaVar.zzd, zzccaVar.zze, zzccaVar.zzh);
        zzceoVar.zzu.add(new WeakReference(zzcdyVar));
        return zzcdyVar;
    }

    public static /* synthetic */ zzgj zzY(zzceo zzceoVar, String str, boolean z) {
        zzgr zzgrVar = new zzgr();
        zzgrVar.zzf(str);
        zzgrVar.zze(true != z ? null : zzceoVar);
        zzcca zzccaVar = zzceoVar.zze;
        zzgrVar.zzc(zzccaVar.zzd);
        zzgrVar.zzd(zzccaVar.zze);
        zzgrVar.zzb(true);
        return zzgrVar.zza();
    }

    public static /* synthetic */ zzgj zzZ(zzceo zzceoVar, zzgi zzgiVar) {
        zzgj zzgjVarZza = zzgiVar.zza();
        zzcel zzcelVar = new zzcel(zzceoVar);
        return new zzceb(zzceoVar.zzb, zzgjVarZza, zzceoVar.zzo, zzceoVar.zzp, zzceoVar, zzcelVar);
    }

    public static /* synthetic */ void zzab(zzceo zzceoVar, boolean z, long j) {
        zzcbr zzcbrVar = zzceoVar.zzk;
        if (zzcbrVar != null) {
            zzcbrVar.zzi(z, j);
        }
    }

    public static /* synthetic */ zzma[] zzac(zzceo zzceoVar, Handler handler, zzacj zzacjVar, zzqh zzqhVar, zzxn zzxnVar, zzuf zzufVar) {
        zztr zztrVar = zztr.zza;
        Context context = zzceoVar.zzb;
        zzru zzruVar = new zzru(context, new zzsx(context, null, null), zztrVar, false, handler, zzqhVar, new zzrc(context).zzc());
        zzaay zzaayVar = new zzaay(context);
        zzaayVar.zzg(zztrVar);
        zzaayVar.zze(handler);
        zzaayVar.zzf(zzacjVar);
        return new zzma[]{zzruVar, zzaayVar.zzh()};
    }

    private final boolean zzad() {
        return this.zzt != null && this.zzt.zzq();
    }

    public final void finalize() {
        zzcbs.zzD().decrementAndGet();
        if (com.google.android.gms.ads.internal.util.zze.zzc()) {
            com.google.android.gms.ads.internal.util.zze.zza("SimpleExoPlayerAdapter finalize ".concat(toString()));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcbs
    public final long zzA() {
        if (zzad()) {
            return 0L;
        }
        return this.zzl;
    }

    @Override // com.google.android.gms.internal.ads.zzcbs
    public final long zzB() {
        if (zzad()) {
            return this.zzt.zzl();
        }
        synchronized (this.zzq) {
            while (true) {
                ArrayList arrayList = this.zzs;
                if (!arrayList.isEmpty()) {
                    long j = this.zzn;
                    Map mapZze = ((zzhe) arrayList.remove(0)).zze();
                    long j2 = 0;
                    if (mapZze != null) {
                        for (Map.Entry entry : mapZze.entrySet()) {
                            if (entry != null) {
                                try {
                                    if (entry.getKey() != null && zzfuv.zzc("content-length", (CharSequence) entry.getKey()) && entry.getValue() != null && ((List) entry.getValue()).get(0) != null) {
                                        j2 = Long.parseLong((String) ((List) entry.getValue()).get(0));
                                        break;
                                    }
                                } catch (NumberFormatException unused) {
                                    continue;
                                }
                            }
                        }
                    }
                    this.zzn = j + j2;
                }
            }
        }
        return this.zzn;
    }

    @Override // com.google.android.gms.internal.ads.zzcbs
    public final Integer zzC() {
        return this.zzr;
    }

    @Override // com.google.android.gms.internal.ads.zzcbs
    public final void zzF(Uri[] uriArr, String str) {
        zzG(uriArr, str, ByteBuffer.allocate(0), false);
    }

    @Override // com.google.android.gms.internal.ads.zzcbs
    public final void zzG(Uri[] uriArr, String str, ByteBuffer byteBuffer, boolean z) {
        zzvj zzvzVar;
        if (this.zzh != null) {
            this.zzi = byteBuffer;
            this.zzj = z;
            int length = uriArr.length;
            if (length == 1) {
                zzvzVar = zzaa(uriArr[0]);
            } else {
                zzvj[] zzvjVarArr = new zzvj[length];
                for (int i = 0; i < uriArr.length; i++) {
                    zzvjVarArr[i] = zzaa(uriArr[i]);
                }
                zzvzVar = new zzvz(false, false, new zzus(), zzvjVarArr);
            }
            this.zzh.zzC(zzvzVar);
            this.zzh.zzq();
            zzcbs.zzE().incrementAndGet();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcbs
    public final void zzH() {
        zziy zziyVar = this.zzh;
        if (zziyVar != null) {
            zziyVar.zzB(this);
            this.zzh.zzA();
            this.zzh = null;
            zzcbs.zzE().decrementAndGet();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcbs
    public final void zzI(long j) {
        this.zzh.zza(j);
    }

    @Override // com.google.android.gms.internal.ads.zzcbs
    public final void zzJ(int i) {
        this.zzc.zzl(i);
    }

    @Override // com.google.android.gms.internal.ads.zzcbs
    public final void zzK(int i) {
        this.zzc.zzm(i);
    }

    @Override // com.google.android.gms.internal.ads.zzcbs
    public final void zzL(zzcbr zzcbrVar) {
        this.zzk = zzcbrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcbs
    public final void zzM(int i) {
        this.zzc.zzn(i);
    }

    @Override // com.google.android.gms.internal.ads.zzcbs
    public final void zzN(int i) {
        this.zzc.zzo(i);
    }

    @Override // com.google.android.gms.internal.ads.zzcbs
    public final void zzO(boolean z) {
        this.zzh.zzr(z);
    }

    @Override // com.google.android.gms.internal.ads.zzcbs
    public final void zzP(Integer num) {
        this.zzr = num;
    }

    @Override // com.google.android.gms.internal.ads.zzcbs
    public final void zzQ(boolean z) {
        if (this.zzh == null) {
            return;
        }
        int i = 0;
        while (true) {
            this.zzh.zzy();
            if (i >= 2) {
                return;
            }
            zzyu zzyuVar = this.zzd;
            zzyh zzyhVarZzc = zzyuVar.zzf().zzc();
            zzyhVarZzc.zzx(i, !z);
            zzyuVar.zzl(zzyhVarZzc);
            i++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcbs
    public final void zzR(int i) {
        Iterator it = this.zzu.iterator();
        while (it.hasNext()) {
            zzcdy zzcdyVar = (zzcdy) ((WeakReference) it.next()).get();
            if (zzcdyVar != null) {
                zzcdyVar.zzm(i);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcbs
    public final void zzS(Surface surface, boolean z) {
        zziy zziyVar = this.zzh;
        if (zziyVar != null) {
            zziyVar.zzs(surface);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcbs
    public final void zzT(float f, boolean z) {
        zziy zziyVar = this.zzh;
        if (zziyVar != null) {
            zziyVar.zzt(f);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcbs
    public final void zzU() {
        this.zzh.zzu();
    }

    @Override // com.google.android.gms.internal.ads.zzcbs
    public final boolean zzV() {
        return this.zzh != null;
    }

    @Override // com.google.android.gms.internal.ads.zzhj
    public final void zza(zzgj zzgjVar, zzgo zzgoVar, boolean z, int i) {
        this.zzl += i;
    }

    public final zzvj zzaa(Uri uri) {
        zzad zzadVar = new zzad();
        zzadVar.zzb(uri);
        zzap zzapVarZzc = zzadVar.zzc();
        zzwo zzwoVar = this.zzg;
        zzwoVar.zza(this.zze.zzf);
        return zzwoVar.zzb(zzapVarZzc);
    }

    @Override // com.google.android.gms.internal.ads.zzhj
    public final void zzb(zzgj zzgjVar, zzgo zzgoVar, boolean z) {
    }

    @Override // com.google.android.gms.internal.ads.zzhj
    public final void zzc(zzgj zzgjVar, zzgo zzgoVar, boolean z) {
    }

    @Override // com.google.android.gms.internal.ads.zzhj
    public final void zzd(zzgj zzgjVar, zzgo zzgoVar, boolean z) {
        if (zzgjVar instanceof zzhe) {
            synchronized (this.zzq) {
                this.zzs.add((zzhe) zzgjVar);
            }
        } else if (zzgjVar instanceof zzceb) {
            this.zzt = (zzceb) zzgjVar;
            final zzccb zzccbVar = (zzccb) this.zzf.get();
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzcc)).booleanValue() && zzccbVar != null && this.zzt.zzn()) {
                final HashMap map = new HashMap();
                map.put("gcacheHit", String.valueOf(this.zzt.zzp()));
                map.put("gcacheDownloaded", String.valueOf(this.zzt.zzo()));
                com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcek
                    @Override // java.lang.Runnable
                    public final void run() {
                        int i = zzceo.zza;
                        zzccbVar.zzd("onGcacheInfoEvent", map);
                    }
                });
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzmr
    public final void zze(zzmp zzmpVar, zzz zzzVar, zzie zzieVar) {
        zzccb zzccbVar = (zzccb) this.zzf.get();
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzcc)).booleanValue() || zzccbVar == null) {
            return;
        }
        HashMap map = new HashMap();
        String str = zzzVar.zzn;
        if (str != null) {
            map.put("audioMime", str);
        }
        String str2 = zzzVar.zzo;
        if (str2 != null) {
            map.put("audioSampleMime", str2);
        }
        String str3 = zzzVar.zzk;
        if (str3 != null) {
            map.put("audioCodec", str3);
        }
        zzccbVar.zzd("onMetadataEvent", map);
    }

    @Override // com.google.android.gms.internal.ads.zzmr
    public final /* synthetic */ void zzf(zzmp zzmpVar, int i, long j, long j2) {
    }

    @Override // com.google.android.gms.internal.ads.zzmr
    public final /* synthetic */ void zzg(zzmp zzmpVar, zzvd zzvdVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzmr
    public final void zzh(zzmp zzmpVar, int i, long j) {
        this.zzm += i;
    }

    @Override // com.google.android.gms.internal.ads.zzmr
    public final /* synthetic */ void zzi(zzbh zzbhVar, zzmq zzmqVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzmr
    public final void zzj(zzmp zzmpVar, zzuy zzuyVar, zzvd zzvdVar, IOException iOException, boolean z) {
        zzcbr zzcbrVar = this.zzk;
        if (zzcbrVar != null) {
            if (this.zze.zzj) {
                zzcbrVar.zzl("onLoadException", iOException);
            } else {
                zzcbrVar.zzk("onLoadError", iOException);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzmr
    public final void zzk(zzmp zzmpVar, int i) {
        zzcbr zzcbrVar = this.zzk;
        if (zzcbrVar != null) {
            zzcbrVar.zzm(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzmr
    public final void zzl(zzmp zzmpVar, zzba zzbaVar) {
        zzcbr zzcbrVar = this.zzk;
        if (zzcbrVar != null) {
            zzcbrVar.zzk("onPlayerError", zzbaVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzmr
    public final /* synthetic */ void zzm(zzmp zzmpVar, zzbf zzbfVar, zzbf zzbfVar2, int i) {
    }

    @Override // com.google.android.gms.internal.ads.zzmr
    public final void zzn(zzmp zzmpVar, Object obj, long j) {
        zzcbr zzcbrVar = this.zzk;
        if (zzcbrVar != null) {
            zzcbrVar.zzv();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzmr
    public final /* synthetic */ void zzo(zzmp zzmpVar, zzid zzidVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzmr
    public final void zzp(zzmp zzmpVar, zzz zzzVar, zzie zzieVar) {
        zzccb zzccbVar = (zzccb) this.zzf.get();
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzcc)).booleanValue() || zzccbVar == null) {
            return;
        }
        HashMap map = new HashMap();
        map.put("frameRate", String.valueOf(zzzVar.zzz));
        map.put("bitRate", String.valueOf(zzzVar.zzj));
        map.put("resolution", zzzVar.zzv + "x" + zzzVar.zzw);
        String str = zzzVar.zzn;
        if (str != null) {
            map.put("videoMime", str);
        }
        String str2 = zzzVar.zzo;
        if (str2 != null) {
            map.put("videoSampleMime", str2);
        }
        String str3 = zzzVar.zzk;
        if (str3 != null) {
            map.put("videoCodec", str3);
        }
        zzccbVar.zzd("onMetadataEvent", map);
    }

    @Override // com.google.android.gms.internal.ads.zzmr
    public final void zzq(zzmp zzmpVar, zzcd zzcdVar) {
        zzcbr zzcbrVar = this.zzk;
        if (zzcbrVar != null) {
            zzcbrVar.zzD(zzcdVar.zzb, zzcdVar.zzc);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcbs
    public final int zzr() {
        return this.zzm;
    }

    @Override // com.google.android.gms.internal.ads.zzcbs
    public final int zzt() {
        return this.zzh.zzg();
    }

    @Override // com.google.android.gms.internal.ads.zzcbs
    public final long zzv() {
        return this.zzh.zzj();
    }

    @Override // com.google.android.gms.internal.ads.zzcbs
    public final long zzw() {
        return this.zzl;
    }

    @Override // com.google.android.gms.internal.ads.zzcbs
    public final long zzx() {
        if (zzad() && this.zzt.zzp()) {
            return Math.min(this.zzl, this.zzt.zzk());
        }
        return 0L;
    }

    @Override // com.google.android.gms.internal.ads.zzcbs
    public final long zzy() {
        return this.zzh.zzl();
    }

    @Override // com.google.android.gms.internal.ads.zzcbs
    public final long zzz() {
        return this.zzh.zzm();
    }
}
