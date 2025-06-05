package OO2.Parcial_2022_SegundaFecha;

public class MinimaEnCelsiusDecorator extends Decorator{

	@Override
	public String displayData() {
		return super.displayData() + this.wrapper.toCelsius(this.temperaturaMinima());
	}

}
