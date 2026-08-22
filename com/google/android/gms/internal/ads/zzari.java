package com.google.android.gms.internal.ads;

import androidx.emoji2.text.flatbuffer.bs.bUqMCsuPSX;
import com.google.android.gms.ads.internal.offline.buffering.Dk.eoBKjVuj;
import java.io.UnsupportedEncodingException;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class zzari extends zzaqd {
    private final Object zza;
    private final zzaqi zzb;

    public zzari(int i, String str, zzaqi zzaqiVar, zzaqh zzaqhVar) {
        super(i, str, zzaqhVar);
        this.zza = new Object();
        this.zzb = zzaqiVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaqd
    /* JADX INFO: renamed from: zzz, reason: merged with bridge method [inline-methods] */
    public void zzo(String str) {
        zzaqi zzaqiVar;
        synchronized (this.zza) {
            zzaqiVar = this.zzb;
        }
        zzaqiVar.zza(str);
    }

    @Override // com.google.android.gms.internal.ads.zzaqd
    public final zzaqj zzh(zzapz zzapzVar) {
        String str;
        String str2;
        try {
            byte[] bArr = zzapzVar.zzb;
            Map map = zzapzVar.zzc;
            String str3 = "ISO-8859-1";
            if (map != null && (str2 = (String) map.get(bUqMCsuPSX.UNxtRxGfAk)) != null) {
                String[] strArrSplit = str2.split(eoBKjVuj.ORdREfGSchMXOmg, 0);
                for (int i = 1; i < strArrSplit.length; i++) {
                    String[] strArrSplit2 = strArrSplit[i].trim().split("=", 0);
                    if (strArrSplit2.length == 2 && strArrSplit2[0].equals("charset")) {
                        str3 = strArrSplit2[1];
                        break;
                    }
                }
            }
            str = new String(bArr, str3);
        } catch (UnsupportedEncodingException unused) {
            str = new String(zzapzVar.zzb);
        }
        return zzaqj.zzb(str, zzara.zzb(zzapzVar));
    }
}
