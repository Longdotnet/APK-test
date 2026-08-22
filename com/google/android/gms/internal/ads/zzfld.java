package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Parcel;
import android.os.RemoteException;
import com.facebook.login.vu.dLDI;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.internal.ClientApi;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public abstract class zzfld {
    protected final ClientApi zza;
    protected final Context zzb;
    protected final int zzc;
    protected final zzbpq zzd;
    protected com.google.android.gms.ads.internal.client.zzfv zze;
    protected AtomicBoolean zzf;
    protected com.google.android.gms.ads.internal.client.zzch zzg;
    private com.google.android.gms.ads.internal.client.zzce zzh;
    private final Queue zzi;
    private final zzfkg zzj;
    private final String zzk;
    private AtomicBoolean zzl;
    private final ScheduledExecutorService zzm;
    private AtomicBoolean zzn;
    private AtomicBoolean zzo;
    private zzfkl zzp;
    private final Clock zzq;
    private final zzfkt zzr;

    public zzfld(ClientApi clientApi, Context context, int i, zzbpq zzbpqVar, com.google.android.gms.ads.internal.client.zzfv zzfvVar, com.google.android.gms.ads.internal.client.zzce zzceVar, ScheduledExecutorService scheduledExecutorService, zzfkg zzfkgVar, Clock clock) {
        this("none", clientApi, context, i, zzbpqVar, zzfvVar, scheduledExecutorService, zzfkgVar, clock);
        this.zzh = zzceVar;
    }

    private final synchronized void zzE(Object obj) {
        try {
            Clock clock = this.zzq;
            zzfku zzfkuVar = new zzfku(obj, clock);
            this.zzi.add(zzfkuVar);
            com.google.android.gms.ads.internal.client.zzea zzeaVarZza = zza(obj);
            ((DefaultClock) clock).getClass();
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (this.zzn.get()) {
                com.google.android.gms.ads.internal.util.zzs.zza.post(new zzfky(this, zzeaVarZza));
            }
            ScheduledExecutorService scheduledExecutorService = this.zzm;
            scheduledExecutorService.execute(new zzfkz(this, jCurrentTimeMillis, zzeaVarZza));
            scheduledExecutorService.schedule(new zzfkx(this), zzfkuVar.zza(), TimeUnit.MILLISECONDS);
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void zzF(Throwable th) {
        try {
            this.zzl.set(false);
            if ((th instanceof zzfka) && ((zzfka) th).zza() == 0) {
                throw null;
            }
            zzN(true);
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void zzG(Object obj) {
        try {
            this.zzl.set(false);
            if (obj != null) {
                this.zzj.zzc();
                this.zzo.set(true);
                zzE(obj);
            }
            zzN(obj == null);
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:19:0x003e A[DONT_GENERATE] */
    /* JADX WARN: Code duplicated, block: B:24:0x0022 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Instruction removed from duplicated block: B:19:0x003e, please report this as an issue */
    public final synchronized void zzH(com.google.android.gms.ads.internal.client.zzea zzeaVar) {
        com.google.android.gms.ads.internal.client.zzch zzchVar;
        com.google.android.gms.ads.internal.client.zzce zzceVar = this.zzh;
        if (zzceVar == null) {
            zzchVar = this.zzg;
            if (zzchVar != null) {
                String str = this.zzk;
                com.google.android.gms.ads.internal.client.zzcf zzcfVar = (com.google.android.gms.ads.internal.client.zzcf) zzchVar;
                Parcel parcelZza = zzcfVar.zza();
                parcelZza.writeString(str);
                zzayv.zzg(parcelZza, zzeaVar);
                zzcfVar.zzdb(1, parcelZza);
                return;
            }
            return;
        }
        try {
            com.google.android.gms.ads.internal.client.zzfv zzfvVar = this.zze;
            com.google.android.gms.ads.internal.client.zzcc zzccVar = (com.google.android.gms.ads.internal.client.zzcc) zzceVar;
            Parcel parcelZza2 = zzccVar.zza();
            zzayv.zze(parcelZza2, zzfvVar);
            zzccVar.zzdb(1, parcelZza2);
        } catch (RemoteException unused) {
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("Failed to call onAdsAvailable");
        }
        zzchVar = this.zzg;
        if (zzchVar != null) {
            try {
                String str2 = this.zzk;
                com.google.android.gms.ads.internal.client.zzcf zzcfVar2 = (com.google.android.gms.ads.internal.client.zzcf) zzchVar;
                Parcel parcelZza3 = zzcfVar2.zza();
                parcelZza3.writeString(str2);
                zzayv.zzg(parcelZza3, zzeaVar);
                zzcfVar2.zzdb(1, parcelZza3);
                return;
            } catch (RemoteException unused2) {
                int i2 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                com.google.android.gms.ads.internal.util.client.zzo.zzj("Failed to call onAdPreloaded");
                return;
            }
        }
        return;
        throw th;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:19:0x003b A[DONT_GENERATE] */
    /* JADX WARN: Code duplicated, block: B:23:0x0022 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Instruction removed from duplicated block: B:19:0x003b, please report this as an issue */
    public final synchronized void zzI() {
        com.google.android.gms.ads.internal.client.zzch zzchVar;
        com.google.android.gms.ads.internal.client.zzce zzceVar = this.zzh;
        if (zzceVar == null) {
            zzchVar = this.zzg;
            if (zzchVar != null) {
                String str = this.zzk;
                com.google.android.gms.ads.internal.client.zzcf zzcfVar = (com.google.android.gms.ads.internal.client.zzcf) zzchVar;
                Parcel parcelZza = zzcfVar.zza();
                parcelZza.writeString(str);
                zzcfVar.zzdb(2, parcelZza);
                return;
            }
            return;
        }
        try {
            com.google.android.gms.ads.internal.client.zzfv zzfvVar = this.zze;
            com.google.android.gms.ads.internal.client.zzcc zzccVar = (com.google.android.gms.ads.internal.client.zzcc) zzceVar;
            Parcel parcelZza2 = zzccVar.zza();
            zzayv.zze(parcelZza2, zzfvVar);
            zzccVar.zzdb(2, parcelZza2);
        } catch (RemoteException unused) {
            int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("Failed to call onAdsExhausted");
        }
        zzchVar = this.zzg;
        if (zzchVar != null) {
            try {
                String str2 = this.zzk;
                com.google.android.gms.ads.internal.client.zzcf zzcfVar2 = (com.google.android.gms.ads.internal.client.zzcf) zzchVar;
                Parcel parcelZza3 = zzcfVar2.zza();
                parcelZza3.writeString(str2);
                zzcfVar2.zzdb(2, parcelZza3);
                return;
            } catch (RemoteException unused2) {
                int i2 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                com.google.android.gms.ads.internal.util.client.zzo.zzj("Failed to call onAdsExhausted");
                return;
            }
        }
        return;
        throw th;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void zzJ(com.google.android.gms.ads.internal.client.zze zzeVar) {
        com.google.android.gms.ads.internal.client.zzch zzchVar = this.zzg;
        if (zzchVar != null) {
            try {
                String str = this.zzk;
                com.google.android.gms.ads.internal.client.zzcf zzcfVar = (com.google.android.gms.ads.internal.client.zzcf) zzchVar;
                Parcel parcelZza = zzcfVar.zza();
                parcelZza.writeString(str);
                zzayv.zze(parcelZza, zzeVar);
                zzcfVar.zzdb(3, parcelZza);
            } catch (RemoteException unused) {
                int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                com.google.android.gms.ads.internal.util.client.zzo.zzj("Failed to call onAdFailedToPreload");
            }
        }
    }

    private final synchronized void zzK() {
        try {
            if (this.zzo.get() && this.zzi.isEmpty()) {
                this.zzo.set(false);
                if (this.zzn.get()) {
                    com.google.android.gms.ads.internal.util.zzs.zza.post(new zzflb(this));
                }
                this.zzm.execute(new zzflc(this));
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void zzL(com.google.android.gms.ads.internal.client.zze zzeVar) {
        try {
            if (this.zzn.get()) {
                com.google.android.gms.ads.internal.util.zzs.zza.post(new zzfla(this, zzeVar));
            }
            this.zzl.set(false);
            int i = zzeVar.zza;
            if (i != 1 && i != 8 && i != 10 && i != 11) {
                zzN(true);
                return;
            }
            com.google.android.gms.ads.internal.client.zzfv zzfvVar = this.zze;
            String str = "Preloading " + zzfvVar.zzb + ", for adUnitId:" + zzfvVar.zza + ", Ad load failed. Stop preloading due to non-retriable error:";
            int i2 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzi(str);
            this.zzf.set(false);
            zzfkr zzfkrVar = new zzfkr(this.zze.zza, zze());
            zzfkrVar.zzb(this.zzk);
            zzfkt zzfktVar = new zzfkt(zzfkrVar, null);
            zzfkl zzfklVar = this.zzp;
            ((DefaultClock) this.zzq).getClass();
            zzfklVar.zzk(System.currentTimeMillis(), zzfktVar, zzeVar, this.zze.zzd, zzd(), zzD());
        } catch (Throwable th) {
            throw th;
        }
    }

    private final synchronized void zzM() {
        Iterator it = this.zzi.iterator();
        while (it.hasNext()) {
            if (((zzfku) it.next()).zzd()) {
                it.remove();
            }
        }
    }

    private final synchronized void zzN(boolean z) {
        try {
            zzfkg zzfkgVar = this.zzj;
            if (zzfkgVar.zze()) {
                return;
            }
            if (z) {
                zzfkgVar.zzb();
            }
            this.zzm.schedule(new zzfkx(this), zzfkgVar.zza(), TimeUnit.MILLISECONDS);
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String zzO(com.google.android.gms.ads.internal.client.zzea zzeaVar) {
        if (zzeaVar instanceof zzcvr) {
            return ((zzcvr) zzeaVar).zzl();
        }
        return null;
    }

    public static /* bridge */ /* synthetic */ double zzc(zzfld zzfldVar, com.google.android.gms.ads.internal.client.zzea zzeaVar) {
        if (zzeaVar instanceof zzcvr) {
            return ((zzcvr) zzeaVar).zzc();
        }
        return 0.0d;
    }

    public final void zzA() {
        this.zzf.set(false);
        this.zzn.set(false);
    }

    public final void zzB(int i) {
        com.google.android.gms.common.internal.zzah.checkArgument(i > 0);
        AdFormat adFormat = AdFormat.getAdFormat(this.zze.zzb);
        int i2 = this.zze.zzd;
        synchronized (this) {
            try {
                com.google.android.gms.ads.internal.client.zzfv zzfvVar = this.zze;
                this.zze = new com.google.android.gms.ads.internal.client.zzfv(zzfvVar.zza, zzfvVar.zzb, zzfvVar.zzc, i > 0 ? i : zzfvVar.zzd);
                Queue queue = this.zzi;
                if (queue.size() > i) {
                    if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzv)).booleanValue()) {
                        ArrayList arrayList = new ArrayList();
                        for (int i3 = 0; i3 < i; i3++) {
                            zzfku zzfkuVar = (zzfku) queue.poll();
                            if (zzfkuVar != null) {
                                arrayList.add(zzfkuVar);
                            }
                        }
                        queue.clear();
                        queue.addAll(arrayList);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        zzfkl zzfklVar = this.zzp;
        if (zzfklVar == null || adFormat == null) {
            return;
        }
        ((DefaultClock) this.zzq).getClass();
        zzfklVar.zza(i2, i, System.currentTimeMillis(), new zzfkt(new zzfkr(this.zze.zza, adFormat), null));
    }

    public final synchronized boolean zzC() {
        zzM();
        return !this.zzi.isEmpty();
    }

    public abstract com.google.android.gms.ads.internal.client.zzea zza(Object obj);

    public abstract ListenableFuture zzb(Context context);

    public final synchronized int zzd() {
        return this.zzi.size();
    }

    public final AdFormat zze() {
        return AdFormat.getAdFormat(this.zze.zzb);
    }

    public final synchronized zzfld zzh() {
        this.zzm.submit(new zzfkx(this));
        return this;
    }

    public final synchronized Object zzj() {
        zzfku zzfkuVar = (zzfku) this.zzi.peek();
        if (zzfkuVar == null) {
            return null;
        }
        return zzfkuVar.zzc();
    }

    public final synchronized Object zzk() {
        try {
            this.zzj.zzc();
            Queue queue = this.zzi;
            zzfku zzfkuVar = (zzfku) queue.poll();
            this.zzo.set(zzfkuVar != null);
            if (zzfkuVar == null) {
                zzfkuVar = null;
            } else if (!queue.isEmpty()) {
                zzfku zzfkuVar2 = (zzfku) queue.peek();
                AdFormat adFormat = AdFormat.getAdFormat(this.zze.zzb);
                String strZzO = zzO(zza(zzfkuVar.zzc()));
                if (zzfkuVar2 != null && adFormat != null && strZzO != null && zzfkuVar2.zzb() < zzfkuVar.zzb()) {
                    zzfkl zzfklVar = this.zzp;
                    ((DefaultClock) this.zzq).getClass();
                    zzfklVar.zzn(System.currentTimeMillis(), this.zze.zzd, zzd(), strZzO, this.zzr, zzD());
                }
            }
            zzw();
            if (zzfkuVar == null) {
                return null;
            }
            return zzfkuVar.zzc();
        } catch (Throwable th) {
            throw th;
        }
    }

    public final String zzn() {
        return this.zzk;
    }

    public final synchronized String zzo() {
        Object objZzj;
        objZzj = zzj();
        return zzO(objZzj == null ? null : zza(objZzj));
    }

    public final void zzv() {
        this.zzi.clear();
    }

    public final synchronized void zzw() {
        ListenableFuture listenableFutureZzb;
        try {
            zzM();
            zzK();
            if (!this.zzl.get() && this.zzf.get() && this.zzi.size() < this.zze.zzd) {
                this.zzl.set(true);
                Activity activityZza = com.google.android.gms.ads.internal.zzv.zza.zzh.zza();
                if (activityZza == null) {
                    String strValueOf = String.valueOf(this.zze.zza);
                    int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                    com.google.android.gms.ads.internal.util.client.zzo.zzj("Empty activity context at preloading: ".concat(strValueOf));
                    listenableFutureZzb = zzb(this.zzb);
                } else {
                    listenableFutureZzb = zzb(activityZza);
                }
                zzgdn.zzr(listenableFutureZzb, new zzfkv(this), this.zzm);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void zzx(int i) {
        com.google.android.gms.common.internal.zzah.checkArgument(i >= 5);
        this.zzj.zzd(i);
    }

    public final synchronized void zzy() {
        this.zzf.set(true);
        this.zzn.set(true);
        this.zzm.submit(new zzfkx(this));
    }

    public final void zzz(zzfkl zzfklVar) {
        this.zzp = zzfklVar;
    }

    public zzfld(String str, ClientApi clientApi, Context context, int i, zzbpq zzbpqVar, com.google.android.gms.ads.internal.client.zzfv zzfvVar, com.google.android.gms.ads.internal.client.zzch zzchVar, ScheduledExecutorService scheduledExecutorService, zzfkg zzfkgVar, Clock clock) {
        this(str, clientApi, context, i, zzbpqVar, zzfvVar, scheduledExecutorService, zzfkgVar, clock);
        this.zzg = zzchVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String zzD() {
        return true != "none".equals(this.zzk) ? "2" : dLDI.RKGIen;
    }

    private zzfld(String str, ClientApi clientApi, Context context, int i, zzbpq zzbpqVar, com.google.android.gms.ads.internal.client.zzfv zzfvVar, ScheduledExecutorService scheduledExecutorService, zzfkg zzfkgVar, Clock clock) {
        this.zzk = str;
        this.zza = clientApi;
        this.zzb = context;
        this.zzc = i;
        this.zzd = zzbpqVar;
        this.zze = zzfvVar;
        this.zzi = new PriorityQueue(Math.max(1, zzfvVar.zzd), new zzfkw(this));
        this.zzf = new AtomicBoolean(true);
        this.zzl = new AtomicBoolean(false);
        this.zzm = scheduledExecutorService;
        this.zzj = zzfkgVar;
        this.zzn = new AtomicBoolean(true);
        this.zzo = new AtomicBoolean(false);
        this.zzq = clock;
        zzfkr zzfkrVar = new zzfkr(zzfvVar.zza, AdFormat.getAdFormat(this.zze.zzb));
        zzfkrVar.zzb(str);
        this.zzr = new zzfkt(zzfkrVar, null);
    }
}
