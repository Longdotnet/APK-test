package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.content.Context;
import android.location.Location;
import android.os.Build;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes.dex */
public final class zzz {
    public final PendingResult<Status> flushLocations(GoogleApiClient googleApiClient) {
        return googleApiClient.execute(new zzq(this, googleApiClient));
    }

    public final Location getLastLocation(GoogleApiClient googleApiClient) {
        String str;
        Api api = LocationServices.API;
        com.google.android.gms.common.internal.zzah.checkArgument(googleApiClient != null, "GoogleApiClient parameter is required.");
        zzaz zzazVar = (zzaz) googleApiClient.getClient(LocationServices.zza);
        com.google.android.gms.common.internal.zzah.checkState(zzazVar != null, "GoogleApiClient is not configured to use the LocationServices.API Api. Pass thisinto GoogleApiClient.Builder#addApi() to use this feature.");
        Context context = googleApiClient.getContext();
        if (Build.VERSION.SDK_INT < 30 || context == null) {
            str = null;
        } else {
            try {
                str = (String) Context.class.getMethod("getAttributionTag", null).invoke(context, null);
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
                str = null;
            }
        }
        try {
            return zzazVar.zzz(str);
        } catch (Exception unused2) {
            return null;
        }
    }

    public final LocationAvailability getLocationAvailability(GoogleApiClient googleApiClient) {
        Api api = LocationServices.API;
        com.google.android.gms.common.internal.zzah.checkArgument(googleApiClient != null, "GoogleApiClient parameter is required.");
        zzaz zzazVar = (zzaz) googleApiClient.getClient(LocationServices.zza);
        com.google.android.gms.common.internal.zzah.checkState(zzazVar != null, "GoogleApiClient is not configured to use the LocationServices.API Api. Pass thisinto GoogleApiClient.Builder#addApi() to use this feature.");
        try {
            return zzazVar.zzA();
        } catch (Exception unused) {
            return null;
        }
    }

    public final PendingResult<Status> removeLocationUpdates(GoogleApiClient googleApiClient, PendingIntent pendingIntent) {
        return googleApiClient.execute(new zzw(this, googleApiClient, pendingIntent));
    }

    public final PendingResult<Status> requestLocationUpdates(GoogleApiClient googleApiClient, LocationRequest locationRequest, PendingIntent pendingIntent) {
        return googleApiClient.execute(new zzu(this, googleApiClient, locationRequest, pendingIntent));
    }

    public final PendingResult<Status> setMockLocation(GoogleApiClient googleApiClient, Location location) {
        return googleApiClient.execute(new zzp(this, googleApiClient, location));
    }

    public final PendingResult<Status> setMockMode(GoogleApiClient googleApiClient, boolean z) {
        return googleApiClient.execute(new zzo(this, googleApiClient, z));
    }

    public final PendingResult<Status> removeLocationUpdates(GoogleApiClient googleApiClient, LocationCallback locationCallback) {
        return googleApiClient.execute(new zzn(this, googleApiClient, locationCallback));
    }

    public final PendingResult<Status> requestLocationUpdates(GoogleApiClient googleApiClient, LocationRequest locationRequest, LocationCallback locationCallback, Looper looper) {
        return googleApiClient.execute(new zzt(this, googleApiClient, locationRequest, locationCallback, looper));
    }

    public final PendingResult<Status> removeLocationUpdates(GoogleApiClient googleApiClient, LocationListener locationListener) {
        return googleApiClient.execute(new zzv(this, googleApiClient, locationListener));
    }

    public final PendingResult<Status> requestLocationUpdates(GoogleApiClient googleApiClient, LocationRequest locationRequest, LocationListener locationListener) {
        com.google.android.gms.common.internal.zzah.checkNotNull(Looper.myLooper(), "Calling thread must be a prepared Looper thread.");
        return googleApiClient.execute(new zzr(this, googleApiClient, locationRequest, locationListener));
    }

    public final PendingResult<Status> requestLocationUpdates(GoogleApiClient googleApiClient, LocationRequest locationRequest, LocationListener locationListener, Looper looper) {
        return googleApiClient.execute(new zzs(this, googleApiClient, locationRequest, locationListener, looper));
    }
}
