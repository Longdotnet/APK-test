package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import android.view.accessibility.CaptioningManager;
import com.google.android.finsky.externalreferrer.jUdg.RDFWIi;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes2.dex */
public final class zzyu extends zzza implements zzmc {
    public static final /* synthetic */ int zzb = 0;
    private static final zzgab zzc = zzgab.zzb(new Comparator() { // from class: com.google.android.gms.internal.ads.zzxu
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            Integer num = (Integer) obj;
            Integer num2 = (Integer) obj2;
            int i = zzyu.zzb;
            if (num.intValue() == -1) {
                return num2.intValue() == -1 ? 0 : -1;
            }
            if (num2.intValue() == -1) {
                return 1;
            }
            return num.intValue() - num2.intValue();
        }
    });
    public final Context zza;
    private final Object zzd;
    private zzyi zze;
    private Thread zzf;
    private zzym zzg;
    private zze zzh;
    private final zzxq zzi;

    public static /* bridge */ /* synthetic */ int zzb(int i, int i2) {
        if (i == 0 || i != i2) {
            return Integer.bitCount(i & i2);
        }
        return Integer.MAX_VALUE;
    }

    public static int zzc(zzz zzzVar, String str, boolean z) {
        if (!TextUtils.isEmpty(str) && str.equals(zzzVar.zzd)) {
            return 4;
        }
        String strZzh = zzh(str);
        String strZzh2 = zzh(zzzVar.zzd);
        if (strZzh2 == null || strZzh == null) {
            return (z && strZzh2 == null) ? 1 : 0;
        }
        if (strZzh2.startsWith(strZzh) || strZzh.startsWith(strZzh2)) {
            return 3;
        }
        String str2 = zzex.zza;
        return strZzh2.split("-", 2)[0].equals(strZzh.split("-", 2)[0]) ? 2 : 0;
    }

    public static String zzh(String str) {
        if (TextUtils.isEmpty(str) || TextUtils.equals(str, "und")) {
            return null;
        }
        return str;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static /* synthetic */ boolean zzm(zzyu zzyuVar, zzyi zzyiVar, zzz zzzVar) {
        zzym zzymVar;
        zzym zzymVar2;
        if (!zzyiVar.zzQ) {
            return true;
        }
        int i = zzzVar.zzG;
        byte b = -1;
        if (i == -1 || i <= 2) {
            return true;
        }
        String str = zzzVar.zzo;
        if (str != null) {
            switch (str.hashCode()) {
                case -2123537834:
                    if (str.equals("audio/eac3-joc")) {
                        b = 2;
                    }
                    break;
                case 187078296:
                    if (str.equals("audio/ac3")) {
                        b = 0;
                    }
                    break;
                case 187078297:
                    if (str.equals("audio/ac4")) {
                        b = 3;
                    }
                    break;
                case 1504578661:
                    if (str.equals("audio/eac3")) {
                        b = 1;
                    }
                    break;
            }
            if ((b == 0 || b == 1 || b == 2 || b == 3) && (Build.VERSION.SDK_INT < 32 || (zzymVar2 = zzyuVar.zzg) == null || !zzymVar2.zze())) {
                return true;
            }
        }
        if (Build.VERSION.SDK_INT >= 32 && (zzymVar = zzyuVar.zzg) != null && zzymVar.zze() && zzymVar.zzc() && zzyuVar.zzg.zzd()) {
            return zzyuVar.zzg.zzb(zzyuVar.zzh, zzzVar);
        }
        return false;
    }

    private static void zzt(zzxk zzxkVar, zzbr zzbrVar, Map map) {
        for (int i = 0; i < zzxkVar.zzb; i++) {
            if (((zzbn) zzbrVar.zzD.get(zzxkVar.zzb(i))) != null) {
                throw null;
            }
        }
    }

    public final void zzu() {
        boolean z;
        zzym zzymVar;
        synchronized (this.zzd) {
            try {
                z = false;
                if (this.zze.zzQ && Build.VERSION.SDK_INT >= 32 && (zzymVar = this.zzg) != null && zzymVar.zze()) {
                    z = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z) {
            zzs();
        }
    }

    private static final Pair zzv(int i, zzyz zzyzVar, int[][][] iArr, zzyo zzyoVar, Comparator comparator) {
        RandomAccess randomAccessZzo;
        boolean z;
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < 2; i2++) {
            if (i == zzyzVar.zzc(i2)) {
                zzxk zzxkVarZzd = zzyzVar.zzd(i2);
                for (int i3 = 0; i3 < zzxkVarZzd.zzb; i3++) {
                    zzbm zzbmVarZzb = zzxkVarZzd.zzb(i3);
                    List listZza = zzyoVar.zza(i2, zzbmVarZzb, iArr[i2][i3]);
                    int i4 = zzbmVarZzb.zza;
                    boolean[] zArr = new boolean[i4];
                    int i5 = 0;
                    while (i5 < i4) {
                        int i6 = i5 + 1;
                        zzyp zzypVar = (zzyp) listZza.get(i5);
                        int iZzb = zzypVar.zzb();
                        if (!zArr[i5] && iZzb != 0) {
                            if (iZzb == 1) {
                                randomAccessZzo = zzfyq.zzo(zzypVar);
                            } else {
                                ArrayList arrayList2 = new ArrayList();
                                arrayList2.add(zzypVar);
                                for (int i7 = i6; i7 < i4; i7++) {
                                    zzyp zzypVar2 = (zzyp) listZza.get(i7);
                                    if (zzypVar2.zzb() == 2 && zzypVar.zzc(zzypVar2)) {
                                        arrayList2.add(zzypVar2);
                                        z = true;
                                        zArr[i7] = true;
                                    } else {
                                        z = true;
                                    }
                                }
                                randomAccessZzo = arrayList2;
                            }
                            arrayList.add(randomAccessZzo);
                        }
                        i5 = i6;
                    }
                }
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        List list = (List) Collections.max(arrayList, comparator);
        int[] iArr2 = new int[list.size()];
        for (int i8 = 0; i8 < list.size(); i8++) {
            iArr2[i8] = ((zzyp) list.get(i8)).zzc;
        }
        zzyp zzypVar3 = (zzyp) list.get(0);
        return Pair.create(new zzyv(zzypVar3.zzb, iArr2, 0), Integer.valueOf(zzypVar3.zza));
    }

    @Override // com.google.android.gms.internal.ads.zzmc
    public final void zza(zzma zzmaVar) {
        synchronized (this.zzd) {
            boolean z = this.zze.zzU;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzza
    public final Pair zzd(zzyz zzyzVar, int[][][] iArr, final int[] iArr2, zzvh zzvhVar, zzbl zzblVar) {
        final zzyi zzyiVar;
        final boolean z;
        final String str;
        final String languageTag;
        int i;
        Context context;
        CaptioningManager captioningManager;
        Locale locale;
        Context context2;
        int i2 = 1;
        synchronized (this.zzd) {
            this.zzf = Thread.currentThread();
            zzyiVar = this.zze;
        }
        if (zzyiVar.zzQ && Build.VERSION.SDK_INT >= 32 && this.zzg == null) {
            this.zzg = new zzym(this.zza, this);
        }
        int i3 = 2;
        zzyv[] zzyvVarArr = new zzyv[2];
        int i4 = 0;
        int i5 = 0;
        while (true) {
            if (i5 >= 2) {
                z = false;
                break;
            }
            if (zzyzVar.zzc(i5) == 2 && zzyzVar.zzd(i5).zzb > 0) {
                z = true;
                break;
            }
            i5++;
        }
        Pair pairZzv = zzv(1, zzyzVar, iArr, new zzyo() { // from class: com.google.android.gms.internal.ads.zzxz
            @Override // com.google.android.gms.internal.ads.zzyo
            public final List zza(int i6, zzbm zzbmVar, int[] iArr3) {
                zzxz zzxzVar = this;
                final zzyu zzyuVar = zzxzVar.zza;
                final zzyi zzyiVar2 = zzyiVar;
                zzfvq zzfvqVar = new zzfvq() { // from class: com.google.android.gms.internal.ads.zzyb
                    @Override // com.google.android.gms.internal.ads.zzfvq
                    public final boolean zza(Object obj) {
                        return zzyu.zzm(zzyuVar, zzyiVar2, (zzz) obj);
                    }
                };
                int i7 = iArr2[i6];
                int i8 = zzfyq.zzd;
                zzfyn zzfynVar = new zzfyn();
                int i9 = 0;
                while (i9 < zzbmVar.zza) {
                    zzfynVar.zzf(new zzye(i6, zzbmVar, i9, zzyiVar2, iArr3[i9], z, zzfvqVar, i7));
                    i9++;
                    zzxzVar = this;
                }
                return zzfynVar.zzi();
            }
        }, new Comparator() { // from class: com.google.android.gms.internal.ads.zzya
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return ((zzye) Collections.max((List) obj)).compareTo((zzye) Collections.max((List) obj2));
            }
        });
        if (pairZzv != null) {
            zzyvVarArr[((Integer) pairZzv.second).intValue()] = (zzyv) pairZzv.first;
        }
        if (pairZzv == null) {
            str = null;
        } else {
            Object obj = pairZzv.first;
            str = ((zzyv) obj).zza.zzb(((zzyv) obj).zzb[0]).zzd;
        }
        int i6 = zzyiVar.zzu.zzb;
        final Point pointZzw = (!zzyiVar.zzk || (context2 = this.zza) == null) ? null : zzex.zzw(context2);
        Pair pairZzv2 = zzv(2, zzyzVar, iArr, new zzyo() { // from class: com.google.android.gms.internal.ads.zzxx
            /* JADX WARN: Code duplicated, block: B:29:0x004c  */
            @Override // com.google.android.gms.internal.ads.zzyo
            public final List zza(int i7, zzbm zzbmVar, int[] iArr3) {
                int i8;
                int i9;
                int i10;
                int i11;
                Point point;
                int i12 = zzyu.zzb;
                zzyi zzyiVar2 = zzyiVar;
                int i13 = iArr2[i7];
                Point point2 = pointZzw;
                int i14 = point2 != null ? point2.x : zzyiVar2.zzi;
                int i15 = point2 != null ? point2.y : zzyiVar2.zzj;
                boolean z2 = zzyiVar2.zzl;
                int i16 = -1;
                if (i14 == Integer.MAX_VALUE) {
                    i8 = Integer.MAX_VALUE;
                } else if (i15 == Integer.MAX_VALUE) {
                    i8 = Integer.MAX_VALUE;
                } else {
                    int i17 = Integer.MAX_VALUE;
                    for (int i18 = 0; i18 < zzbmVar.zza; i18++) {
                        zzz zzzVarZzb = zzbmVar.zzb(i18);
                        int i19 = zzzVarZzb.zzv;
                        if (i19 > 0 && (i9 = zzzVarZzb.zzw) > 0) {
                            if (!z2) {
                                i10 = i15;
                                i11 = i14;
                            } else if ((i19 > i9) != (i14 > i15)) {
                                i11 = i15;
                                i10 = i14;
                            } else {
                                i10 = i15;
                                i11 = i14;
                            }
                            int i20 = i19 * i10;
                            int i21 = i9 * i11;
                            if (i20 >= i21) {
                                String str2 = zzex.zza;
                                point = new Point(i11, ((i21 + i19) - 1) / i19);
                            } else {
                                String str3 = zzex.zza;
                                point = new Point(((i20 + i9) - 1) / i9, i10);
                            }
                            int i22 = i19 * i9;
                            if (i19 >= ((int) (point.x * 0.98f)) && i9 >= ((int) (point.y * 0.98f)) && i22 < i17) {
                                i17 = i22;
                            }
                        }
                    }
                    i8 = i17;
                }
                int i23 = zzfyq.zzd;
                zzfyn zzfynVar = new zzfyn();
                int i24 = 0;
                while (i24 < zzbmVar.zza) {
                    int iZza = zzbmVar.zzb(i24).zza();
                    zzfynVar.zzf(new zzys(i7, zzbmVar, i24, zzyiVar2, iArr3[i24], str, i13, i8 == Integer.MAX_VALUE || (iZza != i16 && iZza <= i8)));
                    i24++;
                    i16 = -1;
                }
                return zzfynVar.zzi();
            }
        }, new Comparator() { // from class: com.google.android.gms.internal.ads.zzxy
            @Override // java.util.Comparator
            public final int compare(Object obj2, Object obj3) {
                List list = (List) obj2;
                List list2 = (List) obj3;
                return zzfyf.zzj().zzc((zzys) Collections.max(list, new Comparator() { // from class: com.google.android.gms.internal.ads.zzyq
                    @Override // java.util.Comparator
                    public final int compare(Object obj4, Object obj5) {
                        return zzys.zzd((zzys) obj4, (zzys) obj5);
                    }
                }), (zzys) Collections.max(list2, new Comparator() { // from class: com.google.android.gms.internal.ads.zzyq
                    @Override // java.util.Comparator
                    public final int compare(Object obj4, Object obj5) {
                        return zzys.zzd((zzys) obj4, (zzys) obj5);
                    }
                }), new Comparator() { // from class: com.google.android.gms.internal.ads.zzyq
                    @Override // java.util.Comparator
                    public final int compare(Object obj4, Object obj5) {
                        return zzys.zzd((zzys) obj4, (zzys) obj5);
                    }
                }).zzb(list.size(), list2.size()).zzc((zzys) Collections.max(list, new Comparator() { // from class: com.google.android.gms.internal.ads.zzyr
                    @Override // java.util.Comparator
                    public final int compare(Object obj4, Object obj5) {
                        return zzys.zza((zzys) obj4, (zzys) obj5);
                    }
                }), (zzys) Collections.max(list2, new Comparator() { // from class: com.google.android.gms.internal.ads.zzyr
                    @Override // java.util.Comparator
                    public final int compare(Object obj4, Object obj5) {
                        return zzys.zza((zzys) obj4, (zzys) obj5);
                    }
                }), new Comparator() { // from class: com.google.android.gms.internal.ads.zzyr
                    @Override // java.util.Comparator
                    public final int compare(Object obj4, Object obj5) {
                        return zzys.zza((zzys) obj4, (zzys) obj5);
                    }
                }).zza();
            }
        });
        int i7 = 4;
        Pair pairZzv3 = pairZzv2 == null ? zzv(4, zzyzVar, iArr, new zzyo() { // from class: com.google.android.gms.internal.ads.zzxv
            @Override // com.google.android.gms.internal.ads.zzyo
            public final List zza(int i8, zzbm zzbmVar, int[] iArr3) {
                int i9 = zzyu.zzb;
                int i10 = zzfyq.zzd;
                zzfyn zzfynVar = new zzfyn();
                for (int i11 = 0; i11 < zzbmVar.zza; i11++) {
                    zzfynVar.zzf(new zzyf(i8, zzbmVar, i11, zzyiVar, iArr3[i11]));
                }
                return zzfynVar.zzi();
            }
        }, new Comparator() { // from class: com.google.android.gms.internal.ads.zzxw
            @Override // java.util.Comparator
            public final int compare(Object obj2, Object obj3) {
                return ((zzyf) ((List) obj2).get(0)).compareTo((zzyf) ((List) obj3).get(0));
            }
        }) : null;
        if (pairZzv3 != null) {
            zzyvVarArr[((Integer) pairZzv3.second).intValue()] = (zzyv) pairZzv3.first;
        } else if (pairZzv2 != null) {
            zzyvVarArr[((Integer) pairZzv2.second).intValue()] = (zzyv) pairZzv2.first;
        }
        if (!zzyiVar.zzx || (context = this.zza) == null || (captioningManager = (CaptioningManager) context.getSystemService("captioning")) == null || !captioningManager.isEnabled() || (locale = captioningManager.getLocale()) == null) {
            languageTag = null;
        } else {
            String str2 = zzex.zza;
            languageTag = locale.toLanguageTag();
        }
        int i8 = 3;
        Pair pairZzv4 = zzv(3, zzyzVar, iArr, new zzyo() { // from class: com.google.android.gms.internal.ads.zzyc
            @Override // com.google.android.gms.internal.ads.zzyo
            public final List zza(int i9, zzbm zzbmVar, int[] iArr3) {
                int i10 = zzyu.zzb;
                int i11 = zzfyq.zzd;
                zzfyn zzfynVar = new zzfyn();
                for (int i12 = 0; i12 < zzbmVar.zza; i12++) {
                    String str3 = languageTag;
                    int i13 = i12;
                    zzfynVar.zzf(new zzyn(i9, zzbmVar, i13, zzyiVar, iArr3[i12], str, str3));
                }
                return zzfynVar.zzi();
            }
        }, new Comparator() { // from class: com.google.android.gms.internal.ads.zzyd
            @Override // java.util.Comparator
            public final int compare(Object obj2, Object obj3) {
                return ((zzyn) ((List) obj2).get(0)).compareTo((zzyn) ((List) obj3).get(0));
            }
        });
        if (pairZzv4 != null) {
            zzyvVarArr[((Integer) pairZzv4.second).intValue()] = (zzyv) pairZzv4.first;
        }
        int i9 = 0;
        while (i9 < i3) {
            int iZzc = zzyzVar.zzc(i9);
            if (iZzc != i3 && iZzc != i2 && iZzc != i8 && iZzc != i7) {
                zzxk zzxkVarZzd = zzyzVar.zzd(i9);
                int[][] iArr3 = iArr[i9];
                int i10 = i4;
                int i11 = i10;
                zzbm zzbmVar = null;
                zzyg zzygVar = null;
                while (i10 < zzxkVarZzd.zzb) {
                    zzbm zzbmVarZzb = zzxkVarZzd.zzb(i10);
                    int[] iArr4 = iArr3[i10];
                    zzyg zzygVar2 = zzygVar;
                    for (int i12 = i4; i12 < zzbmVarZzb.zza; i12++) {
                        if (zzmb.zza(iArr4[i12], zzyiVar.zzR)) {
                            zzyg zzygVar3 = new zzyg(zzbmVarZzb.zzb(i12), iArr4[i12]);
                            if (zzygVar2 == null || zzygVar3.compareTo(zzygVar2) > 0) {
                                zzygVar2 = zzygVar3;
                                zzbmVar = zzbmVarZzb;
                                i11 = i12;
                            }
                        }
                        i2 = 1;
                    }
                    i10 += i2;
                    zzygVar = zzygVar2;
                    i4 = 0;
                }
                zzyvVarArr[i9] = zzbmVar == null ? null : new zzyv(zzbmVar, new int[]{i11}, 0);
                i2 = 1;
            }
            i9 += i2;
            i3 = 2;
            i4 = 0;
            i8 = 3;
            i7 = 4;
        }
        HashMap map = new HashMap();
        int i13 = 2;
        for (int i14 = 0; i14 < 2; i14 += i2) {
            zzt(zzyzVar.zzd(i14), zzyiVar, map);
        }
        zzt(zzyzVar.zze(), zzyiVar, map);
        for (int i15 = 0; i15 < 2; i15 += i2) {
            if (((zzbn) map.get(Integer.valueOf(zzyzVar.zzc(i15)))) != null) {
                throw null;
            }
        }
        int i16 = 0;
        while (i16 < i13) {
            zzxk zzxkVarZzd2 = zzyzVar.zzd(i16);
            if (zzyiVar.zzf(i16, zzxkVarZzd2)) {
                if (zzyiVar.zzd(i16, zzxkVarZzd2) != null) {
                    throw null;
                }
                zzyvVarArr[i16] = null;
            }
            i16++;
            i13 = 2;
        }
        int i17 = 0;
        for (int i18 = i13; i17 < i18; i18 = 2) {
            int iZzc2 = zzyzVar.zzc(i17);
            if (zzyiVar.zze(i17) || zzyiVar.zzE.contains(Integer.valueOf(iZzc2))) {
                zzyvVarArr[i17] = null;
                i = 1;
            } else {
                i = 1;
            }
            i17 += i;
        }
        zzxq zzxqVar = this.zzi;
        zzzl zzzlVarZzq = zzq();
        zzfyq zzfyqVarZzd = zzxr.zzd(zzyvVarArr);
        int i19 = 2;
        zzyw[] zzywVarArr = new zzyw[2];
        int i20 = 0;
        while (i20 < i19) {
            zzyv zzyvVar = zzyvVarArr[i20];
            if (zzyvVar != null) {
                int[] iArr5 = zzyvVar.zzb;
                int length = iArr5.length;
                if (length == 0) {
                    i20 = i20;
                } else {
                    zzywVarArr[i20] = length == 1 ? new zzyx(zzyvVar.zza, iArr5[0], 0, 0, null) : zzxqVar.zza(zzyvVar.zza, iArr5, 0, zzzlVarZzq, (zzfyq) zzfyqVarZzd.get(i20));
                }
                i20++;
                i19 = 2;
            } else {
                i20 = i20;
            }
            i20++;
            i19 = 2;
        }
        zzme[] zzmeVarArr = new zzme[i19];
        for (int i21 = 0; i21 < i19; i21++) {
            zzmeVarArr[i21] = (zzyiVar.zze(i21) || zzyiVar.zzE.contains(Integer.valueOf(zzyzVar.zzc(i21))) || (zzyzVar.zzc(i21) != -2 && zzywVarArr[i21] == null)) ? null : zzme.zza;
        }
        return Pair.create(zzmeVarArr, zzywVarArr);
    }

    @Override // com.google.android.gms.internal.ads.zzzd
    public final zzmc zze() {
        return this;
    }

    public final zzyi zzf() {
        zzyi zzyiVar;
        synchronized (this.zzd) {
            zzyiVar = this.zze;
        }
        return zzyiVar;
    }

    @Override // com.google.android.gms.internal.ads.zzzd
    public final void zzj() {
        zzym zzymVar;
        synchronized (this.zzd) {
            try {
                Thread thread = this.zzf;
                if (thread != null) {
                    zzdd.zzg(thread == Thread.currentThread(), "DefaultTrackSelector is accessed on the wrong thread.");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (Build.VERSION.SDK_INT >= 32 && (zzymVar = this.zzg) != null) {
            zzymVar.zza();
            this.zzg = null;
        }
        super.zzj();
    }

    @Override // com.google.android.gms.internal.ads.zzzd
    public final void zzk(zze zzeVar) {
        if (this.zzh.equals(zzeVar)) {
            return;
        }
        this.zzh = zzeVar;
        zzu();
    }

    public final void zzl(zzyh zzyhVar) {
        boolean zEquals;
        zzyi zzyiVar = new zzyi(zzyhVar);
        synchronized (this.zzd) {
            zEquals = this.zze.equals(zzyiVar);
            this.zze = zzyiVar;
        }
        if (zEquals) {
            return;
        }
        if (zzyiVar.zzQ && this.zza == null) {
            zzea.zzf("DefaultTrackSelector", "Audio channel count constraints cannot be applied without reference to Context. Build the track selector instance with one of the non-deprecated constructors that take a Context argument.");
        }
        zzs();
    }

    @Override // com.google.android.gms.internal.ads.zzzd
    public final boolean zzn() {
        return true;
    }

    public zzyu(Context context) {
        zzxq zzxqVar = new zzxq();
        zzyi zzyiVar = zzyi.zzF;
        this.zzd = new Object();
        this.zza = context != null ? context.getApplicationContext() : null;
        this.zzi = zzxqVar;
        if (zzyiVar instanceof zzyi) {
            this.zze = zzyiVar;
        } else {
            zzyh zzyhVar = new zzyh(zzyiVar, null);
            zzyhVar.zzw(zzyiVar);
            this.zze = new zzyi(zzyhVar);
        }
        this.zzh = zze.zza;
        if (this.zze.zzQ && context == null) {
            zzea.zzf("DefaultTrackSelector", RDFWIi.LEBNHPI);
        }
    }
}
