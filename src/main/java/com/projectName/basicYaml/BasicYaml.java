package com.projectName.basicYaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilterInputStream;
import java.util.Map;
import org.yaml.snakeyaml.*;

public class BasicYaml {

	
	public static void main(String[] args) throws FileNotFoundException{
		stringToMap();
		multipleStringsToMap();
		yamlFileToMap();
	}
	
	public static void yamlFileToMap() throws FileNotFoundException {
		Yaml yaml = new Yaml();
		//String path = "C:\\Users\\jalopez5\\eclipse-workspace\\SimpleAutomationTests\\src\\main\\java\\com\\projectName\\basicYaml\\basic.yaml";
		String path = ".\\src\\main\\java\\com\\projectName\\basicYaml\\basic.yaml";
		FileInputStream inputStream = new FileInputStream(new File(path));
		
		Map<String, String> map = yaml.load(inputStream);
		System.out.println(map);
		System.out.println(map.get("name"));
		System.out.println(map.entrySet());
	}
	
	
	public static void stringToMap() {
		// 1. Yaml String to java map
		Yaml yaml = new Yaml();

		String str = "Hello : 25";
		Map<String, Integer> map = yaml.load(str);

		Integer value = map.get("Hello");

		System.out.println(value);
	}
	
	public static void multipleStringsToMap() {
		Yaml yaml = new Yaml();
		
		//Read strings as Object
		String str = "name: Joe\n" + "phone: 111111\n" + "address: Park avenue\n";
		Object obj = yaml.load(str);
		
		
		//Convert object into map
		@SuppressWarnings("unchecked")
		Map<String, String> map = (Map<String, String>) obj;
		System.out.println("Name: " + map.get("name"));
		System.out.println(map);
	}
}
