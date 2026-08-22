package androidx.loader.app;

import androidx.collection.SparseArrayCompat;
import androidx.core.internal.view.Oteb.nYVxXTZQ;
import androidx.fragment.app.FragmentManagerViewModel;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStore;
import androidx.loader.content.AsyncTaskLoader$LoadTask;
import com.android.billingclient.api.zzcj;
import com.facebook.appevents.suggestedevents.naLU.DaWYVMJ;
import com.google.android.gms.auth.api.signin.internal.zbc;
import com.google.firebase.auth.zzaa;
import java.io.PrintWriter;
import kotlin.collections.MapsKt__MapsKt;
import kotlinx.coroutines.internal.Jbo.ygoi;

/* JADX INFO: loaded from: classes2.dex */
public final class LoaderManagerImpl extends LoaderManager {
    public final LifecycleOwner mLifecycleOwner;
    public final LoaderViewModel mLoaderViewModel;

    public final class LoaderInfo extends MutableLiveData {
        public LifecycleOwner mLifecycleOwner;
        public final zbc mLoader;
        public zzcj mObserver;

        public LoaderInfo(zbc zbcVar) {
            this.mLoader = zbcVar;
            if (zbcVar.mListener != null) {
                throw new IllegalStateException("There is already a listener registered");
            }
            zbcVar.mListener = this;
        }

        public final void markForRedelivery() {
            LifecycleOwner lifecycleOwner = this.mLifecycleOwner;
            zzcj zzcjVar = this.mObserver;
            if (lifecycleOwner == null || zzcjVar == null) {
                return;
            }
            super.removeObserver(zzcjVar);
            observe(lifecycleOwner, zzcjVar);
        }

        @Override // androidx.lifecycle.LiveData
        public final void onActive() {
            zbc zbcVar = this.mLoader;
            zbcVar.mStarted = true;
            zbcVar.mReset = false;
            zbcVar.mAbandoned = false;
            zbcVar.zba.drainPermits();
            zbcVar.cancelLoad();
            zbcVar.mTask = new AsyncTaskLoader$LoadTask(zbcVar);
            zbcVar.executePendingTask();
        }

        @Override // androidx.lifecycle.LiveData
        public final void onInactive() {
            this.mLoader.mStarted = false;
        }

