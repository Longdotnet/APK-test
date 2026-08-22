package okhttp3;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Base64;
import android.util.JsonWriter;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.SupportActionModeWrapper;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemWrapperICS;
import androidx.appcompat.view.menu.MenuWrapperICS;
import androidx.collection.SimpleArrayMap;
import androidx.core.internal.view.SupportMenuItem;
import androidx.core.os.CancellationSignal;
import androidx.emoji2.text.MetadataRepo$Node;
import androidx.emoji2.text.TypefaceEmojiRasterizer;
import androidx.emoji2.text.flatbuffer.MetadataItem;
import androidx.emoji2.text.flatbuffer.MetadataList;
import androidx.fragment.app.DefaultSpecialEffectsController;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManagerViewModel;
import androidx.fragment.app.FragmentStateManager;
import androidx.fragment.app.SpecialEffectsController$FragmentStateManagerOperation;
import androidx.work.Configuration;
import androidx.work.impl.constraints.trackers.BatteryChargingTracker;
import androidx.work.impl.constraints.trackers.BatteryNotLowTracker;
import androidx.work.impl.constraints.trackers.NetworkStateTracker;
import androidx.work.impl.constraints.trackers.StorageNotLowTracker;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoScheduler;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkInitializer;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import com.google.android.gms.ads.internal.util.client.zzk;
import com.google.android.gms.ads.internal.util.client.zzl;
import com.google.android.gms.ads.jY.UUFMQdNK;
import com.google.android.gms.measurement.internal.zzeh;
import com.google.android.gms.measurement.internal.zzew;
import com.google.android.gms.measurement.internal.zzfr;
import com.google.firebase.auth.zzaa;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.inject.Provider;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;
import okhttp3.internal.connection.ExchangeFinder;
import okhttp3.internal.connection.RealCall;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http2.ConnectionShutdownException;
import okhttp3.internal.http2.StreamResetException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class Dispatcher implements ActionMode.Callback, CancellationSignal.OnCancelListener, Factory, zzk {
    public static Dispatcher sInstance;
    public Object executorServiceOrNull;
    public Object readyAsyncCalls;
    public Object runningAsyncCalls;
    public Object runningSyncCalls;

    public /* synthetic */ Dispatcher(Object obj, Object obj2, Object obj3, Object obj4) {
        this.executorServiceOrNull = obj;
        this.readyAsyncCalls = obj2;
        this.runningAsyncCalls = obj3;
        this.runningSyncCalls = obj4;
    }

    public static synchronized Dispatcher getInstance(Context context, TaskExecutor taskExecutor) {
        try {
            if (sInstance == null) {
                Dispatcher dispatcher = new Dispatcher();
                Context applicationContext = context.getApplicationContext();
                dispatcher.executorServiceOrNull = new BatteryChargingTracker(applicationContext, taskExecutor);
                dispatcher.readyAsyncCalls = new BatteryNotLowTracker(applicationContext, taskExecutor);
                dispatcher.runningAsyncCalls = new NetworkStateTracker(applicationContext, taskExecutor);
                dispatcher.runningSyncCalls = new StorageNotLowTracker(applicationContext, taskExecutor);
                sInstance = dispatcher;
            }
        } catch (Throwable th) {
            throw th;
        }
        return sInstance;
    }

    public IOException bodyComplete(boolean z, boolean z2, IOException iOException) {
        if (iOException != null) {
            trackFailure(iOException);
        }
        RealCall call = (RealCall) this.readyAsyncCalls;
        if (z2) {
            if (iOException != null) {
                Intrinsics.checkNotNullParameter(call, "call");
            } else {
                Intrinsics.checkNotNullParameter(call, "call");
            }
        }
        if (z) {
            if (iOException != null) {
                Intrinsics.checkNotNullParameter(call, "call");
            } else {
                Intrinsics.checkNotNullParameter(call, "call");
            }
        }
        return call.messageDone$okhttp(this, z2, z, iOException);
    }

    public synchronized void executorService() {
        try {
            if (((ThreadPoolExecutor) this.executorServiceOrNull) == null) {
                TimeUnit timeUnit = TimeUnit.SECONDS;
                SynchronousQueue synchronousQueue = new SynchronousQueue();
                String name = Util.okHttpName + " Dispatcher";
                Intrinsics.checkNotNullParameter(name, "name");
                this.executorServiceOrNull = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, timeUnit, synchronousQueue, new Configuration.AnonymousClass1(name, false));
            }
            Intrinsics.checkNotNull((ThreadPoolExecutor) this.executorServiceOrNull);
        } catch (Throwable th) {
            throw th;
        }
    }

    public Fragment findActiveFragment(String str) {
        FragmentStateManager fragmentStateManager = (FragmentStateManager) ((HashMap) this.readyAsyncCalls).get(str);
        if (fragmentStateManager != null) {
            return fragmentStateManager.mFragment;
        }
        return null;
    }

    public Fragment findFragmentByWho(String str) {
        for (FragmentStateManager fragmentStateManager : ((HashMap) this.readyAsyncCalls).values()) {
            if (fragmentStateManager != null) {
                Fragment fragmentFindFragmentByWho = fragmentStateManager.mFragment;
                if (!str.equals(fragmentFindFragmentByWho.mWho)) {
                    fragmentFindFragmentByWho = fragmentFindFragmentByWho.mChildFragmentManager.mFragmentStore.findFragmentByWho(str);
                }
                if (fragmentFindFragmentByWho != null) {
                    return fragmentFindFragmentByWho;
                }
            }
        }
        return null;
    }

    public void finished$okhttp(RealCall realCall) {
        ArrayDeque arrayDeque = (ArrayDeque) this.runningSyncCalls;
        synchronized (this) {
            if (!arrayDeque.remove(realCall)) {
                throw new AssertionError("Call wasn't in-flight!");
            }
        }
        promoteAndExecute();
    }

    @Override // javax.inject.Provider
    public Object get() {
        return new WorkInitializer((Executor) ((Provider) this.executorServiceOrNull).get(), (EventStore) ((Provider) this.readyAsyncCalls).get(), (JobInfoScheduler) ((zzaa) this.runningAsyncCalls).get(), (SynchronizationGuard) ((Provider) this.runningSyncCalls).get());
    }

    public SupportActionModeWrapper getActionModeWrapper(ActionMode actionMode) {
        ArrayList arrayList = (ArrayList) this.runningAsyncCalls;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            SupportActionModeWrapper supportActionModeWrapper = (SupportActionModeWrapper) arrayList.get(i);
            if (supportActionModeWrapper != null && supportActionModeWrapper.mWrappedObject == actionMode) {
                return supportActionModeWrapper;
            }
        }
        SupportActionModeWrapper supportActionModeWrapper2 = new SupportActionModeWrapper((Context) this.readyAsyncCalls, actionMode);
        arrayList.add(supportActionModeWrapper2);
        return supportActionModeWrapper2;
    }

    public ArrayList getActiveFragmentStateManagers() {
        ArrayList arrayList = new ArrayList();
        for (FragmentStateManager fragmentStateManager : ((HashMap) this.readyAsyncCalls).values()) {
            if (fragmentStateManager != null) {
                arrayList.add(fragmentStateManager);
            }
        }
        return arrayList;
    }

    public ArrayList getActiveFragments() {
        ArrayList arrayList = new ArrayList();
        for (FragmentStateManager fragmentStateManager : ((HashMap) this.readyAsyncCalls).values()) {
            if (fragmentStateManager != null) {
                arrayList.add(fragmentStateManager.mFragment);
            } else {
                arrayList.add(null);
            }
        }
        return arrayList;
    }

    public List getFragments() {
        ArrayList arrayList;
        if (((ArrayList) this.executorServiceOrNull).isEmpty()) {
            return Collections.emptyList();
        }
        synchronized (((ArrayList) this.executorServiceOrNull)) {
            arrayList = new ArrayList((ArrayList) this.executorServiceOrNull);
        }
        return arrayList;
    }

    public void makeActive(FragmentStateManager fragmentStateManager) {
        Fragment fragment = fragmentStateManager.mFragment;
        String str = fragment.mWho;
        HashMap map = (HashMap) this.readyAsyncCalls;
        if (map.get(str) != null) {
            return;
        }
        map.put(fragment.mWho, fragmentStateManager);
        if (fragment.mRetainInstanceChangedWhileDetached) {
            if (fragment.mRetainInstance) {
                ((FragmentManagerViewModel) this.runningSyncCalls).addRetainedFragment(fragment);
            } else {
                ((FragmentManagerViewModel) this.runningSyncCalls).removeRetainedFragment(fragment);
            }
            fragment.mRetainInstanceChangedWhileDetached = false;
        }
        if (Log.isLoggable("FragmentManager", 2)) {
            Log.v("FragmentManager", "Added fragment to active set " + fragment);
        }
    }

    public void makeInactive(FragmentStateManager fragmentStateManager) {
        Fragment fragment = fragmentStateManager.mFragment;
        if (fragment.mRetainInstance) {
            ((FragmentManagerViewModel) this.runningSyncCalls).removeRetainedFragment(fragment);
        }
        if (((FragmentStateManager) ((HashMap) this.readyAsyncCalls).put(fragment.mWho, null)) != null && Log.isLoggable("FragmentManager", 2)) {
            Log.v("FragmentManager", "Removed fragment from active set " + fragment);
        }
    }

    @Override // androidx.appcompat.view.ActionMode.Callback
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return ((android.view.ActionMode.Callback) this.executorServiceOrNull).onActionItemClicked(getActionModeWrapper(actionMode), new MenuItemWrapperICS((Context) this.readyAsyncCalls, (SupportMenuItem) menuItem));
    }

    @Override // androidx.core.os.CancellationSignal.OnCancelListener
    public void onCancel() {
        View view = (View) this.executorServiceOrNull;
        view.clearAnimation();
        ((ViewGroup) this.readyAsyncCalls).endViewTransition(view);
        ((DefaultSpecialEffectsController.AnimationInfo) this.runningAsyncCalls).completeSpecialEffect();
        if (Log.isLoggable("FragmentManager", 2)) {
            Log.v("FragmentManager", "Animation from operation " + ((SpecialEffectsController$FragmentStateManagerOperation) this.runningSyncCalls) + " has been cancelled.");
        }
    }

    @Override // androidx.appcompat.view.ActionMode.Callback
    public boolean onCreateActionMode(ActionMode actionMode, MenuBuilder menuBuilder) {
        SupportActionModeWrapper actionModeWrapper = getActionModeWrapper(actionMode);
        SimpleArrayMap simpleArrayMap = (SimpleArrayMap) this.runningSyncCalls;
        Menu menuWrapperICS = (Menu) simpleArrayMap.getOrDefault(menuBuilder, null);
        if (menuWrapperICS == null) {
            menuWrapperICS = new MenuWrapperICS((Context) this.readyAsyncCalls, menuBuilder);
            simpleArrayMap.put(menuBuilder, menuWrapperICS);
        }
        return ((android.view.ActionMode.Callback) this.executorServiceOrNull).onCreateActionMode(actionModeWrapper, menuWrapperICS);
    }

    @Override // androidx.appcompat.view.ActionMode.Callback
    public void onDestroyActionMode(ActionMode actionMode) {
        ((android.view.ActionMode.Callback) this.executorServiceOrNull).onDestroyActionMode(getActionModeWrapper(actionMode));
    }

    @Override // androidx.appcompat.view.ActionMode.Callback
    public boolean onPrepareActionMode(ActionMode actionMode, MenuBuilder menuBuilder) {
        SupportActionModeWrapper actionModeWrapper = getActionModeWrapper(actionMode);
        SimpleArrayMap simpleArrayMap = (SimpleArrayMap) this.runningSyncCalls;
        Menu menuWrapperICS = (Menu) simpleArrayMap.getOrDefault(menuBuilder, null);
        if (menuWrapperICS == null) {
            menuWrapperICS = new MenuWrapperICS((Context) this.readyAsyncCalls, menuBuilder);
            simpleArrayMap.put(menuBuilder, menuWrapperICS);
        }
        return ((android.view.ActionMode.Callback) this.executorServiceOrNull).onPrepareActionMode(actionModeWrapper, menuWrapperICS);
    }

    public void promoteAndExecute() {
        byte[] bArr = Util.EMPTY_BYTE_ARRAY;
        ArrayList arrayList = new ArrayList();
        synchronized (this) {
            try {
                Iterator it = ((ArrayDeque) this.readyAsyncCalls).iterator();
                Intrinsics.checkNotNullExpressionValue(it, "readyAsyncCalls.iterator()");
                if (it.hasNext()) {
                    if (it.next() != null) {
                        throw new ClassCastException();
                    }
                    if (((ArrayDeque) this.runningAsyncCalls).size() < 64) {
                        throw null;
                    }
                }
                runningCallsCount();
            } catch (Throwable th) {
                throw th;
            }
        }
        if (arrayList.size() <= 0) {
            return;
        }
        if (arrayList.get(0) != null) {
            throw new ClassCastException();
        }
        executorService();
        throw null;
    }

    public Response.Builder readResponseHeaders(boolean z) throws IOException {
        try {
            Response.Builder responseHeaders = ((ExchangeCodec) this.runningSyncCalls).readResponseHeaders(z);
            if (responseHeaders != null) {
                responseHeaders.exchange = this;
            }
            return responseHeaders;
        } catch (IOException e) {
            RealCall call = (RealCall) this.readyAsyncCalls;
            Intrinsics.checkNotNullParameter(call, "call");
            trackFailure(e);
            throw e;
        }
    }

    public synchronized int runningCallsCount() {
        return ((ArrayDeque) this.runningAsyncCalls).size() + ((ArrayDeque) this.runningSyncCalls).size();
    }

    public void trackFailure(IOException iOException) {
        ((ExchangeFinder) this.runningAsyncCalls).trackFailure(iOException);
        RealConnection connection = ((ExchangeCodec) this.runningSyncCalls).getConnection();
        RealCall call = (RealCall) this.readyAsyncCalls;
        synchronized (connection) {
            try {
                Intrinsics.checkNotNullParameter(call, "call");
                if (!(iOException instanceof StreamResetException)) {
                    if (!(connection.http2Connection != null) || (iOException instanceof ConnectionShutdownException)) {
                        connection.noNewExchanges = true;
                        if (connection.successCount == 0) {
                            RealConnection.connectFailed$okhttp(call.client, connection.route, iOException);
                            connection.routeFailureCount++;
                        }
                    }
                } else if (((StreamResetException) iOException).errorCode == 8) {
                    int i = connection.refusedStreamCount + 1;
                    connection.refusedStreamCount = i;
                    if (i > 1) {
                        connection.noNewExchanges = true;
                        connection.routeFailureCount++;
                    }
                } else if (((StreamResetException) iOException).errorCode != 9 || !call.canceled) {
                    connection.noNewExchanges = true;
                    connection.routeFailureCount++;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:27:0x006e  */
    public Bundle zza() {
        byte b;
        if (((Bundle) this.runningAsyncCalls) == null) {
            zzew zzewVar = (zzew) this.runningSyncCalls;
            String string = zzewVar.zza().getString((String) this.executorServiceOrNull, null);
            if (string != null) {
                try {
                    Bundle bundle = new Bundle();
                    JSONArray jSONArray = new JSONArray(string);
                    for (int i = 0; i < jSONArray.length(); i++) {
                        try {
                            JSONObject jSONObject = jSONArray.getJSONObject(i);
                            String string2 = jSONObject.getString("n");
                            String string3 = jSONObject.getString("t");
                            int iHashCode = string3.hashCode();
                            if (iHashCode != 100) {
                                if (iHashCode != 108) {
                                    if (iHashCode == 115 && string3.equals("s")) {
                                        b = 0;
                                    } else {
                                        b = -1;
                                    }
                                } else if (string3.equals("l")) {
                                    b = 2;
                                } else {
                                    b = -1;
                                }
                            } else if (string3.equals("d")) {
                                b = 1;
                            } else {
                                b = -1;
                            }
                            if (b == 0) {
                                bundle.putString(string2, jSONObject.getString("v"));
                            } else if (b == 1) {
                                bundle.putDouble(string2, Double.parseDouble(jSONObject.getString("v")));
                            } else if (b != 2) {
                                zzeh zzehVar = ((zzfr) zzewVar.mBuilder).zzm;
                                zzfr.zzR(zzehVar);
                                zzehVar.zzd.zzb(string3, "Unrecognized persisted bundle type. Type");
                            } else {
                                bundle.putLong(string2, Long.parseLong(jSONObject.getString("v")));
                            }
                        } catch (NumberFormatException | JSONException unused) {
                            zzeh zzehVar2 = ((zzfr) zzewVar.mBuilder).zzm;
                            zzfr.zzR(zzehVar2);
                            zzehVar2.zzd.zza("Error reading value from SharedPreferences. Value dropped");
                        }
                    }
                    this.runningAsyncCalls = bundle;
                } catch (JSONException unused2) {
                    zzeh zzehVar3 = ((zzfr) zzewVar.mBuilder).zzm;
                    zzfr.zzR(zzehVar3);
                    zzehVar3.zzd.zza("Error loading bundle from SharedPreferences. Values will be lost");
                }
            }
            if (((Bundle) this.runningAsyncCalls) == null) {
                this.runningAsyncCalls = (Bundle) this.readyAsyncCalls;
            }
        }
        return (Bundle) this.runningAsyncCalls;
    }

    public void zzb(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        zzew zzewVar = (zzew) this.runningSyncCalls;
        SharedPreferences.Editor editorEdit = zzewVar.zza().edit();
        int size = bundle.size();
        String str = (String) this.executorServiceOrNull;
        if (size == 0) {
            editorEdit.remove(str);
        } else {
            JSONArray jSONArray = new JSONArray();
            for (String str2 : bundle.keySet()) {
                Object obj = bundle.get(str2);
                if (obj != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("n", str2);
                        jSONObject.put("v", obj.toString());
                        if (obj instanceof String) {
                            jSONObject.put("t", "s");
                        } else if (obj instanceof Long) {
                            jSONObject.put("t", "l");
                        } else if (obj instanceof Double) {
                            jSONObject.put("t", "d");
                        } else {
                            zzeh zzehVar = ((zzfr) zzewVar.mBuilder).zzm;
                            zzfr.zzR(zzehVar);
                            zzehVar.zzd.zzb(obj.getClass(), "Cannot serialize bundle value to SharedPreferences. Type");
                        }
                        jSONArray.put(jSONObject);
                    } catch (JSONException e) {
                        zzeh zzehVar2 = ((zzfr) zzewVar.mBuilder).zzm;
                        zzfr.zzR(zzehVar2);
                        zzehVar2.zzd.zzb(e, "Cannot serialize bundle value to SharedPreferences");
                    }
                }
            }
            editorEdit.putString(str, jSONArray.toString());
        }
        editorEdit.apply();
        this.runningAsyncCalls = bundle;
    }

    public Dispatcher(int i) {
        switch (i) {
            case 6:
                this.executorServiceOrNull = new ArrayList();
                this.readyAsyncCalls = new HashMap();
                this.runningAsyncCalls = new HashMap();
                break;
            default:
                this.readyAsyncCalls = new ArrayDeque();
                this.runningAsyncCalls = new ArrayDeque();
                this.runningSyncCalls = new ArrayDeque();
                break;
        }
    }

    public void addFragment(Fragment fragment) {
        if (((ArrayList) this.executorServiceOrNull).contains(fragment)) {
            throw new IllegalStateException(UUFMQdNK.CKYHyxPqAzqJyLe + fragment);
        }
        synchronized (((ArrayList) this.executorServiceOrNull)) {
            ((ArrayList) this.executorServiceOrNull).add(fragment);
        }
        fragment.mAdded = true;
    }

    public Dispatcher(Typeface typeface, MetadataList metadataList) {
        int i;
        int i2;
        this.runningSyncCalls = typeface;
        this.executorServiceOrNull = metadataList;
        this.runningAsyncCalls = new MetadataRepo$Node(1024);
        int i__offset = metadataList.__offset(6);
        if (i__offset != 0) {
            int i3 = i__offset + metadataList.bb_pos;
            i = ((ByteBuffer) metadataList.bb).getInt(((ByteBuffer) metadataList.bb).getInt(i3) + i3);
        } else {
            i = 0;
        }
        this.readyAsyncCalls = new char[i * 2];
        int i__offset2 = metadataList.__offset(6);
        if (i__offset2 != 0) {
            int i4 = i__offset2 + metadataList.bb_pos;
            i2 = ((ByteBuffer) metadataList.bb).getInt(((ByteBuffer) metadataList.bb).getInt(i4) + i4);
        } else {
            i2 = 0;
        }
        for (int i5 = 0; i5 < i2; i5++) {
            TypefaceEmojiRasterizer typefaceEmojiRasterizer = new TypefaceEmojiRasterizer(this, i5);
            MetadataItem metadataItem = typefaceEmojiRasterizer.getMetadataItem();
            int i__offset3 = metadataItem.__offset(4);
            Character.toChars(i__offset3 != 0 ? ((ByteBuffer) metadataItem.bb).getInt(i__offset3 + metadataItem.bb_pos) : 0, (char[]) this.readyAsyncCalls, i5 * 2);
            if (typefaceEmojiRasterizer.getCodepointsLength() > 0) {
                ((MetadataRepo$Node) this.runningAsyncCalls).put(typefaceEmojiRasterizer, 0, typefaceEmojiRasterizer.getCodepointsLength() - 1);
            } else {
                throw new IllegalArgumentException("invalid metadata codepoint length");
            }
        }
    }

    @Override // com.google.android.gms.ads.internal.util.client.zzk
    public void zza(JsonWriter jsonWriter) throws IOException {
        jsonWriter.name("params").beginObject();
        jsonWriter.name("firstline").beginObject();
        jsonWriter.name("uri").value((String) this.executorServiceOrNull);
        jsonWriter.name("verb").value((String) this.readyAsyncCalls);
        jsonWriter.endObject();
        zzl.zzr(jsonWriter, (Map) this.runningAsyncCalls);
        byte[] bArr = (byte[]) this.runningSyncCalls;
        if (bArr != null) {
            jsonWriter.name("body").value(Base64.encodeToString(bArr, 0));
        }
        jsonWriter.endObject();
    }
}
