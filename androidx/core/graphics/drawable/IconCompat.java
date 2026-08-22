package androidx.core.graphics.drawable;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.versionedparcelable.CustomVersionedParcelable;
import com.google.android.finsky.externalreferrer.jUdg.RDFWIi;
import com.google.android.gms.internal.common.Ko.TSDAbK;
import com.google.android.gms.signin.internal.FVfQ.GsPcpBmONXh;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes2.dex */
public class IconCompat extends CustomVersionedParcelable {
    public static final PorterDuff.Mode DEFAULT_TINT_MODE = PorterDuff.Mode.SRC_IN;
    public byte[] mData;
    public int mInt1;
    public int mInt2;
    public Object mObj1;
    public Parcelable mParcelable;
    public String mString1;
    public ColorStateList mTintList;
    public PorterDuff.Mode mTintMode;
    public String mTintModeStr;
    public int mType;

    /* JADX INFO: loaded from: classes.dex */
    public abstract class Api23Impl {
        public static Uri getUri(Object obj) {
            if (Build.VERSION.SDK_INT >= 28) {
                return Api28Impl.getUri(obj);
            }
            try {
                return (Uri) obj.getClass().getMethod("getUri", null).invoke(obj, null);
            } catch (IllegalAccessException e) {
                Log.e("IconCompat", "Unable to get icon uri", e);
                return null;
            } catch (NoSuchMethodException e2) {
                Log.e("IconCompat", "Unable to get icon uri", e2);
                return null;
            } catch (InvocationTargetException e3) {
                Log.e("IconCompat", "Unable to get icon uri", e3);
                return null;
            }
        }

        public static Drawable loadDrawable(Icon icon, Context context) {
            return icon.loadDrawable(context);
        }

        public static Icon toIcon(IconCompat iconCompat, Context context) {
            Icon iconCreateWithBitmap;
            int i = iconCompat.mType;
            String resPackage = null;
            inputStreamOpenInputStream = null;
            InputStream inputStreamOpenInputStream = null;
            resPackage = null;
            resPackage = null;
            switch (i) {
                case -1:
                    return (Icon) iconCompat.mObj1;
                case 0:
                default:
                    throw new IllegalArgumentException("Unknown type");
                case 1:
                    iconCreateWithBitmap = Icon.createWithBitmap((Bitmap) iconCompat.mObj1);
                    break;
                case 2:
                    if (i == -1) {
                        int i2 = Build.VERSION.SDK_INT;
                        Object obj = iconCompat.mObj1;
                        if (i2 >= 28) {
                            resPackage = Api28Impl.getResPackage(obj);
                        } else {
                            try {
                                resPackage = (String) obj.getClass().getMethod("getResPackage", null).invoke(obj, null);
                            } catch (IllegalAccessException e) {
                                Log.e("IconCompat", "Unable to get icon package", e);
                            } catch (NoSuchMethodException e2) {
                                Log.e("IconCompat", "Unable to get icon package", e2);
                            } catch (InvocationTargetException e3) {
                                Log.e("IconCompat", "Unable to get icon package", e3);
                            }
                        }
                    } else {
                        if (i != 2) {
                            throw new IllegalStateException("called getResPackage() on " + iconCompat);
                        }
                        String str = iconCompat.mString1;
                        resPackage = (str == null || TextUtils.isEmpty(str)) ? ((String) iconCompat.mObj1).split(":", -1)[0] : iconCompat.mString1;
                    }
                    iconCreateWithBitmap = Icon.createWithResource(resPackage, iconCompat.mInt1);
                    break;
                case 3:
                    iconCreateWithBitmap = Icon.createWithData((byte[]) iconCompat.mObj1, iconCompat.mInt1, iconCompat.mInt2);
                    break;
                case 4:
                    iconCreateWithBitmap = Icon.createWithContentUri((String) iconCompat.mObj1);
                    break;
                case 5:
                    iconCreateWithBitmap = Build.VERSION.SDK_INT < 26 ? Icon.createWithBitmap(IconCompat.createLegacyIconFromAdaptiveIcon((Bitmap) iconCompat.mObj1, false)) : Api26Impl.createWithAdaptiveBitmap((Bitmap) iconCompat.mObj1);
                    break;
                case 6:
                    if (Build.VERSION.SDK_INT >= 30) {
                        iconCreateWithBitmap = Api30Impl.createWithAdaptiveBitmapContentUri(iconCompat.getUri());
                    } else {
                        if (context == null) {
                            throw new IllegalArgumentException("Context is required to resolve the file uri of the icon: " + iconCompat.getUri());
                        }
                        Uri uri = iconCompat.getUri();
                        String scheme = uri.getScheme();
                        if (FirebaseAnalytics.Param.CONTENT.equals(scheme) || "file".equals(scheme)) {
                            try {
                                inputStreamOpenInputStream = context.getContentResolver().openInputStream(uri);
                            } catch (Exception e4) {
                                Log.w("IconCompat", "Unable to load image from URI: " + uri, e4);
                            }
                            break;
                        } else {
                            try {
                                inputStreamOpenInputStream = new FileInputStream(new File((String) iconCompat.mObj1));
                            } catch (FileNotFoundException e5) {
                                Log.w("IconCompat", "Unable to load image from path: " + uri, e5);
                            }
                        }
                        if (inputStreamOpenInputStream == null) {
                            throw new IllegalStateException("Cannot load adaptive icon from uri: " + iconCompat.getUri());
                        }
                        if (Build.VERSION.SDK_INT < 26) {
                            iconCreateWithBitmap = Icon.createWithBitmap(IconCompat.createLegacyIconFromAdaptiveIcon(BitmapFactory.decodeStream(inputStreamOpenInputStream), false));
                        } else {
                            iconCreateWithBitmap = Api26Impl.createWithAdaptiveBitmap(BitmapFactory.decodeStream(inputStreamOpenInputStream));
                        }
                    }
                    break;
            }
            ColorStateList colorStateList = iconCompat.mTintList;
            if (colorStateList != null) {
                iconCreateWithBitmap.setTintList(colorStateList);
            }
            PorterDuff.Mode mode = iconCompat.mTintMode;
            if (mode != IconCompat.DEFAULT_TINT_MODE) {
                iconCreateWithBitmap.setTintMode(mode);
            }
            return iconCreateWithBitmap;
        }
    }

