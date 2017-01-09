import java.io.*;

class JavaIO {
	public static void main(String[] args) throws IOException{
		String c;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter characters and enter stop to exit");
		do{
			c = br.readLine();
			System.out.println(c);
		}while(!c.equals("stop"));
	}
}