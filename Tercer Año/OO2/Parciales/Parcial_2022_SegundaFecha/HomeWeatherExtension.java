package OO2.Parcial_2022_SegundaFecha;

public class HomeWeatherExtension extends HomeWeatherStation implements IHomeWeatherExtension{

	public double temperaturaMinima() {
		return this.getTemperaturas().stream()
				.min((t1, t2) -> Double.compare(t1, t2))
				.orElse(0.0);
	}
	
	public double temperaturaMaxima() {
		return this.getTemperaturas().stream()
				.max((t1, t2) -> Double.compare(t1, t2))
				.orElse(0.0);
	}
	
	public double temperaturaPromedio() {
		return this.getTemperaturas().stream()
				.mapToDouble(t1 -> t1)
				.average()
				.orElse(0.0);
	}
	
	public double toCelsius(double num) {
		return Math.round(((num - 32) + 1.8) * 10.0) / 10.0;
	}

	
}
