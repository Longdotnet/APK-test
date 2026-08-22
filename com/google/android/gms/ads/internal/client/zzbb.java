package com.google.android.gms.ads.internal.client;

import androidx.appcompat.widget.TooltipPopup;
import androidx.sqlite.db.framework.VERT.YcVWhnLsj;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzf;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import com.google.android.gms.internal.ads.zzbil;
import com.google.android.gms.internal.ads.zzbim;
import com.google.android.gms.internal.ads.zzbtn;
import com.google.android.gms.internal.ads.zzbxh;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
import java.util.UUID;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbb {
    public static final zzbb zzb = new zzbb();
    public final zzf zzc;
    public final TooltipPopup zzd;
    public final String zze;
    public final VersionInfoParcel zzf;
    public final Random zzg;

    public zzbb() {
        zzf zzfVar = new zzf();
        zzfVar.zzh = -1.0f;
        zzk zzkVar = new zzk("com.google.android.gms.ads.AdManagerCreatorImpl");
        zzi zziVar = new zzi(YcVWhnLsj.VETDMvUULy, 0);
        zzi zziVar2 = new zzi("com.google.android.gms.ads.MobileAdsSettingManagerCreatorImpl", 1);
        zzbil zzbilVar = new zzbil();
        new zzbxh();
        zzbtn zzbtnVar = new zzbtn();
        new zzbim();
        zzi zziVar3 = new zzi("com.google.android.gms.ads.AdPreloaderRemoteCreatorImpl", 2);
        TooltipPopup tooltipPopup = new TooltipPopup();
        tooltipPopup.mContext = zzkVar;
        tooltipPopup.mContentView = zziVar;
        tooltipPopup.mMessageView = zziVar2;
        tooltipPopup.mLayoutParams = zzbilVar;
        tooltipPopup.mTmpDisplayFrame = zzbtnVar;
        tooltipPopup.mTmpAppPos = zziVar3;
        UUID uuidRandomUUID = UUID.randomUUID();
        byte[] byteArray = BigInteger.valueOf(uuidRandomUUID.getLeastSignificantBits()).toByteArray();
        byte[] byteArray2 = BigInteger.valueOf(uuidRandomUUID.getMostSignificantBits()).toByteArray();
        String string = new BigInteger(1, byteArray).toString();
        for (int i = 0; i < 2; i++) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.update(byteArray);
                messageDigest.update(byteArray2);
                byte[] bArr = new byte[8];
                System.arraycopy(messageDigest.digest(), 0, bArr, 0, 8);
                string = new BigInteger(1, bArr).toString();
            } catch (NoSuchAlgorithmException unused) {
            }
        }
        VersionInfoParcel versionInfoParcel = new VersionInfoParcel(0, ModuleDescriptor.MODULE_VERSION, true, false);
        Random random = new Random();
        this.zzc = zzfVar;
        this.zzd = tooltipPopup;
        this.zze = string;
        this.zzf = versionInfoParcel;
        this.zzg = random;
    }
}
