package com.abdullah.bank;

import java.sql.*;
import java.sql.ResultSet;
import java.util.Scanner;

public class DbConnection {
	public static void main(String args[]) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/bank";
		String username = "root";
		String password = "root"; // Change it to your Password
		String readQuery = "select name from bank.checking where Age=23";
		Connection con = DriverManager.getConnection(url, username, password);

		Statement stmt = con.createStatement();
		ResultSet rs;
		PreparedStatement st;
		String qry = "";
		int Age, mobNum, choice, id;
		String name, Address;
		;

		Scanner in = new Scanner(System.in);

		while (true) {
			//System.out.println(" ");
			System.out.println("JDBC OPERATION:");
			System.out.println("1.insert");
			System.out.println("2.update");
			System.out.println("3.delete");
			System.out.println("4.select");
			System.out.println("5.EXIT");
			System.out.println("Enter the choice: ");
			choice = in.nextInt();
			System.out.println("________________________________________________");
			switch (choice) {
			case 1:
				System.out.println("1.Insert new Data.");
				System.out.println("Enter name: ");
				name = in.nextLine();
				System.out.println("Enter age: ");
				Age = in.nextInt();
				System.out.println("Enter mobNum: ");
				mobNum = in.nextInt();
				System.out.println("Enter Address: ");
				Address = in.nextLine();
				in.nextLine();
				qry = "insert into checking(name,Age,mobnum,Address) values(?,?,?,?)";
				st = con.prepareStatement(qry);
				st.setString(1, name);
				st.setInt(2, Age);
				st.setInt(3, mobNum);
				st.setString(4, Address);
				st.executeUpdate();
				System.out.println("Data Insert Suceesfully.....");
				st.close();

				break;

			case 2:
				System.out.println("2.Update new Data.");
				// System.out.println("Enter ID: ");
				// id=in.nextInt();
				System.out.println("Enter name: ");
				name = in.nextLine();
				System.out.println("Enter age: ");
				Age = in.nextInt();
				System.out.println("Enter mobNum: ");
				mobNum = in.nextInt();
				System.out.println("Enter Address: ");
				Address = in.nextLine();
				qry = "Update checking set name=?,Age=?,mobnum=? where Address=?";
				st = con.prepareStatement(qry);
				st.setString(1, name);
				st.setInt(2, Age);
				st.setInt(3, mobNum);
				st.setString(4, Address);
				st.executeUpdate();
				System.out.println("Data Update Success.");
				st.close();

				break;

			case 3:
				System.out.println("3.Delete a Data.");
				System.out.println("Enter the Age:");
				Age = in.nextInt();
				qry = "delete from checking where Age=?";
				st = con.prepareStatement(qry);
				st.setInt(1, Age);
				st.executeUpdate();
				System.out.println("Data deleted Successfully.");
				st.close();

				break;

			case 4:
				System.out.println("4.print all Data.");
				qry = "select * from checking";
				rs = stmt.executeQuery(qry);
				while (rs.next()) {
					name = rs.getString("Name");
					Age = rs.getInt("AGE");
					mobNum = rs.getInt("mobNum");
					Address = rs.getString("Address");
					System.out.print(name + " ");
					System.out.print(Age + " ");
					System.out.print(mobNum + " ");
					System.out.println(Address + " ");
				}

				break;

			case 5:
				System.out.println("5.Exit.");
				break;

			default:
				System.out.println("Enter valid choice>>>>>>>>>");
				break;

			}
		}

	}

}
