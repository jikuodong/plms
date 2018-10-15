package com.jikuodong.plms.utils;

import java.io.*;
import java.math.BigDecimal;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import java.util.regex.Pattern;

public class CommonUtils
{
	/**
	 * 字符串转MAD5
	 * 
	 * @param str
	 *            字符串
	 * @return
	 */
	public static String getMD5Str(String str)
	{
		if (str == null)
		{
			return null;
		}
		MessageDigest messageDigest = null;
		try
		{
			messageDigest = MessageDigest.getInstance("MD5");
			messageDigest.reset();
			messageDigest.update(str.getBytes("UTF-8"));
		}
		catch (NoSuchAlgorithmException e)
		{
			throw new RuntimeException(e);
		}
		catch (UnsupportedEncodingException e)
		{
			throw new RuntimeException(e);
		}

		byte[] byteArray = messageDigest.digest();

		StringBuffer md5StrBuff = new StringBuffer();

		for (int i = 0; i < byteArray.length; i++)
		{
			if (Integer.toHexString(0xFF & byteArray[i]).length() == 1)
				md5StrBuff.append("0").append(Integer.toHexString(0xFF & byteArray[i]));
			else md5StrBuff.append(Integer.toHexString(0xFF & byteArray[i]));
		}

		return md5StrBuff.toString();
	}

	/**
	 * 字符串转MAD5
	 * 
	 * @param str
	 *            字符串
	 * @param charset
	 *            字符集
	 * @return
	 */
	public static String getMD5Str(String str, String charset)
	{
		if (str == null)
		{
			return null;
		}
		MessageDigest messageDigest = null;
		try
		{
			messageDigest = MessageDigest.getInstance("MD5");
			messageDigest.reset();
			messageDigest.update(str.getBytes(charset));
		}
		catch (NoSuchAlgorithmException e)
		{
			throw new RuntimeException(e);
		}
		catch (UnsupportedEncodingException e)
		{
			throw new RuntimeException(e);
		}

		byte[] byteArray = messageDigest.digest();

		StringBuffer md5StrBuff = new StringBuffer();

		for (int i = 0; i < byteArray.length; i++)
		{
			if (Integer.toHexString(0xFF & byteArray[i]).length() == 1)
				md5StrBuff.append("0").append(Integer.toHexString(0xFF & byteArray[i]));
			else md5StrBuff.append(Integer.toHexString(0xFF & byteArray[i]));
		}
		return md5StrBuff.toString();
	}

	public static void copyfile(File infile, File outfile)
	{
		InputStream in = null;
		OutputStream out = null;
		int bufferSize = 2048;
		try
		{
			try
			{
				in = new BufferedInputStream(new FileInputStream(infile), bufferSize);
				out = new BufferedOutputStream(new FileOutputStream(outfile), bufferSize);
				byte[] buffer = new byte[bufferSize];
				int n = 0;
				while (-1 != (n = in.read(buffer)))
				{
					out.write(buffer, 0, n);
				}
			}
			catch (Exception e)
			{
				throw new RuntimeException(e);
			}
			finally
			{
				if (in != null)
				{
					in.close();
				}
				if (out != null)
				{
					out.close();
				}
			}
		}
		catch (Exception e)
		{
			throw new RuntimeException(e);
		}
	}

	public static String getExtention(String fileName)
	{
		if ((fileName == null) || (fileName.trim().length() == 0))
		{
			return "";
		}
		int pos = fileName.lastIndexOf(".");
		if (pos > -1)
		{
			return fileName.substring(pos);
		}

		return "";
	}

