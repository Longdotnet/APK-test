package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.util.Log;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.google.android.gms.common.util.Hex;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class zzee implements Runnable {
    public final /* synthetic */ int $r8$classId = 0;
    public final int zza;
    public final String zzb;
    public final Object zzc;
    public final Object zzd;
    public final Object zze;
    public final Object zzf;

    public zzee(zzeh zzehVar, int i, String str, Object obj, Object obj2, Object obj3) {
        this.zzf = zzehVar;
        this.zza = i;
        this.zzb = str;
        this.zzc = obj;
        this.zzd = obj2;
        this.zze = obj3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.$r8$classId) {
            case 0:
                zzew zzewVar = ((zzfr) ((zzeh) this.zzf).mBuilder).zzl;
                zzfr.zzP(zzewVar);
                if (!zzewVar.zza) {
                    Log.println(6, ((zzeh) this.zzf).zzq(), "Persisted config not initialized. Not logging error/warn");
                    return;
                }
                zzeh zzehVar = (zzeh) this.zzf;
                if (zzehVar.zza == 0) {
                    zzag zzagVar = ((zzfr) zzehVar.mBuilder).zzk;
                    if (zzagVar.zzc == null) {
                        synchronized (zzagVar) {
                            try {
                                if (zzagVar.zzc == null) {
                                    ApplicationInfo applicationInfo = ((zzfr) zzagVar.mBuilder).zze.getApplicationInfo();
                                    String myProcessName = Hex.getMyProcessName();
                                    if (applicationInfo != null) {
                                        String str = applicationInfo.processName;
                                        zzagVar.zzc = Boolean.valueOf(str != null && str.equals(myProcessName));
                                    }
                                    if (zzagVar.zzc == null) {
                                        zzagVar.zzc = Boolean.TRUE;
                                        zzeh zzehVar2 = ((zzfr) zzagVar.mBuilder).zzm;
                                        zzfr.zzR(zzehVar2);
                                        zzehVar2.zzd.zza("My process not in the list of running processes");
                                    }
                                }
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                    }
                    if (zzagVar.zzc.booleanValue()) {
                        zzeh zzehVar3 = (zzeh) this.zzf;
                        ((zzfr) zzehVar3.mBuilder).getClass();
                        zzehVar3.zza = 'C';
                    } else {
                        zzeh zzehVar4 = (zzeh) this.zzf;
                        ((zzfr) zzehVar4.mBuilder).getClass();
                        zzehVar4.zza = 'c';
                    }
                    break;
                }
                zzeh zzehVar5 = (zzeh) this.zzf;
                if (zzehVar5.zzb < 0) {
                    ((zzfr) zzehVar5.mBuilder).zzk.zzh();
                    zzehVar5.zzb = 74029L;
                }
                char cCharAt = "01VDIWEA?".charAt(this.zza);
                zzeh zzehVar6 = (zzeh) this.zzf;
                char c = zzehVar6.zza;
                long j = zzehVar6.zzb;
                String strZzo = zzeh.zzo(true, this.zzb, this.zzc, this.zzd, this.zze);
                StringBuilder sb = new StringBuilder("2");
                sb.append(cCharAt);
                sb.append(c);
                sb.append(j);
                String strM = CoroutineAdapterKt$$ExternalSyntheticLambda0.m(sb, ":", strZzo);
                if (strM.length() > 1024) {
                    strM = this.zzb.substring(0, 1024);
                }
                zzeu zzeuVar = zzewVar.zzb;
                if (zzeuVar != null) {
                    zzew zzewVar2 = (zzew) zzeuVar.zzb;
                    zzewVar2.zzg();
                    if (((zzew) zzeuVar.zzb).zza().getLong((String) zzeuVar.zza, 0L) == 0) {
                        zzeuVar.zzd();
                    }
                    if (strM == null) {
                        strM = "";
                    }
                    SharedPreferences sharedPreferencesZza = zzewVar2.zza();
                    String str2 = (String) zzeuVar.zzc;
                    long j2 = sharedPreferencesZza.getLong(str2, 0L);
                    String str3 = (String) zzeuVar.zzd;
                    if (j2 <= 0) {
                        SharedPreferences.Editor editorEdit = zzewVar2.zza().edit();
                        editorEdit.putString(str3, strM);
                        editorEdit.putLong(str2, 1L);
                        editorEdit.apply();
                        return;
                    }
                    zzlb zzlbVar = ((zzfr) zzewVar2.mBuilder).zzp;
                    zzfr.zzP(zzlbVar);
                    long jNextLong = zzlbVar.zzG().nextLong();
                    long j3 = j2 + 1;
                    long j4 = Long.MAX_VALUE / j3;
                    SharedPreferences.Editor editorEdit2 = zzewVar2.zza().edit();
                    if ((Long.MAX_VALUE & jNextLong) < j4) {
                        editorEdit2.putString(str3, strM);
                    }
                    editorEdit2.putLong(str2, j3);
                    editorEdit2.apply();
                    return;
                }
                return;
            default:
                ((zzej) this.zzc).zza(this.zzb, this.zza, (IOException) this.zzd, (byte[]) this.zze, (Map) this.zzf);
                return;
        }
    }

    public /* synthetic */ zzee(String str, zzej zzejVar, int i, IOException iOException, byte[] bArr, Map map) {
        com.google.android.gms.common.internal.zzah.checkNotNull(zzejVar);
        this.zzc = zzejVar;
        this.zza = i;
        this.zzd = iOException;
        this.zze = bArr;
        this.zzb = str;
        this.zzf = map;
    }
}
