package com.google.android.gms.internal.ads;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import android.util.Base64;
import android.util.Pair;
import com.google.android.gms.ads.internal.offline.buffering.Dk.eoBKjVuj;
import com.google.android.gms.signin.internal.FVfQ.GsPcpBmONXh;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/* JADX INFO: loaded from: classes2.dex */
final class zzalq {
    public final String zza;
    public final String zzb;
    public final boolean zzc;
    public final long zzd;
    public final long zze;
    public final zzalw zzf;
    public final String zzg;
    public final String zzh;
    public final zzalq zzi;
    private final String[] zzj;
    private final HashMap zzk;
    private final HashMap zzl;
    private List zzm;

    private zzalq(String str, String str2, long j, long j2, zzalw zzalwVar, String[] strArr, String str3, String str4, zzalq zzalqVar) {
        this.zza = str;
        this.zzb = str2;
        this.zzh = str4;
        this.zzf = zzalwVar;
        this.zzj = strArr;
        this.zzc = str2 != null;
        this.zzd = j;
        this.zze = j2;
        str3.getClass();
        this.zzg = str3;
        this.zzi = zzalqVar;
        this.zzk = new HashMap();
        this.zzl = new HashMap();
    }

    public static zzalq zzb(String str, long j, long j2, zzalw zzalwVar, String[] strArr, String str2, String str3, zzalq zzalqVar) {
        return new zzalq(str, null, j, j2, zzalwVar, strArr, str2, str3, zzalqVar);
    }

    private static SpannableStringBuilder zzi(String str, Map map) {
        if (!map.containsKey(str)) {
            zzcs zzcsVar = new zzcs();
            zzcsVar.zzl(new SpannableStringBuilder());
            map.put(str, zzcsVar);
        }
        CharSequence charSequenceZzr = ((zzcs) map.get(str)).zzr();
        charSequenceZzr.getClass();
        return (SpannableStringBuilder) charSequenceZzr;
    }

    private final void zzj(TreeSet treeSet, boolean z) {
        String str = this.zza;
        boolean zEquals = "p".equals(str);
        boolean zEquals2 = "div".equals(str);
        if (z || zEquals || (zEquals2 && this.zzh != null)) {
            long j = this.zzd;
            if (j != -9223372036854775807L) {
                treeSet.add(Long.valueOf(j));
            }
            long j2 = this.zze;
            if (j2 != -9223372036854775807L) {
                treeSet.add(Long.valueOf(j2));
            }
        }
        if (this.zzm != null) {
            for (int i = 0; i < this.zzm.size(); i++) {
                zzalq zzalqVar = (zzalq) this.zzm.get(i);
                boolean z2 = true;
                if (!z && !zEquals) {
                    z2 = false;
                }
                zzalqVar.zzj(treeSet, z2);
            }
        }
    }

    private final void zzk(long j, String str, List list) {
        String str2;
        String str3 = this.zzg;
        if (true != "".equals(str3)) {
            str = str3;
        }
        if (zzg(j) && "div".equals(this.zza) && (str2 = this.zzh) != null) {
            list.add(new Pair(str, str2));
            return;
        }
        for (int i = 0; i < zza(); i++) {
            zzd(i).zzk(j, str, list);
        }
    }

