package androidx.fragment.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.activity.ComponentDialog;
import androidx.fragment.app.FragmentManager.PopBackStackState;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import androidx.work.Worker;
import com.daerisoft.thespikerm.R;
import com.facebook.AccessTokenCache;
import com.google.android.gms.ads.internal.util.zzau;
import okhttp3.Protocol;

/* JADX INFO: loaded from: classes.dex */
public class DialogFragment extends Fragment implements DialogInterface.OnCancelListener, DialogInterface.OnDismissListener {
    public int mBackStackId;
    public boolean mCancelable;
    public boolean mCreatingDialog;
    public Dialog mDialog;
    public boolean mDialogCreated;
    public boolean mDismissed;
    public final AccessTokenCache mObserver;
    public final AnonymousClass2 mOnCancelListener;
    public final AnonymousClass3 mOnDismissListener;
    public boolean mShownByMe;
    public boolean mShowsDialog;
    public int mStyle;
    public int mTheme;
    public boolean mViewDestroyed;

    /* JADX INFO: renamed from: androidx.fragment.app.DialogFragment$2 */
    public final class AnonymousClass2 implements DialogInterface.OnCancelListener {
        public final /* synthetic */ int $r8$classId;
        public final /* synthetic */ Object this$0;

        public /* synthetic */ AnonymousClass2(Object obj, int i) {
            this.$r8$classId = i;
            this.this$0 = obj;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public final void onCancel(DialogInterface dialogInterface) {
            switch (this.$r8$classId) {
                case 0:
                    DialogFragment dialogFragment = (DialogFragment) this.this$0;
                    Dialog dialog = dialogFragment.mDialog;
                    if (dialog != null) {
                        dialogFragment.onCancel(dialog);
                    }
                    break;
                default:
                    ((zzau) this.this$0).zzr();
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.DialogFragment$3 */
    public final class AnonymousClass3 implements DialogInterface.OnDismissListener {
        public AnonymousClass3() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface dialogInterface) {
            DialogFragment dialogFragment = DialogFragment.this;
            Dialog dialog = dialogFragment.mDialog;
            if (dialog != null) {
                dialogFragment.onDismiss(dialog);
            }
        }
    }

    /* JADX INFO: renamed from: androidx.fragment.app.DialogFragment$5 */
    public final class AnonymousClass5 extends FragmentContainer {
        public final /* synthetic */ Fragment.AnonymousClass5 val$fragmentContainer;

        public AnonymousClass5() {
            anonymousClass5 = anonymousClass5;
        }

        @Override // androidx.fragment.app.FragmentContainer
        public final View onFindViewById(int i) {
            Fragment.AnonymousClass5 anonymousClass5 = anonymousClass5;
            if (anonymousClass5.onHasView()) {
                return anonymousClass5.onFindViewById(i);
            }
            Dialog dialog = DialogFragment.this.mDialog;
            if (dialog != null) {
                return dialog.findViewById(i);
            }
            return null;
        }

        @Override // androidx.fragment.app.FragmentContainer
        public final boolean onHasView() {
            return anonymousClass5.onHasView() || DialogFragment.this.mDialogCreated;
        }
    }

    public DialogFragment() {
        new Worker.AnonymousClass1(this, 10);
        this.mOnCancelListener = new AnonymousClass2(this, 0);
        this.mOnDismissListener = new AnonymousClass3();
        this.mStyle = 0;
        this.mTheme = 0;
        this.mCancelable = true;
        this.mShowsDialog = true;
        this.mBackStackId = -1;
        this.mObserver = new AccessTokenCache(this, 7);
        this.mDialogCreated = false;
    }

    @Override // androidx.fragment.app.Fragment
    public final FragmentContainer createFragmentContainer() {
        return new FragmentContainer() { // from class: androidx.fragment.app.DialogFragment.5
            public final /* synthetic */ Fragment.AnonymousClass5 val$fragmentContainer;

            public AnonymousClass5() {
                anonymousClass5 = anonymousClass5;
            }

            @Override // androidx.fragment.app.FragmentContainer
            public final View onFindViewById(int i) {
                Fragment.AnonymousClass5 anonymousClass5 = anonymousClass5;
                if (anonymousClass5.onHasView()) {
                    return anonymousClass5.onFindViewById(i);
                }
                Dialog dialog = DialogFragment.this.mDialog;
                if (dialog != null) {
                    return dialog.findViewById(i);
                }
                return null;
            }

            @Override // androidx.fragment.app.FragmentContainer
            public final boolean onHasView() {
                return anonymousClass5.onHasView() || DialogFragment.this.mDialogCreated;
            }
        };
    }

    @Override // androidx.fragment.app.Fragment
    public final void onAttach(Context context) {
        super.onAttach(context);
        getViewLifecycleOwnerLiveData().observeForever(this.mObserver);
        if (this.mShownByMe) {
            return;
        }
        this.mDismissed = false;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        new Handler();
        this.mShowsDialog = this.mContainerId == 0;
        if (bundle != null) {
            this.mStyle = bundle.getInt("android:style", 0);
            this.mTheme = bundle.getInt("android:theme", 0);
            this.mCancelable = bundle.getBoolean("android:cancelable", true);
            this.mShowsDialog = bundle.getBoolean("android:showsDialog", this.mShowsDialog);
            this.mBackStackId = bundle.getInt("android:backStackId", -1);
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        if (Log.isLoggable("FragmentManager", 3)) {
            Log.d("FragmentManager", "onCreateDialog called for DialogFragment " + this);
        }
        return new ComponentDialog(requireContext(), this.mTheme);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        Dialog dialog = this.mDialog;
        if (dialog != null) {
            this.mViewDestroyed = true;
            dialog.setOnDismissListener(null);
            this.mDialog.dismiss();
            if (!this.mDismissed) {
                onDismiss(this.mDialog);
            }
            this.mDialog = null;
            this.mDialogCreated = false;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDetach() {
        super.onDetach();
        if (!this.mShownByMe && !this.mDismissed) {
            this.mDismissed = true;
        }
        getViewLifecycleOwnerLiveData().removeObserver(this.mObserver);
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (this.mViewDestroyed) {
            return;
        }
        if (Log.isLoggable("FragmentManager", 3)) {
            Log.d("FragmentManager", "onDismiss called for DialogFragment " + this);
        }
        if (this.mDismissed) {
            return;
        }
        this.mDismissed = true;
        this.mShownByMe = false;
        Dialog dialog = this.mDialog;
        if (dialog != null) {
            dialog.setOnDismissListener(null);
            this.mDialog.dismiss();
        }
        this.mViewDestroyed = true;
        if (this.mBackStackId >= 0) {
            FragmentManager parentFragmentManager = getParentFragmentManager();
            int i = this.mBackStackId;
            parentFragmentManager.getClass();
            if (i < 0) {
                throw new IllegalArgumentException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m(i, "Bad id: "));
            }
            parentFragmentManager.enqueueAction(parentFragmentManager.new PopBackStackState(i), true);
            this.mBackStackId = -1;
            return;
        }
        FragmentManager parentFragmentManager2 = getParentFragmentManager();
        parentFragmentManager2.getClass();
        BackStackRecord backStackRecord = new BackStackRecord(parentFragmentManager2);
        backStackRecord.mReorderingAllowed = true;
        FragmentManager fragmentManager = this.mFragmentManager;
        if (fragmentManager == null || fragmentManager == backStackRecord.mManager) {
            backStackRecord.addOp(new FragmentTransaction$Op(this, 3));
            backStackRecord.commitInternal(true);
        } else {
            throw new IllegalStateException("Cannot remove Fragment attached to a different FragmentManager. Fragment " + toString() + " is already attached to a FragmentManager.");
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final LayoutInflater onGetLayoutInflater(Bundle bundle) {
        LayoutInflater layoutInflaterOnGetLayoutInflater = super.onGetLayoutInflater(bundle);
        boolean z = this.mShowsDialog;
        if (!z || this.mCreatingDialog) {
            if (Log.isLoggable("FragmentManager", 2)) {
                String str = "getting layout inflater for DialogFragment " + this;
                if (this.mShowsDialog) {
                    Log.d("FragmentManager", "mCreatingDialog = true: " + str);
                } else {
                    Log.d("FragmentManager", "mShowsDialog = false: " + str);
                }
            }
            return layoutInflaterOnGetLayoutInflater;
        }
        if (z && !this.mDialogCreated) {
            try {
                this.mCreatingDialog = true;
                Dialog dialogOnCreateDialog = onCreateDialog(bundle);
                this.mDialog = dialogOnCreateDialog;
                if (this.mShowsDialog) {
                    int i = this.mStyle;
                    if (i == 1 || i == 2) {
                        dialogOnCreateDialog.requestWindowFeature(1);
                    } else if (i == 3) {
                        Window window = dialogOnCreateDialog.getWindow();
                        if (window != null) {
                            window.addFlags(24);
                        }
                        dialogOnCreateDialog.requestWindowFeature(1);
                    }
                    Context context = getContext();
                    if (context instanceof Activity) {
                        this.mDialog.setOwnerActivity((Activity) context);
                    }
                    this.mDialog.setCancelable(this.mCancelable);
                    this.mDialog.setOnCancelListener(this.mOnCancelListener);
                    this.mDialog.setOnDismissListener(this.mOnDismissListener);
                    this.mDialogCreated = true;
                } else {
                    this.mDialog = null;
                }
                this.mCreatingDialog = false;
            } catch (Throwable th) {
                this.mCreatingDialog = false;
                throw th;
            }
        }
        if (Log.isLoggable("FragmentManager", 2)) {
            Log.d("FragmentManager", "get layout inflater for DialogFragment " + this + " from dialog context");
        }
        Dialog dialog = this.mDialog;
        return dialog != null ? layoutInflaterOnGetLayoutInflater.cloneInContext(dialog.getContext()) : layoutInflaterOnGetLayoutInflater;
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        Dialog dialog = this.mDialog;
        if (dialog != null) {
            Bundle bundleOnSaveInstanceState = dialog.onSaveInstanceState();
            bundleOnSaveInstanceState.putBoolean("android:dialogShowing", false);
            bundle.putBundle("android:savedDialogState", bundleOnSaveInstanceState);
        }
        int i = this.mStyle;
        if (i != 0) {
            bundle.putInt("android:style", i);
        }
        int i2 = this.mTheme;
        if (i2 != 0) {
            bundle.putInt("android:theme", i2);
        }
        boolean z = this.mCancelable;
        if (!z) {
            bundle.putBoolean("android:cancelable", z);
        }
        boolean z2 = this.mShowsDialog;
        if (!z2) {
            bundle.putBoolean("android:showsDialog", z2);
        }
        int i3 = this.mBackStackId;
        if (i3 != -1) {
            bundle.putInt("android:backStackId", i3);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onStart() {
        this.mCalled = true;
        Dialog dialog = this.mDialog;
        if (dialog != null) {
            this.mViewDestroyed = false;
            dialog.show();
            View decorView = this.mDialog.getWindow().getDecorView();
            ViewTreeLifecycleOwner.set(decorView, this);
            decorView.setTag(R.id.view_tree_view_model_store_owner, this);
            Protocol.Companion.set(decorView, this);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onStop() {
        this.mCalled = true;
        Dialog dialog = this.mDialog;
        if (dialog != null) {
            dialog.hide();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewStateRestored(Bundle bundle) {
        Bundle bundle2;
        super.onViewStateRestored(bundle);
        if (this.mDialog == null || bundle == null || (bundle2 = bundle.getBundle("android:savedDialogState")) == null) {
            return;
        }
        this.mDialog.onRestoreInstanceState(bundle2);
    }

    @Override // androidx.fragment.app.Fragment
    public final void performCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Bundle bundle2;
        super.performCreateView(layoutInflater, viewGroup, bundle);
        if (this.mView != null || this.mDialog == null || bundle == null || (bundle2 = bundle.getBundle("android:savedDialogState")) == null) {
            return;
        }
        this.mDialog.onRestoreInstanceState(bundle2);
    }

    public void show(FragmentManager fragmentManager, String str) {
        this.mDismissed = false;
        this.mShownByMe = true;
        fragmentManager.getClass();
        BackStackRecord backStackRecord = new BackStackRecord(fragmentManager);
        backStackRecord.mReorderingAllowed = true;
        backStackRecord.doAddOp(0, this, str);
        backStackRecord.commitInternal(false);
    }
}
