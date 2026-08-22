package com.google.firebase.auth;

import com.google.android.gms.tasks.Task;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class MultiFactor {
    public abstract Task enroll(MultiFactorAssertion multiFactorAssertion, String str);

    public abstract List<MultiFactorInfo> getEnrolledFactors();

    public abstract Task getSession();

    public abstract Task unenroll(MultiFactorInfo multiFactorInfo);

    public abstract Task unenroll(String str);
}
