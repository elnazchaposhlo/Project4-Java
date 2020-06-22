import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.lang.model.util.Elements;

public class Task45
{
public static void main(String[] args) throws IOException {
		
		File input = new File("D:\\Java\\eclips-workplace\\Languages\\W3C Web Pages");
		File[] files = input.listFiles();
		
		String pattern1 = "(http)[s]?://?[A-Za-z0-9-.]+(w3.org)(/[\\w/_-]+)*";
		String pattern2 = "(http)[s]?://?[A-Za-z0-9-.]+[A-Za-z]{2,4}+/[\\w/_-]+/";
		String pattern3 = "(http)[s]?://?[A-Za-z0-9-.]+[A-Za-z]{2,4}+/[\\w/_-]+/#\\w+";
		String pattern4 = "(http)[s]?://?[A-Za-z0-9-.]+(net|com|org)";

		System.out.println("Links with domain w3.org\n");
		findPattern(files, pattern1);
		
		System.out.println("\nLinks that contain folders\n");
		findPattern(files, pattern2);
		
		System.out.println("\nLinks that contain references in a Web page and may contain folders\n");
		findPattern(files, pattern3);
		
		System.out.println("\nLinks with domain .net, .com or .org\n");
		findPattern(files, pattern4);
		
	}

	public static void findPattern(File[] files, String pattern) throws IOException {

		Pattern p = Pattern.compile(pattern);
		Matcher m;
		Elements l;
		for (File f : files) {
			Document doc = Jsoup.parse(f, "UTF-8");
			l = doc.select("a");
			String links;
			for (Element link : l) {
				links = link.attr("href");
				m = p.matcher(links);
				if (m.find()) {
					System.out.println("Found Value: " + m.group());
				}
			}

		}

	}

}
