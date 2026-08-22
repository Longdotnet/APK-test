package com.google.android.gms.tasks;

import android.app.Activity;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public abstract class Task {
    public abstract zzw addOnCompleteListener(Activity activity, OnCompleteListener onCompleteListener);

    public abstract zzw addOnCompleteListener(OnCompleteListener onCompleteListener);

    public abstract zzw addOnCompleteListener(Executor executor, OnCompleteListener onCompleteListener);

    public abstract zzw addOnFailureListener(OnFailureListener onFailureListener);

    public abstract zzw addOnFailureListener(Executor executor, OnFailureListener onFailureListener);

    public abstract zzw addOnSuccessListener(Executor executor, OnSuccessListener onSuccessListener);

    public abstract zzw continueWith(Executor executor, Continuation continuation);

    public abstract zzw continueWithTask(Executor executor, Continuation continuation);

    public abstract Exception getException();

    public abstract Object getResult();

    public abstract boolean isComplete();

    public abstract boolean isSuccessful();
}
