package Utils;

import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @ Author     ：CstomRita
 * @ Date       ：Created in 上午8:48 2018/10/3
 * @ Description：HttpClient发送请求
 * @ Modified By：
 * @Version: $
 */

public class HttpClientUtil {

    //创建一个HTTPClient对象
    //处理请求参数(URL传参先创建传参的URL再创建POST/GET对象，POST主体带参就先创建POST对象再写参数入主体区)
    //创建一个POST/GET对象
    //执行请求
    //响应的结果
    //关闭HTTPClient对象

    /**
     * Get带参结果
     *
     * @param url
     * @param param Map
     * @return
     */
    public static String doGet(String url, Map<String, String> param) {

        CloseableHttpResponse response = null;
        String result = "";

        //1 创建HTTPClient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        try {
            // 2创建URL,因为是get方法，需要把参数加在URL后面
            URIBuilder builder = new URIBuilder(url);
            if (param != null) {
                for (String key : param.keySet()) {
                    builder.addParameter(key, param.get(key));
                }
            }
            URI uri = builder.build();
            // 3 创建一个GET对象
            HttpGet httpGet = new HttpGet(uri);
            // 4 执行请求
            response = httpClient.execute(httpGet);
            // 5 取响应结果，如果state=200，取出结果
            if (response.getStatusLine().getStatusCode() == 200) {
                result = EntityUtils.toString(response.getEntity(), "UTF-8");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                //6 关闭responese、HTTPClient对象
                if (response != null) {
                    response.close();
                }
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    /**
     * POST带参请求
     *
     * @param url
     * @param param Map
     * @return
     */
    public static String doPost(String url, Map<String, String> param) {
        CloseableHttpResponse response = null;
        String result = "";

        //1 创建HTTPClient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        try {
            //2 创建一个POST请求对象，这里写入body区，先创建POST对象再将参数传入BODY区
            HttpPost httpPost = new HttpPost(url);
            //3 参数列表写入主体区，通过模拟表单提交 post.setEntity(entity)
            if (param != null) {
                // 3.1模拟表单
                List<NameValuePair> parmList = new ArrayList<>();
                for (String key : param.keySet()) {
                    parmList.add(new BasicNameValuePair(key, param.get(key)));
                }
                // 3.2 包装成一个Entity，提交
                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(parmList);
                httpPost.setEntity(entity);
            }
            //4 执行请求
            response = httpClient.execute(httpPost);
            //5 取响应结果
            result = EntityUtils.toString(response.getEntity(), "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 6 关闭对象
            try {
                response.close();
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    /**
     * POST无参数请求
     *
     * @param url
     * @return
     */
    public static String doPost(String url) {
        return doPost(url, null);
    }

    /**
     * GET无参数请求
     *
     * @param url
     * @return
     */
    public static String doGet(String url) {
        return doGet(url, null);
    }

    /**
     * POST带JSon格式参数请求
     * @param url
     * @param json
     * @return
     */
    public static String doPostJson(String url, String json) {
        CloseableHttpResponse response = null;
        String result = "";

        // 创建Httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        try {
            // 创建Http Post请求
            HttpPost httpPost = new HttpPost(url);
            // 创建请求内容
            StringEntity entity = new StringEntity(json, ContentType.APPLICATION_JSON);
            httpPost.setEntity(entity);
            // 执行http请求
            response = httpClient.execute(httpPost);
            result = EntityUtils.toString(response.getEntity(), "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                response.close();
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
