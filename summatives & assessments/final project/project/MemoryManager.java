package project;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.management.RuntimeErrorException;

public class MemoryManager {

	private final File DATA_FILE = new File("data.expensememory");
	
	private Map<String, Double> expenses;
	
	public MemoryManager() {
		try {
			if(!DATA_FILE.exists()) {
				DATA_FILE.createNewFile();
				expenses = new HashMap<>();
			} else loadFromFile();
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}
	
	public void addExpense(String name, double expense) {
		expenses.put(name, expense);
	}
	
	public void removeExpense(String name) {
		if(expenses.containsKey(name)) expenses.remove(name);
		else throw new RuntimeException("That expense doesn't exist. What happened?");
	}
	
	public Map<String, Double> getExpenses() {
		return Collections.unmodifiableMap(expenses);
	}
	
	public boolean isExpense(String name) {
		return expenses.containsKey(name);
	}
	
	public void reset() {
		expenses.clear();
		saveToFile();
	}
	
	public void saveToFile() {
		try {
			final FileOutputStream outputStream = new FileOutputStream(DATA_FILE);
			final ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
			objectOutputStream.writeObject(expenses);
			objectOutputStream.close();
			outputStream.close();
		} catch (IOException ex) {
			throw new RuntimeException(ex);
		}
	}
	
	public void loadFromFile() {
		try {
			if(DATA_FILE.exists()) {
				final FileInputStream inputStream = new FileInputStream(DATA_FILE);
				final ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
				expenses = (HashMap<String, Double>) objectInputStream.readObject();
				objectInputStream.close();
				inputStream.close();
			} else {
				DATA_FILE.createNewFile();
				expenses = new HashMap<>();
			}
		} catch (IOException | ClassNotFoundException ex) {
			throw new RuntimeException(ex);
		}
	}
	
}
