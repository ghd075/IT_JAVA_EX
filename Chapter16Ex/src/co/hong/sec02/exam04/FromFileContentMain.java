package co.hong.sec02.exam04;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.stream.*;

public class FromFileContentMain {

	public static void main(String[] args) throws IOException {
		Path path = Paths.get("src/co/hong/sec02/exam04/linedata.txt");
		Stream<String> stream;
		
		//Files.lines 메소드 이용
		stream = Files.lines(path, Charset.defaultCharset());
		stream.forEach(System.out :: println);
		System.out.println();
		
		//BufferdReader의 lines() 메소드 이용
		File file = path.toFile();
		FileReader fileReader = new FileReader(file);
		BufferedReader br = new BufferedReader(fileReader);
		stream = br.lines();
		stream.forEach(System.out :: println);
	}

}
