package various;

public class Base62Util {
	
	public static String generateBase62(int num) {
		String s = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvwxyz";
		String hash = "";
		
		while(num > 0) {
			hash = s.charAt(num % 62) + hash;
			num = num / 62;
		}
		System.out.println("num : " + num + ", base 62 hash is : " + hash);
		return hash;
	}

	public static void main(String[] args) {
		generateBase62(999);
		generateBase62(123976);
		generateBase62(23456345);
		generateBase62(5643567);
		generateBase62(89733329);
		generateBase62(1);
	}

}
