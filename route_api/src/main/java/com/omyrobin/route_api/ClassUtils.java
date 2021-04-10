package com.omyrobin.route_api;

import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import dalvik.system.DexFile;

/**
 * @author Omyrobin
 *
 */

public class ClassUtils {


    /**
     * 获得程序所有的apk(instant run会产生很多split apk)
     */
    public static List<String> getSourcePaths(Context context) throws PackageManager
            .NameNotFoundException {
        ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context
                .getPackageName(), 0);
        List<String> sourcePaths = new ArrayList<>();
        //当前 应用的apk 文件
        sourcePaths.add(applicationInfo.sourceDir);
        //instant run
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            if (null != applicationInfo.splitSourceDirs) {
                sourcePaths.addAll(Arrays.asList(applicationInfo.splitSourceDirs));
            }
        }
        return sourcePaths;
    }


    public static Set<String> getFileNameByPackageName(Application context, final String
            packageName) throws PackageManager.NameNotFoundException {
        // 拿到 apk当中的dex 地址!
        final Set<String> classNames = new HashSet<>();
        List<String> paths = getSourcePaths(context);


        for (final String path : paths) {
            DexFile dexfile = null;
            try {
                //加载 apk中的dex 并遍历 获得所有 packageName 的类
                dexfile = new DexFile(path);
                Enumeration<String> dexEntries = dexfile.entries();
                while (dexEntries.hasMoreElements()) {
                    // com.xxx.xxx.XXX 整个APK中给所有的类
                    String className = dexEntries.nextElement();
                    if (className.startsWith(packageName)) {
                        classNames.add(className);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (null != dexfile) {
                    try {
                        dexfile.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        return classNames;
    }
}
