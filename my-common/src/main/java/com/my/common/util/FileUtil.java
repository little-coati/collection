package com.my.common.util;

import com.nari.common.exception.NariException;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

/**
 * @ClassName: FileUtil
 * @Description: 文件处理工具类
 */
public class FileUtil
{

    private static final Logger log = LoggerFactory.getLogger(FileUtil.class);

    /**
     *
     * @param file
     * @return 返回文件后缀
     */
    public static String getFileExt(MultipartFile file){
        return file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1)
                .toLowerCase();
    }


    /**
     * 比较上传的文件类型是否与选择的文件类型一致
     * @param ext 截取的上传文件的后缀名
     * @param suffix 用户选择的文件类型，即后缀名
     * @return 相同返回true，不同返回false
     */
    public static boolean validateFileExt(String ext,String suffix){
        if(suffix.equals(ext)){
            return true;
        }else {
            return false;
        }
    }


    /**
     * @Title: uploadFile
     * @Description: 文件上传
     * @param file
     * @param filePath
     *            文件全路径,包含文件名
     * @throws IOException
     */
    public static void uploadFile(MultipartFile file, String filePath) throws IOException
    {
        FileOutputStream out = null;
    	File newFile = new File(filePath);
    	    try {
    	    	//判断父目录路径是否存在，如test.txt前的I:\a\b\
    	    	if (!newFile.getParentFile().exists()) {
	    	    	//不存在则创建父目录
	    	    	// newFile.getParentFile().mkdirs();
                    boolean mksflag = newFile.getParentFile().mkdirs();
                    if (!mksflag){
                        throw new IOException("try to mkdirs fail") ;
                    }
    	    	}
    	    	out = new FileOutputStream(new File(filePath));
    	    	if (out != null && file != null) {
                    out.write(file.getBytes());
                } else {
    	    	    throw new NullPointerException();
                }
    	    } catch (IOException e) {
                log.error("uploadFile is error: {}", e);
    	    } catch (RuntimeException e) {
    	        log.error(e.toString());
            } finally {
                if (out != null) {
                    try {
                        out.close();
                    } catch (IOException e) {
                        log.error("uploadFile is error: {}", e);
                    }
                }
            }
    }
    /**
     * @Title: uploadFile_rename
     * @Description: 上传文件(重命名)
     * @param file
     * @param filePath
     * @return
     */
    public static String uploadFile_rename(MultipartFile file, StringBuffer filePath)
    {
        String newFileName = null;
        try
        {
            File dir = new File(filePath.toString());// 文件保存路径
            if (!dir.exists())
            {
                //  dir.mkdirs();
                boolean mksflag = dir.mkdirs();
                if (!mksflag){
                    throw new IOException("try to mkdirs fail") ;
                }

            }
            String originalFilename = file.getOriginalFilename();
            int dot = originalFilename.lastIndexOf(".");
            String extension = "";
            if (dot > 0)
            {
                extension = originalFilename.substring(dot, originalFilename.length());
            }
            newFileName = UUID.randomUUID().toString() + extension;// 新的文件名
            filePath.append("/" + newFileName);
            File out = new File(filePath.toString());
            FileCopyUtils.copy(file.getBytes(), out);// 上传
            filePath.delete(0, filePath.length());
        }
        catch (Exception e)
        {
            log.error("uploadFile_rename is error: {}", e);
        }
        return newFileName;
    }
    /**
     * @Title: downloadFile
     * @Description: 下载文件
     * @param urlPath
     *            文件完整路径(包括文件名和扩展名)
     * @param filePath
     *            下载后看到的文件名
     */
    public static void downloadFile(String urlPath, String filePath)
    {
        File dirFile = new File(filePath);
        if (!dirFile.exists())
        {
            // 文件路径不存在时，自动创建目录
            // dirFile.mkdir();
            boolean mkflag = dirFile.mkdir();
            log.info("mkflag is" +String.valueOf(mkflag));

        }
        // 构造URL
        URL url = null;
        try {
            url = new URL(urlPath);
        } catch (MalformedURLException e) {
            log.info("MalformedURL Exception" );
        }
        // 打开连接
        URLConnection connection = null;
        try {
            if(url!=null) {
                connection = url.openConnection();
            }
        } catch (IOException e) {
            log.info("IOException Exception" );
        } catch (RuntimeException e) {
            log.info("NullPointerException Exception");
        }

        // 输入流
        InputStream in = null;
        try {
            if (null != connection) {
                in = connection.getInputStream();
            }
        } catch (IOException e) {
            log.info("IOException Exception" );
        } catch (RuntimeException e) {
            log.info("NullPointerException Exception");
        }

        // 输出的文件流
        FileOutputStream os = null;
        try {
            os = new FileOutputStream(filePath);
        } catch (FileNotFoundException e) {
            log.info("FileNotFoundException Exception" );
        }
        // 1K的数据缓冲
        byte[] buffer = new byte[1024];
        // 读取到的数据长度
        int read;
        // 开始读取
        try {
            if (null != os && null != in) {
                while(-1 != (read = in.read(buffer, 0, buffer.length)))
                {
                    os.write(buffer, 0, read);
                }
            } else {
                throw new NullPointerException();
            }
        } catch (IOException e) {
            log.info("IOException Exception" );
        } catch (RuntimeException e) {
            log.info("NullPointerException Exception");
        }

        // 完毕，关闭所有链接
        if (os != null) {
            try {
                os.close();
            } catch (IOException e) {
                log.info("IOException Exception" );
            } catch (RuntimeException e) {
                log.info("NullPointerException Exception");
            }
        }

        if (in != null) {
            try {
                in.close();
            } catch (IOException e) {
                log.info("IOException Exception" );
            } catch (RuntimeException e) {
                log.info("NullPointerException Exception");
            }
        }
    }
    /**
     * @Title: fileDownload
     * @Description: 下载文件
     * @param request
     * @param response
     * @param storeName
     * @param contentType
     * @param realName
     */
    public static void
        fileDownload(HttpServletRequest request, HttpServletResponse response, String storeName,
                     String contentType, String realName)
    {
        response.setContentType("text/html;charset=UTF-8");
        try {
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            log.info("UnsupportedEncoding error ");
        }
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        String ctxPath = request.getSession().getServletContext().getRealPath("");
        String downLoadPath = ctxPath + storeName;
        if(StringUtils.isBlank(downLoadPath)){
            throw new NariException("downLoadPath is not null");
        }
        long fileLength = new File(downLoadPath).length();
        response.setContentType(contentType);
        try {
            response.setHeader("Content-disposition",
                "attachment; filename=" + new String(realName.getBytes("utf-8"), "ISO8859-1"));
        } catch (UnsupportedEncodingException e) {
            log.info("UnsupportedEncoding error ");
        }
        response.setHeader("Content-Length", String.valueOf(fileLength));
        try {
            bis = new BufferedInputStream(new FileInputStream(downLoadPath));
        } catch (FileNotFoundException e) {
            log.info("FileNotFoundException error ");
        }
        try {
            bos = new BufferedOutputStream(response.getOutputStream());
        } catch (IOException e) {
            log.info("IOException error ");
        }
        byte[] buff = new byte[2048];
        int bytesRead;

        try {
            if (null != bis) {
                while (-1 != (bytesRead = bis.read(buff, 0, buff.length)))
                {
                    if (null != bos) {
                        bos.write(buff, 0, bytesRead);
                    } else {
                        throw new NullPointerException("空文件无法写入");
                    }
                }
            } else {
                throw new NullPointerException("空文件无法读取");
            }
        } catch (IOException e) {
            log.info("IOException error");
        } catch (RuntimeException e) {
            log.info("NullPointerException error");
        }

        try {
            if (null == bis || null == bos) {
                throw new NullPointerException();
            }
            bos.close();
        } catch (IOException e) {
            log.info("IOException error ");
        } catch (RuntimeException e) {
            log.info("NullPointerException error");
        } finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    log.error(e.toString());
                }
            }
        }
    }
    public static String getFileSizeToKB(Long size)
    {
        String result = "0";
        if (size != null)
        {
            DecimalFormat df2 = new DecimalFormat("###.0");
            result = df2.format(size / 1024.0);
        }
        return result;
    }
    // 导入群发时读取
    public static List<String> readFile(MultipartFile file) throws IOException {
        List<String> list = new ArrayList<>();
        InputStream in=null;
        BufferedReader br=null;
        try
        {
            // File temp= new File("temp.txt");
            // file.transferTo(temp);
            /*InputStream in = file.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(in));*/
            in = file.getInputStream();
            br = new BufferedReader(new InputStreamReader(in));
            String s = null;
            while ((s = br.readLine()) != null)
            {// 使用readLine方法，一次读一行
                list.add(s);
            }
           /* if (in != null) {
                in.close();
            }
            if (br != null) {
                br.close();
            }*/
        }
        catch (Exception e)
        {
            log.error("readFile is error: {}", e);
        }finally {
            if (in != null) {
                in.close();
            }
            if (br != null) {
                br.close();
            }
        }
        return list;
    }
    /**
     * @Title: removeFile
     * @Description: 删除文件
     * @param request
     * @param fileUrl
     */
    public static void removeFile(HttpServletRequest request, String fileUrl)
    {
        try
        {
            boolean b = false;
            String realPath = request.getSession().getServletContext().getRealPath("");
            String filePath = realPath + fileUrl;
            File file = new File(filePath);
            if (file != null && file.exists() && file.isFile())
            {
                b = file.delete();
            }
            log.info(" remove file result  = " + b);
        }
        catch (Exception e)
        {
            log.error("removeFile is error: {}", e);
        }
    }
    /**
     * @Title: removeFile
     * @Description: 删除文件
     *
     * @param filePath
     */
    public static void removeFileFromPath( String filePath)
    {
        try
        {
            filePath=PathManipulationUtil.getFilePath(filePath);

            boolean b = false;
            File file = new File(filePath);
            if (file != null && file.exists() && file.isFile())
            {
                b = file.delete();
            }
            log.info(" remove file result  = " + b);
        }
        catch (Exception e)
        {
            log.error("removeFileFromPath is error: {}", e);
        }
    }
    public static boolean isNumber(String tel)
    {
        java.util.regex.Pattern pattern = java.util.regex.Pattern.compile("[0-9]*");
        java.util.regex.Matcher match = pattern.matcher(tel.replaceAll(" ", ""));
        if (match.matches() == false)
        {
            return false;
        }
        return true;
    }
    /**
     * 读写文件 - sql load control
     * 
     * @param request
     * @param fileName
     * @param tableName
     */
    public static boolean modifyFile(HttpServletRequest request, String fileName, String tableName) throws IOException {
        BufferedReader file1=null;
        BufferedWriter file2=null;

        try{
             file1 = new BufferedReader(new FileReader(
                request.getSession().getServletContext().getRealPath("/resources/control_m.ctl")));
             file2  = new BufferedWriter(new FileWriter(
                request.getSession().getServletContext().getRealPath("/resources/control.ctl")));
            // BufferedReader file1 = new BufferedReader(new
            // FileReader("F:\\Soft\\apache-tomcat-6.0.37\\webapps\\xwwt_web\\resources\\control_m.ctl"));
            // BufferedWriter file2 = new BufferedWriter(new
            // FileWriter("F:\\Soft\\apache-tomcat-6.0.37\\webapps\\xwwt_web\\resources\\control.ctl"));
            String s = null;
            while ((s = file1.readLine()) != null){
                s = s.replace("TELPHONE", fileName).replace("TABLE", tableName);
                file2.write(s);
                file2.newLine();
            }
            file2.flush();
            file1.close();
            file2.close();
            return true;

        }catch (Exception e) {
            log.error("modifyFile is error: {}", e);
        }finally{
            if(file1!=null){
                try {
                    file1.close();
                } catch (IOException e){
                    log.error(e.toString());
                }
            }
            if(file2!=null){
                try {
                    file2.close();
                } catch (IOException e){
                    log.error(e.toString());
                }
            }
        }
        return false;
    }

    public static List<String> getFileNameList(String path){
    	 List<String> fileNameLists = new ArrayList<String>();
        // get file list where the path has   
        File file = new File(path);   
        // get the folder list   
        File[] array = file.listFiles();   
          if(array != null ){
        	  for(int i=0;i<array.length;i++){   
                  if(array[i].isFile()){   
                  	fileNameLists.add(array[i].getName());
                  }else if(array[i].isDirectory()){   
                  	getFileNameList(array[i].getPath());   
                  }   
              }  
          }
        
        return fileNameLists;
    } 
    
    /**
     * 判断文件目录是否存在 不存在则创建
     * @param path
     */
    public static void isPathExist(String path) throws IOException {
    	  File file = new File(path);
          if (!file.exists()) {
             // file.mkdirs();
              //修复漏洞unchecked return value
              boolean mksflag = file.mkdirs();
              if (!mksflag){
                  throw new IOException("try to mkdirs fail") ;
              }
          }
    }
    
    /**
     * 按行读文件
     * @param path 文件路径
     * @return
     */
	public static List<String> readerFileByLine(String path) {
		List<String> arrayList = new ArrayList<>();
        BufferedReader bf = null;
		try {
            path=getFilePath(path);
			File file = new File(path);
			InputStreamReader inputReader = new InputStreamReader(new FileInputStream(file));
			bf = new BufferedReader(inputReader);
			// 按行读取字符串
			String str;
            int line = 1;
			if (bf != null) {
                while ((str = bf.readLine()) != null) {
                    arrayList.add(str);
                    line++;
                }
            } else {
			    throw new NullPointerException();
            }
			inputReader.close();
		} catch (IOException e) {
            log.error("readerFileByLine is error: {}", e);
		} catch (RuntimeException e) {
		    log.error(e.toString());
        } finally {
		    if (bf != null) {
		        try {
		            bf.close();
                } catch (IOException e) {
		            log.info(e.toString());
                }
            }
        }
		return arrayList;
	}



    public static String getFilePath(String path) {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("a", "a");
        map.put("b", "b");
        map.put("c", "c");
        map.put("d", "d");
        map.put("e", "e");
        map.put("f", "f");
        map.put("g", "g");
        map.put("h", "h");
        map.put("i", "i");
        map.put("j", "j");
        map.put("k", "k");
        map.put("l", "l");
        map.put("m", "m");
        map.put("n", "n");
        map.put("o", "o");
        map.put("p", "p");
        map.put("q", "q");
        map.put("r", "r");
        map.put("s", "s");
        map.put("t", "t");
        map.put("u", "u");
        map.put("v", "v");
        map.put("w", "w");
        map.put("x", "x");
        map.put("y", "y");
        map.put("z", "z");

        map.put("A", "A");
        map.put("B", "B");
        map.put("C", "C");
        map.put("D", "D");
        map.put("E", "E");
        map.put("F", "F");
        map.put("G", "G");
        map.put("H", "H");
        map.put("I", "I");
        map.put("J", "J");
        map.put("K", "K");
        map.put("L", "L");
        map.put("M", "M");
        map.put("N", "N");
        map.put("O", "O");
        map.put("P", "P");
        map.put("Q", "Q");
        map.put("R", "R");
        map.put("S", "S");
        map.put("T", "T");
        map.put("U", "U");
        map.put("V", "V");
        map.put("W", "W");
        map.put("X", "X");
        map.put("Y", "Y");
        map.put("Z", "Z");


        map.put(":", ":");
        map.put("/", "/");
        map.put("\\", "\\");
        map.put(".", ".");
        map.put("-", "-");
        map.put("_", "_");

        map.put("0", "0");
        map.put("1", "1");
        map.put("2", "2");
        map.put("3", "3");
        map.put("4", "4");
        map.put("5", "5");
        map.put("6", "6");
        map.put("7", "7");
        map.put("8", "8");
        map.put("9", "9");

        String temp = "";
        for (int i = 0; i < path.length(); i++) {

            if (map.get(path.charAt(i)+"")!=null) {
                temp += map.get(path.charAt(i)+"");
            }
        }
        path = temp;
        return path;
    }
}