	public static int[] convertByteArrToIntArr(byte[] byteArr)
	{
		int remained = 0;
		int intNum = 0;
		remained = byteArr.length % 4;
		if (remained != 0)
		{
			throw new RuntimeException();
		}

		intNum = byteArr.length / 4;
		int[] intArr = new int[intNum];

		int j = 0;
		for (int k = 0; j < intArr.length; k += 4)
		{
			int ch1 = byteArr[k];
			int ch2 = byteArr[(k + 1)];
			int ch3 = byteArr[(k + 2)];
			int ch4 = byteArr[(k + 3)];

			if (ch1 < 0)
			{
				ch1 += 256;
			}
			if (ch2 < 0)
			{
				ch2 += 256;
			}
			if (ch3 < 0)
			{
				ch3 += 256;
			}
			if (ch4 < 0)
			{
				ch4 += 256;
			}
			intArr[j] = ((ch1 << 24) + (ch2 << 16) + (ch3 << 8) + (ch4 << 0));

			j++;
		}

		return intArr;
	}

	public static byte[] cuverIntArrToByteArr(int[] intArr)
	{
		int byteNum = intArr.length * 4;
		byte[] byteArr = new byte[byteNum];
		int curInt = 0;
		int j = 0;
		for (int k = 0; j < intArr.length; k += 4)
		{
			curInt = intArr[j];
			byteArr[k] = ((byte) (curInt >>> 24 & 0xFF));
			byteArr[(k + 1)] = ((byte) (curInt >>> 16 & 0xFF));
			byteArr[(k + 2)] = ((byte) (curInt >>> 8 & 0xFF));
			byteArr[(k + 3)] = ((byte) (curInt >>> 0 & 0xFF));

			j++;
		}

		return byteArr;
	}

	public static String getMapStringValue(Map<Object, Object> map, String key)
	{
		return map.get(key) != null ? map.get(key).toString().trim() : "";
	}

	public static String getMapDecimalValue(Map<Object, Object> map, String key)
	{
		return map.get(key) != null ? map.get(key).toString().trim() : "0";
	}

	public static String isNumericToValue(String str, int defaultValue)
	{
		Pattern pattern = Pattern.compile("^[\\d]*$");
		if (pattern.matcher(str).matches())
		{
			return str;
		}

		return String.valueOf(defaultValue);
	}

	public static int isNumericToIntValue(String str, int defaultValue)
	{
		Pattern pattern = Pattern.compile("^[\\d]*$");
		if (pattern.matcher(str).matches())
		{
			return toInt(str);
		}

		return defaultValue;
	}

	/**
	 * 判断字符串是否为null
	 * 
	 * @param value
	 * @return
	 */
	public static boolean isEmpty(String value)
	{
		return (value == null) || ("".equals(value));
	}

	/**
	 * 判断字符串是否为空
	 * 
	 * @param value
	 * @return
	 */
	public static boolean isBlank(String str)
	{
		int strLen;
		if ((str == null) || ((strLen = str.length()) == 0))
		{
			return true;
		}
		for (int i = 0; i < strLen; i++)
		{
			if (!Character.isWhitespace(str.charAt(i)))
			{
				return false;
			}
		}

		return true;
	}

	public static boolean isNotBlank(String str)
	{
		return !isBlank(str);
	}

	public static byte[] loadDirectory(File f, List<Map<String, Object>> list) throws IOException
	{
		if (list == null)
		{
			list = new ArrayList<Map<String, Object>>();
		}
		ByteArrayOutputStream bo = null;
		InputStream in = null;
		if (!f.isDirectory())
		{
			try {
				bo = new ByteArrayOutputStream();
				in = new FileInputStream(f);
				byte[] temByte = new byte[100];
				int byteread = 0;
				byteread = in.read(temByte);
				while (byteread != -1)
				{
					bo.write(temByte);
					byteread = in.read(temByte);
				}
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("fileName", f.getName());
				map.put("fileData", bo.toByteArray());
				list.add(map);
			} finally {
				if (null != in) {
					in.close();
				}
				if (null != bo) {
					bo.close();
				}
			}
		}
		else
		{
			File[] fs = f.listFiles();
			if (null != fs) {
				for (int i = 0; i < fs.length; i++)
				{
					File file = fs[i];
					loadDirectory(file, list);
				}
			}
		}
		byte[] bytes;
		ObjectOutputStream oo = null;
		try {
			bo = new ByteArrayOutputStream();
			oo = new ObjectOutputStream(bo);
			oo.writeObject(list);
			bytes = bo.toByteArray();
		} finally {
			if (null != bo) {
				bo.close();
			}
			if (null != oo) {
				oo.close();
			}
		}
		return bytes;
	}