    /* JADX WARN: Code duplicated, block: B:102:0x01e9  */
    /* JADX WARN: Code duplicated, block: B:105:0x01fc  */
    /* JADX WARN: Code duplicated, block: B:107:0x01ff  */
    /* JADX WARN: Code duplicated, block: B:110:0x0203  */
    /* JADX WARN: Code duplicated, block: B:111:0x020e  */
    /* JADX WARN: Code duplicated, block: B:112:0x021d  */
    /* JADX WARN: Code duplicated, block: B:115:0x0237  */
    /* JADX WARN: Code duplicated, block: B:117:0x0242  */
    /* JADX WARN: Code duplicated, block: B:120:0x0253  */
    /* JADX WARN: Code duplicated, block: B:123:0x0260  */
    private final void zzl(long j, Map map, Map map2, String str, Map map3) {
        zzalq zzalqVar;
        int i;
        zzalw zzalwVarZza;
        int iZze;
        int i2;
        int i3 = -1;
        if (zzg(j)) {
            String str2 = this.zzg;
            String str3 = true != "".equals(str2) ? str2 : str;
            Iterator it = this.zzl.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                String str4 = (String) entry.getKey();
                HashMap map4 = this.zzk;
                int iIntValue = map4.containsKey(str4) ? ((Integer) map4.get(str4)).intValue() : 0;
                int iIntValue2 = ((Integer) entry.getValue()).intValue();
                if (iIntValue != iIntValue2) {
                    zzcs zzcsVar = (zzcs) map3.get(str4);
                    zzcsVar.getClass();
                    zzalu zzaluVar = (zzalu) map2.get(str3);
                    zzaluVar.getClass();
                    int i4 = zzaluVar.zzj;
                    zzalw zzalwVarZza2 = zzalv.zza(this.zzf, this.zzj, map);
                    SpannableStringBuilder spannableStringBuilder = (SpannableStringBuilder) zzcsVar.zzr();
                    if (spannableStringBuilder == null) {
                        spannableStringBuilder = new SpannableStringBuilder();
                        zzcsVar.zzl(spannableStringBuilder);
                    }
                    if (zzalwVarZza2 != null) {
                        zzalq zzalqVar2 = this.zzi;
                        if (zzalwVarZza2.zzh() != i3) {
                            spannableStringBuilder.setSpan(new StyleSpan(zzalwVarZza2.zzh()), iIntValue, iIntValue2, 33);
                        }
                        if (zzalwVarZza2.zzM()) {
                            spannableStringBuilder.setSpan(new StrikethroughSpan(), iIntValue, iIntValue2, 33);
                        }
                        if (zzalwVarZza2.zzN()) {
                            spannableStringBuilder.setSpan(new UnderlineSpan(), iIntValue, iIntValue2, 33);
                        }
                        if (zzalwVarZza2.zzL()) {
                            zzda.zzb(spannableStringBuilder, new ForegroundColorSpan(zzalwVarZza2.zzd()), iIntValue, iIntValue2, 33);
                        }
                        if (zzalwVarZza2.zzK()) {
                            zzda.zzb(spannableStringBuilder, new BackgroundColorSpan(zzalwVarZza2.zzc()), iIntValue, iIntValue2, 33);
                        }
                        if (zzalwVarZza2.zzG() != null) {
                            zzda.zzb(spannableStringBuilder, new TypefaceSpan(zzalwVarZza2.zzG()), iIntValue, iIntValue2, 33);
                        }
                        if (zzalwVarZza2.zzk() != null) {
                            zzalp zzalpVarZzk = zzalwVarZza2.zzk();
                            zzalpVarZzk.getClass();
                            int i5 = zzalpVarZzk.zza;
                            if (i5 == -1) {
                                i5 = (i4 == 2 || i4 == 1) ? 3 : 1;
                                i2 = 1;
                            } else {
                                i2 = zzalpVarZzk.zzb;
                            }
                            int i6 = zzalpVarZzk.zzc;
                            if (i6 == -2) {
                                i6 = 1;
                            }
                            zzda.zzb(spannableStringBuilder, new zzdb(i5, i2, i6), iIntValue, iIntValue2, 33);
                        }
                        int iZzg = zzalwVarZza2.zzg();
                        if (iZzg == 2) {
                            while (true) {
                                if (zzalqVar2 == null) {
                                    zzalqVar2 = null;
                                    break;
                                }
                                zzalw zzalwVarZza3 = zzalv.zza(zzalqVar2.zzf, zzalqVar2.zzj, map);
                                if (zzalwVarZza3 != null && zzalwVarZza3.zzg() == 1) {
                                    break;
                                } else {
                                    zzalqVar2 = zzalqVar2.zzi;
                                }
                            }
                            if (zzalqVar2 != null) {
                                ArrayDeque arrayDeque = new ArrayDeque();
                                arrayDeque.push(zzalqVar2);
                                while (true) {
                                    if (arrayDeque.isEmpty()) {
                                        zzalqVar = null;
                                        break;
                                    }
                                    zzalq zzalqVar3 = (zzalq) arrayDeque.pop();
                                    zzalw zzalwVarZza4 = zzalv.zza(zzalqVar3.zzf, zzalqVar3.zzj, map);
                                    if (zzalwVarZza4 != null && zzalwVarZza4.zzg() == 3) {
                                        zzalqVar = zzalqVar3;
                                        break;
                                    }
                                    for (int iZza = zzalqVar3.zza() - 1; iZza >= 0; iZza--) {
                                        arrayDeque.push(zzalqVar3.zzd(iZza));
                                    }
                                }
                                if (zzalqVar != null) {
                                    if (zzalqVar.zza() != 1 || zzalqVar.zzd(0).zzb == null) {
                                        i = -1;
                                        zzea.zze("TtmlRenderUtil", "Skipping rubyText node without exactly one text child.");
                                    } else {
                                        String str5 = zzalqVar.zzd(0).zzb;
                                        String str6 = zzex.zza;
                                        zzalw zzalwVarZza5 = zzalv.zza(zzalqVar.zzf, zzalqVar.zzj, map);
                                        int iZzf = zzalwVarZza5 != null ? zzalwVarZza5.zzf() : -1;
                                        i = -1;
                                        if (iZzf == -1 && (zzalwVarZza = zzalv.zza(zzalqVar2.zzf, zzalqVar2.zzj, map)) != null) {
                                            iZzf = zzalwVarZza.zzf();
                                        }
                                        spannableStringBuilder.setSpan(new zzcz(str5, iZzf), iIntValue, iIntValue2, 33);
                                    }
                                }
                            }
                            if (zzalwVarZza2.zzJ()) {
                                zzda.zzb(spannableStringBuilder, new zzcy(), iIntValue, iIntValue2, 33);
                            }
                            iZze = zzalwVarZza2.zze();
                            if (iZze != 1) {
                                zzda.zzb(spannableStringBuilder, new AbsoluteSizeSpan((int) zzalwVarZza2.zza(), true), iIntValue, iIntValue2, 33);
                            } else if (iZze != 2) {
                                zzda.zzb(spannableStringBuilder, new RelativeSizeSpan(zzalwVarZza2.zza()), iIntValue, iIntValue2, 33);
                            } else if (iZze == 3) {
                                zzda.zza(spannableStringBuilder, zzalwVarZza2.zza() / 100.0f, iIntValue, iIntValue2, 33);
                            }
                            if ("p".equals(this.zza)) {
                                if (zzalwVarZza2.zzb() != Float.MAX_VALUE) {
                                    zzcsVar.zzj((zzalwVarZza2.zzb() * (-90.0f)) / 100.0f);
                                }
                                if (zzalwVarZza2.zzj() != null) {
                                    zzcsVar.zzm(zzalwVarZza2.zzj());
                                }
                                if (zzalwVarZza2.zzi() != null) {
                                    zzcsVar.zzg(zzalwVarZza2.zzi());
                                }
                            }
                            i3 = i;
                            it = it;
                        } else if (iZzg == 3 || iZzg == 4) {
                            spannableStringBuilder.setSpan(new zzalo(), iIntValue, iIntValue2, 33);
                        }
                        i = -1;
                        if (zzalwVarZza2.zzJ()) {
                            zzda.zzb(spannableStringBuilder, new zzcy(), iIntValue, iIntValue2, 33);
                        }
                        iZze = zzalwVarZza2.zze();
                        if (iZze != 1) {
                            zzda.zzb(spannableStringBuilder, new AbsoluteSizeSpan((int) zzalwVarZza2.zza(), true), iIntValue, iIntValue2, 33);
                        } else if (iZze != 2) {
                            zzda.zzb(spannableStringBuilder, new RelativeSizeSpan(zzalwVarZza2.zza()), iIntValue, iIntValue2, 33);
                        } else if (iZze == 3) {
                            zzda.zza(spannableStringBuilder, zzalwVarZza2.zza() / 100.0f, iIntValue, iIntValue2, 33);
                        }
                        if ("p".equals(this.zza)) {
                            if (zzalwVarZza2.zzb() != Float.MAX_VALUE) {
                                zzcsVar.zzj((zzalwVarZza2.zzb() * (-90.0f)) / 100.0f);
                            }
                            if (zzalwVarZza2.zzj() != null) {
                                zzcsVar.zzm(zzalwVarZza2.zzj());
                            }
                            if (zzalwVarZza2.zzi() != null) {
                                zzcsVar.zzg(zzalwVarZza2.zzi());
                            }
                        }
                        i3 = i;
                        it = it;
                    }
                }
            }
            for (int i7 = 0; i7 < zza(); i7++) {
                zzd(i7).zzl(j, map, map2, str3, map3);
            }
        }
    }

    private final void zzm(long j, boolean z, String str, Map map) {
        HashMap map2 = this.zzk;
        map2.clear();
        HashMap map3 = this.zzl;
        map3.clear();
        String str2 = this.zza;
        if ("metadata".equals(str2)) {
            return;
        }
        String str3 = this.zzg;
        String str4 = true != "".equals(str3) ? str3 : str;
        if (this.zzc && z) {
            SpannableStringBuilder spannableStringBuilderZzi = zzi(str4, map);
            String str5 = this.zzb;
            str5.getClass();
            spannableStringBuilderZzi.append((CharSequence) str5);
            return;
        }
        if ("br".equals(str2) && z) {
            zzi(str4, map).append('\n');
            return;
        }
        if (zzg(j)) {
            for (Map.Entry entry : map.entrySet()) {
                String str6 = (String) entry.getKey();
                CharSequence charSequenceZzr = ((zzcs) entry.getValue()).zzr();
                charSequenceZzr.getClass();
                map2.put(str6, Integer.valueOf(charSequenceZzr.length()));
            }
            boolean zEquals = "p".equals(str2);
            for (int i = 0; i < zza(); i++) {
                zzd(i).zzm(j, z || zEquals, str4, map);
            }
            if (zEquals) {
                SpannableStringBuilder spannableStringBuilderZzi2 = zzi(str4, map);
                int length = spannableStringBuilderZzi2.length();
                do {
                    length--;
                    if (length < 0) {
                        break;
                    }
                } while (spannableStringBuilderZzi2.charAt(length) == ' ');
                if (length >= 0 && spannableStringBuilderZzi2.charAt(length) != '\n') {
                    spannableStringBuilderZzi2.append('\n');
                }
            }
            for (Map.Entry entry2 : map.entrySet()) {
                String str7 = (String) entry2.getKey();
                CharSequence charSequenceZzr2 = ((zzcs) entry2.getValue()).zzr();
                charSequenceZzr2.getClass();
                map3.put(str7, Integer.valueOf(charSequenceZzr2.length()));
            }
        }
    }

    public final int zza() {
        List list = this.zzm;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public final zzalq zzd(int i) {
        List list = this.zzm;
        if (list != null) {
            return (zzalq) list.get(i);
        }
        throw new IndexOutOfBoundsException();
    }

    public final List zze(long j, Map map, Map map2, Map map3) {
        ArrayList arrayList = new ArrayList();
        String str = this.zzg;
        zzk(j, str, arrayList);
        TreeMap treeMap = new TreeMap();
        zzm(j, false, str, treeMap);
        zzl(j, map, map2, str, treeMap);
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            Pair pair = (Pair) arrayList.get(i);
            String str2 = (String) map3.get(pair.second);
            if (str2 != null) {
                byte[] bArrDecode = Base64.decode(str2, 0);
                Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
                zzalu zzaluVar = (zzalu) map2.get(pair.first);
                zzaluVar.getClass();
                zzcs zzcsVar = new zzcs();
                zzcsVar.zzc(bitmapDecodeByteArray);
                zzcsVar.zzh(zzaluVar.zzb);
                zzcsVar.zzi(0);
                zzcsVar.zze(zzaluVar.zzc, 0);
                zzcsVar.zzf(zzaluVar.zze);
                zzcsVar.zzk(zzaluVar.zzf);
                zzcsVar.zzd(zzaluVar.zzg);
                zzcsVar.zzo(zzaluVar.zzj);
                arrayList2.add(zzcsVar.zzq());
            }
        }
        for (Map.Entry entry : treeMap.entrySet()) {
            zzalu zzaluVar2 = (zzalu) map2.get(entry.getKey());
            zzaluVar2.getClass();
            zzcs zzcsVar2 = (zzcs) entry.getValue();
            CharSequence charSequenceZzr = zzcsVar2.zzr();
            charSequenceZzr.getClass();
            SpannableStringBuilder spannableStringBuilder = (SpannableStringBuilder) charSequenceZzr;
            for (zzalo zzaloVar : (zzalo[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), zzalo.class)) {
                spannableStringBuilder.replace(spannableStringBuilder.getSpanStart(zzaloVar), spannableStringBuilder.getSpanEnd(zzaloVar), (CharSequence) "");
            }
            int i2 = 0;
            while (i2 < spannableStringBuilder.length()) {
                int i3 = i2 + 1;
                if (spannableStringBuilder.charAt(i2) == ' ') {
                    int i4 = i3;
                    while (i4 < spannableStringBuilder.length() && spannableStringBuilder.charAt(i4) == ' ') {
                        i4++;
                    }
                    int i5 = i4 - i3;
                    if (i5 > 0) {
                        spannableStringBuilder.delete(i2, i5 + i2);
                    }
                }
                i2 = i3;
            }
            if (spannableStringBuilder.length() > 0 && spannableStringBuilder.charAt(0) == ' ') {
                spannableStringBuilder.delete(0, 1);
            }
            int i6 = 0;
            while (i6 < spannableStringBuilder.length() - 1) {
                int i7 = i6 + 1;
                if (spannableStringBuilder.charAt(i6) == '\n' && spannableStringBuilder.charAt(i7) == ' ') {
                    spannableStringBuilder.delete(i7, i6 + 2);
                }
                i6 = i7;
            }
            if (spannableStringBuilder.length() > 0 && spannableStringBuilder.charAt(spannableStringBuilder.length() - 1) == ' ') {
                spannableStringBuilder.delete(spannableStringBuilder.length() - 1, spannableStringBuilder.length());
            }
            int i8 = 0;
            while (i8 < spannableStringBuilder.length() - 1) {
                int i9 = i8 + 1;
                if (spannableStringBuilder.charAt(i8) == ' ' && spannableStringBuilder.charAt(i9) == '\n') {
                    spannableStringBuilder.delete(i8, i9);
                }
                i8 = i9;
            }
            if (spannableStringBuilder.length() > 0 && spannableStringBuilder.charAt(spannableStringBuilder.length() - 1) == '\n') {
                spannableStringBuilder.delete(spannableStringBuilder.length() - 1, spannableStringBuilder.length());
            }
            zzcsVar2.zze(zzaluVar2.zzc, zzaluVar2.zzd);
            zzcsVar2.zzf(zzaluVar2.zze);
            zzcsVar2.zzh(zzaluVar2.zzb);
            zzcsVar2.zzk(zzaluVar2.zzf);
            zzcsVar2.zzn(zzaluVar2.zzi, zzaluVar2.zzh);
            zzcsVar2.zzo(zzaluVar2.zzj);
            arrayList2.add(zzcsVar2.zzq());
        }
        return arrayList2;
    }

    public final void zzf(zzalq zzalqVar) {
        if (this.zzm == null) {
            this.zzm = new ArrayList();
        }
        this.zzm.add(zzalqVar);
    }

    public final boolean zzg(long j) {
        long j2 = this.zzd;
        if (j2 == -9223372036854775807L) {
            if (this.zze == -9223372036854775807L) {
                return true;
            }
            j2 = -9223372036854775807L;
        }
        if (j2 <= j && this.zze == -9223372036854775807L) {
            return true;
        }
        if (j2 != -9223372036854775807L || j >= this.zze) {
            return j2 <= j && j < this.zze;
        }
        return true;
    }

    public final long[] zzh() {
        TreeSet treeSet = new TreeSet();
        int i = 0;
        zzj(treeSet, false);
        long[] jArr = new long[treeSet.size()];
        Iterator it = treeSet.iterator();
        while (it.hasNext()) {
            jArr[i] = ((Long) it.next()).longValue();
            i++;
        }
        return jArr;
    }

    public static zzalq zzc(String str) {
        String str2 = GsPcpBmONXh.WhjHwfNHSdYPW;
        String str3 = eoBKjVuj.JkAHSiq;
        return new zzalq(null, str.replaceAll(str2, str3).replaceAll(" *\n *", str3).replaceAll(str3, " ").replaceAll("[ \t\\x0B\f\r]+", " "), -9223372036854775807L, -9223372036854775807L, null, null, "", null, null);
    }
}
