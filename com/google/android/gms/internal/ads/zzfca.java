package com.google.android.gms.internal.ads;

import android.util.JsonReader;
import androidx.work.impl.constraints.controllers.pST.ehgOP;
import com.daerisoft.thespikerm.GooglePlayBillingEnums;
import com.facebook.login.vu.dLDI;
import com.google.android.gms.games.event.AfJ.oKjScaD;
import com.google.android.gms.games.provider.NtJ.wsbWxekY;
import com.google.android.gms.signin.internal.FVfQ.GsPcpBmONXh;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.protobuf.DescriptorProtos;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.coroutines.jvm.internal.DEXi.JuorMn;
import okio.AsyncTimeout;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class zzfca {
    public final zzbxx zzA;
    public final String zzB;
    public final JSONObject zzC;
    public final JSONObject zzD;
    public final String zzE;
    public final String zzF;
    public final String zzG;
    public final String zzH;
    public final String zzI;
    public final boolean zzJ;
    public final boolean zzK;
    public final boolean zzL;
    public final boolean zzM;
    public final boolean zzN;
    public final boolean zzO;
    public final boolean zzP;
    public final int zzQ;
    public final int zzR;
    public final boolean zzS;
    public final boolean zzT;
    public final String zzU;
    public final zzfcz zzV;
    public final boolean zzW;
    public final boolean zzX;
    public final int zzY;
    public final String zzZ;
    public final List zza;
    public final List zzaA;
    public final boolean zzaB;
    public final boolean zzaC;
    public final int zzaa;
    public final String zzab;
    public final boolean zzac;
    public final zzbtw zzad;
    public final com.google.android.gms.ads.internal.client.zzt zzae;
    public final String zzaf;
    public final boolean zzag;
    public final JSONObject zzah;
    public final boolean zzai;
    public final JSONObject zzaj;
    public final boolean zzak;
    public final String zzal;
    public final boolean zzam;
    public final String zzan;
    public final String zzao;
    public final String zzap;
    public final boolean zzaq;
    public final boolean zzar;
    public final int zzas;
    public final String zzat;
    public final List zzau;
    public final boolean zzav;
    public final Map zzaw;
    public final com.google.android.gms.ads.internal.util.client.zzv zzax;
    public final com.google.android.gms.ads.internal.util.client.zzw zzay;
    public final double zzaz;
    public final int zzb;
    public final List zzc;
    public final List zzd;
    public final int zze;
    public final List zzf;
    public final List zzg;
    public final List zzh;
    public final List zzi;
    public final String zzj;
    public final String zzk;
    public final zzbwo zzl;
    public final List zzm;
    public final List zzn;
    public final List zzo;
    public final List zzp;
    public final int zzq;
    public final List zzr;
    public final zzfcf zzs;
    public final List zzt;
    public final List zzu;
    public final JSONObject zzv;
    public final String zzw;
    public final String zzx;
    public final String zzy;
    public final String zzz;

    public static String zza(int i) {
        switch (i) {
            case 1:
                return "BANNER";
            case 2:
                return "INTERSTITIAL";
            case 3:
                return JuorMn.FwUdMULkFVcS;
            case 4:
                return "NATIVE";
            case 5:
                return "REWARDED";
            case 6:
                return "APP_OPEN_AD";
            case 7:
                return "REWARDED_INTERSTITIAL";
            default:
                return "UNKNOWN";
        }
    }

    private static int zzc(String str) {
        if ("banner".equals(str)) {
            return 1;
        }
        if ("interstitial".equals(str)) {
            return 2;
        }
        if ("native_express".equals(str)) {
            return 3;
        }
        if ("native".equals(str)) {
            return 4;
        }
        if ("rewarded".equals(str)) {
            return 5;
        }
        if ("app_open_ad".equals(str)) {
            return 6;
        }
        return "rewarded_interstitial".equals(str) ? 7 : 0;
    }

    private static int zze(int i) {
        if (i == 0 || i == 1 || i == 3 || i == 4) {
            return i;
        }
        return 0;
    }

    public final boolean zzb() {
        return this.zzai || this.zzay != null;
    }

    /* JADX WARN: Code duplicated, block: B:264:0x0662 A[PHI: r19
  0x0662: PHI (r19v87 java.util.List) = 
  (r19v2 java.util.List)
  (r19v3 java.util.List)
  (r19v4 java.util.List)
  (r19v5 java.util.List)
  (r19v6 java.util.List)
  (r19v7 java.util.List)
  (r19v8 java.util.List)
  (r19v9 java.util.List)
  (r19v10 java.util.List)
  (r19v11 java.util.List)
  (r19v12 java.util.List)
  (r19v13 java.util.List)
  (r19v14 java.util.List)
  (r19v15 java.util.List)
  (r19v16 java.util.List)
  (r19v17 java.util.List)
  (r19v18 java.util.List)
  (r19v19 java.util.List)
  (r19v20 java.util.List)
  (r19v21 java.util.List)
  (r19v22 java.util.List)
  (r19v23 java.util.List)
  (r19v24 java.util.List)
  (r19v25 java.util.List)
  (r19v26 java.util.List)
  (r19v27 java.util.List)
  (r19v28 java.util.List)
  (r19v29 java.util.List)
  (r19v30 java.util.List)
  (r19v31 java.util.List)
  (r19v32 java.util.List)
  (r19v33 java.util.List)
  (r19v34 java.util.List)
  (r19v35 java.util.List)
  (r19v36 java.util.List)
  (r19v37 java.util.List)
  (r19v38 java.util.List)
  (r19v39 java.util.List)
  (r19v40 java.util.List)
  (r19v41 java.util.List)
  (r19v42 java.util.List)
  (r19v43 java.util.List)
  (r19v44 java.util.List)
  (r19v45 java.util.List)
  (r19v46 java.util.List)
  (r19v47 java.util.List)
  (r19v48 java.util.List)
  (r19v49 java.util.List)
  (r19v50 java.util.List)
  (r19v51 java.util.List)
  (r19v52 java.util.List)
  (r19v53 java.util.List)
  (r19v54 java.util.List)
  (r19v55 java.util.List)
  (r19v56 java.util.List)
  (r19v57 java.util.List)
  (r19v58 java.util.List)
  (r19v59 java.util.List)
  (r19v60 java.util.List)
  (r19v61 java.util.List)
  (r19v62 java.util.List)
  (r19v63 java.util.List)
  (r19v64 java.util.List)
  (r19v65 java.util.List)
  (r19v66 java.util.List)
  (r19v67 java.util.List)
  (r19v68 java.util.List)
  (r19v69 java.util.List)
  (r19v70 java.util.List)
  (r19v71 java.util.List)
  (r19v72 java.util.List)
  (r19v73 java.util.List)
  (r19v74 java.util.List)
  (r19v75 java.util.List)
  (r19v76 java.util.List)
  (r19v77 java.util.List)
  (r19v78 java.util.List)
  (r19v79 java.util.List)
  (r19v80 java.util.List)
  (r19v81 java.util.List)
  (r19v82 java.util.List)
  (r19v83 java.util.List)
  (r19v84 java.util.List)
  (r19v85 java.util.List)
  (r19v88 java.util.List)
 binds: [B:262:0x065d, B:259:0x064e, B:256:0x063f, B:253:0x0630, B:250:0x0621, B:247:0x0612, B:244:0x0603, B:241:0x05f3, B:238:0x05e3, B:235:0x05d3, B:232:0x05c3, B:229:0x05b3, B:226:0x05a3, B:223:0x0593, B:220:0x0583, B:217:0x0573, B:214:0x0562, B:211:0x0552, B:208:0x0542, B:205:0x0532, B:202:0x0522, B:199:0x0512, B:196:0x0501, B:193:0x04f1, B:190:0x04e1, B:187:0x04d1, B:184:0x04c1, B:181:0x04b2, B:178:0x04a2, B:175:0x0492, B:172:0x0482, B:169:0x0472, B:166:0x0462, B:163:0x0452, B:160:0x0442, B:157:0x0433, B:154:0x0422, B:151:0x0412, B:148:0x0402, B:145:0x03f2, B:142:0x03e2, B:139:0x03d2, B:136:0x03c2, B:133:0x03b2, B:130:0x03a2, B:127:0x0392, B:124:0x0382, B:121:0x0372, B:118:0x0362, B:115:0x0352, B:112:0x0342, B:109:0x0332, B:106:0x0322, B:103:0x0312, B:100:0x0302, B:97:0x02f2, B:94:0x02e3, B:91:0x02d3, B:88:0x02c3, B:85:0x02b3, B:82:0x02a3, B:79:0x0293, B:76:0x0284, B:73:0x0274, B:70:0x0264, B:67:0x0254, B:64:0x0244, B:61:0x0233, B:58:0x0223, B:55:0x0213, B:52:0x0203, B:49:0x01f3, B:46:0x01e3, B:43:0x01d3, B:40:0x01c4, B:37:0x01b4, B:34:0x01a5, B:31:0x0195, B:28:0x0186, B:25:0x0176, B:22:0x0166, B:19:0x0156, B:16:0x0146, B:13:0x0136, B:11:0x0128] A[DONT_GENERATE, DONT_INLINE]] */
    public zzfca(JsonReader jsonReader) throws IOException {
        byte b;
        List list;
        List list2;
        List listEmptyList = Collections.emptyList();
        List listEmptyList2 = Collections.emptyList();
        List listEmptyList3 = Collections.emptyList();
        List listEmptyList4 = Collections.emptyList();
        List listEmptyList5 = Collections.emptyList();
        List listEmptyList6 = Collections.emptyList();
        List listEmptyList7 = Collections.emptyList();
        List listEmptyList8 = Collections.emptyList();
        List listEmptyList9 = Collections.emptyList();
        List listEmptyList10 = Collections.emptyList();
        List listEmptyList11 = Collections.emptyList();
        List listEmptyList12 = Collections.emptyList();
        List listEmptyList13 = Collections.emptyList();
        List listEmptyList14 = Collections.emptyList();
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        JSONObject jSONObject4 = new JSONObject();
        JSONObject jSONObject5 = new JSONObject();
        JSONObject jSONObject6 = new JSONObject();
        zzfyq.zzn();
        zzfyq zzfyqVarZzn = zzfyq.zzn();
        HashMap map = new HashMap();
        zzfyq zzfyqVarZzn2 = zzfyq.zzn();
        zzfyq.zzn();
        jsonReader.beginObject();
        JSONObject jSONObjectZzi = jSONObject;
        JSONObject jSONObjectZzi2 = jSONObject2;
        JSONObject jSONObjectZzi3 = jSONObject3;
        JSONObject jSONObjectZzi4 = jSONObject4;
        JSONObject jSONObjectZzi5 = jSONObject5;
        JSONObject jSONObjectZzi6 = jSONObject6;
        List listZzd = zzfyqVarZzn;
        HashMap map2 = map;
        List listZzd2 = zzfyqVarZzn2;
        double dNextDouble = 0.0d;
        zzbwo zzbwoVarZza = null;
        zzfcf zzfcfVar = null;
        zzbxx zzbxxVarZza = null;
        zzbtw zzbtwVarZza = null;
        com.google.android.gms.ads.internal.client.zzt zztVar = null;
        String strNextString = null;
        com.google.android.gms.ads.internal.util.client.zzv zzvVar = null;
        com.google.android.gms.ads.internal.util.client.zzm zzmVar = null;
        String strNextString2 = "";
        String strNextString3 = strNextString2;
        String strNextString4 = strNextString3;
        String strNextString5 = strNextString4;
        String strNextString6 = strNextString5;
        String string = strNextString6;
        String strNextString7 = string;
        String strNextString8 = strNextString7;
        String strNextString9 = strNextString8;
        String strNextString10 = strNextString9;
        String strNextString11 = strNextString10;
        String strNextString12 = strNextString11;
        String strNextString13 = strNextString12;
        String strNextString14 = strNextString13;
        String strNextString15 = strNextString14;
        String strNextString16 = strNextString15;
        String strNextString17 = strNextString16;
        String strNextString18 = strNextString17;
        String strNextString19 = strNextString18;
        String strNextString20 = strNextString19;
        int iZzd = -1;
        int iNextInt = -1;
        int iZzc = 0;
        int iZze = 0;
        int iNextInt2 = 0;
        boolean zNextBoolean = false;
        boolean zNextBoolean2 = false;
        boolean zNextBoolean3 = false;
        boolean zNextBoolean4 = false;
        boolean zNextBoolean5 = false;
        boolean zNextBoolean6 = false;
        boolean zNextBoolean7 = false;
        int iNextInt3 = 0;
        boolean zNextBoolean8 = false;
        boolean zNextBoolean9 = false;
        boolean zNextBoolean10 = false;
        int iNextInt4 = 0;
        boolean zNextBoolean11 = false;
        boolean zNextBoolean12 = false;
        boolean zNextBoolean13 = false;
        boolean zNextBoolean14 = false;
        boolean zNextBoolean15 = false;
        boolean zNextBoolean16 = false;
        boolean zNextBoolean17 = false;
        boolean zNextBoolean18 = false;
        int iNextInt5 = 0;
        boolean zNextBoolean19 = false;
        boolean zNextBoolean20 = false;
        boolean zNextBoolean21 = false;
        List listZza = listEmptyList14;
        List listZzd3 = listEmptyList13;
        List listZza2 = listEmptyList12;
        List listZzd4 = listEmptyList11;
        List listZzd5 = listEmptyList10;
        List listZzd6 = listEmptyList9;
        List listZzd7 = listEmptyList8;
        List listZzd8 = listEmptyList7;
        List listZzd9 = listEmptyList6;
        List listZzd10 = listEmptyList5;
        List listZzd11 = listEmptyList4;
        List listZzd12 = listEmptyList3;
        List listZzd13 = listEmptyList2;
        List listZzd14 = listEmptyList;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            String str = strNextName == null ? "" : strNextName;
            switch (str.hashCode()) {
                case -2138196627:
                    listZza = listZza;
                    if (!str.equals("ad_source_instance_name")) {
                        b = -1;
                    } else {
                        b = 59;
                    }
                    break;
                case -1980587809:
                    listZza = listZza;
                    if (!str.equals("debug_signals")) {
                        b = -1;
                    } else {
                        b = 28;
                    }
                    break;
                case -1965512151:
                    listZza = listZza;
                    if (!str.equals("omid_settings")) {
                        b = -1;
                    } else {
                        b = 41;
                    }
                    break;
                case -1964744830:
                    listZza = listZza;
                    if (!str.equals("offline_ad_config")) {
                        b = -1;
                    } else {
                        b = 79;
                    }
                    break;
                case -1871425831:
                    listZza = listZza;
                    if (!str.equals("recursive_server_response_data")) {
                        b = -1;
                    } else {
                        b = 69;
                    }
                    break;
                case -1843156475:
                    listZza = listZza;
                    if (!str.equals("is_consent")) {
                        b = -1;
                    } else {
                        b = 71;
                    }
                    break;
                case -1840512279:
                    listZza = listZza;
                    if (!str.equals("presentation_urls")) {
                        b = -1;
                    } else {
                        b = 80;
                    }
                    break;
                case -1828733410:
                    listZza = listZza;
                    if (!str.equals("network_ping_config")) {
                        b = -1;
                    } else {
                        b = 78;
                    }
                    break;
                case -1812055556:
                    listZza = listZza;
                    if (!str.equals("play_prewarm_options")) {
                        b = -1;
                    } else {
                        b = 49;
                    }
                    break;
                case -1785028569:
                    listZza = listZza;
                    if (!str.equals("parallel_key")) {
                        b = -1;
                    } else {
                        b = 73;
                    }
                    break;
                case -1776946669:
                    listZza = listZza;
                    if (!str.equals("ad_source_name")) {
                        b = -1;
                    } else {
                        b = 57;
                    }
                    break;
                case -1662989631:
                    listZza = listZza;
                    if (!str.equals("is_interscroller")) {
                        b = -1;
                    } else {
                        b = 53;
                    }
                    break;
                case -1620470467:
                    listZza = listZza;
                    if (!str.equals("backend_query_id")) {
                        b = -1;
                    } else {
                        b = 47;
                    }
                    break;
                case -1550155393:
                    listZza = listZza;
                    if (!str.equals("nofill_urls")) {
                        b = -1;
                    } else {
                        b = 13;
                    }
                    break;
                case -1440104884:
                    listZza = listZza;
                    if (!str.equals("is_custom_close_blocked")) {
                        b = -1;
                    } else {
                        b = 35;
                    }
                    break;
                case -1439500848:
                    listZza = listZza;
                    if (!str.equals(dLDI.XGAjTEzXlspD)) {
                        b = -1;
                    } else {
                        b = 37;
                    }
                    break;
                case -1428969291:
                    listZza = listZza;
                    if (!str.equals("enable_omid")) {
                        b = -1;
                    } else {
                        b = 39;
                    }
                    break;
                case -1406227629:
                    listZza = listZza;
                    if (!str.equals("buffer_click_url_as_ready_to_ping")) {
                        b = -1;
                    } else {
                        b = 67;
                    }
                    break;
                case -1403779768:
                    listZza = listZza;
                    if (!str.equals("showable_impression_type")) {
                        b = -1;
                    } else {
                        b = 44;
                    }
                    break;
                case -1375413093:
                    listZza = listZza;
                    if (!str.equals("ad_cover")) {
                        b = -1;
                    } else {
                        b = 54;
                    }
                    break;
                case -1360811658:
                    listZza = listZza;
                    if (!str.equals("ad_sizes")) {
                        b = -1;
                    } else {
                        b = 19;
                    }
                    break;
                case -1306015996:
                    listZza = listZza;
                    if (!str.equals(ehgOP.xRAzzVBKHojyea)) {
                        b = -1;
                    } else {
                        b = 20;
                    }
                    break;
                case -1303332046:
                    listZza = listZza;
                    if (!str.equals("test_mode_enabled")) {
                        b = -1;
                    } else {
                        b = 34;
                    }
                    break;
                case -1289032093:
                    listZza = listZza;
                    if (!str.equals("extras")) {
                        b = -1;
                    } else {
                        b = 29;
                    }
                    break;
                case -1240082064:
                    listZza = listZza;
                    if (!str.equals("ad_event_value")) {
                        b = -1;
                    } else {
                        b = 51;
                    }
                    break;
                case -1234181075:
                    listZza = listZza;
                    if (!str.equals("allow_pub_rendered_attribution")) {
                        b = -1;
                    } else {
                        b = 30;
                    }
                    break;
                case -1168140544:
                    listZza = listZza;
                    if (!str.equals("presentation_error_urls")) {
                        b = -1;
                    } else {
                        b = 14;
                    }
                    break;
                case -1152230954:
                    listZza = listZza;
                    if (!str.equals("ad_type")) {
                        b = -1;
                    } else {
                        b = 1;
                    }
                    break;
                case -1146534047:
                    listZza = listZza;
                    if (!str.equals("is_scroll_aware")) {
                        b = -1;
                    } else {
                        b = 43;
                    }
                    break;
                case -1115838944:
                    listZza = listZza;
                    if (!str.equals("fill_urls")) {
                        b = -1;
                    } else {
                        b = 12;
                    }
                    break;
                case -1081936678:
                    listZza = listZza;
                    if (!str.equals("allocation_id")) {
                        b = -1;
                    } else {
                        b = 21;
                    }
                    break;
                case -1078050970:
                    listZza = listZza;
                    if (!str.equals("video_complete_urls")) {
                        b = -1;
                    } else {
                        b = 8;
                    }
                    break;
                case -1051269058:
                    listZza = listZza;
                    if (!str.equals("active_view")) {
                        b = -1;
                    } else {
                        b = 25;
                    }
                    break;
                case -982608540:
                    listZza = listZza;
                    if (!str.equals("valid_from_timestamp")) {
                        b = -1;
                    } else {
                        b = 10;
                    }
                    break;
                case -972056451:
                    listZza = listZza;
                    if (!str.equals("ad_source_instance_id")) {
                        b = -1;
                    } else {
                        b = 60;
                    }
                    break;
                case -776859333:
                    listZza = listZza;
                    if (!str.equals(GsPcpBmONXh.rHlrQ)) {
                        b = -1;
                    } else {
                        b = 2;
                    }
                    break;
                case -652881372:
                    listZza = listZza;
                    if (!str.equals("on_device_storage_configs")) {
                        b = -1;
                    } else {
                        b = 82;
                    }
                    break;
                case -570101180:
                    listZza = listZza;
                    if (!str.equals("late_load_urls")) {
                        b = -1;
                    } else {
                        b = 74;
                    }
                    break;
                case -544216775:
                    listZza = listZza;
                    if (!str.equals(wsbWxekY.IihjGqP)) {
                        b = -1;
                    } else {
                        b = 26;
                    }
                    break;
                case -437057161:
                    listZza = listZza;
                    if (!str.equals("imp_urls")) {
                        b = -1;
                    } else {
                        b = 3;
                    }
                    break;
                case -404433734:
                    listZza = listZza;
                    if (!str.equals("rtb_native_required_assets")) {
                        b = -1;
                    } else {
                        b = 62;
                    }
                    break;
                case -404326515:
                    listZza = listZza;
                    if (!str.equals("render_timeout_ms")) {
                        b = -1;
                    } else {
                        b = 38;
                    }
                    break;
                case -397704715:
                    listZza = listZza;
                    if (!str.equals("ad_close_time_ms")) {
                        b = -1;
                    } else {
                        b = 45;
                    }
                    break;
                case -388807511:
                    listZza = listZza;
                    if (!str.equals("content_url")) {
                        b = -1;
                    } else {
                        b = 64;
                    }
                    break;
                case -369773488:
                    listZza = listZza;
                    if (!str.equals("is_close_button_enabled")) {
                        b = -1;
                    } else {
                        b = 50;
                    }
                    break;
                case -213449460:
                    listZza = listZza;
                    if (!str.equals("force_disable_hardware_acceleration")) {
                        b = -1;
                    } else {
                        b = 65;
                    }
                    break;
                case -213424028:
                    listZza = listZza;
                    if (!str.equals("watermark")) {
                        b = -1;
                    } else {
                        b = 46;
                    }
                    break;
                case -180214626:
                    listZza = listZza;
                    if (!str.equals("native_required_asset_viewability")) {
                        b = -1;
                    } else {
                        b = 63;
                    }
                    break;
                case -154616268:
                    listZza = listZza;
                    if (!str.equals("is_offline_ad")) {
                        b = -1;
                    } else {
                        b = 61;
                    }
                    break;
                case -29338502:
                    listZza = listZza;
                    if (!str.equals("allow_custom_click_gesture")) {
                        b = -1;
                    } else {
                        b = 32;
                    }
                    break;
                case 3107:
                    listZza = listZza;
                    if (!str.equals("ad")) {
                        b = -1;
                    } else {
                        b = 18;
                    }
                    break;
                case 3355:
                    listZza = listZza;
                    if (!str.equals("id")) {
                        b = -1;
                    } else {
                        b = 23;
                    }
                    break;
                case 3076010:
                    listZza = listZza;
                    if (!str.equals("data")) {
                        b = -1;
                    } else {
                        b = 22;
                    }
                    break;
                case 37109963:
                    listZza = listZza;
                    if (!str.equals("request_id")) {
                        b = -1;
                    } else {
                        b = 68;
                    }
                    break;
                case 63195984:
                    listZza = listZza;
                    if (!str.equals("render_test_label")) {
                        b = -1;
                    } else {
                        b = 33;
                    }
                    break;
                case 107433883:
                    listZza = listZza;
                    if (!str.equals("qdata")) {
                        b = -1;
                    } else {
                        b = 24;
                    }
                    break;
                case 230323073:
                    listZza = listZza;
                    if (!str.equals("ad_load_urls")) {
                        b = -1;
                    } else {
                        b = 4;
                    }
                    break;
                case 418392395:
                    listZza = listZza;
                    if (!str.equals("is_closable_area_disabled")) {
                        b = -1;
                    } else {
                        b = 36;
                    }
                    break;
                case 542250332:
                    listZza = listZza;
                    if (!str.equals("consent_form_action_identifier")) {
                        b = -1;
                    } else {
                        b = 72;
                    }
                    break;
                case 549176928:
                    listZza = listZza;
                    if (!str.equals("presentation_error_timeout_ms")) {
                        b = -1;
                    } else {
                        b = 16;
                    }
                    break;
                case 597473788:
                    listZza = listZza;
                    if (!str.equals("debug_dialog_string")) {
                        b = -1;
                    } else {
                        b = 27;
                    }
                    break;
                case 754887508:
                    listZza = listZza;
                    if (!str.equals("container_sizes")) {
                        b = -1;
                    } else {
                        b = 17;
                    }
                    break;
                case 791122864:
                    listZza = listZza;
                    if (!str.equals("impression_type")) {
                        b = -1;
                    } else {
                        b = 5;
                    }
                    break;
                case 805095541:
                    listZza = listZza;
                    if (!str.equals("analytics_event_name_to_parameters_map")) {
                        b = -1;
                    } else {
                        b = 77;
                    }
                    break;
                case 1010584092:
                    listZza = listZza;
                    if (!str.equals(FirebaseAnalytics.Param.TRANSACTION_ID)) {
                        b = -1;
                    } else {
                        b = 9;
                    }
                    break;
                case 1100650276:
                    listZza = listZza;
                    if (!str.equals("rewards")) {
                        b = -1;
                    } else {
                        b = 11;
                    }
                    break;
                case 1141602460:
                    listZza = listZza;
                    if (!str.equals(dLDI.MrqiaDl)) {
                        b = -1;
                    } else {
                        b = 56;
                    }
                    break;
                case 1186014765:
                    listZza = listZza;
                    if (!str.equals("cache_hit_urls")) {
                        b = -1;
                    } else {
                        b = 66;
                    }
                    break;
                case 1303622534:
                    listZza = listZza;
                    if (!str.equals("preload_sort_value")) {
                        b = -1;
                    } else {
                        b = 76;
                    }
                    break;
                case 1321720943:
                    listZza = listZza;
                    if (!str.equals("allow_pub_owned_ad_view")) {
                        b = -1;
                    } else {
                        b = 31;
                    }
                    break;
                case 1422388341:
                    listZza = listZza;
                    if (!str.equals("is_collapsible")) {
                        b = -1;
                    } else {
                        b = 70;
                    }
                    break;
                case 1437255331:
                    listZza = listZza;
                    if (!str.equals("ad_source_id")) {
                        b = -1;
                    } else {
                        b = 58;
                    }
                    break;
                case 1565514205:
                    listZza = listZza;
                    if (!str.equals("adapter_only_third_party_impression")) {
                        b = -1;
                    } else {
                        b = 83;
                    }
                    break;
                case 1637553475:
                    listZza = listZza;
                    if (!str.equals("bid_response")) {
                        b = -1;
                    } else {
                        b = 40;
                    }
                    break;
                case 1638957285:
                    listZza = listZza;
                    if (!str.equals("video_start_urls")) {
                        b = -1;
                    } else {
                        b = 6;
                    }
                    break;
                case 1686319423:
                    listZza = listZza;
                    if (!str.equals("ad_network_class_name")) {
                        b = -1;
                    } else {
                        b = 55;
                    }
                    break;
                case 1688341040:
                    listZza = listZza;
                    if (!str.equals("video_reward_urls")) {
                        b = -1;
                    } else {
                        b = 7;
                    }
                    break;
                case 1799285870:
                    listZza = listZza;
                    if (!str.equals("use_third_party_container_height")) {
                        b = -1;
                    } else {
                        b = 48;
                    }
                    break;
                case 1839650832:
                    listZza = listZza;
                    if (!str.equals("renderers")) {
                        b = -1;
                    } else {
                        b = 0;
                    }
                    break;
                case 1875425491:
                    listZza = listZza;
                    if (!str.equals("is_analytics_logging_enabled")) {
                        b = -1;
                    } else {
                        b = 42;
                    }
                    break;
                case 2068142375:
                    listZza = listZza;
                    if (!str.equals("rule_line_external_id")) {
                        b = -1;
                    } else {
                        b = 52;
                    }
                    break;
                case 2072888499:
                    listZza = listZza;
                    if (!str.equals("manual_tracking_urls")) {
                        b = -1;
                    } else {
                        b = 15;
                    }
                    break;
                case 2075506442:
                    listZza = listZza;
                    if (!str.equals("render_serially")) {
                        b = -1;
                    } else {
                        b = 75;
                    }
                    break;
                case 2117205836:
                    listZza = listZza;
                    if (!str.equals("flow_control")) {
                        b = -1;
                    } else {
                        b = 81;
                    }
                    break;
                default:
                    listZza = listZza;
                    b = -1;
                    break;
            }
            switch (b) {
                case 0:
                    listZzd4 = listZzd4;
                    listZzd14 = AsyncTimeout.Companion.zzd(jsonReader);
                    listZza = listZza;
                    break;
                case 1:
                    listZzd4 = listZzd4;
                    iZzc = zzc(jsonReader.nextString());
                    listZza = listZza;
                    break;
                case 2:
                    listZzd4 = listZzd4;
                    listZzd13 = AsyncTimeout.Companion.zzd(jsonReader);
                    listZza = listZza;
                    break;
                case 3:
                    listZzd4 = listZzd4;
                    listZzd12 = AsyncTimeout.Companion.zzd(jsonReader);
                    listZza = listZza;
                    break;
                case 4:
                    listZzd4 = listZzd4;
                    listZzd11 = AsyncTimeout.Companion.zzd(jsonReader);
                    listZza = listZza;
                    break;
                case 5:
                    listZzd4 = listZzd4;
                    iZze = zze(jsonReader.nextInt());
                    listZza = listZza;
                    break;
                case 6:
                    listZzd4 = listZzd4;
                    listZzd10 = AsyncTimeout.Companion.zzd(jsonReader);
                    listZza = listZza;
                    break;
                case 7:
                    listZzd4 = listZzd4;
                    listZzd9 = AsyncTimeout.Companion.zzd(jsonReader);
                    listZza = listZza;
                    break;
                case 8:
                    listZzd4 = listZzd4;
                    listZzd8 = AsyncTimeout.Companion.zzd(jsonReader);
                    listZza = listZza;
                    break;
                case 9:
                    listZzd4 = listZzd4;
                    strNextString2 = jsonReader.nextString();
                    listZza = listZza;
                    break;
                case 10:
                    listZzd4 = listZzd4;
                    strNextString3 = jsonReader.nextString();
                    listZza = listZza;
                    break;
                case 11:
                    listZzd4 = listZzd4;
                    zzbwoVarZza = zzbwo.zza(AsyncTimeout.Companion.zzf(jsonReader));
                    listZza = listZza;
                    break;
                case 12:
                    listZzd4 = listZzd4;
                    listZzd7 = AsyncTimeout.Companion.zzd(jsonReader);
                    listZza = listZza;
                    break;
                case 13:
                    listZzd4 = listZzd4;
                    listZzd6 = AsyncTimeout.Companion.zzd(jsonReader);
                    listZza = listZza;
                    break;
                case 14:
                    listZzd4 = listZzd4;
                    listZzd5 = AsyncTimeout.Companion.zzd(jsonReader);
                    listZza = listZza;
                    break;
                case 15:
                    listZzd4 = AsyncTimeout.Companion.zzd(jsonReader);
                    listZza = listZza;
                    break;
                case 16:
                    listZzd4 = listZzd4;
                    iNextInt2 = jsonReader.nextInt();
                    listZza = listZza;
                    break;
                case 17:
                    listZzd4 = listZzd4;
                    listZza2 = zzfcb.zza(jsonReader);
                    listZza = listZza;
                    break;
                case 18:
                    listZzd4 = listZzd4;
                    zzfcfVar = new zzfcf(jsonReader);
                    listZza = listZza;
                    break;
                case 19:
                    listZzd4 = listZzd4;
                    listZza = zzfcb.zza(jsonReader);
                    break;
                case 20:
                    listZzd4 = listZzd4;
                    listZzd3 = AsyncTimeout.Companion.zzd(jsonReader);
                    listZza = listZza;
                    break;
                case 21:
                    strNextString4 = jsonReader.nextString();
                    listZza = listZza;
                    break;
                case 22:
                    listZzd4 = listZzd4;
                    jSONObjectZzi = AsyncTimeout.Companion.zzi(jsonReader);
                    listZza = listZza;
                    break;
                case DescriptorProtos.FileOptions.DEPRECATED_FIELD_NUMBER /* 23 */:
                    strNextString5 = jsonReader.nextString();
                    listZza = listZza;
                    break;
                case 24:
                    strNextString6 = jsonReader.nextString();
                    listZza = listZza;
                    break;
                case 25:
                    string = AsyncTimeout.Companion.zzi(jsonReader).toString();
                    listZza = listZza;
                    break;
                case 26:
                    listZzd4 = listZzd4;
                    zzbxxVarZza = zzbxx.zza(AsyncTimeout.Companion.zzi(jsonReader));
                    listZza = listZza;
                    break;
                case DescriptorProtos.FileOptions.JAVA_STRING_CHECK_UTF8_FIELD_NUMBER /* 27 */:
                    strNextString7 = jsonReader.nextString();
                    listZza = listZza;
                    break;
                case 28:
                    listZzd4 = listZzd4;
                    jSONObjectZzi2 = AsyncTimeout.Companion.zzi(jsonReader);
                    listZza = listZza;
                    break;
                case 29:
                    listZzd4 = listZzd4;
                    jSONObjectZzi3 = AsyncTimeout.Companion.zzi(jsonReader);
                    listZza = listZza;
                    break;
                case 30:
                    zNextBoolean = jsonReader.nextBoolean();
                    listZza = listZza;
                    break;
                case DescriptorProtos.FileOptions.CC_ENABLE_ARENAS_FIELD_NUMBER /* 31 */:
                    zNextBoolean2 = jsonReader.nextBoolean();
                    listZza = listZza;
                    break;
                case 32:
                    zNextBoolean3 = jsonReader.nextBoolean();
                    listZza = listZza;
                    break;
                case 33:
                    zNextBoolean4 = jsonReader.nextBoolean();
                    listZza = listZza;
                    break;
                case 34:
                    zNextBoolean5 = jsonReader.nextBoolean();
                    listZza = listZza;
                    break;
                case DescriptorProtos.MethodOptions.FEATURES_FIELD_NUMBER /* 35 */:
                    zNextBoolean6 = jsonReader.nextBoolean();
                    listZza = listZza;
                    break;
                case DescriptorProtos.FileOptions.OBJC_CLASS_PREFIX_FIELD_NUMBER /* 36 */:
                    zNextBoolean7 = jsonReader.nextBoolean();
                    listZza = listZza;
                    break;
                case DescriptorProtos.FileOptions.CSHARP_NAMESPACE_FIELD_NUMBER /* 37 */:
                    iZzd = zzd(jsonReader.nextString());
                    listZza = listZza;
                    break;
                case 38:
                    iNextInt3 = jsonReader.nextInt();
                    listZza = listZza;
                    break;
                case DescriptorProtos.FileOptions.SWIFT_PREFIX_FIELD_NUMBER /* 39 */:
                    zNextBoolean8 = jsonReader.nextBoolean();
                    listZza = listZza;
                    break;
                case DescriptorProtos.FileOptions.PHP_CLASS_PREFIX_FIELD_NUMBER /* 40 */:
                    strNextString8 = jsonReader.nextString();
                    listZza = listZza;
                    break;
                case DescriptorProtos.FileOptions.PHP_NAMESPACE_FIELD_NUMBER /* 41 */:
                    listZzd4 = listZzd4;
                    jSONObjectZzi4 = AsyncTimeout.Companion.zzi(jsonReader);
                    listZza = listZza;
                    break;
                case 42:
                    zNextBoolean9 = jsonReader.nextBoolean();
                    listZza = listZza;
                    break;
                case 43:
                    zNextBoolean10 = jsonReader.nextBoolean();
                    listZza = listZza;
                    break;
                case DescriptorProtos.FileOptions.PHP_METADATA_NAMESPACE_FIELD_NUMBER /* 44 */:
                    iNextInt4 = jsonReader.nextInt();
                    listZza = listZza;
                    break;
                case DescriptorProtos.FileOptions.RUBY_PACKAGE_FIELD_NUMBER /* 45 */:
                    iNextInt = jsonReader.nextInt();
                    listZza = listZza;
                    break;
                case 46:
                    strNextString9 = jsonReader.nextString();
                    listZza = listZza;
                    break;
                case 47:
                    strNextString10 = jsonReader.nextString();
                    listZza = listZza;
                    break;
                case 48:
                    zNextBoolean11 = jsonReader.nextBoolean();
                    listZza = listZza;
                    break;
                case 49:
                    listZzd4 = listZzd4;
                    zzbtwVarZza = zzbtw.zza(AsyncTimeout.Companion.zzi(jsonReader));
                    listZza = listZza;
                    break;
                case 50:
                    listZzd4 = listZzd4;
                    list = listZza2;
                    list2 = listZzd3;
                    jsonReader.nextBoolean();
                    listZzd3 = list2;
                    listZza = listZza;
                    listZza2 = list;
                    break;
                case 51:
                    listZzd4 = listZzd4;
                    list = listZza2;
                    list2 = listZzd3;
                    JSONObject jSONObjectZzi7 = AsyncTimeout.Companion.zzi(jsonReader);
                    zztVar = new com.google.android.gms.ads.internal.client.zzt(jSONObjectZzi7.getInt("type_num"), jSONObjectZzi7.getInt("precision_num"), jSONObjectZzi7.getLong(FirebaseAnalytics.Param.VALUE), jSONObjectZzi7.getString(FirebaseAnalytics.Param.CURRENCY));
                    listZzd3 = list2;
                    listZza = listZza;
                    listZza2 = list;
                    break;
                case 52:
                    strNextString11 = jsonReader.nextString();
                    listZza = listZza;
                    break;
                case 53:
                    zNextBoolean12 = jsonReader.nextBoolean();
                    listZza = listZza;
                    break;
                case 54:
                    listZzd4 = listZzd4;
                    jSONObjectZzi5 = AsyncTimeout.Companion.zzi(jsonReader);
                    listZza = listZza;
                    break;
                case 55:
                    strNextString12 = jsonReader.nextString();
                    listZza = listZza;
                    break;
                case 56:
                    strNextString19 = jsonReader.nextString();
                    listZza = listZza;
                    break;
                case 57:
                    strNextString13 = jsonReader.nextString();
                    listZza = listZza;
                    break;
                case 58:
                    strNextString14 = jsonReader.nextString();
                    listZza = listZza;
                    break;
                case 59:
                    strNextString15 = jsonReader.nextString();
                    listZza = listZza;
                    break;
                case 60:
                    strNextString16 = jsonReader.nextString();
                    listZza = listZza;
                    break;
                case 61:
                    zNextBoolean13 = jsonReader.nextBoolean();
                    listZza = listZza;
                    break;
                case 62:
                    listZzd4 = listZzd4;
                    jSONObjectZzi6 = AsyncTimeout.Companion.zzi(jsonReader);
                    listZza = listZza;
                    break;
                case 63:
                    zNextBoolean14 = jsonReader.nextBoolean();
                    listZza = listZza;
                    break;
                case 64:
                    listZzd4 = listZzd4;
                    strNextString = jsonReader.nextString();
                    listZza = listZza;
                    break;
                case 65:
                    zNextBoolean15 = jsonReader.nextBoolean();
                    listZza = listZza;
                    break;
                case GooglePlayBillingEnums.EVENT_OTHER_WEB_IAP /* 66 */:
                    listZzd4 = listZzd4;
                    list = listZza2;
                    list2 = listZzd3;
                    AsyncTimeout.Companion.zzd(jsonReader);
                    listZzd3 = list2;
                    listZza = listZza;
                    listZza2 = list;
                    break;
                case 67:
                    zNextBoolean16 = jsonReader.nextBoolean();
                    listZza = listZza;
                    break;
                case 68:
                    strNextString17 = jsonReader.nextString();
                    listZza = listZza;
                    break;
                case 69:
                    strNextString18 = jsonReader.nextString();
                    listZza = listZza;
                    break;
                case 70:
                    zNextBoolean17 = jsonReader.nextBoolean();
                    listZza = listZza;
                    break;
                case 71:
                    zNextBoolean18 = jsonReader.nextBoolean();
                    listZza = listZza;
                    break;
                case 72:
                    iNextInt5 = jsonReader.nextInt();
                    listZza = listZza;
                    break;
                case 73:
                    strNextString20 = jsonReader.nextString();
                    listZza = listZza;
                    break;
                case 74:
                    listZzd4 = listZzd4;
                    listZzd = AsyncTimeout.Companion.zzd(jsonReader);
                    listZza = listZza;
                    break;
                case 75:
                    zNextBoolean19 = jsonReader.nextBoolean();
                    listZza = listZza;
                    break;
                case 76:
                    listZzd4 = listZzd4;
                    list = listZza2;
                    dNextDouble = jsonReader.nextDouble();
                    listZza2 = list;
                    break;
                case 77:
                    listZzd4 = listZzd4;
                    list = listZza2;
                    list2 = listZzd3;
                    if (((Boolean) zzbde.zzas.zzk()).booleanValue()) {
                        HashMap map3 = new HashMap();
                        jsonReader.beginObject();
                        while (jsonReader.hasNext()) {
                            String strNextName2 = jsonReader.nextName();
                            HashMap map4 = new HashMap();
                            jsonReader.beginObject();
                            while (jsonReader.hasNext()) {
                                map4.put(jsonReader.nextName(), jsonReader.nextString());
                            }
                            jsonReader.endObject();
                            map3.put(strNextName2, map4);
                        }
                        jsonReader.endObject();
                        map2 = map3;
                    } else {
                        jsonReader.skipValue();
                    }
                    listZzd3 = list2;
                    listZza = listZza;
                    listZza2 = list;
                    break;
                case 78:
                    listZzd4 = listZzd4;
                    list = listZza2;
                    list2 = listZzd3;
                    if (!((Boolean) zzbde.zziV.zzk()).booleanValue()) {
                        jsonReader.skipValue();
                        listZzd3 = list2;
                        listZza = listZza;
                        listZza2 = list;
                    } else {
                        JSONObject jSONObjectOptJSONObject = AsyncTimeout.Companion.zzi(jsonReader).optJSONObject("ping_strategy");
                        zzvVar = new com.google.android.gms.ads.internal.util.client.zzv(jSONObjectOptJSONObject == null ? new com.google.android.gms.ads.internal.util.client.zzn(1, 0, 1.0d, false) : new com.google.android.gms.ads.internal.util.client.zzn(jSONObjectOptJSONObject.optInt("max_attempts", 1), jSONObjectOptJSONObject.optInt("initial_backoff_ms", 0), jSONObjectOptJSONObject.optDouble("backoff_multiplier", 1.0d), jSONObjectOptJSONObject.optBoolean("buffer_after_max_attempts", false)));
                        listZzd3 = list2;
                        listZza2 = list;
                    }
                    break;
                case 79:
                    if (!((Boolean) zzbde.zziX.zzk()).booleanValue()) {
                        listZzd4 = listZzd4;
                        list = listZza2;
                        list2 = listZzd3;
                        jsonReader.skipValue();
                        listZzd3 = list2;
                        listZza = listZza;
                        listZza2 = list;
                    } else {
                        JSONObject jSONObjectZzi8 = AsyncTimeout.Companion.zzi(jsonReader);
                        list2 = listZzd3;
                        list = listZza2;
                        listZzd4 = listZzd4;
                        zzmVar = new com.google.android.gms.ads.internal.util.client.zzm(jSONObjectZzi8.optInt("impression_prerequisite", 0), jSONObjectZzi8.optInt("click_prerequisite", 0), jSONObjectZzi8.optBoolean("notification_flow_enabled", false));
                        listZzd3 = list2;
                        listZza2 = list;
                    }
                    break;
                case 80:
                    listZzd2 = AsyncTimeout.Companion.zzd(jsonReader);
                    listZzd4 = listZzd4;
                    break;
                case 81:
                    zNextBoolean20 = jsonReader.nextBoolean();
                    listZzd4 = listZzd4;
                    break;
                case 82:
                    if (((Boolean) zzbde.zzie.zzk()).booleanValue()) {
                        zzfcg.zza(jsonReader);
                    } else {
                        jsonReader.skipValue();
                    }
                    listZzd4 = listZzd4;
                    list = listZza2;
                    list2 = listZzd3;
                    listZzd3 = list2;
                    listZza = listZza;
                    listZza2 = list;
                    break;
                case 83:
                    zNextBoolean21 = jsonReader.nextBoolean();
                    listZzd4 = listZzd4;
                    break;
                default:
                    jsonReader.skipValue();
                    listZzd4 = listZzd4;
                    list = listZza2;
                    list2 = listZzd3;
                    listZzd3 = list2;
                    listZza = listZza;
                    listZza2 = list;
                    break;
            }
            listZzd4 = listZzd4;
        }
        jsonReader.endObject();
        this.zza = listZzd14;
        this.zzb = iZzc;
        this.zzc = listZzd13;
        this.zzd = listZzd12;
        this.zzf = listZzd11;
        this.zze = iZze;
        this.zzg = listZzd10;
        this.zzh = listZzd9;
        this.zzi = listZzd8;
        this.zzj = strNextString2;
        this.zzk = strNextString3;
        this.zzl = zzbwoVarZza;
        this.zzm = listZzd7;
        this.zzn = listZzd6;
        this.zzo = listZzd5;
        this.zzp = listZzd4;
        this.zzq = iNextInt2;
        this.zzr = listZza2;
        this.zzs = zzfcfVar;
        this.zzt = listZzd3;
        this.zzu = listZza;
        this.zzw = strNextString4;
        this.zzv = jSONObjectZzi;
        this.zzx = strNextString5;
        this.zzy = strNextString6;
        this.zzz = string;
        this.zzA = zzbxxVarZza;
        this.zzB = strNextString7;
        this.zzC = jSONObjectZzi2;
        this.zzD = jSONObjectZzi3;
        this.zzJ = zNextBoolean;
        this.zzK = zNextBoolean2;
        this.zzL = zNextBoolean3;
        this.zzM = zNextBoolean4;
        this.zzN = zNextBoolean5;
        this.zzO = zNextBoolean6;
        this.zzP = zNextBoolean7;
        this.zzQ = iZzd;
        this.zzR = iNextInt3;
        this.zzT = zNextBoolean8;
        this.zzU = strNextString8;
        this.zzV = new zzfcz(jSONObjectZzi4);
        this.zzW = zNextBoolean9;
        this.zzX = zNextBoolean10;
        this.zzY = iNextInt4;
        this.zzZ = strNextString9;
        this.zzaa = iNextInt;
        this.zzab = strNextString10;
        this.zzac = zNextBoolean11;
        this.zzad = zzbtwVarZza;
        this.zzae = zztVar;
        this.zzaf = strNextString11;
        this.zzag = zNextBoolean12;
        this.zzah = jSONObjectZzi5;
        this.zzE = strNextString12;
        this.zzF = strNextString13;
        this.zzG = strNextString14;
        this.zzH = strNextString15;
        this.zzI = strNextString16;
        this.zzai = zNextBoolean13;
        this.zzaj = jSONObjectZzi6;
        this.zzak = zNextBoolean14;
        this.zzal = strNextString;
        this.zzam = zNextBoolean15;
        this.zzS = zNextBoolean16;
        this.zzan = strNextString17;
        this.zzao = strNextString18;
        this.zzap = strNextString19;
        this.zzaq = zNextBoolean17;
        this.zzar = zNextBoolean18;
        this.zzas = iNextInt5;
        this.zzau = listZzd;
        this.zzat = strNextString20;
        this.zzav = zNextBoolean19;
        this.zzaw = map2;
        this.zzax = zzvVar;
        this.zzay = zzmVar;
        this.zzaz = dNextDouble;
        this.zzaA = listZzd2;
        this.zzaB = zNextBoolean20;
        this.zzaC = zNextBoolean21;
    }

    private static int zzd(String str) {
        if (oKjScaD.WpfFFunKk.equalsIgnoreCase(str)) {
            return 6;
        }
        return "portrait".equalsIgnoreCase(str) ? 7 : -1;
    }
}