	public static void downloadDirectory(byte[] bytes, String dir) throws Exception
	{
		File f = new File(dir);
		if (!f.exists())
			f.mkdir();

		List<?> list = null;
		try (ByteArrayInputStream bi = new ByteArrayInputStream(bytes); ObjectInputStream oi = new ObjectInputStream(bi)) {
			list = (List<?>) oi.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (list != null) {
			for (int i = 0; i < list.size(); i++) {
				try (OutputStream out = new FileOutputStream(dir + "\\" + ((Map<?, ?>) list.get(i)).get("fileName"))) {
					out.write((byte[]) ((Map<?, ?>) list.get(i)).get("fileData"));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static byte[] object2Bytes(Object obj) throws IOException
	{
		ByteArrayOutputStream bo = new ByteArrayOutputStream();
		ObjectOutputStream oo = new ObjectOutputStream(bo);
		oo.writeObject(obj);
		byte[] bytes = bo.toByteArray();
		bo.close();
		oo.close();
		return bytes;
	}

	public static Object bytes2Object(byte[] bytes) throws IOException, ClassNotFoundException
	{
		ByteArrayInputStream bi = new ByteArrayInputStream(bytes);
		ObjectInputStream oi = new ObjectInputStream(bi);
		Object obj = oi.readObject();
		bi.close();
		oi.close();
		return obj;
	}

	public static byte[] getBytesFromFile(File file) throws Exception
	{
		if (file == null)
		{
			return null;
		}
		byte[] ret = (byte[]) null;
		FileInputStream in = null;
		ByteArrayOutputStream out = null;
		try {
			in = new FileInputStream(file);
			out = new ByteArrayOutputStream();
			byte[] b = new byte[1024];
			int n;
			while ((n = in.read(b)) != -1)
			{
				out.write(b, 0, n);
			}
			ret = out.toByteArray();

		} finally {
			if (null != in) {
				in.close();
			}
			if (null != out) {
				out.close();
			}
		}
		return ret;
	}

	public static byte[] int2Bytes(int num)
	{
		byte[] byteNum = new byte[4];
		for (int ix = 0; ix < 4; ix++)
		{
			int offset = 32 - (ix + 1) * 8;
			byteNum[(4 - ix - 1)] = ((byte) (num >> offset & 0xFF));
		}
		return byteNum;
	}

	public static int bytes2Int(byte[] byteNum)
	{
		int num = 0;
		for (int ix = 0; ix < 4; ix++)
		{
			num <<= 8;
			num |= byteNum[(4 - ix - 1)] & 0xFF;
		}
		return num;
	}

	public static byte int2OneByte(int num)
	{
		return (byte) (num & 0xFF);
	}

	public static int oneByte2Int(byte byteNum)
	{
		return byteNum > 0 ? byteNum : 128 + (128 + byteNum);
	}

	public static byte[] long2Bytes(long num)
	{
		byte[] byteNum = new byte[8];
		for (int ix = 0; ix < 8; ix++)
		{
			int offset = 64 - (ix + 1) * 8;
			byteNum[ix] = ((byte) (int) (num >> offset & 0xFF));
		}
		return byteNum;
	}

	public static long bytes2Long(byte[] byteNum)
	{
		long num = 0L;
		for (int ix = 0; ix < 8; ix++)
		{
			num <<= 8;
			num |= byteNum[ix] & 0xFF;
		}
		return num;
	}

	public static File getFileFromBytes(byte[] b, String dir, String outputFile) throws Exception
	{
		File dirFile = new File(dir);
		File ret = new File(dir + "\\" + outputFile);
		if (!dirFile.exists())
		{
			dirFile.mkdirs();
		}
		if (!ret.exists())
		{
			dirFile.createNewFile();
		}
		FileOutputStream fstream = new FileOutputStream(ret);
		BufferedOutputStream stream = new BufferedOutputStream(fstream);
		stream.write(b);
		stream.close();
		fstream.close();
		return ret;
	}

	/**
	 * 生成UUID
	 * 
	 * @return
	 */
	public static String getNonceStr()
	{
		return UUID.randomUUID().toString().replace("-", "");
	}

	public static String getNonceStr(int length)
	{
		String base = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		int baseLength = base.length();
		Random random = new Random();
		StringBuilder sb = new StringBuilder();
		int num = 0;
		for (int i = 0; i < length; i++)
		{
			num = random.nextInt(baseLength);
			sb.append(base.charAt(num));
		}
		return sb.toString();
	}

	/**
	 * Object对象转字符串
	 * 
	 * @param val
	 * @return 字符串
	 */
	public static String toString(Object val)
	{
		return String.valueOf(val == null ? "" : val);
	}

	/**
	 * Object对象转int
	 * 
	 * @param val
	 * @return int
	 */
	public static int toInt(Object val)
	{
		try
		{
			return Integer.parseInt(toString(val));
		}
		catch (Exception e)
		{
		}
		return 0;
	}

	/**
	 * Object对象转Float
	 * 
	 * @param val
	 * @return Float
	 */
	public static float toFloat(Object val)
	{
		try
		{
			return Float.parseFloat(toString(val));
		}
		catch (Exception e)
		{
		}
		return 0.0F;
	}

	/**
	 * Object对象转Long
	 * 
	 * @param val
	 *            对象
	 * @return Long
	 */
	public static long toLong(Object val)
	{
		try
		{
			return Long.parseLong(toString(val));
		}
		catch (Exception e)
		{
		}
		return 0L;
	}

	/**
	 * Object对象转Double
	 * 
	 * @param val
	 *            对象
	 * @return Double
	 */
	public static double toDouble(Object val)
	{
		try
		{
			return Double.parseDouble(toString(val));
		}
		catch (Exception e)
		{
		}
		return 0.0D;
	}

	/**
	 * Object对象转BigDecimal
	 * 
	 * @param val
	 *            对象
	 * @return BigDecimal
	 */
	public static BigDecimal toBigDecimal(Object val)
	{
		try
		{
			return new BigDecimal(toString(val));
		}
		catch (Exception e)
		{
		}
		return new BigDecimal(0);
	}

	/**
	 * Object对象转Boolean
	 * 
	 * @param val
	 *            对象
	 * @return Boolean
	 */
	public static boolean toBoolean(Object val)
	{
		try
		{
			return Boolean.parseBoolean(toString(val));
		}
		catch (Exception e)
		{
			if (toInt(val) == 1)
			{
				return true;
			}
		}
		return false;
	}

	/**
	 * 拼接字符串
	 * 
	 * @param objs
	 * @return
	 */
	public static String concat(Object... objs)
	{
		StringBuilder sb = new StringBuilder();

		Object[] arrayOfObject = objs;
		int j = objs.length;
		for (int i = 0; i < j; i++)
		{
			Object obj = arrayOfObject[i];

			if (obj == null)
			{
				sb.append("");
			}
			else
			{
				sb.append(obj);
			}
		}

		return sb.toString();
	}

	public static String filterEmoji(String str)
	{
		if (isBlank(str))
		{
			return str;
		}

		return str.replaceAll("[\\ud800\\udc00-\\udbff\\udfff\\ud800-\\udfff]", "*");
	}

	public static int compareTo(String str1, String str2)
	{
		if ((isEmpty(str1)) && (isEmpty(str2)))
		{
			return 0;
		}
		if (isEmpty(str1))
		{
			return -1;
		}

		if (isEmpty(str2))
		{
			return 1;
		}

		return str1.compareTo(str2);
	}

	public static String convertToString(InputStream is) throws Exception
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
		StringBuilder sb = new StringBuilder();

		String line = null;
		try
		{
			while ((line = reader.readLine()) != null)
			{
				sb.append(line + "/n");
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				is.close();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}

		return sb.toString();
	}
}