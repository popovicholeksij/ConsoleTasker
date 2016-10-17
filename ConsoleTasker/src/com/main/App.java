package com.main;

import java.util.Scanner;

import com.dao.TaskerDAO;
import com.menu.Menu;
import com.menu.MenuEntry;

public class App {
	
	@SuppressWarnings("resource")
    public static void main(String[] args) {
		
        Menu menu = new Menu();
        menu.addEntry(new MenuEntry("Add Task") {
            @Override
            public void run() {
            	Scanner sc = new Scanner(System.in);
            	
            	System.out.println("Please input: Task name");
    			String taskName = sc.nextLine();
    			
    			System.out.println("Please input: Goal Time (YYYY-MM-dd)");
    			String goalTime = sc.nextLine();
    			
    			System.out.println("Please input: Priority (1-Low...4-Immediately)");
    			int priority = Integer.parseInt(sc.nextLine()); 
            	TaskerDAO.CreateTask(taskName, goalTime, priority);
            }
        });
        
        menu.addEntry(new MenuEntry("Get Tasks") {
            @Override
            public void run() {
                TaskerDAO.getTasks();
                
            }
        });
        
        menu.addEntry(new MenuEntry("Filter tasks by status") {
			@Override
    		public void run() {
    			System.out.println("Please enter the status (New, In progress, Done or Expired)");
    			Scanner sc = new Scanner(System.in);
    			String status = sc.nextLine();
    			TaskerDAO.getTasksByStatus(status);
    		}
    	});
        
        menu.addEntry(new MenuEntry("Change task status") {
    		@Override
    		public void run() {
    			Scanner sc = new Scanner(System.in);
            	
            	System.out.println("Please input: Task id");
            	int taskId = Integer.parseInt(sc.nextLine());
    			
    			System.out.println("Please input: status (New - 1, In progress - 2, Done - 3, Expired - 4)");
    			int status = Integer.parseInt(sc.nextLine());
    			
            	TaskerDAO.UpdateStatus(taskId, status);
    		}
    	});
        
        menu.run();
    }
}
