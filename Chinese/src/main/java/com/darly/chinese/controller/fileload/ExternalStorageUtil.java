/*
 * 版权所有 2009-2019山东新北洋信息技术股份有限公司保留所有权利。
 */

package com.darly.chinese.controller.fileload;

import android.os.Environment;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

/**
 * 外部存储卡工具类
 * 需要添加权限
 * android.permission.WRITE_EXTERNAL_STORAGE
 * android.permission.MOUNT_UNMOUNT_FILESYSTEMS
 *
 * @author zhangyuhui<- ->Lidy</-->
 * @date 2018/6/14
 */
public class ExternalStorageUtil {

    /**
     * 商品详情图片下载目录
     */
    public static final String GOODS_DETAIL_PATH = File.separator + "StudyDay" + File.separator + "DownLoad" + File.separator;

    /**
     * 创建文件夹
     *
     */
    public static void creatFile(String path) {
        File dir = new File(getExternalStoragePath()+ File.separator + path);
        if (!dir.exists()) {
            if (!dir.getParentFile().exists()){
                String parentPath = dir.getParentFile().getName();
                creatFile(parentPath);
            }
            dir.mkdirs();
        }
    }
    /**
     * 获取下载文件路径
     *
     * @return 路径
     */
    public static String getDownLoadPath() {
        return getExternalStoragePath()+GOODS_DETAIL_PATH;
    }


