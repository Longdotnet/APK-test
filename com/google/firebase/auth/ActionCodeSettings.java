package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes.dex */
public class ActionCodeSettings extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ActionCodeSettings> CREATOR = new zzc();
    private final String zza;
    private final String zzb;
    private final String zzc;
    private final String zzd;
    private final boolean zze;
    private final String zzf;
    private final boolean zzg;
    private String zzh;
    private int zzi;
    private String zzj;

    public static class Builder {
        private String zza;
        private String zzb;
        private String zzc;
        private boolean zzd;
        private String zze;
        private boolean zzf = false;
        private String zzg;

        private Builder() {
        }

        public ActionCodeSettings build() {
            if (this.zza != null) {
                return new ActionCodeSettings(this);
            }
            throw new IllegalArgumentException("Cannot build ActionCodeSettings with null URL. Call #setUrl(String) before calling build()");
        }

        public String getDynamicLinkDomain() {
            return this.zzg;
        }

        public boolean getHandleCodeInApp() {
            return this.zzf;
        }

        public String getIOSBundleId() {
            return this.zzb;
        }

        public String getUrl() {
            return this.zza;
        }

        public Builder setAndroidPackageName(String str, boolean z, String str2) {
            this.zzc = str;
            this.zzd = z;
            this.zze = str2;
            return this;
        }

        public Builder setDynamicLinkDomain(String str) {
            this.zzg = str;
            return this;
        }

        public Builder setHandleCodeInApp(boolean z) {
            this.zzf = z;
            return this;
        }

        public Builder setIOSBundleId(String str) {
            this.zzb = str;
            return this;
        }

        public Builder setUrl(String str) {
            this.zza = str;
            return this;
        }

        public /* synthetic */ Builder(zza zzaVar) {
        }
    }

    private ActionCodeSettings(Builder builder) {
        this.zza = builder.zza;
        this.zzb = builder.zzb;
        this.zzc = null;
        this.zzd = builder.zzc;
        this.zze = builder.zzd;
        this.zzf = builder.zze;
        this.zzg = builder.zzf;
        this.zzj = builder.zzg;
    }

    public static Builder newBuilder() {
        return new Builder(null);
    }

    public static ActionCodeSettings zzb() {
        return new ActionCodeSettings(new Builder(null));
    }

    public boolean canHandleCodeInApp() {
        return this.zzg;
    }

    public boolean getAndroidInstallApp() {
        return this.zze;
    }

    public String getAndroidMinimumVersion() {
        return this.zzf;
    }

    public String getAndroidPackageName() {
        return this.zzd;
    }

    public String getIOSBundle() {
        return this.zzb;
    }

    public String getUrl() {
        return this.zza;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.writeString(parcel, 1, getUrl(), false);
        CloseableKt.writeString(parcel, 2, getIOSBundle(), false);
        CloseableKt.writeString(parcel, 3, this.zzc, false);
        CloseableKt.writeString(parcel, 4, getAndroidPackageName(), false);
        boolean androidInstallApp = getAndroidInstallApp();
        CloseableKt.zzc(parcel, 5, 4);
        parcel.writeInt(androidInstallApp ? 1 : 0);
        CloseableKt.writeString(parcel, 6, getAndroidMinimumVersion(), false);
        boolean zCanHandleCodeInApp = canHandleCodeInApp();
        CloseableKt.zzc(parcel, 7, 4);
        parcel.writeInt(zCanHandleCodeInApp ? 1 : 0);
        CloseableKt.writeString(parcel, 8, this.zzh, false);
        int i2 = this.zzi;
        CloseableKt.zzc(parcel, 9, 4);
        parcel.writeInt(i2);
        CloseableKt.writeString(parcel, 10, this.zzj, false);
        CloseableKt.zzb(parcel, iZza);
    }

    public final int zza() {
        return this.zzi;
    }

    public final String zzc() {
        return this.zzj;
    }

    public final String zzd() {
        return this.zzc;
    }

    public final String zze() {
        return this.zzh;
    }

    public final void zzf(String str) {
        this.zzh = str;
    }

    public final void zzg(int i) {
        this.zzi = i;
    }

    public ActionCodeSettings(String str, String str2, String str3, String str4, boolean z, String str5, boolean z2, String str6, int i, String str7) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = str4;
        this.zze = z;
        this.zzf = str5;
        this.zzg = z2;
        this.zzh = str6;
        this.zzi = i;
        this.zzj = str7;
    }
}
