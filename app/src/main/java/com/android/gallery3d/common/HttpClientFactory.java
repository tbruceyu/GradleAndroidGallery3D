/*
 * Copyright (C) 2011 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.gallery3d.common;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;

import org.apache.http.params.HttpParams;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Constructs {@link HttpClient} instances and isolates client code from API
 * level differences.
 */
public final class HttpClientFactory {
    // TODO: migrate GDataClient to use this util method instead of apache's
    // DefaultHttpClient.
    /**
     * Creates an HttpClient with the userAgent string constructed from the
     * package name contained in the context.
     * @return the client
     */

    /**
     * Creates an HttpClient with the specified userAgent string.
     * @param userAgent the userAgent string
     * @return the client
     */

    /**
     * Closes an HttpClient.
     */

    private static String sUserAgent = null;

    private static String getUserAgent(Context context) {
        if (sUserAgent == null) {
            PackageInfo pi;
            try {
                pi = context.getPackageManager().getPackageInfo(
                        context.getPackageName(), 0);
            } catch (NameNotFoundException e) {
                throw new IllegalStateException("getPackageInfo failed");
            }
            sUserAgent = String.format("%s/%s; %s/%s/%s/%s; %s/%s/%s",
                    pi.packageName,
                    pi.versionName,
                    Build.BRAND,
                    Build.DEVICE,
                    Build.MODEL,
                    Build.ID,
                    Build.VERSION.SDK_INT,
                    Build.VERSION.RELEASE,
                    Build.VERSION.INCREMENTAL);
        }
        return sUserAgent;
    }

    private HttpClientFactory() {
    }
}
