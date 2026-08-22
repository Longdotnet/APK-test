package com.google.android.gms.measurement.internal;

import android.os.Looper;
import com.google.android.gms.internal.measurement.zznn;
import com.google.android.gms.internal.measurement.zzoi;
import com.google.android.gms.internal.measurement.zzpa;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class zzdg implements zzdq {
    public static final /* synthetic */ zzdg zza = new zzdg(0);
    public static final /* synthetic */ zzdg zza$1 = new zzdg(1);
    public static final /* synthetic */ zzdg zza$2 = new zzdg(2);
    public static final /* synthetic */ zzdg zza$3 = new zzdg(3);
    public static final /* synthetic */ zzdg zza$4 = new zzdg(4);
    public static final /* synthetic */ zzdg zza$5 = new zzdg(5);
    public static final /* synthetic */ zzdg zza$6 = new zzdg(6);
    public static final /* synthetic */ zzdg zza$7 = new zzdg(7);
    public static final /* synthetic */ zzdg zza$8 = new zzdg(8);
    public static final /* synthetic */ zzdg zza$9 = new zzdg(9);
    public final /* synthetic */ int $r8$classId;

    public /* synthetic */ zzdg(int i) {
        this.$r8$classId = i;
    }

    @Override // com.google.android.gms.measurement.internal.zzdq
    /* JADX INFO: renamed from: zza, reason: collision with other method in class */
    public Object mo95zza() {
        switch (this.$r8$classId) {
            case 0:
                List list = zzdu.zzav;
                return Boolean.valueOf(zzoi.zzd());
            case 1:
                List list2 = zzdu.zzav;
                return Boolean.valueOf(zzpa.zzd());
            case 2:
                List list3 = zzdu.zzav;
                return Integer.valueOf((int) zznn.zzE());
            case 3:
                List list4 = zzdu.zzav;
                return Integer.valueOf((int) zznn.zzv());
            case 4:
                List list5 = zzdu.zzav;
                return Integer.valueOf((int) zznn.zzz());
            case 5:
                List list6 = zzdu.zzav;
                return Integer.valueOf((int) zznn.zzA());
            case 6:
                List list7 = zzdu.zzav;
                return Integer.valueOf((int) zznn.zzg());
            case 7:
                List list8 = zzdu.zzav;
                return zznn.zzL();
            case 8:
                List list9 = zzdu.zzav;
                return Long.valueOf(zznn.zzs());
            default:
                List list10 = zzdu.zzav;
                return Long.valueOf(zznn.zzH());
        }
    }

    public static final boolean zza() {
        return Looper.myLooper() == Looper.getMainLooper();
    }
}
