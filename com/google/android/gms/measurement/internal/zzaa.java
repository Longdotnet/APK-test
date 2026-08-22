package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import androidx.collection.ArrayMap;
import androidx.collection.MapCollections$KeySet;
import androidx.collection.SimpleArrayMap;
import androidx.emoji2.text.flatbuffer.bs.bUqMCsuPSX;
import com.google.android.gms.internal.measurement.zzek;
import com.google.android.gms.internal.measurement.zzet;
import com.google.android.gms.internal.measurement.zzfp;
import com.google.android.gms.internal.measurement.zzft;
import com.google.android.gms.internal.measurement.zzgh;
import com.google.android.gms.internal.measurement.zzgk;
import com.google.android.gms.internal.measurement.zznz;
import com.google.android.gms.internal.measurement.zzoc;
import java.io.IOException;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import okhttp3.internal.connection.RealConnectionPool;

/* JADX INFO: loaded from: classes2.dex */
public final class zzaa extends zzkh {
    public String zza;
    public HashSet zzb;
    public ArrayMap zzc;
    public Long zzd;
    public Long zze;

    /* JADX WARN: Code duplicated, block: B:101:0x0246 A[LOOP:22: B:84:0x01f4->B:101:0x0246, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:116:0x0278  */
    /* JADX WARN: Code duplicated, block: B:121:0x0290  */
    /* JADX WARN: Code duplicated, block: B:123:0x029b  */
    /* JADX WARN: Code duplicated, block: B:127:0x02c5 A[Catch: all -> 0x02e0, SQLiteException -> 0x02e2, LOOP:11: B:127:0x02c5->B:545:?, LOOP_START, TryCatch #0 {all -> 0x02e0, blocks: (B:125:0x02bf, B:127:0x02c5, B:129:0x02d6, B:135:0x02e4, B:138:0x02f9, B:147:0x0309), top: B:463:0x02b5 }] */
    /* JADX WARN: Code duplicated, block: B:129:0x02d6 A[Catch: all -> 0x02e0, SQLiteException -> 0x02e2, TryCatch #0 {all -> 0x02e0, blocks: (B:125:0x02bf, B:127:0x02c5, B:129:0x02d6, B:135:0x02e4, B:138:0x02f9, B:147:0x0309), top: B:463:0x02b5 }] */
    /* JADX WARN: Code duplicated, block: B:138:0x02f9 A[Catch: all -> 0x02e0, SQLiteException -> 0x02e2, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x02e0, blocks: (B:125:0x02bf, B:127:0x02c5, B:129:0x02d6, B:135:0x02e4, B:138:0x02f9, B:147:0x0309), top: B:463:0x02b5 }] */
    /* JADX WARN: Code duplicated, block: B:153:0x0335  */
    /* JADX WARN: Code duplicated, block: B:156:0x0343  */
    /* JADX WARN: Code duplicated, block: B:158:0x035a  */
    /* JADX WARN: Code duplicated, block: B:198:0x0472  */
    /* JADX WARN: Code duplicated, block: B:200:0x0476  */
    /* JADX WARN: Code duplicated, block: B:204:0x0481  */
    /* JADX WARN: Code duplicated, block: B:206:0x04a2  */
    /* JADX WARN: Code duplicated, block: B:212:0x04b7  */
    /* JADX WARN: Code duplicated, block: B:216:0x04d1  */
    /* JADX WARN: Code duplicated, block: B:217:0x04da  */
    /* JADX WARN: Code duplicated, block: B:221:0x04e6  */
    /* JADX WARN: Code duplicated, block: B:227:0x04fd  */
    /* JADX WARN: Code duplicated, block: B:233:0x0533  */
    /* JADX WARN: Code duplicated, block: B:236:0x053c  */
    /* JADX WARN: Code duplicated, block: B:238:0x0546  */
    /* JADX WARN: Code duplicated, block: B:240:0x0566  */
    /* JADX WARN: Code duplicated, block: B:241:0x056a  */
    /* JADX WARN: Code duplicated, block: B:246:0x0582 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:270:0x0623  */
    /* JADX WARN: Code duplicated, block: B:273:0x0637  */
    /* JADX WARN: Code duplicated, block: B:277:0x0659  */
    /* JADX WARN: Code duplicated, block: B:279:0x0699  */
    /* JADX WARN: Code duplicated, block: B:282:0x06e2  */
    /* JADX WARN: Code duplicated, block: B:286:0x071d  */
    /* JADX WARN: Code duplicated, block: B:293:0x0745  */
    /* JADX WARN: Code duplicated, block: B:299:0x0754  */
    /* JADX WARN: Code duplicated, block: B:309:0x077e A[LOOP:3: B:287:0x071f->B:309:0x077e, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:310:0x0781  */
    /* JADX WARN: Code duplicated, block: B:312:0x0789 A[PHI: r0 r5 r19 r29
  0x0789: PHI (r0v141 java.util.Map) = (r0v203 java.util.Map), (r0v204 java.util.Map) binds: [B:323:0x07b1, B:311:0x0785] A[DONT_GENERATE, DONT_INLINE]
  0x0789: PHI (r5v24 android.database.Cursor) = (r5v25 android.database.Cursor), (r5v26 android.database.Cursor) binds: [B:323:0x07b1, B:311:0x0785] A[DONT_GENERATE, DONT_INLINE]
  0x0789: PHI (r19v19 com.google.android.gms.measurement.internal.zzas) = (r19v20 com.google.android.gms.measurement.internal.zzas), (r19v24 com.google.android.gms.measurement.internal.zzas) binds: [B:323:0x07b1, B:311:0x0785] A[DONT_GENERATE, DONT_INLINE]
  0x0789: PHI (r29v3 okhttp3.internal.connection.RealConnectionPool) = (r29v4 okhttp3.internal.connection.RealConnectionPool), (r29v7 okhttp3.internal.connection.RealConnectionPool) binds: [B:323:0x07b1, B:311:0x0785] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:329:0x07be  */
    /* JADX WARN: Code duplicated, block: B:333:0x07d0  */
    /* JADX WARN: Code duplicated, block: B:339:0x0800  */
    /* JADX WARN: Code duplicated, block: B:341:0x0836  */
    /* JADX WARN: Code duplicated, block: B:342:0x0839  */
    /* JADX WARN: Code duplicated, block: B:345:0x0855 A[LOOP:5: B:337:0x07fa->B:345:0x0855, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:349:0x0875  */
    /* JADX WARN: Code duplicated, block: B:355:0x088e  */
    /* JADX WARN: Code duplicated, block: B:358:0x089d  */
    /* JADX WARN: Code duplicated, block: B:360:0x08b0  */
    /* JADX WARN: Code duplicated, block: B:364:0x08eb A[Catch: all -> 0x091c, SQLiteException -> 0x092e, LOOP:7: B:364:0x08eb->B:385:0x0951, LOOP_START, PHI: r4 r10
  0x08eb: PHI (r4v43 androidx.collection.SimpleArrayMap) = (r4v61 androidx.collection.SimpleArrayMap), (r4v45 androidx.collection.SimpleArrayMap) binds: [B:363:0x08e9, B:385:0x0951] A[DONT_GENERATE, DONT_INLINE]
  0x08eb: PHI (r10v14 java.util.Iterator) = (r10v10 java.util.Iterator), (r10v16 java.util.Iterator) binds: [B:363:0x08e9, B:385:0x0951] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #16 {SQLiteException -> 0x092e, blocks: (B:362:0x08e5, B:364:0x08eb, B:365:0x08f0, B:367:0x0901), top: B:481:0x08e5 }] */
    /* JADX WARN: Code duplicated, block: B:369:0x0911  */
    /* JADX WARN: Code duplicated, block: B:375:0x0920  */
    /* JADX WARN: Code duplicated, block: B:385:0x0951 A[LOOP:7: B:364:0x08eb->B:385:0x0951, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:386:0x0956  */
    /* JADX WARN: Code duplicated, block: B:403:0x098b  */
    /* JADX WARN: Code duplicated, block: B:407:0x099b  */
    /* JADX WARN: Code duplicated, block: B:411:0x09bd  */
    /* JADX WARN: Code duplicated, block: B:414:0x09ce  */
    /* JADX WARN: Code duplicated, block: B:416:0x09e4  */
    /* JADX WARN: Code duplicated, block: B:418:0x09f2  */
    /* JADX WARN: Code duplicated, block: B:419:0x09fb  */
    /* JADX WARN: Code duplicated, block: B:423:0x0a28  */
    /* JADX WARN: Code duplicated, block: B:437:0x0aa0  */
    /* JADX WARN: Code duplicated, block: B:438:0x0aa9  */
    /* JADX WARN: Code duplicated, block: B:442:0x0abd A[PHI: r0 r57
  0x0abd: PHI (r0v90 java.lang.Integer) = (r0v91 java.lang.Integer), (r0v92 java.lang.Integer) binds: [B:441:0x0abb, B:439:0x0aaa] A[DONT_GENERATE, DONT_INLINE]
  0x0abd: PHI (r57v3 ??) = (r57v4 ??), (r57v5 ??) binds: [B:441:0x0abb, B:439:0x0aaa] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:447:0x0ae2  */
    /* JADX WARN: Code duplicated, block: B:452:0x0b40 A[Catch: SQLiteException -> 0x0b54, TRY_LEAVE, TryCatch #4 {SQLiteException -> 0x0b54, blocks: (B:450:0x0b36, B:452:0x0b40), top: B:468:0x0b36 }] */
    /* JADX WARN: Code duplicated, block: B:461:0x0b6d  */
    /* JADX WARN: Code duplicated, block: B:516:0x0645 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:518:0x0631 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:520:0x0779 A[EDGE_INSN: B:520:0x0779->B:308:0x0779 BREAK  A[LOOP:3: B:287:0x071f->B:309:0x077e], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:522:0x07ef A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:523:0x07e3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:527:0x086c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:528:0x0866 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:532:0x094b A[EDGE_INSN: B:532:0x094b->B:384:0x094b BREAK  A[LOOP:7: B:364:0x08eb->B:385:0x0951], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:533:0x09ae A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:535:0x0ac2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:536:0x0a30 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:539:0x0ab4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:53:0x0166 A[PHI: r0 r5 r11 r16 r18 r24
  0x0166: PHI (r0v179 java.util.Map) = (r0v181 java.util.Map), (r0v187 java.util.Map) binds: [B:67:0x0193, B:52:0x0162] A[DONT_GENERATE, DONT_INLINE]
  0x0166: PHI (r5v29 android.database.Cursor) = (r5v30 android.database.Cursor), (r5v31 android.database.Cursor) binds: [B:67:0x0193, B:52:0x0162] A[DONT_GENERATE, DONT_INLINE]
  0x0166: PHI (r11v40 java.lang.Object) = (r11v53 java.lang.Object), (r11v54 java.lang.Object) binds: [B:67:0x0193, B:52:0x0162] A[DONT_GENERATE, DONT_INLINE]
  0x0166: PHI (r16v10 ??) = (r16v22 ??), (r16v14 ??) binds: [B:67:0x0193, B:52:0x0162] A[DONT_GENERATE, DONT_INLINE]
  0x0166: PHI (r18v6 ??) = (r18v22 ??), (r18v10 ??) binds: [B:67:0x0193, B:52:0x0162] A[DONT_GENERATE, DONT_INLINE]
  0x0166: PHI (r24v13 java.lang.String) = (r24v14 java.lang.String), (r24v15 java.lang.String) binds: [B:67:0x0193, B:52:0x0162] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:542:0x0b51 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:548:0x0360 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:568:0x05e0 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:575:0x04c3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:577:0x04b1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:580:0x0509 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:583:0x04f7 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:593:0x0242 A[EDGE_INSN: B:593:0x0242->B:100:0x0242 BREAK  A[LOOP:22: B:84:0x01f4->B:101:0x0246], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:70:0x0198  */
    /* JADX WARN: Code duplicated, block: B:77:0x01d6 A[Catch: SQLiteException -> 0x01e6, all -> 0x021e, TRY_LEAVE, TryCatch #14 {SQLiteException -> 0x01e6, blocks: (B:75:0x01d0, B:77:0x01d6, B:83:0x01ef, B:84:0x01f4, B:85:0x01fe, B:86:0x020e, B:91:0x0221), top: B:479:0x01d0 }] */
    /* JADX WARN: Code duplicated, block: B:83:0x01ef A[Catch: SQLiteException -> 0x01e6, all -> 0x021e, TRY_ENTER, TryCatch #14 {SQLiteException -> 0x01e6, blocks: (B:75:0x01d0, B:77:0x01d6, B:83:0x01ef, B:84:0x01f4, B:85:0x01fe, B:86:0x020e, B:91:0x0221), top: B:479:0x01d0 }] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v207 */
    /* JADX WARN: Type inference failed for: r0v208 */
    /* JADX WARN: Type inference failed for: r0v209 */
    /* JADX WARN: Type inference failed for: r0v210 */
    /* JADX WARN: Type inference failed for: r0v213 */
    /* JADX WARN: Type inference failed for: r0v214 */
    /* JADX WARN: Type inference failed for: r0v35, types: [androidx.collection.ArrayMap, androidx.collection.SimpleArrayMap] */
    /* JADX WARN: Type inference failed for: r0v41, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r0v42 */
    /* JADX WARN: Type inference failed for: r0v44, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r0v45 */
    /* JADX WARN: Type inference failed for: r0v46 */
    /* JADX WARN: Type inference failed for: r0v61 */
    /* JADX WARN: Type inference failed for: r0v63, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r0v83, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r0v84, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r0v87 */
    /* JADX WARN: Type inference failed for: r0v89 */
    /* JADX WARN: Type inference failed for: r0v94 */
    /* JADX WARN: Type inference failed for: r11v12 */
    /* JADX WARN: Type inference failed for: r11v13, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r11v14 */
    /* JADX WARN: Type inference failed for: r11v37 */
    /* JADX WARN: Type inference failed for: r11v38, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r11v39 */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r11v49 */
    /* JADX WARN: Type inference failed for: r11v6, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r15v10, types: [androidx.collection.ArrayMap, androidx.collection.SimpleArrayMap] */
    /* JADX WARN: Type inference failed for: r16v0 */
    /* JADX WARN: Type inference failed for: r16v1 */
    /* JADX WARN: Type inference failed for: r16v10 */
    /* JADX WARN: Type inference failed for: r16v11 */
    /* JADX WARN: Type inference failed for: r16v14 */
    /* JADX WARN: Type inference failed for: r16v16 */
    /* JADX WARN: Type inference failed for: r16v17 */
    /* JADX WARN: Type inference failed for: r16v18 */
    /* JADX WARN: Type inference failed for: r16v19 */
    /* JADX WARN: Type inference failed for: r16v2 */
    /* JADX WARN: Type inference failed for: r16v20 */
    /* JADX WARN: Type inference failed for: r16v21 */
    /* JADX WARN: Type inference failed for: r16v22 */
    /* JADX WARN: Type inference failed for: r16v9 */
    /* JADX WARN: Type inference failed for: r18v0 */
    /* JADX WARN: Type inference failed for: r18v1 */
    /* JADX WARN: Type inference failed for: r18v10 */
    /* JADX WARN: Type inference failed for: r18v17 */
    /* JADX WARN: Type inference failed for: r18v18 */
    /* JADX WARN: Type inference failed for: r18v19 */
    /* JADX WARN: Type inference failed for: r18v2 */
    /* JADX WARN: Type inference failed for: r18v20 */
    /* JADX WARN: Type inference failed for: r18v21 */
    /* JADX WARN: Type inference failed for: r18v22 */
    /* JADX WARN: Type inference failed for: r18v5 */
    /* JADX WARN: Type inference failed for: r18v6 */
    /* JADX WARN: Type inference failed for: r18v7 */
    /* JADX WARN: Type inference failed for: r18v9 */
    /* JADX WARN: Type inference failed for: r57v1 */
    /* JADX WARN: Type inference failed for: r57v2 */
    /* JADX WARN: Type inference failed for: r57v3 */
    /* JADX WARN: Type inference failed for: r57v4 */
    /* JADX WARN: Type inference failed for: r57v5 */
    /* JADX WARN: Type inference failed for: r57v6 */
    /* JADX WARN: Type inference failed for: r57v7 */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final ArrayList zza(String str, List list, List list2, Long l, Long l2) throws Throwable {
        String str2;
        boolean z;
        String str3;
        ?? r16;
        ?? r18;
        Object obj;
        Map map;
        ?? r19;
        ?? r17;
        Object obj2;
        ?? r11;
        String str4;
        String str5;
        Cursor cursorQuery;
        Map map2;
        Map map3;
        Iterator it;
        Map map4;
        Map map5;
        Map map6;
        Integer num;
        com.google.android.gms.internal.measurement.zzgi zzgiVar;
        BitSet bitSet;
        BitSet bitSet2;
        ArrayMap arrayMap;
        List<zzek> list3;
        int i;
        zzkt zzktVar;
        Iterator it2;
        zzgk zzgkVar;
        Long lValueOf;
        String str6;
        ?? arrayMap2;
        SQLiteDatabase sQLiteDatabaseZzh;
        ?? r12;
        Cursor cursorRawQuery;
        ?? r0;
        ArrayMap arrayMap3;
        Iterator it3;
        Integer num2;
        com.google.android.gms.internal.measurement.zzgi zzgiVar2;
        List list4;
        zzag zzagVar;
        Iterator it4;
        Integer numValueOf;
        List arrayList;
        zzkt zzktVar2;
        String str7;
        String str8;
        String str9;
        ArrayList arrayList2;
        zzam zzamVarZzi;
        zzfr zzfrVar;
        String str10;
        ContentValues contentValues;
        ArrayMap arrayMap4;
        Iterator it5;
        String strZzf;
        Map map7;
        Iterator it6;
        ?? r1;
        ?? r2;
        Iterator it7;
        boolean zZzd;
        ?? r3;
        ?? r57;
        Integer num3;
        zzet zzetVar;
        Integer numValueOf2;
        zzx zzxVar;
        ?? r58;
        Integer numValueOf3;
        String str11;
        Cursor cursor;
        Cursor cursorQuery2;
        Map mapEmptyMap;
        Object obj3;
        SimpleArrayMap simpleArrayMap;
        Integer numValueOf4;
        List list5;
        List arrayList3;
        RealConnectionPool realConnectionPool;
        ?? arrayMap5;
        Iterator it8;
        zzft zzftVar;
        zzft zzftVarZza;
        zzam zzamVarZzi2;
        String str12;
        String strZzh;
        zzas zzasVarZzn;
        zzas zzasVar;
        zzas zzasVar2;
        String strZzh2;
        Map map8;
        zzas zzasVar3;
        RealConnectionPool realConnectionPool2;
        Map map9;
        Iterator it9;
        Integer num4;
        int iIntValue;
        Iterator it10;
        boolean zZzd2;
        Map map10;
        Iterator it11;
        zzas zzasVar4;
        Map map11;
        Integer num5;
        zzx zzxVar2;
        Map map12;
        int iZzb;
        zzu zzuVar;
        boolean z2;
        String str13;
        ArrayMap arrayMap6;
        Cursor cursor2;
        Cursor cursorQuery3;
        Map mapEmptyMap2;
        Map map13;
        Integer numValueOf5;
        List list6;
        List arrayList4;
        ArrayMap arrayMap7;
        int i2;
        ?? r13;
        ?? r110;
        ?? r111;
        Cursor cursorQuery4;
        ?? r112;
        ?? r113;
        Object obj4;
        boolean z3;
        boolean z4;
        List arrayList5;
        String str14;
        String str15 = bUqMCsuPSX.gWnFOxD;
        com.google.android.gms.common.internal.zzah.checkNotEmpty(str);
        com.google.android.gms.common.internal.zzah.checkNotNull(list);
        com.google.android.gms.common.internal.zzah.checkNotNull(list2);
        this.zza = str;
        this.zzb = new HashSet();
        this.zzc = new ArrayMap();
        this.zzd = l;
        this.zze = l2;
        Iterator it12 = list.iterator();
        while (true) {
            str2 = null;
            str14 = null;
            if (!it12.hasNext()) {
                z = false;
                break;
            }
            if ("_s".equals(((zzft) it12.next()).zzh())) {
                z = true;
                break;
            }
        }
        zznz.zzc();
        zzfr zzfrVar2 = (zzfr) this.mBuilder;
        boolean zZzs = zzfrVar2.zzk.zzs(this.zza, zzdu.zzW);
        zznz.zzc();
        String str16 = this.zza;
        zzdt zzdtVar = zzdu.zzV;
        zzag zzagVar2 = zzfrVar2.zzk;
        boolean zZzs2 = zzagVar2.zzs(str16, zzdtVar);
        zzkt zzktVar3 = this.zzf;
        if (z) {
            zzam zzamVarZzi3 = zzktVar3.zzi();
            String str17 = this.zza;
            zzamVarZzi3.zzW();
            zzamVarZzi3.zzg();
            com.google.android.gms.common.internal.zzah.checkNotEmpty(str17);
            ContentValues contentValues2 = new ContentValues();
            contentValues2.put("current_session_count", (Integer) 0);
            try {
                str14 = "app_id = ?";
                zzamVarZzi3.zzh().update("events", contentValues2, "app_id = ?", new String[]{str17});
                str2 = "app_id = ?";
            } catch (SQLiteException e) {
                ((zzfr) zzamVarZzi3.mBuilder).zzay().zzd().zzc(zzeh.zzn(str17), "Error resetting session-scoped event counts. appId", e);
                str2 = str14;
            }
        }
        Map mapEmptyMap3 = Collections.emptyMap();
        String str18 = "Failed to merge filter. appId";
        String str19 = "Database error querying filters. appId";
        String str20 = "audience_id";
        try {
            try {
                try {
                    if (zZzs2 && zZzs) {
                        zzam zzamVarZzi4 = zzktVar3.zzi();
                        zzfr zzfrVar3 = (zzfr) zzamVarZzi4.mBuilder;
                        String str21 = this.zza;
                        com.google.android.gms.common.internal.zzah.checkNotEmpty(str21);
                        ArrayMap arrayMap8 = new ArrayMap();
                        SQLiteDatabase sQLiteDatabaseZzh2 = zzamVarZzi4.zzh();
                        try {
                            try {
                                try {
                                    String[] strArr = {"audience_id", "data"};
                                    str3 = "data";
                                    try {
                                        cursorQuery4 = sQLiteDatabaseZzh2.query("event_filters", strArr, "app_id=?", new String[]{str21}, null, null, null);
                                        try {
                                            try {
                                                if (cursorQuery4.moveToFirst()) {
                                                    z3 = zZzs;
                                                    zZzs2 = zZzs2;
                                                    while (true) {
                                                        try {
                                                            try {
                                                                zzek zzekVar = (zzek) ((com.google.android.gms.internal.measurement.zzej) zzen.zzl(zzek.zzc(), cursorQuery4.getBlob(1))).zzaC();
                                                                if (zzekVar.zzo()) {
                                                                    Integer numValueOf6 = Integer.valueOf(cursorQuery4.getInt(0));
                                                                    List list7 = (List) arrayMap8.get(numValueOf6);
                                                                    if (list7 == null) {
                                                                        arrayList5 = new ArrayList();
                                                                        arrayMap8.put(numValueOf6, arrayList5);
                                                                    } else {
                                                                        arrayList5 = list7;
                                                                    }
                                                                    arrayList5.add(zzekVar);
                                                                    z4 = zZzs2;
                                                                } else {
                                                                    z4 = zZzs2 ? 1 : 0;
                                                                }
                                                            } catch (IOException e2) {
                                                                z4 = zZzs2 ? 1 : 0;
                                                                zzfrVar3.zzay().zzd().zzc(zzeh.zzn(str21), "Failed to merge filter. appId", e2);
                                                            }
                                                            if (!cursorQuery4.moveToNext()) {
                                                                break;
                                                            }
                                                            zZzs2 = z4;
                                                        } catch (SQLiteException e3) {
                                                            e = e3;
                                                            r111 = zZzs2;
                                                            r110 = z3;
                                                            zzef zzefVarZzd = zzfrVar3.zzay().zzd();
                                                            zzeg zzegVarZzn = zzeh.zzn(str21);
                                                            zzefVarZzd.zzc(zzegVarZzn, "Database error querying filters. appId", e);
                                                            mapEmptyMap3 = Collections.emptyMap();
                                                            obj = zzegVarZzn;
                                                            r16 = r110;
                                                            r18 = r111;
                                                            obj4 = zzegVarZzn;
                                                            r113 = r110;
                                                            r112 = r111;
                                                            if (cursorQuery4 != null) {
                                                                cursorQuery4.close();
                                                                obj = obj4;
                                                                r16 = r113;
                                                                r18 = r112;
                                                            }
                                                            map = mapEmptyMap3;
                                                            obj2 = obj;
                                                            r17 = r16;
                                                            r19 = r18;
                                                        }
                                                    }
                                                    cursorQuery4.close();
                                                    obj2 = str21;
                                                    map = arrayMap8;
                                                    r17 = z3;
                                                    r19 = z4;
                                                } else {
                                                    r113 = zZzs;
                                                    r112 = zZzs2 ? 1 : 0;
                                                    mapEmptyMap3 = Collections.emptyMap();
                                                    obj4 = str21;
                                                    cursorQuery4.close();
                                                    obj = obj4;
                                                    r16 = r113;
                                                    r18 = r112;
                                                }
                                            } catch (SQLiteException e4) {
                                                e = e4;
                                                r110 = sQLiteDatabaseZzh2;
                                                r111 = strArr;
                                                zzef zzefVarZzd2 = zzfrVar3.zzay().zzd();
                                                zzeg zzegVarZzn2 = zzeh.zzn(str21);
                                                zzefVarZzd2.zzc(zzegVarZzn2, "Database error querying filters. appId", e);
                                                mapEmptyMap3 = Collections.emptyMap();
                                                obj = zzegVarZzn2;
                                                r16 = r110;
                                                r18 = r111;
                                                obj4 = zzegVarZzn2;
                                                r113 = r110;
                                                r112 = r111;
                                                if (cursorQuery4 != null) {
                                                }
                                                map = mapEmptyMap3;
                                                obj2 = obj;
                                                r17 = r16;
                                                r19 = r18;
                                                zzam zzamVarZzi5 = zzktVar3.zzi();
                                                zzfr zzfrVar4 = (zzfr) zzamVarZzi5.mBuilder;
                                                String str22 = this.zza;
                                                zzamVarZzi5.zzW();
                                                zzamVarZzi5.zzg();
                                                com.google.android.gms.common.internal.zzah.checkNotEmpty(str22);
                                                cursorQuery = zzamVarZzi5.zzh().query("audience_filter_values", new String[]{"audience_id", str15}, "app_id=?", new String[]{str22}, null, null, null);
                                                if (cursorQuery.moveToFirst()) {
                                                    arrayMap7 = new ArrayMap();
                                                    while (true) {
                                                        i2 = cursorQuery.getInt(0);
                                                        try {
                                                            arrayMap7.put(Integer.valueOf(i2), (com.google.android.gms.internal.measurement.zzgi) ((zzgh) zzen.zzl(com.google.android.gms.internal.measurement.zzgi.zzf(), cursorQuery.getBlob(1))).zzaC());
                                                            str4 = str20;
                                                            str5 = str19;
                                                        } catch (IOException e5) {
                                                            str4 = str20;
                                                            str5 = str19;
                                                            try {
                                                                zzfrVar4.zzay().zzd().zzd("Failed to merge filter results. appId, audienceId, error", zzeh.zzn(str22), Integer.valueOf(i2), e5);
                                                            } catch (SQLiteException e6) {
                                                                e = e6;
                                                                str18 = str18;
                                                                zzfrVar4.zzay().zzd().zzc(zzeh.zzn(str22), "Database error querying filter results. appId", e);
                                                                Map mapEmptyMap4 = Collections.emptyMap();
                                                                if (cursorQuery != null) {
                                                                    cursorQuery.close();
                                                                }
                                                                map2 = mapEmptyMap4;
                                                                if (!map2.isEmpty()) {
                                                                    HashSet hashSet = new HashSet(map2.keySet());
                                                                    if (z) {
                                                                        String str23 = this.zza;
                                                                        zzam zzamVarZzi6 = zzktVar3.zzi();
                                                                        str6 = this.zza;
                                                                        zzamVarZzi6.zzW();
                                                                        zzamVarZzi6.zzg();
                                                                        com.google.android.gms.common.internal.zzah.checkNotEmpty(str6);
                                                                        arrayMap2 = new ArrayMap();
                                                                        sQLiteDatabaseZzh = zzamVarZzi6.zzh();
                                                                        try {
                                                                            try {
                                                                                cursorRawQuery = sQLiteDatabaseZzh.rawQuery("select audience_id, filter_id from event_filters where app_id = ? and session_scoped = 1 UNION select audience_id, filter_id from property_filters where app_id = ? and session_scoped = 1;", new String[]{str6, str6});
                                                                                try {
                                                                                    if (cursorRawQuery.moveToFirst()) {
                                                                                        do {
                                                                                            numValueOf = Integer.valueOf(cursorRawQuery.getInt(0));
                                                                                            arrayList = (List) arrayMap2.get(numValueOf);
                                                                                            if (arrayList == null) {
                                                                                                arrayList = new ArrayList();
                                                                                                arrayMap2.put(numValueOf, arrayList);
                                                                                            }
                                                                                            arrayList.add(Integer.valueOf(cursorRawQuery.getInt(1)));
                                                                                        } while (cursorRawQuery.moveToNext());
                                                                                    } else {
                                                                                        arrayMap2 = Collections.emptyMap();
                                                                                    }
                                                                                } catch (SQLiteException e7) {
                                                                                    e = e7;
                                                                                    ((zzfr) zzamVarZzi6.mBuilder).zzay().zzd().zzc(zzeh.zzn(str6), "Database error querying scoped filters. appId", e);
                                                                                    arrayMap2 = Collections.emptyMap();
                                                                                    r0 = arrayMap2;
                                                                                    if (cursorRawQuery != null) {
                                                                                    }
                                                                                    com.google.android.gms.common.internal.zzah.checkNotEmpty(str23);
                                                                                    arrayMap3 = new ArrayMap();
                                                                                    if (!map2.isEmpty()) {
                                                                                        it3 = map2.keySet().iterator();
                                                                                        while (it3.hasNext()) {
                                                                                            num2 = (Integer) it3.next();
                                                                                            num2.getClass();
                                                                                            zzgiVar2 = (com.google.android.gms.internal.measurement.zzgi) map2.get(num2);
                                                                                            list4 = (List) r0.get(num2);
                                                                                            if (list4 != null) {
                                                                                            }
                                                                                            zzagVar = zzagVar2;
                                                                                            it4 = it3;
                                                                                            arrayMap3.put(num2, zzgiVar2);
                                                                                            r0 = r0;
                                                                                            zzagVar2 = zzagVar;
                                                                                            it3 = it4;
                                                                                        }
                                                                                    }
                                                                                    map3 = arrayMap3;
                                                                                    it = hashSet.iterator();
                                                                                    map6 = map3;
                                                                                    map5 = map;
                                                                                    map4 = map2;
                                                                                    while (it.hasNext()) {
                                                                                        num = (Integer) it.next();
                                                                                        num.getClass();
                                                                                        zzgiVar = (com.google.android.gms.internal.measurement.zzgi) map6.get(num);
                                                                                        bitSet = new BitSet();
                                                                                        bitSet2 = new BitSet();
                                                                                        arrayMap = new ArrayMap();
                                                                                        if (zzgiVar != null) {
                                                                                            for (com.google.android.gms.internal.measurement.zzfr zzfrVar5 : zzgiVar.zzj()) {
                                                                                                if (zzfrVar5.zzh()) {
                                                                                                    Integer numValueOf7 = Integer.valueOf(zzfrVar5.zza());
                                                                                                    if (zzfrVar5.zzg()) {
                                                                                                        lValueOf = Long.valueOf(zzfrVar5.zzb());
                                                                                                    } else {
                                                                                                        lValueOf = null;
                                                                                                    }
                                                                                                    arrayMap.put(numValueOf7, lValueOf);
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                        ArrayMap arrayMap9 = new ArrayMap();
                                                                                        if (zzgiVar != null) {
                                                                                            it2 = zzgiVar.zzm().iterator();
                                                                                            while (it2.hasNext()) {
                                                                                                zzgkVar = (zzgk) it2.next();
                                                                                                if (!zzgkVar.zzi()) {
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                        Map map14 = map6;
                                                                                        if (zzgiVar != null) {
                                                                                            i = 0;
                                                                                            while (i < zzgiVar.zzd() * 64) {
                                                                                                if (zzen.zzv(i, zzgiVar.zzn())) {
                                                                                                    zzktVar = zzktVar3;
                                                                                                    zzfrVar2.zzay().zzj().zzc(num, "Filter already evaluated. audience ID, filter ID", Integer.valueOf(i));
                                                                                                    bitSet2.set(i);
                                                                                                    if (zzen.zzv(i, zzgiVar.zzk())) {
                                                                                                        bitSet.set(i);
                                                                                                    }
                                                                                                    i++;
                                                                                                    zzktVar3 = zzktVar;
                                                                                                } else {
                                                                                                    zzktVar = zzktVar3;
                                                                                                }
                                                                                                arrayMap.remove(Integer.valueOf(i));
                                                                                                i++;
                                                                                                zzktVar3 = zzktVar;
                                                                                            }
                                                                                        }
                                                                                        zzkt zzktVar4 = zzktVar3;
                                                                                        com.google.android.gms.internal.measurement.zzgi zzgiVar3 = (com.google.android.gms.internal.measurement.zzgi) map4.get(num);
                                                                                        if (r19 == 0) {
                                                                                        }
                                                                                        this.zzc.put(num, new zzu(this, this.zza, zzgiVar3, bitSet, bitSet2, arrayMap, arrayMap9));
                                                                                        str4 = str4;
                                                                                        zzktVar3 = zzktVar4;
                                                                                        str15 = str15;
                                                                                        map6 = map14;
                                                                                        it = it;
                                                                                        str5 = str5;
                                                                                        map4 = map4;
                                                                                        str3 = str3;
                                                                                        map5 = map5;
                                                                                    }
                                                                                    zzktVar2 = zzktVar3;
                                                                                    str7 = str4;
                                                                                    String str24 = str5;
                                                                                    str8 = str3;
                                                                                    str9 = str15;
                                                                                    String str25 = str18;
                                                                                    if (!list.isEmpty()) {
                                                                                        realConnectionPool = new RealConnectionPool(this);
                                                                                        arrayMap5 = new ArrayMap();
                                                                                        it8 = list.iterator();
                                                                                        while (it8.hasNext()) {
                                                                                            zzftVar = (zzft) it8.next();
                                                                                            zzftVarZza = realConnectionPool.zza(zzftVar, this.zza);
                                                                                            if (zzftVarZza != null) {
                                                                                                zzamVarZzi2 = zzktVar2.zzi();
                                                                                                str12 = this.zza;
                                                                                                strZzh = zzftVarZza.zzh();
                                                                                                zzasVarZzn = zzamVarZzi2.zzn(str12, zzftVar.zzh());
                                                                                                if (zzasVarZzn == null) {
                                                                                                    zzfr zzfrVar6 = (zzfr) zzamVarZzi2.mBuilder;
                                                                                                    zzfrVar6.zzay().zzk().zzc(zzeh.zzn(str12), "Event aggregate wasn't created during raw event logging. appId, event", zzfrVar6.zzj().zzd(strZzh));
                                                                                                    zzasVar = new zzas(str12, zzftVar.zzh(), 1L, 1L, 1L, zzftVar.zzd(), 0L, null, null, null, null);
                                                                                                } else {
                                                                                                    zzasVar = new zzas(zzasVarZzn.zza, zzasVarZzn.zzb, zzasVarZzn.zzc + 1, zzasVarZzn.zzd + 1, zzasVarZzn.zze + 1, zzasVarZzn.zzf, zzasVarZzn.zzg, zzasVarZzn.zzh, zzasVarZzn.zzi, zzasVarZzn.zzj, zzasVarZzn.zzk);
                                                                                                }
                                                                                                zzasVar2 = zzasVar;
                                                                                                zzktVar2.zzi().zzE(zzasVar2);
                                                                                                strZzh2 = zzftVarZza.zzh();
                                                                                                map8 = (Map) arrayMap5.get(strZzh2);
                                                                                                if (map8 == null) {
                                                                                                    zzam zzamVarZzi7 = zzktVar2.zzi();
                                                                                                    zzfr zzfrVar7 = (zzfr) zzamVarZzi7.mBuilder;
                                                                                                    str13 = this.zza;
                                                                                                    zzamVarZzi7.zzW();
                                                                                                    zzamVarZzi7.zzg();
                                                                                                    com.google.android.gms.common.internal.zzah.checkNotEmpty(str13);
                                                                                                    com.google.android.gms.common.internal.zzah.checkNotEmpty(strZzh2);
                                                                                                    arrayMap6 = new ArrayMap();
                                                                                                    try {
                                                                                                        cursorQuery3 = zzamVarZzi7.zzh().query("event_filters", new String[]{str7, str8}, "app_id=? AND event_name=?", new String[]{str13, strZzh2}, null, null, null);
                                                                                                        try {
                                                                                                            try {
                                                                                                                if (cursorQuery3.moveToFirst()) {
                                                                                                                    zzasVar3 = zzasVar2;
                                                                                                                    while (true) {
                                                                                                                        try {
                                                                                                                            try {
                                                                                                                                zzek zzekVar2 = (zzek) ((com.google.android.gms.internal.measurement.zzej) zzen.zzl(zzek.zzc(), cursorQuery3.getBlob(1))).zzaC();
                                                                                                                                numValueOf5 = Integer.valueOf(cursorQuery3.getInt(0));
                                                                                                                                list6 = (List) arrayMap6.get(numValueOf5);
                                                                                                                                if (list6 == null) {
                                                                                                                                    realConnectionPool2 = realConnectionPool;
                                                                                                                                    try {
                                                                                                                                        arrayList4 = new ArrayList();
                                                                                                                                        arrayMap6.put(numValueOf5, arrayList4);
                                                                                                                                    } catch (SQLiteException e8) {
                                                                                                                                        e = e8;
                                                                                                                                        zzfrVar7.zzay().zzd().zzc(zzeh.zzn(str13), str24, e);
                                                                                                                                        Map mapEmptyMap5 = Collections.emptyMap();
                                                                                                                                        map13 = mapEmptyMap5;
                                                                                                                                        mapEmptyMap2 = mapEmptyMap5;
                                                                                                                                        if (cursorQuery3 != null) {
                                                                                                                                            cursorQuery3.close();
                                                                                                                                            map13 = mapEmptyMap2;
                                                                                                                                        }
                                                                                                                                    }
                                                                                                                                } else {
                                                                                                                                    realConnectionPool2 = realConnectionPool;
                                                                                                                                    arrayList4 = list6;
                                                                                                                                }
                                                                                                                                arrayList4.add(zzekVar2);
                                                                                                                            } catch (IOException e9) {
                                                                                                                                realConnectionPool2 = realConnectionPool;
                                                                                                                                zzfrVar7.zzay().zzd().zzc(zzeh.zzn(str13), str25, e9);
                                                                                                                            }
                                                                                                                            if (!cursorQuery3.moveToNext()) {
                                                                                                                                break;
                                                                                                                            }
                                                                                                                            realConnectionPool = realConnectionPool2;
                                                                                                                        } catch (SQLiteException e10) {
                                                                                                                            e = e10;
                                                                                                                            realConnectionPool2 = realConnectionPool;
                                                                                                                            zzfrVar7.zzay().zzd().zzc(zzeh.zzn(str13), str24, e);
                                                                                                                            Map mapEmptyMap6 = Collections.emptyMap();
                                                                                                                            map13 = mapEmptyMap6;
                                                                                                                            mapEmptyMap2 = mapEmptyMap6;
                                                                                                                            if (cursorQuery3 != null) {
                                                                                                                                cursorQuery3.close();
                                                                                                                                map13 = mapEmptyMap2;
                                                                                                                            }
                                                                                                                            arrayMap5.put(strZzh2, map13);
                                                                                                                            map9 = map13;
                                                                                                                            it9 = map9.keySet().iterator();
                                                                                                                            while (it9.hasNext()) {
                                                                                                                                num4 = (Integer) it9.next();
                                                                                                                                iIntValue = num4.intValue();
                                                                                                                                if (this.zzb.contains(num4)) {
                                                                                                                                    zzfrVar2.zzay().zzj().zzb(num4, "Skipping failed audience ID");
                                                                                                                                } else {
                                                                                                                                    it10 = ((List) map9.get(num4)).iterator();
                                                                                                                                    zZzd2 = true;
                                                                                                                                    map10 = map9;
                                                                                                                                    while (true) {
                                                                                                                                        if (!it10.hasNext()) {
                                                                                                                                            it11 = it9;
                                                                                                                                            zzasVar4 = zzasVar3;
                                                                                                                                            map11 = map10;
                                                                                                                                            num5 = num4;
                                                                                                                                            break;
                                                                                                                                        }
                                                                                                                                        zzek zzekVar3 = (zzek) it10.next();
                                                                                                                                        it11 = it9;
                                                                                                                                        zzasVar4 = zzasVar3;
                                                                                                                                        map12 = map10;
                                                                                                                                        num5 = num4;
                                                                                                                                        zzxVar2 = new zzx(this, this.zza, iIntValue, zzekVar3, 0);
                                                                                                                                        Long l3 = this.zzd;
                                                                                                                                        Long l4 = this.zze;
                                                                                                                                        iZzb = zzekVar3.zzb();
                                                                                                                                        zzuVar = (zzu) this.zzc.getOrDefault(num5, null);
                                                                                                                                        if (zzuVar == null) {
                                                                                                                                            z2 = false;
                                                                                                                                        } else {
                                                                                                                                            z2 = zzuVar.zze.get(iZzb);
                                                                                                                                        }
                                                                                                                                        zZzd2 = zzxVar2.zzd(l3, l4, zzftVarZza, zzasVar4.zzc, zzasVar4, z2);
                                                                                                                                        if (!zZzd2) {
                                                                                                                                            this.zzb.add(num5);
                                                                                                                                            map11 = map12;
                                                                                                                                            break;
                                                                                                                                        }
                                                                                                                                        zzd(num5).zzc(zzxVar2);
                                                                                                                                        num4 = num5;
                                                                                                                                        map10 = map12;
                                                                                                                                        zzasVar3 = zzasVar4;
                                                                                                                                        it9 = it11;
                                                                                                                                    }
                                                                                                                                    if (!zZzd2) {
                                                                                                                                        this.zzb.add(num5);
                                                                                                                                    }
                                                                                                                                    map9 = map11;
                                                                                                                                    zzasVar3 = zzasVar4;
                                                                                                                                    it9 = it11;
                                                                                                                                }
                                                                                                                            }
                                                                                                                            realConnectionPool = realConnectionPool2;
                                                                                                                        }
                                                                                                                    }
                                                                                                                    cursorQuery3.close();
                                                                                                                    map13 = arrayMap6;
                                                                                                                } else {
                                                                                                                    zzasVar3 = zzasVar2;
                                                                                                                    realConnectionPool2 = realConnectionPool;
                                                                                                                    mapEmptyMap2 = Collections.emptyMap();
                                                                                                                    cursorQuery3.close();
                                                                                                                    map13 = mapEmptyMap2;
                                                                                                                }
                                                                                                            } catch (SQLiteException e11) {
                                                                                                                e = e11;
                                                                                                                zzasVar3 = zzasVar2;
                                                                                                            }
                                                                                                            arrayMap5.put(strZzh2, map13);
                                                                                                            map9 = map13;
                                                                                                        } catch (Throwable th) {
                                                                                                            th = th;
                                                                                                            cursor2 = cursorQuery3;
                                                                                                            if (cursor2 != null) {
                                                                                                                cursor2.close();
                                                                                                            }
                                                                                                            throw th;
                                                                                                        }
                                                                                                    } catch (SQLiteException e12) {
                                                                                                        e = e12;
                                                                                                        zzasVar3 = zzasVar2;
                                                                                                        realConnectionPool2 = realConnectionPool;
                                                                                                        cursorQuery3 = null;
                                                                                                    } catch (Throwable th2) {
                                                                                                        th = th2;
                                                                                                        cursor2 = null;
                                                                                                    }
                                                                                                } else {
                                                                                                    zzasVar3 = zzasVar2;
                                                                                                    realConnectionPool2 = realConnectionPool;
                                                                                                    map9 = map8;
                                                                                                }
                                                                                                it9 = map9.keySet().iterator();
                                                                                                while (it9.hasNext()) {
                                                                                                    num4 = (Integer) it9.next();
                                                                                                    iIntValue = num4.intValue();
                                                                                                    if (this.zzb.contains(num4)) {
                                                                                                        zzfrVar2.zzay().zzj().zzb(num4, "Skipping failed audience ID");
                                                                                                    } else {
                                                                                                        it10 = ((List) map9.get(num4)).iterator();
                                                                                                        zZzd2 = true;
                                                                                                        map10 = map9;
                                                                                                        while (true) {
                                                                                                            if (!it10.hasNext()) {
                                                                                                                it11 = it9;
                                                                                                                zzasVar4 = zzasVar3;
                                                                                                                map11 = map10;
                                                                                                                num5 = num4;
                                                                                                                break;
                                                                                                            }
                                                                                                            zzek zzekVar4 = (zzek) it10.next();
                                                                                                            it11 = it9;
                                                                                                            zzasVar4 = zzasVar3;
                                                                                                            map12 = map10;
                                                                                                            num5 = num4;
                                                                                                            zzxVar2 = new zzx(this, this.zza, iIntValue, zzekVar4, 0);
                                                                                                            Long l5 = this.zzd;
                                                                                                            Long l6 = this.zze;
                                                                                                            iZzb = zzekVar4.zzb();
                                                                                                            zzuVar = (zzu) this.zzc.getOrDefault(num5, null);
                                                                                                            if (zzuVar == null) {
                                                                                                                z2 = false;
                                                                                                            } else {
                                                                                                                z2 = zzuVar.zze.get(iZzb);
                                                                                                            }
                                                                                                            zZzd2 = zzxVar2.zzd(l5, l6, zzftVarZza, zzasVar4.zzc, zzasVar4, z2);
                                                                                                            if (!zZzd2) {
                                                                                                                this.zzb.add(num5);
                                                                                                                map11 = map12;
                                                                                                                break;
                                                                                                            }
                                                                                                            zzd(num5).zzc(zzxVar2);
                                                                                                            num4 = num5;
                                                                                                            map10 = map12;
                                                                                                            zzasVar3 = zzasVar4;
                                                                                                            it9 = it11;
                                                                                                        }
                                                                                                        if (!zZzd2) {
                                                                                                            this.zzb.add(num5);
                                                                                                        }
                                                                                                        map9 = map11;
                                                                                                        zzasVar3 = zzasVar4;
                                                                                                        it9 = it11;
                                                                                                    }
                                                                                                }
                                                                                                realConnectionPool = realConnectionPool2;
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                    if (!list2.isEmpty()) {
                                                                                        arrayMap4 = new ArrayMap();
                                                                                        it5 = list2.iterator();
                                                                                        while (it5.hasNext()) {
                                                                                            com.google.android.gms.internal.measurement.zzgm zzgmVar = (com.google.android.gms.internal.measurement.zzgm) it5.next();
                                                                                            strZzf = zzgmVar.zzf();
                                                                                            map7 = (Map) arrayMap4.get(strZzf);
                                                                                            if (map7 == null) {
                                                                                                zzam zzamVarZzi8 = zzktVar2.zzi();
                                                                                                zzfr zzfrVar8 = (zzfr) zzamVarZzi8.mBuilder;
                                                                                                str11 = this.zza;
                                                                                                zzamVarZzi8.zzW();
                                                                                                zzamVarZzi8.zzg();
                                                                                                com.google.android.gms.common.internal.zzah.checkNotEmpty(str11);
                                                                                                com.google.android.gms.common.internal.zzah.checkNotEmpty(strZzf);
                                                                                                ArrayMap arrayMap10 = new ArrayMap();
                                                                                                try {
                                                                                                    cursorQuery2 = zzamVarZzi8.zzh().query("property_filters", new String[]{str7, str8}, "app_id=? AND property_name=?", new String[]{str11, strZzf}, null, null, null);
                                                                                                    try {
                                                                                                        try {
                                                                                                            simpleArrayMap = arrayMap10;
                                                                                                            if (cursorQuery2.moveToFirst()) {
                                                                                                                while (true) {
                                                                                                                    try {
                                                                                                                        zzet zzetVar2 = (zzet) ((com.google.android.gms.internal.measurement.zzes) zzen.zzl(zzet.zzc(), cursorQuery2.getBlob(1))).zzaC();
                                                                                                                        numValueOf4 = Integer.valueOf(cursorQuery2.getInt(0));
                                                                                                                        list5 = (List) simpleArrayMap.get(numValueOf4);
                                                                                                                        if (list5 == null) {
                                                                                                                            it6 = it5;
                                                                                                                            try {
                                                                                                                                arrayList3 = new ArrayList();
                                                                                                                                simpleArrayMap.put(numValueOf4, arrayList3);
                                                                                                                            } catch (SQLiteException e13) {
                                                                                                                                e = e13;
                                                                                                                                zzfrVar8.zzay().zzd().zzc(zzeh.zzn(str11), str24, e);
                                                                                                                                Map mapEmptyMap7 = Collections.emptyMap();
                                                                                                                                obj3 = mapEmptyMap7;
                                                                                                                                mapEmptyMap = mapEmptyMap7;
                                                                                                                                if (cursorQuery2 != null) {
                                                                                                                                    cursorQuery2.close();
                                                                                                                                    obj3 = mapEmptyMap;
                                                                                                                                }
                                                                                                                            }
                                                                                                                        } else {
                                                                                                                            it6 = it5;
                                                                                                                            arrayList3 = list5;
                                                                                                                        }
                                                                                                                        arrayList3.add(zzetVar2);
                                                                                                                    } catch (IOException e14) {
                                                                                                                        it6 = it5;
                                                                                                                        zzfrVar8.zzay().zzd().zzc(zzeh.zzn(str11), "Failed to merge filter", e14);
                                                                                                                    }
                                                                                                                    if (!cursorQuery2.moveToNext()) {
                                                                                                                        break;
                                                                                                                    }
                                                                                                                    it5 = it6;
                                                                                                                    simpleArrayMap = simpleArrayMap;
                                                                                                                }
                                                                                                                cursorQuery2.close();
                                                                                                                obj3 = simpleArrayMap;
                                                                                                            } else {
                                                                                                                it6 = it5;
                                                                                                                mapEmptyMap = Collections.emptyMap();
                                                                                                                cursorQuery2.close();
                                                                                                                obj3 = mapEmptyMap;
                                                                                                            }
                                                                                                        } catch (Throwable th3) {
                                                                                                            th = th3;
                                                                                                            cursor = cursorQuery2;
                                                                                                            if (cursor != null) {
                                                                                                                cursor.close();
                                                                                                            }
                                                                                                            throw th;
                                                                                                        }
                                                                                                    } catch (SQLiteException e15) {
                                                                                                        e = e15;
                                                                                                        it6 = it5;
                                                                                                    }
                                                                                                } catch (SQLiteException e16) {
                                                                                                    e = e16;
                                                                                                    it6 = it5;
                                                                                                    cursorQuery2 = null;
                                                                                                } catch (Throwable th4) {
                                                                                                    th = th4;
                                                                                                    cursor = null;
                                                                                                }
                                                                                                arrayMap4.put(strZzf, obj3);
                                                                                                r1 = obj3;
                                                                                            } else {
                                                                                                it6 = it5;
                                                                                                r1 = map7;
                                                                                            }
                                                                                            r2 = r1;
                                                                                            for (Integer num6 : r1.keySet()) {
                                                                                                int iIntValue2 = num6.intValue();
                                                                                                if (this.zzb.contains(num6)) {
                                                                                                    zzfrVar2.zzay().zzj().zzb(num6, "Skipping failed audience ID");
                                                                                                    break;
                                                                                                }
                                                                                                it7 = ((List) r2.get(num6)).iterator();
                                                                                                zZzd = true;
                                                                                                r3 = r2;
                                                                                                while (true) {
                                                                                                    if (it7.hasNext()) {
                                                                                                        zzetVar = (zzet) it7.next();
                                                                                                        if (Log.isLoggable(zzfrVar2.zzay().zzq(), 2)) {
                                                                                                            zzef zzefVarZzj = zzfrVar2.zzay().zzj();
                                                                                                            if (zzetVar.zzj()) {
                                                                                                                numValueOf3 = Integer.valueOf(zzetVar.zza());
                                                                                                            } else {
                                                                                                                numValueOf3 = null;
                                                                                                            }
                                                                                                            zzefVarZzj.zzd("Evaluating filter. audience, filter, property", num6, numValueOf3, zzfrVar2.zzj().zzf(zzetVar.zze()));
                                                                                                            zzfrVar2.zzay().zzj().zzb(zzktVar2.zzu().zzp(zzetVar), "Filter definition");
                                                                                                        }
                                                                                                        if (zzetVar.zzj()) {
                                                                                                        }
                                                                                                        r57 = r3;
                                                                                                        num3 = num6;
                                                                                                        zzef zzefVarZzk = zzfrVar2.zzay().zzk();
                                                                                                        zzeg zzegVarZzn3 = zzeh.zzn(this.zza);
                                                                                                        if (zzetVar.zzj()) {
                                                                                                            numValueOf2 = Integer.valueOf(zzetVar.zza());
                                                                                                        } else {
                                                                                                            numValueOf2 = null;
                                                                                                        }
                                                                                                        zzefVarZzk.zzc(zzegVarZzn3, "Invalid property filter ID. appId, id", String.valueOf(numValueOf2));
                                                                                                        this.zzb.add(num3);
                                                                                                        r2 = r57;
                                                                                                    } else {
                                                                                                        r57 = r3;
                                                                                                        num3 = num6;
                                                                                                    }
                                                                                                    if (!zZzd) {
                                                                                                        this.zzb.add(num3);
                                                                                                    }
                                                                                                    r2 = r57;
                                                                                                    zzd(num3).zzc(zzxVar);
                                                                                                    num6 = num3;
                                                                                                    r3 = r58;
                                                                                                }
                                                                                            }
                                                                                            it5 = it6;
                                                                                        }
                                                                                    }
                                                                                    arrayList2 = new ArrayList();
                                                                                    MapCollections$KeySet<Integer> mapCollections$KeySet = (MapCollections$KeySet) this.zzc.keySet();
                                                                                    mapCollections$KeySet.removeAll(this.zzb);
                                                                                    for (Integer num7 : mapCollections$KeySet) {
                                                                                        int iIntValue3 = num7.intValue();
                                                                                        zzu zzuVar2 = (zzu) this.zzc.get(num7);
                                                                                        com.google.android.gms.common.internal.zzah.checkNotNull(zzuVar2);
                                                                                        zzfp zzfpVarZza = zzuVar2.zza(iIntValue3);
                                                                                        arrayList2.add(zzfpVarZza);
                                                                                        zzamVarZzi = zzktVar2.zzi();
                                                                                        zzfrVar = (zzfr) zzamVarZzi.mBuilder;
                                                                                        str10 = this.zza;
                                                                                        com.google.android.gms.internal.measurement.zzgi zzgiVarZzd = zzfpVarZza.zzd();
                                                                                        zzamVarZzi.zzW();
                                                                                        zzamVarZzi.zzg();
                                                                                        com.google.android.gms.common.internal.zzah.checkNotEmpty(str10);
                                                                                        com.google.android.gms.common.internal.zzah.checkNotNull(zzgiVarZzd);
                                                                                        byte[] bArrZzbu = zzgiVarZzd.zzbu();
                                                                                        contentValues = new ContentValues();
                                                                                        contentValues.put("app_id", str10);
                                                                                        contentValues.put(str7, num7);
                                                                                        String str26 = str9;
                                                                                        contentValues.put(str26, bArrZzbu);
                                                                                        try {
                                                                                            try {
                                                                                                if (zzamVarZzi.zzh().insertWithOnConflict("audience_filter_values", null, contentValues, 5) == -1) {
                                                                                                    zzfrVar.zzay().zzd().zzb(zzeh.zzn(str10), "Failed to insert filter results (got -1). appId");
                                                                                                }
                                                                                            } catch (SQLiteException e17) {
                                                                                                e = e17;
                                                                                                zzfrVar.zzay().zzd().zzc(zzeh.zzn(str10), "Error storing filter results. appId", e);
                                                                                            }
                                                                                        } catch (SQLiteException e18) {
                                                                                            e = e18;
                                                                                        }
                                                                                        str9 = str26;
                                                                                    }
                                                                                    return arrayList2;
                                                                                }
                                                                            } catch (SQLiteException e19) {
                                                                                e = e19;
                                                                                cursorRawQuery = null;
                                                                            } catch (Throwable th5) {
                                                                                th = th5;
                                                                                r12 = 0;
                                                                                if (r12 != 0) {
                                                                                    r12.close();
                                                                                }
                                                                                throw th;
                                                                            }
                                                                            cursorRawQuery.close();
                                                                            r0 = arrayMap2;
                                                                            com.google.android.gms.common.internal.zzah.checkNotEmpty(str23);
                                                                            arrayMap3 = new ArrayMap();
                                                                            if (!map2.isEmpty()) {
                                                                                it3 = map2.keySet().iterator();
                                                                                while (it3.hasNext()) {
                                                                                    num2 = (Integer) it3.next();
                                                                                    num2.getClass();
                                                                                    zzgiVar2 = (com.google.android.gms.internal.measurement.zzgi) map2.get(num2);
                                                                                    list4 = (List) r0.get(num2);
                                                                                    if (list4 != null) {
                                                                                    }
                                                                                    zzagVar = zzagVar2;
                                                                                    it4 = it3;
                                                                                    arrayMap3.put(num2, zzgiVar2);
                                                                                    r0 = r0;
                                                                                    zzagVar2 = zzagVar;
                                                                                    it3 = it4;
                                                                                }
                                                                            }
                                                                            map3 = arrayMap3;
                                                                        } catch (Throwable th6) {
                                                                            th = th6;
                                                                            r12 = sQLiteDatabaseZzh;
                                                                            if (r12 != 0) {
                                                                                r12.close();
                                                                            }
                                                                            throw th;
                                                                        }
                                                                    } else {
                                                                        map3 = map2;
                                                                    }
                                                                    it = hashSet.iterator();
                                                                    map6 = map3;
                                                                    map5 = map;
                                                                    map4 = map2;
                                                                    while (it.hasNext()) {
                                                                        num = (Integer) it.next();
                                                                        num.getClass();
                                                                        zzgiVar = (com.google.android.gms.internal.measurement.zzgi) map6.get(num);
                                                                        bitSet = new BitSet();
                                                                        bitSet2 = new BitSet();
                                                                        arrayMap = new ArrayMap();
                                                                        if (zzgiVar != null) {
                                                                            while (r2.hasNext()) {
                                                                                if (zzfrVar5.zzh()) {
                                                                                    Integer numValueOf8 = Integer.valueOf(zzfrVar5.zza());
                                                                                    if (zzfrVar5.zzg()) {
                                                                                        lValueOf = Long.valueOf(zzfrVar5.zzb());
                                                                                    } else {
                                                                                        lValueOf = null;
                                                                                    }
                                                                                    arrayMap.put(numValueOf8, lValueOf);
                                                                                }
                                                                            }
                                                                        }
                                                                        ArrayMap arrayMap11 = new ArrayMap();
                                                                        if (zzgiVar != null) {
                                                                            it2 = zzgiVar.zzm().iterator();
                                                                            while (it2.hasNext()) {
                                                                                zzgkVar = (zzgk) it2.next();
                                                                                if (!zzgkVar.zzi()) {
                                                                                }
                                                                            }
                                                                        }
                                                                        Map map15 = map6;
                                                                        if (zzgiVar != null) {
                                                                            i = 0;
                                                                            while (i < zzgiVar.zzd() * 64) {
                                                                                if (zzen.zzv(i, zzgiVar.zzn())) {
                                                                                    zzktVar = zzktVar3;
                                                                                    zzfrVar2.zzay().zzj().zzc(num, "Filter already evaluated. audience ID, filter ID", Integer.valueOf(i));
                                                                                    bitSet2.set(i);
                                                                                    if (zzen.zzv(i, zzgiVar.zzk())) {
                                                                                        bitSet.set(i);
                                                                                    }
                                                                                    i++;
                                                                                    zzktVar3 = zzktVar;
                                                                                } else {
                                                                                    zzktVar = zzktVar3;
                                                                                }
                                                                                arrayMap.remove(Integer.valueOf(i));
                                                                                i++;
                                                                                zzktVar3 = zzktVar;
                                                                            }
                                                                        }
                                                                        zzkt zzktVar5 = zzktVar3;
                                                                        com.google.android.gms.internal.measurement.zzgi zzgiVar4 = (com.google.android.gms.internal.measurement.zzgi) map4.get(num);
                                                                        if (r19 == 0) {
                                                                        }
                                                                        this.zzc.put(num, new zzu(this, this.zza, zzgiVar4, bitSet, bitSet2, arrayMap, arrayMap11));
                                                                        str4 = str4;
                                                                        zzktVar3 = zzktVar5;
                                                                        str15 = str15;
                                                                        map6 = map15;
                                                                        it = it;
                                                                        str5 = str5;
                                                                        map4 = map4;
                                                                        str3 = str3;
                                                                        map5 = map5;
                                                                    }
                                                                }
                                                                zzktVar2 = zzktVar3;
                                                                str7 = str4;
                                                                String str27 = str5;
                                                                str8 = str3;
                                                                str9 = str15;
                                                                String str28 = str18;
                                                                if (!list.isEmpty()) {
                                                                    realConnectionPool = new RealConnectionPool(this);
                                                                    arrayMap5 = new ArrayMap();
                                                                    it8 = list.iterator();
                                                                    while (it8.hasNext()) {
                                                                        zzftVar = (zzft) it8.next();
                                                                        zzftVarZza = realConnectionPool.zza(zzftVar, this.zza);
                                                                        if (zzftVarZza != null) {
                                                                            zzamVarZzi2 = zzktVar2.zzi();
                                                                            str12 = this.zza;
                                                                            strZzh = zzftVarZza.zzh();
                                                                            zzasVarZzn = zzamVarZzi2.zzn(str12, zzftVar.zzh());
                                                                            if (zzasVarZzn == null) {
                                                                                zzfr zzfrVar9 = (zzfr) zzamVarZzi2.mBuilder;
                                                                                zzfrVar9.zzay().zzk().zzc(zzeh.zzn(str12), "Event aggregate wasn't created during raw event logging. appId, event", zzfrVar9.zzj().zzd(strZzh));
                                                                                zzasVar = new zzas(str12, zzftVar.zzh(), 1L, 1L, 1L, zzftVar.zzd(), 0L, null, null, null, null);
                                                                            } else {
                                                                                zzasVar = new zzas(zzasVarZzn.zza, zzasVarZzn.zzb, zzasVarZzn.zzc + 1, zzasVarZzn.zzd + 1, zzasVarZzn.zze + 1, zzasVarZzn.zzf, zzasVarZzn.zzg, zzasVarZzn.zzh, zzasVarZzn.zzi, zzasVarZzn.zzj, zzasVarZzn.zzk);
                                                                            }
                                                                            zzasVar2 = zzasVar;
                                                                            zzktVar2.zzi().zzE(zzasVar2);
                                                                            strZzh2 = zzftVarZza.zzh();
                                                                            map8 = (Map) arrayMap5.get(strZzh2);
                                                                            if (map8 == null) {
                                                                                zzam zzamVarZzi9 = zzktVar2.zzi();
                                                                                zzfr zzfrVar10 = (zzfr) zzamVarZzi9.mBuilder;
                                                                                str13 = this.zza;
                                                                                zzamVarZzi9.zzW();
                                                                                zzamVarZzi9.zzg();
                                                                                com.google.android.gms.common.internal.zzah.checkNotEmpty(str13);
                                                                                com.google.android.gms.common.internal.zzah.checkNotEmpty(strZzh2);
                                                                                arrayMap6 = new ArrayMap();
                                                                                cursorQuery3 = zzamVarZzi9.zzh().query("event_filters", new String[]{str7, str8}, "app_id=? AND event_name=?", new String[]{str13, strZzh2}, null, null, null);
                                                                                if (cursorQuery3.moveToFirst()) {
                                                                                    zzasVar3 = zzasVar2;
                                                                                    while (true) {
                                                                                        zzek zzekVar5 = (zzek) ((com.google.android.gms.internal.measurement.zzej) zzen.zzl(zzek.zzc(), cursorQuery3.getBlob(1))).zzaC();
                                                                                        numValueOf5 = Integer.valueOf(cursorQuery3.getInt(0));
                                                                                        list6 = (List) arrayMap6.get(numValueOf5);
                                                                                        if (list6 == null) {
                                                                                            realConnectionPool2 = realConnectionPool;
                                                                                            arrayList4 = new ArrayList();
                                                                                            arrayMap6.put(numValueOf5, arrayList4);
                                                                                        } else {
                                                                                            realConnectionPool2 = realConnectionPool;
                                                                                            arrayList4 = list6;
                                                                                        }
                                                                                        arrayList4.add(zzekVar5);
                                                                                        if (!cursorQuery3.moveToNext()) {
                                                                                            break;
                                                                                            break;
                                                                                        }
                                                                                        realConnectionPool = realConnectionPool2;
                                                                                    }
                                                                                    cursorQuery3.close();
                                                                                    map13 = arrayMap6;
                                                                                } else {
                                                                                    zzasVar3 = zzasVar2;
                                                                                    realConnectionPool2 = realConnectionPool;
                                                                                    mapEmptyMap2 = Collections.emptyMap();
                                                                                    cursorQuery3.close();
                                                                                    map13 = mapEmptyMap2;
                                                                                }
                                                                                arrayMap5.put(strZzh2, map13);
                                                                                map9 = map13;
                                                                            } else {
                                                                                zzasVar3 = zzasVar2;
                                                                                realConnectionPool2 = realConnectionPool;
                                                                                map9 = map8;
                                                                            }
                                                                            it9 = map9.keySet().iterator();
                                                                            while (it9.hasNext()) {
                                                                                num4 = (Integer) it9.next();
                                                                                iIntValue = num4.intValue();
                                                                                if (this.zzb.contains(num4)) {
                                                                                    zzfrVar2.zzay().zzj().zzb(num4, "Skipping failed audience ID");
                                                                                } else {
                                                                                    it10 = ((List) map9.get(num4)).iterator();
                                                                                    zZzd2 = true;
                                                                                    map10 = map9;
                                                                                    while (true) {
                                                                                        if (!it10.hasNext()) {
                                                                                            it11 = it9;
                                                                                            zzasVar4 = zzasVar3;
                                                                                            map11 = map10;
                                                                                            num5 = num4;
                                                                                            break;
                                                                                        }
                                                                                        zzek zzekVar6 = (zzek) it10.next();
                                                                                        it11 = it9;
                                                                                        zzasVar4 = zzasVar3;
                                                                                        map12 = map10;
                                                                                        num5 = num4;
                                                                                        zzxVar2 = new zzx(this, this.zza, iIntValue, zzekVar6, 0);
                                                                                        Long l7 = this.zzd;
                                                                                        Long l8 = this.zze;
                                                                                        iZzb = zzekVar6.zzb();
                                                                                        zzuVar = (zzu) this.zzc.getOrDefault(num5, null);
                                                                                        if (zzuVar == null) {
                                                                                            z2 = false;
                                                                                        } else {
                                                                                            z2 = zzuVar.zze.get(iZzb);
                                                                                        }
                                                                                        zZzd2 = zzxVar2.zzd(l7, l8, zzftVarZza, zzasVar4.zzc, zzasVar4, z2);
                                                                                        if (!zZzd2) {
                                                                                            this.zzb.add(num5);
                                                                                            map11 = map12;
                                                                                            break;
                                                                                        }
                                                                                        zzd(num5).zzc(zzxVar2);
                                                                                        num4 = num5;
                                                                                        map10 = map12;
                                                                                        zzasVar3 = zzasVar4;
                                                                                        it9 = it11;
                                                                                    }
                                                                                    if (!zZzd2) {
                                                                                        this.zzb.add(num5);
                                                                                    }
                                                                                    map9 = map11;
                                                                                    zzasVar3 = zzasVar4;
                                                                                    it9 = it11;
                                                                                }
                                                                            }
                                                                            realConnectionPool = realConnectionPool2;
                                                                        }
                                                                    }
                                                                }
                                                                if (!list2.isEmpty()) {
                                                                    arrayMap4 = new ArrayMap();
                                                                    it5 = list2.iterator();
                                                                    while (it5.hasNext()) {
                                                                        com.google.android.gms.internal.measurement.zzgm zzgmVar2 = (com.google.android.gms.internal.measurement.zzgm) it5.next();
                                                                        strZzf = zzgmVar2.zzf();
                                                                        map7 = (Map) arrayMap4.get(strZzf);
                                                                        if (map7 == null) {
                                                                            zzam zzamVarZzi10 = zzktVar2.zzi();
                                                                            zzfr zzfrVar11 = (zzfr) zzamVarZzi10.mBuilder;
                                                                            str11 = this.zza;
                                                                            zzamVarZzi10.zzW();
                                                                            zzamVarZzi10.zzg();
                                                                            com.google.android.gms.common.internal.zzah.checkNotEmpty(str11);
                                                                            com.google.android.gms.common.internal.zzah.checkNotEmpty(strZzf);
                                                                            ArrayMap arrayMap12 = new ArrayMap();
                                                                            cursorQuery2 = zzamVarZzi10.zzh().query("property_filters", new String[]{str7, str8}, "app_id=? AND property_name=?", new String[]{str11, strZzf}, null, null, null);
                                                                            simpleArrayMap = arrayMap12;
                                                                            if (cursorQuery2.moveToFirst()) {
                                                                                while (true) {
                                                                                    zzet zzetVar3 = (zzet) ((com.google.android.gms.internal.measurement.zzes) zzen.zzl(zzet.zzc(), cursorQuery2.getBlob(1))).zzaC();
                                                                                    numValueOf4 = Integer.valueOf(cursorQuery2.getInt(0));
                                                                                    list5 = (List) simpleArrayMap.get(numValueOf4);
                                                                                    if (list5 == null) {
                                                                                        it6 = it5;
                                                                                        arrayList3 = new ArrayList();
                                                                                        simpleArrayMap.put(numValueOf4, arrayList3);
                                                                                    } else {
                                                                                        it6 = it5;
                                                                                        arrayList3 = list5;
                                                                                    }
                                                                                    arrayList3.add(zzetVar3);
                                                                                    if (!cursorQuery2.moveToNext()) {
                                                                                        break;
                                                                                        break;
                                                                                    }
                                                                                    it5 = it6;
                                                                                    simpleArrayMap = simpleArrayMap;
                                                                                }
                                                                                cursorQuery2.close();
                                                                                obj3 = simpleArrayMap;
                                                                            } else {
                                                                                it6 = it5;
                                                                                mapEmptyMap = Collections.emptyMap();
                                                                                cursorQuery2.close();
                                                                                obj3 = mapEmptyMap;
                                                                            }
                                                                            arrayMap4.put(strZzf, obj3);
                                                                            r1 = obj3;
                                                                        } else {
                                                                            it6 = it5;
                                                                            r1 = map7;
                                                                        }
                                                                        r2 = r1;
                                                                        while (r10.hasNext()) {
                                                                            int iIntValue4 = num6.intValue();
                                                                            if (this.zzb.contains(num6)) {
                                                                                zzfrVar2.zzay().zzj().zzb(num6, "Skipping failed audience ID");
                                                                                break;
                                                                                break;
                                                                            }
                                                                            it7 = ((List) r2.get(num6)).iterator();
                                                                            zZzd = true;
                                                                            r3 = r2;
                                                                            while (true) {
                                                                                if (it7.hasNext()) {
                                                                                    zzetVar = (zzet) it7.next();
                                                                                    if (Log.isLoggable(zzfrVar2.zzay().zzq(), 2)) {
                                                                                        zzef zzefVarZzj2 = zzfrVar2.zzay().zzj();
                                                                                        if (zzetVar.zzj()) {
                                                                                            numValueOf3 = Integer.valueOf(zzetVar.zza());
                                                                                        } else {
                                                                                            numValueOf3 = null;
                                                                                        }
                                                                                        zzefVarZzj2.zzd("Evaluating filter. audience, filter, property", num6, numValueOf3, zzfrVar2.zzj().zzf(zzetVar.zze()));
                                                                                        zzfrVar2.zzay().zzj().zzb(zzktVar2.zzu().zzp(zzetVar), "Filter definition");
                                                                                    }
                                                                                    if (zzetVar.zzj()) {
                                                                                    }
                                                                                    r57 = r3;
                                                                                    num3 = num6;
                                                                                    zzef zzefVarZzk2 = zzfrVar2.zzay().zzk();
                                                                                    zzeg zzegVarZzn4 = zzeh.zzn(this.zza);
                                                                                    if (zzetVar.zzj()) {
                                                                                        numValueOf2 = Integer.valueOf(zzetVar.zza());
                                                                                    } else {
                                                                                        numValueOf2 = null;
                                                                                    }
                                                                                    zzefVarZzk2.zzc(zzegVarZzn4, "Invalid property filter ID. appId, id", String.valueOf(numValueOf2));
                                                                                    this.zzb.add(num3);
                                                                                    r2 = r57;
                                                                                } else {
                                                                                    r57 = r3;
                                                                                    num3 = num6;
                                                                                }
                                                                                if (!zZzd) {
                                                                                    this.zzb.add(num3);
                                                                                }
                                                                                r2 = r57;
                                                                                zzd(num3).zzc(zzxVar);
                                                                                num6 = num3;
                                                                                r3 = r58;
                                                                            }
                                                                        }
                                                                        it5 = it6;
                                                                    }
                                                                }
                                                                arrayList2 = new ArrayList();
                                                                MapCollections$KeySet<Integer> mapCollections$KeySet2 = (MapCollections$KeySet) this.zzc.keySet();
                                                                mapCollections$KeySet2.removeAll(this.zzb);
                                                                while (r2.hasNext()) {
                                                                    int iIntValue5 = num7.intValue();
                                                                    zzu zzuVar3 = (zzu) this.zzc.get(num7);
                                                                    com.google.android.gms.common.internal.zzah.checkNotNull(zzuVar3);
                                                                    zzfp zzfpVarZza2 = zzuVar3.zza(iIntValue5);
                                                                    arrayList2.add(zzfpVarZza2);
                                                                    zzamVarZzi = zzktVar2.zzi();
                                                                    zzfrVar = (zzfr) zzamVarZzi.mBuilder;
                                                                    str10 = this.zza;
                                                                    com.google.android.gms.internal.measurement.zzgi zzgiVarZzd2 = zzfpVarZza2.zzd();
                                                                    zzamVarZzi.zzW();
                                                                    zzamVarZzi.zzg();
                                                                    com.google.android.gms.common.internal.zzah.checkNotEmpty(str10);
                                                                    com.google.android.gms.common.internal.zzah.checkNotNull(zzgiVarZzd2);
                                                                    byte[] bArrZzbu2 = zzgiVarZzd2.zzbu();
                                                                    contentValues = new ContentValues();
                                                                    contentValues.put("app_id", str10);
                                                                    contentValues.put(str7, num7);
                                                                    String str29 = str9;
                                                                    contentValues.put(str29, bArrZzbu2);
                                                                    if (zzamVarZzi.zzh().insertWithOnConflict("audience_filter_values", null, contentValues, 5) == -1) {
                                                                        zzfrVar.zzay().zzd().zzb(zzeh.zzn(str10), "Failed to insert filter results (got -1). appId");
                                                                    }
                                                                    str9 = str29;
                                                                }
                                                                return arrayList2;
                                                            }
                                                        }
                                                        try {
                                                            if (!cursorQuery.moveToNext()) {
                                                                break;
                                                            }
                                                            str20 = str4;
                                                            str19 = str5;
                                                            str18 = str18;
                                                        } catch (SQLiteException e20) {
                                                            e = e20;
                                                            zzfrVar4.zzay().zzd().zzc(zzeh.zzn(str22), "Database error querying filter results. appId", e);
                                                            Map mapEmptyMap8 = Collections.emptyMap();
                                                            if (cursorQuery != null) {
                                                                cursorQuery.close();
                                                            }
                                                            map2 = mapEmptyMap8;
                                                        }
                                                    }
                                                    cursorQuery.close();
                                                    map2 = arrayMap7;
                                                } else {
                                                    Map mapEmptyMap9 = Collections.emptyMap();
                                                    cursorQuery.close();
                                                    map2 = mapEmptyMap9;
                                                    str4 = "audience_id";
                                                    str5 = "Database error querying filters. appId";
                                                    str18 = "Failed to merge filter. appId";
                                                }
                                                if (!map2.isEmpty()) {
                                                    HashSet hashSet2 = new HashSet(map2.keySet());
                                                    if (z) {
                                                        String str210 = this.zza;
                                                        zzam zzamVarZzi11 = zzktVar3.zzi();
                                                        str6 = this.zza;
                                                        zzamVarZzi11.zzW();
                                                        zzamVarZzi11.zzg();
                                                        com.google.android.gms.common.internal.zzah.checkNotEmpty(str6);
                                                        arrayMap2 = new ArrayMap();
                                                        sQLiteDatabaseZzh = zzamVarZzi11.zzh();
                                                        cursorRawQuery = sQLiteDatabaseZzh.rawQuery("select audience_id, filter_id from event_filters where app_id = ? and session_scoped = 1 UNION select audience_id, filter_id from property_filters where app_id = ? and session_scoped = 1;", new String[]{str6, str6});
                                                        if (cursorRawQuery.moveToFirst()) {
                                                            do {
                                                                numValueOf = Integer.valueOf(cursorRawQuery.getInt(0));
                                                                arrayList = (List) arrayMap2.get(numValueOf);
                                                                if (arrayList == null) {
                                                                    arrayList = new ArrayList();
                                                                    arrayMap2.put(numValueOf, arrayList);
                                                                }
                                                                arrayList.add(Integer.valueOf(cursorRawQuery.getInt(1)));
                                                            } while (cursorRawQuery.moveToNext());
                                                        } else {
                                                            arrayMap2 = Collections.emptyMap();
                                                        }
                                                        cursorRawQuery.close();
                                                        r0 = arrayMap2;
                                                        com.google.android.gms.common.internal.zzah.checkNotEmpty(str210);
                                                        arrayMap3 = new ArrayMap();
                                                        if (!map2.isEmpty()) {
                                                            it3 = map2.keySet().iterator();
                                                            while (it3.hasNext()) {
                                                                num2 = (Integer) it3.next();
                                                                num2.getClass();
                                                                zzgiVar2 = (com.google.android.gms.internal.measurement.zzgi) map2.get(num2);
                                                                list4 = (List) r0.get(num2);
                                                                if (list4 != null) {
                                                                }
                                                                zzagVar = zzagVar2;
                                                                it4 = it3;
                                                                arrayMap3.put(num2, zzgiVar2);
                                                                r0 = r0;
                                                                zzagVar2 = zzagVar;
                                                                it3 = it4;
                                                            }
                                                        }
                                                        map3 = arrayMap3;
                                                    } else {
                                                        map3 = map2;
                                                    }
                                                    it = hashSet2.iterator();
                                                    map6 = map3;
                                                    map5 = map;
                                                    map4 = map2;
                                                    while (it.hasNext()) {
                                                        num = (Integer) it.next();
                                                        num.getClass();
                                                        zzgiVar = (com.google.android.gms.internal.measurement.zzgi) map6.get(num);
                                                        bitSet = new BitSet();
                                                        bitSet2 = new BitSet();
                                                        arrayMap = new ArrayMap();
                                                        if (zzgiVar != null) {
                                                            while (r2.hasNext()) {
                                                                if (zzfrVar5.zzh()) {
                                                                    Integer numValueOf9 = Integer.valueOf(zzfrVar5.zza());
                                                                    if (zzfrVar5.zzg()) {
                                                                        lValueOf = Long.valueOf(zzfrVar5.zzb());
                                                                    } else {
                                                                        lValueOf = null;
                                                                    }
                                                                    arrayMap.put(numValueOf9, lValueOf);
                                                                }
                                                            }
                                                        }
                                                        ArrayMap arrayMap13 = new ArrayMap();
                                                        if (zzgiVar != null) {
                                                            it2 = zzgiVar.zzm().iterator();
                                                            while (it2.hasNext()) {
                                                                zzgkVar = (zzgk) it2.next();
                                                                if (!zzgkVar.zzi()) {
                                                                }
                                                            }
                                                        }
                                                        Map map16 = map6;
                                                        if (zzgiVar != null) {
                                                            i = 0;
                                                            while (i < zzgiVar.zzd() * 64) {
                                                                if (zzen.zzv(i, zzgiVar.zzn())) {
                                                                    zzktVar = zzktVar3;
                                                                    zzfrVar2.zzay().zzj().zzc(num, "Filter already evaluated. audience ID, filter ID", Integer.valueOf(i));
                                                                    bitSet2.set(i);
                                                                    if (zzen.zzv(i, zzgiVar.zzk())) {
                                                                        bitSet.set(i);
                                                                    }
                                                                    i++;
                                                                    zzktVar3 = zzktVar;
                                                                } else {
                                                                    zzktVar = zzktVar3;
                                                                }
                                                                arrayMap.remove(Integer.valueOf(i));
                                                                i++;
                                                                zzktVar3 = zzktVar;
                                                            }
                                                        }
                                                        zzkt zzktVar6 = zzktVar3;
                                                        com.google.android.gms.internal.measurement.zzgi zzgiVar5 = (com.google.android.gms.internal.measurement.zzgi) map4.get(num);
                                                        if (r19 == 0) {
                                                        }
                                                        this.zzc.put(num, new zzu(this, this.zza, zzgiVar5, bitSet, bitSet2, arrayMap, arrayMap13));
                                                        str4 = str4;
                                                        zzktVar3 = zzktVar6;
                                                        str15 = str15;
                                                        map6 = map16;
                                                        it = it;
                                                        str5 = str5;
                                                        map4 = map4;
                                                        str3 = str3;
                                                        map5 = map5;
                                                    }
                                                }
                                                zzktVar2 = zzktVar3;
                                                str7 = str4;
                                                String str211 = str5;
                                                str8 = str3;
                                                str9 = str15;
                                                String str212 = str18;
                                                if (!list.isEmpty()) {
                                                    realConnectionPool = new RealConnectionPool(this);
                                                    arrayMap5 = new ArrayMap();
                                                    it8 = list.iterator();
                                                    while (it8.hasNext()) {
                                                        zzftVar = (zzft) it8.next();
                                                        zzftVarZza = realConnectionPool.zza(zzftVar, this.zza);
                                                        if (zzftVarZza != null) {
                                                            zzamVarZzi2 = zzktVar2.zzi();
                                                            str12 = this.zza;
                                                            strZzh = zzftVarZza.zzh();
                                                            zzasVarZzn = zzamVarZzi2.zzn(str12, zzftVar.zzh());
                                                            if (zzasVarZzn == null) {
                                                                zzfr zzfrVar12 = (zzfr) zzamVarZzi2.mBuilder;
                                                                zzfrVar12.zzay().zzk().zzc(zzeh.zzn(str12), "Event aggregate wasn't created during raw event logging. appId, event", zzfrVar12.zzj().zzd(strZzh));
                                                                zzasVar = new zzas(str12, zzftVar.zzh(), 1L, 1L, 1L, zzftVar.zzd(), 0L, null, null, null, null);
                                                            } else {
                                                                zzasVar = new zzas(zzasVarZzn.zza, zzasVarZzn.zzb, zzasVarZzn.zzc + 1, zzasVarZzn.zzd + 1, zzasVarZzn.zze + 1, zzasVarZzn.zzf, zzasVarZzn.zzg, zzasVarZzn.zzh, zzasVarZzn.zzi, zzasVarZzn.zzj, zzasVarZzn.zzk);
                                                            }
                                                            zzasVar2 = zzasVar;
                                                            zzktVar2.zzi().zzE(zzasVar2);
                                                            strZzh2 = zzftVarZza.zzh();
                                                            map8 = (Map) arrayMap5.get(strZzh2);
                                                            if (map8 == null) {
                                                                zzam zzamVarZzi12 = zzktVar2.zzi();
                                                                zzfr zzfrVar13 = (zzfr) zzamVarZzi12.mBuilder;
                                                                str13 = this.zza;
                                                                zzamVarZzi12.zzW();
                                                                zzamVarZzi12.zzg();
                                                                com.google.android.gms.common.internal.zzah.checkNotEmpty(str13);
                                                                com.google.android.gms.common.internal.zzah.checkNotEmpty(strZzh2);
                                                                arrayMap6 = new ArrayMap();
                                                                cursorQuery3 = zzamVarZzi12.zzh().query("event_filters", new String[]{str7, str8}, "app_id=? AND event_name=?", new String[]{str13, strZzh2}, null, null, null);
                                                                if (cursorQuery3.moveToFirst()) {
                                                                    zzasVar3 = zzasVar2;
                                                                    while (true) {
                                                                        zzek zzekVar7 = (zzek) ((com.google.android.gms.internal.measurement.zzej) zzen.zzl(zzek.zzc(), cursorQuery3.getBlob(1))).zzaC();
                                                                        numValueOf5 = Integer.valueOf(cursorQuery3.getInt(0));
                                                                        list6 = (List) arrayMap6.get(numValueOf5);
                                                                        if (list6 == null) {
                                                                            realConnectionPool2 = realConnectionPool;
                                                                            arrayList4 = new ArrayList();
                                                                            arrayMap6.put(numValueOf5, arrayList4);
                                                                        } else {
                                                                            realConnectionPool2 = realConnectionPool;
                                                                            arrayList4 = list6;
                                                                        }
                                                                        arrayList4.add(zzekVar7);
                                                                        if (!cursorQuery3.moveToNext()) {
                                                                            break;
                                                                            break;
                                                                        }
                                                                        realConnectionPool = realConnectionPool2;
                                                                    }
                                                                    cursorQuery3.close();
                                                                    map13 = arrayMap6;
                                                                } else {
                                                                    zzasVar3 = zzasVar2;
                                                                    realConnectionPool2 = realConnectionPool;
                                                                    mapEmptyMap2 = Collections.emptyMap();
                                                                    cursorQuery3.close();
                                                                    map13 = mapEmptyMap2;
                                                                }
                                                                arrayMap5.put(strZzh2, map13);
                                                                map9 = map13;
                                                            } else {
                                                                zzasVar3 = zzasVar2;
                                                                realConnectionPool2 = realConnectionPool;
                                                                map9 = map8;
                                                            }
                                                            it9 = map9.keySet().iterator();
                                                            while (it9.hasNext()) {
                                                                num4 = (Integer) it9.next();
                                                                iIntValue = num4.intValue();
                                                                if (this.zzb.contains(num4)) {
                                                                    zzfrVar2.zzay().zzj().zzb(num4, "Skipping failed audience ID");
                                                                } else {
                                                                    it10 = ((List) map9.get(num4)).iterator();
                                                                    zZzd2 = true;
                                                                    map10 = map9;
                                                                    while (true) {
                                                                        if (!it10.hasNext()) {
                                                                            it11 = it9;
                                                                            zzasVar4 = zzasVar3;
                                                                            map11 = map10;
                                                                            num5 = num4;
                                                                            break;
                                                                        }
                                                                        zzek zzekVar8 = (zzek) it10.next();
                                                                        it11 = it9;
                                                                        zzasVar4 = zzasVar3;
                                                                        map12 = map10;
                                                                        num5 = num4;
                                                                        zzxVar2 = new zzx(this, this.zza, iIntValue, zzekVar8, 0);
                                                                        Long l9 = this.zzd;
                                                                        Long l10 = this.zze;
                                                                        iZzb = zzekVar8.zzb();
                                                                        zzuVar = (zzu) this.zzc.getOrDefault(num5, null);
                                                                        if (zzuVar == null) {
                                                                            z2 = false;
                                                                        } else {
                                                                            z2 = zzuVar.zze.get(iZzb);
                                                                        }
                                                                        zZzd2 = zzxVar2.zzd(l9, l10, zzftVarZza, zzasVar4.zzc, zzasVar4, z2);
                                                                        if (!zZzd2) {
                                                                            this.zzb.add(num5);
                                                                            map11 = map12;
                                                                            break;
                                                                        }
                                                                        zzd(num5).zzc(zzxVar2);
                                                                        num4 = num5;
                                                                        map10 = map12;
                                                                        zzasVar3 = zzasVar4;
                                                                        it9 = it11;
                                                                    }
                                                                    if (!zZzd2) {
                                                                        this.zzb.add(num5);
                                                                    }
                                                                    map9 = map11;
                                                                    zzasVar3 = zzasVar4;
                                                                    it9 = it11;
                                                                }
                                                            }
                                                            realConnectionPool = realConnectionPool2;
                                                        }
                                                    }
                                                }
                                                if (!list2.isEmpty()) {
                                                    arrayMap4 = new ArrayMap();
                                                    it5 = list2.iterator();
                                                    while (it5.hasNext()) {
                                                        com.google.android.gms.internal.measurement.zzgm zzgmVar3 = (com.google.android.gms.internal.measurement.zzgm) it5.next();
                                                        strZzf = zzgmVar3.zzf();
                                                        map7 = (Map) arrayMap4.get(strZzf);
                                                        if (map7 == null) {
                                                            zzam zzamVarZzi13 = zzktVar2.zzi();
                                                            zzfr zzfrVar14 = (zzfr) zzamVarZzi13.mBuilder;
                                                            str11 = this.zza;
                                                            zzamVarZzi13.zzW();
                                                            zzamVarZzi13.zzg();
                                                            com.google.android.gms.common.internal.zzah.checkNotEmpty(str11);
                                                            com.google.android.gms.common.internal.zzah.checkNotEmpty(strZzf);
                                                            ArrayMap arrayMap14 = new ArrayMap();
                                                            cursorQuery2 = zzamVarZzi13.zzh().query("property_filters", new String[]{str7, str8}, "app_id=? AND property_name=?", new String[]{str11, strZzf}, null, null, null);
                                                            simpleArrayMap = arrayMap14;
                                                            if (cursorQuery2.moveToFirst()) {
                                                                while (true) {
                                                                    zzet zzetVar4 = (zzet) ((com.google.android.gms.internal.measurement.zzes) zzen.zzl(zzet.zzc(), cursorQuery2.getBlob(1))).zzaC();
                                                                    numValueOf4 = Integer.valueOf(cursorQuery2.getInt(0));
                                                                    list5 = (List) simpleArrayMap.get(numValueOf4);
                                                                    if (list5 == null) {
                                                                        it6 = it5;
                                                                        arrayList3 = new ArrayList();
                                                                        simpleArrayMap.put(numValueOf4, arrayList3);
                                                                    } else {
                                                                        it6 = it5;
                                                                        arrayList3 = list5;
                                                                    }
                                                                    arrayList3.add(zzetVar4);
                                                                    if (!cursorQuery2.moveToNext()) {
                                                                        break;
                                                                        break;
                                                                    }
                                                                    it5 = it6;
                                                                    simpleArrayMap = simpleArrayMap;
                                                                }
                                                                cursorQuery2.close();
                                                                obj3 = simpleArrayMap;
                                                            } else {
                                                                it6 = it5;
                                                                mapEmptyMap = Collections.emptyMap();
                                                                cursorQuery2.close();
                                                                obj3 = mapEmptyMap;
                                                            }
                                                            arrayMap4.put(strZzf, obj3);
                                                            r1 = obj3;
                                                        } else {
                                                            it6 = it5;
                                                            r1 = map7;
                                                        }
                                                        r2 = r1;
                                                        while (r10.hasNext()) {
                                                            int iIntValue6 = num6.intValue();
                                                            if (this.zzb.contains(num6)) {
                                                                zzfrVar2.zzay().zzj().zzb(num6, "Skipping failed audience ID");
                                                                break;
                                                                break;
                                                            }
                                                            it7 = ((List) r2.get(num6)).iterator();
                                                            zZzd = true;
                                                            r3 = r2;
                                                            while (true) {
                                                                if (it7.hasNext()) {
                                                                    zzetVar = (zzet) it7.next();
                                                                    if (Log.isLoggable(zzfrVar2.zzay().zzq(), 2)) {
                                                                        zzef zzefVarZzj3 = zzfrVar2.zzay().zzj();
                                                                        if (zzetVar.zzj()) {
                                                                            numValueOf3 = Integer.valueOf(zzetVar.zza());
                                                                        } else {
                                                                            numValueOf3 = null;
                                                                        }
                                                                        zzefVarZzj3.zzd("Evaluating filter. audience, filter, property", num6, numValueOf3, zzfrVar2.zzj().zzf(zzetVar.zze()));
                                                                        zzfrVar2.zzay().zzj().zzb(zzktVar2.zzu().zzp(zzetVar), "Filter definition");
                                                                    }
                                                                    if (zzetVar.zzj()) {
                                                                    }
                                                                    r57 = r3;
                                                                    num3 = num6;
                                                                    zzef zzefVarZzk3 = zzfrVar2.zzay().zzk();
                                                                    zzeg zzegVarZzn5 = zzeh.zzn(this.zza);
                                                                    if (zzetVar.zzj()) {
                                                                        numValueOf2 = Integer.valueOf(zzetVar.zza());
                                                                    } else {
                                                                        numValueOf2 = null;
                                                                    }
                                                                    zzefVarZzk3.zzc(zzegVarZzn5, "Invalid property filter ID. appId, id", String.valueOf(numValueOf2));
                                                                    this.zzb.add(num3);
                                                                    r2 = r57;
                                                                } else {
                                                                    r57 = r3;
                                                                    num3 = num6;
                                                                }
                                                                if (!zZzd) {
                                                                    this.zzb.add(num3);
                                                                }
                                                                r2 = r57;
                                                                zzd(num3).zzc(zzxVar);
                                                                num6 = num3;
                                                                r3 = r58;
                                                            }
                                                        }
                                                        it5 = it6;
                                                    }
                                                }
                                                arrayList2 = new ArrayList();
                                                MapCollections$KeySet<Integer> mapCollections$KeySet3 = (MapCollections$KeySet) this.zzc.keySet();
                                                mapCollections$KeySet3.removeAll(this.zzb);
                                                while (r2.hasNext()) {
                                                    int iIntValue7 = num7.intValue();
                                                    zzu zzuVar4 = (zzu) this.zzc.get(num7);
                                                    com.google.android.gms.common.internal.zzah.checkNotNull(zzuVar4);
                                                    zzfp zzfpVarZza3 = zzuVar4.zza(iIntValue7);
                                                    arrayList2.add(zzfpVarZza3);
                                                    zzamVarZzi = zzktVar2.zzi();
                                                    zzfrVar = (zzfr) zzamVarZzi.mBuilder;
                                                    str10 = this.zza;
                                                    com.google.android.gms.internal.measurement.zzgi zzgiVarZzd3 = zzfpVarZza3.zzd();
                                                    zzamVarZzi.zzW();
                                                    zzamVarZzi.zzg();
                                                    com.google.android.gms.common.internal.zzah.checkNotEmpty(str10);
                                                    com.google.android.gms.common.internal.zzah.checkNotNull(zzgiVarZzd3);
                                                    byte[] bArrZzbu3 = zzgiVarZzd3.zzbu();
                                                    contentValues = new ContentValues();
                                                    contentValues.put("app_id", str10);
                                                    contentValues.put(str7, num7);
                                                    String str213 = str9;
                                                    contentValues.put(str213, bArrZzbu3);
                                                    if (zzamVarZzi.zzh().insertWithOnConflict("audience_filter_values", null, contentValues, 5) == -1) {
                                                        zzfrVar.zzay().zzd().zzb(zzeh.zzn(str10), "Failed to insert filter results (got -1). appId");
                                                    }
                                                    str9 = str213;
                                                }
                                                return arrayList2;
                                            }
                                        } catch (SQLiteException e21) {
                                            e = e21;
                                            z3 = zZzs;
                                        }
                                    } catch (SQLiteException e22) {
                                        e = e22;
                                        r110 = zZzs;
                                        r111 = zZzs2 ? 1 : 0;
                                        cursorQuery4 = null;
                                        zzef zzefVarZzd3 = zzfrVar3.zzay().zzd();
                                        zzeg zzegVarZzn6 = zzeh.zzn(str21);
                                        zzefVarZzd3.zzc(zzegVarZzn6, "Database error querying filters. appId", e);
                                        mapEmptyMap3 = Collections.emptyMap();
                                        obj = zzegVarZzn6;
                                        r16 = r110;
                                        r18 = r111;
                                        obj4 = zzegVarZzn6;
                                        r113 = r110;
                                        r112 = r111;
                                        if (cursorQuery4 != null) {
                                            cursorQuery4.close();
                                            obj = obj4;
                                            r16 = r113;
                                            r18 = r112;
                                        }
                                        map = mapEmptyMap3;
                                        obj2 = obj;
                                        r17 = r16;
                                        r19 = r18;
                                        zzam zzamVarZzi14 = zzktVar3.zzi();
                                        zzfr zzfrVar15 = (zzfr) zzamVarZzi14.mBuilder;
                                        String str214 = this.zza;
                                        zzamVarZzi14.zzW();
                                        zzamVarZzi14.zzg();
                                        com.google.android.gms.common.internal.zzah.checkNotEmpty(str214);
                                        cursorQuery = zzamVarZzi14.zzh().query("audience_filter_values", new String[]{"audience_id", str15}, "app_id=?", new String[]{str214}, null, null, null);
                                        if (cursorQuery.moveToFirst()) {
                                            Map mapEmptyMap10 = Collections.emptyMap();
                                            cursorQuery.close();
                                            map2 = mapEmptyMap10;
                                            str4 = "audience_id";
                                            str5 = "Database error querying filters. appId";
                                            str18 = "Failed to merge filter. appId";
                                        } else {
                                            arrayMap7 = new ArrayMap();
                                            while (true) {
                                                i2 = cursorQuery.getInt(0);
                                                arrayMap7.put(Integer.valueOf(i2), (com.google.android.gms.internal.measurement.zzgi) ((zzgh) zzen.zzl(com.google.android.gms.internal.measurement.zzgi.zzf(), cursorQuery.getBlob(1))).zzaC());
                                                str4 = str20;
                                                str5 = str19;
                                                if (!cursorQuery.moveToNext()) {
                                                    break;
                                                    break;
                                                }
                                                str20 = str4;
                                                str19 = str5;
                                                str18 = str18;
                                            }
                                            cursorQuery.close();
                                            map2 = arrayMap7;
                                        }
                                        if (!map2.isEmpty()) {
                                            HashSet hashSet3 = new HashSet(map2.keySet());
                                            if (z) {
                                                String str215 = this.zza;
                                                zzam zzamVarZzi15 = zzktVar3.zzi();
                                                str6 = this.zza;
                                                zzamVarZzi15.zzW();
                                                zzamVarZzi15.zzg();
                                                com.google.android.gms.common.internal.zzah.checkNotEmpty(str6);
                                                arrayMap2 = new ArrayMap();
                                                sQLiteDatabaseZzh = zzamVarZzi15.zzh();
                                                cursorRawQuery = sQLiteDatabaseZzh.rawQuery("select audience_id, filter_id from event_filters where app_id = ? and session_scoped = 1 UNION select audience_id, filter_id from property_filters where app_id = ? and session_scoped = 1;", new String[]{str6, str6});
                                                if (cursorRawQuery.moveToFirst()) {
                                                    do {
                                                        numValueOf = Integer.valueOf(cursorRawQuery.getInt(0));
                                                        arrayList = (List) arrayMap2.get(numValueOf);
                                                        if (arrayList == null) {
                                                            arrayList = new ArrayList();
                                                            arrayMap2.put(numValueOf, arrayList);
                                                        }
                                                        arrayList.add(Integer.valueOf(cursorRawQuery.getInt(1)));
                                                    } while (cursorRawQuery.moveToNext());
                                                } else {
                                                    arrayMap2 = Collections.emptyMap();
                                                }
                                                cursorRawQuery.close();
                                                r0 = arrayMap2;
                                                com.google.android.gms.common.internal.zzah.checkNotEmpty(str215);
                                                arrayMap3 = new ArrayMap();
                                                if (!map2.isEmpty()) {
                                                    it3 = map2.keySet().iterator();
                                                    while (it3.hasNext()) {
                                                        num2 = (Integer) it3.next();
                                                        num2.getClass();
                                                        zzgiVar2 = (com.google.android.gms.internal.measurement.zzgi) map2.get(num2);
                                                        list4 = (List) r0.get(num2);
                                                        if (list4 != null) {
                                                        }
                                                        zzagVar = zzagVar2;
                                                        it4 = it3;
                                                        arrayMap3.put(num2, zzgiVar2);
                                                        r0 = r0;
                                                        zzagVar2 = zzagVar;
                                                        it3 = it4;
                                                    }
                                                }
                                                map3 = arrayMap3;
                                            } else {
                                                map3 = map2;
                                            }
                                            it = hashSet3.iterator();
                                            map6 = map3;
                                            map5 = map;
                                            map4 = map2;
                                            while (it.hasNext()) {
                                                num = (Integer) it.next();
                                                num.getClass();
                                                zzgiVar = (com.google.android.gms.internal.measurement.zzgi) map6.get(num);
                                                bitSet = new BitSet();
                                                bitSet2 = new BitSet();
                                                arrayMap = new ArrayMap();
                                                if (zzgiVar != null) {
                                                    while (r2.hasNext()) {
                                                        if (zzfrVar5.zzh()) {
                                                            Integer numValueOf10 = Integer.valueOf(zzfrVar5.zza());
                                                            if (zzfrVar5.zzg()) {
                                                                lValueOf = Long.valueOf(zzfrVar5.zzb());
                                                            } else {
                                                                lValueOf = null;
                                                            }
                                                            arrayMap.put(numValueOf10, lValueOf);
                                                        }
                                                    }
                                                }
                                                ArrayMap arrayMap15 = new ArrayMap();
                                                if (zzgiVar != null) {
                                                    it2 = zzgiVar.zzm().iterator();
                                                    while (it2.hasNext()) {
                                                        zzgkVar = (zzgk) it2.next();
                                                        if (!zzgkVar.zzi()) {
                                                        }
                                                    }
                                                }
                                                Map map17 = map6;
                                                if (zzgiVar != null) {
                                                    i = 0;
                                                    while (i < zzgiVar.zzd() * 64) {
                                                        if (zzen.zzv(i, zzgiVar.zzn())) {
                                                            zzktVar = zzktVar3;
                                                            zzfrVar2.zzay().zzj().zzc(num, "Filter already evaluated. audience ID, filter ID", Integer.valueOf(i));
                                                            bitSet2.set(i);
                                                            if (zzen.zzv(i, zzgiVar.zzk())) {
                                                                bitSet.set(i);
                                                            }
                                                            i++;
                                                            zzktVar3 = zzktVar;
                                                        } else {
                                                            zzktVar = zzktVar3;
                                                        }
                                                        arrayMap.remove(Integer.valueOf(i));
                                                        i++;
                                                        zzktVar3 = zzktVar;
                                                    }
                                                }
                                                zzkt zzktVar7 = zzktVar3;
                                                com.google.android.gms.internal.measurement.zzgi zzgiVar6 = (com.google.android.gms.internal.measurement.zzgi) map4.get(num);
                                                if (r19 == 0) {
                                                }
                                                this.zzc.put(num, new zzu(this, this.zza, zzgiVar6, bitSet, bitSet2, arrayMap, arrayMap15));
                                                str4 = str4;
                                                zzktVar3 = zzktVar7;
                                                str15 = str15;
                                                map6 = map17;
                                                it = it;
                                                str5 = str5;
                                                map4 = map4;
                                                str3 = str3;
                                                map5 = map5;
                                            }
                                        }
                                        zzktVar2 = zzktVar3;
                                        str7 = str4;
                                        String str216 = str5;
                                        str8 = str3;
                                        str9 = str15;
                                        String str217 = str18;
                                        if (!list.isEmpty()) {
                                            realConnectionPool = new RealConnectionPool(this);
                                            arrayMap5 = new ArrayMap();
                                            it8 = list.iterator();
                                            while (it8.hasNext()) {
                                                zzftVar = (zzft) it8.next();
                                                zzftVarZza = realConnectionPool.zza(zzftVar, this.zza);
                                                if (zzftVarZza != null) {
                                                    zzamVarZzi2 = zzktVar2.zzi();
                                                    str12 = this.zza;
                                                    strZzh = zzftVarZza.zzh();
                                                    zzasVarZzn = zzamVarZzi2.zzn(str12, zzftVar.zzh());
                                                    if (zzasVarZzn == null) {
                                                        zzfr zzfrVar16 = (zzfr) zzamVarZzi2.mBuilder;
                                                        zzfrVar16.zzay().zzk().zzc(zzeh.zzn(str12), "Event aggregate wasn't created during raw event logging. appId, event", zzfrVar16.zzj().zzd(strZzh));
                                                        zzasVar = new zzas(str12, zzftVar.zzh(), 1L, 1L, 1L, zzftVar.zzd(), 0L, null, null, null, null);
                                                    } else {
                                                        zzasVar = new zzas(zzasVarZzn.zza, zzasVarZzn.zzb, zzasVarZzn.zzc + 1, zzasVarZzn.zzd + 1, zzasVarZzn.zze + 1, zzasVarZzn.zzf, zzasVarZzn.zzg, zzasVarZzn.zzh, zzasVarZzn.zzi, zzasVarZzn.zzj, zzasVarZzn.zzk);
                                                    }
                                                    zzasVar2 = zzasVar;
                                                    zzktVar2.zzi().zzE(zzasVar2);
                                                    strZzh2 = zzftVarZza.zzh();
                                                    map8 = (Map) arrayMap5.get(strZzh2);
                                                    if (map8 == null) {
                                                        zzam zzamVarZzi16 = zzktVar2.zzi();
                                                        zzfr zzfrVar17 = (zzfr) zzamVarZzi16.mBuilder;
                                                        str13 = this.zza;
                                                        zzamVarZzi16.zzW();
                                                        zzamVarZzi16.zzg();
                                                        com.google.android.gms.common.internal.zzah.checkNotEmpty(str13);
                                                        com.google.android.gms.common.internal.zzah.checkNotEmpty(strZzh2);
                                                        arrayMap6 = new ArrayMap();
                                                        cursorQuery3 = zzamVarZzi16.zzh().query("event_filters", new String[]{str7, str8}, "app_id=? AND event_name=?", new String[]{str13, strZzh2}, null, null, null);
                                                        if (cursorQuery3.moveToFirst()) {
                                                            zzasVar3 = zzasVar2;
                                                            while (true) {
                                                                zzek zzekVar9 = (zzek) ((com.google.android.gms.internal.measurement.zzej) zzen.zzl(zzek.zzc(), cursorQuery3.getBlob(1))).zzaC();
                                                                numValueOf5 = Integer.valueOf(cursorQuery3.getInt(0));
                                                                list6 = (List) arrayMap6.get(numValueOf5);
                                                                if (list6 == null) {
                                                                    realConnectionPool2 = realConnectionPool;
                                                                    arrayList4 = new ArrayList();
                                                                    arrayMap6.put(numValueOf5, arrayList4);
                                                                } else {
                                                                    realConnectionPool2 = realConnectionPool;
                                                                    arrayList4 = list6;
                                                                }
                                                                arrayList4.add(zzekVar9);
                                                                if (!cursorQuery3.moveToNext()) {
                                                                    break;
                                                                    break;
                                                                }
                                                                realConnectionPool = realConnectionPool2;
                                                            }
                                                            cursorQuery3.close();
                                                            map13 = arrayMap6;
                                                        } else {
                                                            zzasVar3 = zzasVar2;
                                                            realConnectionPool2 = realConnectionPool;
                                                            mapEmptyMap2 = Collections.emptyMap();
                                                            cursorQuery3.close();
                                                            map13 = mapEmptyMap2;
                                                        }
                                                        arrayMap5.put(strZzh2, map13);
                                                        map9 = map13;
                                                    } else {
                                                        zzasVar3 = zzasVar2;
                                                        realConnectionPool2 = realConnectionPool;
                                                        map9 = map8;
                                                    }
                                                    it9 = map9.keySet().iterator();
                                                    while (it9.hasNext()) {
                                                        num4 = (Integer) it9.next();
                                                        iIntValue = num4.intValue();
                                                        if (this.zzb.contains(num4)) {
                                                            zzfrVar2.zzay().zzj().zzb(num4, "Skipping failed audience ID");
                                                        } else {
                                                            it10 = ((List) map9.get(num4)).iterator();
                                                            zZzd2 = true;
                                                            map10 = map9;
                                                            while (true) {
                                                                if (!it10.hasNext()) {
                                                                    it11 = it9;
                                                                    zzasVar4 = zzasVar3;
                                                                    map11 = map10;
                                                                    num5 = num4;
                                                                    break;
                                                                }
                                                                zzek zzekVar10 = (zzek) it10.next();
                                                                it11 = it9;
                                                                zzasVar4 = zzasVar3;
                                                                map12 = map10;
                                                                num5 = num4;
                                                                zzxVar2 = new zzx(this, this.zza, iIntValue, zzekVar10, 0);
                                                                Long l11 = this.zzd;
                                                                Long l12 = this.zze;
                                                                iZzb = zzekVar10.zzb();
                                                                zzuVar = (zzu) this.zzc.getOrDefault(num5, null);
                                                                if (zzuVar == null) {
                                                                    z2 = false;
                                                                } else {
                                                                    z2 = zzuVar.zze.get(iZzb);
                                                                }
                                                                zZzd2 = zzxVar2.zzd(l11, l12, zzftVarZza, zzasVar4.zzc, zzasVar4, z2);
                                                                if (!zZzd2) {
                                                                    this.zzb.add(num5);
                                                                    map11 = map12;
                                                                    break;
                                                                }
                                                                zzd(num5).zzc(zzxVar2);
                                                                num4 = num5;
                                                                map10 = map12;
                                                                zzasVar3 = zzasVar4;
                                                                it9 = it11;
                                                            }
                                                            if (!zZzd2) {
                                                                this.zzb.add(num5);
                                                            }
                                                            map9 = map11;
                                                            zzasVar3 = zzasVar4;
                                                            it9 = it11;
                                                        }
                                                    }
                                                    realConnectionPool = realConnectionPool2;
                                                }
                                            }
                                        }
                                        if (!list2.isEmpty()) {
                                            arrayMap4 = new ArrayMap();
                                            it5 = list2.iterator();
                                            while (it5.hasNext()) {
                                                com.google.android.gms.internal.measurement.zzgm zzgmVar4 = (com.google.android.gms.internal.measurement.zzgm) it5.next();
                                                strZzf = zzgmVar4.zzf();
                                                map7 = (Map) arrayMap4.get(strZzf);
                                                if (map7 == null) {
                                                    zzam zzamVarZzi17 = zzktVar2.zzi();
                                                    zzfr zzfrVar18 = (zzfr) zzamVarZzi17.mBuilder;
                                                    str11 = this.zza;
                                                    zzamVarZzi17.zzW();
                                                    zzamVarZzi17.zzg();
                                                    com.google.android.gms.common.internal.zzah.checkNotEmpty(str11);
                                                    com.google.android.gms.common.internal.zzah.checkNotEmpty(strZzf);
                                                    ArrayMap arrayMap16 = new ArrayMap();
                                                    cursorQuery2 = zzamVarZzi17.zzh().query("property_filters", new String[]{str7, str8}, "app_id=? AND property_name=?", new String[]{str11, strZzf}, null, null, null);
                                                    simpleArrayMap = arrayMap16;
                                                    if (cursorQuery2.moveToFirst()) {
                                                        while (true) {
                                                            zzet zzetVar5 = (zzet) ((com.google.android.gms.internal.measurement.zzes) zzen.zzl(zzet.zzc(), cursorQuery2.getBlob(1))).zzaC();
                                                            numValueOf4 = Integer.valueOf(cursorQuery2.getInt(0));
                                                            list5 = (List) simpleArrayMap.get(numValueOf4);
                                                            if (list5 == null) {
                                                                it6 = it5;
                                                                arrayList3 = new ArrayList();
                                                                simpleArrayMap.put(numValueOf4, arrayList3);
                                                            } else {
                                                                it6 = it5;
                                                                arrayList3 = list5;
                                                            }
                                                            arrayList3.add(zzetVar5);
                                                            if (!cursorQuery2.moveToNext()) {
                                                                break;
                                                                break;
                                                            }
                                                            it5 = it6;
                                                            simpleArrayMap = simpleArrayMap;
                                                        }
                                                        cursorQuery2.close();
                                                        obj3 = simpleArrayMap;
                                                    } else {
                                                        it6 = it5;
                                                        mapEmptyMap = Collections.emptyMap();
                                                        cursorQuery2.close();
                                                        obj3 = mapEmptyMap;
                                                    }
                                                    arrayMap4.put(strZzf, obj3);
                                                    r1 = obj3;
                                                } else {
                                                    it6 = it5;
                                                    r1 = map7;
                                                }
                                                r2 = r1;
                                                while (r10.hasNext()) {
                                                    int iIntValue8 = num6.intValue();
                                                    if (this.zzb.contains(num6)) {
                                                        zzfrVar2.zzay().zzj().zzb(num6, "Skipping failed audience ID");
                                                        break;
                                                        break;
                                                    }
                                                    it7 = ((List) r2.get(num6)).iterator();
                                                    zZzd = true;
                                                    r3 = r2;
                                                    while (true) {
                                                        if (it7.hasNext()) {
                                                            zzetVar = (zzet) it7.next();
                                                            if (Log.isLoggable(zzfrVar2.zzay().zzq(), 2)) {
                                                                zzef zzefVarZzj4 = zzfrVar2.zzay().zzj();
                                                                if (zzetVar.zzj()) {
                                                                    numValueOf3 = Integer.valueOf(zzetVar.zza());
                                                                } else {
                                                                    numValueOf3 = null;
                                                                }
                                                                zzefVarZzj4.zzd("Evaluating filter. audience, filter, property", num6, numValueOf3, zzfrVar2.zzj().zzf(zzetVar.zze()));
                                                                zzfrVar2.zzay().zzj().zzb(zzktVar2.zzu().zzp(zzetVar), "Filter definition");
                                                            }
                                                            if (zzetVar.zzj()) {
                                                            }
                                                            r57 = r3;
                                                            num3 = num6;
                                                            zzef zzefVarZzk4 = zzfrVar2.zzay().zzk();
                                                            zzeg zzegVarZzn7 = zzeh.zzn(this.zza);
                                                            if (zzetVar.zzj()) {
                                                                numValueOf2 = Integer.valueOf(zzetVar.zza());
                                                            } else {
                                                                numValueOf2 = null;
                                                            }
                                                            zzefVarZzk4.zzc(zzegVarZzn7, "Invalid property filter ID. appId, id", String.valueOf(numValueOf2));
                                                            this.zzb.add(num3);
                                                            r2 = r57;
                                                        } else {
                                                            r57 = r3;
                                                            num3 = num6;
                                                        }
                                                        if (!zZzd) {
                                                            this.zzb.add(num3);
                                                        }
                                                        r2 = r57;
                                                        zzd(num3).zzc(zzxVar);
                                                        num6 = num3;
                                                        r3 = r58;
                                                    }
                                                }
                                                it5 = it6;
                                            }
                                        }
                                        arrayList2 = new ArrayList();
                                        MapCollections$KeySet<Integer> mapCollections$KeySet4 = (MapCollections$KeySet) this.zzc.keySet();
                                        mapCollections$KeySet4.removeAll(this.zzb);
                                        while (r2.hasNext()) {
                                            int iIntValue9 = num7.intValue();
                                            zzu zzuVar5 = (zzu) this.zzc.get(num7);
                                            com.google.android.gms.common.internal.zzah.checkNotNull(zzuVar5);
                                            zzfp zzfpVarZza4 = zzuVar5.zza(iIntValue9);
                                            arrayList2.add(zzfpVarZza4);
                                            zzamVarZzi = zzktVar2.zzi();
                                            zzfrVar = (zzfr) zzamVarZzi.mBuilder;
                                            str10 = this.zza;
                                            com.google.android.gms.internal.measurement.zzgi zzgiVarZzd4 = zzfpVarZza4.zzd();
                                            zzamVarZzi.zzW();
                                            zzamVarZzi.zzg();
                                            com.google.android.gms.common.internal.zzah.checkNotEmpty(str10);
                                            com.google.android.gms.common.internal.zzah.checkNotNull(zzgiVarZzd4);
                                            byte[] bArrZzbu4 = zzgiVarZzd4.zzbu();
                                            contentValues = new ContentValues();
                                            contentValues.put("app_id", str10);
                                            contentValues.put(str7, num7);
                                            String str218 = str9;
                                            contentValues.put(str218, bArrZzbu4);
                                            if (zzamVarZzi.zzh().insertWithOnConflict("audience_filter_values", null, contentValues, 5) == -1) {
                                                zzfrVar.zzay().zzd().zzb(zzeh.zzn(str10), "Failed to insert filter results (got -1). appId");
                                            }
                                            str9 = str218;
                                        }
                                        return arrayList2;
                                    }
                                } catch (SQLiteException e23) {
                                    e = e23;
                                    str3 = "data";
                                }
                                zzam zzamVarZzi18 = zzktVar3.zzi();
                                zzfr zzfrVar19 = (zzfr) zzamVarZzi18.mBuilder;
                                String str219 = this.zza;
                                zzamVarZzi18.zzW();
                                zzamVarZzi18.zzg();
                                com.google.android.gms.common.internal.zzah.checkNotEmpty(str219);
                                cursorQuery = zzamVarZzi18.zzh().query("audience_filter_values", new String[]{"audience_id", str15}, "app_id=?", new String[]{str219}, null, null, null);
                                if (cursorQuery.moveToFirst()) {
                                    Map mapEmptyMap11 = Collections.emptyMap();
                                    cursorQuery.close();
                                    map2 = mapEmptyMap11;
                                    str4 = "audience_id";
                                    str5 = "Database error querying filters. appId";
                                    str18 = "Failed to merge filter. appId";
                                } else {
                                    arrayMap7 = new ArrayMap();
                                    while (true) {
                                        i2 = cursorQuery.getInt(0);
                                        arrayMap7.put(Integer.valueOf(i2), (com.google.android.gms.internal.measurement.zzgi) ((zzgh) zzen.zzl(com.google.android.gms.internal.measurement.zzgi.zzf(), cursorQuery.getBlob(1))).zzaC());
                                        str4 = str20;
                                        str5 = str19;
                                        if (!cursorQuery.moveToNext()) {
                                            break;
                                            break;
                                        }
                                        str20 = str4;
                                        str19 = str5;
                                        str18 = str18;
                                    }
                                    cursorQuery.close();
                                    map2 = arrayMap7;
                                }
                                if (!map2.isEmpty()) {
                                    HashSet hashSet4 = new HashSet(map2.keySet());
                                    if (z) {
                                        String str2110 = this.zza;
                                        zzam zzamVarZzi19 = zzktVar3.zzi();
                                        str6 = this.zza;
                                        zzamVarZzi19.zzW();
                                        zzamVarZzi19.zzg();
                                        com.google.android.gms.common.internal.zzah.checkNotEmpty(str6);
                                        arrayMap2 = new ArrayMap();
                                        sQLiteDatabaseZzh = zzamVarZzi19.zzh();
                                        cursorRawQuery = sQLiteDatabaseZzh.rawQuery("select audience_id, filter_id from event_filters where app_id = ? and session_scoped = 1 UNION select audience_id, filter_id from property_filters where app_id = ? and session_scoped = 1;", new String[]{str6, str6});
                                        if (cursorRawQuery.moveToFirst()) {
                                            do {
                                                numValueOf = Integer.valueOf(cursorRawQuery.getInt(0));
                                                arrayList = (List) arrayMap2.get(numValueOf);
                                                if (arrayList == null) {
                                                    arrayList = new ArrayList();
                                                    arrayMap2.put(numValueOf, arrayList);
                                                }
                                                arrayList.add(Integer.valueOf(cursorRawQuery.getInt(1)));
                                            } while (cursorRawQuery.moveToNext());
                                        } else {
                                            arrayMap2 = Collections.emptyMap();
                                        }
                                        cursorRawQuery.close();
                                        r0 = arrayMap2;
                                        com.google.android.gms.common.internal.zzah.checkNotEmpty(str2110);
                                        arrayMap3 = new ArrayMap();
                                        if (!map2.isEmpty()) {
                                            it3 = map2.keySet().iterator();
                                            while (it3.hasNext()) {
                                                num2 = (Integer) it3.next();
                                                num2.getClass();
                                                zzgiVar2 = (com.google.android.gms.internal.measurement.zzgi) map2.get(num2);
                                                list4 = (List) r0.get(num2);
                                                if (list4 != null || list4.isEmpty()) {
                                                    zzagVar = zzagVar2;
                                                    it4 = it3;
                                                    arrayMap3.put(num2, zzgiVar2);
                                                    r0 = r0;
                                                    zzagVar2 = zzagVar;
                                                    it3 = it4;
                                                } else {
                                                    List listZzq = zzktVar3.zzu().zzq(zzgiVar2.zzk(), list4);
                                                    if (!listZzq.isEmpty()) {
                                                        zzgh zzghVar = (zzgh) zzgiVar2.zzby();
                                                        zzghVar.zzf();
                                                        zzghVar.zzb(listZzq);
                                                        List listZzq2 = zzktVar3.zzu().zzq(zzgiVar2.zzn(), list4);
                                                        zzghVar.zzh();
                                                        zzghVar.zzd(listZzq2);
                                                        zzoc.zzc();
                                                        if (zzagVar2.zzs(null, zzdu.zzas)) {
                                                            ArrayList arrayList6 = new ArrayList();
                                                            for (com.google.android.gms.internal.measurement.zzfr zzfrVar20 : zzgiVar2.zzj()) {
                                                                zzag zzagVar3 = zzagVar2;
                                                                Iterator it13 = it3;
                                                                if (!list4.contains(Integer.valueOf(zzfrVar20.zza()))) {
                                                                    arrayList6.add(zzfrVar20);
                                                                }
                                                                zzagVar2 = zzagVar3;
                                                                it3 = it13;
                                                            }
                                                            zzagVar = zzagVar2;
                                                            it4 = it3;
                                                            zzghVar.zze();
                                                            zzghVar.zza(arrayList6);
                                                            ArrayList arrayList7 = new ArrayList();
                                                            for (zzgk zzgkVar2 : zzgiVar2.zzm()) {
                                                                if (!list4.contains(Integer.valueOf(zzgkVar2.zzb()))) {
                                                                    arrayList7.add(zzgkVar2);
                                                                }
                                                            }
                                                            zzghVar.zzg();
                                                            zzghVar.zzc(arrayList7);
                                                        } else {
                                                            zzagVar = zzagVar2;
                                                            it4 = it3;
                                                            for (int i3 = 0; i3 < zzgiVar2.zza(); i3++) {
                                                                if (list4.contains(Integer.valueOf(zzgiVar2.zze(i3).zza()))) {
                                                                    zzghVar.zzi(i3);
                                                                }
                                                            }
                                                            for (int i4 = 0; i4 < zzgiVar2.zzc(); i4++) {
                                                                if (list4.contains(Integer.valueOf(zzgiVar2.zzi(i4).zzb()))) {
                                                                    zzghVar.zzj(i4);
                                                                }
                                                            }
                                                        }
                                                        arrayMap3.put(num2, (com.google.android.gms.internal.measurement.zzgi) zzghVar.zzaC());
                                                        r0 = r0;
                                                        zzagVar2 = zzagVar;
                                                        it3 = it4;
                                                    }
                                                }
                                            }
                                        }
                                        map3 = arrayMap3;
                                    } else {
                                        map3 = map2;
                                    }
                                    it = hashSet4.iterator();
                                    map6 = map3;
                                    map5 = map;
                                    map4 = map2;
                                    while (it.hasNext()) {
                                        num = (Integer) it.next();
                                        num.getClass();
                                        zzgiVar = (com.google.android.gms.internal.measurement.zzgi) map6.get(num);
                                        bitSet = new BitSet();
                                        bitSet2 = new BitSet();
                                        arrayMap = new ArrayMap();
                                        if (zzgiVar != null && zzgiVar.zza() != 0) {
                                            while (r2.hasNext()) {
                                                if (zzfrVar5.zzh()) {
                                                    Integer numValueOf11 = Integer.valueOf(zzfrVar5.zza());
                                                    if (zzfrVar5.zzg()) {
                                                        lValueOf = Long.valueOf(zzfrVar5.zzb());
                                                    } else {
                                                        lValueOf = null;
                                                    }
                                                    arrayMap.put(numValueOf11, lValueOf);
                                                }
                                            }
                                        }
                                        ArrayMap arrayMap17 = new ArrayMap();
                                        if (zzgiVar != null && zzgiVar.zzc() != 0) {
                                            it2 = zzgiVar.zzm().iterator();
                                            while (it2.hasNext()) {
                                                zzgkVar = (zzgk) it2.next();
                                                if (!zzgkVar.zzi() && zzgkVar.zza() > 0) {
                                                    arrayMap17.put(Integer.valueOf(zzgkVar.zzb()), Long.valueOf(zzgkVar.zzc(zzgkVar.zza() - 1)));
                                                    map6 = map6;
                                                    it2 = it2;
                                                }
                                            }
                                        }
                                        Map map18 = map6;
                                        if (zzgiVar != null) {
                                            i = 0;
                                            while (i < zzgiVar.zzd() * 64) {
                                                if (zzen.zzv(i, zzgiVar.zzn())) {
                                                    zzktVar = zzktVar3;
                                                    zzfrVar2.zzay().zzj().zzc(num, "Filter already evaluated. audience ID, filter ID", Integer.valueOf(i));
                                                    bitSet2.set(i);
                                                    if (zzen.zzv(i, zzgiVar.zzk())) {
                                                        bitSet.set(i);
                                                    }
                                                    i++;
                                                    zzktVar3 = zzktVar;
                                                } else {
                                                    zzktVar = zzktVar3;
                                                }
                                                arrayMap.remove(Integer.valueOf(i));
                                                i++;
                                                zzktVar3 = zzktVar;
                                            }
                                        }
                                        zzkt zzktVar8 = zzktVar3;
                                        com.google.android.gms.internal.measurement.zzgi zzgiVar7 = (com.google.android.gms.internal.measurement.zzgi) map4.get(num);
                                        if (r19 == 0 && r17 != 0 && (list3 = (List) map5.get(num)) != null && this.zze != null && this.zzd != null) {
                                            for (zzek zzekVar11 : list3) {
                                                int iZzb2 = zzekVar11.zzb();
                                                long jLongValue = this.zze.longValue() / 1000;
                                                if (zzekVar11.zzm()) {
                                                    jLongValue = this.zzd.longValue() / 1000;
                                                }
                                                Integer numValueOf12 = Integer.valueOf(iZzb2);
                                                if (arrayMap.containsKey(numValueOf12)) {
                                                    arrayMap.put(numValueOf12, Long.valueOf(jLongValue));
                                                }
                                                if (arrayMap17.containsKey(numValueOf12)) {
                                                    arrayMap17.put(numValueOf12, Long.valueOf(jLongValue));
                                                }
                                            }
                                        }
                                        this.zzc.put(num, new zzu(this, this.zza, zzgiVar7, bitSet, bitSet2, arrayMap, arrayMap17));
                                        str4 = str4;
                                        zzktVar3 = zzktVar8;
                                        str15 = str15;
                                        map6 = map18;
                                        it = it;
                                        str5 = str5;
                                        map4 = map4;
                                        str3 = str3;
                                        map5 = map5;
                                    }
                                }
                                zzktVar2 = zzktVar3;
                                str7 = str4;
                                String str2111 = str5;
                                str8 = str3;
                                str9 = str15;
                                String str2112 = str18;
                                if (!list.isEmpty()) {
                                    realConnectionPool = new RealConnectionPool(this);
                                    arrayMap5 = new ArrayMap();
                                    it8 = list.iterator();
                                    while (it8.hasNext()) {
                                        zzftVar = (zzft) it8.next();
                                        zzftVarZza = realConnectionPool.zza(zzftVar, this.zza);
                                        if (zzftVarZza != null) {
                                            zzamVarZzi2 = zzktVar2.zzi();
                                            str12 = this.zza;
                                            strZzh = zzftVarZza.zzh();
                                            zzasVarZzn = zzamVarZzi2.zzn(str12, zzftVar.zzh());
                                            if (zzasVarZzn == null) {
                                                zzfr zzfrVar110 = (zzfr) zzamVarZzi2.mBuilder;
                                                zzfrVar110.zzay().zzk().zzc(zzeh.zzn(str12), "Event aggregate wasn't created during raw event logging. appId, event", zzfrVar110.zzj().zzd(strZzh));
                                                zzasVar = new zzas(str12, zzftVar.zzh(), 1L, 1L, 1L, zzftVar.zzd(), 0L, null, null, null, null);
                                            } else {
                                                zzasVar = new zzas(zzasVarZzn.zza, zzasVarZzn.zzb, zzasVarZzn.zzc + 1, zzasVarZzn.zzd + 1, zzasVarZzn.zze + 1, zzasVarZzn.zzf, zzasVarZzn.zzg, zzasVarZzn.zzh, zzasVarZzn.zzi, zzasVarZzn.zzj, zzasVarZzn.zzk);
                                            }
                                            zzasVar2 = zzasVar;
                                            zzktVar2.zzi().zzE(zzasVar2);
                                            strZzh2 = zzftVarZza.zzh();
                                            map8 = (Map) arrayMap5.get(strZzh2);
                                            if (map8 == null) {
                                                zzam zzamVarZzi110 = zzktVar2.zzi();
                                                zzfr zzfrVar111 = (zzfr) zzamVarZzi110.mBuilder;
                                                str13 = this.zza;
                                                zzamVarZzi110.zzW();
                                                zzamVarZzi110.zzg();
                                                com.google.android.gms.common.internal.zzah.checkNotEmpty(str13);
                                                com.google.android.gms.common.internal.zzah.checkNotEmpty(strZzh2);
                                                arrayMap6 = new ArrayMap();
                                                cursorQuery3 = zzamVarZzi110.zzh().query("event_filters", new String[]{str7, str8}, "app_id=? AND event_name=?", new String[]{str13, strZzh2}, null, null, null);
                                                if (cursorQuery3.moveToFirst()) {
                                                    zzasVar3 = zzasVar2;
                                                    while (true) {
                                                        zzek zzekVar12 = (zzek) ((com.google.android.gms.internal.measurement.zzej) zzen.zzl(zzek.zzc(), cursorQuery3.getBlob(1))).zzaC();
                                                        numValueOf5 = Integer.valueOf(cursorQuery3.getInt(0));
                                                        list6 = (List) arrayMap6.get(numValueOf5);
                                                        if (list6 == null) {
                                                            realConnectionPool2 = realConnectionPool;
                                                            arrayList4 = new ArrayList();
                                                            arrayMap6.put(numValueOf5, arrayList4);
                                                        } else {
                                                            realConnectionPool2 = realConnectionPool;
                                                            arrayList4 = list6;
                                                        }
                                                        arrayList4.add(zzekVar12);
                                                        if (!cursorQuery3.moveToNext()) {
                                                            break;
                                                            break;
                                                        }
                                                        realConnectionPool = realConnectionPool2;
                                                    }
                                                    cursorQuery3.close();
                                                    map13 = arrayMap6;
                                                } else {
                                                    zzasVar3 = zzasVar2;
                                                    realConnectionPool2 = realConnectionPool;
                                                    mapEmptyMap2 = Collections.emptyMap();
                                                    cursorQuery3.close();
                                                    map13 = mapEmptyMap2;
                                                }
                                                arrayMap5.put(strZzh2, map13);
                                                map9 = map13;
                                            } else {
                                                zzasVar3 = zzasVar2;
                                                realConnectionPool2 = realConnectionPool;
                                                map9 = map8;
                                            }
                                            it9 = map9.keySet().iterator();
                                            while (it9.hasNext()) {
                                                num4 = (Integer) it9.next();
                                                iIntValue = num4.intValue();
                                                if (this.zzb.contains(num4)) {
                                                    zzfrVar2.zzay().zzj().zzb(num4, "Skipping failed audience ID");
                                                } else {
                                                    it10 = ((List) map9.get(num4)).iterator();
                                                    zZzd2 = true;
                                                    map10 = map9;
                                                    while (true) {
                                                        if (!it10.hasNext()) {
                                                            it11 = it9;
                                                            zzasVar4 = zzasVar3;
                                                            map11 = map10;
                                                            num5 = num4;
                                                            break;
                                                        }
                                                        zzek zzekVar13 = (zzek) it10.next();
                                                        it11 = it9;
                                                        zzasVar4 = zzasVar3;
                                                        map12 = map10;
                                                        num5 = num4;
                                                        zzxVar2 = new zzx(this, this.zza, iIntValue, zzekVar13, 0);
                                                        Long l13 = this.zzd;
                                                        Long l14 = this.zze;
                                                        iZzb = zzekVar13.zzb();
                                                        zzuVar = (zzu) this.zzc.getOrDefault(num5, null);
                                                        if (zzuVar == null) {
                                                            z2 = false;
                                                        } else {
                                                            z2 = zzuVar.zze.get(iZzb);
                                                        }
                                                        zZzd2 = zzxVar2.zzd(l13, l14, zzftVarZza, zzasVar4.zzc, zzasVar4, z2);
                                                        if (!zZzd2) {
                                                            this.zzb.add(num5);
                                                            map11 = map12;
                                                            break;
                                                        }
                                                        zzd(num5).zzc(zzxVar2);
                                                        num4 = num5;
                                                        map10 = map12;
                                                        zzasVar3 = zzasVar4;
                                                        it9 = it11;
                                                    }
                                                    if (!zZzd2) {
                                                        this.zzb.add(num5);
                                                    }
                                                    map9 = map11;
                                                    zzasVar3 = zzasVar4;
                                                    it9 = it11;
                                                }
                                            }
                                            realConnectionPool = realConnectionPool2;
                                        }
                                    }
                                }
                                if (!list2.isEmpty()) {
                                    arrayMap4 = new ArrayMap();
                                    it5 = list2.iterator();
                                    while (it5.hasNext()) {
                                        com.google.android.gms.internal.measurement.zzgm zzgmVar5 = (com.google.android.gms.internal.measurement.zzgm) it5.next();
                                        strZzf = zzgmVar5.zzf();
                                        map7 = (Map) arrayMap4.get(strZzf);
                                        if (map7 == null) {
                                            zzam zzamVarZzi111 = zzktVar2.zzi();
                                            zzfr zzfrVar112 = (zzfr) zzamVarZzi111.mBuilder;
                                            str11 = this.zza;
                                            zzamVarZzi111.zzW();
                                            zzamVarZzi111.zzg();
                                            com.google.android.gms.common.internal.zzah.checkNotEmpty(str11);
                                            com.google.android.gms.common.internal.zzah.checkNotEmpty(strZzf);
                                            ArrayMap arrayMap18 = new ArrayMap();
                                            cursorQuery2 = zzamVarZzi111.zzh().query("property_filters", new String[]{str7, str8}, "app_id=? AND property_name=?", new String[]{str11, strZzf}, null, null, null);
                                            simpleArrayMap = arrayMap18;
                                            if (cursorQuery2.moveToFirst()) {
                                                while (true) {
                                                    zzet zzetVar6 = (zzet) ((com.google.android.gms.internal.measurement.zzes) zzen.zzl(zzet.zzc(), cursorQuery2.getBlob(1))).zzaC();
                                                    numValueOf4 = Integer.valueOf(cursorQuery2.getInt(0));
                                                    list5 = (List) simpleArrayMap.get(numValueOf4);
                                                    if (list5 == null) {
                                                        it6 = it5;
                                                        arrayList3 = new ArrayList();
                                                        simpleArrayMap.put(numValueOf4, arrayList3);
                                                    } else {
                                                        it6 = it5;
                                                        arrayList3 = list5;
                                                    }
                                                    arrayList3.add(zzetVar6);
                                                    if (!cursorQuery2.moveToNext()) {
                                                        break;
                                                        break;
                                                    }
                                                    it5 = it6;
                                                    simpleArrayMap = simpleArrayMap;
                                                }
                                                cursorQuery2.close();
                                                obj3 = simpleArrayMap;
                                            } else {
                                                it6 = it5;
                                                mapEmptyMap = Collections.emptyMap();
                                                cursorQuery2.close();
                                                obj3 = mapEmptyMap;
                                            }
                                            arrayMap4.put(strZzf, obj3);
                                            r1 = obj3;
                                        } else {
                                            it6 = it5;
                                            r1 = map7;
                                        }
                                        r2 = r1;
                                        while (r10.hasNext()) {
                                            int iIntValue10 = num6.intValue();
                                            if (this.zzb.contains(num6)) {
                                                zzfrVar2.zzay().zzj().zzb(num6, "Skipping failed audience ID");
                                                break;
                                                break;
                                            }
                                            it7 = ((List) r2.get(num6)).iterator();
                                            zZzd = true;
                                            r3 = r2;
                                            while (true) {
                                                if (it7.hasNext()) {
                                                    zzetVar = (zzet) it7.next();
                                                    if (Log.isLoggable(zzfrVar2.zzay().zzq(), 2)) {
                                                        zzef zzefVarZzj5 = zzfrVar2.zzay().zzj();
                                                        if (zzetVar.zzj()) {
                                                            numValueOf3 = Integer.valueOf(zzetVar.zza());
                                                        } else {
                                                            numValueOf3 = null;
                                                        }
                                                        zzefVarZzj5.zzd("Evaluating filter. audience, filter, property", num6, numValueOf3, zzfrVar2.zzj().zzf(zzetVar.zze()));
                                                        zzfrVar2.zzay().zzj().zzb(zzktVar2.zzu().zzp(zzetVar), "Filter definition");
                                                    }
                                                    if (zzetVar.zzj() || zzetVar.zza() > 256) {
                                                        r57 = r3;
                                                        num3 = num6;
                                                        zzef zzefVarZzk5 = zzfrVar2.zzay().zzk();
                                                        zzeg zzegVarZzn8 = zzeh.zzn(this.zza);
                                                        if (zzetVar.zzj()) {
                                                            numValueOf2 = Integer.valueOf(zzetVar.zza());
                                                        } else {
                                                            numValueOf2 = null;
                                                        }
                                                        zzefVarZzk5.zzc(zzegVarZzn8, "Invalid property filter ID. appId, id", String.valueOf(numValueOf2));
                                                        this.zzb.add(num3);
                                                        r2 = r57;
                                                    } else {
                                                        r58 = r3;
                                                        num3 = num6;
                                                        zzxVar = new zzx(this, this.zza, iIntValue10, zzetVar, 1);
                                                        Long l15 = this.zzd;
                                                        Long l16 = this.zze;
                                                        int iZza = zzetVar.zza();
                                                        zzu zzuVar6 = (zzu) this.zzc.getOrDefault(num3, null);
                                                        zZzd = zzxVar.zzd(l15, l16, zzgmVar5, zzuVar6 == null ? false : zzuVar6.zze.get(iZza));
                                                        if (zZzd) {
                                                            zzd(num3).zzc(zzxVar);
                                                            num6 = num3;
                                                            r3 = r58;
                                                        } else {
                                                            this.zzb.add(num3);
                                                            r57 = r58;
                                                        }
                                                    }
                                                } else {
                                                    r57 = r3;
                                                    num3 = num6;
                                                }
                                                if (!zZzd) {
                                                    this.zzb.add(num3);
                                                }
                                                r2 = r57;
                                            }
                                        }
                                        it5 = it6;
                                    }
                                }
                                arrayList2 = new ArrayList();
                                MapCollections$KeySet<Integer> mapCollections$KeySet5 = (MapCollections$KeySet) this.zzc.keySet();
                                mapCollections$KeySet5.removeAll(this.zzb);
                                while (r2.hasNext()) {
                                    int iIntValue11 = num7.intValue();
                                    zzu zzuVar7 = (zzu) this.zzc.get(num7);
                                    com.google.android.gms.common.internal.zzah.checkNotNull(zzuVar7);
                                    zzfp zzfpVarZza5 = zzuVar7.zza(iIntValue11);
                                    arrayList2.add(zzfpVarZza5);
                                    zzamVarZzi = zzktVar2.zzi();
                                    zzfrVar = (zzfr) zzamVarZzi.mBuilder;
                                    str10 = this.zza;
                                    com.google.android.gms.internal.measurement.zzgi zzgiVarZzd5 = zzfpVarZza5.zzd();
                                    zzamVarZzi.zzW();
                                    zzamVarZzi.zzg();
                                    com.google.android.gms.common.internal.zzah.checkNotEmpty(str10);
                                    com.google.android.gms.common.internal.zzah.checkNotNull(zzgiVarZzd5);
                                    byte[] bArrZzbu5 = zzgiVarZzd5.zzbu();
                                    contentValues = new ContentValues();
                                    contentValues.put("app_id", str10);
                                    contentValues.put(str7, num7);
                                    String str2113 = str9;
                                    contentValues.put(str2113, bArrZzbu5);
                                    if (zzamVarZzi.zzh().insertWithOnConflict("audience_filter_values", null, contentValues, 5) == -1) {
                                        zzfrVar.zzay().zzd().zzb(zzeh.zzn(str10), "Failed to insert filter results (got -1). appId");
                                    }
                                    str9 = str2113;
                                }
                                return arrayList2;
                            } catch (Throwable th7) {
                                th = th7;
                                r13 = 0;
                                if (r13 != 0) {
                                    r13.close();
                                }
                                throw th;
                            }
                        } catch (Throwable th8) {
                            th = th8;
                            r13 = "data";
                            if (r13 != 0) {
                                r13.close();
                            }
                            throw th;
                        }
                    }
                    str3 = "data";
                    r16 = zZzs;
                    r18 = zZzs2 ? 1 : 0;
                    obj = str2;
                    if (cursorQuery.moveToFirst()) {
                        Map mapEmptyMap12 = Collections.emptyMap();
                        cursorQuery.close();
                        map2 = mapEmptyMap12;
                        str4 = "audience_id";
                        str5 = "Database error querying filters. appId";
                        str18 = "Failed to merge filter. appId";
                    } else {
                        arrayMap7 = new ArrayMap();
                        while (true) {
                            i2 = cursorQuery.getInt(0);
                            arrayMap7.put(Integer.valueOf(i2), (com.google.android.gms.internal.measurement.zzgi) ((zzgh) zzen.zzl(com.google.android.gms.internal.measurement.zzgi.zzf(), cursorQuery.getBlob(1))).zzaC());
                            str4 = str20;
                            str5 = str19;
                            if (!cursorQuery.moveToNext()) {
                                break;
                                break;
                            }
                            str20 = str4;
                            str19 = str5;
                            str18 = str18;
                        }
                        cursorQuery.close();
                        map2 = arrayMap7;
                    }
                } catch (SQLiteException e24) {
                    e = e24;
                    str4 = "audience_id";
                    str5 = "Database error querying filters. appId";
                }
                cursorQuery = zzamVarZzi18.zzh().query("audience_filter_values", new String[]{"audience_id", str15}, "app_id=?", new String[]{str219}, null, null, null);
            } catch (SQLiteException e25) {
                e = e25;
                str4 = "audience_id";
                str5 = "Database error querying filters. appId";
                str18 = "Failed to merge filter. appId";
                cursorQuery = null;
            } catch (Throwable th9) {
                th = th9;
                r11 = 0;
                if (r11 != 0) {
                    r11.close();
                }
                throw th;
            }
            if (!map2.isEmpty()) {
                HashSet hashSet5 = new HashSet(map2.keySet());
                if (z) {
                    String str2114 = this.zza;
                    zzam zzamVarZzi112 = zzktVar3.zzi();
                    str6 = this.zza;
                    zzamVarZzi112.zzW();
                    zzamVarZzi112.zzg();
                    com.google.android.gms.common.internal.zzah.checkNotEmpty(str6);
                    arrayMap2 = new ArrayMap();
                    sQLiteDatabaseZzh = zzamVarZzi112.zzh();
                    cursorRawQuery = sQLiteDatabaseZzh.rawQuery("select audience_id, filter_id from event_filters where app_id = ? and session_scoped = 1 UNION select audience_id, filter_id from property_filters where app_id = ? and session_scoped = 1;", new String[]{str6, str6});
                    if (cursorRawQuery.moveToFirst()) {
                        do {
                            numValueOf = Integer.valueOf(cursorRawQuery.getInt(0));
                            arrayList = (List) arrayMap2.get(numValueOf);
                            if (arrayList == null) {
                                arrayList = new ArrayList();
                                arrayMap2.put(numValueOf, arrayList);
                            }
                            arrayList.add(Integer.valueOf(cursorRawQuery.getInt(1)));
                        } while (cursorRawQuery.moveToNext());
                    } else {
                        arrayMap2 = Collections.emptyMap();
                    }
                    cursorRawQuery.close();
                    r0 = arrayMap2;
                    com.google.android.gms.common.internal.zzah.checkNotEmpty(str2114);
                    arrayMap3 = new ArrayMap();
                    if (!map2.isEmpty()) {
                        it3 = map2.keySet().iterator();
                        while (it3.hasNext()) {
                            num2 = (Integer) it3.next();
                            num2.getClass();
                            zzgiVar2 = (com.google.android.gms.internal.measurement.zzgi) map2.get(num2);
                            list4 = (List) r0.get(num2);
                            if (list4 != null) {
                            }
                            zzagVar = zzagVar2;
                            it4 = it3;
                            arrayMap3.put(num2, zzgiVar2);
                            r0 = r0;
                            zzagVar2 = zzagVar;
                            it3 = it4;
                        }
                    }
                    map3 = arrayMap3;
                } else {
                    map3 = map2;
                }
                it = hashSet5.iterator();
                map6 = map3;
                map5 = map;
                map4 = map2;
                while (it.hasNext()) {
                    num = (Integer) it.next();
                    num.getClass();
                    zzgiVar = (com.google.android.gms.internal.measurement.zzgi) map6.get(num);
                    bitSet = new BitSet();
                    bitSet2 = new BitSet();
                    arrayMap = new ArrayMap();
                    if (zzgiVar != null) {
                        while (r2.hasNext()) {
                            if (zzfrVar5.zzh()) {
                                Integer numValueOf13 = Integer.valueOf(zzfrVar5.zza());
                                if (zzfrVar5.zzg()) {
                                    lValueOf = Long.valueOf(zzfrVar5.zzb());
                                } else {
                                    lValueOf = null;
                                }
                                arrayMap.put(numValueOf13, lValueOf);
                            }
                        }
                    }
                    ArrayMap arrayMap19 = new ArrayMap();
                    if (zzgiVar != null) {
                        it2 = zzgiVar.zzm().iterator();
                        while (it2.hasNext()) {
                            zzgkVar = (zzgk) it2.next();
                            if (!zzgkVar.zzi()) {
                            }
                        }
                    }
                    Map map19 = map6;
                    if (zzgiVar != null) {
                        i = 0;
                        while (i < zzgiVar.zzd() * 64) {
                            if (zzen.zzv(i, zzgiVar.zzn())) {
                                zzktVar = zzktVar3;
                                zzfrVar2.zzay().zzj().zzc(num, "Filter already evaluated. audience ID, filter ID", Integer.valueOf(i));
                                bitSet2.set(i);
                                if (zzen.zzv(i, zzgiVar.zzk())) {
                                    bitSet.set(i);
                                }
                                i++;
                                zzktVar3 = zzktVar;
                            } else {
                                zzktVar = zzktVar3;
                            }
                            arrayMap.remove(Integer.valueOf(i));
                            i++;
                            zzktVar3 = zzktVar;
                        }
                    }
                    zzkt zzktVar9 = zzktVar3;
                    com.google.android.gms.internal.measurement.zzgi zzgiVar8 = (com.google.android.gms.internal.measurement.zzgi) map4.get(num);
                    if (r19 == 0) {
                    }
                    this.zzc.put(num, new zzu(this, this.zza, zzgiVar8, bitSet, bitSet2, arrayMap, arrayMap19));
                    str4 = str4;
                    zzktVar3 = zzktVar9;
                    str15 = str15;
                    map6 = map19;
                    it = it;
                    str5 = str5;
                    map4 = map4;
                    str3 = str3;
                    map5 = map5;
                }
            }
            zzktVar2 = zzktVar3;
            str7 = str4;
            String str2115 = str5;
            str8 = str3;
            str9 = str15;
            String str2116 = str18;
            if (!list.isEmpty()) {
                realConnectionPool = new RealConnectionPool(this);
                arrayMap5 = new ArrayMap();
                it8 = list.iterator();
                while (it8.hasNext()) {
                    zzftVar = (zzft) it8.next();
                    zzftVarZza = realConnectionPool.zza(zzftVar, this.zza);
                    if (zzftVarZza != null) {
                        zzamVarZzi2 = zzktVar2.zzi();
                        str12 = this.zza;
                        strZzh = zzftVarZza.zzh();
                        zzasVarZzn = zzamVarZzi2.zzn(str12, zzftVar.zzh());
                        if (zzasVarZzn == null) {
                            zzfr zzfrVar113 = (zzfr) zzamVarZzi2.mBuilder;
                            zzfrVar113.zzay().zzk().zzc(zzeh.zzn(str12), "Event aggregate wasn't created during raw event logging. appId, event", zzfrVar113.zzj().zzd(strZzh));
                            zzasVar = new zzas(str12, zzftVar.zzh(), 1L, 1L, 1L, zzftVar.zzd(), 0L, null, null, null, null);
                        } else {
                            zzasVar = new zzas(zzasVarZzn.zza, zzasVarZzn.zzb, zzasVarZzn.zzc + 1, zzasVarZzn.zzd + 1, zzasVarZzn.zze + 1, zzasVarZzn.zzf, zzasVarZzn.zzg, zzasVarZzn.zzh, zzasVarZzn.zzi, zzasVarZzn.zzj, zzasVarZzn.zzk);
                        }
                        zzasVar2 = zzasVar;
                        zzktVar2.zzi().zzE(zzasVar2);
                        strZzh2 = zzftVarZza.zzh();
                        map8 = (Map) arrayMap5.get(strZzh2);
                        if (map8 == null) {
                            zzam zzamVarZzi113 = zzktVar2.zzi();
                            zzfr zzfrVar114 = (zzfr) zzamVarZzi113.mBuilder;
                            str13 = this.zza;
                            zzamVarZzi113.zzW();
                            zzamVarZzi113.zzg();
                            com.google.android.gms.common.internal.zzah.checkNotEmpty(str13);
                            com.google.android.gms.common.internal.zzah.checkNotEmpty(strZzh2);
                            arrayMap6 = new ArrayMap();
                            cursorQuery3 = zzamVarZzi113.zzh().query("event_filters", new String[]{str7, str8}, "app_id=? AND event_name=?", new String[]{str13, strZzh2}, null, null, null);
                            if (cursorQuery3.moveToFirst()) {
                                zzasVar3 = zzasVar2;
                                while (true) {
                                    zzek zzekVar14 = (zzek) ((com.google.android.gms.internal.measurement.zzej) zzen.zzl(zzek.zzc(), cursorQuery3.getBlob(1))).zzaC();
                                    numValueOf5 = Integer.valueOf(cursorQuery3.getInt(0));
                                    list6 = (List) arrayMap6.get(numValueOf5);
                                    if (list6 == null) {
                                        realConnectionPool2 = realConnectionPool;
                                        arrayList4 = new ArrayList();
                                        arrayMap6.put(numValueOf5, arrayList4);
                                    } else {
                                        realConnectionPool2 = realConnectionPool;
                                        arrayList4 = list6;
                                    }
                                    arrayList4.add(zzekVar14);
                                    if (!cursorQuery3.moveToNext()) {
                                        break;
                                        break;
                                    }
                                    realConnectionPool = realConnectionPool2;
                                }
                                cursorQuery3.close();
                                map13 = arrayMap6;
                            } else {
                                zzasVar3 = zzasVar2;
                                realConnectionPool2 = realConnectionPool;
                                mapEmptyMap2 = Collections.emptyMap();
                                cursorQuery3.close();
                                map13 = mapEmptyMap2;
                            }
                            arrayMap5.put(strZzh2, map13);
                            map9 = map13;
                        } else {
                            zzasVar3 = zzasVar2;
                            realConnectionPool2 = realConnectionPool;
                            map9 = map8;
                        }
                        it9 = map9.keySet().iterator();
                        while (it9.hasNext()) {
                            num4 = (Integer) it9.next();
                            iIntValue = num4.intValue();
                            if (this.zzb.contains(num4)) {
                                zzfrVar2.zzay().zzj().zzb(num4, "Skipping failed audience ID");
                            } else {
                                it10 = ((List) map9.get(num4)).iterator();
                                zZzd2 = true;
                                map10 = map9;
                                while (true) {
                                    if (!it10.hasNext()) {
                                        it11 = it9;
                                        zzasVar4 = zzasVar3;
                                        map11 = map10;
                                        num5 = num4;
                                        break;
                                    }
                                    zzek zzekVar15 = (zzek) it10.next();
                                    it11 = it9;
                                    zzasVar4 = zzasVar3;
                                    map12 = map10;
                                    num5 = num4;
                                    zzxVar2 = new zzx(this, this.zza, iIntValue, zzekVar15, 0);
                                    Long l17 = this.zzd;
                                    Long l18 = this.zze;
                                    iZzb = zzekVar15.zzb();
                                    zzuVar = (zzu) this.zzc.getOrDefault(num5, null);
                                    if (zzuVar == null) {
                                        z2 = false;
                                    } else {
                                        z2 = zzuVar.zze.get(iZzb);
                                    }
                                    zZzd2 = zzxVar2.zzd(l17, l18, zzftVarZza, zzasVar4.zzc, zzasVar4, z2);
                                    if (!zZzd2) {
                                        this.zzb.add(num5);
                                        map11 = map12;
                                        break;
                                    }
                                    zzd(num5).zzc(zzxVar2);
                                    num4 = num5;
                                    map10 = map12;
                                    zzasVar3 = zzasVar4;
                                    it9 = it11;
                                }
                                if (!zZzd2) {
                                    this.zzb.add(num5);
                                }
                                map9 = map11;
                                zzasVar3 = zzasVar4;
                                it9 = it11;
                            }
                        }
                        realConnectionPool = realConnectionPool2;
                    }
                }
            }
            if (!list2.isEmpty()) {
                arrayMap4 = new ArrayMap();
                it5 = list2.iterator();
                while (it5.hasNext()) {
                    com.google.android.gms.internal.measurement.zzgm zzgmVar6 = (com.google.android.gms.internal.measurement.zzgm) it5.next();
                    strZzf = zzgmVar6.zzf();
                    map7 = (Map) arrayMap4.get(strZzf);
                    if (map7 == null) {
                        zzam zzamVarZzi114 = zzktVar2.zzi();
                        zzfr zzfrVar115 = (zzfr) zzamVarZzi114.mBuilder;
                        str11 = this.zza;
                        zzamVarZzi114.zzW();
                        zzamVarZzi114.zzg();
                        com.google.android.gms.common.internal.zzah.checkNotEmpty(str11);
                        com.google.android.gms.common.internal.zzah.checkNotEmpty(strZzf);
                        ArrayMap arrayMap110 = new ArrayMap();
                        cursorQuery2 = zzamVarZzi114.zzh().query("property_filters", new String[]{str7, str8}, "app_id=? AND property_name=?", new String[]{str11, strZzf}, null, null, null);
                        simpleArrayMap = arrayMap110;
                        if (cursorQuery2.moveToFirst()) {
                            while (true) {
                                zzet zzetVar7 = (zzet) ((com.google.android.gms.internal.measurement.zzes) zzen.zzl(zzet.zzc(), cursorQuery2.getBlob(1))).zzaC();
                                numValueOf4 = Integer.valueOf(cursorQuery2.getInt(0));
                                list5 = (List) simpleArrayMap.get(numValueOf4);
                                if (list5 == null) {
                                    it6 = it5;
                                    arrayList3 = new ArrayList();
                                    simpleArrayMap.put(numValueOf4, arrayList3);
                                } else {
                                    it6 = it5;
                                    arrayList3 = list5;
                                }
                                arrayList3.add(zzetVar7);
                                if (!cursorQuery2.moveToNext()) {
                                    break;
                                    break;
                                }
                                it5 = it6;
                                simpleArrayMap = simpleArrayMap;
                            }
                            cursorQuery2.close();
                            obj3 = simpleArrayMap;
                        } else {
                            it6 = it5;
                            mapEmptyMap = Collections.emptyMap();
                            cursorQuery2.close();
                            obj3 = mapEmptyMap;
                        }
                        arrayMap4.put(strZzf, obj3);
                        r1 = obj3;
                    } else {
                        it6 = it5;
                        r1 = map7;
                    }
                    r2 = r1;
                    while (r10.hasNext()) {
                        int iIntValue12 = num6.intValue();
                        if (this.zzb.contains(num6)) {
                            zzfrVar2.zzay().zzj().zzb(num6, "Skipping failed audience ID");
                            break;
                            break;
                        }
                        it7 = ((List) r2.get(num6)).iterator();
                        zZzd = true;
                        r3 = r2;
                        while (true) {
                            if (it7.hasNext()) {
                                zzetVar = (zzet) it7.next();
                                if (Log.isLoggable(zzfrVar2.zzay().zzq(), 2)) {
                                    zzef zzefVarZzj6 = zzfrVar2.zzay().zzj();
                                    if (zzetVar.zzj()) {
                                        numValueOf3 = Integer.valueOf(zzetVar.zza());
                                    } else {
                                        numValueOf3 = null;
                                    }
                                    zzefVarZzj6.zzd("Evaluating filter. audience, filter, property", num6, numValueOf3, zzfrVar2.zzj().zzf(zzetVar.zze()));
                                    zzfrVar2.zzay().zzj().zzb(zzktVar2.zzu().zzp(zzetVar), "Filter definition");
                                }
                                if (zzetVar.zzj()) {
                                }
                                r57 = r3;
                                num3 = num6;
                                zzef zzefVarZzk6 = zzfrVar2.zzay().zzk();
                                zzeg zzegVarZzn9 = zzeh.zzn(this.zza);
                                if (zzetVar.zzj()) {
                                    numValueOf2 = Integer.valueOf(zzetVar.zza());
                                } else {
                                    numValueOf2 = null;
                                }
                                zzefVarZzk6.zzc(zzegVarZzn9, "Invalid property filter ID. appId, id", String.valueOf(numValueOf2));
                                this.zzb.add(num3);
                                r2 = r57;
                            } else {
                                r57 = r3;
                                num3 = num6;
                            }
                            if (!zZzd) {
                                this.zzb.add(num3);
                            }
                            r2 = r57;
                            zzd(num3).zzc(zzxVar);
                            num6 = num3;
                            r3 = r58;
                        }
                    }
                    it5 = it6;
                }
            }
            arrayList2 = new ArrayList();
            MapCollections$KeySet<Integer> mapCollections$KeySet6 = (MapCollections$KeySet) this.zzc.keySet();
            mapCollections$KeySet6.removeAll(this.zzb);
            while (r2.hasNext()) {
                int iIntValue13 = num7.intValue();
                zzu zzuVar8 = (zzu) this.zzc.get(num7);
                com.google.android.gms.common.internal.zzah.checkNotNull(zzuVar8);
                zzfp zzfpVarZza6 = zzuVar8.zza(iIntValue13);
                arrayList2.add(zzfpVarZza6);
                zzamVarZzi = zzktVar2.zzi();
                zzfrVar = (zzfr) zzamVarZzi.mBuilder;
                str10 = this.zza;
                com.google.android.gms.internal.measurement.zzgi zzgiVarZzd6 = zzfpVarZza6.zzd();
                zzamVarZzi.zzW();
                zzamVarZzi.zzg();
                com.google.android.gms.common.internal.zzah.checkNotEmpty(str10);
                com.google.android.gms.common.internal.zzah.checkNotNull(zzgiVarZzd6);
                byte[] bArrZzbu6 = zzgiVarZzd6.zzbu();
                contentValues = new ContentValues();
                contentValues.put("app_id", str10);
                contentValues.put(str7, num7);
                String str2117 = str9;
                contentValues.put(str2117, bArrZzbu6);
                if (zzamVarZzi.zzh().insertWithOnConflict("audience_filter_values", null, contentValues, 5) == -1) {
                    zzfrVar.zzay().zzd().zzb(zzeh.zzn(str10), "Failed to insert filter results (got -1). appId");
                }
                str9 = str2117;
            }
            return arrayList2;
        } catch (Throwable th10) {
            th = th10;
            r11 = obj2;
            if (r11 != 0) {
                r11.close();
            }
            throw th;
        }
        map = mapEmptyMap3;
        obj2 = obj;
        r17 = r16;
        r19 = r18;
        zzam zzamVarZzi115 = zzktVar3.zzi();
        zzfr zzfrVar116 = (zzfr) zzamVarZzi115.mBuilder;
        String str2118 = this.zza;
        zzamVarZzi115.zzW();
        zzamVarZzi115.zzg();
        com.google.android.gms.common.internal.zzah.checkNotEmpty(str2118);
    }

    @Override // com.google.android.gms.measurement.internal.zzkh
    public final void zzb() {
    }

    public final zzu zzd(Integer num) {
        if (this.zzc.containsKey(num)) {
            return (zzu) this.zzc.getOrDefault(num, null);
        }
        zzu zzuVar = new zzu(this, this.zza);
        this.zzc.put(num, zzuVar);
        return zzuVar;
    }
}
