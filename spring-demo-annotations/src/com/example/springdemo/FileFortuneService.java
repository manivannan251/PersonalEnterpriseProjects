package com.example.springdemo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

@Component
public class FileFortuneService implements FortuneService {

	private String fileName = "C://Users//Mani//workspace//enterpriseprojects//spring-demo-annotations//src//fortune-data.txt";
	
	private List<String> fortunes;
	
	private Random myRandom = new Random();
	
	/*
	 * public FileFortuneService() { File file = new File(fileName); fortunes = new
	 * ArrayList<>(); System.out.println("Reading fortunes from file "+fileName);
	 * System.out.println("The file "+file.exists());
	 * 
	 * try(BufferedReader br = new BufferedReader(new FileReader(file))) {
	 * 
	 * String tempLine; while((tempLine=br.readLine())!=null) {
	 * fortunes.add(tempLine); }
	 * 
	 * } catch (IOException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); }
	 * 
	 * }
	 */
	
	@PostConstruct
	private void readFortuesFromFile() {
		File file = new File(fileName);
		fortunes = new ArrayList<>();
		System.out.println("Reading fortunes from file "+fileName);
		System.out.println("The file "+file.exists());
		
		try(BufferedReader br = new BufferedReader(new FileReader(file))) {
			
			String tempLine;
			while((tempLine=br.readLine())!=null) {
				fortunes.add(tempLine);
			}
			
		}  catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	@Override
	public String getFortune() {
		int index = myRandom.nextInt(fortunes.size());
		return fortunes.get(index);
		
	}

}
