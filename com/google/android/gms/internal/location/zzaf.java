package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.Geofence;
import com.google.android.gms.location.GeofencingRequest;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzaf {
    @Deprecated
    public final PendingResult<Status> addGeofences(GoogleApiClient googleApiClient, List<Geofence> list, PendingIntent pendingIntent) {
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty()) {
            for (Geofence geofence : list) {
                if (geofence != null) {
                    com.google.android.gms.common.internal.zzah.checkArgument(geofence instanceof zzbe, "Geofence must be created using Geofence.Builder.");
                    arrayList.add((zzbe) geofence);
                }
            }
        }
        com.google.android.gms.common.internal.zzah.checkArgument(!arrayList.isEmpty(), "No geofence has been added to this request.");
        return googleApiClient.execute(new zzac(this, googleApiClient, new GeofencingRequest(arrayList, 5, "", null), pendingIntent));
    }

    public final PendingResult<Status> removeGeofences(GoogleApiClient googleApiClient, PendingIntent pendingIntent) {
        com.google.android.gms.common.internal.zzah.checkNotNull(pendingIntent, "PendingIntent can not be null.");
        return zza(googleApiClient, new com.google.android.gms.location.zzbq(null, pendingIntent, ""));
    }

    public final PendingResult<Status> zza(GoogleApiClient googleApiClient, com.google.android.gms.location.zzbq zzbqVar) {
        return googleApiClient.execute(new zzad(this, googleApiClient, zzbqVar));
    }

    public final PendingResult<Status> removeGeofences(GoogleApiClient googleApiClient, List<String> list) {
        com.google.android.gms.common.internal.zzah.checkNotNull(list, "geofence can't be null.");
        com.google.android.gms.common.internal.zzah.checkArgument(!list.isEmpty(), "Geofences must contains at least one id.");
        return zza(googleApiClient, new com.google.android.gms.location.zzbq(list, null, ""));
    }

    public final PendingResult<Status> addGeofences(GoogleApiClient googleApiClient, GeofencingRequest geofencingRequest, PendingIntent pendingIntent) {
        return googleApiClient.execute(new zzac(this, googleApiClient, geofencingRequest, pendingIntent));
    }
}
