package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.ThemedSpinnerAdapter;
import androidx.appcompat.R$styleable;
import androidx.appcompat.app.AlertController;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.appcompat.view.menu.CascadingMenuPopup;
import androidx.appcompat.view.menu.ShowableListMenu;
import androidx.appcompat.view.menu.StandardMenuPopup;
import androidx.fragment.app.FragmentState;
import com.android.billingclient.api.zzda;
import com.daerisoft.thespikerm.RunnerKeyboardController;
import com.facebook.appevents.internal.SessionInfo;
import com.google.android.datatransport.runtime.synchronization.JDyk.FETmZwrVHuasmL;
import com.google.firebase.auth.zzaa;
import com.yoyogames.runner.RunnerJNILib;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import okhttp3.Headers;

/* JADX INFO: loaded from: classes.dex */
public final class AppCompatSpinner extends Spinner {
    public static final int[] ATTRS_ANDROID_SPINNERMODE = {R.attr.spinnerMode};
    public final SessionInfo mBackgroundTintHelper;
    public int mDropDownWidth;
    public final AnonymousClass1 mForwardingListener;
    public final SpinnerPopup mPopup;
    public final Context mPopupContext;
    public final boolean mPopupSet;
    public SpinnerAdapter mTempAdapter;
    public final Rect mTempRect;

    /* JADX INFO: renamed from: androidx.appcompat.widget.AppCompatSpinner$2, reason: invalid class name */
    public final class AnonymousClass2 implements ViewTreeObserver.OnGlobalLayoutListener {
        public final /* synthetic */ int $r8$classId;
        public Object this$0;

        public /* synthetic */ AnonymousClass2() {
            this.$r8$classId = 4;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            switch (this.$r8$classId) {
                case 0:
                    AppCompatSpinner appCompatSpinner = (AppCompatSpinner) this.this$0;
                    if (!appCompatSpinner.getInternalPopup().isShowing()) {
                        appCompatSpinner.mPopup.show(appCompatSpinner.getTextDirection(), appCompatSpinner.getTextAlignment());
                    }
                    ViewTreeObserver viewTreeObserver = appCompatSpinner.getViewTreeObserver();
                    if (viewTreeObserver != null) {
                        viewTreeObserver.removeOnGlobalLayoutListener(this);
                    }
                    break;
                case 1:
                    CascadingMenuPopup cascadingMenuPopup = (CascadingMenuPopup) this.this$0;
                    if (cascadingMenuPopup.isShowing()) {
                        ArrayList arrayList = cascadingMenuPopup.mShowingMenus;
                        if (arrayList.size() > 0 && !((CascadingMenuPopup.CascadingMenuInfo) arrayList.get(0)).window.mModal) {
                            View view = cascadingMenuPopup.mShownAnchorView;
                            if (view != null && view.isShown()) {
                                Iterator it = arrayList.iterator();
                                while (it.hasNext()) {
                                    ((CascadingMenuPopup.CascadingMenuInfo) it.next()).window.show();
                                }
                            } else {
                                cascadingMenuPopup.dismiss();
                            }
                            break;
                        }
                    }
                    break;
                case 2:
                    StandardMenuPopup standardMenuPopup = (StandardMenuPopup) this.this$0;
                    if (standardMenuPopup.isShowing()) {
                        MenuPopupWindow menuPopupWindow = standardMenuPopup.mPopup;
                        if (!menuPopupWindow.mModal) {
                            View view2 = standardMenuPopup.mShownAnchorView;
                            if (view2 != null && view2.isShown()) {
                                menuPopupWindow.show();
                            } else {
                                standardMenuPopup.dismiss();
                            }
                        }
                    }
                    break;
                case 3:
                    DropdownPopup dropdownPopup = (DropdownPopup) this.this$0;
                    AppCompatSpinner appCompatSpinner2 = AppCompatSpinner.this;
                    dropdownPopup.getClass();
                    if (appCompatSpinner2.isAttachedToWindow() && appCompatSpinner2.getGlobalVisibleRect(dropdownPopup.mVisibleRect)) {
                        dropdownPopup.computeContentWidth();
                        dropdownPopup.show();
                    } else {
                        dropdownPopup.dismiss();
                    }
                    break;
                default:
                    RunnerKeyboardController runnerKeyboardController = (RunnerKeyboardController) this.this$0;
                    View view3 = runnerKeyboardController.m_activityView;
                    Rect rect = runnerKeyboardController.m_viewActiveRect;
                    view3.getWindowVisibleDisplayFrame(rect);
                    boolean z = view3.getHeight() - (rect.bottom - rect.top) >= ((int) TypedValue.applyDimension(1, (float) RunnerKeyboardController.ms_estimatedKeyboardHeight, runnerKeyboardController.m_activityView.getResources().getDisplayMetrics()));
                    if (z != runnerKeyboardController.m_virtualKeyboardVisible) {
                        runnerKeyboardController.m_virtualKeyboardVisible = z;
                        if (z) {
                            runnerKeyboardController.m_keyboardStatus = "visible";
                        } else {
                            runnerKeyboardController.m_keyboardStatus = "hidden";
                        }
                        View view4 = runnerKeyboardController.m_activityView;
                        Rect rect2 = runnerKeyboardController.m_viewActiveRect;
                        view4.getWindowVisibleDisplayFrame(rect2);
                        int height = view4.getHeight() - (rect2.bottom - rect2.top);
                        runnerKeyboardController.m_currentKeyboardHeight = height;
                        RunnerJNILib.OnVirtualKeyboardStatus(runnerKeyboardController.m_keyboardStatus, height);
                        break;
                    }
                    break;
            }
        }

