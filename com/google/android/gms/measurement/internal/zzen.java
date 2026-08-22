package com.google.android.gms.measurement.internal;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.text.jp.CyjpdoedCdLTIO;
import androidx.work.impl.constraints.controllers.pST.ehgOP;
import com.google.android.gms.ads.internal.gMU.QTaELkFI;
import com.google.android.gms.auth.api.LNi.xPQrbOSWiEdU;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader$ParseException;
import com.google.android.gms.common.stats.ZnFR.FKidOcdAYt;
import com.google.android.gms.internal.measurement.zzer;
import com.google.android.gms.internal.measurement.zzet;
import com.google.android.gms.internal.measurement.zzey;
import com.google.android.gms.internal.measurement.zzfp;
import com.google.android.gms.internal.measurement.zzfs;
import com.google.android.gms.internal.measurement.zzft;
import com.google.android.gms.internal.measurement.zzfw;
import com.google.android.gms.internal.measurement.zzfx;
import com.google.android.gms.internal.measurement.zzgb;
import com.google.android.gms.internal.measurement.zzgc;
import com.google.android.gms.internal.measurement.zzgd;
import com.google.android.gms.internal.measurement.zzgk;
import com.google.android.gms.internal.measurement.zzjr;
import com.google.android.gms.internal.measurement.zzkb;
import com.google.android.gms.internal.measurement.zzll;
import com.google.android.gms.internal.measurement.zzpd;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPOutputStream;
import kotlinx.coroutines.internal.Jbo.ygoi;

/* JADX INFO: loaded from: classes2.dex */
public final class zzen extends zzkh {
    public final /* synthetic */ int $r8$classId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ zzen(zzkt zzktVar, int i) {
        super(zzktVar);
        this.$r8$classId = i;
    }

    public static final zzfx zzB(zzft zzftVar, String str) {
        for (zzfx zzfxVar : zzftVar.zzi()) {
            if (zzfxVar.zzg().equals(str)) {
                return zzfxVar;
            }
        }
        return null;
    }

    /* JADX WARN: Type inference failed for: r6v9, types: [android.os.Bundle[], java.io.Serializable] */
    public static final Serializable zzC(zzft zzftVar, String str) {
        zzfx zzfxVarZzB = zzB(zzftVar, str);
        if (zzfxVarZzB == null) {
            return null;
        }
        if (zzfxVarZzB.zzy()) {
            return zzfxVarZzB.zzh();
        }
        if (zzfxVarZzB.zzw()) {
            return Long.valueOf(zzfxVarZzB.zzd());
        }
        if (zzfxVarZzB.zzu()) {
            return Double.valueOf(zzfxVarZzB.zza());
        }
        if (zzfxVarZzB.zzc() <= 0) {
            return null;
        }
        List<zzfx> listZzi = zzfxVarZzB.zzi();
        ArrayList arrayList = new ArrayList();
        for (zzfx zzfxVar : listZzi) {
            if (zzfxVar != null) {
                Bundle bundle = new Bundle();
                for (zzfx zzfxVar2 : zzfxVar.zzi()) {
                    if (zzfxVar2.zzy()) {
                        bundle.putString(zzfxVar2.zzg(), zzfxVar2.zzh());
                    } else if (zzfxVar2.zzw()) {
                        bundle.putLong(zzfxVar2.zzg(), zzfxVar2.zzd());
                    } else if (zzfxVar2.zzu()) {
                        bundle.putDouble(zzfxVar2.zzg(), zzfxVar2.zza());
                    }
                }
                if (!bundle.isEmpty()) {
                    arrayList.add(bundle);
                }
            }
        }
        return (Bundle[]) arrayList.toArray(new Bundle[arrayList.size()]);
    }

