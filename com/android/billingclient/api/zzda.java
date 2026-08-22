package com.android.billingclient.api;

import android.R;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.util.JsonWriter;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AlertController;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.view.menu.MenuDialogHelper;
import com.google.android.gms.ads.internal.util.client.zzk;
import com.google.android.gms.ads.internal.util.client.zzl;
import com.google.android.gms.auth.IJ.gZrKCJ;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class zzda implements zzk {
    public Object zza;
    public int zzb;

    public /* synthetic */ zzda(int i, Object obj) {
        this.zzb = i;
        this.zza = obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v1, types: [android.widget.ListAdapter] */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v4 */
    public AlertDialog create() {
        final AlertController.AlertParams alertParams = (AlertController.AlertParams) this.zza;
        AlertDialog alertDialog = new AlertDialog(alertParams.mContext, this.zzb);
        View view = alertParams.mCustomTitleView;
        final AlertController alertController = alertDialog.mAlert;
        if (view != null) {
            alertController.mCustomTitleView = view;
        } else {
            CharSequence charSequence = alertParams.mTitle;
            if (charSequence != null) {
                alertController.mTitle = charSequence;
                TextView textView = alertController.mTitleView;
                if (textView != null) {
                    textView.setText(charSequence);
                }
            }
            Drawable drawable = alertParams.mIcon;
            if (drawable != null) {
                alertController.mIcon = drawable;
                ImageView imageView = alertController.mIconView;
                if (imageView != null) {
                    imageView.setVisibility(0);
                    alertController.mIconView.setImageDrawable(drawable);
                }
            }
        }
        if (alertParams.mAdapter != null) {
            AlertController.RecycleListView recycleListView = (AlertController.RecycleListView) alertParams.mInflater.inflate(alertController.mListLayout, (ViewGroup) null);
            int i = alertParams.mIsSingleChoice ? alertController.mSingleChoiceItemLayout : alertController.mListItemLayout;
            Object obj = alertParams.mAdapter;
            ?? checkedItemAdapter = obj;
            if (obj == null) {
                checkedItemAdapter = new AlertController.CheckedItemAdapter(alertParams.mContext, i, R.id.text1, null);
            }
            alertController.mAdapter = checkedItemAdapter;
            alertController.mCheckedItem = alertParams.mCheckedItem;
            if (alertParams.mOnClickListener != null) {
                recycleListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: androidx.appcompat.app.AlertController.AlertParams.3
                    @Override // android.widget.AdapterView.OnItemClickListener
                    public final void onItemClick(AdapterView adapterView, View view2, int i2, long j) {
                        AlertParams alertParams2 = AlertParams.this;
                        DialogInterface.OnClickListener onClickListener = alertParams2.mOnClickListener;
                        AlertController alertController2 = alertController;
                        onClickListener.onClick(alertController2.mDialog, i2);
                        if (alertParams2.mIsSingleChoice) {
                            return;
                        }
                        alertController2.mDialog.dismiss();
                    }
                });
            }
            if (alertParams.mIsSingleChoice) {
                recycleListView.setChoiceMode(1);
            }
            alertController.mListView = recycleListView;
        }
        alertDialog.setCancelable(true);
        alertDialog.setCanceledOnTouchOutside(true);
        alertDialog.setOnCancelListener(null);
        alertDialog.setOnDismissListener(null);
        MenuDialogHelper menuDialogHelper = alertParams.mOnKeyListener;
        if (menuDialogHelper != null) {
            alertDialog.setOnKeyListener(menuDialogHelper);
        }
        return alertDialog;
    }

    public boolean hasNext() {
        return this.zzb < ((ArrayList) this.zza).size();
    }

    public zzda(BillingResult billingResult, int i) {
        this.zza = billingResult;
        this.zzb = i;
    }

    @Override // com.google.android.gms.ads.internal.util.client.zzk
    public void zza(JsonWriter jsonWriter) throws IOException {
        jsonWriter.name(gZrKCJ.yHdcfcbkqKzHql).beginObject();
        jsonWriter.name("firstline").beginObject();
        jsonWriter.name("code").value(this.zzb);
        jsonWriter.endObject();
        zzl.zzr(jsonWriter, (Map) this.zza);
        jsonWriter.endObject();
    }

    public zzda(Context context) {
        int iResolveDialogTheme = AlertDialog.resolveDialogTheme(context, 0);
        this.zza = new AlertController.AlertParams(new ContextThemeWrapper(context, AlertDialog.resolveDialogTheme(context, iResolveDialogTheme)));
        this.zzb = iResolveDialogTheme;
    }
}
