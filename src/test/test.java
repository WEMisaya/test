package test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;


public class test {
	public static double getCost() {
		return cost;
	}




	public static void setCost(double cost) {
		test.cost = cost;
	}




	public static double getSign() {
		return sign;
	}




	public static void setSign(double sign) {
		test.sign = sign;
	}

	private static double cost = 0 ;
	private static double sign = 0 ;
	
	public static void main(String[] args) throws Exception {
	
//		String zipFile = "C:/Users/jinyonghang/Desktop/test/mer.zip";
//		String descDir = "C:/Users/jinyonghang/Desktop/test/fileTest/";
//	
//		unZip(zipFile,descDir);
//	
//		
//		String from = "C:/Users/jinyonghang/Desktop/test/fileTest/mer/image/";
//		String to = "C:/Users/jinyonghang/Desktop/test/img/";
//		MoveFolderAndFileWithSelf(from, to);
		
//		double a = Double.parseDouble("0.001");
//		double b = Double.parseDouble("0.0011");
//		System.out.println(a+" - "+b);
//		
//		cost = a;
//		System.out.println(getCost());
//		cost = b;
//		System.out.println(getCost());
//		String abc = "1234567890";
//		System.out.println(abc.substring(0,abc.length()-1));
		

//		String date = convertTimeStampToString(new Date(), "YYMMDD");
//		System.out.println(date);
		ArrayList<String[]> list = new ArrayList<>();
		list.ensureCapacity(10);
		for (int i = 0; i < 10; i++) {
			list.add(new String[]{"1","2"});
		}
		
		for (int i = 0; i < list.size(); i++) {
			String[] temp = list.get(i);
			//System.out.println(temp[0]+"  "+temp[1]);
			temp[0] = "3";
		}
		for (int i = 0; i < list.size(); i++) {
			String[] temp = list.get(i);
			System.out.println(temp[0]+"  "+temp[1]);
		
		}
		
	} 
	
	public static String convertTimeStampToString(java.util.Date asDate, String asPattern) {
		if (asDate == null)
			return "";
		SimpleDateFormat lFormat = new SimpleDateFormat();
		if ((asPattern != null) && (asPattern.length() > 0))
			lFormat.applyPattern(asPattern);
		return lFormat.format(asDate);
	}
	
	
	 private static void unZip(String zipFile,String descDir) throws IOException {  
	       File pathFile = new File(descDir);  
	       if(!pathFile.exists()){  
	           pathFile.mkdirs();  
	       }  
	       @SuppressWarnings("resource")
			ZipFile zip = new ZipFile(zipFile);  
	       System.out.println("--------zip name:"+zip.getName());
	       int i=1;
	       for(Enumeration entries = zip.entries();entries.hasMoreElements();){
	    	   System.out.println("is "+i);
	    	   i++;
	           ZipEntry entry = (ZipEntry)entries.nextElement();  
	           String zipEntryName = entry.getName();  
	           InputStream in = zip.getInputStream(entry);  
	           String outPath = (descDir+zipEntryName).replaceAll("\\*", "/");;  
	           //�ж�·���Ƿ����,�������򴴽��ļ�·��  
	           File file = new File(outPath.substring(0, outPath.lastIndexOf('/')));  
	           if(!file.exists()){  
	               file.mkdirs();  
	           }  
	           //�ж��ļ�ȫ·���Ƿ�Ϊ�ļ���,����������Ѿ��ϴ�,����Ҫ��ѹ  
	           if(new File(outPath).isDirectory()){  
	        	   System.out.println("file is directory");
	               continue;  
	           }  
	           //����ļ�·����Ϣ  
	           System.out.println(outPath.substring(0, outPath.lastIndexOf('/')));  
	             
	           OutputStream out = new FileOutputStream(outPath);  
	           byte[] buf1 = new byte[1024];  
	           int len;  
	           while((len=in.read(buf1))>0){  
	               out.write(buf1,0,len);  
	           }  
	           in.close();  
	           out.close();  
	           }  
	       System.out.println("******************��ѹ���********************");  
	   }




