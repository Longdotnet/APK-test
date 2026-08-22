package com.yoyogames.runner;

import android.content.DialogInterface;
import android.content.Intent;
import android.widget.EditText;
import androidx.work.impl.WorkerWrapper;
import com.daerisoft.thespikerm.RunnerActivity;
import com.google.android.gms.ads.internal.util.zzau;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzv;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes3.dex */
public final class RunnerJNILib$5$1 implements DialogInterface.OnClickListener {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object this$0;
    public final /* synthetic */ Object val$input;

    public /* synthetic */ RunnerJNILib$5$1(zzau zzauVar, String str) {
        this.$r8$classId = 1;
        this.val$input = zzauVar;
        this.this$0 = str;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        switch (this.$r8$classId) {
            case 0:
                RunnerActivity.InputStringResult = ((EditText) this.val$input).getText().toString();
                ((CountDownLatch) ((WorkerWrapper.AnonymousClass1) this.this$0).this$0).countDown();
                break;
            case 1:
                zzs zzsVar = zzv.zza.zzd;
                zzs.zzU(((zzau) this.val$input).zza, Intent.createChooser(new Intent("android.intent.action.SEND").setType("text/plain").putExtra("android.intent.extra.TEXT", (String) this.this$0), "Share via"));
                break;
            default:
                String string = ((EditText) this.val$input).getText().toString();
                RunnerActivity.InputStringResult = string;
                RunnerJNILib.InputResult(string, 1, ((RunnerJNILib.AnonymousClass6) this.this$0).val$idDialog);
                break;
        }
    }

    public /* synthetic */ RunnerJNILib$5$1(Runnable runnable, EditText editText, int i) {
        this.$r8$classId = i;
        this.this$0 = runnable;
        this.val$input = editText;
    }
}
