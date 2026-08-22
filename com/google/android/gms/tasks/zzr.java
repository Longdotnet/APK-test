package com.google.android.gms.tasks;

import android.net.Uri;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzbd;
import com.google.android.gms.ads.internal.util.client.zzo;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.nonagon.signalgeneration.zzau;
import com.google.android.gms.internal.ads.zzbde;
import com.google.android.gms.internal.ads.zzbuf;
import com.google.android.gms.internal.ads.zzfjy;
import com.google.android.gms.internal.ads.zzgdj;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class zzr implements zzgdj {
    public final /* synthetic */ int $r8$classId;
    public final Object zza;
    public Object zzb;
    public boolean zzc;

    public zzr() {
        this.$r8$classId = 0;
        this.zza = new Object();
    }

    public void zza(zzq zzqVar) {
        synchronized (this.zza) {
            try {
                if (((ArrayDeque) this.zzb) == null) {
                    this.zzb = new ArrayDeque();
                }
                ((ArrayDeque) this.zzb).add(zzqVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void zzb(Task task) {
        zzq zzqVar;
        synchronized (this.zza) {
            if (((ArrayDeque) this.zzb) != null && !this.zzc) {
                this.zzc = true;
                while (true) {
                    synchronized (this.zza) {
                        try {
                            zzqVar = (zzq) ((ArrayDeque) this.zzb).poll();
                            if (zzqVar == null) {
                                this.zzc = false;
                                return;
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    zzqVar.zzd(task);
                }
            }
        }
    }

    public zzr(zzau zzauVar, zzbuf zzbufVar, boolean z, int i) {
        this.$r8$classId = i;
        switch (i) {
            case 2:
                this.zza = zzbufVar;
                this.zzc = z;
                Objects.requireNonNull(zzauVar);
                this.zzb = zzauVar;
                break;
            default:
                this.zza = zzbufVar;
                this.zzc = z;
                Objects.requireNonNull(zzauVar);
                this.zzb = zzauVar;
                break;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgdj
    public void zza(Throwable th) {
        Object obj = this.zza;
        switch (this.$r8$classId) {
            case 1:
                try {
                    ((zzbuf) obj).zze("Internal error: " + th.getMessage());
                } catch (RemoteException e) {
                    int i = zze.$r8$clinit;
                    zzo.zzh("", e);
                    return;
                }
                break;
            default:
                try {
                    ((zzbuf) obj).zze("Internal error: " + th.getMessage());
                } catch (RemoteException e2) {
                    int i2 = zze.$r8$clinit;
                    zzo.zzh("", e2);
                }
                break;
        }
    }

    /* JADX WARN: Code duplicated, block: B:21:0x004b A[Catch: RemoteException -> 0x003f, TRY_LEAVE, TryCatch #1 {RemoteException -> 0x003f, blocks: (B:5:0x000e, B:6:0x0016, B:8:0x001c, B:10:0x002c, B:11:0x0031, B:13:0x003a, B:18:0x0041, B:19:0x0045, B:21:0x004b, B:24:0x005d, B:25:0x006b, B:27:0x007d), top: B:54:0x000e }] */
    /* JADX WARN: Code duplicated, block: B:60:0x006b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:61:0x005d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:62:0x007d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:64:0x0045 A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.ads.zzgdj
    public void zzb(Object obj) {
        boolean zZzX;
        zzfjy zzfjyVar;
        Object obj2 = this.zza;
        switch (this.$r8$classId) {
            case 1:
                ArrayList<Uri> arrayList = (ArrayList) obj;
                try {
                    ((zzbuf) obj2).zzf(arrayList);
                    zzau zzauVar = (zzau) this.zzb;
                    if (!zzauVar.zzr && !this.zzc) {
                    }
                    for (Uri uri : arrayList) {
                        boolean zZzX2 = zzau.zzX(uri, zzauVar.zzD, zzauVar.zzE);
                        zzfjy zzfjyVar2 = zzauVar.zzq;
                        if (zZzX2) {
                            zzfjyVar2.zzd(zzau.zzaa(zzauVar.zzA, uri, "1").toString(), null, null, null);
                        } else {
                            if (((Boolean) zzbd.zza.zzd.zzb(zzbde.zzhJ)).booleanValue()) {
                                zzfjyVar2.zzd(uri.toString(), null, null, null);
                            }
                        }
                        break;
                    }
                } catch (RemoteException e) {
                    int i = zze.$r8$clinit;
                    zzo.zzh("", e);
                    return;
                }
                break;
            default:
                List<Uri> list = (List) obj;
                try {
                    zzau zzauVar2 = (zzau) this.zzb;
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        if (zzau.zzX((Uri) it.next(), zzauVar2.zzB, zzauVar2.zzC)) {
                            zzauVar2.zzx.getAndIncrement();
                            ((zzbuf) obj2).zzf(list);
                            if (!zzauVar2.zzs && !this.zzc) {
                            }
                            for (Uri uri2 : list) {
                                zZzX = zzau.zzX(uri2, zzauVar2.zzB, zzauVar2.zzC);
                                zzfjyVar = zzauVar2.zzq;
                                if (zZzX) {
                                    zzfjyVar.zzd(zzau.zzaa(zzauVar2.zzA, uri2, "1").toString(), null, null, null);
                                } else {
                                    if (((Boolean) zzbd.zza.zzd.zzb(zzbde.zzhJ)).booleanValue()) {
                                        zzfjyVar.zzd(uri2.toString(), null, null, null);
                                    }
                                }
                                break;
                            }
                            break;
                        }
                    }
                    ((zzbuf) obj2).zzf(list);
                    if (!zzauVar2.zzs) {
                    }
                    while (r10.hasNext()) {
                        zZzX = zzau.zzX(uri2, zzauVar2.zzB, zzauVar2.zzC);
                        zzfjyVar = zzauVar2.zzq;
                        if (zZzX) {
                            zzfjyVar.zzd(zzau.zzaa(zzauVar2.zzA, uri2, "1").toString(), null, null, null);
                        } else {
                            if (((Boolean) zzbd.zza.zzd.zzb(zzbde.zzhJ)).booleanValue()) {
                                zzfjyVar.zzd(uri2.toString(), null, null, null);
                            }
                        }
                        break;
                    }
                } catch (RemoteException e2) {
                    int i2 = zze.$r8$clinit;
                    zzo.zzh("", e2);
                }
                break;
        }
    }
}
