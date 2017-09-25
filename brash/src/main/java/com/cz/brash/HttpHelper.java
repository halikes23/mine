package com.cz.brash;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;




public class HttpHelper {
	
	private static int connectTimeOut = 5000;
	private static int readTimeOut = 10000;
	private final static String REQUEST_ENCODING = "UTF-8";
	public static int getConnectTimeOut() {
		return connectTimeOut;
	}
	public static void setConnectTimeOut(int connectTimeOut) {
		HttpHelper.connectTimeOut = connectTimeOut;
	}
	public static int getReadTimeOut() {
		return readTimeOut;
	}
	public static void setReadTimeOut(int readTimeOut) {
		HttpHelper.readTimeOut = readTimeOut;
	}
	public static String getRequestEncoding() {
		return REQUEST_ENCODING;
	}
	
	public static String doGet(String requrl,Map<?,?> parameters,String recvEncoding){
		HttpURLConnection url_con=null;
		StringBuilder responseContent = new StringBuilder();
		String vchartset= StringUtils.isEmpty(recvEncoding)?HttpHelper.REQUEST_ENCODING:recvEncoding;
		try {
				StringBuffer params=new StringBuffer();
				Iterator<?> iter=parameters.entrySet().iterator() ;
				while (iter.hasNext()) {
					Entry<?, ?> element=(Entry<?, ?>) iter.next();
					params.append(element.getKey().toString());
					params.append("=");
					params.append(URLEncoder.encode(element.getValue().toString(),vchartset));
					params.append("&");
				}
				if(params.length()>0){
					params=params.deleteCharAt(params.length()-1);
				}
				URL url=new URL(requrl);
				url_con=(HttpURLConnection) url.openConnection();
				url_con.setRequestMethod("GET");
				System.setProperty("连接超时：", String.valueOf(HttpHelper.connectTimeOut));
				System.setProperty("访问超时：", String.valueOf(HttpHelper.readTimeOut)); 
				url_con.setDoOutput(true);//
				byte[] b=params.toString().getBytes();
				url_con.getOutputStream().write(b, 0,b.length);
				url_con.getOutputStream().flush();
				url_con.getOutputStream().close();
				InputStream in=url_con.getInputStream();
				byte[] echo=new byte[10*1024];
				int len ;
				while(( len = in.read(echo) )!=-1){
					responseContent.append(new String(echo,0,len,vchartset)) ;
				}
				int code = url_con.getResponseCode();
				if (code != 200) {
					return "ERROR" + code;
				}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(url_con!=null){
				url_con.disconnect();
			}
		}
		return responseContent.toString();
		
	}
	public static String doGet(String reqUrl, String recvEncoding) {
		return doGet(reqUrl,new HashMap<String,Object>(),recvEncoding);
		
	}
	
	public static String doPost(String reqUrl, Map<String, String> parameters) throws IOException{
		return doPost( reqUrl,  parameters, "" , HttpHelper.REQUEST_ENCODING );
	}
	
	public static String doPost(String reqUrl, Map<String, String> parameters , String body , String recvEncoding) throws IOException{
		HttpURLConnection url_con = null;
		StringBuilder responseContent = new StringBuilder();
		String vchartset=StringUtils.isEmpty(recvEncoding)?HttpHelper.REQUEST_ENCODING:recvEncoding;
		try {
			
			
			int idx = 0 ;
			StringBuffer params = new StringBuffer();
			for (Iterator<?> iter = parameters.entrySet().iterator(); iter.hasNext();) {
				Entry<?, ?> element = (Entry<?, ?>) iter.next();
				params.append(element.getKey().toString());
				params.append("=");
				params.append(URLEncoder.encode(element.getValue().toString(), vchartset));
				idx ++ ;
				if(parameters.size() != idx){
					params.append("&");
				}
			}

			if(reqUrl.indexOf("?") == -1 && parameters.size() > 0){
				reqUrl = reqUrl + "?" ;
			}
			reqUrl =  reqUrl + params ;
			URL url = new URL(reqUrl);
			
			url_con = (HttpURLConnection) url.openConnection();
			url_con.setRequestMethod("POST");
			url_con.setConnectTimeout(HttpHelper.connectTimeOut);
			url_con.setReadTimeout(HttpHelper.readTimeOut);
			url_con.setDoOutput(true);
			
			
			byte[] b = body.getBytes();
			url_con.getOutputStream().write(b, 0, b.length);
			url_con.getOutputStream().flush();
			url_con.getOutputStream().close();

			InputStream in = url_con.getInputStream();
			byte[] echo = new byte[10 * 1024];
			int len ;
			while(( len = in.read(echo) )!=-1){
				responseContent.append(new String(echo,0,len,recvEncoding)) ;
			}
			
			int code = url_con.getResponseCode();
			if (code != 200) {
				return "ERROR" + code;
			}

		}catch (IOException e) {
			e.printStackTrace();
			throw e ;
		}finally {
			if (url_con != null) {
				url_con.disconnect();
			}
		}
		return responseContent.toString();
	}
	
