package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.dao.connector.SQLConnection;

public class TaskerDAO {

	public static void CreateTask(String taskName, String goalTime, int priority) {

		Connection conn = null;
		PreparedStatement ps = null;
		String query = "INSERT INTO task (task_name, goal_time, priority, status)" + " VALUES (?,?,?,1)";
		try {
			conn = SQLConnection.getDBConnection();
			ps = conn.prepareStatement(query);

			ps.setString(1, taskName);
			ps.setString(2, goalTime);
			ps.setInt(3, priority);

			ps.executeUpdate();

			System.out.println("New task added !");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void getTasks() {

		Connection conn = null;
		String query = "SELECT task.id, task.task_name, task.goal_time, priority.priority_name, status.status_name FROM task" + " JOIN priority ON task.priority = priority.id JOIN status ON task.status = status.id;";
		try {
			conn = SQLConnection.getDBConnection();
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);
			while (rs.next()) {
				System.out.print("ID: " + rs.getInt("id") + "  |  ");
				System.out.print("Task name: " + rs.getString("task_name") + "  |  ");
				System.out.print("Goal time: " + rs.getString("goal_time") + "  |  ");
				System.out.print("Priority: " + rs.getString("priority_name") + "  |  ");
				System.out.print("Status: " + rs.getString("status_name") + "  |  ");
				System.out.println();
			}
			System.out.println("Done !");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void getTasksByStatus(String status) {

		Connection conn = null;
		String query = "SELECT task.id, task.task_name, task.goal_time, priority.priority_name, status.status_name FROM task" + " JOIN priority ON task.priority = priority.id JOIN status ON task.status = status.id" + " WHERE status.status_name = \""
				+ status + "\";";
		try {
			conn = SQLConnection.getDBConnection();
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);
			while (rs.next()) {
				System.out.print("ID: " + rs.getInt("id") + "  |  ");
				System.out.print("Task name: " + rs.getString("task_name") + "  |  ");
				System.out.print("Goal time: " + rs.getString("goal_time") + "  |  ");
				System.out.print("Priority: " + rs.getString("priority_name") + "  |  ");
				System.out.print("Status: " + rs.getString("status_name") + "  |  ");
				System.out.println();
			}
			System.out.println("Done !");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void UpdateStatus(int taskId, int status) {

		Connection conn = null;
		PreparedStatement ps = null;
		String query = "UPDATE task SET status = ? WHERE id = ?;";
		try {
			conn = SQLConnection.getDBConnection();
			ps = conn.prepareStatement(query);

			ps.setInt(1, status);
			ps.setInt(2, taskId);

			ps.executeUpdate();

			System.out.println("Task status updated !");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
