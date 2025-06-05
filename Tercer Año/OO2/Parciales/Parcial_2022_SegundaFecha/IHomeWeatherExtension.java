package OO2.Parcial_2022_SegundaFecha;

public interface IHomeWeatherExtension extends WeatherData{

	double temperaturaMinima();
	double temperaturaMaxima();
	double temperaturaPromedio();
	String displayData();
	double toCelsius(double num);
}