	/**
	 * 
	 * @param reqUrl 请求url
	 * @param parameters 请求变量
	 * @param requestProperties 请求参数 列：Content-Type:application/json;charset=utf-8
	 * @param recvEncoding 编码
	 * @return
	 */
	public static String sendGet(String url, Map<?,?> parameters , String recvEncoding) throws UnsupportedEncodingException {  
        String result = "";  
        BufferedReader in = null;  
        String vchartset=StringUtils.isEmpty(recvEncoding)?REQUEST_ENCODING:recvEncoding;
        StringBuffer params=new StringBuffer();
		Iterator<?> iter=parameters.entrySet().iterator() ;
		while (iter.hasNext()) {
			Entry<?, ?> element=(Entry<?, ?>) iter.next();
			params.append(element.getKey().toString());
			params.append("=");
			params.append(URLEncoder.encode(element.getValue().toString(),vchartset));
			params.append("&");
		}
		if(params.length()>0){
			params=params.deleteCharAt(params.length()-1);
		}
        try {  
            String urlName = url + "?" + params;  
            URL realUrl = new URL(urlName);  
            // 打开和URL之间的连接  
            URLConnection conn = realUrl.openConnection();  
            // 设置通用的请求属性  
            conn.setRequestProperty("accept", "*/*");  
            conn.setRequestProperty("connection", "Keep-Alive");  
            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");  
            // 建立实际的连接  
            conn.connect();  
            // 定义BufferedReader输入流来读取URL的响应  
            in = new BufferedReader(new InputStreamReader(conn.getInputStream() ,"UTF-8"));  
            String line;  
            while ((line = in.readLine()) != null) {  
                result += "\n" + line;  
            }  
        } catch (Exception e) {  
            System.out.println("发送GET请求出现异常！" + e);  
            e.printStackTrace();  
        }  
        // 使用finally块来关闭输入流  
        finally {  
            try {  
                if (in != null) {  
                    in.close();  
                }  
            } catch (IOException ex) {  
                ex.printStackTrace();  
            }  
        }  
        return result;  
    }  
	public static void main(String[] args) {
		Map<String,String > params = new HashMap<String,String>() ; 
		try {
			params.put("KEY1", "VALUE1");
			HttpHelper.doPost("http://192.168.1.60:4700/", params, "body", "UTF-8") ;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static File download(String cutedUrl, String fileName) throws IOException {
		HttpURLConnection url_con=null;
		File file = new File(fileName) ;
		if(!file.getParentFile().exists()){
			file.getParentFile().mkdirs() ;
		}
		if(!file.exists()){
			file.createNewFile() ;
		}
		FileOutputStream fileWriter = new FileOutputStream(file) ;
		try {
				URL url=new URL(cutedUrl);
				url_con=(HttpURLConnection) url.openConnection();
				url_con.setRequestMethod("POST");
				url_con.setDoOutput(true);//
				url_con.getOutputStream().flush();
				url_con.getOutputStream().close();
				InputStream in=url_con.getInputStream();
				byte[] echo=new byte[10*1024];
				int len ;
				while(( len = in.read(echo) )!=-1){
					fileWriter.write(echo,0,len);
				}
				
				int code = url_con.getResponseCode();
				if (code != 200) {
					throw new Exception("response code : " + code + " message : " + url_con.getResponseMessage()) ;
				}
				return file ;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(url_con!=null){
				url_con.disconnect();
			}
			if(fileWriter!=null){
				fileWriter.close();
			}
		}
		return null ;
		
	}
}
