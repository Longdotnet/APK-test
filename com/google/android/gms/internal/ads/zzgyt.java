package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class zzgyt extends zzgys {
    @Override // com.google.android.gms.internal.ads.zzgys
    public final void zza(Object obj) {
        ((zzgzd) obj).zza.zzg();
    }

    @Override // com.google.android.gms.internal.ads.zzgys
    public final void zzb(zzhcm zzhcmVar, Map.Entry entry) {
        zzgze zzgzeVar = (zzgze) entry.getKey();
        if (!zzgzeVar.zzc) {
            zzhck zzhckVar = zzhck.zza;
            switch (zzgzeVar.zzb.ordinal()) {
                case 0:
                    zzhcmVar.zzf(zzgzeVar.zza, ((Double) entry.getValue()).doubleValue());
                    break;
                case 1:
                    zzhcmVar.zzo(zzgzeVar.zza, ((Float) entry.getValue()).floatValue());
                    break;
                case 2:
                    zzhcmVar.zzt(zzgzeVar.zza, ((Long) entry.getValue()).longValue());
                    break;
                case 3:
                    zzhcmVar.zzK(zzgzeVar.zza, ((Long) entry.getValue()).longValue());
                    break;
                case 4:
                    zzhcmVar.zzr(zzgzeVar.zza, ((Integer) entry.getValue()).intValue());
                    break;
                case 5:
                    zzhcmVar.zzm(zzgzeVar.zza, ((Long) entry.getValue()).longValue());
                    break;
                case 6:
                    zzhcmVar.zzk(zzgzeVar.zza, ((Integer) entry.getValue()).intValue());
                    break;
                case 7:
                    zzhcmVar.zzb(zzgzeVar.zza, ((Boolean) entry.getValue()).booleanValue());
                    break;
                case 8:
                    zzhcmVar.zzG(zzgzeVar.zza, (String) entry.getValue());
                    break;
                case 9:
                    zzhcmVar.zzq(zzgzeVar.zza, entry.getValue(), zzhbc.zza().zzb(entry.getValue().getClass()));
                    break;
                case 10:
                    zzhcmVar.zzv(zzgzeVar.zza, entry.getValue(), zzhbc.zza().zzb(entry.getValue().getClass()));
                    break;
                case 11:
                    zzhcmVar.zzd(zzgzeVar.zza, (zzgxz) entry.getValue());
                    break;
                case 12:
                    zzhcmVar.zzI(zzgzeVar.zza, ((Integer) entry.getValue()).intValue());
                    break;
                case 13:
                    zzhcmVar.zzr(zzgzeVar.zza, ((Integer) entry.getValue()).intValue());
                    break;
                case 14:
                    zzhcmVar.zzx(zzgzeVar.zza, ((Integer) entry.getValue()).intValue());
                    break;
                case 15:
                    zzhcmVar.zzz(zzgzeVar.zza, ((Long) entry.getValue()).longValue());
                    break;
                case 16:
                    zzhcmVar.zzB(zzgzeVar.zza, ((Integer) entry.getValue()).intValue());
                    break;
                case 17:
                    zzhcmVar.zzD(zzgzeVar.zza, ((Long) entry.getValue()).longValue());
                    break;
            }
        }
        zzhck zzhckVar2 = zzhck.zza;
        switch (zzgzeVar.zzb.ordinal()) {
            case 0:
                zzhbn.zzt(zzgzeVar.zza, (List) entry.getValue(), zzhcmVar, zzgzeVar.zzd);
                break;
            case 1:
                zzhbn.zzx(zzgzeVar.zza, (List) entry.getValue(), zzhcmVar, zzgzeVar.zzd);
                break;
            case 2:
                zzhbn.zzA(zzgzeVar.zza, (List) entry.getValue(), zzhcmVar, zzgzeVar.zzd);
                break;
            case 3:
                zzhbn.zzI(zzgzeVar.zza, (List) entry.getValue(), zzhcmVar, zzgzeVar.zzd);
                break;
            case 4:
                zzhbn.zzz(zzgzeVar.zza, (List) entry.getValue(), zzhcmVar, zzgzeVar.zzd);
                break;
            case 5:
                zzhbn.zzw(zzgzeVar.zza, (List) entry.getValue(), zzhcmVar, zzgzeVar.zzd);
                break;
            case 6:
                zzhbn.zzv(zzgzeVar.zza, (List) entry.getValue(), zzhcmVar, zzgzeVar.zzd);
                break;
            case 7:
                zzhbn.zzr(zzgzeVar.zza, (List) entry.getValue(), zzhcmVar, zzgzeVar.zzd);
                break;
            case 8:
                zzhbn.zzG(zzgzeVar.zza, (List) entry.getValue(), zzhcmVar);
                break;
            case 9:
                List list = (List) entry.getValue();
                if (list != null && !list.isEmpty()) {
                    zzhbn.zzy(zzgzeVar.zza, (List) entry.getValue(), zzhcmVar, zzhbc.zza().zzb(list.get(0).getClass()));
                    break;
                }
                break;
            case 10:
                List list2 = (List) entry.getValue();
                if (list2 != null && !list2.isEmpty()) {
                    zzhbn.zzB(zzgzeVar.zza, (List) entry.getValue(), zzhcmVar, zzhbc.zza().zzb(list2.get(0).getClass()));
                    break;
                }
                break;
            case 11:
                zzhbn.zzs(zzgzeVar.zza, (List) entry.getValue(), zzhcmVar);
                break;
            case 12:
                zzhbn.zzH(zzgzeVar.zza, (List) entry.getValue(), zzhcmVar, zzgzeVar.zzd);
                break;
            case 13:
                zzhbn.zzz(zzgzeVar.zza, (List) entry.getValue(), zzhcmVar, zzgzeVar.zzd);
                break;
            case 14:
                zzhbn.zzC(zzgzeVar.zza, (List) entry.getValue(), zzhcmVar, zzgzeVar.zzd);
                break;
            case 15:
                zzhbn.zzD(zzgzeVar.zza, (List) entry.getValue(), zzhcmVar, zzgzeVar.zzd);
                break;
            case 16:
                zzhbn.zzE(zzgzeVar.zza, (List) entry.getValue(), zzhcmVar, zzgzeVar.zzd);
                break;
            case 17:
                zzhbn.zzF(zzgzeVar.zza, (List) entry.getValue(), zzhcmVar, zzgzeVar.zzd);
                break;
        }
    }
}
