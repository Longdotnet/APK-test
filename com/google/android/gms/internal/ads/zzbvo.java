package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.Hex;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes.dex */
public final class zzbvo extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbvo> CREATOR = new zzbvp();
    ParcelFileDescriptor zza;
    private Parcelable zzb = null;
    private boolean zzc = true;

    public zzbvo(ParcelFileDescriptor parcelFileDescriptor) {
        this.zza = parcelFileDescriptor;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        final ParcelFileDescriptor.AutoCloseOutputStream autoCloseOutputStream;
        if (this.zza == null) {
            Parcel parcelObtain = Parcel.obtain();
            try {
                this.zzb.writeToParcel(parcelObtain, 0);
                final byte[] bArrMarshall = parcelObtain.marshall();
                parcelObtain.recycle();
                ParcelFileDescriptor parcelFileDescriptor = null;
                try {
                    ParcelFileDescriptor[] parcelFileDescriptorArrCreatePipe = ParcelFileDescriptor.createPipe();
                    autoCloseOutputStream = new ParcelFileDescriptor.AutoCloseOutputStream(parcelFileDescriptorArrCreatePipe[1]);
                    try {
                        zzcaf.zza.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbvn
                            @Override // java.lang.Runnable
                            public final void run() throws Throwable {
                                Parcelable.Creator<zzbvo> creator = zzbvo.CREATOR;
                                OutputStream outputStream = autoCloseOutputStream;
                                byte[] bArr = bArrMarshall;
                                DataOutputStream dataOutputStream = null;
                                try {
                                    try {
                                        DataOutputStream dataOutputStream2 = new DataOutputStream(outputStream);
                                        try {
                                            dataOutputStream2.writeInt(bArr.length);
                                            dataOutputStream2.write(bArr);
                                            Hex.closeQuietly(dataOutputStream2);
                                        } catch (IOException e) {
                                            e = e;
                                            dataOutputStream = dataOutputStream2;
                                            int i2 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                                            com.google.android.gms.ads.internal.util.client.zzo.zzh("Error transporting the ad response", e);
                                            com.google.android.gms.ads.internal.zzv.zza.zzi.zzw(e, "LargeParcelTeleporter.pipeData.1");
                                            if (dataOutputStream == null) {
                                                Hex.closeQuietly(outputStream);
                                            } else {
                                                Hex.closeQuietly(dataOutputStream);
                                            }
                                        } catch (Throwable th) {
                                            th = th;
                                            dataOutputStream = dataOutputStream2;
                                            if (dataOutputStream == null) {
                                                Hex.closeQuietly(outputStream);
                                            } else {
                                                Hex.closeQuietly(dataOutputStream);
                                            }
                                            throw th;
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                    }
                                } catch (IOException e2) {
                                    e = e2;
                                }
                            }
                        });
                        parcelFileDescriptor = parcelFileDescriptorArrCreatePipe[0];
                    } catch (IOException e) {
                        e = e;
                        int i2 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                        com.google.android.gms.ads.internal.util.client.zzo.zzh("Error transporting the ad response", e);
                        com.google.android.gms.ads.internal.zzv.zza.zzi.zzw(e, "LargeParcelTeleporter.pipeData.2");
                        Hex.closeQuietly(autoCloseOutputStream);
                    }
                } catch (IOException e2) {
                    e = e2;
                    autoCloseOutputStream = null;
                }
                this.zza = parcelFileDescriptor;
            } catch (Throwable th) {
                parcelObtain.recycle();
                throw th;
            }
        }
        int iZza = CloseableKt.zza(parcel, 20293);
        CloseableKt.writeParcelable(parcel, 2, this.zza, i, false);
        CloseableKt.zzb(parcel, iZza);
    }

    public final SafeParcelable zza(Parcelable.Creator creator) {
        if (this.zzc) {
            if (this.zza == null) {
                int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                com.google.android.gms.ads.internal.util.client.zzo.zzg("File descriptor is empty, returning null.");
                return null;
            }
            DataInputStream dataInputStream = new DataInputStream(new ParcelFileDescriptor.AutoCloseInputStream(this.zza));
            try {
                try {
                    int i2 = dataInputStream.readInt();
                    byte[] bArr = new byte[i2];
                    dataInputStream.readFully(bArr, 0, i2);
                    Hex.closeQuietly(dataInputStream);
                    Parcel parcelObtain = Parcel.obtain();
                    try {
                        parcelObtain.unmarshall(bArr, 0, i2);
                        parcelObtain.setDataPosition(0);
                        this.zzb = (Parcelable) creator.createFromParcel(parcelObtain);
                        parcelObtain.recycle();
                        this.zzc = false;
                    } catch (Throwable th) {
                        parcelObtain.recycle();
                        throw th;
                    }
                } catch (Throwable th2) {
                    Hex.closeQuietly(dataInputStream);
                    throw th2;
                }
            } catch (IOException e) {
                int i3 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                com.google.android.gms.ads.internal.util.client.zzo.zzh("Could not read from parcel file descriptor", e);
                Hex.closeQuietly(dataInputStream);
                return null;
            }
        }
        return (SafeParcelable) this.zzb;
    }
}