    /**
     * 是否可写
     *
     * @return 可写性
     */
    public static boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            return true;
        }
        return false;
    }

    /**
     * 是否可读
     *
     * @return 可读性
     */
    public static boolean isExternalStorageReadable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)
                || Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
            return true;
        }
        return false;
    }

    /**
     * 获得根路径
     *
     * @return 外置内存卡根路径
     */
    public static String getExternalStoragePath() {
        if (isExternalStorageWritable()) {
            return Environment.getExternalStorageDirectory().getPath();
        } else {
            return null;
        }
    }

    /**
     * 获得下载目录路径
     *
     * @return 外置内存卡下载路径
     */
    public static String getExternalDownloadPath() {
        return Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_DOWNLOADS).getAbsolutePath();
    }

    /**
     * 向根路径写文件
     *
     * @param fileName 文件名
     * @param content  上下文
     * @return 是否写入成功
     */
    public static boolean write(String fileName, String content) {
        return write("/", fileName, content);
    }

    /**
     * 向根目录写字节
     *
     * @param fileName 文件名
     * @param bytes    文件字节数组
     * @return 是否写入成功
     */
    public static boolean writeBytes(String fileName, byte[] bytes) {
        return writeBytes("/", fileName, bytes);
    }

    /**
     * 向指定目录的文件中写入字符串,路径以/开始/结尾
     *
     * @param path     相对于根路径的路径，路径以/开始，以/结尾
     * @param fileName 文件名
     * @param content  文件内容
     * @return 是否写入成功
     */
    public static boolean write(String path, String fileName, String content) {
        return writeBytes(path, fileName, content.getBytes());
    }

    /**
     * 向指定目录的文件写入字节数组,路径以/开始/结尾
     *
     * @param path     相对于根路径的路径，路径以/开始，以/结尾
     * @param fileName 文件名
     * @param bytes    字节数组
     * @return
     */
    public static boolean writeBytes(String path, String fileName, byte bytes[]) {
        boolean flag = false;
        if (!"/".equals(path)) {
            File dir = new File(getExternalStoragePath() + path);
            if (!dir.exists()) {
                if (!(dir.mkdir() || dir.isDirectory())) {
                    // 文件目录创建失败或者不是一个目录
                    return false;
                }
            }
        }
        File file = new File(getExternalStoragePath() + path + fileName);
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file, false);
            fos.write(bytes);
            flag = true;
        } catch (FileNotFoundException e) {
//            e.printStackTrace();
        } catch (IOException e) {
//            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
//                    e.printStackTrace();
                }
            }

        }
        return flag;
    }

    /**
     * 从根路径读字节
     *
     * @param fileName 文件名
     * @return 字节数组
     */
    public static byte[] readBytes(String fileName) {
        return readBytes("/", fileName);
    }

    /**
     * 从指定目录读字节,路径以/开始/结尾
     *
     * @param path     相对于根路径的路径，路径以/开始，以/结尾
     * @param fileName 文件名
     * @return 字节数组
     */
    public static byte[] readBytes(String path, String fileName) {
        File file = new File(getExternalStoragePath() + path + fileName);
        if (!file.isFile()) {
            return null;
        } else {
            FileInputStream fis = null;
            try {
                fis = new FileInputStream(file);
                if (fis != null) {
                    int length = fis.available();
                    byte[] buffer = new byte[length];
                    if (fis.read(buffer) > 0) {
                        return buffer;
                    }
                }
            } catch (FileNotFoundException e) {
//                e.printStackTrace();
            } catch (IOException e) {
//                e.printStackTrace();
            } finally {
                if (fis != null) {
                    try {
                        fis.close();
                    } catch (IOException e) {
//                        e.printStackTrace();
                    }
                }
            }
            return null;
        }

    }

    /**
     * 从根目录读文本
     *
     * @param fileName 文件名
     * @return 字符串
     */
    public static String read(String fileName) {
        return read("/", fileName);
    }

    /**
     * 从指定目录读文本,路径以/开始/结尾
     *
     * @param path     相对于根路径的路径，路径以/开始，以/结尾
     * @param fileName 文件名
     * @return 字符串
     */
    public static String read(String path, String fileName) {
        try {
            byte[] readBytes = readBytes(path, fileName);
            if (readBytes == null) {
                return null;
            }
            return new String(readBytes, "UTF-8");
        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
        }
        return null;
    }


    /**
     * 从指定目录删除,路径以/开始/结尾
     */
    public static void delete() {
        File file = new File(getExternalStoragePath() + GOODS_DETAIL_PATH);
        deleteFile(file);
    }


    /**
     * 从指定目录删除,路径以/开始/结尾
     */
    public static void delete(File file) {
        deleteFile(file);
    }

    /**
     * 要删除的文件夹的所在位置
     *
     * @param file
     */
    private static void deleteFile(File file) {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (int i = 0; i < files.length; i++) {
                File f = files[i];
                deleteFile(f);
            }
            file.delete();//如要保留文件夹，只删除文件，请注释这行
        } else if (file.exists()) {
            file.delete();
        }
    }

    /**
     * 获取当前目录下所有的APK文件
     *
     * @param fileAbsolutePath 目录路径
     * @return
     */
    public static ArrayList<String> getAPKFileName(String fileAbsolutePath) {
        ArrayList<String> apkFiles = new ArrayList<String>();
        File file = new File(fileAbsolutePath);
        File[] subFile = file.listFiles();

        for (int iFileLength = 0; iFileLength < subFile.length; iFileLength++) {
            // 判断是否为文件夹
            if (!subFile[iFileLength].isDirectory()) {
                String filename = subFile[iFileLength].getName();
                // 判断是否为APK结尾
                if (filename.trim().toLowerCase().endsWith(".apk")) {
                    apkFiles.add(filename);
                }
            }
        }
        return apkFiles;
    }

    /**
     * 获取当前目录下所有的指定扩展名的文件
     *
     * @param fileAbsolutePath  目录路径
     * @param filenameExtension 文件扩展名（如：.apk  .zip）
     * @return 该目录下所有该类型的文件名集合
     */
    public static ArrayList<String> getFileNames(String fileAbsolutePath, String filenameExtension) {
        ArrayList<String> apkFiles = new ArrayList<String>();
        File file = new File(fileAbsolutePath);
        File[] subFile = file.listFiles();

        for (int iFileLength = 0; iFileLength < subFile.length; iFileLength++) {
            // 判断是否为文件夹
            if (!subFile[iFileLength].isDirectory()) {
                String filename = subFile[iFileLength].getName();
                // 判断是否为APK结尾
                if (filename.trim().toLowerCase().endsWith(filenameExtension)) {
                    apkFiles.add(filename);
                }
            }
        }
        return apkFiles;
    }


}