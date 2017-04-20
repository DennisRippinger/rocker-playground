package de.drippinger;

public class Playground {

	public static void main(String... args) {
		User user = new User();
		user.setName("Dennis");

		System.out.println(views.main.template("Mytitle", user).render().toString());

	}
}