        public /* synthetic */ AnonymousClass2(Object obj, int i) {
            this.$r8$classId = i;
            this.this$0 = obj;
        }
    }

    public abstract class Api23Impl {
        public static void setDropDownViewTheme(ThemedSpinnerAdapter themedSpinnerAdapter, Resources.Theme theme) {
            if (Objects.equals(themedSpinnerAdapter.getDropDownViewTheme(), theme)) {
                return;
            }
            themedSpinnerAdapter.setDropDownViewTheme(theme);
        }
    }

    /* JADX INFO: loaded from: classes2.dex */
    public final class DialogPopup implements SpinnerPopup, DialogInterface.OnClickListener {
        public DropDownAdapter mListAdapter;
        public AlertDialog mPopup;
        public CharSequence mPrompt;

        public DialogPopup() {
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public final void dismiss() {
            AlertDialog alertDialog = this.mPopup;
            if (alertDialog != null) {
                alertDialog.dismiss();
                this.mPopup = null;
            }
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public final Drawable getBackground() {
            return null;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public final CharSequence getHintText() {
            return this.mPrompt;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public final int getHorizontalOffset() {
            return 0;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public final int getVerticalOffset() {
            return 0;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public final boolean isShowing() {
            AlertDialog alertDialog = this.mPopup;
            if (alertDialog != null) {
                return alertDialog.isShowing();
            }
            return false;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface dialogInterface, int i) {
            AppCompatSpinner appCompatSpinner = AppCompatSpinner.this;
            appCompatSpinner.setSelection(i);
            if (appCompatSpinner.getOnItemClickListener() != null) {
                appCompatSpinner.performItemClick(null, i, this.mListAdapter.getItemId(i));
            }
            dismiss();
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public final void setAdapter(ListAdapter listAdapter) {
            this.mListAdapter = (DropDownAdapter) listAdapter;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public final void setBackgroundDrawable(Drawable drawable) {
            Log.e("AppCompatSpinner", "Cannot set popup background for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public final void setHorizontalOriginalOffset(int i) {
            Log.e("AppCompatSpinner", "Cannot set horizontal (original) offset for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public final void setPromptText(CharSequence charSequence) {
            this.mPrompt = charSequence;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public final void setVerticalOffset(int i) {
            Log.e("AppCompatSpinner", "Cannot set vertical offset for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public final void show(int i, int i2) {
            if (this.mListAdapter == null) {
                return;
            }
            AppCompatSpinner appCompatSpinner = AppCompatSpinner.this;
            zzda zzdaVar = new zzda(appCompatSpinner.getPopupContext());
            CharSequence charSequence = this.mPrompt;
            AlertController.AlertParams alertParams = (AlertController.AlertParams) zzdaVar.zza;
            if (charSequence != null) {
                alertParams.mTitle = charSequence;
            }
            DropDownAdapter dropDownAdapter = this.mListAdapter;
            int selectedItemPosition = appCompatSpinner.getSelectedItemPosition();
            alertParams.mAdapter = dropDownAdapter;
            alertParams.mOnClickListener = this;
            alertParams.mCheckedItem = selectedItemPosition;
            alertParams.mIsSingleChoice = true;
            AlertDialog alertDialogCreate = zzdaVar.create();
            this.mPopup = alertDialogCreate;
            AlertController.RecycleListView recycleListView = alertDialogCreate.mAlert.mListView;
            recycleListView.setTextDirection(i);
            recycleListView.setTextAlignment(i2);
            this.mPopup.show();
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public final void setHorizontalOffset(int i) {
            Log.e("AppCompatSpinner", FETmZwrVHuasmL.tqbcqyrpGr);
        }
    }

    public final class DropDownAdapter implements ListAdapter, SpinnerAdapter {
        public SpinnerAdapter mAdapter;
        public ListAdapter mListAdapter;

        @Override // android.widget.ListAdapter
        public final boolean areAllItemsEnabled() {
            ListAdapter listAdapter = this.mListAdapter;
            if (listAdapter != null) {
                return listAdapter.areAllItemsEnabled();
            }
            return true;
        }

        @Override // android.widget.Adapter
        public final int getCount() {
            SpinnerAdapter spinnerAdapter = this.mAdapter;
            if (spinnerAdapter == null) {
                return 0;
            }
            return spinnerAdapter.getCount();
        }

        @Override // android.widget.SpinnerAdapter
        public final View getDropDownView(int i, View view, ViewGroup viewGroup) {
            SpinnerAdapter spinnerAdapter = this.mAdapter;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getDropDownView(i, view, viewGroup);
        }

        @Override // android.widget.Adapter
        public final Object getItem(int i) {
            SpinnerAdapter spinnerAdapter = this.mAdapter;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getItem(i);
        }

        @Override // android.widget.Adapter
        public final long getItemId(int i) {
            SpinnerAdapter spinnerAdapter = this.mAdapter;
            if (spinnerAdapter == null) {
                return -1L;
            }
            return spinnerAdapter.getItemId(i);
        }

        @Override // android.widget.Adapter
        public final int getItemViewType(int i) {
            return 0;
        }

        @Override // android.widget.Adapter
        public final View getView(int i, View view, ViewGroup viewGroup) {
            return getDropDownView(i, view, viewGroup);
        }

        @Override // android.widget.Adapter
        public final int getViewTypeCount() {
            return 1;
        }

        @Override // android.widget.Adapter
        public final boolean hasStableIds() {
            SpinnerAdapter spinnerAdapter = this.mAdapter;
            return spinnerAdapter != null && spinnerAdapter.hasStableIds();
        }

        @Override // android.widget.Adapter
        public final boolean isEmpty() {
            return getCount() == 0;
        }

        @Override // android.widget.ListAdapter
        public final boolean isEnabled(int i) {
            ListAdapter listAdapter = this.mListAdapter;
            if (listAdapter != null) {
                return listAdapter.isEnabled(i);
            }
            return true;
        }

        @Override // android.widget.Adapter
        public final void registerDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.mAdapter;
            if (spinnerAdapter != null) {
                spinnerAdapter.registerDataSetObserver(dataSetObserver);
            }
        }

        @Override // android.widget.Adapter
        public final void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.mAdapter;
            if (spinnerAdapter != null) {
                spinnerAdapter.unregisterDataSetObserver(dataSetObserver);
            }
        }
    }

    public final class DropdownPopup extends ListPopupWindow implements SpinnerPopup {
        public DropDownAdapter mAdapter;
        public CharSequence mHintText;
        public int mOriginalHorizontalOffset;
        public final Rect mVisibleRect;

        public DropdownPopup(Context context, AttributeSet attributeSet) {
            super(context, attributeSet, com.daerisoft.thespikerm.R.attr.spinnerStyle);
            this.mVisibleRect = new Rect();
            this.mDropDownAnchorView = AppCompatSpinner.this;
            this.mModal = true;
            this.mPopup.setFocusable(true);
            this.mItemClickListener = new AdapterView.OnItemClickListener() { // from class: androidx.appcompat.widget.AppCompatSpinner.DropdownPopup.1
                @Override // android.widget.AdapterView.OnItemClickListener
                public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
                    DropdownPopup dropdownPopup = DropdownPopup.this;
                    AppCompatSpinner.this.setSelection(i);
                    AppCompatSpinner appCompatSpinner = AppCompatSpinner.this;
                    if (appCompatSpinner.getOnItemClickListener() != null) {
                        appCompatSpinner.performItemClick(view, i, dropdownPopup.mAdapter.getItemId(i));
                    }
                    dropdownPopup.dismiss();
                }
            };
        }

        public final void computeContentWidth() {
            int i;
            AppCompatPopupWindow appCompatPopupWindow = this.mPopup;
            Drawable background = appCompatPopupWindow.getBackground();
            AppCompatSpinner appCompatSpinner = AppCompatSpinner.this;
            if (background != null) {
                background.getPadding(appCompatSpinner.mTempRect);
                boolean z = ViewUtils.sInitComputeFitSystemWindowsMethod;
                int layoutDirection = appCompatSpinner.getLayoutDirection();
                Rect rect = appCompatSpinner.mTempRect;
                i = layoutDirection == 1 ? rect.right : -rect.left;
            } else {
                Rect rect2 = appCompatSpinner.mTempRect;
                rect2.right = 0;
                rect2.left = 0;
                i = 0;
            }
            int paddingLeft = appCompatSpinner.getPaddingLeft();
            int paddingRight = appCompatSpinner.getPaddingRight();
            int width = appCompatSpinner.getWidth();
            int i2 = appCompatSpinner.mDropDownWidth;
            if (i2 == -2) {
                int iCompatMeasureContentWidth = appCompatSpinner.compatMeasureContentWidth(this.mAdapter, appCompatPopupWindow.getBackground());
                int i3 = appCompatSpinner.getContext().getResources().getDisplayMetrics().widthPixels;
                Rect rect3 = appCompatSpinner.mTempRect;
                int i4 = (i3 - rect3.left) - rect3.right;
                if (iCompatMeasureContentWidth > i4) {
                    iCompatMeasureContentWidth = i4;
                }
                setContentWidth(Math.max(iCompatMeasureContentWidth, (width - paddingLeft) - paddingRight));
            } else if (i2 == -1) {
                setContentWidth((width - paddingLeft) - paddingRight);
            } else {
                setContentWidth(i2);
            }
            boolean z2 = ViewUtils.sInitComputeFitSystemWindowsMethod;
            this.mDropDownHorizontalOffset = appCompatSpinner.getLayoutDirection() == 1 ? (((width - paddingRight) - this.mDropDownWidth) - this.mOriginalHorizontalOffset) + i : paddingLeft + this.mOriginalHorizontalOffset + i;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public final CharSequence getHintText() {
            return this.mHintText;
        }

        @Override // androidx.appcompat.widget.ListPopupWindow, androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public final void setAdapter(ListAdapter listAdapter) {
            super.setAdapter(listAdapter);
            this.mAdapter = (DropDownAdapter) listAdapter;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public final void setHorizontalOriginalOffset(int i) {
            this.mOriginalHorizontalOffset = i;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public final void setPromptText(CharSequence charSequence) {
            this.mHintText = charSequence;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.SpinnerPopup
        public final void show(int i, int i2) {
            ViewTreeObserver viewTreeObserver;
            AppCompatPopupWindow appCompatPopupWindow = this.mPopup;
            boolean zIsShowing = appCompatPopupWindow.isShowing();
            computeContentWidth();
            this.mPopup.setInputMethodMode(2);
            show();
            DropDownListView dropDownListView = this.mDropDownList;
            dropDownListView.setChoiceMode(1);
            dropDownListView.setTextDirection(i);
            dropDownListView.setTextAlignment(i2);
            AppCompatSpinner appCompatSpinner = AppCompatSpinner.this;
            int selectedItemPosition = appCompatSpinner.getSelectedItemPosition();
            DropDownListView dropDownListView2 = this.mDropDownList;
            if (appCompatPopupWindow.isShowing() && dropDownListView2 != null) {
                dropDownListView2.setListSelectionHidden(false);
                dropDownListView2.setSelection(selectedItemPosition);
                if (dropDownListView2.getChoiceMode() != 0) {
                    dropDownListView2.setItemChecked(selectedItemPosition, true);
                }
            }
            if (zIsShowing || (viewTreeObserver = appCompatSpinner.getViewTreeObserver()) == null) {
                return;
            }
            final AnonymousClass2 anonymousClass2 = new AnonymousClass2(this, 3);
            viewTreeObserver.addOnGlobalLayoutListener(anonymousClass2);
            this.mPopup.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: androidx.appcompat.widget.AppCompatSpinner.DropdownPopup.3
                @Override // android.widget.PopupWindow.OnDismissListener
                public final void onDismiss() {
                    ViewTreeObserver viewTreeObserver2 = AppCompatSpinner.this.getViewTreeObserver();
                    if (viewTreeObserver2 != null) {
                        viewTreeObserver2.removeGlobalOnLayoutListener(anonymousClass2);
                    }
                }
            });
        }
    }

    public final class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new FragmentState.AnonymousClass1(13);
        public boolean mShowDropdown;

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeByte(this.mShowDropdown ? (byte) 1 : (byte) 0);
        }
    }

    public interface SpinnerPopup {
        void dismiss();

        Drawable getBackground();

        CharSequence getHintText();

        int getHorizontalOffset();

        int getVerticalOffset();

        boolean isShowing();

        void setAdapter(ListAdapter listAdapter);

        void setBackgroundDrawable(Drawable drawable);

        void setHorizontalOffset(int i);

        void setHorizontalOriginalOffset(int i);

        void setPromptText(CharSequence charSequence);

        void setVerticalOffset(int i);

        void show(int i, int i2);
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0067 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:28:0x006a  */
    /* JADX WARN: Code duplicated, block: B:29:0x009d  */
    /* JADX WARN: Code duplicated, block: B:32:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:35:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:39:0x00d7  */
    /* JADX WARN: Type inference failed for: r1v6, types: [androidx.appcompat.widget.AppCompatSpinner$1] */
    public AppCompatSpinner(Context context, AttributeSet attributeSet) throws Throwable {
        TypedArray typedArrayObtainStyledAttributes;
        CharSequence[] textArray;
        SpinnerAdapter spinnerAdapter;
        super(context, attributeSet, com.daerisoft.thespikerm.R.attr.spinnerStyle);
        this.mTempRect = new Rect();
        ThemeUtils.checkAppCompatTheme(getContext(), this);
        int[] iArr = R$styleable.Spinner;
        zzaa zzaaVarObtainStyledAttributes = zzaa.obtainStyledAttributes(context, attributeSet, iArr, com.daerisoft.thespikerm.R.attr.spinnerStyle);
        this.mBackgroundTintHelper = new SessionInfo(this);
        TypedArray typedArray = (TypedArray) zzaaVarObtainStyledAttributes.zzb;
        int resourceId = typedArray.getResourceId(4, 0);
        if (resourceId != 0) {
            this.mPopupContext = new ContextThemeWrapper(context, resourceId);
        } else {
            this.mPopupContext = context;
        }
        int i = -1;
        TypedArray typedArray2 = null;
        try {
            typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ATTRS_ANDROID_SPINNERMODE, com.daerisoft.thespikerm.R.attr.spinnerStyle, 0);
            try {
                try {
                    if (typedArrayObtainStyledAttributes.hasValue(0)) {
                        i = typedArrayObtainStyledAttributes.getInt(0, 0);
                    }
                } catch (Throwable th) {
                    th = th;
                    typedArray2 = typedArrayObtainStyledAttributes;
                    if (typedArray2 != null) {
                        typedArray2.recycle();
                    }
                    throw th;
                }
            } catch (Exception e) {
                e = e;
                Log.i("AppCompatSpinner", "Could not read android:spinnerMode", e);
                if (typedArrayObtainStyledAttributes != null) {
                }
                if (i != 0) {
                    DialogPopup dialogPopup = new DialogPopup();
                    this.mPopup = dialogPopup;
                    dialogPopup.mPrompt = typedArray.getString(2);
                } else if (i == 1) {
                    final DropdownPopup dropdownPopup = new DropdownPopup(this.mPopupContext, attributeSet);
                    zzaa zzaaVarObtainStyledAttributes2 = zzaa.obtainStyledAttributes(this.mPopupContext, attributeSet, iArr, com.daerisoft.thespikerm.R.attr.spinnerStyle);
                    this.mDropDownWidth = ((TypedArray) zzaaVarObtainStyledAttributes2.zzb).getLayoutDimension(3, -2);
                    dropdownPopup.setBackgroundDrawable(zzaaVarObtainStyledAttributes2.getDrawable(1));
                    dropdownPopup.mHintText = typedArray.getString(2);
                    zzaaVarObtainStyledAttributes2.recycle();
                    this.mPopup = dropdownPopup;
                    this.mForwardingListener = new ForwardingListener(this) { // from class: androidx.appcompat.widget.AppCompatSpinner.1
                        @Override // androidx.appcompat.widget.ForwardingListener
                        public final ShowableListMenu getPopup() {
                            return dropdownPopup;
                        }

                        @Override // androidx.appcompat.widget.ForwardingListener
                        public final boolean onForwardingStarted() {
                            AppCompatSpinner appCompatSpinner = AppCompatSpinner.this;
                            if (appCompatSpinner.getInternalPopup().isShowing()) {
                                return true;
                            }
                            appCompatSpinner.mPopup.show(appCompatSpinner.getTextDirection(), appCompatSpinner.getTextAlignment());
                            return true;
                        }
                    };
                }
                textArray = typedArray.getTextArray(0);
                if (textArray != null) {
                    ArrayAdapter arrayAdapter = new ArrayAdapter(context, R.layout.simple_spinner_item, textArray);
                    arrayAdapter.setDropDownViewResource(com.daerisoft.thespikerm.R.layout.support_simple_spinner_dropdown_item);
                    setAdapter((SpinnerAdapter) arrayAdapter);
                }
                zzaaVarObtainStyledAttributes.recycle();
                this.mPopupSet = true;
                spinnerAdapter = this.mTempAdapter;
                if (spinnerAdapter != null) {
                    setAdapter(spinnerAdapter);
                    this.mTempAdapter = null;
                }
                this.mBackgroundTintHelper.loadFromAttributes(attributeSet, com.daerisoft.thespikerm.R.attr.spinnerStyle);
            }
        } catch (Exception e2) {
            e = e2;
            typedArrayObtainStyledAttributes = null;
        } catch (Throwable th2) {
            th = th2;
            if (typedArray2 != null) {
                typedArray2.recycle();
            }
            throw th;
        }
        typedArrayObtainStyledAttributes.recycle();
        if (i != 0) {
            DialogPopup dialogPopup2 = new DialogPopup();
            this.mPopup = dialogPopup2;
            dialogPopup2.mPrompt = typedArray.getString(2);
        } else if (i == 1) {
            final DropdownPopup dropdownPopup2 = new DropdownPopup(this.mPopupContext, attributeSet);
            zzaa zzaaVarObtainStyledAttributes3 = zzaa.obtainStyledAttributes(this.mPopupContext, attributeSet, iArr, com.daerisoft.thespikerm.R.attr.spinnerStyle);
            this.mDropDownWidth = ((TypedArray) zzaaVarObtainStyledAttributes3.zzb).getLayoutDimension(3, -2);
            dropdownPopup2.setBackgroundDrawable(zzaaVarObtainStyledAttributes3.getDrawable(1));
            dropdownPopup2.mHintText = typedArray.getString(2);
            zzaaVarObtainStyledAttributes3.recycle();
            this.mPopup = dropdownPopup2;
            this.mForwardingListener = new ForwardingListener(this) { // from class: androidx.appcompat.widget.AppCompatSpinner.1
                @Override // androidx.appcompat.widget.ForwardingListener
                public final ShowableListMenu getPopup() {
                    return dropdownPopup2;
                }

                @Override // androidx.appcompat.widget.ForwardingListener
                public final boolean onForwardingStarted() {
                    AppCompatSpinner appCompatSpinner = AppCompatSpinner.this;
                    if (appCompatSpinner.getInternalPopup().isShowing()) {
                        return true;
                    }
                    appCompatSpinner.mPopup.show(appCompatSpinner.getTextDirection(), appCompatSpinner.getTextAlignment());
                    return true;
                }
            };
        }
        textArray = typedArray.getTextArray(0);
        if (textArray != null) {
            ArrayAdapter arrayAdapter2 = new ArrayAdapter(context, R.layout.simple_spinner_item, textArray);
            arrayAdapter2.setDropDownViewResource(com.daerisoft.thespikerm.R.layout.support_simple_spinner_dropdown_item);
            setAdapter((SpinnerAdapter) arrayAdapter2);
        }
        zzaaVarObtainStyledAttributes.recycle();
        this.mPopupSet = true;
        spinnerAdapter = this.mTempAdapter;
        if (spinnerAdapter != null) {
            setAdapter(spinnerAdapter);
            this.mTempAdapter = null;
        }
        this.mBackgroundTintHelper.loadFromAttributes(attributeSet, com.daerisoft.thespikerm.R.attr.spinnerStyle);
    }

    public final int compatMeasureContentWidth(SpinnerAdapter spinnerAdapter, Drawable drawable) {
        int i = 0;
        if (spinnerAdapter == null) {
            return 0;
        }
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int iMax = Math.max(0, getSelectedItemPosition());
        int iMin = Math.min(spinnerAdapter.getCount(), iMax + 15);
        View view = null;
        int iMax2 = 0;
        for (int iMax3 = Math.max(0, iMax - (15 - (iMin - iMax))); iMax3 < iMin; iMax3++) {
            int itemViewType = spinnerAdapter.getItemViewType(iMax3);
            if (itemViewType != i) {
                view = null;
                i = itemViewType;
            }
            view = spinnerAdapter.getView(iMax3, view, this);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
            iMax2 = Math.max(iMax2, view.getMeasuredWidth());
        }
        if (drawable == null) {
            return iMax2;
        }
        Rect rect = this.mTempRect;
        drawable.getPadding(rect);
        return iMax2 + rect.left + rect.right;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        SessionInfo sessionInfo = this.mBackgroundTintHelper;
        if (sessionInfo != null) {
            sessionInfo.applySupportBackgroundTint();
        }
    }

    @Override // android.widget.Spinner
    public int getDropDownHorizontalOffset() {
        SpinnerPopup spinnerPopup = this.mPopup;
        return spinnerPopup != null ? spinnerPopup.getHorizontalOffset() : super.getDropDownHorizontalOffset();
    }

    @Override // android.widget.Spinner
    public int getDropDownVerticalOffset() {
        SpinnerPopup spinnerPopup = this.mPopup;
        return spinnerPopup != null ? spinnerPopup.getVerticalOffset() : super.getDropDownVerticalOffset();
    }

    @Override // android.widget.Spinner
    public int getDropDownWidth() {
        return this.mPopup != null ? this.mDropDownWidth : super.getDropDownWidth();
    }

    public final SpinnerPopup getInternalPopup() {
        return this.mPopup;
    }

    @Override // android.widget.Spinner
    public Drawable getPopupBackground() {
        SpinnerPopup spinnerPopup = this.mPopup;
        return spinnerPopup != null ? spinnerPopup.getBackground() : super.getPopupBackground();
    }

    @Override // android.widget.Spinner
    public Context getPopupContext() {
        return this.mPopupContext;
    }

    @Override // android.widget.Spinner
    public CharSequence getPrompt() {
        SpinnerPopup spinnerPopup = this.mPopup;
        return spinnerPopup != null ? spinnerPopup.getHintText() : super.getPrompt();
    }

    public ColorStateList getSupportBackgroundTintList() {
        SessionInfo sessionInfo = this.mBackgroundTintHelper;
        if (sessionInfo != null) {
            return sessionInfo.getSupportBackgroundTintList();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        SessionInfo sessionInfo = this.mBackgroundTintHelper;
        if (sessionInfo != null) {
            return sessionInfo.getSupportBackgroundTintMode();
        }
        return null;
    }

    @Override // android.widget.Spinner, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        SpinnerPopup spinnerPopup = this.mPopup;
        if (spinnerPopup == null || !spinnerPopup.isShowing()) {
            return;
        }
        spinnerPopup.dismiss();
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.mPopup == null || View.MeasureSpec.getMode(i) != Integer.MIN_VALUE) {
            return;
        }
        setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), compatMeasureContentWidth(getAdapter(), getBackground())), View.MeasureSpec.getSize(i)), getMeasuredHeight());
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        ViewTreeObserver viewTreeObserver;
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (!savedState.mShowDropdown || (viewTreeObserver = getViewTreeObserver()) == null) {
            return;
        }
        viewTreeObserver.addOnGlobalLayoutListener(new AnonymousClass2(this, 0));
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public final Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        SpinnerPopup spinnerPopup = this.mPopup;
        savedState.mShowDropdown = spinnerPopup != null && spinnerPopup.isShowing();
        return savedState;
    }

    @Override // android.widget.Spinner, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        AnonymousClass1 anonymousClass1 = this.mForwardingListener;
        if (anonymousClass1 == null || !anonymousClass1.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // android.widget.Spinner, android.view.View
    public final boolean performClick() {
        SpinnerPopup spinnerPopup = this.mPopup;
        if (spinnerPopup == null) {
            return super.performClick();
        }
        if (spinnerPopup.isShowing()) {
            return true;
        }
        this.mPopup.show(getTextDirection(), getTextAlignment());
        return true;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        SessionInfo sessionInfo = this.mBackgroundTintHelper;
        if (sessionInfo != null) {
            sessionInfo.onSetBackgroundDrawable();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        SessionInfo sessionInfo = this.mBackgroundTintHelper;
        if (sessionInfo != null) {
            sessionInfo.onSetBackgroundResource(i);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownHorizontalOffset(int i) {
        SpinnerPopup spinnerPopup = this.mPopup;
        if (spinnerPopup == null) {
            super.setDropDownHorizontalOffset(i);
        } else {
            spinnerPopup.setHorizontalOriginalOffset(i);
            spinnerPopup.setHorizontalOffset(i);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownVerticalOffset(int i) {
        SpinnerPopup spinnerPopup = this.mPopup;
        if (spinnerPopup != null) {
            spinnerPopup.setVerticalOffset(i);
        } else {
            super.setDropDownVerticalOffset(i);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownWidth(int i) {
        if (this.mPopup != null) {
            this.mDropDownWidth = i;
        } else {
            super.setDropDownWidth(i);
        }
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundDrawable(Drawable drawable) {
        SpinnerPopup spinnerPopup = this.mPopup;
        if (spinnerPopup != null) {
            spinnerPopup.setBackgroundDrawable(drawable);
        } else {
            super.setPopupBackgroundDrawable(drawable);
        }
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundResource(int i) {
        setPopupBackgroundDrawable(Headers.Companion.getDrawable(getPopupContext(), i));
    }

    @Override // android.widget.Spinner
    public void setPrompt(CharSequence charSequence) {
        SpinnerPopup spinnerPopup = this.mPopup;
        if (spinnerPopup != null) {
            spinnerPopup.setPromptText(charSequence);
        } else {
            super.setPrompt(charSequence);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        SessionInfo sessionInfo = this.mBackgroundTintHelper;
        if (sessionInfo != null) {
            sessionInfo.setSupportBackgroundTintList(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        SessionInfo sessionInfo = this.mBackgroundTintHelper;
        if (sessionInfo != null) {
            sessionInfo.setSupportBackgroundTintMode(mode);
        }
    }

    @Override // android.widget.AdapterView
    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        if (!this.mPopupSet) {
            this.mTempAdapter = spinnerAdapter;
            return;
        }
        super.setAdapter(spinnerAdapter);
        SpinnerPopup spinnerPopup = this.mPopup;
        if (spinnerPopup != null) {
            Context context = this.mPopupContext;
            if (context == null) {
                context = getContext();
            }
            Resources.Theme theme = context.getTheme();
            DropDownAdapter dropDownAdapter = new DropDownAdapter();
            dropDownAdapter.mAdapter = spinnerAdapter;
            if (spinnerAdapter instanceof ListAdapter) {
                dropDownAdapter.mListAdapter = (ListAdapter) spinnerAdapter;
            }
            if (theme != null && (spinnerAdapter instanceof ThemedSpinnerAdapter)) {
                Api23Impl.setDropDownViewTheme((ThemedSpinnerAdapter) spinnerAdapter, theme);
            }
            spinnerPopup.setAdapter(dropDownAdapter);
        }
    }
}
