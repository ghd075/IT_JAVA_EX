package co.hong.sec02.exam05;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FromDirectoryMain {

	public static void main(String[] args) throws IOException {
		Path path = Paths.get("C:/Users/Danawa/git/IT_JAVA_EX");
		Stream<Path> stream = Files.list(path);
		stream.forEach( p -> System.out.println(p.getFileName()));
	}

}
