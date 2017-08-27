package hello;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class ReadText {
	
	private static int RANDOM_LETHED = 231;
	
	 public static void readTxtFile(String filePath){
	        try {
	                String encoding="GBK";
	                File file=new File(filePath);
	                if(file.isFile() && file.exists()){ //判断文件是否存在
	                    InputStreamReader read = new InputStreamReader(
	                    new FileInputStream(file),encoding);//考虑到编码格式
	                    BufferedReader bufferedReader = new BufferedReader(read);
	                    String lineTxt = null;
	                    long i = 0;
	                    int ran = (int)(Math.random()*RANDOM_LETHED);
	                    System.out.println(ran);
	                    while((lineTxt = bufferedReader.readLine()) != null){
	                    	i++;
	                    	if(i==ran) {
	                    		String[] arr = lineTxt.split("\\s+");
	                    		for(String ss : arr) {
	    	                    	System.out.println(ss);
	    	                    }
	                    		System.out.println(arr.length);
	                    		break;
	                    	}
	                        //System.out.println(lineTxt);
	                    }
	                    
	                    
	                    read.close();
	                }else{
	                	System.out.println("找不到指定的文件");
	                }
	        } catch (Exception e) {
	            System.out.println("读取文件内容出错");
	            e.printStackTrace();
	        }
	     
	    }
	 
	 private String getFile(String fileName) {
	        ClassLoader classLoader = getClass().getClassLoader();
	        /**
	        getResource()方法会去classpath下找这个文件，获取到url resource, 得到这个资源后，调用url.getFile获取到 文件 的绝对路径
	        */
	        URL url = classLoader.getResource(fileName);
	        /**
	         * url.getFile() 得到这个文件的绝对路径
	         */
	       return url.getFile();
//	        File file = new File(url.getFile());
//	        System.out.println(file.exists());
	    }
	 
	 public static void main(String argv[]){
	  
		 ReadText rText = new ReadText();
		
	       String filePath = rText.getFile("word.txt");
//	      "res/";
	        readTxtFile(filePath);
	    }
	

}
