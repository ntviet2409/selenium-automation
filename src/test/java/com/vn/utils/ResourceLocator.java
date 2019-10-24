package com.vn.utils;

import java.io.File;
import java.io.InputStream;
import java.net.URL;

interface ResourceLocator {
    String getResourceName(String name);
    String getFullPathResourceName(String name) throws ScumberException;
    URL getAsUrl(String resource);
    InputStream getAsStream(String resource);
    File getAsFile(String resource) throws ScumberException;
    String getBaseFolder() throws ScumberException;
}
