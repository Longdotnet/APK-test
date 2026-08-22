package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class zzh implements zzq, OnSuccessListener, OnFailureListener, OnCanceledListener {
    public final /* synthetic */ int $r8$classId;
    public final Executor zza;
    public final Object zzb;
    public Object zzc;

    public zzh(zzt zztVar, OnCanceledListener onCanceledListener) {
        this.$r8$classId = 0;
        this.zzb = new Object();
        this.zza = zztVar;
        this.zzc = onCanceledListener;
    }

    private final void zzc$com$google$android$gms$tasks$zzj() {
        synchronized (this.zzb) {
            this.zzc = null;
        }
    }

    private final void zzc$com$google$android$gms$tasks$zzl() {
        synchronized (this.zzb) {
            this.zzc = null;
        }
    }

    private final void zzc$com$google$android$gms$tasks$zzn() {
        synchronized (this.zzb) {
            this.zzc = null;
        }
    }

    private final void zzd$com$google$android$gms$tasks$zzj(Task task) {
        synchronized (this.zzb) {
            try {
                if (((OnCompleteListener) this.zzc) == null) {
                    return;
                }
                this.zza.execute(new zzc(this, task, 10));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final void zzd$com$google$android$gms$tasks$zzl(Task task) {
        if (task.isSuccessful() || ((zzw) task).zzd) {
            return;
        }
        synchronized (this.zzb) {
            try {
                if (((OnFailureListener) this.zzc) == null) {
                    return;
                }
                this.zza.execute(new zzc(this, task, 11));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final void zzd$com$google$android$gms$tasks$zzn(Task task) {
        if (task.isSuccessful()) {
            synchronized (this.zzb) {
                try {
                    if (((OnSuccessListener) this.zzc) == null) {
                        return;
                    }
                    this.zza.execute(new zzc(this, task, 12));
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    @Override // com.google.android.gms.tasks.OnCanceledListener
    public void onCanceled() {
        ((zzw) this.zzc).zzc();
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public void onFailure(Exception exc) {
        ((zzw) this.zzc).zza(exc);
    }

    @Override // com.google.android.gms.tasks.OnSuccessListener
    public void onSuccess(Object obj) {
        ((zzw) this.zzc).zzb(obj);
    }

    @Override // com.google.android.gms.tasks.zzq
    public final void zzc() {
        switch (this.$r8$classId) {
            case 0:
                synchronized (this.zzb) {
                    this.zzc = null;
                    break;
                }
                return;
            case 1:
                zzc$com$google$android$gms$tasks$zzj();
                return;
            case 2:
                zzc$com$google$android$gms$tasks$zzl();
                return;
            case 3:
                zzc$com$google$android$gms$tasks$zzn();
                return;
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override // com.google.android.gms.tasks.zzq
    public final void zzd(Task task) {
        switch (this.$r8$classId) {
            case 0:
                if (((zzw) task).zzd) {
                    synchronized (this.zzb) {
                        try {
                            if (((OnCanceledListener) this.zzc) != null) {
                                zzt zztVar = (zzt) this.zza;
                                zzg zzgVar = new zzg(this, 0);
                                zztVar.getClass();
                                zzgVar.run();
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    return;
                }
                return;
            case 1:
                zzd$com$google$android$gms$tasks$zzj(task);
                return;
            case 2:
                zzd$com$google$android$gms$tasks$zzl(task);
                return;
            case 3:
                zzd$com$google$android$gms$tasks$zzn(task);
                return;
            default:
                ((zzu) this.zza).execute(new zzc(this, task, 13));
                return;
        }
    }

    public zzh(zzu zzuVar, SuccessContinuation successContinuation, zzw zzwVar) {
        this.$r8$classId = 4;
        this.zza = zzuVar;
        this.zzb = successContinuation;
        this.zzc = zzwVar;
    }

    public zzh(Executor executor, OnCompleteListener onCompleteListener) {
        this.$r8$classId = 1;
        this.zzb = new Object();
        this.zza = executor;
        this.zzc = onCompleteListener;
    }

    public zzh(Executor executor, OnFailureListener onFailureListener) {
        this.$r8$classId = 2;
        this.zzb = new Object();
        this.zza = executor;
        this.zzc = onFailureListener;
    }

    public zzh(Executor executor, OnSuccessListener onSuccessListener) {
        this.$r8$classId = 3;
        this.zzb = new Object();
        this.zza = executor;
        this.zzc = onSuccessListener;
    }
}
