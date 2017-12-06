import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.out;

public class FriendTest {
	
	public static void main(String[] args) {
		final List<Friend> friends = new ArrayList<>();
		friends.add(new Friend("Jackson", "2227778888", new Date(System.currentTimeMillis()), "jackson@wesjd.net"));
		friends.add(new Friend("Sean", "2227778889", new Date(System.currentTimeMillis()), "sean@wesjd.net"));
		friends.add(new Friend("Alex", "2227777888", new Date(System.currentTimeMillis()), "alex@wesjd.net"));
		friends.add(new Friend("Peter", "2227878888", new Date(System.currentTimeMillis()), "peter@wesjd.net"));
		friends.add(new Friend("Nik", "3227778888", new Date(System.currentTimeMillis()), "nik@wesjd.net"));
		
		final Scanner scanner = new Scanner(System.in);
		out.println("Type QUIT to quit.");
		while(true) {
			out.print("Friend search > ");
			String input = scanner.nextLine();
			if(input.equalsIgnoreCase("quit")) break;
			else {
				final Friend match = friends.stream()
						                 .filter(friend -> friend.getName().equalsIgnoreCase(input))
						                 .findFirst().orElse(null);
				if(match != null) out.println(match);
				else out.println("No match found.");
			}
		}
		out.println("Goodbye.");
		scanner.close();
	}

}
