package com.android.settings.deviceinfo;

import android.content.Context;
import android.os.SystemProperties;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.preference.PreferenceScreen;

import com.android.settings.R;
import com.android.settings.core.BasePreferenceController;
import com.android.settingslib.widget.LayoutPreference;

public class AetheriaAboutHeaderController extends BasePreferenceController {

    private static final String PROP_ROM_NAME = "ro.aetheria.rom.name";
    private static final String PROP_BUILD_TYPE = "ro.aetheria.releasetype";
    private static final String PROP_MAINTAINER = "ro.aetheria.maintainer";

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

        String romName = SystemProperties.get(PROP_ROM_NAME, "AetheriaOS");
        String buildType = SystemProperties.get(PROP_BUILD_TYPE, "UNOFFICIAL");
        String maintainer = SystemProperties.get(PROP_MAINTAINER, "N1709");

        boolean isOfficial = STATUS_OFFICIAL.equalsIgnoreCase(buildType);

        TextView romNameView = pref.findViewById(R.id.aetheria_rom_name);
        if (romNameView != null) {
            romNameView.setText(romName);
        }

        TextView buildTypeView = pref.findViewById(R.id.aetheria_build_type);
        if (buildTypeView != null) {
            buildTypeView.setText(buildType.toUpperCase());
        }

        TextView maintainerView = pref.findViewById(R.id.aetheria_maintainer);
        if (maintainerView != null) {
            maintainerView.setText("Maintained by " + maintainer);
        }

        TextView maintainerStatus = pref.findViewById(R.id.aetheria_maintainer_status);
        if (maintainerStatus != null) {
            maintainerStatus.setText(isOfficial ? "Verified maintainer" : "Unverified build");
        }

        View statusAccent = pref.findViewById(R.id.aetheria_status_accent);
        if (statusAccent != null) {
            statusAccent.setBackgroundResource(isOfficial
                    ? R.drawable.aetheria_accent_official
                    : R.drawable.aetheria_accent_unofficial);
        }

        ImageView avatar = pref.findViewById(R.id.aetheria_avatar);
        if (avatar != null) {
            avatar.setImageResource(R.drawable.ic_aetheria_maintainer_avatar);
        }
    }
}
