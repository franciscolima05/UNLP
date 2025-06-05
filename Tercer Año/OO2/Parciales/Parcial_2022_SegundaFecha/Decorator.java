package OO2.Parcial_2022_SegundaFecha;

import java.util.List;

public abstract class Decorator implements IHomeWeatherExtension{
	protected IHomeWeatherExtension wrapper;
	

	public double temperaturaMinima() {
		return this.wrapper.temperaturaMinima();
	}

	public double temperaturaMaxima() {
		return this.wrapper.temperaturaMaxima();
	}

	public double temperaturaPromedio() {
		return this.wrapper.temperaturaPromedio();
	}
	
	public String displayData() {
		return this.wrapper.displayData();
	}

	@Override
	public double getTemperatura() {
		return this.wrapper.getTemperatura();
	}

	@Override
	public double getPresion() {
		return this.wrapper.getPresion();
	}

	@Override
	public double getRadiacionSolar() {
		return this.wrapper.getRadiacionSolar();
	}

	@Override
	public List<Double> getTemperaturas() {
		return this.wrapper.getTemperaturas();
	}
	
	@Override
	public double toCelsius(double num) {
		return this.wrapper.toCelsius(num);
	}

}
