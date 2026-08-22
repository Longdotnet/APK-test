package com.google.android.gms.ads.nonagon.signalgeneration;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.JsonReader;
import com.google.android.gms.internal.ads.zzbvq;
import com.google.android.gms.internal.ads.zzdyy;
import com.google.android.gms.internal.ads.zzfve;
import com.google.android.gms.internal.ads.zzgcu;
import com.google.android.gms.internal.ads.zzgdn;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.InputStreamReader;
import java.util.ArrayList;
import org.json.JSONException;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class zzai implements zzgcu {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object zza;

    public /* synthetic */ zzai(Object obj, int i) {
        this.$r8$classId = i;
        this.zza = obj;
    }

    @Override // com.google.android.gms.internal.ads.zzgcu
    public final ListenableFuture zza(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                final Uri uri = (Uri) obj;
                final zzau zzauVar = (zzau) this.zza;
                return zzgdn.zzm(zzauVar.zzS("google.afma.nativeAds.getPublisherCustomRenderedClickSignals"), new zzfve(zzauVar, uri) { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzaj
                    public final /* synthetic */ Uri zzb;

                    {
                        this.zzb = uri;
                    }

                    @Override // com.google.android.gms.internal.ads.zzfve
                    public final Object apply(Object obj2) {
                        String str = (String) obj2;
                        boolean zIsEmpty = TextUtils.isEmpty(str);
                        Uri uri2 = this.zzb;
                        return !zIsEmpty ? zzau.zzaa("nas", uri2, str) : uri2;
                    }
                }, zzauVar.zzk);
            case 1:
                final ArrayList arrayList = (ArrayList) obj;
                final zzau zzauVar2 = (zzau) this.zza;
                return zzgdn.zzm(zzauVar2.zzS("google.afma.nativeAds.getPublisherCustomRenderedImpressionSignals"), new zzfve() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzae
                    @Override // com.google.android.gms.internal.ads.zzfve
                    public final Object apply(Object obj2) {
                        String str = (String) obj2;
                        ArrayList arrayList2 = new ArrayList();
                        for (Uri uri2 : arrayList) {
                            zzau zzauVar3 = zzauVar2;
                            if (!zzau.zzX(uri2, zzauVar3.zzD, zzauVar3.zzE) || TextUtils.isEmpty(str)) {
                                arrayList2.add(uri2);
                            } else {
                                arrayList2.add(zzau.zzaa("nas", uri2, str));
                            }
                        }
                        return arrayList2;
                    }
                }, zzauVar2.zzk);
            default:
                zzdyy zzdyyVar = (zzdyy) obj;
                zzbk zzbkVar = new zzbk(new JsonReader(new InputStreamReader(zzdyyVar.zzb())), zzdyyVar.zza());
                zzbvq zzbvqVar = (zzbvq) this.zza;
                try {
                    zzbkVar.zzb = com.google.android.gms.ads.internal.client.zzbb.zzb.zzc.zzn(zzbvqVar.zza).toString();
                    break;
                } catch (JSONException unused) {
                    zzbkVar.zzb = "{}";
                }
                Bundle bundle = zzbvqVar.zzn;
                if (!bundle.isEmpty()) {
                    try {
                        zzbkVar.zzc = com.google.android.gms.ads.internal.client.zzbb.zzb.zzc.zzn(bundle).toString();
                        break;
                    } catch (JSONException unused2) {
                    }
                }
                return zzgdn.zzh(zzbkVar);
        }
    }
}
