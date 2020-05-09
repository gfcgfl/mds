package com.zju.nir.common.utils;

import java.io.*;

/**
 * @author xiaoguo
 */
public class FileUtils {

    /**
     * 递归创建目录
     *
     * @param dir
     */
    public static void createDirectory(File dir) {

//        if (!dir.isDirectory()) {
//            dir = dir.getParentFile();
//        }
        if (dir.exists()) {

            return;
        }

        createDirectory(dir.getParentFile());
        dir.mkdir();
        return;
    }


    public static boolean deleteFile(File fileToDelete) {
        if (fileToDelete == null) {
            return false;
        }

        if (fileToDelete.exists()) {
            return fileToDelete.delete();
        } else {
            return true;
        }
    }


    public static File parseToFile(byte[] bytes) {


        File tempFile;
        try {
            tempFile = File.createTempFile("bytesToFile", "temp");
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        try (
                FileOutputStream fos = new FileOutputStream(tempFile);
                BufferedOutputStream bos = new BufferedOutputStream(fos)
        ) {
            bos.write(bytes);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return tempFile;

    }


    public static byte[] toBytes(File file) {
        try {
            FileInputStream fis = new FileInputStream(file);
            ByteArrayOutputStream bos = new ByteArrayOutputStream(fis.available());
            byte[] b = new byte[fis.available()];
            int n;
            while ((n = fis.read(b)) != -1) {
                bos.write(b, 0, n);
            }
            fis.close();
            byte[] data = bos.toByteArray();
            bos.close();
            return data;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public static File getFileByUrl(String fileUrl) {
//        这里先模拟   todo
        return new File("D:\\pro\\JAVA\\Prjs\\mental-disease-system" +
                "\\bloodoxygen-parse-servcie-8001\\src\\main\\resources" +
                "\\marked-task1-12-20200114091946740.txt");
    }
}
