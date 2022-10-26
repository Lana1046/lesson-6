public class Main {

    public static void main(String[] args) {
        OkHttpGet okHttpGet = new OkHttpGet();
        System.out.println(okHttpGet.getCity("Moscow"));
        System.out.println(okHttpGet.getWeather());

    }
}
