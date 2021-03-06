package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Stream;

import org.apache.commons.io.IOUtils;


public class ReadFile {
	
	private BufferedReader br = null;
	
	//Return List<String> of the input
	public List<String> readFile(String path){
		List<String> input = new ArrayList<>();
		   try {

				br = new BufferedReader(new FileReader(path));

				String line;
				while ((line = br.readLine()) != null) {
					input.add(line);
				}

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
		return input;
	}
	
	//Parse just list of strings
	public static String getString(String path) {
        try {
            Scanner scanner = new Scanner(new File(path));

            StringBuilder input = new StringBuilder();
            while(scanner.hasNext())
                input.append(scanner.nextLine()).append("\n");

            scanner.close();
            return input.substring(0, input.length() - 1);
        }catch(Exception e) { throw new IllegalArgumentException(e); }
    }
	
	 public static <T> Stream<T> inputLines(
	            String input,
	            Function<? super String, ? extends T> mappingFunction) {
	        return new BufferedReader(new StringReader(input)).lines().map(mappingFunction);
	    }
	
	 public static String getInput(String file) throws IOException {
	        InputStream stream = InputStreamReader.class.getResourceAsStream(file);
	        return stream != null
	                ? IOUtils.toString(ReadFile.class.getResourceAsStream(file),"UTF-8")
	                : null;
	    }
//	//Returns String[] of input **REVISE FOR DAY 2????***
//	public static String[] getStream(String path) {
//		
//		try (Stream<String> stream = Files.lines(Paths.get(path))){
//			String[] input = stream.toArray(String[]::new);
//			return input;
//		} catch(Exception e) { throw new IllegalArgumentException(e); }
//	}
}
