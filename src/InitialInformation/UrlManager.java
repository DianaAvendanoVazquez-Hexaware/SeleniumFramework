package InitialInformation;

public class UrlManager {
	public static String getUrl(String section) {
		String fileName = "C:\\Users\\iamCa\\Desktop\\NotPorn\\cursos\\Framework\\Framework_ex\\data\\urls.xlsx";
		String[] urls = ReadData.readData(fileName,section);
		String url = urls[0];
		return url;
	}
}
