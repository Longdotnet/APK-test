package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.IntentSenderRequest;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzah;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;
import com.google.firebase.auth.zzz;
import java.util.Arrays;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class Status extends AbstractSafeParcelable implements Result, ReflectedParcelable {
    public final int zzb;
    public final String zzc;
    public final PendingIntent zzd;
    public final ConnectionResult zze;
    public static final Status RESULT_SUCCESS_CACHE = new Status(-1);
    public static final Status RESULT_SUCCESS = new Status(0);
    public static final Status RESULT_INTERRUPTED = new Status(14);
    public static final Status RESULT_INTERNAL_ERROR = new Status(8);
    public static final Status RESULT_TIMEOUT = new Status(15);
    public static final Status RESULT_CANCELED = new Status(16);
    public static final Status zza = new Status(17);
    public static final Status RESULT_DEAD_CLIENT = new Status(18);
    public static final Parcelable.Creator<Status> CREATOR = new zzb();

    public Status(int i, String str, PendingIntent pendingIntent, ConnectionResult connectionResult) {
        this.zzb = i;
        this.zzc = str;
        this.zzd = pendingIntent;
        this.zze = connectionResult;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Status)) {
            return false;
        }
        Status status = (Status) obj;
        return this.zzb == status.zzb && zzah.equal(this.zzc, status.zzc) && zzah.equal(this.zzd, status.zzd) && zzah.equal(this.zze, status.zze);
    }

    public ConnectionResult getConnectionResult() {
        return this.zze;
    }

    public PendingIntent getResolution() {
        return this.zzd;
    }

    @Override // com.google.android.gms.common.api.Result
    public Status getStatus() {
        return this;
    }

    @ResultIgnorabilityUnspecified
    public int getStatusCode() {
        return this.zzb;
    }

    public String getStatusMessage() {
        return this.zzc;
    }

    public boolean hasResolution() {
        return this.zzd != null;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.zzb), this.zzc, this.zzd, this.zze});
    }

    public boolean isCanceled() {
        return this.zzb == 16;
    }

    public boolean isInterrupted() {
        return this.zzb == 14;
    }

    public boolean isSuccess() {
        return this.zzb <= 0;
    }

    public void startResolutionForResult(Activity activity, int i) throws IntentSender.SendIntentException {
        if (hasResolution()) {
            PendingIntent pendingIntent = this.zzd;
            zzah.checkNotNull(pendingIntent);
            activity.startIntentSenderForResult(pendingIntent.getIntentSender(), i, null, 0, 0, 0);
        }
    }

    public String toString() {
        zzz zzzVar = new zzz(this);
        zzzVar.add(zza(), "statusCode");
        zzzVar.add(this.zzd, "resolution");
        return zzzVar.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iZza = CloseableKt.zza(parcel, 20293);
        int statusCode = getStatusCode();
        CloseableKt.zzc(parcel, 1, 4);
        parcel.writeInt(statusCode);
        CloseableKt.writeString(parcel, 2, getStatusMessage(), false);
        CloseableKt.writeParcelable(parcel, 3, this.zzd, i, false);
        CloseableKt.writeParcelable(parcel, 4, getConnectionResult(), i, false);
        CloseableKt.zzb(parcel, iZza);
    }

    public final String zza() {
        String str = this.zzc;
        return str != null ? str : CommonStatusCodes.getStatusCodeString(this.zzb);
    }

    @Deprecated
    public Status(ConnectionResult connectionResult, String str, int i) {
        this(i, str, connectionResult.zzc, connectionResult);
    }

    public void startResolutionForResult(ActivityResultLauncher activityResultLauncher) {
        if (hasResolution()) {
            PendingIntent pendingIntent = this.zzd;
            zzah.checkNotNull(pendingIntent);
            IntentSender intentSender = pendingIntent.getIntentSender();
            Intrinsics.checkNotNullParameter(intentSender, "intentSender");
            activityResultLauncher.launch(new IntentSenderRequest(intentSender, null, 0, 0));
        }
    }

    public Status(int i) {
        this(i, (String) null);
    }

    public Status(ConnectionResult connectionResult, String str) {
        this(connectionResult, str, 17);
    }

    public Status(int i, String str) {
        this(i, str, (PendingIntent) null);
    }

    public Status(int i, String str, PendingIntent pendingIntent) {
        this(i, str, pendingIntent, null);
    }
}
