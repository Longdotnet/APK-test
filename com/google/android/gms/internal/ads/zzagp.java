package com.google.android.gms.internal.ads;

import com.google.android.gms.signin.internal.FVfQ.GsPcpBmONXh;
import java.io.IOException;
import java.io.StringReader;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* JADX INFO: loaded from: classes2.dex */
final class zzagp {
    private static final String[] zza = {"Camera:MotionPhoto", "GCamera:MotionPhoto", "Camera:MicroVideo", "GCamera:MicroVideo"};
    private static final String[] zzb = {GsPcpBmONXh.klX, "GCamera:MotionPhotoPresentationTimestampUs", "Camera:MicroVideoPresentationTimestampUs", "GCamera:MicroVideoPresentationTimestampUs"};
    private static final String[] zzc = {"Camera:MicroVideoOffset", "GCamera:MicroVideoOffset"};

    public static zzagl zza(String str) {
        long j;
        try {
            XmlPullParser xmlPullParserNewPullParser = XmlPullParserFactory.newInstance().newPullParser();
            xmlPullParserNewPullParser.setInput(new StringReader(str));
            xmlPullParserNewPullParser.next();
            if (!zzey.zzc(xmlPullParserNewPullParser, "x:xmpmeta")) {
                throw zzaz.zza("Couldn't find xmp metadata", null);
            }
            zzfyq zzfyqVarZzn = zzfyq.zzn();
            long j2 = -9223372036854775807L;
            do {
                xmlPullParserNewPullParser.next();
                if (zzey.zzc(xmlPullParserNewPullParser, "rdf:Description")) {
                    String[] strArr = zza;
                    int i = 0;
                    for (int i2 = 0; i2 < 4; i2++) {
                        String strZza = zzey.zza(xmlPullParserNewPullParser, strArr[i2]);
                        if (strZza != null) {
                            if (Integer.parseInt(strZza) != 1) {
                                return null;
                            }
                            String[] strArr2 = zzb;
                            int i3 = 0;
                            while (true) {
                                if (i3 < 4) {
                                    String strZza2 = zzey.zza(xmlPullParserNewPullParser, strArr2[i3]);
                                    if (strZza2 != null) {
                                        j = Long.parseLong(strZza2);
                                        if (j != -1) {
                                            break;
                                        }
                                        break;
                                    }
                                    i3++;
                                }
                                j = -9223372036854775807L;
                                break;
                            }
                            String[] strArr3 = zzc;
                            while (true) {
                                if (i >= 2) {
                                    zzfyqVarZzn = zzfyq.zzn();
                                    break;
                                }
                                String strZza3 = zzey.zza(xmlPullParserNewPullParser, strArr3[i]);
                                if (strZza3 != null) {
                                    zzfyqVarZzn = zzfyq.zzp(new zzagk("image/jpeg", "Primary", 0L, 0L), new zzagk("video/mp4", "MotionPhoto", Long.parseLong(strZza3), 0L));
                                    break;
                                }
                                i++;
                            }
                            j2 = j;
                        }
                    }
                    return null;
                }
                if (zzey.zzc(xmlPullParserNewPullParser, "Container:Directory")) {
                    zzfyqVarZzn = zzb(xmlPullParserNewPullParser, "Container", "Item");
                } else if (zzey.zzc(xmlPullParserNewPullParser, "GContainer:Directory")) {
                    zzfyqVarZzn = zzb(xmlPullParserNewPullParser, "GContainer", "GContainerItem");
                }
            } while (!zzey.zzb(xmlPullParserNewPullParser, "x:xmpmeta"));
            if (zzfyqVarZzn.isEmpty()) {
                return null;
            }
            return new zzagl(j2, zzfyqVarZzn);
        } catch (zzaz | NumberFormatException | XmlPullParserException unused) {
            zzea.zzf("MotionPhotoXmpParser", "Ignoring unexpected XMP metadata");
            return null;
        }
    }

    private static zzfyq zzb(XmlPullParser xmlPullParser, String str, String str2) throws XmlPullParserException, IOException {
        int i = zzfyq.zzd;
        zzfyn zzfynVar = new zzfyn();
        do {
            String strConcat = str.concat(":Item");
            xmlPullParser.next();
            if (zzey.zzc(xmlPullParser, strConcat)) {
                String strConcat2 = str2.concat(":Mime");
                String strConcat3 = str2.concat(":Semantic");
                String strConcat4 = str2.concat(":Length");
                String strConcat5 = str2.concat(":Padding");
                String strZza = zzey.zza(xmlPullParser, strConcat2);
                String strZza2 = zzey.zza(xmlPullParser, strConcat3);
                String strZza3 = zzey.zza(xmlPullParser, strConcat4);
                String strZza4 = zzey.zza(xmlPullParser, strConcat5);
                if (strZza == null || strZza2 == null) {
                    return zzfyq.zzn();
                }
                zzfynVar.zzf(new zzagk(strZza, strZza2, strZza3 != null ? Long.parseLong(strZza3) : 0L, strZza4 != null ? Long.parseLong(strZza4) : 0L));
            }
        } while (!zzey.zzb(xmlPullParser, str.concat(":Directory")));
        return zzfynVar.zzi();
    }
}
