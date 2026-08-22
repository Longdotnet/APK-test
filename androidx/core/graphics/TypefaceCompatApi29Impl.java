package androidx.core.graphics;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.Font;
import android.graphics.fonts.FontFamily;
import android.graphics.fonts.FontStyle;
import android.os.ParcelFileDescriptor;
import androidx.core.content.res.FontResourcesParserCompat$FontFamilyFilesResourceEntry;
import androidx.core.content.res.FontResourcesParserCompat$FontFileResourceEntry;
import androidx.core.provider.FontsContractCompat$FontInfo;
import java.io.IOException;
import java.io.InputStream;
import kotlin.ExceptionsKt;

/* JADX INFO: loaded from: classes.dex */
public final class TypefaceCompatApi29Impl extends ExceptionsKt {
    public static Font findBaseFont(FontFamily fontFamily, int i) {
        FontStyle fontStyle = new FontStyle((i & 1) != 0 ? 700 : 400, (i & 2) != 0 ? 1 : 0);
        Font font = fontFamily.getFont(0);
        int matchScore = getMatchScore(fontStyle, font.getStyle());
        for (int i2 = 1; i2 < fontFamily.getSize(); i2++) {
            Font font2 = fontFamily.getFont(i2);
            int matchScore2 = getMatchScore(fontStyle, font2.getStyle());
            if (matchScore2 < matchScore) {
                font = font2;
                matchScore = matchScore2;
            }
        }
        return font;
    }

    public static int getMatchScore(FontStyle fontStyle, FontStyle fontStyle2) {
        return (Math.abs(fontStyle.getWeight() - fontStyle2.getWeight()) / 100) + (fontStyle.getSlant() == fontStyle2.getSlant() ? 0 : 2);
    }

    @Override // kotlin.ExceptionsKt
    public final Typeface createFromFontFamilyFilesResourceEntry(Context context, FontResourcesParserCompat$FontFamilyFilesResourceEntry fontResourcesParserCompat$FontFamilyFilesResourceEntry, Resources resources, int i) {
        try {
            FontFamily.Builder builder = null;
            for (FontResourcesParserCompat$FontFileResourceEntry fontResourcesParserCompat$FontFileResourceEntry : fontResourcesParserCompat$FontFamilyFilesResourceEntry.mEntries) {
                try {
                    Font fontBuild = new Font.Builder(resources, fontResourcesParserCompat$FontFileResourceEntry.mResourceId).setWeight(fontResourcesParserCompat$FontFileResourceEntry.mWeight).setSlant(fontResourcesParserCompat$FontFileResourceEntry.mItalic ? 1 : 0).setTtcIndex(fontResourcesParserCompat$FontFileResourceEntry.mTtcIndex).setFontVariationSettings(fontResourcesParserCompat$FontFileResourceEntry.mVariationSettings).build();
                    if (builder == null) {
                        builder = new FontFamily.Builder(fontBuild);
                    } else {
                        builder.addFont(fontBuild);
                    }
                } catch (IOException unused) {
                }
            }
            if (builder == null) {
                return null;
            }
            FontFamily fontFamilyBuild = builder.build();
            return new Typeface.CustomFallbackBuilder(fontFamilyBuild).setStyle(findBaseFont(fontFamilyBuild, i).getStyle()).build();
        } catch (Exception unused2) {
            return null;
        }
    }

    @Override // kotlin.ExceptionsKt
    public final Typeface createFromFontInfo(Context context, FontsContractCompat$FontInfo[] fontsContractCompat$FontInfoArr, int i) {
        ContentResolver contentResolver = context.getContentResolver();
        try {
            FontFamily.Builder builder = null;
            for (FontsContractCompat$FontInfo fontsContractCompat$FontInfo : fontsContractCompat$FontInfoArr) {
                try {
                    ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = contentResolver.openFileDescriptor(fontsContractCompat$FontInfo.mUri, "r", null);
                    if (parcelFileDescriptorOpenFileDescriptor == null) {
                        if (parcelFileDescriptorOpenFileDescriptor != null) {
                        }
                    } else {
                        try {
                            Font fontBuild = new Font.Builder(parcelFileDescriptorOpenFileDescriptor).setWeight(fontsContractCompat$FontInfo.mWeight).setSlant(fontsContractCompat$FontInfo.mItalic ? 1 : 0).setTtcIndex(fontsContractCompat$FontInfo.mTtcIndex).build();
                            if (builder == null) {
                                builder = new FontFamily.Builder(fontBuild);
                            } else {
                                builder.addFont(fontBuild);
                            }
                        } catch (Throwable th) {
                            try {
                                parcelFileDescriptorOpenFileDescriptor.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                            throw th;
                        }
                    }
                    parcelFileDescriptorOpenFileDescriptor.close();
                } catch (IOException unused) {
                }
            }
            if (builder == null) {
                return null;
            }
            FontFamily fontFamilyBuild = builder.build();
            return new Typeface.CustomFallbackBuilder(fontFamilyBuild).setStyle(findBaseFont(fontFamilyBuild, i).getStyle()).build();
        } catch (Exception unused2) {
            return null;
        }
    }

    @Override // kotlin.ExceptionsKt
    public final Typeface createFromInputStream(Context context, InputStream inputStream) {
        throw new RuntimeException("Do not use this function in API 29 or later.");
    }

    @Override // kotlin.ExceptionsKt
    public final Typeface createFromResourcesFontFile(Context context, Resources resources, int i, String str, int i2) {
        try {
            Font fontBuild = new Font.Builder(resources, i).build();
            return new Typeface.CustomFallbackBuilder(new FontFamily.Builder(fontBuild).build()).setStyle(fontBuild.getStyle()).build();
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // kotlin.ExceptionsKt
    public final FontsContractCompat$FontInfo findBestInfo(FontsContractCompat$FontInfo[] fontsContractCompat$FontInfoArr, int i) {
        throw new RuntimeException("Do not use this function in API 29 or later.");
    }
}
