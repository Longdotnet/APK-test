package com.android.billingclient.api;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Process;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import androidx.loader.content.AsyncTaskLoader$LoadTask;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import androidx.webkit.internal.JavaScriptReplyProxyImpl;
import com.daerisoft.thespikerm.com.suncyan.thespikecross.log.v1.TossType;
import com.google.android.gms.ads.internal.util.zzf;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.ads.nonagon.signalgeneration.TaggingLibraryJsInterface;
import com.google.android.gms.internal.ads.zzavr;
import com.google.android.gms.internal.ads.zzavt;
import com.google.android.gms.internal.ads.zzavu;
import com.google.android.gms.internal.measurement.zzt;
import com.google.android.gms.internal.play_billing.zzab;
import com.google.android.gms.internal.play_billing.zzb;
import com.google.android.gms.internal.play_billing.zzfz;
import com.google.android.gms.internal.play_billing.zzga;
import com.google.android.gms.internal.play_billing.zzgg;
import com.google.android.gms.internal.play_billing.zzgk;
import com.google.android.gms.measurement.internal.zzaw;
import com.google.android.gms.measurement.internal.zzen;
import com.google.android.gms.measurement.internal.zzfi;
import com.google.android.gms.measurement.internal.zzgj;
import com.google.android.gms.measurement.internal.zzkt;
import com.google.gson.yWTz.kBfGXgdfpo;
import java.io.ByteArrayOutputStream;
import java.lang.ref.WeakReference;
import java.util.Objects;
import java.util.concurrent.Callable;
import kotlin.jvm.internal.Intrinsics;
import org.chromium.support_lib_boundary.JsReplyProxyBoundaryInterface;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class zzaz implements Callable {
    public final /* synthetic */ int $r8$classId;
    public final Object zza;

    public zzaz(zzgj zzgjVar, zzaw zzawVar, String str) {
        this.$r8$classId = 8;
        this.zza = zzgjVar;
    }

    public /* synthetic */ zzaz(Object obj, int i) {
        this.$r8$classId = i;
        this.zza = obj;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x01e3  */
    /* JADX WARN: Code duplicated, block: B:103:0x01ea  */
    /* JADX WARN: Code duplicated, block: B:104:0x01ec  */
    /* JADX WARN: Code duplicated, block: B:107:0x01f3  */
    /* JADX WARN: Code duplicated, block: B:108:0x01f5  */
    /* JADX WARN: Code duplicated, block: B:111:0x01fc  */
    /* JADX WARN: Code duplicated, block: B:112:0x01fe  */
    /* JADX WARN: Code duplicated, block: B:115:0x0205  */
    /* JADX WARN: Code duplicated, block: B:116:0x0207  */
    /* JADX WARN: Code duplicated, block: B:119:0x020c  */
    /* JADX WARN: Code duplicated, block: B:120:0x020e  */
    /* JADX WARN: Code duplicated, block: B:123:0x0213  */
    /* JADX WARN: Code duplicated, block: B:124:0x0215  */
    /* JADX WARN: Code duplicated, block: B:127:0x021c  */
    /* JADX WARN: Code duplicated, block: B:128:0x021e  */
    /* JADX WARN: Code duplicated, block: B:131:0x0223  */
    /* JADX WARN: Code duplicated, block: B:132:0x0225  */
    /* JADX WARN: Code duplicated, block: B:135:0x022a A[Catch: Exception -> 0x013f, TryCatch #0 {Exception -> 0x013f, blocks: (B:48:0x010c, B:51:0x0127, B:56:0x0148, B:60:0x0152, B:64:0x0159, B:66:0x015f, B:71:0x016e, B:75:0x018b, B:76:0x01a8, B:73:0x017c, B:77:0x01ac, B:81:0x01b7, B:85:0x01c0, B:89:0x01c9, B:93:0x01d2, B:97:0x01db, B:101:0x01e4, B:105:0x01ed, B:109:0x01f6, B:113:0x01ff, B:117:0x0208, B:121:0x020f, B:125:0x0216, B:129:0x021f, B:133:0x0226, B:135:0x022a, B:137:0x0235, B:139:0x0243, B:141:0x0254, B:54:0x0143, B:49:0x0119), top: B:179:0x010c }] */
    /* JADX WARN: Code duplicated, block: B:137:0x0235 A[Catch: Exception -> 0x013f, TryCatch #0 {Exception -> 0x013f, blocks: (B:48:0x010c, B:51:0x0127, B:56:0x0148, B:60:0x0152, B:64:0x0159, B:66:0x015f, B:71:0x016e, B:75:0x018b, B:76:0x01a8, B:73:0x017c, B:77:0x01ac, B:81:0x01b7, B:85:0x01c0, B:89:0x01c9, B:93:0x01d2, B:97:0x01db, B:101:0x01e4, B:105:0x01ed, B:109:0x01f6, B:113:0x01ff, B:117:0x0208, B:121:0x020f, B:125:0x0216, B:129:0x021f, B:133:0x0226, B:135:0x022a, B:137:0x0235, B:139:0x0243, B:141:0x0254, B:54:0x0143, B:49:0x0119), top: B:179:0x010c }] */
    /* JADX WARN: Code duplicated, block: B:139:0x0243 A[Catch: Exception -> 0x013f, TryCatch #0 {Exception -> 0x013f, blocks: (B:48:0x010c, B:51:0x0127, B:56:0x0148, B:60:0x0152, B:64:0x0159, B:66:0x015f, B:71:0x016e, B:75:0x018b, B:76:0x01a8, B:73:0x017c, B:77:0x01ac, B:81:0x01b7, B:85:0x01c0, B:89:0x01c9, B:93:0x01d2, B:97:0x01db, B:101:0x01e4, B:105:0x01ed, B:109:0x01f6, B:113:0x01ff, B:117:0x0208, B:121:0x020f, B:125:0x0216, B:129:0x021f, B:133:0x0226, B:135:0x022a, B:137:0x0235, B:139:0x0243, B:141:0x0254, B:54:0x0143, B:49:0x0119), top: B:179:0x010c }] */
    /* JADX WARN: Code duplicated, block: B:141:0x0254 A[Catch: Exception -> 0x013f, TRY_LEAVE, TryCatch #0 {Exception -> 0x013f, blocks: (B:48:0x010c, B:51:0x0127, B:56:0x0148, B:60:0x0152, B:64:0x0159, B:66:0x015f, B:71:0x016e, B:75:0x018b, B:76:0x01a8, B:73:0x017c, B:77:0x01ac, B:81:0x01b7, B:85:0x01c0, B:89:0x01c9, B:93:0x01d2, B:97:0x01db, B:101:0x01e4, B:105:0x01ed, B:109:0x01f6, B:113:0x01ff, B:117:0x0208, B:121:0x020f, B:125:0x0216, B:129:0x021f, B:133:0x0226, B:135:0x022a, B:137:0x0235, B:139:0x0243, B:141:0x0254, B:54:0x0143, B:49:0x0119), top: B:179:0x010c }] */
    /* JADX WARN: Code duplicated, block: B:156:0x0285  */
    /* JADX WARN: Code duplicated, block: B:158:0x02a3  */
    /* JADX WARN: Code duplicated, block: B:160:0x02a9  */
    /* JADX WARN: Code duplicated, block: B:163:0x02ba  */
    /* JADX WARN: Code duplicated, block: B:165:0x02cc  */
    /* JADX WARN: Code duplicated, block: B:168:0x02e8 A[Catch: Exception -> 0x02ec, TryCatch #3 {Exception -> 0x02ec, blocks: (B:166:0x02d5, B:168:0x02e8, B:171:0x02ee), top: B:184:0x02d5 }] */
    /* JADX WARN: Code duplicated, block: B:79:0x01b4  */
    /* JADX WARN: Code duplicated, block: B:80:0x01b6  */
    /* JADX WARN: Code duplicated, block: B:83:0x01bd  */
    /* JADX WARN: Code duplicated, block: B:84:0x01bf  */
    /* JADX WARN: Code duplicated, block: B:87:0x01c6  */
    /* JADX WARN: Code duplicated, block: B:88:0x01c8  */
    /* JADX WARN: Code duplicated, block: B:91:0x01cf  */
    /* JADX WARN: Code duplicated, block: B:92:0x01d1  */
    /* JADX WARN: Code duplicated, block: B:95:0x01d8  */
    /* JADX WARN: Code duplicated, block: B:96:0x01da  */
    /* JADX WARN: Code duplicated, block: B:99:0x01e1  */
    @Override // java.util.concurrent.Callable
    public final Object call() {
        Bundle bundle;
        int i;
        int i2;
        String str;
        int iZzy;
        String strM;
        zzga zzgaVar;
        zzgg zzggVarZzy;
        int i3;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        boolean z9;
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        switch (this.$r8$classId) {
            case 0:
                zzbc zzbcVar = (zzbc) this.zza;
                synchronized (zzbcVar.zzb) {
                    break;
                }
                if (TextUtils.isEmpty(null)) {
                    bundle = null;
                } else {
                    bundle = new Bundle();
                    bundle.putString("accountName", null);
                }
                int i4 = 3;
                try {
                    String packageName = ((BillingClientImpl) zzbcVar.zza).zze.getPackageName();
                    iZzy = 3;
                    int i5 = 22;
                    while (true) {
                        if (i5 >= 3) {
                            if (bundle == null) {
                                try {
                                    iZzy = ((BillingClientImpl) zzbcVar.zza).zzg.zzy(i5, packageName, "subs");
                                } catch (Exception e) {
                                    e = e;
                                    i4 = iZzy;
                                    zzb.zzl("BillingClient", "Exception while checking if billing is supported; try to reconnect", e);
                                    if (e instanceof DeadObjectException) {
                                        i2 = 101;
                                    } else if (e instanceof RemoteException) {
                                        i2 = 100;
                                    } else {
                                        if (e instanceof SecurityException) {
                                            i2 = TossType.TOSS_OPEN_MASKED_SOLHWA_VALUE;
                                        } else {
                                            i = 42;
                                        }
                                        if (i == 42) {
                                            strM = CoroutineAdapterKt$$ExternalSyntheticLambda0.m(e.getClass().getSimpleName(), ": ", zzab.zzb(e.getMessage()));
                                            if (strM.length() > 70) {
                                                strM = strM.substring(0, 70);
                                            }
                                            str = strM;
                                        } else {
                                            str = null;
                                        }
                                        ((BillingClientImpl) zzbcVar.zza).zza = 0;
                                        ((BillingClientImpl) zzbcVar.zza).zzg = null;
                                        iZzy = i4;
                                    }
                                    i = i2;
                                    if (i == 42) {
                                        strM = CoroutineAdapterKt$$ExternalSyntheticLambda0.m(e.getClass().getSimpleName(), ": ", zzab.zzb(e.getMessage()));
                                        if (strM.length() > 70) {
                                            strM = strM.substring(0, 70);
                                        }
                                        str = strM;
                                    } else {
                                        str = null;
                                    }
                                    ((BillingClientImpl) zzbcVar.zza).zza = 0;
                                    ((BillingClientImpl) zzbcVar.zza).zzg = null;
                                    iZzy = i4;
                                }
                            } else {
                                iZzy = ((BillingClientImpl) zzbcVar.zza).zzg.zzc(i5, packageName, "subs", bundle);
                            }
                            if (iZzy == 0) {
                                zzb.zzj("BillingClient", kBfGXgdfpo.aPOhvdPPYjsYk + i5);
                            } else {
                                i5--;
                            }
                        } else {
                            i5 = 0;
                        }
                    }
                    BillingClientImpl billingClientImpl = (BillingClientImpl) zzbcVar.zza;
                    billingClientImpl.zzj = i5 >= 5;
                    billingClientImpl.zzi = i5 >= 3;
                    if (i5 < 3) {
                        zzb.zzj("BillingClient", "In-app billing API does not support subscription on this device.");
                        i = 9;
                    } else {
                        i = 1;
                    }
                    for (int i6 = 22; i6 >= 3; i6--) {
                        iZzy = bundle == null ? ((BillingClientImpl) zzbcVar.zza).zzg.zzy(i6, packageName, "inapp") : ((BillingClientImpl) zzbcVar.zza).zzg.zzc(i6, packageName, "inapp", bundle);
                        if (iZzy == 0) {
                            ((BillingClientImpl) zzbcVar.zza).zzk = i6;
                            zzb.zzj("BillingClient", "mHighestLevelSupportedForInApp: " + i6);
                            BillingClientImpl billingClientImpl2 = (BillingClientImpl) zzbcVar.zza;
                            i3 = billingClientImpl2.zzk;
                            if (i3 >= 22) {
                                z = true;
                            } else {
                                z = false;
                            }
                            billingClientImpl2.zzy = z;
                            if (i3 >= 21) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            billingClientImpl2.zzx = z2;
                            if (i3 >= 20) {
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            billingClientImpl2.zzw = z3;
                            if (i3 >= 19) {
                                z4 = true;
                            } else {
                                z4 = false;
                            }
                            billingClientImpl2.zzv = z4;
                            if (i3 >= 18) {
                                z5 = true;
                            } else {
                                z5 = false;
                            }
                            billingClientImpl2.zzu = z5;
                            if (i3 >= 17) {
                                z6 = true;
                            } else {
                                z6 = false;
                            }
                            billingClientImpl2.zzt = z6;
                            if (i3 >= 16) {
                                z7 = true;
                            } else {
                                z7 = false;
                            }
                            billingClientImpl2.zzs = z7;
                            if (i3 >= 15) {
                                z8 = true;
                            } else {
                                z8 = false;
                            }
                            billingClientImpl2.zzr = z8;
                            if (i3 >= 14) {
                                z9 = true;
                            } else {
                                z9 = false;
                            }
                            billingClientImpl2.zzq = z9;
                            if (i3 >= 12) {
                                z10 = true;
                            } else {
                                z10 = false;
                            }
                            billingClientImpl2.zzp = z10;
                            if (i3 >= 10) {
                                z11 = true;
                            } else {
                                z11 = false;
                            }
                            billingClientImpl2.zzo = z11;
                            if (i3 >= 9) {
                                z12 = true;
                            } else {
                                z12 = false;
                            }
                            billingClientImpl2.zzn = z12;
                            if (i3 >= 8) {
                                z13 = true;
                            } else {
                                z13 = false;
                            }
                            billingClientImpl2.zzm = z13;
                            if (i3 >= 6) {
                                z14 = true;
                            } else {
                                z14 = false;
                            }
                            billingClientImpl2.zzl = z14;
                            if (i3 < 3) {
                                zzb.zzk("BillingClient", "In-app billing API version 3 is not supported on this device.");
                                i = 36;
                            }
                            if (iZzy == 0) {
                                ((BillingClientImpl) zzbcVar.zza).zza = 2;
                                if (((BillingClientImpl) zzbcVar.zza).zzd != null) {
                                    ((BillingClientImpl) zzbcVar.zza).zzd.zzg(((BillingClientImpl) zzbcVar.zza).zzx);
                                }
                            } else {
                                ((BillingClientImpl) zzbcVar.zza).zza = 0;
                                ((BillingClientImpl) zzbcVar.zza).zzg = null;
                            }
                            str = null;
                            if (iZzy == 0) {
                                ((BillingClientImpl) zzbcVar.zza).zzaq(zzcb.zzc(6));
                                zzbcVar.zzd(zzce.zzl);
                                return null;
                            }
                            BillingClientImpl billingClientImpl3 = (BillingClientImpl) zzbcVar.zza;
                            BillingResult billingResult = zzce.zza;
                            int i7 = zzcb.$r8$clinit;
                            try {
                                zzggVarZzy = zzgk.zzy();
                                zzggVarZzy.zzn(billingResult.zza);
                                zzggVarZzy.zzm(billingResult.zzb);
                                zzggVarZzy.zzo(i);
                                if (str != null) {
                                    zzggVarZzy.zzl(str);
                                }
                                zzfz zzfzVarZzy = zzga.zzy();
                                zzfzVarZzy.zzl(zzggVarZzy);
                                zzfzVarZzy.zzn(6);
                                zzgaVar = (zzga) zzfzVarZzy.zzf();
                                break;
                            } catch (Exception e2) {
                                zzb.zzl("BillingLogger", "Unable to create logging payload", e2);
                                zzgaVar = null;
                            }
                            billingClientImpl3.zzap(zzgaVar);
                            zzbcVar.zzd(zzce.zza);
                            return null;
                        }
                    }
                    BillingClientImpl billingClientImpl4 = (BillingClientImpl) zzbcVar.zza;
                    i3 = billingClientImpl4.zzk;
                    if (i3 >= 22) {
                        z = true;
                    } else {
                        z = false;
                    }
                    billingClientImpl4.zzy = z;
                    if (i3 >= 21) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    billingClientImpl4.zzx = z2;
                    if (i3 >= 20) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    billingClientImpl4.zzw = z3;
                    if (i3 >= 19) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    billingClientImpl4.zzv = z4;
                    if (i3 >= 18) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    billingClientImpl4.zzu = z5;
                    if (i3 >= 17) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    billingClientImpl4.zzt = z6;
                    if (i3 >= 16) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    billingClientImpl4.zzs = z7;
                    if (i3 >= 15) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    billingClientImpl4.zzr = z8;
                    if (i3 >= 14) {
                        z9 = true;
                    } else {
                        z9 = false;
                    }
                    billingClientImpl4.zzq = z9;
                    if (i3 >= 12) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    billingClientImpl4.zzp = z10;
                    if (i3 >= 10) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    billingClientImpl4.zzo = z11;
                    if (i3 >= 9) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    billingClientImpl4.zzn = z12;
                    if (i3 >= 8) {
                        z13 = true;
                    } else {
                        z13 = false;
                    }
                    billingClientImpl4.zzm = z13;
                    if (i3 >= 6) {
                        z14 = true;
                    } else {
                        z14 = false;
                    }
                    billingClientImpl4.zzl = z14;
                    if (i3 < 3) {
                        zzb.zzk("BillingClient", "In-app billing API version 3 is not supported on this device.");
                        i = 36;
                    }
                    if (iZzy == 0) {
                        ((BillingClientImpl) zzbcVar.zza).zza = 2;
                        if (((BillingClientImpl) zzbcVar.zza).zzd != null) {
                            ((BillingClientImpl) zzbcVar.zza).zzd.zzg(((BillingClientImpl) zzbcVar.zza).zzx);
                        }
                    } else {
                        ((BillingClientImpl) zzbcVar.zza).zza = 0;
                        ((BillingClientImpl) zzbcVar.zza).zzg = null;
                    }
                    str = null;
                } catch (Exception e3) {
                    e = e3;
                }
                if (iZzy == 0) {
                    ((BillingClientImpl) zzbcVar.zza).zzaq(zzcb.zzc(6));
                    zzbcVar.zzd(zzce.zzl);
                    return null;
                }
                BillingClientImpl billingClientImpl5 = (BillingClientImpl) zzbcVar.zza;
                BillingResult billingResult2 = zzce.zza;
                int i8 = zzcb.$r8$clinit;
                zzggVarZzy = zzgk.zzy();
                zzggVarZzy.zzn(billingResult2.zza);
                zzggVarZzy.zzm(billingResult2.zzb);
                zzggVarZzy.zzo(i);
                if (str != null) {
                    zzggVarZzy.zzl(str);
                }
                zzfz zzfzVarZzy2 = zzga.zzy();
                zzfzVarZzy2.zzl(zzggVarZzy);
                zzfzVarZzy2.zzn(6);
                zzgaVar = (zzga) zzfzVarZzy2.zzf();
                billingClientImpl5.zzap(zzgaVar);
                zzbcVar.zzd(zzce.zza);
                return null;
            case 1:
                AsyncTaskLoader$LoadTask asyncTaskLoader$LoadTask = (AsyncTaskLoader$LoadTask) this.zza;
                asyncTaskLoader$LoadTask.mTaskInvoked.set(true);
                try {
                    Process.setThreadPriority(10);
                    asyncTaskLoader$LoadTask.doInBackground();
                    Binder.flushPendingCommands();
                    asyncTaskLoader$LoadTask.postResult(null);
                    return null;
                } catch (Throwable th) {
                    try {
                        asyncTaskLoader$LoadTask.mCancelled.set(true);
                        throw th;
                    } catch (Throwable th2) {
                        asyncTaskLoader$LoadTask.postResult(null);
                        throw th2;
                    }
                }
            case 2:
                JavaScriptReplyProxyImpl javaScriptReplyProxyImpl = new JavaScriptReplyProxyImpl();
                javaScriptReplyProxyImpl.mBoundaryInterface = (JsReplyProxyBoundaryInterface) this.zza;
                return javaScriptReplyProxyImpl;
            case 3:
                View view = (View) ((WeakReference) this.zza).get();
                if (view == null || view.getWidth() == 0 || view.getHeight() == 0) {
                    return "";
                }
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.RGB_565);
                view.draw(new Canvas(bitmapCreateBitmap));
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmapCreateBitmap.compress(Bitmap.CompressFormat.JPEG, 10, byteArrayOutputStream);
                String strEncodeToString = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2);
                Intrinsics.checkNotNullExpressionValue(strEncodeToString, "encodeToString(outputStream.toByteArray(), Base64.NO_WRAP)");
                return strEncodeToString;
            case 4:
                zzf zzfVar = zzs.zza;
                zzs zzsVar = zzv.zza.zzd;
                return zzs.zzQ((Uri) this.zza);
            case 5:
                zzu zzuVar = (zzu) this.zza;
                return new zzavu(zzavt.zzt(zzuVar.zzd, new zzavr(zzuVar.zza.afmaVersion, false)));
            case 6:
                return ((TaggingLibraryJsInterface) this.zza).getViewSignals();
            case 7:
                return new zzt(((zzfi) this.zza).zze);
            default:
                zzgj zzgjVar = (zzgj) this.zza;
                zzgjVar.zza.zzA$1();
                zzen zzenVar = zzgjVar.zza.zzj;
                zzkt.zzal(zzenVar);
                zzenVar.zzg();
                throw new IllegalStateException("Unexpected call on client side");
        }
    }

    public zzaz(zzu zzuVar) {
        this.$r8$classId = 5;
        Objects.requireNonNull(zzuVar);
        this.zza = zzuVar;
    }

    public zzaz(View view) {
        this.$r8$classId = 3;
        this.zza = new WeakReference(view);
    }
}
