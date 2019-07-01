package avaj.weatherprovider;

import avaj.simulation.aircrafts.Coordinates;

class WeatherProvider {
    private static WeatherProvider weatherProvider;

    private static String weather[] = {"SUN", "RAIN", "FOG", "SNOW"};

    private WeatherProvider(){

    }

    public static WeatherProvider getProvider(){
        if (weatherProvider == null){
            weatherProvider = new WeatherProvider();
        }
        return weatherProvider;
    }

    public static String getCurrentWeather(Coordinates coordinates){
        int weathervar = (coordinates.getLatitude() + 1) * (coordinates.getLongitude() + 1) * (coordinates.getHeight() + 1) % 4;
        
        return weather[weathervar];
    }
}