package com.quizcampen.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class HTMLReader {

//	public static final String LOGIN_PAGE = readFile("login.html");
	public static final String START_PAGE = readFile("start.html");
	public static final String EVENT_PAGE= readFile("events.html");
	public static final String EVENTUPDATE_PAGE= readFile("updateEvent.html");
	public static final String HISTORIC_PAGE= readFile("historic.html");
	public static final String TODAYEVENT_PAGE= readFile("todayevent.html");
	public static final String FUTUREEVENTS_PAGE= readFile("futureevents.html");
	
	

	public String getFromTo(String from, String to, String html) {
		if (html == null) {
			return null;
		}
		int start = html.indexOf(from);
		if (start < 0) {
			return null;
		}
		int stop = to != null ? html.indexOf(to, start + from.length()) : -1;
		if (stop < 0) {
			return html.substring(start);
		}
		return html.substring(start, stop);
	}

	public String getFromToContent(String from, String to, String html) {
		if (html == null) {
			return null;
		}
		int start = html.indexOf(from);
		if (start < 0) {
			return null;
		}
		start += from.length();
		int stop = to != null ? html.indexOf(to, start) : -1;
		if (stop < 0) {
			return html.substring(start);
		}
		return html.substring(start, stop);
	}

	public Object[] getFromToPos(String from, String to, String html) {
		if (html == null) {
			return null;
		}
		int start = html.indexOf(from);
		if (start < 0) {
			return null;
		}
		int stop = to != null ? html.indexOf(to, start + from.length()) : -1;
		String content = null;
		if (stop < 0) {
			content = html.substring(start);
		}
		content = html.substring(start, stop + to.length());
		return new Object[] { content, Integer.valueOf(start), Integer.valueOf(stop) };
	}

	public String readHTML(String urlStr) throws IOException {
		StringBuffer buffer = new StringBuffer();
		URL url = null;
		try {
			url = new URL(urlStr);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		try {
			URLConnection con = url.openConnection();
			con.setRequestProperty("Accept-Language", "en-US,en;q=0.8,sv;q=0.6");
			con.setRequestProperty("User-Agent",
					"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.95 Safari/537.36");

			con.setReadTimeout(100000);
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF8"));
			String inputLine;
			while ((inputLine = in.readLine()) != null) {
				buffer.append(inputLine + "\n");
			}
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return buffer.toString();
	}

	public String getTagContent(String tag, String html) {
		int index = html.indexOf("<" + tag);
		if (index < 0) {
			return "";
		}

		index = html.indexOf(">", index + 1);
		int stop = html.indexOf("</" + tag + ">");
		String tmp = html.substring(index + 1, stop);
		tmp = tmp.replace("&nbsp", "");
		return tmp;
	}

	public String getTagContentWithTag(String tag, String html) {
		int index = html.indexOf("<" + tag);
		if (index < 0) {
			return null;
		}

		int stop = html.indexOf("</" + tag + ">");
		return html.substring(index, stop) + "</" + tag + ">";
	}

	public String cropFromLast(String string, String html) {
		int index = html.lastIndexOf(string);
		if (index < 0) {
			return html;
		}
		return html.substring(index + 1);
	}

	public String removeTag(String tag, String html) {
		int index = html.indexOf("<" + tag);

		if (index < 0) {
			html = html.replaceAll("</" + tag + ">", "");

			return html;
		}
		int stop = html.indexOf(">", index);
		String tagStart = html.substring(index, stop + 1);
		String tmp = html.substring(0, index) + html.substring(stop + 1);

		return removeTag(tag, tmp);
	}

	public String cropTo(String string, String html) {
		int index = html.indexOf(string);
		if (index < 0) {
			return html;
		}
		return html.substring(0, index);
	}

	public String getTDContent(String html) {
		String tmp = html;
		tmp = removeTag("span", tmp);
		tmp = removeTag("a", tmp);
		tmp = tmp.replaceAll("&nbsp;", "");
		tmp = cropTo("</td>", tmp);
		tmp = cropFromLast(">", tmp);
		return tmp;
	}

	public List<String> getTags(String tag, String html) {
		String tmp = new String(html);
		List<String> list = new ArrayList();
		String tagContent = getTagContentWithTag(tag, tmp);
		if (tagContent == null) {
			return list;
		}
		if (tagContent != null) {
			list.add(tagContent);
			tmp = tmp.replace(tagContent, "");
			list.addAll(getTags(tag, tmp));
		}
		return list;
	}

	public static String removeSpecialChars(String playerStr) {
		String result = new String(playerStr);
		result = result.replace("Ã¶", "o");
		result = result.replace("Ã–", "O");
		result = result.replace("Ã˜", "O");
		result = result.replace("Ã¸", "o");

		result = result.replace("Ã¡", "a");
		result = result.replace("Ã�", "A");

		result = result.replace("Ã ", "a");
		result = result.replace("Ã€", "A");

		result = result.replace("Ã¥", "a");
		result = result.replace("Ã…", "A");

		result = result.replace("Ã¤", "a");
		result = result.replace("Ã„", "A");

		result = result.replace("Ã©", "e");
		result = result.replace("Ã‰", "E");

		result = result.replace("Ã¨", "e");
		result = result.replace("Ãˆ", "E");

		result = result.replace("Ã‘", "N");
		return result;
	}

	public static String fromHtml(String text) {
		if (text == null) {
			return "";
		}

		String result = text.replaceAll("<[^>]+>", "");
		result = result.replaceAll("\n", "");
		result = result.replaceAll("\r", "");
		result = result.replaceAll("&nbsp;", " ");
		result = result.replaceAll("&Ouml;", "Ã–");
		result = result.replaceAll("&ouml;", "Ã¶");
		result = result.replaceAll("&amp;", "&");

		result = result.replaceAll("&euml;", "Ã«");
		result = result.replaceAll("&eacute;", "Ã©");
		result = result.replaceAll("&egrave;", "Ã¨");
		result = result.replaceAll("&uuml;", "Ã¼");
		result = result.replaceAll("&oslash;", "Ã¸");
		result = result.replaceAll("&ccedil;", "Ã§");
		result = result.replaceAll("&aelig;", "Ã¦");
		result = result.replaceAll("&aring;", "Ã¥");
		result = result.replaceAll("&auml;", "Ã¤");
		result = result.replaceAll("&ouml;", "Ã¶");
		result = result.replaceAll("&acirc;", "Ã¢");
		result = result.replaceAll("&aacute;", "Ã¡");
		result = result.replaceAll("&agrave;", "Ã ");
		result = result.replaceAll("&szlig;", "ÃŸ");

		result = result.replaceAll("&Euml;", "Ã‹");
		result = result.replaceAll("&Eacute;", "Ã‰");
		result = result.replaceAll("&Egrave;", "Ãˆ");
		result = result.replaceAll("&Uuml;", "Ãœ");
		result = result.replaceAll("&Oslash;", "Ã˜");
		result = result.replaceAll("&Ccedil;", "Ã‡");
		result = result.replaceAll("&AElig;", "Ã†");
		result = result.replaceAll("&Aring;", "Ã…");
		result = result.replaceAll("&Auml;", "Ã„");
		result = result.replaceAll("&Ouml;", "Ã–");
		result = result.replaceAll("&Acirc;", "Ã‚");
		result = result.replaceAll("&Aacute;", "Ã�");
		result = result.replaceAll("&Agrave;", "Ã€");

		result = result.trim();
		return result;
	}

	public static String readFile(String string) {
		URL url = new HTMLReader().getClass().getClassLoader().getResource(string);
		try {
			if (url != null) {
				return getStringFromInputStream(url.openStream());
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		return null;
	}

	public static String getStringFromInputStream(InputStream is) {
		BufferedReader br = null;
		StringBuilder sb = new StringBuilder();

		try {
			br = new BufferedReader(new InputStreamReader(is, "UTF8"));
			String line;
			while ((line = br.readLine()) != null) {
				sb.append(line + "\n");
			}

			return sb.toString();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return null;
	}

	public static Class[] getClasses(String packageName) throws ClassNotFoundException, IOException {
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		assert (classLoader != null);
		String path = packageName.replace('.', '/');
		Enumeration<URL> resources = classLoader.getResources(path);
		List<File> dirs = new ArrayList();
		while (resources.hasMoreElements()) {
			URL resource = (URL) resources.nextElement();

			dirs.add(new File(resource.getFile()));
		}
		ArrayList<Class> classes = new ArrayList();
		for (File directory : dirs) {
			classes.addAll(findClasses(directory, packageName));
		}
		return (Class[]) classes.toArray(new Class[classes.size()]);
	}

	public static List<Class> findClasses(File directory, String packageName) throws ClassNotFoundException {
		List<Class> classes = new ArrayList();
		if (!directory.exists()) {
			return classes;
		}
		File[] files = directory.listFiles();
		for (File file : files) {
			if (file.isDirectory()) {
				assert (!file.getName().contains("."));
				classes.addAll(findClasses(file, packageName + "." + file.getName()));
			} else if (file.getName().endsWith(".class")) {
				classes.add(Class.forName(packageName + '.' + file

						.getName().substring(0, file.getName().length() - 6)));
			}
		}
		return classes;
	}
}

/*
 * Location:
 * /Users/danielsvenson/Downloads/temp/OddsServiceRest20170714.war!/WEB-INF/
 * classes/com/danester/utils/HTMLReader.class Java compiler version: 8 (52.0)
 * JD-Core Version: 0.7.1
 */