package MacquireBank;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
	String[] getMovieTitles(String substr) {
		String urlData;
		int start = 1;
		int total = 1000;
		List<String> titles = new ArrayList<>();
		while (start <= total) {
			try {
				URL obj = new URL(
						"https://jsonmock.hackerrank.com/api/movies/search/?Title=" + substr + "&page=" + start);
				HttpURLConnection con = (HttpURLConnection) obj.openConnection();
				con.setRequestMethod("GET");
				BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
				while ((urlData = in.readLine()) != null) {
					JsonObject retrievedDataObj = new Gson().fromJson(urlData, JsonObject.class);
					total = retrievedDataObj.get("total_pages").getAsInt();
					JsonArray dataArray = retrievedDataObj.getAsJsonArray("data");
					for (int i = 0; i < dataArray.size(); i++) {
						String movieTitle = dataArray.get(i).getAsJsonObject().get("Title").getAsString();
						titles.add(movieTitle);
					}
				}
				in.close();
				start++;
			} catch (Exception ex) {
				ex.printStackTrace();
			}

		}
		Collections.sort(titles);
		String[] movieTitles = titles.toArray(new String[0]);
		return movieTitles;
	}
}