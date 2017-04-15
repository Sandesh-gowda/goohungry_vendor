package com.goohungrry.ecode.locationfinder.providers.permissionprovider;

import android.support.annotation.NonNull;

import com.goohungrry.ecode.locationfinder.configuration.Defaults;

public class StubPermissionProvider extends PermissionProvider {

    public StubPermissionProvider() {
        super(Defaults.LOCATION_PERMISSIONS, null);
    }

    @Override
    public boolean requestPermissions() {
        return false;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, @NonNull int[] grantResults) {
    }
}
