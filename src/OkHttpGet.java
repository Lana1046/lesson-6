import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkHttpGet {

    private String urlCountry = "http://dataservice.accuweather.com/locations/v1/cities/RU/search";

    private String urlWeather = "http://dataservice.accuweather.com/forecasts/v1/daily/5day/294021";

    private String apiKey = "0JlWB2TbvhDA2mllphiRW1Gii8UX2VdG";
    private OkHttpClient client = new OkHttpClient();


    public void setCountry(String countryId) {
        urlCountry = "http://dataservice.accuweather.com/locations/v1/cities/" + countryId + "/search";
    }

    public void setCity(String cityId) {
        urlWeather = "http://dataservice.accuweather.com/forecasts/v1/daily/5day/" + cityId;
    }

    public String getCity(String cityName) {

        HttpUrl.Builder urlBuilder = HttpUrl.parse(urlCountry).newBuilder();
        urlBuilder.addQueryParameter("apikey", apiKey)
                .addQueryParameter("q", cityName)
                .addQueryParameter("language", "en")
                .addQueryParameter("details", "false")
                .addQueryParameter("offset", "25")
                .addQueryParameter("alias", "NoOfficialMatchFound")
                .build();
        Request request = new Request.Builder()
                .url(urlBuilder.toString())
                .get()
                .build();

        return call(request);
    }

    public String getWeather() {

        HttpUrl.Builder urlBuilder = HttpUrl.parse(urlWeather).newBuilder();
        urlBuilder.addQueryParameter("apikey", apiKey)
                .addQueryParameter("language", "en")
                .addQueryParameter("details", "false")
                .addQueryParameter("metric", "false")
                .build();

        Request request = new Request.Builder()
                .url(urlBuilder.toString())
                .get()
                .build();

        return call(request);
    }

    private String call(Request request) {
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        } catch (Exception e) {
            e.printStackTrace();
            return "Not found";
        }
    }
}
