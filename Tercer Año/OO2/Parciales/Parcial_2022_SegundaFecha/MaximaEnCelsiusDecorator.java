package OO2.Parcial_2022_SegundaFecha;

public class MaximaEnCelsiusDecorator extends Decorator{

	@Override
	public String displayData() {
		return super.displayData() + this.wrapper.toCelsius(this.temperaturaMaxima());
	}

}