    public static final void zzF(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            sb.append("  ");
        }
    }

    public static final String zzG(boolean z, boolean z2, boolean z3) {
        StringBuilder sb = new StringBuilder();
        if (z) {
            sb.append("Dynamic ");
        }
        if (z2) {
            sb.append("Sequence ");
        }
        if (z3) {
            sb.append("Session-Scoped ");
        }
        return sb.toString();
    }

    public static final void zzI(StringBuilder sb, int i, String str, Object obj) {
        if (obj == null) {
            return;
        }
        zzF(sb, i + 1);
        sb.append(str);
        sb.append(": ");
        sb.append(obj);
        sb.append('\n');
    }

    public static int zza(zzgc zzgcVar, String str) {
        for (int i = 0; i < zzgcVar.zzb(); i++) {
            if (str.equals(zzgcVar.zzao(i).zzf())) {
                return i;
            }
        }
        return -1;
    }

    private final void zzb$com$google$android$gms$measurement$internal$zzen() {
    }

    private final void zzb$com$google$android$gms$measurement$internal$zzic() {
    }

    private final void zzb$com$google$android$gms$measurement$internal$zzkv() {
    }

    public static Bundle zzf(Map map, boolean z) {
        Bundle bundle = new Bundle();
        for (String str : map.keySet()) {
            Object obj = map.get(str);
            if (obj == null) {
                bundle.putString(str, null);
            } else if (obj instanceof Long) {
                bundle.putLong(str, ((Long) obj).longValue());
            } else if (obj instanceof Double) {
                bundle.putDouble(str, ((Double) obj).doubleValue());
            } else if (!(obj instanceof ArrayList)) {
                bundle.putString(str, obj.toString());
            } else if (z) {
                ArrayList arrayList = (ArrayList) obj;
                ArrayList arrayList2 = new ArrayList();
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    arrayList2.add(zzf((Map) arrayList.get(i), false));
                }
                bundle.putParcelableArray(str, (Parcelable[]) arrayList2.toArray(new Parcelable[0]));
            }
        }
        return bundle;
    }

    public static zzaw zzi(com.google.android.gms.internal.measurement.zzaa zzaaVar) {
        Object obj;
        Bundle bundleZzf = zzf(zzaaVar.zze(), true);
        String string = (!bundleZzf.containsKey("_o") || (obj = bundleZzf.get("_o")) == null) ? "app" : obj.toString();
        String strZzb = zzg.zzb(zzaaVar.zzd(), zzg.f3zza, zzg.zzc);
        if (strZzb == null) {
            strZzb = zzaaVar.zzd();
        }
        return new zzaw(strZzb, new zzau(bundleZzf), string, zzaaVar.zza());
    }

    public static zzll zzl(zzkb zzkbVar, byte[] bArr) {
        zzjr zzjrVarZza = zzjr.zza();
        return zzjrVarZza != null ? zzkbVar.zzay(bArr, zzjrVarZza) : zzkbVar.zzax(bArr);
    }

    public static ArrayList zzr(BitSet bitSet) {
        int length = (bitSet.length() + 63) / 64;
        ArrayList arrayList = new ArrayList(length);
        for (int i = 0; i < length; i++) {
            long j = 0;
            for (int i2 = 0; i2 < 64; i2++) {
                int i3 = (i * 64) + i2;
                if (i3 >= bitSet.length()) {
                    break;
                }
                if (bitSet.get(i3)) {
                    j |= 1 << i2;
                }
            }
            arrayList.add(Long.valueOf(j));
        }
        return arrayList;
    }

    public static HashMap zzs(Bundle bundle, boolean z) {
        HashMap map = new HashMap();
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            boolean z2 = obj instanceof Parcelable[];
            if (z2 || (obj instanceof ArrayList) || (obj instanceof Bundle)) {
                if (z) {
                    ArrayList arrayList = new ArrayList();
                    if (z2) {
                        for (Parcelable parcelable : (Parcelable[]) obj) {
                            if (parcelable instanceof Bundle) {
                                arrayList.add(zzs((Bundle) parcelable, false));
                            }
                        }
                    } else if (obj instanceof ArrayList) {
                        ArrayList arrayList2 = (ArrayList) obj;
                        int size = arrayList2.size();
                        for (int i = 0; i < size; i++) {
                            Object obj2 = arrayList2.get(i);
                            if (obj2 instanceof Bundle) {
                                arrayList.add(zzs((Bundle) obj2, false));
                            }
                        }
                    } else if (obj instanceof Bundle) {
                        arrayList.add(zzs((Bundle) obj, false));
                    }
                    map.put(str, arrayList);
                }
            } else if (obj != null) {
                map.put(str, obj);
            }
        }
        return map;
    }

    public static boolean zzv(int i, List list) {
        if (i < list.size() * 64) {
            return ((1 << (i % 64)) & ((Long) list.get(i / 64)).longValue()) != 0;
        }
        return false;
    }

    public static boolean zzx(String str) {
        return str != null && str.matches("([+-])?([0-9]+\\.?[0-9]*|[0-9]*\\.?[0-9]+)") && str.length() <= 310;
    }

    public static final void zzz(zzfs zzfsVar, String str, Long l) {
        List listZzp = zzfsVar.zzp();
        int i = 0;
        while (true) {
            if (i >= listZzp.size()) {
                i = -1;
                break;
            } else if (str.equals(((zzfx) listZzp.get(i)).zzg())) {
                break;
            } else {
                i++;
            }
        }
        zzfw zzfwVarZze = zzfx.zze();
        zzfwVarZze.zzj(str);
        if (l instanceof Long) {
            zzfwVarZze.zzi(l.longValue());
        }
        if (i >= 0) {
            zzfsVar.zzj(i, zzfwVarZze);
        } else {
            zzfsVar.zze(zzfwVarZze);
        }
    }

    public void zzD(StringBuilder sb, int i, List list) {
        if (list == null) {
            return;
        }
        int i2 = i + 1;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzfx zzfxVar = (zzfx) it.next();
            if (zzfxVar != null) {
                zzF(sb, i2);
                sb.append("param {\n");
                zzI(sb, i2, "name", zzfxVar.zzx() ? ((zzfr) this.mBuilder).zzq.zze(zzfxVar.zzg()) : null);
                zzI(sb, i2, "string_value", zzfxVar.zzy() ? zzfxVar.zzh() : null);
                zzI(sb, i2, "int_value", zzfxVar.zzw() ? Long.valueOf(zzfxVar.zzd()) : null);
                zzI(sb, i2, "double_value", zzfxVar.zzu() ? Double.valueOf(zzfxVar.zza()) : null);
                if (zzfxVar.zzc() > 0) {
                    zzD(sb, i2, zzfxVar.zzi());
                }
                zzF(sb, i2);
                sb.append("}\n");
            }
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzkh
    public final void zzb() {
        int i = this.$r8$classId;
    }

    public long zzd(byte[] bArr) {
        com.google.android.gms.common.internal.zzah.checkNotNull(bArr);
        zzfr zzfrVar = (zzfr) this.mBuilder;
        zzlb zzlbVar = zzfrVar.zzp;
        zzfr.zzP(zzlbVar);
        zzlbVar.zzg();
        MessageDigest messageDigestZzF = zzlb.zzF();
        if (messageDigestZzF != null) {
            return zzlb.zzp(messageDigestZzF.digest(bArr));
        }
        zzeh zzehVar = zzfrVar.zzm;
        zzfr.zzR(zzehVar);
        zzehVar.zzd.zza("Failed to get MD5");
        return 0L;
    }

    public Parcelable zzh(byte[] bArr, Parcelable.Creator creator) {
        if (bArr == null) {
            return null;
        }
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.unmarshall(bArr, 0, bArr.length);
            parcelObtain.setDataPosition(0);
            return (Parcelable) creator.createFromParcel(parcelObtain);
        } catch (SafeParcelReader$ParseException unused) {
            zzeh zzehVar = ((zzfr) this.mBuilder).zzm;
            zzfr.zzR(zzehVar);
            zzehVar.zzd.zza("Failed to load parcelable from buffer");
            return null;
        } finally {
            parcelObtain.recycle();
        }
    }

    public zzft zzj(zzar zzarVar) {
        zzfs zzfsVarZze = zzft.zze();
        zzfsVarZze.zzl(zzarVar.zze);
        zzau zzauVar = zzarVar.zzf;
        for (String str : zzauVar.zza.keySet()) {
            zzfw zzfwVarZze = zzfx.zze();
            zzfwVarZze.zzj(str);
            Object obj = zzauVar.zza.get(str);
            com.google.android.gms.common.internal.zzah.checkNotNull(obj);
            zzt(zzfwVarZze, obj);
            zzfsVarZze.zze(zzfwVarZze);
        }
        return (zzft) zzfsVarZze.zzaC();
    }

    public String zzp(zzet zzetVar) {
        StringBuilder sb = new StringBuilder();
        sb.append("\nproperty_filter {\n");
        if (zzetVar.zzj()) {
            zzI(sb, 0, "filter_id", Integer.valueOf(zzetVar.zza()));
        }
        zzI(sb, 0, "property_name", ((zzfr) this.mBuilder).zzq.zzf(zzetVar.zze()));
        String strZzG = zzG(zzetVar.zzg(), zzetVar.zzh(), zzetVar.zzi());
        if (!strZzG.isEmpty()) {
            zzI(sb, 0, "filter_type", strZzG);
        }
        zzE(sb, 1, zzetVar.zzb());
        sb.append("}\n");
        return sb.toString();
    }

    public List zzq(List list, List list2) {
        int i;
        ArrayList arrayList = new ArrayList(list);
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            int iIntValue = num.intValue();
            zzfr zzfrVar = (zzfr) this.mBuilder;
            if (iIntValue < 0) {
                zzeh zzehVar = zzfrVar.zzm;
                zzfr.zzR(zzehVar);
                zzehVar.zzg.zzb(num, "Ignoring negative bit index to be cleared");
            } else {
                int iIntValue2 = num.intValue() / 64;
                if (iIntValue2 >= arrayList.size()) {
                    zzeh zzehVar2 = zzfrVar.zzm;
                    zzfr.zzR(zzehVar2);
                    zzehVar2.zzg.zzc(num, "Ignoring bit index greater than bitSet size", Integer.valueOf(arrayList.size()));
                } else {
                    arrayList.set(iIntValue2, Long.valueOf(((Long) arrayList.get(iIntValue2)).longValue() & (~(1 << (num.intValue() % 64)))));
                }
            }
        }
        int size = arrayList.size();
        int size2 = arrayList.size() - 1;
        while (true) {
            int i2 = size2;
            i = size;
            size = i2;
            if (size < 0 || ((Long) arrayList.get(size)).longValue() != 0) {
                break;
            }
            size2 = size - 1;
        }
        return arrayList.subList(0, i);
    }

    public void zzt(zzfw zzfwVar, Object obj) {
        zzfwVar.zzg();
        zzfwVar.zze();
        zzfwVar.zzd();
        zzfwVar.zzf();
        if (obj instanceof String) {
            zzfwVar.zzk((String) obj);
            return;
        }
        if (obj instanceof Long) {
            zzfwVar.zzi(((Long) obj).longValue());
            return;
        }
        if (obj instanceof Double) {
            zzfwVar.zzh(((Double) obj).doubleValue());
            return;
        }
        if (!(obj instanceof Bundle[])) {
            zzeh zzehVar = ((zzfr) this.mBuilder).zzm;
            zzfr.zzR(zzehVar);
            zzehVar.zzd.zzb(obj, "Ignoring invalid (type) event param value");
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (Bundle bundle : (Bundle[]) obj) {
            if (bundle != null) {
                zzfw zzfwVarZze = zzfx.zze();
                for (String str : bundle.keySet()) {
                    zzfw zzfwVarZze2 = zzfx.zze();
                    zzfwVarZze2.zzj(str);
                    Object obj2 = bundle.get(str);
                    if (obj2 instanceof Long) {
                        zzfwVarZze2.zzi(((Long) obj2).longValue());
                    } else if (obj2 instanceof String) {
                        zzfwVarZze2.zzk((String) obj2);
                    } else if (obj2 instanceof Double) {
                        zzfwVarZze2.zzh(((Double) obj2).doubleValue());
                    }
                    zzfwVarZze.zzc(zzfwVarZze2);
                }
                if (zzfwVarZze.zza() > 0) {
                    arrayList.add((zzfx) zzfwVarZze.zzaC());
                }
            }
        }
        zzfwVar.zzb(arrayList);
    }

    public void zzu(com.google.android.gms.internal.measurement.zzgl zzglVar, Object obj) {
        com.google.android.gms.common.internal.zzah.checkNotNull(obj);
        zzglVar.zzc();
        zzglVar.zzb();
        zzglVar.zza();
        if (obj instanceof String) {
            zzglVar.zzh((String) obj);
            return;
        }
        if (obj instanceof Long) {
            zzglVar.zze(((Long) obj).longValue());
        } else {
            if (obj instanceof Double) {
                zzglVar.zzd(((Double) obj).doubleValue());
                return;
            }
            zzeh zzehVar = ((zzfr) this.mBuilder).zzm;
            zzfr.zzR(zzehVar);
            zzehVar.zzd.zzb(obj, "Ignoring invalid (type) user attribute value");
        }
    }

    public boolean zzw(long j, long j2) {
        if (j == 0 || j2 <= 0) {
            return true;
        }
        ((zzfr) this.mBuilder).zzr.getClass();
        return Math.abs(System.currentTimeMillis() - j) > j2;
    }

    public byte[] zzy(byte[] bArr) throws IOException {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            byteArrayOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            zzeh zzehVar = ((zzfr) this.mBuilder).zzm;
            zzfr.zzR(zzehVar);
            zzehVar.zzd.zzb(e, "Failed to gzip content");
            throw e;
        }
    }

    public static final void zzH(StringBuilder sb, String str, com.google.android.gms.internal.measurement.zzgi zzgiVar) {
        if (zzgiVar == null) {
            return;
        }
        zzF(sb, 3);
        sb.append(str);
        sb.append(" {\n");
        if (zzgiVar.zzb() != 0) {
            zzF(sb, 4);
            sb.append("results: ");
            int i = 0;
            for (Long l : zzgiVar.zzk()) {
                int i2 = i + 1;
                if (i != 0) {
                    sb.append(", ");
                }
                sb.append(l);
                i = i2;
            }
            sb.append('\n');
        }
        if (zzgiVar.zzd() != 0) {
            zzF(sb, 4);
            sb.append("status: ");
            int i3 = 0;
            for (Long l2 : zzgiVar.zzn()) {
                int i4 = i3 + 1;
                if (i3 != 0) {
                    sb.append(", ");
                }
                sb.append(l2);
                i3 = i4;
            }
            sb.append('\n');
        }
        int iZza = zzgiVar.zza();
        String str2 = ygoi.cVhWCWpAN;
        if (iZza != 0) {
            zzF(sb, 4);
            sb.append("dynamic_filter_timestamps: {");
            int i5 = 0;
            for (com.google.android.gms.internal.measurement.zzfr zzfrVar : zzgiVar.zzj()) {
                int i6 = i5 + 1;
                if (i5 != 0) {
                    sb.append(", ");
                }
                sb.append(zzfrVar.zzh() ? Integer.valueOf(zzfrVar.zza()) : null);
                sb.append(":");
                sb.append(zzfrVar.zzg() ? Long.valueOf(zzfrVar.zzb()) : null);
                i5 = i6;
            }
            sb.append(str2);
        }
        if (zzgiVar.zzc() != 0) {
            zzF(sb, 4);
            sb.append("sequence_filter_timestamps: {");
            int i7 = 0;
            for (zzgk zzgkVar : zzgiVar.zzm()) {
                int i8 = i7 + 1;
                if (i7 != 0) {
                    sb.append(", ");
                }
                sb.append(zzgkVar.zzi() ? Integer.valueOf(zzgkVar.zzb()) : null);
                sb.append(": [");
                Iterator it = zzgkVar.zzf().iterator();
                int i9 = 0;
                while (it.hasNext()) {
                    long jLongValue = ((Long) it.next()).longValue();
                    int i10 = i9 + 1;
                    if (i9 != 0) {
                        sb.append(", ");
                    }
                    sb.append(jLongValue);
                    i9 = i10;
                }
                sb.append("]");
                i7 = i8;
            }
            sb.append(str2);
        }
        zzF(sb, 3);
        sb.append(str2);
    }

    public static final void zzJ(StringBuilder sb, int i, String str, zzer zzerVar) {
        String str2;
        if (zzerVar == null) {
            return;
        }
        zzF(sb, i);
        sb.append(str);
        sb.append(" {\n");
        if (zzerVar.zzg()) {
            int iZzm = zzerVar.zzm();
            if (iZzm == 1) {
                str2 = "UNKNOWN_COMPARISON_TYPE";
            } else if (iZzm == 2) {
                str2 = "LESS_THAN";
            } else if (iZzm != 3) {
                str2 = iZzm != 4 ? "BETWEEN" : "EQUAL";
            } else {
                str2 = xPQrbOSWiEdU.AfRZKj;
            }
            zzI(sb, i, "comparison_type", str2);
        }
        if (zzerVar.zzi()) {
            zzI(sb, i, "match_as_float", Boolean.valueOf(zzerVar.zzf()));
        }
        if (zzerVar.zzh()) {
            zzI(sb, i, "comparison_value", zzerVar.zzc());
        }
        if (zzerVar.zzk()) {
            zzI(sb, i, "min_comparison_value", zzerVar.zze());
        }
        if (zzerVar.zzj()) {
            zzI(sb, i, "max_comparison_value", zzerVar.zzd());
        }
        zzF(sb, i);
        sb.append("}\n");
    }

    public void zzE(StringBuilder sb, int i, com.google.android.gms.internal.measurement.zzem zzemVar) {
        String str;
        if (zzemVar == null) {
            return;
        }
        zzF(sb, i);
        sb.append(QTaELkFI.RNXksuI);
        if (zzemVar.zzh()) {
            zzI(sb, i, "complement", Boolean.valueOf(zzemVar.zzg()));
        }
        if (zzemVar.zzj()) {
            zzI(sb, i, "param_name", ((zzfr) this.mBuilder).zzq.zze(zzemVar.zze()));
        }
        if (zzemVar.zzk()) {
            int i2 = i + 1;
            zzey zzeyVarZzd = zzemVar.zzd();
            if (zzeyVarZzd != null) {
                zzF(sb, i2);
                sb.append("string_filter {\n");
                if (zzeyVarZzd.zzi()) {
                    switch (zzeyVarZzd.zzj()) {
                        case 1:
                            str = "UNKNOWN_MATCH_TYPE";
                            break;
                        case 2:
                            str = "REGEXP";
                            break;
                        case 3:
                            str = "BEGINS_WITH";
                            break;
                        case 4:
                            str = "ENDS_WITH";
                            break;
                        case 5:
                            str = "PARTIAL";
                            break;
                        case 6:
                            str = "EXACT";
                            break;
                        default:
                            str = "IN_LIST";
                            break;
                    }
                    zzI(sb, i2, "match_type", str);
                }
                if (zzeyVarZzd.zzh()) {
                    zzI(sb, i2, "expression", zzeyVarZzd.zzd());
                }
                if (zzeyVarZzd.zzg()) {
                    zzI(sb, i2, "case_sensitive", Boolean.valueOf(zzeyVarZzd.zzf()));
                }
                if (zzeyVarZzd.zza() > 0) {
                    zzF(sb, i + 2);
                    sb.append("expression_list {\n");
                    for (String str2 : zzeyVarZzd.zze()) {
                        zzF(sb, i + 3);
                        sb.append(str2);
                        sb.append("\n");
                    }
                    sb.append("}\n");
                }
                zzF(sb, i2);
                sb.append("}\n");
            }
        }
        if (zzemVar.zzi()) {
            zzJ(sb, i + 1, "number_filter", zzemVar.zzc());
        }
        zzF(sb, i);
        sb.append("}\n");
    }

    public String zzm(zzgb zzgbVar) {
        if (zzgbVar == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\nbatch {\n");
        for (zzgd zzgdVar : zzgbVar.zzd()) {
            if (zzgdVar != null) {
                zzF(sb, 1);
                sb.append("bundle {\n");
                if (zzgdVar.zzbj()) {
                    zzI(sb, 1, "protocol_version", Integer.valueOf(zzgdVar.zzd()));
                }
                zzpd.zzc();
                zzfr zzfrVar = (zzfr) this.mBuilder;
                if (zzfrVar.zzk.zzs(null, zzdu.zzal)) {
                    if (zzfrVar.zzk.zzs(zzgdVar.zzx(), zzdu.zzan) && zzgdVar.zzbm()) {
                        zzI(sb, 1, "session_stitching_token", zzgdVar.zzK());
                    }
                }
                zzI(sb, 1, "platform", zzgdVar.zzI());
                if (zzgdVar.zzbf()) {
                    zzI(sb, 1, "gmp_version", Long.valueOf(zzgdVar.zzm()));
                }
                if (zzgdVar.zzbq()) {
                    zzI(sb, 1, "uploading_gmp_version", Long.valueOf(zzgdVar.zzr()));
                }
                if (zzgdVar.zzbd()) {
                    zzI(sb, 1, "dynamite_version", Long.valueOf(zzgdVar.zzj()));
                }
                if (zzgdVar.zzba()) {
                    zzI(sb, 1, "config_version", Long.valueOf(zzgdVar.zzh()));
                }
                zzI(sb, 1, "gmp_app_id", zzgdVar.zzF());
                zzI(sb, 1, "admob_app_id", zzgdVar.zzw());
                zzI(sb, 1, "app_id", zzgdVar.zzx());
                zzI(sb, 1, "app_version", zzgdVar.zzA());
                if (zzgdVar.zzaY()) {
                    zzI(sb, 1, "app_version_major", Integer.valueOf(zzgdVar.zza()));
                }
                zzI(sb, 1, "firebase_instance_id", zzgdVar.zzE());
                if (zzgdVar.zzbc()) {
                    zzI(sb, 1, "dev_cert_hash", Long.valueOf(zzgdVar.zzi()));
                }
                zzI(sb, 1, "app_store", zzgdVar.zzz());
                if (zzgdVar.zzbp()) {
                    zzI(sb, 1, "upload_timestamp_millis", Long.valueOf(zzgdVar.zzq()));
                }
                if (zzgdVar.zzbn()) {
                    zzI(sb, 1, "start_timestamp_millis", Long.valueOf(zzgdVar.zzp()));
                }
                if (zzgdVar.zzbe()) {
                    zzI(sb, 1, "end_timestamp_millis", Long.valueOf(zzgdVar.zzk()));
                }
                if (zzgdVar.zzbi()) {
                    zzI(sb, 1, "previous_bundle_start_timestamp_millis", Long.valueOf(zzgdVar.zzo()));
                }
                if (zzgdVar.zzbh()) {
                    zzI(sb, 1, "previous_bundle_end_timestamp_millis", Long.valueOf(zzgdVar.zzn()));
                }
                zzI(sb, 1, "app_instance_id", zzgdVar.zzy());
                zzI(sb, 1, "resettable_device_id", zzgdVar.zzJ());
                zzI(sb, 1, "ds_id", zzgdVar.zzD());
                if (zzgdVar.zzbg()) {
                    zzI(sb, 1, "limited_ad_tracking", Boolean.valueOf(zzgdVar.zzaW()));
                }
                zzI(sb, 1, QTaELkFI.CbNaiiyf, zzgdVar.zzH());
                zzI(sb, 1, "device_model", zzgdVar.zzC());
                zzI(sb, 1, "user_default_language", zzgdVar.zzL());
                if (zzgdVar.zzbo()) {
                    zzI(sb, 1, ygoi.UbqDZLRJEIwu, Integer.valueOf(zzgdVar.zzf()));
                }
                if (zzgdVar.zzaZ()) {
                    zzI(sb, 1, "bundle_sequential_index", Integer.valueOf(zzgdVar.zzb()));
                }
                if (zzgdVar.zzbl()) {
                    zzI(sb, 1, FKidOcdAYt.cZLxcW, Boolean.valueOf(zzgdVar.zzaX()));
                }
                zzI(sb, 1, "health_monitor", zzgdVar.zzG());
                if (zzgdVar.zzbk()) {
                    zzI(sb, 1, "retry_counter", Integer.valueOf(zzgdVar.zze()));
                }
                if (zzgdVar.zzbb()) {
                    zzI(sb, 1, "consent_signals", zzgdVar.zzB());
                }
                List<com.google.android.gms.internal.measurement.zzgm> listZzO = zzgdVar.zzO();
                zzec zzecVar = zzfrVar.zzq;
                if (listZzO != null) {
                    for (com.google.android.gms.internal.measurement.zzgm zzgmVar : listZzO) {
                        if (zzgmVar != null) {
                            zzF(sb, 2);
                            sb.append("user_property {\n");
                            zzI(sb, 2, "set_timestamp_millis", zzgmVar.zzs() ? Long.valueOf(zzgmVar.zzc()) : null);
                            zzI(sb, 2, "name", zzecVar.zzf(zzgmVar.zzf()));
                            zzI(sb, 2, "string_value", zzgmVar.zzg());
                            zzI(sb, 2, "int_value", zzgmVar.zzr() ? Long.valueOf(zzgmVar.zzb()) : null);
                            zzI(sb, 2, "double_value", zzgmVar.zzq() ? Double.valueOf(zzgmVar.zza()) : null);
                            zzF(sb, 2);
                            sb.append("}\n");
                        }
                    }
                }
                List<zzfp> listZzM = zzgdVar.zzM();
                if (listZzM != null) {
                    for (zzfp zzfpVar : listZzM) {
                        if (zzfpVar != null) {
                            zzF(sb, 2);
                            sb.append(ehgOP.sSOgvtrKgYThYP);
                            if (zzfpVar.zzk()) {
                                zzI(sb, 2, "audience_id", Integer.valueOf(zzfpVar.zza()));
                            }
                            if (zzfpVar.zzm()) {
                                zzI(sb, 2, "new_audience", Boolean.valueOf(zzfpVar.zzj()));
                            }
                            zzH(sb, "current_data", zzfpVar.zzd());
                            if (zzfpVar.zzn()) {
                                zzH(sb, "previous_data", zzfpVar.zze());
                            }
                            zzF(sb, 2);
                            sb.append("}\n");
                        }
                    }
                }
                List<zzft> listZzN = zzgdVar.zzN();
                if (listZzN != null) {
                    for (zzft zzftVar : listZzN) {
                        if (zzftVar != null) {
                            zzF(sb, 2);
                            sb.append("event {\n");
                            zzI(sb, 2, "name", zzecVar.zzd(zzftVar.zzh()));
                            if (zzftVar.zzu()) {
                                zzI(sb, 2, "timestamp_millis", Long.valueOf(zzftVar.zzd()));
                            }
                            if (zzftVar.zzt()) {
                                zzI(sb, 2, "previous_timestamp_millis", Long.valueOf(zzftVar.zzc()));
                            }
                            if (zzftVar.zzs()) {
                                zzI(sb, 2, "count", Integer.valueOf(zzftVar.zza()));
                            }
                            if (zzftVar.zzb() != 0) {
                                zzD(sb, 2, zzftVar.zzi());
                            }
                            zzF(sb, 2);
                            sb.append("}\n");
                        }
                    }
                }
                zzF(sb, 1);
                sb.append("}\n");
            }
        }
        sb.append("}\n");
        return sb.toString();
    }

    public boolean zza() {
        zzW();
        ConnectivityManager connectivityManager = (ConnectivityManager) ((zzfr) this.mBuilder).zze.getSystemService(CyjpdoedCdLTIO.uaebrLJt);
        NetworkInfo activeNetworkInfo = null;
        if (connectivityManager != null) {
            try {
                activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            } catch (SecurityException unused) {
            }
        }
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}
