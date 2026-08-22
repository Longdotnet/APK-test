package com.google.android.gms.location;

import android.view.InputDevice;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.common.internal.zzah;
import com.google.zxing.aztec.encoder.State;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzn implements Comparator {
    public final /* synthetic */ int $r8$classId;

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        switch (this.$r8$classId) {
            case 0:
                ActivityTransition activityTransition = (ActivityTransition) obj;
                ActivityTransition activityTransition2 = (ActivityTransition) obj2;
                zzah.checkNotNull(activityTransition);
                zzah.checkNotNull(activityTransition2);
                int i = activityTransition.zza;
                int i2 = activityTransition2.zza;
                if (i == i2) {
                    int i3 = activityTransition.zzb;
                    int i4 = activityTransition2.zzb;
                    if (i3 == i4) {
                        return 0;
                    }
                    if (i3 < i4) {
                        return -1;
                    }
                } else if (i < i2) {
                    return -1;
                }
                return 1;
            case 1:
                int axis = ((InputDevice.MotionRange) obj).getAxis();
                int axis2 = ((InputDevice.MotionRange) obj2).getAxis();
                if (axis == 22) {
                    axis = 23;
                } else if (axis == 23) {
                    axis = 22;
                }
                if (axis2 == 22) {
                    axis2 = 23;
                } else if (axis2 == 23) {
                    axis2 = 22;
                }
                return axis - axis2;
            case 2:
                List list = RequestConfiguration.zza;
                return list.indexOf((String) obj) - list.indexOf((String) obj2);
            case 3:
                return ((Comparable) obj).compareTo((Comparable) obj2);
            default:
                return ((State) obj).bitCount - ((State) obj2).bitCount;
        }
    }
}
