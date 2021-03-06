package com.interlan.test.problem;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.RecursiveTask;

public class FolderProcessor extends RecursiveTask<List<String>> {
	private static final long serialVersionUID = 1L;
	// This attribute will store the full path of the folder this task is going
	// to process.
	private final String path;
	// This attribute will store the name of the extension of the files this
	// task is going to look for.
	private final String searchKeyWord;

	// Implement the constructor of the class to initialize its attributes
	public FolderProcessor(String path, String searchKeyWord) {
		this.path = path;
		this.searchKeyWord = searchKeyWord;
	}

	// Implement the compute() method. As you parameterized the RecursiveTask
	// class with the List<String> type,
	// this method has to return an object of that type.
	@Override
	protected List<String> compute() {
		// List to store the names of the files stored in the folder.
		List<String> list = new ArrayList<String>();
		// FolderProcessor tasks to store the subtasks that are going to process
		// the subfolders stored in the folder
		List<FolderProcessor> tasks = new ArrayList<FolderProcessor>();
		// Get the content of the folder.
		File file = new File(path);
		File content[] = file.listFiles();
		// For each element in the folder, if there is a subfolder, create a new
		// FolderProcessor object
		// and execute it asynchronously using the fork() method.
		if (content != null) {
			for (int i = 0; i < content.length; i++) {
				if (content[i].isDirectory()) {
					FolderProcessor task = new FolderProcessor(content[i].getAbsolutePath(), searchKeyWord);
					task.fork();
					tasks.add(task);
				}
				// Otherwise, compare the extension of the file with the
				// extension you are looking for using the checkFile() method
				// and, if they are equal, store the full path of the file in
				// the list of strings declared earlier.
				else {
					String result = searchWord(new File(content[i].getAbsolutePath()), searchKeyWord);
					list.add(result);
				}
			}
		}
		// If the list of the FolderProcessor subtasks has more than 50
		// elements,
		// write a message to the console to indicate this circumstance.
		if (tasks.size() > 50) {
			System.out.printf("%s: %d tasks ran.\n", file.getAbsolutePath(), tasks.size());
		}
		// add to the list of files the results returned by the subtasks
		// launched by this task.
		addResultsFromTasks(list, tasks);
		// Return the list of strings
		return list;
	}

	// For each task stored in the list of tasks, call the join() method that
	// will wait for its finalization and then will return the result of the
	// task.
	// Add that result to the list of strings using the addAll() method.
	private void addResultsFromTasks(List<String> list, List<FolderProcessor> tasks) {
		for (FolderProcessor item : tasks) {
			list.addAll(item.join());
		}
	}

	public String searchWord(File file, String searchKeyWord) {
		String returnString = "";
		try (Scanner scanner = new Scanner(file)) {
			int lineNumber = 0;
			while (scanner.hasNextLine()) {
				lineNumber++;
				String line = scanner.nextLine();
				if (line.contains(searchKeyWord)) {
					returnString = "presentt at " + file.getAbsolutePath() + " at line number  " + lineNumber;
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return returnString;
	}
}