    /* JADX INFO: loaded from: classes.dex */
    public abstract class Api26Impl {
        public static Drawable createAdaptiveIconDrawable(Drawable drawable, Drawable drawable2) {
            return new AdaptiveIconDrawable(drawable, drawable2);
        }

        public static Icon createWithAdaptiveBitmap(Bitmap bitmap) {
            return Icon.createWithAdaptiveBitmap(bitmap);
        }
    }

    /* JADX INFO: loaded from: classes.dex */
    public abstract class Api28Impl {
        public static int getResId(Object obj) {
            return ((Icon) obj).getResId();
        }

        public static String getResPackage(Object obj) {
            return ((Icon) obj).getResPackage();
        }

        public static int getType(Object obj) {
            return ((Icon) obj).getType();
        }

        public static Uri getUri(Object obj) {
            return ((Icon) obj).getUri();
        }
    }

    /* JADX INFO: loaded from: classes.dex */
    public abstract class Api30Impl {
        public static Icon createWithAdaptiveBitmapContentUri(Uri uri) {
            return Icon.createWithAdaptiveBitmapContentUri(uri);
        }
    }

    public IconCompat() {
        this.mType = -1;
        this.mData = null;
        this.mParcelable = null;
        this.mInt1 = 0;
        this.mInt2 = 0;
        this.mTintList = null;
        this.mTintMode = DEFAULT_TINT_MODE;
        this.mTintModeStr = null;
    }

    public static Bitmap createLegacyIconFromAdaptiveIcon(Bitmap bitmap, boolean z) {
        int iMin = (int) (Math.min(bitmap.getWidth(), bitmap.getHeight()) * 0.6666667f);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iMin, iMin, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint(3);
        float f = iMin;
        float f2 = 0.5f * f;
        float f3 = 0.9166667f * f2;
        if (z) {
            float f4 = 0.010416667f * f;
            paint.setColor(0);
            paint.setShadowLayer(f4, 0.0f, f * 0.020833334f, 1023410176);
            canvas.drawCircle(f2, f2, f3, paint);
            paint.setShadowLayer(f4, 0.0f, 0.0f, 503316480);
            canvas.drawCircle(f2, f2, f3, paint);
            paint.clearShadowLayer();
        }
        paint.setColor(-16777216);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        Matrix matrix = new Matrix();
        matrix.setTranslate((-(bitmap.getWidth() - iMin)) / 2.0f, (-(bitmap.getHeight() - iMin)) / 2.0f);
        bitmapShader.setLocalMatrix(matrix);
        paint.setShader(bitmapShader);
        canvas.drawCircle(f2, f2, f3, paint);
        canvas.setBitmap(null);
        return bitmapCreateBitmap;
    }

