package com.google.android.gms.common;

import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzah;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.common.zzb;
import com.google.android.gms.internal.common.zzc;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzj extends zzb implements zzaa {
    public static final /* synthetic */ int $r8$clinit = 0;
    public final int zza;

    public zzj(byte[] bArr) {
        super("com.google.android.gms.common.internal.ICertData");
        zzah.checkArgument(bArr.length == 25);
        this.zza = Arrays.hashCode(bArr);
    }

    public static byte[] zze(String str) {
        try {
            return str.getBytes("ISO-8859-1");
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }

    public final boolean equals(Object obj) {
        IObjectWrapper iObjectWrapperZzd;
        if (obj != null && (obj instanceof zzaa)) {
            try {
                zzaa zzaaVar = (zzaa) obj;
                if (zzaaVar.zzc() == this.zza && (iObjectWrapperZzd = zzaaVar.zzd()) != null) {
                    return Arrays.equals(zzf(), (byte[]) ObjectWrapper.unwrap(iObjectWrapperZzd));
                }
                return false;
            } catch (RemoteException e) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e);
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.common.zzb
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i == 1) {
            IObjectWrapper iObjectWrapperZzd = zzd();
            parcel2.writeNoException();
            zzc.zze(parcel2, iObjectWrapperZzd);
        } else {
            if (i != 2) {
                return false;
            }
            parcel2.writeNoException();
            parcel2.writeInt(this.zza);
        }
        return true;
    }

    @Override // com.google.android.gms.common.internal.zzaa
    public final int zzc() {
        return this.zza;
    }

    @Override // com.google.android.gms.common.internal.zzaa
    public final IObjectWrapper zzd() {
        return new ObjectWrapper(zzf());
    }

    public abstract byte[] zzf();
}
