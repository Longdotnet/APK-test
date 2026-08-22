package com.google.android.gms.internal.ads;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline0;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlinx.coroutines.internal.Jbo.ygoi;

/* JADX INFO: loaded from: classes2.dex */
public final class zzahk extends zzahf {
    public final String zza;
    public final zzfyq zzb;

    public zzahk(String str, String str2, List list) {
        super(str);
        zzdd.zzd(!list.isEmpty());
        this.zza = str2;
        zzfyq zzfyqVarZzl = zzfyq.zzl(list);
        this.zzb = zzfyqVarZzl;
    }

    private static List zzb(String str) {
        ArrayList arrayList = new ArrayList();
        try {
            if (str.length() >= 10) {
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(0, 4))));
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(5, 7))));
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(8, 10))));
            } else if (str.length() >= 7) {
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(0, 4))));
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(5, 7))));
            } else if (str.length() >= 4) {
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(0, 4))));
            }
            return arrayList;
        } catch (NumberFormatException unused) {
            return new ArrayList();
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzahk.class == obj.getClass()) {
            zzahk zzahkVar = (zzahk) obj;
            if (Objects.equals(this.zzf, zzahkVar.zzf) && Objects.equals(this.zza, zzahkVar.zza) && this.zzb.equals(zzahkVar.zzb)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = this.zzf.hashCode() + 527;
        String str = this.zza;
        return this.zzb.hashCode() + (((iHashCode * 31) + (str != null ? str.hashCode() : 0)) * 31);
    }

    @Override // com.google.android.gms.internal.ads.zzahf
    public final String toString() {
        String strValueOf = String.valueOf(this.zzb);
        StringBuilder sb = new StringBuilder();
        sb.append(this.zzf);
        sb.append(": description=");
        return Fragment$$ExternalSyntheticOutline0.m(sb, this.zza, ": values=", strValueOf);
    }

    @Override // com.google.android.gms.internal.ads.zzahf, com.google.android.gms.internal.ads.zzau
    public final void zza(zzar zzarVar) {
        byte b;
        String str = this.zzf;
        switch (str.hashCode()) {
            case 82815:
                b = !str.equals("TAL") ? (byte) -1 : (byte) 6;
                break;
            case 82878:
                b = !str.equals("TCM") ? (byte) -1 : (byte) 16;
                break;
            case 82897:
                b = !str.equals("TDA") ? (byte) -1 : (byte) 12;
                break;
            case 83253:
                b = !str.equals("TP1") ? (byte) -1 : (byte) 2;
                break;
            case 83254:
                b = !str.equals("TP2") ? (byte) -1 : (byte) 4;
                break;
            case 83255:
                b = !str.equals("TP3") ? (byte) -1 : (byte) 18;
                break;
            case 83341:
                b = !str.equals(ygoi.azEJYvAjWyG) ? (byte) -1 : (byte) 8;
                break;
            case 83378:
                b = !str.equals("TT2") ? (byte) -1 : (byte) 0;
                break;
            case 83536:
                b = !str.equals("TXT") ? (byte) -1 : (byte) 20;
                break;
            case 83552:
                b = !str.equals("TYE") ? (byte) -1 : (byte) 10;
                break;
            case 2567331:
                b = !str.equals("TALB") ? (byte) -1 : (byte) 7;
                break;
            case 2569357:
                b = !str.equals("TCOM") ? (byte) -1 : (byte) 17;
                break;
            case 2569358:
                b = !str.equals("TCON") ? (byte) -1 : (byte) 22;
                break;
            case 2569891:
                b = !str.equals("TDAT") ? (byte) -1 : (byte) 13;
                break;
            case 2570401:
                b = !str.equals("TDRC") ? (byte) -1 : (byte) 14;
                break;
            case 2570410:
                b = !str.equals("TDRL") ? (byte) -1 : (byte) 15;
                break;
            case 2571565:
                b = !str.equals("TEXT") ? (byte) -1 : (byte) 21;
                break;
            case 2575251:
                b = !str.equals("TIT2") ? (byte) -1 : (byte) 1;
                break;
            case 2581512:
                b = !str.equals("TPE1") ? (byte) -1 : (byte) 3;
                break;
            case 2581513:
                b = !str.equals("TPE2") ? (byte) -1 : (byte) 5;
                break;
            case 2581514:
                b = !str.equals("TPE3") ? (byte) -1 : (byte) 19;
                break;
            case 2583398:
                b = !str.equals("TRCK") ? (byte) -1 : (byte) 9;
                break;
            case 2590194:
                b = !str.equals("TYER") ? (byte) -1 : (byte) 11;
                break;
            default:
                b = -1;
                break;
        }
        switch (b) {
            case 0:
            case 1:
                zzarVar.zzr((CharSequence) this.zzb.get(0));
                break;
            case 2:
            case 3:
                zzarVar.zze((CharSequence) this.zzb.get(0));
                break;
            case 4:
            case 5:
                zzarVar.zzc((CharSequence) this.zzb.get(0));
                break;
            case 6:
            case 7:
                zzarVar.zzd((CharSequence) this.zzb.get(0));
                break;
            case 8:
            case 9:
                String str2 = (String) this.zzb.get(0);
                String str3 = zzex.zza;
                String[] strArrSplit = str2.split("/", -1);
                try {
                    int i = Integer.parseInt(strArrSplit[0]);
                    Integer numValueOf = strArrSplit.length > 1 ? Integer.valueOf(Integer.parseInt(strArrSplit[1])) : null;
                    zzarVar.zzu(Integer.valueOf(i));
                    zzarVar.zzt(numValueOf);
                } catch (NumberFormatException unused) {
                    return;
                }
                break;
            case 10:
            case 11:
                try {
                    zzarVar.zzm(Integer.valueOf(Integer.parseInt((String) this.zzb.get(0))));
                } catch (NumberFormatException unused2) {
                    return;
                }
                break;
            case 12:
            case 13:
                try {
                    String str4 = (String) this.zzb.get(0);
                    int i2 = Integer.parseInt(str4.substring(2, 4));
                    int i3 = Integer.parseInt(str4.substring(0, 2));
                    zzarVar.zzl(Integer.valueOf(i2));
                    zzarVar.zzk(Integer.valueOf(i3));
                } catch (NumberFormatException | StringIndexOutOfBoundsException unused3) {
                    return;
                }
                break;
            case 14:
                List listZzb = zzb((String) this.zzb.get(0));
                int size = listZzb.size();
                if (size != 1) {
                    if (size != 2) {
                        if (size == 3) {
                            zzarVar.zzk((Integer) listZzb.get(2));
                        }
                    }
                    zzarVar.zzl((Integer) listZzb.get(1));
                }
                zzarVar.zzm((Integer) listZzb.get(0));
                break;
            case 15:
                List listZzb2 = zzb((String) this.zzb.get(0));
                int size2 = listZzb2.size();
                if (size2 != 1) {
                    if (size2 != 2) {
                        if (size2 == 3) {
                            zzarVar.zzn((Integer) listZzb2.get(2));
                        }
                    }
                    zzarVar.zzo((Integer) listZzb2.get(1));
                }
                zzarVar.zzp((Integer) listZzb2.get(0));
                break;
            case 16:
            case 17:
                zzarVar.zzf((CharSequence) this.zzb.get(0));
                break;
            case 18:
            case 19:
                zzarVar.zzg((CharSequence) this.zzb.get(0));
                break;
            case 20:
            case 21:
                zzarVar.zzv((CharSequence) this.zzb.get(0));
                break;
            case 22:
                zzfyq zzfyqVar = this.zzb;
                Integer numZzg = zzgbt.zzg((String) zzfyqVar.get(0), 10);
                if (numZzg != null) {
                    String strZza = zzahg.zza(numZzg.intValue());
                    if (strZza != null) {
                        zzarVar.zzj(strZza);
                    }
                } else {
                    zzarVar.zzj((CharSequence) zzfyqVar.get(0));
                }
                break;
        }
    }
}
