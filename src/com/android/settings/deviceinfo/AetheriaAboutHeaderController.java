package com.android.settings.deviceinfo;

import android.content.Context;
import android.os.SystemProperties;
import android.widget.TextView;

import androidx.preference.PreferenceScreen;

import com.android.settings.R;
import com.android.settings.core.BasePreferenceController;
import com.android.settingslib.widget.LayoutPreference;

public class AetheriaAboutHeaderController extends BasePreferenceController {

    private static final String PROP_VERSION = "ro.aetheria.display.version";
    private static final String PROP_BUILD_TYPE = "ro.aetheria.releasetype";
    private static final String PROP_DEVICE = "ro.product.device";
    private static final String PROP_MAINTAINER = "ro.aetheria.maintainer";
    private static final String PROP_TAGLINE = "ro.aetheria.tagline";

    public AetheriaAboutHeaderController(Context context, String key) {
        super(context, key);
    }

    @Override
    public int getAvailabilityStatus() {
        return AVAILABLE;
    }

    @Override
    public void displayPreference(PreferenceScreen screen) {
        super.displayPreference(screen);
        LayoutPreference pref = screen.findPreference(getPreferenceKey());
        if (pref == null) return;

        String device = SystemProperties.get(PROP_DEVICE, "Unknown");
        String version = SystemProperties.get(PROP_VERSION, "1.0");
        String buildType = SystemProperties.get(PROP_BUILD_TYPE, "UNOFFICIAL");
        String maintainer = SystemProperties.get(PROP_MAINTAINER, "Unknown");
        String tagline = SystemProperties.get(PROP_TAGLINE, "Where imagination meets the cosmos");

        TextView deviceInfo = pref.findViewById(R.id.aetheria_device_info);
        if (deviceInfo != null) {
            deviceInfo.setText(device + " | " + version + " | " + buildType);
        }

        TextView taglineView = pref.findViewById(R.id.aetheria_tagline);
        if (taglineView != null) {
            taglineView.setText(tagline);
        }

        TextView maintainerView = pref.findViewById(R.id.aetheria_maintainer);
        if (maintainerView != null) {
            maintainerView.setText("Maintained by " + maintainer);
        }
    }
}
