package Utils;

import java.io.IOException;

public class BrowserData {
		
		public static String getbrowserpath() throws IOException {
		String current = new java.io.File( "." ).getCanonicalPath();
		String Browserpath = current+"\\Browsers\\chromedriver.exe";
		return Browserpath;}

		public static String getScreenshotsPath() throws IOException {
		String current = new java.io.File( "." ).getCanonicalPath();
		String Srcpath = current+"\\test-output\\Screenshots";
		return Srcpath;
		}

				
}
