package MacquireBank;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import org.json.*;

public class Problem4 {
	public static void main(String args[]) {
		String[] titles = getMovieTitles("spiderman");
		Stream.of(titles).forEach(System.out::println);
	}
	public static String[] getMovieTitles(String substr) {
		String urlData;
		int start = 1;
		int total = 1;
		List<String> titles = new ArrayList<>();
		while (start <= total) {
			try {
				URL hackerUrl = new URL(
						"https://jsonmock.hackerrank.com/api/movies/search/?Title=" + substr + "&page=" + start);
				HttpURLConnection con = (HttpURLConnection) hackerUrl.openConnection();
				con.setRequestMethod("GET");
				BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
				while ((urlData = in.readLine()) != null) {
					JSONObject convertedObject = new JSONObject(urlData);
					total = Integer.parseInt(convertedObject.get("total_pages").toString());
					JSONArray data = convertedObject.getJSONArray("data");
					for (int i = 0; i < data.length(); i++) {
						JSONObject jsonOb = (JSONObject) data.get(i);
						String title = jsonOb.get("Title").toString();
						titles.add(title);
					}
				}
				in.close();
				start++;
			} catch (Exception ex) {
				ex.printStackTrace();
			}

		}
		Collections.sort(titles);
		return titles.toArray(new String[0]);
	}
}