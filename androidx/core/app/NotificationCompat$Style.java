package androidx.core.app;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.appcompat.widget.AppCompatTextHelper;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.internal.util.client.zzo;
import com.google.android.gms.common.internal.zzah;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.measurement.internal.zzdg;
import com.google.android.gms.measurement.internal.zzeh;
import com.google.android.gms.measurement.internal.zzfo;
import com.google.android.gms.measurement.internal.zzfr;
import com.google.android.gms.measurement.internal.zzgm;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import okhttp3.Dispatcher;

/* JADX INFO: loaded from: classes.dex */
public abstract class NotificationCompat$Style implements zzgm {
    public Object mBuilder;

    public NotificationCompat$Style() {
        AppCompatTextHelper appCompatTextHelper = new AppCompatTextHelper();
        this.mBuilder = appCompatTextHelper;
        ((HashSet) appCompatTextHelper.mDrawableRightTint).add("B3EEABB8EE11C2BE770B684D95219ECB");
    }

    public void addCustomTargeting(String str, String str2) {
        if (!TextUtils.isEmpty(str2) && str2.contains(",")) {
            zzo.zzj("Value " + str2 + " contains invalid character ',' (comma). The server will parse it as a list of comma-separated values.");
        }
        ((Bundle) ((AppCompatTextHelper) this.mBuilder).mDrawableBottomTint).putString(str, str2);
    }

    public NotificationCompat$Style addNetworkExtrasBundle(Bundle bundle) {
        AppCompatTextHelper appCompatTextHelper = (AppCompatTextHelper) this.mBuilder;
        appCompatTextHelper.getClass();
        ((Bundle) appCompatTextHelper.mDrawableLeftTint).putBundle(AdMobAdapter.class.getName(), bundle);
        if (AdMobAdapter.class.equals(AdMobAdapter.class) && bundle.getBoolean("_emulatorLiveAds")) {
            ((HashSet) appCompatTextHelper.mDrawableRightTint).remove("B3EEABB8EE11C2BE770B684D95219ECB");
        }
        return self();
    }

    public abstract void apply(Dispatcher dispatcher);

    public abstract String getClassName();

    public abstract NotificationCompat$Style self();

    public void setContentUrl(String str) {
        zzah.checkNotNull(str, "Content URL must be non-null.");
        zzah.checkNotEmpty(str, "Content URL must be non-empty.");
        int length = str.length();
        Object[] objArr = {512, Integer.valueOf(str.length())};
        if (!(length <= 512)) {
            throw new IllegalArgumentException(String.format("Content URL must not exceed %d in length.  Provided length was %d.", objArr));
        }
        ((AppCompatTextHelper) this.mBuilder).mDrawableEndTint = str;
    }

    public void setNeighboringContentUrls(List list) {
        if (list == null) {
            zzo.zzj("neighboring content URLs list should not be null");
            return;
        }
        ArrayList arrayList = (ArrayList) ((AppCompatTextHelper) this.mBuilder).mDrawableTint;
        arrayList.clear();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (TextUtils.isEmpty(str)) {
                zzo.zzj("neighboring content URL should not be null or empty");
            } else {
                arrayList.add(str);
            }
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzgm
    public Context zzau() {
        throw null;
    }

    @Override // com.google.android.gms.measurement.internal.zzgm
    public Clock zzav() {
        throw null;
    }

    @Override // com.google.android.gms.measurement.internal.zzgm
    public zzdg zzaw() {
        throw null;
    }

    @Override // com.google.android.gms.measurement.internal.zzgm
    public zzeh zzay() {
        throw null;
    }

    @Override // com.google.android.gms.measurement.internal.zzgm
    public zzfo zzaz() {
        throw null;
    }

    public void zzg() {
        zzfo zzfoVar = ((zzfr) this.mBuilder).zzn;
        zzfr.zzR(zzfoVar);
        zzfoVar.zzg();
    }

    public NotificationCompat$Style(zzfr zzfrVar) {
        zzah.checkNotNull(zzfrVar);
        this.mBuilder = zzfrVar;
    }
}
