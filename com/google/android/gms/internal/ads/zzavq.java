package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzavq implements zzavp {
    protected static volatile zzawx zza;
    protected MotionEvent zzb;
    protected double zzk;
    protected float zzl;
    protected float zzm;
    protected float zzn;
    protected float zzo;
    protected DisplayMetrics zzq;
    protected zzawp zzr;
    private double zzs;
    private double zzt;
    protected final LinkedList zzc = new LinkedList();
    protected long zzd = 0;
    protected long zze = 0;
    protected long zzf = 0;
    protected long zzg = 0;
    protected long zzh = 0;
    protected long zzi = 0;
    protected long zzj = 0;
    private boolean zzu = false;
    protected boolean zzp = false;

    public zzavq(Context context) {
        try {
            zzaus.zze();
            this.zzq = context.getResources().getDisplayMetrics();
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzdd)).booleanValue()) {
                this.zzr = new zzawp();
            }
        } catch (Throwable unused) {
        }
    }

    private final void zzm() {
        this.zzh = 0L;
        this.zzd = 0L;
        this.zze = 0L;
        this.zzf = 0L;
        this.zzg = 0L;
        this.zzi = 0L;
        this.zzj = 0L;
        LinkedList linkedList = this.zzc;
        if (linkedList.isEmpty()) {
            MotionEvent motionEvent = this.zzb;
            if (motionEvent != null) {
                motionEvent.recycle();
            }
        } else {
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                ((MotionEvent) it.next()).recycle();
            }
            linkedList.clear();
        }
        this.zzb = null;
    }

    /* JADX WARN: Code duplicated, block: B:47:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:48:0x00b5 A[Catch: Exception -> 0x00e9, TryCatch #0 {Exception -> 0x00e9, blocks: (B:45:0x00a8, B:48:0x00b5, B:57:0x00d9, B:60:0x00ed), top: B:74:0x00a8 }] */
    /* JADX WARN: Code duplicated, block: B:50:0x00c9 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:52:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:54:0x00d1 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:55:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:56:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:60:0x00ed A[Catch: Exception -> 0x00e9, TRY_LEAVE, TryCatch #0 {Exception -> 0x00e9, blocks: (B:45:0x00a8, B:48:0x00b5, B:57:0x00d9, B:60:0x00ed), top: B:74:0x00a8 }] */
    /* JADX WARN: Code duplicated, block: B:74:0x00a8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    private final String zzp(Context context, String str, int i, View view, Activity activity, byte[] bArr) {
        zzavo zzavoVarZzd;
        String str2;
        int i2;
        Exception exc;
        int i3;
        int i4;
        long jCurrentTimeMillis;
        String strZzb;
        int i5;
        int i6;
        zzast zzastVarZzc;
        int i7;
        int i8;
        int i9 = i;
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        boolean zBooleanValue = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzcP)).booleanValue();
        zzast zzastVarZzb = null;
        if (zBooleanValue) {
            zzavoVarZzd = zza != null ? zza.zzd() : null;
            str2 = "be";
        } else {
            zzavoVarZzd = null;
            str2 = null;
        }
        int i10 = 1;
        try {
            if (i9 == 3) {
                zzastVarZzb = zzb(context, view, activity);
                try {
                    this.zzu = true;
                    i8 = 1002;
                } catch (Exception e) {
                    exc = e;
                    i2 = 3;
                    i10 = 1;
                    if (!zBooleanValue) {
                    }
                    jCurrentTimeMillis = System.currentTimeMillis();
                    if (zzastVarZzb != null) {
                        try {
                            if (((zzatq) zzastVarZzb.zzbr()).zzaY() == 0) {
                                strZzb = Integer.toString(5);
                            } else {
                                zzatq zzatqVar = (zzatq) zzastVarZzb.zzbr();
                                int i11 = zzaus.zzc;
                                strZzb = zzaus.zzb(zzatqVar.zzaV(), str);
                                if (zBooleanValue) {
                                    if (i9 == i2) {
                                        i5 = 1006;
                                    } else if (i9 == i3) {
                                        i5 = 1010;
                                    } else {
                                        i5 = 1004;
                                    }
                                    zzavoVarZzd.zzc(i5, -1, System.currentTimeMillis() - jCurrentTimeMillis, str2, null);
                                }
                            }
                        } catch (Exception e2) {
                            strZzb = Integer.toString(7);
                            if (zBooleanValue && zzavoVarZzd != null) {
                                if (i9 == i2) {
                                    i6 = 1007;
                                } else {
                                    i6 = i9 == i3 ? 1011 : 1005;
                                }
                                zzavoVarZzd.zzc(i6, -1, System.currentTimeMillis() - jCurrentTimeMillis, str2, e2);
                            }
                        }
                    } else {
                        strZzb = Integer.toString(5);
                    }
                    return strZzb;
                }
            } else {
                if (i9 == 2) {
                    zzastVarZzc = zzi(context, view, activity);
                    i7 = 1008;
                } else {
                    zzastVarZzc = zzc(context, null);
                    i7 = 1000;
                }
                zzastVarZzb = zzastVarZzc;
                i8 = i7;
            }
            if (!zBooleanValue || zzavoVarZzd == null) {
                i2 = 3;
            } else {
                i2 = 3;
                try {
                    zzavoVarZzd.zzc(i8, -1, System.currentTimeMillis() - jCurrentTimeMillis2, str2, null);
                } catch (Exception e3) {
                    e = e3;
                    exc = e;
                    if (!zBooleanValue && zzavoVarZzd != null) {
                        if (i9 == i2) {
                            i4 = 1003;
                            i3 = 2;
                        } else {
                            i3 = 2;
                            if (i9 == 2) {
                                i4 = 1009;
                            } else {
                                i4 = 1001;
                                i9 = i10;
                            }
                        }
                        zzavoVarZzd.zzc(i4, -1, System.currentTimeMillis() - jCurrentTimeMillis2, str2, exc);
                    }
                    jCurrentTimeMillis = System.currentTimeMillis();
                    if (zzastVarZzb != null) {
                        strZzb = Integer.toString(5);
                    } else if (((zzatq) zzastVarZzb.zzbr()).zzaY() == 0) {
                        strZzb = Integer.toString(5);
                    } else {
                        zzatq zzatqVar2 = (zzatq) zzastVarZzb.zzbr();
                        int i12 = zzaus.zzc;
                        strZzb = zzaus.zzb(zzatqVar2.zzaV(), str);
                        if (zBooleanValue) {
                            if (i9 == i2) {
                                i5 = 1006;
                            } else if (i9 == i3) {
                                i5 = 1010;
                            } else {
                                i5 = 1004;
                            }
                            zzavoVarZzd.zzc(i5, -1, System.currentTimeMillis() - jCurrentTimeMillis, str2, null);
                        }
                    }
                    return strZzb;
                }
            }
        } catch (Exception e4) {
            e = e4;
            i2 = 3;
        }
        i3 = 2;
        jCurrentTimeMillis = System.currentTimeMillis();
        if (zzastVarZzb != null) {
            strZzb = Integer.toString(5);
        } else if (((zzatq) zzastVarZzb.zzbr()).zzaY() == 0) {
            strZzb = Integer.toString(5);
        } else {
            zzatq zzatqVar3 = (zzatq) zzastVarZzb.zzbr();
            int i13 = zzaus.zzc;
            strZzb = zzaus.zzb(zzatqVar3.zzaV(), str);
            if (zBooleanValue && zzavoVarZzd != null) {
                if (i9 == i2) {
                    i5 = 1006;
                } else if (i9 == i3) {
                    i5 = 1010;
                } else {
                    i5 = 1004;
                }
                zzavoVarZzd.zzc(i5, -1, System.currentTimeMillis() - jCurrentTimeMillis, str2, null);
            }
        }
        return strZzb;
    }

    public abstract long zza(StackTraceElement[] stackTraceElementArr);

    public abstract zzast zzb(Context context, View view, Activity activity);

    public abstract zzast zzc(Context context, zzasg zzasgVar);

    @Override // com.google.android.gms.internal.ads.zzavp
    public final String zzd(Context context, String str, View view) {
        return zzp(context, str, 3, view, null, null);
    }

    @Override // com.google.android.gms.internal.ads.zzavp
    public final String zze(Context context, String str, View view, Activity activity) {
        return zzp(context, str, 3, view, activity, null);
    }

    @Override // com.google.android.gms.internal.ads.zzavp
    public final String zzf(Context context) {
        if (zzaxa.zzc()) {
            throw new IllegalStateException("The caller must not be called from the UI thread.");
        }
        return zzp(context, null, 1, null, null, null);
    }

    @Override // com.google.android.gms.internal.ads.zzavp
    public final String zzg(Context context) {
        return "19";
    }

    @Override // com.google.android.gms.internal.ads.zzavp
    public final String zzh(Context context, View view, Activity activity) {
        return zzp(context, null, 2, view, activity, null);
    }

    public abstract zzast zzi(Context context, View view, Activity activity);

    public abstract zzawz zzj(MotionEvent motionEvent);

    @Override // com.google.android.gms.internal.ads.zzavp
    public final synchronized void zzk(MotionEvent motionEvent) {
        Long l;
        try {
            if (this.zzu) {
                zzm();
                this.zzu = false;
            }
            int action = motionEvent.getAction();
            if (action == 0) {
                this.zzk = 0.0d;
                this.zzs = motionEvent.getRawX();
                this.zzt = motionEvent.getRawY();
            } else if (action == 1 || action == 2) {
                double rawX = motionEvent.getRawX();
                double rawY = motionEvent.getRawY();
                double d = rawX - this.zzs;
                double d2 = rawY - this.zzt;
                this.zzk += Math.sqrt((d2 * d2) + (d * d));
                this.zzs = rawX;
                this.zzt = rawY;
            }
            int action2 = motionEvent.getAction();
            if (action2 != 0) {
                try {
                    if (action2 == 1) {
                        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
                        this.zzb = motionEventObtain;
                        LinkedList linkedList = this.zzc;
                        linkedList.add(motionEventObtain);
                        if (linkedList.size() > 6) {
                            ((MotionEvent) linkedList.remove()).recycle();
                        }
                        this.zzf++;
                        this.zzh = zza(new Throwable().getStackTrace());
                    } else if (action2 == 2) {
                        this.zze += (long) (motionEvent.getHistorySize() + 1);
                        zzawz zzawzVarZzj = zzj(motionEvent);
                        Long l2 = zzawzVarZzj.zzd;
                        if (l2 != null && zzawzVarZzj.zzg != null) {
                            this.zzi = l2.longValue() + zzawzVarZzj.zzg.longValue() + this.zzi;
                        }
                        if (this.zzq != null && (l = zzawzVarZzj.zze) != null && zzawzVarZzj.zzh != null) {
                            this.zzj = l.longValue() + zzawzVarZzj.zzh.longValue() + this.zzj;
                        }
                    } else if (action2 == 3) {
                        this.zzg++;
                    }
                } catch (zzawn unused) {
                }
            } else {
                this.zzl = motionEvent.getX();
                this.zzm = motionEvent.getY();
                this.zzn = motionEvent.getRawX();
                this.zzo = motionEvent.getRawY();
                this.zzd++;
            }
            this.zzp = true;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzavp
    public final synchronized void zzl(int i, int i2, int i3) {
        try {
            if (this.zzb != null) {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzcN)).booleanValue()) {
                    zzm();
                } else {
                    this.zzb.recycle();
                }
            }
            DisplayMetrics displayMetrics = this.zzq;
            if (displayMetrics != null) {
                float f = displayMetrics.density;
                this.zzb = MotionEvent.obtain(0L, i3, 1, i * f, i2 * f, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
            } else {
                this.zzb = null;
            }
            this.zzp = false;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzavp
    public final void zzn(StackTraceElement[] stackTraceElementArr) {
        zzawp zzawpVar;
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zza.zzd.zzb(zzbde.zzdd)).booleanValue() || (zzawpVar = this.zzr) == null) {
            return;
        }
        zzawpVar.zzb(Arrays.asList(stackTraceElementArr));
    }

    @Override // com.google.android.gms.internal.ads.zzavp
    public void zzo(View view) {
    }
}
