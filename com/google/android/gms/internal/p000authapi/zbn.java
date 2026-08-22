package com.google.android.gms.internal.p000authapi;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.text.TextUtils;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.credentials.HintRequest;
import com.google.android.gms.common.internal.zzah;

/* JADX INFO: loaded from: classes.dex */
public final class zbn {
    public static PendingIntent zba(Context context, Auth.AuthCredentialsOptions authCredentialsOptions, HintRequest hintRequest, String str) {
        zzah.checkNotNull(context, "context must not be null");
        zzah.checkNotNull(hintRequest, "request must not be null");
        if (TextUtils.isEmpty(str)) {
            str = zbbb.zba();
        } else {
            zzah.checkNotNull(str);
        }
        Intent intentPutExtra = new Intent("com.google.android.gms.auth.api.credentials.PICKER").putExtra("claimedCallingPackage", (String) null);
        intentPutExtra.putExtra("logSessionId", str);
        Parcel parcelObtain = Parcel.obtain();
        hintRequest.writeToParcel(parcelObtain, 0);
        byte[] bArrMarshall = parcelObtain.marshall();
        parcelObtain.recycle();
        intentPutExtra.putExtra("com.google.android.gms.credentials.HintRequest", bArrMarshall);
        return zbbc.zba(context, 2000, intentPutExtra, zbbc.zba | 134217728);
    }
}
