/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.darly.dlcommon.common.bolts.links;

import android.net.Uri;

import com.darly.dlcommon.common.bolts.tasks.Task;


/**
 * Implement this interface to provide an alternate strategy for resolving App Links that may
 * include pre-fetching, caching, or querying for App Link data from an index provided by a
 * service provider.
 */
public interface AppLinkResolver {
    /**
     * Asynchronously resolves App Link data for a given URL.
     *
     * @param url the URL to resolve into an App Link.
     * @return the {@link AppLink} for the given URL.
     */
    public Task<AppLink> getAppLinkFromUrlInBackground(Uri url);
}
