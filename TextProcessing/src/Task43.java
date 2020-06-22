import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
public class Task43 
{
	public static void main(String[] args) throws IOException
	{

		File input = new File("W3C Web Pages");
		String[] htmlFiles = input.list();
		for (int i = 0; i < htmlFiles.length; i++)
		{

			htmlToText(htmlFiles[i]);

		}
		System.out.println("The Conversion is completed - it returns without any error");
	}

	private static void htmlToText(String fileName) throws IOException
	{

		File f = new File("W3C Web Pages\\" + fileName);
		Document document = Jsoup.parse(f, "UTF-8");
		String text = document.text();
		PrintWriter out = new PrintWriter("Text\\" + fileName.replaceAll(".html", ".txt"));
		out.println(text);
		out.close();

	}
}
