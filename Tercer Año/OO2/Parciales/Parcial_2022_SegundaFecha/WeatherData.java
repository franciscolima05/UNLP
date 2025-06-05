package OO2.Parcial_2022_SegundaFecha;
import java.util.List;

public interface WeatherData {

	double getTemperatura();
	double getPresion();
	double getRadiacionSolar();
	List<Double> getTemperaturas();
	String displayData();
}
