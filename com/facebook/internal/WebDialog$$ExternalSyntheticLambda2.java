package com.facebook.internal;

import android.view.View;
import com.facebook.login.DeviceAuthDialog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class WebDialog$$ExternalSyntheticLambda2 implements View.OnClickListener {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ View.OnCreateContextMenuListener f$0;

    public /* synthetic */ WebDialog$$ExternalSyntheticLambda2(View.OnCreateContextMenuListener onCreateContextMenuListener, int i) {
        this.$r8$classId = i;
        this.f$0 = onCreateContextMenuListener;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.$r8$classId) {
            case 0:
                WebDialog this$0 = (WebDialog) this.f$0;
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                this$0.cancel();
                break;
            default:
                DeviceAuthDialog this$1 = (DeviceAuthDialog) this.f$0;
                Intrinsics.checkNotNullParameter(this$1, "this$0");
                this$1.onCancel();
                break;
        }
    }
}
