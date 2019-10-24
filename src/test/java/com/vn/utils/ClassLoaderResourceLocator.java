package com.vn.utils;

import java.io.InputStream;
import java.net.URL;

public class ClassLoaderResourceLocator extends AbstractResourceLocator {
    public ClassLoaderResourceLocator() {
        super();
    }

    public ClassLoaderResourceLocator(final String prefix) {
        super(prefix);
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * com.aurea.test.scumber.common.utils.ResourceLocator#getAsUrl(java.lang
     * .String)
     */
    @Override
    public URL getAsUrl(final String resource) {
        return Thread.currentThread().getContextClassLoader().getResource(getResourceName(resource));
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * com.aurea.test.scumber.common.utils.ResourceLocator#getAsStream(java.
     * lang.String)
     */
    @Override
    public InputStream getAsStream(final String resource) {
        final String resourceName = getResourceName(resource);
        return Thread.currentThread().getContextClassLoader().getResourceAsStream(
                resourceName);
    }
}
