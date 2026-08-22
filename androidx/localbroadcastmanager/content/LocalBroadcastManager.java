package androidx.localbroadcastmanager.content;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.util.Log;
import androidx.emoji2.text.flatbuffer.bs.bUqMCsuPSX;
import androidx.room.RoomOpenHelper;
import com.facebook.internal.PlatformServiceClient$1;
import com.google.android.gms.appset.vSSa.iafHZUfOuHNwvy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class LocalBroadcastManager {
    public static LocalBroadcastManager mInstance;
    public static final Object mLock = new Object();
    public final Context mAppContext;
    public final PlatformServiceClient$1 mHandler;
    public final HashMap mReceivers = new HashMap();
    public final HashMap mActions = new HashMap();
    public final ArrayList mPendingBroadcasts = new ArrayList();

    public final class ReceiverRecord {
        public boolean broadcasting;
        public boolean dead;
        public final IntentFilter filter;
        public final BroadcastReceiver receiver;

        public ReceiverRecord(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
            this.filter = intentFilter;
            this.receiver = broadcastReceiver;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder(128);
            sb.append("Receiver{");
            sb.append(this.receiver);
            sb.append(" filter=");
            sb.append(this.filter);
            if (this.dead) {
                sb.append(" DEAD");
            }
            sb.append(bUqMCsuPSX.SvDjDDqYNx);
            return sb.toString();
        }
    }

    public LocalBroadcastManager(Context context) {
        this.mAppContext = context;
        this.mHandler = new PlatformServiceClient$1(this, context.getMainLooper());
    }

    public static LocalBroadcastManager getInstance(Context context) {
        LocalBroadcastManager localBroadcastManager;
        synchronized (mLock) {
            try {
                if (mInstance == null) {
                    mInstance = new LocalBroadcastManager(context.getApplicationContext());
                }
                localBroadcastManager = mInstance;
            } catch (Throwable th) {
                throw th;
            }
        }
        return localBroadcastManager;
    }

    public final void registerReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        synchronized (this.mReceivers) {
            try {
                ReceiverRecord receiverRecord = new ReceiverRecord(broadcastReceiver, intentFilter);
                ArrayList arrayList = (ArrayList) this.mReceivers.get(broadcastReceiver);
                if (arrayList == null) {
                    arrayList = new ArrayList(1);
                    this.mReceivers.put(broadcastReceiver, arrayList);
                }
                arrayList.add(receiverRecord);
                for (int i = 0; i < intentFilter.countActions(); i++) {
                    String action = intentFilter.getAction(i);
                    ArrayList arrayList2 = (ArrayList) this.mActions.get(action);
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList(1);
                        this.mActions.put(action, arrayList2);
                    }
                    arrayList2.add(receiverRecord);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void unregisterReceiver(BroadcastReceiver broadcastReceiver) {
        synchronized (this.mReceivers) {
            try {
                ArrayList arrayList = (ArrayList) this.mReceivers.remove(broadcastReceiver);
                if (arrayList == null) {
                    return;
                }
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    ReceiverRecord receiverRecord = (ReceiverRecord) arrayList.get(size);
                    receiverRecord.dead = true;
                    for (int i = 0; i < receiverRecord.filter.countActions(); i++) {
                        String action = receiverRecord.filter.getAction(i);
                        ArrayList arrayList2 = (ArrayList) this.mActions.get(action);
                        if (arrayList2 != null) {
                            for (int size2 = arrayList2.size() - 1; size2 >= 0; size2--) {
                                ReceiverRecord receiverRecord2 = (ReceiverRecord) arrayList2.get(size2);
                                if (receiverRecord2.receiver == broadcastReceiver) {
                                    receiverRecord2.dead = true;
                                    arrayList2.remove(size2);
                                }
                            }
                            if (arrayList2.size() <= 0) {
                                this.mActions.remove(action);
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final boolean sendBroadcast(Intent intent) {
        ArrayList arrayList;
        int i;
        String str;
        boolean z;
        String str2;
        synchronized (this.mReceivers) {
            try {
                String action = intent.getAction();
                String strResolveTypeIfNeeded = intent.resolveTypeIfNeeded(this.mAppContext.getContentResolver());
                Uri data = intent.getData();
                String scheme = intent.getScheme();
                Set<String> categories = intent.getCategories();
                boolean z2 = true;
                boolean z3 = false;
                byte b = (intent.getFlags() & 8) != 0;
                if (b != false) {
                    Log.v("LocalBroadcastManager", "Resolving type " + strResolveTypeIfNeeded + " scheme " + scheme + " of intent " + intent);
                }
                ArrayList arrayList2 = (ArrayList) this.mActions.get(intent.getAction());
                if (arrayList2 != null) {
                    if (b != false) {
                        Log.v("LocalBroadcastManager", "Action list: " + arrayList2);
                    }
                    ArrayList arrayList3 = null;
                    int i2 = 0;
                    while (i2 < arrayList2.size()) {
                        ReceiverRecord receiverRecord = (ReceiverRecord) arrayList2.get(i2);
                        if (b != false) {
                            Log.v("LocalBroadcastManager", "Matching against filter " + receiverRecord.filter);
                        }
                        if (receiverRecord.broadcasting) {
                            if (b != false) {
                                Log.v("LocalBroadcastManager", "  Filter's target already added");
                            }
                            arrayList = arrayList2;
                            i = i2;
                            str = action;
                            z = z2;
                        } else {
                            String str3 = action;
                            arrayList = arrayList2;
                            i = i2;
                            str = action;
                            z = z2;
                            int iMatch = receiverRecord.filter.match(str3, strResolveTypeIfNeeded, scheme, data, categories, "LocalBroadcastManager");
                            if (iMatch >= 0) {
                                if (b != false) {
                                    Log.v("LocalBroadcastManager", iafHZUfOuHNwvy.qNlXCLOhQ + Integer.toHexString(iMatch));
                                }
                                if (arrayList3 == null) {
                                    arrayList3 = new ArrayList();
                                }
                                arrayList3.add(receiverRecord);
                                receiverRecord.broadcasting = z;
                            } else if (b != false) {
                                if (iMatch == -4) {
                                    str2 = "category";
                                } else if (iMatch == -3) {
                                    str2 = "action";
                                } else if (iMatch != -2) {
                                    str2 = iMatch != -1 ? "unknown reason" : "type";
                                } else {
                                    str2 = "data";
                                }
                                Log.v("LocalBroadcastManager", "  Filter did not match: " + str2);
                            }
                        }
                        i2 = i + 1;
                        z2 = z;
                        arrayList2 = arrayList;
                        action = str;
                        z3 = false;
                    }
                    boolean z4 = z2;
                    if (arrayList3 != null) {
                        for (int i3 = 0; i3 < arrayList3.size(); i3++) {
                            ((ReceiverRecord) arrayList3.get(i3)).broadcasting = false;
                        }
                        this.mPendingBroadcasts.add(new RoomOpenHelper(intent, arrayList3, 11, false));
                        if (!this.mHandler.hasMessages(z4 ? 1 : 0)) {
                            this.mHandler.sendEmptyMessage(z4 ? 1 : 0);
                        }
                        return z4;
                    }
                }
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
