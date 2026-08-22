package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.JsonReader;
import androidx.emoji2.text.flatbuffer.bs.bUqMCsuPSX;
import com.google.android.gms.ads.RequestConfiguration;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class zzdtr extends zzblg {
    private final zzdtu zza;
    private final zzdtp zzb;
    private final Map zzc = new HashMap();

    public zzdtr(zzdtu zzdtuVar, zzdtp zzdtpVar) {
        this.zza = zzdtuVar;
        this.zzb = zzdtpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzblh
    public final void zze() {
        this.zzc.clear();
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0066  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.google.android.gms.internal.ads.zzblh
    public final void zzf(String str) {
        byte b;
        zzbcv zzbcvVar = zzbde.zzkr;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.zza;
        if (((Boolean) zzbdVar.zzd.zzb(zzbcvVar)).booleanValue()) {
            com.google.android.gms.ads.internal.util.zze.zza("Received H5 gmsg: ".concat(String.valueOf(str)));
            Uri uri = Uri.parse(str);
            com.google.android.gms.ads.internal.util.zzs zzsVar = com.google.android.gms.ads.internal.zzv.zza.zzd;
            HashMap mapZzQ = com.google.android.gms.ads.internal.util.zzs.zzQ(uri);
            String str2 = (String) mapZzQ.get("action");
            if (TextUtils.isEmpty(str2)) {
                com.google.android.gms.ads.internal.util.client.zzo.zze("H5 gmsg did not contain an action");
                return;
            }
            int iHashCode = str2.hashCode();
            byte b2 = -1;
            if (iHashCode != 579053441) {
                if (iHashCode == 871091088 && str2.equals("initialize")) {
                    b = 0;
                } else {
                    b = -1;
                }
            } else if (str2.equals("dispose_all")) {
                b = 1;
            } else {
                b = -1;
            }
            if (b == 0) {
                this.zzc.clear();
                this.zzb.zza();
                return;
            }
            if (b == 1) {
                Map map = this.zzc;
                Iterator it = map.values().iterator();
                while (it.hasNext()) {
                    ((zzdtk) it.next()).zza();
                }
                map.clear();
                return;
            }
            String str3 = (String) mapZzQ.get("obj_id");
            try {
                Objects.requireNonNull(str3);
                long j = Long.parseLong(str3);
                switch (str2.hashCode()) {
                    case -1790951212:
                        if (str2.equals("show_interstitial_ad")) {
                            b2 = 2;
                        }
                        break;
                    case -1266374734:
                        if (str2.equals("show_rewarded_ad")) {
                            b2 = 5;
                        }
                        break;
                    case -257098725:
                        if (str2.equals("load_rewarded_ad")) {
                            b2 = 4;
                        }
                        break;
                    case 393881811:
                        if (str2.equals("create_interstitial_ad")) {
                            b2 = 0;
                        }
                        break;
                    case 585513149:
                        if (str2.equals("load_interstitial_ad")) {
                            b2 = 1;
                        }
                        break;
                    case 1671767583:
                        if (str2.equals("dispose")) {
                            b2 = 6;
                        }
                        break;
                    case 2109237041:
                        if (str2.equals("create_rewarded_ad")) {
                            b2 = 3;
                        }
                        break;
                }
                zzbdc zzbdcVar = zzbdVar.zzd;
                switch (b2) {
                    case 0:
                        Map map2 = this.zzc;
                        if (map2.size() < ((Integer) zzbdcVar.zzb(zzbde.zzks)).intValue()) {
                            Long lValueOf = Long.valueOf(j);
                            if (!map2.containsKey(lValueOf)) {
                                String str4 = (String) mapZzQ.get("ad_unit");
                                if (!TextUtils.isEmpty(str4)) {
                                    zzdtl zzdtlVarZzb = this.zza.zzb();
                                    zzdtlVarZzb.zzb(j);
                                    zzdtlVarZzb.zza(str4);
                                    map2.put(lValueOf, zzdtlVarZzb.zzc().zza());
                                    this.zzb.zzh(j);
                                    com.google.android.gms.ads.internal.util.zze.zza("Created H5 interstitial #" + j + " with ad unit " + str4);
                                } else {
                                    com.google.android.gms.ads.internal.util.client.zzo.zzj("Could not create H5 ad, missing ad unit id");
                                    this.zzb.zzi(j);
                                }
                            } else {
                                com.google.android.gms.ads.internal.util.client.zzo.zze("Could not create H5 ad, object ID already exists");
                                this.zzb.zzi(j);
                            }
                        } else {
                            com.google.android.gms.ads.internal.util.client.zzo.zzj("Could not create H5 ad, too many existing objects");
                            this.zzb.zzi(j);
                        }
                        break;
                    case 1:
                        zzdtk zzdtkVar = (zzdtk) this.zzc.get(Long.valueOf(j));
                        if (zzdtkVar != null) {
                            zzdtkVar.zzb(zzc(mapZzQ));
                        } else {
                            com.google.android.gms.ads.internal.util.client.zzo.zze("Could not load H5 ad, object ID does not exist");
                            this.zzb.zzf(j);
                        }
                        break;
                    case 2:
                        zzdtk zzdtkVar2 = (zzdtk) this.zzc.get(Long.valueOf(j));
                        if (zzdtkVar2 != null) {
                            zzdtkVar2.zzc();
                        } else {
                            com.google.android.gms.ads.internal.util.client.zzo.zze("Could not show H5 ad, object ID does not exist");
                            this.zzb.zzf(j);
                        }
                        break;
                    case 3:
                        Map map3 = this.zzc;
                        if (map3.size() < ((Integer) zzbdcVar.zzb(zzbde.zzks)).intValue()) {
                            Long lValueOf2 = Long.valueOf(j);
                            if (!map3.containsKey(lValueOf2)) {
                                String str5 = (String) mapZzQ.get("ad_unit");
                                if (!TextUtils.isEmpty(str5)) {
                                    zzdtl zzdtlVarZzb2 = this.zza.zzb();
                                    zzdtlVarZzb2.zzb(j);
                                    zzdtlVarZzb2.zza(str5);
                                    map3.put(lValueOf2, zzdtlVarZzb2.zzc().zzb());
                                    this.zzb.zzh(j);
                                    com.google.android.gms.ads.internal.util.zze.zza("Created H5 rewarded #" + j + " with ad unit " + str5);
                                } else {
                                    com.google.android.gms.ads.internal.util.client.zzo.zzj("Could not create H5 ad, missing ad unit id");
                                    this.zzb.zzi(j);
                                }
                            } else {
                                com.google.android.gms.ads.internal.util.client.zzo.zze("Could not create H5 ad, object ID already exists");
                                this.zzb.zzi(j);
                            }
                        } else {
                            com.google.android.gms.ads.internal.util.client.zzo.zzj("Could not create H5 ad, too many existing objects");
                            this.zzb.zzi(j);
                        }
                        break;
                    case 4:
                        zzdtk zzdtkVar3 = (zzdtk) this.zzc.get(Long.valueOf(j));
                        if (zzdtkVar3 != null) {
                            zzdtkVar3.zzb(zzc(mapZzQ));
                        } else {
                            com.google.android.gms.ads.internal.util.client.zzo.zze("Could not load H5 ad, object ID does not exist");
                            this.zzb.zzq(j);
                        }
                        break;
                    case 5:
                        zzdtk zzdtkVar4 = (zzdtk) this.zzc.get(Long.valueOf(j));
                        if (zzdtkVar4 != null) {
                            zzdtkVar4.zzc();
                        } else {
                            com.google.android.gms.ads.internal.util.client.zzo.zze("Could not show H5 ad, object ID does not exist");
                            this.zzb.zzq(j);
                        }
                        break;
                    case 6:
                        Map map4 = this.zzc;
                        Long lValueOf3 = Long.valueOf(j);
                        zzdtk zzdtkVar5 = (zzdtk) map4.get(lValueOf3);
                        if (zzdtkVar5 != null) {
                            zzdtkVar5.zza();
                            map4.remove(lValueOf3);
                            com.google.android.gms.ads.internal.util.zze.zza("Disposed H5 ad #" + j);
                        } else {
                            com.google.android.gms.ads.internal.util.client.zzo.zze("Could not dispose H5 ad, object ID does not exist");
                        }
                        break;
                    default:
                        com.google.android.gms.ads.internal.util.client.zzo.zze("H5 gmsg contained invalid action: ".concat(str2));
                        break;
                }
            } catch (NullPointerException | NumberFormatException unused) {
                com.google.android.gms.ads.internal.util.client.zzo.zze("H5 gmsg did not contain a valid object id: ".concat(String.valueOf(str3)));
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:36:0x00d4  */
    private static com.google.android.gms.ads.internal.client.zzm zzc(Map map) {
        int i;
        byte b;
        Bundle bundle = new Bundle();
        ArrayList arrayList = new ArrayList();
        Bundle bundle2 = new Bundle();
        Bundle bundle3 = new Bundle();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        String str = (String) map.get("ad_request");
        boolean zNextBoolean = false;
        int i2 = -1;
        String str2 = null;
        int iNextInt = 60000;
        if (str == null) {
            return new com.google.android.gms.ads.internal.client.zzm(8, -1L, bundle, -1, arrayList, false, -1, false, null, null, null, null, bundle2, bundle3, arrayList2, null, null, false, null, -1, null, arrayList3, 60000, null, 0, 0L, 0L);
        }
        JsonReader jsonReader = new JsonReader(new StringReader(Uri.decode(str)));
        try {
            jsonReader.beginObject();
            i = -1;
            while (jsonReader.hasNext()) {
                try {
                    String strNextName = jsonReader.nextName();
                    switch (strNextName.hashCode()) {
                        case -1289032093:
                            if (!strNextName.equals("extras")) {
                                b = -1;
                            } else {
                                b = 0;
                            }
                            break;
                        case -839117230:
                            if (!strNextName.equals("isTestDevice")) {
                                b = -1;
                            } else {
                                b = 2;
                            }
                            break;
                        case -733436947:
                            if (!strNextName.equals("tagForUnderAgeOfConsent")) {
                                b = -1;
                            } else {
                                b = 4;
                            }
                            break;
                        case -99890337:
                            if (!strNextName.equals(bUqMCsuPSX.mOYWuLXiqeFRcYV)) {
                                b = -1;
                            } else {
                                b = 6;
                            }
                            break;
                        case 523149226:
                            if (!strNextName.equals("keywords")) {
                                b = -1;
                            } else {
                                b = 1;
                            }
                            break;
                        case 597632527:
                            if (!strNextName.equals("maxAdContentRating")) {
                                b = -1;
                            } else {
                                b = 5;
                            }
                            break;
                        case 1411582723:
                            if (!strNextName.equals("tagForChildDirectedTreatment")) {
                                b = -1;
                            } else {
                                b = 3;
                            }
                            break;
                        default:
                            b = -1;
                            break;
                    }
                    switch (b) {
                        case 0:
                            jsonReader.beginObject();
                            Bundle bundle4 = new Bundle();
                            while (jsonReader.hasNext()) {
                                bundle4.putString(jsonReader.nextName(), jsonReader.nextString());
                            }
                            jsonReader.endObject();
                            bundle = bundle4;
                            break;
                        case 1:
                            jsonReader.beginArray();
                            ArrayList arrayList4 = new ArrayList();
                            while (jsonReader.hasNext()) {
                                arrayList4.add(jsonReader.nextString());
                            }
                            jsonReader.endArray();
                            arrayList = arrayList4;
                            break;
                        case 2:
                            zNextBoolean = jsonReader.nextBoolean();
                            break;
                        case 3:
                            i2 = !jsonReader.nextBoolean() ? 0 : 1;
                            break;
                        case 4:
                            i = !jsonReader.nextBoolean() ? 0 : 1;
                            break;
                        case 5:
                            String strNextString = jsonReader.nextString();
                            if (RequestConfiguration.zza.contains(strNextString)) {
                                str2 = strNextString;
                            }
                            break;
                        case 6:
                            iNextInt = jsonReader.nextInt();
                            break;
                        default:
                            jsonReader.skipValue();
                            break;
                    }
                } catch (IOException unused) {
                    int i3 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                    com.google.android.gms.ads.internal.util.client.zzo.zze("Ad Request json was malformed, parsing ended early.");
                }
            }
            jsonReader.endObject();
        } catch (IOException unused2) {
            i = -1;
        }
        com.google.android.gms.ads.internal.client.zzm zzmVar = new com.google.android.gms.ads.internal.client.zzm(8, -1L, bundle, -1, arrayList, zNextBoolean, i2, false, null, null, null, null, bundle2, bundle3, arrayList2, null, null, false, null, i, str2, arrayList3, iNextInt, null, 0, 0L, 0L);
        Bundle bundle5 = zzmVar.zzm;
        Bundle bundle6 = bundle5.getBundle("com.google.ads.mediation.admob.AdMobAdapter");
        if (bundle6 == null) {
            bundle6 = zzmVar.zzc;
            bundle5.putBundle("com.google.ads.mediation.admob.AdMobAdapter", bundle6);
        }
        return new com.google.android.gms.ads.internal.client.zzm(8, -1L, bundle6, zzmVar.zzd, zzmVar.zze, zzmVar.zzf, zzmVar.zzg, zzmVar.zzh, zzmVar.zzi, zzmVar.zzj, zzmVar.zzk, zzmVar.zzl, bundle5, zzmVar.zzn, zzmVar.zzo, zzmVar.zzp, zzmVar.zzq, zzmVar.zzr, zzmVar.zzs, zzmVar.zzt, zzmVar.zzu, zzmVar.zzv, zzmVar.zzw, zzmVar.zzx, zzmVar.zzy, zzmVar.zzz, zzmVar.zzA);
    }
}
