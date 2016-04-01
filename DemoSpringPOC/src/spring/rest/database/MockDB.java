package spring.rest.database;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import spring.rest.model.User;
import spring.rest.model.Users;

import com.google.gson.Gson;

public class MockDB {

	String emailID;
	File file;
	Users users;
	String fileName = "./staticDB2.json";  //C:\opt\isv\tomcat-6.0\grid\bin
	FileWriter fileWriter;
	Gson gson = new Gson();

	public MockDB(String email) {
		this.emailID = email;
	}

	public void saveJson(String json) {
		try {
			users = null;
			file = new File(fileName);

			if (!file.exists()) {
				System.out.println("\nDB File Absolute Path: " + file.getAbsolutePath());
				file.createNewFile();
				users = new Users();
				User newUser = gson.fromJson(json, User.class);
				List<User> tempUsers = users.getUsers();
				tempUsers.add(newUser);
				users.setUsers(tempUsers);

				System.out.println("\nNew User Details:\n\t"
						+ gson.toJson(newUser));

				fileWriter = new FileWriter(file, true);

				System.out
						.println("\nNumber of users after have added the new user: "
								+ users.getUsers().size());

				String usersJSON = gson.toJson(users);
				System.out.print("\nJSON in DB:\n" + usersJSON);
				fileWriter.write(usersJSON);
				System.out.println("\n\nRecord Inserted Successfully\n");
							
			}else{
				users = getExistingUsers(file);
				if (checkIfExisting(file) == false) {				
					User newUser = gson.fromJson(json, User.class);
					System.out.println("\nNumber of users before adding a new user: "
							+ users.getUsers().size());
					List<User> tempUsers = users.getUsers();
					tempUsers.add(newUser);
					users.setUsers(tempUsers);

					System.out.println("\nNew User Details:\n\t"
							+ gson.toJson(newUser));

					fileWriter = new FileWriter(file, false);

					System.out
							.println("Number of users after have added the new user: "
									+ users.getUsers().size());

					String usersJSON = gson.toJson(users);
					System.out.print("JSON in DB:\n" + usersJSON);
					fileWriter.write(usersJSON);
				
				} else {
					System.out.println("\n\nUSER ALREADY THERE!!!\n");
				}
			}

			if(fileWriter!=null)
			fileWriter.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private Users getExistingUsers(File file) throws IOException {

		BufferedReader in = new BufferedReader(new FileReader(file.toString()));
		StringBuffer strBuffer = new StringBuffer();
		String str;
		while ((str = in.readLine()) != null) {
			strBuffer.append(str);
		}

		users = null;

		users = gson.fromJson(strBuffer.toString(), Users.class);
		/*System.out.println("Number of users in getExistingUsers(): "
				+ users.getUsers().size());*/
		in.close();

		return users;
	}

	private Boolean checkIfExisting(File file) throws IOException {

		users = getExistingUsers(file);
		User user = null;

		System.out.println("\nComparing for user pre-existance:\n");
		for (int i = 0; i < users.getUsers().size(); i++) {
			user = users.getUsers().get(i);
			String email = user.getEmail();

			System.out.println("EMAIL: " + email + "\t||\tEmailID: " + emailID);
			if (email.equals(emailID)) {
				return true;
			}
		}
		return false;
	}


}