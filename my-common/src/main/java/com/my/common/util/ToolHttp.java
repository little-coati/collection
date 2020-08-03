package com.my.common.util;

import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ReflectionUtils;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;

/**
 * ToolHttp （类说明）
 *
 * @author xuyingyang
 * @maven {<dependency> <groupId>org.apache.httpcomponents</groupId>
 *        <artifactId>httpclient</artifactId> <version>4.5.2</version> </dependency>}
 *        {<dependency> <groupId>org.json</groupId> <artifactId>json</artifactId>
 *        <version>20140107</version> </dependency>}
 */
public class ToolHttp
{
	private static Logger logger = LoggerFactory.getLogger( ToolHttp.class );

	/** HTTP请求超时时间单位毫秒 */
	private static int CONNECT_TIMEOUT = 6000;

	/** HTTP读取超时时间单位毫秒 */
	private static int READ_TIMEOUT = 6000;

	/** 默认请求参数配置, 防止多线程参数混乱 */
	private static ThreadLocal<RequestConfig> commReqCfg = new ThreadLocal<>();

	private static final int MAX_DATA = 1024;

	private static final int EXPECTED_BUFFER_DATA = 1024;

	ToolHttp()
	{
		commReqCfg.set( RequestConfig.custom().setConnectionRequestTimeout( CONNECT_TIMEOUT ).setConnectTimeout( READ_TIMEOUT )
		        .setSocketTimeout( CONNECT_TIMEOUT ).build() );
	}

	/**
	 * 初始化请求配置
	 *
	 * @param CONNECT_TIMEOUT 连接超时时间单位毫秒
	 * @param READ_TIMEOUT 读取超时时间单位毫秒
	 */
	ToolHttp(int CONNECT_TIMEOUT, int READ_TIMEOUT)
	{
		commReqCfg.set( RequestConfig.custom().setConnectionRequestTimeout( CONNECT_TIMEOUT ).setConnectTimeout( READ_TIMEOUT )
		        .setSocketTimeout( CONNECT_TIMEOUT ).build() );
	}

	/**
	 * POST 请求
	 *
	 * @param client
	 * @param url 请求Url
	 * @param data 请求参数
	 * @return 返回流
	 */
	private static InputStream requestPost( CloseableHttpClient client, String url, String data )
	{
		HttpPost post = new HttpPost( url );
		post.addHeader("Content-Type","application/json");
		post.setConfig( commReqCfg.get() );
		if (null != data)
		{
			HttpEntity entity = new StringEntity( data, "utf-8" );
			post.setEntity( entity );
		}

		try {
			// 获取请求
			CloseableHttpResponse response = null;
			response = client.execute( post );
			return response.getEntity().getContent();
		} catch (IOException e) {
			logger.error("method requestPost error");
			return null;
		}
	}

	/**
	 * POST 请求
	 *
	 * @param url 请求的Url
	 * @param data 请求的参数
	 * @return 返回响应的字符串
	 */
	public static String post( String url, String data )
	{
		logger.info( "Http发送Post请求，Url：" + url + "; 参数：" + data );
		CloseableHttpClient client = HttpClientBuilder.create().build();
		InputStream is = null;
		StringBuilder strB = new StringBuilder(EXPECTED_BUFFER_DATA);
		try
		{
			is = requestPost( client, url, data );
			byte[] bts = new byte[1024];
			int len = -1;
			while ( ( len = is.read( bts ) ) != -1 )
			{
				String s = new String(bts, 0, len, "utf-8");
				if (s.length() < MAX_DATA) {
					strB.append(s);
				}
			}
			is.close();
			client.close();
		}
		catch ( Exception e )
		{
			logger.error( "Http发送Post请求错误，Url：" + url + "; 参数：" + data, e );
			//throw e;
		}
		finally
		{
			close( is );
			try
			{
				client.close();
			}
			catch ( Exception e )
			{
				logger.warn( "Http发送Post关闭连接流错误" );
			}
		}
		logger.info( "Http发送Post请求，Url：" + url + "; 参数：" + data + "; 结果：" + strB.toString() );
		logger.info( "结果" + data );
		return data;
	}

	/**
	 * POST 请求
	 *
	 * @param url 请求的Url
	 * @return 返回响应的字符串
	 */
	public static String post( String url )
	{
		logger.info( "Http发送Post请求，Url：" + url );
		CloseableHttpClient client = HttpClientBuilder.create().build();
		InputStream is = null;
		StringBuffer strB = new StringBuffer(EXPECTED_BUFFER_DATA);
		try
		{
			is = requestPost( client, url, null );
			byte[] bts = new byte[1024];
			int len = -1;
			while ( ( len = is.read( bts ) ) != -1 )
			{
				String s = new String(bts, 0, len, "utf-8");
				if (s.length() < MAX_DATA) {
					strB.append(s);
				}
			}
			is.close();
			client.close();
		}
		catch ( Exception e )
		{
			logger.error( "Http发送Post请求错误，Url：" + url, e );
			//throw e;
		}
		finally
		{
			close( is );
			try
			{
				client.close();
			}
			catch ( Exception e )
			{
				logger.warn( "Http发送Post关闭连接流错误" );
			}
		}
		logger.info( "Http发送Post请求，Url：" + url + "; 结果：" + strB.toString() );
		return strB.toString();
	}


	/**
	 * 关闭Http连接
	 *
	 * @param io
	 */
	private static void close( Closeable io )
	{
		if (io != null)
		{
			try
			{
				io.close();
			}
			catch ( Exception e )
			{
				logger.error( "关闭Http连接失败", e );
			}
		}
	}

	/**
	 * @description <描述>
	 * @param object
	 * @return String 返回类型
	 * @author xuYingYang
	 * @version V1.0
	 * @date 2018年6月10日
	 * @email xuyingyang_cloud@sina.com
	 */
	public static String getStringByBean( Object object )
	{

		try
		{
			if (null == object)
			{
				logger.warn( "获取bean中的所有属性进行拼装URL失败, 参数为空{}", object );
				return null;
			}
			StringBuffer sb = new StringBuffer();
			Field[] fields = object.getClass().getDeclaredFields();
			for ( Field f : fields )
			{
				ReflectionUtils.makeAccessible(f);
				Object strSql = f.get( object );
				sb.append( "&" );
				sb.append( f.getName() );
				sb.append( "=" );
				sb.append( strSql == null ? "" : strSql + "" );
			}

			return sb.toString();
		}
		catch ( Exception e )
		{
			logger.error( "获取bean中的所有属性进行拼装URL失败", e );
		}

		return null;
	}

}
