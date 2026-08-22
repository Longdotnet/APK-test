package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Binder;
import android.os.Bundle;
import android.os.Parcel;
import android.text.TextUtils;
import androidx.work.impl.WorkerWrapper;
import com.android.billingclient.api.zzaz;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.GoogleSignatureVerifier;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.util.Hex;
import com.google.android.gms.internal.measurement.zzbn;
import com.google.android.gms.internal.measurement.zzbo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes.dex */
public final class zzgj extends zzbn implements zzdx {
    public final zzkt zza;
    public Boolean zzb;
    public String zzc;

    public zzgj(zzkt zzktVar) {
        super("com.google.android.gms.measurement.internal.IMeasurementService");
        com.google.android.gms.common.internal.zzah.checkNotNull(zzktVar);
        this.zza = zzktVar;
        this.zzc = null;
    }

    public final void zzA(zzaw zzawVar, zzq zzqVar) {
        zzkt zzktVar = this.zza;
        zzktVar.zzA$1();
        zzktVar.zzE(zzawVar, zzqVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzbn
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) {
        ArrayList arrayList;
        switch (i) {
            case 1:
                zzaw zzawVar = (zzaw) zzbo.zza(parcel, zzaw.CREATOR);
                zzq zzqVar = (zzq) zzbo.zza(parcel, zzq.CREATOR);
                zzbo.zzc(parcel);
                zzk(zzawVar, zzqVar);
                parcel2.writeNoException();
                return true;
            case 2:
                zzkw zzkwVar = (zzkw) zzbo.zza(parcel, zzkw.CREATOR);
                zzq zzqVar2 = (zzq) zzbo.zza(parcel, zzq.CREATOR);
                zzbo.zzc(parcel);
                zzt(zzkwVar, zzqVar2);
                parcel2.writeNoException();
                return true;
            case 3:
            case 8:
            default:
                return false;
            case 4:
                zzq zzqVar3 = (zzq) zzbo.zza(parcel, zzq.CREATOR);
                zzbo.zzc(parcel);
                zzj(zzqVar3);
                parcel2.writeNoException();
                return true;
            case 5:
                zzaw zzawVar2 = (zzaw) zzbo.zza(parcel, zzaw.CREATOR);
                String string = parcel.readString();
                parcel.readString();
                zzbo.zzc(parcel);
                com.google.android.gms.common.internal.zzah.checkNotNull(zzawVar2);
                com.google.android.gms.common.internal.zzah.checkNotEmpty(string);
                zzz(string, true);
                zzx(new WorkerWrapper.AnonymousClass1(this, zzawVar2, string, 19));
                parcel2.writeNoException();
                return true;
            case 6:
                zzq zzqVar4 = (zzq) zzbo.zza(parcel, zzq.CREATOR);
                zzbo.zzc(parcel);
                zzs(zzqVar4);
                parcel2.writeNoException();
                return true;
            case 7:
                zzq zzqVar5 = (zzq) zzbo.zza(parcel, zzq.CREATOR);
                boolean zZzg = zzbo.zzg(parcel);
                zzbo.zzc(parcel);
                zzy(zzqVar5);
                String str = zzqVar5.zza;
                com.google.android.gms.common.internal.zzah.checkNotNull(str);
                zzkt zzktVar = this.zza;
                try {
                    List<zzky> list = (List) zzktVar.zzaz().zzh(new com.google.android.gms.ads.internal.zzh(this, str, 4)).get();
                    arrayList = new ArrayList(list.size());
                    for (zzky zzkyVar : list) {
                        if (zZzg || !zzlb.zzah(zzkyVar.zzc)) {
                            arrayList.add(new zzkw(zzkyVar));
                        }
                        break;
                    }
                } catch (InterruptedException e) {
                    e = e;
                    zzeh zzehVarZzay = zzktVar.zzay();
                    zzehVarZzay.zzd.zzc(zzeh.zzn(str), "Failed to get user properties. appId", e);
                    arrayList = null;
                } catch (ExecutionException e2) {
                    e = e2;
                    zzeh zzehVarZzay2 = zzktVar.zzay();
                    zzehVarZzay2.zzd.zzc(zzeh.zzn(str), "Failed to get user properties. appId", e);
                    arrayList = null;
                }
                parcel2.writeNoException();
                parcel2.writeTypedList(arrayList);
                return true;
            case 9:
                zzaw zzawVar3 = (zzaw) zzbo.zza(parcel, zzaw.CREATOR);
                String string2 = parcel.readString();
                zzbo.zzc(parcel);
                byte[] bArrZzu = zzu(zzawVar3, string2);
                parcel2.writeNoException();
                parcel2.writeByteArray(bArrZzu);
                return true;
            case 10:
                long j = parcel.readLong();
                String string3 = parcel.readString();
                String string4 = parcel.readString();
                String string5 = parcel.readString();
                zzbo.zzc(parcel);
                zzq(string3, string4, j, string5);
                parcel2.writeNoException();
                return true;
            case 11:
                zzq zzqVar6 = (zzq) zzbo.zza(parcel, zzq.CREATOR);
                zzbo.zzc(parcel);
                String strZzd = zzd(zzqVar6);
                parcel2.writeNoException();
                parcel2.writeString(strZzd);
                return true;
            case 12:
                zzac zzacVar = (zzac) zzbo.zza(parcel, zzac.CREATOR);
                zzq zzqVar7 = (zzq) zzbo.zza(parcel, zzq.CREATOR);
                zzbo.zzc(parcel);
                zzn(zzacVar, zzqVar7);
                parcel2.writeNoException();
                return true;
            case 13:
                zzac zzacVar2 = (zzac) zzbo.zza(parcel, zzac.CREATOR);
                zzbo.zzc(parcel);
                com.google.android.gms.common.internal.zzah.checkNotNull(zzacVar2);
                com.google.android.gms.common.internal.zzah.checkNotNull(zzacVar2.zzc);
                com.google.android.gms.common.internal.zzah.checkNotEmpty(zzacVar2.zza);
                zzz(zzacVar2.zza, true);
                zzx(new com.google.android.gms.tasks.zzc(this, new zzac(zzacVar2), 1));
                parcel2.writeNoException();
                return true;
            case 14:
                String string6 = parcel.readString();
                String string7 = parcel.readString();
                boolean zZzg2 = zzbo.zzg(parcel);
                zzq zzqVar8 = (zzq) zzbo.zza(parcel, zzq.CREATOR);
                zzbo.zzc(parcel);
                List listZzh = zzh(string6, string7, zZzg2, zzqVar8);
                parcel2.writeNoException();
                parcel2.writeTypedList(listZzh);
                return true;
            case 15:
                String string8 = parcel.readString();
                String string9 = parcel.readString();
                String string10 = parcel.readString();
                boolean zZzg3 = zzbo.zzg(parcel);
                zzbo.zzc(parcel);
                List listZzi = zzi(string8, string9, string10, zZzg3);
                parcel2.writeNoException();
                parcel2.writeTypedList(listZzi);
                return true;
            case 16:
                String string11 = parcel.readString();
                String string12 = parcel.readString();
                zzq zzqVar9 = (zzq) zzbo.zza(parcel, zzq.CREATOR);
                zzbo.zzc(parcel);
                List listZzf = zzf(string11, string12, zzqVar9);
                parcel2.writeNoException();
                parcel2.writeTypedList(listZzf);
                return true;
            case 17:
                String string13 = parcel.readString();
                String string14 = parcel.readString();
                String string15 = parcel.readString();
                zzbo.zzc(parcel);
                List listZzg = zzg(string13, string14, string15);
                parcel2.writeNoException();
                parcel2.writeTypedList(listZzg);
                return true;
            case 18:
                zzq zzqVar10 = (zzq) zzbo.zza(parcel, zzq.CREATOR);
                zzbo.zzc(parcel);
                zzm(zzqVar10);
                parcel2.writeNoException();
                return true;
            case 19:
                Bundle bundle = (Bundle) zzbo.zza(parcel, Bundle.CREATOR);
                zzq zzqVar11 = (zzq) zzbo.zza(parcel, zzq.CREATOR);
                zzbo.zzc(parcel);
                zzr(bundle, zzqVar11);
                parcel2.writeNoException();
                return true;
            case 20:
                zzq zzqVar12 = (zzq) zzbo.zza(parcel, zzq.CREATOR);
                zzbo.zzc(parcel);
                zzp(zzqVar12);
                parcel2.writeNoException();
                return true;
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzdx
    public final String zzd(zzq zzqVar) {
        zzy(zzqVar);
        zzkt zzktVar = this.zza;
        try {
            return (String) zzktVar.zzaz().zzh(new com.google.android.gms.ads.internal.zzh(zzktVar, zzqVar, 5)).get(30000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            zzeh zzehVarZzay = zzktVar.zzay();
            zzehVarZzay.zzd.zzc(zzeh.zzn(zzqVar.zza), "Failed to get app instance id. appId", e);
            return null;
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzdx
    public final List zzf(String str, String str2, zzq zzqVar) {
        zzy(zzqVar);
        String str3 = zzqVar.zza;
        com.google.android.gms.common.internal.zzah.checkNotNull(str3);
        zzkt zzktVar = this.zza;
        try {
            return (List) zzktVar.zzaz().zzh(new com.android.billingclient.api.zzac(this, str3, str, str2, 3)).get();
        } catch (InterruptedException | ExecutionException e) {
            zzktVar.zzay().zzd.zzb(e, "Failed to get conditional user properties");
            return Collections.emptyList();
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzdx
    public final List zzg(String str, String str2, String str3) {
        zzz(str, true);
        zzkt zzktVar = this.zza;
        try {
            return (List) zzktVar.zzaz().zzh(new com.android.billingclient.api.zzac(this, str, str2, str3, 4)).get();
        } catch (InterruptedException | ExecutionException e) {
            zzktVar.zzay().zzd.zzb(e, "Failed to get conditional user properties as");
            return Collections.emptyList();
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzdx
    public final List zzh(String str, String str2, boolean z, zzq zzqVar) {
        zzy(zzqVar);
        String str3 = zzqVar.zza;
        com.google.android.gms.common.internal.zzah.checkNotNull(str3);
        zzkt zzktVar = this.zza;
        try {
            List<zzky> list = (List) zzktVar.zzaz().zzh(new com.android.billingclient.api.zzac(this, str3, str, str2, 1)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (zzky zzkyVar : list) {
                if (z || !zzlb.zzah(zzkyVar.zzc)) {
                    arrayList.add(new zzkw(zzkyVar));
                }
            }
            return arrayList;
        } catch (InterruptedException e) {
            e = e;
            zzeh zzehVarZzay = zzktVar.zzay();
            zzehVarZzay.zzd.zzc(zzeh.zzn(str3), "Failed to query user properties. appId", e);
            return Collections.emptyList();
        } catch (ExecutionException e2) {
            e = e2;
            zzeh zzehVarZzay2 = zzktVar.zzay();
            zzehVarZzay2.zzd.zzc(zzeh.zzn(str3), "Failed to query user properties. appId", e);
            return Collections.emptyList();
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzdx
    public final List zzi(String str, String str2, String str3, boolean z) {
        zzz(str, true);
        zzkt zzktVar = this.zza;
        try {
            List<zzky> list = (List) zzktVar.zzaz().zzh(new com.android.billingclient.api.zzac(this, str, str2, str3, 2)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (zzky zzkyVar : list) {
                if (z || !zzlb.zzah(zzkyVar.zzc)) {
                    arrayList.add(new zzkw(zzkyVar));
                }
            }
            return arrayList;
        } catch (InterruptedException e) {
            e = e;
            zzeh zzehVarZzay = zzktVar.zzay();
            zzehVarZzay.zzd.zzc(zzeh.zzn(str), "Failed to get user properties as. appId", e);
            return Collections.emptyList();
        } catch (ExecutionException e2) {
            e = e2;
            zzeh zzehVarZzay2 = zzktVar.zzay();
            zzehVarZzay2.zzd.zzc(zzeh.zzn(str), "Failed to get user properties as. appId", e);
            return Collections.emptyList();
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzdx
    public final void zzj(zzq zzqVar) {
        zzy(zzqVar);
        zzx(new zzfz(this, zzqVar, 3));
    }

    @Override // com.google.android.gms.measurement.internal.zzdx
    public final void zzk(zzaw zzawVar, zzq zzqVar) {
        com.google.android.gms.common.internal.zzah.checkNotNull(zzawVar);
        zzy(zzqVar);
        zzx(new WorkerWrapper.AnonymousClass1(this, zzawVar, zzqVar, 18));
    }

    @Override // com.google.android.gms.measurement.internal.zzdx
    public final void zzm(zzq zzqVar) {
        com.google.android.gms.common.internal.zzah.checkNotEmpty(zzqVar.zza);
        zzz(zzqVar.zza, false);
        zzx(new zzfz(this, zzqVar, 0));
    }

    @Override // com.google.android.gms.measurement.internal.zzdx
    public final void zzn(zzac zzacVar, zzq zzqVar) {
        com.google.android.gms.common.internal.zzah.checkNotNull(zzacVar);
        com.google.android.gms.common.internal.zzah.checkNotNull(zzacVar.zzc);
        zzy(zzqVar);
        zzac zzacVar2 = new zzac(zzacVar);
        zzacVar2.zza = zzqVar.zza;
        zzx(new WorkerWrapper.AnonymousClass1(this, zzacVar2, zzqVar, 17));
    }

    @Override // com.google.android.gms.measurement.internal.zzdx
    public final void zzp(zzq zzqVar) {
        com.google.android.gms.common.internal.zzah.checkNotEmpty(zzqVar.zza);
        com.google.android.gms.common.internal.zzah.checkNotNull(zzqVar.zzv);
        zzfz zzfzVar = new zzfz(this, zzqVar, 2);
        zzkt zzktVar = this.zza;
        if (zzktVar.zzaz().zzs()) {
            zzfzVar.run();
        } else {
            zzktVar.zzaz().zzq(zzfzVar);
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzdx
    public final void zzq(String str, String str2, long j, String str3) {
        zzx(new zzgi(this, str2, str3, str, j, 0));
    }

    @Override // com.google.android.gms.measurement.internal.zzdx
    public final void zzr(Bundle bundle, zzq zzqVar) {
        zzy(zzqVar);
        String str = zzqVar.zza;
        com.google.android.gms.common.internal.zzah.checkNotNull(str);
        zzx(new WorkerWrapper.AnonymousClass1(this, str, bundle, 16, false));
    }

    @Override // com.google.android.gms.measurement.internal.zzdx
    public final void zzs(zzq zzqVar) {
        zzy(zzqVar);
        zzx(new zzfz(this, zzqVar, 1));
    }

    @Override // com.google.android.gms.measurement.internal.zzdx
    public final void zzt(zzkw zzkwVar, zzq zzqVar) {
        com.google.android.gms.common.internal.zzah.checkNotNull(zzkwVar);
        zzy(zzqVar);
        zzx(new WorkerWrapper.AnonymousClass1(this, zzkwVar, zzqVar, 20));
    }

    @Override // com.google.android.gms.measurement.internal.zzdx
    public final byte[] zzu(zzaw zzawVar, String str) {
        com.google.android.gms.common.internal.zzah.checkNotEmpty(str);
        com.google.android.gms.common.internal.zzah.checkNotNull(zzawVar);
        zzz(str, true);
        zzkt zzktVar = this.zza;
        zzeh zzehVarZzay = zzktVar.zzay();
        zzfr zzfrVar = zzktVar.zzn;
        zzec zzecVar = zzfrVar.zzq;
        String str2 = zzawVar.zza;
        zzehVarZzay.zzk.zzb(zzecVar.zzd(str2), "Log and bundle. event");
        ((DefaultClock) zzktVar.zzav()).getClass();
        long jNanoTime = System.nanoTime() / 1000000;
        zzfo zzfoVarZzaz = zzktVar.zzaz();
        zzaz zzazVar = new zzaz(this, zzawVar, str);
        zzfoVarZzaz.zzu();
        zzfm zzfmVar = new zzfm(zzfoVarZzaz, zzazVar, true);
        if (Thread.currentThread() == zzfoVarZzaz.zzb) {
            zzfmVar.run();
        } else {
            zzfoVarZzaz.zzt(zzfmVar);
        }
        try {
            byte[] bArr = (byte[]) zzfmVar.get();
            if (bArr == null) {
                zzktVar.zzay().zzd.zzb(zzeh.zzn(str), "Log and bundle returned null. appId");
                bArr = new byte[0];
            }
            ((DefaultClock) zzktVar.zzav()).getClass();
            zzktVar.zzay().zzk.zzd("Log and bundle processed. event, size, time_ms", zzfrVar.zzq.zzd(str2), Integer.valueOf(bArr.length), Long.valueOf((System.nanoTime() / 1000000) - jNanoTime));
            return bArr;
        } catch (InterruptedException e) {
            e = e;
            zzeh zzehVarZzay2 = zzktVar.zzay();
            zzehVarZzay2.zzd.zzd("Failed to log and bundle. appId, event, error", zzeh.zzn(str), zzfrVar.zzq.zzd(str2), e);
            return null;
        } catch (ExecutionException e2) {
            e = e2;
            zzeh zzehVarZzay3 = zzktVar.zzay();
            zzehVarZzay3.zzd.zzd("Failed to log and bundle. appId, event, error", zzeh.zzn(str), zzfrVar.zzq.zzd(str2), e);
            return null;
        }
    }

    public final void zzx(Runnable runnable) {
        zzkt zzktVar = this.zza;
        if (zzktVar.zzaz().zzs()) {
            runnable.run();
        } else {
            zzktVar.zzaz().zzp(runnable);
        }
    }

    public final void zzy(zzq zzqVar) {
        com.google.android.gms.common.internal.zzah.checkNotNull(zzqVar);
        String str = zzqVar.zza;
        com.google.android.gms.common.internal.zzah.checkNotEmpty(str);
        zzz(str, false);
        this.zza.zzv().zzX(zzqVar.zzb, zzqVar.zzq);
    }

    public final void zzz(String str, boolean z) {
        boolean zIsEmpty = TextUtils.isEmpty(str);
        zzkt zzktVar = this.zza;
        if (zIsEmpty) {
            zzktVar.zzay().zzd.zza("Measurement Service called without app package");
            throw new SecurityException("Measurement Service called without app package");
        }
        if (z) {
            try {
                if (this.zzb == null) {
                    boolean z2 = true;
                    if (!"com.google.android.gms".equals(this.zzc) && !Hex.isGooglePlayServicesUid(zzktVar.zzn.zze, Binder.getCallingUid()) && !GoogleSignatureVerifier.getInstance(zzktVar.zzn.zze).isUidGoogleSigned(Binder.getCallingUid())) {
                        z2 = false;
                    }
                    this.zzb = Boolean.valueOf(z2);
                }
                if (this.zzb.booleanValue()) {
                    return;
                }
            } catch (SecurityException e) {
                zzktVar.zzay().zzd.zzb(zzeh.zzn(str), "Measurement Service called with invalid calling package. appId");
                throw e;
            }
        }
        if (this.zzc == null) {
            Context context = zzktVar.zzn.zze;
            int callingUid = Binder.getCallingUid();
            int i = GooglePlayServicesUtil.$r8$clinit;
            if (Hex.uidHasPackageName(context, str, callingUid)) {
                this.zzc = str;
            }
        }
        if (str.equals(this.zzc)) {
            return;
        }
        throw new SecurityException("Unknown calling package name '" + str + "'.");
    }
}
