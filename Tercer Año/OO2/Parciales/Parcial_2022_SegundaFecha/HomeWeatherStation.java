package OO2.Parcial_2022_SegundaFecha;

import java.util.List;

public class HomeWeatherStation implements WeatherData{
	private double presion;
	private double radiacion;
	private List<Double> temperaturas;

	@Override
	public double getTemperatura() {
		return this.temperaturas.get(this.temperaturas.size() - 1);
	}

	@Override
	public double getPresion() {
		return this.presion;
	}

	@Override
	public double getRadiacionSolar() {
		return this.radiacion:
	}

	@Override
	public List<Double> getTemperaturas() {
		return this.temperaturas;
	}

	@Override
	public String displayData() {
		return "";
	}

	
}
