package com.android.settings.deviceinfo;

import android.content.Context;
import android.os.SystemProperties;

import com.android.settings.core.BasePreferenceController;

public class AetheriaMaintainerPreferenceController extends BasePreferenceController {

    private static final String PROP_MAINTAINER = "ro.aetheria.maintainer";

    public AetheriaMaintainerPreferenceController(Context context, String key) {
        super(context, key);
    }

    @Override
    public int getAvailabilityStatus() {
        return AVAILABLE;
    }

    @Override
    public CharSequence getSummary() {
        return SystemProperties.get(PROP_MAINTAINER, "Unknown");
    }
}
