package com.interlan.test.problem;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

public class WordSearchMultiThreading {

	public static final File DUMMY_FILE = new  File("");
	public static volatile AtomicBoolean DONE = new AtomicBoolean(false);
	public static BlockingQueue<File> fileQueue = new ArrayBlockingQueue<File>(3);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//D:\JP\temp
		new Thread(new FileEnumerationTask("D:\\JP\\temp\\filetesting", fileQueue)).start();
		
		for(int i=0; i<20; i++){
			new Thread(new WordSearchTask("bbc", fileQueue), "SearchThread-"+i).start();
		}
	}
}

class FileEnumerationTask implements Runnable{
	
	private String  fileSrcPath;
	private BlockingQueue<File> fileQueue;
	
	public FileEnumerationTask(String fileSrcPath, BlockingQueue<File> fileQueue) {
		// TODO Auto-generated constructor stub
		this.fileSrcPath = fileSrcPath;
		this.fileQueue = fileQueue;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			enumerate(new File(fileSrcPath));
			fileQueue.put(WordSearchMultiThreading.DUMMY_FILE);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void enumerate(File files){
		try {
			File[] file = files.listFiles();
			for (File file2 : file) {
				if(file2.isFile()){
					fileQueue.put(file2);
				}
				else{
					enumerate(file2.getAbsoluteFile());
				}
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class WordSearchTask implements Runnable{
	
	private String searchKeyWord;
	private BlockingQueue<File> fileQueue;
	
	public WordSearchTask(String searchKeyWord, BlockingQueue<File> fileQueue) {
		// TODO Auto-generated constructor stub
		this.searchKeyWord = searchKeyWord;
		this.fileQueue = fileQueue;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(!WordSearchMultiThreading.DONE.get()){
			File file = null;
			try {
				file = fileQueue.take();
				if(file == WordSearchMultiThreading.DUMMY_FILE)
					WordSearchMultiThreading.DONE.compareAndSet(false, true);
				else
					searchWord(file, searchKeyWord);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void searchWord(File file, String searchKeyWord){
		try(Scanner scanner = new Scanner(file)) {
			int lineNumber = 0;
			while(scanner.hasNextLine()){
				lineNumber++;
				String line = scanner.nextLine();
				if(line.contains(searchKeyWord)){
					System.out.println("presentt at "+file.getAbsolutePath()+" at line number  "+lineNumber);
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