	public static void MoveFolderAndFileWithSelf(String from, String to) throws Exception {  
	        try {  
	            File dir = new File(from);  
	            // Ŀ�� 
	            File moveDir = new File(to);  
	            if(dir.isDirectory()){  
	                if (!moveDir.exists()) {  
	                    moveDir.mkdirs();  
	                }  
	            }else{  
	                File tofile = new File(to);  
	                dir.renameTo(tofile);  
	                return;  
	            }  
	              
	            //System.out.println("dir.isDirectory()"+dir.isDirectory());  
	            //System.out.println("dir.isFile():"+dir.isFile());  
	              
	            // �ļ�һ��  
	            File[] files = dir.listFiles();  
	            if (files == null)  
	                return;  
	  
	            // �ļ��ƶ�  
	            for (int i = 0; i < files.length; i++) {  
	                System.out.println("�ļ�����"+files[i].getName());  
	                if (files[i].isDirectory()) {  
	                    MoveFolderAndFileWithSelf(files[i].getPath(), to);  
	                    // �ɹ���ɾ��ԭ�ļ�  
	                    files[i].delete();  
	                }  
	                File moveFile = new File(moveDir.getPath() + "/" + files[i].getName());  
	                // Ŀ���ļ����´��ڵĻ���ɾ��  
	                if (moveFile.exists()) {  
	                    moveFile.delete();  
	                }  
	                files[i].renameTo(moveFile);  
	            }  
	            dir.delete();  
	        } catch (Exception e) {  
	            throw e;  
	        }  
	    }  
	
	public static void unZipTest(){


		 long startTime=System.currentTimeMillis();  
	        try {  
	            ZipInputStream Zin=new ZipInputStream(new FileInputStream("C:\\Users\\jinyonghang\\Desktop\\bankparsenew.zip"));//����Դzip·��  
	            BufferedInputStream Bin=new BufferedInputStream(Zin);  
	            String Parent="C:\\Users\\jinyonghang\\Desktop"; //���·�����ļ���Ŀ¼��  
	            File Fout=null;  
	            ZipEntry entry;  
	            try {
	                while((entry = Zin.getNextEntry())!=null && !entry.isDirectory()){  
	                    Fout=new File(Parent,entry.getName());  
	                    if(!Fout.exists()){  
	                        (new File(Fout.getParent())).mkdirs();  
	                    }  
	                    FileOutputStream out=new FileOutputStream(Fout);  
	                    BufferedOutputStream Bout=new BufferedOutputStream(out);  
	                    int b;  
	                    while((b=Bin.read())!=-1){  
	                        Bout.write(b);  
	                    }  
	                    Bout.close();  
	                    out.close();  
	                    System.out.println(Fout+"��ѹ�ɹ�");      
	                }  
	                Bin.close();  
	                Zin.close();  
	            } catch (IOException e) {  
	                // TODO Auto-generated catch block  
	                e.printStackTrace();  
	            }  
	        } catch (FileNotFoundException e) {  
	            // TODO Auto-generated catch block  
	            e.printStackTrace();  
	        }  
	        long endTime=System.currentTimeMillis();  
	        System.out.println("�ķ�ʱ�䣺 "+(endTime-startTime)+" ms");  
	    
	}

	 /** 
     * ��ѹ�ļ���ָ��Ŀ¼ 
     * @param zipFile 
     * @param descDir 
     * @author isea533 
     */  
    @SuppressWarnings("rawtypes")  
    public static void unZipFiles(File zipFile,String descDir)throws IOException{  
        File pathFile = new File(descDir);  
        if(!pathFile.exists()){  
            pathFile.mkdirs();  
        }  
        @SuppressWarnings("resource")
		ZipFile zip = new ZipFile(zipFile);  
        for(Enumeration entries = zip.entries();entries.hasMoreElements();){  
            ZipEntry entry = (ZipEntry)entries.nextElement();  
            String zipEntryName = entry.getName();  
            InputStream in = zip.getInputStream(entry);  
            String outPath = (descDir+zipEntryName).replaceAll("\\*", "/");;  
            //�ж�·���Ƿ����,�������򴴽��ļ�·��  
            File file = new File(outPath.substring(0, outPath.lastIndexOf('/')));  
            if(!file.exists()){  
                file.mkdirs();  
            }  
            //�ж��ļ�ȫ·���Ƿ�Ϊ�ļ���,����������Ѿ��ϴ�,����Ҫ��ѹ  
            if(new File(outPath).isDirectory()){  
                continue;  
            }  
            //����ļ�·����Ϣ  
            System.out.println(outPath);  
              
            OutputStream out = new FileOutputStream(outPath);  
            byte[] buf1 = new byte[1024];  
            int len;  
            while((len=in.read(buf1))>0){  
                out.write(buf1,0,len);  
            }  
            in.close();  
            out.close();  
            }  
        System.out.println("******************��ѹ���********************");  
    }  

	public static int occurTimes(String string, String a) {

		int n = string.split(a).length;
		return n;
	}

}
