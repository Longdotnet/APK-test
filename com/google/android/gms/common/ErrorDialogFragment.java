package com.google.android.gms.common;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import com.google.android.gms.common.internal.zzah;

/* JADX INFO: loaded from: classes.dex */
public class ErrorDialogFragment extends DialogFragment {
    public AlertDialog zaa;
    public DialogInterface.OnCancelListener zab;
    public AlertDialog zac;

    @Override // android.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        DialogInterface.OnCancelListener onCancelListener = this.zab;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }

    @Override // android.app.DialogFragment
    public final Dialog onCreateDialog(Bundle bundle) {
        AlertDialog alertDialog = this.zaa;
        if (alertDialog != null) {
            return alertDialog;
        }
        setShowsDialog(false);
        if (this.zac == null) {
            Activity activity = getActivity();
            zzah.checkNotNull(activity);
            this.zac = new AlertDialog.Builder(activity).create();
        }
        return this.zac;
    }
}