        @Override // androidx.lifecycle.LiveData
        public final void removeObserver(Observer observer) {
            super.removeObserver(observer);
            this.mLifecycleOwner = null;
            this.mObserver = null;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder(64);
            sb.append(DaWYVMJ.HQFkuBfBShDNNd);
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" #0 : ");
            MapsKt__MapsKt.buildShortClassTag(this.mLoader, sb);
            sb.append("}}");
            return sb.toString();
        }
    }

    /* JADX INFO: loaded from: classes.dex */
    public class LoaderViewModel extends ViewModel {
        public static final FragmentManagerViewModel.AnonymousClass1 FACTORY = new FragmentManagerViewModel.AnonymousClass1(1);
        public final SparseArrayCompat mLoaders = new SparseArrayCompat();
        public boolean mCreatingLoader = false;

        @Override // androidx.lifecycle.ViewModel
        public final void onCleared() {
            SparseArrayCompat sparseArrayCompat = this.mLoaders;
            int i = sparseArrayCompat.mSize;
            for (int i2 = 0; i2 < i; i2++) {
                LoaderInfo loaderInfo = (LoaderInfo) sparseArrayCompat.mValues[i2];
                zbc zbcVar = loaderInfo.mLoader;
                zbcVar.cancelLoad();
                zbcVar.mAbandoned = true;
                zzcj zzcjVar = loaderInfo.mObserver;
                if (zzcjVar != null) {
                    loaderInfo.removeObserver(zzcjVar);
                }
                LoaderInfo loaderInfo2 = zbcVar.mListener;
                if (loaderInfo2 == null) {
                    throw new IllegalStateException("No listener register");
                }
                if (loaderInfo2 != loaderInfo) {
                    throw new IllegalArgumentException("Attempting to unregister the wrong listener");
                }
                zbcVar.mListener = null;
                if (zzcjVar != null) {
                    boolean z = zzcjVar.zza;
                }
                zbcVar.mReset = true;
                zbcVar.mStarted = false;
                zbcVar.mAbandoned = false;
                zbcVar.mContentChanged = false;
            }
            int i3 = sparseArrayCompat.mSize;
            Object[] objArr = sparseArrayCompat.mValues;
            for (int i4 = 0; i4 < i3; i4++) {
                objArr[i4] = null;
            }
            sparseArrayCompat.mSize = 0;
        }
    }

    public LoaderManagerImpl(LifecycleOwner lifecycleOwner, ViewModelStore viewModelStore) {
        this.mLifecycleOwner = lifecycleOwner;
        zzaa zzaaVar = new zzaa(viewModelStore, LoaderViewModel.FACTORY);
        String canonicalName = LoaderViewModel.class.getCanonicalName();
        if (canonicalName == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        }
        this.mLoaderViewModel = (LoaderViewModel) zzaaVar.get(LoaderViewModel.class, "androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(canonicalName));
    }

    public final void dump(String str, PrintWriter printWriter) {
        LoaderViewModel loaderViewModel = this.mLoaderViewModel;
        if (loaderViewModel.mLoaders.mSize <= 0) {
            return;
        }
        printWriter.print(str);
        printWriter.println("Loaders:");
        String str2 = str + "    ";
        int i = 0;
        while (true) {
            SparseArrayCompat sparseArrayCompat = loaderViewModel.mLoaders;
            if (i >= sparseArrayCompat.mSize) {
                return;
            }
            LoaderInfo loaderInfo = (LoaderInfo) sparseArrayCompat.mValues[i];
            printWriter.print(str);
            printWriter.print("  #");
            printWriter.print(loaderViewModel.mLoaders.mKeys[i]);
            printWriter.print(ygoi.nTLXE);
            printWriter.println(loaderInfo.toString());
            printWriter.print(str2);
            printWriter.print("mId=");
            printWriter.print(0);
            printWriter.print(" mArgs=");
            printWriter.println((Object) null);
            printWriter.print(str2);
            printWriter.print("mLoader=");
            printWriter.println(loaderInfo.mLoader);
            zbc zbcVar = loaderInfo.mLoader;
            String str3 = str2 + "  ";
            zbcVar.getClass();
            printWriter.print(str3);
            printWriter.print("mId=");
            printWriter.print(0);
            printWriter.print(" mListener=");
            printWriter.println(zbcVar.mListener);
            if (zbcVar.mStarted || zbcVar.mContentChanged) {
                printWriter.print(str3);
                printWriter.print("mStarted=");
                printWriter.print(zbcVar.mStarted);
                printWriter.print(" mContentChanged=");
                printWriter.print(zbcVar.mContentChanged);
                printWriter.print(" mProcessingChange=");
                printWriter.println(false);
            }
            if (zbcVar.mAbandoned || zbcVar.mReset) {
                printWriter.print(str3);
                printWriter.print("mAbandoned=");
                printWriter.print(zbcVar.mAbandoned);
                printWriter.print(" mReset=");
                printWriter.println(zbcVar.mReset);
            }
            if (zbcVar.mTask != null) {
                printWriter.print(str3);
                printWriter.print("mTask=");
                printWriter.print(zbcVar.mTask);
                printWriter.print(" waiting=");
                zbcVar.mTask.getClass();
                printWriter.println(false);
            }
            if (zbcVar.mCancellingTask != null) {
                printWriter.print(str3);
                printWriter.print("mCancellingTask=");
                printWriter.print(zbcVar.mCancellingTask);
                printWriter.print(" waiting=");
                zbcVar.mCancellingTask.getClass();
                printWriter.println(false);
            }
            if (loaderInfo.mObserver != null) {
                printWriter.print(str2);
                printWriter.print("mCallbacks=");
                printWriter.println(loaderInfo.mObserver);
                zzcj zzcjVar = loaderInfo.mObserver;
                zzcjVar.getClass();
                printWriter.print(str2 + "  ");
                printWriter.print("mDeliveredData=");
                printWriter.println(zzcjVar.zza);
            }
            printWriter.print(str2);
            printWriter.print("mData=");
            zbc zbcVar2 = loaderInfo.mLoader;
            Object obj = loaderInfo.mData;
            Object obj2 = obj != LiveData.NOT_SET ? obj : null;
            zbcVar2.getClass();
            StringBuilder sb = new StringBuilder(64);
            MapsKt__MapsKt.buildShortClassTag(obj2, sb);
            sb.append("}");
            printWriter.println(sb.toString());
            printWriter.print(str2);
            printWriter.print("mStarted=");
            printWriter.println(loaderInfo.mActiveCount > 0);
            i++;
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append(nYVxXTZQ.NHpZsRbvBLhD);
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        MapsKt__MapsKt.buildShortClassTag(this.mLifecycleOwner, sb);
        sb.append("}}");
        return sb.toString();
    }
}
