package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.games.event.AfJ.oKjScaD;
import java.util.HashMap;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
final class zzcdm implements Runnable {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ String zzc;
    final /* synthetic */ String zzd;
    final /* synthetic */ zzcdn zze;

    public zzcdm(zzcdn zzcdnVar, String str, String str2, String str3, String str4) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = str4;
        Objects.requireNonNull(zzcdnVar);
        this.zze = zzcdnVar;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:44:0x00aa  */
    @Override // java.lang.Runnable
    public final void run() {
        byte b;
        HashMap map = new HashMap();
        map.put("event", "precacheCanceled");
        map.put("src", this.zza);
        String str = this.zzb;
        if (!TextUtils.isEmpty(str)) {
            map.put("cachedSrc", str);
        }
        String str2 = this.zzc;
        switch (str2.hashCode()) {
            case -1947652542:
                if (!str2.equals("interrupted")) {
                    b = -1;
                } else {
                    b = 3;
                }
                break;
            case -1396664534:
                if (!str2.equals("badUrl")) {
                    b = -1;
                } else {
                    b = 8;
                }
                break;
            case -1347010958:
                if (!str2.equals("inProgress")) {
                    b = -1;
                } else {
                    b = 2;
                }
                break;
            case -918817863:
                if (!str2.equals("downloadTimeout")) {
                    b = -1;
                } else {
                    b = 9;
                }
                break;
            case -659376217:
                if (!str2.equals("contentLengthMissing")) {
                    b = -1;
                } else {
                    b = 0;
                }
                break;
            case -642208130:
                if (!str2.equals("playerFailed")) {
                    b = -1;
                } else {
                    b = 5;
                }
                break;
            case -354048396:
                if (!str2.equals("sizeExceeded")) {
                    b = -1;
                } else {
                    b = 11;
                }
                break;
            case -32082395:
                if (!str2.equals("externalAbort")) {
                    b = -1;
                } else {
                    b = 10;
                }
                break;
            case 3387234:
                if (!str2.equals("noop")) {
                    b = -1;
                } else {
                    b = 4;
                }
                break;
            case 96784904:
                if (!str2.equals(oKjScaD.buZM)) {
                    b = -1;
                } else {
                    b = 1;
                }
                break;
            case 580119100:
                if (!str2.equals("expireFailed")) {
                    b = -1;
                } else {
                    b = 6;
                }
                break;
            case 725497484:
                if (!str2.equals("noCacheDir")) {
                    b = -1;
                } else {
                    b = 7;
                }
                break;
            default:
                b = -1;
                break;
        }
        String str3 = "internal";
        switch (b) {
            case 6:
            case 7:
                str3 = "io";
                break;
            case 8:
            case 9:
                str3 = "network";
                break;
            case 10:
            case 11:
                str3 = "policy";
                break;
        }
        map.put("type", str3);
        map.put("reason", str2);
        String str4 = this.zzd;
        if (!TextUtils.isEmpty(str4)) {
            map.put("message", str4);
        }
        zzcdn.zze(this.zze, "onPrecacheEvent", map);
    }
}
