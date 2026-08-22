package okhttp3;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Base64;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.ResourceManagerInternal;
import androidx.appcompat.widget.ThemeUtils;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.ColorUtils;
import androidx.lifecycle.hSi.sgtsHsWT;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$$ExternalSyntheticLambda0;
import com.daerisoft.thespikerm.R;
import com.google.android.datatransport.runtime.AutoValue_EventInternal;
import com.google.android.datatransport.runtime.EncodedPayload;
import com.google.android.datatransport.runtime.backends.MetadataBackendRegistry;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.scheduling.DefaultScheduler;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoScheduler;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import com.google.android.gms.ads.internal.client.zzbd;
import com.google.android.gms.ads.internal.util.client.zzo;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzv;
import com.google.android.gms.ads.nonagon.signalgeneration.zzau;
import com.google.android.gms.ads.nonagon.signalgeneration.zzbk;
import com.google.android.gms.auth.IJ.gZrKCJ;
import com.google.android.gms.common.util.concurrent.dN.MnHfHMYQDPUO;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.ads.zzbde;
import com.google.android.gms.internal.ads.zzbex;
import com.google.android.gms.internal.ads.zzbyx;
import com.google.android.gms.internal.ads.zzbze;
import com.google.android.gms.internal.ads.zzfhj;
import com.google.android.gms.internal.ads.zzfhu;
import com.google.android.gms.internal.ads.zzgdj;
import com.google.android.gms.measurement.internal.RVw.ZRqOdXiy;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.firebase.auth.zzaa;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import java.util.concurrent.Executor;
import javax.inject.Provider;
import kotlin.Pair;
import kotlin.collections.EmptyMap;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.jvm.internal.DEXi.JuorMn;
import kotlin.jvm.internal.ArrayIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import okhttp3.internal.Util;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.http2.Http2Connection;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class Request {
    public final /* synthetic */ int $r8$classId;
    public Object body;
    public Object headers;
    public Object lazyCacheControl;
    public Serializable method;
    public Object tags;
    public Object url;

    public final class Builder implements Factory, zzgdj {
        public final /* synthetic */ int $r8$classId;
        public Object body;
        public Object headers;
        public Object method;
        public Object tags;
        public Object url;

        public /* synthetic */ Builder(boolean z) {
            this.$r8$classId = 0;
        }

        public Request build() {
            Map mapUnmodifiableMap;
            HttpUrl httpUrl = (HttpUrl) this.url;
            if (httpUrl == null) {
                throw new IllegalStateException("url == null");
            }
            String str = (String) this.method;
            Headers headersBuild = ((Headers.Builder) this.headers).build();
            RequestBody requestBody = (RequestBody) this.body;
            LinkedHashMap toImmutableMap = (LinkedHashMap) this.tags;
            byte[] bArr = Util.EMPTY_BYTE_ARRAY;
            Intrinsics.checkNotNullParameter(toImmutableMap, "$this$toImmutableMap");
            if (toImmutableMap.isEmpty()) {
                mapUnmodifiableMap = EmptyMap.INSTANCE;
            } else {
                mapUnmodifiableMap = Collections.unmodifiableMap(new LinkedHashMap(toImmutableMap));
                Intrinsics.checkNotNullExpressionValue(mapUnmodifiableMap, "Collections.unmodifiableMap(LinkedHashMap(this))");
            }
            return new Request(httpUrl, str, headersBuild, requestBody, mapUnmodifiableMap);
        }

        @Override // javax.inject.Provider
        public Object get() {
            return new DefaultScheduler((Executor) ((Provider) this.url).get(), (MetadataBackendRegistry) ((Provider) this.method).get(), (JobInfoScheduler) ((zzaa) this.headers).get(), (EventStore) ((Provider) this.body).get(), (SynchronizationGuard) ((Provider) this.tags).get());
        }

        public void header(String str, String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            Headers.Builder builder = (Headers.Builder) this.headers;
            builder.getClass();
            Headers.Companion.checkName(str);
            Headers.Companion.checkValue(value, str);
            builder.removeAll(str);
            builder.addLenient$okhttp(str, value);
        }

        public void method(String method, RequestBody requestBody) {
            Intrinsics.checkNotNullParameter(method, "method");
            if (method.length() <= 0) {
                throw new IllegalArgumentException("method.isEmpty() == true");
            }
            if (requestBody == null) {
                if (method.equals("POST") || method.equals("PUT") || method.equals("PATCH") || method.equals("PROPPATCH") || method.equals("REPORT")) {
                    throw new IllegalArgumentException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("method ", method, " must have a request body.").toString());
                }
            } else if (!RangesKt.permitsRequestBody(method)) {
                throw new IllegalArgumentException(CoroutineAdapterKt$$ExternalSyntheticLambda0.m$1("method ", method, " must not have a request body.").toString());
            }
            this.method = method;
            this.body = requestBody;
        }

        @Override // com.google.android.gms.internal.ads.zzgdj
        public void zza(Throwable th) {
            String message = th.getMessage();
            if (((Boolean) zzbd.zza.zzd.zzb(zzbde.zzia)).booleanValue()) {
                zzv.zza.zzi.zzv(th, "SignalGeneratorImpl.generateSignals");
            } else {
                zzv.zza.zzi.zzw(th, "SignalGeneratorImpl.generateSignals");
            }
            zzfhu zzfhuVarZzs = zzau.zzs((ListenableFuture) this.url, (zzbze) this.method);
            if (((Boolean) zzbex.zze.zze()).booleanValue() && zzfhuVarZzs != null) {
                zzfhj zzfhjVar = (zzfhj) this.body;
                zzfhjVar.zzh(th);
                zzfhjVar.zzg(false);
                zzfhuVarZzs.zza(zzfhjVar);
                zzfhuVarZzs.zzh();
            }
            zzbyx zzbyxVar = (zzbyx) this.headers;
            if (zzbyxVar == null) {
                return;
            }
            try {
                if (!"Unknown format is no longer supported.".equals(message)) {
                    message = "Internal error. " + message;
                }
                zzbyxVar.zzb(message);
            } catch (RemoteException e) {
                int i = zze.$r8$clinit;
                zzo.zzh("", e);
            }
        }

        public Builder(zzau zzauVar, ListenableFuture listenableFuture, zzbze zzbzeVar, zzbyx zzbyxVar, zzfhj zzfhjVar) {
            this.$r8$classId = 3;
            this.url = listenableFuture;
            this.method = zzbzeVar;
            this.headers = zzbyxVar;
            this.body = zzfhjVar;
            Objects.requireNonNull(zzauVar);
            this.tags = zzauVar;
        }

        public String toString() {
            switch (this.$r8$classId) {
                case 1:
                    StringBuilder sb = new StringBuilder();
                    sb.append("FontRequest {mProviderAuthority: " + ((String) this.method) + ZRqOdXiy.RtTMHedHWromJ + ((String) this.url) + ", mQuery: " + ((String) this.headers) + ", mCertificates:");
                    int i = 0;
                    while (true) {
                        List list = (List) this.body;
                        if (i >= list.size()) {
                            sb.append("}mCertificatesArray: 0");
                            return sb.toString();
                        }
                        sb.append(" [");
                        List list2 = (List) list.get(i);
                        for (int i2 = 0; i2 < list2.size(); i2++) {
                            sb.append(" \"");
                            sb.append(Base64.encodeToString((byte[]) list2.get(i2), 0));
                            sb.append("\"");
                        }
                        sb.append(" ]");
                        i++;
                    }
                    break;
                default:
                    return super.toString();
            }
        }

        @Override // com.google.android.gms.internal.ads.zzgdj
        public void zzb(Object obj) {
            zzbk zzbkVar = (zzbk) obj;
            zzfhu zzfhuVarZzs = zzau.zzs((ListenableFuture) this.url, (zzbze) this.method);
            zzau zzauVar = (zzau) this.tags;
            zzauVar.zzG.set(true);
            boolean zBooleanValue = ((Boolean) zzbd.zza.zzd.zzb(zzbde.zzhU)).booleanValue();
            zzbyx zzbyxVar = (zzbyx) this.headers;
            zzfhj zzfhjVar = (zzfhj) this.body;
            if (!zBooleanValue) {
                if (zzbyxVar != null) {
                    try {
                        zzbyxVar.zzb("QueryInfo generation has been disabled.");
                    } catch (RemoteException e) {
                        String strConcat = "QueryInfo generation has been disabled.".concat(e.toString());
                        int i = zze.$r8$clinit;
                        zzo.zzg(strConcat);
                    }
                }
                if (!((Boolean) zzbex.zze.zze()).booleanValue() || zzfhuVarZzs == null) {
                    return;
                }
                zzfhjVar.zzc("QueryInfo generation has been disabled.");
                zzfhjVar.zzg(false);
                zzfhuVarZzs.zza(zzfhjVar);
                zzfhuVarZzs.zzh();
                return;
            }
            try {
                if (zzbkVar == null) {
                    if (zzbyxVar != null) {
                        zzbyxVar.zzc(null, null, null);
                    }
                    zzfhjVar.zzg(true);
                    if (!((Boolean) zzbex.zze.zze()).booleanValue() || zzfhuVarZzs == null) {
                        return;
                    }
                    zzfhuVarZzs.zza(zzfhjVar);
                    zzfhuVarZzs.zzh();
                    return;
                }
                try {
                    String str = zzbkVar.zza;
                    if (TextUtils.isEmpty((!TextUtils.isEmpty(zzbkVar.zzc) ? new JSONObject(zzbkVar.zzc) : new JSONObject(zzbkVar.zzb)).optString("request_id", ""))) {
                        int i2 = zze.$r8$clinit;
                        zzo.zzj("The request ID is empty in request JSON.");
                        if (zzbyxVar != null) {
                            zzbyxVar.zzb(sgtsHsWT.RqxXoBGtW);
                        }
                        zzfhjVar.zzc(MnHfHMYQDPUO.cQE);
                        zzfhjVar.zzg(false);
                        if (!((Boolean) zzbex.zze.zze()).booleanValue() || zzfhuVarZzs == null) {
                            return;
                        }
                        zzfhuVarZzs.zza(zzfhjVar);
                        zzfhuVarZzs.zzh();
                        return;
                    }
                    Bundle bundle = zzbkVar.zzf;
                    boolean z = zzauVar.zzu;
                    String str2 = zzauVar.zzv;
                    String str3 = zzauVar.zzw;
                    if (z && bundle != null && bundle.getInt(str3, -1) == -1) {
                        bundle.putInt(str3, zzauVar.zzx.get());
                    }
                    if (zzauVar.zzt && bundle != null && TextUtils.isEmpty(bundle.getString(str2))) {
                        if (TextUtils.isEmpty(zzauVar.zzz)) {
                            zzauVar.zzz = zzv.zza.zzd.zzc(zzauVar.zzg, zzauVar.zzy.afmaVersion);
                        }
                        bundle.putString(str2, zzauVar.zzz);
                    }
                    if (zzbyxVar != null) {
                        if (TextUtils.isEmpty(zzbkVar.zzc)) {
                            zzbyxVar.zzc(str, zzbkVar.zzb, bundle);
                        } else {
                            zzbyxVar.zzc(str, zzbkVar.zzc, bundle);
                        }
                    }
                    zzfhjVar.zzg(true);
                    if (!((Boolean) zzbex.zze.zze()).booleanValue() || zzfhuVarZzs == null) {
                        return;
                    }
                    zzfhuVarZzs.zza(zzfhjVar);
                    zzfhuVarZzs.zzh();
                } catch (JSONException e2) {
                    int i3 = zze.$r8$clinit;
                    zzo.zzj("Failed to create JSON object from the request string.");
                    if (zzbyxVar != null) {
                        zzbyxVar.zzb("Internal error for request JSON: " + e2.toString());
                    }
                    zzfhjVar.zzh(e2);
                    zzfhjVar.zzg(false);
                    zzv.zza.zzi.zzw(e2, "SignalGeneratorImpl.generateSignals.onSuccess");
                    if (!((Boolean) zzbex.zze.zze()).booleanValue() || zzfhuVarZzs == null) {
                        return;
                    }
                    zzfhuVarZzs.zza(zzfhjVar);
                    zzfhuVarZzs.zzh();
                }
            } catch (RemoteException e3) {
                zzfhjVar.zzh(e3);
                zzfhjVar.zzg(false);
                int i4 = zze.$r8$clinit;
                zzo.zzh("", e3);
                zzv.zza.zzi.zzw(e3, "SignalGeneratorImpl.generateSignals.onSuccess");
            } finally {
                if (((Boolean) zzbex.zze.zze()).booleanValue() && zzfhuVarZzs != null) {
                    zzfhuVarZzs.zza(zzfhjVar);
                    zzfhuVarZzs.zzh();
                }
            }
        }

        public Builder(Provider provider, Provider provider2, zzaa zzaaVar, Provider provider3, Provider provider4) {
            this.$r8$classId = 2;
            this.url = provider;
            this.method = provider2;
            this.headers = zzaaVar;
            this.body = provider3;
            this.tags = provider4;
        }

        public Builder(String str, String str2, String str3, List list) {
            this.$r8$classId = 1;
            str.getClass();
            this.method = str;
            str2.getClass();
            this.url = str2;
            this.headers = str3;
            list.getClass();
            this.body = list;
            this.tags = str + "-" + str2 + "-" + str3;
        }

        public Builder() {
            this.$r8$classId = 0;
            this.tags = new LinkedHashMap();
            this.method = "GET";
            this.headers = new Headers.Builder();
        }
    }

    public Request(Context context, String str) {
        String strConcat;
        this.$r8$classId = 3;
        this.lazyCacheControl = context.getApplicationContext();
        this.method = str;
        this.url = new TreeMap();
        String packageName = context.getPackageName();
        try {
            strConcat = packageName + "-" + Wrappers.packageManager(context).getPackageInfo(0, context.getPackageName()).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            int i = zze.$r8$clinit;
            zzo.zzh("Unable to get package version name for reporting", e);
            strConcat = String.valueOf(packageName).concat("-missing");
        }
        this.tags = strConcat;
    }

    public static boolean arrayContains(int i, int[] iArr) {
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    public static ColorStateList createButtonColorStateList(Context context, int i) {
        int themeAttrColor = ThemeUtils.getThemeAttrColor(context, R.attr.colorControlHighlight);
        return new ColorStateList(new int[][]{ThemeUtils.DISABLED_STATE_SET, ThemeUtils.PRESSED_STATE_SET, ThemeUtils.FOCUSED_STATE_SET, ThemeUtils.EMPTY_STATE_SET}, new int[]{ThemeUtils.getDisabledThemeAttrColor(context, R.attr.colorButtonNormal), ColorUtils.compositeColors(themeAttrColor, i), ColorUtils.compositeColors(themeAttrColor, i), i});
    }

    public static LayerDrawable getRatingBarLayerDrawable(ResourceManagerInternal resourceManagerInternal, Context context, int i) {
        BitmapDrawable bitmapDrawable;
        BitmapDrawable bitmapDrawable2;
        BitmapDrawable bitmapDrawable3;
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(i);
        Drawable drawable = resourceManagerInternal.getDrawable(context, R.drawable.abc_star_black_48dp);
        Drawable drawable2 = resourceManagerInternal.getDrawable(context, R.drawable.abc_star_half_black_48dp);
        if ((drawable instanceof BitmapDrawable) && drawable.getIntrinsicWidth() == dimensionPixelSize && drawable.getIntrinsicHeight() == dimensionPixelSize) {
            bitmapDrawable = (BitmapDrawable) drawable;
            bitmapDrawable2 = new BitmapDrawable(bitmapDrawable.getBitmap());
        } else {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            drawable.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            drawable.draw(canvas);
            bitmapDrawable = new BitmapDrawable(bitmapCreateBitmap);
            bitmapDrawable2 = new BitmapDrawable(bitmapCreateBitmap);
        }
        bitmapDrawable2.setTileModeX(Shader.TileMode.REPEAT);
        if ((drawable2 instanceof BitmapDrawable) && drawable2.getIntrinsicWidth() == dimensionPixelSize && drawable2.getIntrinsicHeight() == dimensionPixelSize) {
            bitmapDrawable3 = (BitmapDrawable) drawable2;
        } else {
            Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
            Canvas canvas2 = new Canvas(bitmapCreateBitmap2);
            drawable2.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            drawable2.draw(canvas2);
            bitmapDrawable3 = new BitmapDrawable(bitmapCreateBitmap2);
        }
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{bitmapDrawable, bitmapDrawable3, bitmapDrawable2});
        layerDrawable.setId(0, android.R.id.background);
        layerDrawable.setId(1, android.R.id.secondaryProgress);
        layerDrawable.setId(2, android.R.id.progress);
        return layerDrawable;
    }

    public static void setPorterDuffColorFilter(Drawable drawable, int i, PorterDuff.Mode mode) {
        PorterDuffColorFilter porterDuffColorFilter;
        Drawable drawableMutate = drawable.mutate();
        if (mode == null) {
            mode = AppCompatDrawableManager.DEFAULT_MODE;
        }
        PorterDuff.Mode mode2 = AppCompatDrawableManager.DEFAULT_MODE;
        synchronized (AppCompatDrawableManager.class) {
            porterDuffColorFilter = ResourceManagerInternal.getPorterDuffColorFilter(i, mode);
        }
        drawableMutate.setColorFilter(porterDuffColorFilter);
    }

    public void addMetadata(String str, String str2) {
        HashMap map = (HashMap) this.tags;
        if (map == null) {
            throw new IllegalStateException("Property \"autoMetadata\" has not been set");
        }
        map.put(str, str2);
    }

    public AutoValue_EventInternal build() {
        String strM = ((String) this.method) == null ? " transportName" : "";
        if (((EncodedPayload) this.url) == null) {
            strM = strM.concat(" encodedPayload");
        }
        if (((Long) this.headers) == null) {
            strM = CoroutineAdapterKt$$ExternalSyntheticLambda0.m(strM, " eventMillis");
        }
        if (((Long) this.body) == null) {
            strM = CoroutineAdapterKt$$ExternalSyntheticLambda0.m(strM, " uptimeMillis");
        }
        if (((HashMap) this.tags) == null) {
            strM = CoroutineAdapterKt$$ExternalSyntheticLambda0.m(strM, " autoMetadata");
        }
        if (strM.isEmpty()) {
            return new AutoValue_EventInternal((String) this.method, (Integer) this.lazyCacheControl, (EncodedPayload) this.url, ((Long) this.headers).longValue(), ((Long) this.body).longValue(), (HashMap) this.tags);
        }
        throw new IllegalStateException("Missing required properties:".concat(strM));
    }

    public ColorStateList getTintListForDrawableRes(Context context, int i) {
        if (i == R.drawable.abc_edit_text_material) {
            return ContextCompat.getColorStateList(context, R.color.abc_tint_edittext);
        }
        if (i == 2131165250) {
            return ContextCompat.getColorStateList(context, R.color.abc_tint_switch_track);
        }
        if (i != R.drawable.abc_switch_thumb_material) {
            if (i == R.drawable.abc_btn_default_mtrl_shape) {
                return createButtonColorStateList(context, ThemeUtils.getThemeAttrColor(context, R.attr.colorButtonNormal));
            }
            if (i == R.drawable.abc_btn_borderless_material) {
                return createButtonColorStateList(context, 0);
            }
            if (i == R.drawable.abc_btn_colored_material) {
                return createButtonColorStateList(context, ThemeUtils.getThemeAttrColor(context, R.attr.colorAccent));
            }
            if (i == 2131165245 || i == R.drawable.abc_spinner_textfield_background_material) {
                return ContextCompat.getColorStateList(context, R.color.abc_tint_spinner);
            }
            if (arrayContains(i, (int[]) this.url)) {
                return ThemeUtils.getThemeAttrColorStateList(context, R.attr.colorControlNormal);
            }
            if (arrayContains(i, (int[]) this.body)) {
                return ContextCompat.getColorStateList(context, R.color.abc_tint_default);
            }
            if (arrayContains(i, (int[]) this.tags)) {
                return ContextCompat.getColorStateList(context, R.color.abc_tint_btn_checkable);
            }
            if (i == R.drawable.abc_seekbar_thumb_material) {
                return ContextCompat.getColorStateList(context, R.color.abc_tint_seek_thumb);
            }
            return null;
        }
        int[][] iArr = new int[3][];
        int[] iArr2 = new int[3];
        ColorStateList themeAttrColorStateList = ThemeUtils.getThemeAttrColorStateList(context, R.attr.colorSwitchThumbNormal);
        if (themeAttrColorStateList == null || !themeAttrColorStateList.isStateful()) {
            iArr[0] = ThemeUtils.DISABLED_STATE_SET;
            iArr2[0] = ThemeUtils.getDisabledThemeAttrColor(context, R.attr.colorSwitchThumbNormal);
            iArr[1] = ThemeUtils.CHECKED_STATE_SET;
            iArr2[1] = ThemeUtils.getThemeAttrColor(context, R.attr.colorControlActivated);
            iArr[2] = ThemeUtils.EMPTY_STATE_SET;
            iArr2[2] = ThemeUtils.getThemeAttrColor(context, R.attr.colorSwitchThumbNormal);
        } else {
            int[] iArr3 = ThemeUtils.DISABLED_STATE_SET;
            iArr[0] = iArr3;
            iArr2[0] = themeAttrColorStateList.getColorForState(iArr3, 0);
            iArr[1] = ThemeUtils.CHECKED_STATE_SET;
            iArr2[1] = ThemeUtils.getThemeAttrColor(context, R.attr.colorControlActivated);
            iArr[2] = ThemeUtils.EMPTY_STATE_SET;
            iArr2[2] = themeAttrColorStateList.getDefaultColor();
        }
        return new ColorStateList(iArr, iArr2);
    }

    public Builder newBuilder() {
        Builder builder = new Builder(false);
        builder.tags = new LinkedHashMap();
        builder.url = (HttpUrl) this.url;
        builder.method = (String) this.method;
        builder.body = (RequestBody) this.body;
        Map map = (Map) this.tags;
        builder.tags = map.isEmpty() ? new LinkedHashMap() : MapsKt__MapsKt.toMutableMap(map);
        builder.headers = ((Headers) this.headers).newBuilder();
        return builder;
    }

    public String toString() {
        switch (this.$r8$classId) {
            case 0:
                StringBuilder sb = new StringBuilder("Request{method=");
                sb.append((String) this.method);
                sb.append(JuorMn.zesehofJMY);
                sb.append((HttpUrl) this.url);
                Headers headers = (Headers) this.headers;
                if (headers.size() != 0) {
                    sb.append(", headers=[");
                    Iterator it = headers.iterator();
                    int i = 0;
                    while (true) {
                        ArrayIterator arrayIterator = (ArrayIterator) it;
                        if (arrayIterator.hasNext()) {
                            Object next = arrayIterator.next();
                            int i2 = i + 1;
                            if (i < 0) {
                                throw new ArithmeticException("Index overflow has happened.");
                            }
                            Pair pair = (Pair) next;
                            String str = (String) pair.first;
                            String str2 = (String) pair.second;
                            if (i > 0) {
                                sb.append(", ");
                            }
                            sb.append(str);
                            sb.append(':');
                            sb.append(str2);
                            i = i2;
                        } else {
                            sb.append(']');
                        }
                    }
                }
                Map map = (Map) this.tags;
                if (!map.isEmpty()) {
                    sb.append(", tags=");
                    sb.append(map);
                }
                sb.append('}');
                String string = sb.toString();
                Intrinsics.checkNotNullExpressionValue(string, gZrKCJ.dvQ);
                return string;
            default:
                return super.toString();
        }
    }

    public Request(HttpUrl url, String method, Headers headers, RequestBody requestBody, Map map) {
        this.$r8$classId = 0;
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(method, "method");
        this.url = url;
        this.method = method;
        this.headers = headers;
        this.body = requestBody;
        this.tags = map;
    }

    /* JADX WARN: Type inference failed for: r4v4, types: [int[], java.io.Serializable] */
    public Request(int i) {
        this.$r8$classId = i;
        switch (i) {
            case 2:
                break;
            default:
                this.lazyCacheControl = new int[]{2131165260, 2131165258, 2131165184};
                this.url = new int[]{2131165208, R.drawable.abc_seekbar_tick_mark_material, R.drawable.abc_ic_menu_share_mtrl_alpha, R.drawable.abc_ic_menu_copy_mtrl_am_alpha, R.drawable.abc_ic_menu_cut_mtrl_alpha, R.drawable.abc_ic_menu_selectall_mtrl_alpha, R.drawable.abc_ic_menu_paste_mtrl_am_alpha};
                this.method = new int[]{2131165257, 2131165259, 2131165201, R.drawable.abc_text_cursor_material, 2131165254, 2131165255, 2131165256};
                this.headers = new int[]{2131165233, R.drawable.abc_cab_background_internal_bg, 2131165232};
                this.body = new int[]{R.drawable.abc_tab_indicator_material, R.drawable.abc_textfield_search_material};
                this.tags = new int[]{R.drawable.abc_btn_check_material, R.drawable.abc_btn_radio_material, R.drawable.abc_btn_check_material_anim, R.drawable.abc_btn_radio_material_anim};
                break;
        }
    }

    public Request(TaskRunner taskRunner) {
        this.$r8$classId = 4;
        Intrinsics.checkNotNullParameter(taskRunner, "taskRunner");
        this.tags = taskRunner;
        this.body = Http2Connection.Listener.REFUSE_INCOMING_STREAMS;
    }
}
