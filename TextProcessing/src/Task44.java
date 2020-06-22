import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Task44
{
	public static void main(String args[]) throws IOException {

		String phonenumberPattern = "(\\()?(\\d){3}(\\))?[- ](\\d){3}-(\\d){4}";
		String emailPattern = "[A-Za-z0-9._%-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}";

		File input = new File("D:\\Java\\eclips-workplace\\Languages\\Text");
		File[] files = input.listFiles();
		
		System.out.println("\nPhone Numbers : \n");
		findPattern(files, phonenumberPattern);
		System.out.println("\nEmail : \n");
		findPattern(files, emailPattern);

	}

	public static void findPattern(File[] files, String pattern) throws IOException {

		Pattern p = Pattern.compile(pattern);
		Matcher m;
		for (File f : files) {

			Document doc = Jsoup.parse(f, "UTF-8");
			String text = doc.text();
			m = p.matcher(text);
			while (m.find()) {
				System.out.println("Found Value: " + m.group());
			}
		}

	}	
}
