package test;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileIOTest {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		String root = "D:\\\\Users\\\\yinzixian\\\\Desktop\\\\";
		String file = root + sc.next();
		String name = sc.next();
		System.out.println(file);
		System.out.println(name);
		OutputFile.write(file, InputFile.read(file), name);
	}
}

class InputFile {
	public static Set<String> read(String filename) throws IOException{
		Set<String> set = new HashSet<>();
		BufferedReader in = new BufferedReader(new FileReader(filename));
		String s;
		while((s = in.readLine()) != null)
			set.add(s);
		in.close();
		return set;
	}
}
class OutputFile {
	public static void write(String filename,Set<String> set, String name) throws IOException{
		String reg = "([^<>/\\\\|:\"\"\\*\\?]+(\\.\\w+))$+";
		System.out.println("begin...");
		Pattern p = Pattern.compile(reg);
		Matcher m = p.matcher(filename);
		if(m.find()) 
			filename = filename.replace(m.group(1), name + m.group(2));		
		PrintWriter out = new PrintWriter(
							new BufferedWriter(new FileWriter(filename)));
		List<String> list = new ArrayList<String>(set);
		for(String s : list) {
			if(s.contains(name))
				out.println(s);
		}
		out.close();
		System.out.println("Done...");
	}
}