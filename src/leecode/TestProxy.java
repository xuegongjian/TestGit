package leecode;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;



public class TestProxy {

	public static void main(String[] args) throws IOException{
		
//		System.setProperty("http.proxyHost", "squid.caiwu.corp");
//		System.setProperty("http.proxyPort", "3128");
//		System.setProperty("https.proxyHost", "squid.caiwu.corp");
//		System.setProperty("https.proxyPort", "3128");
//		System.setProperty("http.nonProxyHosts", "localhost|10.*|66.*|127.0.0.1|*.corp|*.idc");
//		
		System.out.println("IN");
		useUrlConnectionForTainWei(null,2000,null);
		System.out.println("SUCCESS");
		
	}
	
	
	// 临时加个方法
		private static String useUrlConnectionForTainWei(
				Map<String, Object> requestMap, int timeout, String operation) {
			URL httpUrl = null;
			HttpURLConnection conn = null;
			BufferedReader reader = null;
			try {
				// 建立链接
				httpUrl = new URL("http://yixin.itrus.com.cn:6443/rest/eApply");
				Proxy proxy = new Proxy(Proxy.Type.DIRECT.HTTP, new InetSocketAddress("squid.caiwu.corp", 3128));
				conn = (HttpURLConnection) httpUrl.openConnection(proxy);
				conn.setDoOutput(true); // 设置是否向HttpURLConnection输出
				conn.setDoInput(true); // 设置是否从HttpURLConnection读入
				conn.setUseCaches(false); // 是否使用缓存
				conn.setRequestMethod("POST");
				conn.setConnectTimeout(timeout);
				conn.setReadTimeout(timeout);
				conn.setRequestProperty("Content-type", "application/json"); // 传输形式是json格式
				conn.connect();
				
				// 封装参数
				String jsonStr = "";//JSON.toJSONString(requestMap);
				// 写入数据
				OutputStream outputStream = conn.getOutputStream();
				outputStream.write(jsonStr.getBytes("UTF-8"));
				outputStream.close();
				// 获取出参
				StringBuffer sb = new StringBuffer();
				reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				String lines;
				while ((lines = reader.readLine()) != null) {
					lines = new String(lines.getBytes(), "utf-8");
					sb.append(lines);
				}
				return sb.toString();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (null != reader) {
					try {
						reader.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				if (null != conn) {
					conn.disconnect();
				}

			}
			return "";
		}
		
	public static void getTSAResponse(byte[] requestBytes) throws IOException {
        // Setup the TSA connection
        URL url = new URL("https://open.itruscloud.com/apigate/timestampapi?serviceCode=TSA0005");
        URLConnection tsaConnection;
        try {
        	tsaConnection = (URLConnection) url.openConnection();
        }
        catch (IOException ioe) {
        	ioe.printStackTrace();
            throw new IOException(ioe);
        }
        tsaConnection.setDoInput(true);
        tsaConnection.setDoOutput(true);
        tsaConnection.setUseCaches(false);

        
        tsaConnection.setRequestProperty("Content-Type", "application/json");
//        tsaConnection.setRequestProperty("Content-Type", "application/timestamp-query");
        //tsaConnection.setRequestProperty("Content-Transfer-Encoding", "base64");
//        tsaConnection.setRequestProperty("Content-Transfer-Encoding", "binary");
        tsaConnection.connect();
//        OutputStream out = tsaConnection.getOutputStream();
//        out.write(requestBytes);
//        out.close();
        
        // Get TSA response as a byte array
        InputStream inp = tsaConnection.getInputStream();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int bytesRead = 0;
        while ((bytesRead = inp.read(buffer, 0, buffer.length)) >= 0) {
            baos.write(buffer, 0, bytesRead);
        }
        byte[] respBytes = baos.toByteArray();
        
        System.out.println(new String(respBytes));
    }  
}