    public static IconCompat createWithResource(int i) {
        if (i == 0) {
            throw new IllegalArgumentException("Drawable resource ID must not be 0");
        }
        IconCompat iconCompat = new IconCompat(2);
        iconCompat.mInt1 = i;
        iconCompat.mObj1 = "";
        iconCompat.mString1 = "";
        return iconCompat;
    }

    public final int getResId() {
        int i = this.mType;
        if (i != -1) {
            if (i == 2) {
                return this.mInt1;
            }
            throw new IllegalStateException("called getResId() on " + this);
        }
        int i2 = Build.VERSION.SDK_INT;
        Object obj = this.mObj1;
        if (i2 >= 28) {
            return Api28Impl.getResId(obj);
        }
        try {
            return ((Integer) obj.getClass().getMethod("getResId", null).invoke(obj, null)).intValue();
        } catch (IllegalAccessException e) {
            Log.e("IconCompat", "Unable to get icon resource", e);
            return 0;
        } catch (NoSuchMethodException e2) {
            Log.e("IconCompat", "Unable to get icon resource", e2);
            return 0;
        } catch (InvocationTargetException e3) {
            Log.e("IconCompat", "Unable to get icon resource", e3);
            return 0;
        }
    }

    public final int getType() {
        int i = this.mType;
        if (i != -1) {
            return i;
        }
        int i2 = Build.VERSION.SDK_INT;
        Object obj = this.mObj1;
        if (i2 >= 28) {
            return Api28Impl.getType(obj);
        }
        try {
            return ((Integer) obj.getClass().getMethod("getType", null).invoke(obj, null)).intValue();
        } catch (IllegalAccessException e) {
            Log.e("IconCompat", "Unable to get icon type " + obj, e);
            return -1;
        } catch (NoSuchMethodException e2) {
            Log.e("IconCompat", "Unable to get icon type " + obj, e2);
            return -1;
        } catch (InvocationTargetException e3) {
            Log.e("IconCompat", "Unable to get icon type " + obj, e3);
            return -1;
        }
    }

    public final Uri getUri() {
        int i = this.mType;
        if (i == -1) {
            return Api23Impl.getUri(this.mObj1);
        }
        if (i == 4 || i == 6) {
            return Uri.parse((String) this.mObj1);
        }
        throw new IllegalStateException("called getUri() on " + this);
    }

    public final String toString() {
        String str;
        if (this.mType == -1) {
            return String.valueOf(this.mObj1);
        }
        StringBuilder sb = new StringBuilder("Icon(typ=");
        switch (this.mType) {
            case 1:
                str = GsPcpBmONXh.UlANpaXJNpwAvW;
                break;
            case 2:
                str = "RESOURCE";
                break;
            case 3:
                str = "DATA";
                break;
            case 4:
                str = TSDAbK.GfMB;
                break;
            case 5:
                str = "BITMAP_MASKABLE";
                break;
            case 6:
                str = RDFWIi.pzaepJBEzaVkp;
                break;
            default:
                str = "UNKNOWN";
                break;
        }
        sb.append(str);
        switch (this.mType) {
            case 1:
            case 5:
                sb.append(" size=");
                sb.append(((Bitmap) this.mObj1).getWidth());
                sb.append("x");
                sb.append(((Bitmap) this.mObj1).getHeight());
                break;
            case 2:
                sb.append(" pkg=");
                sb.append(this.mString1);
                sb.append(" id=");
                sb.append(String.format("0x%08x", Integer.valueOf(getResId())));
                break;
            case 3:
                sb.append(" len=");
                sb.append(this.mInt1);
                if (this.mInt2 != 0) {
                    sb.append(" off=");
                    sb.append(this.mInt2);
                }
                break;
            case 4:
            case 6:
                sb.append(" uri=");
                sb.append(this.mObj1);
                break;
        }
        if (this.mTintList != null) {
            sb.append(" tint=");
            sb.append(this.mTintList);
        }
        if (this.mTintMode != DEFAULT_TINT_MODE) {
            sb.append(" mode=");
            sb.append(this.mTintMode);
        }
        sb.append(")");
        return sb.toString();
    }

    public IconCompat(int i) {
        this.mData = null;
        this.mParcelable = null;
        this.mInt1 = 0;
        this.mInt2 = 0;
        this.mTintList = null;
        this.mTintMode = DEFAULT_TINT_MODE;
        this.mTintModeStr = null;
        this.mType = i;
    }
}
