package com.android.settings.deviceinfo;

import android.content.Context;
import android.os.SystemProperties;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.preference.PreferenceScreen;

import com.android.settings.R;
import com.android.settings.core.BasePreferenceController;
import com.android.settingslib.widget.LayoutPreference;

public class AetheriaAboutHeaderController extends BasePreferenceController {

    private static final String PROP_VERSION = "ro.aetheria.build.version";
    private static final String PROP_BUILD_TYPE = "ro.aetheria.releasetype";
    private static final String PROP_DEVICE = "ro.product.device";
    private static final String PROP_MAINTAINER = "ro.aetheria.maintainer";
    private static final String PROP_TAGLINE = "ro.aetheria.tagline";

    private static final String STATUS_OFFICIAL = "OFFICIAL";

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

        boolean isOfficial = STATUS_OFFICIAL.equalsIgnoreCase(buildType);

        TextView deviceInfo = pref.findViewById(R.id.aetheria_device_info);
        if (deviceInfo != null) {
            deviceInfo.setText(device + " | " + version + " | " + buildType.toLowerCase());
        }

        TextView taglineView = pref.findViewById(R.id.aetheria_tagline);
        if (taglineView != null) {
            taglineView.setText(tagline);
        }

        TextView maintainerView = pref.findViewById(R.id.aetheria_maintainer);
        if (maintainerView != null) {
            maintainerView.setText("Maintained by " + maintainer);
        }

        TextView maintainerStatus = pref.findViewById(R.id.aetheria_maintainer_status);
        if (maintainerStatus != null) {
            maintainerStatus.setText(isOfficial ? "Verified maintainer" : "Unverified build");
        }

        TextView avatar = pref.findViewById(R.id.aetheria_avatar);
        if (avatar != null && maintainer.length() > 0) {
            avatar.setText(String.valueOf(maintainer.charAt(0)).toUpperCase());
        }

        ImageView statusIcon = pref.findViewById(R.id.aetheria_status_icon);
        if (statusIcon != null) {
            statusIcon.setImageResource(isOfficial
                    ? R.drawable.ic_aetheria_status_official
                    : R.drawable.ic_aetheria_status_unofficial);
        }
    }
}
