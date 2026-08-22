package com.daerisoft.thespikerm;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class YYGooglePlayServices$$ExternalSyntheticLambda0 implements OnCompleteListener {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ double f$0;

    public /* synthetic */ YYGooglePlayServices$$ExternalSyntheticLambda0(int i, double d) {
        this.$r8$classId = i;
        this.f$0 = d;
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public final void onComplete(Task task) {
        switch (this.$r8$classId) {
            case 0:
                YYGooglePlayServices.lambda$GooglePlayServices_PlayerStats_LoadPlayerStats$7(this.f$0, task);
                break;
            case 1:
                YYGooglePlayServices.lambda$GooglePlayServices_SavedGames_CommitNew$2(this.f$0, task);
                break;
            case 2:
                YYGooglePlayServices.lambda$GooglePlayServices_SavedGames_Load$4(this.f$0, task);
                break;
            default:
                YYGooglePlayServices.lambda$GooglePlayServices_SavedGames_Delete$6(this.f$0, task);
                break;
        }
    }
}
