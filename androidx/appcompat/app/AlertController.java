package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.R$styleable;
import androidx.appcompat.view.menu.MenuDialogHelper;
import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.NestedScrollView;
import com.daerisoft.thespikerm.R;
import com.facebook.internal.PlatformServiceClient$1;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public final class AlertController {
    public ListAdapter mAdapter;
    public final int mAlertDialogLayout;
    public Button mButtonNegative;
    public Button mButtonNeutral;
    public Button mButtonPositive;
    public final Context mContext;
    public View mCustomTitleView;
    public final AlertDialog mDialog;
    public final PlatformServiceClient$1 mHandler;
    public Drawable mIcon;
    public ImageView mIconView;
    public final int mListItemLayout;
    public final int mListLayout;
    public RecycleListView mListView;
    public TextView mMessageView;
    public NestedScrollView mScrollView;
    public final boolean mShowTitle;
    public final int mSingleChoiceItemLayout;
    public CharSequence mTitle;
    public TextView mTitleView;
    public final Window mWindow;
    public int mCheckedItem = -1;
    public final Toolbar.AnonymousClass4 mButtonHandler = new Toolbar.AnonymousClass4(this, 1);

    public final class AlertParams {
        public Object mAdapter;
        public int mCheckedItem = -1;
        public final ContextThemeWrapper mContext;
        public View mCustomTitleView;
        public Drawable mIcon;
        public final LayoutInflater mInflater;
        public boolean mIsSingleChoice;
        public DialogInterface.OnClickListener mOnClickListener;
        public MenuDialogHelper mOnKeyListener;
        public CharSequence mTitle;

        /* JADX INFO: renamed from: androidx.appcompat.app.AlertController$AlertParams$3 */
        public final class AnonymousClass3 implements AdapterView.OnItemClickListener {
            public final /* synthetic */ AlertController val$dialog;

            public AnonymousClass3() {
                alertController = alertController;
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
                AlertParams alertParams = AlertParams.this;
                DialogInterface.OnClickListener onClickListener = alertParams.mOnClickListener;
                AlertController alertController = alertController;
                onClickListener.onClick(alertController.mDialog, i);
                if (alertParams.mIsSingleChoice) {
                    return;
                }
                alertController.mDialog.dismiss();
            }
        }

        public AlertParams(ContextThemeWrapper contextThemeWrapper) {
            this.mContext = contextThemeWrapper;
            this.mInflater = (LayoutInflater) contextThemeWrapper.getSystemService("layout_inflater");
        }
    }

    public final class CheckedItemAdapter extends ArrayAdapter {
        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public final long getItemId(int i) {
            return i;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public final boolean hasStableIds() {
            return true;
        }
    }

    public class RecycleListView extends ListView {
        public final int mPaddingBottomNoButtons;
        public final int mPaddingTopNoTitle;

        public RecycleListView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.RecycleListView);
            this.mPaddingBottomNoButtons = typedArrayObtainStyledAttributes.getDimensionPixelOffset(0, -1);
            this.mPaddingTopNoTitle = typedArrayObtainStyledAttributes.getDimensionPixelOffset(1, -1);
        }
    }

    public AlertController(Context context, AlertDialog alertDialog, Window window) {
        this.mContext = context;
        this.mDialog = alertDialog;
        this.mWindow = window;
        PlatformServiceClient$1 platformServiceClient$1 = new PlatformServiceClient$1();
        platformServiceClient$1.this$0 = new WeakReference(alertDialog);
        this.mHandler = platformServiceClient$1;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(null, R$styleable.AlertDialog, R.attr.alertDialogStyle, 0);
        this.mAlertDialogLayout = typedArrayObtainStyledAttributes.getResourceId(0, 0);
        typedArrayObtainStyledAttributes.getResourceId(2, 0);
        this.mListLayout = typedArrayObtainStyledAttributes.getResourceId(4, 0);
        typedArrayObtainStyledAttributes.getResourceId(5, 0);
        this.mSingleChoiceItemLayout = typedArrayObtainStyledAttributes.getResourceId(7, 0);
        this.mListItemLayout = typedArrayObtainStyledAttributes.getResourceId(3, 0);
        this.mShowTitle = typedArrayObtainStyledAttributes.getBoolean(6, true);
        typedArrayObtainStyledAttributes.getDimensionPixelSize(1, 0);
        typedArrayObtainStyledAttributes.recycle();
        alertDialog.getDelegate().requestWindowFeature(1);
    }

    public static ViewGroup resolvePanel(View view, View view2) {
        if (view == null) {
            if (view2 instanceof ViewStub) {
                view2 = ((ViewStub) view2).inflate();
            }
            return (ViewGroup) view2;
        }
        if (view2 != null) {
            ViewParent parent = view2.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view2);
            }
        }
        if (view instanceof ViewStub) {
            view = ((ViewStub) view).inflate();
        }
        return (ViewGroup) view;
    }
}
