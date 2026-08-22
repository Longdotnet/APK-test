package com.google.firebase.auth.internal;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.gMU.QTaELkFI;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.measurement.internal.RVw.ZRqOdXiy;
import java.util.HashMap;
import java.util.Map;
import kotlin.io.TextStreamsKt;
import okhttp3.internal.concurrent.onZL.mnwSv;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbl {
    public static final Map zza;

    public static Status zza(Intent intent) {
        com.google.android.gms.common.internal.zzah.checkNotNull(intent);
        com.google.android.gms.common.internal.zzah.checkArgument(zzd(intent));
        Parcelable.Creator<Status> creator = Status.CREATOR;
        byte[] byteArrayExtra = intent.getByteArrayExtra("com.google.firebase.auth.internal.STATUS");
        return (Status) (byteArrayExtra == null ? null : TextStreamsKt.deserializeFromBytes(byteArrayExtra, creator));
    }

    public static Status zzb(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("code");
            String string2 = jSONObject.getString("message");
            if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
                Map map = zza;
                if (map.containsKey(string)) {
                    return zzai.zza(((String) map.get(string)) + ":" + string2);
                }
            }
            return zzai.zza("WEB_INTERNAL_ERROR:" + str);
        } catch (JSONException e) {
            return zzai.zza("WEB_INTERNAL_ERROR:" + str + "[ " + e.getLocalizedMessage() + " ]");
        }
    }

    public static boolean zzd(Intent intent) {
        com.google.android.gms.common.internal.zzah.checkNotNull(intent);
        return intent.hasExtra("com.google.firebase.auth.internal.STATUS");
    }

    static {
        HashMap map = new HashMap();
        zza = map;
        map.put("auth/invalid-provider-id", "INVALID_PROVIDER_ID");
        map.put("auth/invalid-cert-hash", mnwSv.CQj);
        map.put("auth/network-request-failed", "WEB_NETWORK_REQUEST_FAILED");
        map.put(QTaELkFI.ZfPAIcAMRWur, "WEB_STORAGE_UNSUPPORTED");
        map.put("auth/operation-not-allowed", "OPERATION_NOT_ALLOWED");
    }

    public static void zzc(Intent intent, Status status) {
        Parcel parcelObtain = Parcel.obtain();
        status.writeToParcel(parcelObtain, 0);
        byte[] bArrMarshall = parcelObtain.marshall();
        parcelObtain.recycle();
        intent.putExtra(ZRqOdXiy.SmKcNaDn, bArrMarshall);
    }
}
